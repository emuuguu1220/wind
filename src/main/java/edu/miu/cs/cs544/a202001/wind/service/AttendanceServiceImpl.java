package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;
import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.domain.Student;
import edu.miu.cs.cs544.a202001.wind.domain.TimeSlot;
import edu.miu.cs.cs544.a202001.wind.repository.IAttendanceRepository;
import edu.miu.cs.cs544.a202001.wind.repository.ILocationRepository;
import edu.miu.cs.cs544.a202001.wind.repository.ITimeSlotRepository;
import edu.miu.cs.cs544.a202001.wind.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    private IAttendanceRepository attendanceRepository;
    private IUserRepository userRepository;
    private ITimeSlotRepository timeSlotRepository;
    private ILocationRepository locationRepository;
    
	@Override
	public Map<String, Object> recordAttendance(String barcode_id,long locationId) {
		Map<String, Object> rtn = new LinkedHashMap<>();
		Student student = (Student) userRepository.findStudentByBarcode((String) barcode_id);
		if(student == null) {
			rtn.put("success", false);
	    	rtn.put("message", "student not found!");
	    	return rtn;
		}
		TimeSlot timeSlot = (TimeSlot) timeSlotRepository.findByTime(new Date());
		if(timeSlot == null) {
			rtn.put("success", false);
	    	rtn.put("message", "time slot not found!");
		}
		Location location = locationRepository.getOne(locationId);
		Attendance att = new Attendance(new Date(),student,timeSlot,location);
		attendanceRepository.save(att);
		
		rtn.put("success", true);
    	rtn.put("message", "attendance recorded");
		return rtn;
	}
	
    public AttendanceServiceImpl(IAttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public AttendanceServiceImpl() {
    }
    
    @Autowired
    public void setAttendanceRepository(IAttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }
    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setTimeSlotRepository(ITimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }
    @Autowired
    public void setLocationRepo(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
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

    @Override
    public List<Object[]> getAllAttendancesForStudent(String barCode) {
        return attendanceRepository.findByBarcode(barCode);
    }
    @Override
    public List<Attendance> getAttendanceBySession(Long sessionId, Long courseOfferingId)
    {
        return attendanceRepository.getAttendanceBySession(sessionId,courseOfferingId);
    }

}
