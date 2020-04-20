package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="Time")
	private String time;
	
	public Event() {}

	public Event(String name, String location, String date, String time) {
		this.name = name;
		this.location = location;
		this.date = date;
		this.time = time;
	}

	public Event(int eventId, String name, String location, String date, String time) {
		this.eventId = eventId;
		this.name = name;
		this.location = location;
		this.date = date;
		this.time = time;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", name=" + name + ", location=" + location + ", date=" + date + ", time="
				+ time + "]";
	}
}
