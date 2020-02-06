package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;

import java.util.List;

public interface IAttendanceService {
    public abstract void addAttendance(Attendance attendance);
    public abstract Attendance getAttendanceById(Long id);
    public abstract List<Attendance> getAllAttendances();
    public abstract void updateAttendance(Attendance attendance);
    public abstract void deleteAttendance(Attendance attendance);
    List<Attendance> getAllAttendancesForStudent(String barCode);
}