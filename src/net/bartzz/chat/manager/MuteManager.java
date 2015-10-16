package net.bartzz.chat.manager;

import java.util.ArrayList;
import java.util.Collection;

import net.bartzz.chat.data.Mute;

public class MuteManager {
	
	private static Collection<Mute> mutes = new ArrayList<Mute>();
	
	public static Collection<Mute> getMutes() {
		
		return mutes;
	}
	
	public static Mute getMute(String nick) {
		for (Mute mute : mutes) {
			if (mute.getNick().equalsIgnoreCase(nick)) {
				return mute;
			}
		}
		return null;
	}
	
	public static void removeMute(String nick) {
		Mute mute = getMute(nick);
		
		if (mute == null) {
			return;
		}
		
		mute.setTime(0);
		
		mutes.remove(mute);
	}
}
