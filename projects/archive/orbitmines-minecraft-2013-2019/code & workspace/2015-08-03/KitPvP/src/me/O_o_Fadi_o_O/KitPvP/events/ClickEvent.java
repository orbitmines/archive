package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.BoosterInv;
import me.O_o_Fadi_o_O.KitPvP.DisguisePlayer;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.Inv.ChatColors;
import me.O_o_Fadi_o_O.KitPvP.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.KitPvP.Inv.OMTShop;
import me.O_o_Fadi_o_O.KitPvP.Inv.PetRenameGUI;
import me.O_o_Fadi_o_O.KitPvP.Inv.Pets;
import me.O_o_Fadi_o_O.KitPvP.Inv.Trails;
import me.O_o_Fadi_o_O.KitPvP.managers.ConfirmManager;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.ChatColor;
import me.O_o_Fadi_o_O.KitPvP.utils.Currency;
import me.O_o_Fadi_o_O.KitPvP.utils.Pet;
import me.O_o_Fadi_o_O.KitPvP.utils.ReflectionUtil;
import me.O_o_Fadi_o_O.KitPvP.utils.Server;
import me.O_o_Fadi_o_O.KitPvP.utils.StaffRank;
import me.O_o_Fadi_o_O.KitPvP.utils.Trail;
import me.O_o_Fadi_o_O.KitPvP.utils.TrailType;
import me.O_o_Fadi_o_O.KitPvP.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ClickEvent implements Listener {
	
	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		if(e.getWhoClicked() instanceof Player){
			
			final Player p = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.loaded.get(p) == true){
					if(StorageManager.opmodeenabled.get(p) == false){
						e.setResult(Result.DENY);
						new BukkitRunnable(){
							public void run(){
								p.updateInventory();
							}
						}.runTaskLater(this.start, 1);
					}
				}
			}
			
			if(e.getInventory().getName() != null && item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
				if(e.getInventory().getName().equals("§0§lServer Selector")){
					e.setCancelled(true);
					
					if(item.getType() == Material.IRON_SWORD){
						start.teleportToServer(p, Server.KITPVP);
					}
					if(item.getType() == Material.DIAMOND_PICKAXE){
						start.teleportToServer(p, Server.PRISON);
					}
					if(item.getType() == Material.WOOD_AXE){
						start.teleportToServer(p, Server.CREATIVE);
					}
					if(item.getType() == Material.WATCH){
						start.teleportToServer(p, Server.HUB);
					}
					if(item.getType() == Material.STONE_HOE){
						start.teleportToServer(p, Server.SURVIVAL);
					}
					if(item.getType() == Material.FISHING_ROD){
						start.teleportToServer(p, Server.SKYBLOCK);
					}
					if(item.getType() == Material.BOW){
						start.teleportToServer(p, Server.MINIGAMES);
					}
				}
				if(e.getInventory().getName().equals("§0§lOMT Shop")){
					e.setCancelled(true);
					if(item.getType() == Material.GOLD_NUGGET && item.getItemMeta().getDisplayName().equals("§6§l+200 Coins")){
						if(StorageManager.orbitminestokens.get(p) >= 1){
							p.openInventory(ConfirmManager.getConfirmInv(item, Currency.ORBITMINES_TOKENS, 1));
						}
						else{
							PlayerManager.sendOMTRequiredMessage(p, 1);
						}
					}
					if(item.getType() == Material.GOLD_NUGGET && item.getItemMeta().getDisplayName().equals("§6§l+1000 Coins")){
						if(StorageManager.orbitminestokens.get(p) >= 4){
							p.openInventory(ConfirmManager.getConfirmInv(item, Currency.ORBITMINES_TOKENS, 4));
						}
						else{
							PlayerManager.sendOMTRequiredMessage(p, 4);
						}
					}
					if(item.getType() == Material.GOLD_NUGGET && item.getItemMeta().getDisplayName().equals("§6§l+2500 Coins")){
						if(StorageManager.orbitminestokens.get(p) >= 9){
							p.openInventory(ConfirmManager.getConfirmInv(item, Currency.ORBITMINES_TOKENS, 9));
						}
						else{
							PlayerManager.sendOMTRequiredMessage(p, 9);
						}
					}
					if(item.getType() == Material.GOLD_NUGGET && item.getItemMeta().getDisplayName().equals("§6§l+5000 Coins")){
						if(StorageManager.orbitminestokens.get(p) >= 16){
							p.openInventory(ConfirmManager.getConfirmInv(item, Currency.ORBITMINES_TOKENS, 16));
						}
						else{
							PlayerManager.sendOMTRequiredMessage(p, 16);
						}
					}
				}
				/*
				if(e.getInventory().getName().equals("§0§lSettings (" + p.getName() + ")")){
					e.setCancelled(true);
				
					if(item.getType() == Material.EYE_OF_ENDER && item.getItemMeta().getDisplayName().startsWith("§3§lPlayers")){
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						
						if(StorageManager.playersenabled.get(p) == true){
							p.sendMessage("§3§l§oPlayers §c§lDISABLED");
							
							for(Player player : Bukkit.getOnlinePlayers()){
								p.hidePlayer(player);
							}
							
							DatabaseManager.setPlayersEnabled(p, false);
							p.closeInventory();
						}
						else{
							p.sendMessage("§3§l§oPlayers §a§lENABLED");
							
							for(final Player player : Bukkit.getOnlinePlayers()){
								p.showPlayer(player);
								if(StorageManager.disguise.containsKey(player)){
					    			new BukkitRunnable(){
					    				public void run(){
						        			DisguisePlayer.disguisePlayer(player, StorageManager.disguise.get(player), p);
					    				}
					    			}.runTaskLater(this.hub, 1);
								}
							}
							
							DatabaseManager.setPlayersEnabled(p, true);
						}
						p.closeInventory();
					}
					if(item.getType() == Material.LEASH && item.getItemMeta().getDisplayName().startsWith("§6§lStacker")){
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						
						if(StorageManager.stackerenabled.get(p) == true){
							p.sendMessage("§6§l§oStacker §c§lDISABLED");

							DatabaseManager.setStackerEnabled(p, false);

							p.closeInventory();
						}
						else{
							p.sendMessage("§6§l§oStacker §a§lENABLED");

							DatabaseManager.setStackerEnabled(p, true);

						}
						p.closeInventory();
					}
					if(item.getType() == Material.PAPER && item.getItemMeta().getDisplayName().startsWith("§f§lScoreboard")){
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						
						if(StorageManager.scoreboardenabled.get(p) == true){
							p.sendMessage("§f§l§oScoreboard §c§lDISABLED");

							DatabaseManager.setScoreboardEnabled(p, false);

							p.closeInventory();
							
							p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
						}
						else{
							p.sendMessage("§f§l§oScoreboard §a§lENABLED");

							DatabaseManager.setScoreboardEnabled(p, true);
						}
						p.closeInventory();
					}
				}
				*/
				if(e.getInventory().getName().equals("§0§lCosmetic Perks")){
					e.setCancelled(true);
				
					if(item.getType() == Material.MONSTER_EGG){
						p.openInventory(Pets.getPetsInv(p));
					}
					if(item.getType() == Material.INK_SACK){
						p.openInventory(ChatColors.getChatColors(p));
					}
					if(item.getType() == Material.SKULL_ITEM){
						//p.openInventory(Disguises.getDisguisesInv(p));
					}
					if(item.getType() == Material.COMPASS){
						//p.openInventory(Gadgets.getGadgetsInv(p));
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE){
						//p.openInventory(Wardrobe.getWardrobeInv(p));
					}
					if(item.getType() == Material.STRING){
						p.openInventory(Trails.getTrailsInv(p));
					}
					if(item.getType() == Material.PUMPKIN){
						//p.openInventory(Hats.getHatsInv(p));
					}
					if(item.getType() == Material.FIREWORK){
						//Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
						//Fireworks.getFireworksInv(p, inv);
					}
				}
				/*
				if(e.getInventory().getName().equals("§0§lFireworks")){
					e.setCancelled(true);
				
					if(item.getItemMeta().getDisplayName().startsWith("§7Color 1:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextColor1(p, inv);
					}
					if(item.getItemMeta().getDisplayName().startsWith("§7Color 2:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextColor2(p, inv);
					}
					if(item.getItemMeta().getDisplayName().startsWith("§7Fade 1:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextFade1(p, inv);
					}
					if(item.getItemMeta().getDisplayName().startsWith("§7Fade 2:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextFade2(p, inv);
					}
					if(item.getItemMeta().getDisplayName().startsWith("§7Trail:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextTrail(p, inv);
					}
					if(item.getItemMeta().getDisplayName().startsWith("§7Flicker:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextFlicker(p, inv);
					}
					if(item.getItemMeta().getDisplayName().startsWith("§7Type:")){
						Inventory inv = p.getOpenInventory().getTopInventory();
						Fireworks.getNextType(p, inv);
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(item.getType() == Material.ANVIL){
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, 1);
						
						ItemStack i = new ItemStack(Material.FIREBALL, 1);
						ItemMeta imeta = i.getItemMeta();
						imeta.setDisplayName("§c§nFirework Gun§r §c(§6" + StorageManager.fireworkpasses.get(p) + "§c)");
						i.setItemMeta(imeta);
						p.getInventory().setItem(5, new ItemStack(i));
						
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §c§lFirework Gun§7.");
					}
					if(item.getType() == Material.EMPTY_MAP && item.getItemMeta().getDisplayName().equals("§6§l+5 Firework Passes")){
						if(StorageManager.vippoints.get(p) >= 2){
							p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 2));
						}
						else{
							PlayerManager.sendVIPPointsRequiredMessage(p, 2);
						}
					}
					if(item.getType() == Material.EMPTY_MAP && item.getItemMeta().getDisplayName().equals("§6§l+25 Firework Passes")){
						if(StorageManager.vippoints.get(p) >= 10){
							p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 10));
						}
						else{
							PlayerManager.sendVIPPointsRequiredMessage(p, 10);
						}
					}
				}
				*/
				/*
				if(e.getInventory().getName().equals("§0§lHats")){
					e.setCancelled(true);
				
					if(item.getType() == Material.EMPTY_MAP && item.getItemMeta().getDisplayName().equals("§e§nMore Hats >>")){
						int page = StorageManager.hatsinvpage.get(p) +1;
						StorageManager.hatsinvpage.put(p, page);
						Hats.setInvPage(e.getInventory(), p, page);
					}
					if(item.getType() == Material.EMPTY_MAP && item.getItemMeta().getDisplayName().equals("§e§n<< More Hats")){
						int page = StorageManager.hatsinvpage.get(p) -1;
						StorageManager.hatsinvpage.put(p, page);
						Hats.setInvPage(e.getInventory(), p, page);
					}
					
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7Hat Block Trail:")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Hat Block Trail§7.");
								
								DatabaseManager.setBlockTrailHats(p, true);
							}
							if(item.getItemMeta().getDisplayName().endsWith("ENABLED")){
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7Hat Block Trail§7!");
								
								DatabaseManager.setBlockTrailHats(p, false);
							}
						}
						else{
							if(StorageManager.hasunlockedhat.get(p) == true){
								if(StorageManager.vippoints.get(p) >= 750){
									p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 750));
								}
								else{
									PlayerManager.sendVIPPointsRequiredMessage(p, 750);
								}
							}
							else{
								p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6An Hat§7!");
							}
						}
					}
					if(item.getType() == Material.GOLD_ORE && item.getItemMeta().getDisplayName().equals("§6Gold Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.GOLD_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Gold Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(item.getType() == Material.SMOOTH_BRICK && item.getItemMeta().getDisplayName().equals("§7Stone Bricks Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.SMOOTH_BRICK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Stone Bricks Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 75){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 75));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 75);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§aLime Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 5);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aLime Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.CACTUS && item.getItemMeta().getDisplayName().equals("§2Cactus Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.CACTUS, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Cactus Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.EMERALD_ORE && item.getItemMeta().getDisplayName().equals("§aEmerald Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.EMERALD_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aEmerald Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(item.getType() == Material.IRON_BLOCK && item.getItemMeta().getDisplayName().equals("§7Iron Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.IRON_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Iron Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(item.getType() == Material.SNOW_BLOCK && item.getItemMeta().getDisplayName().equals("§fSnow Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.SNOW_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSnow Block Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 75){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 75));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 75);
							}
						}
					}
					if(item.getType() == Material.TNT && item.getItemMeta().getDisplayName().equals("§cTNT Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.TNT, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cTNT Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.COAL_ORE && item.getItemMeta().getDisplayName().equals("§8Coal Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.COAL_ORE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Coal Ore Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§8Black Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 15);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Black Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.GOLD_BLOCK && item.getItemMeta().getDisplayName().equals("§6Gold Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.GOLD_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Gold Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(item.getType() == Material.FURNACE && item.getItemMeta().getDisplayName().equals("§7Furnace Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.FURNACE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Furnace Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.QUARTZ_ORE && item.getItemMeta().getDisplayName().equals("§cQuartz Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.QUARTZ_ORE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cQuartz Ore Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.HAY_BLOCK && item.getItemMeta().getDisplayName().equals("§eHay Bale Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.HAY_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eHay Bale Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.REDSTONE_ORE && item.getItemMeta().getDisplayName().equals("§4Redstone Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.REDSTONE_ORE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Redstone Ore Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.ICE && item.getItemMeta().getDisplayName().equals("§bIce Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.ICE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bIce Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 150){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 150));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 150);
							}
						}
					}
					if(item.getType() == Material.WORKBENCH && item.getItemMeta().getDisplayName().equals("§6Workbench Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.WORKBENCH, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Workbench Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.DIAMOND_BLOCK && item.getItemMeta().getDisplayName().equals("§bDiamond Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bDiamond Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(item.getType() == Material.IRON_ORE && item.getItemMeta().getDisplayName().equals("§7Iron Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.IRON_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Iron Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(item.getType() == Material.GRASS && item.getItemMeta().getDisplayName().equals("§aGrass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.GRASS, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aGrass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§4Red Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 14);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Red Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.BEDROCK && item.getItemMeta().getDisplayName().equals("§8Bedrock Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.BEDROCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Bedrock Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.LAPIS_ORE && item.getItemMeta().getDisplayName().equals("§1Lapis Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.LAPIS_ORE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Lapis Ore Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.REDSTONE_BLOCK && item.getItemMeta().getDisplayName().equals("§4Redstone Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.REDSTONE_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Redstone Block Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.QUARTZ_BLOCK && item.getItemMeta().getDisplayName().equals("§fQuartz Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.QUARTZ_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fQuartz Block Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 75){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 75));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 75);
							}
						}
					}
					if(item.getType() == Material.LAPIS_BLOCK && item.getItemMeta().getDisplayName().equals("§1Lapis Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.LAPIS_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Lapis Block Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§dMagenta Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 2);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dMagenta Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.COAL_BLOCK && item.getItemMeta().getDisplayName().equals("§0Coal Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.COAL_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Coal Block Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.EMERALD_BLOCK && item.getItemMeta().getDisplayName().equals("§aEmerald Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.EMERALD_BLOCK, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aEmerald Block Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(item.getType() == Material.MELON_BLOCK && item.getItemMeta().getDisplayName().equals("§2Melon Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.MELON_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Melon Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.GLASS && item.getItemMeta().getDisplayName().equals("§fGlass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.GLASS, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fGlass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 150){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 150));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 150);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§eYellow Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 4);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eYellow Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.MYCEL && item.getItemMeta().getDisplayName().equals("§7Mycelium Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.MYCEL, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Mycelium Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 75){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 75));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 75);
							}
						}
					}
					if(item.getType() == Material.LEAVES && item.getItemMeta().getDisplayName().equals("§2Leaves Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.LEAVES, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Leaves Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.DIAMOND_ORE && item.getItemMeta().getDisplayName().equals("§bDiamond Ore Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_ORE, 1));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bDiamond Ore Hat§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§6Orange Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Orange Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.STONE && item.getItemMeta().getDisplayName().equals("§fPolished Diorite Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STONE, 1);
							i.setDurability((short) 4);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fPolished Diorite Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.PRISMARINE && item.getItemMeta().getDisplayName().equals("§3Dark Prismarine Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.PRISMARINE, 1);
							i.setDurability((short) 2);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Dark Prismarine Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 150){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 150));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 150);
							}
						}
					}
					if(item.getType() == Material.SPONGE && item.getItemMeta().getDisplayName().equals("§eSponge Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.SPONGE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eSponge Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.SLIME_BLOCK && item.getItemMeta().getDisplayName().equals("§aSlime Block Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.SLIME_BLOCK, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aSlime Block Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 200){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 200));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 200);
							}
						}
					}
					if(item.getType() == Material.SEA_LANTERN && item.getItemMeta().getDisplayName().equals("§fSea Lantern Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.SEA_LANTERN, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSea Lantern Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 225){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 225));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 225);
							}
						}
					}
					if(item.getType() == Material.PRISMARINE && item.getItemMeta().getDisplayName().equals("§9Prismarine Bricks Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.PRISMARINE, 1);
							i.setDurability((short) 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Prismarine Bricks Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 150){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 150));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 150);
							}
						}
					}
					if(item.getType() == Material.STONE && item.getItemMeta().getDisplayName().equals("§cPolished Granite Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STONE, 1);
							i.setDurability((short) 2);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cPolished Granite Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.ENDER_CHEST && item.getItemMeta().getDisplayName().equals("§3EnderChest Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.ENDER_CHEST, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3EnderChest Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 175){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 175));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 175);
							}
						}
					}
					if(item.getType() == Material.GLOWSTONE && item.getItemMeta().getDisplayName().equals("§6Glowstone Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.GLOWSTONE, 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Glowstone Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 200){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 200));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 200);
							}
						}
					}
					if(item.getType() == Material.SPONGE && item.getItemMeta().getDisplayName().equals("§eWet Sponge Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.SPONGE, 1);
							i.setDurability((short) 1);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eWet Sponge Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 125){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 125));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 125);
							}
						}
					}
					if(item.getType() == Material.STONE && item.getItemMeta().getDisplayName().equals("§7Polished Andesite Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STONE, 1);
							i.setDurability((short) 6);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Polished Andesite Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS && item.getItemMeta().getDisplayName().equals("§1Blue Stained Glass Hat")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							if(PlayerManager.hasHat(p)){
								PlayerManager.removeHat(p);
							}
							
							ItemStack i = new ItemStack(Material.STAINED_GLASS, 1);
							i.setDurability((short) 11);
							
							p.getInventory().setHelmet(i);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Blue Stained Glass Hat§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 100){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 100));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 100);
							}
						}
					}
					if(item.getType() == Material.ENDER_CHEST && !item.getItemMeta().getDisplayName().equals("§3EnderChest Hat")){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(item.getType() == Material.LAVA_BUCKET){
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
				*/
				/*
				if(e.getInventory().getName().equals("§0§lGadgets")){
					e.setCancelled(true);
					
					if(item.getType() == Material.LEASH && item.getItemMeta().getDisplayName().equals("§6§lStacker")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.LEASH, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§6§nStacker");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6§lStacker§7.");
						}
						else{
							//Already Unlocked
						}
					}
					if(item.getType() == Material.SNOW_BALL && item.getItemMeta().getDisplayName().equals("§f§lPaintballs")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.SNOW_BALL, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§f§nPaintballs");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f§lPaintballs§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 700){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 700));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 700);
							}
						}
					}
					if(item.getType() == Material.SKULL_ITEM && item.getItemMeta().getDisplayName().equals("§a§lCreeper Launcher")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.SKULL_ITEM, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§a§nCreeper Launcher");
							i.setItemMeta(imeta);
							i.setDurability((short) 4);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §a§lCreeper Launcher§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 525){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 525));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 525);
							}
						}
					}
					if(item.getType() == Material.SADDLE && item.getItemMeta().getDisplayName().equals("§e§lPet Ride")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.SADDLE, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§e§nPet Ride");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §e§lPet Ride§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.BOOK && item.getItemMeta().getDisplayName().equals("§7§lBook Explosion")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.BOOK, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§7§nBook Explosion");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lBook Explosion§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.EYE_OF_ENDER && item.getItemMeta().getDisplayName().equals("§2§lSwap Teleporter")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.EYE_OF_ENDER, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§2§nSwap Teleporter");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2§lSwap Teleporter§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MAGMA_CREAM && item.getItemMeta().getDisplayName().equals("§c§lMagmaCube Soccer")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.MAGMA_CREAM, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§c§nMagmaCube Soccer");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §c§lMagmaCube Soccer§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 1000){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 1000));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 1000);
							}
						}
					}
					if(item.getType() == Material.PUMPKIN && item.getItemMeta().getDisplayName().equals("§6§lSnowman Attack")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							ItemStack i = new ItemStack(Material.PUMPKIN, 1);
							ItemMeta imeta = i.getItemMeta();
							imeta.setDisplayName("§6§nSnowman Attack");
							i.setItemMeta(imeta);
							p.getInventory().setItem(5, new ItemStack(i));
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6§lSnowman Attack§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 1200){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 1200));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 1200);
							}
						}
					}
					try{
						if(item.getItemMeta().getLore().contains("§c§lDISABLE §bGadget")){
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
							PlayerManager.removeGadget(p);
						}
					}catch(Exception ex){}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				*/
				if(e.getInventory().getName().equals("§0§lTrails")){
					e.setCancelled(true);
					
					if(item.getType() == Material.FIREWORK && item.getItemMeta().getDisplayName().equals("§cFireWork Spark Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cFireWork Spark Trail§7.");
							StorageManager.trail.put(p, Trail.FIREWORK_SPARK);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.NETHER_STALK && item.getItemMeta().getDisplayName().equals("§cHeart Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cHeart Trail§7.");
							StorageManager.trail.put(p, Trail.HEART);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 300){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 300));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 300);
							}
						}
					}
					if(item.getType() == Material.TNT && item.getItemMeta().getDisplayName().equals("§4TNT Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4TNT Trail§7.");
							StorageManager.trail.put(p, Trail.TNT);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.COAL && item.getItemMeta().getDisplayName().equals("§8Angry Villager Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Angry Villager Trail§7.");
							StorageManager.trail.put(p, Trail.ANGRY_VILLAGER);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.SLIME_BALL && item.getItemMeta().getDisplayName().equals("§aSlime Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aSlime Trail§7.");
							StorageManager.trail.put(p, Trail.SLIME);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 275){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 275));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 275);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§0Smoke Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Smoke Trail§7.");
							StorageManager.trail.put(p, Trail.SMOKE);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 325){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 325));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 325);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§5Witch Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §5Witch Trail§7.");
							StorageManager.trail.put(p, Trail.WITCH);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 350){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 350));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 350);
							}
						}
					}
					if(item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals("§bCrit Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bCrit Trail§7.");
							StorageManager.trail.put(p, Trail.CRIT);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 375){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 375));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 375);
							}
						}
					}
					if(item.getType() == Material.WATER_BUCKET && item.getItemMeta().getDisplayName().equals("§9Water Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Water Trail§7.");
							StorageManager.trail.put(p, Trail.WATER);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 425){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 425));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 425);
							}
						}
					}
					if(item.getType() == Material.NOTE_BLOCK && item.getItemMeta().getDisplayName().equals("§dMusic Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dMusic Trail§7.");
							StorageManager.trail.put(p, Trail.MUSIC);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 625){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 625));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 625);
							}
						}
					}
					if(item.getType() == Material.SNOW_BALL && item.getItemMeta().getDisplayName().equals("§fSnow Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSnow Trail§7.");
							StorageManager.trail.put(p, Trail.SNOW);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.ENCHANTMENT_TABLE && item.getItemMeta().getDisplayName().equals("§1Enchantment Table Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Enchantment Table Trail§7.");
							StorageManager.trail.put(p, Trail.ENCHANTMENT_TABLE);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.WEB && item.getItemMeta().getDisplayName().equals("§fBubble Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fBubble Trail§7.");
							StorageManager.trail.put(p, Trail.BUBBLE);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 375){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 375));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 375);
							}
						}
					}
					if(item.getType() == Material.MOB_SPAWNER && item.getItemMeta().getDisplayName().equals("§7Mob Spawner Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Mob Spawner Trail§7.");
							StorageManager.trail.put(p, Trail.MOB_SPAWNER);
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 525){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 525));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 525);
							}
						}
					}
					if(item.getType() == Material.EMERALD && item.getItemMeta().getDisplayName().equals("§aHappy Villager Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aHappy Villager Trail§7.");
							StorageManager.trail.put(p, Trail.HAPPY_VILLAGER);
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§3Magic Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Magic Trail§7.");
							StorageManager.trail.put(p, Trail.MAGIC);
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(item.getType() == Material.LAVA_BUCKET && item.getItemMeta().getDisplayName().equals("§6Lava Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Lava Trail§7.");
							StorageManager.trail.put(p, Trail.LAVA);
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(item.getType() == Material.REDSTONE && item.getItemMeta().getDisplayName().equals("§4Rainbow Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Rainbow Trail§7.");
							StorageManager.trail.put(p, Trail.RAINBOW);
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(item.getType() == Material.REDSTONE_COMPARATOR && item.getItemMeta().getDisplayName().equals("§f§nTrail Settings")){
						if(StorageManager.hasunlockedtrail.get(p) == true){
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED§7! Required: §fA Trail§7.");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(item.getType() == Material.LAVA_BUCKET && !item.getItemMeta().getDisplayName().equals("§6Lava Trail")){
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
				/*
				if(e.getInventory().getName().equals("§0§lWardrobe")){
					e.setCancelled(true);
					
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().endsWith("Disco Armor")){
						
						if(StorageManager.wardrobeunlockedcolors.get(p).size() >= 2){
							if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
								p.closeInventory();
								if(PlayerManager.hasWardrobeArmor(p)){
									PlayerManager.removeWardrobeArmor(p);
								}
								DatabaseManager.setDiscoWardrobe(p, true);
								
								p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your " + item.getItemMeta().getDisplayName() +"§7.");
								
								PlayerManager.giveLeatherWardrobeArmor(p, ((LeatherArmorMeta) item.getItemMeta()).getColor(), item.getItemMeta().getDisplayName());
							}
							else{
								if(StorageManager.vippoints.get(p) >= 500){
									p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
								}
								else{
									PlayerManager.sendVIPPointsRequiredMessage(p, 500);
								}
							}
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: " + item.getItemMeta().getLore().get(3).substring(14));
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§fWhite Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fWhite Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.WHITE, "§fWhite Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§9Blue Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Blue Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.BLUE, "§9Blue Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§2Green Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Green Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.GREEN, "§2Green Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§0Black Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Black Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.BLACK, "§0Black Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§bLight Blue Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bLight Blue Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.AQUA, "§bLight Blue Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§dPink Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dPink Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.FUCHSIA, "§dPink Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§aLight Green Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aLight Green Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.LIME, "§aLight Green Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§1Dark Blue Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Dark Blue Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.NAVY, "§1Dark Blue Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§5Purple Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §5Purple Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.PURPLE, "§5Purple Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§6Orange Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Orange Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.ORANGE, "§6Orange Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§cRed Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cRed Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.RED, "§cRed Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§3Cyan Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Cyan Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.TEAL, "§3Cyan Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§eYellow Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eYellow Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.YELLOW, "§eYellow Armor");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§7Gray Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Gray Armor§7.");
							
							PlayerManager.giveLeatherWardrobeArmor(p, Color.GRAY, "§7Gray Armor");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.IRON_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§7Iron Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Iron Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, "§7Iron Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(item.getType() == Material.GOLD_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§6Gold Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Gold Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, "§6Gold Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(item.getType() == Material.DIAMOND_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§bDiamond Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bDiamond Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, "§bDiamond Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					if(item.getType() == Material.CHAINMAIL_CHESTPLATE && item.getItemMeta().getDisplayName().equals("§7Chainmail Armor")){
						
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							if(PlayerManager.hasWardrobeArmor(p)){
								PlayerManager.removeWardrobeArmor(p);
							}
							p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Chainmail Armor§7.");
							
							PlayerManager.giveWardrobeArmor(p, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, "§7Chainmail Armor");
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						}
					}
					
					if(item.getType() == Material.LAVA_BUCKET){

						if(PlayerManager.hasWardrobeArmor(p)){
							
							PlayerManager.removeWardrobeArmor(p);
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have any Armor §a§lENABLED§7!");
						}
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				*/
				if(e.getInventory().getName().equals("§0§lChatColors")){
					e.setCancelled(true);
					
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().contains("Bold ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §" + StorageManager.chatcolor.get(p) +"§lBold ChatColor§7.");

								DatabaseManager.setBoldChatColor(p, true);
							}
							if(item.getItemMeta().getDisplayName().endsWith("ENABLED")){
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §" + StorageManager.chatcolor.get(p) +"§lBold ChatColor§7.");

								DatabaseManager.setBoldChatColor(p, false);
							}
						}
						else{
							if(StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
								if(StorageManager.vippoints.get(p) >= 3000){
									p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 3000));
								}
								else{
									PlayerManager.sendVIPPointsRequiredMessage(p, 3000);
								}
							}
							else{
								p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().contains("Cursive ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §" + StorageManager.chatcolor.get(p) +"§oCursive ChatColor§7.");
								
								DatabaseManager.setCursiveChatColor(p, true);
							}
							if(item.getItemMeta().getDisplayName().endsWith("ENABLED")){
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
								
								p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §" + StorageManager.chatcolor.get(p) +"§oCursive ChatColor§7.");
								
								DatabaseManager.setCursiveChatColor(p, false);
							}
						}
						else{
							if(StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
								if(StorageManager.vippoints.get(p) >= 2000){
									p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 2000));
								}
								else{
									PlayerManager.sendVIPPointsRequiredMessage(p, 2000);
								}
							}
							else{
								p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
							}
						}
					}
					if(item.getType() == Material.REDSTONE && item.getItemMeta().getDisplayName().equals("§4Dark Red ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Dark Red ChatColor§7.");
							StorageManager.chatcolor.put(p, "4");
							
							DatabaseManager.setChatColor(p, "4");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§aLight Green ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aLight Green ChatColor§7.");
							StorageManager.chatcolor.put(p, "a");
							
							DatabaseManager.setChatColor(p, "a");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 575){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 575));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 575);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§8Dark Gray ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Dark Gray ChatColor§7.");
							StorageManager.chatcolor.put(p, "8");

							DatabaseManager.setChatColor(p, "8");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 250){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 250));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 250);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§cRed ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cRed ChatColor§7.");
							StorageManager.chatcolor.put(p, "c");
							
							DatabaseManager.setChatColor(p, "c");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 650){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 650));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 650);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§fWhite ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fWhite ChatColor§7.");
							StorageManager.chatcolor.put(p, "f");

							DatabaseManager.setChatColor(p, "f");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§bLight Blue ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §bLight Blue ChatColor§7.");
							StorageManager.chatcolor.put(p, "b");
								
							DatabaseManager.setChatColor(p, "b");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 700){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 700));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 700);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§dPink ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dPink ChatColor§7.");
							StorageManager.chatcolor.put(p, "d");

							DatabaseManager.setChatColor(p, "d");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 525){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 525));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 525);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§9Blue ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Blue ChatColor§7.");
							StorageManager.chatcolor.put(p, "9");

							DatabaseManager.setChatColor(p, "9");

						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§1Dark Blue ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §1Dark Blue ChatColor§7.");
							StorageManager.chatcolor.put(p, "1");

							DatabaseManager.setChatColor(p, "1");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 350){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 350));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 350);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§7Gray ChatColor")){
						
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
						
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Gray ChatColor§7.");
						StorageManager.chatcolor.put(p, "7");

						DatabaseManager.setChatColor(p, "7");
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§2Green ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Green ChatColor§7.");
							StorageManager.chatcolor.put(p, "2");
								
							DatabaseManager.setChatColor(p, "2");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§0Black ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §0Black ChatColor§7.");
							StorageManager.chatcolor.put(p, "0");
							
							DatabaseManager.setChatColor(p, "0");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 200){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 200));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 200);
							}
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§eYellow ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eYellow ChatColor§7.");
							StorageManager.chatcolor.put(p, "e");

							DatabaseManager.setChatColor(p, "e");
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
							
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§6Orange ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Orange ChatColor§7.");
							StorageManager.chatcolor.put(p, "6");

							DatabaseManager.setChatColor(p, "6");
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
							
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§5Purple ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §5Purple ChatColor§7.");
							StorageManager.chatcolor.put(p, "5");

							DatabaseManager.setChatColor(p, "5");
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
							
						}
					}
					if(item.getType() == Material.INK_SACK && item.getItemMeta().getDisplayName().equals("§3Cyan ChatColor")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 5, 1);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Cyan ChatColor§7.");
							StorageManager.chatcolor.put(p, "3");
								
							DatabaseManager.setChatColor(p, "3");
						}
						else{
								
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
							
						}
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				if(e.getInventory().getName().equals("§0§lDisguises")){
					e.setCancelled(true);
					
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§8Enderman Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.ENDERMAN, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Enderman Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Ghast Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.GHAST, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Ghast Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§6Rabbit Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.RABBIT, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Rabbit Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 650){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 650));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 650);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§fIron Golem Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.IRON_GOLEM, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fIron Golem Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 575){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 575));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 575);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§6Horse Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.HORSE, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Horse Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§fSnowman Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SNOWMAN, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSnowman Disguise§7.");
							
						}		
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§2Witch Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.WITCH, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Witch Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 450){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 450));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 450);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§8Bat Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.BAT, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Bat Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§fChicken Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fChicken Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 325){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 325));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§eOcelot Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.OCELOT, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §eOcelot Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 375){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 375));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 375);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§4Mushroom Cow Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.MUSHROOM_COW, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §4Mushroom Cow Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 350){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 350));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 350);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§9Squid Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SQUID, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §9Squid Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§aSlime Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SLIME, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aSlime Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 425){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 425));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 425);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§dZombie Pigman Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.PIG_ZOMBIE, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dZombie Pigman Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§cMagma Cube Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.MAGMA_CUBE, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §cMagma Cube Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Skeleton Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SKELETON, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Skeleton Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Wolf Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.WOLF, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Wolf Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§8Spider Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SPIDER, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Spider Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 375){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 375));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 375);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Silverfish Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SILVERFISH, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7Silverfish Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§fSheep Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.SHEEP, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §fSheep Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 375){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 375));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 375);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§3Cave Spider Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.CAVE_SPIDER, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §3Cave Spider Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§aCreeper Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.CREEPER, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §aCreeper Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§8Cow Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.COW, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §8Cow Disguise§7.");
							
						}
						else{
							if(StorageManager.vippoints.get(p) >= 350){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 350));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 350);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§6Blaze Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.BLAZE, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Blaze Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§dPig Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.PIG, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §dPig Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§2Zombie Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.ZOMBIE, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §2Zombie Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §6§lGold VIP§7!");
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§6Villager Disguise")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

							DisguisePlayer.disguisePlayer(p, EntityType.VILLAGER, Bukkit.getOnlinePlayers());
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §6Villager Disguise§7.");
							
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §b§lDiamond VIP§7!");
						}
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(item.getType() == Material.LAVA_BUCKET){
						if(StorageManager.disguise.containsKey(p)){
							DisguisePlayer.undisguisePlayer(p);
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Disguise §a§lENABLED§7!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lPets")){
					e.setCancelled(true);
					
					if(item.getType() == Material.NAME_TAG && item.getItemMeta().getDisplayName().startsWith("§fRename ")){
						String displayName = item.getItemMeta().getDisplayName();
						
						if(displayName.endsWith(" §aCreeper Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.CREEPER, 50);
						}
						else if(displayName.endsWith(" §9Squid Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.SQUID, 94);
						}
						else if(displayName.endsWith(" §4Mushroom Cow Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.MUSHROOMCOW, 96);
						}
						else if(displayName.endsWith(" §dPig Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.PIG, 90);
						}
						else if(displayName.endsWith(" §7Wolf Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.WOLF, 95);
						}
						else if(displayName.endsWith(" §fSheep Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.SHEEP, 91);
						}
						else if(displayName.endsWith(" §6Horse Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.HORSE, 100);
						}
						else if(displayName.endsWith(" §cMagma Cube Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.MAGMACUBE, 62);
						}
						else if(displayName.endsWith(" §aSlime Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.SLIME, 55);
						}
						else if(displayName.endsWith(" §8Cow Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.COW, 92);
						}
						else if(displayName.endsWith(" §7Silverfish Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.SILVERFISH, 60);
						}
						else if(displayName.endsWith(" §eOcelot Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.OCELOT, 98);
						}
						else if(displayName.endsWith(" §8Spider Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.SPIDER, 52);
						}
						else if(displayName.endsWith(" §7Chicken Pet")){
							PetRenameGUI.openAnvilGUI(p, Pet.CHICKEN, 93);
						}
						else if(displayName.endsWith(" §fPet")){
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Pet §a§lENABLED§7!");
						}
						
					}
					if(item.getType() == Material.LAVA_BUCKET){
						if(StorageManager.pet.get(p) != Pet.NONE){

							PlayerManager.removePet(p, "§7Pet");
							
							p.playSound(p.getLocation(), Sound.FIRE, 5, 1);
							p.closeInventory();
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §7You don't have a Pet §a§lENABLED§7!");
						}
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§4Mushroom Cow Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.mushroomcowpet.get(p));
							}

							PlayerManager.spawnPet(p, Pet.MUSHROOMCOW);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.COW_HURT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.mushroomcowpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§dPig Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.pigpet.get(p));
							}

							PlayerManager.spawnPet(p, Pet.PIG);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.PIG_DEATH, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.pigpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 425){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 425));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 425);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Wolf Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.wolfpet.get(p));
							}

							PlayerManager.spawnPet(p, Pet.WOLF);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.WOLF_BARK, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.wolfpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§fSheep Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.sheeppet.get(p));		
							}
							
							PlayerManager.spawnPet(p, Pet.SHEEP);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.sheeppet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 425){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 425));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 425);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§6Horse Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.horsepet.get(p));	
							}
							
							PlayerManager.spawnPet(p, Pet.HORSE);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.HORSE_HIT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.horsepet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 525){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 525));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 525);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§cMagma Cube Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.magmacubepet.get(p));	
							}
							
							PlayerManager.spawnPet(p, Pet.MAGMACUBE);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SLIME_WALK, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.magmacubepet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§aSlime Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.slimepet.get(p));	
							}
							
							PlayerManager.spawnPet(p, Pet.SLIME);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SLIME_WALK, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.slimepet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 475){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 475));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 475);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§8Cow Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.cowpet.get(p));	
							}
							
							PlayerManager.spawnPet(p, Pet.COW);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.COW_HURT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.cowpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 425){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 425));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 425);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Silverfish Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.silverfishpet.get(p));
							}
							
							PlayerManager.spawnPet(p, Pet.SILVERFISH);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SILVERFISH_HIT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.silverfishpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 450){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 450));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 450);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§eOcelot Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.ocelotpet.get(p));
							}
							
							PlayerManager.spawnPet(p, Pet.OCELOT);

							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CAT_MEOW, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.ocelotpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 450){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 450));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 450);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§9Squid Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.squidpet.get(p));
							}
							
							PlayerManager.spawnPet(p, Pet.SQUID);

							p.closeInventory();
							p.playSound(p.getLocation(), Sound.WATER, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.squidpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 600){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 600));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 600);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§8Spider Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.spiderpet.get(p));
							}
							
							PlayerManager.spawnPet(p, Pet.SPIDER);

							p.closeInventory();
							p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.spiderpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§aCreeper Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.creeperpet.get(p));
							}
							
							PlayerManager.spawnPet(p, Pet.CREEPER);

							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CREEPER_HISS, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.creeperpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 525){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 525));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 525);
							}
						}
					}
					if(item.getType() == Material.MONSTER_EGG && item.getItemMeta().getDisplayName().equals("§7Chicken Pet")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(StorageManager.pet.get(p) != Pet.NONE){
								PlayerManager.removePet(p, StorageManager.chickenpet.get(p));
							}
							
							PlayerManager.spawnPet(p, Pet.CHICKEN);

							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CHICKEN_IDLE, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §f" + StorageManager.chickenpet.get(p) + "§7.");
						}
						else{
							if(StorageManager.vippoints.get(p) >= 425){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 425));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 425);
							}
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lTrail Settings")){
					e.setCancelled(true);
					
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lBasic Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								
								StorageManager.trailtype.put(p, TrailType.BASIC_TRAIL);
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lBasic Trail§7.");
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lGround Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								
								StorageManager.trailtype.put(p, TrailType.GROUND_TRAIL);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lGround Trail§7.");
							}
						}
						else{
							if(StorageManager.vippoints.get(p) >= 600){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 600));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 600);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lHead Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								
								StorageManager.trailtype.put(p, TrailType.HEAD_TRAIL);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lHead Trail§7.");
							}
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lBody Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								
								StorageManager.trailtype.put(p, TrailType.BODY_TRAIL);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lBody Trail§7.");
							}
						}
						else{
							if(StorageManager.vippoints.get(p) >= 400){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 400));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 400);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lBig Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								
								StorageManager.trailtype.put(p, TrailType.BIG_TRAIL);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lBig Trail§7.");
							}
						}
						else{
							if(StorageManager.vippoints.get(p) >= 650){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 650));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 650);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lVertical Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								
								StorageManager.trailtype.put(p, TrailType.VERTICAL_TRAIL);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lVertical Trail§7.");
							}
						}
						else{
							if(StorageManager.vippoints.get(p) >= 500){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 500));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 500);
							}
						}
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().startsWith("§7§lSpecial Trail")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							if(item.getItemMeta().getDisplayName().endsWith("DISABLED")){
								StorageManager.trailspecial.put(p, true);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED §7your §7§lSpecial Trail§7.");
							}
							else{
								StorageManager.trailspecial.put(p, false);
								
								p.openInventory(Trails.setTrailSettingsInv(p));
								
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7§lSpecial Trail§7.");
							}
						}
						else{
							if(StorageManager.vippoints.get(p) >= 750){
								p.openInventory(ConfirmManager.getConfirmInv(item, Currency.VIP_POINTS, 750));
							}
							else{
								PlayerManager.sendVIPPointsRequiredMessage(p, 750);
							}
						}
					}
					if(item.getType() == Material.NETHER_STAR && item.getItemMeta().getDisplayName().startsWith("§7§lParticle Amount")){
						if(item.getItemMeta().getLore().contains("§a§lUnlocked")){
							
							int amount = item.getAmount() +1;
							
							if(amount == 6){
								amount = 1;
							}
							
							item.setAmount(amount);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§7§lParticle Amount: §f§l" + amount);
							item.setItemMeta(meta);
							
							StorageManager.trailparticlesamount.put(p, amount);
							
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							p.sendMessage("§9Cosmetic Perks §8| §7Set your §fTrail's §7§lParticle Amount§7 to §f§l" + amount + "§7.");
							
						}
					}
					if(item.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
				}
				//TODO
				if(e.getInventory().getName().equals("§0§lConfirm your Purchase")){
					e.setCancelled(true);
				
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().equals("§a§lConfirm")){
						ItemStack bitem = e.getInventory().getItem(13);
						ItemStack pitem = e.getInventory().getItem(31);
						
						if(!bitem.getItemMeta().getDisplayName().endsWith("Booster")){
							if(pitem.getType() == Material.DIAMOND){
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§9Cosmetic Perks §8| §7Item Bought: " + bitem.getItemMeta().getDisplayName() + "§7.");
								p.sendMessage("§9Cosmetic Perks §8| §7Price: " + pitem.getItemMeta().getDisplayName().substring(9) + "§7.");
							}
							if(pitem.getType() == Material.GOLD_INGOT){
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								p.sendMessage("§eOMT Shop §8| §7Item Bought: " + bitem.getItemMeta().getDisplayName() + "§7.");
								p.sendMessage("§eOMT Shop §8| §7Price: " + pitem.getItemMeta().getDisplayName().substring(9) + "§7.");
							}
						}
						/*
						if(bitem.getItemMeta().getDisplayName().equals("§6§l5 Firework Passes")){

							DatabaseManager.setFireworksPasses(p, StorageManager.fireworkpasses.get(p));
							DatabaseManager.removeVIPPoints(p, 2);
							DatabaseManager.addFireworksPasses(p, 5);

							Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
							Fireworks.getFireworksInv(p, inv);
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§l25 Firework Passes")){

							DatabaseManager.setFireworksPasses(p, StorageManager.fireworkpasses.get(p));
							DatabaseManager.removeVIPPoints(p, 10);
							DatabaseManager.addFireworksPasses(p, 25);
								
							Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
							Fireworks.getFireworksInv(p, inv);
						}
						if(bitem.getItemMeta().getDisplayName().equals("§f§lPaintballs")){

							DatabaseManager.removeVIPPoints(p, 700);

							StorageManager.paintballsgadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-Paintballs");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§a§lCreeper Launcher")){

							DatabaseManager.removeVIPPoints(p, 525);
								
							StorageManager.creeperlaunchergadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-CreeperLauncher");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§e§lPet Ride")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.petridegadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-PetRide");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lBook Explosion")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.bookexplosiongadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-BookExplosion");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2§lSwap Teleporter")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.swapteleportergadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-SwapTeleporter");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§c§lMagmaCube Soccer")){

							DatabaseManager.removeVIPPoints(p, 1000);

							StorageManager.magmacubesoccergadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-MagmaCubeSoccer");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§lSnowman Attack")){

							DatabaseManager.removeVIPPoints(p, 1200);

							StorageManager.snowmanattackgadget.add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Gadgets-SnowmanAttack");
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						*/
						/*
						if(bitem.getItemMeta().getDisplayName().equals("§7Hat Block Trail")){

							DatabaseManager.removeVIPPoints(p, 750);

							StorageManager.hatsblocktrail.put(p, false);
							DatabaseManager.insertString(p.getName(), "Hats-BlockTrail", "blocktrail", "false");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Stone Bricks Hat")){

							DatabaseManager.removeVIPPoints(p, 75);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.STONE_BRICKS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-StoneBricks");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aLime Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.GREEN_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-GreenGlass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2Cactus Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.CACTUS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Cactus");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fSnow Block Hat")){

							DatabaseManager.removeVIPPoints(p, 75);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.SNOW).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Snow");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cTNT Hat")){
							
							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.TNT).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-TNT");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Coal Ore Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.COAL_ORE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-CoalOre");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§9Black Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);
								
							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.BLACK_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-BlackGlass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Furnace Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.FURNACE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Furnace");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cQuartz Ore Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.QUARTZ_ORE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-QuartzOre");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eHay Bale Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.HAY_BALE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-HayBale");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§4Redstone Ore Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.REDSTONE_ORE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-RedstoneOre");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§bIce Hat")){

							DatabaseManager.removeVIPPoints(p, 150);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.ICE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Ice");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Workbench Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.WORKBENCH).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Workbench");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aGrass Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.GRASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Grass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§4Red Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.RED_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-RedGlass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§9Bedrock Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.BEDROCK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Bedrock");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§1Lapis Ore Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.LAPIS_ORE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-LapisOre");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§4Redstone Block Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.REDSTONE_BLOCK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-RedstoneBlock");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fQuartz Block Hat")){

							DatabaseManager.removeVIPPoints(p, 75);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.QUARTZ_BLOCK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-QuartzBlock");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§1Lapis Block Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.LAPIS_BLOCK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-LapisBlock");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§dMagenta Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.MAGENTA_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-MagentaGlass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§0Coal Block Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.COAL_BLOCK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-CoalBlock");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2Melon Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.MELON).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Melon");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fGlass Hat")){

							DatabaseManager.removeVIPPoints(p, 150);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Glass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eYellow Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.YELLOW_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-YellowGlass");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Mycelium Hat")){

							DatabaseManager.removeVIPPoints(p, 75);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.MYCELIUM).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Mycelium");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2Leaves Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.LEAVES).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Leaves");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Orange Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.ORANGE_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Orange");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fPolished Diorite Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.DIORITE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Diorite");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§3Dark Prismarine Hat")){

							DatabaseManager.removeVIPPoints(p, 150);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.DARK_PRISMARINE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-DarkPrismarine");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eSponge Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.SPONGE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Sponge");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aSlime Block Hat")){

							DatabaseManager.removeVIPPoints(p, 200);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.SLIME_BLOCK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-SlimeBlock");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fSea Lantern Hat")){

							DatabaseManager.removeVIPPoints(p, 225);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.SEA_LANTERN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-SeaLantern");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§9Prismarine Bricks Hat")){

							DatabaseManager.removeVIPPoints(p, 150);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.PRISMARINE_BRICKS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-PrismarineBricks");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cPolished Granite Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.GRANITE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Granite");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Chest Hat")){

							DatabaseManager.removeVIPPoints(p, 175);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.CHEST).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Chest");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Glowstone Hat")){

							DatabaseManager.removeVIPPoints(p, 200);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.GLOWSTONE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Glowstone");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eWet Sponge Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.WET_SPONGE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-WetSponge");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Polished Andesite Hat")){

							DatabaseManager.removeVIPPoints(p, 100);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.ANDESITE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-Andesite");
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§1Blue Stained Glass Hat")){

							DatabaseManager.removeVIPPoints(p, 125);

							StorageManager.hasunlockedhat.put(p, true);
							StorageManager.hats.get(Hat.BLUE_GLASS).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Hats-BlueGlass");
							p.openInventory(Hats.getHatsInv(p));
						}
						*/
						if(bitem.getItemMeta().getDisplayName().equals("§cFireWork Spark Trail")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.FIREWORK_SPARK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Firework");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cHeart Trail")){

							DatabaseManager.removeVIPPoints(p, 300);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.HEART).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Heart");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§4TNT Trail")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.TNT).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-TNT");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Angry Villager Trail")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.ANGRY_VILLAGER).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-AngryVillager");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aSlime Trail")){

							DatabaseManager.removeVIPPoints(p, 275);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.SLIME).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Slime");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§0Smoke Trail")){

							DatabaseManager.removeVIPPoints(p, 325);

							StorageManager.trails.get(Trail.SMOKE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Smoke");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§5Witch Trail")){

							DatabaseManager.removeVIPPoints(p, 350);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.WITCH).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Witch");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§bCrit Trail")){

							DatabaseManager.removeVIPPoints(p, 375);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.CRIT).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Crit");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§dMusic Trail")){

							DatabaseManager.removeVIPPoints(p, 625);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.MUSIC).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Music");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fSnow Trail")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.SNOW).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Snow");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§1Enchantment Table Trail")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.ENCHANTMENT_TABLE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-ETable");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fBubble Trail")){

							DatabaseManager.removeVIPPoints(p, 375);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.BUBBLE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-Bubble");
							p.openInventory(Trails.getTrailsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Mob Spawner Trail")){

							DatabaseManager.removeVIPPoints(p, 525);

							StorageManager.hasunlockedtrail.put(p, true);
							StorageManager.trails.get(Trail.MOB_SPAWNER).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-MobSpawner");
							p.openInventory(Trails.getTrailsInv(p));
						}
						/*
						if(bitem.getItemMeta().getDisplayName().equals("§fWhite Armor")){

							DatabaseManager.removeVIPPoints(p, 250);
								
							StorageManager.wardrobeunlockedcolors.get(p).add(Color.WHITE);
							StorageManager.wardrobearmor.get(Color.WHITE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-White");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§9Blue Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.BLUE);
							StorageManager.wardrobearmor.get(Color.BLUE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Blue");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2Green Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.GREEN);
							StorageManager.wardrobearmor.get(Color.GREEN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Green");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§0Black Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.BLACK);
							StorageManager.wardrobearmor.get(Color.BLACK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Black");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§bLight Blue Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.AQUA);
							StorageManager.wardrobearmor.get(Color.AQUA).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-LightBlue");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§dPink Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.FUCHSIA);
							StorageManager.wardrobearmor.get(Color.FUCHSIA).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Pink");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aLight Green Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.LIME);
							StorageManager.wardrobearmor.get(Color.LIME).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-LightGreen");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§1Dark Blue Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.NAVY);
							StorageManager.wardrobearmor.get(Color.NAVY).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-DarkBlue");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§5Purple Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.PURPLE);
							StorageManager.wardrobearmor.get(Color.PURPLE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Purple");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Orange Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.ORANGE);
							StorageManager.wardrobearmor.get(Color.ORANGE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Orange");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cRed Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.RED);
							StorageManager.wardrobearmor.get(Color.RED).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Red");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§3Cyan Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.TEAL);
							StorageManager.wardrobearmor.get(Color.TEAL).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Cyan");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eYellow Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.YELLOW);
							StorageManager.wardrobearmor.get(Color.YELLOW).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Yellow");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Gray Armor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.wardrobeunlockedcolors.get(p).add(Color.GRAY);
							StorageManager.wardrobearmor.get(Color.GRAY).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Wardrobe-Gray");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().endsWith("Disco Armor")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.wardrobedisco.put(p, false);
							DatabaseManager.insertString(p.getName(), "Wardrobe-Disco", "disco", "false");
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						*/
						if(bitem.getItemMeta().getDisplayName().equals("§4Dark Red ChatColor")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.chatcolors.get(ChatColor.DARK_RED).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-DarkRed");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aLight Green ChatColor")){

							DatabaseManager.removeVIPPoints(p, 575);

							StorageManager.chatcolors.get(ChatColor.LIGHT_GREEN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-LightGreen");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Dark Gray ChatColor")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.chatcolors.get(ChatColor.DARK_GRAY).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-DarkGray");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cRed ChatColor")){

							DatabaseManager.removeVIPPoints(p, 650);

							StorageManager.chatcolors.get(ChatColor.RED).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-Red");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fWhite ChatColor")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.chatcolors.get(ChatColor.WHITE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-White");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§bLight Blue ChatColor")){

							DatabaseManager.removeVIPPoints(p, 700);

							StorageManager.chatcolors.get(ChatColor.LIGHT_BLUE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-LightBlue");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§dPink ChatColor")){

							DatabaseManager.removeVIPPoints(p, 525);

							StorageManager.chatcolors.get(ChatColor.PINK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-Pink");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§9Blue ChatColor")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.chatcolors.get(ChatColor.BLUE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-Blue");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§1Dark Blue ChatColor")){

							DatabaseManager.removeVIPPoints(p, 350);

							StorageManager.chatcolors.get(ChatColor.DARK_BLUE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-DarkBlue");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2Green ChatColor")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.chatcolors.get(ChatColor.GREEN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-Green");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§0Black ChatColor")){

							DatabaseManager.removeVIPPoints(p, 200);

							StorageManager.chatcolors.get(ChatColor.BLACK).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "ChatColors-Black");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().contains("Bold ChatColor")){

							DatabaseManager.removeVIPPoints(p, 3000);

							StorageManager.boldchatcolor.put(p, false);
							DatabaseManager.insertString(p.getName(), "ChatColors-Bold", "bold", "false");
							p.openInventory(ChatColors.getChatColors(p));
						}
						if(bitem.getItemMeta().getDisplayName().contains("Cursive ChatColor")){

							DatabaseManager.removeVIPPoints(p, 2000);

							StorageManager.cursivechatcolor.put(p, false);
							DatabaseManager.insertString(p.getName(), "ChatColors-Cursive", "cursive", "false");
							p.openInventory(ChatColors.getChatColors(p));
						}
						/*
						if(bitem.getItemMeta().getDisplayName().equals("§8Enderman Disguise")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.disguises.get(Disguise.ENDERMAN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Enderman");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2Witch Disguise")){
								
							DatabaseManager.removeVIPPoints(p, 450);

							StorageManager.disguises.get(Disguise.WITCH).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Witch");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Bat Disguise")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.disguises.get(Disguise.BAT).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Bat");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fChicken Disguise")){

							DatabaseManager.removeVIPPoints(p, 325);

							StorageManager.disguises.get(Disguise.CHICKEN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Chicken");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eOcelot Disguise")){

							DatabaseManager.removeVIPPoints(p, 375);

							StorageManager.disguises.get(Disguise.OCELOT).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Ocelot");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§4Mushroom Cow Disguise")){

							DatabaseManager.removeVIPPoints(p, 250);

							StorageManager.disguises.get(Disguise.MUSHROOM_COW).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-MushroomCow");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§9Squid Disguise")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.disguises.get(Disguise.SQUID).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Squid");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fIron Golem Disguise")){

							DatabaseManager.removeVIPPoints(p, 575);

							StorageManager.disguises.get(Disguise.IRON_GOLEM).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-IronGolem");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Ghast Disguise")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.disguises.get(Disguise.GHAST).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Ghast");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aSlime Disguise")){

							DatabaseManager.removeVIPPoints(p, 425);

							StorageManager.disguises.get(Disguise.SLIME).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Slime");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§dZombie Pigman Disguise")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.disguises.get(Disguise.ZOMBIE_PIGMAN).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-ZombiePigman");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cMagma Cube Disguise")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.disguises.get(Disguise.MAGMA_CUBE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-MagmaCube");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Skeleton Disguise")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.disguises.get(Disguise.SKELETON).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Skeleton");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Horse Disguise")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.disguises.get(Disguise.HORSE).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Horse");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Rabbit Disguise")){

							DatabaseManager.removeVIPPoints(p, 650);

							StorageManager.disguises.get(Disguise.RABBIT).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Rabbit");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Wolf Disguise")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.disguises.get(Disguise.WOLF).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Wolf");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Spider Disguise")){

							DatabaseManager.removeVIPPoints(p, 375);

							StorageManager.disguises.get(Disguise.SPIDER).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Spider");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Silverfish Disguise")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.disguises.get(Disguise.SILVERFISH).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Silverfish");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fSheep Disguise")){

							DatabaseManager.removeVIPPoints(p, 375);

							StorageManager.disguises.get(Disguise.SHEEP).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Sheep");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§3Cave Spider Disguise")){

							DatabaseManager.removeVIPPoints(p, 400);

							StorageManager.disguises.get(Disguise.CAVE_SPIDER).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-CaveSpider");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aCreeper Disguise")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.disguises.get(Disguise.CREEPER).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Creeper");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Cow Disguise")){

							DatabaseManager.removeVIPPoints(p, 350);

							StorageManager.disguises.get(Disguise.COW).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Dis-Cow");
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						*/
						if(bitem.getItemMeta().getDisplayName().equals("§9Squid Pet")){

							DatabaseManager.removeVIPPoints(p, 600);

							StorageManager.squidpet.put(p, p.getName() + "'s Squid");
							DatabaseManager.insertString(p.getName(), "Pets-Squid", "petname", p.getName() + "'s Squid");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Spider Pet")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.spiderpet.put(p, p.getName() + "'s Spider");
							DatabaseManager.insertString(p.getName(), "Pets-Spider", "petname", p.getName() + "'s Spider");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§4Mushroom Cow Pet")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.mushroomcowpet.put(p, p.getName() + "'s Mushroom Cow");
							DatabaseManager.insertString(p.getName(), "Pets-MushroomCow", "petname", p.getName() + "'s Mushroom Cow");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§cMagma Cube Pet")){

							DatabaseManager.removeVIPPoints(p, 500);

							StorageManager.magmacubepet.put(p, p.getName() + "'s MagmaCube");
							DatabaseManager.insertString(p.getName(), "Pets-MagmaCube", "petname", p.getName() + "'s MagmaCube");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§dPig Pet")){

							DatabaseManager.removeVIPPoints(p, 425);

							StorageManager.pigpet.put(p, p.getName() + "'s Pig");
							DatabaseManager.insertString(p.getName(), "Pets-Pig", "petname", p.getName() + "'s Pig");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aSlime Pet")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.slimepet.put(p, p.getName() + "'s Slime");
							DatabaseManager.insertString(p.getName(), "Pets-Slime", "petname", p.getName() + "'s Slime");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Wolf Pet")){

							DatabaseManager.removeVIPPoints(p, 475);

							StorageManager.wolfpet.put(p, p.getName() + "'s Wolf");
							DatabaseManager.insertString(p.getName(), "Pets-Wolf", "petname", p.getName() + "'s Wolf");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§8Cow Pet")){

							DatabaseManager.removeVIPPoints(p, 425);

							StorageManager.cowpet.put(p, p.getName() + "'s Cow");
							DatabaseManager.insertString(p.getName(), "Pets-Cow", "petname", p.getName() + "'s Cow");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§fSheep Pet")){

							DatabaseManager.removeVIPPoints(p, 425);

							StorageManager.sheeppet.put(p, p.getName() + "'s Sheep");
							DatabaseManager.insertString(p.getName(), "Pets-Sheep", "petname", p.getName() + "'s Sheep");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Silverfish Pet")){

							DatabaseManager.removeVIPPoints(p, 450);

							StorageManager.silverfishpet.put(p, p.getName() + "'s Silverfish");
							DatabaseManager.insertString(p.getName(), "Pets-Silverfish", "petname", p.getName() + "'s Silverfish");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6Horse Pet")){

							DatabaseManager.removeVIPPoints(p, 525);

							StorageManager.horsepet.put(p, p.getName() + "'s Horse");
							DatabaseManager.insertString(p.getName(), "Pets-Horse", "petname", p.getName() + "'s Horse");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§eOcelot Pet")){

							DatabaseManager.removeVIPPoints(p, 450);

							StorageManager.ocelotpet.put(p, p.getName() + "'s Ocelot");
							DatabaseManager.insertString(p.getName(), "Pets-Ocelot", "petname", p.getName() + "'s Ocelot");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§aCreeper Pet")){

							DatabaseManager.removeVIPPoints(p, 525);

							StorageManager.creeperpet.put(p, p.getName() + "'s Creeper");
							DatabaseManager.insertString(p.getName(), "Pets-Creeper", "petname", p.getName() + "'s Creeper");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Chicken Pet")){

							DatabaseManager.removeVIPPoints(p, 425);
							
							StorageManager.chickenpet.put(p, p.getName() + "'s Chicken");
							DatabaseManager.insertString(p.getName(), "Pets-Chicken", "petname", p.getName() + "'s Chicken");
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lGround Trail")){

							DatabaseManager.removeVIPPoints(p, 600);
							
							StorageManager.trailtypes.get(TrailType.GROUND_TRAIL).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-TypeGround");
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lHead Trail")){

							DatabaseManager.removeVIPPoints(p, 400);
							
							StorageManager.trailtypes.get(TrailType.HEAD_TRAIL).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-TypeHead");
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lBody Trail")){

							DatabaseManager.removeVIPPoints(p, 400);
							
							StorageManager.trailtypes.get(TrailType.BODY_TRAIL).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-TypeBody");
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lBig Trail")){

							DatabaseManager.removeVIPPoints(p, 650);
							
							StorageManager.trailtypes.get(TrailType.BIG_TRAIL).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-TypeBig");
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lVertical Trail")){

							DatabaseManager.removeVIPPoints(p, 500);
							
							StorageManager.trailtypes.get(TrailType.VERTICAL_TRAIL).add(p);
							DatabaseManager.insertUUID(Start.getUUIDfromPlayer(p).toString(), "Trails-TypeVertical");
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lSpecial Trail")){

							DatabaseManager.removeVIPPoints(p, 750);
							
							StorageManager.trailspecial.put(p, false);
							DatabaseManager.insertString(p.getName(), "Trails-TypeSpecial", "special", "false");
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lIron VIP Booster")){

							DatabaseManager.removeVIPPoints(p, 200);

							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							p.sendMessage(Start.TAG + "§7Item Bought: §ax1.25 Booster§7. (§a30 Minutes§7)");
							p.sendMessage(Start.TAG + "§7Price: §b§l200 VIP Points§7.");
							p.closeInventory();
						
							StorageManager.boosteramount = 1.25;
							StorageManager.boosterminutes = 30;
							StorageManager.boosterseconds = 0;
							StorageManager.boosterplayer = p.getName();
							
							Bukkit.broadcastMessage(Start.TAG + "§8" + PlayerManager.getPlayerDisplayname(p) + " §7activated a §aBooster§7! (§ax1.25§7)");
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§lGold VIP Booster")){

							DatabaseManager.removeVIPPoints(p, 200);

							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							p.sendMessage(Start.TAG + "§7Item Bought: §ax1.50 Booster§7. (§a30 Minutes§7)");
							p.sendMessage(Start.TAG + "§7Price: §b§l200 VIP Points§7.");
							p.closeInventory();
						
							StorageManager.boosteramount = 1.50;
							StorageManager.boosterminutes = 30;
							StorageManager.boosterseconds = 0;
							StorageManager.boosterplayer = p.getName();
							
							Bukkit.broadcastMessage(Start.TAG + "§8" + PlayerManager.getPlayerDisplayname(p) + " §7activated a §aBooster§7! (§ax1.50§7)");
						}
						if(bitem.getItemMeta().getDisplayName().equals("§b§lDiamond VIP Booster")){

							DatabaseManager.removeVIPPoints(p, 200);
								
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							p.sendMessage(Start.TAG + "§7Item Bought: §ax2.00 Booster§7. (§a30 Minutes§7)");
							p.sendMessage(Start.TAG + "§7Price: §b§l200 VIP Points§7.");
							p.closeInventory();
						
							StorageManager.boosteramount = 2.00;
							StorageManager.boosterminutes = 30;
							StorageManager.boosterseconds = 0;
							StorageManager.boosterplayer = p.getName();
							
							Bukkit.broadcastMessage(Start.TAG + "§8" + PlayerManager.getPlayerDisplayname(p) + " §7activated a §aBooster§7! (§ax2.00§7)");
						}
						if(bitem.getItemMeta().getDisplayName().equals("§a§lEmerald VIP Booster")){

							DatabaseManager.removeVIPPoints(p, 200);

							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							p.sendMessage(Start.TAG + "§7Item Bought: §ax2.50 Booster§7. (§a30 Minutes§7)");
							p.sendMessage(Start.TAG + "§7Price: §b§l200 VIP Points§7.");
							p.closeInventory();
						
							StorageManager.boosteramount = 2.50;
							StorageManager.boosterminutes = 30;
							StorageManager.boosterseconds = 0;
							StorageManager.boosterplayer = p.getName();
							
							Bukkit.broadcastMessage(Start.TAG + "§8" + PlayerManager.getPlayerDisplayname(p) + " §7activated a §aBooster§7! (§ax2.50§7)");
						}
						
						if(bitem.getItemMeta().getDisplayName().equals("§6§l+200 Coins")){

							DatabaseManager.removeOMT(p, 1);
							DatabaseManager.addMoney(p, 200);
							
							p.closeInventory();
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§l+1000 Coins")){

							DatabaseManager.removeOMT(p, 4);
							DatabaseManager.addMoney(p, 1000);
							
							p.closeInventory();
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§l+2500 Coins")){

							DatabaseManager.removeOMT(p, 9);
							DatabaseManager.addMoney(p, 2500);
							
							p.closeInventory();
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§l+5000 Coins")){

							DatabaseManager.removeOMT(p, 16);
							DatabaseManager.addMoney(p, 5000);
							
							p.closeInventory();
						}
						//TODO
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().equals("§c§lCancel")){
						ItemStack bitem = e.getInventory().getItem(13);
						ItemStack citem = e.getInventory().getItem(31);
						
						if(bitem.getItemMeta().getDisplayName().endsWith("Booster")){
							p.sendMessage("§aBoosters §8| §c§lCancelled §7purchase! (" + bitem.getItemMeta().getDisplayName() + "§7)");
						}
						else if(citem.getType() == Material.DIAMOND){
							p.sendMessage("§9Cosmetic Perks §8| §c§lCancelled §7purchase! (" + bitem.getItemMeta().getDisplayName() + "§7)");
						}
						else if(citem.getType() == Material.GOLD_INGOT){
							p.sendMessage("§eOMT Shop §8| §c§lCancelled §7purchase! (" + bitem.getItemMeta().getDisplayName() + "§7)");
						}
						else{}
						/*
						if(bitem.getItemMeta().getDisplayName().equals("§6§l5 Firework Passes")){
							Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
							Fireworks.getFireworksInv(p, inv);
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§l25 Firework Passes")){
							Inventory inv = Bukkit.createInventory(null, 54, "§0§lFireworks");
							Fireworks.getFireworksInv(p, inv);
						}
						if(bitem.getItemMeta().getDisplayName().equals("§f§lPaintballs")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§a§lCreeper Launcher")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§e§lPet Ride")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7§lBook Explosion")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§2§lSwap Teleporter")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§c§lMagmaCube Soccer")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§6§lSnowman Attack")){
							p.openInventory(Gadgets.getGadgetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().equals("§7Hat Block Trail")){
							p.openInventory(Hats.getHatsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().endsWith("Hat")){
							p.openInventory(Hats.getHatsInv(p));
						}
						*/
						if(bitem.getItemMeta().getDisplayName().endsWith("Trail") && !bitem.getItemMeta().getDisplayName().equals("§7Hat Block Trail") && !bitem.getItemMeta().getDisplayName().startsWith("§7§l")){
							p.openInventory(Trails.getTrailsInv(p));
						}
						/*
						if(bitem.getItemMeta().getDisplayName().endsWith("Armor")){
							p.openInventory(Wardrobe.getWardrobeInv(p));
						}
						*/
						if(bitem.getItemMeta().getDisplayName().endsWith("ChatColor")){
							p.openInventory(ChatColors.getChatColors(p));
						}
						/*
						if(bitem.getItemMeta().getDisplayName().endsWith("Disguise")){
							p.openInventory(Disguises.getDisguisesInv(p));
						}
						*/
						if(bitem.getItemMeta().getDisplayName().endsWith("Pet")){
							p.openInventory(Pets.getPetsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().endsWith("Trail") && bitem.getItemMeta().getDisplayName().startsWith("§7§l")){
							p.openInventory(Trails.setTrailSettingsInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().endsWith("Booster")){
							p.openInventory(BoosterInv.getBoostersInv(p));
						}
						if(bitem.getItemMeta().getDisplayName().endsWith("Coins")){
							p.openInventory(OMTShop.getOMTShop(p));
						}
						//TODO
						
						
						
					}
				}
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
			ex.printStackTrace();
		}
	}
}
