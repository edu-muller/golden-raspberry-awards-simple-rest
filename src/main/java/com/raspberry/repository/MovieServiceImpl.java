package com.raspberry.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.raspberry.dto.AwardIntervalDTO;
import com.raspberry.dto.ProducerAwardDTO;
import com.raspberry.model.Movie;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveAll(List<Movie> movies) {
		repository.saveAll(movies);
	}
	
	@Override
	public AwardIntervalDTO findAwardInterval() {
		List<Movie> movies = this.repository.findByWinnerTrue();
		Map<String, List<Movie>> mapMoviesProducer = new HashMap<>();
		movies.forEach(m -> m.getProducers().forEach(p -> mapMoviesProducer.computeIfAbsent(p, i -> new ArrayList<>()).add(m)));
		
		mapMoviesProducer.entrySet().removeIf(entry -> entry.getValue().size() < 2);
		mapMoviesProducer.values().forEach(ms -> ms.sort(Comparator.comparing(Movie::getYear)));
		
		List<ProducerAwardDTO> producerAwardDto = new ArrayList<>();
		mapMoviesProducer.forEach((p, ms) -> {
			Movie previous = null;
			for (Movie m : ms) {
				if (previous == null) {
					previous = m;
				} else {
					producerAwardDto.add(new ProducerAwardDTO(p, m.getYear() - previous.getYear(), previous.getYear(), m.getYear()));
				}
			}
		});
		
		int minInterval = producerAwardDto.stream().mapToInt(ProducerAwardDTO::getInterval).min().getAsInt();
		int maxInterval = producerAwardDto.stream().mapToInt(ProducerAwardDTO::getInterval).max().getAsInt();
		
		AwardIntervalDTO awardIntervalDto = new AwardIntervalDTO();
		awardIntervalDto.setMin(producerAwardDto.stream().filter(pad -> pad.getInterval() == minInterval).toList());
		awardIntervalDto.setMax(producerAwardDto.stream().filter(pad -> pad.getInterval() == maxInterval).toList());
		
		return awardIntervalDto;
	}
}