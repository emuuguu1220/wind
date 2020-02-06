package edu.miu.cs.cs544.a202001.wind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.a202001.wind.domain.Student;
import edu.miu.cs.cs544.a202001.wind.domain.User;

import java.util.List;
import java.util.Map;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT t FROM User t where t.userName = :userName")
    User findByUsername(String userName);

    @Query("SELECT t FROM Student t where t.barcode = :barcode_id")
    Student findStudentByBarcode(String barcode_id);

    @Query("select distinct st from Session s join s.courseOffering co join co.students st join st.attendances at where s.id = :sessionId")
    List<Student> getAttendedStudentPerSession(Long sessionId);

    @Query("select st from Student st")
    List<Student> getAllStudent();

    @Query("select st from Student st join st.courseOfferings co join co.sessions s where s.id=?1")
    List<Student> getAllStudentPerSession(Long sessionId);

    @Query("select distinct st from Session s join s.courseOffering co join co.students st left join st.attendances at where s.id = :sessionId")
    List<Student> getSuspendedStudentPerSession(Long sessionId);


}
