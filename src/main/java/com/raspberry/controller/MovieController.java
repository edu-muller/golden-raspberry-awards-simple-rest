package com.raspberry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raspberry.dto.AwardIntervalDTO;
import com.raspberry.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping("producers/awards-intervals")
	public AwardIntervalDTO awardsIntervals() {
		return this.service.findAwardInterval();
	}
}