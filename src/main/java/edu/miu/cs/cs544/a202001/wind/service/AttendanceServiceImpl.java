package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;
import edu.miu.cs.cs544.a202001.wind.repository.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    private IAttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(IAttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public AttendanceServiceImpl() {
    }

    @Autowired
    public void setAttendanceRepository(IAttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public void addAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).get();
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Attendance attendance) {
        attendanceRepository.delete(attendance);
    }
}
