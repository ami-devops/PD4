package com.mindtree.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.model.Employee;
import com.mindtree.model.Meeting;
import com.mindtree.model.MeetingRoom;
import com.mindtree.serviceImpl.ManagementSystemServiceImpl;

/*
 * This spring controller interacts with JSP page and service layer.
 */
@Controller
public class MeetingController 
{
	@Autowired
	ManagementSystemServiceImpl service;
	
	/*
	 * Getting Emp and MeetingRoom info from the database
	 */
	@RequestMapping(value="/GetMeetingInfo",method=RequestMethod.GET)
	public String sendEmpPage(Model model, HttpServletRequest request)
	{	
	   	HttpSession session = request.getSession();
	   
	   	List<Employee> employees = service.getAllEmployees();
		session.setAttribute("employees", employees);
		//Get Meeting rooms and store
		List<MeetingRoom> meetingRooms = service.getAllMeetingRooms();
		session.setAttribute("meetingRooms", meetingRooms);
		
		Employee tempEmp = employees.get(0);
		MeetingRoom tempRoom = meetingRooms.get(0);
		session.setAttribute("tempEmp", tempEmp);
		session.setAttribute("tempRoom", tempRoom);
		
		int flag = 0;
		session.setAttribute("flag", flag);

		model.addAttribute("meeting", new Meeting());
		return "ScheduleMeeting";
	}
	
	/*
	 * Use following method thru Ajax to display info for selected meeting-room and employee
	 */
	@RequestMapping(value="/ScheduleMeetingController", method=RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	   HttpSession session = request.getSession();
	   List<Employee> employees = (List<Employee>) session.getAttribute("employees");
	   List<MeetingRoom> meetingRooms = (List<MeetingRoom>) session.getAttribute("meetingRooms");
	   MeetingRoom tempRoom = new MeetingRoom();
	   Employee tempEmp = new Employee();
	   String roomId = (String)request.getParameter("meetingRoomSelect");
	   String empId = (String)request.getParameter("employeeSelect");
		
		for (MeetingRoom m:meetingRooms)
		{
			if(m.getRoomId().equals(roomId))
			{
				tempRoom = m;
				
			}
		}
		
		for(Employee e:employees)
		{
			if (e.getEmpId().equals(empId))
			{
				tempEmp = e;
				
			}
		}
		
		response.getWriter().print("<output class='info' id='roomDetails'>Room Details:</output><br>");
		response.getWriter().print("<output class='info' id='location'>Location: " + tempRoom.getRoomLocation() + "</output><br>");
		response.getWriter().print("<output id='seats' class='info'>#Seats: " + tempRoom.getRoomSize() + "</output><br>");
		response.getWriter().print("<div id='empArea'>");
		response.getWriter().print("<output id='empDetails' class='info'>Employee Details:</output><br>");
		response.getWriter().print("<output id='empName' class='info'>Name: " + tempEmp.getFirstName() + " " + tempEmp.getLastName() + "</output><br>");
		response.getWriter().print("<output id='empEmail' class='info'>Email: " + tempEmp.getEmail() + "</output>");
		response.getWriter().print("</div>");
		          
	}

	/*
	 * This method gets parameters from JSP page and then add it to the meeting table of the database.
	 */
	@RequestMapping(value="/addMeeting", method=RequestMethod.GET)
	public String addMeeting(@ModelAttribute("meeting")Meeting meeting, Model model, 
			HttpServletRequest request, HttpServletResponse response)
	{
	   
		HttpSession session = request.getSession();
		
		List<Employee> employees = (List<Employee>) session.getAttribute("employees");
		List<MeetingRoom> meetingRooms = (List<MeetingRoom>) session.getAttribute("meetingRooms");
		List<Meeting> meetings = (List<Meeting>)service.getAllMeetings();
		
		String subject = request.getParameter("subject");
		String startDate = request.getParameter("startDate");
		String startTime = request.getParameter("startTime");
		String endDate = request.getParameter("endDate");
		String endTime = request.getParameter("endTime");
		String roomSelect = request.getParameter("meetingRoomSelect");
		String employeeSelect = request.getParameter("employeeSelect");
		
		MeetingRoom meetingRoom = new MeetingRoom();
		Employee employee = new Employee();
		
		for (Employee e: employees)
		{
			if (e.getEmpId().compareTo(employeeSelect) == 0)
			{
				employee = e;
			}
		}
		
		for (MeetingRoom m: meetingRooms)
		{
			if (m.getRoomId().compareTo(roomSelect) == 0)
			{
				meetingRoom = m;
			}
		}
		
		Meeting meetingStore = new Meeting(subject, startDate, startTime, endDate, endTime, meetingRoom, employee);
		
		for (Meeting m:meetings)
		{
			if (m.getSubject().equalsIgnoreCase(meetingStore.getSubject()))
			{
				return "InvalidTopic";
			}
			
		}
		
		service.addMeeting(meetingStore);
		
		int flag = 1;
		session.setAttribute("flag", flag);
	   
	   return "index"; 
	}
   	
	/*
	 * Show meeting details based upon valid startDate and roomId
	 */
   @RequestMapping(value="/viewMeetingDetails", method=RequestMethod.POST)
   public String getMeetingDetails(Model model, HttpServletRequest request,HttpServletResponse response )
   {	HttpSession session = request.getSession();
		
		String startDate = request.getParameter("startDate");
		String roomId = request.getParameter("roomId");
		
		List<Meeting> meetings = service.getMeeting(startDate, roomId);
		if (meetings.size() < 1)
		{
			return "InvalidSearch";
		}
		session.setAttribute("meetings", meetings);
		return "ShowMeetingDetails";
   }
}
