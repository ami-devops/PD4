package com.mindtree.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.MeetingDao;
import com.mindtree.daoImpl.MeetingDaoImpl;
import com.mindtree.model.Employee;
import com.mindtree.model.Meeting;
import com.mindtree.model.MeetingRoom;
import com.mindtree.service.ManagementSystemService;
import com.mindtree.util.JPAUtil;

@Service(value="service")
public class ManagementSystemServiceImpl implements ManagementSystemService 
{

	MeetingDao dao = new MeetingDaoImpl();
	
	public ManagementSystemServiceImpl(){}
	
	public MeetingDao getDao() {
		return dao;
	}

	@Override
	public void setDao(MeetingDaoImpl dao) 
	{
		this.dao = dao;	
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.serviceImpl.ManagementSystemService#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees()
	{
		return dao.getAllEmployees();
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.serviceImpl.ManagementSystemService#getAllMeetingRooms()
	 */
	@Override
	public List<MeetingRoom> getAllMeetingRooms()
	{
		return dao.getAllMeetingRooms();
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.serviceImpl.ManagementSystemService#getMeeting(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Meeting> getMeeting(String startDate, String roomId)
	{
		return dao.getMeetings(startDate, roomId);
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.serviceImpl.ManagementSystemService#addMeeting(com.mindtree.model.Meeting)
	 */
	@Override
	public void addMeeting(Meeting meeting)
	{
		dao.addMeeting(meeting);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mindtree.service.ManagementSystemService#getMeetingsAll()
	 */
	@Override
	public List<Meeting> getAllMeetings()
	{
		return dao.getAllMeetings();
	}

	
}
