package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Event;
import com.example.service.EventService;

@RestController
@RequestMapping("/eventapi")
@CrossOrigin(origins="*")
public class EventController {

	private EventService eventServ;
	
	@Autowired
	public EventController(EventService eventServ) {
		this.eventServ = eventServ;
	}
	
	@GetMapping("/{time}")
	public String[] findTimeInWords(@PathVariable("time") String time) {
		System.out.println("in findTimeInWords(): " + time);
		String[] timeArr = time.split(":");
		int h = Integer.parseInt(timeArr[0]);
		int m = Integer.parseInt(timeArr[1]);
		String[] output = new String[1];
		output[0] = eventServ.timeInWords(h, m);
		return output;
	}
	
	@PostMapping("/newEvent")
	public Event createNewEvent(@RequestBody Map<String, String> reqBody) {
		return eventServ.newEvent(reqBody.get("name"), reqBody.get("location"), Integer.parseInt(reqBody.get("month")), Integer.parseInt(reqBody.get("day")), Integer.parseInt(reqBody.get("year")), Integer.parseInt(reqBody.get("hour")), Integer.parseInt(reqBody.get("minute")));
	}
	
	@GetMapping("/allEvents")
	public Object[] getAllEvents() {
		System.out.println("in getAllEvents()");
		Object[] resBody = new Object[2];
		List<Event> eventList = eventServ.getAllEvents();
		List<String> timeList = new ArrayList<>();
		for (Event event: eventList) {
			int hours = ((event.getDate().getHours() - 1) % 12 + 1);
			timeList.add(eventServ.timeInWords(hours, event.getDate().getMinutes()));
		}
		resBody[0] = eventList;
		resBody[1] = timeList;
		return resBody;
	}
}
