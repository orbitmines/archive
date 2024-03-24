package me.O_o_Fadi_o_O.OrbitMines.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Hologram;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPCArmorStand;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.CreativeServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.KitPvPServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.PrisonServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SkyBlockServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ArmorType;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ItemType;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.Mastery;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.Masteries;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DamageEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e){
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Spider && !ServerStorage.pets.contains(e.getDamager())){
				final Player p = (Player) e.getEntity();
				
				p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 0));
				new BukkitRunnable(){
					public void run(){
						p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
					} 
				}.runTaskLater(Start.getInstance(), 1);
				new BukkitRunnable(){
					public void run(){
						p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
					} 
				}.runTaskLater(Start.getInstance(), 3);
				new BukkitRunnable(){
					public void run(){
						p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
					} 
				}.runTaskLater(Start.getInstance(), 5);
			}
			
			if(e.getDamager() instanceof Snowball){
				Entity ent = e.getDamager();
				if(ServerStorage.snowgolemattackballs.contains(ent)){
					
					for(Entity en : ent.getNearbyEntities(0.5, 0.5, 0.5)){
						if(en instanceof Player){
							Player p = (Player) en;
							OMPlayer omp = OMPlayer.getOMPlayer(p);
							
							if(!omp.isInLapisParkour()){
								p.playSound(p.getLocation(), Sound.WITHER_IDLE, 5, 1);
								p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
								p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 4));
							}
						}
					}
				}
			}
			
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
				ItemStack i = ((Player) e.getDamager()).getItemInHand();
				
				if(i != null && i.getType() == Material.LEASH && i.getItemMeta().getDisplayName().equals("§6§nStacker")){
					Player pE = (Player) e.getEntity();
					Player pD = (Player) e.getDamager();
					OMPlayer ompE = OMPlayer.getOMPlayer(pE);
					OMPlayer ompD = OMPlayer.getOMPlayer(pD);
					
					if(!ompE.isInLapisParkour() && !ompD.isInLapisParkour()){
						if(ompE.isLoaded() && ompD.isLoaded())
							if(ompE.hasStackerEnabled()){
								if(ompD.hasStackerEnabled()){
									if(ompE.hasPlayersEnabled()){
										pD.setPassenger(pE);
										
										pD.sendMessage("§7You've §6§lstacked§f " + ompE.getName() + "§7 on your Head!");
										pD.playEffect(pD.getLocation(), Effect.STEP_SOUND, 152);
										pE.sendMessage("§7" + ompD.getName() + " §6§lstacked§7 you on their Head!");
										e.setCancelled(true);
								}
								else{
									pD.sendMessage("§7This player has §c§lDISABLED §3§lPlayers§7!");
								}
							}
							else{
								pD.sendMessage("§7You §c§lDISABLED§6§l stacking§7! Enable it in your §c§nSettings§7!");
							}
						}
						else{
							pD.sendMessage("§7This player has §c§lDISABLED §6§lstacking§7!");
						}
					}
				}
			}
		}

		if(ServerData.isServer(Server.KITPVP)){
			if(e.getDamager() instanceof Player){
				Player pD = (Player) e.getDamager();
				OMPlayer ompD = OMPlayer.getOMPlayer(pD);
				KitPvPPlayer kpD = ompD.getKitPvPPlayer();
				Masteries mD = kpD.getMasteries();
				
				if(kpD.getSummonedUndeath().contains(e.getEntity())){
					e.setCancelled(true);
				}
				
				if(kpD.isSpectator() || kpD.isPlayer() && kpD.getKitSelected() == null){
					e.setCancelled(true);
				}
				
				if(e.getEntity() instanceof Player){
					Player pE = (Player) e.getEntity();
					OMPlayer ompE = OMPlayer.getOMPlayer(pE);
					KitPvPPlayer kpE = ompE.getKitPvPPlayer();
					Masteries mE = kpE.getMasteries();
					
					if(kpD.getSummonedUndeath().size() > 0){
						for(Entity en : kpD.getSummonedUndeath()){
							((PigZombie) en).setTarget(pE);
						}
					}
					
					// Masteries \\
					double meleedamage = e.getDamage() * mD.getMasteryEffect(Mastery.MELEE);
					double meleeprotected = e.getDamage() * mE.getMasteryEffect(Mastery.MELEE_PROTECTION);
					e.setDamage(e.getDamage() + meleedamage + meleeprotected);
					
					// Play Armor Enchantments \\
					for(ItemStack item : pE.getInventory().getArmorContents()){
						if(item != null && item.getItemMeta() != null && item.getItemMeta().getLore() != null){
							List<String> itemlore = item.getItemMeta().getLore();
							
							if(itemlore.contains(ArmorType.MOLTEN_ARMOR_I.getName())){
								ArmorType.MOLTEN_ARMOR_I.playEnchantment(ompD, ompE);
							}
							if(itemlore.contains(ArmorType.WITHER_ARMOR_I.getName())){
								ArmorType.WITHER_ARMOR_I.playEnchantment(ompD, ompE);
							}
						}
					}
					
					ItemStack item = pD.getItemInHand();
					if(item != null && item.getItemMeta() != null && item.getItemMeta().getLore() != null){
						List<String> itemlore = item.getItemMeta().getLore();
						
						for(ItemType type : ItemType.values()){
							if(itemlore.contains(type.getName())){
								type.playEnchantment(ompD, ompE, e.getDamage());
							}
						}
					}
				}
			}
			else if(e.getDamager() instanceof Projectile && e.getEntity() instanceof Player){
				KitPvPServer kitpvp = ServerData.getKitPvP();
				Projectile proj = (Projectile) e.getDamager();
				Player pE = (Player) e.getEntity();
				OMPlayer ompE = OMPlayer.getOMPlayer(pE);
				Masteries mE = ompE.getKitPvPPlayer().getMasteries();
				
				if(proj.getShooter() instanceof Player){
					Player pD = (Player) proj.getShooter();
					Masteries mD = OMPlayer.getOMPlayer(pD).getKitPvPPlayer().getMasteries();
					
					// Masteries \\
					double rangedamage = e.getDamage() * mD.getMasteryEffect(Mastery.RANGE);
					double rangeprotected = e.getDamage() * mE.getMasteryEffect(Mastery.RANGE_PROTECTION);
					e.setDamage(e.getDamage() + rangedamage + rangeprotected);
				}
				
				if(kitpvp.isProjectile(proj)){
					switch(kitpvp.getProjectileType(proj)){
						case EXPLOSIVE_I:				
							TNTPrimed tnt = (TNTPrimed) proj.getWorld().spawn(proj.getLocation(), TNTPrimed.class);
							tnt.setFuseTicks(10);
							break;
						case LIGHTNING_I:
							proj.getWorld().strikeLightning(proj.getLocation());
							break;
						case UNDEATH_I:
							final List<Entity> undeath1 = new ArrayList<Entity>();
							
							for(int i = 0; i < 3; i++){
								Zombie z = (Zombie) (proj.getWorld().spawnEntity(proj.getLocation(), EntityType.ZOMBIE));
								z.setCustomName("§4Undeath Knight");
								z.setCustomNameVisible(true);
				        		z.setTarget((LivingEntity) e.getEntity());
								undeath1.add(z);
							}
							
							new BukkitRunnable(){
								public void run(){
									for(Entity en : undeath1){
										if(!en.isDead()){
											en.getWorld().playEffect(en.getLocation(), Effect.STEP_SOUND, 152);
											en.remove();
										}
									}
								}
							}.runTaskLater(Start.getInstance(), 300);
							break;
						case UNDEATH_II:
							final List<Entity> undeath2 = new ArrayList<Entity>();
							
							for(int i = 0; i < 3; i++){
								Zombie z = (Zombie) (proj.getWorld().spawnEntity(proj.getLocation(), EntityType.ZOMBIE));
								z.setCustomName("§4Undeath Knight");
								z.setCustomNameVisible(true);
				        		z.setTarget((LivingEntity) e.getEntity());
								undeath2.add(z);
							}
							
							final Skeleton s = (Skeleton) (proj.getWorld().spawnEntity(proj.getLocation(), EntityType.SKELETON));
							s.setSkeletonType(SkeletonType.NORMAL);
							s.setCustomName("§4Undeath Archer");
							s.setCustomNameVisible(true);
			        		s.setTarget((LivingEntity) e.getEntity());
							undeath2.add(s);
							
							new BukkitRunnable(){
								public void run(){
									for(Entity en : undeath2){
										if(!en.isDead()){
											en.getWorld().playEffect(en.getLocation(), Effect.STEP_SOUND, 152);
											en.remove();
										}
									}
								}
							}.runTaskLater(Start.getInstance(), 300);
							break;
						case WITHER_I:
							ompE.addPotionEffect(PotionEffectType.WITHER, 5, 0);
							break;
						default:
							break;
					}
					
					kitpvp.removeProjectile(proj);
				}
			}
			else{}
		}
		else if(ServerData.isServer(Server.CREATIVE)){
			CreativeServer creative = ServerData.getCreative();

			if(e.getDamager() instanceof Player){
				Player pD = (Player) e.getDamager();
				OMPlayer ompD = OMPlayer.getOMPlayer(pD);
				CreativePlayer cpD = ompD.getCreativePlayer();
				
				if(pD.getWorld().getName().equals(creative.getPlotWorld().getName())){
					if(e.getEntity() instanceof Player){
						Player pE = (Player) e.getEntity();
						OMPlayer ompE = OMPlayer.getOMPlayer(pE);
						CreativePlayer cpE = ompE.getCreativePlayer();
						
						if(pD.getGameMode() != GameMode.SURVIVAL || pE.getGameMode() != GameMode.SURVIVAL || !cpD.isInPvPPlot() || !cpE.isInPvPPlot() || cpD.getPvPPlot().getPlotID() != cpE.getPvPPlot().getPlotID() || cpD.getSelectedKit() == null || cpE.getSelectedKit() == null){
							e.setCancelled(true);
						}
					}
					else{
						if(!ompD.isOpMode() && !cpD.isOnPlot(e.getEntity().getLocation()) || ((e.getEntity() instanceof ArmorStand) && NPCArmorStand.getNPCArmorStand((ArmorStand) e.getEntity()) != null)){
							e.setCancelled(true);
						}
					}
				}
				else if(pD.getWorld().getName().equals(creative.getCreativeWorld().getName())){
					if(!ompD.isOpMode()){
						e.setCancelled(true);
					}
				}
				else{}
			}
			if(e.getEntity() instanceof Player){
				Player pE = (Player) e.getEntity();
				OMPlayer ompE = OMPlayer.getOMPlayer(pE);
				CreativePlayer cpE = ompE.getCreativePlayer();
			
				if(cpE.isInPvPPlot() && cpE.getSelectedKit() == null){
					e.setCancelled(true);
				}
			}
		}
		else if(ServerData.isServer(Server.SURVIVAL)){
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
				Player pE = (Player) e.getEntity();
				OMPlayer ompE = OMPlayer.getOMPlayer(pE);
				SurvivalPlayer spE = ompE.getSurvivalPlayer();
				
				if(!spE.isInPvP()){
					e.setCancelled(true);
				}
			}
		}
		else if(ServerData.isServer(Server.SKYBLOCK)){
			if(e.getDamager() instanceof Player){
				Player pD = (Player) e.getDamager();
				SkyBlockServer skyblock = ServerData.getSkyBlock();
				OMPlayer ompD = OMPlayer.getOMPlayer(pD);
				SkyBlockPlayer sbpD = ompD.getSkyBlockPlayer();
				
				if(pD.getWorld().getName().equals(skyblock.getSkyblockWorld().getName()) || pD.getWorld().getName().equals(skyblock.getSkyblockNetherWorld().getName())){
					if(sbpD.hasIsland()){
						if(!sbpD.onIsland(e.getEntity().getLocation(), true)){
							e.setCancelled(true);
						}
					}
					else{
						e.setCancelled(true);
					}
				}
				else if(pD.getWorld().getName().equals(skyblock.getLobbyWorld().getName())){
					e.setCancelled(true);
				}
				else{}
			}
		}
		else if(ServerData.isServer(Server.PRISON)){
			if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
				PrisonServer prison = ServerData.getPrison();
				Player pD = (Player) e.getDamager();
				Player pE = (Player) e.getEntity();
				
				if(pD.getWorld().getName().equals(prison.getLobbyWorld().getName())){
					OMPlayer ompD = OMPlayer.getOMPlayer(pD);
					OMPlayer ompE = OMPlayer.getOMPlayer(pE);
					PrisonPlayer ppD = ompD.getPrisonPlayer();
					PrisonPlayer ppE = ompE.getPrisonPlayer();
					
					if(!ppD.isInPvP() || !ppE.isInPvP()){
						e.setCancelled(true);
					}
				}
				else{
					e.setCancelled(true);
				}
			}
		}
		else if(ServerData.isServer(Server.MINIGAMES)){
			if(e.getDamager() instanceof Player){
				Player pD = (Player) e.getDamager();
				OMPlayer ompD = OMPlayer.getOMPlayer(pD);
				Arena arena = ompD.getArena();
				
				if(arena != null){
					if(arena.getSpectators().contains(ompD)){
						e.setCancelled(true);
					}
					else{
						if(arena.getState() != GameState.IN_GAME){
							e.setCancelled(true);
						}
						else if(arena.getType() == MiniGameType.SURVIVAL_GAMES && arena.getMinutes() == 19 && arena.getSeconds() >= 30){
							Kit kitD = ompD.getSGPlayer().getKit();
							if(kitD != null && kitD.getKitName().equals(TicketType.RUNNER_KIT.getKit().getKitName())){
								e.setCancelled(true);
								pD.sendMessage("§7You can't deal damage the first 30s! (§f§l" + TicketType.RUNNER_KIT.getName() + "§7)");
							}
							else if(e.getEntity() instanceof Player){
								Player pE = (Player) e.getEntity();
								OMPlayer ompE = OMPlayer.getOMPlayer(pE);
								Kit kitE = ompE.getSGPlayer().getKit();
	
								if(kitE != null && kitE.getKitName().equals(TicketType.RUNNER_KIT.getKit().getKitName())){
									e.setCancelled(true);
									pD.sendMessage("§7You can't attack " + ompE.getName() + "§7 the first 30s! (§f§l" + TicketType.RUNNER_KIT.getName() + "§7)");
								}
							}
							else{}
						}
						else if(arena.getType() == MiniGameType.ULTRA_HARD_CORE){
							if(!arena.getUHC().isInPvP() && e.getEntity() instanceof Player){
								e.setCancelled(true);
							}
							if(e.getEntity() instanceof Boat){
								if(arena.isSpectator(ompD)){
									e.setCancelled(true);
								}
							}
						}
						else if(arena.getType() == MiniGameType.CHICKEN_FIGHT){
							if(e.getEntity() instanceof Player){
								final Player pE = (Player) e.getEntity();
								OMPlayer ompE = OMPlayer.getOMPlayer(pE);
								ompE.getSWPlayer().setLastProjectile(ompD);
								
								pE.getWorld().playEffect(pE.getLocation(), Effect.STEP_SOUND, 152, 3);

								final Vector v = ompE.getCFPlayer().getVelocity(pE.getLocation().subtract(pD.getLocation()).toVector().normalize()).add(new Vector(0, ompE.getCFPlayer().getKnockbackMotifier() / 4, 0));
								
								new BukkitRunnable(){
									public void run(){
										pE.setVelocity(v);
									}
								}.runTaskLater(Start.getInstance(), 1);
							}
							if(e.getEntity() instanceof Boat){
								if(arena.isSpectator(ompD)){
									e.setCancelled(true);
								}
							}
							if(e.getEntity() instanceof ArmorStand){
								Hologram h = Hologram.getHologram((ArmorStand) e.getEntity());

								if(h != null && arena.getType() == MiniGameType.CHICKEN_FIGHT && arena.getState() == GameState.IN_GAME){
									OMPlayer ompE = null;
									for(OMPlayer omplayer : arena.getPlayers()){
										if(omplayer.getPlayer() != pD && omplayer.getCFPlayer().getNameHologram().getHologramID() == h.getHologramID()){
											ompE = omplayer;
										}
									}
									Kit kit = ompE.getCFPlayer().getKit();

									if(kit != null){
										if(kit.getKitName().equals(TicketType.CHICKEN_MAMA_KIT.toString())){
											//e.setDamage(e.getDamage() * 1);
										}
										else if(kit.getKitName().equals(TicketType.BABY_CHICKEN_KIT.toString())){
											e.setDamage(e.getDamage() * 1.1);
										}
										else if(kit.getKitName().equals(TicketType.HOT_WING_KIT.toString())){
											e.setDamage(e.getDamage() * 1.5);
										}
										else if(kit.getKitName().equals(TicketType.CHICKEN_WARLORD_KIT.toString())){
											e.setDamage(e.getDamage() * 0.8);
										}
										else if(kit.getKitName().equals(TicketType.CHICKEN_KIT.toString())){
											e.setDamage(e.getDamage() * 0.9);
										}
										else{}
									}
									
									ompE.getPlayer().damage(e.getDamage(), e.getEntity());
								}
							}
						}
						else{}
					}
				}
			}
			else if(e.getEntity() instanceof Player && e.getDamager() instanceof Projectile){
				Player pE = (Player) e.getEntity();
				OMPlayer ompE = OMPlayer.getOMPlayer(pE);
				Arena arena = ompE.getArena();
				
				if(arena != null){
					if(arena.getType() == MiniGameType.SKYWARS){
						ProjectileSource ps = ((Projectile) e.getDamager()).getShooter();
						
						if(ps instanceof Player){
							Player pD = (Player) ps;
							OMPlayer ompD = OMPlayer.getOMPlayer(pD);
							
							ompE.getSWPlayer().setLastProjectile(ompD);
						}
					}
				}
			}
			else{}
		}
		else{}
	}
}
