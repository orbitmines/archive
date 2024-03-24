package me.O_o_Fadi_o_O.Prison.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.Prison.Hologram;
import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import net.minecraft.server.v1_8_R1.BlockPosition;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.util.CraftMagicNumbers;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class InteractEvent implements Listener{
	
	Start start = Start.getInstance();
	
	Hologram hologram = new Hologram();
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 4;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();

		if(StorageManager.loaded.get(p) == true){
			try{
				if(a == Action.RIGHT_CLICK_BLOCK){
					Block b = e.getClickedBlock();
					if(b.getType() == Material.CHEST){
						e.setCancelled(true);
						if(StorageManager.rarechests.contains(b)){
							e.setCancelled(true);
							if(p == StorageManager.rarechestplayer.get(b)){
								if(StorageManager.rarechestisopened.get(b) == false){
									if(p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR){
										for(Player player : Bukkit.getOnlinePlayers()){
											player.playEffect(b.getLocation(), Effect.STEP_SOUND, 54);
										}
										((CraftWorld) b.getWorld()).getHandle().playBlockAction(new BlockPosition(b.getLocation().getBlockX(), b.getLocation().getBlockY(), b.getLocation().getBlockZ()), CraftMagicNumbers.getBlock(b), 1, 1);
										StorageManager.rarechestisopened.put(b, true);
										StorageManager.rarechests.remove(b);
										giveRareChestReward(b);
									}
									else{
										p.sendMessage(Start.TAG + "You have to click on the §cRare Chest§7 with your §6Fists§7!");
									}
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDEINED§7! This isn't your §cRare Chest§7!");
							}
						}
					}
				}
				if(a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_BLOCK){
					if(e.getClickedBlock().getType() == Material.WALL_SIGN){
						Sign s = (Sign) e.getClickedBlock().getState();
						
						if(s.getLine(0).startsWith("Lagg Problems?")){
							long lastUsed = 0;
							if(lastUsage.containsKey(p.getName())){
								lastUsed = lastUsage.get(p.getName());
							}
							int cdmillis = cdtime * 1000;
									
							if(System.currentTimeMillis()-lastUsed>=cdmillis){
								
								PlayerManager.toggleClockEnabled(p);
								
								lastUsage.put(p.getName(), System.currentTimeMillis());
							}
						}
						e.setCancelled(true);
						p.updateInventory();
					}
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}
	
	public void giveRareChestReward(Block b){
		
		Random r = new Random();
		int rInt = r.nextInt(1000);
		
		int nextLowestInt = 0;
		
		Player p = StorageManager.rarechestplayer.get(b);
		
        FireworkEffect.Builder builder = FireworkEffect.builder();
        
        FireworkEffect effect = builder.flicker(true).trail(true).withColor(Color.RED).withColor(Color.RED).withFade(Color.GRAY).with(FireworkEffect.Type.BALL).build();

        Location l = new Location(b.getWorld(), b.getLocation().getX() + 0.5, b.getLocation().getY() -1, b.getLocation().getZ() + 0.5);
        Firework fw = (Firework) p.getWorld().spawnEntity(l, EntityType.FIREWORK);
        FireworkMeta fwmeta = fw.getFireworkMeta();	
        fwmeta.addEffect(effect);
        fw.setFireworkMeta(fwmeta);
        
		if(Prison.isIntEqualTo(rInt, 0, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§b§lDiamond Pickaxe"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Efficiency V, Unbreaking V)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRare Pickaxe");
			item.setItemMeta(meta);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§7§lIron Pickaxe"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Efficiency V, Unbreaking V)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRare Pickaxe");
			item.setItemMeta(meta);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
        
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§b§lDiamond Pickaxe"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Efficiency IV, Unbreaking V)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRare Pickaxe");
			item.setItemMeta(meta);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§7§lIron Pickaxe"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Efficiency IV, Unbreaking V)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRare Pickaxe");
			item.setItemMeta(meta);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§6§l100000 Gold"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveMoney(p, 100000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§6§l75000 Gold"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveMoney(p, 75000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§6§l70000 Gold"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveMoney(p, 70000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§6§l60000 Gold"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveMoney(p, 60000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§6§l50000 Gold"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveMoney(p, 50000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§6§l25000 Gold"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveMoney(p, 25000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§c§l1 Rare Chest"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.CHEST, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRare Chest");
			item.setItemMeta(meta);
			p.getInventory().addItem(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§a§l3 Gamble Tickets"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveGambleTickets(p, 3);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§a§l4 Gamble Tickets"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveGambleTickets(p, 4);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§a§l5 Gamble Tickets"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveGambleTickets(p, 5);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§a§l6 Gamble Tickets"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			PlayerManager.giveGambleTickets(p, 6);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§d§lEnchanted Book"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY()-0.25 +0.25, b.getZ() + 0.5), "§7(Sharpness III)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§d§lEnchanted Book"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Protection III)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§d§lEnchanted Book"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Protection IV)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§d§lEnchanted Book"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Efficiency V)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.DIG_SPEED, 5, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			List<Entity> holograms = StorageManager.rarechestholograms.get(b);
			StorageManager.armorstands.remove(holograms.get(0));
			holograms.get(0).remove();
			holograms.clear();
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.25, b.getZ() + 0.5), "§d§lEnchanted Book"));
			holograms.add(hologram.createHologram(new Location(b.getWorld(), b.getX() + 0.5, b.getY() -0.25 +0.25, b.getZ() + 0.5), "§7(Fortune I)"));
			StorageManager.rarechestholograms.put(b, holograms);
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		p.updateInventory();
		removeRareChest(b);
	}
	
	public void removeRareChest(final Block b){
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				
				for(Entity en : StorageManager.rarechestholograms.get(b)){
					en.remove();
					StorageManager.armorstands.remove(en);
				}
				
				StorageManager.rarechestholograms.remove(b);
				StorageManager.rarechestplayer.remove(b);
				StorageManager.rarechests.remove(b);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.playEffect(b.getLocation(), Effect.STEP_SOUND, 54);
				}
				b.setType(Material.AIR);
				
			}
		}.runTaskLater(this.start, 100);
	}
}
