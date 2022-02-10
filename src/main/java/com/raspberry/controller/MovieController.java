package com.raspberry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raspberry.dto.AwardIntervalDTO;
import com.raspberry.repository.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
//	@GetMapping
//	public List<Movie> list() {
//		return repository.findAll();
//	}
	
	@GetMapping("producers/award-intervals")
	public AwardIntervalDTO awardIntervals() {
		return this.service.findAwardInterval();
	}
}