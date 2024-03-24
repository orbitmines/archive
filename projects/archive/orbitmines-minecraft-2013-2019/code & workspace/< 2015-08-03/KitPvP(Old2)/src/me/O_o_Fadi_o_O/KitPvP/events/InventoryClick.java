package me.O_o_Fadi_o_O.KitPvP.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.BoosterInv;
import me.O_o_Fadi_o_O.KitPvP.KitSelector;
import me.O_o_Fadi_o_O.KitPvP.LobbyItems;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.TeleporterInv;
import me.O_o_Fadi_o_O.KitPvP.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.util.Vector;

public class InventoryClick implements Listener{
	
	Start plugin;
		 
	public InventoryClick(Start instance) {
		plugin = instance;
	}
		
	private KitSelector kitselector = new KitSelector(this.plugin);
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 1;
	private Map<String, Long> lastUsage2 = new HashMap<String, Long>();
	private final int cdtime2 = 1;
	private Map<String, Long> lastUsage3 = new HashMap<String, Long>();
	private final int cdtime3 = 5;
	private Map<String, Long> lastUsage4 = new HashMap<String, Long>();
	private final int cdtime4 = 20;
	private Map<String, Long> lastUsage5 = new HashMap<String, Long>();
	private final int cdtime5 = 120;
	private final int cdtime6 = 100;
	private Map<String, Long> lastUsage7 = new HashMap<String, Long>();
	private final int cdtime7 = 7;
	private Map<String, Long> lastUsage8 = new HashMap<String, Long>();
	private final int cdtime8 = 5;
	private Map<String, Long> lastUsage9 = new HashMap<String, Long>();
	private final int cdtime9 = 40;
	private Map<String, Long> lastUsage10 = new HashMap<String, Long>();
	private final int cdtime10 = 30;
	
	private Map<String, Long> lastUsage11 = new HashMap<String, Long>();
	private final int cdtime11 = 5;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		
		Action a = e.getAction();
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();	
		
		ItemStack h = p.getItemInHand();
		
		if(!StorageManager.PlayerKitSelected.containsKey(p)){
			if(StorageManager.Spectators.contains(p)){
				if(!PlayerManager.isInOPMode(p)){
					e.setCancelled(true);
				}
			}
			if(h.getType() == Material.ENDER_PEARL){
				
				if(PlayerManager.isLoaded(p)){
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(Start.sinv.getServerSelectorInv(p, 1));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
				
				e.setCancelled(true);
				p.updateInventory();
			}
			if(h.getType() == Material.GOLD_NUGGET){
				
				if(PlayerManager.isLoaded(p)){
					p.openInventory(BoosterInv.getBoostersInv(p));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
				
				e.setCancelled(true);
				p.updateInventory();
			}
			if(h.getType() == Material.EXP_BOTTLE){
				if(PlayerManager.isLoaded(p)){
					p.sendMessage("§a§oComing Soon...");
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
				
				e.setCancelled(true);
				p.updateInventory();
			}
			if(h.getType() == Material.ENDER_CHEST){
				if(PlayerManager.isLoaded(p)){
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					p.openInventory(CosmeticPerks.getCosmeticPerks(p));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
				
				e.setCancelled(true);
				p.updateInventory();
			}
			if(h.getType() == Material.DIAMOND_CHESTPLATE){
				if(PlayerManager.isLoaded(p)){
					p.sendMessage(Start.TAG + "Opening the §bKit Selector§7...");
					p.openInventory(kitselector.getKitSelector(p));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
				
				e.setCancelled(true);
				p.updateInventory();
			}
		}
		else{
			if(a == Action.PHYSICAL && b.getType().getId() == 59){
				e.setCancelled(true);
			}
		}
		
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(b != null && b.getType() == Material.CHEST){
					if(!PlayerManager.isInOPMode(p)){
						e.setCancelled(true);
					}
				}
				if(h.getType() == Material.NAME_TAG && h.getItemMeta().getDisplayName().equals("§e§nTeleporter")){
					e.setCancelled(true);
					p.updateInventory();
					
					if(StorageManager.Spectators.contains(p)){
						p.openInventory(TeleporterInv.getTeleporterInv(p));
					}
					
				}
				if(h.getType() == Material.ENDER_PEARL && h.getItemMeta().getDisplayName().equals("§3§nBack to the Lobby")){
					
					if(StorageManager.Spectators.contains(p)){
						StorageManager.Spectators.remove(p);
						p.teleport(StorageManager.spawnLocation);
						Start.clearInventory(p);
						LobbyItems.giveItems(p);
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
						p.setFlying(false);
						p.setAllowFlight(false);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							player.showPlayer(p);
						}
					}
					e.setCancelled(true);
					p.updateInventory();
					
				}
				if(h.getType() == Material.SNOW_BALL){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(h != null && h.getType() == Material.BLAZE_ROD && h.getItemMeta().getLore().contains("§7Fire Spell I")){
					
					long lastUsed = 0;
					if(lastUsage.containsKey(p.getName())){
						lastUsed = lastUsage.get(p.getName());
					}
					int cdmillis = cdtime * 1000;
					
					if(System.currentTimeMillis()-lastUsed>=cdmillis){
						FallingBlock block1 = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.FIRE, (byte) 0);
						
						block1.setVelocity(p.getLocation().getDirection().multiply(1.1));
						block1.setDropItem(false);
						
						Vector velocity = block1.getVelocity();
						double speed = velocity.length();
						Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
						double spray = 5D;
						
						for (int i = 0; i < 2; i++) {
							FallingBlock block = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.FIRE, (byte) 0);
							
						  	block.setVelocity(new Vector(direction.getX() + (Math.random() - 1.5) / spray, direction.getY() + (Math.random() - 1.5) / spray, direction.getZ() + (Math.random() - 1.5) / spray).normalize().multiply(speed));
							block.setDropItem(false);
						}
						
						lastUsage.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft + "s§7 before using the §cFire Wand§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.BREWING_STAND_ITEM && h.getItemMeta().getLore().contains("§7Potion Launcher I")){
					
					long lastUsed11 = 0;
					if(lastUsage11.containsKey(p.getName())){
						lastUsed11 = lastUsage11.get(p.getName());
					}
					int cdmillis11 = cdtime11 * 1000;
						
					if(System.currentTimeMillis()-lastUsed11>=cdmillis11){
						
						Potion po = new Potion(PotionType.INSTANT_DAMAGE, 1);
						po.setSplash(true);
						ItemStack item = new ItemStack(Material.POTION, 1);
						po.apply(item);
						
						ThrownPotion sp = p.launchProjectile(ThrownPotion.class);
						sp.setItem(item);
						
						sp.setVelocity(p.getLocation().getDirection().multiply(2));
						
						lastUsage11.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft11 = (int) (cdtime11-((System.currentTimeMillis()-lastUsed11)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft11 + "s§7 before using the §ePotion Launcher§7 again.");
					}
					
					e.setCancelled(true);
					p.updateInventory();
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.BLAZE_ROD && h.getItemMeta().getLore().contains("§7Fire Spell II")){
					
					long lastUsed2 = 0;
					if(lastUsage2.containsKey(p.getName())){
						lastUsed2 = lastUsage2.get(p.getName());
					}
					int cdmillis2 = cdtime2 * 1000;
						
					if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
						FallingBlock block1 = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.FIRE, (byte) 0);
						
						block1.setVelocity(p.getLocation().getDirection().multiply(1.1));
						block1.setDropItem(false);
						
						Vector velocity = block1.getVelocity();
						double speed = velocity.length();
						Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
						double spray = 5D;
						
						for (int i = 0; i < 7; i++) {
							FallingBlock block = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.FIRE, (byte) 0);
							
						  	block.setVelocity(new Vector(direction.getX() + (Math.random() - 1.5) / spray, direction.getY() + (Math.random() - 1.5) / spray, direction.getZ() + (Math.random() - 1.5) / spray).normalize().multiply(speed));
							block.setDropItem(false);
						
						}
						
						lastUsage2.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft2 = (int) (cdtime2-((System.currentTimeMillis()-lastUsed2)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft2 + "s§7 before using the §cFire Wand§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.STICK && h.getItemMeta().getLore().contains("§7Wither I")){
					
					ItemStack soul = new ItemStack(Material.REDSTONE, 1);
					ItemMeta soulmeta = soul.getItemMeta();
					soulmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §cSoul");
					soul.setItemMeta(soulmeta);
					
					if(p.getInventory().containsAtLeast(soul, 1)){
					
						long lastUsed3 = 0;
						if(lastUsage3.containsKey(p.getName())){
							lastUsed3 = lastUsage3.get(p.getName());
						}
						int cdmillis3 = cdtime3 * 1000;
						
						if(System.currentTimeMillis()-lastUsed3>=cdmillis3){
							p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 4, 2);
							Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(1)).toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
							WitherSkull wither = p.getWorld().spawn(loc, WitherSkull.class);
							wither.setShooter(p);
							wither.setVelocity(p.getEyeLocation().getDirection().multiply(1));
						
							Vector velocity = wither.getVelocity();
							double speed = velocity.length();
							Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
							double spray = 3.5D;
							 
							for (int i = 0; i < 2; i++) {
							  WitherSkull ws = p.launchProjectile(WitherSkull.class);
							  ws.setVelocity(new Vector(direction.getX() + (Math.random() - 0.5) / spray, direction.getY() + (Math.random() - 0.5) / spray, direction.getZ() + (Math.random() - 0.5) / spray).normalize().multiply(speed));
							}
							
							p.getInventory().removeItem(soul);
							p.updateInventory();
							
							lastUsage3.put(p.getName(), System.currentTimeMillis());
						}
						else{
							int timeLeft3 = (int) (cdtime3-((System.currentTimeMillis()-lastUsed3)/1000));
							p.sendMessage(Start.TAG + "Wait§6 " + timeLeft3 + "s§7 before using the §8Necromancer's Staff§7 again.");
						}
					}
					else{
						p.sendMessage(Start.TAG + "You don't have any §cSouls§7!");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.STONE_SWORD && h.getItemMeta().getLore().contains("§7Healing I") && p.isSneaking()){
				
					long lastUsed4 = 0;
					if(lastUsage4.containsKey(p.getName())){
						lastUsed4 = lastUsage4.get(p.getName());
					}
					int cdmillis4 = cdtime4 * 1000;
						
					if(System.currentTimeMillis()-lastUsed4>=cdmillis4){

						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 2));
						
						lastUsage4.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft4 = (int) (cdtime4-((System.currentTimeMillis()-lastUsed4)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft4 + "s§7 before using the §aHealing Power§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.STONE_SWORD && h.getItemMeta().getLore().contains("§7Healing II") && p.isSneaking()){
				
					long lastUsed4 = 0;
					if(lastUsage4.containsKey(p.getName())){
						lastUsed4 = lastUsage4.get(p.getName());
					}
					int cdmillis4 = cdtime4 * 1000;
						
					if(System.currentTimeMillis()-lastUsed4>=cdmillis4){

						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
						
						lastUsage4.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft4 = (int) (cdtime4-((System.currentTimeMillis()-lastUsed4)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft4 + "s§7 before using the §aHealing Power§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.LOG && h.getItemMeta().getLore().contains("§7Barrier I")){
				
					e.setCancelled(true);
					p.updateInventory();
					long lastUsed5 = 0;
					if(lastUsage5.containsKey(p.getName())){
						lastUsed5 = lastUsage5.get(p.getName());
					}
					int cdmillis5 = cdtime5 * 1000;
						
					if(System.currentTimeMillis()-lastUsed5>=cdmillis5){
						
						onBarrierLvL1(p);
						
					
						p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0));
						
						lastUsage5.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft5 = (int) (cdtime5-((System.currentTimeMillis()-lastUsed5)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft5 + "s§7 before using the §dBarrier§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.LOG && h.getItemMeta().getLore().contains("§7Barrier II")){
				
					e.setCancelled(true);
					p.updateInventory();
					long lastUsed5 = 0;
					if(lastUsage5.containsKey(p.getName())){
						lastUsed5 = lastUsage5.get(p.getName());
					}
					int cdmillis5 = cdtime6 * 1000;
						
					if(System.currentTimeMillis()-lastUsed5>=cdmillis5){
						
						onBarrierLvL1(p);
						
					
						p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1));
						
						lastUsage5.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft5 = (int) (cdtime6-((System.currentTimeMillis()-lastUsed5)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft5 + "s§7 before using the §dBarrier§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.REDSTONE_TORCH_ON && h.getItemMeta().getLore().contains("§7TNT I")){
				
					e.setCancelled(true);
					p.updateInventory();
					long lastUsed7 = 0;
					if(lastUsage7.containsKey(p.getName())){
						lastUsed7 = lastUsage7.get(p.getName());
					}
					int cdmillis7 = cdtime7 * 1000;
						
					if(System.currentTimeMillis()-lastUsed7>=cdmillis7){
						
						TNTPrimed tnt = (TNTPrimed) p.getWorld().spawn(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), TNTPrimed.class);
						tnt.setFuseTicks(15);
						tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2));
						
						lastUsage7.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft7 = (int) (cdtime7-((System.currentTimeMillis()-lastUsed7)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft7 + "s§7 before using the §4TNT Launcher§7 again.");
					}
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.COAL && h.getItemMeta().getLore().contains("§7Healing Kit I")){
				
					ItemStack coal = new ItemStack(Material.COAL, 1);
					ItemMeta coalmeta = coal.getItemMeta();
					coalmeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §1Miner Power");
					List<String> coallore = new ArrayList<String>();
					coallore.add("§7Healing Kit I");
					coalmeta.setLore(coallore);
					coal.setItemMeta(coalmeta);
					coal.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
					
					p.getInventory().removeItem(coal);
					((CraftPlayer) p).getHandle().setHealth(20);
						
				}
			}
			catch(NullPointerException exception){
						
			}
			try{
				if(h != null && h.getType() == Material.STONE_SWORD && h.getItemMeta().getLore().contains("§7Magic I") && p.isSneaking()){
				
					long lastUsed10 = 0;
					if(lastUsage10.containsKey(p.getName())){
						lastUsed10 = lastUsage10.get(p.getName());
					}
					int cdmillis10 = cdtime10 * 1000;
						
					if(System.currentTimeMillis()-lastUsed10>=cdmillis10){
						
						p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 4, 2);
						for(Entity player : p.getNearbyEntities(5, 5, 5)){
							if(player instanceof Player){
								((Player) player).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 150, 1));
								((Player) player).playSound(player.getLocation(), Sound.WITHER_SHOOT, 4, 2);
								
							}
						}
						
						lastUsage10.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft10 = (int) (cdtime10-((System.currentTimeMillis()-lastUsed10)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft10 + "s§7 before using the §5Magic Spell§7 again.");
					}
				}
			}
			catch(Exception exception){
						
			}
			try{
				if(h != null && h.getType() == Material.RAW_FISH && h.getItemMeta().getLore().contains("§7Fish Attack I")){
				
					e.setCancelled(true);
					p.updateInventory();
					long lastUsed8 = 0;
					if(lastUsage8.containsKey(p.getName())){
						lastUsed8 = lastUsage8.get(p.getName());
					}
					int cdmillis8 = cdtime8 * 1000;
						
					if(System.currentTimeMillis()-lastUsed8>=cdmillis8){
						
						p.playSound(p.getLocation(), Sound.AMBIENCE_RAIN, 4, 4);
						for(Entity player : p.getNearbyEntities(4, 4, 4)){
							if(player instanceof Player){
								((Player) player).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 2));
								((Player) player).playSound(player.getLocation(), Sound.AMBIENCE_RAIN, 4, 4);
								
							}
						}
						
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "splash", 
	                                (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), 
	                                (float) p.getLocation().getZ(), 
	                                2, 2, 2,(float) 0, 50));
						}
						
						lastUsage8.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft8 = (int) (cdtime8-((System.currentTimeMillis()-lastUsed8)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft8 + "s§7 before using the §9Fish Attack§7 again.");
					}
				}
			}
			catch(Exception exception){
						
			}
			try{
				if(h != null && h.getType() == Material.IRON_FENCE && h.getItemMeta().getLore().contains("§7Shield I")){
				
					e.setCancelled(true);
					p.updateInventory();
					long lastUsed9 = 0;
					if(lastUsage9.containsKey(p.getName())){
						lastUsed9 = lastUsage9.get(p.getName());
					}
					int cdmillis9 = cdtime9 * 1000;
						
					if(System.currentTimeMillis()-lastUsed9>=cdmillis9){
						
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 4, 1);
						p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0));		
						
						
						lastUsage9.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft9 = (int) (cdtime9-((System.currentTimeMillis()-lastUsed9)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft9 + "s§7 before using the §7Shield§7 again.");
					}
				}
			}
			catch(Exception exception){
						
			}
			try{
				if(h != null && h.getType() == Material.IRON_FENCE && h.getItemMeta().getLore().contains("§7Shield II")){
				
					e.setCancelled(true);
					p.updateInventory();
					long lastUsed9 = 0;
					if(lastUsage9.containsKey(p.getName())){
						lastUsed9 = lastUsage9.get(p.getName());
					}
					int cdmillis9 = cdtime9 * 1000;
						
					if(System.currentTimeMillis()-lastUsed9>=cdmillis9){
						
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 4, 1);
						p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 240, 1));		
						
						
						lastUsage9.put(p.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft9 = (int) (cdtime9-((System.currentTimeMillis()-lastUsed9)/1000));
						p.sendMessage(Start.TAG + "Wait§6 " + timeLeft9 + "s§7 before using the §7Shield§7 again.");
					}
				}
			}
			catch(Exception exception){
						
			}
		}
		
	}
	public void onBarrierLvL1(Player p){
		// BLOCK 1
		final Block b1 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() -2, p.getLocation().getBlockZ());
		final Material currentb1 = b1.getType();
		if(b1.isEmpty()){
			randomBlock(b1);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b1.setType(currentb1);
				}
			}, 100L);
		}
		
		// BLOCK 2
		final Block b2 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() -2, p.getLocation().getBlockZ());
		final Material currentb2 = b2.getType();
		if(b2.isEmpty()){
			randomBlock(b2);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b2.setType(currentb2);
				}
			}, 100L);
		}
		
		// BLOCK 3
		final Block b3 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() -2, p.getLocation().getBlockZ());
		final Material currentb3 = b3.getType();
		if(b3.isEmpty()){
			randomBlock(b3);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b3.setType(currentb3);
				}
			}, 100L);
		}
		
		// BLOCK 4
		final Block b4 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() -2, p.getLocation().getBlockZ() - 1);
		final Material currentb4 = b4.getType();
		if(b4.isEmpty()){
			randomBlock(b4);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b4.setType(currentb4);
				}
			}, 100L);
		}
		
		// BLOCK 5
		final Block b5 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() -2, p.getLocation().getBlockZ() - 1);
		final Material currentb5 = b5.getType();
		if(b5.isEmpty()){
			randomBlock(b5);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b5.setType(currentb5);
				}
			}, 100L);
		}
		
		// BLOCK 6
		final Block b6 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() -2, p.getLocation().getBlockZ() - 1);
		final Material currentb6 = b6.getType();
		if(b6.isEmpty()){
			randomBlock(b6);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b6.setType(currentb6);
				}
			}, 100L);
		}
		
		// BLOCK 7
		final Block b7 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() -2, p.getLocation().getBlockZ() + 1);
		final Material currentb7 = b7.getType();
		if(b7.isEmpty()){
			randomBlock(b7);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b7.setType(currentb7);
				}
			}, 100L);
		}
		
		// BLOCK 8
		final Block b8 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() -2, p.getLocation().getBlockZ() + 1);
		final Material currentb8 = b8.getType();
		if(b8.isEmpty()){
			randomBlock(b8);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b8.setType(currentb8);
				}
			}, 100L);
		}
		
		// BLOCK 9
		final Block b9 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() -2, p.getLocation().getBlockZ() + 1);
		final Material currentb9 = b9.getType();
		if(b9.isEmpty()){
			randomBlock(b9);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b9.setType(currentb9);
				}
			}, 100L);
		}
		// BLOCK 10
		final Block b10 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() +3, p.getLocation().getBlockZ());
		final Material currentb10 = b10.getType();
		if(b10.isEmpty()){
			randomBlock(b10);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b10.setType(currentb10);
				}
			}, 100L);
		}
		
		// BLOCK 11
		final Block b11 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() +3, p.getLocation().getBlockZ());
		final Material currentb11 = b11.getType();
		if(b11.isEmpty()){
			randomBlock(b11);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b11.setType(currentb11);
				}
			}, 100L);
		}
		
		// BLOCK 12
		final Block b12 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() +3, p.getLocation().getBlockZ());
		final Material currentb12 = b12.getType();
		if(b12.isEmpty()){
			randomBlock(b12);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b12.setType(currentb12);
				}
			}, 100L);
		}
		
		// BLOCK 13
		final Block b13 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() +3, p.getLocation().getBlockZ() - 1);
		final Material currentb13 = b13.getType();
		if(b13.isEmpty()){
			randomBlock(b13);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b13.setType(currentb13);
				}
			}, 100L);
		}
		
		// BLOCK 14
		final Block b14 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() +3, p.getLocation().getBlockZ() - 1);
		final Material currentb14 = b14.getType();
		if(b14.isEmpty()){
			randomBlock(b14);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b14.setType(currentb14);
				}
			}, 100L);
		}
		
		// BLOCK 15
		final Block b15 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() +3, p.getLocation().getBlockZ() - 1);
		final Material currentb15 = b15.getType();
		if(b15.isEmpty()){
			randomBlock(b15);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b15.setType(currentb15);
				}
			}, 100L);
		}
		
		// BLOCK 16
		final Block b16 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() +3, p.getLocation().getBlockZ() + 1);
		final Material currentb16 = b16.getType();
		if(b16.isEmpty()){
			randomBlock(b16);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b16.setType(currentb16);
				}
			}, 100L);
		}
		
		// BLOCK 17
		final Block b17 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() +3, p.getLocation().getBlockZ() + 1);
		final Material currentb17 = b17.getType();
		if(b17.isEmpty()){
			randomBlock(b17);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b17.setType(currentb17);
				}
			}, 100L);
		}
		
		// BLOCK 18
		final Block b18 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() +3, p.getLocation().getBlockZ() + 1);
		final Material currentb18 = b18.getType();
		if(b18.isEmpty()){
			randomBlock(b18);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b18.setType(currentb18);
				}
			}, 100L);
		}
		// BLOCK 19
		final Block b19 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() + 2);
		final Material currentb19 = b19.getType();
		if(b19.isEmpty()){
			randomBlock(b19);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b19.setType(currentb19);
				}
			}, 100L);
		}
		// BLOCK 20
		final Block b20 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() + 2);
		final Material currentb20 = b20.getType();
		if(b20.isEmpty()){
			randomBlock(b20);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b20.setType(currentb20);
				}
			}, 100L);
		}
		// BLOCK 21
		final Block b21 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() + 2);
		final Material currentb21 = b21.getType();
		if(b21.isEmpty()){
			randomBlock(b21);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b21.setType(currentb21);
				}
			}, 100L);
		}
		// BLOCK 22
		final Block b22 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ());
		final Material currentb22 = b22.getType();
		if(b22.isEmpty()){
			randomBlock(b22);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b22.setType(currentb22);
				}
			}, 100L);
		}
		// BLOCK 23
		final Block b23 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() + 1);
		final Material currentb23 = b23.getType();
		if(b23.isEmpty()){
			randomBlock(b23);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b23.setType(currentb23);
				}
			}, 100L);
		}
		// BLOCK 24
		final Block b24 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() - 1);
		final Material currentb24 = b24.getType();
		if(b24.isEmpty()){
			randomBlock(b24);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b24.setType(currentb24);
				}
			}, 100L);
		}
		// BLOCK 25
		final Block b25 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() - 2);
		final Material currentb25 = b25.getType();
		if(b25.isEmpty()){
			randomBlock(b25);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b25.setType(currentb25);
				}
			}, 100L);
		}
		// BLOCK 26
		final Block b26 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() - 2);
		final Material currentb26 = b26.getType();
		if(b26.isEmpty()){
			randomBlock(b26);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b26.setType(currentb26);
				}
			}, 100L);
		}
		// BLOCK 27
		final Block b27 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() - 2);
		final Material currentb27 = b27.getType();
		if(b27.isEmpty()){
			randomBlock(b27);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b27.setType(currentb27);
				}
			}, 100L);
		}
		// BLOCK 28
		final Block b28 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ());
		final Material currentb28 = b28.getType();
		if(b28.isEmpty()){
			randomBlock(b28);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b28.setType(currentb28);
				}
			}, 100L);
		}
		// BLOCK 29
		final Block b29 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() + 1);
		final Material currentb29 = b29.getType();
		if(b29.isEmpty()){
			randomBlock(b29);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b29.setType(currentb29);
				}
			}, 100L);
		}
		// BLOCK 30
		final Block b30 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() - 1);
		final Material currentb30 = b30.getType();
		if(b30.isEmpty()){
			randomBlock(b30);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b30.setType(currentb30);
				}
			}, 100L);
		}
		// BLOCK 31
		final Block b31 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() + 2);
		final Material currentb31 = b31.getType();
		if(b31.isEmpty()){
			randomBlock(b31);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b31.setType(currentb31);
				}
			}, 100L);
		}
		// BLOCK 32
		final Block b32 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() + 2);
		final Material currentb32 = b32.getType();
		if(b32.isEmpty()){
			randomBlock(b32);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b32.setType(currentb32);
				}
			}, 100L);
		}
		// BLOCK 33
		final Block b33 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() + 2);
		final Material currentb33 = b33.getType();
		if(b33.isEmpty()){
			randomBlock(b33);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b33.setType(currentb33);
				}
			}, 100L);
		}
		// BLOCK 34
		final Block b34 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ());
		final Material currentb34 = b34.getType();
		if(b34.isEmpty()){
			randomBlock(b34);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b34.setType(currentb34);
				}
			}, 100L);
		}
		// BLOCK 36
		final Block b36 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() + 1);
		final Material currentb36 = b36.getType();
		if(b36.isEmpty()){
			randomBlock(b36);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b36.setType(currentb36);
				}
			}, 100L);
		}
		// BLOCK 37
		final Block b37 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() - 1);
		final Material currentb37 = b37.getType();
		if(b37.isEmpty()){
			randomBlock(b37);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b37.setType(currentb37);
				}
			}, 100L);
		}
		// BLOCK 38
		final Block b38 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() - 2);
		final Material currentb38 = b38.getType();
		if(b38.isEmpty()){
			randomBlock(b38);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b38.setType(currentb38);
				}
			}, 100L);
		}
		// BLOCK 39
		final Block b39 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() - 2);
		final Material currentb39 = b39.getType();
		if(b39.isEmpty()){
			randomBlock(b39);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b39.setType(currentb39);
				}
			}, 100L);
		}
		// BLOCK 40
		final Block b40 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() - 2);
		final Material currentb40 = b40.getType();
		if(b40.isEmpty()){
			randomBlock(b40);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b40.setType(currentb40);
				}
			}, 100L);
		}
		// BLOCK 41
		final Block b41 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ());
		final Material currentb41 = b41.getType();
		if(b41.isEmpty()){
			randomBlock(b41);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b41.setType(currentb41);
				}
			}, 100L);
		}
		// BLOCK 42
		final Block b42 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() + 1);
		final Material currentb42 = b42.getType();
		if(b42.isEmpty()){
			randomBlock(b42);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b42.setType(currentb42);
				}
			}, 100L);
		}
		// BLOCK 43
		final Block b43 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() +2, p.getLocation().getBlockZ() - 1);
		final Material currentb43 = b43.getType();
		if(b43.isEmpty()){
			randomBlock(b43);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b43.setType(currentb43);
				}
			}, 100L);
		}
		// BLOCK 44
		final Block b44 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 2);
		final Material currentb44 = b44.getType();
		if(b44.isEmpty()){
			randomBlock(b44);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b44.setType(currentb44);
				}
			}, 100L);
		}
		// BLOCK 45
		final Block b45 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 2);
		final Material currentb45 = b45.getType();
		if(b45.isEmpty()){
			randomBlock(b45);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b45.setType(currentb45);
				}
			}, 100L);
		}
		// BLOCK 46
		final Block b46 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 2);
		final Material currentb46 = b46.getType();
		if(b46.isEmpty()){
			randomBlock(b46);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b46.setType(currentb46);
				}
			}, 100L);
		}
		// BLOCK 47
		final Block b47 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 2, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 2);
		final Material currentb47 = b47.getType();
		if(b47.isEmpty()){
			randomBlock(b47);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b47.setType(currentb47);
				}
			}, 100L);
		}
		
		
		
		// BLOCK 48
		final Block b48 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 2);
		final Material currentb48 = b48.getType();
		if(b48.isEmpty()){
			randomBlock(b48);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b48.setType(currentb48);
				}
			}, 100L);
		}
		// BLOCK 49
		final Block b49 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 2);
		final Material currentb49 = b49.getType();
		if(b49.isEmpty()){
			randomBlock(b49);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b49.setType(currentb49);
				}
			}, 100L);
		}
		// BLOCK 50
		final Block b50 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 2);
		final Material currentb50 = b50.getType();
		if(b50.isEmpty()){
			randomBlock(b50);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b50.setType(currentb50);
				}
			}, 100L);
		}
		// BLOCK 51
		final Block b51 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 2);
		final Material currentb51 = b51.getType();
		if(b51.isEmpty()){
			randomBlock(b51);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b51.setType(currentb51);
				}
			}, 100L);
		}
		// BLOCK 52
		final Block b52 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 3);
		final Material currentb52 = b52.getType();
		if(b52.isEmpty()){
			randomBlock(b52);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b52.setType(currentb52);
				}
			}, 100L);
		}
		// BLOCK 53
		final Block b53 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 3);
		final Material currentb53 = b53.getType();
		if(b53.isEmpty()){
			randomBlock(b53);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b53.setType(currentb53);
				}
			}, 100L);
		}
		// BLOCK 54
		final Block b54 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 3);
		final Material currentb54 = b54.getType();
		if(b54.isEmpty()){
			randomBlock(b54);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b54.setType(currentb54);
				}
			}, 100L);
		}
		// BLOCK 55
		final Block b55 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 3);
		final Material currentb55 = b55.getType();
		if(b55.isEmpty()){
			randomBlock(b55);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b55.setType(currentb55);
				}
			}, 100L);
		}
		// BLOCK 56
		final Block b56 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 3);
		final Material currentb56 = b56.getType();
		if(b56.isEmpty()){
			randomBlock(b56);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b56.setType(currentb56);
				}
			}, 100L);
		}
		// BLOCK 57
		final Block b57 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 3);
		final Material currentb57 = b57.getType();
		if(b57.isEmpty()){
			randomBlock(b57);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b57.setType(currentb57);
				}
			}, 100L);
		}
		// BLOCK 58
		final Block b58 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 3);
		final Material currentb58 = b58.getType();
		if(b58.isEmpty()){
			randomBlock(b58);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b58.setType(currentb58);
				}
			}, 100L);
		}
		// BLOCK 59
		final Block b59 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 3);
		final Material currentb59 = b59.getType();
		if(b59.isEmpty()){
			randomBlock(b59);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b59.setType(currentb59);
				}
			}, 100L);
		}
		// BLOCK 60
		final Block b60 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 3);
		final Material currentb60 = b60.getType();
		if(b60.isEmpty()){
			randomBlock(b60);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b60.setType(currentb60);
				}
			}, 100L);
		}
		// BLOCK 61
		final Block b61 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 3);
		final Material currentb61 = b61.getType();
		if(b61.isEmpty()){
			randomBlock(b61);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b61.setType(currentb61);
				}
			}, 100L);
		}
		// BLOCK 62
		final Block b62 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 3);
		final Material currentb62 = b62.getType();
		if(b62.isEmpty()){
			randomBlock(b62);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b62.setType(currentb62);
				}
			}, 100L);
		}
		// BLOCK 63
		final Block b63 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 3);
		final Material currentb63 = b63.getType();
		if(b63.isEmpty()){
			randomBlock(b63);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b63.setType(currentb63);
				}
			}, 100L);
		}
		// BLOCK 64
		final Block b64 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 3, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
		final Material currentb64 = b64.getType();
		if(b64.isEmpty()){
			randomBlock(b64);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b64.setType(currentb64);
				}
			}, 100L);
		}
		// BLOCK 65
		final Block b65 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 3, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 1);
		final Material currentb65 = b65.getType();
		if(b65.isEmpty()){
			randomBlock(b65);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b65.setType(currentb65);
				}
			}, 100L);
		}
		// BLOCK 66
		final Block b66 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 3, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 1);
		final Material currentb66 = b66.getType();
		if(b66.isEmpty()){
			randomBlock(b66);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b66.setType(currentb66);
				}
			}, 100L);
		}
		// BLOCK 67
		final Block b67 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 3, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());
		final Material currentb67 = b67.getType();
		if(b67.isEmpty()){
			randomBlock(b67);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b67.setType(currentb67);
				}
			}, 100L);
		}
		// BLOCK 68
		final Block b68 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 3, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 1);
		final Material currentb68 = b68.getType();
		if(b68.isEmpty()){
			randomBlock(b68);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b68.setType(currentb68);
				}
			}, 100L);
		}
		// BLOCK 69
		final Block b69 = p.getWorld().getBlockAt(p.getLocation().getBlockX() + 3, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 1);
		final Material currentb69 = b69.getType();
		if(b69.isEmpty()){
			randomBlock(b69);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b69.setType(currentb69);
				}
			}, 100L);
		}
		// BLOCK 70
		final Block b70 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 3, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
		final Material currentb70 = b70.getType();
		if(b70.isEmpty()){
			randomBlock(b70);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b70.setType(currentb70);
				}
			}, 100L);
		}
		// BLOCK 71
		final Block b71 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 3, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 1);
		final Material currentb71 = b71.getType();
		if(b71.isEmpty()){
			randomBlock(b71);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b71.setType(currentb71);
				}
			}, 100L);
		}
		// BLOCK 72
		final Block b72 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 3, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 1);
		final Material currentb72 = b72.getType();
		if(b72.isEmpty()){
			randomBlock(b72);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b72.setType(currentb72);
				}
			}, 100L);
		}
		// BLOCK 73
		final Block b73 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 3, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());
		final Material currentb73 = b73.getType();
		if(b73.isEmpty()){
			randomBlock(b73);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b73.setType(currentb73);
				}
			}, 100L);
		}
		// BLOCK 74
		final Block b74 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 3, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() - 1);
		final Material currentb74 = b74.getType();
		if(b74.isEmpty()){
			randomBlock(b74);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b74.setType(currentb74);
				}
			}, 100L);
		}
		// BLOCK 75
		final Block b75 = p.getWorld().getBlockAt(p.getLocation().getBlockX() - 3, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 1);
		final Material currentb75 = b75.getType();
		if(b75.isEmpty()){
			randomBlock(b75);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					
					b75.setType(currentb75);
				}
			}, 100L);
		}
	}
	public void randomBlock(Block b){
        Random Block = new Random();
        int BlockInt;
        
        for(int BlockCount = 1; BlockCount <= 1; BlockCount++){
        	BlockInt = 1 + Block.nextInt(2);
        	
        	if(BlockInt == 1){
        		b.setType(Material.LEAVES);
        	}
        	else if(BlockInt == 2){
        		b.setType(Material.LOG);
        	}
        }
	}
}
