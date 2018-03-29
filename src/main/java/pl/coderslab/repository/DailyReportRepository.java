package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.DailyReport;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {

}
