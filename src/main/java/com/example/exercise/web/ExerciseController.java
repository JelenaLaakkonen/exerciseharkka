package com.example.exercise.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exercise.domain.Exercise;
import com.example.exercise.domain.ExerciseRepository;
import com.example.exercise.domain.ImageRepository;
import com.example.exercise.domain.MoodRepository;

@Controller
public class ExerciseController {
	
	@Autowired
	private ExerciseRepository eRepository;
	@Autowired
	private MoodRepository mRepository;
	@Autowired
	private ImageRepository iRepository;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String ExerciseList(Model model) {
		model.addAttribute("exercises", eRepository.findAll());
		return "main";
	}
	
	// REST all exercises
		@RequestMapping(value = "/exercises", method = RequestMethod.GET)
		public @ResponseBody List<Exercise> exerciseRest() {
			return (List<Exercise>) eRepository.findAll();
		}

		// REST exercise by id
		@RequestMapping(value = "/exercise/{exerciseId}", method = RequestMethod.GET)
		public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("exerciseId") Long exerciseId) {
			return eRepository.findById(exerciseId);
		}

		@RequestMapping(value = "/addexercise", method = RequestMethod.GET)
		public String addExercise(Model model) {
			model.addAttribute("exercise", new Exercise());
			model.addAttribute("moods", mRepository.findAll());
			model.addAttribute("images", iRepository.findAll());
			return "addexercise";
		}

		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Exercise exercise) {
			eRepository.save(exercise);
			return "redirect:/main";
		}

		@RequestMapping(value = "/delete/{exerciseId}", method = RequestMethod.GET)
		@PreAuthorize("hasAuthority('ADMIN')")
		public String deleteExercise(@PathVariable("exerciseId") Long exerciseId, Model model) {
			eRepository.deleteById(exerciseId);
			return "redirect:/main";
		}

		@RequestMapping(value = "/edit/{exerciseId}", method = RequestMethod.GET)
		public String editExercise(@PathVariable("exerciseId") Long exerciseId, Model model) {
			model.addAttribute("exercise", eRepository.findById(exerciseId));
			model.addAttribute("moods", mRepository.findAll());
			model.addAttribute("images", iRepository.findAll());
			return "edit";
		}
}
