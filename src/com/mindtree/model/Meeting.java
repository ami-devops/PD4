package com.mindtree.model;

import java.io.Serializable;

import javax.persistence.*;
import com.mindtree.model.*;

@Entity
@Table(name="Meeting")
public class Meeting implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int meetingId;
	
	@Column(name="subject")

	private String subject;

	@Column(name="startDate")
	private String startDate;

	@Column(name="startTime")
	private String startTime;
	
	@Column(name="endDate")
	private String endDate;
	
	@Column(name="endTime")
	private String endTime;

	@OneToOne
	@JoinColumn(name="ROOM_ID")
	private MeetingRoom meetingRoom;
	
	@OneToOne
	@JoinColumn(name="EMP_MID")
	private Employee employee;

	public Meeting(String subject, String startDate, String startTime, String endDate, String endTime,
			MeetingRoom meetingRoom, Employee employee) {
		super();
		this.subject = subject;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.meetingRoom = meetingRoom;
		this.employee = employee;
	}

	public Meeting()
	{
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
}
