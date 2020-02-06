package edu.miu.cs.cs544.a202001.wind.repository;

import edu.miu.cs.cs544.a202001.wind.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;

import java.util.List;


@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("select distinct c.name, a.date, 'Attended' " +
            "from Attendance a " +
            "join a.student st " +
            "join st.courseOfferings co " +
            "join co.course c " +
            "where a.barcode_id =?1"
    )
    List<Object[]> findByBarcode(String barCode);

    @Query("select distinct a from Attendance a join a.student st join st.courseOfferings co join co.sessions s where st.id=?1 and co.id=?2")
    List<Attendance> getAttendanceByStudentByCourseOff(Long studentId,Long courseOfferingId);

}
