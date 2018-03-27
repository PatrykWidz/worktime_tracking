package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.WeeklyReport;

public interface WeeklyReportRepository extends JpaRepository<WeeklyReport, Long> {

//	List<WeeklyReport> findAllbyWorkWeekId(Long id);
//	
//	WeeklyReport getOneByEmployeeId(Long id);
}
