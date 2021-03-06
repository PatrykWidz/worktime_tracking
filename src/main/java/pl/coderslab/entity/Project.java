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

@Entity
@Table(name = "projects")
public class Project {

	/*** Start of list of attributes ***/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String symbol;
	private String name;
	private LocalDate deadline;
	private double value;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees = new ArrayList<>();

	@OneToMany(mappedBy = "project")
	private List<PartialDailyReport> partialDailyReports = new ArrayList<>();

	/*** End of list of attributes ***/

	public Project() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public List<PartialDailyReport> getPartialDailyReports() {
		return partialDailyReports;
	}

	public void setPartialDailyReports(List<PartialDailyReport> partialDailyReports) {
		this.partialDailyReports = partialDailyReports;
	}

	public String getSymbolAndName() {
		return this.symbol + " " + this.name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
