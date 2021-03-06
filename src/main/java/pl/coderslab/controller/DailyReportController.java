package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		
		List<PartialDailyReport> reports = dailyReport.getPartialDailyReports();
		
		double manHourSum = 0.0;
		
		for(PartialDailyReport report : reports) {
			manHourSum += report.getManHours();
		}
		
		model.addAttribute("manHourSum", manHourSum);
		
		return "dailyReport";
	}
	
	@PostMapping("/{dailyReportId}")
	public String save(@Valid @ModelAttribute PartialDailyReport partialDailyReport, BindingResult bindingResult, @PathVariable Long dailyReportId) {
		
		
		//TODO: finish form validation - include error messages in the form. Make page load properly when errors occur.
		if (bindingResult.hasErrors()) {
			return "dailyReport";
		}
				
		//Set man-hours
		partialDailyReport.setManHours();
		
		// Assign it to a weeklyReport
		partialDailyReport.setDailyReport(dailyReportRepo.findById(dailyReportId).get());
		
		partialDailyReportRepo.save(partialDailyReport);
		
		return "redirect: /worktime-tracking/daily-report/" + partialDailyReport.getDailyReport().getId();
	}
}
