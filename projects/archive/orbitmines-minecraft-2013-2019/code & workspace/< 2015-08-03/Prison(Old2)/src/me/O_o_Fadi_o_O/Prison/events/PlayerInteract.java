package me.O_o_Fadi_o_O.Prison.events;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomFirework;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.util.CraftMagicNumbers;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.filoghost.holograms.api.Hologram;
import com.gmail.filoghost.holograms.api.HolographicDisplaysAPI;

public class PlayerInteract implements Listener{
	 
	Start plugin;
	 
	public PlayerInteract(Start instance) {
		plugin = instance;
	}
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 4;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
			
		try{
			if(PlayerManager.isLoaded(p)){
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
					Block b = e.getClickedBlock();
					if(b.getType() == Material.CHEST){
						if(StorageManager.rareChests.contains(b)){
							e.setCancelled(true);
							if(p == StorageManager.rareChestPlayer.get(b)){
								if(StorageManager.rareChestIsOpened.get(b) == false){
									if(p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR){
										for(Player player : Bukkit.getOnlinePlayers()){
											player.playEffect(b.getLocation(), Effect.STEP_SOUND, 54);
										}
										((CraftWorld) b.getWorld()).getHandle().playNote(b.getLocation().getBlockX(), b.getLocation().getBlockY(), b.getLocation().getBlockZ(), CraftMagicNumbers.getBlock(b), 1, 1);
										StorageManager.rareChestIsOpened.put(b, true);
										StorageManager.rareChests.remove(b);
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
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK){
					if(e.getClickedBlock().getType() == Material.WALL_SIGN){
						Sign s = (Sign) e.getClickedBlock().getState();
						
						if(s.getLine(3).startsWith("     ")){
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
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
			
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	@SuppressWarnings("deprecation")
	public void giveRareChestReward(Block b){
		
		Random r = new Random();
		int rInt = r.nextInt(1000);
		
		int nextLowestInt = 0;
		
		Player p = StorageManager.rareChestPlayer.get(b);
		
        FireworkEffect.Builder builder = FireworkEffect.builder();
        
        FireworkEffect effect = builder.flicker(true).trail(true).withColor(Color.RED).withColor(Color.RED).withFade(Color.GRAY).with(FireworkEffect.Type.BALL).build();

        Location l = new Location(b.getWorld(), b.getLocation().getX() + 0.5, b.getLocation().getY(), b.getLocation().getZ() + 0.5);
        CustomFirework.spawn(l, effect, Bukkit.getOnlinePlayers());
        
        
		Location l2 = new Location(b.getWorld(), b.getX() + 0.5, b.getY() +1, b.getZ() + 0.5);
		Hologram hologram = HolographicDisplaysAPI.createHologram(this.plugin, l2, "§cRare Chest");
		StorageManager.rareChestHolograms.put(b, hologram);
        
        
		if(Prison.isIntEqualTo(rInt, 0, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§b§lDiamond Pickaxe");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Efficiency V, Unbreaking V)");
			StorageManager.rareChestHolograms.get(b).update();
			
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
			StorageManager.rareChestHolograms.get(b).setLine(0, "§7§lIron Pickaxe");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Efficiency V, Unbreaking V)");
			StorageManager.rareChestHolograms.get(b).update();
			
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
			StorageManager.rareChestHolograms.get(b).setLine(0, "§b§lDiamond Pickaxe");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Efficiency IV, Unbreaking V)");
			StorageManager.rareChestHolograms.get(b).update();
			
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
			StorageManager.rareChestHolograms.get(b).setLine(0, "§7§lIron Pickaxe");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Efficiency IV, Unbreaking V)");
			StorageManager.rareChestHolograms.get(b).update();
			
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
			StorageManager.rareChestHolograms.get(b).setLine(0, "§6§l100000 Gold");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveMoney(p, 100000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§6§l75000 Gold");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveMoney(p, 75000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§6§l70000 Gold");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveMoney(p, 70000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§6§l60000 Gold");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveMoney(p, 60000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§6§l50000 Gold");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveMoney(p, 50000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§6§l25000 Gold");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveMoney(p, 25000);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§c§l1 Rare Chest");
			StorageManager.rareChestHolograms.get(b).update();
			
			ItemStack item = new ItemStack(Material.CHEST, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRare Chest");
			item.setItemMeta(meta);
			p.getInventory().addItem(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§a§l3 Gamble Tickets");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveGambleTickets(p, 3);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§a§l4 Gamble Tickets");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveGambleTickets(p, 4);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§a§l5 Gamble Tickets");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveGambleTickets(p, 5);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§a§l6 Gamble Tickets");
			StorageManager.rareChestHolograms.get(b).update();
			
			PlayerManager.giveGambleTickets(p, 6);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§d§lEnchanted Book");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Sharpness III)");
			StorageManager.rareChestHolograms.get(b).update();
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§d§lEnchanted Book");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Protection III)");
			StorageManager.rareChestHolograms.get(b).update();
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§d§lEnchanted Book");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Protection IV)");
			StorageManager.rareChestHolograms.get(b).update();
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§d§lEnchanted Book");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Efficiency V)");
			StorageManager.rareChestHolograms.get(b).update();
			
			ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
			EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
			meta.setDisplayName("§cRare Enchanted Book");
			meta.addStoredEnchant(Enchantment.DIG_SPEED, 5, true);
			item.setItemMeta(meta);
			
			p.getInventory().setItemInHand(item);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			StorageManager.rareChestHolograms.get(b).setLine(0, "§d§lEnchanted Book");
			StorageManager.rareChestHolograms.get(b).addLine("§7(Fortune I)");
			StorageManager.rareChestHolograms.get(b).update();
			
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
				
				StorageManager.rareChestHolograms.get(b).delete();
				StorageManager.rareChestHolograms.remove(b);
				StorageManager.rareChestPlayer.remove(b);
				StorageManager.rareChests.remove(b);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.playEffect(b.getLocation(), Effect.STEP_SOUND, 54);
				}
				b.setType(Material.AIR);
				
			}
		}.runTaskLater(this.plugin, 100);
	}
}
