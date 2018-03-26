package pl.coderslab.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.coderslab.service.DaysOfWeek;

@Controller
public class HomePageController {

	@ModelAttribute("currentDate")
	public String currentDatte() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.toString();
	}
	
	@ModelAttribute("currentWeek")
	public List<LocalDate> currentWeek() {
		LocalDate currentDate = LocalDate.now();
		List<LocalDate> currentWeek = DaysOfWeek.getDaysOfWeek(currentDate);
		return currentWeek;
	}
	
	@GetMapping("/")
	public String home() {
		return "reportWorktimeForm";
	}
}
