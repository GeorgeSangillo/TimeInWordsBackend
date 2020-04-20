package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Event;
import com.example.repository.EventRepo;

@Service
public class EventService {

	private EventRepo eventRepo;
	
	@Autowired
	public EventService(EventRepo eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	public Event newEvent(String name, String location, int month, int day, int year, int hour, int minute) {
		Date date = new Date();
		date.setMonth(month);
		date.setDate(day);
		date.setYear(year);
		date.setHours(hour);
		date.setMinutes(minute);
		return eventRepo.save(new Event(name, location, date));
	}
	
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}
	
    // Complete the timeInWords function below.
    public String timeInWords(int h, int m) {
        int min; // minutes to/past hour
        int hr; // hour
        String time = ""; // string of the time in words
        String hour = ""; // string of the hour in words
        String rel = ""; // string of whether minutes are to or past the hour

        // Used to get integer that shows how far from hour minutes are
        if (m<=30) {
            min = m;
            rel = " past ";
            hr = h;
        }
        else {
            min = 60 - m;
            rel = " to ";
            if (h < 12)
                hr = h + 1;
            else
                hr = 1;
        }

        // Used to get Word version of the hour
        switch(hr) {
            case 1: hour = "one";
                    break;
            case 2: hour = "two";
                    break;
            case 3: hour = "three";
                    break;
            case 4: hour = "four";
                    break;
            case 5: hour = "five";
                    break;
            case 6: hour = "six";
                    break;
            case 7: hour = "seven";
                    break;
            case 8: hour = "eight";
                    break;
            case 9: hour = "nine";
                    break;
            case 10: hour = "ten";
                     break;
            case 11: hour = "eleven";
                     break;
            case 12: hour = "twelve";
                     break;
        }

        // Used to get Word version of the minutes
        switch (min) {
            case 1: time += "one minute";
                    break;
            case 2: time += "two minutes";
                    break;
            case 3: time += "three minutes";
                    break;
            case 4: time += "four minutes";
                    break;
            case 5: time += "five minutes";
                    break;
            case 6: time += "six minutes";
                    break;
            case 7: time += "seven minutes";
                    break;
            case 8: time += "eight minutes";
                    break;
            case 9: time += "nine minutes";
                    break;
            case 10: time += "ten minutes";
                     break;
            case 11: time += "eleven minutes";
                     break;
            case 12: time += "twelve minutes";
                     break;
            case 13: time += "thirteen minutes";
                     break;
            case 14: time += "fourteen minutes";
                     break;
            case 15: time += "quarter";
                     break;
            case 16: time += "sixteen minutes";
                     break;
            case 17: time += "seventeen minutes";
                     break;
            case 18: time += "eighteen minutes";
                     break;
            case 19: time += "nineteen minutes";
                     break;
            case 20: time += "twenty minutes";
                     break;
            case 21: time += "twenty one minutes";
                     break;
            case 22: time += "twenty two minutes";
                     break;
            case 23: time += "twenty three minutes";
                     break;
            case 24: time += "twenty four minutes";
                     break;
            case 25: time += "twenty five minutes";
                     break;
            case 26: time += "twenty six minutes";
                     break;
            case 27: time += "twenty seven minutes";
                     break;
            case 28: time += "twenty eight minutes";
                     break;
            case 29: time += "twenty nine minutes";
                     break;
            case 30: time += "half";
                     break;
            default: return hour + " o' clock";
        }
        time += rel + hour;
        return time;
    }
}
