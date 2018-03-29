package pl.coderslab.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "weekly_reports")
public class WeeklyReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String status = "0"; // 0 - notconfirmed, 1 - confirmed

	private LocalDate startDate;

	@ManyToOne
	private Employee employee;

	@OneToMany(mappedBy = "weeklyReport", fetch = FetchType.EAGER)
	List<DailyReport> dailyReports = new ArrayList<>();

	public WeeklyReport() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<DailyReport> getDailyReports() {
		return dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
}
