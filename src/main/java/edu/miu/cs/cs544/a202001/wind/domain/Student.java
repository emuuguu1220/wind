package edu.miu.cs.cs544.a202001.wind.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User{
	
    @Column(name="STUDENT_ID")
	private String studentId;
 
	private String barcode;
	
	@OneToMany(mappedBy="student")
	private List<Attendance> attendances = new ArrayList<Attendance>();
	
	public Student() {}
	public Student(String userName,String password, String firstName, String lastName, String email, String studentId, String barcode) {
		super(userName,password,firstName,lastName,email);
		this.studentId = studentId;
		this.barcode = barcode;
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
	
}
