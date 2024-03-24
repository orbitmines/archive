package me.O_o_Fadi_o_O.Prison.runnables;

import me.O_o_Fadi_o_O.Prison.DisguisePlayer;
import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.NPCManager;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.managers.TitleManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRunnable {
	
	Start start = Start.getInstance();
	NPCManager npcmanager = new NPCManager();
	
	public void startPlayerRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				npcmanager.updateAllNPCs();
				
				PlayerManager.bossbarnumber = PlayerManager.bossbarnumber +1;
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.loaded.get(p) == true){
						if(p.getWorld().getName().equals(StorageManager.prisonworld.getName())){
							if(p.getLocation().distance(StorageManager.spawn) <= 150 && p.getLocation().distance(StorageManager.spawn) >= 75 && StorageManager.opmodeenabled.get(p) == false){
								p.teleport(StorageManager.spawn);
							}
						}
						if(StorageManager.spawnteleporting.containsKey(p)){
							StorageManager.spawnteleporting.put(p, StorageManager.spawnteleporting.get(p) -1);
							
							int seconds = StorageManager.spawnteleporting.get(p);
							
							if(seconds != 0){
								TitleManager.setTitle(p, "", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
							}
							else{
								p.teleport(new Location(StorageManager.spawn.getWorld(), StorageManager.spawn.getX(), StorageManager.spawn.getY() +4, StorageManager.spawn.getZ(), -90, 0));
								TitleManager.setTitle(p, "", "§7Teleported to §6Spawn§7!", 0, 40, 20);
								StorageManager.spawnteleporting.remove(p);
								if(StorageManager.disguise.containsKey(p)){
									DisguisePlayer.undisguisePlayer(p);
								}
							}
						}
						
						PlayerManager.setBossBar(p);
						/*
						if(StorageManager.playersenabled.get(p) == false){
							for(Player player : Bukkit.getOnlinePlayers()){
								p.hidePlayer(player);
							}
						}
						
						if(p.getWorld().getName().equals("Hub")){
							boolean petInv = false;
							
							if(!StorageManager.playersinmindcraft.contains(p)){
								if(StorageManager.pet.get(p) != Pet.NONE){
									if(p.getVehicle() != null && p.getVehicle() == StorageManager.petentity.get(p)){
										petInv = true;
									}
								}
								
								if(petInv == true){
									PlayerManager.givePetInv(p);
								}
								else{
									if(StorageManager.opmodeenabled.get(p) == false){
										JoinItems.giveItems(p);
									}
								}
							}
						}
						
						if(StorageManager.wardrobedisco.containsKey(p) && StorageManager.wardrobedisco.get(p) == true){
							
							PlayerManager.setRandomArmorForPlayerInv(p);
							
						}
						if(p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("§0§lWardrobe")){
							
							PlayerManager.setRandomArmorForWardrobeInv(p.getOpenInventory().getTopInventory(), p);
							
						}
						
						if(p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("§0§lConfirm your Purchase")){
							if(p.getOpenInventory().getTopInventory().getItem(13).getItemMeta().getDisplayName().endsWith("Disco Armor")){
								PlayerManager.setRandomArmorForConfirmInv(p.getOpenInventory().getTopInventory(), p);
							}
						}
						*/
					}
					
					/*
					if(p.getOpenInventory().getTopInventory() instanceof AnvilInventory){
						{
							ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§9§nCosmetic Perks");
							item.setItemMeta(meta);
							p.getInventory().setItem(12, item);
						}
						{
							ItemStack item = new ItemStack(Material.NAME_TAG, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§f§oClick the §6§oRight§f§o Egg to rename your Pet!");
							item.setItemMeta(meta);
							p.getInventory().setItem(14, item);
						}
					}
					else{
						p.getInventory().setItem(12, null);
						p.getInventory().setItem(14, null);
					}
					*/
				}

			}
		}.runTaskTimer(this.start, 0, 20);
	}
}

