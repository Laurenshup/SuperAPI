package com.laurenshup.superapi.time;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the base class for times.
 * 
 * @author Laurenshup
 */
public class Time {
	
	private List<Object> objects = new ArrayList<>();
	
	/**
	 * @param objects the time objects
	 */
	public Time(List<Object> objects) {
		this.objects = objects;
	}
	
	/**
	 * Gives the time string of the transformed time.
	 * 
	 * @return the time string
	 */
	public String getString() {
		String time = "";
		for(Object object : objects) {
			if(object instanceof String) {
				String text = (String) object;
				time+=text;
			} else {
				TimeValue value = (TimeValue) object;
				time+=value.getValue();
			}
		}
		return time;
	}
	
	/**
	 * Gives the time view that is used for this time.
	 * 
	 * @return the time view
	 */
	public TimeView getTimeView() {
		List<Object> objects = new ArrayList<>();
		for(Object object : this.objects) {
			if(object instanceof String) {
				String text = (String) object;
				objects.add(text);
			} else {
				TimeValue value = (TimeValue) object;
				objects.add(value.getType());
			}
		}
		TimeView view = new TimeView(objects);
		return view;
	}

}
