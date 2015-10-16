package net.bartzz.chat.task;

import org.bukkit.configuration.file.FileConfiguration;

import net.bartzz.chat.Main;
import net.bartzz.chat.util.ChatUtils;

public class AutoMessage implements Runnable {

	private static AutoMessage inst;
	private static FileConfiguration config = Main.getInstance().getConfig();
	
	static int time = config.getInt("msg-delay") * 20 * 60;
	
	public AutoMessage() {
		
		inst = this;
	}
	
	public static AutoMessage getInstance() {
		
		if (inst != null) return inst;
		return new AutoMessage();
	}

	@Override
	public void run() {
		
		for (String messages : config.getStringList("messages")) {
			
			ChatUtils.broadcast(messages);
			
			try {
				Thread.sleep(time * 1000 * 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
