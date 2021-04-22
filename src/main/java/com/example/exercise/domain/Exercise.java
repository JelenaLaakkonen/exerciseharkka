package com.example.exercise.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Exercise {
	@ManyToOne
	@JoinColumn(name = "imageId")
	private Image image;
	@ManyToOne
	@JoinColumn(name = "moodId")
	private Mood mood;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long exerciseId;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private int pulse;
	private double duration;
	private String notes;
	
	public Exercise() {
	}

	public Exercise(Mood mood, Image image, String title, LocalDate date, int pulse, double duration, String notes) {
		super();
		this.mood = mood;
		this.image = image;
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
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
		return "Exercise [image=" + image + ", mood=" + mood + ", exerciseId=" + exerciseId + ", title=" + title
				+ ", date=" + date + ", pulse=" + pulse + ", duration=" + duration + ", notes=" + notes + "]";
	}
	
}