package com.raspberry.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class MovieControllerIntegrationTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void beforeEach() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	void shouldGetAwardsIntervals() throws Exception {
		this.mockMvc.perform(get("/movies/producers/awards-intervals"))
				.andExpect(status().isOk())
				.andExpect(content().json(
						"{"
						+ " \"min\": ["
						+ "   {"
						+ "     \"producer\": \"Joel Silver\","
						+ "     \"interval\": 1,"
						+ "     \"previousWin\": 1990,"
						+ "     \"followingWin\": 1991"
						+ "   }"
						+ " ],"
						+ " \"max\": ["
						+ "   {"
						+ "     \"producer\": \"Matthew Vaughn\","
						+ "     \"interval\": 13,"
						+ "     \"previousWin\": 2002,"
						+ "     \"followingWin\": 2015"
						+ "   }"
						+ " ]"
						+ "}"));
	}
}
