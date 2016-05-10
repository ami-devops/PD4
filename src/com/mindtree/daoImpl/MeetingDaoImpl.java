package com.mindtree.daoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.MeetingDao;
import com.mindtree.model.Employee;
import com.mindtree.model.Meeting;
import com.mindtree.model.MeetingRoom;
import com.mindtree.util.JPAUtil;
import com.mindtree.util.SessionFactoryUtil;

@Repository
public class MeetingDaoImpl implements MeetingDao {
	
	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	private HibernateTemplate getHibernateTemplate(){
		return SessionFactoryUtil.getHibernateTemplate();
	}
	

	/* (non-Javadoc)
	 * @see com.mindtree.daoImpl.MeetingRoomDao#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees()
	{
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT e FROM Employee e");
	    return (ArrayList<Employee>) query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.daoImpl.MeetingRoomDao#getAllMeetingRooms()
	 */
	@Override
	public List<MeetingRoom> getAllMeetingRooms()
	{
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT mr FROM MeetingRoom mr");
	   return (ArrayList<MeetingRoom>) query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.daoImpl.MeetingRoomDao#addMeeting(com.mindtree.model.Meeting)
	 */
	@Override
	public void addMeeting(Meeting meeting)
	{
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(meeting);
		
		em.getTransaction().commit();
		em.close();
	}
	
	/* (non-Javadoc)
	 * @see com.mindtree.daoImpl.MeetingRoomDao#getMeetings(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Meeting> getMeetings(String startDate, String roomId)
	{
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT m FROM Meeting m where m.startDate='" + startDate + "' and m.meetingRoom.roomId='" + roomId + "'");
	   return (ArrayList<Meeting>) query.getResultList();	
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mindtree.dao.MeetingDao#getAllMeetings()
	 */
	
	public List<Meeting> getAllMeetings()
	{
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT m FROM Meeting m");
	   return (ArrayList<Meeting>) query.getResultList();	
	}
}
