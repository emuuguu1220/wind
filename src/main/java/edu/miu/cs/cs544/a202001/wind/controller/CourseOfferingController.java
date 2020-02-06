package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.CourseOffering;
import edu.miu.cs.cs544.a202001.wind.service.ICourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/courseOfferings")
public class CourseOfferingController {

    private ICourseOfferingService courseOfferingService;

    @GetMapping(value = "/")
    public List<CourseOffering> getAllCourseOfferings() {
        return courseOfferingService.getAllCourseOfferings();
    }

    @GetMapping(value = "/{id}")
    public CourseOffering getCourseOffering(@PathVariable Long id) {
        return courseOfferingService.getCourseOfferingById(id);
    }


    @PostMapping(value = "/add")
    public void addCourseOffering(@RequestBody CourseOffering courseOffering, HttpServletResponse response) throws IOException {
        courseOfferingService.addCourseOffering(courseOffering);
        response.sendRedirect("/courseOfferings/");
    }

    @PutMapping(value = "/update")
    public void updateCourseOffering(@RequestBody CourseOffering courseOffering) {
        courseOfferingService.updateCourseOffering(courseOffering);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCourseOffering(@RequestBody CourseOffering courseOffering) {
        courseOfferingService.deleteCourseOffering(courseOffering);
    }


    public CourseOfferingController() {
    }

    public ICourseOfferingService getCourseOfferingService() {
        return courseOfferingService;
    }
    @Autowired
    public void setCourseOfferingService(ICourseOfferingService courseOfferingService) {
        this.courseOfferingService = courseOfferingService;
    }
}
