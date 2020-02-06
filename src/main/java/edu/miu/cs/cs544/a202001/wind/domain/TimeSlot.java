package edu.miu.cs.cs544.a202001.wind.domain;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TIMESLOT")
public class TimeSlot {
	@Id
	@Length(max = 3)
	private String abbrevation;
	
	@Lob
	private String description;
	
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	public TimeSlot() {}
	public TimeSlot(String abbrevation, String description, Date startTime, Date endTime) {
		this.abbrevation = abbrevation;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
