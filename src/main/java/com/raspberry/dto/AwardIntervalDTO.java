package com.raspberry.dto;

import java.util.List;

import lombok.Data;

@Data
public class AwardIntervalDTO {
	
	private List<ProducerAwardDTO> min;
	
	private List<ProducerAwardDTO> max;
}