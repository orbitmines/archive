package me.O_o_Fadi_o_O.MiniGames.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.ReflectionUtil;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomPig;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSheep;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSlime;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomWolf;
import me.O_o_Fadi_o_O.MiniGames.inv.ChatColors;
import me.O_o_Fadi_o_O.MiniGames.inv.CosmeticPerks;
import me.O_o_Fadi_o_O.MiniGames.inv.Disguises;
import me.O_o_Fadi_o_O.MiniGames.inv.Fireworks;
import me.O_o_Fadi_o_O.MiniGames.inv.Gadgets;
import me.O_o_Fadi_o_O.MiniGames.inv.Hats;
import me.O_o_Fadi_o_O.MiniGames.inv.Pets;
import me.O_o_Fadi_o_O.MiniGames.inv.Trails;
import me.O_o_Fadi_o_O.MiniGames.inv.VIPInv;
import me.O_o_Fadi_o_O.MiniGames.inv.Wardrobe;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
				if(e.getInventory().getName().equals(VIPInv.getVIPInv(p).getName())){
					
					if(c.getType() != null && c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§f§l§o+100% Coins Booster")){
						if(!Manager.UsedEffect.contains(p)){
							if(Start.points.get(p.getName()) >= 1){
								
								try {
									plugin.removeVIPPoints(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								if(p.hasPermission("Rank.Owner")){
									Bukkit.broadcastMessage("§4§lOwner §4" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else if(p.hasPermission("Rank.Moderator")){
									Bukkit.broadcastMessage("§b§lMod §b" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else if(p.hasPermission("Rank.Builder")){
									Bukkit.broadcastMessage("§d§lBuilder §d" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else if(p.hasPermission("Rank.Emerald")){
									Bukkit.broadcastMessage("§a§lEmerald §a" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else if(p.hasPermission("Rank.Diamond")){
									Bukkit.broadcastMessage("§9§lDiamond §9" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else if(p.hasPermission("Rank.Gold")){
									Bukkit.broadcastMessage("§6§lGold §6" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else if(p.hasPermission("Rank.Iron")){
									Bukkit.broadcastMessage("§7§lIron §7" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								else{
									Bukkit.broadcastMessage("§8" + p.getName() + " §7activated a §f§l+100% Coins Booster§7!");
								}
								for(Player player : Bukkit.getOnlinePlayers()){
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
								}
								Manager.BoosterMultiply = Manager.BoosterMultiply + 1;
								Manager.UsedEffect.add(p);
								p.closeInventory();
								
							}
							else{
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
						else{
							p.sendMessage("§c§oYou already activated a Game Effect this round!");
						}
					}
					if(c.getType() != null && c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§f§l§o+200% Coins Booster")){
						if(p.hasPermission("Rank.Emerald")){
							if(!Manager.UsedEffect.contains(p)){
								if(Start.points.get(p.getName()) >= 1){
									
									try {
										plugin.removeVIPPoints(p, 1);
									} catch (SQLException ex) {
										ex.printStackTrace();
									}
									
									if(p.hasPermission("Rank.Owner")){
										Bukkit.broadcastMessage("§4§lOwner §4" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else if(p.hasPermission("Rank.Moderator")){
										Bukkit.broadcastMessage("§b§lMod §b" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else if(p.hasPermission("Rank.Builder")){
										Bukkit.broadcastMessage("§d§lBuilder §d" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else if(p.hasPermission("Rank.Emerald")){
										Bukkit.broadcastMessage("§a§lEmerald §a" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else if(p.hasPermission("Rank.Diamond")){
										Bukkit.broadcastMessage("§9§lDiamond §9" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else if(p.hasPermission("Rank.Gold")){
										Bukkit.broadcastMessage("§6§lGold §6" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else if(p.hasPermission("Rank.Iron")){
										Bukkit.broadcastMessage("§7§lIron §7" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									else{
										Bukkit.broadcastMessage("§8" + p.getName() + " §7activated a §f§l+200% Coins Booster§7!");
									}
									for(Player player : Bukkit.getOnlinePlayers()){
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
									}
									Manager.BoosterMultiply = Manager.BoosterMultiply + 2;
									Manager.UsedEffect.add(p);
									p.closeInventory();
									
								}
								else{
									p.sendMessage("§9You don't have enough§b VIP Points§9!");
								}
							}
							else{
								p.sendMessage("§c§oYou already activated a Game Effect this round!");
							}
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §a§lEmerald VIP§c§o to use this!");
						}
					}
					if(c.getType() != null && c.getType() == Material.POTION && c.getItemMeta().getDisplayName().equals("§9§l§oSpeed 4")){
						if(!Manager.UsedEffect.contains(p)){
							if(Manager.GameEffectSpeed == false){
								if(Start.points.get(p.getName()) >= 1){
									
									try {
										plugin.removeVIPPoints(p, 1);
									} catch (SQLException ex) {
										ex.printStackTrace();
									}
									if(p.hasPermission("Rank.Owner")){
										Bukkit.broadcastMessage("§4§lOwner §4" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else if(p.hasPermission("Rank.Moderator")){
										Bukkit.broadcastMessage("§b§lMod §b" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else if(p.hasPermission("Rank.Builder")){
										Bukkit.broadcastMessage("§d§lBuilder §d" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else if(p.hasPermission("Rank.Emerald")){
										Bukkit.broadcastMessage("§a§lEmerald §a" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else if(p.hasPermission("Rank.Diamond")){
										Bukkit.broadcastMessage("§9§lDiamond §9" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else if(p.hasPermission("Rank.Gold")){
										Bukkit.broadcastMessage("§6§lGold §6" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else if(p.hasPermission("Rank.Iron")){
										Bukkit.broadcastMessage("§7§lIron §7" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									else{
										Bukkit.broadcastMessage("§8" + p.getName() + " §7activated a §9§lSpeed 4 Effect§7!");
									}
									for(Player player : Bukkit.getOnlinePlayers()){
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
									}
									Manager.UsedEffect.add(p);
									Manager.GameEffectSpeed = true;
									p.closeInventory();
									
								}
								else{
									p.sendMessage("§9You don't have enough§b VIP Points§9!");
								}
							}
							else{
								p.sendMessage("§c§oThe §f§lSpeed 4 Effect§c§o has already been activated this round!");
							}
						}
						else{
							p.sendMessage("§c§oYou already activated a Game Effect this round!");
						}
					}
					if(c.getType() != null && c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§8§l§oBlindness")){
						if(!Manager.UsedEffect.contains(p)){
							if(Manager.GameEffectBlindness == false){
								if(Start.points.get(p.getName()) >= 1){
									
									try {
										plugin.removeVIPPoints(p, 1);
									} catch (SQLException ex) {
										ex.printStackTrace();
									}
									
									if(p.hasPermission("Rank.Owner")){
										Bukkit.broadcastMessage("§4§lOwner §4" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else if(p.hasPermission("Rank.Moderator")){
										Bukkit.broadcastMessage("§b§lMod §b" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else if(p.hasPermission("Rank.Builder")){
										Bukkit.broadcastMessage("§d§lBuilder §d" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else if(p.hasPermission("Rank.Emerald")){
										Bukkit.broadcastMessage("§a§lEmerald §a" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else if(p.hasPermission("Rank.Diamond")){
										Bukkit.broadcastMessage("§9§lDiamond §9" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else if(p.hasPermission("Rank.Gold")){
										Bukkit.broadcastMessage("§6§lGold §6" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else if(p.hasPermission("Rank.Iron")){
										Bukkit.broadcastMessage("§7§lIron §7" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									else{
										Bukkit.broadcastMessage("§8" + p.getName() + " §7activated a §8§lBlindness Effect§7!");
									}
									for(Player player : Bukkit.getOnlinePlayers()){
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
									}
									Manager.UsedEffect.add(p);
									Manager.GameEffectBlindness = true;
									p.closeInventory();
									
								}
								else{
									p.sendMessage("§9You don't have enough§b VIP Points§9!");
								}
							}
							else{
								p.sendMessage("§c§oThe §8§lBlindness Effect§c§o has already been activated this round!");
							}
						}
						else{
							p.sendMessage("§c§oYou already activated a Game Effect this round!");
						}
					}
					if(c.getType() != null && c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getDisplayName().equals("§7§l§oJump Boost 5")){
						if(!Manager.UsedEffect.contains(p)){
							if(Manager.GameEffectJump == false){
								if(Start.points.get(p.getName()) >= 1){
									
									try {
										plugin.removeVIPPoints(p, 1);
									} catch (SQLException ex) {
										ex.printStackTrace();
									}
									
									if(p.hasPermission("Rank.Owner")){
										Bukkit.broadcastMessage("§4§lOwner §4" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else if(p.hasPermission("Rank.Moderator")){
										Bukkit.broadcastMessage("§b§lMod §b" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else if(p.hasPermission("Rank.Builder")){
										Bukkit.broadcastMessage("§d§lBuilder §d" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else if(p.hasPermission("Rank.Emerald")){
										Bukkit.broadcastMessage("§a§lEmerald §a" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else if(p.hasPermission("Rank.Diamond")){
										Bukkit.broadcastMessage("§9§lDiamond §9" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else if(p.hasPermission("Rank.Gold")){
										Bukkit.broadcastMessage("§6§lGold §6" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else if(p.hasPermission("Rank.Iron")){
										Bukkit.broadcastMessage("§7§lIron §7" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									else{
										Bukkit.broadcastMessage("§8" + p.getName() + " §7activated a §7§lJump Boost 5 Effect§7!");
									}
									for(Player player : Bukkit.getOnlinePlayers()){
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
									}
									Manager.UsedEffect.add(p);
									Manager.GameEffectJump = true;
									p.closeInventory();
									
								}
								else{
									p.sendMessage("§9You don't have enough§b VIP Points§9!");
								}
							}
							else{
								p.sendMessage("§c§oThe §7§lJump Boost 5 Effect§c§o has already been activated this round!");
							}
						}
						else{
							p.sendMessage("§c§oYou already activated a Game Effect this round!");
						}
					}
				}
				if(e.getSlotType() == SlotType.ARMOR){
					e.setCancelled(true);
				}
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
						p.openInventory(Gadgets.getGadgetsInv(p));
					}
					if(c.getType() == Material.LEATHER_CHESTPLATE){
						p.openInventory(Wardrobe.getWardrobeInv(p));
					}
					if(c.getType() == Material.STRING){
						p.openInventory(Trails.getTrailsInv(p));
					}
					if(c.getType() == Material.PUMPKIN){
						p.openInventory(Hats.getHatsInv(p));
					}
					if(c.getType() == Material.FIREWORK){
						Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
						Fireworks.getFireworksInv(p, inv);
					}
				}
				if(e.getInventory().getName().equals("§0§lFireworks")){
					e.setCancelled(true);
					try{
						if(c.getItemMeta().getDisplayName().startsWith("§7Color 1:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkColor1.get(p.getName()) != null){
								
								if(Start.FireworkColor1.get(p.getName()) == Color.AQUA){
									Start.FireworkColor1.put(p.getName(), Color.BLACK);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.BLACK){
									Start.FireworkColor1.put(p.getName(), Color.BLUE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.BLUE){
									Start.FireworkColor1.put(p.getName(), Color.FUCHSIA);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.FUCHSIA){
									Start.FireworkColor1.put(p.getName(), Color.GRAY);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.GRAY){
									Start.FireworkColor1.put(p.getName(), Color.GREEN);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.GREEN){
									Start.FireworkColor1.put(p.getName(), Color.LIME);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.LIME){
									Start.FireworkColor1.put(p.getName(), Color.MAROON);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.MAROON){
									Start.FireworkColor1.put(p.getName(), Color.NAVY);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.NAVY){
									Start.FireworkColor1.put(p.getName(), Color.ORANGE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.ORANGE){
									Start.FireworkColor1.put(p.getName(), Color.PURPLE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.PURPLE){
									Start.FireworkColor1.put(p.getName(), Color.RED);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.RED){
									Start.FireworkColor1.put(p.getName(), Color.SILVER);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.SILVER){
									Start.FireworkColor1.put(p.getName(), Color.TEAL);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.TEAL){
									Start.FireworkColor1.put(p.getName(), Color.WHITE);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.WHITE){
									Start.FireworkColor1.put(p.getName(), Color.YELLOW);
									Fireworks.getColor1(inv, p, 10);
								}
								else if(Start.FireworkColor1.get(p.getName()) == Color.YELLOW){
									Start.FireworkColor1.put(p.getName(), Color.AQUA);
									Fireworks.getColor1(inv, p, 10);
								}
								
							}
							else{
								Start.FireworkColor1.put(p.getName(), Color.BLACK);
								Fireworks.getColor1(inv, p, 10);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Color 2:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkColor2.get(p.getName()) != null){
								
								if(Start.FireworkColor2.get(p.getName()) == Color.AQUA){
									Start.FireworkColor2.put(p.getName(), Color.BLACK);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.BLACK){
									Start.FireworkColor2.put(p.getName(), Color.BLUE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.BLUE){
									Start.FireworkColor2.put(p.getName(), Color.FUCHSIA);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.FUCHSIA){
									Start.FireworkColor2.put(p.getName(), Color.GRAY);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.GRAY){
									Start.FireworkColor2.put(p.getName(), Color.GREEN);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.GREEN){
									Start.FireworkColor2.put(p.getName(), Color.LIME);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.LIME){
									Start.FireworkColor2.put(p.getName(), Color.MAROON);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.MAROON){
									Start.FireworkColor2.put(p.getName(), Color.NAVY);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.NAVY){
									Start.FireworkColor2.put(p.getName(), Color.ORANGE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.ORANGE){
									Start.FireworkColor2.put(p.getName(), Color.PURPLE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.PURPLE){
									Start.FireworkColor2.put(p.getName(), Color.RED);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.RED){
									Start.FireworkColor2.put(p.getName(), Color.SILVER);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.SILVER){
									Start.FireworkColor2.put(p.getName(), Color.TEAL);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.TEAL){
									Start.FireworkColor2.put(p.getName(), Color.WHITE);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.WHITE){
									Start.FireworkColor2.put(p.getName(), Color.YELLOW);
									Fireworks.getColor2(inv, p, 28);
								}
								else if(Start.FireworkColor2.get(p.getName()) == Color.YELLOW){
									Start.FireworkColor2.remove(p.getName());
									Fireworks.getColor2(inv, p, 28);
								}
								
							}
							else{
								Start.FireworkColor2.put(p.getName(), Color.AQUA);
								Fireworks.getColor2(inv, p, 28);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Fade 1:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkFade1.get(p.getName()) != null){
								
								if(Start.FireworkFade1.get(p.getName()) == Color.AQUA){
									Start.FireworkFade1.put(p.getName(), Color.BLACK);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.BLACK){
									Start.FireworkFade1.put(p.getName(), Color.BLUE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.BLUE){
									Start.FireworkFade1.put(p.getName(), Color.FUCHSIA);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.FUCHSIA){
									Start.FireworkFade1.put(p.getName(), Color.GRAY);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.GRAY){
									Start.FireworkFade1.put(p.getName(), Color.GREEN);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.GREEN){
									Start.FireworkFade1.put(p.getName(), Color.LIME);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.LIME){
									Start.FireworkFade1.put(p.getName(), Color.MAROON);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.MAROON){
									Start.FireworkFade1.put(p.getName(), Color.NAVY);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.NAVY){
									Start.FireworkFade1.put(p.getName(), Color.ORANGE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.ORANGE){
									Start.FireworkFade1.put(p.getName(), Color.PURPLE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.PURPLE){
									Start.FireworkFade1.put(p.getName(), Color.RED);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.RED){
									Start.FireworkFade1.put(p.getName(), Color.SILVER);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.SILVER){
									Start.FireworkFade1.put(p.getName(), Color.TEAL);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.TEAL){
									Start.FireworkFade1.put(p.getName(), Color.WHITE);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.WHITE){
									Start.FireworkFade1.put(p.getName(), Color.YELLOW);
									Fireworks.getFade1(inv, p, 12);
								}
								else if(Start.FireworkFade1.get(p.getName()) == Color.YELLOW){
									Start.FireworkFade1.remove(p.getName());
									Fireworks.getFade1(inv, p, 12);
								}
								
							}
							else{
								Start.FireworkFade1.put(p.getName(), Color.AQUA);
								Fireworks.getFade1(inv, p, 12);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Fade 2:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkFade2.get(p.getName()) != null){
								
								if(Start.FireworkFade2.get(p.getName()) == Color.AQUA){
									Start.FireworkFade2.put(p.getName(), Color.BLACK);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.BLACK){
									Start.FireworkFade2.put(p.getName(), Color.BLUE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.BLUE){
									Start.FireworkFade2.put(p.getName(), Color.FUCHSIA);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.FUCHSIA){
									Start.FireworkFade2.put(p.getName(), Color.GRAY);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.GRAY){
									Start.FireworkFade2.put(p.getName(), Color.GREEN);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.GREEN){
									Start.FireworkFade2.put(p.getName(), Color.LIME);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.LIME){
									Start.FireworkFade2.put(p.getName(), Color.MAROON);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.MAROON){
									Start.FireworkFade2.put(p.getName(), Color.NAVY);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.NAVY){
									Start.FireworkFade2.put(p.getName(), Color.ORANGE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.ORANGE){
									Start.FireworkFade2.put(p.getName(), Color.PURPLE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.PURPLE){
									Start.FireworkFade2.put(p.getName(), Color.RED);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.RED){
									Start.FireworkFade2.put(p.getName(), Color.SILVER);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.SILVER){
									Start.FireworkFade2.put(p.getName(), Color.TEAL);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.TEAL){
									Start.FireworkFade2.put(p.getName(), Color.WHITE);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.WHITE){
									Start.FireworkFade2.put(p.getName(), Color.YELLOW);
									Fireworks.getFade2(inv, p, 30);
								}
								else if(Start.FireworkFade2.get(p.getName()) == Color.YELLOW){
									Start.FireworkFade2.remove(p.getName());
									Fireworks.getFade2(inv, p, 30);
								}
								
							}
							else{
								Start.FireworkFade2.put(p.getName(), Color.AQUA);
								Fireworks.getFade2(inv, p, 30);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Trail:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkTrail.get(p.getName()) != null){
								
								if(Start.FireworkTrail.get(p.getName()) == false){
									Start.FireworkTrail.put(p.getName(), true);
									Fireworks.getTrail(inv, p, 14);
								}
								else if(Start.FireworkTrail.get(p.getName()) == true){
									Start.FireworkTrail.put(p.getName(), false);
									Fireworks.getTrail(inv, p, 14);
								}
								
							}
							else{
								Start.FireworkTrail.put(p.getName(), true);
								Fireworks.getTrail(inv, p, 14);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Flicker:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkFlicker.get(p.getName()) != null){
								
								if(Start.FireworkFlicker.get(p.getName()) == false){
									Start.FireworkFlicker.put(p.getName(), true);
									Fireworks.getFlicker(inv, p, 32);
								}
								else if(Start.FireworkFlicker.get(p.getName()) == true){
									Start.FireworkFlicker.put(p.getName(), false);
									Fireworks.getFlicker(inv, p, 32);
								}
								
							}
							else{
								Start.FireworkFlicker.put(p.getName(), true);
								Fireworks.getFlicker(inv, p, 32);
							}
						}
						if(c.getItemMeta().getDisplayName().startsWith("§7Type:")){
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							if(Start.FireworkType.get(p.getName()) != null){
								
								if(Start.FireworkType.get(p.getName()) == Type.BALL){
									Start.FireworkType.put(p.getName(), Type.BALL_LARGE);
									Fireworks.getType(inv, p, 25);
								}
								else if(Start.FireworkType.get(p.getName()) == Type.BALL_LARGE){
									Start.FireworkType.put(p.getName(), Type.BURST);
									Fireworks.getType(inv, p, 25);
								}
								else if(Start.FireworkType.get(p.getName()) == Type.BURST){
									Start.FireworkType.put(p.getName(), Type.CREEPER);
									Fireworks.getType(inv, p, 25);
								}
								else if(Start.FireworkType.get(p.getName()) == Type.CREEPER){
									Start.FireworkType.put(p.getName(), Type.STAR);
									Fireworks.getType(inv, p, 25);
								}
								else if(Start.FireworkType.get(p.getName()) == Type.STAR){
									Start.FireworkType.put(p.getName(), Type.BALL);
									Fireworks.getType(inv, p, 25);
								}
								
							}
							else{
								Start.FireworkType.put(p.getName(), Type.BALL_LARGE);
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
							itemmeta.setDisplayName("§c§nFirework Gun§r §c(§6" + Start.FireworkPasses.get(p.getName()) + "§c)");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(6, new ItemStack(item));
						}
					}catch(Exception ex){
						
					}
					try{
						if(c.getType() == Material.EMPTY_MAP && c.getItemMeta().getDisplayName().equals("§6§l+5 Firework Passes")){
							if(Start.points.get(p.getName()) >= 2){
								
								try {
									Start.setFireworksPasses(p, Start.FireworkPasses.get(p.getName()));
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								try {
									plugin.removeVIPPoints(p, 2);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								try {
									plugin.addFireworksPasses(p, 5);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §6§l5 Firework Passes§9 for§b 2 VIP Points§9!");
								
								Inventory inv = p.getOpenInventory().getTopInventory();
								Fireworks.getVIPPasses(inv, p, 50);
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
						if(c.getType() == Material.EMPTY_MAP && c.getItemMeta().getDisplayName().equals("§6§l+25 Firework Passes")){
							if(Start.points.get(p.getName()) >= 10){
								
								try {
									Start.setFireworksPasses(p, Start.FireworkPasses.get(p.getName()));
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								try {
									plugin.removeVIPPoints(p, 10);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								try {
									plugin.addFireworksPasses(p, 25);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §6§l25 Firework Passes§9 for§b 10 VIP Points§9!");
								
								Inventory inv = p.getOpenInventory().getTopInventory();
								Fireworks.getVIPPasses(inv, p, 50);
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							p.getInventory().setItem(6, new ItemStack(item));
							
							p.sendMessage("§fActivated your §6§lStacker§b Gadget§f!");
							
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
							p.getInventory().setItem(6, new ItemStack(item));
							
							p.sendMessage("§fActivated your §f§lPaintballs§b Gadget§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 700){
								
								try {
									plugin.removeVIPPoints(p, 700);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.gadgetsPaintballs.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Gadgets-Paintballs", "paintballs", 0);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §f§lPaintballs§b Gadget§9 for§b 700 VIP Points§9!");
								p.openInventory(Gadgets.getGadgetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							p.getInventory().setItem(6, new ItemStack(item));
							
							p.sendMessage("§fActivated your §a§lCreeper Launcher§b Gadget§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 525){
								
								try {
									plugin.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.gadgetsCreeperLauncher.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Gadgets-CreeperLauncher", "launcher", 0);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §a§lCreeper Launcher§b Gadget§9 for§b 525 VIP Points§9!");
								p.openInventory(Gadgets.getGadgetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							p.getInventory().setItem(6, new ItemStack(item));
							
							p.sendMessage("§fActivated your §e§lPet Ride§b Gadget§f!");
							
						}
						else{
							if(c.getItemMeta().getLore().contains("§c§oPet Required")){
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§f§oYou §c§lDO NOT§f§o have a Pet!");
							}
							else{
								if(Start.points.get(p.getName()) >= 100){
									
									try {
										plugin.removeVIPPoints(p, 100);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									Start.gadgetsPetRide.put(p.getName(), 1);
									plugin.insertInt(p.getName(), "Gadgets-PetRide", "petride", 0);
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
									p.sendMessage("§9You've bought the §e§lPet Ride§b Gadget§9 for§b 100 VIP Points§9!");
									p.openInventory(Gadgets.getGadgetsInv(p));
								}
								else{
									p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
									p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							p.getInventory().setItem(6, new ItemStack(item));
							
							p.sendMessage("§fActivated your §7§lBook Explosion§b Gadget§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.gadgetsBookExplosion.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Gadgets-BookExplosion", "bookexplosion", 0);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7§lBook Explosion§b Gadget§9 for§b 475 VIP Points§9!");
								p.openInventory(Gadgets.getGadgetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §2Witch Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 450){
								
								try {
									plugin.removeVIPPoints(p, 450);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disWitch.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Witch", "witch", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §2Witch Disguise§9 for§b 450 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Bat Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.BAT);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §8Bat Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disBat.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Bat", "bat", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Bat Disguise§9 for§b 400 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§fChicken Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §fChicken Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 325){
								
								try {
									plugin.removeVIPPoints(p, 325);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disChicken.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Chicken", "chicken", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fChicken Disguise§9 for§b 325 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§eOcelot Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.OCELOT);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §eOcelot Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 375){
								
								try {
									plugin.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disOcelot.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Ocelot", "ocelot", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §eOcelot Disguise§9 for§b 375 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§4Mushroom Cow Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.MUSHROOM_COW);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §4Mushroom Cow Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 350){
								
								try {
									plugin.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disMushroomCow.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-MushroomCow", "mushroomcow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4Mushroom Cow Disguise§9 for§b 350 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§9Squid Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SQUID);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §9Squid Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 500){
								
								try {
									plugin.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disSquid.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Squid", "squid", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §9Squid Disguise§9 for§b 500 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§aSlime Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SLIME);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §aSlime Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 425){
								
								try {
									plugin.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disSlime.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Slime", "slime", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aSlime Disguise§9 for§b 425 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§dZombie Pigman Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.PIG_ZOMBIE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §dZombie Pigman Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disZombiePigman.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-ZombiePigman", "zombiepigman", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §dZombie Pigman Disguise§9 for§b 400 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§cMagma Cube Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.MAGMA_CUBE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §cMagma Cube Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disMagmaCube.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-MagmaCube", "magmacube", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cMagma Cube Disguise§9 for§b 475 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Skeleton Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SKELETON);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §7Skeleton Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 500){
								
								try {
									plugin.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disSkeleton.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Skeleton", "skeleton", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Skeleton Disguise§9 for§b 500 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Wolf Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.WOLF);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §7Wolf Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disWolf.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Wolf", "wolf", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Wolf Disguise§9 for§b 400 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Spider Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SPIDER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §8Spider Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 375){
								
								try {
									plugin.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disSpider.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Spider", "spider", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Spider Disguise§9 for§b 375 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Silverfish Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SILVERFISH);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §7Silverfish Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disSilverfish.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Silverfish", "silverfish", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Silverfish Disguise§9 for§b 475 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§fSheep Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.SHEEP);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §fSheep Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 375){
								
								try {
									plugin.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disSheep.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Sheep", "sheep", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fSheep Disguise§9 for§b 375 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§3Cave Spider Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.CAVE_SPIDER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §3Cave Spider Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disCaveSpider.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-CaveSpider", "cavespider", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §3Cave Spider Disguise§9 for§b 400 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§aCreeper Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.CREEPER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §aCreeper Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disCreeper.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Creeper", "creeper", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aCreeper Disguise§9 for§b 475 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Cow Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.COW);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §8Cow Disguise§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 350){
								
								try {
									plugin.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.disCow.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Dis-Cow", "cow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Cow Disguise§9 for§b 350 VIP Points§9!");
								p.openInventory(Disguises.getDisguisesInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6Blaze Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.BLAZE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §6Blaze Disguise§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §a§lEmerald VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§dPig Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.PIG);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §dPig Disguise§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §7§lIron VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§2Zombie Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.ZOMBIE);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §2Zombie Disguise§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §6§lGold VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6Villager Disguise")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							MobDisguise mob = new MobDisguise(DisguiseType.VILLAGER);
							DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§fActivated your §6Villager Disguise§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §b§lDiamond VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.FIRE){
						p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
						p.closeInventory();
						p.sendMessage("§fYour Current Disguise has been §c§lREMOVED§f!");
						DisguiseAPI.undisguiseToAll(p);
					}
				}
				if(e.getInventory().getName().equals("§0§lHats")){
					e.setCancelled(true);
					
					if(c.getType() == Material.GOLD_ORE && c.getItemMeta().getDisplayName().equals("§6Gold Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.GOLD_ORE, 1));
							
							p.sendMessage("§fActivated your §6Gold Ore Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §6§lGold VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.SMOOTH_BRICK && c.getItemMeta().getDisplayName().equals("§7Stone Bricks Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.SMOOTH_BRICK, 1));
							
							p.sendMessage("§fActivated your §7Stone Bricks Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 75){
								
								try {
									plugin.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsStoneBricks.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-StoneBricks", "stonebricks", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Stone Bricks Hat§9 for§b 75 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §aLime Stained Glass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsGreenGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-GreenGlass", "greenglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aLime Stained Glass Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.CACTUS && c.getItemMeta().getDisplayName().equals("§2Cactus Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.CACTUS, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §2Cactus Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsCactus.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Cactus", "cactus", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §2Cactus Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.EMERALD_ORE && c.getItemMeta().getDisplayName().equals("§aEmerald Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.EMERALD_ORE, 1));
							
							p.sendMessage("§fActivated your §aEmerald Ore Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §a§lEmerald VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.IRON_BLOCK && c.getItemMeta().getDisplayName().equals("§7Iron Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.IRON_BLOCK, 1));
							
							p.sendMessage("§fActivated your §7Iron Block Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §7§lIron VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.SNOW_BLOCK && c.getItemMeta().getDisplayName().equals("§fSnow Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.SNOW_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §fSnow Block Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 75){
								
								try {
									plugin.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsSnow.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Snow", "snow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fSnow Block Hat§9 for§b 75 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getDisplayName().equals("§cTNT Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.TNT, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §cTNT Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsTNT.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-TNT", "tnt", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cTNT Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.COAL_ORE && c.getItemMeta().getDisplayName().equals("§8Coal Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.COAL_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §8Coal Ore Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsCoalOre.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-CoalOre", "coalore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Coal Ore Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §8Black Stained Glass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsBlackGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-BlackGlass", "blackglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Black Stained Glass Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.GOLD_BLOCK && c.getItemMeta().getDisplayName().equals("§6Gold Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.GOLD_BLOCK, 1));
							
							p.sendMessage("§fActivated your §6Gold Block Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §6§lGold VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.FURNACE && c.getItemMeta().getDisplayName().equals("§7Furnace Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.FURNACE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §7Furnace Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsFurnace.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Furnace", "furnace", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Furnace Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§cQuartz Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.QUARTZ_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §cQuartz Ore Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsQuartzOre.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-QuartzOre", "quartzore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cQuartz Ore Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.HAY_BLOCK && c.getItemMeta().getDisplayName().equals("§eHay Bale Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.HAY_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §eHay Bale Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsHayBale.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-HayBale", "haybale", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §eHay Bale Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.REDSTONE_ORE && c.getItemMeta().getDisplayName().equals("§4Redstone Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.REDSTONE_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §4Redstone Ore Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsRedstoneOre.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-RedstoneOre", "redstoneore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4Redstone Ore Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.ICE && c.getItemMeta().getDisplayName().equals("§bIce Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.ICE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §bIce Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 150){
								
								try {
									plugin.removeVIPPoints(p, 150);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsIce.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Ice", "ice", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §bIce Hat§9 for§b 150 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§6Workbench Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.WORKBENCH, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §6Workbench Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsWorkbench.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Workbench", "workbench", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §6Workbench Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.DIAMOND_BLOCK && c.getItemMeta().getDisplayName().equals("§bDiamond Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK, 1));
							
							p.sendMessage("§fActivated your §bDiamond Block Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §b§lDiamond VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.IRON_ORE && c.getItemMeta().getDisplayName().equals("§7Iron Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.IRON_ORE, 1));
							
							p.sendMessage("§fActivated your §7Iron Ore Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §7§lIron VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.GRASS && c.getItemMeta().getDisplayName().equals("§aGrass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.GRASS, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §aGrass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsGrass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Grass", "grass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aGrass Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §4Red Stained Glass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsRedGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-RedGlass", "redglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4Red Stained Glass Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.BEDROCK && c.getItemMeta().getDisplayName().equals("§8Bedrock Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.BEDROCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §8Bedrock Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsBedrock.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Bedrock", "bedrock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Bedrock Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.LAPIS_ORE && c.getItemMeta().getDisplayName().equals("§1Lapis Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.LAPIS_ORE, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §1Lapis Ore Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsLapisOre.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-LapisOre", "lapisore", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §1Lapis Ore Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4Redstone Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §4Redstone Block Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsRedstoneBlock.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-RedstoneBlock", "redstoneblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4Redstone Block Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.QUARTZ_BLOCK && c.getItemMeta().getDisplayName().equals("§fQuartz Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §fQuartz Block Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 75){
								
								try {
									plugin.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsQuartzBlock.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-QuartzBlock", "quartzblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fQuartz Block Hat§9 for§b 75 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.LAPIS_BLOCK && c.getItemMeta().getDisplayName().equals("§1Lapis Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §1Lapis Block Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsLapisBlock.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-LapisBlock", "lapisblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §1Lapis Block Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §dMagenta Stained Glass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsMagentaGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-MagentaGlass", "magentaglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §dMagenta Stained Glass Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.COAL_BLOCK && c.getItemMeta().getDisplayName().equals("§0Coal Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §0Coal Block Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsCoalBlock.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-CoalBlock", "coalblock", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §0Coal Block Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getDisplayName().equals("§aEmerald Block Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.EMERALD_BLOCK, 1));
							
							p.sendMessage("§fActivated your §aEmerald Block Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §a§lEmerald VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.MELON_BLOCK && c.getItemMeta().getDisplayName().equals("§2Melon Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.MELON_BLOCK, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §2Melon Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 100){
								
								try {
									plugin.removeVIPPoints(p, 100);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsMelon.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Melon", "melon", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §2Melon Hat§9 for§b 100 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.GLASS && c.getItemMeta().getDisplayName().equals("§fGlass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.GLASS, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §fGlass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 150){
								
								try {
									plugin.removeVIPPoints(p, 150);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Glass", "glass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fGlass Hat§9 for§b 150 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §eYellow Stained Glass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsYellowGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-YellowGlass", "yellowglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §eYellow Stained Glass Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MYCEL && c.getItemMeta().getDisplayName().equals("§7Mycelium Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.MYCEL, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §7Mycelium Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 75){
								
								try {
									plugin.removeVIPPoints(p, 75);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsMycelium.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Mycelium", "mycelium", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Mycelium Hat§9 for§b 75 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.LEAVES && c.getItemMeta().getDisplayName().equals("§2Leaves Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.LEAVES, 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §2Leaves Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsLeaves.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-Leaves", "leaves", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §2Leaves Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.DIAMOND_ORE && c.getItemMeta().getDisplayName().equals("§bDiamond Ore Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_ORE, 1));
							
							p.sendMessage("§fActivated your §bDiamond Ore Hat§f!");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §b§lDiamond VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().equals("§6Orange Stained Glass Hat")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
							item.setDurability((short) 1);
							
							p.getInventory().setHelmet(item);
							
							p.sendMessage("§fActivated your §6Orange Stained Glass Hat§f!");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 125){
								
								try {
									plugin.removeVIPPoints(p, 125);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.hatsOrangeGlass.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Hats-OrangeGlass", "orangeglass", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §6Orange Stained Glass Hat§9 for§b 125 VIP Points§9!");
								p.openInventory(Hats.getHatsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.FIRE){
						p.getInventory().setHelmet(null);
						p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
						p.closeInventory();
						p.sendMessage("§fYour Current Hat has been §c§lREMOVED§f!");
					}
				}
				if(e.getInventory().getName().equals("§0§lTrails")){
					e.setCancelled(true);
					
					if(c.getType() == Material.FIREWORK && c.getItemMeta().getDisplayName().equals("§cFireWork Spark Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §cFireWork Spark Trail§f!");
							Start.trail.put(p, "FireWork");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsfirework.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Firework", "firework", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cFireWork Spark Trail§9 for§b 400 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§cHeart Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §cHeart Trail§f!");
							Start.trail.put(p, "Hearts");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 300){
								
								try {
									plugin.removeVIPPoints(p, 300);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailshearts.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Hearts", "hearts", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cHearts Trail§9 for§b 300 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getDisplayName().equals("§4TNT Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §4TNT Trail§f!");
							Start.trail.put(p, "TNT");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsexplode.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Explode", "explode", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4TNT Trail§9 for§b 300 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8Angry Villager Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §8Villager Trail§f!");
							Start.trail.put(p, "AngryVillager");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsangryvillager.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-AngryVillager", "angryvillager", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Angry Villager Trail§9 for§b 400 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§aSlime Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §aSlime Trail§f!");
							Start.trail.put(p, "Slime");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 275){
								
								try {
									plugin.removeVIPPoints(p, 275);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsslime.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Slime", "slime", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aSlime Trail§9 for§b 275 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§0Smoke Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §0Smoke Trail§f!");
							Start.trail.put(p, "Smoke");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 325){
								
								try {
									plugin.removeVIPPoints(p, 325);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailssmoke.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Smoke", "smoke", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §0Smoke Trail§9 for§b 325 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§5Witch Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §5Witch Trail§f!");
							Start.trail.put(p, "Witch");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 350){
								
								try {
									plugin.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailswitch.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Witch", "witch", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §5Witch Trail§9 for§b 350 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getDisplayName().equals("§bCrit Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §bCrit Trail§f!");
							Start.trail.put(p, "Crit");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 375){
								
								try {
									plugin.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailscrit.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Crit", "crit", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §bCrit Trail§9 for§b 375 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.WATER_BUCKET && c.getItemMeta().getDisplayName().equals("§9Water Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §9Water Trail§f!");
							Start.trail.put(p, "Water");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 425){
								
								try {
									plugin.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailswater.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Water", "water", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §9Water Trail§9 for§b 425 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.NOTE_BLOCK && c.getItemMeta().getDisplayName().equals("§dMusic Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §dMusic Trail§f!");
							Start.trail.put(p, "Music");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 625){
								
								try {
									plugin.removeVIPPoints(p, 625);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsnote.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Music", "music", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §dMusic Trail§9 for§b 625 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§fSnow Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §fSnow Trail§f!");
							Start.trail.put(p, "Snow");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailssnow.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Snow", "snow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fSnow Trail§9 for§b 475 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.ENCHANTMENT_TABLE && c.getItemMeta().getDisplayName().equals("§1Enchantment Table Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §1Enchantment Table Trail§f!");
							Start.trail.put(p, "EnchantmentTable");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 400){
								
								try {
									plugin.removeVIPPoints(p, 400);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsenchantmenttable.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-ETable", "etable", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §1Enchantment Table Trail§9 for§b 400 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.WEB && c.getItemMeta().getDisplayName().equals("§fBubble Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §fBubble Trail§f!");
							Start.trail.put(p, "Bubble");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 375){
								
								try {
									plugin.removeVIPPoints(p, 375);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsbubbles.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-Bubble", "bubble", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fBubble Trail§9 for§b 375 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MOB_SPAWNER && c.getItemMeta().getDisplayName().equals("§7Mob Spawner Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §7Mob Spawner Trail§f!");
							Start.trail.put(p, "MobSpawner");
							
						}
						else{
							if(Start.points.get(p.getName()) >= 525){
								
								try {
									plugin.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.trailsmobspawner.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Trails-MobSpawner", "mobspawner", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Mob Spawner Trail§9 for§b 525 VIP Points§9!");
								p.openInventory(Trails.getTrailsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§aHappy Villager Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §aHappy Villager Trail§f!");
							Start.trail.put(p, "HappyVillager");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §a§lEmerald VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§3Magic Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §3Magic Trail§f!");
							Start.trail.put(p, "Magic");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §7§lIron VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§6Lava Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §6Lava Trail§f!");
							Start.trail.put(p, "Lava");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §b§lDiamond VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Rainbow Trail")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§fActivated your §4Rainbow Trail§f!");
							Start.trail.put(p, "Rainbow");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §6§lGold VIP§c§o to use this!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.FIRE){
						if(Start.trail.containsKey(p)){
							Start.trail.remove(p);
						}
						p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
						p.closeInventory();
						p.sendMessage("§fYour Current Trail has been §c§lREMOVED§f!");
					}
				}
				if(e.getInventory().getName().equals("§0§lChatColors")){
					e.setCancelled(true);
					
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Dark Red ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §4Dark Red ChatColor§f!");
							Start.chatcolor.put(p, "4");
							try {
								plugin.setChatColor(p, "4");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolordarkred.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-DarkRed", "darkred", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4Dark Red ChatColor§9 for§b 475 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§aLight Green ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §aLight Green ChatColor§f!");
							Start.chatcolor.put(p, "a");
							try {
								plugin.setChatColor(p, "a");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 575){
								
								try {
									plugin.removeVIPPoints(p, 575);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorlightgreen.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-LightGreen", "lightgreen", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aLight Green ChatColor§9 for§b 575 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§8Dark Gray ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §8Dark Gray ChatColor§f!");
							Start.chatcolor.put(p, "8");
							try {
								plugin.setChatColor(p, "8");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolordarkgray.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-DarkGray", "darkgray", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Dark Gray ChatColor§9 for§b 250 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§cRed ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §cRed ChatColor§f!");
							Start.chatcolor.put(p, "c");
							try {
								plugin.setChatColor(p, "c");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 650){
								
								try {
									plugin.removeVIPPoints(p, 650);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorred.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-Red", "red", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cRed ChatColor§9 for§b 650 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§fWhite ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §fWhite ChatColor§f!");
							Start.chatcolor.put(p, "f");
							try {
								plugin.setChatColor(p, "f");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 500){
								
								try {
									plugin.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorwhite.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-White", "white", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fWhite ChatColor§9 for§b 500 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§bLight Blue ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §bLight Blue ChatColor§f!");
							Start.chatcolor.put(p, "b");
							try {
								plugin.setChatColor(p, "b");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 700){
								
								try {
									plugin.removeVIPPoints(p, 700);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorlightblue.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-LightBlue", "lightblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §bLight Blue ChatColor§9 for§b 700 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§dPink ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §dPink ChatColor§f!");
							Start.chatcolor.put(p, "d");
							try {
								plugin.setChatColor(p, "d");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 525){
								
								try {
									plugin.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorpink.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-Pink", "pink", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §dPink ChatColor§9 for§b 525 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§9Blue ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §9Blue ChatColor§f!");
							Start.chatcolor.put(p, "9");
							try {
								plugin.setChatColor(p, "9");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorblue.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-Blue", "blue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §9Blue ChatColor§9 for§b 475 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1Dark Blue ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §1Dark Blue ChatColor§f!");
							Start.chatcolor.put(p, "1");
							try {
								plugin.setChatColor(p, "1");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 350){
								
								try {
									plugin.removeVIPPoints(p, 350);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolordarkblue.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-DarkBlue", "darkblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §1Dark Blue ChatColor§9 for§b 350 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§7Gray ChatColor")){
						
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
						
						p.sendMessage("§fActivated your §7Gray ChatColor§f!");
						Start.chatcolor.put(p, "7");
						try {
							plugin.setChatColor(p, "7");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§2Green ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §2Green ChatColor§f!");
							Start.chatcolor.put(p, "2");
							try {
								plugin.setChatColor(p, "2");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorgreen.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-Green", "green", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §2Green ChatColor§9 for§b 475 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§0Black ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §0Black ChatColor§f!");
							Start.chatcolor.put(p, "0");
							try {
								plugin.setChatColor(p, "0");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							if(Start.points.get(p.getName()) >= 200){
								
								try {
									plugin.removeVIPPoints(p, 200);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.chatcolorblack.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "ChatColors-Black", "black", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §0Black ChatColor§9 for§b 200 VIP Points§9!");
								p.openInventory(ChatColors.getChatColors(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§eYellow ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §eYellow ChatColor§f!");
							Start.chatcolor.put(p, "e");
							try {
								plugin.setChatColor(p, "e");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §6§lGold VIP§c§o to use this!");
							
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§6Orange ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §6Orange ChatColor§f!");
							Start.chatcolor.put(p, "6");
							try {
								plugin.setChatColor(p, "6");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §a§lEmerald VIP§c§o to use this!");
							
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§5Purple ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §5Purple ChatColor§f!");
							Start.chatcolor.put(p, "5");
							try {
								plugin.setChatColor(p, "5");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §7§lIron VIP§c§o to use this!");
							
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§3Cyan ChatColor")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§fActivated your §3Cyan ChatColor§f!");
							Start.chatcolor.put(p, "3");
							try {
								plugin.setChatColor(p, "3");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§c§oYou need to be §b§lDiamond VIP§c§o to use this!");
							
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
							
							p.sendMessage("§fActivated your §fWhite Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§fWhite Armor");
								itemmeta.setColor(Color.WHITE);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§fWhite Armor");
								itemmeta.setColor(Color.WHITE);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§fWhite Armor");
								itemmeta.setColor(Color.WHITE);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.white.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-White", "white", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fWhite Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §9Blue Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§9Blue Armor");
								itemmeta.setColor(Color.BLUE);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§9Blue Armor");
								itemmeta.setColor(Color.BLUE);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§9Blue Armor");
								itemmeta.setColor(Color.BLUE);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.blue.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Blue", "blue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §9Blue Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §2Green Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§2Green Armor");
								itemmeta.setColor(Color.GREEN);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§2Green Armor");
								itemmeta.setColor(Color.GREEN);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§2Green Armor");
								itemmeta.setColor(Color.GREEN);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.green.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Green", "green", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §2Green Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §0Black Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§0Black Armor");
								itemmeta.setColor(Color.BLACK);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§0Black Armor");
								itemmeta.setColor(Color.BLACK);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§0Black Armor");
								itemmeta.setColor(Color.BLACK);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.black.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Black", "black", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §0Black Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §bLight Blue Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§bLight Blue Armor");
								itemmeta.setColor(Color.AQUA);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§bLight Blue Armor");
								itemmeta.setColor(Color.AQUA);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§bLight Blue Armor");
								itemmeta.setColor(Color.AQUA);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.lightblue.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-LightBlue", "lightblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §bLight Blue Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §dPink Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§dPink Armor");
								itemmeta.setColor(Color.FUCHSIA);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§dPink Armor");
								itemmeta.setColor(Color.FUCHSIA);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§dPink Armor");
								itemmeta.setColor(Color.FUCHSIA);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.pink.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Pink", "pink", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §dPink Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §aLight Green Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§aLight Green Armor");
								itemmeta.setColor(Color.LIME);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§aLight Green Armor");
								itemmeta.setColor(Color.LIME);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§aLight Green Armor");
								itemmeta.setColor(Color.LIME);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.lightgreen.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-LightGreen", "lightgreen", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aLight Green Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §1Dark Blue Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§1Dark Blue Armor");
								itemmeta.setColor(Color.NAVY);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§1Dark Blue Armor");
								itemmeta.setColor(Color.NAVY);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§1Dark Blue Armor");
								itemmeta.setColor(Color.NAVY);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.darkblue.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-DarkBlue", "darkblue", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §1Dark Blue Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §5Purple Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§5Purple Armor");
								itemmeta.setColor(Color.PURPLE);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§5Purple Armor");
								itemmeta.setColor(Color.PURPLE);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§5Purple Armor");
								itemmeta.setColor(Color.PURPLE);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.purple.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Purple", "purple", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §5Purple Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §6Orange Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§6Orange Armor");
								itemmeta.setColor(Color.ORANGE);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§6Orange Armor");
								itemmeta.setColor(Color.ORANGE);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§6Orange Armor");
								itemmeta.setColor(Color.ORANGE);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.orange.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Orange", "orange", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §6Orange Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §cRed Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§cRed Armor");
								itemmeta.setColor(Color.RED);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§cRed Armor");
								itemmeta.setColor(Color.RED);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§cRed Armor");
								itemmeta.setColor(Color.RED);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.red.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Red", "red", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cRed Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §3Cyan Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§3Cyan Armor");
								itemmeta.setColor(Color.TEAL);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§3Cyan Armor");
								itemmeta.setColor(Color.TEAL);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§3Cyan Armor");
								itemmeta.setColor(Color.TEAL);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.cyan.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Cyan", "cyan", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §3Cyan Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §eYellow Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§eYellow Armor");
								itemmeta.setColor(Color.YELLOW);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§eYellow Armor");
								itemmeta.setColor(Color.YELLOW);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§eYellow Armor");
								itemmeta.setColor(Color.YELLOW);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.yellow.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Yellow", "yellow", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §eYellow Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §7Gray Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§7Gray Armor");
								itemmeta.setColor(Color.GRAY);
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§7Gray Armor");
								itemmeta.setColor(Color.GRAY);
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
								LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
								itemmeta.setDisplayName("§7Gray Armor");
								itemmeta.setColor(Color.GRAY);
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							if(Start.points.get(p.getName()) >= 250){
								
								try {
									plugin.removeVIPPoints(p, 250);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.gray.put(p.getName(), 1);
								plugin.insertInt(p.getName(), "Wardrobe-Gray", "gray", 1);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Gray Armor§9 for§b 250 VIP Points§9!");
								p.openInventory(Wardrobe.getWardrobeInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
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
							
							p.sendMessage("§fActivated your §7Iron Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§7Iron Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§7Iron Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§7Iron Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							p.sendMessage("§c§oYou need to be§7§l Iron VIP§c§o to use this!");
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
							
							p.sendMessage("§fActivated your §6Gold Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§6Gold Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.GOLD_LEGGINGS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§6Gold Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.GOLD_BOOTS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§6Gold Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							p.sendMessage("§c§oYou need to be§6§l Gold VIP§c§o to use this!");
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
							
							p.sendMessage("§fActivated your §bDiamond Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§bDiamond Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§bDiamond Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§bDiamond Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							p.sendMessage("§c§oYou need to be§b§l Diamond VIP§c§o to use this!");
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
							
							p.sendMessage("§fActivated your §7Chainmail Armor§f!");
							
							{
								ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§7Chainmail Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setChestplate(item);
							}
							{
								ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§7Chainmail Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setLeggings(item);
							}
							{
								ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
								ItemMeta itemmeta = item.getItemMeta();
								itemmeta.setDisplayName("§7Chainmail Armor");
								item.setItemMeta(itemmeta);
								p.getInventory().setBoots(item);
							}
						}
						else{
							p.sendMessage("§c§oYou need to be§a§l Emerald VIP§c§o to use this!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					
					if(c.getType() == Material.FIRE){

						p.sendMessage("§fCurrent Armor has been §c§lREMOVED§f!");
						p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
						p.closeInventory();
						p.getInventory().setChestplate(null);
						p.getInventory().setLeggings(null);
						p.getInventory().setBoots(null);
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				if(e.getInventory().getName().equals("§0§lPets")){
					e.setCancelled(true);
					
					if(c.getType() == Material.FIRE){
						if(Start.ownerpets.containsKey(p)){
							p.sendMessage("§fPet §c§lDISABLED§f!");
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
							
							for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
								if(en.getUniqueId() == Start.ownerpets.get(p)){
									if(en instanceof LivingEntity){
										en.remove();
										Start.owners.remove(Start.ownerpets.get(p));
										Start.ownerpets.remove(p);
									}
								}
							}
						}
						else{
							p.sendMessage("§fYou don't have a Pet activated!");
						}
					}
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§4Mushroom Cow Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomMushroomCow cow = new CustomMushroomCow(nmsWorld);
						    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(cow);
							cow.setAge(1);
							cow.setCustomName(Start.mushroomcow.get(p.getName()));
							cow.setCustomNameVisible(true);
							
							final UUID petID = cow.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.COW_HURT, 5, 1);
							p.sendMessage("§fActivated your §4Mushroom Cow Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.mushroomcow.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-MushroomCow", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §4Mushroom Cow Pet§9 for§b 475 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§dPig Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomPig pig = new CustomPig(nmsWorld);
						    pig.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(pig);
							pig.setAge(1);
							pig.setCustomName(Start.pig.get(p.getName()));
							pig.setCustomNameVisible(true);
							
							final UUID petID = pig.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PIG_DEATH, 5, 1);
							p.sendMessage("§fActivated your §dPig Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 425){
								
								try {
									plugin.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.pig.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Pig", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §dPig Pet§9 for§b 425 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Wolf Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomWolf wolf = new CustomWolf(nmsWorld);
						    wolf.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(wolf);
							wolf.setAge(1);
							wolf.setCustomName(Start.wolf.get(p.getName()));
							wolf.setCustomNameVisible(true);
							
							final UUID petID = wolf.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.WOLF_BARK, 5, 1);
							p.sendMessage("§fActivated your §7Wolf Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.wolf.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Wolf", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Wolf Pet§9 for§b 475 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§fSheep Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomSheep sheep = new CustomSheep(nmsWorld);
						    sheep.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(sheep);
							sheep.setAge(1);
							sheep.setCustomName(Start.sheep.get(p.getName()));
							sheep.setCustomNameVisible(true);
							
							final UUID petID = sheep.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 5, 1);
							p.sendMessage("§fActivated your §fSheep Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 425){
								
								try {
									plugin.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.sheep.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Sheep", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §fSheep Pet§9 for§b 425 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6Horse Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							

							Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
							horse.setAdult();
							horse.setCustomName(Start.horse.get(p.getName()));
							horse.setCustomNameVisible(true);
							horse.setTamed(true);
							horse.setRemoveWhenFarAway(false);
							horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
							horse.setColor(Horse.Color.BROWN);
							horse.setStyle(Style.WHITE);
							
							final UUID petID = horse.getUniqueId();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.HORSE_HIT, 5, 1);
							p.sendMessage("§fActivated your §6Horse Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 525){
								
								try {
									plugin.removeVIPPoints(p, 525);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.horse.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Horse", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §6Horse Pet§9 for§b 525 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§cMagma Cube Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomMagmaCube magmacube = new CustomMagmaCube(nmsWorld);
						    magmacube.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(magmacube);
							magmacube.setSize(3);
							magmacube.setCustomName(Start.magmacube.get(p.getName()));
							magmacube.setCustomNameVisible(true);
							
							final UUID petID = magmacube.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SLIME_WALK, 5, 1);
							p.sendMessage("§fActivated your §cMagma Cube Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 500){
								
								try {
									plugin.removeVIPPoints(p, 500);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.magmacube.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-MagmaCube", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §cMagma Cube Pet§9 for§b 500 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§aSlime Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomSlime slime = new CustomSlime(nmsWorld);
						    slime.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(slime);
							slime.setSize(3);
							slime.setCustomName(Start.slime.get(p.getName()));
							slime.setCustomNameVisible(true);
							
							final UUID petID = slime.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SLIME_WALK, 5, 1);
							p.sendMessage("§fActivated your §aSlime Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 475){
								
								try {
									plugin.removeVIPPoints(p, 475);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.slime.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Slime", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §aSlime Pet§9 for§b 475 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§8Cow Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomCow cow = new CustomCow(nmsWorld);
						    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(cow);
							cow.setAge(1);
							cow.setCustomName(Start.cow.get(p.getName()));
							cow.setCustomNameVisible(true);
							
							final UUID petID = cow.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.COW_HURT, 5, 1);
							p.sendMessage("§fActivated your §8Cow Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 425){
								
								try {
									plugin.removeVIPPoints(p, 425);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.cow.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Cow", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §8Cow Pet§9 for§b 425 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7Silverfish Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomSilverfish silverfish = new CustomSilverfish(nmsWorld);
						    silverfish.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(silverfish);
							silverfish.setCustomName(Start.silverfish.get(p.getName()));
							silverfish.setCustomNameVisible(true);
							
							final UUID petID = silverfish.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SILVERFISH_HIT, 5, 1);
							p.sendMessage("§fActivated your §7Silverfish Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 450){
								
								try {
									plugin.removeVIPPoints(p, 450);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.silverfish.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Silverfish", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought the §7Silverfish Pet§9 for§b 450 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
					if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§eOcelot Pet")){
						if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(Start.ownerpets.containsKey(p)){
								
								
								for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
									if(en.getUniqueId() == Start.ownerpets.get(p)){
										if(en instanceof LivingEntity){
											en.remove();
											Start.owners.remove(Start.ownerpets.get(p));
											Start.ownerpets.remove(p);
										}
									}
								}
							}
							
							Location loc = p.getLocation();
							
						    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
						    CustomOcelot ocelot = new CustomOcelot(nmsWorld);
						    ocelot.setPosition(loc.getX(), loc.getY(), loc.getZ());
						    nmsWorld.addEntity(ocelot);
							ocelot.setAge(1);
							ocelot.setCustomName(Start.ocelot.get(p.getName()));
							ocelot.setCustomNameVisible(true);
							
							final UUID petID = ocelot.getUniqueID();
							Start.owners.put(petID, p);
							Start.ownerpets.put(p, petID);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CAT_MEOW, 5, 1);
							p.sendMessage("§fActivated your §eOcelot Pet§f!");
						}
						else{
							if(Start.points.get(p.getName()) >= 450){
								
								try {
									plugin.removeVIPPoints(p, 450);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Start.ocelot.put(p.getName(), p.getName() + "s Pet");
								plugin.insertString(p.getName(), "Pets-Ocelot", "petname", p.getName() + "s Pet");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9You've bought te §eOcelot Pet§9 for§b 450 VIP Points§9!");
								p.openInventory(Pets.getPetsInv(p));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage("§9You don't have enough§b VIP Points§9!");
							}
						}
					}
				}
				
				if(!p.isOp() && !p.getWorld().getName().equals("SkyBlockWorld")){
					e.setCancelled(true);
				}
			}
		}catch(Exception ex){
			
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
