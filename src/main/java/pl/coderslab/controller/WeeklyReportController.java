package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.WeeklyReport;
import pl.coderslab.repository.WeeklyReportRepository;
import pl.coderslab.repository.WorkWeekRepository;

@Controller
public class WeeklyReportController {
	
	@Autowired
	private WorkWeekRepository workWeekRepo;
	
	@Autowired
	private WeeklyReportRepository weeklyReportRepo;
	
	@GetMapping("/weekly-report/{weekId}/{employeeId}")
	public String weeklyReport(@PathVariable Long weekId, @PathVariable Long employeeId, Model model) {

//		List<WeeklyReport> weeklyReports = weeklyReportRepo.findAllbyWorkWeekId(weekId); //All weekly reports are found by weekId
//		
//		if (weeklyReportRepo.existsById(employeeId)) {
//		WeeklyReport weeklyReport = weeklyReportRepo.getOne(employeeId); //A report of a particular employee is found for the assigned week
//		model.addAttribute("weeklyReport", weeklyReport);
//		}
		return "weeklyReportForm";
	}
}
