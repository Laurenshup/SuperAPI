package com.laurenshup.superapi;

import com.laurenshup.superapi.time.*;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * This is your SuperAPI's TimeManager.
 * 
 * @author Laurenshup
 */
public class TimeManager {
	
	@SuppressWarnings("unused")
	private Plugin plugin;
	
	protected TimeManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Gives you a time instance of the currenttime with the given timeview.
	 * 
	 * @param view the timeview to use
	 * @return the current time with the given timeview
	 */
	public Time getCurrentTime(TimeView view) {
		List<Object> objects = new ArrayList<>();
		for(Object object : view.getClearTime()) {
			if(object instanceof String) {
				objects.add(object);
			} else {
				TimeType type = (TimeType) object;
				String value = TimeFormatter.getValue(type);
				TimeValue timevalue = new TimeValue(type, value);
				objects.add(timevalue);
			}
		}
		Time time = new Time(objects);
		return time;
	}

}
