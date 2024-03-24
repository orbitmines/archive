package me.O_o_Fadi_o_O.OrbitMines.events;

import java.util.ArrayList;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.ActionBar;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.KitPvPServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Plot;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.ActiveBooster;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ItemType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.ChickenFightPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SkywarsPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SurvivalGamesPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.UHCPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class EntityDeath implements Listener{
	
	@EventHandler
	public void onDeath(EntityDeathEvent e){
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES) && e.getEntity() instanceof Creeper){
			e.getDrops().clear();
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		final Player p = (Player) e.getEntity();
		final OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(ServerData.isServer(Server.KITPVP)){
			final KitPvPServer kitpvp = ServerData.getKitPvP();
			KitPvPPlayer kp = omp.getKitPvPPlayer();
			
			e.getDrops().clear();

			for(int i = 0; i < 6; i++){
				ItemStack itemD = Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.INK_SACK), "Blood " + p.getName() + i), 1);
				int delay = 40;
				if(i > 2){
					itemD = Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.BONE), "Bone " + p.getName() + i), 1);
					delay = 60;
				}
				
				final Item item = p.getWorld().dropItem(p.getLocation(), itemD);
				item.setPickupDelay(Integer.MAX_VALUE);
				item.setVelocity(Utils.getRandomVelocity());
				
				new BukkitRunnable(){
					public void run(){
						item.remove();
					}
				}.runTaskLater(Start.getInstance(), delay);
			}
			
			kp.setKitSelected(null);
			kp.setKitLevelSelected(1);
			kp.setCurrentStreak(0);
			kp.addDeath();
			
			if(p.getKiller() instanceof Player && p.getKiller() != p){
				Player pK = (Player) p.getKiller();
				final OMPlayer ompK = OMPlayer.getOMPlayer(pK);
				KitPvPPlayer kpK = ompK.getKitPvPPlayer();
				ItemStack item = pK.getItemInHand();
				
				{// Necromancer Wither I \\
					ItemStack stick = Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STICK), "§b§lNecromancer §a§lLvL 3§8 || §8Necromancer's Staff"), ItemType.WITHER_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5);
					
					if(pK.getInventory().containsAtLeast(stick, 1)){
						pK.getInventory().addItem(Utils.setDisplayname(new ItemStack(Material.REDSTONE), "§b§lNecromancer §a§lLvL 3§8 || §cSoul"));
					}
				}
				
				int money = 0;
				ActiveBooster booster = kitpvp.getBooster();
				if(booster == null){
					money = (int) (50 * kpK.getVIPBooster());
					int vipextra = money - 50;
					
					kpK.addMoney(money);
					kp.createKillHologram(pK, money);
					pK.sendMessage("§6§l+50 Coins");
					if(vipextra != 0){
						pK.sendMessage("§6§l+" + vipextra + " Coins §7(" + ompK.getVIPRank().getRankString() + " §lVIP§7)");
					}
				}
				else{
					money = (int) (50 * booster.getBooster().getMultiplier());
					int extra = money - 50;
					money *= kpK.getVIPBooster();
					int vipextra = money - 50 - extra;
					
					kpK.addMoney(money);
					kp.createKillHologram(pK, money);
					
					pK.sendMessage("§6§l+50 Coins");
					pK.sendMessage("§6§l+" + extra + " Coins §7(§a" + booster.getPlayer() + "'s Booster§7)");
					if(vipextra != 0){
						pK.sendMessage("§6§l+" + vipextra + " Coins §7(" + ompK.getVIPRank().getRankString() + " §lVIP§7)");
					}
				}
				
				kpK.setCurrentStreak(kpK.getCurrentStreak() +1);
				kpK.addKill();
				pK.sendMessage("§f§lCurrent Streak: §c§l" + kpK.getCurrentStreak() + " §f§lBest Streak: §c§l" + kpK.getBestStreak());
				if(kpK.getBestStreak() < kpK.getCurrentStreak()){
					kpK.setBestStreak(kpK.getCurrentStreak());
					
					pK.sendMessage("§f§lNew Best Streak: §c§l" + kpK.getCurrentStreak());
					pK.playSound(pK.getLocation(), Sound.LEVEL_UP, 5, 1);
				}
				
				if(item == null || item.getType() != Material.BOW){
					if(new Random().nextBoolean()){
						e.setDeathMessage("§6" + p.getName() + "§7 was killed by §6" + pK.getName() + "§7!");
					}
					else{
						e.setDeathMessage("§6" + p.getName() + "§7 was slaughtered by §6" + pK.getName() + "§7!");
					}
				}
				else{
					if(new Random().nextBoolean()){
						e.setDeathMessage("§6" + p.getName() + "§7 was shot by §6" + pK.getName() + "§7!");
					}
					else{
						e.setDeathMessage("§6" + p.getName() + "§7 was sniped by §6" + pK.getName() + "§7!");
					}
				}
				
				kpK.addExp(2);
				if(kpK.isLevelUp()){
					kpK.setExp(kpK.getExp() - (int) kpK.getExpRequired());
					kpK.addLevel();
					Bukkit.broadcastMessage("§6" + ompK.getName() + " §7reached level §6" + kpK.getLevels() + "§7!");
				}
				kpK.updateLevel();
				
				ActionBar ab = new ActionBar("§6+" + money + " Coins§7, §e+" + 2 * kpK.getExpBooster() + " XP");
				ab.send(pK);
				
				final int streak = kpK.getCurrentStreak();
				if(streak == 3 || streak == 5 || streak >= 10){
					new BukkitRunnable(){
						public void run(){
							Bukkit.broadcastMessage("§c§l" + ompK.getName() + "§7 has a §c§l" + streak + " Kill Streak§7!");
						}
					}.runTaskLater(Start.getInstance(), 1);
				}
			}
			else{
				e.setDeathMessage("§6" + p.getName() + "§7 died.");
			}
			
			p.setHealth(20);
			p.teleport(kitpvp.getSpawn());
			omp.clearInventory();
			
			new BukkitRunnable(){
				public void run(){
					p.setVelocity(new Vector(0, 0, 0));
					p.setFireTicks(0);
					kitpvp.giveLobbyItems(omp);
				}
			}.runTaskLater(Start.getInstance(), 1);
		}
		else if(ServerData.isServer(Server.CREATIVE)){
			CreativePlayer cp = omp.getCreativePlayer();
			
			if(cp.isInPvPPlot()){
				final Plot plot = cp.getPvPPlot();
				
				if(!plot.hasPvPDrops()){
					e.getDrops().clear();
				}
				
				cp.setSelectedKit(null);
				p.setHealth(20D);
				
				new BukkitRunnable(){
					public void run(){
						p.teleport(plot.getPvPLobbyLocation());
						p.setVelocity(new Vector(0, 0, 0));
						p.setFireTicks(0);
						omp.clearInventory();
						omp.clearPotionEffects();
					}
				}.runTaskLater(Start.getInstance(), 1);
			}
		}
		else if(ServerData.isServer(Server.SURVIVAL)){
			SurvivalPlayer sp = omp.getSurvivalPlayer();
			
			p.setHealth(20D);
			p.setFoodLevel(20);
			sp.setLastLocation(p.getLocation());
			
			new BukkitRunnable(){
				public void run(){
					p.teleport(ServerData.getSurvival().getSpawn());
					p.setVelocity(new Vector(0, 0, 0));
					p.setFireTicks(0);
					omp.clearLevels();
					omp.clearPotionEffects();
				}
			}.runTaskLater(Start.getInstance(), 1);
		}
		else if(ServerData.isServer(Server.SKYBLOCK)){
			p.setHealth(20D);
			p.setFoodLevel(20);
			
			new BukkitRunnable(){
				public void run(){
					p.teleport(ServerData.getSkyBlock().getSpawn());
					p.setVelocity(new Vector(0, 0, 0));
					p.setFireTicks(0);
					if(!omp.hasPerms(VIPRank.Diamond_VIP)){
						omp.clearLevels();
					}
					omp.clearPotionEffects();
				}
			}.runTaskLater(Start.getInstance(), 1);
		}
		else if(ServerData.isServer(Server.PRISON)){
			p.setHealth(20D);
			p.setFoodLevel(20);
			
			new BukkitRunnable(){
				public void run(){
					p.teleport(ServerData.getPrison().getSpawn());
					p.setVelocity(new Vector(0, 0, 0));
					p.setFireTicks(0);
					omp.clearLevels();
					omp.clearPotionEffects();
				}
			}.runTaskLater(Start.getInstance(), 1);
		}
		else if(ServerData.isServer(Server.MINIGAMES)){
			final Arena arena = omp.getArena();
			
			if(arena != null){
				p.setHealth(20D);
				p.setFoodLevel(20);
				e.setDeathMessage(null);
				
				if(arena.getState() == GameState.IN_GAME){
					switch(arena.getType()){
						case CHICKEN_FIGHT:
							e.getDrops().clear();
							
							arena.getPlayers().remove(omp);
							arena.getDeadPlayers().add(omp);
							arena.getSpectators().add(omp);

						    omp.getCFPlayer().updateHologram();
							omp.getCFPlayer().setSecondsSurvived(900 - (arena.getMinutes() * 60 + arena.getSeconds()));
							omp.clearPotionEffects();
							
							p.setAllowFlight(true);
							p.setFlying(true);
						    ((CraftPlayer) p).getHandle().setInvisible(true);
						    
							if(p.getKiller() instanceof Player){
								Player pK = p.getKiller();
								OMPlayer ompK = OMPlayer.getOMPlayer(pK);
								ChickenFightPlayer cfpK = ompK.getCFPlayer();
								
								if(new Random().nextBoolean()){
									arena.sendMessage(omp.getName() + "§7 was killed by " + ompK.getName() + "§7.");
								}
								else{
									arena.sendMessage(omp.getName() + "§7 was slaughtered by " + ompK.getName() + "§7.");
								}
								
								pK.sendMessage("§2§l+1 Kill");

								int kills = cfpK.getRoundKills();
								cfpK.addRoundKill();
										
								if(cfpK.getRoundKills() % 2 == 0){
									ActionBar ab = new ActionBar("§2+1 Kill§7, §f+1 Ticket");
									ab.send(pK);
									
									pK.sendMessage("§f§l+1 Ticket");
									omp.addMGTickets(1);
								}
								else{
									ActionBar ab = new ActionBar("§2+1 Kill");
									ab.send(pK);
								}
								cfpK.addKill();
								
								pK.sendMessage("§f§lCurrent Streak: §c§l" + (kills +1) + " §f§lBest Streak: §c§l" + cfpK.getBeststreak());
								if(cfpK.getBeststreak() < kills +1){
									cfpK.setBeststreak(kills +1);
									
									pK.sendMessage("§f§lNew Best Streak: §c§l" + (kills +1));
									pK.playSound(pK.getLocation(), Sound.LEVEL_UP, 5, 1);
								}
							}
							else{
								if(p.getLocation().getY() < 0){
									arena.sendMessage(omp.getName() + "§7 fell into the void.");
								}
								else{
									arena.sendMessage(omp.getName() + "§7 died.");
								}
							}
							
						    if(arena.getPlayers().size() == 1){
						    	arena.getCF().setSecondPlace(omp);
						    	arena.getCF().ending();
						    }
						    else if(arena.getPlayers().size() == 2){
						    	arena.getCF().setThirdPlace(omp);
						    }
						    else{}
						    
						    new BukkitRunnable(){
						    	public void run(){
						    		Kit.getKit("Spectator").setItems(p);
						    		
						    		if(p.getLocation().getY() < 0){
						    			p.teleport(arena.getMap().getSpectatorLocation());
						    		}
						    	}
						    }.runTaskLater(Start.getInstance(), 1);
							break;
						case GHOST_ATTACK:
							break;
						case SKYWARS:
							arena.getPlayers().remove(omp);
							arena.getDeadPlayers().add(omp);
							arena.getSpectators().add(omp);
							
							p.setAllowFlight(true);
							p.setFlying(true);
						    ((CraftPlayer) p).getHandle().setInvisible(true);
						    
							if(p.getKiller() instanceof Player || omp.getSWPlayer().getLastProjectile() != null){
								Player pK = null;
								OMPlayer ompK = null;
								if(p.getKiller() instanceof Player){
									pK = p.getKiller();
									ompK = OMPlayer.getOMPlayer(pK);
								}
								else{
									ompK = omp.getSWPlayer().getLastProjectile();
									pK = ompK.getPlayer();
								}
								SkywarsPlayer swpK = ompK.getSWPlayer();
								
								if(p.getKiller() instanceof Player){
									if(new Random().nextBoolean()){
										arena.sendMessage(omp.getName() + "§7 was killed by " + ompK.getName() + "§7.");
									}
									else{
										arena.sendMessage(omp.getName() + "§7 was slaughtered by " + ompK.getName() + "§7.");
									}
								}
								else{
									arena.sendMessage(omp.getName() + "§7 was thrown in the void by " + ompK.getName() + "§7.");
								}
								
								pK.sendMessage("§2§l+1 Kill");
								pK.sendMessage("§f§l+1 Ticket");
								
								ActionBar ab = new ActionBar("§2+1 Kill§7, §f+1 Ticket");
								ab.send(pK);
								
								int kills = swpK.getRoundKills();
								swpK.addRoundKill();
								swpK.addKill();
								omp.addMGTickets(1);
								pK.sendMessage("§f§lCurrent Streak: §c§l" + (kills +1) + " §f§lBest Streak: §c§l" + swpK.getBeststreak());
								if(swpK.getBeststreak() < kills +1){
									swpK.setBeststreak(kills +1);
									
									pK.sendMessage("§f§lNew Best Streak: §c§l" + (kills +1));
									pK.playSound(pK.getLocation(), Sound.LEVEL_UP, 5, 1);
								}
							}
							else{
								if(p.getLocation().getY() < 0){
									arena.sendMessage(omp.getName() + "§7 fell into the void.");
								}
								else{
									arena.sendMessage(omp.getName() + "§7 died.");
								}
							}
							
						    if(arena.getPlayers().size() == 1){
						    	arena.getSW().setSecondPlace(omp);
						    	arena.getSW().ending();
						    }
						    else if(arena.getPlayers().size() == 2){
						    	arena.getSW().setThirdPlace(omp);
						    }
						    else{}
						    
						    new BukkitRunnable(){
						    	public void run(){
						    		Kit.getKit("Spectator").setItems(p);
						    		
						    		if(p.getLocation().getY() < 0){
						    			p.teleport(arena.getMap().getSpectatorLocation());
						    		}
						    	}
						    }.runTaskLater(Start.getInstance(), 1);
							break;
						case SPLATCRAFT:
							break;
						case SPLEEF:
							break;
						case SURVIVAL_GAMES:
							arena.getPlayers().remove(omp);
							arena.getDeadPlayers().add(omp);
							arena.getSpectators().add(omp);
							
							omp.clearPotionEffects();
							
							p.setAllowFlight(true);
							p.setFlying(true);
						    ((CraftPlayer) p).getHandle().setInvisible(true);
						    
							if(p.getKiller() instanceof Player){
								Player pK = p.getKiller();
								OMPlayer ompK = OMPlayer.getOMPlayer(pK);
								SurvivalGamesPlayer sgpK = ompK.getSGPlayer();
								
								if(new Random().nextBoolean()){
									arena.sendMessage(omp.getName() + "§7 was killed by " + ompK.getName() + "§7.");
								}
								else{
									arena.sendMessage(omp.getName() + "§7 was slaughtered by " + ompK.getName() + "§7.");
								}
								
								pK.sendMessage("§2§l+1 Kill");
								pK.sendMessage("§f§l+1 Ticket");
								
								ActionBar ab = new ActionBar("§2+1 Kill§7, §f+1 Ticket");
								ab.send(pK);
								
								int kills = sgpK.getRoundKills();
								sgpK.addRoundKill();
								sgpK.addKill();
								omp.addMGTickets(1);
								pK.sendMessage("§f§lCurrent Streak: §c§l" + (kills +1) + " §f§lBest Streak: §c§l" + sgpK.getBeststreak());
								if(sgpK.getBeststreak() < kills +1){
									sgpK.setBeststreak(kills +1);
									
									pK.sendMessage("§f§lNew Best Streak: §c§l" + (kills +1));
									pK.playSound(pK.getLocation(), Sound.LEVEL_UP, 5, 1);
								}
							}
							else{
								arena.sendMessage(omp.getName() + "§7 died.");
							}
							
						    if(arena.getPlayers().size() == 1){
						    	arena.getSG().setSecondPlace(omp);
						    	arena.getSG().ending();
						    }
						    else if(arena.getPlayers().size() == 2){
						    	arena.getSG().setThirdPlace(omp);
						    }
						    else{}
						    
						    if(!arena.getSG().isInDeathMatch() && arena.getMinutes() != 0 && arena.getPlayers().size() != 1 && arena.getPlayers().size() <= 3){
						    	arena.setMinutes(1);
						    	arena.setSeconds(0);
						    	
								arena.playSound(Sound.WITHER_DEATH, 5, 1);
								arena.sendMessage("§c§lDeathmatch starting in §f§l1m 0s§c§l!");
						    }
						    
						    new BukkitRunnable(){
						    	public void run(){
						    		Kit.getKit("Spectator").setItems(p);
						    	}
						    }.runTaskLater(Start.getInstance(), 1);
							break;
						case ULTRA_HARD_CORE:
							arena.getPlayers().remove(omp);
							arena.getDeadPlayers().add(omp);
							arena.getSpectators().add(omp);
							
							p.setAllowFlight(true);
							p.setFlying(true);
						    ((CraftPlayer) p).getHandle().setInvisible(true);
						    
							if(p.getKiller() instanceof Player){
								Player pK = p.getKiller();
								OMPlayer ompK = OMPlayer.getOMPlayer(pK);
								UHCPlayer uhcK = ompK.getUHCPlayer();
								
								if(new Random().nextBoolean()){
									arena.sendMessage(omp.getName() + "§7 was killed by " + ompK.getName() + "§7.");
								}
								else{
									arena.sendMessage(omp.getName() + "§7 was slaughtered by " + ompK.getName() + "§7.");
								}
								
								pK.sendMessage("§2§l+1 Kill");
								pK.sendMessage("§f§l+2 Tickets");
								
								ActionBar ab = new ActionBar("§2+1 Kill§7, §f+2 Tickets");
								ab.send(pK);
								
								int kills = uhcK.getRoundKills();
								uhcK.addRoundKill();
								uhcK.addKill();
								omp.addMGTickets(2);
								pK.sendMessage("§f§lCurrent Streak: §c§l" + (kills +1) + " §f§lBest Streak: §c§l" + uhcK.getBeststreak());
								if(uhcK.getBeststreak() < kills +1){
									uhcK.setBeststreak(kills +1);
									
									pK.sendMessage("§f§lNew Best Streak: §c§l" + (kills +1));
									pK.playSound(pK.getLocation(), Sound.LEVEL_UP, 5, 1);
								}
							}
							else{
								arena.sendMessage(omp.getName() + "§7 died.");
							}
							
						    if(arena.getPlayers().size() == 1){
						    	arena.getUHC().setSecondPlace(omp);
						    	arena.getUHC().ending();
						    }
						    else if(arena.getPlayers().size() == 2){
						    	arena.getUHC().setThirdPlace(omp);
						    }
						    else{}
						    
						    new BukkitRunnable(){
						    	public void run(){
						    		Kit.getKit("Spectator").setItems(p);
						    	}
						    }.runTaskLater(Start.getInstance(), 1);
							break;
					}
				}
			}
		}
		else{}
	}
}
