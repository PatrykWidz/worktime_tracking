package pl.coderslab.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.WorkWeek;
import pl.coderslab.repository.WorkWeekRepository;

@Controller
public class WorkWeekController {
	
	@Autowired
	private WorkWeekRepository workWeekRepo;
	
	@GetMapping("/workWeek/add")
	public String add(Model model) {
		WorkWeek workWeek = new WorkWeek();
		model.addAttribute("workWeek", workWeek);
		
		return "newWorkWeekForm";
	}
	
	@PostMapping("/workWeek/add")
	@ResponseBody
	public String save(HttpServletRequest request) {
		
		WorkWeek workWeek = new WorkWeek();
		
		String startDateStr = request.getParameter("startDate");
		LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
		
		workWeek.setStartDate(startDate);
		
		workWeekRepo.save(workWeek);
		
		return "Success";
	}
}
