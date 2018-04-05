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
@Table(name = "daily_reports")
public class DailyReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate date;

	private String dayName;

	private int status = 1; // 1 - active, 0 - inactive

	@OneToMany(mappedBy = "dailyReport", fetch = FetchType.EAGER)
	List<PartialDailyReport> partialDailyReports = new ArrayList<>();

	@ManyToOne
	private WeeklyReport weeklyReport;

	
	public DailyReport() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = LocalDate.parse(date);
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<PartialDailyReport> getPartialDailyReports() {
		return partialDailyReports;
	}

	public void setPartialDailyReports(List<PartialDailyReport> partialDailyReports) {
		this.partialDailyReports = partialDailyReports;
	}

	public WeeklyReport getWeeklyReport() {
		return weeklyReport;
	}

	public void setWeeklyReport(WeeklyReport weeklyReport) {
		this.weeklyReport = weeklyReport;
	}

}
