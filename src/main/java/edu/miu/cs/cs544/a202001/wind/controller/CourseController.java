package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.Course;
import edu.miu.cs.cs544.a202001.wind.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private ICourseService courseService;

    @GetMapping(value = "/")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }


    @PostMapping(value = "/add")
    public void addCourse(@RequestBody Course course, HttpServletResponse response) throws IOException {
        courseService.addCourse(course);
        response.sendRedirect("/courses/");
    }

    @PutMapping(value = "/update")
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCourse(@RequestBody Course course) {
        courseService.deleteCourse(course);
    }


    public CourseController() {
    }

    public ICourseService getCourseService() {
        return courseService;
    }
    @Autowired
    public void setCourseService(ICourseService courseService) {
        this.courseService = courseService;
    }
}
