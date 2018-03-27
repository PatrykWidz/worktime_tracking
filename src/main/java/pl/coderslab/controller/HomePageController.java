package pl.coderslab.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.coderslab.entity.WorkWeek;
import pl.coderslab.repository.WorkWeekRepository;

@Controller
public class HomePageController {

	@Autowired
	private WorkWeekRepository workWeekRepo;
	
	@ModelAttribute("currentDate")
	public String currentDatte() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.toString();
	}
	
	@GetMapping("/userPanel")
	public String userPanel() {
		return "userPanel";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<LocalDate> dayDates = new ArrayList<>();
		List<String> dayNames = new ArrayList<>();
		
		Long id = Long.parseLong("1");
		
		System.out.println(workWeekRepo.existsById(id));
		
		WorkWeek workWeek = workWeekRepo.findById(id).get();
		
		
		LocalDate startDate = workWeek.getStartDate();
		
		for (int i = 0; i < 5; i++) {
			dayDates.add(startDate.plusDays(i));
			dayNames.add(startDate.plusDays(i).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		}
		
		model.addAttribute("dayDates", dayDates);
		model.addAttribute("dayNames", dayNames);
		
		return "weeklyReportForm";
	}
}
