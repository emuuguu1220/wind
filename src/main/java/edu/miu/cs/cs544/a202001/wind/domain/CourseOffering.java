package edu.miu.cs.cs544.a202001.wind.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

@Entity
@Data
@Table(name="COURSE_OFFERING")
public class CourseOffering {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate; 
	
	@ManyToOne
	@Valid
	@JoinColumn(name="course_id",nullable=false)
	private Course course;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="courseOffering",fetch=FetchType.EAGER)
	private List<Session> sessions = new ArrayList<Session>();
	@JsonIgnore
	@ManyToMany(mappedBy="courseOfferings")
	List<Student> students = new ArrayList<Student>();
	
	public CourseOffering() {}
	public CourseOffering(Date startDate, Date endDate, Course course) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
	}
	public void addStudent(Student student) {
		students.add(student);
//		student.addCourseOffering(this);
	}
	public void removeStudent(Student student) {
		students.remove(student);
//		student.removeCourseOffering(this);
	}
	public void addSession(Session session) {
		sessions.add(session);
		session.setCourseOffering(this);
	}
	public void removeSession(Session session) {
		sessions.remove(session);
		session.setCourseOffering(null);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public List<Student> getStudents() {
		return students;
	}
}
