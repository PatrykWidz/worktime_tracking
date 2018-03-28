package pl.coderslab.repository;


import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.WorkWeek;

public interface WorkWeekRepository extends JpaRepository<WorkWeek, Long> {

	WorkWeek findByStartDate(LocalDate startDate);
}
