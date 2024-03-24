package me.O_o_Fadi_o_O.MiniGames.runnables;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Pet;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRunnable {
	
	Start start = Start.getInstance();
	
	public static int i = 0;
	
	public void startPlayerRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				i++;
				if(i == 4){
					i = 1;
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
						if(p.getLocation().getY() <= 50 || p.getLocation().distance(StorageManager.spawn) >= 75){
							p.teleport(StorageManager.spawn);
						}
					}
					
					
					if(StorageManager.loaded.get(p) == true){
							
						PlayerManager.setBossBar(p);
						
						if(StorageManager.playersgame.containsKey(p)){
							ScoreboardManager.setScoreboard(p);
						}
						
						boolean petInv = false;
						
						if(StorageManager.pet.get(p) != Pet.NONE){
							if(p.getVehicle() != null && p.getVehicle() == StorageManager.petentity.get(p)){
								petInv = true;
							}
						}
						
						if(petInv == true){
							PlayerManager.givePetInv(p);
						}
						else{
							if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
								if(StorageManager.opmodeenabled.get(p) == false){
									MiniGamesLobbyKit.giveInventory(p, false);
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
		}.runTaskTimer(this.start, 0, 20);
	}
}

