package pl.coderslab.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomePageController {
	
	@ModelAttribute("currentDate")
	public String currentDatte() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.toString();
	}
}
