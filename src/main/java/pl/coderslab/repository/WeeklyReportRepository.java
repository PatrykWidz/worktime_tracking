package pl.coderslab.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.WeeklyReport;

public interface WeeklyReportRepository extends JpaRepository<WeeklyReport, Long> {


	WeeklyReport findByStartDateAndEmployeeId(LocalDate startDate, Long employeeId);
	
	boolean existsByStartDateAndEmployeeId(LocalDate startDate, Long employeeId);
}
