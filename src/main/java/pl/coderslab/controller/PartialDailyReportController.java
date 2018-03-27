package pl.coderslab.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.Employee;
import pl.coderslab.entity.PartialDailyReport;
import pl.coderslab.entity.Project;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.PartialDailyReportRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.service.TimeOperations;

@Controller
public class PartialDailyReportController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private PartialDailyReportRepository partialDailyReportRepo;
	
	@ModelAttribute("projects")
	List<Project> projects() {
		return projectRepo.findAll();
	}
	
	@GetMapping("/partial-daily-report/{emplId}/{dt}/add")
	public String add(Model model, @PathVariable String dt) {
		
		PartialDailyReport partialDailyReport = new PartialDailyReport();
		
		LocalDate reportDate = TimeOperations.parseDateFromString(dt);
		
		model.addAttribute("dayDate", reportDate);
		model.addAttribute("dayName", reportDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		
		
		model.addAttribute("partialDailyReport", partialDailyReport);
		
		return "partialDailyReportForm";
	}
	
	@PostMapping("/partial-daily-report/{emplId}/{dt}/add")
	public String save(Model model, @ModelAttribute PartialDailyReport partialDailyReport, @PathVariable Long emplId, @PathVariable String dt) {
		
		Employee employee = employeeRepo.getOne(emplId);
		
		//Date comes as a String from the URI, it needs to be parsed to LocalDate
		LocalDate reportDate = TimeOperations.parseDateFromString(dt);
		
		//Set date and assign employee to a new partial report
		partialDailyReport.setDate(reportDate);
		partialDailyReport.setEmployee(employee);
		
		//Calculate man-hours by taking start time and end time
		double manHours = TimeOperations.calculateTimeRange(partialDailyReport.getStartTime(), partialDailyReport.getEndTime());
		
		//Set man-hours
		partialDailyReport.setManHours(manHours);
		
		partialDailyReportRepo.save(partialDailyReport);
		
		return "partialDailyReportForm";
	}
}
