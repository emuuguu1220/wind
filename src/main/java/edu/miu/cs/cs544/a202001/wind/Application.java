package edu.miu.cs.cs544.a202001.wind;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.miu.cs.cs544.a202001.wind.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs544.a202001.wind.domain.Admin;
import edu.miu.cs.cs544.a202001.wind.domain.Attendance;
import edu.miu.cs.cs544.a202001.wind.domain.Course;
import edu.miu.cs.cs544.a202001.wind.domain.CourseOffering;
import edu.miu.cs.cs544.a202001.wind.domain.Faculty;
import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.domain.Session;
import edu.miu.cs.cs544.a202001.wind.domain.Student;
import edu.miu.cs.cs544.a202001.wind.domain.TimeSlot;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	ILocationRepository locationRepository;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	ITimeSlotRepository tsRepository;
	@Autowired
	IAttendanceRepo atRepository;
	@Autowired
	ICourseOfferRepo coRepo;
	@Autowired 
	ISessionRepo sessionRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
    public void run(String... args) throws Exception 
    {   
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");  
		
		/*Independent table*/
		Course course1 = new Course("cs544", "Enterprise architecture","Description of Enterprise architecture");
		Course course2 = new Course("cs545", "Software Development","Description of Software Development");
		courseRepository.save(course1);
		courseRepository.save(course2);
		
		/*Independent table*/
		Location location = new Location("Verrill Hall");
		locationRepository.save(location);
		locationRepository.save(new Location("Dalby Hall"));
		
		/*Independent table*/
		Student student = new Student("student","pass","Munkh-Erdene","Tolya","metolya@miu.edu","610231","123128312370");
		userRepository.save(student);
		userRepository.save(new Admin("admin","pass","Adminname","Adminpass","admin@miu.edu"));
		userRepository.save(new Faculty("faculty","pass","Gregory","Guthrie","gguthrie@miu.edu"));
		
		/*Independent table*/
		TimeSlot timeSlot1 = new TimeSlot("AM","before midday",timeFormat.parse("08:30:00"),timeFormat.parse("09:00:00"));
		TimeSlot timeSlot2 = new TimeSlot("PM","after midday",timeFormat.parse("17:30:00"),timeFormat.parse("18:30:00"));
		tsRepository.save(timeSlot1);
		tsRepository.save(timeSlot2);
		
		/*Relation tables*/
		Attendance att1 = new Attendance(new Date(),student,timeSlot2,location);
		Attendance att2 = new Attendance(new Date(),student,timeSlot2,location);
		atRepository.save(att1);
		atRepository.save(att2);
		
		Date startDate = dateFormat.parse("11/01/2020");
		Date endDate = dateFormat.parse("07/02/2020");
		/*Relation tables*/
		CourseOffering co = new CourseOffering(startDate,endDate,course1);
		co.addSession(new Session(dateFormat.parse("11/01/2020"),timeSlot1));
		co.addSession(new Session(dateFormat.parse("12/01/2020"),timeSlot1));
		coRepo.save(co);
		
		
    }
}
