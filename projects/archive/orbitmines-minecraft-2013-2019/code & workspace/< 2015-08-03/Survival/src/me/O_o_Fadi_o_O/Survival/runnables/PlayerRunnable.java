package me.O_o_Fadi_o_O.Survival.runnables;

import me.O_o_Fadi_o_O.Survival.DisguisePlayer;
import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;
import me.O_o_Fadi_o_O.Survival.managers.TitleManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRunnable {
	
	Start start = Start.getInstance();
	
	public void startPlayerRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				PlayerManager.bossbarnumber = PlayerManager.bossbarnumber +1;
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.loaded.get(p) == true){
						if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
							if(StorageManager.playersinpvp.contains(p) || StorageManager.pvpteleporting.containsKey(p) || StorageManager.pvpcountdown.containsKey(p)){
								if(p.getAllowFlight() == true && StorageManager.opmodeenabled.get(p) == false){
									p.setFlying(false);
									p.setAllowFlight(false);
								}
							}
							else{
								if(p.getLocation().getY() <= 50 || p.getLocation().distance(StorageManager.spawn) >= 50 && StorageManager.opmodeenabled.get(p) == false){
									p.teleport(StorageManager.spawn);
								}
							}
							if(StorageManager.worldportals.containsKey(1)){
								for(Block b : StorageManager.worldportals.get(1)){
									if(b.isEmpty()){
										p.sendBlockChange(b.getLocation(), Material.PORTAL, (byte) 2);
									}
								}
							}
							if(StorageManager.pvpteleporting.containsKey(p)){
								StorageManager.pvpteleporting.put(p, StorageManager.pvpteleporting.get(p) -1);
								
								int seconds = StorageManager.pvpteleporting.get(p);
								
								if(seconds != 0){
									TitleManager.setTitle(p, "", "§7Type §a§l/confirm§7! §7Time Left: §6" + seconds + "§7...", 0, 40, 0);
								}
								else{
									p.teleport(StorageManager.spawn);
									TitleManager.setTitle(p, "", "§c§lCancelled §7PvP Teleportation!", 0, 40, 20);
									StorageManager.pvpteleporting.remove(p);
								}
							}
							if(StorageManager.pvpcountdown.containsKey(p)){
								StorageManager.pvpcountdown.put(p, StorageManager.pvpcountdown.get(p) -1);
								
								int seconds = StorageManager.pvpcountdown.get(p);
								
								if(seconds != 0){
									TitleManager.setTitle(p, "", "§7Your PvP Mode is §a§lEnabled§7 in §6" + seconds + "§7...", 0, 40, 0);
								}
								else{
									TitleManager.setTitle(p, "", "§7PvP Mode §a§lEnabled§7!", 0, 40, 20);
									StorageManager.pvpcountdown.remove(p);
									StorageManager.playersinpvp.add(p);
								}
							}
						}
						if(StorageManager.spawnteleporting.containsKey(p)){
							StorageManager.spawnteleporting.put(p, StorageManager.spawnteleporting.get(p) -1);
							
							int seconds = StorageManager.spawnteleporting.get(p);
							
							if(seconds != 0){
								TitleManager.setTitle(p, "", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
							}
							else{
								p.teleport(StorageManager.spawn);
								TitleManager.setTitle(p, "", "§7Teleported to §6Spawn§7!", 0, 40, 20);
								StorageManager.spawnteleporting.remove(p);
								if(StorageManager.playersinpvp.contains(p)){
									StorageManager.playersinpvp.remove(p);
								}
								if(StorageManager.disguise.containsKey(p)){
									DisguisePlayer.undisguisePlayer(p);
								}
							}
						}
						if(StorageManager.hometeleporting.containsKey(p)){
							StorageManager.hometeleporting.put(p, StorageManager.hometeleporting.get(p) -1);
							
							int seconds = StorageManager.hometeleporting.get(p);
							String home = StorageManager.hometeleportingto.get(p);
							
							if(seconds != 0){
								TitleManager.setTitle(p, "", "§7Teleporting to §6" + home + "§7 in §6" + seconds + "§7...", 0, 40, 0);
							}
							else{
								p.teleport(StorageManager.hometeleportinglocation.get(p));
								TitleManager.setTitle(p, "", "§7Teleported to §6" + home + "§7!", 0, 40, 20);
								StorageManager.hometeleporting.remove(p);
								StorageManager.hometeleportinglocation.remove(p);
								StorageManager.hometeleportingto.remove(p);
								if(StorageManager.playersinpvp.contains(p)){
									StorageManager.playersinpvp.remove(p);
								}
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

