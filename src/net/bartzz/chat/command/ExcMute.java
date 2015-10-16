package net.bartzz.chat.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bartzz.chat.data.Mute;
import net.bartzz.chat.manager.MuteManager;
import net.bartzz.chat.util.ChatUtils;
import net.bartzz.chat.util.DateUtils;
import net.bartzz.chat.util.FormatUtils;

public class ExcMute implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		
		if (!sender.hasPermission("chatpro.mute")) {
			ChatUtils.sendMessage(sender, "&cBrak uprawnien.");
			return true;
		}
		
		if (args.length == 0 || args.length == 1) {
			ChatUtils.sendMessage(sender, "&cUzycie: &7/mute <nick> <czas>");
			return true;
		}
		
		if (args.length > 2) {
			ChatUtils.sendMessage(sender, "&cBledna ilosc argumentow!");
			return true;
		}
		
		if (args.length == 2) {
			
			Player player = Bukkit.getPlayer(args[0]);
			
			if (player == null) {
				ChatUtils.sendMessage(sender, "&cGracz o podanym nicku nie jest online.");
				return true;
			}
			
			if (!FormatUtils.isInt(args[1])) {
				ChatUtils.sendMessage(sender, "&cCZAS musi byc liczba!");
				return true;
			}
			
			if (player.hasPermission("chatpro.bypass")) {
				ChatUtils.sendMessage(sender, "&cGracz &6" + player.getName() + " &cjest niekaralny!");
				return true;
			}
			
			int arg = Integer.valueOf(args[1]);
			
			long time = System.currentTimeMillis() + (1000 * 60 * arg);
			
			String timeParsed = DateUtils.parseTimeHour(time);

			Mute mute = new Mute(player.getName(), time);
			
			MuteManager.getMutes().add(mute);
			
			ChatUtils.broadcast("&6* &c" + sender.getName() + " &7wyciszyl gracza: &c" + player.getName() + "&7. (&e" + arg + "min&7)");
			
			ChatUtils.sendMessage(sender, "&eWyciszyles gracza &a" + player.getName() + " &edo: &a" + timeParsed + ".");
			
			ChatUtils.sendMessage(player, "&eZostales wyciszony!");
			ChatUtils.sendMessage(player, "&eNadawca: &a" + sender.getName() + "&e, do: &a" + timeParsed + ".");
		}
		return false;
	}

}
