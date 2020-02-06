package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.*;
import edu.miu.cs.cs544.a202001.wind.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl() {
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<Object> getAttendedStudentPerSession(Long sessionId)
    {
      return userRepository.getAttendedStudentPerSession(sessionId);
    }
    @Override
    public Double getAttendedStudentPerSessionPerCent(Long sessionId)
    {return userRepository.getAttendedStudentPerSessionPerCent(sessionId);}

    @Override
    public List<CourseOffering> addCourseOfferingToStudent(Long studentId, CourseOffering courseOffering) {
        Optional<User> user = userRepository.findById(studentId);
        Student student = (Student) user.get();
        student.addCourseOffering(courseOffering);
        courseOffering.addStudent(student);
        return student.getCourseOfferings();
    }


}
