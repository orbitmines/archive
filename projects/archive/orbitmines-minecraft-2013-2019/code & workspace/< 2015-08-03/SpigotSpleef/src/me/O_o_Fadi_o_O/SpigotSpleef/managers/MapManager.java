package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.AnvilGUI;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Map;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MapManager {

	public static void enterSetupMode(Player p, int mapid){
		if(!StorageManager.mapsetup.containsKey(p) && !StorageManager.arenasetup.containsKey(p)){
			if(Map.getMapFromID(mapid) == null){
				Map map = new Map(mapid, null, null, new ArrayList<Location>(), true);
				StorageManager.maps.add(map);
				StorageManager.mapsetup.put(p, map);
			}
			else{
				Map map = Map.getMapFromID(mapid);
				if(!map.isInUse()){
					map.setInUse(true);
					StorageManager.mapsetup.put(p, map);
				}
				else{
					Message m = Message.getMessage(MessageName.MAP_CURRENTLY_IN_USE);
					m.replace("&", "§");
					m.send(p);
					return;
				}
			}
			
			Message m = Message.getMessage(MessageName.ENTER_MAP_SETUP);
			m.replace("&", "§");
			m.send(p);
		}
		else{
			Message m = Message.getMessage(MessageName.ALREADY_IN_SETUP_MODE);
			m.replace("&", "§");
			m.send(p);
		}
	}
	
	public static void openSetupInventory(Player p, Map map){
		Message m = Message.getMessage(MessageName.OPEN_MAP_SETUP);
		m.replace("&", "§");
		m.send(p);
		
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lMap #" + map.getMapID());
	
		{
			ItemStack item = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§e§lSet Map Name");
			List<String> lore = new ArrayList<String>();
			if(map.getName() == null){
				lore.add(" §7Done: §4§l✘ ");
			}
			else{
				lore.add(" §7Done: §a§l✔ ");
				lore.add(" §7Current Name: §a" + map.getName() + " ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§3§lSet Next Spawnpoint");
			List<String> lore = new ArrayList<String>();
			if(map.getSpawns().size() == 0){
				lore.add(" §7Done: §4§l✘ ");
				lore.add(" §7Amount: §40 ");
			}
			else{
				lore.add(" §7Done: §a§l✔ ");
				lore.add(" §7Amount: §a" + map.getSpawns().size() + " ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§a§lSet Spectator Spawnpoint");
			List<String> lore = new ArrayList<String>();
			if(map.getSpectatorLocation() == null){
				lore.add(" §7Done: §4§l✘ ");
			}
			else{
				lore.add(" §7Done: §a§l✔ ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§2§lFinish Setup");
			List<String> lore = new ArrayList<String>();
			if(map.getName() == null || map.getSpawns().size() == 0 || map.getSpectatorLocation() == null){
				lore.add(" §7Setup Complete: §4§l✘ ");
			}
			else{
				lore.add(" §7Setup Complete: §a§l✔ ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			item.setDurability((short) 13);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.BARRIER, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§4§lDelete Map");
			item.setItemMeta(meta);
			inv.setItem(17, item);
		}
		
		p.openInventory(inv);
	}
	
	public static void loadMaps(){
		if(ConfigManager.maps.contains("maps")){
			for(String mapid : ConfigManager.maps.getConfigurationSection("maps").getKeys(false)){
				String mapname = ConfigManager.maps.getString("maps." + mapid + ".Name");
				Location spectatorspawn = getLocationFromString(ConfigManager.maps.getString("maps." + mapid + ".Locations.SpectatorSpawn"));
				List<Location> spawns = new ArrayList<Location>();
				
				for(String spawnid : ConfigManager.maps.getConfigurationSection("maps." + mapid + ".Locations.Spawns").getKeys(false)){
					spawns.add(getLocationFromString(ConfigManager.maps.getString("maps." + mapid + ".Locations.Spawns." + spawnid)));
				}
				
				Map map = new Map(Integer.parseInt(mapid), mapname, spectatorspawn, spawns, false);
				StorageManager.maps.add(map);
			}
		}
	}
	
	public static String getStringFromLocation(Location l){
		return l.getWorld().getName() + "|" + l.getX() + "|" + l.getY() + "|" + l.getZ() + "|" + l.getYaw() + "|" + l.getPitch();
	}
	
	public static Location getLocationFromString(String location){
		String[] l = location.split("\\|");
		return new Location(Bukkit.getWorld(l[0]), Double.parseDouble(l[1]), Double.parseDouble(l[2]), Double.parseDouble(l[3]), Float.parseFloat(l[4]), Float.parseFloat(l[5]));
	}
	
	public static void openMapNameEditor(final Player p, final int mapid){
		Message m = Message.getMessage(MessageName.OPEN_MAP_SETUP_NAME_EDITOR);
		m.replace("&", "§");
		m.send(p);
		
		final AnvilGUI gui = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler(){
			@Override
			public void onAnvilClick(AnvilGUI.AnvilClickEvent e){
				if(e.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
					String s = e.getName();
					e.setWillClose(true);
					e.setWillDestroy(true);
					
					Message m = Message.getMessage(MessageName.SET_MAP_NAME);
					m.replace("&", "§");
					m.replace("%map-id%", "" + mapid);
					m.replace("%map-name%", s);
					m.send(p);
					StorageManager.mapsetup.get(p).setName(s);
				}
				else{
					e.setWillClose(false);
					e.setWillDestroy(false);
				}
			}
		});
		
		{
			ItemStack item = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("Insert Mapname");
			item.setItemMeta(meta);
			gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, item);
		}
	
		gui.open();
	}
	
	public static void setNextSpawnpoint(Player p){
		p.closeInventory();
		Map map = StorageManager.mapsetup.get(p);
		map.addSpawn(p.getLocation());
		
		Message m = Message.getMessage(MessageName.SET_NEXT_MAP_SPAWNPOINT);
		m.replace("&", "§");
		m.replace("%map-id%", "" + map.getMapID());
		m.replace("%spawn-id%", "" + map.getSpawns().size());
		m.send(p);
	}
	
	public static void setSpectatorSpawnpoint(Player p){
		p.closeInventory();
		Map map = StorageManager.mapsetup.get(p);
		map.setSpectatorLocation(p.getLocation());
		
		Message m = Message.getMessage(MessageName.SET_MAP_SPECTATOR_SPAWNPOINT);
		m.replace("&", "§");
		m.replace("%map-id%", "" + map.getMapID());
		m.send(p);
	}
	
	public static void finishSetup(Player p){
		p.closeInventory();
		Map map = StorageManager.mapsetup.get(p);
		saveMap(map);
		map.setInUse(false);
		
		Message m = Message.getMessage(MessageName.FINISH_MAP_SETUP);
		m.replace("&", "§");
		m.replace("%map-id%", "" + map.getMapID());
		m.send(p);
		StorageManager.mapsetup.remove(p);
	}
	
	public static void deleteMap(Player p){
		p.closeInventory();
		Map map = StorageManager.mapsetup.get(p);
		
		int mapid = map.getMapID();
		ConfigManager.maps.set("maps." + mapid, null);
		ConfigManager.saveMaps();
		StorageManager.maps.remove(map);

		Message m = Message.getMessage(MessageName.DELETE_MAP);
		m.replace("&", "§");
		m.replace("%map-id%", "" + mapid);
		m.send(p);
		StorageManager.mapsetup.remove(p);
	}
	
	public static void saveMap(Map map){
		int mapid = map.getMapID();
		ConfigManager.maps.set("maps." + mapid + ".Name", map.getName());
		ConfigManager.maps.set("maps." + mapid + ".Locations.SpectatorSpawn", getStringFromLocation(map.getSpectatorLocation()));
		int index = 1;
		for(Location spawn : map.getSpawns()){
			ConfigManager.maps.set("maps." + mapid + ".Locations.Spawns." + index, getStringFromLocation(spawn));
			index++;
		}
		ConfigManager.saveMaps();
	}
}
