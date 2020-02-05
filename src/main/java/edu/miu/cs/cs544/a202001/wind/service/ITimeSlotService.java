package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.TimeSlot;

import java.util.List;

public interface ITimeSlotService {
    public abstract void addTimeSlot(TimeSlot timeSlot);
    public abstract TimeSlot getTimeSlotById(String abbrevation);
    public abstract List<TimeSlot> getAllTimeSlots();
    public abstract void updateTimeSlot(TimeSlot timeSlot);
    public abstract void deleteTimeSlot(TimeSlot timeSlot);
}
