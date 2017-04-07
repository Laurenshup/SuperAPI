package com.laurenshup.superapi.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatter {
	
	public static String getValue(TimeType type) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("DDD/dd/EEEE/MMMM/HH/SSS/mm/MM/ss/EEE/MMM/ww/yyyy");
		String[] split = format.format(date).split("/");
		String value = null;
		switch(type) {
		case DAYS:
			value = split[0];
			break;
		case DAY_OF_MONTH:
			value = split[1];
			break;
		case FULLY_DAY:
			value = split[2];
			break;
		case FULLY_MONTH:
			value = split[3];
			break;
		case HOURS:
			value = split[4];
			break;
		case MILLISECONDS:
			value = split[5];
			break;
		case MINUTES:
			value = split[6];
			break;
		case MONTHS:
			value = String.valueOf(Integer.parseInt(split[7])+1);
			break;
		case SECONDS:
			value = split[8];
			break;
		case SHORT_DAY:
			value = split[9];
			break;
		case SHORT_MONTH:
			value = split[10];
			break;
		case WEEKS:
			value = split[11];
			break;
		case YEAR:
			value = split[12];
			break;
		}
		return value;
	}

}
