package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.events.ClickEvent;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.Pet;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PetRunnable {

	Start start = Start.getInstance();
	
	public void startPetRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.pet.get(p) != Pet.NONE){
						Entity en = StorageManager.petentity.get(p);
						if(en instanceof LivingEntity){
							LivingEntity ent = (LivingEntity) en;
							Location l = p.getLocation();
							
							try{
								if(ClickEvent.getDistance(l, ent.getLocation()) < 20){
									ClickEvent.navigate(ent, l, 1.2);
								}
								else{
									ent.teleport(l);
								}
							}catch(Exception ex){PlayerManager.removePet(p, "§7Pet");}
							/*
							if(StorageManager.petsheepdisco.containsKey(p) && StorageManager.petsheepdisco.get(p) == true){
									
								Random r = new Random();
								int rInt = r.nextInt(15);
								
								Sheep s = (Sheep) en;
								DyeColor c = DyeColor.getByDyeData((byte) rInt);
								s.setColor(c);
								
							}
							if(StorageManager.petshroomtrail.containsKey(p) && StorageManager.petshroomtrail.get(p) == true){
									
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
							if(StorageManager.petbabypigs.containsKey(p) && StorageManager.petbabypigs.get(p) == true){
								List<Entity> list = StorageManager.petbabypigsentities.get(p);
								
								LivingEntity pig1 = (LivingEntity) list.get(0);
								LivingEntity pig2 = (LivingEntity) list.get(1);
								
								Location enL = ent.getLocation();
								Location pig1L = pig1.getLocation();
								Location pig2L = pig2.getLocation();
								
								if(ClickEvent.getDistance(enL, pig1L) < 7 && ClickEvent.getDistance(enL, pig1L) > 1){
									ClickEvent.navigate(pig1, enL, 1.2);
								}
								else{
									pig1.teleport(enL);
								}
								if(ClickEvent.getDistance(pig1L, pig2L) < 7 && ClickEvent.getDistance(pig1L, pig2L) > 1){
									ClickEvent.navigate(pig2, pig1L, 1.2);
								}
								else{
									pig2.teleport(pig1L);
								}
							}
							*/
						}
					}
				}
			}
		}.runTaskTimer(this.start, 20, 3);
		
	}
	
	public void removeEntity(final Item i){
		new BukkitRunnable(){
			
			@Override
			public void run() {
				i.remove();
			}
		}.runTaskLater(this.start, 60);	
	}
}
