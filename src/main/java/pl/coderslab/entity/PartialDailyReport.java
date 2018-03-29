package pl.coderslab.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partial_daily_reports")
public class PartialDailyReport {

	/*** Start of list of attributes ***/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double manHours;

	private LocalTime startTime;
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

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setManHours(double manHours) {
		this.manHours = manHours;
	}

	public DailyReport getDailyReport() {
		return dailyReport;
	}

	public void setDailyReport(DailyReport dailyReport) {
		this.dailyReport = dailyReport;
	}
}
