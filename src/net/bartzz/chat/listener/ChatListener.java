package net.bartzz.chat.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.bartzz.chat.Main;
import net.bartzz.chat.data.Mute;
import net.bartzz.chat.manager.ChatManager;
import net.bartzz.chat.manager.MuteManager;
import net.bartzz.chat.util.ChatUtils;
import net.bartzz.chat.util.DateUtils;

public class ChatListener implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		final Player player = event.getPlayer();
		
		Mute mute = MuteManager.getMute(player.getName());
		
		if (mute == null) {
			return;
		}
		
		if (System.currentTimeMillis() <= mute.getTime()) {
			
			long till = mute.getTime() - System.currentTimeMillis();
			
			String tillParsed = DateUtils.parseMinutes(till);
			
			event.setCancelled(true);
			
			ChatUtils.sendMessage(player, "&cZostales wyciszony! Bedziesz mogl pisac za &6" + tillParsed + " &cminut.");
			
			return;
		}
		
		if (!ChatManager.getInstance().getChatStatus()) {
			
			if (!player.hasPermission("chatpro.bypass")) {
				
				event.setCancelled(true);
				
				ChatUtils.sendMessage(player, "&cChat jest obecnie wylaczony!");
				
				return;
			}
		}
		
		for (String words : Main.getInstance().getConfig().getStringList("censorwords")) {
			
			if (event.getMessage().contains(words)) {
				
				event.setMessage(event.getMessage().replace(words, "***"));
				
				return;
			}
		}
	}
}
