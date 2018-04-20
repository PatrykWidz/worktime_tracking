package pl.coderslab.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import pl.coderslab.service.TimeOperations;

@Entity
@Table(name = "partial_daily_reports")
public class PartialDailyReport {

	/*** Start of list of attributes ***/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double manHours;

	@NotNull(message = "This field cannot be empty")
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime startTime;
	
	@NotNull(message = "This field cannot be empty")
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime endTime;
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private DailyReport dailyReport;

	/*** End of list of attributes ***/

	public PartialDailyReport() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getManHours() {
		return manHours;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		
		this.startTime = LocalTime.parse(startTime);
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = LocalTime.parse(endTime);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setManHours() {
		double manHours = TimeOperations.calculateTimeRange(this.startTime, this.endTime);
		manHours = (double) Math.round(manHours * 100) / 100;
		this.manHours = manHours;
	}

	public DailyReport getDailyReport() {
		return dailyReport;
	}

	public void setDailyReport(DailyReport dailyReport) {
		this.dailyReport = dailyReport;
	}
}
