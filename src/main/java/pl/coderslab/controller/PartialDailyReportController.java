package pl.coderslab.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.PartialDailyReport;
import pl.coderslab.entity.Project;
import pl.coderslab.repository.PartialDailyReportRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.service.TimeOperations;

@Controller
public class PartialDailyReportController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private PartialDailyReportRepository partialDailyReportRepo;
	
	@ModelAttribute("projects")
	List<Project> projects() {
		return projectRepo.findAll();
	}
	
	@GetMapping("/partial-daily-report/{date}")
	public String add(Model model, @PathVariable String date, HttpServletRequest request) {
		
		PartialDailyReport partialDailyReport = new PartialDailyReport();
		
		LocalDate reportDate = TimeOperations.parseDateFromString(date);
		List<PartialDailyReport> partialReports = partialDailyReportRepo.findAllByDate(reportDate); //get a list of partial reports to display those that are ready
		
		model.addAttribute("partialReports", partialReports); 
		
		model.addAttribute("dayDate", reportDate);
		model.addAttribute("dayName", reportDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		
		
		model.addAttribute("partialDailyReport", partialDailyReport);
		
		return "partialDailyReportForm";
	}
	
	@PostMapping("/partial-daily-report/{reportDate}")
	public String save(Model model, @ModelAttribute PartialDailyReport partialDailyReport, @PathVariable String reportDate) {
		
		//Date comes as a String from the URI, it needs to be parsed to LocalDate
		LocalDate date = TimeOperations.parseDateFromString(reportDate);
		
		//Set date and assign employee to a new partial report
		partialDailyReport.setDate(date);
		
		//Calculate man-hours by taking start time and end time
		double manHours = TimeOperations.calculateTimeRange(partialDailyReport.getStartTime(), partialDailyReport.getEndTime());
		manHours = (double) Math.round(manHours * 100) / 100;
		
		//Set man-hours
		partialDailyReport.setManHours(manHours);
		
		partialDailyReportRepo.save(partialDailyReport);
		
		return "partialDailyReportForm";
	}
}
