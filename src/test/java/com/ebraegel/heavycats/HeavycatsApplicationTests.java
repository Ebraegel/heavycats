package com.ebraegel.heavycats;

import com.ebraegel.heavycats.contoller.CatController;
import com.ebraegel.heavycats.contoller.WeightController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HeavycatsApplicationTests {
	@Autowired
	private CatController catController;

	@Autowired
	private WeightController weightController;

	@Test
	public void catControllerLoads() throws Exception {
		assertThat(catController).isNotNull();
	}

	@Test
	public void weightControllerLoads() throws Exception {
		assertThat(weightController).isNotNull();
	}
}
