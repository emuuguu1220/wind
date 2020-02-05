package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.TimeSlot;
import edu.miu.cs.cs544.a202001.wind.service.ITimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeSlots")
public class TimeSlotController {

    private ITimeSlotService timeSlotService;

    @GetMapping(value = "/")
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotService.getAllTimeSlots();
    }

    @GetMapping(value = "/{id}")
    public TimeSlot getTimeSlot(@PathVariable String id) {
        return timeSlotService.getTimeSlotById(id);
    }


    @PostMapping(value = "/add")
    public void addTimeSlot(@RequestBody TimeSlot timeSlot) {
        timeSlotService.addTimeSlot(timeSlot);
    }

    @PutMapping(value = "/update")
    public void updateTimeSlot(@RequestBody TimeSlot timeSlot) {
        timeSlotService.updateTimeSlot(timeSlot);
    }

    @DeleteMapping(value = "/delete")
    public void deleteTimeSlot(@RequestBody TimeSlot timeSlot) {
        timeSlotService.deleteTimeSlot(timeSlot);
    }


    public TimeSlotController() {
    }

    public ITimeSlotService getTimeSlotService() {
        return timeSlotService;
    }
    @Autowired
    public void setTimeSlotService(ITimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }
}
