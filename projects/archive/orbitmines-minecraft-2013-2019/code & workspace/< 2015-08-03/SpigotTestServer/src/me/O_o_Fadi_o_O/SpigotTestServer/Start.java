package me.O_o_Fadi_o_O.SpigotTestServer;

import me.O_o_Fadi_o_O.SpigotTestServer.events.BreakEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.events.EntityDamage;
import me.O_o_Fadi_o_O.SpigotTestServer.events.FoodEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.events.InteractEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.events.JoinEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.events.PlaceEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.events.QuitEvent;
import me.O_o_Fadi_o_O.SpigotTestServer.managers.NPCManager;
import me.O_o_Fadi_o_O.SpigotTestServer.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotTestServer.utils.Hologram;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Start extends JavaPlugin {

    static Start plugin;
	
	public void onEnable(){
		plugin = this;
		
		registerAllEvents();
		
		new BukkitRunnable(){
			public void run(){
				StorageManager.lobbyworld = Bukkit.getWorld("Lobby");
				StorageManager.lobby = new Location(StorageManager.lobbyworld, 0.5, 70, 0.5, 90, 0);
				
				Hologram.createHologram(new Location(StorageManager.lobbyworld, -18, 68.7, 3), "§6§lSpigot§7§lSpleef");
				Hologram.createHologram(new Location(StorageManager.lobbyworld, -18, 68.5, 3), "§7Premium Project (§a12.50 EUR§7)");
				
				Hologram.createHologram(new Location(StorageManager.lobbyworld, -15.5, 68.7, -4), "§6§lBungee§7§lMSG");
				Hologram.createHologram(new Location(StorageManager.lobbyworld, -15.5, 68.5, -4), "§7Free Project");
				
				Hologram.createItemHologram(new Location(StorageManager.lobbyworld, -15.5, 66, -4), "§6§lBungee§7§lMSG");
				
				NPCManager.spawnArmorStand(
						StorageManager.lobbyworld, 
						new Location(StorageManager.lobbyworld, -6.355, 71, -2.75, -51, 31), 
						"§6§lFadi§c§lDev §7/ §c§lO_o_Fadi_o_O",
						true, 
						true, 
						true, 
						EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
						false, 
						EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
						EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
						EulerAngle.ZERO.setX(0).setY(0).setZ(-0.2), 
						EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
						EulerAngle.ZERO.setX(0).setY(0).setZ(0.2), 
						false,
						addOwnerToSkull("O_o_Fadi_o_O"),
						addColorToLeather(Material.LEATHER_CHESTPLATE, Color.ORANGE),
						addColorToLeather(Material.LEATHER_LEGGINGS, Color.ORANGE),
						addColorToLeather(Material.LEATHER_BOOTS, Color.ORANGE),
						new ItemStack(Material.COMPASS, 1));
				
				for(Player p : Bukkit.getOnlinePlayers()){
					p.teleport(StorageManager.lobby);
				}
			}
		}.runTaskLater(this, 50);
	}
	
	public void onDisable(){
		for(Entity en : StorageManager.lobbyworld.getEntities()){
			if(en instanceof ArmorStand || en instanceof Item){
				en.remove();
			}
		}
	}
	
	public static Start getInstance(){
		return plugin;
	}
	
	private void registerAllEvents(){
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
	}
	
	private ItemStack addColorToLeather(Material leather, Color color){
		ItemStack item = new ItemStack(leather, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(color);
		item.setItemMeta(meta);
		
		return item;
	}
	private ItemStack addOwnerToSkull(String owner){
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		item.setDurability((short) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(owner);
		item.setItemMeta(meta);
		
		return item;
	}
}
