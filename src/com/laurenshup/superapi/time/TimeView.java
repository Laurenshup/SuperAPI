package com.laurenshup.superapi.time;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the base class for a time view.
 * 
 * @author Laurenshup
 */
public class TimeView {
	
	private List<Object> objects = new ArrayList<>();
	
	/**
	 * @param objects the objects for time view
	 */
	public TimeView(List<Object> objects) {
		this.objects = objects;
	}
	
	/**
	 * Gets a list of the objects.
	 * 
	 * @return the list of the objects
	 */
	public List<Object> getClearTime() {
		return objects;
	}

}
