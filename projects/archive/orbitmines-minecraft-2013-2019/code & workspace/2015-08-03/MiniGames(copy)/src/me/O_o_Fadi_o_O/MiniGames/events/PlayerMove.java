package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import me.O_o_Fadi_o_O.MiniGames.utils.Trail;
import me.O_o_Fadi_o_O.MiniGames.utils.TrailType;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerMove implements Listener{

	Start start = Start.getInstance();
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onMove(final PlayerMoveEvent e) {
		
		if(!p.getAllowFlight()){
			Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
			if(!b.isEmpty()){
				if(b.getType() != Material.AIR){
					if(StorageManager.playersgame.containsKey(p)){
						if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
							if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.LOBBY || StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.LASTSECONDS){
								p.setAllowFlight(true);
							}
						}
						else if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
							p.setAllowFlight(true);
						}
					}
					else{
						p.setAllowFlight(true);
					}
				}
			}
		}
    }
}
