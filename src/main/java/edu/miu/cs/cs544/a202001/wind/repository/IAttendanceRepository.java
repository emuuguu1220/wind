package edu.miu.cs.cs544.a202001.wind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;

import java.util.List;


@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("select a from Attendance a where a.barcode_id =?1")
    List<Attendance> findByBarcode(String barCode);
}
