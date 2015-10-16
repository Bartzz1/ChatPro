package net.bartzz.chat.manager;

import net.bartzz.chat.util.ChatUtils;

public class ChatManager {
	
	private static ChatManager inst;
	
	private boolean	chatStatus;

	public void toggle() {
		
		if (chatStatus) {
			
			chatStatus = false;
		}
		else {
			
			chatStatus = true;
		}
	}
	
	public void clear() {
		
		for (int i = 0; i < 101; i++) {
			
			ChatUtils.broadcast(" ");
		}
	}
	
	public boolean getChatStatus() {
		return chatStatus;
	}
	
	public void setChatStatus(boolean status) {
		this.chatStatus = status;
	}
	
	public static ChatManager getInstance() {
		
		if (inst != null) return inst;
		return new ChatManager();
	}
}
