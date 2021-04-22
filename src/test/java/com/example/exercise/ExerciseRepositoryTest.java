package com.example.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.exercise.domain.Exercise;
import com.example.exercise.domain.ExerciseRepository;
import com.example.exercise.domain.Mood;
import com.example.exercise.domain.MoodRepository;
import com.example.exercise.domain.User;
import com.example.exercise.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ExerciseRepositoryTest {

	@Autowired
	private ExerciseRepository eRepository;

	@Autowired
	private MoodRepository mRepository;

	@Autowired
	private UserRepository uRepository;

	@Test
	public void findByTitleShouldReturnExercise() {
		List<Exercise> exercises = eRepository.findByTitle("Running");
		assertThat(exercises).hasSize(1);
		assertThat(exercises.get(0).getDate()).isEqualTo("02.02.2020");
	}

	@Test
	public void createNewExercise() {
		Exercise exercise = new Exercise(new Mood("Neutral"), "Hiking", "05.04.2021", 100, 1.0, "Nice views");
		eRepository.save(exercise);
		assertThat(exercise.getExerciseId()).isNotNull();
	}

	@Test
	public void deleteExercise() {
		List<Exercise> exercises = eRepository.findByTitle("Running");
		eRepository.deleteAll(exercises);
		assertThat(exercises.isEmpty());
	}

	@Test
	public void findByNameShouldReturnMood() {
		List<Mood> moods = mRepository.findByName("Energetic");
		assertThat(moods).hasSize(1);
	}

	@Test
	public void createNewMood() {
		Mood mood = new Mood("Relaxed");
		mRepository.save(mood);
		assertThat(mood.getMoodId()).isNotNull();
	}

	@Test
	public void deleteCategory() {
		List<Mood> moods = mRepository.findByName("Energetic");
		mRepository.deleteAll(moods);
		assertThat(moods.isEmpty());
	}

	@Test
	public void findByUserNameShouldReturnUser() {
		User user = uRepository.findByUsername("user");
		assertThat(user.getEmail()).isEqualTo("user@user.fi");
	}

	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user2@user.fi", "USER");
		uRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteUser() {
		User user = uRepository.findByUsername("user");
		uRepository.deleteById(user.getId());
		assertThat(uRepository.findByUsername("user")).isNull();
	}

}
