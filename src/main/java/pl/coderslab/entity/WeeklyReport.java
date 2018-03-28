package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	
	private String status;
	
	@ManyToOne
	private WorkWeek workWeek;
	
	@ManyToOne
	private Employee employee;
	
	@OneToMany(mappedBy = "weeklyReport")
	List<PartialDailyReport> partialDailyReport = new ArrayList<>();

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

	public WorkWeek getWorkWeek() {
		return workWeek;
	}

	public void setWorkWeek(WorkWeek workWeek) {
		this.workWeek = workWeek;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<PartialDailyReport> getPartialDailyReport() {
		return partialDailyReport;
	}

	public void setPartialDailyReport(List<PartialDailyReport> partialDailyReport) {
		this.partialDailyReport = partialDailyReport;
	}
}
