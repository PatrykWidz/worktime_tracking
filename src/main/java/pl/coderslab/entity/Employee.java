package pl.coderslab.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.coderslab.service.TimeOperations;

@Entity
@Table(name="employees")
public class Employee {

	/*** Start of list of attributes ***/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private double manHourCost;
	private LocalDate dateOfEmployment;

	@OneToMany(mappedBy = "employee")
	public List<WeeklyReport> weeklyReports = new ArrayList<>();
	
	@ManyToMany
	public List<Project> projects = new ArrayList<>();
	
	/*** End of list of attributes ***/
	
	public Employee() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getManHourCost() {
		return manHourCost;
	}

	public void setManHourCost(double manHourCost) {
		this.manHourCost = manHourCost;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(String dateOfEmployment) {
		this.dateOfEmployment = LocalDate.parse(dateOfEmployment);
	}

	public List<WeeklyReport> getWeeklyReports() {
		return weeklyReports;
	}

	public void setWeeklyReports(List<WeeklyReport> weeklyReports) {
		this.weeklyReports = weeklyReports;
	}
}
