package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.PartialDailyReport;
import pl.coderslab.entity.Project;
import pl.coderslab.repository.PartialDailyReportRepository;
import pl.coderslab.repository.ProjectRepository;

@Controller
@RequestMapping("/daily-report/partial-daily-report")
public class PartialDailyReportController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private PartialDailyReportRepository partialDailyReportRepo;
	
	@ModelAttribute("projects")
	List<Project> projects() {
		return projectRepo.findAll();
	}
	
	
	@RequestMapping("/{partialDailyReportId}/delete")
	public String delete(@PathVariable Long partialDailyReportId) {
		
		PartialDailyReport partialDailyReport = partialDailyReportRepo.findById(partialDailyReportId).get();
		
		Long dailyReportId = partialDailyReport.getDailyReport().getId();
		
		
		partialDailyReportRepo.deleteById(partialDailyReportId);
		
		return "redirect: /worktime-tracking/daily-report/" + dailyReportId;
	}
}
