package net.bartzz.chat.data;

public class Mute {
	
	private String	nick;
	private long 	time;
	
	public Mute(String nick, long time) {
		
		this.nick = nick;
		this.time = time;
	}

	public String getNick() {
		return nick;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
}
