package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.PartialDailyReport;

public interface PartialDailyReportRepository extends JpaRepository<PartialDailyReport, Long> {

}
