package pl.coderslab.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.coderslab.repository.WorkWeekRepository;

@Controller
public class HomePageController {
	
	@ModelAttribute("currentDate")
	public String currentDatte() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.toString();
	}
}
