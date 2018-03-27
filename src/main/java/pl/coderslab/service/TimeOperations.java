package pl.coderslab.service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TimeOperations {

	/*
	 * This method returns days of a working week as dates (Monday to Friday) Then
	 * the method is used to fill in the report view with proper dates
	 */

	public static List<LocalDate> getDaysOfWeek(LocalDate date) {

		LocalDate firstDayOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		List<LocalDate> daysOfWeek = new ArrayList<>();

		daysOfWeek.add(firstDayOfWeek);

		for (int i = 1; i <= 4; i++) {
			daysOfWeek.add(firstDayOfWeek.plusDays(i));
		}

		return daysOfWeek;
	}

	/*
	 * This method returns an ArrayList of days' names for a given ArrayList of
	 * LocalDate instances
	 */

	public static List<String> getDaysOfWeekNames(List<LocalDate> daysOfWeek) {

		List<String> daysOfWeekNames = new ArrayList<>();

		for (LocalDate date : daysOfWeek) {
			daysOfWeekNames.add(date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		}

		return daysOfWeekNames;
	}

	public static LocalDate parseDateFromString(String dateStr) {

		LocalDate date = LocalDate.parse(dateStr);

		return date;
	}

	public static double calculateTimeRange(LocalTime start, LocalTime end) {

		Duration timeElapsed = Duration.between(start, end);

		return (timeElapsed.getSeconds() / 3600.0);
	}
}
