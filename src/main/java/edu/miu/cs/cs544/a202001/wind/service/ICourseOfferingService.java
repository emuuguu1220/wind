package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.CourseOffering;

import java.util.List;

public interface ICourseOfferingService {
    public abstract void addCourseOffering(CourseOffering courseOffering);
    public abstract CourseOffering getCourseOfferingById(Long id);
    public abstract List<CourseOffering> getAllCourseOfferings();
    public abstract void updateCourseOffering(CourseOffering courseOffering);
    public abstract void deleteCourseOffering(CourseOffering courseOffering);
}
