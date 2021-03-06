package edu.miu.cs.cs544.a202001.wind.controller;

import edu.miu.cs.cs544.a202001.wind.domain.Attendance;
import edu.miu.cs.cs544.a202001.wind.domain.User;
import edu.miu.cs.cs544.a202001.wind.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    private IAttendanceService attendanceService;

    @GetMapping(value = "/AttendedbyBarCode/{barCode}")
    public List<Object[]> getUserAttendances(@PathVariable String barCode) {
        return attendanceService.getAllAttendancesForStudent(barCode);
    }



    @GetMapping(value = "/")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping(value = "/{id}")
    public Attendance getAttendance(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping(value = "/student/{studentId}/{courseOfferingId}")
    public List<Attendance> getAttendanceByStudentByCourseOff(@PathVariable Long studentId, @PathVariable Long courseOfferingId)
    {
        return attendanceService.getAttendanceByStudentByCourseOff(studentId,courseOfferingId);
    }
    @GetMapping(value = "/record")
    public Map<String, Object> recordAttendance(@RequestParam String barcode,@RequestParam long locationId) {
       return attendanceService.recordAttendance(barcode,locationId);
    }

    @DeleteMapping(value = "/delete")
    public void deleteAttendance(@RequestBody Attendance attendance) {
        attendanceService.deleteAttendance(attendance);
    }


    public AttendanceController() {
    }

    public IAttendanceService getAttendanceService() {
        return attendanceService;
    }

    @Autowired
    public void setAttendanceService(IAttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
}
