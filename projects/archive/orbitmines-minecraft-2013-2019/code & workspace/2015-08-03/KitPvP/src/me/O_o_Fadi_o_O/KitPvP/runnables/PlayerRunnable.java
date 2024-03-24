package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.SpectatorKit;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRunnable {
	
	Start start = Start.getInstance();
	
	public void startPlayerRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
						if(p.getLocation().getY() <= 50 || p.getLocation().distance(StorageManager.spawn) >= 50){
							p.teleport(StorageManager.spawn);
						}
					}
					
					if(StorageManager.loaded.get(p) == true){
						
						if(StorageManager.spectators.contains(p)){
							p.setGameMode(GameMode.CREATIVE);
							SpectatorKit.giveInventory(p);
							
							if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("§0§lKit Selector")){
								p.closeInventory();
							}
							for(Player player : Bukkit.getOnlinePlayers()){
								player.hidePlayer(p);
							}
						}
						else{
							if(StorageManager.opmodeenabled.get(p) == false){
								p.setGameMode(GameMode.SURVIVAL);
							}
							for(Player player : Bukkit.getOnlinePlayers()){
								player.showPlayer(p);
							}
						}
						
						try{
							if(p.getInventory().getBoots().getItemMeta().getLore().contains("§7Fly I")){
								if(p.getAllowFlight() == true){
									Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() -1, p.getLocation().getBlockZ()));
									if(b.getType() == Material.AIR || b.isEmpty()){
										for(Player player : Bukkit.getOnlinePlayers()){
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
											EnumParticle.SMOKE_LARGE, true, (float) p.getLocation().getX(), (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1, 0, 1, 0, 3, null));
										}
									}
								}
							}
						}catch(Exception ex){}
						
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

