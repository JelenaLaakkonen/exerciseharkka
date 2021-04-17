package com.example.exercise.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exercise {
	@ManyToOne
	@JoinColumn(name = "moodId")
	private Mood mood;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long exerciseId;
	private String title;
	private String date;
	private int pulse;
	private double duration;
	private String notes;
	
	public Exercise() {
	}

	public Exercise(Mood mood, String title, String date, int pulse, double duration, String notes) {
		super();
		this.mood = mood;
		this.title = title;
		this.date = date;
		this.pulse = pulse;
		this.duration = duration;
		this.notes = notes;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public Long getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Long exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Exercise [exerciseId=" + exerciseId + ", title=" + title + ", date=" + date + ", pulse=" + pulse
				+ ", duration=" + duration + ", notes=" + notes + "]";
	}
	
}