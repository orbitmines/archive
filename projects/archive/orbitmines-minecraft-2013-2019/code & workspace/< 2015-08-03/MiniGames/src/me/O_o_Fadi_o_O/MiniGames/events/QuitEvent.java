package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.DisguisePlayer;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.Pet;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		
		if(StorageManager.playersgame.containsKey(p)){
			if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
				ChickenFight.leaveArena(p, StorageManager.playersarena.get(p));
			}
			if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
				SurvivalGames.leaveArena(p, StorageManager.playersarena.get(p));
			}
		}
		else{
			Start.teleportToLobby(p);
		}
		
		try{
			DatabaseManager.setFireworksPasses(p, StorageManager.fireworkpasses.get(p));
			
			if(StorageManager.pet.get(p) != Pet.NONE){
				
				Entity en = StorageManager.petentity.get(p);
				if(en instanceof LivingEntity){
					StorageManager.petentity.remove(p);
					StorageManager.petowner.remove(en);
					en.remove();
				}
			}
			
			if(StorageManager.nickname.containsKey(p)){
				if(DatabaseManager.containsPath("name", "PlayerNicknames", p.getName())){
					DatabaseManager.setNickname(p, StorageManager.nickname.get(p));
				}
				else{
					DatabaseManager.insertString(p.getName(), "PlayerNicknames", "nick", StorageManager.nickname.get(p));
				}
			}
			else{
				if(DatabaseManager.containsPath("name", "PlayerNicknames", p.getName())){
					DatabaseManager.removeNickname(p);
				}
			}
			
			String fwsettings = PlayerManager.parseStringFromColor(StorageManager.fireworkcolor1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkcolor2.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade2.get(p)) + "|" + StorageManager.fireworkflicker.get(p) + "|" + StorageManager.fireworktrail.get(p) + "|" + StorageManager.fireworktype.get(p);
			DatabaseManager.setFireworkSettings(p, fwsettings);
			
			if(StorageManager.soccermagmacube.containsKey(p)){
				StorageManager.soccermagmacube.get(p).remove();
				StorageManager.soccermagmacube.remove(p);
			}
			
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
