package edu.miu.cs.cs544.a202001.wind.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.a202001.wind.domain.TimeSlot;

 
 
@Repository
public interface ITimeSlotRepository extends JpaRepository<TimeSlot, String> {
	@Query("SELECT t FROM TimeSlot t where :currentTIME BETWEEN t.startTime AND t.endTime")
	TimeSlot findByTime(Date currentTIME);
}
