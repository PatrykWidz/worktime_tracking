package pl.coderslab.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
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

	private LocalDate date;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private Project project;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
