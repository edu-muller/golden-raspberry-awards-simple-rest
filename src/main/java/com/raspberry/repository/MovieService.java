package com.raspberry.repository;

import java.util.List;

import com.raspberry.dto.AwardIntervalDTO;
import com.raspberry.model.Movie;

public interface MovieService {
	
	void saveAll(List<Movie> movies);
	
	AwardIntervalDTO findAwardInterval();
}
