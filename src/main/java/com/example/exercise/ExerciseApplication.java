package com.example.exercise;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.exercise.domain.Exercise;
import com.example.exercise.domain.ExerciseRepository;
import com.example.exercise.domain.Image;
import com.example.exercise.domain.ImageRepository;
import com.example.exercise.domain.Mood;
import com.example.exercise.domain.MoodRepository;
import com.example.exercise.domain.User;
import com.example.exercise.domain.UserRepository;

@SpringBootApplication
public class ExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ExerciseRepository eRepository, MoodRepository mRepository, ImageRepository iRepository, UserRepository uRepository) {
		return (args) -> {

			Mood m1 = new Mood("Lethargic");
			Mood m2 = new Mood("Energetic");

			mRepository.save(m1);
			mRepository.save(m2);
			
			Image i1 = new Image("sunny");
			Image i2 = new Image("cloudy");

			iRepository.save(i1);
			iRepository.save(i2);
			
			LocalDate d1 = LocalDate.parse("2021-02-20");
			LocalDate d2 = LocalDate.parse("2021-02-21");
			
			Exercise e1 = new Exercise(m1, i1, "Running", d1, 120, 1.5, "Muscles sore after");
			Exercise e2 = new Exercise(m2, i2, "Streching", d2, 60, 0.5, "Felt relaxed after");

			eRepository.save(e1);
			eRepository.save(e2);
			
			uRepository.deleteAll();

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.fi","USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.fi", "ADMIN");
			
			uRepository.save(user1);
			uRepository.save(user2);
			
		};
	}

}
