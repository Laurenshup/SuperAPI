package com.laurenshup.superapi.message;

/**
 * This is the class for a click event.
 * 
 * @author Laurenshup
 */
public class ClickEvent {
	
	private ClickEventType type;
	private String location;
	
	/**
	 * The location is used in links, files etc..
	 * 
	 * @param type the click event type
	 * @param location the click event location
	 */
	public ClickEvent(ClickEventType type, String location) {
		this.type = type;
		this.location = location;
	}
	
	/**
	 * Gives the click event type.
	 * 
	 * @return the click event type
	 */
	public ClickEventType getType() {
		return type;
	}
	
	/**
	 * Gives the location of the click event.
	 * The location is used in links, files etc..
	 * 
	 * @return the click event location
	 */
	public String getLocation() {
		return location;
	}

}
