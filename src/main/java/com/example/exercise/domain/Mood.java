package com.example.exercise.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long moodId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mood")
	private List<Exercise> exercises;

	public Mood() {
	}

	public Mood(String name) {
		super();
		this.name = name;
	}

	public Long getMoodId() {
		return moodId;
	}

	public void setMoodId(Long moodId) {
		this.moodId = moodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<Exercise> getExerises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	@Override
	public String toString() {
		return "Mood [moodId=" + moodId + ", name=" + name + "]";
	}

}
