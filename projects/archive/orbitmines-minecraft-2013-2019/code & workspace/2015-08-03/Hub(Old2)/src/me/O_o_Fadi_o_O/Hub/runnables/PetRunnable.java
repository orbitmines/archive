package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.events.ClickEventENG;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PetRunnable {

	Hub plugin;
	 
	public PetRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startPetRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.ownerpets.containsKey(p)){
						Entity en = StorageManager.ownerpets.get(p);
						if(StorageManager.owners.containsKey(en)){
							if(en instanceof LivingEntity){
								LivingEntity ent = (LivingEntity) en;
								Location l = p.getLocation();
								
								if(ClickEventENG.getDistance(l, ent.getLocation()) < 20){
									ClickEventENG.navigate(ent, l, 1.2);
								}
								else{
									ent.teleport(l);
								}
								if(StorageManager.SheepDisco.containsKey(p)){
									if(StorageManager.SheepDisco.get(p) == true){
										
										Random r = new Random();
										int rInt = r.nextInt(15);
										
										Sheep s = (Sheep) StorageManager.ownerpets.get(p);
										DyeColor c = DyeColor.getByDyeData((byte) rInt);
										s.setColor(c);
										
									}
								}
								if(StorageManager.ShroomTrail.containsKey(p)){
									if(StorageManager.ShroomTrail.get(p) == true){
										
										for(int i = 0; i < 5; i++){
											ItemStack item = new ItemStack(Material.RED_MUSHROOM, 1);
											Item iEn = en.getWorld().dropItem(en.getLocation(), item);
											
								            float x = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
								            float y = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
								            float z = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
											
											iEn.setVelocity(en.getLocation().getDirection().multiply(-1).add(new Vector(x, y, z)));
											removeEntity(iEn);

										}
									}
								}
								if(StorageManager.BabyPigs.containsKey(p) && StorageManager.BabyPigs.get(p) == true){
									List<Entity> list = StorageManager.BabyPigsEntity.get(p);
									
									LivingEntity pig1 = (LivingEntity) list.get(0);
									LivingEntity pig2 = (LivingEntity) list.get(1);
									
									Location enL = ent.getLocation();
									Location pig1L = pig1.getLocation();
									Location pig2L = pig2.getLocation();
									
									if(ClickEventENG.getDistance(enL, pig1L) < 7 && ClickEventENG.getDistance(enL, pig1L) > 1){
										ClickEventENG.navigate(pig1, enL, 1.2);
									}
									else{
										pig1.teleport(enL);
									}
									if(ClickEventENG.getDistance(pig1L, pig2L) < 7 && ClickEventENG.getDistance(pig1L, pig2L) > 1){
										ClickEventENG.navigate(pig2, pig1L, 1.2);
									}
									else{
										pig2.teleport(pig1L);
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this.plugin, 20, 3);
		
	}
	
	public void removeEntity(final Item i){
		new BukkitRunnable(){
			
			@Override
			public void run() {
				i.remove();
			}
		}.runTaskLater(this.plugin, 60);	
	}
}
