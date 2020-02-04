package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Course;

import java.util.List;

public interface ICourseService {
    public abstract void addCourse(Course course);
    public abstract Course getCourseById(Long id);
    public abstract List<Course> getAllCourses();
    public abstract void updateCourse(Course course);
    public abstract void deleteCourse(Course course);
}
