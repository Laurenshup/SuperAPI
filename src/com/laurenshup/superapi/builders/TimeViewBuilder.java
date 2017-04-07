package com.laurenshup.superapi.builders;

import com.laurenshup.superapi.time.TimeType;
import com.laurenshup.superapi.time.TimeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Create your own time views with this handy builder.
 * 
 * @author Laurenshup
 */
public class TimeViewBuilder {
	
	private List<Object> objects = new ArrayList<>();
	
	/**
	 * Adds text to the builder
	 * 
	 * @param text the text to add to the builder
	 * @return the new instance of the builder
	 */
	public TimeViewBuilder addString(String text) {
		objects.add(text);
		return this;
	}
	
	/**
	 * Adds a time type to the builder
	 * A time type will be replaced with a time when transforming it.
	 * 
	 * @param type the type to add to the builder
	 * @return the new instance of the builder
	 */
	public TimeViewBuilder addType(TimeType type) {
		objects.add(type);
		return this;
	}
	
	/**
	 * Builds the time view
	 * 
	 * @return the builded time view
	 */
	public TimeView build() {
		TimeView view = new TimeView(objects);
		return view;
	}

}
