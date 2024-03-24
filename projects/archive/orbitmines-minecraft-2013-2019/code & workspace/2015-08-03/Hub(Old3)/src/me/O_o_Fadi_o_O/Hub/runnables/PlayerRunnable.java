package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.JoinItems;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.utils.Pet;
import me.O_o_Fadi_o_O.Hub.utils.Server;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRunnable {
	
	Hub hub = Hub.getInstance();
	
	public void startPlayerRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				PlayerManager.bossbarnumber = PlayerManager.bossbarnumber +1;
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(!p.getWorld().getName().equals(StorageManager.builderworld.getName())){
						if(!p.getWorld().getName().equals(StorageManager.hubworld.getName())){
							p.teleport(StorageManager.spawn);
						}
						else{
							if(p.getLocation().getY() <= 50 || p.getLocation().distance(StorageManager.spawn) >= 100){
								p.teleport(StorageManager.spawn);
							}
						}
						for(Server server : Server.values()){
							if(StorageManager.serverportals.containsKey(server)){
								for(Block b : StorageManager.serverportals.get(server)){
									if(b.isEmpty()){
										if(server != Server.SURVIVAL && server != Server.SKYBLOCK){
											p.sendBlockChange(b.getLocation(), Material.PORTAL, (byte) 2);
										}
										else{
											p.sendBlockChange(b.getLocation(), Material.PORTAL, (byte) 1);
										}
									}
								}
							}
						}
					}
					
					
					if(StorageManager.loaded.get(p) == true){
							
						PlayerManager.setBossBar(p);
						
						if(StorageManager.playersenabled.get(p) == false){
							for(Player player : Bukkit.getOnlinePlayers()){
								p.hidePlayer(player);
							}
						}
						
						if(p.getWorld().getName().equals(StorageManager.hubworld.getName())){
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
					}
					
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
				}

			}
		}.runTaskTimer(this.hub, 0, 20);
	}
}

