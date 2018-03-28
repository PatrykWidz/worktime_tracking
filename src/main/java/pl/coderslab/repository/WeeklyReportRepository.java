package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.WeeklyReport;

public interface WeeklyReportRepository extends JpaRepository<WeeklyReport, Long> {


	WeeklyReport findByWorkWeekId(Long id);
}
