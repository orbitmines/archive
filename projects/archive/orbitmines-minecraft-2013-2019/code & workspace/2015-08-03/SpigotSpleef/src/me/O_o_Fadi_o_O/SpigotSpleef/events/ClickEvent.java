package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.ArenaManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.MapManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.NPCManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.PlayerDataManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSelector;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSelectorItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ItemType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitSelector;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitSelectorItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeArena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeServer;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ClickEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		
		if(he instanceof Player){
			final Player p = (Player) he;
			ItemStack c = e.getCurrentItem();	
			
			if(StorageManager.spleefplayer.containsKey(p)){
				SpleefPlayer sp = StorageManager.spleefplayer.get(p);
				
				if(sp.isInArena()){
					e.setResult(Result.DENY);
					
					new BukkitRunnable(){
						public void run(){
							p.updateInventory();
						}
					}.runTaskLater(Start.getInstance(), 1);
				}
			}
			
			try{
				if(c != null){
					//Map Setup
					if(e.getInventory().getName().startsWith("§0§lMap") && StorageManager.mapsetup.containsKey(p)){
						e.setCancelled(true);
						
						if(c.getType() == Material.NAME_TAG && c.getItemMeta().getDisplayName().equals("§e§lSet Map Name")){
							MapManager.openMapNameEditor(p, StorageManager.mapsetup.get(p).getMapID());
						}
						if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§lSet Next Spawnpoint")){
							MapManager.setNextSpawnpoint(p);
						}
						if(c.getType() == Material.EYE_OF_ENDER && c.getItemMeta().getDisplayName().equals("§a§lSet Spectator Spawnpoint")){
							MapManager.setSpectatorSpawnpoint(p);
						}
						if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§2§lFinish Setup") && c.getItemMeta().getLore().get(0).equals(" §7Setup Complete: §a§l✔ ")){
							MapManager.finishSetup(p);
						}
						if(c.getType() == Material.BARRIER && c.getItemMeta().getDisplayName().equals("§4§lDelete Map")){
							MapManager.deleteMap(p);
						}
					}
					//Arena Setup
					if(e.getInventory().getName().startsWith("§0§lArena") && StorageManager.arenasetup.containsKey(p)){
						e.setCancelled(true);
						
						if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§lSet Lobby Spawnpoint")){
							ArenaManager.setLobbySpawnpoint(p);
						}
						if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§2§lFinish Setup") && c.getItemMeta().getLore().get(0).equals(" §7Setup Complete: §a§l✔ ")){
							ArenaManager.finishSetup(p);
						}
						if(c.getType() == Material.BARRIER && c.getItemMeta().getDisplayName().equals("§4§lDelete Arena")){
							ArenaManager.deleteArena(p);
						}
					}
					//NPC Editor
					if(e.getInventory().getName().startsWith("§0§lEdit NPC")){
						e.setCancelled(true);
						
						if(c.getType() == Material.NAME_TAG && c.getItemMeta().getDisplayName().equals("§e§lSet NPC Name")){
							NPCManager.openNPCNameEditor(p, StorageManager.spleefplayer.get(p).getNearestNPC());
						}
						if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§6§lSet Mob Type")){
							NPCManager.openNPCMobEditor(p, StorageManager.spleefplayer.get(p).getNearestNPC());
						}
						if(c.getType() == Material.IRON_SPADE && c.getItemMeta().getDisplayName().equals("§7§lSet Kit")){
							NPCManager.openNPCKitEditor(p, StorageManager.spleefplayer.get(p).getNearestKitSelector());
						}
						if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§2§lSave")){
							NPCManager.saveNPCs(p);
						}
					}
					//NPC Editor - Edit Mob
					if(e.getInventory().getName().startsWith("§0§lEdit NPC - Mob Editor")){
						e.setCancelled(true);
						
						if(c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().startsWith("§6§lSet NPC Mob to")){
							NPCManager.setNPCMob(p, StorageManager.spleefplayer.get(p).getNearestNPC(), EntityType.fromId(c.getDurability()));
						}
					}
					//NPC Editor - Edit Kit
					if(e.getInventory().getName().startsWith("§0§lEdit NPC - Kit Editor")){
						e.setCancelled(true);
						
						if(c.getType() == Material.IRON_SPADE && c.getItemMeta().getDisplayName().startsWith("§7§lSet NPC Kit to")){
							NPCManager.setNPCKit(p, StorageManager.spleefplayer.get(p).getNearestKitSelector(), Kit.getKitFromID(c.getAmount()));
						}
					}
					//ArenaSelector
					ArenaSelector as = StorageManager.arenaselector;
					if(as != null){
						if(e.getInventory().getName().equals(as.getInventory().getName())){
							e.setCancelled(true);
							
							if(StorageManager.spleefplayer.containsKey(p)){
								SpleefPlayer sp = StorageManager.spleefplayer.get(p);
								
								if(!sp.isInArena()){
									int index = 0;
									for(ArenaSelectorItemStack item : as.getItemStacks()){
										if(item != null && e.getInventory().first(c) == index){
											Arena arena = item.getArena();
											BungeeArena bungeearena = item.getBungeeArena();
											
											if(StorageManager.bungeecord == true){
												if(bungeearena != null){
													if(bungeearena.isStatus(SpleefStatus.WAITING) || bungeearena.isStatus(SpleefStatus.STARTING)){
														if(!bungeearena.isFull()){
															sp.joinSpleef(bungeearena);
														}
														else{
															Message m = Message.getMessage(MessageName.ARENA_IS_FULL);
															m.replace("&", "§");
															m.replace("%arena-id%", "" + bungeearena.getArenaID());
															m.send(p);
														}
													}
													else{
														if(!bungeearena.isStatus(SpleefStatus.RESTARTING) && !bungeearena.isStatus(SpleefStatus.ENDING)){
															sp.joinSpleef(bungeearena);
														}
													}
												}
												else{
													BungeeServer server = BungeeServer.getServerFromID(item.getArenaID());
													if(server != null){
														sp.teleportToServer(server.getServer());
													}
												}
											}
											else if(arena != null){
												if(arena.isStatus(SpleefStatus.WAITING) || arena.isStatus(SpleefStatus.STARTING)){
													if(!arena.isFull()){
														sp.joinSpleef(arena);
													}
													else{
														Message m = Message.getMessage(MessageName.ARENA_IS_FULL);
														m.replace("&", "§");
														m.replace("%arena-id%", "" + arena.getArenaID());
														m.send(p);
													}
												}
												else{
													if(!arena.isStatus(SpleefStatus.RESTARTING) && !arena.isStatus(SpleefStatus.ENDING)){
														sp.joinSpleef(arena);
													}
												}
											}
											else{}
										}
										index++;
									}
								}
							}
						}
					}
					//KitSelector
					KitSelector ks = StorageManager.kitselector;
					if(ks != null){
						if(StorageManager.spleefplayer.containsKey(p)){
							SpleefPlayer sp = StorageManager.spleefplayer.get(p);
							Kit kit = ks.getLastTriedPurchase(sp);
							
							if(kit != null && e.getInventory().getName().startsWith(ks.getReplacedString(sp, kit, e.getInventory().getName()))){
								e.setCancelled(true);
								
								if(sp.isInArena()){
									int index = 0;
									for(KitSelectorItemStack item : ks.getItemStacks()){
										if(item != null && e.getInventory().first(c) == index){
											if(item.getItemType() == ItemType.CONFIRM_PURCHASE){
												Message m = Message.getMessage(MessageName.BOUGHT_KIT);
												m.replace("&", "§");
												m.replace("%kit-name%", kit.getName());
												m.replace("%kit-id%", "" + kit.getKitID());
												m.replace("%price%", "" + kit.getPrice());
												m.send(p);
												
												sp.addUnlockedKit(kit);
												sp.removeTokens(kit.getPrice());
												PlayerDataManager.setKits(p.getUniqueId(), sp.getUnlockedKits());
												p.closeInventory();
												ks.setLastTriedPurchase(sp, null);
											}
											else if(item.getItemType() == ItemType.CANCEL_PURCHASE){
												p.closeInventory();
												ks.setLastTriedPurchase(sp, null);
											}
											else{}
										}
										index++;
									}
								}
							}
						}
					}
					
				}
			}catch(NullPointerException ex){ex.printStackTrace();}
		}
	}
}
