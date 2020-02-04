package edu.miu.cs.cs544.a202001.wind.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User{
	
    @Column(name="STUDENT_ID")
	private String studentId;
    
    @Column(name = "BARCODE_ID", unique = true)
	private String barcode;
	
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	private List<Attendance> attendances = new ArrayList<Attendance>();
	
	public Student() {}
	public Student(String userName,String password, String firstName, String lastName, String email, String studentId, String barcode) {
		super(userName,password,firstName,lastName,email);
		this.studentId = studentId;
		this.barcode = barcode;
	}
	public void addAttendance(Attendance attendance) {
		attendances.add(attendance);
	}
	public void removeAttendance(Attendance attendance) {
		attendances.remove(attendance);
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
	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}
	
}
