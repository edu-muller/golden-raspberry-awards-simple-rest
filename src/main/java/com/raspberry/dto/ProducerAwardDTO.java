package com.raspberry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProducerAwardDTO {
	
	private String producer;
	
	private Integer interval;
	
	private Integer previousWin;
	
	private Integer followingWin;
}