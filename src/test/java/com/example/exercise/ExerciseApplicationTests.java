package com.example.exercise;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.exercise.web.ExerciseController;
import com.example.exercise.web.LoginController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	private ExerciseController eController;
	
	@Autowired
	private LoginController lController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(eController).isNotNull();
		assertThat(lController).isNotNull();
	}

}
