package com.example.exercise.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
		List<Exercise> findByTitle(String title);
	}