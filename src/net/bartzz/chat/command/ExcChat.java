package net.bartzz.chat.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bartzz.chat.manager.ChatManager;
import net.bartzz.chat.util.ChatUtils;

public class ExcChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		
		if (!sender.hasPermission("chatpro.help")) {
			ChatUtils.sendMessage(sender, "&cBrak uprawnien.");
			return true;
		}
		
		if  (!(sender instanceof Player)) {
			ChatUtils.sendMessage(sender, "&cDo uzycia tej komendy musisz byc graczem.");
			return true;
		}
		
		if (args.length == 0) {
			
			ChatUtils.sendHelp(sender);
		}
		
		else if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("toggle")) {
				
				if (!sender.hasPermission("chatpro.toggle")) {
					ChatUtils.sendMessage(sender, "&cBrak uprawnien.");
					return true;
				}
				
				ChatManager.getInstance().toggle();
				
				ChatUtils.sendMessage(sender, "&eStatus chatu: &a" + (ChatManager.getInstance().getChatStatus() ? "wlaczony" : "wylaczony") + ".");
			}
			
			else if (args[0].equalsIgnoreCase("clear")) {
				
				if (!sender.hasPermission("chatpro.clear")) {
					ChatUtils.sendMessage(sender, "&cBrak uprawnien.");
					return true;
				}
				
				ChatManager.getInstance().clear();
				
				ChatUtils.broadcast("&eChat zostal wyczyszczony przez &a" + sender.getName() + "&e.");
			}
			
			else {
				
				ChatUtils.sendHelp(sender);
			}
		}
		return false;
	}

}
