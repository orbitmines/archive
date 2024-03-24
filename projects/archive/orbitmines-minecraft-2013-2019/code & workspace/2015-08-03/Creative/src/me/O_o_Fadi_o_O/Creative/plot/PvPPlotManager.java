package me.O_o_Fadi_o_O.Creative.plot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.ConfigManager;
import me.O_o_Fadi_o_O.Creative.managers.NPCManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.managers.TitleManager;
import me.O_o_Fadi_o_O.Creative.utils.ArmorStandType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.EulerAngle;

public class PvPPlotManager {
	
	private static NPCManager npcmanager = new NPCManager();

	public static void loadPvPPlot(int PlotNumber){
		if(ConfigManager.plots.contains("plots." + PlotNumber + ".PvPInfo.SetupFinished")){
			boolean finished = getFinishedSetup(PlotNumber);
			if(finished){
				StorageManager.plotpvpsetupfinished.put(PlotNumber, finished);
				StorageManager.plotpvpspawnlocation.put(PlotNumber, getLobbyLocation(PlotNumber));
				
				List<Location> spawnlocations = new ArrayList<Location>();
				for(String location : ConfigManager.plots.getConfigurationSection("plots." + PlotNumber + ".PvPInfo.Locations.Spawns").getKeys(false)){
					spawnlocations.add(getSpawnLocation(PlotNumber, Integer.parseInt(location)));
				}
				StorageManager.plotpvplocations.put(PlotNumber, spawnlocations);
				
				StorageManager.plotpvpdrops.put(PlotNumber, getEnabledDrops(PlotNumber));
				StorageManager.plotpvparrows.put(PlotNumber, getEnabledArrows(PlotNumber));
				StorageManager.plotpvpbuild.put(PlotNumber, getEnabledBuild(PlotNumber));
				StorageManager.plotpvpmaxplayers.put(PlotNumber, getMaxPlayers(PlotNumber));
				
				List<String> kitnames = new ArrayList<String>();
				for(String kitname : ConfigManager.plots.getConfigurationSection("plots." + PlotNumber + ".PvPInfo.Kits").getKeys(false)){
					kitnames.add(kitname);
				}
				StorageManager.plotpvpkitnames.put(PlotNumber, kitnames);
				
				List<ItemStack[]> kits = new ArrayList<ItemStack[]>();
				for(String kitname : ConfigManager.plots.getConfigurationSection("plots." + PlotNumber + ".PvPInfo.Kits").getKeys(false)){
					kits.add(getKit(PlotNumber, kitname));
				}
				StorageManager.plotpvpkits.put(PlotNumber, kits);
				
				StorageManager.plotpvpplayers.put(PlotNumber, new ArrayList<Player>());
				StorageManager.plotpvpplayersselectedkit.put(PlotNumber, new ArrayList<Player>());
				
				List<Location> npclocations = new ArrayList<Location>();
				for(String kitname : ConfigManager.plots.getConfigurationSection("plots." + PlotNumber + ".PvPInfo.Locations.NPCs").getKeys(false)){
					npclocations.add(getNPCLocation(PlotNumber, kitname));
				}
				StorageManager.plotpvpnpclocations.put(PlotNumber, npclocations);
				
				spawnNPCs(PlotNumber);
				for(String kitname : StorageManager.plotpvpkitnames.get(PlotNumber)){
					updateNPC(PlotNumber, kitname);
				}
			}
			else{
				resetPvPInfo(PlotNumber);
			}
		}
	}
	
	public static void createKitInventories(Player p){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		
		List<Inventory> inventories = new ArrayList<Inventory>();
		
		for(String kitname : StorageManager.plotpvpkitnames.get(PlotNumber)){
			Inventory inv = Bukkit.createInventory(null, 27, "§0§lKit: " + kitname);
			
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§fHelmet Slot: §7§lEmpty");
				item.setItemMeta(meta);
				inv.setItem(0, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§fChestplate Slot: §7§lEmpty");
				item.setItemMeta(meta);
				inv.setItem(1, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§fLeggings Slot: §7§lEmpty");
				item.setItemMeta(meta);
				inv.setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§fBoots Slot: §7§lEmpty");
				item.setItemMeta(meta);
				inv.setItem(3, item);
			}
			
			for(int i = 18; i <= 26; i++){
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, (i - 17));
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§fHotbar Slot " + (i - 17) + ": §7§lEmpty");
				item.setItemMeta(meta);
				inv.setItem(i, item);
			}
			
			inventories.add(inv);
		}
		StorageManager.plotpvpinventories.put(p, inventories);
	}
	
	public static void selectKit(Player p, int PlotNumber, String kitname){
		List<Player> playersselectedkit = StorageManager.plotpvpplayersselectedkit.get(PlotNumber);
		playersselectedkit.add(p);
		StorageManager.plotpvpplayersselectedkit.put(PlotNumber, playersselectedkit);
		
		teleportInArena(p, PlotNumber);
		givePlayerKit(p, PlotNumber, kitname);
		
	    for(PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		TitleManager.setTitle(p, "", "§7Selected Kit: '§d§l" + kitname + "§7'");
	}
	
	public static void teleportInArena(Player p, int PlotNumber){
		List<Location> spawnlocations = StorageManager.plotpvplocations.get(PlotNumber);
		
		p.teleport(spawnlocations.get(new Random().nextInt(spawnlocations.size())));
	}
	
	public static void openInventory(Player p, Entity en){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		p.openInventory(StorageManager.plotpvpinventories.get(p).get(StorageManager.plotpvpnpcs.get(PlotNumber).indexOf(en)));
	}
	
	public static void spawnNPCs(int PlotNumber){
		if(!StorageManager.plotpvpnpcs.containsKey(PlotNumber)){
			StorageManager.plotpvpnpcs.put(PlotNumber, new ArrayList<Entity>());
		}
		
		for(Location l : StorageManager.plotpvpnpclocations.get(PlotNumber)){
			npcmanager.spawnArmorStand(
					l.getWorld(), 
					l, 
					"§7§lKit §8| §a" + StorageManager.plotpvpkitnames.get(PlotNumber).get(StorageManager.plotpvpnpclocations.get(PlotNumber).indexOf(l)),
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					true,
					null,
					null,
					null,
					null,
					null,
					ArmorStandType.PLOT_KIT_SELECTOR,
					PlotNumber);
		}
	}
	
	public static void resetPvPInfo(int PlotNumber){
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo", null);
		ConfigManager.savePlots();
	}
	
	public static void updateNPC(int PlotNumber, String kitname){
		int index = StorageManager.plotpvpkitnames.get(PlotNumber).indexOf(kitname);
		ArmorStand as = (ArmorStand) StorageManager.plotpvpnpcs.get(PlotNumber).get(index);
		
		ItemStack[] inventory = StorageManager.plotpvpkits.get(PlotNumber).get(index);
		
		ItemStack helmet = inventory[0];
		ItemStack chestplate = inventory[1];
		ItemStack leggings = inventory[2];
		ItemStack boots = inventory[3];
		
		if(helmet == null || helmet.getItemMeta() == null || helmet.getItemMeta().getDisplayName() == null || !helmet.getItemMeta().getDisplayName().endsWith("§7§lEmpty")){
			as.setHelmet(helmet);
		}
		if(chestplate == null || chestplate.getItemMeta() == null || chestplate.getItemMeta().getDisplayName() == null || !chestplate.getItemMeta().getDisplayName().endsWith("§7§lEmpty")){
			as.setChestplate(chestplate);
		}
		if(leggings == null || leggings.getItemMeta() == null || leggings.getItemMeta().getDisplayName() == null || !leggings.getItemMeta().getDisplayName().endsWith("§7§lEmpty")){
			as.setLeggings(leggings);
		}
		if(boots == null || boots.getItemMeta() == null || boots.getItemMeta().getDisplayName() == null || !boots.getItemMeta().getDisplayName().endsWith("§7§lEmpty")){
			as.setBoots(boots);
		}
		
		boolean hasinhand = false;
		for(int i = 4; i <= 12; i ++){
			if(hasinhand == false){
				if(inventory[i] != null){
					if(inventory[i].getItemMeta() == null || inventory[i].getItemMeta().getDisplayName() == null || !inventory[i].getItemMeta().getDisplayName().endsWith("§7§lEmpty")){
						as.setItemInHand(inventory[i]);
						hasinhand = true;
					}
				}
			}
		}
		
		if(hasinhand == false){
			as.setItemInHand(null);
		}
	}
	
	public static void removeALLNPCs(){
		for(int PlotNumber : StorageManager.plotmode.keySet()){
			if(StorageManager.plotpvpnpcs.containsKey(PlotNumber)){
				removeNPCs(PlotNumber);
			}
		}
	}
	
	public static void removeNPCs(int PlotNumber){
		for(Entity en : StorageManager.plotpvpnpcs.get(PlotNumber)){
			en.remove();
		}
		StorageManager.plotpvpnpcs.put(PlotNumber, new ArrayList<Entity>());
	}
	
	public static void setFinishedSetup(Player p, boolean finished){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		StorageManager.plotpvpsetupfinished.put(PlotNumber, finished);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.SetupFinished", finished);
		ConfigManager.savePlots();
	}
	public static boolean getFinishedSetup(int PlotNumber){
		return Boolean.parseBoolean(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.SetupFinished"));
	}
	
	public static void setLobbyLocation(Player p){
		Location l = p.getLocation();
		String location = getStringFromLocation(l);
		
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		StorageManager.plotpvpspawnlocation.put(PlotNumber, l);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.Locations.Lobby", location);
		ConfigManager.savePlots();
	}
	public static Location getLobbyLocation(int PlotNumber){
		return getLocationFromString(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.Locations.Lobby"));
	}
	
	public static void setNPCLocation(Player p, String kitname){
		Location l = p.getLocation();
		String location = getStringFromLocation(l);
		
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		List<Location> npclocations = StorageManager.plotpvpnpclocations.get(PlotNumber);
		npclocations.add(l);
		StorageManager.plotpvpnpclocations.put(PlotNumber, npclocations);
		
		List<String> kitnames = new ArrayList<String>();
		for(String kit : StorageManager.plotpvpkitnames.get(PlotNumber)){
			kitnames.add(kit);
		}
		kitnames.add(kitname);
		StorageManager.plotpvpkitnames.put(PlotNumber, kitnames);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.Locations.NPCs." + kitname, location);
		ConfigManager.savePlots();
	}
	public static Location getNPCLocation(int PlotNumber, String kitname){
		List<String> kitnames = new ArrayList<String>();
		for(String kit : StorageManager.plotpvpkitnames.get(PlotNumber)){
			kitnames.add(kit);
		}
		kitnames.remove(kitname);
		kitnames.add(kitname);
		StorageManager.plotpvpkitnames.put(PlotNumber, kitnames);
		
		return getLocationFromString(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.Locations.NPCs." + kitname));
	}
	
	public static void setSpawnLocation(Player p, int spawn){
		Location l = p.getLocation();
		String location = getStringFromLocation(l);
		
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		List<Location> spawnlocations = StorageManager.plotpvplocations.get(PlotNumber);
		spawnlocations.add(l);
		StorageManager.plotpvplocations.put(PlotNumber, spawnlocations);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.Locations.Spawns." + spawn, location);
		ConfigManager.savePlots();
	}
	public static Location getSpawnLocation(int PlotNumber, int spawn){
		return getLocationFromString(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.Locations.Spawns." + spawn));
	}
	
	public static void setEnabledDrops(Player p, boolean dropsenabled){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		StorageManager.plotpvpdrops.put(PlotNumber, dropsenabled);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.EnableDrops", dropsenabled);
		ConfigManager.savePlots();
	}
	public static boolean getEnabledDrops(int PlotNumber){
		return Boolean.parseBoolean(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.EnableDrops"));
	}
	
	public static void setEnabledArrows(Player p, boolean arrowsenabled){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		StorageManager.plotpvparrows.put(PlotNumber, arrowsenabled);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.EnableArrows", arrowsenabled);
		ConfigManager.savePlots();
	}
	public static boolean getEnabledArrows(int PlotNumber){
		return Boolean.parseBoolean(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.EnableArrows"));
	}
	
	public static void setEnabledBuild(Player p, boolean buildenabled){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		StorageManager.plotpvpbuild.put(PlotNumber, buildenabled);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.EnableBuild", buildenabled);
		ConfigManager.savePlots();
	}
	public static boolean getEnabledBuild(int PlotNumber){
		return Boolean.parseBoolean(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.EnableBuild"));
	}
	
	public static void setMaxPlayers(Player p, int maxplayers){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		StorageManager.plotpvpmaxplayers.put(PlotNumber, maxplayers);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.MaxPlayers", maxplayers);
		ConfigManager.savePlots();
	}
	public static int getMaxPlayers(int PlotNumber){
		return ConfigManager.plots.getInt("plots." + PlotNumber + ".PvPInfo.MaxPlayers");
	}
	
	public static void setKit(Player p, String kitname, ItemStack[] inventory){
		
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		List<ItemStack[]> kits = StorageManager.plotpvpkits.get(PlotNumber);
		int index2 = StorageManager.plotpvpkitnames.get(PlotNumber).indexOf(kitname);
		if(kits.size() < (index2 +1)){
			for(int i = kits.size(); i <= (index2 +1); i ++){
				kits.add(new ItemStack[13]);
			}
		}
		kits.set(index2, inventory);
		StorageManager.plotpvpkits.put(PlotNumber, kits);
		
		int index = 0;
		for(ItemStack item : inventory){
			if(item != null){
				if(item.getItemMeta() == null || item.getItemMeta().getDisplayName() == null || !item.getItemMeta().getDisplayName().endsWith("§7§lEmpty")){
					ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.Kits." + kitname + "." + index, getStringFromItemStack(item));
				}
				else{
					ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.Kits." + kitname + "." + index, null);
				}
			}
			else{
				ConfigManager.plots.set("plots." + PlotNumber + ".PvPInfo.Kits." + kitname + "." + index, null);
			}
			index++;
		}
		ConfigManager.savePlots();
		
		updateNPC(PlotNumber, kitname);
	}
	public static ItemStack[] getKit(int PlotNumber, String kitname){
		ItemStack[] inventory = new ItemStack[13];
		
		for(String itemstack : ConfigManager.plots.getConfigurationSection("plots." + PlotNumber + ".PvPInfo.Kits." + kitname).getKeys(false)){
			inventory[Integer.parseInt(itemstack)] = getItemStackFromString(ConfigManager.plots.getString("plots." + PlotNumber + ".PvPInfo.Kits." + kitname + "." + itemstack));
		}
		
		return inventory;
	}
	public static void givePlayerKit(Player p, int PlotNumber, String kitname){
		Start.clearInventory(p);
		
		ItemStack[] inventory = StorageManager.plotpvpkits.get(PlotNumber).get(StorageManager.plotpvpkitnames.get(PlotNumber).indexOf(kitname));
		
		for(int i = 4; i <= 12; i++){
			p.getInventory().setItem((i -4), inventory[i]);
		}
		
		p.getInventory().setBoots(inventory[3]);
		p.getInventory().setLeggings(inventory[2]);
		p.getInventory().setChestplate(inventory[1]);
		p.getInventory().setHelmet(inventory[0]);
		
		p.updateInventory();
	}
	
	public static String getStringFromItemStack(ItemStack item){
		Material m = item.getType();
		int amount = item.getAmount();
		int durability = item.getDurability();
		String enchantmentsstring = "Enchantments";
		Map<Enchantment, Integer> enchantments = item.getEnchantments();
		for(Enchantment ench : enchantments.keySet()){
			if(enchantments.get(ench) > 0){
				enchantmentsstring = enchantmentsstring + ":" + ench.getName() + "(" + enchantments.get(ench) + ")";
			}
		}
		String displayname = item.getItemMeta().getDisplayName();
		
		return m.toString() + "|" + amount + "|" + durability + "|" + enchantmentsstring + "|" + displayname;
	}
	public static ItemStack getItemStackFromString(String itemstack){
		String[] iargs = itemstack.split("\\|");
		
		ItemStack item = new ItemStack(Material.valueOf(iargs[0]), Integer.parseInt(iargs[1]));
		item.setDurability((short) Integer.parseInt(iargs[2]));
		
		if(iargs[3].contains(":")){
			String[] enchargs = iargs[3].split("\\:");
			for(String ench : enchargs){
				if(!ench.equals("Enchantments")){
					String ench2 = ench.replace("(", "|").replace(")", "");
					String[] enchs = ench2.split("\\|");
					
					item.addUnsafeEnchantment(Enchantment.getByName(enchs[0]), Integer.parseInt(enchs[1]));
				}
			}
		}
		
		if(!iargs[4].equals("null")){
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(iargs[4]);
			item.setItemMeta(meta);
		}
		
		return item;
	}
	
	public static String getStringFromLocation(Location l){
		String world = l.getWorld().getName();
		double x = l.getX();
		double y = l.getY();
		double z = l.getZ();
		float yaw = l.getYaw();
		float pitch = l.getPitch();
		
		return world + "|" + x + "|" + y + "|" + z + "|" + yaw + "|" + pitch;
	}
	public static Location getLocationFromString(String location){
		String[] largs = location.split("\\|");
		
		World w = Bukkit.getWorld(largs[0]);
		double x = Double.parseDouble(largs[1]);
		double y = Double.parseDouble(largs[2]);
		double z = Double.parseDouble(largs[3]);
		float yaw = Float.parseFloat(largs[4]);
		float pitch = Float.parseFloat(largs[5]);
		
		return new Location(w, x, y, z, yaw, pitch);
	}
}
