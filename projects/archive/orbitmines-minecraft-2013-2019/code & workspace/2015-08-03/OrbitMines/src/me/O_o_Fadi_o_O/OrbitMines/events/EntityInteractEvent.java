package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.OMTShopInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPC;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.CreativeServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.PrisonServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SkyBlockServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.NPCType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.Inventories.KitSelectorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Inventories.MGKitInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Inventories.MiniGamesInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Inventories.GoldShopInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Inventories.VillagerGambleInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Mine;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.MineType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rank;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EntityInteractEvent implements Listener{
	
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		final Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		Entity en = e.getRightClicked();
		ItemStack item = p.getItemInHand();
		
		if(omp.isLoaded()){
			if(!omp.isOpMode() && !ServerData.isServer(Server.PRISON) && p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
				e.setCancelled(true);
				omp.updateInventory();
			}
			
			if(ServerStorage.pets.contains(en)){
				e.setCancelled(true);
				omp.updateInventory();
			}
			
			if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
				if(omp.getSoccerMagmaCube() == en){
					e.setCancelled(true);
					omp.disableSoccerMagmaCube();
					omp.updateInventory();
				}
				if(omp.getPet() == en && item != null && item.getType() == Material.SADDLE && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null && item.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
					e.setCancelled(true);
					en.setPassenger(p);
					omp.updateInventory();
				}
				if(item != null){
					if(item.getType() == Material.MONSTER_EGG || item.getType() == Material.EGG){
						e.setCancelled(true);
						omp.updateInventory();
					}
				}
			}
			else if(ServerData.isServer(Server.CREATIVE)){
				if(!omp.isOpMode()){
					CreativeServer creative = ServerData.getCreative();
					CreativePlayer cp = omp.getCreativePlayer();
				
					if(p.getWorld().getName().equals(creative.getPlotWorld().getName())){
						if(!(en instanceof Player) && !cp.isOnPlot(en.getLocation())){
							e.setCancelled(true);
						}
					}
					else if(p.getWorld().getName().equals(creative.getCreativeWorld().getName())){
						e.setCancelled(true);
					}
					else{}
					
					if(item != null && item.getType() == Material.MONSTER_EGG){
						e.setCancelled(true);
						omp.updateInventory();
					}
				}
			}
			else if(ServerData.isServer(Server.SKYBLOCK)){
				if(!omp.isOpMode()){
					SkyBlockServer skyblock = ServerData.getSkyBlock();
					SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
					
					if(p.getWorld().getName().equals(skyblock.getSkyblockWorld().getName()) || p.getWorld().getName().equals(skyblock.getSkyblockNetherWorld().getName())){
						if(sbp.hasIsland()){
							if(!sbp.onIsland(en.getLocation(), true)){
								e.setCancelled(true);
							}
						}
						else{
							e.setCancelled(true);
						}
					}
					else if(p.getWorld().getName().equals(skyblock.getLobbyWorld().getName())){
						e.setCancelled(true);
					}
					else{}
				}
			}
			else if(ServerData.isServer(Server.PRISON)){
				if(!omp.isOpMode()){
					PrisonServer prison = ServerData.getPrison();
					PrisonPlayer pp = omp.getPrisonPlayer();
					
					if(p.getWorld().getName().equals(prison.getLobbyWorld().getName()) && en != null && (pp.getShop() == null || !pp.getShop().isInShop(en.getLocation()))){
						e.setCancelled(true);
					}
				}
			}
			else{}
			
			NPC npc = NPC.getNPC(en);
			if(npc != null){
				e.setCancelled(true);
				omp.updateInventory();
				
				if(!omp.onCooldown(Cooldown.NPC_INTERACT)){
					if(npc.getNPCType() == NPCType.ALPHA){
						omp.toServer(Server.ALPHA);
					}
					else if(npc.getNPCType() == NPCType.MINDCRAFT){
						if(omp.isInMindCraft()){
							omp.getMCPlayer().leave();
						}
						else{
							omp.getMCPlayer().join();
						}
					}
					else if(npc.getNPCType() == NPCType.LAPIS_PARKOUR){
						if(omp.isInLapisParkour()){
							omp.leaveLapisParkour();
						}
						else{
							omp.joinLapisParkour();
						}
					}
					else if(npc.getNPCType() == NPCType.MINIGAMES){
						new MiniGamesInv().open(p);
					}
					else if(npc.getNPCType() == NPCType.OMT_SHOP){
						new OMTShopInv().open(p);
					}
					else if(npc.getNPCType() == NPCType.KIT_SELECTOR){
						new KitSelectorInv().open(p);
					}
					else if(npc.getNPCType() == NPCType.SPECTATE){
						if(omp.getPet() != null){
							omp.disablePet();
						}
						if(omp.hasTrailEnabled()){
							omp.disableTrail();
						}
						
						KitPvPPlayer kp = omp.getKitPvPPlayer();
						kp.setSpectator();
						kp.teleportToMap();
						ServerData.getKitPvP().giveSpectatorItems(omp);
					}
					else if(npc.getNPCType() == NPCType.TUTORIALS){
						p.teleport(ServerData.getSurvival().getTutorials());
					}
					else if(npc.getNPCType() == NPCType.SPAWN){
						p.teleport(ServerData.getSurvival().getSpawn());
					}
					else if(npc.getNPCType() == NPCType.SHOP){
						new GoldShopInv().open(omp, null);
					}
					else if(npc.getNPCType() == NPCType.RESET_MINE){
						if(en.getCustomName() != null){
							if(omp.hasPerms(VIPRank.Gold_VIP)){
								if(!omp.onCooldown(Cooldown.RESET_MINE)){
									try{
										Rank rank = Rank.valueOf(en.getCustomName().substring(en.getCustomName().length() -1));
									
										Mine mine = Mine.getMine(rank, MineType.NORMAL);
										mine.reset(omp);
										
										p.sendMessage("§7Mine §a§l" + rank.toString() + "§7 has been reset!");
										
										omp.resetCooldown(Cooldown.RESET_MINE);
									}catch(IllegalArgumentException ex){}
								}
								else{
									if(omp.hasPerms(VIPRank.Diamond_VIP)){
										p.sendMessage("§7You can only reset a mine once every §65 minutes§7!");
									}
									else{
										p.sendMessage("§7You can only reset a mine once every §610 minutes§7!");
									}
								}
							}
							else{
								omp.requiredVIPRank(VIPRank.Gold_VIP);
							}
						}
					}
					else if(npc.getNPCType() == NPCType.VILLAGER_GAMBLE){
						new VillagerGambleInv(false).open(p);
					}
					else if(npc.getNPCType() == NPCType.RUNNER_KIT){
						new MGKitInv(TicketType.RUNNER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.FIGHTER_KIT){
						new MGKitInv(TicketType.FIGHTER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.ARCHER_KIT){
						new MGKitInv(TicketType.ARCHER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.WARRIOR_KIT){
						new MGKitInv(TicketType.WARRIOR_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.BOMBER_KIT){
						new MGKitInv(TicketType.BOMBER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.SURVIVOR_KIT){
						new MGKitInv(TicketType.SURVIVOR_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.STARTER_KIT){
						new MGKitInv(TicketType.STARTER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.APPLETREE_KIT){
						new MGKitInv(TicketType.APPLETREE_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.SPEEDSTER_KIT){
						new MGKitInv(TicketType.SPEEDSTER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.MINER_KIT){
						new MGKitInv(TicketType.MINER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.TANK_KIT){
						new MGKitInv(TicketType.TANK_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.SNOWGOLEM_KIT){
						new MGKitInv(TicketType.SNOWGOLEM_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.ENCHANTER_KIT){
						new MGKitInv(TicketType.ENCHANTER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.CREEPER_KIT){
						new MGKitInv(TicketType.CREEPER_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.ENDERMAN_KIT){
						new MGKitInv(TicketType.ENDERMAN_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.CHICKEN_MAMA_KIT){
						new MGKitInv(TicketType.CHICKEN_MAMA_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.BABY_CHICKEN_KIT){
						new MGKitInv(TicketType.BABY_CHICKEN_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.HOT_WING_KIT){
						new MGKitInv(TicketType.HOT_WING_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.CHICKEN_WARLORD_KIT){
						new MGKitInv(TicketType.CHICKEN_WARLORD_KIT).open(p);
					}
					else if(npc.getNPCType() == NPCType.CHICKEN_KIT){
						new MGKitInv(TicketType.CHICKEN_KIT).open(p);
					}
					else{}
					
					omp.resetCooldown(Cooldown.NPC_INTERACT);
				}
			}
		}
		else{
			e.setCancelled(true);
			omp.updateInventory();
			omp.notLoaded();
		}
	}
}
