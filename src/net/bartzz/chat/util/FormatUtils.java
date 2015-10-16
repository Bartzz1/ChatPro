package net.bartzz.chat.util;

public class FormatUtils {
	
	public static boolean isInt(String parsed) {
		try {
			Integer.parseInt(parsed);
			return true;
		}
		catch (NumberFormatException exception) {
			return false;
		}
	}
}
