package edu.miu.cs.cs544.a202001.wind.controller;

import edu.miu.cs.cs544.a202001.wind.domain.CourseOffering;
import edu.miu.cs.cs544.a202001.wind.domain.Student;
import edu.miu.cs.cs544.a202001.wind.domain.User;
import edu.miu.cs.cs544.a202001.wind.service.ICourseOfferingService;
import edu.miu.cs.cs544.a202001.wind.service.ICourseService;
import edu.miu.cs.cs544.a202001.wind.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICourseOfferingService courseOfferingService;

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/student/{studentId}/courseOffering/{courseOfferingId}")
    public List<CourseOffering> addCourseOfferingToStudent(@PathVariable Long studentId, @PathVariable Long courseOfferingId) {
        return userService.addCourseOfferingToStudent(studentId, courseOfferingService.getCourseOfferingById(courseOfferingId));
    }

    @GetMapping(value = "/student/session/{sessionId}")
    public List<Student> getAttendedStudentPerSession(@PathVariable Long sessionId) {
        return userService.getAttendedStudentPerSession(sessionId);
    }



    @GetMapping(value = "/student/session/{sessionId}/percent")
    public Map<String, Object> getAttendedStudentPerSessionPerCent(@PathVariable Long sessionId) {
        return userService.getAttendedStudentPerSessionPerCent(sessionId);
    }
    @PostMapping(value = "/add")
    public void addUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        userService.addUser(user);
        response.sendRedirect("/users/");
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }


    public UserController() {
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
