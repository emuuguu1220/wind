package edu.miu.cs.cs544.a202001.wind.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ATTENDANCE")
public class Attendance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
    @ManyToOne
    @JoinColumn(name="STUDENT_ID",nullable=false)
	private Student student;
    
    @ManyToOne
    @JoinColumn(name="TIME_SLOT_ID",nullable=false)
    private TimeSlot timeSlot;
    
	@ManyToOne
	@JoinColumn(name="LOCATION_ID",nullable=false)
	private Location location;
	
	private String barcode_id;
	
	public Attendance() {}
	public Attendance(Date date, Student student, TimeSlot timeSlot, Location location) {
		this.student = student;
		this.timeSlot = timeSlot;
		this.date = date;
		this.location = location;
		this.barcode_id = student.getBarcode();
		this.student.addAttendance(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getBarcode_id() {
		return barcode_id;
	}
	public void setBarcode_id(String barcode_id) {
		this.barcode_id = barcode_id;
	}
	
}
