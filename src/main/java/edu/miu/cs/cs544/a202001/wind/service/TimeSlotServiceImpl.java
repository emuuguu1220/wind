package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.TimeSlot;
import edu.miu.cs.cs544.a202001.wind.repository.ITimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements ITimeSlotService {

    private ITimeSlotRepository timeSlotRepository;

    public TimeSlotServiceImpl(ITimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    public TimeSlotServiceImpl() {
    }

    @Autowired
    public void setTimeSlotRepository(ITimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
    }

    @Override
    public TimeSlot getTimeSlotById(String id) {
        return timeSlotRepository.findById(id).get();
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @Override
    public void updateTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
    }

    @Override
    public void deleteTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.delete(timeSlot);
    }
}
