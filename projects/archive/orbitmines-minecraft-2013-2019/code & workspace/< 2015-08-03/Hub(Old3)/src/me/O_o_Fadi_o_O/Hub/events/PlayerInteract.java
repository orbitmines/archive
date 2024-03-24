package me.O_o_Fadi_o_O.Hub.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.Inv.Settings;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.TitleManager;
import me.O_o_Fadi_o_O.Hub.utils.Pet;
import me.O_o_Fadi_o_O.Hub.utils.VIPRank;
import net.minecraft.server.v1_8_R1.AttributeInstance;
import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.GenericAttributes;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftFirework;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayerInteract implements Listener{
	
	Hub hub = Hub.getInstance();
	 
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 6;
	
	private Map<String, Long> lastUsage2 = new HashMap<String, Long>();
	private final int cdtime2 = 7;
	
	private Map<String, Long> lastUsage3 = new HashMap<String, Long>();
	private final int cdtime3 = 4;
	
	private Map<String, Long> LastUsedInkBomb = new HashMap<String, Long>();
	private final int CooldownInkBomb = 3;
	
	private Map<String, Long> LastUsedWebs = new HashMap<String, Long>();
	private final int CooldownWebs = 4;
	
	private Map<String, Long> LastUsedSpiderLauncher = new HashMap<String, Long>();
	private final int CooldownSpiderLauncher = 2;
	
	private Map<String, Long> LastUsedBabyFirework = new HashMap<String, Long>();
	private final int CooldownBabyFirework = 1;
	
	private Map<String, Long> LastUsedBark = new HashMap<String, Long>();
	private final int CooldownBark = 3;
	
	private Map<String, Long> LastUsedMilkExplosion = new HashMap<String, Long>();
	private final int CooldownMilkExplosion = 4;
	
	private Map<String, Long> LastUsedSilverfishBomb = new HashMap<String, Long>();
	private final int CooldownSilverfishBomb = 6;
	
	private Map<String, Long> LastUsedLeap = new HashMap<String, Long>();
	private final int CooldownLeap = 4;
	
	private Map<String, Long> LastUsedKittyCannon = new HashMap<String, Long>();
	private final int CooldownKittyCannon = 1;
	
	private Map<String, Long> LastUsedSuperJump = new HashMap<String, Long>();
	private final int CooldownSuperJump = 5;
	
	private Map<String, Long> LastUsedSnowGolemAttack = new HashMap<String, Long>();
	private final int CooldownSnowGolemAttack = 180;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
		
		ItemStack i = e.getItem();
		final Block b = e.getClickedBlock();
		Action a = e.getAction();
			
		if(StorageManager.afk.containsKey(p)){
			if(StorageManager.afk.get(p).equals("")){
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7.");
			}
			else{
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7. (§7" + StorageManager.afk.get(p) + "§7)");
			}
			StorageManager.afk.remove(p);
		}
		
		if(!p.getWorld().getName().equals(StorageManager.builderworld.getName())){
			
			if(b != null && b.getType() == Material.WALL_SIGN){
				if(b.getLocation().getBlockX() == -18 && b.getLocation().getBlockZ() == 2){
					p.kickPlayer("§6§lOrbitMines§4§lNetwork §8- §7Well that's unfortunate. :)");
				}
			}
			
			if(StorageManager.playersinmindcraft.contains(p)){
				if(i != null && i.getItemMeta() != null && i.getItemMeta().getDisplayName() != null){
					if(i.getType() == Material.TNT && i.getItemMeta().getDisplayName().equals("§4§lReset Colors")){
						
						p.playSound(p.getLocation(), Sound.EXPLODE, 5, 1);
						
						List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
						String newturn = "0|0|0|0";
						blocksfromturn.set(0, newturn);
						
						List<Block> blocks = StorageManager.mindcraftblocksforturn.get(0);
						
						for(Block bl : blocks){
							p.sendBlockChange(bl.getLocation(), Material.WOOL, (byte) 0);
						}
					}
					if(i.getType() == Material.REDSTONE_TORCH_ON && i.getItemMeta().getDisplayName().equals("§c§lEnd Turn")){
						
						List<String> blocksfromturn = new ArrayList<String>();
						for(String s : StorageManager.mindcraftblocksfromturns.get(p)){
							blocksfromturn.add(s);
						}
						
						String newturnnext = blocksfromturn.get(0);
						if(!newturnnext.contains("0")){
						
							List<String> blockstatusfromturn = new ArrayList<String>();
							
							for(String s : StorageManager.mindcraftstatusfromturns.get(p)){
								blockstatusfromturn.add(s);
							}
							
							int currentturn = StorageManager.mindcraftcurrentturn.get(p);
							String newturn = "0|0|0|0";
							
							blocksfromturn.set(0, newturn);
							blocksfromturn.set(currentturn, newturnnext);
							
							StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
							
							String[] correctturn = StorageManager.mindcraftcorrectturn.get(p).split("\\|");
							String[] thisturn = newturnnext.split("\\|");
							
							List<String> correctturnints = new ArrayList<String>();
							
							for(String s : correctturn){
								correctturnints.add(s);
							}
							
							List<String> thisturnints = new ArrayList<String>();
							
							for(String s : thisturn){
								thisturnints.add(s);
							}
							
							String status = "";
							int correct = 0;
							int otherplace = 0;
							int incorrect = 0;
							
							for(int iR = 3; iR > -1; iR--){
								if(correctturnints.get(iR).equals(thisturnints.get(iR))){
									correct++;
									correctturnints.set(iR, "0");
								}
							}
							for(int iR = 3; iR > -1; iR--){
								if(correctturnints.contains(thisturnints.get(iR))){
									otherplace++;
									correctturnints.set(iR, "0");
								}
								else{
									if(!correctturnints.get(iR).equals("0")){
										incorrect++;
									}
								}
							}
							
							if(correct + otherplace + incorrect == 5){
								otherplace--;
							}
							
							if(correct != 0){
								for(int iR = 0; iR < correct; iR++){
									status = status + "|" + "5";
								}
							}
							if(otherplace != 0){
								for(int iR = 0; iR < otherplace; iR++){
									status = status + "|" + "4";
								}
							}
							if(incorrect != 0){
								for(int iR = 0; iR < incorrect; iR++){
									status = status + "|" + "0";
								}
							}
							
							status = status.substring(1);
							
							blockstatusfromturn.set(currentturn, status);
							StorageManager.mindcraftstatusfromturns.put(p, blockstatusfromturn);
							
							StorageManager.mindcraftcurrentturn.put(p, currentturn +1);
							
							List<Block> blocks = StorageManager.mindcraftblocksforturn.get(0);
							List<Block> blocks2 = StorageManager.mindcraftblocksforturn.get(currentturn);
							
							for(Block bl : blocks){
								p.sendBlockChange(bl.getLocation(), Material.WOOL, (byte) 0);
							}
							for(Block bl : blocks2){
								p.sendBlockChange(bl.getLocation(), Material.WOOL, (byte) Integer.parseInt(thisturn[blocks2.indexOf(bl)]));
							}
							
							if(StorageManager.mindcraftcorrectturn.get(p).equals(newturnnext)){
								p.getInventory().clear();
								p.sendMessage("§c§lMindCraft §8| §7You guessed the color combination!");
								p.sendMessage("§c§lMindCraft §8| §c§l+1 Win");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
								
								blocksfromturn.set(11, StorageManager.mindcraftcorrectturn.get(p));
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);		
								
								DatabaseManager.addMindCraftWins(p);
								
								if(StorageManager.mindcraftbestgame.containsKey(p)){
									if(currentturn < StorageManager.mindcraftbestgame.get(p)){
										DatabaseManager.setMindCraftBestGame(p, currentturn);
									}
								}
								else{
									DatabaseManager.insertInt(p.getName(), "MindCraft-BestGame", "turns", currentturn);
								}
								
								//Location l = p.getLocation();
								
						       // FireworkEffect.Builder builder = FireworkEffect.builder();
						        
						        //FireworkEffect effect = builder.flicker(true).trail(true).withColor(Color.NAVY).withColor(Color.GREEN).withFade(Color.GRAY).withFade(Color.BLACK).with(FireworkEffect.Type.STAR).build();
		
						       // CustomFirework.spawn(l, effect, Bukkit.getOnlinePlayers());
						        
								TitleManager.setTitle(p, "§c§lMindCraft", "§7You won! §c+1 Win");
								
								p.getInventory().clear();
								p.updateInventory();
								
								new BukkitRunnable(){
									public void run(){
										
										StorageManager.playersinmindcraft.remove(p);
										StorageManager.mindcraftcurrentturn.remove(p);
										StorageManager.mindcraftblocksfromturns.remove(p);
										StorageManager.mindcraftstatusfromturns.remove(p);
										StorageManager.mindcraftcorrectturn.remove(p);
										
									}
								}.runTaskLater(this.hub, 100);
							}
							else if(currentturn == 10){
								
								blocksfromturn.set(11, StorageManager.mindcraftcorrectturn.get(p));
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								p.sendMessage("§c§lMindCraft §8| §7You §cLost§7! Try again!");
								
								TitleManager.setTitle(p, "§c§lMindCraft", "§7You Lost! Try again!");
								
								p.getInventory().clear();
								p.updateInventory();
								
								new BukkitRunnable(){
									public void run(){
										
										StorageManager.playersinmindcraft.remove(p);
										StorageManager.mindcraftcurrentturn.remove(p);
										StorageManager.mindcraftblocksfromturns.remove(p);
										StorageManager.mindcraftstatusfromturns.remove(p);
										StorageManager.mindcraftcorrectturn.remove(p);
										
									}
								}.runTaskLater(this.hub, 100);
							}
							else{
								p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
								p.sendMessage("§c§lMindCraft §8| §7Correct: §a" + correct + " §7Other Place: §e" + otherplace + " §7Incorrect: §c" + incorrect);
							}
						}
						else{
							p.sendMessage("§c§lMindCraft §8| §7You didn't use all color slots!");
						}
					}
				}
				if(a == Action.RIGHT_CLICK_BLOCK){
					List<Block> blocks = StorageManager.mindcraftblocksforturn.get(0);
					if(blocks.contains(b)){
						if(i != null && i.getItemMeta() != null && i.getItemMeta().getDisplayName() != null){
							if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().equals("§1§lBlue")){
								e.setCancelled(true);
								p.updateInventory();
								
								List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturn.get(0);
								
								String[] turnblocks = turn.split("\\|");
								
								turnblocks[blocks.indexOf(b)] = "11";
								
								String newturn = "";
								
								for(String s : turnblocks){
									newturn = newturn + "|"+ s;
								}
								
								newturn = newturn.substring(1);
								
								blocksfromturn.set(0, newturn);
								
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								new BukkitRunnable(){
									public void run(){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 11);
									}
								}.runTaskLater(this.hub, 1);
							}
							if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().equals("§e§lYellow")){
								e.setCancelled(true);
								p.updateInventory();
								
								List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturn.get(0);
								
								String[] turnblocks = turn.split("\\|");
								
								turnblocks[blocks.indexOf(b)] = "4";
								
								String newturn = "";
								
								for(String s : turnblocks){
									newturn = newturn + "|"+ s;
								}
								
								newturn = newturn.substring(1);
								
								blocksfromturn.set(0, newturn);
								
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								new BukkitRunnable(){
									public void run(){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 4);
									}
								}.runTaskLater(this.hub, 1);
							}
							if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().equals("§a§lGreen")){
								e.setCancelled(true);
								p.updateInventory();
								
								List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturn.get(0);
								
								String[] turnblocks = turn.split("\\|");
								
								turnblocks[blocks.indexOf(b)] = "5";
								
								String newturn = "";
								
								for(String s : turnblocks){
									newturn = newturn + "|"+ s;
								}
								
								newturn = newturn.substring(1);
								
								blocksfromturn.set(0, newturn);
								
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								new BukkitRunnable(){
									public void run(){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 5);
									}
								}.runTaskLater(this.hub, 1);
							}
							if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().equals("§c§lRed")){
								e.setCancelled(true);
								p.updateInventory();
								
								List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturn.get(0);
								
								String[] turnblocks = turn.split("\\|");
								
								turnblocks[blocks.indexOf(b)] = "14";
								
								String newturn = "";
								
								for(String s : turnblocks){
									newturn = newturn + "|"+ s;
								}
								
								newturn = newturn.substring(1);
								
								blocksfromturn.set(0, newturn);
								
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								new BukkitRunnable(){
									public void run(){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 14);
									}
								}.runTaskLater(this.hub, 1);
							}
							if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().equals("§b§lLight Blue")){
								e.setCancelled(true);
								p.updateInventory();
								
								List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturn.get(0);
								
								String[] turnblocks = turn.split("\\|");
								
								turnblocks[blocks.indexOf(b)] = "3";
								
								String newturn = "";
								
								for(String s : turnblocks){
									newturn = newturn + "|"+ s;
								}
								
								newturn = newturn.substring(1);
								
								blocksfromturn.set(0, newturn);
								
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								new BukkitRunnable(){
									public void run(){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 3);
									}
								}.runTaskLater(this.hub, 1);
							}
							if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().equals("§6§lOrange")){
								e.setCancelled(true);
								p.updateInventory();
								
								List<String> blocksfromturn = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturn.get(0);
								
								String[] turnblocks = turn.split("\\|");
								
								turnblocks[blocks.indexOf(b)] = "1";
								
								String newturn = "";
								
								for(String s : turnblocks){
									newturn = newturn + "|"+ s;
								}
								
								newturn = newturn.substring(1);
								
								blocksfromturn.set(0, newturn);
								
								StorageManager.mindcraftblocksfromturns.put(p, blocksfromturn);
								
								new BukkitRunnable(){
									public void run(){
										p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 1);
									}
								}.runTaskLater(this.hub, 1);
							}
						}
					}
				}
			}
			
			try{
				if(i != null){
					if(StorageManager.loaded.get(p) == true){
						if(StorageManager.opmodeenabled.get(p) == false && i != null && i.getType() != Material.WRITTEN_BOOK){
							e.setCancelled(true);
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
						e.setCancelled(true);
						p.updateInventory();
					}
					if(i.getType() == Material.PUMPKIN && i.getItemMeta().getDisplayName().equals("§6§nSnowman Attack")){
						e.setCancelled(true);
						p.updateInventory();
						
						if(StorageManager.loaded.get(p)){
							long LastUsageSnowGolemAttack = 0;
							if(LastUsedSnowGolemAttack.containsKey(p.getName())){
								LastUsageSnowGolemAttack = LastUsedSnowGolemAttack.get(p.getName());
							}
							int cooldown = CooldownSnowGolemAttack * 1000;
									
							if(System.currentTimeMillis()-LastUsageSnowGolemAttack>=cooldown){
								
								ItemStack item = new ItemStack(Material.PUMPKIN, 1);
								ItemMeta meta = item.getItemMeta();
								meta.setDisplayName("" + p.getName());
								item.setItemMeta(meta);
								
								Item iEn = p.getWorld().dropItem(p.getLocation(), item);
								iEn.setVelocity(p.getLocation().getDirection().multiply(0.5));
								
								StorageManager.snowgolemattackseconds.put(p, 0);
								StorageManager.snowgolemattackitem.put(p, iEn);
								
								Bukkit.broadcastMessage(PlayerManager.getPlayerDisplayname(p) + "§7 summoned a §6§lSnowman Attack§7!");
								for(Player player : Bukkit.getOnlinePlayers()){
									player.playSound(p.getLocation(), Sound.WITHER_SPAWN, 5, 1);
								}
								
								LastUsedSnowGolemAttack.put(p.getName(), System.currentTimeMillis());
							}
						}
						else{
							PlayerManager.warnPlayerNotLoaded(p);
						}
					}
					if(i.getType() == Material.EGG && i.getItemMeta().getDisplayName().equals("§7§nEgg Bomb")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Egg egg = (Egg) p.launchProjectile(Egg.class);
						StorageManager.eggbombs.add(egg);
		
					}
					if(i.getType() == Material.RAW_CHICKEN && i.getItemMeta().getDisplayName().equals("§c§nChange Age")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Chicken c = (Chicken) en;
						
						if(c.isAdult()){
							c.setBaby();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.chickenpet.get(p) +"'s§7 Age§7 to a §7§lBaby§7!");
							i.setAmount(1);
						}
						else{
							c.setAdult();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.chickenpet.get(p) +"'s§7 Age§7 to an §7§lAdult§7!");
							i.setAmount(2);
						}
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
					}
					if(i.getType() == Material.MONSTER_EGG && i.getItemMeta().getDisplayName().startsWith("§a§nChange Type")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Creeper c = (Creeper) StorageManager.petentity.get(p);
						
						if(c.isPowered()){
							c.setPowered(false);
							ItemMeta meta = i.getItemMeta();
							meta.setDisplayName("§a§nChange Type§7 (§6§lNORMAL§7)");
							i.setItemMeta(meta);
						}
						else{
							c.setPowered(true);
							ItemMeta meta = i.getItemMeta();
							meta.setDisplayName("§a§nChange Type§7 (§e§lLIGHTNING§7)");
							i.setItemMeta(meta);
						}
						
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
					if(i.getType() == Material.TNT && i.getItemMeta().getDisplayName().equals("§c§nExplode")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Creeper c = (Creeper) StorageManager.petentity.get(p);
						
						c.getWorld().playEffect(c.getLocation(), Effect.EXPLOSION_HUGE, 4);
						c.getWorld().playSound(c.getLocation(), Sound.EXPLODE, 5, 1);
						StorageManager.petentity.remove(p);
						StorageManager.petowner.remove(c);
						StorageManager.pet.put(p, Pet.NONE);
						
						p.leaveVehicle();
						
			        	for(Entity en : c.getNearbyEntities(3, 3, 3)){
			        		
			        		if(en instanceof Player){
			        			Vector v = en.getLocation().getDirection();
			        			en.setVelocity(v.multiply(-1).add(new Vector(0, 1.3, 0)));
			        			
			        		}
			        	}
			        	
						c.remove();
					}
					if(i.getType() == Material.RAW_FISH && i.getItemMeta().getDisplayName().equals("§9§nChange Color")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Ocelot o = (Ocelot) en;
						
						org.bukkit.entity.Ocelot.Type t = o.getCatType();
						
						if(t == org.bukkit.entity.Ocelot.Type.BLACK_CAT){
							t = org.bukkit.entity.Ocelot.Type.RED_CAT;
						}
						else if(t == org.bukkit.entity.Ocelot.Type.RED_CAT){
							t = org.bukkit.entity.Ocelot.Type.SIAMESE_CAT;
						}
						else if(t == org.bukkit.entity.Ocelot.Type.SIAMESE_CAT){
							t = org.bukkit.entity.Ocelot.Type.WILD_OCELOT;
						}
						else if(t == org.bukkit.entity.Ocelot.Type.WILD_OCELOT){
							t = org.bukkit.entity.Ocelot.Type.BLACK_CAT;
						}
						
						o.setCatType(t);
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
					if(i.getType() == Material.MONSTER_EGG && i.getItemMeta().getDisplayName().equals("§e§nKitty Cannon")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageKittyCannon = 0;
						if(LastUsedKittyCannon.containsKey(p.getName())){
							LastUsageKittyCannon = LastUsedKittyCannon.get(p.getName());
						}
						int cooldown = CooldownKittyCannon * 1000;
								
						if(System.currentTimeMillis()-LastUsageKittyCannon>=cooldown){
							
							final Ocelot o = (Ocelot) p.getWorld().spawnEntity(p.getLocation(), EntityType.OCELOT);
							o.setBaby();
							o.setVelocity(p.getLocation().getDirection().multiply(2));
							o.setRemoveWhenFarAway(false);
							
							Random r = new Random();
							int rInt = r.nextInt(4);
							
							if(rInt == 1){
								o.setCatType(org.bukkit.entity.Ocelot.Type.BLACK_CAT);
							}
							else if(rInt == 2){
								o.setCatType(org.bukkit.entity.Ocelot.Type.RED_CAT);
							}
							else if(rInt == 3){
								o.setCatType(org.bukkit.entity.Ocelot.Type.SIAMESE_CAT);
							}
							else if(rInt == 4){
								o.setCatType(org.bukkit.entity.Ocelot.Type.WILD_OCELOT);
							}
							
							new BukkitRunnable(){
								public void run(){
									if(o instanceof LivingEntity){
										o.getWorld().playEffect(o.getLocation(), Effect.EXPLOSION_LARGE, 1);
										o.getWorld().playSound(o.getLocation(), Sound.EXPLODE, 5, 1);
										o.remove();
									}
								}
							}.runTaskLater(this.hub, 20);
							
							LastUsedKittyCannon.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.LEATHER && i.getItemMeta().getDisplayName().equals("§e§nChange Color")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Horse h = (Horse) en;
						
						org.bukkit.entity.Horse.Color c = h.getColor();
						
						if(c == org.bukkit.entity.Horse.Color.BLACK){
							c = org.bukkit.entity.Horse.Color.BROWN;
						}
						else if(c == org.bukkit.entity.Horse.Color.BROWN){
							c = org.bukkit.entity.Horse.Color.CHESTNUT;
						}
						else if(c == org.bukkit.entity.Horse.Color.CHESTNUT){
							c = org.bukkit.entity.Horse.Color.CREAMY;
						}
						else if(c == org.bukkit.entity.Horse.Color.CREAMY){
							c = org.bukkit.entity.Horse.Color.DARK_BROWN;
						}
						else if(c == org.bukkit.entity.Horse.Color.DARK_BROWN){
							c = org.bukkit.entity.Horse.Color.GRAY;
						}
						else if(c == org.bukkit.entity.Horse.Color.GRAY){
							c = org.bukkit.entity.Horse.Color.WHITE;
						}
						else if(c == org.bukkit.entity.Horse.Color.WHITE){
							c = org.bukkit.entity.Horse.Color.BLACK;
						}
						
						h.setColor(c);
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
					if(i.getType() == Material.FEATHER && i.getItemMeta().getDisplayName().equals("§f§nChange Speed")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Horse h = (Horse) en;
						
						int speed = i.getAmount();
						
						AttributeInstance currentSpeed = ((EntityInsentient) ((CraftLivingEntity) h).getHandle()).getAttributeInstance(GenericAttributes.d);
						
						double newSpeed = currentSpeed.b();
						
						if(speed == 3){
					        newSpeed = currentSpeed.b() / 3;
							
							speed = 1;
						}
						else if(speed == 2){
							newSpeed = (currentSpeed.b() / 2) * 3;
					        
					        speed++;
						}
						else{
							newSpeed = currentSpeed.b() * 2;
							
							speed++;
						}
						
						currentSpeed.setValue(newSpeed);
				        
						i.setAmount(speed);
						p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.horsepet.get(p) +"'s§6 Speed§7 to §6§l" + speed + "§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						
					}
					if(i.getType() == Material.STONE_HOE && i.getItemMeta().getDisplayName().equals("§8§nLeap")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageLeap = 0;
						if(LastUsedLeap.containsKey(p.getName())){
							LastUsageLeap = LastUsedLeap.get(p.getName());
						}
						int cooldown = CooldownLeap * 1000;
								
						if(System.currentTimeMillis()-LastUsageLeap>=cooldown){
						
							Silverfish s = (Silverfish) StorageManager.petentity.get(p);
							s.setVelocity(p.getLocation().getDirection().multiply(1.3).add(new Vector(0, 0.3, 0)));
							
							p.getWorld().playSound(p.getLocation(), Sound.FIREWORK_BLAST, 6, 1);
							
							LastUsedLeap.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.MONSTER_EGG && i.getItemMeta().getDisplayName().equals("§7§nSilverfish Bomb")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageSilverfishBomb = 0;
						if(LastUsedSilverfishBomb.containsKey(p.getName())){
							LastUsageSilverfishBomb = LastUsedSilverfishBomb.get(p.getName());
						}
						int cooldown = CooldownSilverfishBomb * 1000;
								
						if(System.currentTimeMillis()-LastUsageSilverfishBomb>=cooldown){
						
							ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("" + p.getName());
							item.setDurability((short) 60);
							item.setItemMeta(meta);
							Location pl = p.getLocation();
							Location l = new Location(p.getWorld(), pl.getX(), pl.getY() +1, pl.getZ());
							
							final Item iEn = p.getWorld().dropItem(l, item);
							iEn.setVelocity(p.getLocation().getDirection().multiply(1.1));
							
							StorageManager.silverfishbombs.add(iEn);
							
							LastUsedSilverfishBomb.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.WOOL && i.getItemMeta().getDisplayName().startsWith("§f§nSheep Disco")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						if(StorageManager.petsheepdisco.get(p) == true){
						
							ItemMeta meta = i.getItemMeta();
							meta.setDisplayName("§f§nSheep Disco§7 (§c§lDISABLED§7)");
							i.setItemMeta(meta);
							
							p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED§7 the §fSheep Disco§7!");
							p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
							
							StorageManager.petsheepdisco.put(p, false);
							
						}
						else{
							
							ItemMeta meta = i.getItemMeta();
							meta.setDisplayName("§f§nSheep Disco§7 (§a§lENABLED§7)");
							i.setItemMeta(meta);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED§7 the §fSheep Disco§7!");
							p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
							
							StorageManager.petsheepdisco.put(p, true);
							
						}
						
					}
					if(i.getType() == Material.INK_SACK && i.getItemMeta().getDisplayName().startsWith("§f§nChange Color")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Sheep s = (Sheep) StorageManager.petentity.get(p);
						DyeColor c = PlayerManager.getNextDyeColorForSheep(s);
						i.setDurability(c.getDyeData());
						
						s.setColor(c);
						
						ItemMeta meta = i.getItemMeta();
						meta.setDisplayName("§f§nChange Color§7 (" + PlayerManager.getColorNameFromSheep(s) + "§7)");
						i.setItemMeta(meta);
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						
					}
					if(i.getType() == Material.MILK_BUCKET && i.getItemMeta().getDisplayName().equals("§f§nMilk Explosion")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageMilkExplosion = 0;
						if(LastUsedMilkExplosion.containsKey(p.getName())){
							LastUsageMilkExplosion = LastUsedMilkExplosion.get(p.getName());
						}
						int cooldown = CooldownMilkExplosion * 1000;
								
						if(System.currentTimeMillis()-LastUsageMilkExplosion>=cooldown){
						
							ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("" + p.getName());
							item.setItemMeta(meta);
							
							final Item iEn = p.getWorld().dropItem(p.getLocation(), item);
							iEn.setVelocity(p.getLocation().getDirection().multiply(0.8));
							
							new BukkitRunnable(){
								public void run(){
									Location l = iEn.getLocation();
									
							    	Firework fw = (Firework) iEn.getWorld().spawnEntity(l.subtract(0, 1, 0), EntityType.FIREWORK);
							        FireworkMeta fwmeta = fw.getFireworkMeta();
							        FireworkEffect.Builder builder = FireworkEffect.builder();
							       
							        builder.withColor(Color.WHITE);
							        builder.withColor(Color.WHITE);
							        builder.withFade(Color.WHITE);
							        builder.with(Type.BALL_LARGE);
							        builder.withFlicker();
							        builder.withTrail();
							        
							        fwmeta.addEffects(builder.build());
							        fw.setFireworkMeta(fwmeta);
							        
							        iEn.remove();
									
							        Location l1 = new Location(iEn.getWorld(), l.getBlockX() +1, l.getBlockY() +1, l.getBlockZ() +1);
							        Location l2 = new Location(iEn.getWorld(), l.getBlockX() -1, l.getBlockY() -1, l.getBlockZ() -1);
							        
							        List<Block> blocks = hub.getBlocksBetween(l1, l2);
							        
							        for(Block b : blocks){
							        	if(!b.isEmpty() && b.getType() != Material.AIR && b.getType() != Material.SIGN_POST && b.getType() != Material.WALL_SIGN){
							        		for(Player player : Bukkit.getOnlinePlayers()){
							        			player.sendBlockChange(b.getLocation(), Material.SNOW_BLOCK, (byte) 0);
							        		}
							        		setBacktoBlock(b);
							        	}
							        }
								}
							}.runTaskLater(this.hub, 60);
							LastUsedMilkExplosion.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.RAW_BEEF && i.getItemMeta().getDisplayName().equals("§c§nChange Age")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Cow cow = (Cow) en;
						
						if(cow.isAdult()){
							cow.setBaby();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.cowpet.get(p) +"'s§8 Age§7 to a §8§lBaby§7!");
							i.setAmount(1);
						}
						else{
							cow.setAdult();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.cowpet.get(p) +"'s§8 Age§7 to an §8§lAdult§7!");
							i.setAmount(2);
						}
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
					}
					if(i.getType() == Material.BONE && i.getItemMeta().getDisplayName().equals("§7§nChange Age")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Wolf wolf = (Wolf) en;
						
						if(wolf.isAdult()){
							wolf.setBaby();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.wolfpet.get(p) +"'s§7 Age§7 to a §7§lBaby§7!");
							i.setAmount(1);
						}
						else{
							wolf.setAdult();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.wolfpet.get(p) +"'s§7 Age§7 to an §7§lAdult§7!");
							i.setAmount(2);
						}
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
					}
					if(i.getType() == Material.LEATHER_BOOTS && i.getItemMeta().getDisplayName().equals("§6§nSuper Jump")){
						
						long LastUsageSuperJump = 0;
						if(LastUsedSuperJump.containsKey(p.getName())){
							LastUsageSuperJump = LastUsedSuperJump.get(p.getName());
						}
						int cooldown = CooldownSuperJump * 1000;
								
						if(System.currentTimeMillis()-LastUsageSuperJump>=cooldown){
							
							Entity en = StorageManager.petentity.get(p);
							en.setVelocity(new Vector(0, 3, 0));
							
							LastUsedSuperJump.put(p.getName(), System.currentTimeMillis());
						}
						
					}
					if(i.getType() == Material.SLIME_BALL && i.getItemMeta().getDisplayName().equals("§a§nChange Size")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Slime s = (Slime) en;
						
						int size = i.getAmount();
						
						if(size == 3){
							size = 1;
						}
						else{
							size++;
						}
						
						i.setAmount(size);
						s.setSize(size);
						p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.slimepet.get(p) +"'s§a Size§7 to §a§l" + size + "§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
					}
					if(i.getType() == Material.MONSTER_EGG && i.getItemMeta().getDisplayName().equals("§d§nBaby Pigs§7 (§c§lDISABLED§7)")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§d§nBaby Pigs§7 (§a§lENABLED§7)");
						item.setItemMeta(meta);
						item.setDurability((short) 90);
						p.getInventory().setItem(2, item);
						
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED§7 the §dBaby Pigs§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						
						StorageManager.petbabypigs.put(p, true);
						
						Pig pig1 = (Pig) p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
						pig1.setBaby();
						pig1.setAgeLock(true);
						pig1.setRemoveWhenFarAway(false);
						
						Pig pig2 = (Pig) p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
						pig2.setBaby();
						pig2.setAgeLock(true);
						pig2.setRemoveWhenFarAway(false);
						
						List<Entity> list = new ArrayList<Entity>();
						list.add(pig1);
						list.add(pig2);
						StorageManager.petbabypigsentities.put(p, list);
						
					}
					if(i.getType() == Material.PORK && i.getItemMeta().getDisplayName().equals("§d§nChange Age")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						Pig pig = (Pig) en;
						
						if(pig.isAdult()){
							pig.setBaby();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.pigpet.get(p) +"'s§d Age§7 to a §d§lBaby§7!");
							i.setAmount(1);
						}
						else{
							pig.setAdult();
							p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.pigpet.get(p) +"'s§d Age§7 to an §d§lAdult§7!");
							i.setAmount(2);
						}
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
					}
					if(i.getType() == Material.MONSTER_EGG && i.getItemMeta().getDisplayName().equals("§d§nBaby Pigs§7 (§a§lENABLED§7)")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§d§nBaby Pigs§7 (§c§lDISABLED§7)");
						item.setItemMeta(meta);
						item.setDurability((short) 90);
						p.getInventory().setItem(2, item);
						
						p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED§7 the §dBaby Pigs§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						
						StorageManager.petbabypigs.put(p, false);
						
						for(Entity en : StorageManager.petbabypigsentities.get(p)){
							en.remove();
						}
						StorageManager.petbabypigsentities.remove(p);
						
					}
					if(i.getType() == Material.COOKED_BEEF && i.getItemMeta().getDisplayName().equals("§6§nBark")){
						
						long LastUsageBark = 0;
						if(LastUsedBark.containsKey(p.getName())){
							LastUsageBark = LastUsedBark.get(p.getName());
						}
						int cooldown = CooldownBark * 1000;
								
						if(System.currentTimeMillis()-LastUsageBark>=cooldown){
							p.getWorld().playSound(p.getLocation(), Sound.WOLF_BARK, 10, 1);
							
							for(Entity en : p.getNearbyEntities(3, 3, 3)){
								
								if(en instanceof Player){
									
									Player p2 = (Player) en;
									if(!StorageManager.playersinlapisparkour.contains(p2)){
										p2.setVelocity(p.getLocation().getDirection().subtract(p2.getLocation().getDirection()).multiply(4));
									}
								}
							}
							
							for(int iB = 0; iB < 20; iB++){
								ItemStack item = new ItemStack(Material.BONE, 1);
								ItemMeta meta = item.getItemMeta();
								meta.setDisplayName("" + iB);
								item.setItemMeta(meta);
								Item iEn = p.getWorld().dropItem(p.getLocation(), item);
								
								int iR = new Random().nextInt(2);
								
								if(iR == 0){
						            float x = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
						            float y = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
						            float z = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
						            
									iEn.setVelocity(new Vector(x, y, z));
								}
								else{
									float x = (float) -0.03 + (float) (Math.random() * - 0.3);
						            float y = (float) -0.03 + (float) (Math.random() * - 0.3);
						            float z = (float) -0.03 + (float) (Math.random() * - 0.3);
						            
									iEn.setVelocity(new Vector(x, y, z));
								}
								removeEntity(iEn);
		
							}
							
							LastUsedBark.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.MAGMA_CREAM && i.getItemMeta().getDisplayName().equals("§c§nChange Size")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						Entity en = StorageManager.petentity.get(p);
						MagmaCube mc = (MagmaCube) en;
						
						int size = i.getAmount();
						
						if(size == 3){
							size = 1;
						}
						else{
							size++;
						}
						
						i.setAmount(size);
						mc.setSize(size);
						p.sendMessage("§9Cosmetic Perks §8|§7 Changed §f" + StorageManager.magmacubepet.get(p) +"'s§c Size§7 to §c§l" + size + "§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
					}
					if(i.getType() == Material.FIREBALL && i.getItemMeta().getDisplayName().equals("§6§nFireball")){
						
						Fireball fb = (Fireball) p.launchProjectile(Fireball.class);
						
						StorageManager.fireballs.add(fb);
						
					}
					if(i.getType() == Material.HUGE_MUSHROOM_1 && i.getItemMeta().getDisplayName().equals("§4§nShroom Trail§7 (§c§lDISABLED§7)")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						ItemStack item = new ItemStack(Material.HUGE_MUSHROOM_2, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§4§nShroom Trail§7 (§a§lENABLED§7)");
						item.setItemMeta(meta);
						item.setDurability((short) 14);
						p.getInventory().setItem(2, item);
						
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED§7 the §4Shroom Trail§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						
						StorageManager.petshroomtrail.put(p, true);
						
					}
					if(i.getType() == Material.HUGE_MUSHROOM_2 && i.getItemMeta().getDisplayName().equals("§4§nShroom Trail§7 (§a§lENABLED§7)")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						ItemStack item = new ItemStack(Material.HUGE_MUSHROOM_1, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§4§nShroom Trail§7 (§c§lDISABLED§7)");
						item.setItemMeta(meta);
						item.setDurability((short) 14);
						p.getInventory().setItem(2, item);
						
						p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7the §4Shroom Trail§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						
						StorageManager.petshroomtrail.put(p, false);
					}
					if(i.getType() == Material.FIREWORK && i.getItemMeta().getDisplayName().equals("§c§nBaby Firework")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageBabyFirework = 0;
						if(LastUsedBabyFirework.containsKey(p.getName())){
							LastUsageBabyFirework = LastUsedBabyFirework.get(p.getName());
						}
						int cooldown = CooldownBabyFirework * 1000;
								
						if(System.currentTimeMillis()-LastUsageBabyFirework>=cooldown){
						
							final MushroomCow cow = (MushroomCow) p.getWorld().spawnEntity(p.getLocation(), EntityType.MUSHROOM_COW);
							cow.setAge(1);
							cow.setAgeLock(true);
							cow.setRemoveWhenFarAway(false);
							cow.setVelocity(p.getLocation().getDirection().multiply(1.2).setY(2));
							cow.setMaxHealth((double) Integer.MAX_VALUE);
							
							new BukkitRunnable(){
								public void run(){
									if(cow instanceof LivingEntity){
								    	Firework fw = (Firework) p.getWorld().spawnEntity(cow.getLocation(), EntityType.FIREWORK);
								        FireworkMeta fwmeta = fw.getFireworkMeta();
								        FireworkEffect.Builder builder = FireworkEffect.builder();
								       
								        builder.withColor(Color.RED);
								        builder.withColor(Color.RED);
								        builder.withFade(Color.RED);
								        builder.with(Type.BALL);
								        builder.withFlicker();
								        builder.withTrail();
								        
								        ((CraftFirework) fw).getHandle().expectedLifespan = 0;
								        
								        fwmeta.addEffects(builder.build());
								        fw.setFireworkMeta(fwmeta);
								        
										cow.remove();
									}
								}
							}.runTaskLater(this.hub, 30);
							LastUsedBabyFirework.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.WEB && i.getItemMeta().getDisplayName().equals("§f§nWebs")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageWebs = 0;
						if(LastUsedWebs.containsKey(p.getName())){
							LastUsageWebs = LastUsedWebs.get(p.getName());
						}
						int cooldown = CooldownWebs * 1000;
								
						if(System.currentTimeMillis()-LastUsageWebs>=cooldown){
							FallingBlock block1 = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.WEB, (byte) 0);
							
							block1.setVelocity(p.getLocation().getDirection().multiply(1.1));
							block1.setDropItem(false);
							
							Vector velocity = block1.getVelocity();
							double speed = velocity.length();
							Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
							double spray = 5D;
							
							for (int i2 = 0; i2 < 2; i2++) {
								FallingBlock block = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.WEB, (byte) 0);
								
							  	block.setVelocity(new Vector(direction.getX() + (Math.random() - 1.5) / spray, direction.getY() + (Math.random() - 1.5) / spray, direction.getZ() + (Math.random() - 1.5) / spray).normalize().multiply(speed));
								block.setDropItem(false);
							}
							LastUsedWebs.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.SPIDER_EYE && i.getItemMeta().getDisplayName().equals("§5§nSpider Launcher")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageSpiderLauncher = 0;
						if(LastUsedSpiderLauncher.containsKey(p.getName())){
							LastUsageSpiderLauncher = LastUsedSpiderLauncher.get(p.getName());
						}
						int cooldown = CooldownSpiderLauncher * 1000;
								
						if(System.currentTimeMillis()-LastUsageSpiderLauncher>=cooldown){
							
							final Spider s = (Spider) p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER);
							
							s.setVelocity(p.getLocation().getDirection().multiply(1.5));
							s.setRemoveWhenFarAway(false);
							
							new BukkitRunnable(){
								public void run(){
									if(s instanceof LivingEntity){
										s.remove();
									}
								}
							}.runTaskLater(this.hub, 80);
							
							LastUsedSpiderLauncher.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.INK_SACK && i.getItemMeta().getDisplayName().equals("§8§nInk Bomb")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						long LastUsageInkBomb = 0;
						if(LastUsedInkBomb.containsKey(p.getName())){
							LastUsageInkBomb = LastUsedInkBomb.get(p.getName());
						}
						int cooldown = CooldownInkBomb * 1000;
								
						if(System.currentTimeMillis()-LastUsageInkBomb>=cooldown){
							e.setCancelled(true);
							p.updateInventory();
							
							ItemStack item = new ItemStack(Material.INK_SACK, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§8§nInk Bomb " + p.getName());
							item.setItemMeta(meta);
							
							Item itemEn = p.getWorld().dropItem(p.getLocation(), item);
							itemEn.setVelocity(p.getLocation().getDirection().multiply(1.3));
							itemEn.setPickupDelay(Integer.MAX_VALUE);
							StorageManager.inkbombs.add(itemEn);
							StorageManager.inkbombtime.put(itemEn, 10 * 3);
							
							LastUsedInkBomb.put(p.getName(), System.currentTimeMillis());
						}
					}
					if(i.getType() == Material.WATER_BUCKET && i.getItemMeta().getDisplayName().equals("§9§nWater Spout")){
						
						e.setCancelled(true);
						p.updateInventory();
						
				        FallingBlock block = p.getWorld().spawnFallingBlock(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), Material.STAINED_GLASS, (byte) 11);
			            block.setDropItem(false);
			            
			            p.getWorld().playSound(p.getLocation(), Sound.WATER, 6, 1);
			            
			            block.setVelocity(p.getLocation().getDirection().multiply(1.1));
					}
					if(i.getType() == Material.MAGMA_CREAM && i.getItemMeta().getDisplayName().equals("§c§nMagmaCube Soccer")){
						
						if(!StorageManager.soccermagmacube.containsKey(p)){
							MagmaCube mc = (MagmaCube) p.getWorld().spawnEntity(p.getLocation(), EntityType.MAGMA_CUBE);
							mc.setSize(1);
							mc.setRemoveWhenFarAway(false);
							mc.setCustomName("§cSoccer Ball");
							mc.setCustomNameVisible(true);
							
							StorageManager.soccermagmacubes.add(mc);
							StorageManager.soccermagmacube.put(p, mc);
							
							p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED§7 your §cMagmaCube Ball§7. §eRight Click§7 to remove it, §eLeft Click§7 to shoot it.");
							p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 152);
						}
						else{
							StorageManager.soccermagmacube.get(p).teleport(p.getLocation());
							p.sendMessage("§9Cosmetic Perks §8| §7Teleported your §cMagmaCube Ball§7 to you!");
							p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 152);
						}
					}
					if(i.getType() == Material.EYE_OF_ENDER && i.getItemMeta().getDisplayName().equals("§2§nSwap Teleporter")){
						e.setCancelled(true);
						if(!StorageManager.playersinlapisparkour.contains(p)){
							if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
								long lastUsed3 = 0;
								if(lastUsage3.containsKey(p.getName())){
									lastUsed3 = lastUsage3.get(p.getName());
								}
								int cdmillis3 = cdtime3 * 1000;
										
								if(System.currentTimeMillis()-lastUsed3>=cdmillis3){
									ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
									final Entity en = p.getWorld().dropItem(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() +1, p.getLocation().getZ()), item);
									
									en.setVelocity(p.getLocation().getDirection().multiply(1.5));
									
									if(StorageManager.swapteleporter.containsValue(p)){
										for(Entity ent : StorageManager.hubworld.getEntities()){
											if(StorageManager.swapteleporter.containsKey(ent)){
												if(StorageManager.swapteleporter.get(ent) == p){
													StorageManager.swapteleporter.remove(ent);
													ent.remove();
												}
											}
										}
									}
									
									StorageManager.swapteleporter.put(en, p);
									
									new BukkitRunnable(){
										public void run(){
											if(StorageManager.swapteleporter.get(en) != null){
												StorageManager.swapteleporter.remove(en);
												en.remove();
											}
										}
									}.runTaskLater(this.hub, 100);
									
									lastUsage3.put(p.getName(), System.currentTimeMillis());
								}
							}
						}
					}
					if(i.getType() == Material.SKULL_ITEM && i.getItemMeta().getDisplayName().equals("§a§nCreeper Launcher")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						if(!StorageManager.playersinlapisparkour.contains(p)){
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
					}
					if(i.getType() == Material.SNOW_BALL && i.getItemMeta().getDisplayName().equals("§f§nPaintballs")){
						e.setCancelled(true);
						p.updateInventory();
						Snowball ball = p.launchProjectile(Snowball.class);
						StorageManager.paintballs.add(ball);
					}
					if(i.getType() == Material.BOOK && i.getItemMeta().getDisplayName().equals("§7§nBook Explosion")){
						e.setCancelled(true);
						p.updateInventory();
						
						if(!StorageManager.playersinlapisparkour.contains(p)){
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
									}.runTaskLater(this.hub, 20 * 10L);
									
									lastUsage2.put(p.getName(), System.currentTimeMillis());
								}
							}
						}
					}
					if(i.getType() == Material.FIREBALL && i.getItemMeta().getDisplayName().startsWith("§c§nFirework Gun")){
						e.setCancelled(true);
						p.updateInventory();
						if(StorageManager.fireworkpasses.get(p) >= 1){
							Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
					        FireworkMeta fwmeta = fw.getFireworkMeta();
					        FireworkEffect.Builder builder = FireworkEffect.builder();
					        if(StorageManager.fireworktrail.get(p) == true){
					        	builder.withTrail();
					        }
					        if(StorageManager.fireworkflicker.get(p) == true){
					        	builder.withFlicker();
					        }
					        if(StorageManager.fireworkfade1.get(p) != null){
					        	builder.withFade(StorageManager.fireworkfade1.get(p));
					        }
					        if(StorageManager.fireworkfade2.get(p) != null){
					        	builder.withFade(StorageManager.fireworkfade2.get(p));
					        }
					        if(StorageManager.fireworkcolor1.get(p) != null){
					        	builder.withColor(StorageManager.fireworkcolor1.get(p));
					        }
					        else{
					        	builder.withColor(Color.AQUA);
					        }
					        if(StorageManager.fireworkcolor1.get(p) != null){
					        	builder.withColor(StorageManager.fireworkcolor1.get(p));
					        }
					        if(StorageManager.fireworktype.get(p) != null){
					        	builder.with(StorageManager.fireworktype.get(p));
					        }
					        else{
					        	builder.with(Type.BALL);
					        }
					        
					        fwmeta.addEffects(builder.build());
					        fw.setFireworkMeta(fwmeta);
					        
					        fw.setVelocity(p.getLocation().getDirection().multiply(0.2));
					        
					        StorageManager.fireworkpasses.put(p, StorageManager.fireworkpasses.get(p) -1);
					        
							ItemStack item = new ItemStack(Material.FIREBALL, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§c§nFirework Gun§r §c(§6" + StorageManager.fireworkpasses.get(p) + "§c)");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(5, new ItemStack(item));
						}
						else{
							p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7You don't have any §6§lFirework Passes§7.");
						}
					}
					if(i.getType() == Material.ENDER_CHEST && i.getItemMeta().getDisplayName().equals("§9§nCosmetic Perks")){
						
						e.setCancelled(true);
						p.updateInventory();
						
						if(StorageManager.loaded.get(p) == true){
							if(!StorageManager.playersinlapisparkour.contains(p)){
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
				if(i.getType() == Material.REDSTONE_TORCH_ON && i.getItemMeta().getDisplayName().equals("§c§nSettings")){
					
					e.setCancelled(true);
					p.updateInventory();
					
					if(StorageManager.loaded.get(p) == true){
						if(!StorageManager.playersinlapisparkour.contains(p)){
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 152);
							Inventory invs = Bukkit.createInventory(null, 27, "§0§lSettings (" + p.getName() + ")");
							Settings.getSettingsInv(p, invs);
						}
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
					
				}
				if(i.getType() == Material.ENDER_PEARL && i.getItemMeta().getDisplayName().equals("§3§nServer Selector")){
					
					if(StorageManager.loaded.get(p) == true){
						if(!StorageManager.playersinlapisparkour.contains(p)){
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
							p.openInventory(ServerSelector.serverSelector);
						}
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
				
				}
				if(i.getType() == Material.ENDER_CHEST && i.getItemMeta().getDisplayName().equals("§9§nCosmetic Perks")){
					
					e.setCancelled(true);
					p.updateInventory();
					
					if(StorageManager.loaded.get(p)){
						if(!StorageManager.playersinlapisparkour.contains(p)){
							p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
							p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						}
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
					
				}
				if(i.getType() == Material.FEATHER && i.getItemMeta().getDisplayName().equals("§f§nFly")){
		
					if(StorageManager.loaded.get(p)){
						if(PlayerManager.hasVIPPerms(p, VIPRank.Iron_VIP)){
							if(!StorageManager.playersinlapisparkour.contains(p)){
								if(p.getAllowFlight() == false){
									p.playEffect(p.getLocation(), Effect.STEP_SOUND, 80);
									p.setAllowFlight(true);
									p.setFlying(true);
									p.sendMessage("§f§l§oFly §a§l§oENABLED");
								}
								else if(p.getAllowFlight() == true){
									p.playEffect(p.getLocation(), Effect.STEP_SOUND, 80);
									p.setAllowFlight(false);
									p.setFlying(false);
									p.sendMessage("§f§l§oFly §c§l§oDISABLED");
								}
							}
						}
						else{
							p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
							p.sendMessage("§f§l§oFly §8| §4§lDENIED §7Required: §7§lIron VIP§7!");
						}
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
					
				}
				if(i.getType() == Material.EXP_BOTTLE && i.getItemMeta().getDisplayName().equals("§d§nAchievements")){
		
					if(StorageManager.loaded.get(p)){
						p.sendMessage("§a§oComing Soon...");
						//TODO p.openInventory(AchievementManager.getAchievementInv(p));
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
				}
			}
		}
	}

	public void removeEntity(final Item i){
		new BukkitRunnable(){
			
			@Override
			public void run() {
				i.remove();
			}
		}.runTaskLater(this.hub, 60);	
	}
	
	public void setBacktoBlock(final Block b){
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()){
					p.sendBlockChange(b.getLocation(), b.getType(), b.getData());
				}
			}
		}.runTaskLater(this.hub, 40);	
	}
}
