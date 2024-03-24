package me.O_o_Fadi_o_O.Creative;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.Creative.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Creative.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.Creative.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Creative.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Creative.NMS.CustomVillager;
import me.O_o_Fadi_o_O.Creative.NMS.PetChicken;
import me.O_o_Fadi_o_O.Creative.NMS.PetCow;
import me.O_o_Fadi_o_O.Creative.NMS.PetCreeper;
import me.O_o_Fadi_o_O.Creative.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.Creative.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.Creative.NMS.PetOcelot;
import me.O_o_Fadi_o_O.Creative.NMS.PetPig;
import me.O_o_Fadi_o_O.Creative.NMS.PetSheep;
import me.O_o_Fadi_o_O.Creative.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.Creative.NMS.PetSlime;
import me.O_o_Fadi_o_O.Creative.NMS.PetSpider;
import me.O_o_Fadi_o_O.Creative.NMS.PetSquid;
import me.O_o_Fadi_o_O.Creative.NMS.PetWolf;
import me.O_o_Fadi_o_O.Creative.PlotInv.PlotEditor;
import me.O_o_Fadi_o_O.Creative.events.BlockChangeEvent;
import me.O_o_Fadi_o_O.Creative.events.BreakEvent;
import me.O_o_Fadi_o_O.Creative.events.ClickEvent;
import me.O_o_Fadi_o_O.Creative.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Creative.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.Creative.events.DropEvent;
import me.O_o_Fadi_o_O.Creative.events.EntityDamage;
import me.O_o_Fadi_o_O.Creative.events.EntityDeath;
import me.O_o_Fadi_o_O.Creative.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Creative.events.ExplodeEvent;
import me.O_o_Fadi_o_O.Creative.events.FoodEvent;
import me.O_o_Fadi_o_O.Creative.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.Creative.events.InteractEvent;
import me.O_o_Fadi_o_O.Creative.events.JoinEvent;
import me.O_o_Fadi_o_O.Creative.events.PlaceEvent;
import me.O_o_Fadi_o_O.Creative.events.PlayerChat;
import me.O_o_Fadi_o_O.Creative.events.PlayerMove;
import me.O_o_Fadi_o_O.Creative.events.ProjectileHit;
import me.O_o_Fadi_o_O.Creative.events.QuitEvent;
import me.O_o_Fadi_o_O.Creative.events.SignEvent;
import me.O_o_Fadi_o_O.Creative.events.VoteEvent;
import me.O_o_Fadi_o_O.Creative.managers.BungeeManager;
import me.O_o_Fadi_o_O.Creative.managers.ComponentMessageManager;
import me.O_o_Fadi_o_O.Creative.managers.ConfigManager;
import me.O_o_Fadi_o_O.Creative.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Creative.managers.NPCManager;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.PlotManager;
import me.O_o_Fadi_o_O.Creative.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.managers.TitleManager;
import me.O_o_Fadi_o_O.Creative.managers.VoteManager;
import me.O_o_Fadi_o_O.Creative.plot.PlotCreator;
import me.O_o_Fadi_o_O.Creative.plot.PvPPlotManager;
import me.O_o_Fadi_o_O.Creative.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.PetRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.Creative.utils.ArmorStandType;
import me.O_o_Fadi_o_O.Creative.utils.ChatColor;
import me.O_o_Fadi_o_O.Creative.utils.Disguise;
import me.O_o_Fadi_o_O.Creative.utils.Hat;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;
import me.O_o_Fadi_o_O.Creative.utils.Server;
import me.O_o_Fadi_o_O.Creative.utils.StaffRank;
import me.O_o_Fadi_o_O.Creative.utils.Trail;
import me.O_o_Fadi_o_O.Creative.utils.TrailType;
import me.O_o_Fadi_o_O.Creative.utils.VIPRank;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Start extends JavaPlugin {
	
	private Map<String, Long> lastBroadcast = new HashMap<String, Long>();
	private final int broadcastcooldown = 300;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("p") || cmd.getName().equalsIgnoreCase("plot")){
			if(sender instanceof Player){
				final Player p = (Player) sender;
				
				if(a.length == 0){
					for(String s : getHelpMessage()){
						p.sendMessage(s);
					}
				}
				else if(a[0].equalsIgnoreCase("help")){
					for(String s : getHelpMessage()){
						p.sendMessage(s);
					}
				}
				else if(a[0].equalsIgnoreCase("setuppvp")){
					if(PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
						if(PlayerManager.hasPlot(p)){
							if(!StorageManager.playersinpvpsetup.contains(p)){
								int PlotNumber = StorageManager.playersplotnumber.get(p);
								
								if(StorageManager.plotmode.get(PlotNumber) == PlotMode.NORMAL){
									StorageManager.playersinpvpsetup.add(p);
									
									PvPPlotManager.resetPvPInfo(PlotNumber);
									
									PvPPlotManager.setFinishedSetup(p, false);
									
									StorageManager.plotpvpnpclocations.put(PlotNumber, new ArrayList<Location>());
									
									StorageManager.plotpvplocations.put(PlotNumber, new ArrayList<Location>());
									
									StorageManager.plotpvpkitnames.put(PlotNumber, new ArrayList<String>());
									
									StorageManager.plotpvpkits.put(PlotNumber, new ArrayList<ItemStack[]>());
									
									StorageManager.plotpvpnpcs.put(PlotNumber, new ArrayList<Entity>());
									
									StorageManager.plotpvpplayersselectedkit.put(PlotNumber, new ArrayList<Player>());
									StorageManager.plotpvpplayers.put(PlotNumber, new ArrayList<Player>());
									
									p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									p.sendMessage("");
									p.sendMessage("§7Entered §d§lSetup Mode§7!");
									p.sendMessage("");
									p.sendMessage("§dStep 1:");
									ComponentMessageManager.sendComponentMessage(p, "§7Set the lobby. ", "§7[§d§li§7]", "show_text", "", "§7- Spawnpoint where players will go when they join or die.\n- §7They'll be able to select a kit in that area too!", "");
									p.sendMessage("§7Use §d/p setuppvp setlobby§7.");	
								}
								else{
									p.sendMessage("§7You have to set your §7§Plot Mode§7 to Normal if you want to progress this setup.");	
								}
							}
							else{
								if(a.length >= 2){
									if(a[1].equalsIgnoreCase("setlobby")){
										
										PvPPlotManager.setLobbyLocation(p);
										
										p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
										
										p.sendMessage("");
										p.sendMessage("§7Successfully set the §d§lLobby§7!");
										p.sendMessage("");
										p.sendMessage("§dStep 2:");
										ComponentMessageManager.sendComponentMessage(p, "§7Set the NPC spawns. ", "§7[§d§li§7]", "show_text", "", "§7- This is an ArmorStand which can be Right-Clicked to select a kit.", "");
										p.sendMessage("§7Use §d/p setuppvp setnpc <kitname>§7.");	
									}
									else if(a[1].equalsIgnoreCase("setnpc")){
										if(a.length == 3){
											if(a[2].length() <= 15){
												int PlotNumber = StorageManager.playersplotnumber.get(p);
												
												if(StorageManager.plotpvpnpclocations.get(PlotNumber).size() <= 3){
													PvPPlotManager.setNPCLocation(p, a[2]);
													
													p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													
													p.sendMessage("");
													p.sendMessage("§7Successfully set a §d§lNPC Spawn§7! (Kit: §d" + a[2] + "§7)");
													p.sendMessage("");
													p.sendMessage("§7§oYou can have a maximum of 4 NPCs. (Current Amount: " + StorageManager.plotpvpnpclocations.get(PlotNumber).size() + ")");
													p.sendMessage("");
													p.sendMessage("§dStep 3:");
													ComponentMessageManager.sendComponentMessage(p, "§7Set the In Game spawns. ", "§7[§d§li§7]", "show_text", "", "§7- Spawnpoints where players will go when they select a kit.", "");
													p.sendMessage("§7Use §d/p setuppvp setspawn§7.");
													
												}
												else{
													p.sendMessage("§7You reached the maximum amount of §dNPC Spawns§7!");
												}
											}
											else{
												p.sendMessage("§7The §dKit Name§7 cannot be longer than §d15 characters§7!");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp setnpc <kitname>§7.");	
										}
									}
									else if(a[1].equalsIgnoreCase("setspawn")){
										if(a.length == 2){
											int PlotNumber = StorageManager.playersplotnumber.get(p);
												
											if(StorageManager.plotpvplocations.get(PlotNumber).size() <= 9){
												PvPPlotManager.setSpawnLocation(p, StorageManager.plotpvplocations.get(PlotNumber).size() +1);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												p.sendMessage("");
												p.sendMessage("§7Successfully set an §d§lIn Game Spawn§7! (§d" + StorageManager.plotpvplocations.get(PlotNumber).size() + "§7)");
												p.sendMessage("");
												p.sendMessage("§7§oYou can have a maximum of 10 In Game spawns. (Current Amount: " + StorageManager.plotpvplocations.get(PlotNumber).size() + ")");
												p.sendMessage("");
												p.sendMessage("§dStep 4:");
												ComponentMessageManager.sendComponentMessage(p, "§cDisable§7 or §aEnable §7Loot Drops. ", "§7[§d§li§7]", "show_text", "", "§7- When enabled, all items in a players Inventory will drop when they die.", "");
												p.sendMessage("§7Use §d/p setuppvp drops true§7 or §d/p setuppvp drops false§7.");
												
											}
											else{
												p.sendMessage("§7You reached the maximum amount of §dIn Game Spawns§7!");
											}
										}
									}
									else if(a[1].equalsIgnoreCase("drops")){
										if(a.length == 3){
											try{
												boolean enabledrops = Boolean.parseBoolean(a[2]);
												
												PvPPlotManager.setEnabledDrops(p, enabledrops);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												p.sendMessage("");
												if(enabledrops == true){
													p.sendMessage("§7Successfully §aenabled §d§lLoot Drops§7!");
												}
												else{
													p.sendMessage("§7Successfully §cdisabled §d§lLoot Drops§7!");
												}
												p.sendMessage("");
												p.sendMessage("§dStep 5:");
												ComponentMessageManager.sendComponentMessage(p, "§cDisable§7 or §aEnable §7Arrow Entities. ", "§7[§d§li§7]", "show_text", "", "§7- When disabled, an arrow that missed their target will be removed from the ground.", "");
												p.sendMessage("§7Use §d/p setuppvp arrows true§7 or §d/p setuppvp arrows false§7.");
												
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp drops true§7 or §d/p setuppvp drops false§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp drops true§7 or §d/p setuppvp drops false§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("arrows")){
										if(a.length == 3){
											try{
												boolean enablearrows = Boolean.parseBoolean(a[2]);
												
												PvPPlotManager.setEnabledArrows(p, enablearrows);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

												p.sendMessage("");
												if(enablearrows == true){
													p.sendMessage("§7Successfully §aenabled §d§lArrow Entities§7!");
												}
												else{
													p.sendMessage("§7Successfully §cdisabled §d§lArrow Entities§7!");
												}
												p.sendMessage("");
												p.sendMessage("§dStep 6:");
												ComponentMessageManager.sendComponentMessage(p, "§cDisable§7 or §aEnable §7Build Mode. ", "§7[§d§li§7]", "show_text", "", "§7- When enabled, all players will be able to build.", "");
												p.sendMessage("§7Use §d/p setuppvp build true§7 or §d/p setuppvp build false§7.");
												
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp arrows true§7 or §d/p setuppvp arrows false§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp arrows true§7 or §d/p setuppvp arrows false§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("build")){
										if(a.length == 3){
											try{
												boolean enablebuild = Boolean.parseBoolean(a[2]);
												
												PvPPlotManager.setEnabledBuild(p, enablebuild);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

												p.sendMessage("");
												if(enablebuild == true){
													p.sendMessage("§7Successfully §aenabled §d§lBuild Mode§7!");
												}
												else{
													p.sendMessage("§7Successfully §cdisabled §d§lBuild Mode§7!");
												}
												p.sendMessage("");
												p.sendMessage("§dStep 7:");
												ComponentMessageManager.sendComponentMessage(p, "§7Set the maximum amount of players allowed. ", "§7[§d§li§7]", "show_text", "", "§7- Has to be between 4 and 50.", "");
												p.sendMessage("§7Use §d/p setuppvp setmaxplayers <amount>§7.");
												
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp build true§7 or §d/p setuppvp build false§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp build true§7 or §d/p setuppvp build false§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("setmaxplayers")){
										if(a.length == 3){
											try{
												int amount = Integer.parseInt(a[2]);
												
												if(amount >= 4 && amount <= 50){
													
													PvPPlotManager.setMaxPlayers(p, amount);
													
													int PlotNumber = StorageManager.playersplotnumber.get(p);
													
													PvPPlotManager.removeNPCs(PlotNumber);
													PvPPlotManager.spawnNPCs(PlotNumber);
													
													PvPPlotManager.createKitInventories(p);
													
													p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													
													p.sendMessage("");
													p.sendMessage("§7Successfully set the §d§lMax. Players§7! (§d" + amount + "§7)");
													p.sendMessage("");
													p.sendMessage("§dStep 8:");
													ComponentMessageManager.sendComponentMessage(p, "§7Click on the ArmorStands that just appeared. ", "§7[§d§li§7]", "show_text", "", "§7- Add items to these inventories to design your kits.", "");
													p.sendMessage("§7Done?");
													p.sendMessage("§7Use §d/p setuppvp finish§7.");
													
												}
												else{
													p.sendMessage("§7Only numbers between §d4§7 and §d50§7 are allowed.");
												}
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp setmaxplayers <amount>§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp setmaxplayers <amount>§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("finish")){
										int PlotNumber = StorageManager.playersplotnumber.get(p);
										
										if(StorageManager.plotpvpspawnlocation.containsKey(PlotNumber)
										&& StorageManager.plotpvpnpclocations.get(PlotNumber).size() > 0
										&& StorageManager.plotpvplocations.get(PlotNumber).size() > 0
										&& StorageManager.plotpvpdrops.containsKey(PlotNumber)
										&& StorageManager.plotpvparrows.containsKey(PlotNumber)
										&& StorageManager.plotpvpbuild.containsKey(PlotNumber)
										&& StorageManager.plotpvpkitnames.get(PlotNumber).size() > 0
										&& StorageManager.plotpvpkits.get(PlotNumber).size() > 0
										&& StorageManager.plotpvpmaxplayers.containsKey(PlotNumber)
										&& StorageManager.plotpvpnpcs.get(PlotNumber).size() > 0){
											
											PvPPlotManager.setFinishedSetup(p, true);
											StorageManager.playersinpvpsetup.remove(p);
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.sendMessage("");
											p.sendMessage("§7Successfully finished the §d§lSetup§7!");
											p.sendMessage("");
											p.sendMessage("§7Switch your plot to §c§lPvP Mode§7 using §d/p edit§7.");
											
										}
										else{
											p.sendMessage("§7You didn't do the setup right!");
										}
									}
									else{
										p.sendMessage("§7Incorrect Use!");
										p.sendMessage("§7Follow the steps carefully.");
									}
								}
								else{
									p.sendMessage("§7Incorrect Use!");
									p.sendMessage("§7Follow the steps carefully.");
								}
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
						}
					}
					else{
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
					}
				}
			}
			else{
				sender.sendMessage(TAG + "§cYou can't perform commands through the Console!");
			}
		}
		return false;
	}
	
	public void teleportToPlot(final Player p1, final Player p2){
		p1.sendMessage(Start.TAG + "§7Teleporting to §d" + p2.getName() + "s §dPlot§7...");
		new BukkitRunnable(){
			public void run(){
				p1.teleport(StorageManager.playersplothomelocation.get(p2));
				p1.playSound(p1.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
				TitleManager.setTitle(p1, "", "§7Teleported to §d" + p2.getName() + "s Plot§7.");
			}
		}.runTaskLater(this, 10);
	}

    private boolean setupPermissions(){
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
}
