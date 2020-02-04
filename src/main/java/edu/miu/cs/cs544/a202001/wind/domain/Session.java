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
@Table(name="SESSION")
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="COURSE_OFFER_ID",nullable=false)
	private CourseOffering courseOffering;
	
	@ManyToOne
	@JoinColumn(name="TIME_SLOT_ID",nullable=false)
	private TimeSlot timeSlot;
	
	public Session() {}
	public Session(Date date,TimeSlot timeSlot) {
		this.date = date;
		this.timeSlot = timeSlot;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CourseOffering getCourseOffering() {
		return courseOffering;
	}
	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	
}
