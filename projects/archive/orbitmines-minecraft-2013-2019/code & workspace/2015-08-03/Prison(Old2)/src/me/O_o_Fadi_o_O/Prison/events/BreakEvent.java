package me.O_o_Fadi_o_O.Prison.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BreakEvent implements Listener {
	
	Start plugin;
	 
	public BreakEvent(Start instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(final BlockBreakEvent e){
		
		//TODO: Check if player is in a mine
		
		/*
		Random r = new Random();
		int i = r.nextInt(10);
		
		if(i == 1){
			
			new BukkitRunnable(){
				
				public void run(){
					
					e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation()).setType(Material.CHEST);
					
					Block c = e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation());
					List<Block> list = StorageManager.legendaryChests;
					list.add(c);
					StorageManager.legendaryChests = list;
					
				}
			}.runTaskLater(this.plugin, 1);
			
		}
		
		*/
		final Player p = e.getPlayer();
		final Block b = e.getBlock();
		if(PlayerManager.isLoaded(p)){
			if(!PlayerManager.isInOPMode(p)){
				for(final Rank rank : PlayerManager.getAllRanksPassed(p)){
					try{//TODO REMOVE
					if(StorageManager.RankWoodmenBlocks.get(rank).contains(b)){
						e.setCancelled(true);
						if(b.getType() == Material.LOG){
							p.getInventory().addItem(new ItemStack(b.getType(), 1));
							b.setType(Material.STAINED_CLAY);
							b.setData((byte) 15);
							if(StorageManager.RankWoodmenBlocksTaken.get(rank) != null){
								List<Block> blocksTaken = StorageManager.RankWoodmenBlocksTaken.get(rank);
								blocksTaken.add(b);
								StorageManager.RankWoodmenBlocksTaken.put(rank, blocksTaken);
							}
							else{
								List<Block> blocksTaken = new ArrayList<Block>();
								blocksTaken.add(b);
								StorageManager.RankWoodmenBlocksTaken.put(rank, blocksTaken);
							}
						}
						else{
							p.sendMessage("§4§lPrison §7| §7Wait until the §6§lLumberjack§7 has more supplies for you!");
							e.setCancelled(true);
						}
					}
					else if(StorageManager.RankMines.get(rank).contains(b)){
						e.setCancelled(true);
						
						if(e.getBlock().getType() != Material.IRON_ORE && e.getBlock().getType() != Material.GOLD_ORE){
							for(ItemStack item : e.getBlock().getDrops()){
								p.getInventory().addItem(item);
							}
						}
						else{
							if(e.getBlock().getType() == Material.IRON_ORE){
								p.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
							}
							if(e.getBlock().getType() == Material.GOLD_ORE){
								p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
							}
						}
						e.getBlock().setType(Material.AIR);
						
						//TODO: CHESTS
					}
					else{e.setCancelled(true);}
					}catch(Exception ex){}
				}
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}

}
