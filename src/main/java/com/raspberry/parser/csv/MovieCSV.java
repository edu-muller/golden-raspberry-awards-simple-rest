package com.raspberry.parser.csv;

import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.raspberry.model.Movie;

import lombok.Data;

@Data
public class MovieCSV {
	
	@CsvBindByName
	private Integer year;
	
	@CsvBindByName
	private String title;
	
	@CsvBindAndSplitByName(elementType = String.class, splitOn = "\\sand\\s|,\\sand\\s|,\\s")
	private List<String> studios;
	
	@CsvBindAndSplitByName(elementType = String.class, splitOn = "\\sand\\s|,\\sand\\s|,\\s")
	private List<String> producers;
	
	@CsvCustomBindByName(converter = ConvertYesToBoolean.class)
	private boolean winner;
	
	public Movie toEntity() {
		return Movie.builder()
				.year(year)
				.title(title)
				.studios(studios)
				.producers(producers)
				.winner(winner)
				.build();
	}
}