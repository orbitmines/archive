package me.O_o_Fadi_o_O.SkyBlock.island;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.IslandManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;
import me.O_o_Fadi_o_O.SkyBlock.utils.IslandRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class IslandCreator {

	Start plugin;
	 
	public IslandCreator(Start instance) {
		plugin = instance;
	}
	
	public synchronized void createIsland(int IslandNumber, Player p){
	
		p.sendMessage(Start.TAG + "§dPreparing World...");
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		prepareWorld(p, IslandNumber);
		
	}
	
	public void prepareWorld(final Player p, final int IslandNumber){
		new BukkitRunnable(){
			public void run(){
				World w = Bukkit.getWorld("SkyBlock");
				
				p.sendMessage(Start.TAG + "§dGenerating Island...");
				p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				generatingIsland(p, IslandNumber, w);
			}
		}.runTaskLater(this.plugin, 5);
	}
	
	public void generatingIsland(final Player p, final int IslandNumber, final World w){
		new BukkitRunnable(){
			public void run(){
				Location l = null;
				
				if(IslandNumber == 1){
					l = new Location(w, 0, 100, 0);
				}
				else{
					l = newIslandLocation(StorageManager.IslandLocation.get(StorageManager.IslandsAmount));
				}
				
				for(Player player : Bukkit.getOnlinePlayers()){
					if(player.getName().equals("O_o_Fadi_o_O")){
						if(l != null){
							player.sendMessage(l.getWorld().getName() + ", " + l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ());
						}
						else{
							player.sendMessage("null");
						}
					}
				}
				
				generateIslandBlocks(l);
				
				p.sendMessage(Start.TAG + "§dSaving Data...");
				p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				savingData(p, IslandNumber, w, l);
			}
		}.runTaskLater(this.plugin, 20);
	}
	
	public void savingData(final Player p, final int IslandNumber, final World w, final Location l){
		new BukkitRunnable(){
			public void run(){
				plugin.setIslandAmount(IslandNumber);
				IslandManager.setIslandLocation(IslandNumber, l);
				IslandManager.setIslandMembers(IslandNumber, null);
				IslandManager.setIslandOwner(IslandNumber, p);
				IslandManager.setPlayersIslandHomeLocation(p, new Location(w, l.getBlockX() +0.5, l.getBlockY(), l.getBlockZ() +2.5, 180, 0));
				IslandManager.setPlayersIslandNumber(p, IslandNumber);
				IslandManager.setPlayersIslandRank(p, IslandRank.OWNER);
				IslandManager.resetChallenges(p);
				IslandManager.setIslandCreatedDate(IslandNumber);
				IslandManager.setIslandTeleportEnabled(IslandNumber, false);
				StorageManager.IslandMembers.put(IslandNumber, IslandManager.getIslandMembers(IslandNumber));
				StorageManager.PlayerHasIsland.put(p, true);
				
				p.sendMessage(Start.TAG + "§dIsland Ready!");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				
				teleportPlayer(p);
			}
		}.runTaskLater(this.plugin, 20);
	}
	
	public void teleportPlayer(final Player p){
		p.sendMessage(Start.TAG + "§7Teleporting to your §dIsland§7...");
		new BukkitRunnable(){
			public void run(){
				p.teleport(StorageManager.PlayersIslandHomeLocation.get(p));
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
		}.runTaskLater(this.plugin, 10);
	}
	
	public static void generateIslandBlocks(Location l){

		World w = l.getWorld();
		
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		
		// LAYER 1
		
		{Location l1 = new Location(w, x +0, y +6, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +6, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +6, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +6, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +6, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		
		// LAYER 2
		{Location l1 = new Location(w, x +0, y +5, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +5, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +5, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +5, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +5, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +5, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		
		// LAYER 3
		{Location l1 = new Location(w, x +0, y +4, z +0); w.getBlockAt(l1).setType(Material.LOG);}
		{Location l1 = new Location(w, x +1, y +4, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +4, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +4, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +4, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +4, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +4, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +4, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +4, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +4, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +4, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +4, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +4, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +4, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +4, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +4, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +4, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +4, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +4, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +4, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +4, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +4, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +4, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +4, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +4, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		
		// LAYER 4
		{Location l1 = new Location(w, x +0, y +3, z +0); w.getBlockAt(l1).setType(Material.LOG);}
		{Location l1 = new Location(w, x +1, y +3, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +3, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +3, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +3, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +3, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +3, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +3, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +3, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +3, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +3, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +3, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +2, y +3, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +3, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +3, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +3, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +3, z -2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +3, z -1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +3, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +3, z +1); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -2, y +3, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x -1, y +3, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +0, y +3, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +3, z +0); w.getBlockAt(l1).setType(Material.LEAVES);}
		{Location l1 = new Location(w, x +1, y +3, z +2); w.getBlockAt(l1).setType(Material.LEAVES);}

		// LAYER 5
		{Location l1 = new Location(w, x +0, y +2, z +0); w.getBlockAt(l1).setType(Material.LOG);}
		
		// LAYER 6
		{Location l1 = new Location(w, x +0, y +1, z +0); w.getBlockAt(l1).setType(Material.LOG);}
		
		// LAYER 7
		{Location l1 = new Location(w, x +0, y +0, z +0); w.getBlockAt(l1).setType(Material.LOG);}
		IslandChest.setIslandChest(w, x, y, z -1);
		
		// LAYER 8
		{Location l1 = new Location(w, x +0, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +0, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +0, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +2, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +2, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +2, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +2, y -1, z -2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z -2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +0, y -1, z -2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z -2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -2, y -1, z -2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -2, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -2, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -2, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -2, y -1, z +2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z +2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +0, y -1, z +2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z +2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +2, y -1, z +2); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +3, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +3, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +3, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -3, y -1, z +0); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -3, y -1, z -1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -3, y -1, z +1); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +0, y -1, z +3); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z +3); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z +3); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +0, y -1, z -3); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x -1, y -1, z -3); w.getBlockAt(l1).setType(Material.GRASS);}
		{Location l1 = new Location(w, x +1, y -1, z -3); w.getBlockAt(l1).setType(Material.GRASS);}
		
		// LAYER 9
		{Location l1 = new Location(w, x +0, y -2, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z +0); w.getBlockAt(l1).setType(Material.SAND);}
		{Location l1 = new Location(w, x +0, y -2, z +1); w.getBlockAt(l1).setType(Material.SAND);}
		{Location l1 = new Location(w, x -1, y -2, z +0); w.getBlockAt(l1).setType(Material.SAND);}
		{Location l1 = new Location(w, x +0, y -2, z -1); w.getBlockAt(l1).setType(Material.SAND);}
		{Location l1 = new Location(w, x -1, y -2, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -2, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -2, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -2, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -2, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -2, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -2, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -2, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -2, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -2, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -2, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -2, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -2, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -2, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -2, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -2, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +3, y -2, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +3, y -2, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +3, y -2, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -3, y -2, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -3, y -2, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -3, y -2, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -2, z +3); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -2, z +3); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z +3); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -2, z -3); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -2, z -3); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -2, z -3); w.getBlockAt(l1).setType(Material.DIRT);}
		
		// LAYER 10
		{Location l1 = new Location(w, x +0, y -3, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -3, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -3, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -3, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -3, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -3, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -3, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -3, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -3, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -3, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -3, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +2, y -3, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -3, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -3, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -3, z -2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -3, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -3, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -2, y -3, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -3, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -3, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -3, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -3, z +2); w.getBlockAt(l1).setType(Material.DIRT);}
		
		// LAYER 11
		{Location l1 = new Location(w, x +0, y -4, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -4, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -4, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -4, z +0); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +0, y -4, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -4, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x +1, y -4, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -4, z +1); w.getBlockAt(l1).setType(Material.DIRT);}
		{Location l1 = new Location(w, x -1, y -4, z -1); w.getBlockAt(l1).setType(Material.DIRT);}
		
		// LAYER 12
		{Location l1 = new Location(w, x +0, y -5, z +0); w.getBlockAt(l1).setType(Material.BEDROCK);}
		
	}
	
	public static Location newIslandLocation(Location lastIsland){
		
		final int x = (int) lastIsland.getX();
		final int z = (int) lastIsland.getZ();
		final Location nextL = lastIsland;
		if (x < z) {
			if (-1 * x < z) {
				nextL.setX(nextL.getX() + 130);
				return nextL;
			}
			nextL.setZ(nextL.getZ() + 130);
			return nextL;
		}
		if (x > z) {
			if (-1 * x >= z) {
				nextL.setX(nextL.getX() - 130);
				return nextL;
			}
			nextL.setZ(nextL.getZ() - 130);
			return nextL;
		}
		if (x <= 0) {
			nextL.setZ(nextL.getZ() + 130);
			return nextL;
		}
		nextL.setZ(nextL.getZ() - 130);
		return nextL;
		
	}
}
