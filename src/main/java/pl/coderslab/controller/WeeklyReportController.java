package pl.coderslab.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.WeeklyReport;
import pl.coderslab.entity.WorkWeek;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.WeeklyReportRepository;
import pl.coderslab.repository.WorkWeekRepository;

@Controller
public class WeeklyReportController {

	@Autowired
	private WorkWeekRepository workWeekRepo;

	@Autowired
	private WeeklyReportRepository weeklyReportRepo;

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/weekly-report/{employeeId}")
	public String weeklyReport(@PathVariable Long employeeId, Model model) {

		LocalDate today = LocalDate.now(); // get current date
		LocalDate firsDayOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // get the nearest
																									// previous Monday
		WorkWeek workWeek = workWeekRepo.findByStartDate(firsDayOfWeek); // find current week

		Long workWeekId = workWeek.getId(); //find id of current week
		WeeklyReport weeklyReport = weeklyReportRepo.findByWorkWeekId(workWeekId);
		
		/*
		 * The code below is necessary to generate weekly report form
		 * It provides all dates and names of days
		 * With usage of dates user we'll be able to access a particular day's reports
		 */
		
		LocalDate startDate = workWeek.getStartDate();
		List<LocalDate> dayDates = new ArrayList<>(); //this section can be later transfered to service TODO
		List<String> dayNames = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			dayDates.add(startDate.plusDays(i));
			dayNames.add(startDate.plusDays(i).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		}
		
		model.addAttribute("dayDates", dayDates);
		model.addAttribute("dayNames", dayNames);
		
		/*
		 * When the users clicks on the link, he is transfered to a current week report.
		 * It a report for the current week does not exist, it is created.
		 * If it exists, is is loaded.
		 */

		if (weeklyReport == null) {

			WeeklyReport newWeeklyReport = new WeeklyReport();
			newWeeklyReport.setWorkWeek(workWeek); // assign unique work week (current one in this case)
			newWeeklyReport.setEmployee(employeeRepo.findById(employeeId).get()); // assign employee's id

			weeklyReportRepo.save(newWeeklyReport);
			model.addAttribute("weeklyReport", newWeeklyReport);
			return "weeklyReportForm";
		} else {

			model.addAttribute("weeklyReport", weeklyReport);

			return "weeklyReportForm";
		}
	}
}
