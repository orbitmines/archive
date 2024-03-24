package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSelectorItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSign;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPCType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArenaManager {
	
	public static void loadArenas(){
		if(ConfigManager.arenas.contains("Lobby")){
			StorageManager.minigameslobby = getLocationFromString(ConfigManager.arenas.getString("Lobby"));
		}
		if(ConfigManager.arenas.contains("arenas")){
			for(String arenaid : ConfigManager.arenas.getConfigurationSection("arenas").getKeys(false)){
				if(Integer.parseInt(arenaid) >= StorageManager.lastarenaid){
					StorageManager.lastarenaid = Integer.parseInt(arenaid) +1;
				}
				
				Location lobbyspawn = getLocationFromString(ConfigManager.arenas.getString("arenas." + arenaid + ".Locations.Lobby"));
				
				Arena arena = new Arena(Integer.parseInt(arenaid), lobbyspawn, StorageManager.minplayers, StorageManager.maxplayers, null, new ArrayList<SpleefPlayer>(), new ArrayList<SpleefPlayer>(), SpleefStatus.WAITING, StorageManager.waittimeminutes, StorageManager.waittimeseconds);
				StorageManager.arenas.add(arena);
				
				if(ConfigManager.arenas.contains("arenas." + arenaid + ".Signs")){
					for(String signid : ConfigManager.arenas.getConfigurationSection("arenas." + arenaid + ".Signs").getKeys(false)){
						ArenaSign sign = new ArenaSign(Integer.parseInt(arenaid), getLocationFromString(ConfigManager.arenas.getString("arenas." + arenaid + ".Signs." + signid)), arena, null);
						arena.addArenaSign(sign);
						StorageManager.signs.add(sign);
					}
				}
			}
		}
		
		if(ConfigManager.arenas.contains("arena-selectors")){
			for(String arenaselector : ConfigManager.arenas.getStringList("arena-selectors")){
				String[] parts = arenaselector.split("\\;");
				EntityType type = EntityType.valueOf(parts[0]);
				String displayname = parts[1].replace("&", "§");
				Location location = getLocationFromString(parts[2]);
				NPC npc = new NPC(NPCType.ARENA_SELECTOR, type, parts[1], null, null, null);
				npc.newEntity(type, location, displayname);
				StorageManager.npcs.add(npc);
			}
		}
		if(ConfigManager.arenas.contains("kit-selectors")){
			for(String kitstring : ConfigManager.arenas.getStringList("kit-selectors")){
				String[] parts = kitstring.split("\\;");
				int kitid = Integer.parseInt(parts[0]);
				EntityType type = EntityType.valueOf(parts[1]);
				Kit kit = Kit.getKitFromID(kitid);
				String displayname = parts[2].replace("&", "§").replace("%kit-name%", kit.getName());
				Location location = getLocationFromString(parts[3]);
				NPC npc = new NPC(NPCType.KIT_SELECTOR, type, parts[2], null, null, kit);
				npc.newEntity(type, location, displayname);
				StorageManager.npcs.add(npc);
			}
		}
	}
	
	public static void setMiniGamesLobby(Player p){
		ConfigManager.arenas.set("Lobby", getStringFromLocation(p.getLocation()));
		ConfigManager.saveArenas();
		StorageManager.minigameslobby = p.getLocation();
	}
	
	public static void enterSetupMode(Player p, int arenaid){
		if(!StorageManager.mapsetup.containsKey(p) && !StorageManager.arenasetup.containsKey(p)){
			if(Arena.getArenaFromID(arenaid) == null){
				if(StorageManager.bungeecord == true && StorageManager.ishubserver == true || StorageManager.maps.size() > StorageManager.arenas.size()){
					Arena arena = new Arena(arenaid, null, StorageManager.minplayers, StorageManager.maxplayers, null, new ArrayList<SpleefPlayer>(), new ArrayList<SpleefPlayer>(), SpleefStatus.ENDING, -1, -1);
					StorageManager.arenas.add(arena);
					StorageManager.arenasetup.put(p, arena);
					
					Message m = Message.getMessage(MessageName.ENTER_ARENA_SETUP);
					m.replace("&", "§");
					m.send(p);
				}
				else{
					Message m = Message.getMessage(MessageName.NO_MAP_AVAILABLE);
					m.replace("&", "§");
					m.send(p);
				}
			}
			else{
				Arena arena = Arena.getArenaFromID(arenaid);
				StorageManager.arenasetup.put(p, arena);
				
				Message m = Message.getMessage(MessageName.ENTER_ARENA_SETUP);
				m.replace("&", "§");
				m.send(p);
			}
		}
		else{
			Message m = Message.getMessage(MessageName.ALREADY_IN_SETUP_MODE);
			m.replace("&", "§");
			m.send(p);
		}
	}
	
	public static void openSetupInventory(Player p, Arena arena){
		Message m = Message.getMessage(MessageName.OPEN_ARENA_SETUP);
		m.replace("&", "§");
		m.send(p);
		
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lArena #" + arena.getArenaID());
	
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§3§lSet Lobby Spawnpoint");
			List<String> lore = new ArrayList<String>();
			if(arena.getLobby() == null){
				lore.add(" §7Done: §4§l✘ ");
			}
			else{
				lore.add(" §7Done: §a§l✔ ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.SIGN, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§e§lSigns");
			List<String> lore = new ArrayList<String>();
			lore.add(" §7Amount: §a" + arena.getArenaSigns().size() + " ");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§2§lFinish Setup");
			List<String> lore = new ArrayList<String>();
			if(arena.getLobby() == null){
				lore.add(" §7Setup Complete: §4§l✘ ");
			}
			else{
				lore.add(" §7Setup Complete: §a§l✔ ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			item.setDurability((short) 13);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.BARRIER, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§4§lDelete Arena");
			item.setItemMeta(meta);
			inv.setItem(16, item);
		}
		
		p.openInventory(inv);
	}
	
	public static String getStringFromLocation(Location l){
		return l.getWorld().getName() + "|" + l.getX() + "|" + l.getY() + "|" + l.getZ() + "|" + l.getYaw() + "|" + l.getPitch();
	}
	
	public static Location getLocationFromString(String location){
		String[] l = location.split("\\|");
		return new Location(Bukkit.getWorld(l[0]), Double.parseDouble(l[1]), Double.parseDouble(l[2]), Double.parseDouble(l[3]), Float.parseFloat(l[4]), Float.parseFloat(l[5]));
	}
	
	public static void saveKitSelectors(){
		List<String> npcs = new ArrayList<String>();
		for(NPC npc : StorageManager.npcs){
			if(npc.getNPCType() == NPCType.KIT_SELECTOR){
				npcs.add(npc.getKit().getKitID() + ";" + npc.getEntity().getType().toString() + ";" + npc.getDisplayname() + ";" + getStringFromLocation(npc.getEntity().getLocation()));
			}
		}
		ConfigManager.arenas.set("kit-selectors", npcs);
		ConfigManager.saveArenas();
	}

	public static void saveArenaSelectors(){
		List<String> npcs = new ArrayList<String>();
		for(NPC npc : StorageManager.npcs){
			if(npc.getNPCType() == NPCType.ARENA_SELECTOR){
				npcs.add(npc.getEntity().getType().toString() + ";" + npc.getDisplayname() + ";" + getStringFromLocation(npc.getEntity().getLocation()));
			}
		}
		ConfigManager.arenas.set("arena-selectors", npcs);
		ConfigManager.saveArenas();
	}
	

	public static void setLobbySpawnpoint(Player p){
		p.closeInventory();
		Arena arena = StorageManager.arenasetup.get(p);
		arena.setLobby(p.getLocation());
		
		Message m = Message.getMessage(MessageName.SET_ARENA_LOBBY_SPAWNPOINT);
		m.replace("&", "§");
		m.replace("%arena-id%", "" + arena.getArenaID());
		m.send(p);
	}
	
	public static void setArenaSign(Player p, Block b){
		if(!ArenaSign.isSignArenaSign(b.getLocation())){
			Arena arena = StorageManager.arenasetup.get(p);
			ArenaSign sign = new ArenaSign(arena.getArenaID(), b.getLocation(), arena, null);
			arena.addArenaSign(sign);
			StorageManager.signs.add(sign);

			Message m = Message.getMessage(MessageName.NEW_ARENA_SIGN);
			m.replace("&", "§");
			m.send(p);
		}
		else{
			Message m = Message.getMessage(MessageName.ALREADY_ARENA_SIGN);
			m.replace("&", "§");
			m.send(p);
		}
	}
	
	public static void finishSetup(Player p){
		p.closeInventory();
		Arena arena = StorageManager.arenasetup.get(p);
		saveArena(arena);
		if(arena.isStatus(SpleefStatus.RESTARTING)){
			arena.toWaiting();
		}
		
		Message m = Message.getMessage(MessageName.FINISH_ARENA_SETUP);
		m.replace("&", "§");
		m.replace("%arena-id%", "" + arena.getArenaID());
		m.send(p);
		StorageManager.arenasetup.remove(p);
	}
	
	public static void deleteArena(Player p){
		p.closeInventory();
		Arena arena = StorageManager.arenasetup.get(p);		
		
		for(ArenaSign sign : arena.getArenaSigns()){
			String[] lines = new String[4];
			lines[0] = "";
			lines[1] = "";
			lines[2] = "";
			lines[3] = "";
			sign.sendUpdate(lines);
			StorageManager.signs.remove(sign);
		}
		
		for(ArenaSelectorItemStack item : StorageManager.arenaselector.getItemStacks()){
			if(item != null && item.getArena() != null && item.getArena() == arena){
				item.setArena(null);
			}
		}
		
		for(SpleefPlayer sp : arena.getAllPlayers()){
			sp.clearInventory();
			sp.teleportToLobby();
			sp.setArena(null);
		}
		arena.resetScoreboard();
		arena.resetMap();
		if(arena.getMap() != null){
			arena.getMap().setInUse(false);
		}
		arena.cancelArena();
		
		int arenaid = arena.getArenaID();
		ConfigManager.arenas.set("arenas." + arenaid, null);
		ConfigManager.saveArenas();
		StorageManager.arenas.remove(arena);

		Message m = Message.getMessage(MessageName.DELETE_ARENA);
		m.replace("&", "§");
		m.replace("%arena-id%", "" + arenaid);
		m.send(p);
		
		StorageManager.arenasetup.remove(p);
	}
	
	public static void saveArena(Arena arena){
		int arenaid = arena.getArenaID();
		ConfigManager.arenas.set("arenas." + arenaid + ".Locations.Lobby", getStringFromLocation(arena.getLobby()));
		int index = 1;
		for(ArenaSign sign : arena.getArenaSigns()){
			ConfigManager.arenas.set("arenas." + arenaid + ".Signs." + index, getStringFromLocation(sign.getLocation()));
			index++;
		}
		ConfigManager.saveArenas();
		arena.toWaiting();
	}
}
