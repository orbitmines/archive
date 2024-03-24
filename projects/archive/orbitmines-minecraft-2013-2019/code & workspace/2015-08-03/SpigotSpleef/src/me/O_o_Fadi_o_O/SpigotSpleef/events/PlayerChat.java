package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener{

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			if(sp.isInArena()){
				if(StorageManager.useperarenachat == false){
					e.setFormat(Message.getMessage(MessageName.CHAT_PREFIX_IF_NOR_PER_ARENA).getMessage().replace("&", "§").replace("%arena-id%", "" + sp.getArena().getArenaID()) + "§r" + e.getFormat());
				}
				else{
					e.setCancelled(true);
					for(SpleefPlayer sps : sp.getArena().getPlayers()){
						sps.getPlayer().sendMessage(String.format(e.getFormat(), p.getDisplayName(), e.getMessage()));
					}
				}
			}
			else{
				if(StorageManager.useperarenachat == false){
					e.setFormat(Message.getMessage(MessageName.LOBBY_CHAT_PREFIX_IF_NOT_PER_ARENA).getMessage().replace("&", "§") + "§r"  + e.getFormat());
				}
				else{
					e.setCancelled(true);
					for(Player player : Bukkit.getOnlinePlayers()){
						if(StorageManager.spleefplayer.containsKey(player)){
							SpleefPlayer sps = StorageManager.spleefplayer.get(player);
							if(!sps.isInArena()){
								player.sendMessage(String.format(e.getFormat(), p.getDisplayName(), e.getMessage()));
							}
						}
					}
				}
			}
		}
	}
}
