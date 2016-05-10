package com.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="meeting_room")
@Entity
public class MeetingRoom 
{
	@Id
	@Column(name="ROOM_ID")
	private String roomId;
	
	@Column(name="ROOM_LOCATION")
	private String roomLocation;
	
	@Column(name="ROOM_SIZE")
	private String roomSize;

	public MeetingRoom(String roomId, String roomLocation, String roomSize) {
		super();
		this.roomId = roomId;
		this.roomLocation = roomLocation;
		this.roomSize = roomSize;
	}

	public MeetingRoom() {
		super();
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}
	
}
