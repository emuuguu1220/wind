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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
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
	IAttendanceRepository atRepository;
	@Autowired
	ICourseOfferingRepository coRepo;
	@Autowired
	ISessionRepository sessionRepo;
	
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
		BCryptPasswordEncoder BCryptPasswordEncoder = new BCryptPasswordEncoder();
		Student student = new Student("student",BCryptPasswordEncoder.encode("123"),"Munkh-Erdene","Tolya","metolya@miu.edu","610231","123128312370");
		Student student2 = new Student("student2",BCryptPasswordEncoder.encode("123"),"oussama","Jablaoui","metoleya@miu.edu","610211","123148312370");
		Student student3 = new Student("student2",BCryptPasswordEncoder.encode("123"),"oussama","Jablaoui","metoleyea@miu.edu","610411","123148112370");

		userRepository.save(student);
		userRepository.save(student2);
		userRepository.save(new Admin("admin",BCryptPasswordEncoder.encode("123"),"Admin","Admin","admin@miu.edu"));
		userRepository.save(new Faculty("faculty",BCryptPasswordEncoder.encode("123"),"Gregory","Guthrie","gguthrie@miu.edu"));
		
		/*Independent table*/
		TimeSlot timeSlot1 = new TimeSlot("AM","before midday",timeFormat.parse("00:00:00"),timeFormat.parse("12:00:00"));
		TimeSlot timeSlot2 = new TimeSlot("PM","after midday",timeFormat.parse("12:00:01"),timeFormat.parse("23:59:59"));
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
		Session session1= new Session(dateFormat.parse("11/01/2020"),timeSlot1);
		CourseOffering co = new CourseOffering(startDate,endDate,course1);
		co.addSession(session1 );
		session1.setCourseOffering(co);
		co.addSession(new Session(dateFormat.parse("12/01/2020"),timeSlot1));
		co.addStudent(student);
		co.addStudent(student2);
		coRepo.save(co);
		sessionRepo.save(session1);
		/*Student signing for course*/
		student.addCourseOffering(co);
		student2.addCourseOffering(co);
		userRepository.save(student);
		userRepository.save(student2);
//		Student user = (Student) userRepository.findById((long) 1).orElse(null);

    }

}
