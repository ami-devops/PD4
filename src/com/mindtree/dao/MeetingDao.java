package com.mindtree.dao;

import java.util.List;

import com.mindtree.model.Employee;
import com.mindtree.model.Meeting;
import com.mindtree.model.MeetingRoom;

public interface MeetingDao 
{
	public abstract void addEmployee(Employee emp);
	public abstract List<Employee> getAllEmployees();
	public abstract List<MeetingRoom> getAllMeetingRooms();
	public abstract void addMeeting(Meeting meeting);
	public abstract List<Meeting> getMeetings(String startDate, String roomId);
	public abstract List<Meeting> getAllMeetings();
}
