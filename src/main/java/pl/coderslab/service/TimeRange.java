package pl.coderslab.service;

import java.time.Duration;
import java.time.LocalTime;

public class TimeRange {
	
	public static double calculateTimeRange(LocalTime start, LocalTime end) {
		
		Duration timeElapsed = Duration.between(start, end);
		
		return ( timeElapsed.getSeconds() / 3600 );
	}
}
