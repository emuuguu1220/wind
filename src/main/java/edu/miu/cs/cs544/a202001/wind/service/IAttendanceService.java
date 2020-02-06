package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;
import edu.miu.cs.cs544.a202001.wind.domain.Student;

import java.util.List;
import java.util.Map;

public interface IAttendanceService {
    public abstract void addAttendance(Attendance attendance);
    public abstract Map<String, Object> recordAttendance(String barcode_id);
    public abstract Attendance getAttendanceById(Long id);
    public abstract List<Attendance> getAllAttendances();
    public abstract void updateAttendance(Attendance attendance);
    public abstract void deleteAttendance(Attendance attendance);
    List<Object[]> getAllAttendancesForStudent(String barCode);
}
