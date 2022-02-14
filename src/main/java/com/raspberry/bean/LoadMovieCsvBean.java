package com.raspberry.bean;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvToBeanBuilder;
import com.raspberry.model.Movie;
import com.raspberry.parser.csv.MovieCSV;
import com.raspberry.service.MovieService;

@Component
public class LoadMovieCsvBean implements InitializingBean {
	
	private static final String CSV_NAME = "movielist.csv";
	
	private final MovieService movieService;
	
	@Value("${data.file.path}")
	private String dataFilePath;
	
	@Autowired
	public LoadMovieCsvBean(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.loadCsv();
	}
	
	public void loadCsv() throws IOException {
		try (FileReader fileReader = new FileReader(this.dataFilePath + CSV_NAME)) {
			List<MovieCSV> moviesCsv = new CsvToBeanBuilder<MovieCSV>(fileReader)
					.withType(MovieCSV.class)
					.withSeparator(';')
					.build()
					.parse();
			
			List<Movie> movies = moviesCsv.stream().map(MovieCSV::toEntity).toList();
			this.movieService.saveAll(movies);
		}
	}
}
