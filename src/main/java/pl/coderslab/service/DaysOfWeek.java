package pl.coderslab.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class DaysOfWeek {

	/*
	 * This method returns days of a working week as dates (Monday to Friday)
	 * Then the method is used to fill in the report view with proper dates
	 */
	
	public static List<LocalDate> getDaysOfWeek(LocalDate date) {
		
		LocalDate firstDayOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		List<LocalDate> currentWeek = new ArrayList<>();
		
		currentWeek.add(firstDayOfWeek);
		
		for (int i = 1; i <= 4; i++) {
			currentWeek.add(firstDayOfWeek.plusDays(i));
		}
		
		return currentWeek;
	}
}
