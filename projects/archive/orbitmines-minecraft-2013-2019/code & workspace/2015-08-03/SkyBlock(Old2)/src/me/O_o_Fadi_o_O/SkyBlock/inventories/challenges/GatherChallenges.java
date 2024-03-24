package me.O_o_Fadi_o_O.SkyBlock.inventories.challenges;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GatherChallenges {

	public static Inventory getGatherChallengesInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 54, "§0§lGather Challenges");

		setCobblestoneGeneratorItem(inv, p);
		setApplesItem(inv, p);
		setJackTheLumberjackItem(inv, p);
		
		setMoreSmoothnessItem(inv, p);
		setFishingTimeItem(inv, p);
		setChopChopItem(inv, p);
		
		setNavigationItem(inv, p);
		setLibrarianItem(inv, p);
		setTheDarkForestItem(inv, p);
		
		setItsTimeItem(inv, p);
		setStainedClayItem(inv, p);
		
		setSheepShearingItem(inv, p);
		setWindowsItem(inv, p);
		
		setWoodFactoryItem(inv, p);
		setLuckyFishingItem(inv, p);
		
		ItemStack item = new ItemStack(Material.PAPER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§f§lChallenges");
		item.setItemMeta(itemmeta);
		inv.setItem(49, item);
		
		return inv;
	}
	
	public static void setCobblestoneGeneratorItem(Inventory inv, Player p){
	
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Cobblestone Generator")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 32 Cobblestone");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Birch Sapling");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(1, item);
			}
		}
	}
	
	public static void setApplesItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Apples")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.APPLE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 1 Apple");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Sugarcane");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(19, item);
			}
		}
	}
	
	public static void setJackTheLumberjackItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Jack the Lumberjack")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.LOG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 25 Oak Logs");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Melon Seed");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(37, item);
			}
		}
	}
	
	public static void setMoreSmoothnessItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Cobblestone Generator")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("More Smoothness")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.SMOOTH_BRICK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Cobblestone Generator");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 40 Stone Bricks");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Iron Ingot");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 40 Stone Bricks");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Iron Ingot");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(2, item);
			}
		}
	}
	
	public static void setFishingTimeItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Apples")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Fishing Time!")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.RAW_FISH, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Apples");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 10 Raw Fish");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 2 Leather");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 10 Raw Fish");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 2 Leather");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(20, item);
			}
		}
	}
	
	public static void setChopChopItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Jack the Lumberjack")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Chop Chop")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.LOG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Jack the Lumberjack");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 32 Oak Logs");
					lore.add("    §8- 32 Birch Logs");
					lore.add("    §8- 32 Spruce Logs");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 16 Clay");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 32 Oak Logs");
					lore.add("    §d- 32 Birch Logs");
					lore.add("    §d- 32 Spruce Logs");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 16 Clay");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(38, item);
			}
		}
	}
	
	public static void setNavigationItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("More Smoothness")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Navigation")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.COMPASS, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- More Smoothness");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 1 Compass");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Pumpkin Seed");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 1 Compass");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Pumpkin Seed");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(3, item);
			}
		}
	}
	
	public static void setLibrarianItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Fishing Time!")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Librarian")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.BOOKSHELF, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Fishing Time!");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 2 Bookshelfs");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 3 Gold Ore");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 2 Bookshelfs");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 3 Gold Ore");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(21, item);
			}
		}
	}
	
	public static void setTheDarkForestItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Chop Chop")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("The Dark Forest")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.LOG_2, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Chop Chop");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 64 Dark Oak Logs");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 2 Poppies");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 64 Dark Oak Logs");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 2 Poppies");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(39, item);
			}
		}
	}
	
	public static void setItsTimeItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("Navigation")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("Librarian")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("It's Time")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.WATCH, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Navigation");
					lore.add("    §c- Librarian");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 1 Clock");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Pig Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Navigation");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 1 Clock");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Pig Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Librarian");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 1 Clock");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Pig Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 1 Clock");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Spawn Pig Egg");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(13, item);
			}
		}
	}
	
	public static void setStainedClayItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("Librarian")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("The Dark Forest")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Stained Clay")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.STAINED_CLAY, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Librarian");
					lore.add("    §c- The Dark Forest");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 28 Red Stained Clay");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Mycelium");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Librarian");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 28 Red Stained Clay");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Mycelium");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- The Dark Forest");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 28 Red Stained Clay");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Mycelium");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 28 Red Stained Clay");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Mycelium");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(31, item);
			}
		}
	}
	
	public static void setSheepShearingItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("It's Time")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Sheep Shearing")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.WOOL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- It's Time");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 50 White Wool");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 3 Gravel");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 50 White Wool");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 3 Gravel");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(14, item);
			}
		}
	}
	
	public static void setWindowsItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Stained Clay")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Windows")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Stained Clay");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 16 Red Stained Glass");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 2 Obsidian");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 16 Red Stained Glass");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 2 Obsidian");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(32, item);
			}
		}
	}
	
	public static void setWoodFactoryItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("Sheep Shearing")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("Windows")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Wood Factory")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.LOG_2, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Sheep Shearing");
					lore.add("    §c- Windows");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 64 Oak Logs");
					lore.add("    §8- 64 Birch Logs");
					lore.add("    §8- 64 Spruce Logs");
					lore.add("    §8- 64 Dark Oak Logs");
					lore.add("    §8- 64 Jungle Logs");
					lore.add("    §8- 64 Acacia Logs");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Cow Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Sheep Shearing");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 64 Oak Logs");
					lore.add("    §8- 64 Birch Logs");
					lore.add("    §8- 64 Spruce Logs");
					lore.add("    §8- 64 Dark Oak Logs");
					lore.add("    §8- 64 Jungle Logs");
					lore.add("    §8- 64 Acacia Logs");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Cow Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Windows");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 64 Oak Logs");
					lore.add("    §8- 64 Birch Logs");
					lore.add("    §8- 64 Spruce Logs");
					lore.add("    §8- 64 Dark Oak Logs");
					lore.add("    §8- 64 Jungle Logs");
					lore.add("    §8- 64 Acacia Logs");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Cow Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 64 Oak Logs");
					lore.add("    §d- 64 Birch Logs");
					lore.add("    §d- 64 Spruce Logs");
					lore.add("    §d- 64 Dark Oak Logs");
					lore.add("    §d- 64 Jungle Logs");
					lore.add("    §d- 64 Acacia Logs");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Spawn Cow Egg");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(24, item);
			}
		}
	}
	
	public static void setLuckyFishingItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Wood Factory")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Lucky Fishing")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.NAME_TAG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Wood Factory");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 3 Name Tags");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Diamond");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 3 Name Tags");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Diamond");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(25, item);
			}
		}
	}
}
