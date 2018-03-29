package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.DailyReport;
import pl.coderslab.entity.PartialDailyReport;
import pl.coderslab.entity.Project;
import pl.coderslab.repository.DailyReportRepository;
import pl.coderslab.repository.PartialDailyReportRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.service.TimeOperations;

@Controller
@RequestMapping("/daily-report")
public class DailyReportController {

	@Autowired
	private DailyReportRepository dailyReportRepo;
	
	@Autowired
	private PartialDailyReportRepository partialDailyReportRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@ModelAttribute("projects")
	List<Project> projects() {
		return projectRepo.findAll();
	}
	
	@GetMapping("/{dailyReportId}")
	public String load(@PathVariable Long dailyReportId, Model model) {
		
		DailyReport dailyReport = dailyReportRepo.findById(dailyReportId).get();
		PartialDailyReport partialDailyReport = new PartialDailyReport();
		
		model.addAttribute("dailyReport", dailyReport);
		model.addAttribute("partialDailyReport", partialDailyReport);
		
		return "dailyReport";
	}
	
	@PostMapping("/{dailyReportId}")
	public String save(@ModelAttribute PartialDailyReport partialDailyReport, @PathVariable Long dailyReportId) {
		
		//Calculate man-hours by taking start time and end time
		double manHours = TimeOperations.calculateTimeRange(partialDailyReport.getStartTime(), partialDailyReport.getEndTime());
		manHours = (double) Math.round(manHours * 100) / 100;
				
		//Set man-hours
		partialDailyReport.setManHours(manHours);
		
		// Assign it to a weeklyReport
		partialDailyReport.setDailyReport(dailyReportRepo.findById(dailyReportId).get());
		
		partialDailyReportRepo.save(partialDailyReport);
		
		return "redirect: /worktime-tracking/daily-report/" + partialDailyReport.getDailyReport().getId();
	}
}
