package com.openclassrooms.bobapp;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BobappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void failingTest() {
		assertFalse(true, "This test is designed to fail");
	}

}
