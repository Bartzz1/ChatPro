package net.bartzz.chat.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	@SuppressWarnings("unused")
	public static long parseStringToTime(int num, String key) {
		
		switch (key) {
			
		case "sec":
			
			long sec = num * 1000;
		
		case "min":
			
			long min = num * 1000 * 60;
		
		case "h":
			
			long h = num * 1000 * 60 * 60;
		}
		
		return 0;
	}
	
	public static String parseTimeHour(long time) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss", Locale.GERMANY);
		Date d = new Date(time);
		return format.format(d);
	}
	
	public static String parseMinutes(long time) {
		SimpleDateFormat format = new SimpleDateFormat("mm:ss", Locale.GERMANY);
		Date date = new Date(time);
		return format.format(date);
	}
}
