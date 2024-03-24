package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.DisguisePlayer;
import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Prison.managers.NPCManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Pet;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class QuitEvent implements Listener {

	Start start = Start.getInstance();
	NPCManager npcmanager = new NPCManager();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		
		e.setQuitMessage(null);
		
		p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		
		npcmanager.unloadNPCs(p);
		
		try{
			
			//DatabaseManager.setFireworksPasses(p, StorageManager.fireworkpasses.get(p));
			
			if(StorageManager.pet.get(p) != Pet.NONE){
				
				Entity en = StorageManager.petentity.get(p);
				if(en instanceof LivingEntity){
					StorageManager.petentity.remove(p);
					StorageManager.petowner.remove(en);
					en.remove();
				}
			}
			
			if(StorageManager.nickname.containsKey(p)){
				if(DatabaseManager.containsPath("uuid", "PlayerNicknames", Start.getUUIDfromPlayer(p).toString())){
					DatabaseManager.setNickname(p, StorageManager.nickname.get(p));
				}
				else{
					DatabaseManager.insertString(p.getName(), "PlayerNicknames", "nick", StorageManager.nickname.get(p));
				}
			}
			else{
				if(DatabaseManager.containsPath("uuid", "PlayerNicknames", Start.getUUIDfromPlayer(p).toString())){
					DatabaseManager.removeNickname(p);
				}
			}
			
			/*
			String fwsettings = PlayerManager.parseStringFromColor(StorageManager.fireworkcolor1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkcolor2.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade2.get(p)) + "|" + StorageManager.fireworkflicker.get(p) + "|" + StorageManager.fireworktrail.get(p) + "|" + StorageManager.fireworktype.get(p);
			DatabaseManager.setFireworkSettings(p, fwsettings);
			
			if(StorageManager.soccermagmacube.containsKey(p)){
				StorageManager.soccermagmacube.get(p).remove();
				StorageManager.soccermagmacube.remove(p);
			}
			*/
			
			if(StorageManager.disguise.containsKey(p)){
				DisguisePlayer.undisguisePlayer(p);
			}
			if(StorageManager.trailparticlesamount.containsKey(p)){
				DatabaseManager.setTrailTypeParticleAmount(p, StorageManager.trailparticlesamount.get(p));
			}
			if(StorageManager.trailspecial.containsKey(p)){
				DatabaseManager.setTrailTypeSpecial(p, StorageManager.trailspecial.get(p));
			}
			if(StorageManager.trailtype.containsKey(p)){
				DatabaseManager.setTrailType(p, StorageManager.trailtype.get(p));
			}
		}catch(Exception ex){}
	}
}
