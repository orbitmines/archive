package me.O_o_Fadi_o_O.Survival.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.Inv.ChatColors;
import me.O_o_Fadi_o_O.Survival.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Survival.Inv.Disguises;
import me.O_o_Fadi_o_O.Survival.Inv.Fireworks;
import me.O_o_Fadi_o_O.Survival.Inv.Gadgets;
import me.O_o_Fadi_o_O.Survival.Inv.Hats;
import me.O_o_Fadi_o_O.Survival.Inv.Pets;
import me.O_o_Fadi_o_O.Survival.Inv.Trails;
import me.O_o_Fadi_o_O.Survival.Inv.Wardrobe;
import me.O_o_Fadi_o_O.Survival.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;
import me.O_o_Fadi_o_O.Survival.utils.Pet;
import me.O_o_Fadi_o_O.Survival.utils.ReflectionUtil;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickEventENG implements Listener{
	
	Start plugin;
	 
	public ClickEventENG(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			final Player p = (Player) he;
			ItemStack c = e.getCurrentItem();
			
			try{
			if(c != null){
				if(e.getInventory().getName().equals("§0§lServer Selector")){
					e.setCancelled(true);
					
					if(c.getType() == Material.IRON_SWORD){
						teleportServer(p, "kitpvp");
					}
					if(c.getType() == Material.DIAMOND_PICKAXE){
						teleportServer(p, "prison");
					}
					if(c.getType() == Material.WOOD_AXE){
						teleportServer(p, "creative");
					}
					if(c.getType() == Material.STONE_HOE){
						teleportServer(p, "survival");
					}
					if(c.getType() == Material.GRASS){
						teleportServer(p, "skyblock");
					}
					if(c.getType() == Material.BOW){
						teleportServer(p, "minigames");
					}
				}
				if(e.getInventory().getName().equals("§0§lCosmetic Perks")){
					e.setCancelled(true);
				
					if(c.getType() == Material.MONSTER_EGG){
						p.openInventory(Pets.getPetsInv(p));
					}
					if(c.getType() == Material.INK_SACK){
						p.openInventory(ChatColors.getChatColors(p));
					}
					if(c.getType() == Material.SKULL_ITEM){
						p.openInventory(Disguises.getDisguisesInv(p));
					}
					if(c.getType() == Material.COMPASS){
						//p.openInventory(Gadgets.getGadgetsInv(p));
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE){
						//p.openInventory(Wardrobe.getWardrobeInv(p));
					}
					if(c.getType() == Material.STRING){
						p.openInventory(Trails.getTrailsInv(p));
					}
					if(c.getType() == Material.PUMPKIN){
						//p.openInventory(Hats.getHatsInv(p));
					}
					if(c.getType() == Material.FIREWORK){
						//Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
						//Fireworks.getFireworksInv(p, inv);//TODO
					}
				}
				if(e.getInventory().getName().equals("§0§lFireworks")){
					e.setCancelled(true);
					try{
						if(c.getItemMeta().getDisplayName().startsWith("§7Color 1:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkColor1.get(p.getName()) != null){
								
								if(StorageManager.FireworkColor1.get(p.getName()) == Color.AQUA){
									StorageManager.FireworkColor1.put(p.getName(), Color.BLACK);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.BLACK){
									StorageManager.FireworkColor1.put(p.getName(), Color.BLUE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.BLUE){
									StorageManager.FireworkColor1.put(p.getName(), Color.FUCHSIA);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.FUCHSIA){
									StorageManager.FireworkColor1.put(p.getName(), Color.GRAY);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.GRAY){
									StorageManager.FireworkColor1.put(p.getName(), Color.GREEN);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.GREEN){
									StorageManager.FireworkColor1.put(p.getName(), Color.LIME);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.LIME){
									StorageManager.FireworkColor1.put(p.getName(), Color.MAROON);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.MAROON){
									StorageManager.FireworkColor1.put(p.getName(), Color.NAVY);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.NAVY){
									StorageManager.FireworkColor1.put(p.getName(), Color.ORANGE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.ORANGE){
									StorageManager.FireworkColor1.put(p.getName(), Color.PURPLE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.PURPLE){
									StorageManager.FireworkColor1.put(p.getName(), Color.RED);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.RED){
									StorageManager.FireworkColor1.put(p.getName(), Color.SILVER);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.SILVER){
									StorageManager.FireworkColor1.put(p.getName(), Color.TEAL);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.TEAL){
									StorageManager.FireworkColor1.put(p.getName(), Color.WHITE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.WHITE){
									StorageManager.FireworkColor1.put(p.getName(), Color.YELLOW);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(StorageManager.FireworkColor1.get(p.getName()) == Color.YELLOW){
									StorageManager.FireworkColor1.put(p.getName(), Color.AQUA);
									Fireworks.getColor1(inv, p, 10);
								}
								
							}
							else{
								StorageManager.FireworkColor1.put(p.getName(), Color.BLACK);
								Fireworks.getColor1(inv, p, 10);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Color 2:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkColor2.get(p.getName()) != null){
								
								if(StorageManager.FireworkColor2.get(p.getName()) == Color.AQUA){
									StorageManager.FireworkColor2.put(p.getName(), Color.BLACK);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.BLACK){
									StorageManager.FireworkColor2.put(p.getName(), Color.BLUE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.BLUE){
									StorageManager.FireworkColor2.put(p.getName(), Color.FUCHSIA);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.FUCHSIA){
									StorageManager.FireworkColor2.put(p.getName(), Color.GRAY);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.GRAY){
									StorageManager.FireworkColor2.put(p.getName(), Color.GREEN);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.GREEN){
									StorageManager.FireworkColor2.put(p.getName(), Color.LIME);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.LIME){
									StorageManager.FireworkColor2.put(p.getName(), Color.MAROON);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.MAROON){
									StorageManager.FireworkColor2.put(p.getName(), Color.NAVY);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.NAVY){
									StorageManager.FireworkColor2.put(p.getName(), Color.ORANGE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.ORANGE){
									StorageManager.FireworkColor2.put(p.getName(), Color.PURPLE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.PURPLE){
									StorageManager.FireworkColor2.put(p.getName(), Color.RED);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.RED){
									StorageManager.FireworkColor2.put(p.getName(), Color.SILVER);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.SILVER){
									StorageManager.FireworkColor2.put(p.getName(), Color.TEAL);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.TEAL){
									StorageManager.FireworkColor2.put(p.getName(), Color.WHITE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.WHITE){
									StorageManager.FireworkColor2.put(p.getName(), Color.YELLOW);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(StorageManager.FireworkColor2.get(p.getName()) == Color.YELLOW){
									StorageManager.FireworkColor2.remove(p.getName());
									Fireworks.getColor2(inv, p, 28);
								}
								
							}
							else{
								StorageManager.FireworkColor2.put(p.getName(), Color.AQUA);
								Fireworks.getColor2(inv, p, 28);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Fade 1:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkFade1.get(p.getName()) != null){
								
								if(StorageManager.FireworkFade1.get(p.getName()) == Color.AQUA){
									StorageManager.FireworkFade1.put(p.getName(), Color.BLACK);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.BLACK){
									StorageManager.FireworkFade1.put(p.getName(), Color.BLUE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.BLUE){
									StorageManager.FireworkFade1.put(p.getName(), Color.FUCHSIA);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.FUCHSIA){
									StorageManager.FireworkFade1.put(p.getName(), Color.GRAY);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.GRAY){
									StorageManager.FireworkFade1.put(p.getName(), Color.GREEN);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.GREEN){
									StorageManager.FireworkFade1.put(p.getName(), Color.LIME);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.LIME){
									StorageManager.FireworkFade1.put(p.getName(), Color.MAROON);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.MAROON){
									StorageManager.FireworkFade1.put(p.getName(), Color.NAVY);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.NAVY){
									StorageManager.FireworkFade1.put(p.getName(), Color.ORANGE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.ORANGE){
									StorageManager.FireworkFade1.put(p.getName(), Color.PURPLE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.PURPLE){
									StorageManager.FireworkFade1.put(p.getName(), Color.RED);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.RED){
									StorageManager.FireworkFade1.put(p.getName(), Color.SILVER);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.SILVER){
									StorageManager.FireworkFade1.put(p.getName(), Color.TEAL);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.TEAL){
									StorageManager.FireworkFade1.put(p.getName(), Color.WHITE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.WHITE){
									StorageManager.FireworkFade1.put(p.getName(), Color.YELLOW);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(StorageManager.FireworkFade1.get(p.getName()) == Color.YELLOW){
									StorageManager.FireworkFade1.remove(p.getName());
									Fireworks.getFade1(inv, p, 12);
								}
								
							}
							else{
								StorageManager.FireworkFade1.put(p.getName(), Color.AQUA);
								Fireworks.getFade1(inv, p, 12);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Fade 2:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkFade2.get(p.getName()) != null){
								
								if(StorageManager.FireworkFade2.get(p.getName()) == Color.AQUA){
									StorageManager.FireworkFade2.put(p.getName(), Color.BLACK);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.BLACK){
									StorageManager.FireworkFade2.put(p.getName(), Color.BLUE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.BLUE){
									StorageManager.FireworkFade2.put(p.getName(), Color.FUCHSIA);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.FUCHSIA){
									StorageManager.FireworkFade2.put(p.getName(), Color.GRAY);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.GRAY){
									StorageManager.FireworkFade2.put(p.getName(), Color.GREEN);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.GREEN){
									StorageManager.FireworkFade2.put(p.getName(), Color.LIME);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.LIME){
									StorageManager.FireworkFade2.put(p.getName(), Color.MAROON);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.MAROON){
									StorageManager.FireworkFade2.put(p.getName(), Color.NAVY);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.NAVY){
									StorageManager.FireworkFade2.put(p.getName(), Color.ORANGE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.ORANGE){
									StorageManager.FireworkFade2.put(p.getName(), Color.PURPLE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.PURPLE){
									StorageManager.FireworkFade2.put(p.getName(), Color.RED);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.RED){
									StorageManager.FireworkFade2.put(p.getName(), Color.SILVER);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.SILVER){
									StorageManager.FireworkFade2.put(p.getName(), Color.TEAL);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.TEAL){
									StorageManager.FireworkFade2.put(p.getName(), Color.WHITE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.WHITE){
									StorageManager.FireworkFade2.put(p.getName(), Color.YELLOW);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(StorageManager.FireworkFade2.get(p.getName()) == Color.YELLOW){
									StorageManager.FireworkFade2.remove(p.getName());
									Fireworks.getFade2(inv, p, 30);
								}
								
							}
							else{
								StorageManager.FireworkFade2.put(p.getName(), Color.AQUA);
								Fireworks.getFade2(inv, p, 30);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Trail:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkTrail.get(p.getName()) != null){
								
								if(StorageManager.FireworkTrail.get(p.getName()) == false){
									StorageManager.FireworkTrail.put(p.getName(), true);
									Fireworks.getTrail(inv, p, 14);
								}
								else if(StorageManager.FireworkTrail.get(p.getName()) == true){
									StorageManager.FireworkTrail.put(p.getName(), false);
									Fireworks.getTrail(inv, p, 14);
								}
								
							}
							else{
								StorageManager.FireworkTrail.put(p.getName(), true);
								Fireworks.getTrail(inv, p, 14);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Flicker:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkFlicker.get(p.getName()) != null){
								
								if(StorageManager.FireworkFlicker.get(p.getName()) == false){
									StorageManager.FireworkFlicker.put(p.getName(), true);
									Fireworks.getFlicker(inv, p, 32);
								}
								else if(StorageManager.FireworkFlicker.get(p.getName()) == true){
									StorageManager.FireworkFlicker.put(p.getName(), false);
									Fireworks.getFlicker(inv, p, 32);
								}
								
							}
							else{
								StorageManager.FireworkFlicker.put(p.getName(), true);
								Fireworks.getFlicker(inv, p, 32);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Type:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(StorageManager.FireworkType.get(p.getName()) != null){
								
								if(StorageManager.FireworkType.get(p.getName()) == Type.BALL){
									StorageManager.FireworkType.put(p.getName(), Type.BALL_LARGE);
									Fireworks.getType(inv, p, 25);
								}
								else if(StorageManager.FireworkType.get(p.getName()) == Type.BALL_LARGE){
									StorageManager.FireworkType.put(p.getName(), Type.BURST);
									Fireworks.getType(inv, p, 25);
								}
								else if(StorageManager.FireworkType.get(p.getName()) == Type.BURST){
									StorageManager.FireworkType.put(p.getName(), Type.CREEPER);
									Fireworks.getType(inv, p, 25);
								}
								else if(StorageManager.FireworkType.get(p.getName()) == Type.CREEPER){
									StorageManager.FireworkType.put(p.getName(), Type.STAR);
									Fireworks.getType(inv, p, 25);
								}
								else if(StorageManager.FireworkType.get(p.getName()) == Type.STAR){
									StorageManager.FireworkType.put(p.getName(), Type.BALL);
									Fireworks.getType(inv, p, 25);
								}
								
							}
							else{
								StorageManager.FireworkType.put(p.getName(), Type.BALL_LARGE);
								Fireworks.getType(inv, p, 25);
							}
						}
						if(c.getType() == Material.ENDER_CHEST){
							p.openInventory(CosmeticPerks.getCosmeticPerks(p));
							p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
						}
						if(c.getType() == Material.ANVIL){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, 1);
							
							ItemStack item = new ItemStack(Material.FIREBALL, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§c§nFirework Gun§r §c(§6" + StorageManager.FireworkPasses.get(p.getName()) + "§c)");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(5, new ItemStack(item));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §c§lFirework Gun§7.");
						}
					}catch(Exception ex){
						
					}
					try{
						if(c.getType() == Material.EMPTY_MAP && c.getItemMeta().getDisplayName().equals("§6§l+5 Firework Passes")){
							if(StorageManager.points.get(p.getName()) >= 2){
								
								try {
									DatabaseManager.setFireworksPasses(p, StorageManager.FireworkPasses.get(p.getName()));
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								try {
									DatabaseManager.removeVIPPoints(p, 2);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								try {
									DatabaseManager.addFireworksPasses(p, 5);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §6§l5 Firework Passes§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l2 VIP Points§7.");
								
								Inventory inv = p.getOpenInventory().getTopInventory();
								Fireworks.getVIPPasses(inv, p, 50);
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 2 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
						if(c.getType() == Material.EMPTY_MAP && c.getItemMeta().getDisplayName().equals("§6§l+25 Firework Passes")){
							if(StorageManager.points.get(p.getName()) >= 10){
								
								try {
									DatabaseManager.setFireworksPasses(p, StorageManager.FireworkPasses.get(p.getName()));
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								try {
									DatabaseManager.removeVIPPoints(p, 10);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								try {
									DatabaseManager.addFireworksPasses(p, 25);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §6§l25 Firework Passes§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l10 VIP Points§7.");
								
								Inventory inv = p.getOpenInventory().getTopInventory();
								Fireworks.getVIPPasses(inv, p, 50);
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 10 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}catch(Exception ex){
						
					}
				}
				if(e.getInventory().getName().equals("§0§lGadgets")){
					e.setCancelled(true);
					
					if(c.getType() == Material.LEASH && c.getItemMeta().getDisplayName().equals("§6§lStacker")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack item = new ItemStack(Material.LEASH, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§6§nStacker");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(5, new ItemStack(item));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6§lStacker§7.");
							
						}
						else{
							
						}
					}
					if(c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§f§lPaintballs")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§f§nPaintballs");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(5, new ItemStack(item));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f§lPaintballs§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 700){
								
								try {
									DatabaseManager.removeVIPPoints(p, 700);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.gadgetsPaintballs.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Gadgets-Paintballs", "paintballs", 0);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §f§lPaintballs§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l700 VIP Points§7.");
								p.openInventory(Gadgets.getGadgetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 700 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§a§lCreeper Launcher")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§a§nCreeper Launcher");
							item.setItemMeta(itemmeta);
							item.setDurability((short) 4);
							p.getInventory().setItem(5, new ItemStack(item));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §a§lCreeper Launcher§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 525){
								
								try {
									DatabaseManager.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.gadgetsCreeperLauncher.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Gadgets-CreeperLauncher", "launcher", 0);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §a§lCreeper Launcher§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l525 VIP Points§7.");
								p.openInventory(Gadgets.getGadgetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 525 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.SADDLE && c.getItemMeta().getDisplayName().equals("§e§lPet Ride")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack item = new ItemStack(Material.SADDLE, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§e§nPet Ride");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(5, new ItemStack(item));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §e§lPet Ride§7.");
							
						}
						else{
							if(c.getItemMeta().getLore().contains("§c§oPet Required")){
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§f§oYou §c§lDO NOT§f§o have a Pet!");
							}
							else{
								if(StorageManager.points.get(p.getName()) >= 100){
									
									try {
										DatabaseManager.removeVIPPoints(p, 100);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									StorageManager.gadgetsPetRide.put(p.getName(), 1);
									DatabaseManager.insertInt(p.getName(), "Gadgets-PetRide", "petride", 0);
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
									p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §e§lPet Ride§7.");
									p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
									p.openInventory(Gadgets.getGadgetsInv(p));
								}
								else{
									p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
									int needed = 100 - StorageManager.points.get(p.getName());
									if(needed == 1){
										p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
									}
									else{
										p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
									}
								}
							}
						}
					}
					if(c.getType() == Material.BOOK && c.getItemMeta().getDisplayName().equals("§7§lBook Explosion")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack item = new ItemStack(Material.BOOK, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§7§nBook Explosion");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(5, new ItemStack(item));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lBook Explosion§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.gadgetsBookExplosion.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Gadgets-BookExplosion", "bookexplosion", 0);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7§lBook Explosion§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Gadgets.getGadgetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				if(e.getInventory().getName().equals("§0§lDisguises")){
					e.setCancelled(true);
					
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§2Witch Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.WITCH);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Witch Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 450){
								
								try {
									DatabaseManager.removeVIPPoints(p, 450);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disWitch.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Witch", "witch", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §2Witch Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l450 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 450 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Bat Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.BAT);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Bat Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disBat.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Bat", "bat", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Bat Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§fChicken Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fChicken Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 325){
								
								try {
									DatabaseManager.removeVIPPoints(p, 325);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disChicken.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Chicken", "chicken", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fChicken Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l325 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 325 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§eOcelot Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.OCELOT);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eOcelot Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 375){
								
								try {
									DatabaseManager.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disOcelot.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Ocelot", "ocelot", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §eOcelot Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l375 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 375 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§4Mushroom Cow Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.MUSHROOM_COW);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Mushroom Cow Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 350){
								
								try {
									DatabaseManager.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disMushroomCow.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-MushroomCow", "mushroomcow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4Mushroom Cow Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l350 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 350 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§9Squid Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SQUID);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Squid Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 500){
								
								try {
									DatabaseManager.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disSquid.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Squid", "squid", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §9Squid Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l500 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 500 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§aSlime Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SLIME);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aSlime Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 425){
								
								try {
									DatabaseManager.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disSlime.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Slime", "slime", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aSlime Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l425 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 425 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§dZombie Pigman Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.PIG_ZOMBIE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dZombie Pigman Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disZombiePigman.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-ZombiePigman", "zombiepigman", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §dZombie Pigman Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§cMagma Cube Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.MAGMA_CUBE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cMagma Cube Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disMagmaCube.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-MagmaCube", "magmacube", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cMagma Cube Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Skeleton Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SKELETON);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Skeleton Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 500){
								
								try {
									DatabaseManager.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disSkeleton.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Skeleton", "skeleton", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Skeleton Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l500 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 500 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Wolf Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.WOLF);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Wolf Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disWolf.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Wolf", "wolf", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Wolf Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Spider Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SPIDER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Spider Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 375){
								
								try {
									DatabaseManager.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disSpider.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Spider", "spider", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Spider Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l375 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 375 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Silverfish Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SILVERFISH);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Silverfish Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disSilverfish.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Silverfish", "silverfish", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Silverfish Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§fSheep Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SHEEP);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSheep Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 375){
								
								try {
									DatabaseManager.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disSheep.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Sheep", "sheep", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fSheep Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l375 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 375 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§3Cave Spider Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.CAVE_SPIDER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Cave Spider Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disCaveSpider.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-CaveSpider", "cavespider", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §3Cave Spider Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§aCreeper Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.CREEPER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aCreeper Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disCreeper.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Creeper", "creeper", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aCreeper Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Cow Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.COW);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Cow Disguise§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 350){
								
								try {
									DatabaseManager.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.disCow.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Dis-Cow", "cow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Cow Disguise§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l350 VIP Points§7.");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 350 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6Blaze Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.BLAZE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Blaze Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§dPig Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.PIG);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dPig Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§2Zombie Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.ZOMBIE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Zombie Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6Villager Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.VILLAGER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Villager Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.FIRE){
						if(PlayerManager.isDisguised(p)){
							PlayerManager.removeDisguise(p);
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Disguise §a§lENABLED§7!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lHats")){
					e.setCancelled(true);
					
					if(c.getType() == Material.GOLD_ORE && c.getItemMeta().getDisplayName().equals("§6Gold Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.GOLD_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Gold Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(c.getType() == Material.SMOOTH_BRICK && c.getItemMeta().getDisplayName().equals("§7Stone Bricks Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.SMOOTH_BRICK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Stone Bricks Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 75){
								
								try {
									DatabaseManager.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsStoneBricks.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-StoneBricks", "stonebricks", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Stone Bricks Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l75 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 75 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§aLime Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 5);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aLime Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsGreenGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-GreenGlass", "greenglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aLime Stained Glass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.CACTUS && c.getItemMeta().getDisplayName().equals("§2Cactus Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.CACTUS, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Cactus Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsCactus.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Cactus", "cactus", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §2Cactus Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.EMERALD_ORE && c.getItemMeta().getDisplayName().equals("§aEmerald Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.EMERALD_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aEmerald Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(c.getType() == Material.IRON_BLOCK && c.getItemMeta().getDisplayName().equals("§7Iron Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.IRON_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Iron Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(c.getType() == Material.SNOW_BLOCK && c.getItemMeta().getDisplayName().equals("§fSnow Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.SNOW_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSnow Block Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 75){
								
								try {
									DatabaseManager.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsSnow.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Snow", "snow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fSnow Block Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l75 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 75 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getDisplayName().equals("§cTNT Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.TNT, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cTNT Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsTNT.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-TNT", "tnt", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cTNT Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.COAL_ORE && c.getItemMeta().getDisplayName().equals("§8Coal Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.COAL_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Coal Ore Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsCoalOre.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-CoalOre", "coalore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Coal Ore Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§8Black Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 15);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Black Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsBlackGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-BlackGlass", "blackglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Black Stained Glass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.GOLD_BLOCK && c.getItemMeta().getDisplayName().equals("§6Gold Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.GOLD_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Gold Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(c.getType() == Material.FURNACE && c.getItemMeta().getDisplayName().equals("§7Furnace Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.FURNACE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Furnace Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsFurnace.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Furnace", "furnace", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Furnace Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§cQuartz Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.QUARTZ_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cQuartz Ore Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsQuartzOre.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-QuartzOre", "quartzore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cQuartz Ore Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.HAY_BLOCK && c.getItemMeta().getDisplayName().equals("§eHay Bale Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.HAY_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eHay Bale Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsHayBale.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-HayBale", "haybale", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §eHay Bale Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.REDSTONE_ORE && c.getItemMeta().getDisplayName().equals("§4Redstone Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.REDSTONE_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Redstone Ore Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsRedstoneOre.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-RedstoneOre", "redstoneore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4Redstone Ore Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.ICE && c.getItemMeta().getDisplayName().equals("§bIce Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.ICE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bIce Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 150){
								
								try {
									DatabaseManager.removeVIPPoints(p, 150);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsIce.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Ice", "ice", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §bIce Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l150 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 150 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§6Workbench Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.WORKBENCH, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Workbench Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsWorkbench.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Workbench", "workbench", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §6Workbench Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.DIAMOND_BLOCK && c.getItemMeta().getDisplayName().equals("§bDiamond Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bDiamond Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(c.getType() == Material.IRON_ORE && c.getItemMeta().getDisplayName().equals("§7Iron Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.IRON_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Iron Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(c.getType() == Material.GRASS && c.getItemMeta().getDisplayName().equals("§aGrass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.GRASS, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aGrass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsGrass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Grass", "grass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aGrass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§4Red Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 14);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Red Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsRedGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-RedGlass", "redglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4Red Stained Glass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.BEDROCK && c.getItemMeta().getDisplayName().equals("§8Bedrock Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.BEDROCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Bedrock Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsBedrock.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Bedrock", "bedrock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Bedrock Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LAPIS_ORE && c.getItemMeta().getDisplayName().equals("§1Lapis Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.LAPIS_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Lapis Ore Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsLapisOre.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-LapisOre", "lapisore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §1Lapis Ore Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4Redstone Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Redstone Block Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsRedstoneBlock.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-RedstoneBlock", "redstoneblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4Redstone Block Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.QUARTZ_BLOCK && c.getItemMeta().getDisplayName().equals("§fQuartz Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fQuartz Block Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 75){
								
								try {
									DatabaseManager.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsQuartzBlock.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-QuartzBlock", "quartzblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fQuartz Block Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l75 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 75 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LAPIS_BLOCK && c.getItemMeta().getDisplayName().equals("§1Lapis Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Lapis Block Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsLapisBlock.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-LapisBlock", "lapisblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §1Lapis Block Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§dMagenta Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 2);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dMagenta Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsMagentaGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-MagentaGlass", "magentaglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §dMagenta Stained Glass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.COAL_BLOCK && c.getItemMeta().getDisplayName().equals("§0Coal Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Coal Block Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsCoalBlock.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-CoalBlock", "coalblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §0Coal Block Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getDisplayName().equals("§aEmerald Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.EMERALD_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aEmerald Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(c.getType() == Material.MELON_BLOCK && c.getItemMeta().getDisplayName().equals("§2Melon Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.MELON_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Melon Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 100){
								
								try {
									DatabaseManager.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsMelon.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Melon", "melon", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §2Melon Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l100 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 100 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.GLASS && c.getItemMeta().getDisplayName().equals("§fGlass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.GLASS, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fGlass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 150){
								
								try {
									DatabaseManager.removeVIPPoints(p, 150);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Glass", "glass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fGlass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l150 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 150 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§eYellow Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 4);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eYellow Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsYellowGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-YellowGlass", "yellowglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §eYellow Stained Glass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MYCEL && c.getItemMeta().getDisplayName().equals("§7Mycelium Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.MYCEL, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Mycelium Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 75){
								
								try {
									DatabaseManager.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsMycelium.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Mycelium", "mycelium", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Mycelium Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l75 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 75 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEAVES && c.getItemMeta().getDisplayName().equals("§2Leaves Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.LEAVES, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Leaves Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsLeaves.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-Leaves", "leaves", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §2Leaves Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.DIAMOND_ORE && c.getItemMeta().getDisplayName().equals("§bDiamond Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bDiamond Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§6Orange Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Orange Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 125){
								
								try {
									DatabaseManager.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.hatsOrangeGlass.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Hats-OrangeGlass", "orangeglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §6Orange Stained Glass Hat§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l125 VIP Points§7.");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 125 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.FIRE){
						if(PlayerManager.hasHat(p)){
							PlayerManager.removeHat(p);
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Hat §a§lENABLED§7!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lTrails")){
					e.setCancelled(true);
					
					if(c.getType() == Material.FIREWORK && c.getItemMeta().getDisplayName().equals("§cFireWork Spark Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cFireWork Spark Trail§7.");
							StorageManager.trail.put(p, "FireWork");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsfirework.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Firework", "firework", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cFireWork Spark Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§cHeart Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cHeart Trail§7.");
							StorageManager.trail.put(p, "Hearts");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 300){
								
								try {
									DatabaseManager.removeVIPPoints(p, 300);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailshearts.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Hearts", "hearts", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cHeart Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l300 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 300 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getDisplayName().equals("§4TNT Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4TNT Trail§7.");
							StorageManager.trail.put(p, "TNT");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsexplode.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Explode", "explode", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4TNT Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8Angry Villager Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Angry Villager Trail§7.");
							StorageManager.trail.put(p, "AngryVillager");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsangryvillager.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-AngryVillager", "angryvillager", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Angry Villager Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§aSlime Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aSlime Trail§7.");
							StorageManager.trail.put(p, "Slime");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 275){
								
								try {
									DatabaseManager.removeVIPPoints(p, 275);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsslime.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Slime", "slime", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aSlime Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l275 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 275 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§0Smoke Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Smoke Trail§7.");
							StorageManager.trail.put(p, "Smoke");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 325){
								
								try {
									DatabaseManager.removeVIPPoints(p, 325);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailssmoke.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Smoke", "smoke", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §0Smoke Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l325 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 325 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§5Witch Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §5Witch Trail§7.");
							StorageManager.trail.put(p, "Witch");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 350){
								
								try {
									DatabaseManager.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailswitch.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Witch", "witch", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §5Witch Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l350 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 350 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getDisplayName().equals("§bCrit Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bCrit Trail§7.");
							StorageManager.trail.put(p, "Crit");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 375){
								
								try {
									DatabaseManager.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailscrit.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Crit", "crit", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §bCrit Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l375 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 375 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.WATER_BUCKET && c.getItemMeta().getDisplayName().equals("§9Water Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Water Trail§7.");
							StorageManager.trail.put(p, "Water");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 425){
								
								try {
									DatabaseManager.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailswater.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Water", "water", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §9Water Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l425 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 425 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.NOTE_BLOCK && c.getItemMeta().getDisplayName().equals("§dMusic Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dMusic Trail§7.");
							StorageManager.trail.put(p, "Music");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 625){
								
								try {
									DatabaseManager.removeVIPPoints(p, 625);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsnote.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Music", "music", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §dMusic Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l625 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 625 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§fSnow Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSnow Trail§7.");
							StorageManager.trail.put(p, "Snow");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailssnow.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Snow", "snow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fSnow Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.ENCHANTMENT_TABLE && c.getItemMeta().getDisplayName().equals("§1Enchantment Table Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Enchantment Table Trail§7.");
							StorageManager.trail.put(p, "EnchantmentTable");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 400){
								
								try {
									DatabaseManager.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsenchantmenttable.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-ETable", "etable", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §1Enchantment Table Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l400 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 400 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.WEB && c.getItemMeta().getDisplayName().equals("§fBubble Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fBubble Trail§7.");
							StorageManager.trail.put(p, "Bubble");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 375){
								
								try {
									DatabaseManager.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsbubbles.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-Bubble", "bubble", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fBubble Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l375 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 375 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MOB_SPAWNER && c.getItemMeta().getDisplayName().equals("§7Mob Spawner Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Mob Spawner Trail§7.");
							StorageManager.trail.put(p, "MobSpawner");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 525){
								
								try {
									DatabaseManager.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.trailsmobspawner.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Trails-MobSpawner", "mobspawner", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Mob Spawner Trail§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l525 VIP Points§7.");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 525 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§aHappy Villager Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aHappy Villager Trail§7.");
							StorageManager.trail.put(p, "HappyVillager");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§3Magic Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Magic Trail§7.");
							StorageManager.trail.put(p, "Magic");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§6Lava Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Lava Trail§7.");
							StorageManager.trail.put(p, "Lava");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Rainbow Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Rainbow Trail§7.");
							StorageManager.trail.put(p, "Rainbow");
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.FIRE){
						if(PlayerManager.hasTrailEnabled(p)){
							PlayerManager.removeTrail(p);
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Trail §a§lENABLED§7!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lChatColors")){
					e.setCancelled(true);
					
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Dark Red ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Dark Red ChatColor§7.");
							StorageManager.chatcolor.put(p, "4");
							try {
								DatabaseManager.setChatColor(p, "4");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolordarkred.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-DarkRed", "darkred", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4Dark Red ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§aLight Green ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aLight Green ChatColor§7.");
							StorageManager.chatcolor.put(p, "a");
							try {
								DatabaseManager.setChatColor(p, "a");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 575){
								
								try {
									DatabaseManager.removeVIPPoints(p, 575);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorlightgreen.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-LightGreen", "lightgreen", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aLight Green ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l575 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 575 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§8Dark Gray ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Dark Gray ChatColor§7.");
							StorageManager.chatcolor.put(p, "8");
							try {
								DatabaseManager.setChatColor(p, "8");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolordarkgray.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-DarkGray", "darkgray", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Dark Gray ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§cRed ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cRed ChatColor§7.");
							StorageManager.chatcolor.put(p, "c");
							try {
								DatabaseManager.setChatColor(p, "c");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 650){
								
								try {
									DatabaseManager.removeVIPPoints(p, 650);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorred.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-Red", "red", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cRed ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l650 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 650 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§fWhite ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fWhite ChatColor§7.");
							StorageManager.chatcolor.put(p, "f");
							try {
								DatabaseManager.setChatColor(p, "f");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 500){
								
								try {
									DatabaseManager.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorwhite.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-White", "white", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fWhite ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l500 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 500 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§bLight Blue ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bLight Blue ChatColor§7.");
							StorageManager.chatcolor.put(p, "b");
							try {
								DatabaseManager.setChatColor(p, "b");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 700){
								
								try {
									DatabaseManager.removeVIPPoints(p, 700);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorlightblue.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-LightBlue", "lightblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §bLight Blue ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l700 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 700 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§dPink ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dPink ChatColor§7.");
							StorageManager.chatcolor.put(p, "d");
							try {
								DatabaseManager.setChatColor(p, "d");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 525){
								
								try {
									DatabaseManager.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorpink.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-Pink", "pink", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §dPink ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l525 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 525 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§9Blue ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Blue ChatColor§7.");
							StorageManager.chatcolor.put(p, "9");
							try {
								DatabaseManager.setChatColor(p, "9");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorblue.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-Blue", "blue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §9Blue ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1Dark Blue ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Dark Blue ChatColor§7.");
							StorageManager.chatcolor.put(p, "1");
							try {
								DatabaseManager.setChatColor(p, "1");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 350){
								
								try {
									DatabaseManager.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolordarkblue.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-DarkBlue", "darkblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §1Dark Blue ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l350 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 350 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§7Gray ChatColor")){
						
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
						
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Gray ChatColor§7.");
						StorageManager.chatcolor.put(p, "7");
						try {
							DatabaseManager.setChatColor(p, "7");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§2Green ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Green ChatColor§7.");
							StorageManager.chatcolor.put(p, "2");
							try {
								DatabaseManager.setChatColor(p, "2");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorgreen.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-Green", "green", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §2Green ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§0Black ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Black ChatColor§7.");
							StorageManager.chatcolor.put(p, "0");
							try {
								DatabaseManager.setChatColor(p, "0");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 200){
								
								try {
									DatabaseManager.removeVIPPoints(p, 200);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.chatcolorblack.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "ChatColors-Black", "black", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §0Black ChatColor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l200 VIP Points§7.");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 200 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§eYellow ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eYellow ChatColor§7.");
							StorageManager.chatcolor.put(p, "e");
							try {
								DatabaseManager.setChatColor(p, "e");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
							
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§6Orange ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Orange ChatColor§7.");
							StorageManager.chatcolor.put(p, "6");
							try {
								DatabaseManager.setChatColor(p, "6");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
							
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§5Purple ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §5Purple ChatColor§7.");
							StorageManager.chatcolor.put(p, "5");
							try {
								DatabaseManager.setChatColor(p, "5");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
							
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§3Cyan ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Cyan ChatColor§7.");
							StorageManager.chatcolor.put(p, "3");
							try {
								DatabaseManager.setChatColor(p, "3");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
							
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				if(e.getInventory().getName().equals("§0§lWardrobe")){
					e.setCancelled(true);
					
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§fWhite Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fWhite Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.WHITE, "§fWhite Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.white.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-White", "white", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fWhite Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§9Blue Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Blue Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.BLUE, "§9Blue Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.blue.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Blue", "blue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §9Blue Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§2Green Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Green Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.GREEN, "§2Green Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.green.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Green", "green", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §2Green Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§0Black Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Black Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.BLACK, "§0Black Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.black.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Black", "black", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §0Black Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§bLight Blue Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bLight Blue Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.AQUA, "§bLight Blue Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.lightblue.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-LightBlue", "lightblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §bLight Blue Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§dPink Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dPink Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.FUCHSIA, "§dPink Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.pink.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Pink", "pink", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §dPink Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§aLight Green Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aLight Green Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.LIME, "§aLight Green Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.lightgreen.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-LightGreen", "lightgreen", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aLight Green Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§1Dark Blue Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Dark Blue Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.NAVY, "§1Dark Blue Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.darkblue.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-DarkBlue", "darkblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §1Dark Blue Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§5Purple Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §5Purple Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.PURPLE, "§5Purple Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.purple.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Purple", "purple", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §5Purple Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§6Orange Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Orange Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.ORANGE, "§6Orange Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.orange.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Orange", "orange", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §6Orange Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§cRed Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cRed Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.RED, "§cRed Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.red.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Red", "red", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cRed Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§3Cyan Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Cyan Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.TEAL, "§3Cyan Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.cyan.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Cyan", "cyan", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §3Cyan Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§eYellow Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eYellow Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.YELLOW, "§eYellow Armor");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.yellow.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Yellow", "yellow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §eYellow Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§7Gray Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Gray Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.GRAY, "§7Gray Armor");
							
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 250){
								
								try {
									DatabaseManager.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.gray.put(p.getName(), 1);
								DatabaseManager.insertInt(p.getName(), "Wardrobe-Gray", "gray", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Gray Armor§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l250 VIP Points§7.");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 250 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.IRON_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§7Iron Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Iron Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, "§7Iron Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(c.getType() == Material.GOLD_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§6Gold Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Gold Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, "§6Gold Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§bDiamond Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bDiamond Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, "§bDiamond Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(c.getType() == Material.CHAINMAIL_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§7Chainmail Armor")){
						
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Chainmail Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, "§7Chainmail Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					
					if(c.getType() == Material.FIRE){

						if(PlayerManager.hasWardrobeArmor(p)){
							
							PlayerManager.removeWardrobeArmor(p);
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have any Armor §a§lENABLED§7!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				if(e.getInventory().getName().equals("§0§lPets")){
					e.setCancelled(true);
					
					if(c.getType() == Material.FIRE){
						if(PlayerManager.isPetActive(p)){

							PlayerManager.removePet(p, "§7Pet");
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Pet §a§lENABLED§7!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§4Mushroom Cow Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.mushroomcow.get(p.getName()));
								
							}

							PlayerManager.spawnPet(p, Pet.MUSHROOMCOW);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.COW_HURT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.mushroomcow.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.mushroomcow.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-MushroomCow", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §4Mushroom Cow Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§dPig Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.pig.get(p.getName()));
								
							}

							PlayerManager.spawnPet(p, Pet.PIG);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PIG_DEATH, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.pig.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 425){
								
								try {
									DatabaseManager.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.pig.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Pig", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §dPig Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l425 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 425 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Wolf Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.wolf.get(p.getName()));
								
							}

							PlayerManager.spawnPet(p, Pet.WOLF);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.WOLF_BARK, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.wolf.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.wolf.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Wolf", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Wolf Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§fSheep Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.sheep.get(p.getName()));
								
							}
							
							PlayerManager.spawnPet(p, Pet.SHEEP);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.sheep.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 425){
								
								try {
									DatabaseManager.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.sheep.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Sheep", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §fSheep Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l425 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 425 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6Horse Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.horse.get(p.getName()));
								
							}
							
							PlayerManager.spawnPet(p, Pet.HORSE);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.HORSE_HIT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.horse.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 525){
								
								try {
									DatabaseManager.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.horse.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Horse", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §6Horse Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l525 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 525 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§cMagma Cube Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.magmacube.get(p.getName()));
								
							}
							
							PlayerManager.spawnPet(p, Pet.MAGMACUBE);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SLIME_WALK, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.magmacube.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 500){
								
								try {
									DatabaseManager.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.magmacube.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-MagmaCube", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §cMagma Cube Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l500 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 500 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§aSlime Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.slime.get(p.getName()));
								
							}
							
							PlayerManager.spawnPet(p, Pet.SLIME);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SLIME_WALK, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.slime.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 475){
								
								try {
									DatabaseManager.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.slime.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Slime", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §aSlime Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l475 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 475 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Cow Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.cow.get(p.getName()));
								
							}
							
							PlayerManager.spawnPet(p, Pet.COW);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.COW_HURT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.cow.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 425){
								
								try {
									DatabaseManager.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.cow.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Cow", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §8Cow Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l425 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 425 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Silverfish Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){

								PlayerManager.removePet(p, StorageManager.silverfish.get(p.getName()));
								
							}
							
							PlayerManager.spawnPet(p, Pet.SILVERFISH);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SILVERFISH_HIT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.silverfish.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 450){
								
								try {
									DatabaseManager.removeVIPPoints(p, 450);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.silverfish.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Silverfish", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §7Silverfish Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l450 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 450 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§eOcelot Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(PlayerManager.isPetActive(p)){
								PlayerManager.removePet(p, StorageManager.ocelot.get(p.getName()));
							}
							
							PlayerManager.spawnPet(p, Pet.OCELOT);

							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CAT_MEOW, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.ocelot.get(p.getName()) + "§7.");
						}
						else{
							if(StorageManager.points.get(p.getName()) >= 450){
								
								try {
									DatabaseManager.removeVIPPoints(p, 450);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								StorageManager.ocelot.put(p.getName(), p.getName() + "s Pet");
								DatabaseManager.insertString(p.getName(), "Pets-Ocelot", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: §eOcelot Pet§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: §b§l450 VIP Points§7.");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								int needed = 450 - StorageManager.points.get(p.getName());
								if(needed == 1){
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
								}
								else{
									p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
								}
							}
						}
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		}
	}
	
	public static double getDistance(Location l1, Location l2){
		double distance = l1.distance(l2);
		return distance;
	}
	
	public static void navigate(LivingEntity le, Location l, double v){
		try{
			
			Object entityLiving = ReflectionUtil.getMethod("getHandle", le.getClass(), 0).invoke(le);
			Object nav = ReflectionUtil.getMethod("getNavigation", entityLiving.getClass(), 0).invoke(entityLiving);
			ReflectionUtil.getMethod("a", nav.getClass(), 4).invoke(nav, l.getX(), l.getY(), l.getZ(), v);
			
		}catch(Exception ex){
			
		}
	}
	
    public void teleportServer(Player p, String server){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
 
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException eee) {
         
        }
 
        p.sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
    }
}
