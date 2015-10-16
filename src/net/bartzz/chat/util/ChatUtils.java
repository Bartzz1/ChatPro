package net.bartzz.chat.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import org.bukkit.ChatColor;

public class ChatUtils {
	
	public static String fixColor(String text) {
		
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static void sendHelp(CommandSender sender) {
		
		ChatUtils.sendMessage(sender, "&e=-=-=-=-=-=-=-=-=-=-=-=");
		ChatUtils.sendMessage(sender, "&e+ &a/chat toggle &8- &7Wlacza/wylacza chat.");
		ChatUtils.sendMessage(sender, "&e+ &a/chat clear &8- &7Czysci chat.");
		ChatUtils.sendMessage(sender, "&e=-=-=-=-=-=-=-=-=-=-=-=");
	}

	public static void sendMessage(CommandSender sender, String text) {
		
		if (text.isEmpty()) {
			return;
		}
		
		sender.sendMessage(fixColor(text));
	}
	
	public static void broadcast(String text) {
		
		if (text.isEmpty()) {
			return;
		}
		
		Bukkit.getOnlinePlayers().forEach(player -> sendMessage(player, text));
	}
	
	public static void broadcast(String text, String permission) {
		
		if (text.isEmpty() || permission.isEmpty()) {
			return;
		}
		
		Bukkit.getOnlinePlayers().stream().filter(player -> player.hasPermission(permission)).forEach(player -> sendMessage(player, text));
	}
}
