package me.O_o_Fadi_o_O.Prison.runnables;

import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.events.ClickEventENG;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class WoodmenRunnable {
	Start plugin;
	 
	public WoodmenRunnable(Start instance) {
		plugin = instance;
	}
	
	public static HashMap<Rank, Block> zombieWorkingOn = new HashMap<Rank, Block>();
	public static HashMap<Rank, Boolean> zombieWorking = new HashMap<Rank, Boolean>();
	
	public void startWoodmenRunnable(){
		
		for(Rank rank : Rank.values()){
			zombieWorking.put(rank, false);
			zombieWorkingOn.put(rank, null);
		}
		
		new BukkitRunnable(){
			
			public void run(){
				for(Rank rank : Rank.values()){
					if(zombieWorking.get(rank) == true){
						Entity zombie = StorageManager.RankWoodmen.get(rank);
						if(zombieWorkingOn.get(rank) != null){
							Block b = zombieWorkingOn.get(rank);
							
							ClickEventENG.navigate((LivingEntity) zombie, b.getLocation(), 1.2);
						}
						else{
						
							Location l = StorageManager.RankWoodmenLocation.get(rank);
							
							ClickEventENG.navigate((LivingEntity) zombie, l, 1.2);
						}
						
					}
				}
			}
		}.runTaskTimer(this.plugin, 0, 3);
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				for(Rank rank : Rank.values()){
					Entity zombie = StorageManager.RankWoodmen.get(rank);
					try{
						for(Block b : StorageManager.RankWoodmenBlocksTaken.get(rank)){
							if(zombieWorking.get(rank) == false){
								zombieWorking.put(rank, true);
								zombieWorkingOn.put(rank, b);
								List<Block> blocksTaken = StorageManager.RankWoodmenBlocksTaken.get(rank);
								blocksTaken.remove(b);
								StorageManager.RankWoodmenBlocksTaken.put(rank, blocksTaken);
								
								Zombie z = (Zombie) zombie;
								z.getEquipment().setItemInHand(new ItemStack(Material.LOG));
								StorageManager.RankWoodBlockWillbeTaken.get(rank).setType(Material.AIR);
							}
						}
					}catch(Exception ex){}
					if(zombieWorking.get(rank) == true){
						if(zombieWorkingOn.get(rank) != null){
							Block b = zombieWorkingOn.get(rank);
							
							ClickEventENG.navigate((LivingEntity) zombie, b.getLocation(), 1.2);
							
							if(b.getLocation().distance(zombie.getLocation()) <= 1.75){
							
								b.setType(Material.LOG);
								b.setData((byte) 8);
								b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, 17);
								zombieWorkingOn.put(rank, null);
								
								Zombie z = (Zombie) zombie;
								z.getEquipment().setItemInHand(new ItemStack(Material.AIR));
								StorageManager.RankWoodBlockWillbeTaken.get(rank).setType(Material.LOG);
							}
						}
						else{
							Location l = StorageManager.RankWoodmenLocation.get(rank);
							
							ClickEventENG.navigate((LivingEntity) zombie, l, 1.2);
							
							if(l.distance(zombie.getLocation()) <= 1.75){
								zombieWorking.put(rank, false);
							}
							
							Zombie z = (Zombie) zombie;
							z.getEquipment().setItemInHand(new ItemStack(Material.IRON_AXE));
						}
					}
				}
			}
			
		}.runTaskTimer(this.plugin, 0, 10);
	}
}
