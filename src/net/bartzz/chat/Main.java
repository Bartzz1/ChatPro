package net.bartzz.chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.bartzz.chat.command.ExcChat;
import net.bartzz.chat.command.ExcMute;
import net.bartzz.chat.listener.ChatListener;
import net.bartzz.chat.manager.ChatManager;
import net.bartzz.chat.task.AutoMessage;

@TODO(todoValue = { "Dodac system cooldown", "AntyCaps", "AntyFlood", "AutoMessage" })
public class Main extends JavaPlugin {
	
	private static Main inst;
	static Thread autoMsg;
	
	public void onLoad() { 
		inst = this;
	}
	
	public void onEnable() {
		
		saveDefaultConfig();
		
		autoMsg = new Thread(AutoMessage.getInstance());
		
		autoMsg.start();
		
		this.regCommands();
		this.regEvents();
		
		AutoMessage.getInstance().run();
		
		ChatManager.getInstance().setChatStatus(true);
	}
	
	private void regCommands() {
		
		this.getCommand("chat").setExecutor(new ExcChat());
		this.getCommand("mute").setExecutor(new ExcMute());
	}
	
	private void regEvents() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new ChatListener(), this);
	}
	
	public static Main getInstance() {
		
		return inst;
	}
}
