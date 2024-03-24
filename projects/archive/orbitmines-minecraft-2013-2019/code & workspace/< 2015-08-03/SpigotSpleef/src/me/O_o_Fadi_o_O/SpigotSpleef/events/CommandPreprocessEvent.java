package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreprocessEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommand(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			String[] a = e.getMessage().split(" ");
			
			if(!Start.hasPermission(p, "bypass.commands", "bypass.*", "*")){
				if(sp.isInArena()){
					if(!StorageManager.whitelistedcommands.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						Message message = Message.getMessage(MessageName.COMMAND_IN_GAME);
						message.replace("&", "§");
						message.send(p);
					}
				}
			}
		}
	}
}
