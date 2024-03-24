package me.O_o_Fadi_o_O.OrbitMines.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.ChatColorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.CosmeticPerksInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.DisguiseInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.FireworkInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.GadgetInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.HatInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.InventoryInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.PetInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.ServerSelectorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.TrailInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.WardrobeInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.StringInt;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.ComponentMessage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativeUtils.PlotType;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Inventories.PlotInfoInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Inventories.PlotSetupInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Plot;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.Inventories.KitSelectorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.KitPvPKit;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Inventories.MineInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Inventories.ChallengesInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Inventories.IslandInfoInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Inventories.KitInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Island;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockUtils.ChallengeType;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockUtils.IslandRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Home;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Inventories.WarpEditorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Inventories.WarpInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Inventories.WarpRenameInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Warp;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.regions.Region;

public class CommandManager {

	public static enum Command {
		
		UUID,
		PLUGINS,
		PL,
		BUILDER,
		SERVERS,
		PERKS,
		OPMODE,
		TOPVOTERS,
		AFK,
		NICK,
		DISGUISE,
		DIS,
		D,
		UNDISGUISE,
		UNDIS,
		UND,
		GIVE,
		TP,
		TELEPORT,
		SKULL,
		EAT,
		FEED,
		FLY,
		GMS,
		GMC,
		GMA,
		GMSPEC,
		GAMEMODE,
		GM,
		VOTE,
		PETS,
		CHATCOLORS,
		DISGUISES,
		GADGETS,
		WARDROBE,
		TRAILS,
		HATS,
		FIREWORKS,
		SILENT,
		HEAL,
		KIT,
		PLOT,
		P,
		SPAWN,
		HOME,
		H,
		DELHOME,
		DELH,
		SETHOME,
		SETH,
		HOMES,
		CONFIRM,
		REGION,
		TOPMONEY,
		WARPS,
		MYWARPS,
		SETWARP,
		EDITWARP,
		ENDERCHEST,
		WORKBENCH,
		ACCEPT,
		TPHERE,
		INVSEE,
		BACK,
		ISLAND,
		IS,
		RANKUP,
		MINES,
		ADDENCH,
		ADDENCHANTMENT,
		PAY,
		TOPGOLD,
		REMOVEENTITIES;
		
		public String getName(){
			return "/" + this.toString().toLowerCase();
		}
		
		public void dispatch(OMPlayer omp, String[] a){
			switch(this){
				case AFK:
					dispatchAFK(omp, a);
					break;
				case BUILDER:
					dispatchBuilder(omp, a);
					break;
				case D:
					dispatchDisguise(omp, a);
					break;
				case DIS:
					dispatchDisguise(omp, a);
					break;
				case DISGUISE:
					dispatchDisguise(omp, a);
					break;
				case EAT:
					dispatchFeed(omp, a);
					break;
				case FEED:
					dispatchFeed(omp, a);
					break;
				case FLY:
					dispatchFly(omp, a);
					break;
				case GAMEMODE:
					dispatchGM(omp, a);
					break;
				case GIVE:
					dispatchGive(omp, a);
					break;
				case GM:
					dispatchGM(omp, a);
					break;
				case GMA:
					dispatchGMA(omp, a);
					break;
				case GMC:
					dispatchGMC(omp, a);
					break;
				case GMS:
					dispatchGMS(omp, a);
					break;
				case GMSPEC:
					dispatchGMSpec(omp, a);
					break;
				case NICK:
					dispatchNick(omp, a);
					break;
				case OPMODE:
					dispatchOPMode(omp, a);
					break;
				case PERKS:
					dispatchPerks(omp, a);
					break;
				case PL:
					dispatchPlugins(omp, a);
					break;
				case PLUGINS:
					dispatchPlugins(omp, a);
					break;
				case SERVERS:
					dispatchServers(omp, a);
					break;
				case SKULL:
					dispatchSkull(omp, a);
					break;
				case TELEPORT:
					dispatchTeleport(omp, a);
					break;
				case TOPVOTERS:
					dispatchTopVoters(omp, a);
					break;
				case TP:
					dispatchTeleport(omp, a);
					break;
				case UND:
					dispatchUndisguise(omp, a);
					break;
				case UNDIS:
					dispatchUndisguise(omp, a);
					break;
				case UNDISGUISE:
					dispatchUndisguise(omp, a);
					break;
				case UUID:
					dispatchUUID(omp, a);
					break;
				case VOTE:
					dispatchVote(omp, a);
					break;
				case CHATCOLORS:
					dispatchChatColors(omp, a);
					break;
				case DISGUISES:
					dispatchDisguises(omp, a);
					break;
				case FIREWORKS:
					dispatchFireworks(omp, a);
					break;
				case GADGETS:
					dispatchGadgets(omp, a);
					break;
				case HATS:
					dispatchHats(omp, a);
					break;
				case PETS:
					dispatchPets(omp, a);
					break;
				case TRAILS:
					dispatchTrails(omp, a);
					break;
				case WARDROBE:
					dispatchWardrobe(omp, a);
					break;
				case SILENT:
					dispatchSilent(omp, a);
					break;
				case HEAL:
					dispatchHeal(omp, a);
					break;
				case KIT:
					dispatchKit(omp, a);
					break;
				case P:
					dispatchPlot(omp, a);
					break;
				case PLOT:
					dispatchPlot(omp, a);
					break;
				case SPAWN:
					dispatchSpawn(omp, a);
					break;
				case HOME:
					dispatchHome(omp, a);
					break;
				case H:
					dispatchHome(omp, a);
					break;
				case DELHOME:
					dispatchDelHome(omp, a);
					break;
				case DELH:
					dispatchDelHome(omp, a);
					break;
				case SETHOME:
					dispatchSetHome(omp, a);
					break;
				case SETH:
					dispatchSetHome(omp, a);
					break;
				case HOMES:
					dispatchHomes(omp, a);
					break;
				case CONFIRM:
					dispatchConfirm(omp, a);
					break;
				case REGION:
					dispatchRegion(omp, a);
					break;
				case TOPMONEY:
					dispatchTopMoney(omp, a);
					break;
				case WARPS:
					dispatchWarps(omp, a);
					break;
				case MYWARPS:
					dispatchMyWarps(omp, a);
					break;
				case SETWARP:
					dispatchSetWarp(omp, a);
					break;
				case EDITWARP:
					dispatchEditWarp(omp, a);
					break;
				case ENDERCHEST:
					dispatchEnderchest(omp, a);
					break;
				case WORKBENCH:
					dispatchWorkbench(omp, a);
					break;
				case TPHERE:
					dispatchTPHere(omp, a);
					break;
				case ACCEPT:
					dispatchAccept(omp, a);
					break;
				case INVSEE:
					dispatchInvSee(omp, a);
					break;
				case BACK:
					dispatchBack(omp, a);
					break;
				case ISLAND:
					dispatchIsland(omp, a);
					break;
				case IS:
					dispatchIsland(omp, a);
					break;
				case RANKUP:
					dispatchRankup(omp, a);
					break;
				case MINES:
					dispatchMines(omp, a);
					break;
				case ADDENCH:
					dispatchAddEnchantment(omp, a);
					break;
				case ADDENCHANTMENT:
					dispatchAddEnchantment(omp, a);
					break;
				case PAY:
					dispatchPay(omp, a);
					break;
				case TOPGOLD:
					dispatchTopGold(omp, a);
					break;
				case REMOVEENTITIES:
					dispatchRemoveEntities(omp, a);
					break;
				default:
					break;
			}
		}
		
		private void dispatchRemoveEntities(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.KITPVP) && omp.hasPerms(StaffRank.Owner)){
				for(Entity en : p.getWorld().getEntities()){
					if(!(en instanceof Player)){
						en.remove();
					}
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchTopGold(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.PRISON)){
				List<StringInt> players = ServerData.getPrison().getTopGold();
				
				p.sendMessage("");
				p.sendMessage("§6§lTop 10 richest Players§7:");
				sendTopGoldMessage(p, "§6§l1.§6", players.get(0).getString(), players.get(0).getInteger());
				sendTopGoldMessage(p, "§7§l2.§7", players.get(1).getString(), players.get(1).getInteger());
				sendTopGoldMessage(p, "§c§l3.§c", players.get(2).getString(), players.get(2).getInteger());
				sendTopGoldMessage(p, "§8§l4.§8", players.get(3).getString(), players.get(3).getInteger());
				sendTopGoldMessage(p, "§8§l5.§8", players.get(4).getString(), players.get(4).getInteger());
				sendTopGoldMessage(p, "§8§l6.§8", players.get(5).getString(), players.get(5).getInteger());
				sendTopGoldMessage(p, "§8§l7.§8", players.get(6).getString(), players.get(6).getInteger());
				sendTopGoldMessage(p, "§8§l8.§8", players.get(7).getString(), players.get(7).getInteger());
				sendTopGoldMessage(p, "§8§l9.§8", players.get(8).getString(), players.get(8).getInteger());
				sendTopGoldMessage(p, "§8§l10.§8", players.get(9).getString(), players.get(9).getInteger());
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void sendTopGoldMessage(Player p, String placement, String player, int money){
			if(money == 1){
				p.sendMessage("  " + placement + " " + player + " §7| §6" + money + " Gold");
			}
			else{
				if(player == null){
					p.sendMessage("  " + placement + " ");
				}
				else{
					p.sendMessage("  " + placement + " " + player + " §7| §6" + money + " Gold");
				}
			}
		}
		
		private void dispatchPay(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.PRISON)){
				if(a.length == 3){
					Player p2 = Utils.getPlayer(a[1]);
					
					if(p2 != null){
						if(p2 != p){
							PrisonPlayer pp = omp.getPrisonPlayer();
							OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
							PrisonPlayer pp2 = omp2.getPrisonPlayer();
							
							boolean numeric = true;
							
							for(int i = 0; i < a[2].length(); i++){
								if(!Character.isDigit(a[2].charAt(i))){
									numeric = false;
								}
							}
							
							if(numeric){
								int amount = Integer.parseInt(a[2]);
								
								if(pp.hasGold(amount)){
				    				p.sendMessage("§7You paid " + omp2.getName() + " §6§l" + amount + " Gold§7!");
				    				p2.sendMessage(omp.getName() + "§7 paid you §6§l" + amount + " Gold§7!");
				    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
				    				p2.playSound(p2.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
				    				
				    				pp.removeGold(amount);
				    				pp2.addGold(amount);
								}
								else{
									pp.removeGold(amount);
								}
							}
							else{
								p.sendMessage("§7Invalid number.");
							}
						}
		    			else{
		    				p.sendMessage("§7You cannot send §6§lGold§7 to yourself.");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + "§7 isn't §aonline§7!");
		    		}
				}
				else{
					p.sendMessage("§7Use §6/pay <player> <amount>§7.");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchAddEnchantment(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(omp.hasPerms(StaffRank.Owner)){
				ItemStack item = p.getItemInHand();
				
				if(item != null){
					if(a.length == 3){
						Enchantment ench = Enchantment.getByName(a[1]);
						
						if(ench != null){
							try{
								int level = Integer.parseInt(a[2]);
								
								item.addUnsafeEnchantment(ench, level);
							}catch(NumberFormatException ex){
								p.sendMessage("§7Invalid Level. (§6" + a[2] + "§7)");
							}
						}
						else{
							p.sendMessage("§7Unknown Enchantment. (§6" + a[1] + "§7)");
						}
					}
					else{
						p.sendMessage("§7Use §6" + a[0].toLowerCase() + " <enchantment> <level>§7.");
					}
				}
				else{
					p.sendMessage("§7You don't have an item in your hand.");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchMines(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.PRISON)){
				if(!omp.getPrisonPlayer().isInPvP()){
					new MineInv().open(omp.getPrisonPlayer());
				}
				else{
					p.sendMessage("You cannot use that command in the §c§lPvP Area§7!");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchRankup(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.PRISON)){
				PrisonPlayer pp = omp.getPrisonPlayer();
				
				if(pp.getRank().getNextRank() != null){
					if(pp.canRankup()){
						pp.rankup();
					}
					else{
						pp.requiredGold(pp.getRank().getRankupPrice());
					}
				}
				else{
					p.sendMessage("§7You've reached the highest rank! More ranks are coming soon!");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchIsland(OMPlayer omp, String[] a){
			final Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SKYBLOCK)){
				final SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
				Island is = sbp.getIsland();
				
				if(a.length > 1){
					if(a[1].equalsIgnoreCase("restart")){
						if(sbp.hasIsland()){
							p.chat("/island leave");
							p.chat("/island home");
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("home") || a[1].equalsIgnoreCase("h")){
						if(sbp.hasIsland()){
							if(!sbp.inVoid()){
								p.sendMessage("§7Teleporting to your §dIsland§7...");
								
								omp.resetCooldown(Cooldown.TELEPORTING);
								sbp.setTeleportingTo(is);
							}
							else{
								p.sendMessage("§7You cannot do that in the Void§7!");
							}
						}
						else{
							Island.generate(sbp);
						}
					}
					else if(a[1].equalsIgnoreCase("sethome") || a[1].equalsIgnoreCase("seth")){
						if(sbp.hasIsland()){
							if(p.getWorld().getName().equals(ServerData.getSkyBlock().getSkyblockWorld().getName())){
								if(!sbp.inVoid()){
									if(sbp.onOwnIsland(p.getLocation(), true)){
										sbp.setHomeLocation(p.getLocation());
										p.sendMessage("§dIsland Home§7 set!");
									}
								}
								else{
									p.sendMessage("§7You cannot do that in the Void§7!");
								}
							}
							else{
								p.sendMessage("§7You cannot do that here§7!");
							}
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("invite")){
						if(sbp.hasIsland()){
							if(sbp.isOwner()){
								if(a.length == 3){
									if(is.getMembers().size() +1 != is.getMaxMembers()){
										Player p2 = Utils.getPlayer(a[2]);
										
										if(p2 != null){
											if(p != p2){
												OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
												SkyBlockPlayer sbp2 = omp2.getSkyBlockPlayer();
												
												if(!sbp2.hasIsland()){
													p.sendMessage("§d" + p2.getName() + "§7 has been invited to your §dIsland§7!");
													p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													
													sbp2.setInvited(is);
													p2.sendMessage("§d" + p.getName() + "§7 has invited you to their §dIsland§7!");
													p2.sendMessage("§7Type §d/is accept§7 to §aAccept§7 or §d/is deny§7 to §cDeny§7.");
													p2.playSound(p2.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													
													is.sendMessageToMembers("§d" + p.getName() + "§7 invited §d" + a[1] + "§7 to your §dIsland§7!");
												}
												else{
									    			p.sendMessage("§d" + p2.getName() + " §7already has an §dIsland§7.");
												}
											}
											else{
								    			p.sendMessage("§7You can't invite yourself!");
											}
										}
										else{
							    			p.sendMessage("§7Player §d" + a[2] + " §7isn't §aOnline§7!");
										}
									}
									else{
										p.sendMessage("§7Your §dIsland§7 already reached the maximum amount of members! (§6" + is.getMaxMembers() + "§7)");
									}
								}
								else{
									p.sendMessage("§7Use §d" + a[0].toLowerCase() + " invite <player>§7.");
								}
							}
							else{
								p.sendMessage("§7You're not the owner of your §dIsland§7!");
							}
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("remove")){
						if(sbp.hasIsland()){
							if(sbp.isOwner()){
								if(a.length == 3){
									if(!a[2].equalsIgnoreCase(p.getName())){
										Player p2 = Utils.getPlayer(a[2]);
										UUID uuid = null;
										
										if(p2 != null){
											uuid = p2.getUniqueId();
										}
										else{
											uuid = Utils.getUUID(a[2]);
										}
										
										if(uuid != null && Utils.getStringList(is.getMembers()).contains(uuid.toString())){
											is.removeMember(uuid);
											
											p.sendMessage("§7You removed §d" + a[2] + "§7 from your §dIsland§7!");
											p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											
											if(p2 != null){
												OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
												SkyBlockPlayer sbp2 = omp2.getSkyBlockPlayer();
												
												sbp2.setIsland(null, null);
												sbp2.setHomeLocation(null);
												
												p2.sendMessage("§d" + p.getName() + "§7 removed you from their §dIsland§7!");
												p2.playSound(p2.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												p2.teleport(ServerData.getSkyBlock().getSpawn());
											}
											ConfigManager.playerdata.set("players." + uuid.toString() + ".IslandInfo", null);
											ConfigManager.savePlayerData();
											
											is.sendMessageToMembers("§d" + p.getName() + "§7 removed §d" + a[2] + "§7 from your §dIsland§7!");
										}
										else{
											p.sendMessage("§7Player §d" + a[2] + "§7 isn't on your §dIsland§7!");
										}
									}
									else{
										p.sendMessage("§7You can't remove yourself from your own §dIsland§7!");
									}
								}
								else{
									p.sendMessage("§7Use §d" + a[0].toLowerCase() + " remove <player>§7.");
								}
							}
							else{
								p.sendMessage("§7You're not the owner of your §dIsland§7!");
							}
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("accept")){
						if(sbp.isInvited()){
							if(!sbp.hasIsland()){
								Island is2 = sbp.getInvited();
								
								if(is2.getMembers().size() + 1 != is2.getMaxMembers()){
									is2.sendMessageToMembers("§d" + p.getName() + "§7 joined your §dIsland§7!");
									
									Player owner = Utils.getPlayer(is2.getOwner());
									if(owner != null){
										owner.sendMessage("§d" + p.getName() + "§7 joined your §dIsland§7!");
									}

									p.sendMessage("§7You joined §dIsland " + is2.getIslandID() + "§7.");
									p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									
									is2.addMember(p.getUniqueId());
									sbp.setIsland(is2, IslandRank.MEMBER);
									sbp.setInvited(null);
									
									p.teleport(sbp.getHomeLocation());
									p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
									
									Title t = new Title("", "§7Teleported to your §dIsland§7.");
									t.send(p);
								}
								else{
									sbp.setInvited(null);
									p.sendMessage("§7That §dIsland§7 already reached the maximum amount of members!");
								}
							}
							else{
								sbp.setInvited(null);
								p.sendMessage("§7You already have an §dIsland§7.");
							}
						}
						else{
							p.sendMessage("§7You haven't been invited to an §dIsland§7.");
						}
					}
					else if(a[1].equalsIgnoreCase("deny")){
						if(sbp.isInvited()){
							Island is2 = sbp.getInvited();
							Player owner = Utils.getPlayer(is2.getOwner());
					
							if(owner != null){
								owner.sendMessage("§d" + p.getName() + "§7 denied your invite§7!");
								owner.playSound(owner.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							}

							sbp.setInvited(null);
							p.sendMessage("§dIsland§7 invite denied.");
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						}
						else{
							p.sendMessage("§7You haven't been invited to an §dIsland§7.");
						}
					}
					else if(a[1].equalsIgnoreCase("leave")){
						if(sbp.hasIsland()){
							ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo", null);
							ConfigManager.savePlayerData();
							
							omp.clearInventory();
							p.teleport(ServerData.getSkyBlock().getSpawn());
							p.sendMessage("§7You left your §dIsland§7!");
							
							if(sbp.isOwner()){
								if(is.getMembers().size() != 0){
									UUID newowner = is.getMembers().get(0);
									Player p2 = Utils.getPlayer(newowner);
									
									is.sendMessageToMembers("§d" + p.getName() + "§7 left your §dIsland§7!");
									is.removeMember(newowner);
									is.setOwner(newowner);
									
									if(p2 != null){
										OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
										SkyBlockPlayer sbp2 = omp2.getSkyBlockPlayer();
										
										sbp2.setIslandRank(IslandRank.OWNER);
										is.sendMessageToMembers("§d" + p2.getName() + "§7 is now the §downer§7 of your §dIsland§7!");
										
										p.sendMessage("§7You are now the §downer§7 of your §dIsland§7!");
									}
									else{
										ConfigManager.playerdata.set("players." + newowner.toString() + ".IslandInfo.IslandRank", IslandRank.OWNER.toString());
										ConfigManager.savePlayerData();

										is.sendMessageToMembers("§d" + Utils.getName(newowner) + "§7 is now the §downer§7 of your §dIsland§7!");
									}
								}
								else{
									is.delete();
								}
							}
							else{
								is.removeMember(p.getUniqueId());
								is.sendMessageToMembers("§d" + p.getName() + "§7 left your §dIsland§7!");
								
								Player owner = Utils.getPlayer(is.getOwner());
								if(owner != null){
									owner.sendMessage("§d" + p.getName() + "§7 left your §dIsland§7!");
								}
							}
							
							sbp.setIsland(null, null);
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("teleport") || a[1].equalsIgnoreCase("tp")){
						if(a.length == 3){	
							Player p2 = Utils.getPlayer(a[2]);
							
							if(p2 != null){
								OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
								SkyBlockPlayer sbp2 = omp2.getSkyBlockPlayer();
								
								if(sbp2.hasIsland()){
									Island is2 = sbp2.getIsland();
									
									if(is2.isTeleportEnabled()){
										if(!sbp.inVoid()){
											sbp.setTeleportingTo(is2);
											omp.resetCooldown(Cooldown.TELEPORTING);
										}
										else{
											p.sendMessage("§7You cannot do that in the Void§7!");
										}
									}
									else{
										p.sendMessage("§d" + p2.getName() + "'s Island§7 has teleporting §c§lDISABLED§7.");
									}
								}
								else{
									p.sendMessage("§d" + p2.getName() + "§7 doesn't have an §dIsland§7.");
								}
							}
							else{
								p.sendMessage("§7Player §d" + a[2] +" §7isn't §aOnline§7!");
							}
						}
						else{
							p.sendMessage("§7Use §d" + a[0].toLowerCase() + " " + a[1].toLowerCase() + " <player>§7.");
						}
					}
					else if(a[1].equalsIgnoreCase("challenge") || a[1].equalsIgnoreCase("c")){
						if(sbp.hasIsland()){
							new ChallengesInv(ChallengeType.GATHER).open(p);
							p.playSound(p.getLocation(), Sound.WITHER_IDLE, 5, 1);
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("info")){
						if(sbp.hasIsland()){
							new IslandInfoInv().open(sbp);
							p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
						}
						else{
							p.sendMessage("§7You don't have an §dIsland§7!");
						}
					}
					else{
						p.sendMessage("§lHelp Menu:");
						p.sendMessage("§d/is home | h §7§o(Teleport to your Island)");
						p.sendMessage("§d/is sethome §7§o(Set your Island Home)");
						p.sendMessage("§d/is help §7§o(Show this Menu)");
						p.sendMessage("§d/is invite <player> §7§o(Invite a Player)");
						p.sendMessage("§d/is remove <player> §7§o(Remove a Player)");
						p.sendMessage("§d/is accept §7§o(Accept an Island invite)");
						p.sendMessage("§d/is deny §7§o(Deny an Island invite)");
						p.sendMessage("§d/is tp | teleport <player> §7§o(Teleport to an Island)");
						p.sendMessage("§d/is c | challenge §7§o(Open the Challenges Menu)");
						p.sendMessage("§d/is leave §7§o(Leave your Island)");
						p.sendMessage("§d/is restart §7§o(Restart your Island)");
						p.sendMessage("§d/is info §7§o(Open the Island Info Menu)");
					}
				}
				else{
					p.sendMessage("§lHelp Menu:");
					p.sendMessage("§d/is home | h §7§o(Teleport to your Island)");
					p.sendMessage("§d/is sethome §7§o(Set your Island Home)");
					p.sendMessage("§d/is help §7§o(Show this Menu)");
					p.sendMessage("§d/is invite <player> §7§o(Invite a Player)");
					p.sendMessage("§d/is remove <player> §7§o(Remove a Player)");
					p.sendMessage("§d/is accept §7§o(Accept an Island invite)");
					p.sendMessage("§d/is deny §7§o(Deny an Island invite)");
					p.sendMessage("§d/is tp | teleport <player> §7§o(Teleport to an Island)");
					p.sendMessage("§d/is c | challenge §7§o(Open the Challenges Menu)");
					p.sendMessage("§d/is leave §7§o(Leave your Island)");
					p.sendMessage("§d/is restart §7§o(Restart your Island)");
					p.sendMessage("§d/is info §7§o(Open the Island Info Menu)");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchBack(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				if(omp.hasPerms(VIPRank.Emerald_VIP)){
					if(sp.hasLastLocation()){
						p.teleport(sp.getLastLocation());
						sp.setLastLocation(null);
						p.sendMessage("§7Teleported to your previous location.");
					}
					else{
						p.sendMessage("§7You cannot teleport to your previous location.");
					}
				}
				else{
					omp.requiredVIPRank(VIPRank.Emerald_VIP);
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchInvSee(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(omp.hasPerms(StaffRank.Moderator) || ServerData.isServer(Server.SURVIVAL, Server.SKYBLOCK, Server.PRISON) && omp.hasPerms(VIPRank.Diamond_VIP)){
				if(a.length == 2){
					Player p2 = Utils.getPlayer(a[1]);
					
					if(p2 != null){
						OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
						
						if(omp.hasPerms(StaffRank.Moderator) || !omp2.hasPerms(StaffRank.Moderator)){
							new InventoryInv(p2).open(p);
						}
						else{
							p.sendMessage("§7You cannot view " + omp2.getName() + "'s §7inventory.");
						}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
	    		else{
			    	p.sendMessage("§7Use §6/invsee <player>§7.");
	    		}
			}
			else if(ServerData.isServer(Server.SURVIVAL, Server.SKYBLOCK, Server.PRISON)){
				omp.requiredVIPRank(VIPRank.Diamond_VIP);
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchAccept(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				if(sp.hasTPRequest()){
					SurvivalPlayer sp2 = sp.getTPRequest();
					Player p2 = Utils.getPlayer(sp2.getUUID());
					
					if(p2 != null){
						OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
						p2.teleport(p);
						p.sendMessage(omp2.getName() + " §7has been teleporter to you.");
						p2.sendMessage(omp.getName() + " §7accepted your request.");
						p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					}
					else{
						p.sendMessage("§6" + Utils.getName(sp2.getUUID()) + "§7 is no longer §aonline§7!");
					}
					
					sp.setTPRequest(null);
				}
				else if(sp.hasTPHereRequest()){
					SurvivalPlayer sp2 = sp.getTPHereRequest();
					Player p2 = Utils.getPlayer(sp2.getUUID());
					
					if(p2 != null){
						OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
						p.teleport(p2);
						p.sendMessage("§7You have been teleported to " + omp2.getName() + "§7.");
						p2.sendMessage(omp.getName() + " §7accepted your request.");
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					}
					else{
						p.sendMessage("§6" + Utils.getName(sp2.getUUID()) + "§7 is no longer §aonline§7!");
					}
					
					sp.setTPHereRequest(null);
				}
				else{
					omp.unknownCommand(a[0]);
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchTPHere(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				if(omp.hasPerms(VIPRank.Emerald_VIP)){
					if(a.length == 2){
			    		Player p2 = Utils.getPlayer(a[1]);
			    		
			    		if(p2 != null){
				    		if(p2 != p){
					    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
					    		SurvivalPlayer sp2 = omp2.getSurvivalPlayer();

					    		sp2.setTPRequest(null);
			    				sp2.setTPHereRequest(omp.getSurvivalPlayer());
			    				p.sendMessage("§7Teleport request sent to §6" + omp2.getName() + "§7!");
			    				p2.sendMessage(omp.getName() + "§7 wants to teleport you to them. Type §a/accept§7 to accept.");
			    			}
			    			else{
			    				p.sendMessage("§7You can't §6teleport§7 yourself!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
			    		}
			    	}
		    		else{
				    	p.sendMessage("§7Use §6/tphere <player>§7.");
		    		}
				}
				else{
					omp.requiredVIPRank(VIPRank.Emerald_VIP);
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchWorkbench(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL, Server.PRISON)){
				if(omp.hasPerms(VIPRank.Diamond_VIP)){
					p.openWorkbench(null, true);
				}
				else{
					omp.requiredVIPRank(VIPRank.Diamond_VIP);
				}
			}
			else if(ServerData.isServer(Server.SKYBLOCK)){
				if(omp.hasPerms(VIPRank.Gold_VIP)){
					p.openWorkbench(null, true);
				}
				else{
					omp.requiredVIPRank(VIPRank.Gold_VIP);
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchEnderchest(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL, Server.SKYBLOCK, Server.PRISON)){
				if(omp.hasPerms(VIPRank.Emerald_VIP)){
					p.openInventory(p.getEnderChest());
				}
				else{
					omp.requiredVIPRank(VIPRank.Emerald_VIP);
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchWarps(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				new WarpInv(0, false).open(p);
			}
			else if(ServerData.isServer(Server.PRISON)){
				p.sendMessage("§7Try §6/mines§7.");
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchMyWarps(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				String warps = "";
				for(Warp warp : sp.getWarps()){
					if(warps.equals("")){
						warps = "§6" + warp.getName();
		    		}
		    		else{
		    			warps += "§7, §6" + warp.getName();
		    		}
		    	}
				
				if(!warps.equals("")){
					p.sendMessage("§7Your Warps: " + warps);
				}
				else{
					p.sendMessage("§7No §6warps§7 to display. Create one using §6/setwarp§7.");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchSetWarp(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				if(sp.getWarps().size() < sp.getWarpsAllowed()){
					if(p.getWorld().getName().equals(ServerData.getSurvival().getSurvivalWorld().getName())){
						new WarpRenameInv(omp, null).open();
					}
					else{
						p.sendMessage("§7You're only allowed to create warps in the overworld!");
					}
				}
				else{
					if(sp.getWarps().size() == 0){
						p.sendMessage("§7You cannot set any warps! Type §3/donate§7 to discover how to create one!");
					}
					else{
						p.sendMessage("§7You already reached the maximum amount of warps! (§6" + sp.getWarpsAllowed() + "§7)");
					}
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchEditWarp(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				if(a.length == 2){
					SurvivalPlayer sp = omp.getSurvivalPlayer();
					Warp warp = Warp.getWarp(a[1]);
					
					if(warp != null && sp.getWarps().contains(warp)){
						new WarpEditorInv(warp).open(p);
					}
					else{
						p.sendMessage("§7You don't possess a warp named '§6" + a[1] + "§7'.");
					}
				}
				else{
					p.sendMessage("§7Use §6/editwarp <warp>§7.");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchTopMoney(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				List<StringInt> players = ServerData.getSurvival().getTopMoney();
				
				p.sendMessage("");
				p.sendMessage("§2§lTop 10 richest Players§7:");
				sendTopMoneyMessage(p, "§6§l1.§6", players.get(0).getString(), players.get(0).getInteger());
				sendTopMoneyMessage(p, "§7§l2.§7", players.get(1).getString(), players.get(1).getInteger());
				sendTopMoneyMessage(p, "§c§l3.§c", players.get(2).getString(), players.get(2).getInteger());
				sendTopMoneyMessage(p, "§8§l4.§8", players.get(3).getString(), players.get(3).getInteger());
				sendTopMoneyMessage(p, "§8§l5.§8", players.get(4).getString(), players.get(4).getInteger());
				sendTopMoneyMessage(p, "§8§l6.§8", players.get(5).getString(), players.get(5).getInteger());
				sendTopMoneyMessage(p, "§8§l7.§8", players.get(6).getString(), players.get(6).getInteger());
				sendTopMoneyMessage(p, "§8§l8.§8", players.get(7).getString(), players.get(7).getInteger());
				sendTopMoneyMessage(p, "§8§l9.§8", players.get(8).getString(), players.get(8).getInteger());
				sendTopMoneyMessage(p, "§8§l10.§8", players.get(9).getString(), players.get(9).getInteger());
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void sendTopMoneyMessage(Player p, String placement, String player, int money){
			if(money == 1){
				p.sendMessage("  " + placement + " " + player + " §7| §2" + money + "$");
			}
			else{
				if(player == null){
					p.sendMessage("  " + placement + " ");
				}
				else{
					p.sendMessage("  " + placement + " " + player + " §7| §2" + money + "$");
				}
			}
		}
		
		private void dispatchRegion(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.SURVIVAL)){
				ServerData.getSurvival().getRegionTeleporter().open(p);
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		public static void dispatchConfirm(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL) && omp.getCooldowns().containsKey(Cooldown.PVP_CONFIRM)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				omp.removeCooldown(Cooldown.PVP_CONFIRM);
				sp.teleportToPvPArea();
				
				Title t = new Title("", "§7You've entered the §cPvP Area§7.", 0, 40, 20);
				t.send(p);
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchHomes(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				String homes = "";
				for(Home home : sp.getHomes()){
					if(homes.equals("")){
						homes = "§6" + home.getName();
		    		}
		    		else{
		    			homes += "§7, §6" + home.getName();
		    		}
		    	}
				
				if(!homes.equals("")){
					p.sendMessage("§7Your Homes: " + homes);
				}
				else{
					p.sendMessage("§7No §6homes§7 to display. Create one using §6/sethome <name>§7.");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchSetHome(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				if(sp.getHomes().size() < sp.getHomesAllowed()){
					boolean cancreate = true;
					
					for(int i = 0; i < a[1].length(); i++){
						if(!Character.isAlphabetic(a[1].charAt(i)) && !Character.isDigit(a[1].charAt(i))){
							cancreate = false;
						}
					}
					
					if(cancreate){
						sp.setHome(a[1]);
					}
					else{
						p.sendMessage("§7Your §6home name§7 can only contain §6alphabetic§7 and §6numeric§7 characters.");
					}
				}
				else{
					p.sendMessage("§7You already reached the maximum amount of homes! (§6" + sp.getHomesAllowed() + "§7)");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchDelHome(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				if(sp.getHomes().size() > 0){
					if(a.length == 2){
						Home home = sp.getHome(a[1]);
							
						if(home != null){
							sp.removeHome(home);
							p.sendMessage("§7Removed your home! (§6" + home.getName() + "§7)");
						}
						else{
							p.sendMessage("§7You don't have a §6home§7 named '§6" + a[1] + "§7'!");
						}
					}
					else{
						p.sendMessage("§7Use §6/" + a[0].toLowerCase() + " <name>§7.");
					}
				}
				else{
					p.sendMessage("§7You haven't set a §6home§7 yet!");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchHome(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp = omp.getSurvivalPlayer();
				
				if(sp.getHomes().size() > 0){
					if(a.length == 1){
						sp.getHomes().get(0).teleport();
					}
					else if(a.length == 2){
						Home home = sp.getHome(a[1]);
							
						if(home != null){
							home.teleport();
						}
						else{
							p.sendMessage("§7You don't have a §6home§7 named '§6" + a[1] + "§7'!");
						}
					}
					else{
						p.sendMessage("§7Use §6/" + a[0].toLowerCase() + " <name>§7.");
					}
				}
				else{
					p.sendMessage("§7You haven't set a §6home§7 yet!");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		public static void dispatchSpawn(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.CREATIVE, Server.SURVIVAL, Server.SKYBLOCK, Server.PRISON)){
				omp.resetCooldown(Cooldown.TELEPORTING);
				p.sendMessage("§7Teleporting to §6Spawn§7...");
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		public static void dispatchInPvPPlot(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(a[0].equalsIgnoreCase("/p") || a[0].equalsIgnoreCase("/plot")){
				if(a[1].equalsIgnoreCase("leave")){
					omp.resetCooldown(Cooldown.TELEPORTING);
					p.sendMessage("§7Leaving §dPlot§7...");
				}
				else{
					p.sendMessage("§7You are in a §c§lPvP Plot§7! Use §d/plot leave§7 to leave!");
				}
			}
			else{
				p.sendMessage("§7You are in a §c§lPvP Plot§7! Use §d/plot leave§7 to leave!");
			}
		}
		
		@SuppressWarnings("deprecation")
		public static boolean dispatchWECommand(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			CreativePlayer cp = omp.getCreativePlayer();
			
			if(cp.hasWEAccess(a[0])){
				try{
					if(!cp.isInPvPPlot()){
						WorldEdit we = WorldEdit.getInstance();
						Region s = we.getSession(p.getName()).getSelection(we.getSession(p.getName()).getSelectionWorld());
						World w = Bukkit.getWorld(s.getWorld().getName());
						int x1 = s.getMinimumPoint().getBlockX();
						int y1 = s.getMinimumPoint().getBlockY();
						int z1 = s.getMinimumPoint().getBlockZ();
						int x2 = s.getMaximumPoint().getBlockX();
						int y2 = s.getMaximumPoint().getBlockY();
						int z2 = s.getMaximumPoint().getBlockZ();
						
						Location l1 = new Location(w, x1, y1, z1);
						Location l2 = new Location(w, x2, y2, z2);
						
						boolean canuse = true;
						for(Block b : Utils.getBlocksBetween(l1, l2)){
							if(!cp.isOnPlot(b.getLocation())){
								canuse = false; 
							}
						}
						
						if(canuse == false){
							p.sendMessage("§7Your §dWorldEdit§7 selection goes outside your §dPlot§7.");
							return false;
						}
					}
					else{
						p.sendMessage("§7You're in a §c§lPvP Plot§7. You cannot use §dWorldEdit§7 here!");
						return false;
					}
				}catch(Exception ex){
					return false;
				}
			}
			else{
				p.sendMessage("§7You can buy this command at the §eOMT Shop§7! (§e/spawn§7)");
				return false;
			}
			return true;
		}
		
		private void dispatchPlot(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.CREATIVE)){
				CreativePlayer cp = omp.getCreativePlayer();
				
				if(a.length > 1){
					if(a[1].equalsIgnoreCase("home") || a[1].equalsIgnoreCase("h")){
						if(!cp.hasPlot()){
							p.sendMessage("§7Preparing new §dPlot§7...");
							p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
							Plot.nextPlot(cp);
						}
						
						p.teleport(cp.getPlot().getHomeLocation());
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
						Title t = new Title("", "§7Teleported to your §dPlot§7.");
						t.send(p);
					}
					else if(a[1].equalsIgnoreCase("sethome") || a[1].equalsIgnoreCase("seth")){
						if(cp.hasPlot()){
							if(p.getWorld().getName().equals(ServerData.getCreative().getPlotWorld().getName())){
								if(cp.isOnPlot(p.getLocation())){
									cp.getPlot().setHomeLocation(p.getLocation());
									p.sendMessage("§dPlot Home§7 set!");
								}
							}
							else{
								p.sendMessage("§7You cannot set your §dPlot Home§7 here!");
							}
						}
						else{
							p.sendMessage("§7You don't have a §dPlot§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("pvpbroadcast")){
						if(omp.hasPerms(VIPRank.Emerald_VIP)){
							if(cp.hasPlot()){
								if(cp.getPlot().getPlotType() == PlotType.PVP){
									if(!omp.onCooldown(Cooldown.BROADCAST)){
										for(Player player : Bukkit.getOnlinePlayers()){
											player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
											player.sendMessage("");

											ComponentMessage cm = new ComponentMessage();
											cm.addPart("§d" + p.getName() + "'s Plot§7 is in §c§lPvP Mode§7! ", null, null, null, null);
											cm.addPart("§a§lClick Here to Join", ClickEvent.Action.RUN_COMMAND, "/p join " + cp.getPlot().getPlotID(), HoverEvent.Action.SHOW_TEXT, "§aClick to Join");
											cm.send(player);
										}
										
										omp.resetCooldown(Cooldown.BROADCAST);
									}
								}
								else{
									p.sendMessage("§7Your §dPlot§7 has to be in §c§lPvP Mode§7!");
								}
							}
							else{
								p.sendMessage("§7You don't have a §dPlot§7!");
							}
						}
						else{
							omp.requiredVIPRank(VIPRank.Emerald_VIP);
						}
					}
					else if(a[1].equalsIgnoreCase("join")){
						if(cp.getPvPPlot() == null){
							if(a.length == 3){
								try{
									Plot plot = Plot.getPlot(Integer.parseInt(a[2]));
									
									if(plot != null && plot.getPlotType() == PlotType.PVP){
										List<CreativePlayer> players = Plot.getPvPPlayers(plot);
										if(players.size() < plot.getPvPMaxPlayers()){
											players.add(cp);
											cp.setPvPPlot(plot);
											
											p.teleport(plot.getPvPLobbyLocation());
											p.setGameMode(GameMode.SURVIVAL);
											Title t = new Title("", "§7Joined Plot §d#" + plot.getPlotID() + "§7!");
											t.send(p);
											
											for(CreativePlayer cplayer : players){
												cplayer.getPlayer().playSound(cplayer.getPlayer().getLocation(), Sound.CLICK, 5, 1);
												cplayer.getPlayer().sendMessage("§d" + p.getName() + "§7 joined §dPlot #" + plot.getPlotID() + "§7. (§d" + players.size() + "§7/§d" + plot.getPvPMaxPlayers() + "§7)");
											}

											if(omp.hasHatsBlockTrail()){
												omp.setHatsBlockTrail(false);
											}
											if(omp.isDisguised()){
												omp.undisguise();
											}
											if(omp.hasWardrobeEnabled()){
												omp.disableWardrobe();
											}
											
											p.setLevel(0);
											p.setExp(0);
											omp.clearInventory();
											omp.clearPotionEffects();
										}
										else{
											p.sendMessage("§7That Plot is full! (§d" + players.size() + "§7/§d" + plot.getPvPMaxPlayers() + "§7)");
										}
									}
									else{
										p.sendMessage("§7That Plot is in §d§lBuild Mode§7!");
									}
								}catch(NumberFormatException ex){
									p.sendMessage("§7Invalid §dPlot ID§7.");
								}
							}
							else{
								p.sendMessage("§7Invalid Usage. (§d/p join <plot-id>§7)");
							}
						}
						else{
							p.sendMessage("§7You already are on a §c§lPvP Plot§7! Leave with §d/p leave§7.");
						}
					}
					else if(a[1].equalsIgnoreCase("leave")){
						if(cp.isInPvPPlot()){
							omp.resetCooldown(Cooldown.TELEPORTING);
							p.sendMessage("§7Leaving §dPlot§7...");
						}
						else{
							p.sendMessage("§7You're not on a §c§lPvP Plot§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("clear")){
						if(cp.hasPlot()){
							if(cp.getPlot().canReset()){
								cp.getPlot().reset();
							}
							else{
								p.sendMessage("§7You may only clear your §dPlot§7 once every §d15 minutes§7.");
							}
						}
						else{
							p.sendMessage("§7You don't have a §dPlot§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("setuppvp")){
						if(omp.hasPerms(VIPRank.Emerald_VIP)){
							if(cp.hasPlot()){
								if(cp.getPlot().getPlotType() == PlotType.NORMAL){
									new PlotSetupInv().open(p);
								}
								else{
									p.sendMessage("§7Your §dPlot§7 has to be in §d§lBuild Mode§7!");
								}
							}
							else{
								p.sendMessage("§7You don't have a §dPlot§7!");
							}
						}
						else{
							omp.requiredVIPRank(VIPRank.Emerald_VIP);
						}
					}
					else if(a[1].equalsIgnoreCase("info")){
						if(cp.hasPlot()){
							new PlotInfoInv().open(p);
						}
						else{
							p.sendMessage("§7You don't have a §dPlot§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("add")){
						if(cp.hasPlot()){
							if(a.length == 3){
								Player p2 = Utils.getPlayer(a[2]);
								
								if(p2 != null){
									if(p2 != p){
										Plot plot = cp.getPlot();
		
										if(!plot.getMemberUUIDs().contains(p2.getUniqueId())){
											p.sendMessage("§d" + p2.getName() + "§7 can now access your plot!");
											p2.sendMessage("§7You can now access §d" + p.getName() + "'s Plot§7!");
											p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											p2.playSound(p2.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											
											plot.addMemberUUID(p2.getUniqueId());
										}
										else{
											p.sendMessage("§7Player §d" + a[2] +" §7is already added to your §dPlot§7!");
										}
									}
									else{
										p.sendMessage("§7You cannot add yourself to your own plot!");
									}
								}
								else{
									p.sendMessage("§7Player §d" + a[2] +" §7isn't §aOnline§7!");
								}
							}
							else{
								p.sendMessage("§7Invalid Usage. (§d/p add <player>§7)");
							}
						}
						else{
							p.sendMessage("§7You don't have a §dPlot§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("remove")){
						if(cp.hasPlot()){
							if(a.length == 3){
								if(!a[2].equals(p.getName())){
									Plot plot = cp.getPlot();
									UUID uuid = null;
									Player p2 = Utils.getPlayer(a[2]);
									if(p2 != null){
										uuid = p2.getUniqueId();
									}
									else{
										uuid = Utils.getUUID(a[2]);
									}
									
									if(uuid != null && plot.getMemberUUIDs().contains(uuid)){
										plot.removeMemberUUID(uuid);
										
										if(p2 != null){
											p2.sendMessage("§7You can no longer access §d" + p.getName() + "'s Plot§7!");
											p2.playSound(p2.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
										}
										
										p.sendMessage("§d" + a[2] + "§7 can no longer access your §dPlot§7!");
										p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									}
									else{
										p.sendMessage("§7Player §d" + a[2] +" §7hasn't been added to your §dPlot§7!");
									}
								}
								else{
									p.sendMessage("§7You cannot remove yourself from your own plot!");
								}
							}
							else{
								p.sendMessage("§7Invalid Usage. (§d/p remove <player>§7)");
							}
						}
						else{
							p.sendMessage("§7You don't have a §dPlot§7!");
						}
					}
					else if(a[1].equalsIgnoreCase("tp") || a[1].equalsIgnoreCase("teleport")){
						if(a.length == 3){
							UUID uuid = null;
							Player p2 = Utils.getPlayer(a[2]);
							if(p2 != null){
								uuid = p2.getUniqueId();
							}
							else{
								uuid = Utils.getUUID(a[2]);
							}
							
							if(uuid != null){
								Plot plot = Plot.getPlot(uuid);
								if(plot != null){
									p.teleport(plot.getHomeLocation());
									Title t = new Title("", "§7Teleported to §d" + a[2] + " Plot§7.");
									t.send(p);
								}
								else{
									p.sendMessage("§d" + a[2] + "§7 doesn't have a §dPlot§7!");
								}
							}
							else{
								p.sendMessage("§d" + a[2] +" §7doesn't have a §dPlot§7!");
							}
						}
						else{
							p.sendMessage("§7Invalid Usage. (§d/p tp <player>§7)");
						}
					}
					else{
						p.sendMessage("§lHelp Menu:");
						p.sendMessage("§d/plot home | h §7§o(Teleport to your Plot)");
						p.sendMessage("§d/plot sethome §7§o(Set your Plot Home)");
						p.sendMessage("§d/plot help §7§o(Show this Menu)");
						p.sendMessage("§d/plot add <player> §7§o(Add a Player)");
						p.sendMessage("§d/plot remove <player> §7§o(Remove a Player)");
						p.sendMessage("§d/plot tp | teleport <player> §7§o(Teleport to a Plot)");
						p.sendMessage("§d/plot clear §7§o(Clear your Plot)");
						p.sendMessage("§d/plot info §7§o(Show Plot Info)");
						p.sendMessage("§d/plot setuppvp §7§o(Setup PvP Mode)");
						p.sendMessage("§d/plot pvpbroadcast §7§o(Broadcast Plot in PvP Mode)");
					}
				}
				else{
					p.sendMessage("§lHelp Menu:");
					p.sendMessage("§d/plot home | h §7§o(Teleport to your Plot)");
					p.sendMessage("§d/plot sethome §7§o(Set your Plot Home)");
					p.sendMessage("§d/plot help §7§o(Show this Menu)");
					p.sendMessage("§d/plot add <player> §7§o(Add a Player)");
					p.sendMessage("§d/plot remove <player> §7§o(Remove a Player)");
					p.sendMessage("§d/plot tp | teleport <player> §7§o(Teleport to a Plot)");
					p.sendMessage("§d/plot clear §7§o(Clear your Plot)");
					p.sendMessage("§d/plot info §7§o(Show Plot Info)");
					p.sendMessage("§d/plot setuppvp §7§o(Setup PvP Mode)");
					p.sendMessage("§d/plot pvpbroadcast §7§o(Broadcast Plot in PvP Mode)");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchKit(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(ServerData.isServer(Server.KITPVP)){
				KitPvPPlayer kp = omp.getKitPvPPlayer();
				
				if(a.length > 1 && omp.hasPerms(StaffRank.Owner)){
					if(a.length == 3){
						try{
							KitPvPKit kitpvpkit = KitPvPKit.valueOf(a[1].toUpperCase());
							
							try{
								int level = Integer.parseInt(a[2]);
								
								if(level > 0 && level <= kitpvpkit.getHighestLevel()){
									Kit kit = kitpvpkit.getKit(level);
									
									kit.setItems(p);
									p.sendMessage("§7Selected Kit: '§b§l" + kitpvpkit.getName() + "§7' §7§o(§a§oLvL " + level + "§7§o)");
								}
								else{
									p.sendMessage("§7Kit '§b§l" + kitpvpkit.getName() +"§7' doesn't have the §a§lLevel " + level + "§7!");
								}
							}catch(Exception ex){
								p.sendMessage("§6" + a[2] + " §7isn't a number!");
							}
						}catch(IllegalArgumentException ex){
							p.sendMessage("§6" + a[1] + " §7isn't a Kit!");
						}
					}
					else{
						p.sendMessage("§7Use §6/kit <kit> <level>§7.");
					}
				}
				else{
	    			if(kp.getKitSelected() == null){
	    				if(kp.isPlayer()){
	    					new KitSelectorInv().open(p);
	    				}
	    				else{
	    					p.sendMessage("§7You can't use §6/kit§7 while §espectating§7!");
	    				}
	    			}
	    			else{
	    				p.sendMessage("§7You can't use §6/kit§7 while playing!");
	    			}
				}
			}
			else if(ServerData.isServer(Server.SKYBLOCK)){
				SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
				new KitInv().open(sbp);
			}
			else if(ServerData.isServer(Server.PRISON)){
				if(a.length == 2){
					if(a[1].equalsIgnoreCase("starter")){
						if(!omp.onCooldown(Cooldown.STARTER_KIT)){
							Kit.getKit("Starter").addItems(p);
							p.sendMessage("§7You've been given the §9Starter Kit§7.");
							
							omp.resetCooldown(Cooldown.STARTER_KIT);
						}
						else{
							p.sendMessage("§7You can only use this Kit once every §65 hours§7.");
						}
					}
					else{
						p.sendMessage("§7Unknown Kit.");
					}
				}
				else{
					p.sendMessage("§7Use §6/kit <kit>§7.");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchHeal(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();

			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		
		    		if(p2 != null){
		    			if(p2 == p){
		    				p.setHealth(20);
		    				p.sendMessage("§7Restored your §6Healthbar§7!");
		    			}
		    			else{
		    				p.sendMessage("§7Restored " + omp2.getName() + "'s §6Healthbar§7!");
		    				p2.sendMessage("§7" + omp.getName() + "§7 restored your §6Healthbar§7!");
		    				p2.setHealth(20);
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
				else{
		    		p.setHealth(20);
		    		p.sendMessage("§7Restored your §6Healthbar§7!");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}

		private void dispatchSilent(OMPlayer omp, String[] a){
			if(omp.hasPerms(StaffRank.Moderator)){
				omp.setSilentMode(!omp.isSilentMode());
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchChatColors(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new ChatColorInv().open(p);
		}
		
		private void dispatchDisguises(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new DisguiseInv().open(p);
		}
		
		private void dispatchFireworks(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new FireworkInv().open(p);
		}
		
		private void dispatchGadgets(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new GadgetInv().open(p);
		}
		
		private void dispatchHats(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new HatInv().open(p);
		}
		
		private void dispatchPets(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new PetInv().open(p);
		}
		
		private void dispatchTrails(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new TrailInv().open(p);
		}
		
		private void dispatchWardrobe(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new WardrobeInv().open(p);
		}
		
		private void dispatchAFK(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(omp.hasPerms(VIPRank.Iron_VIP)){
				if(omp.isAFK()){
					omp.noLongerAFK();
	    		}
	    		else{
		    		if(a.length == 1){
		    			omp.nowAFK(null);
		    		}
		    		else if(a.length == 2){
			    		if(omp.hasPerms(VIPRank.Diamond_VIP)){
				    		if(a[1].length() <= 20){
				    			String afkmessage = a[1];
				    			if(omp.hasPerms(VIPRank.Emerald_VIP)){
					    			afkmessage = a[1].replaceAll("&a", "§a").replaceAll("&b", "§b").replaceAll("&c", "§c").replaceAll("&d", "§d").replaceAll("&e", "§e").replaceAll("&f", "§f").replaceAll("&0", "§0").replaceAll("&1", "§1").replaceAll("&2", "§2").replaceAll("&3", "§3").replaceAll("&4", "§4").replaceAll("&5", "§5").replaceAll("&6", "§6").replaceAll("&7", "§7").replaceAll("&8", "§8").replaceAll("&9", "§9");
				    			}
				    			omp.nowAFK(afkmessage);
				    		}
				    		else{
				    			p.sendMessage("§7Your §6afk text§7 can't be longer than §620 characters§7!");
				    		}
			    		}
			    		else{
			    			p.sendMessage("§7You have to be a §9§lDiamond VIP§7 to use §6" + a[0].toLowerCase() + " <reason>§7.");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§7Invalid Usage. (§6/afk §7or §6/afk <reason>§7)");
			    	}
	    		}
			}
			else{
    			p.sendMessage("§7You have to be an §7§lIron VIP§7 to use §6" + a[0].toLowerCase() + "§7.");
			}
		}
		
		private void dispatchBuilder(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(ServerData.isServer(Server.HUB) && omp.hasPerms(StaffRank.Builder)){
	    		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " BuilderWorld");
	    		p.sendMessage("§7Teleported to the §d§lBuilder World§7.");
	    		Title t = new Title("", "§d§lBuilder World");
	    		t.send(p);
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		@SuppressWarnings("deprecation")
		private void dispatchDisguise(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();

			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		if(a[1].equalsIgnoreCase("block")){
		    			p.sendMessage("§7Invalid Usage. (§6/disguise block <id>§7)");
		    		}
		    		else{
			    		try{
			    			EntityType type = EntityType.valueOf(a[1].toUpperCase());
			    			omp.disguiseAsMob(type, false, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
			    			p.sendMessage("§7Disguised as: §6" + a[1].toUpperCase() + "§7.");
			    		}
			    		catch(IllegalArgumentException ex){
			    			p.sendMessage("§7Invalid Disguise.");
			    		}
		    		}
		    	}
		    	else if(a.length == 3){
		    		if(a[1].equalsIgnoreCase("block")){
		    			try{
		    				int id = Integer.parseInt(a[2]);
		    				omp.disguiseAsBlock(id, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
		    				p.sendMessage("§7Disguised as: §6" + Material.getMaterial(id).toString() + "§7.");
		    			}
		    			catch(IllegalArgumentException ex){
		    				p.sendMessage("§6" + a[2] + "§7 isn't a number.");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Invalid Disguise.");
		    		}
		    	}
		    	else if(a.length == 4){
		    		if(a[1].equalsIgnoreCase("player")){
		    			Player p2 = Utils.getPlayer(a[2]);
		    			OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    			
		    			if(p2 != null){
		    				try{
				    			EntityType type = EntityType.valueOf(a[3].toUpperCase());
				    			omp2.disguiseAsMob(type, false, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
				    			p.sendMessage("§7Disguised " + omp2.getName() + " §7as: §6" + a[3].toUpperCase() + "§7.");
				    			p2.sendMessage("§7Disguised as: §6" + a[3].toUpperCase() + "§7.");
				    		}
				    		catch(IllegalArgumentException ex){
				    			p.sendMessage("§7Invalid Disguise.");
				    		}
		    			}
		    			else{
		    				p.sendMessage("§7Player §6" + a[2] + " §7isn't §aOnline§7!");
		    			}
		    		}
		    		else if(a[1].equalsIgnoreCase("near")){
		    			try{
		    				int radius = Integer.parseInt(a[2]);
		    				
		    				try{
				    			EntityType type = EntityType.valueOf(a[3].toUpperCase());
				    			int amount = 1;
				    			
				    			for(Entity en : p.getNearbyEntities(radius, radius, radius)){
				    				if(en instanceof Player){
				    					amount++;
				    					Player player = (Player) en;
				    					OMPlayer omplayer = OMPlayer.getOMPlayer(player);
						    			omplayer.disguiseAsMob(type, false, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
				    					player.sendMessage("§7Disguised as: §6" + a[3].toUpperCase() + "§7.");
				    				}
				    			}

				    			omp.disguiseAsMob(type, false, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
				    			p.sendMessage("§7Disguised near players (§6" + amount + "§7) §7as: §6" + a[3].toUpperCase() + "§7.");
				    			p.sendMessage("§7Disguised as: §6" + a[3].toUpperCase() + "§7.");
				    			
				    		}
				    		catch(IllegalArgumentException ex){
				    			p.sendMessage("§7Invalid Disguise.");
				    		}
		    			}
		    			catch(NumberFormatException ex){
			    			p.sendMessage("§7Invalid Radius.");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Invalid Disguise.");
		    		}
		    	}
		    	else if(a.length == 5){
		    		if(a[1].equalsIgnoreCase("player")){
		    			Player p2 = Utils.getPlayer(a[2]);
		    			OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    			
		    			if(p2 != null){
		    				if(a[3].equalsIgnoreCase("block")){
				    			try{
				    				int id = Integer.parseInt(a[4]);

				    				omp2.disguiseAsBlock(id, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
				    				p.sendMessage("§7Disguised " + omp2.getName() + " §7as: §6Block§7. (§6" + Material.getMaterial(id).toString() + "§7)");
				    				p2.sendMessage("§7Disguised as: §aBlock§7. (§6" + Material.getMaterial(id).toString() + "§7)");
				    			}
				    			catch(NumberFormatException ex){
					    			p.sendMessage("§7Invalid ID.");
				    			}
				    		}
				    		else{
				    			p.sendMessage("§7Invalid Disguise.");
				    		}
		    			}
		    			else{
		    				p.sendMessage("§7Player §6" + a[2] + " §7isn't §aOnline§7!");
		    			}
		    		}
		    		else if(a[1].equalsIgnoreCase("near")){
		    			try{
		    				int radius = Integer.parseInt(a[2]);
		    				
		    				if(a[3].equalsIgnoreCase("block")){
			    				try{
			    					int id = Integer.parseInt(a[4]);
					    			
					    			int amount = 1;
					    			
					    			for(Entity en : p.getNearbyEntities(radius, radius, radius)){
					    				if(en instanceof Player){
					    					amount++;
					    					Player player = (Player) en;
					    					OMPlayer omplayer = OMPlayer.getOMPlayer(player);
					    					omplayer.disguiseAsBlock(id, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
					    					player.sendMessage("§7Disguised as: §aBlock§7. (§a" + Material.getMaterial(id).toString() + "§7)");
					    				}
					    			}

			    					omp.disguiseAsBlock(id, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]));
					    			p.sendMessage("§7Disguised near players (§a" + amount + "§7) §7as: §aBlock§7. (§a" + Material.getMaterial(id).toString() + "§7)");
					    			p.sendMessage("§7Disguised as: §aBlock§7. (§a" + Material.getMaterial(id).toString() + "§7)");
					    
					    		}
					    		catch(NumberFormatException ex){
					    			p.sendMessage("§7Invalid ID.");
					    		}
		    				}
		    				else{
				    			p.sendMessage("§7Invalid Disguise.");
		    				}
		    			}
		    			catch(NumberFormatException ex){
			    			p.sendMessage("§7Invalid Radius.");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Invalid Disguise.");
		    		}
		    	}
		    	else{
		    		p.sendMessage("§7§lMobs");
		    		p.sendMessage(" §6/d (player | <player>) <mob>§7): ");
		    		p.sendMessage(" §7§lAvailable§7: §6Armor_Stand§7, §6Bat§7, §6Blaze§7, §6Cave_Spider§7, §6Chicken§7, §6Cow§7, §6Creeper§7, §6Enderman§7, §6Enderman§7, §6Endermite§7, §6Ender_Dragon§7, §6Ghast§7, §6Giant§7, §6Guardian§7, §6Horse§7, §6Iron_Golem§7, §6Magma_Cube§7, §6Mushroom_Cow§7, §6Ocelot§7, §6Pig§7, §6Pig_Zombie§7, §6Rabbit§7, §6Sheep§7, §6Silverfish§7, §6Skeleton§7, §6Slime§7, §6Snowman§7, §6Spider§7, §6Squid§7, §6Villager§7, §6Witch§7, §6Wither§7, §6Wolf§7, §6Zombie");
		    		p.sendMessage("§7§lBlocks");
		    		p.sendMessage(" §6/d (player | <player>) block <id>");
		    		p.sendMessage("§7§lDisguise near to Mob");
		    		p.sendMessage(" §6/d near <radius> <mob>");
		    		p.sendMessage("§7§lDisguise near to Block");
		    		p.sendMessage(" §6/d near <radius> block <id>");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchFeed(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();

			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		
		    		if(p2 != null){
		    			if(p2 == p){
		    				p.setFoodLevel(20);
		    				p.sendMessage("§7Restored your §6Hungerbar§7!");
		    			}
		    			else{
		    				p.sendMessage("§7Restored " + omp2.getName() + "'s §6Hungerbar§7!");
		    				p2.sendMessage("§7" + omp.getName() + "§7 restored your §6Hungerbar§7!");
		    				p2.setFoodLevel(20);
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
				else{
		    		p.setFoodLevel(20);
		    		p.sendMessage("§7Restored your §6Hungerbar§7!");
		    	}
			}
			else if(ServerData.isServer(Server.PRISON) && omp.hasPerms(VIPRank.Gold_VIP)){
	    		p.setFoodLevel(20);
	    		p.sendMessage("§7Restored your §6Hungerbar§7!");
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}

		private void dispatchFly(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Moderator) || ServerData.isServer(Server.SURVIVAL, Server.PRISON) && omp.hasPerms(VIPRank.Diamond_VIP) || ServerData.isServer(Server.SKYBLOCK) && omp.hasPerms(VIPRank.Emerald_VIP)){
				if(a.length == 2 && omp.hasPerms(StaffRank.Moderator)){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		
		    		if(p2 != null){
		    			if(p2 == p){
				    		p.setAllowFlight(!p.getAllowFlight());
				    		p.setFlying(p.getAllowFlight());
				    		p.sendMessage(Utils.statusString(p.getAllowFlight()) + " §7your §fFly§7 mode!");
		    			}
		    			else{
				    		p2.setAllowFlight(!p2.getAllowFlight());
				    		p2.setFlying(p2.getAllowFlight());
				    		p.sendMessage(Utils.statusString(p2.getAllowFlight()) + " " + omp2.getName() + "'s §fFly§7 mode!");
				    		p2.sendMessage("§7" + omp.getName() + " " + Utils.statusString(p2.getAllowFlight()) + " §7your §fFly§7 mode!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else{
		    		p.setAllowFlight(!p.getAllowFlight());
		    		p.setFlying(p.getAllowFlight());
		    		p.sendMessage(Utils.statusString(p.getAllowFlight()) + " §7your §fFly§7 mode!");
		    	}
			}
			else if(ServerData.isServer(Server.SURVIVAL, Server.PRISON)){
				omp.requiredVIPRank(VIPRank.Diamond_VIP);
			}
			else if(ServerData.isServer(Server.SKYBLOCK)){
				omp.requiredVIPRank(VIPRank.Emerald_VIP);
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		@SuppressWarnings("deprecation")
		private void dispatchGive(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 3 || a.length == 4){
	    			try{
	    				int amount = 64;
	    				if(a.length == 4){
	    					amount = Integer.parseInt(a[3]);
	    				}
	    				
			    		Player p2 = Utils.getPlayer(a[1]);
			    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
			    		
			    		if(p2 != null){
			    			if(a[2].contains(":")){
			    				String[] itemstrings = a[2].split("\\:");
			    				
			    				try{
			    					int durability = Integer.parseInt(itemstrings[1]);
			    					
			    					try{
				    					int id = Integer.parseInt(itemstrings[0]);
				    					
				    					if(p2 == p){
				    						try{
					    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
					    						item.setDurability((short) durability);
					    						p.getInventory().addItem(item);
					    						p.updateInventory();
					    						
							    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    						}catch(IllegalArgumentException ex){
				    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
				    						}
				    					}
				    					else{
				    						try{
					    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
					    						item.setDurability((short) durability);
					    						p2.getInventory().addItem(item);
					    						p2.updateInventory();
					    						
							    				p.sendMessage("§7You gave " + omp2.getName() + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
							    				p2.sendMessage("§7" + omp.getName() +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    						}catch(IllegalArgumentException ex){
				    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
				    						}
				    					}
				    					
				    				}catch(NumberFormatException ex){
				    					Material m = null;
				    					
				    					for(Material ma : Material.values()){
				    						if(ma.toString().equalsIgnoreCase(itemstrings[0])){
				    							m = ma;
				    						}
				    						else if(ma.toString().replace("_", "").equalsIgnoreCase(itemstrings[0])){
				    							m = ma;
				    						}
				    						else{}
				    					}
				    					
				    					if(m != null){
					    					if(p2 == p){
					    						ItemStack item = new ItemStack(m, amount);
					    						item.setDurability((short) durability);
					    						p.getInventory().addItem(item);
					    						p.updateInventory();
					    						
							    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    					}
					    					else{
					    						ItemStack item = new ItemStack(m, amount);
					    						item.setDurability((short) durability);
					    						p2.getInventory().addItem(item);
					    						p2.updateInventory();
					    						
							    				p.sendMessage("§7You gave " + omp2.getName() + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
							    				p2.sendMessage("§7" + omp.getName() +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    					}
				    					}
				    					else{
				    						p.sendMessage("§7There's no §6Item§7 with the name §6" + itemstrings[0] + "§7!");
				    					}
				    				}
			    				}
			    				catch(NumberFormatException ex){
			    					p.sendMessage("§7The Durability §6" + itemstrings[1] + "§7 isn't a number!");
			    				}
			    			}
			    			else{
			    				try{
			    					int id = Integer.parseInt(a[2]);
			    					
			    					if(p2 == p){
			    						try{
				    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
				    						p.getInventory().addItem(item);
				    						p.updateInventory();
				    						
						    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
			    						}catch(Exception ex){
			    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
			    						}
			    					}
			    					else{
			    						try{
				    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
				    						p2.getInventory().addItem(item);
				    						p2.updateInventory();
				    						
						    				p.sendMessage("§7You gave " + omp2.getName() + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
						    				p2.sendMessage("§7" + omp.getName() +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
			    						}catch(Exception ex){
			    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
			    						}
			    					}
			    					
			    				}catch(NumberFormatException ex){
			    					Material m = null;
			    					
			    					for(Material ma : Material.values()){
			    						if(ma.toString().equalsIgnoreCase(a[2])){
			    							m = ma;
			    						}
			    						else if(ma.toString().replace("_", "").equalsIgnoreCase(a[2])){
			    							m = ma;
			    						}
			    						else{}
			    					}
			    					
			    					if(m != null){
				    					if(p2 == p){
				    						ItemStack item = new ItemStack(m, amount);
				    						p.getInventory().addItem(item);
				    						p.updateInventory();
				    						
						    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    					}
				    					else{
				    						ItemStack item = new ItemStack(m, amount);
				    						p2.getInventory().addItem(item);
				    						p2.updateInventory();
				    						
						    				p.sendMessage("§7You gave " + omp2.getName() + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
						    				p2.sendMessage("§7" + omp.getName() +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    					}
			    					}
			    					else{
			    						p.sendMessage("§7There's no §6Item§7 with the name §6" + a[2] + "§7!");
			    					}
			    				}
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
			    		}
	    			}
	    			catch(NumberFormatException ex){
	    				p.sendMessage("§7The amount §6" + a[3] + "§7 isn't a number!");
	    			}
		    	}
		    	else{
			    	p.sendMessage("§7Invalid Usage. (§6" + a[0].toLowerCase() + " <player> <item | id> (amount)§7)");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchGM(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
	    			if(Utils.isGameMode(GameMode.SURVIVAL, a)){
	    				p.setGameMode(GameMode.SURVIVAL);
	    				p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
	    			}
	    			else if(Utils.isGameMode(GameMode.CREATIVE, a)){
	    				p.setGameMode(GameMode.CREATIVE);
	    				p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
	    			}
	    			else if(Utils.isGameMode(GameMode.ADVENTURE, a)){
	    				p.setGameMode(GameMode.ADVENTURE);
	    				p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
	    			}
	    			else if(Utils.isGameMode(GameMode.SPECTATOR, a)){
	    				p.setGameMode(GameMode.SPECTATOR);
	    				p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
	    			}
	    			else{
	    				p.sendMessage("§7Invalid Usage. (§6" + a[0] + " s|c|a|spec§7)");
	    			}
		    	}
		    	else if(a.length == 3){
		    		Player p2 = Utils.getPlayer(a[2]);
		    		
		    		if(p2 != null){
		    			if(p2 == p){
			    			if(Utils.isGameMode(GameMode.SURVIVAL, a)){
			    				p.setGameMode(GameMode.SURVIVAL);
			    				p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
			    			}
			    			else if(Utils.isGameMode(GameMode.CREATIVE, a)){
			    				p.setGameMode(GameMode.CREATIVE);
			    				p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
			    			}
			    			else if(Utils.isGameMode(GameMode.ADVENTURE, a)){
			    				p.setGameMode(GameMode.ADVENTURE);
			    				p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
			    			}
			    			else if(Utils.isGameMode(GameMode.SPECTATOR, a)){
			    				p.setGameMode(GameMode.SPECTATOR);
			    				p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
			    			}
			    			else{
			    				p.sendMessage("§7Invalid Usage. (§6" + a[0] + " s|c|a|spec <player>§7)");
			    			}
		    			}
		    			else{
		    				OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
			    			if(Utils.isGameMode(GameMode.SURVIVAL, a)){
			    				p2.setGameMode(GameMode.SURVIVAL);
			    				p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §a§lSurvival§7!");
			    				p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §a§lSurvival§7!");
			    			}
			    			else if(Utils.isGameMode(GameMode.CREATIVE, a)){
			    				p2.setGameMode(GameMode.CREATIVE);
			    				p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §d§lCreative§7!");
			    				p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §d§lCreative§7!");
			    			}
			    			else if(Utils.isGameMode(GameMode.ADVENTURE, a)){
			    				p2.setGameMode(GameMode.ADVENTURE);
			    				p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §2§lAdventure§7!");
			    				p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §2§lAdventure§7!");
			    			}
			    			else if(Utils.isGameMode(GameMode.SPECTATOR, a)){
			    				p2.setGameMode(GameMode.SPECTATOR);
			    				p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §e§lSpectate§7!");
			    				p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §e§lSpectate§7!");
			    			}
			    			else{
			    				p.sendMessage("§7Invalid Usage. (§6" + a[0] + " s|c|a|spec <player>§7)");
			    			}
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[2] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else{
	    			p.sendMessage("§7Invalid Usage. (§6" + a[0] + " s|c|a|spec§7)");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchGMA(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
			    		
		    		if(p2 != null){
		    			if(p2 == p){
			    			p.setGameMode(GameMode.ADVENTURE);
			    			p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
		    			}
		    			else{
			    			p2.setGameMode(GameMode.ADVENTURE);
			    			p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §2§lAdventure§7!");
			    			p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §2§lAdventure§7!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else{
		    		p.setGameMode(GameMode.ADVENTURE);
		    		p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchGMC(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
			    		
		    		if(p2 != null){
		    			if(p2 == p){
			    			p.setGameMode(GameMode.CREATIVE);
			    			p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
		    			}
		    			else{
			    			p2.setGameMode(GameMode.CREATIVE);
			    			p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §d§lCreative§7!");
			    			p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §d§lCreative§7!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else{
		    		p.setGameMode(GameMode.CREATIVE);
		    		p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchGMS(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
			    		
		    		if(p2 != null){
		    			if(p2 == p){
			    			p.setGameMode(GameMode.SURVIVAL);
			    			p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
		    			}
		    			else{
			    			p2.setGameMode(GameMode.SURVIVAL);
			    			p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §a§lSurvival§7!");
			    			p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §a§lSurvival§7!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else{
		    		p.setGameMode(GameMode.SURVIVAL);
		    		p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchGMSpec(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		
		    		if(p2 != null){
		    			if(p2 == p){
			    			p.setGameMode(GameMode.SPECTATOR);
			    			p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
		    			}
		    			else{
			    			p2.setGameMode(GameMode.SPECTATOR);
			    			p.sendMessage("§7Set " + omp2.getName() + "'s §6GameMode§7 to §e§lSpectate§7!");
			    			p2.sendMessage("§7" + omp.getName() + " §7set your §6GameMode§7 to §e§lSpectate§7!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else{
		    		p.setGameMode(GameMode.SPECTATOR);
	    			p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
		    	}
			}
			else if(omp.hasPerms(StaffRank.Moderator)){
				if(p.getGameMode() == GameMode.SPECTATOR){
					if(ServerData.isServer(Server.CREATIVE)){
			    		p.setGameMode(GameMode.CREATIVE);
		    			p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
					}
					else{
			    		p.setGameMode(GameMode.SURVIVAL);
		    			p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
					}
				}
				else{
		    		p.setGameMode(GameMode.SPECTATOR);
	    			p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchNick(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(VIPRank.Gold_VIP)){
				if(a.length == 2){
		    		if(a[1].length() <= 30){
		    			
		    			if(a[1].equalsIgnoreCase("off")){
		    				p.sendMessage("§7Removed your §6nickname§7!");
		    				omp.setNickname(null);
		    			}
		    			else{
			    			if(omp.hasPerms(VIPRank.Emerald_VIP)){
			    				String newnickname = a[1].replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d").replace("&e", "§e").replace("&f", "§f").replace("&0", "§0").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4").replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9").replace("&r", "§r").replace("&k", "§k").replace("&m", "§m").replace("&n", "§n").replace("&l", "§l");
			    				p.sendMessage("§7Changed your §6nickname§7 to '§a" + newnickname + "§7'.");
			    				omp.setNickname(newnickname);
			    			}
			    			else if(omp.hasPerms(VIPRank.Diamond_VIP)){
			    				String newnickname = a[1].replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d").replace("&e", "§e").replace("&f", "§f").replace("&0", "§0").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4").replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9");
			    				p.sendMessage("§7Changed your §6nickname§7 to '§9" + newnickname + "§7'.");
			    				omp.setNickname(newnickname);
			    			}
			    			else{
			    				p.sendMessage("§7Changed your §6nickname§7 to '§6" + a[1] + "§7'.");
			    				omp.setNickname(a[1]);
			    			}
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Your §6nickname§7 cannot be longer than §630 characters§7!");
		    		}
		    	}
		    	else{
		    		p.sendMessage("§7Invalid Usage. (§6/nick <nickname | off>§7)");
		    	}
			}
			else{
	    		p.sendMessage("§7Permission Denied. (You have to be a §6§lGold VIP§7)");
			}
		}
		
		private void dispatchOPMode(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				omp.setOpMode(!omp.isOpMode());
				p.sendMessage("§7Your §4§lOP Mode§7 is now " + Utils.statusString(omp.isOpMode()) + "§7!");
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchPerks(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			new CosmeticPerksInv().open(p);
		}
		
		private void dispatchPlugins(OMPlayer omp, String[] a){
			omp.unknownCommand(a[0]);
		}
		
		private void dispatchServers(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
		
			ServerSelectorInv.get().open(p);
		}
		
		private void dispatchSkull(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner) || ServerData.isServer(Server.HUB) && omp.hasPerms(StaffRank.Builder) && p.getWorld().getName().equals(ServerData.getHub().getBuilderWorld().getName())){
				if(a.length == 2){
		    		p.sendMessage("§7You've been given §6" + a[1] + "'s§7 skull.");

    				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
    				SkullMeta meta = (SkullMeta) item.getItemMeta();
    				meta.setDisplayName("§6" + a[1] + "'s §7Skull");
    				meta.setOwner(a[1]);
    				item.setItemMeta(meta);
    				item.setDurability((short) 3);
    				
    				p.getInventory().addItem(item);
		    	}
		    	else{
			    	p.sendMessage("§7Invalid Usage. (§6" + a[0].toLowerCase() + " <player>§7)");
		    	}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchTopVoters(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			List<StringInt> voters = ServerStorage.voters;
			
			p.sendMessage("");
			p.sendMessage("§b§lTop 5 Voters§7:");
			sendTopVoterMessage(p, "§6§l1.§6", voters.get(0).getString(), voters.get(0).getInteger());
			sendTopVoterMessage(p, "§7§l2.§7", voters.get(1).getString(), voters.get(1).getInteger());
			sendTopVoterMessage(p, "§c§l3.§c", voters.get(2).getString(), voters.get(2).getInteger());
			sendTopVoterMessage(p, "§8§l4.§8", voters.get(3).getString(), voters.get(3).getInteger());
			sendTopVoterMessage(p, "§8§l5.§8", voters.get(4).getString(), voters.get(4).getInteger());
		}
		
		private void sendTopVoterMessage(Player p, String placement, String player, int votes){
			if(votes == 1){
				p.sendMessage("  " + placement + " " + player + " §7| §b" + votes + " Vote");
			}
			else{
				if(player == null){
					p.sendMessage("  " + placement + " ");
				}
				else{
					p.sendMessage("  " + placement + " " + player + " §7| §b" + votes + " Votes");
				}
			}
		}
		
		private void dispatchTeleport(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Moderator)){
				if(a.length == 2){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		
		    		if(p2 != null){
		    			if(p2 != p){
				    		p.teleport(p2);
				    		p.sendMessage("§7Teleported to " + omp2.getName() + "§7!");
		    			}
		    			else{
		    				p.sendMessage("§7You can't §6teleport§7 to yourself!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
				else if(a.length == 3){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		Player p3 = Utils.getPlayer(a[2]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		OMPlayer omp3 = OMPlayer.getOMPlayer(p3);
		    		
		    		if(p2 != null){
		    			if(p3 != null){
					    	p2.teleport(p3);
					    	p.sendMessage("§7Teleported " + omp2.getName() + "§7 to " + omp3.getName() + "§7!");
		    			}
		    			else{
		    				p.sendMessage("§7Player §6" + a[2] + " §7isn't §aOnline§7!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
		    	else if(a.length == 5){
		    		Player p2 = Utils.getPlayer(a[1]);
		    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
		    		
		    		if(p2 != null){
		    			try{
			    			int x = Integer.parseInt(a[2]);
			    			int y = Integer.parseInt(a[3]);
			    			int z = Integer.parseInt(a[4]);
			    			
			    			Location l = new Location(p2.getWorld(), x, y, z, p2.getLocation().getYaw(), p2.getLocation().getPitch());
			    			
					    	p2.teleport(l);
					    	
					    	if(p2 != p){
					    		p.sendMessage("§7Teleported " + omp2.getName() + "§7 to §6" + x + "§7, §6" + y + "§7, §6" + z + "§7!");
					    	}
					    	else{
					    		p.sendMessage("§7Teleported to §6" + x + "§7, §6" + y + "§7, §6" + z + "§7!");
					    	}
					    }catch(NumberFormatException ex){
		    				p.sendMessage("§7The given coordinates aren't numbers!");
		    			}
		    		}
		    		else{
		    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
		    		}
		    	}
	    		else{
			    	p.sendMessage("§7Invalid Usage. §7(§6" + a[0].toLowerCase() + " <player | player1> (player2 | x) (y) (z)");
	    		}
			}
			else if(ServerData.isServer(Server.SURVIVAL)){
				if(omp.hasPerms(VIPRank.Gold_VIP)){
					if(a.length == 2){
			    		Player p2 = Utils.getPlayer(a[1]);
			    		
			    		if(p2 != null){
				    		if(p2 != p){
					    		OMPlayer omp2 = OMPlayer.getOMPlayer(p2);
					    		SurvivalPlayer sp2 = omp2.getSurvivalPlayer();
					    		
					    		sp2.setTPHereRequest(null);
			    				sp2.setTPRequest(omp.getSurvivalPlayer());
			    				p.sendMessage("§7Teleport request sent to §6" + omp2.getName() + "§7!");
			    				p2.sendMessage(omp.getName() + "§7 wants to teleport to you. Type §a/accept§7 to accept.");
			    			}
			    			else{
			    				p.sendMessage("§7You can't §6teleport§7 to yourself!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + a[1] + " §7isn't §aOnline§7!");
			    		}
			    	}
		    		else{
				    	p.sendMessage("§7Use §6/tp <player>§7.");
		    		}
				}
				else{
					omp.requiredVIPRank(VIPRank.Gold_VIP);
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchUndisguise(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Owner)){
				if(omp.isDisguised()){
					omp.undisguise();
					p.sendMessage("§7You are no longer §6disguised§7.");
				}
				else{
					p.sendMessage("§7You aren't §6disguised§7!");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchUUID(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();
			
			if(omp.hasPerms(StaffRank.Moderator)){
				if(a.length == 2){
					UUID uuid = Utils.getUUID(a[1]);

					if(uuid != null){
						p.sendMessage("");
						p.sendMessage("§7Loading §6" + a[1] + "'s §7UUID info...");
						
						ComponentMessage cm = new ComponentMessage();
						cm.addPart(" §7UUID: ", null, null, null, null);
						cm.addPart("§6" + uuid.toString(), ClickEvent.Action.SUGGEST_COMMAND, uuid.toString(), Action.SHOW_TEXT, "§7Copy §6UUID§7.");
						cm.addPart("§7.", null, null, null, null);
						cm.send(p);
						
						p.sendMessage(" §7Name History:");
						HashMap<String, String> names = Utils.getNames(uuid);
						for(String name : names.keySet()){
							if(names.get(name) != null){
								p.sendMessage("  §6" + name + " " + names.get(name));
							}
							else{
								p.sendMessage("  §6" + name);
							}
						}
					}
					else{
						if(a[1].length() > 16){
							uuid = java.util.UUID.fromString(a[1]);
							
							if(uuid != null){
								p.sendMessage("");
								p.sendMessage("§7Loading §6" + a[1] + "§7 info...");
								
								ComponentMessage cm = new ComponentMessage();
								cm.addPart(" §7UUID: ", null, null, null, null);
								cm.addPart("§6" + uuid.toString(), ClickEvent.Action.SUGGEST_COMMAND, uuid.toString(), Action.SHOW_TEXT, "§7Copy §6UUID§7.");
								cm.addPart("§7.", null, null, null, null);
								cm.send(p);
								
								p.sendMessage(" §7Name History:");
								HashMap<String, String> names = Utils.getNames(uuid);
								for(String name : names.keySet()){
									if(names.get(name) != null){
										p.sendMessage("  §6" + name + " " + names.get(name));
									}
									else{
										p.sendMessage("  §6" + name);
									}
								}
							}
							else{
								p.sendMessage("§7Invalid UUID. (§6" + a[0].toLowerCase() + " <player>§7)");
							}
						}
						else{
							p.sendMessage("§7Invalid Player. (§6" + a[0].toLowerCase() + " <player>§7)");
						}
					}
				}
				else{
					p.sendMessage("§7Invalid Usage. (§6" + a[0].toLowerCase() + " <player | uuid>§7)");
				}
			}
			else{
				omp.unknownCommand(a[0]);
			}
		}
		
		private void dispatchVote(OMPlayer omp, String[] a){
			Player p = omp.getPlayer();

			p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
			p.sendMessage("");
			p.sendMessage("§b§lVote §8| §7Vote for §b§lRewards§7!");
			p.sendMessage("§b§lVote §8| §7Reward in the " + ServerData.getServer().getName() + "§7 Server:");
			p.sendMessage("§b§lVote §8| §7");
			for(String s : ServerData.getServer().getVoteRewardsMessages()){
				p.sendMessage("§b§lVote §8| §7  - " + s);
			}
			p.sendMessage("§b§lVote §8| §7");
			p.sendMessage("§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
			p.sendMessage("§b§lVote §8| §7Your total Votes this Month: §b§l" + omp.getVotes());
		}
		
		public static List<String> getCommands(){
			List<String> commands = new ArrayList<String>();
			for(Command command : values()){
				commands.add(command.getName());
			}
			return commands;
		}
		public static List<String> getCommandNames(){
			List<String> commands = new ArrayList<String>();
			for(Command command : values()){
				commands.add(command.getName().substring(1));
			}
			return commands;
		}
		
		public static boolean isCommand(String cmd){
			for(Command command : values()){
				if(command.getName().equalsIgnoreCase(cmd)){
					return true;
				}
			}
			return false;
		}
	}
}
