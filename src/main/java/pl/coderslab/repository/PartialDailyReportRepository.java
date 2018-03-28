package pl.coderslab.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.PartialDailyReport;

public interface PartialDailyReportRepository extends JpaRepository<PartialDailyReport, Long> {

	List<PartialDailyReport> findAllByDate(LocalDate date);
}
