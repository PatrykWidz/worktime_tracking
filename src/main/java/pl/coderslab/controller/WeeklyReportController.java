package pl.coderslab.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.DailyReport;
import pl.coderslab.entity.WeeklyReport;
import pl.coderslab.repository.DailyReportRepository;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.WeeklyReportRepository;

@Controller
public class WeeklyReportController {

	@Autowired
	private WeeklyReportRepository weeklyReportRepo;

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private DailyReportRepository dailyReportRepo;

	@GetMapping("/weekly-report/{currentDate}/{employeeId}")
	public String weeklyReport(@PathVariable String currentDate, @PathVariable Long employeeId, Model model) {

		LocalDate date = LocalDate.parse(currentDate);
		LocalDate firstDayOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		
		if ( ! ( weeklyReportRepo.existsByStartDateAndEmployeeId(firstDayOfWeek, employeeId) ) ) {
			//Create new weekly report
			WeeklyReport weeklyReport = new WeeklyReport();
			
			weeklyReport.setStartDate(firstDayOfWeek);
			weeklyReport.setEmployee(employeeRepo.findById(employeeId).get());
			weeklyReportRepo.save(weeklyReport);
			
			//Generate empty daily reports
			for (int i = 0; i < 5; i++) {
				DailyReport dailyReport = new DailyReport();
				
				dailyReport.setDate(firstDayOfWeek.plusDays(i).toString());
				dailyReport.setDayName(firstDayOfWeek.plusDays(i).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
				dailyReport.setWeeklyReport(weeklyReport);
				
				dailyReportRepo.save(dailyReport);
			}
			
			weeklyReport = weeklyReportRepo.findByStartDateAndEmployeeId(firstDayOfWeek, employeeId);
			model.addAttribute("weeklyReport", weeklyReport);
			
		} else {
			
			WeeklyReport weeklyReport = weeklyReportRepo.findByStartDateAndEmployeeId(firstDayOfWeek, employeeId);
			
			model.addAttribute("weeklyReport", weeklyReport);
		}
		
		return "weeklyReportForm";
	}
}
