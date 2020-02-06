package edu.miu.cs.cs544.a202001.wind.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User{

	@Pattern(regexp = "\\d+", message = "Invalid Student ID")
    @Column(name="STUDENT_ID", unique = true)
	private String studentId;

	@Pattern(regexp = "\\d+", message = "Invalid Barcode Number")
	@Column(name = "BARCODE_ID", unique = true)
	private String barcode;
	
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	private List<Attendance> attendances = new ArrayList<Attendance>();
	
	@ManyToMany
	@JoinTable(name= "Student_CourseOffer",
	   joinColumns = {@JoinColumn(name="STUDENT_ID")},
	   inverseJoinColumns = {@JoinColumn(name="COURSE_OFFERING_ID")}
	)
	private List<CourseOffering> courseOfferings = new ArrayList<CourseOffering>();
	
	public Student() {}
	public Student(String userName,String password, String firstName, String lastName, String email, String studentId, String barcode) {
		super(userName,password,firstName,lastName,email);
		this.studentId = studentId;
		this.barcode = barcode;
	}
	public void addCourseOffering(CourseOffering co) {
		this.courseOfferings.add(co);
	}
	public void removeCourseOffering(CourseOffering co) {
		this.courseOfferings.remove(co);
	}
	public void addAttendance(Attendance attendance) {
		attendances.add(attendance);
		attendance.setStudent(this);
	}

	public void removeAttendance(Attendance attendance) {
		attendances.remove(attendance);
		attendance.setStudent(null);
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public List<Attendance> getAttendances() {
		return attendances;
	}
	public List<CourseOffering> getCourseOfferings() {
		return courseOfferings;
	}
}
