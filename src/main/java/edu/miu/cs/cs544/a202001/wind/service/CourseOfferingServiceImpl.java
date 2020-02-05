package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.CourseOffering;
import edu.miu.cs.cs544.a202001.wind.repository.ICourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseOfferingServiceImpl implements ICourseOfferingService {

    private ICourseOfferingRepository courseOfferingRepository;

    public CourseOfferingServiceImpl(ICourseOfferingRepository courseOfferingRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
    }

    public CourseOfferingServiceImpl() {
    }

    @Autowired
    public void setCourseOfferingRepository(ICourseOfferingRepository courseOfferingRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
    }

    @Override
    public void addCourseOffering(CourseOffering courseOffering) {
        courseOfferingRepository.save(courseOffering);
    }

    @Override
    public CourseOffering getCourseOfferingById(Long id) {
        return courseOfferingRepository.findById(id).get();
    }

    @Override
    public List<CourseOffering> getAllCourseOfferings() {
        return courseOfferingRepository.findAll();
    }

    @Override
    public void updateCourseOffering(CourseOffering courseOffering) {
        courseOfferingRepository.save(courseOffering);
    }

    @Override
    public void deleteCourseOffering(CourseOffering courseOffering) {
        courseOfferingRepository.delete(courseOffering);
    }
}
