package com.laurenshup.superapi.time;

public class TimeValue {
	
	private TimeType type;
	private String value;
	
	public TimeValue(TimeType type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public TimeType getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}

}
