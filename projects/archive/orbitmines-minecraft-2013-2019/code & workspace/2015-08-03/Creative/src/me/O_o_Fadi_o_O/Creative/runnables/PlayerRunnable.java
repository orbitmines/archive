package me.O_o_Fadi_o_O.Creative.runnables;

import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Creative.DisguisePlayer;
import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.managers.TitleManager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
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
				
				Block b1 = StorageManager.lobbyworld.getBlockAt(new Location(StorageManager.lobbyworld, -5, 74, 12));
				Block b2 = StorageManager.lobbyworld.getBlockAt(new Location(StorageManager.lobbyworld, -13, 74, 4));
				
				byte data = (byte) new Random().nextInt(16);
				b1.setData(data);
				b2.setData(data);
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getOpenInventory().getTopInventory().getName().startsWith("§0§lKit:")){
						for(int slot = 0; slot <= 26; slot++){
							if(slot == 0 || slot == 1 || slot == 2 || slot == 3 || slot == 18 || slot == 19 || slot == 20 || slot == 21 || slot == 22 || slot == 23 || slot == 24 || slot == 25 || slot == 26){
								if(p.getOpenInventory().getTopInventory().getItem(slot) == null){
									
								}
							}
						}
					}
					if(StorageManager.loaded.get(p) == true){
						if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
							if(p.getLocation().getY() <= 50 || p.getLocation().distance(StorageManager.spawn) >= 50 && StorageManager.opmodeenabled.get(p) == false){
								p.teleport(StorageManager.spawn);
							}
						}
						if(StorageManager.spawnteleporting.containsKey(p)){
							StorageManager.spawnteleporting.put(p, StorageManager.spawnteleporting.get(p) -1);
							
							int seconds = StorageManager.spawnteleporting.get(p);
							
							if(seconds != 0){
								if(StorageManager.playerspvpplot.containsKey(p)){
									TitleManager.setTitle(p, "", "§7Leaving §dPlot§7 in §d" + seconds + "§7...", 0, 40, 0);
								}
								else{
									TitleManager.setTitle(p, "", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
								}
							}
							else{
								p.teleport(StorageManager.spawn);
								
								if(StorageManager.playerspvpplot.containsKey(p)){
									TitleManager.setTitle(p, "", "§7Left the §dPlot§7!", 0, 40, 20);
									int PlotNumber = StorageManager.playerspvpplot.get(p);
									
									List<Player> pvpplayers = StorageManager.plotpvpplayers.get(PlotNumber);
									for(Player player : pvpplayers){
										player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
										player.sendMessage("§d" + p.getName() + "§7 left §dPlot #" + PlotNumber + "§7. (§d" + (pvpplayers.size() -1) + "§7/§d" + StorageManager.plotpvpmaxplayers.get(PlotNumber) + "§7)");
									}
									pvpplayers.remove(p);
									StorageManager.plotpvpplayers.put(PlotNumber, pvpplayers);
									
									List<Player> pvpplayers2 = StorageManager.plotpvpplayersselectedkit.get(PlotNumber);
									pvpplayers2.remove(p);
									StorageManager.plotpvpplayersselectedkit.put(PlotNumber, pvpplayers2);
									
									StorageManager.playerspvpplot.remove(p);
									
									Start.clearInventory(p);
								}
								else{
									TitleManager.setTitle(p, "", "§7Teleported to §6Spawn§7!", 0, 40, 20);
								}
								StorageManager.spawnteleporting.remove(p);
								if(StorageManager.disguise.containsKey(p)){
									DisguisePlayer.undisguisePlayer(p);
								}
							}
						}
						if(StorageManager.playerspvpplot.containsKey(p)){
							p.setGameMode(GameMode.SURVIVAL);
							
							int PlotNumber = StorageManager.playerspvpplot.get(p);
							
							if(StorageManager.plotpvpplayersselectedkit.get(PlotNumber).contains(p)){
								for(Player player : Bukkit.getOnlinePlayers()){
									if(!StorageManager.playerspvpplot.containsKey(player) || StorageManager.playerspvpplot.get(player) != PlotNumber || StorageManager.playerspvpplot.get(player) == PlotNumber && !StorageManager.plotpvpplayersselectedkit.get(PlotNumber).contains(player)){
										p.hidePlayer(player);
									}
									else{
										p.showPlayer(player);
									}
								}
							}
							else{
								for(Player player : Bukkit.getOnlinePlayers()){
									p.showPlayer(player);
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
						*/
						
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

