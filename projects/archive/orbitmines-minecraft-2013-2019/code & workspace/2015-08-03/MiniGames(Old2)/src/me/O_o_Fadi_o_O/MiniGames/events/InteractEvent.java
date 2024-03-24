package me.O_o_Fadi_o_O.MiniGames.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.CosmeticPerks;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.VIPInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.MiniGameSelector;
import me.O_o_Fadi_o_O.MiniGames.Inventories.ServerSelector;
import me.O_o_Fadi_o_O.MiniGames.Inventories.StatsInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.TeleporterInv;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class InteractEvent implements Listener{
	
	Start plugin;
	 
	public InteractEvent(Start instance) {
		plugin = instance;
	}
	
	ServerSelector sinv = new ServerSelector();
	 
	public static Map<String, Long> lastUsage = new HashMap<String, Long>();
	public static final int cdtime = 6;
	
	public static Map<String, Long> lastUsage2 = new HashMap<String, Long>();
	public static final int cdtime2 = 7;
	
	public static Map<String, Long> lastUsage3 = new HashMap<String, Long>();
	public static final int cdtime3 = 10;
	
	public static Map<String, Long> lastUsage4 = new HashMap<String, Long>();
	public static final int cdtime4 = 8;
	
	private Map<String, Long> lastUsage5 = new HashMap<String, Long>();
	private final int cdtime5 = 4;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
		
		Action a = e.getAction();
		ItemStack i = e.getItem();
		try{
			
			Block b = e.getClickedBlock();
			
			if(StorageManager.SpectatorsInSurvivalGames.contains(p) || StorageManager.SpectatorsInChickenFight.contains(p)){
				
				e.setCancelled(true);
				
			}
			
			if(b != null && b.getType() == Material.CHEST){
				if(StorageManager.PlayersInSurvivalGames.contains(p)){
					Chest c = (Chest) b.getState();
					if(!StorageManager.SurvivalGamesChests.containsKey(c)){
						int arena = StorageManager.PlayersArena.get(p);
						SurvivalGames.setRandomChestContents(c);
						StorageManager.SurvivalGamesChests.put(c, arena);
						if(arena == 1){
							StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c);
						}
						if(arena == 2){
							StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c);
						}
						
						Location l1 = b.getLocation().add(0, 0, 1);
						Location l2 = b.getLocation().add(1, 0, 0);
						Location l3 = b.getLocation().subtract(1, 0, 0);
						Location l4 = b.getLocation().subtract(0, 0, 1);
						
						if(l1.getWorld().getBlockAt(l1).getType() == Material.CHEST){
							Chest c1 = (Chest) l1.getWorld().getBlockAt(l1).getState();
							StorageManager.SurvivalGamesChests.put(c1, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c1);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c1);
							}
						}
						if(l2.getWorld().getBlockAt(l2).getType() == Material.CHEST){
							Chest c2 = (Chest) l2.getWorld().getBlockAt(l2).getState();
							StorageManager.SurvivalGamesChests.put(c2, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c2);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c2);
							}
						}
						if(l3.getWorld().getBlockAt(l3).getType() == Material.CHEST){
							Chest c3 = (Chest) l3.getWorld().getBlockAt(l3).getState();
							StorageManager.SurvivalGamesChests.put(c3, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c3);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c3);
							}
						}
						if(l4.getWorld().getBlockAt(l4).getType() == Material.CHEST){
							Chest c4 = (Chest) l4.getWorld().getBlockAt(l4).getState();
							StorageManager.SurvivalGamesChests.put(c4, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c4);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c4);
							}
						}
					}
				}
			}
			if(b != null && b.getType() == Material.TRAPPED_CHEST){
				if(StorageManager.PlayersInSurvivalGames.contains(p)){
					Chest c = (Chest) b.getState();
					if(!StorageManager.SurvivalGamesChests.containsKey(c)){
						int arena = StorageManager.PlayersArena.get(p);
						SurvivalGames.setRandomChestContents(c);
						StorageManager.SurvivalGamesChests.put(c, arena);
						if(arena == 1){
							StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c);
						}
						if(arena == 2){
							StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c);
						}
						
						Location l1 = b.getLocation().add(0, 0, 1);
						Location l2 = b.getLocation().add(1, 0, 0);
						Location l3 = b.getLocation().subtract(1, 0, 0);
						Location l4 = b.getLocation().subtract(0, 0, 1);
						
						if(l1.getWorld().getBlockAt(l1).getType() == Material.TRAPPED_CHEST){
							Chest c1 = (Chest) l1.getWorld().getBlockAt(l1).getState();
							StorageManager.SurvivalGamesChests.put(c1, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c1);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c1);
							}
						}
						if(l2.getWorld().getBlockAt(l2).getType() == Material.TRAPPED_CHEST){
							Chest c2 = (Chest) l2.getWorld().getBlockAt(l2).getState();
							StorageManager.SurvivalGamesChests.put(c2, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c2);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c2);
							}
						}
						if(l3.getWorld().getBlockAt(l3).getType() == Material.TRAPPED_CHEST){
							Chest c3 = (Chest) l3.getWorld().getBlockAt(l3).getState();
							StorageManager.SurvivalGamesChests.put(c3, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c3);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c3);
							}
						}
						if(l4.getWorld().getBlockAt(l4).getType() == Material.TRAPPED_CHEST){
							Chest c4 = (Chest) l4.getWorld().getBlockAt(l4).getState();
							StorageManager.SurvivalGamesChests.put(c4, arena);
							if(arena == 1){
								StorageManager.SurvivalGamesAllChestsArena1.put(StorageManager.SurvivalGamesAllChestsArena1.size() +1, c4);
							}
							if(arena == 2){
								StorageManager.SurvivalGamesAllChestsArena2.put(StorageManager.SurvivalGamesAllChestsArena2.size() +1, c4);
							}
						}
					}
				}
			}
			
		}catch(Exception ex){
			
		}
		try{
			if(i != null){
				if(i.getType() == Material.NAME_TAG && i.getItemMeta().getDisplayName().equals("§e§nTeleporter")){
					e.setCancelled(true);
					p.updateInventory();
					
					p.openInventory(TeleporterInv.getTeleporterInv(p));
					
				}
				if(i.getType() == Material.SKULL_ITEM && !i.getItemMeta().getDisplayName().equals("§a§nCreeper Launcher")){
					e.setCancelled(true);
					p.updateInventory();
					
					if(PlayerManager.isLoaded(p)){
						p.openInventory(MiniGameSelector.getMiniGameSelectorInv(p, 0));
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
				}
				if(i.getType() == Material.SADDLE && i.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.LEASH){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.ENDER_PEARL){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.EXP_BOTTLE){
					if(!StorageManager.PlayersGame.containsKey(p)){
						e.setCancelled(true);
						p.updateInventory();
					}
				}
				if(i.getType() == Material.EYE_OF_ENDER && i.getItemMeta().getDisplayName().equals("§2§nSwap Teleporter")){
					e.setCancelled(true);
					if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
						long lastUsed5 = 0;
						if(lastUsage5.containsKey(p.getName())){
							lastUsed5 = lastUsage5.get(p.getName());
						}
						int cdmillis5 = cdtime5 * 1000;
								
						if(System.currentTimeMillis()-lastUsed5>=cdmillis5){
							ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
							final Entity en = p.getWorld().dropItem(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), item);
							
							en.setVelocity(p.getLocation().getDirection().multiply(1.5));
							
							if(StorageManager.SwapTeleporter.containsValue(p)){
								for(World w : Bukkit.getWorlds()){
									for(Entity ent : w.getEntities()){
										if(StorageManager.SwapTeleporter.containsKey(ent)){
											if(StorageManager.SwapTeleporter.get(ent) == p){
												StorageManager.SwapTeleporter.remove(ent);
												ent.remove();
											}
										}
									}
								}
							}
							
							StorageManager.SwapTeleporter.put(en, p);
							
							new BukkitRunnable(){
								public void run(){
									if(StorageManager.SwapTeleporter.get(en) != null){
										StorageManager.SwapTeleporter.remove(en);
										en.remove();
									}
								}
							}.runTaskLater(this.plugin, 100);
							
							lastUsage5.put(p.getName(), System.currentTimeMillis());
						}
					}
				}
				if(i.getType() == Material.SKULL_ITEM && i.getItemMeta().getDisplayName().equals("§a§nCreeper Launcher")){
					
					e.setCancelled(true);
					p.updateInventory();
					
					long lastUsed = 0;
					if(lastUsage.containsKey(p.getName())){
						lastUsed = lastUsage.get(p.getName());
					}
					int cdmillis = cdtime * 1000;
							
					if(System.currentTimeMillis()-lastUsed>=cdmillis){
						
						Creeper creeper = (Creeper) p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
						creeper.setPowered(true);
						
						Vector vector = p.getLocation().getDirection().normalize().multiply(1.5);
						
						creeper.setVelocity(vector);
						
						lastUsage.put(p.getName(), System.currentTimeMillis());
					}
				}
				if(i.getType() == Material.SNOW_BALL && i.getItemMeta().getDisplayName().equals("§f§nPaintballs")){
					e.setCancelled(true);
					p.updateInventory();
					Snowball ball = p.launchProjectile(Snowball.class);
					StorageManager.Paintballs.add(ball);
				}
				if(i.getType() == Material.BOOK && i.getItemMeta().getDisplayName().equals("§7§nBook Explosion")){
					e.setCancelled(true);
					p.updateInventory();
					
					long lastUsed2 = 0;
					if(lastUsage2.containsKey(p.getName())){
						lastUsed2 = lastUsage2.get(p.getName());
					}
					int cdmillis2 = cdtime2 * 1000;
							
					if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
						p.getWorld().playSound(p.getLocation(), Sound.EXPLODE, 5, 1);
						for(int i1 = 1; i1 <= 12; i1++){
							int upper1 = 5;
							Random random1 = new Random();
							random1.nextInt((upper1));
							int upper2 = 4;
							Random random2 = new Random();
							random2.nextInt((upper2));
							int upper3 = 6;
							Random random3 = new Random();
							random3.nextInt((upper3));
							
							ItemStack item = new ItemStack(Material.PAPER);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("Paper " + i1);
							item.setItemMeta(meta);
							
							final Item paper = p.getWorld().dropItem(p.getLocation(), item);
				            	
			            	if(i1 == 1 || i1 == 2 || i1 == 3){
					            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
					            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
					            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
			            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
			            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
			            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
			            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
			            	}
			            	else if(i1 == 4 || i1 == 5 || i1 == 6){
					            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
					            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
					            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
			            		paper.setVelocity(new Vector(x, y, z));
			            		paper.setVelocity(new Vector(x, y, z));
			            		paper.setVelocity(new Vector(x, y, z));
			            		paper.setVelocity(new Vector(x, y, z));
			            	}
			            	else if(i1 == 7 || i1 == 8 || i1 == 9){
					            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
					            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
					            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
			            		paper.setVelocity(new Vector(x -0.2, y, z));
			            		paper.setVelocity(new Vector(x -0.2, y, z));
			            		paper.setVelocity(new Vector(x -0.2, y, z));
			            		paper.setVelocity(new Vector(x -0.2, y, z));
			            	}
			              	else if(i1 == 10 || i1 == 11 || i1 == 12){
					            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
					            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
					            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
			            		paper.setVelocity(new Vector(x, y, z -0.2));
			            		paper.setVelocity(new Vector(x, y, z -0.2));
			            		paper.setVelocity(new Vector(x, y, z -0.2));
			            		paper.setVelocity(new Vector(x, y, z -0.2));
			            	}
							
							new BukkitRunnable(){
							  @Override
							  public void run(){
							    paper.remove();
							  }
							}.runTaskLater(this.plugin, 20 * 10L);
							
							lastUsage2.put(p.getName(), System.currentTimeMillis());
						}
					}
				}
				if(i.getType() == Material.FIREBALL && i.getItemMeta().getDisplayName().startsWith("§c§nFirework Gun")){
					e.setCancelled(true);
					p.updateInventory();
					if(StorageManager.FireworkPasses.get(p.getName()) >= 1){
						Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				        FireworkMeta fwmeta = fw.getFireworkMeta();
				        FireworkEffect.Builder builder = FireworkEffect.builder();
				        if(StorageManager.FireworkTrail.get(p.getName()) != null && StorageManager.FireworkTrail.get(p.getName()) == true){
				        	builder.withTrail();
				        }
				        if(StorageManager.FireworkFlicker.get(p.getName()) != null && StorageManager.FireworkFlicker.get(p.getName()) == true){
				        	builder.withFlicker();
				        }
				        if(StorageManager.FireworkFade1.get(p.getName()) != null){
				        	builder.withFade(StorageManager.FireworkFade1.get(p.getName()));
				        }
				        if(StorageManager.FireworkFade2.get(p.getName()) != null){
				        	builder.withFade(StorageManager.FireworkFade2.get(p.getName()));
				        }
				        if(StorageManager.FireworkColor1.get(p.getName()) != null){
				        	builder.withColor(StorageManager.FireworkColor1.get(p.getName()));
				        }
				        else{
				        	builder.withColor(Color.AQUA);
				        }
				        if(StorageManager.FireworkColor2.get(p.getName()) != null){
				        	builder.withColor(StorageManager.FireworkColor2.get(p.getName()));
				        }
				        if(StorageManager.FireworkType.get(p.getName()) != null){
				        	builder.with(StorageManager.FireworkType.get(p.getName()));
				        }
				        else{
				        	builder.with(Type.BALL);
				        }
				        
				        fwmeta.addEffects(builder.build());
				        fw.setFireworkMeta(fwmeta);
				        
				        fw.setVelocity(p.getLocation().getDirection().multiply(0.2));
				        
				        StorageManager.FireworkPasses.put(p.getName(), StorageManager.FireworkPasses.get(p.getName()) -1);
				        
						ItemStack item = new ItemStack(Material.FIREBALL, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c§nFirework Gun§r §c(§6" + StorageManager.FireworkPasses.get(p.getName()) + "§c)");
						item.setItemMeta(itemmeta);
						p.getInventory().setItem(6, new ItemStack(item));
					}
					else{
						p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7You don't have any §6§lFirework Passes§7.");
					}
				}
				if(i.getType() == Material.ENDER_CHEST && i.getItemMeta().getDisplayName().equals("§9§nCosmetic Perks")){
					
					e.setCancelled(true);
					p.updateInventory();
					
					if(PlayerManager.isLoaded(p)){
						if(StorageManager.PlayersGame.containsKey(p)){
							if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
								if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p)) == ChickenFightState.LOBBY){
									p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
									p.openInventory(CosmeticPerks.getCosmeticPerks(p));
								}
							}
							if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
								if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.LOBBY){
									p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
									p.openInventory(CosmeticPerks.getCosmeticPerks(p));
								}
							}
						}
						else{
							p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
							p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						}
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
				}
			}
		}catch(Exception ex){
			
		}
		
		if(e.getItem() != null){
			if(e.getItem().getType() == Material.POTION && i.getItemMeta().getDisplayName().equals("§b§nGame Effects")){
				e.setCancelled(true);
				p.openInventory(VIPInv.getVIPInv(p));
				p.playSound(p.getLocation(), Sound.DRINK, 5, 1);
			}
			if(e.getItem().getType() == Material.FEATHER){
				if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){
			
					if(StorageManager.PlayersGame.containsKey(p)){
						if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
							if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p)) == ChickenFightState.INGAME){
						
								if(StorageManager.ChickenFightKit.get(p).equals("Chicken Mama")){
									
									long lastUsed = 0;
									if(lastUsage.containsKey(p.getName())){
										lastUsed = lastUsage.get(p.getName());
									}
									int cdmillis = cdtime * 1000;
											
									if(System.currentTimeMillis()-lastUsed>=cdmillis){
										p.getWorld().playSound(p.getLocation(), Sound.CHICKEN_HURT, 5, 1);
										
										p.sendMessage("§7You used §f§lFeather Attack§7!");
										
										for(Entity en : p.getNearbyEntities(2, 2, 2)){
											
											if(en instanceof Player){
												
												Player player = (Player) en;
												if(StorageManager.ChickenFightKit.containsKey(player)){
													if(StorageManager.ChickenFightKit.get(player).equals("Baby Chicken")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.4);
														player.setVelocity(velocity.add(new Vector(0, 1.1, 0)));
													}
													if(StorageManager.ChickenFightKit.get(player).equals("Chicken Mama")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.2);
														player.setVelocity(velocity.add(new Vector(0, 0.55, 0)));
													}
													if(StorageManager.ChickenFightKit.get(player).equals("Hot Wing")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.3);
														player.setVelocity(velocity.add(new Vector(0, 0.825, 0)));
													}
													if(StorageManager.ChickenFightKit.get(player).equals("Chicken Warrior")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2);
														player.setVelocity(velocity.add(new Vector(0, 0.28, 0)));
													}
													player.damage(4D, p);
												}
											}
										}
										
										for(int i1 = 1; i1 <= 25; i1++){
											int upper1 = 5;
											Random random1 = new Random();
											random1.nextInt((upper1));
											int upper2 = 4;
											Random random2 = new Random();
											random2.nextInt((upper2));
											int upper3 = 6;
											Random random3 = new Random();
											random3.nextInt((upper3));
											
											ItemStack toDrop = new ItemStack(Material.FEATHER);
											ItemMeta meta = toDrop.getItemMeta();
											meta.setDisplayName("Feather" + i1);
											toDrop.setItemMeta(meta);
											
											int upper4 = 2;
											Random random4 = new Random();
											random4.nextInt(upper4);
											
											if(random4.nextInt(upper4) == 1){
												final Item item = p.getWorld().dropItem(p.getLocation().add(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
												item.setPickupDelay(Integer.MAX_VALUE);
												 
												new BukkitRunnable(){
												  @Override
												  public void run(){
												    item.remove();
												  }
												}.runTaskLater(this.plugin, 40L);
											}
											if(random4.nextInt(upper4) == 2){
												final Item item = p.getWorld().dropItem(p.getLocation().subtract(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
												item.setPickupDelay(Integer.MAX_VALUE);
												 
												new BukkitRunnable(){
												  @Override
												  public void run(){
												    item.remove();
												  }
												}.runTaskLater(this.plugin, 40L);
											}
										}
										p.setLevel(0);
										p.setExp(0);
										lastUsage.put(p.getName(), System.currentTimeMillis());
									}
									else{
										int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lFeather Attack§7 in §6" + timeLeft + "s");
									}
								}
								if(StorageManager.ChickenFightKit.get(p).equals("Baby Chicken")){
									long lastUsed2 = 0;
									if(lastUsage2.containsKey(p.getName())){
										lastUsed2 = lastUsage2.get(p.getName());
									}
									int cdmillis2 = cdtime2 * 1000;
											
									if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
										p.getWorld().playSound(p.getLocation(), Sound.CLICK, 5, 1);
										
										p.sendMessage("§7You used §f§lEgg Bom§7!");
										p.launchProjectile(Egg.class);
										
										p.setLevel(0);
										p.setExp(0);
										lastUsage2.put(p.getName(), System.currentTimeMillis());
									}
									else{
										int timeLeft = (int) (cdtime2-((System.currentTimeMillis()-lastUsed2)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lEgg Bom§7 in §6" + timeLeft + "s");
									}
									
								}
								if(StorageManager.ChickenFightKit.get(p).equals("Hot Wing")){
									long lastUsed3 = 0;
									if(lastUsage3.containsKey(p.getName())){
										lastUsed3 = lastUsage3.get(p.getName());
									}
									int cdmillis3 = cdtime3 * 1000;
											
									if(System.currentTimeMillis()-lastUsed3>=cdmillis3){
										p.getWorld().playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 5, 1);
										
										p.sendMessage("§7You used §f§lFire Shield§7!");
										
										ShieldEffect effect = new ShieldEffect(Start.effectManager);
										effect.setLocation(p.getLocation());
						                effect.iterations = 15;
						                effect.particle = ParticleEffect.FLAME;
						
						                effect.start();
										
						                for(Entity en : p.getNearbyEntities(2.5, 2.5, 2.5)){
						                	
						                	if(en instanceof Player){
						                		
						                		Player player = (Player) en;
						                		
						                		player.setFireTicks(80);
						                		player.playSound(player.getLocation(), Sound.FIRE_IGNITE, 5, 1);
						                		
						                	}
						                	
						                }
										
										p.setLevel(0);
										p.setExp(0);
										lastUsage3.put(p.getName(), System.currentTimeMillis());
									}
									else{
										int timeLeft = (int) (cdtime3-((System.currentTimeMillis()-lastUsed3)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lFire Shield§7 in §6" + timeLeft + "s");
									}
									
								}
								if(StorageManager.ChickenFightKit.get(p).equals("Chicken Warrior")){
									long lastUsed4 = 0;
									if(lastUsage4.containsKey(p.getName())){
										lastUsed4 = lastUsage4.get(p.getName());
									}
									int cdmillis4 = cdtime4 * 1000;
											
									if(System.currentTimeMillis()-lastUsed4>=cdmillis4){
										
										p.sendMessage("§7You used §f§lKnock Knock§7!");
										p.playSound(p.getLocation(), Sound.IRONGOLEM_THROW, 5, 1);
										
						                for(Entity en : p.getNearbyEntities(3, 3, 3)){
						                	
						                	if(en instanceof Player){
						                		
						                		final Player player = (Player) en;
						                		
						                		player.playSound(player.getLocation(), Sound.IRONGOLEM_THROW, 5, 1);
						                		
						                		new BukkitRunnable(){
												  @Override
												  public void run(){
														if(StorageManager.ChickenFightKit.containsKey(player)){
															if(StorageManager.ChickenFightKit.get(player).equals("Baby Chicken")){
										                		player.setVelocity(new Vector(0, 0.9, 0).multiply(2.5));
															}
															if(StorageManager.ChickenFightKit.get(player).equals("Chicken Mama")){
										                		player.setVelocity(new Vector(0, 0.7, 0).multiply(2.5));
															}
															if(StorageManager.ChickenFightKit.get(player).equals("Hot Wing")){
										                		player.setVelocity(new Vector(0, 0.8, 0).multiply(2.5));
															}
															if(StorageManager.ChickenFightKit.get(player).equals("Chicken Warrior")){
										                		player.setVelocity(new Vector(0, 0.5, 0).multiply(2.5));
															}
															player.damage(5D, p);
														}
												  }
												}.runTaskLater(this.plugin, 1L);
						                	}
						                	
						                }
										
										p.setLevel(0);
										p.setExp(0);
										lastUsage4.put(p.getName(), System.currentTimeMillis());
									}
									else{
										int timeLeft = (int) (cdtime4-((System.currentTimeMillis()-lastUsed4)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lKnock Knock§7 in §6" + timeLeft + "s");
									}
								}
								
							}
						}
					}
					
				}
			}
			if(e.getItem().getType() == Material.EMERALD){
				if(PlayerManager.isLoaded(p)){
					p.playEffect(p.getLocation(), Effect.STEP_SOUND, 133);
					p.openInventory(StatsInv.getStatsInv(p));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
				
			}
			if(e.getItem().getType() == Material.ENDER_PEARL && e.getItem().getItemMeta().getDisplayName().endsWith("Hub")){
				e.setCancelled(true);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.updateInventory();
				
					} 
				}, 1L);
				
				if(PlayerManager.isLoaded(p)){
					
			        ByteArrayOutputStream b = new ByteArrayOutputStream();
			        DataOutputStream out = new DataOutputStream(b);
			 
			        try {
			            out.writeUTF("Connect");
			            out.writeUTF("hub");
			        } catch (IOException eee) {
			         
			        }
			 
			        p.sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
			}
			if(e.getItem().getType() == Material.ENDER_PEARL && e.getItem().getItemMeta().getDisplayName().endsWith("Lobby")){
				e.setCancelled(true);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.updateInventory();
				
					} 
				}, 1L);
				
				if(PlayerManager.isLoaded(p)){
					
					if(StorageManager.PlayersGame.containsKey(p)){
						if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
							ChickenFight.leaveArena(p, StorageManager.PlayersArena.get(p));
						}
						if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
							SurvivalGames.leaveArena(p, StorageManager.PlayersArena.get(p));
						}
					}
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
			}
		}
	}
}
