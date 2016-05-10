package com.mindtree.service;

import java.util.List;

import com.mindtree.dao.MeetingDao;
import com.mindtree.daoImpl.MeetingDaoImpl;
import com.mindtree.model.Employee;
import com.mindtree.model.Meeting;
import com.mindtree.model.MeetingRoom;

public interface ManagementSystemService {

	//public abstract void addEmployee(Employee emp);

	public abstract List<Employee> getAllEmployees();

	public abstract List<MeetingRoom> getAllMeetingRooms();

	public abstract List<Meeting> getMeeting(String startDate, String roomId);

	public abstract void addMeeting(Meeting meeting);

	public abstract MeetingDao getDao();

	public abstract void setDao(MeetingDaoImpl dao);

	public abstract List<Meeting> getAllMeetings();
}