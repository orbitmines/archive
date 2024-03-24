package me.O_o_Fadi_o_O.OrbitMines.runnables;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.OrbitMines.managers.VoteManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.Hologram;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.ConfirmInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.ServerSelectorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.TeleporterInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.WardrobeInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPC;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPCArmorStand;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Particle;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.CreativeServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.HubServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.KitPvPServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.PrisonServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SkyBlockServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SurvivalServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.StringInt;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.NPCType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.ReflectionUtil;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Trail;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.TrailType;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Plot;
import me.O_o_Fadi_o_O.OrbitMines.utils.hub.MGArena;
import me.O_o_Fadi_o_O.OrbitMines.utils.hub.MindCraftPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.ActiveBooster;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPMap;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.KitPvPKit;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Lumberjack;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Mine;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.MineType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Shop;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Island;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockUtils;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.ShopSign;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;
import net.minecraft.server.v1_8_R3.EnumParticle;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Snowman;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class Runnables {

	public void start(Plugin plugin){
		if(ServerData.isServer(Server.SURVIVAL, Server.PRISON)){
			toBuySign();
		}
		
		new DatabaseRunnable().runTaskAsynchronously(plugin);
		if(ServerData.isServer(Server.HUB, Server.SKYBLOCK, Server.MINIGAMES, Server.PRISON)){
			new MindCraftNPCRunnable().runTaskTimer(plugin, 0, 10);
		}
		new NPCRunnable().runTaskTimer(plugin, 0, 100);
		new VoteRunnable().runTaskTimer(plugin, 100, 72000);
		new PlayerRunnable().runTaskTimer(plugin, 0, 20);
		new ScoreboardRunnable().runTaskTimer(plugin, 0, 5);
		new SGARunnable().runTaskTimer(plugin, 0, 3);
		new EntityRunnable().runTaskTimer(plugin, 40, 1);
		
		if(ServerData.isServer(Server.SKYBLOCK)){
			new NetherSkyBlockRunnable().runTaskTimer(plugin, 40, 2400);
		}
		else if(ServerData.isServer(Server.PRISON)){
			new PrisonShopsRunnable().runTaskTimer(plugin, 40, 1200);
		}
		else{}
	}
	
	public class DatabaseRunnable extends BukkitRunnable {
		
		@Override
		public void run(){//Asynchronously
			Database.get().openConnection();
		}
	}
	
	public class NetherSkyBlockRunnable extends BukkitRunnable {
		@Override
		public void run(){//40, 300
			for(Island is : ServerData.getSkyBlock().getIslands()){
				if(is.isNetherGenerated()){
					Location l = is.getNetherLocation();
					
					if(new Random().nextBoolean()){
						List<Block> blocks = Utils.getBlocksBetween(new Location(l.getWorld(), l.getX() -4, l.getY() +8, l.getZ() -3), new Location(l.getWorld(), l.getX() -37, l.getY() +8, l.getZ() +33));
						List<Block> newblocks = new ArrayList<Block>();
						
						for(Block b : blocks){
							if(b != null && b.getType() != Material.AIR){
								Block b2 = b.getRelative(BlockFace.UP);
							
								if(b2 != null && b2.getType() == Material.AIR){
									newblocks.add(b2);
								}
							}
						}
						
						if(newblocks.size() > 0){
							Block b = newblocks.get(new Random().nextInt(newblocks.size()));
							
							Skeleton s = (Skeleton) b.getWorld().spawnEntity(b.getLocation(), EntityType.SKELETON);
							s.setSkeletonType(SkeletonType.WITHER);
							
							int amount = 0;
							for(Entity en : s.getNearbyEntities(15, 15, 15)){
								if(en instanceof Skeleton){
									amount++;
								}
							}
							
							if(amount > 2){
								s.remove();
							}
						}
					}
				}
			}
		}
	}
	
	public class PrisonShopsRunnable extends BukkitRunnable {
		@Override
		public void run(){//40, 1200
			for(Shop shop : ServerData.getPrison().getShops()){
				if(!shop.canRent() && shop.expired()){
					shop.expire();
				}
			}
		}
	}
	
	public class MindCraftNPCRunnable extends BukkitRunnable {
		
		@SuppressWarnings("deprecation")
		@Override
		public void run(){//0, 10
			if(ServerData.isServer(Server.HUB)){
				NPC npc = NPC.getNPC(NPCType.MINDCRAFT);
				
				if(npc != null){
				    ItemStack i = ((LivingEntity) npc.getEntity()).getEquipment().getItemInHand();
				    i.setDurability((short) (int) Arrays.asList(1, 3, 4, 5, 11, 14).get(new Random().nextInt(6)));
				    ((LivingEntity) npc.getEntity()).getEquipment().setItemInHand(i);
				}
			}
			else if(ServerData.isServer(Server.PRISON)){
				for(Lumberjack lj : ServerData.getPrison().getLumberjacks()){
					if(!lj.isWorking()){
						List<Block> takenblocks = lj.getTakenBlocks();
						
						if(takenblocks.size() > 0){
							lj.setWorking(true);
							lj.setWorkingOn(takenblocks.get(0));
							
							lj.getNPC().setItemInHand(new ItemStack(Material.LOG));
							lj.getToRemove().setType(Material.AIR);
						}
					}
					else{
						if(lj.getWorkingOn() != null){
							if(lj.getNPC().getEntity().getLocation().distance(lj.getWorkingOn().getLocation()) <= 1.75){
								lj.getNPC().setItemInHand(new ItemStack(Material.AIR));
								lj.getToRemove().setType(Material.LOG);
								
								lj.getWorkingOn().setType(Material.LOG);
								lj.getWorkingOn().setData((byte) 4);
								lj.getWorkingOn().getWorld().playEffect(lj.getWorkingOn().getLocation(), Effect.STEP_SOUND, 17);
								
								lj.setWorkingOn(null);
							}
						}
						else{
							lj.getNPC().setItemInHand(new ItemStack(Material.IRON_AXE));
							
							if(lj.getNPC().getEntity().getLocation().distance(lj.getLocation()) <= 1.25){
								lj.setWorking(false);
							}
						}
					}
				}
			}
			else{
				for(Player p : Bukkit.getOnlinePlayers()){
					OMPlayer omp = OMPlayer.getOMPlayer(p);
					
					if(omp.isLoaded()){
						if(ServerData.isServer(Server.SKYBLOCK)){
							SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
							
							if(sbp.hasIsland() && p.getWorld().getName().equals(ServerData.getSkyBlock().getSkyblockWorld().getName()) && sbp.onOwnIsland(p.getLocation(), false)){
								if(p.getLocation().getBlock().getType() == Material.PORTAL){
									if(!omp.getCooldowns().containsKey(Cooldown.NETHER_TELEPORTING)){
										omp.resetCooldown(Cooldown.NETHER_TELEPORTING);
									}
									
									if(!omp.onCooldown(Cooldown.NETHER_TELEPORTING)){
										omp.removeCooldown(Cooldown.NETHER_TELEPORTING);
										
										Island is = sbp.getIsland();
										if(is.isNetherGenerated()){
											p.teleport(is.getNetherHomeLocation());
										}
										else{
											SkyBlockUtils.generateNetherIsland(is.getNetherLocation());
											is.setNetherGenerated(true);
											p.teleport(is.getNetherHomeLocation());
										}
									}
								}
								else{
									if(omp.onCooldown(Cooldown.NETHER_TELEPORTING)){
										omp.removeCooldown(Cooldown.NETHER_TELEPORTING);
									}
								}
							}
						}
						else if(ServerData.isServer(Server.MINIGAMES)){
							Arena arena = omp.getArena();
							
							if(arena != null){
								if(arena.isPlayer(omp)){
									p.setGameMode(GameMode.SURVIVAL);
									
									switch(arena.getType()){
										case CHICKEN_FIGHT:
											if(arena.getState() == GameState.IN_GAME){
												if(p.getInventory().contains(Material.COMPASS)){
													omp.updateTracker(arena.getPlayers());
												}
											}
											break;
										case GHOST_ATTACK:
											break;
										case SKYWARS:
											if(arena.getState() == GameState.WARMUP){
												TicketType cage = omp.getSWPlayer().getCage();
												if(cage != null){
													if(cage == TicketType.GRAY_RAINBOW_CAGE){
														for(Block b : omp.getSWPlayer().getCageBlocks()){
															if(b.getType() == Material.STAINED_GLASS){
																b.setData(Arrays.asList((byte) 0, (byte) 7, (byte) 8, (byte) 15).get(new Random().nextInt(4)));
															}
														}
													}
													else if(cage == TicketType.THE_WOOL_HUT_CAGE){
														for(Block b : omp.getSWPlayer().getCageBlocks()){
															if(b.getType() == Material.WOOL){
																b.setData(Arrays.asList((byte) 2, (byte) 3, (byte) 4, (byte) 11, (byte) 14).get(new Random().nextInt(4)));
															}
														}
													}
													else{}
												}
											}
											else if(arena.getState() == GameState.IN_GAME){
												if(p.getInventory().contains(Material.COMPASS)){
													omp.updateTracker(arena.getPlayers());
												}
											}
											else{}
											break;
										case SPLATCRAFT:
											break;
										case SPLEEF:
											break;
										case SURVIVAL_GAMES:
											if(arena.getState() == GameState.WARMUP){
												Location l = arena.getMap().getPlayerSpawns().get(omp);
												
												if(p.getLocation().distance(l) >= 1.3){
													p.teleport(l);
													p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1F, 0.1F);
													
													Title t = new Title("", "§7Stay on your platform!", 0, 30, 0);
													t.send(p);
												}
											}
											else if(arena.getState() == GameState.IN_GAME){
												if(p.getInventory().contains(Material.COMPASS)){
													omp.updateTracker(arena.getPlayers());
												}
												omp.getSGPlayer().updateLeatherColor();
											}
											else{}
											break;
										case ULTRA_HARD_CORE:
											if(arena.getState() == GameState.WARMUP){
												Location l = arena.getMap().getPlayerSpawns().get(omp);
												
												if(l != null){
													if(p.getLocation().distance(l) >= 1.3){
														p.teleport(l);
														p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1F, 0.1F);
														
														Title t = new Title("", "§7Stay on your platform!", 0, 30, 0);
														t.send(p);
													}
												}
												else{
													if(p.getLocation().distance(arena.getMap().getSpectatorLocation()) >= 25){
														p.teleport(arena.getMap().getSpectatorLocation());
													}
												}
											}
											break;
									}
								}
								else{
									p.setGameMode(GameMode.SPECTATOR);
									Kit.getKit("Spectator").setItems(p);
								}
							}
						}
						else{}
					}
				}
			}
		}
	}
	
	public class NPCRunnable extends BukkitRunnable	{
		
		@Override
		public void run(){//0, 100
			for(NPCArmorStand npc : NPCArmorStand.getNPCArmorStands()){
				ArmorStand as = npc.getArmorStand();
				
				if(npc.getNPCType() == NPCType.TOP_DONATOR){
					ItemStack item = as.getHelmet();
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					String lastdonatorstring = ServerData.getHub().getLastDonatorString();
					
					if(lastdonatorstring == null){
						meta.setOwner(null);
						item.setDurability((short) 0); 
					}
					else{
						item.setDurability((short) 3); 
						meta.setOwner(lastdonatorstring);
						as.setCustomName("§7Recent Donator: §6§l" + lastdonatorstring);
						as.setCustomNameVisible(true);
					}
					item.setItemMeta(meta);
					as.setHelmet(item);
				}
				else if(npc.getNPCType() == NPCType.SERVER_INFO_CREATIVE){
					Server.CREATIVE.updateNPC(as);
				}
				else if(npc.getNPCType() == NPCType.SERVER_INFO_KITPVP){
					Server.KITPVP.updateNPC(as);
				}
				else if(npc.getNPCType() == NPCType.SERVER_INFO_MINIGAMES){
					Server.MINIGAMES.updateNPC(as);
				}
				else if(npc.getNPCType() == NPCType.SERVER_INFO_PRISON){
					Server.PRISON.updateNPC(as);
				}
				else if(npc.getNPCType() == NPCType.SERVER_INFO_SKYBLOCK){
					Server.SKYBLOCK.updateNPC(as);
				}
				else if(npc.getNPCType() == NPCType.SERVER_INFO_SURVIVAL){
					Server.SURVIVAL.updateNPC(as);
				}
				else if(npc.getNPCType() == NPCType.MASTERIES){
					if(npc.getItem() != null){
						ItemStack item = npc.getItem().getItemStack();
						if(item.getType() == Material.DIAMOND_SWORD){
							item.setType(Material.IRON_CHESTPLATE);
						}
						else if(item.getType() == Material.IRON_CHESTPLATE){
							item.setType(Material.BOW);
						}
						else if(item.getType() == Material.BOW){
							item.setType(Material.ARROW);
						}
						else if(item.getType() == Material.ARROW){
							item.setType(Material.DIAMOND_SWORD);
						}
						else{
							item.setType(Material.DIAMOND_SWORD);
						}
						npc.getItem().setItemStack(item);
					}
				}
				else{}
			}
		}
	}
	
	public class VoteRunnable extends BukkitRunnable {
		
		@Override
		public void run(){//100, 72000
			
			if(ServerData.isServer(Server.KITPVP)){
				KitPvPServer kitpvp = ServerData.getKitPvP();
				
		        if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
		        	kitpvp.setFreeKitEnabled(true);
		        }
		        else{
		        	kitpvp.setFreeKitEnabled(false);
		        }
			}
			
			HashMap<String, Integer> uuidvoters = Database.get().getIntEntries("Votes", "uuid", "votes");
			List<StringInt> playervotes = new ArrayList<StringInt>();
			
			StringInt voter1 = new StringInt(null, 0);
			StringInt voter2 = new StringInt(null, 0);
			StringInt voter3 = new StringInt(null, 0);
			StringInt voter4 = new StringInt(null, 0);
			StringInt voter5 = new StringInt(null, 0);
			
			for(String uuid : uuidvoters.keySet()){
				int votes = uuidvoters.get(uuid);
				if(votes >= voter1.getInteger()){
					voter5 = voter4;
					voter4 = voter3;
					voter3 = voter2;
					voter2 = voter1;
					voter1 = new StringInt(uuid, votes);
				}
				else if(votes >= voter2.getInteger()){
					voter5 = voter4;
					voter4 = voter3;
					voter3 = voter2;
					voter2 = new StringInt(uuid, votes);
				}
				else if(votes >= voter3.getInteger()){
					voter5 = voter4;
					voter4 = voter3;
					voter3 = new StringInt(uuid, votes);
				}
				else if(votes >= voter4.getInteger()){
					voter5 = voter4;
					voter4 = new StringInt(uuid, votes);
				}
				else if(votes >= voter5.getInteger()){
					voter5 = new StringInt(uuid, votes);
				}else{}
			}

			playervotes = Arrays.asList(voter1, voter2, voter3, voter4, voter5);
			
			for(StringInt voter : playervotes){
				if(voter.getString() != null){
					String playername = Utils.getName(UUID.fromString(voter.getString()));
					
					if(playername != null){
						voter.setString(playername);
					}
				}
			}
			
			ServerStorage.voters = playervotes;
			
			if(ServerData.isServer(Server.SURVIVAL)){
				HashMap<String, Integer> uuidmoney = Database.get().getIntEntries("Survival-Money", "uuid", "money");
				ServerData.getSurvival().setTopMoney(getTopTen(uuidmoney));
			}
			else if(ServerData.isServer(Server.PRISON)){
				HashMap<String, Integer> uuidgold = Database.get().getIntEntries("Prison-Gold", "uuid", "gold");
				ServerData.getPrison().setTopGold(getTopTen(uuidgold));
			}
			else{}
		}
		
		private List<StringInt> getTopTen(HashMap<String, Integer> uuidmoney){
			List<StringInt> playermoney = new ArrayList<StringInt>();
			
			StringInt player1 = new StringInt(null, 0);
			StringInt player2 = new StringInt(null, 0);
			StringInt player3 = new StringInt(null, 0);
			StringInt player4 = new StringInt(null, 0);
			StringInt player5 = new StringInt(null, 0);
			StringInt player6 = new StringInt(null, 0);
			StringInt player7 = new StringInt(null, 0);
			StringInt player8 = new StringInt(null, 0);
			StringInt player9 = new StringInt(null, 0);
			StringInt player10 = new StringInt(null, 0);
			
			for(String uuid : uuidmoney.keySet()){
				int votes = uuidmoney.get(uuid);
				if(votes >= player1.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = player6;
					player6 = player5;
					player5 = player4;
					player4 = player3;
					player3 = player2;
					player2 = player1;
					player1 = new StringInt(uuid, votes);
				}
				else if(votes >= player2.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = player6;
					player6 = player5;
					player5 = player4;
					player4 = player3;
					player3 = player2;
					player2 = new StringInt(uuid, votes);
				}
				else if(votes >= player3.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = player6;
					player6 = player5;
					player5 = player4;
					player4 = player3;
					player3 = new StringInt(uuid, votes);
				}
				else if(votes >= player4.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = player6;
					player6 = player5;
					player5 = player4;
					player4 = new StringInt(uuid, votes);
				}
				else if(votes >= player5.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = player6;
					player6 = player5;
					player5 = new StringInt(uuid, votes);
				}
				else if(votes >= player6.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = player6;
					player6 = new StringInt(uuid, votes);
				}
				else if(votes >= player7.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = player7;
					player7 = new StringInt(uuid, votes);
				}
				else if(votes >= player8.getInteger()){
					player10 = player9;
					player9 = player8;
					player8 = new StringInt(uuid, votes);
				}
				else if(votes >= player9.getInteger()){
					player10 = player9;
					player9 = new StringInt(uuid, votes);
				}
				else if(votes >= player10.getInteger()){
					player10 = new StringInt(uuid, votes);
				}
				else{}
			}

			playermoney = Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);
			
			for(StringInt player : playermoney){
				if(player.getString() != null){
					String playername = Utils.getName(UUID.fromString(player.getString()));
					
					if(playername != null){
						player.setString(playername);
					}
				}
			}
			
			return playermoney;
		}
	}
	
	public class PlayerRunnable extends BukkitRunnable {
		
		@SuppressWarnings("deprecation")
		@Override
		public void run(){//0, 20
			for(Server server : Server.values()){
				ByteArrayOutputStream b = new ByteArrayOutputStream();
				DataOutputStream out = new DataOutputStream(b);
		    
				try{
					out.writeUTF("PlayerCount");
				  	out.writeUTF(server.toString().toLowerCase());
				}catch (IOException e){
					e.printStackTrace();
				}
	
				Bukkit.getServer().sendPluginMessage(Start.getInstance(), "BungeeCord", b.toByteArray());
			}

			ServerSelectorInv.get().update();
			new VoteManager().updateTop();
			
			if(ServerData.isServer(Server.HUB)){
				HashMap<MiniGameType, Location> mgsigns = ServerData.getHub().getMGSigns();
				HashMap<MiniGameType, List<MGArena>> arenas = new HashMap<MiniGameType, List<MGArena>>();
				
				for(MGArena arena : ServerData.getHub().getMGArenas()){
					if(!arenas.containsKey(arena.getType())){
						arenas.put(arena.getType(), new ArrayList<MGArena>());
					}
					arenas.get(arena.getType()).add(arena);
					
					if(arena.getState() == GameState.ENDING || arena.getState() == GameState.RESTARTING){
						arena.setSecondsRestarting(arena.getSecondsRestarting() +1);
						
						if(arena.getSecondsRestarting() == 15){
							arena.setSecondsRestarting(0);
							arena.setLastResponse(0);
							arena.setPlayers(0);
							arena.setState(GameState.WAITING);
							arena.setMinutes(0);
							arena.setSeconds(0);
						}
					}
					else{
						arena.setLastResponse(arena.getLastResponse() +1);
						
						if(arena.getState() != GameState.CLOSED && arena.getLastResponse() == 3){
							arena.setLastResponse(0);
							arena.setPlayers(0);
							arena.setState(GameState.WAITING);
							arena.setMinutes(0);
							arena.setSeconds(0);
						}
					}
					
					arena.updateSign();
				}
				
				for(MiniGameType type : arenas.keySet()){
					Location l = mgsigns.get(type);
					int lobbies = 0;
					int players = 0;
					
					for(MGArena arena : arenas.get(type)){
						if(arena.getState() != GameState.CLOSED){
							lobbies++;
						}
						players += arena.getPlayers();
					}
					
					String[] lines = new String[4];
					lines[0] = "§l" + type.getName();
					lines[1] = "";
					lines[2] = "Lobbies: " + lobbies;
					lines[3] = "Players: " + players;
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getWorld().getName().equals(l.getWorld().getName()) && p.getLocation().distance(l) <= 16){
							p.sendSignChange(l, lines);
						}
					}
				}
			}
			else if(ServerData.isServer(Server.KITPVP)){
				KitPvPServer kitpvp = ServerData.getKitPvP();
				KitPvPMap map = kitpvp.getCurrentMap();
				map.tickTimer();
				
				if(map.getSeconds() <= 10 && map.getSeconds() != 0 && map.getMinutes() == 0){
					Bukkit.broadcastMessage("§7Switching Maps in §6§l" + map.getSeconds() + "§7...");
					
					for(Player p : Bukkit.getOnlinePlayers()){
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
				}
				if(map.getSeconds() == 0 && map.getMinutes() == 0){
					kitpvp.setNextMap();
					
					for(Player p : Bukkit.getOnlinePlayers()){
						OMPlayer omp = OMPlayer.getOMPlayer(p);
						KitPvPPlayer kp = omp.getKitPvPPlayer();
						
						if(kp.isSpectator() || kp.getKitSelected() != null){
							kp.teleportToMap();
						}
						p.sendMessage("§7§lMaps Switched!");
					}
				}
				
				ActiveBooster booster = kitpvp.getBooster();
				if(booster != null){
					booster.tickTimer();
					
					if(booster.getSeconds() == 0){
						if(booster.getMinutes() != 0){
							Bukkit.broadcastMessage("§a" + booster.getPlayer() + "'s Booster§7 (§ax" + booster.getBooster().getMultiplier() +"§7) remains for §a" + booster.getMinutes() + "m " + booster.getSeconds() + "s§7.");
						}
						else{
							Bukkit.broadcastMessage("§a" + booster.getPlayer() + "'s Booster§7 (§ax" + booster.getBooster().getMultiplier() +"§7) has been expired.");
							kitpvp.setBooster(null);
						}
					}
				}
			}
			else if(ServerData.isServer(Server.CREATIVE)){
				CreativeServer creative = ServerData.getCreative();
				
				byte data = (byte) new Random().nextInt(16);
				for(Block b : creative.getBeacons()){
					b.setData(data);
				}
			}
			else if(ServerData.isServer(Server.SURVIVAL, Server.PRISON)){
				if(ShopSign.getShopSigns().size() > 0){
					for(ShopSign sign : ShopSign.getShopSigns()){
						sign.update();
					}
				}
				
				if(ServerData.isServer(Server.PRISON)){
					for(Mine mine : Mine.getMines()){
						if(mine.getType() == MineType.NORMAL){
							mine.tickTimer();
							mine.updateTimer();
							mine.updateSigns();
							
							if(mine.getMinutes() == 0 && mine.getSeconds() == 0){
								mine.reset(null);
							}
						}
					}
					
					for(Shop shop : ServerData.getPrison().getShops()){
						shop.updateSign();
					}
				}
			}
			else if(ServerData.isServer(Server.MINIGAMES)){
				for(final Arena arena : ServerData.getMiniGames().getArenas()){
					arena.sendData();
					arena.checkNPCs();
					
					if(arena.getState() == GameState.WAITING && arena.getPlayers().size() >= 3 || arena.getState() != GameState.WAITING && arena.getState() != GameState.RESTARTING){
						arena.tickTimer();
					}
					
					if(arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING){
						if(arena.getPlayers().size() < 3){
							if(arena.getMinutes() == 0 && arena.getSeconds() <= 30){
								arena.setSeconds(30);
							}
						}
						
						if(arena.getMinutes() == 0){
							if(arena.getSeconds() == 0){
								switch(arena.getType()){
									case CHICKEN_FIGHT:
										arena.getCF().warmup();
										break;
									case GHOST_ATTACK:
										break;
									case SKYWARS:
										arena.getSW().warmup();
										break;
									case SPLATCRAFT:
										break;
									case SPLEEF:
										break;
									case SURVIVAL_GAMES:
										arena.getSG().warmup();
										break;
									case ULTRA_HARD_CORE:
										arena.getUHC().warmup();
										break;
								}
							}
							else if(arena.getSeconds() <= 10){
								if(arena.getSeconds() == 10){
									arena.starting();
								}
								
								arena.playSound(Sound.SUCCESSFUL_HIT, 5, 1);
								arena.sendMessage("§fStarting in §6" + arena.getSeconds() + "§f...");
							}
							else{}
						}
					}
					else if(arena.getState() == GameState.WARMUP){
						int totalseconds = 30 + arena.getPlayers().size() * 5;
						int seconds = totalseconds % 60;
						int minutes = 0;
						
						if(totalseconds != seconds){
							minutes = (totalseconds - seconds) / 60;
						}
						
						if(arena.getMinutes() == 0 && arena.getSeconds() == 0){
							switch(arena.getType()){
								case CHICKEN_FIGHT:
									arena.getCF().start();
									break;
								case GHOST_ATTACK:
									break;
								case SKYWARS:
									arena.getSW().start();
									break;
								case SPLATCRAFT:
									break;
								case SPLEEF:
									break;
								case SURVIVAL_GAMES:
									arena.getSG().start();
									break;
								case ULTRA_HARD_CORE:
									arena.getUHC().start();
									break;
							}
						}
						else if(arena.getMinutes() == 0 && arena.getSeconds() <= 10){
							if(arena.getType() == MiniGameType.SURVIVAL_GAMES || arena.getType() == MiniGameType.SKYWARS){
								arena.getMap().getWorld().strikeLightningEffect(arena.getMap().getSpectatorLocation());
							}
							
							arena.updateWarmup();
						}
						else if(arena.getType() == MiniGameType.ULTRA_HARD_CORE && arena.getMinutes() * 60 + arena.getSeconds() <= (minutes * 60 + seconds) -15 && arena.getSeconds() % 5 == 0){
							boolean found = false;
							for(OMPlayer omp : arena.getPlayers()){
								if(!found && !arena.getMap().getPlayerSpawns().containsKey(omp)){
									found = true;
									arena.getUHC().teleportToArena(omp);
								}
							}
						}
						else{}
					}
					else if(arena.getState() == GameState.IN_GAME){
						if(arena.getPlayers().size() <= 1){
							switch(arena.getType()){
								case CHICKEN_FIGHT:
									arena.getCF().ending();
									break;
								case GHOST_ATTACK:
									break;
								case SKYWARS:
									arena.getSW().ending();
									break;
								case SPLATCRAFT:
									break;
								case SPLEEF:
									break;
								case SURVIVAL_GAMES:
									arena.getSG().ending();
									break;
								case ULTRA_HARD_CORE:
									arena.getUHC().ending();
									break;
							}
						}
						
						if(arena.getType() == MiniGameType.SURVIVAL_GAMES && arena.getMinutes() == 10 && arena.getSeconds() == 0){
							arena.getSG().restockChests();
						}
						else if(arena.getType() == MiniGameType.ULTRA_HARD_CORE){
							if(arena.getUHC().isInPvP()){
								if(arena.getUHC().getBorder() > 100D){
									arena.getUHC().tickBorder();
								}
							}
							
							if(arena.getSeconds() == 0){
								if(arena.getMinutes() != 0 && arena.getMinutes() % 4 == 0){
									for(OMPlayer omp : arena.getPlayers()){
										if(omp.getUHCPlayer().getKit() != null && omp.getUHCPlayer().getKit().getKitName().equals(TicketType.APPLETREE_KIT.getKit().getKitName())){
											String type = TicketType.APPLETREE_KIT.getRarity().getColor() + TicketType.APPLETREE_KIT.getName();
											omp.getPlayer().getInventory().addItem(Utils.setLore(new ItemStack(Material.APPLE), Arrays.asList(type)));
											omp.getPlayer().playSound(omp.getPlayer().getLocation(), Sound.ITEM_PICKUP, 5, 1);
										}
									}
								}
								
								if(arena.getMinutes() == 25 || arena.getMinutes() == 20 || arena.getMinutes() == 16){
									arena.playSound(Sound.CLICK, 5, 1);
									arena.sendMessage("§cPvP§7 enabled in §6" + (arena.getMinutes() -15) + "m " + arena.getSeconds() + "s§7.");
								}
								else if(arena.getMinutes() == 15){
									arena.getUHC().pvp();
								}
								else if(arena.getMinutes() == 10 || arena.getMinutes() == 5 || arena.getMinutes() == 2 || arena.getMinutes() == 1){
									arena.playSound(Sound.CLICK, 5, 1);
									arena.sendMessage("§7Game ending in §6" + arena.getMinutes() + "m " + arena.getSeconds() + "s§7.");
								}
								else{}
							}
						}
						else if(arena.getType() == MiniGameType.CHICKEN_FIGHT){
							for(OMPlayer omp : arena.getPlayers()){
						    	if(!arena.isSpectator(omp) && omp.getCFPlayer().getKit().getKitName().equals(TicketType.CHICKEN_KIT.toString())){
						    		arena.getCF().setChickenBlock(omp);
						    	}
						    	
						    	OMPlayer ompD = arena.getCF().getChickenBlockPlayer(omp.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN));
						    	if(ompD != null && omp != ompD && !arena.isSpectator(ompD) && !omp.onCooldown(Cooldown.WOOL_TRAIL)){
						    		omp.getPlayer().damage(Arrays.asList(0.5D, 1D).get(new Random().nextInt(2)), ompD.getCFPlayer().getNameHologram().getArmorstands().get(0));
						    		omp.addPotionEffect(PotionEffectType.SLOW, 60, 2);
						    		
						    		omp.resetCooldown(Cooldown.WOOL_TRAIL);
						    	}
							}
						}
						else{}
						
						if(arena.getMinutes() == 0 && arena.getSeconds() == 0){
							switch(arena.getType()){
								case CHICKEN_FIGHT:
									arena.getCF().ending();
									break;
								case GHOST_ATTACK:
									break;
								case SKYWARS:
									arena.getSW().ending();
									break;
								case SPLATCRAFT:
									break;
								case SPLEEF:
									break;
								case SURVIVAL_GAMES:
									if(!arena.getSG().isInDeathMatch()){
										arena.getSG().deathmatch();
									}
									else{
										arena.getSG().ending();
									}
									break;
								case ULTRA_HARD_CORE:
									if(!arena.getUHC().isInPvP()){
										arena.getUHC().pvp();
									}
									else{
										arena.getUHC().ending();
									}
									break;
							}
						}
						else if(arena.getMinutes() == 1 && arena.getSeconds() == 0 || arena.getMinutes() == 0 && (arena.getSeconds() == 30 || arena.getSeconds() <= 10)){
							if(arena.getType() == MiniGameType.SURVIVAL_GAMES){
								arena.playSound(Sound.CLICK, 5, 1);
								if(!arena.getSG().isInDeathMatch()){
									arena.sendMessage("§c§lDeathmatch starting in §f§l" + arena.getMinutes() + "m " + arena.getSeconds() + "s§c§l!");
								}
								else{
									arena.sendMessage("§c§lDeathmatch ending in §f§l" + arena.getMinutes() + "m " + arena.getSeconds() + "s§c§l!");
								}
							}
							else{
								
							}
						}
						else{}
					}
					else if(arena.getState() == GameState.ENDING){
						if(arena.getSeconds() == 10){
							switch(arena.getType()){
								case CHICKEN_FIGHT:
									arena.getCF().rewardPlayers();
									break;
								case GHOST_ATTACK:
									break;
								case SKYWARS:
									arena.getSW().rewardPlayers();
									break;
								case SPLATCRAFT:
									break;
								case SPLEEF:
									break;
								case SURVIVAL_GAMES:
									arena.getSG().rewardPlayers();
									break;
								case ULTRA_HARD_CORE:
									arena.getUHC().rewardPlayers();
									break;
							}
						}
						else if(arena.getSeconds() == 0){
							for(OMPlayer omp : arena.getAllPlayers()){
								arena.leave(omp);
							}
							
							new BukkitRunnable(){
								public void run(){
									switch(arena.getType()){
										case CHICKEN_FIGHT:
											arena.getCF().restart();
											break;
										case GHOST_ATTACK:
											break;
										case SKYWARS:
											arena.getSW().restart();
											break;
										case SPLATCRAFT:
											break;
										case SPLEEF:
											break;
										case SURVIVAL_GAMES:
											arena.getSG().restart();
											break;
										case ULTRA_HARD_CORE:
											arena.getUHC().restart();
											break;
									}
								}
							}.runTaskLater(Start.getInstance(), 500);
						}
						else if(arena.getSeconds() <= 5){
							arena.playSound(Sound.CLICK, 5, 1);
							arena.sendMessage("§7Restarting arena in §6" + arena.getSeconds() + "§7...");
						}
						else{}
					}
					else{}
				}
			}
			else{}
			
			for(NPC npc : NPC.getNPCs()){
				if(npc.getMoveLocations().size() > 0){
					if(npc.getMovingTo() != null){
						if(npc.isAtLocation(npc.getMovingTo())){
							int index = npc.getMovingToIndex();
							npc.setSecondsToStay(npc.getSecondsToStay() -1);
							
							if(npc.getSecondsToStay() == 0){
								npc.setMovingTo(npc.getNextMoveLocation());
								npc.setSecondsToStay(npc.getSecondsToStay(npc.getMovingTo()));
								
								if(npc.getSecondsToStay() == 0){
									npc.setMovingTo(npc.getNextMoveLocation());
									npc.setSecondsToStay(npc.getSecondsToStay(npc.getMovingTo()));
								}
							}
							else{
								int seconds = npc.getSecondsToStay();
								World w = ServerData.getLobbyWorld();
								
								if(npc.getNPCType() == NPCType.CLAIM_TUTORIAL){
									if(index == 0){
										if(seconds == 9){
											npc.setItemInHand(null);
											
											w.getBlockAt(new Location(w, -53, 78, -7)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -53, 78, -8)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -52, 78, -8)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -53, 78, -11)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -53, 78, -14)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -53, 78, -15)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -52, 78, -15)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -49, 78, -15)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -46, 78, -15)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -45, 78, -15)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -45, 78, -14)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -45, 78, -14)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -45, 78, -11)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -45, 78, -8)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -45, 78, -7)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -46, 78, -7)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -46, 78, -7)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -49, 78, -7)).setType(Material.GRASS);
											w.getBlockAt(new Location(w, -52, 78, -7)).setType(Material.GRASS);
										}
										else if(seconds == 5){
											final Hologram h = new Hologram(new Location(w, -48.5, 79.25, -3.5));
											h.addLine("§7Take a Stone Hoe in your hand");
											h.create();
											
											new BukkitRunnable(){
												public void run(){
													h.delete();
												}
											}.runTaskLater(Start.getInstance(), 120);
											
											npc.setItemInHand(new ItemStack(Material.STONE_HOE));
										}
										else{}
									}
									else if(index == 1){
										if(seconds == 5){
											final Hologram h = new Hologram(new Location(w, -53.5, 79.25, -5.5));
											h.addLine("§6Right Click§7 at the corner of your property");
											h.create();
											
											final Hologram h2 = new Hologram(new Location(w, -52.5, 77, -6.5));
											h2.addLine("§bRight Click");
											h2.create();
											
											new BukkitRunnable(){
												public void run(){
													h.delete();
													h2.delete();
												}
											}.runTaskLater(Start.getInstance(), 120);
											
											w.getBlockAt(new Location(w, -53, 78, -7)).setType(Material.SOIL);
										}
									}
									else if(index == 3){
										if(seconds == 5){
											final Hologram h = new Hologram(new Location(w, -43.5, 79.25, -15.5));
											h.addLine("§6Right Click§7 at the opposite corner of your property");
											h.create();
											
											final Hologram h2 = new Hologram(new Location(w, -44.5, 77, -14.5));
											h2.addLine("§bRight Click");
											h2.create();
											
											new BukkitRunnable(){
												public void run(){
													h.delete();
													h2.delete();
												}
											}.runTaskLater(Start.getInstance(), 120);
											
											w.getBlockAt(new Location(w, -53, 78, -7)).setType(Material.GLOWSTONE);
											w.getBlockAt(new Location(w, -53, 78, -8)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -52, 78, -8)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -53, 78, -11)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -53, 78, -14)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -53, 78, -15)).setType(Material.GLOWSTONE);
											w.getBlockAt(new Location(w, -52, 78, -15)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -49, 78, -15)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -46, 78, -15)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -45, 78, -15)).setType(Material.GLOWSTONE);
											w.getBlockAt(new Location(w, -45, 78, -14)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -45, 78, -14)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -45, 78, -11)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -45, 78, -8)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -45, 78, -7)).setType(Material.GLOWSTONE);
											w.getBlockAt(new Location(w, -46, 78, -7)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -46, 78, -7)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -49, 78, -7)).setType(Material.GOLD_BLOCK);
											w.getBlockAt(new Location(w, -52, 78, -7)).setType(Material.GOLD_BLOCK);
										}
									}
									else{}
								}
							}
						}
					}
					else{
						npc.setMovingTo(npc.getNextMoveLocation());
					}
				}
			}
			
			for(Player p : Bukkit.getOnlinePlayers()){
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				omp.setScoreboard();
				omp.checkLastLocation();
				
				if(omp.isLoaded()){
					World lobby = ServerData.getLobbyWorld();
					
					if(ServerData.isServer(Server.HUB, Server.MINIGAMES, Server.CREATIVE)){
						if(omp.isWardrobeDisco()){
							omp.discoWardrobe();
						}
						if(p.getOpenInventory().getTopInventory().getName() != null){
							if(p.getOpenInventory().getTopInventory().getName().equals("§0§lWardrobe")){
								WardrobeInv.setDiscoItem(p.getOpenInventory().getTopInventory(), omp);
							}
							if(p.getOpenInventory().getTopInventory().getName().equals("§0§lConfirm your Purchase") && p.getOpenInventory().getTopInventory().getItem(13).getItemMeta().getDisplayName().endsWith("Disco Armor")){
								ConfirmInv.setDiscoItem(p.getOpenInventory().getTopInventory(), omp);
							}
						}
					}
					
					if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
						if(!ServerData.isServer(Server.MINIGAMES) || omp.getArena() != null && omp.getArena().getState() == GameState.WAITING){
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
					
						if(omp.getPet() != null){
							if(p.getVehicle() != null && p.getVehicle() == omp.getPet()){
								omp.givePetInventory();
							}
							else{
								if(!omp.isOpMode()){
									if(ServerData.isServer(Server.HUB)){
										ServerData.getHub().giveLobbyItems(omp);
									}
								}
							}
						}
						else{
							if(!omp.isOpMode()){
								if(ServerData.isServer(Server.HUB) && !p.getWorld().getName().equals(ServerData.getHub().getBuilderWorld().getName())){
									ServerData.getHub().giveLobbyItems(omp);
								}
							}
						}
						
						if(omp.getSGASeconds() != -1){
							int seconds = omp.getSGASeconds();
							omp.setSGASeconds(seconds +1);
							
							if(omp.getSGAItem() != null && omp.getSGASnowGolems() == null){
								Location l = omp.getSGAItem().getLocation();
								
								if(seconds <= 10){
									l.getWorld().playSound(l, Sound.WITHER_SPAWN, 5, 1);
									Particle pa = new Particle(EnumParticle.FLAME, l);
									pa.setSize(1, 1, 1);
									pa.setAmount(30);
									pa.send(Bukkit.getOnlinePlayers());
								}
								if(seconds == 11){
									l.getWorld().playSound(l, Sound.WITHER_DEATH, 5, 1);
									Snowman s1 = (Snowman) l.getWorld().spawnEntity(l, EntityType.SNOWMAN);
									Snowman s2 = (Snowman) l.getWorld().spawnEntity(l, EntityType.SNOWMAN);
									Snowman s3 = (Snowman) l.getWorld().spawnEntity(l, EntityType.SNOWMAN);
									
									s1.setPassenger(s2);
									s2.setPassenger(s3);
									omp.getSGAItem().remove();
									omp.setSGAItem(null);
									
									List<Entity> snowgolems = new ArrayList<Entity>();
									snowgolems.add(s1);
									snowgolems.add(s2);
									snowgolems.add(s3);
									omp.setSGASnowGolems(snowgolems);
								}
							}
						}
					}
					
					if(lobby != null){
						if(ServerData.isServer(Server.HUB)){
							HubServer hub = ServerData.getHub();
							
							if(!omp.hasPlayersEnabled()){
								for(Player player : Bukkit.getOnlinePlayers()){
									p.hidePlayer(player);
								}
							}
						
							if(!p.getWorld().getName().equals(hub.getBuilderWorld().getName()) && !omp.isOpMode()){
								if(!p.getWorld().getName().equals(lobby.getName())){
									p.teleport(hub.getSpawn());
								}
								else{
									if(p.getLocation().getY() <= 50 || p.getLocation().distance(hub.getSpawn()) >= 100){
										p.teleport(hub.getSpawn());
									}
								}
							
								for(Server server : Server.values()){
									if(hub.getServerPortals().containsKey(server)){
										for(Block b : hub.getServerPortals().get(server)){
											if(b.isEmpty()){
												if(server != Server.SURVIVAL && server != Server.SKYBLOCK){
													p.sendBlockChange(b.getLocation(), Material.PORTAL, (byte) 2);
												}
												else{
													p.sendBlockChange(b.getLocation(), Material.PORTAL, (byte) 1);
												}
											}
										}
									}
								}
							}
							
							if(omp.isInLapisParkour()){
								if(lobby.getName().equals(p.getWorld().getName())){
									if(p.getLocation().distance(hub.getLapisParkour()) > 2){
										Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -1, p.getLocation().getZ());
		
										 Material m = p.getWorld().getBlockAt(l).getType();
										
										if(m != Material.GLOWSTONE){
											if(!p.isSprinting()){
												p.teleport(hub.getLapisParkour());
												p.sendMessage("§7You can't stop sprinting!");
											}
											else if(p.isOnGround()){
												 if(m == Material.GLOWSTONE){
													if(!omp.CompletedLapisParkour()){
														 omp.setCompletedLapisParkour(true);
														 
														 p.sendMessage("§7You received §b§l250 VIP Points§7!");
														 
														 p.teleport(hub.getLapisParkour());
														 omp.setInLapisParkour(false);
														 
														 omp.addVIPPoints(250);
														 Database.get().insert("ParkourCompleted", "uuid", p.getUniqueId().toString());
														 Database.get().update("VIPPoints", "points", "" + omp.getVIPPoints(), "uuid", p.getUniqueId().toString());
													 }
													 
													 Bukkit.broadcastMessage("§6" + p.getName() + "§7 completed the §1Lapis Parkour§7!");
													 for(Player player : Bukkit.getOnlinePlayers()){
														 player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
													 }
												 }
												 else{
													 if(m != Material.LAPIS_BLOCK && m != Material.AIR){
														 p.teleport(hub.getLapisParkour());
													 }
												 }
											}
											else if(p.getLocation().getY() <= 74){
												p.teleport(hub.getLapisParkour());
											}
											else{}
										}
										else{
											if(!omp.CompletedLapisParkour()){
												 omp.setCompletedLapisParkour(true);
												 
												 p.sendMessage("§7You received §b§l250 VIP Points§7!");
												 
												 p.teleport(hub.getLapisParkour());
												 omp.setInLapisParkour(false);
	
												 omp.addVIPPoints(250);
												 Database.get().insert("ParkourCompleted", "uuid", p.getUniqueId().toString());
												 Database.get().update("VIPPoints", "points", "" + omp.getVIPPoints(), "uuid", p.getUniqueId().toString());
											 }
											 
											 Bukkit.broadcastMessage(omp.getName() + "§7 completed the §1Lapis Parkour§7!");
											 for(Player player : Bukkit.getOnlinePlayers()){
												 player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
											 }
										}
									}
								}
								else{
									 p.teleport(hub.getLapisParkour());
								}
							
								if(p.getAllowFlight() == true){
									p.setAllowFlight(false);
									p.setFlying(false);
									p.sendMessage("§f§l§oFly §c§lDISABLED");
								}
							}
							
							if(lobby.getName().equals(p.getWorld().getName())){
								Location winsign = hub.getMCWinsSign();
								if(p.getLocation().distance(winsign) < 16){
									MindCraftPlayer mcp = omp.getMCPlayer();
									String[] sign = new String[4];
									sign[0] = "";
									sign[1] = "§lWins";
									if(mcp != null){
										sign[2] = "" + mcp.getWins();
									}
									else{
										sign[2] = "Loading...";
									}
									sign[3] = "";
									p.sendSignChange(winsign, sign);
								}
								Location bestgamesign = hub.getMCBestGameSign();
								if(p.getLocation().distance(bestgamesign) < 16){
									MindCraftPlayer mcp = omp.getMCPlayer();
									String[] sign = new String[4];
									sign[0] = "";
									sign[1] = "§lBest Game";
									if(mcp != null && mcp.getBestGame() != 0){
										if(mcp.getBestGame() != 1){
											sign[2] = "" + mcp.getBestGame() + " Turns";
										}
										else{
											sign[2] = "" + mcp.getBestGame() + " Turn";
										}
									}
									else{
										sign[2] = "None";
									}
									sign[3] = "";
									p.sendSignChange(bestgamesign, sign);
								}
							}
						
							if(omp.isInMindCraft()){
								MindCraftPlayer mcp = omp.getMCPlayer();
								
								for(int i = 0; i <= 11; i++){
									List<Block> blocks = hub.getMCBlocksForTurn().get(i);
									
									List<String> blocksfromturns = mcp.getBlocksFromTurns();
									String turn = blocksfromturns.get(i);
									String[] turnblocks = turn.split("\\|");
									
									for(Block b : blocks){
										int bint = Integer.parseInt(turnblocks[blocks.indexOf(b)]);
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) bint);
									}
									
									if(i != 0 && i != 11){
										List<Block> blocks2 = hub.getMCBlocksForTurnStatus().get(i);
										
										List<String> blockstatusfromturns = mcp.getStatusFromTurns();
										String status = blockstatusfromturns.get(i);
										String[] statusblocks = status.split("\\|");
										
										for(Block b : blocks2){
											int data = Integer.parseInt(statusblocks[blocks2.indexOf(b)]);
											
											p.sendBlockChange(b.getLocation(), Material.STAINED_GLASS, (byte) data);
										}
									}
								}
							}
							else{
								for(int i = 0; i <= 11; i++){
									List<Block> blocks = hub.getMCBlocksForTurn().get(i);
									
									for(Block b : blocks){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 0);
									}
									
									if(i != 0 && i != 11){
										List<Block> blocks2 = hub.getMCBlocksForTurnStatus().get(i);
										for(Block b : blocks2){
											p.sendBlockChange(b.getLocation(), Material.STAINED_GLASS, (byte) 0);
										}
									}
								}
							}
						}
						else if(ServerData.isServer(Server.KITPVP)){
							KitPvPServer kitpvp = ServerData.getKitPvP();
							KitPvPPlayer kp = omp.getKitPvPPlayer();
							
							if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals(new TeleporterInv().getInventory().getName())){
								TeleporterInv.update(p, p.getOpenInventory().getTopInventory());
							}

							if(!p.getWorld().getName().equals(lobby.getName())){
								if(!omp.isOpMode() && kp.getKitSelected() == null && kp.isPlayer()){
									p.teleport(kitpvp.getSpawn());
								}
							}
							else{
								if(p.getLocation().getY() <= 50 || p.getLocation().distance(kitpvp.getSpawn()) >= 50){
									p.teleport(kitpvp.getSpawn());
								}
							}
							
							if(kp.isSpectator()){
								p.setGameMode(GameMode.CREATIVE);
								omp.hide();
								
								if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("§0§lKit Selector")){
									p.closeInventory();
								}
							}
							else{
								omp.show();
								
								KitPvPKit kit = kp.getKitSelected();
								if(kit != null && kit.getNextArrow() != 0){
									int arrows = 0;
									int bows = 0;
									for(ItemStack i : p.getInventory().getContents()){
										if(i != null){
											if(i.getType() == Material.ARROW){
												arrows++;
											}
											if(i.getType() == Material.BOW){
												bows++;
											}
										}
									}
									
									if(arrows != kit.getMaxArrows(kp.getKitLevelSelected()) && bows > 0){
										
										if(kp.getArrowSeconds() == -1){
											kp.setArrowSeconds(kit.getNextArrow());
										}
										
										kp.tickArrowTimer();
										if(kp.getArrowSeconds() == 0){
											p.getInventory().addItem(Utils.setDisplayname(new ItemStack(Material.ARROW, 1), "§b§l" + kit.getName() + " §a§lLvL " + kp.getKitLevelSelected() + "§8 || §bArrow"));
											
											kp.setArrowSeconds(kit.getNextArrow());
										}
									}
								}
								
								if(!omp.isOpMode()){
									p.setGameMode(GameMode.SURVIVAL);
								}
							}
						}
						else if(ServerData.isServer(Server.CREATIVE)){
							CreativeServer creative = ServerData.getCreative();
							CreativePlayer cp = omp.getCreativePlayer();
							
							if(p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
								if(p.getLocation().getY() <= 50 || p.getLocation().distance(creative.getSpawn()) >= 50 && !omp.isOpMode()){
									p.teleport(creative.getSpawn());
								}
							}
							
							if(omp.getCooldowns().containsKey(Cooldown.TELEPORTING)){
								if(omp.onCooldown(Cooldown.TELEPORTING)){
									int seconds = (int) ((Cooldown.TELEPORTING.getCooldown(omp) /1000) - ((System.currentTimeMillis() - omp.getCooldown(Cooldown.TELEPORTING)) / 1000));
									
									if(cp.getPvPPlot() != null){
										Title t = new Title("", "§7Leaving §dPlot§7 in §d" + seconds + "§7...", 0, 40, 0);
										t.send(p);
									}
									else{
										Title t = new Title("", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
										t.send(p);
									}
								}
								else{
									omp.removeCooldown(Cooldown.TELEPORTING);
									p.teleport(creative.getSpawn());
									
									if(cp.getPvPPlot() != null){
										Title t = new Title("", "§7Left the §dPlot§7!", 0, 40, 20);
										t.send(p);
								
										List<CreativePlayer> cplayers = Plot.getPvPPlayers(cp.getPvPPlot());
										for(CreativePlayer cplayer : cplayers){
											cplayer.getPlayer().playSound(cplayer.getPlayer().getLocation(), Sound.CLICK, 5, 1);
											cplayer.getPlayer().sendMessage("§d" + p.getName() + "§7 left §dPlot #" + cp.getPvPPlot().getPlotID() + "§7. (§d" + (cplayers.size() -1) + "§7/§d" + cp.getPvPPlot().getPvPMaxPlayers() + "§7)");
										}
										
										cp.setSelectedKit(null);
										cp.setPvPPlot(null);
										omp.clearInventory();
									}
									else{
										Title t = new Title("", "§7Teleported to §6Spawn§7!", 0, 40, 20);
										t.send(p);
									}
								}
							}
							if(cp.getPvPPlot() != null){
								p.setGameMode(GameMode.SURVIVAL);
								
								if(cp.getSelectedKit() != null){
									for(Player player : Bukkit.getOnlinePlayers()){
										CreativePlayer cplayer = OMPlayer.getOMPlayer(player).getCreativePlayer();
										if(cplayer.getPvPPlot() == null || cplayer.getPvPPlot().getPlotID() != cp.getPvPPlot().getPlotID() || cplayer.getPvPPlot().getPlotID() == cp.getPvPPlot().getPlotID() && cplayer.getSelectedKit() == null){
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
						}
						else if(ServerData.isServer(Server.SURVIVAL)){
							SurvivalServer survival = ServerData.getSurvival();
							SurvivalPlayer sp = omp.getSurvivalPlayer();
							
							if(p.getWorld().getName().equals(survival.getLobbyWorld().getName())){
								if(!omp.isOpMode() && sp.isInPvP() && p.getAllowFlight() == true){
									p.setFlying(false);
									p.setAllowFlight(false);
								}
								
								if(omp.isDisguised()){
									omp.undisguise();
								}
							}
							
							if(omp.getCooldowns().containsKey(Cooldown.PVP_CONFIRM)){
								if(omp.onCooldown(Cooldown.PVP_CONFIRM)){
									int seconds = (int) ((Cooldown.PVP_CONFIRM.getCooldown(omp) /1000) - ((System.currentTimeMillis() - omp.getCooldown(Cooldown.PVP_CONFIRM)) / 1000));
									
									Title t = new Title("§7Type §a§l/confirm", "§7Time remaining: §6" + seconds + "§7.", 0, 40, 0);
									t.send(p);
								}
								else{
									omp.removeCooldown(Cooldown.PVP_CONFIRM);
									
									Title t = new Title("", "§c§lCancelled§7 PvP Teleportation.", 0, 40, 20);
									t.send(p);
								}
							}

							if(omp.getCooldowns().containsKey(Cooldown.TELEPORTING)){
								if(omp.onCooldown(Cooldown.TELEPORTING)){
									int seconds = (int) ((Cooldown.TELEPORTING.getCooldown(omp) /1000) - ((System.currentTimeMillis() - omp.getCooldown(Cooldown.TELEPORTING)) / 1000));
									
									if(sp.isHomeTeleporting()){
										Title t = new Title("", "§7Teleporting to §6" + sp.getTeleportingTo().getName() + "§7 in §6" + seconds + "§7...", 0, 40, 0);
										t.send(p);
									}
									else if(sp.isWarpTeleporting()){
										Title t = new Title("", "§7Teleporting to §3" + sp.getWarpingTo().getName() + "§7 in §3" + seconds + "§7...", 0, 40, 0);
										t.send(p);
									}
									else{
										Title t = new Title("", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
										t.send(p);
									}
								}
								else{
									omp.removeCooldown(Cooldown.TELEPORTING);
									
									if(sp.isHomeTeleporting()){
										Title t = new Title("", "§7Teleported to §6" + sp.getTeleportingTo().getName() + "§7!", 0, 40, 20);
										t.send(p);
								
										sp.getTeleportingTo().teleportInstantly();
										sp.setHomeTeleporting(false);
										sp.setTeleportingTo(null);
									}
									else if(sp.isWarpTeleporting()){
										Title t = new Title("", "§7Teleported to §3" + sp.getWarpingTo().getName() + "§7!", 0, 40, 20);
										t.send(p);
								
										sp.getWarpingTo().teleportInstantly(omp);
										sp.setWarpTeleporting(false);
										sp.setWarpingTo(null);
									}
									else{
										Title t = new Title("", "§7Teleported to §6Spawn§7!", 0, 40, 20);
										t.send(p);
										
										sp.setLastLocation(p.getLocation());
										p.teleport(survival.getSpawn());
									}
								}
							}
						}
						else if(ServerData.isServer(Server.SKYBLOCK)){
							SkyBlockServer skyblock = ServerData.getSkyBlock();
							SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
							
							if(!omp.isOpMode() && p.getWorld().getName().equals(skyblock.getLobbyWorld().getName()) && p.getLocation().distance(skyblock.getSpawn()) >= 75){
								p.teleport(skyblock.getSpawn());
							}
							
							if(omp.getCooldowns().containsKey(Cooldown.TELEPORTING)){
								if(omp.onCooldown(Cooldown.TELEPORTING)){
									int seconds = (int) ((Cooldown.TELEPORTING.getCooldown(omp) /1000) - ((System.currentTimeMillis() - omp.getCooldown(Cooldown.TELEPORTING)) / 1000));
										
									if(sbp.getTeleportingTo() != null){
										Island is = sbp.getTeleportingTo();
										
										if(sbp.getIsland().getIslandID() == is.getIslandID()){
											Title t = new Title("", "§7Teleporting to your §dIsland§7 in §d" + seconds + "§7...", 0, 40, 0);
											t.send(p);
										}
										else{
											Title t = new Title("", "§7Teleporting to §dIsland " + is.getIslandID() + "§7 in §d" + seconds + "§7...", 0, 40, 0);
											t.send(p);
										}
									}
									else{
										Title t = new Title("", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
										t.send(p);
									}
								}
								else{
									omp.removeCooldown(Cooldown.TELEPORTING);
									
									if(sbp.getTeleportingTo() != null){
										Island is = sbp.getTeleportingTo();
										
										if(sbp.getIsland().getIslandID() == is.getIslandID()){
											p.teleport(sbp.getHomeLocation());
											
											Title t = new Title("", "§7Teleported to your §dIsland§7!", 0, 40, 20);
											t.send(p);
										}
										else{
											p.teleport(is.getOwnersHomeLocation());
											
											Title t = new Title("", "§7Teleported to §dIsland " + is.getIslandID() + "§7!", 0, 40, 20);
											t.send(p);
										}
										sbp.setTeleportingTo(null);
									}
									else{
										p.teleport(skyblock.getSpawn());
										
										Title t = new Title("", "§7Teleported to §6Spawn§7!", 0, 40, 20);
										t.send(p);
									}
								}
							}
						}
						else if(ServerData.isServer(Server.PRISON)){
							PrisonServer prison = ServerData.getPrison();
							PrisonPlayer pp = omp.getPrisonPlayer();
							
							if(p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
								if(!pp.isInPvP() && (p.getLocation().getY() <= 55 || p.getLocation().distance(prison.getSpawn()) >= 100 && !omp.isOpMode())){
									p.teleport(prison.getSpawn());
								}
								
								if(pp.isInPvP() && !omp.isOpMode()){
									if(p.getAllowFlight() == true){
										p.setFlying(false);
										p.setAllowFlight(false);
									}
									
									if(omp.isDisguised()){
										omp.undisguise();
									}
								}
							}
							
							if(omp.getCooldowns().containsKey(Cooldown.TELEPORTING)){
								if(omp.onCooldown(Cooldown.TELEPORTING)){
									int seconds = (int) ((Cooldown.TELEPORTING.getCooldown(omp) /1000) - ((System.currentTimeMillis() - omp.getCooldown(Cooldown.TELEPORTING)) / 1000));
									
									Title t = new Title("", "§7Teleporting to §6Spawn§7 in §6" + seconds + "§7...", 0, 40, 0);
									t.send(p);
									
									if(omp.isDisguised()){
										omp.undisguise();
									}
								}
								else{
									omp.removeCooldown(Cooldown.TELEPORTING);
									p.teleport(prison.getSpawn());
									
									Title t = new Title("", "§7Teleported to §6Spawn§7!", 0, 40, 20);
									t.send(p);
								}
							}
						}
						else if(ServerData.isServer(Server.MINIGAMES)){
							Arena arena = omp.getArena();
							
							if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals(new TeleporterInv().getInventory().getName())){
								TeleporterInv.update(p, p.getOpenInventory().getTopInventory());
							}
							
							if(arena != null && !omp.isOpMode() && p.getWorld().getName().equals(lobby.getName())){
								Location spawn = arena.getLobby();
								
								if(p.getLocation().getY() <= 50 || p.getLocation().distance(spawn) >= 50){
									p.teleport(spawn);
								}
							}
						}
						else{}
					}
				}
			}
		}
	}
	
	public class ScoreboardRunnable extends BukkitRunnable {
		
		@Override
		public void run(){//0, 5
			ScoreboardManager.setNextTitle();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getScoreboard() != null && p.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null){
					p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ScoreboardManager.title);
				}
			}
		}
	}
	
	public class SGARunnable extends BukkitRunnable {
		
		@SuppressWarnings("deprecation")
		@Override
		public void run(){//0, 3
			if(ServerData.isServer(Server.HUB)){
				ServerData.getHub().updateWaterfalls();
			}
			
			for(Player p : Bukkit.getOnlinePlayers()){
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				
				if(omp.isLoaded()){
					if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
						if(omp.getPet() != null){
							Entity pet = omp.getPet();
							
							if(omp.hasPetSheepDisco()){
								Random r = new Random();
								int rInt = r.nextInt(15);
								
								Sheep s = (Sheep) pet;
								DyeColor c = DyeColor.getByDyeData((byte) rInt);
								s.setColor(c);
							}
							if(omp.hasPetShroomTrail()){
								for(int i = 0; i <= 5; i++){
									ItemStack item = Utils.setDisplayname(new ItemStack(Material.RED_MUSHROOM, 1), p.getName() + i);
									final Item iEn = pet.getWorld().dropItem(pet.getLocation(), item);
						            iEn.setVelocity(pet.getLocation().getDirection().multiply(-1).add(Utils.getRandomVelocity()));
						            
									new BukkitRunnable(){
										@Override
										public void run() {
											iEn.remove();
										}
									}.runTaskLater(Start.getInstance(), 60);
								}
							}
							if(omp.hasPetBabyPigs()){
								List<Entity> list = omp.getPetBabyPigEntities();
								
								LivingEntity pig1 = (LivingEntity) list.get(0);
								LivingEntity pig2 = (LivingEntity) list.get(1);
								
								Location enL = pet.getLocation();
								Location pig1L = pig1.getLocation();
								Location pig2L = pig2.getLocation();
								
								if(getDistance(enL, pig1L) < 7 && getDistance(enL, pig1L) > 1){
									navigate(pig1, enL, 1.2);
								}
								else{
									pig1.teleport(enL);
								}
								if(getDistance(pig1L, pig2L) < 7 && getDistance(pig1L, pig2L) > 1){
									navigate(pig2, pig1L, 1.2);
								}
								else{
									pig2.teleport(pig1L);
								}
							}
						}
					}
					
					if(omp.getSGASeconds() != -1 && omp.getSGASnowGolems() != null){
						int seconds = omp.getSGASeconds();
						
						List<Entity> snowgolems = omp.getSGASnowGolems();
						
						List<Player> players = new ArrayList<Player>();
						for(Player player : Bukkit.getOnlinePlayers()){
							players.add(player);
						}
						
						if(seconds >= 12){
							Entity en = snowgolems.get(2);
							Player player = players.get(new Random().nextInt(players.size()));
							
							Location l1 = en.getLocation();
							Location l2 = player.getLocation();
							 
							Snowball s = ((Snowman) en).launchProjectile(Snowball.class, l2.toVector().subtract(l1.toVector()).multiply(0.15));
							en.getWorld().playSound(l1, Sound.DIG_SNOW, 2, 1);
							ServerStorage.snowgolemattackballs.add(s);
						}
						
						if(seconds == 50){
							Location l = snowgolems.get(1).getLocation();
							l.getWorld().playSound(l, Sound.WITHER_DEATH, 5, 1);
							
							Particle pa = new Particle(EnumParticle.FLAME, l);
							pa.setSize(2, 2, 2);
							pa.setAmount(30);
							pa.send(Bukkit.getOnlinePlayers());
							
							for(Entity en : snowgolems){
								en.remove();
							}
							
							omp.setSGASeconds(-1);
							omp.setSGAItem(null);
							omp.setSGASnowGolems(null);
						}
					}
				}
			}
		}
	}
	
	public class EntityRunnable extends BukkitRunnable {
		
		@Override
		public void run(){//40, 1
			for(NPCArmorStand npc : NPCArmorStand.getNPCArmorStands()){
			    npc.checkEntity();

				if(npc.getNPCType() == NPCType.CRATES){
					if(npc.getItem() != null){
						ItemStack item = npc.getItem().getItemStack();
						if(item.getType() == Material.CHEST){
							item.setType(Material.ENDER_CHEST);
						}
						else if(item.getType() == Material.ENDER_CHEST){
							item.setType(Material.CHEST);
						}
						else{
							item.setType(Material.ENDER_CHEST);
						}
						npc.getItem().setItemStack(item);
					}
				}
			}
			
			for(NPC npc : NPC.getNPCs()){
				npc.checkEntity();
				
				if(npc.getMovingTo() != null){
					npc.moveToLocation(npc.getMovingTo());
				}
				
				if(npc.getEntity() != null && npc.getEntity().getFireTicks() > 0 && npc.getNPCType() != NPCType.HOT_WING_KIT){
					npc.getEntity().setFireTicks(0);
				}
			}
			
			if(ServerData.isServer(Server.PRISON)){
				for(Lumberjack lj : ServerData.getPrison().getLumberjacks()){
					if(lj.isWorking()){
						if(lj.getWorkingOn() != null){
							lj.getNPC().moveToLocation(lj.getWorkingOn().getLocation());
						}
						else{
							lj.getNPC().moveToLocation(lj.getLocation());
						}
					}
				}
			}
			
			for(Player player : Bukkit.getOnlinePlayers()){
				OMPlayer omplayer = OMPlayer.getOMPlayer(player);
				
				if(omplayer.isLoaded()){
					if(omplayer != null && player.isOp() && omplayer.getStaffRank() != StaffRank.Owner && !omplayer.isOpMode()){
						player.setOp(false);
					}
					
					if(omplayer.getCooldowns().containsKey(Cooldown.TELEPORTING)){
						if(omplayer.onCooldown(Cooldown.TELEPORTING)){
							omplayer.parseTrail(Trail.FIREWORK_SPARK, TrailType.CYLINDER_TRAIL, 1, false);
						}
					}
					else{
						omplayer.playTrail();
					}
					omplayer.updateCooldownActionBar();
	
					Entity petentity = omplayer.getPet();
					if(petentity != null && petentity instanceof LivingEntity){
						if(petentity.getWorld().getName().equals(player.getWorld().getName())){
							LivingEntity pet = (LivingEntity) petentity;
							
							Location l = player.getLocation();
							
							if(getDistance(l, pet.getLocation()) < 20){
								navigate(pet, l, 1.2);
							}
							else{
								pet.teleport(l);
							}
						}
						else{
							omplayer.disablePet();
						}
					}
				}
			}
			
			if(ServerData.isServer(Server.HUB)){
				HubServer hub = ServerData.getHub();
				hub.updateWaterfalls();
			}
			
			World lobby = ServerData.getLobbyWorld();
			
			if(lobby != null && ServerData.isServer(Server.HUB, Server.MINIGAMES)){
				for(Entity en : lobby.getEntities()){
					if(ServerStorage.fireballs.contains(en) || ServerStorage.soccermagmacubes.contains(en)){
						Particle p = new Particle(EnumParticle.FLAME, en.getLocation());
						p.send(Bukkit.getOnlinePlayers());
					}
					else if(ServerStorage.eggbombs.contains(en)){
						Particle p = new Particle(EnumParticle.FIREWORKS_SPARK, en.getLocation());
						p.send(Bukkit.getOnlinePlayers());
					}
					else if(ServerStorage.silverfishbombs.contains(en)){
						if(en.isOnGround()){
							Location l = en.getLocation();
							l.getWorld().playSound(l, Sound.EXPLODE, 5, 1);
							l.getWorld().playEffect(l, Effect.EXPLOSION_HUGE, 4);
							Location l2 = new Location(l.getWorld(), l.getX() +1, l.getY(), l.getZ() +0);
							Location l3 = new Location(l.getWorld(), l.getX() +0, l.getY(), l.getZ() +1);
							Location l4 = new Location(l.getWorld(), l.getX() -1, l.getY(), l.getZ() +0);
							Location l5 = new Location(l.getWorld(), l.getX() +0, l.getY(), l.getZ() -1);
							
							for(Location lo : Arrays.asList(l, l2, l3, l4, l5)){
								final Silverfish s = (Silverfish) en.getWorld().spawnEntity(lo, EntityType.SILVERFISH);
								new BukkitRunnable(){
									@Override
									public void run() {
										s.remove();
									}
								}.runTaskLater(Start.getInstance(), 60);
							}
							
							en.remove();
							ServerStorage.silverfishbombs.remove(en);
						}
					}
					else if(ServerStorage.inkbombs.contains(en)){
						Particle p = new Particle(EnumParticle.SMOKE_LARGE, en.getLocation());
						p.send(Bukkit.getOnlinePlayers());
						ServerStorage.inkbombtime.put(en, ServerStorage.inkbombtime.get(en) -1);
						
						if(ServerStorage.inkbombtime.get(en) == 0){
							Location l1 = en.getLocation();
							Location l2 = new Location(l1.getWorld(), l1.getX() +1, l1.getY(), l1.getZ() +0);
							Location l3 = new Location(l1.getWorld(), l1.getX() +0, l1.getY(), l1.getZ() +1);
							Location l4 = new Location(l1.getWorld(), l1.getX() -1, l1.getY(), l1.getZ() -0);
							Location l5 = new Location(l1.getWorld(), l1.getX() -0, l1.getY(), l1.getZ() -1);
							
							Particle p2 = new Particle(EnumParticle.LAVA, l1);
							p2.setAmount(3);
							p2.send(Bukkit.getOnlinePlayers());
							p2.setLocation(l2);
							p2.send(Bukkit.getOnlinePlayers());
							p2.setLocation(l3);
							p2.send(Bukkit.getOnlinePlayers());
							p2.setLocation(l4);
							p2.send(Bukkit.getOnlinePlayers());
							p2.setLocation(l5);
							p2.send(Bukkit.getOnlinePlayers());
							
							l1.getWorld().playSound(l1, Sound.EXPLODE, 10, 1);
							
							for(Entity ens : en.getNearbyEntities(3, 3, 3)){
								if(ens instanceof Player){
									Player player = (Player) ens;
									player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
								}
							}
							
							en.remove();
							ServerStorage.inkbombs.remove(en);
							ServerStorage.inkbombtime.remove(en);
						}
					}
					else if(ServerStorage.swapteleporter.containsKey(en)){
						Particle p = new Particle(EnumParticle.SMOKE_LARGE, en.getLocation());
						p.setAmount(10);
						p.send(Bukkit.getOnlinePlayers());
						
						OMPlayer omplayer = ServerStorage.swapteleporter.get(en);
						Player player = omplayer.getPlayer();
						for(Entity e : en.getNearbyEntities(0.5, 1, 0.5)){
							if(e instanceof Player){
								if(player != e){
									Player player2 = (Player) e;
									OMPlayer omplayer2 = OMPlayer.getOMPlayer(player2);
									
									if(!omplayer.isInLapisParkour() && !omplayer2.isInLapisParkour()){
										if(omplayer2.hasPlayersEnabled()){
											Location l1 = player.getLocation();
											Location l2 = player2.getLocation();
											
											player.teleport(l2);
											player2.teleport(l1);
											
											player.sendMessage("§7You've §2§lswapped§7 positions with " + omplayer2.getName() + "§7!");
											player2.sendMessage(omplayer.getName() + " §2§lswapped§7 positions with you!");
											
											player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
											player2.playSound(player2.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
											
											ServerStorage.swapteleporter.remove(en);
											en.remove();
										}
										else{
											player.sendMessage("§7This player has §c§lDISABLED §3§lPlayers§7!");
											ServerStorage.swapteleporter.remove(en);
											en.remove();
										}
									}
								}
							}
						}
					}
					else{}
				}
			}
		}
	}
	
	public void toSellSign(){
		World w = ServerData.getLobbyWorld();
		for(Player player : Bukkit.getOnlinePlayers()){
			if(player.getWorld().getName().equals(w.getName()) && (ServerData.isServer(Server.SURVIVAL) && player.getLocation().distance(new Location(w, -42, 79, -5)) <= 16 || ServerData.isServer(Server.PRISON) && player.getLocation().distance(new Location(w, 0, 71, -4)) <= 16)){
				String currency = "$";
				if(ServerData.isServer(Server.PRISON)){
					currency = " G";
				}
				
				String[] lines1 = {"Shop:Sell", "276:0", "1 : 100" + currency, ""}; 
				String[] lines3 = {"§2§lSell", "Diamond Sword", "1 : 100" + currency, player.getName()}; 
				
				if(ServerData.isServer(Server.SURVIVAL)){
					player.sendSignChange(new Location(w, -43, 79, -6), lines1);
					player.sendSignChange(new Location(w, -43, 79, -4), lines3);
				}
				else{
					player.sendSignChange(new Location(w, -1, 71, -4), lines1);
					player.sendSignChange(new Location(w, 1, 71, -4), lines3);
				}
			}
		}
		
		new BukkitRunnable(){
			public void run(){
				toBuySign();
			}
		}.runTaskLater(Start.getInstance(), 200);
	}
	
	public void toBuySign(){
		World w = ServerData.getLobbyWorld();
		for(Player player : Bukkit.getOnlinePlayers()){
			if(player.getWorld().getName().equals(w.getName()) && (ServerData.isServer(Server.SURVIVAL) && player.getLocation().distance(new Location(w, -42, 79, -5)) <= 16 || ServerData.isServer(Server.PRISON) && player.getLocation().distance(new Location(w, 0, 71, -4)) <= 16)){
				String currency = "$";
				if(ServerData.isServer(Server.PRISON)){
					currency = " G";
				}
				
				String[] lines1 = {"Shop:Buy", "4:0", "64 : 10" + currency, ""};
				String[] lines3 = {"§2§lBuy", "Cobblestone", "64 : 10" + currency, player.getName()}; 
				
				if(ServerData.isServer(Server.SURVIVAL)){
					player.sendSignChange(new Location(w, -43, 79, -6), lines1);
					player.sendSignChange(new Location(w, -43, 79, -4), lines3);
				}
				else{
					player.sendSignChange(new Location(w, -1, 71, -4), lines1);
					player.sendSignChange(new Location(w, 1, 71, -4), lines3);
				}
			}
		}
		
		new BukkitRunnable(){
			public void run(){
				toSellSign();
			}
		}.runTaskLater(Start.getInstance(), 200);
	}
	
	public double getDistance(Location l1, Location l2){
		double distance = l1.distance(l2);
		return distance;
	}
	
	public void navigate(LivingEntity le, Location l, double v){
		try{
			Object entityLiving = ReflectionUtil.getMethod("getHandle", le.getClass(), 0).invoke(le);
			Object nav = ReflectionUtil.getMethod("getNavigation", entityLiving.getClass(), 0).invoke(entityLiving);
			ReflectionUtil.getMethod("a", nav.getClass(), 4).invoke(nav, l.getX(), l.getY(), l.getZ(), v);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
