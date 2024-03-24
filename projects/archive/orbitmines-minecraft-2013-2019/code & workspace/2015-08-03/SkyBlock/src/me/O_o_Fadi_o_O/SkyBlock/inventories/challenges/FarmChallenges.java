package me.O_o_Fadi_o_O.SkyBlock.inventories.challenges;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.CustomItem;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FarmChallenges {

	public static Inventory getFarmChallengesInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 54, "§0§lFarm Challenges");

		setMelonsItem(inv, p);
		setHalloweenPartyItem(inv, p);
		setSugarcaneItem(inv, p);
		
		setMelonBlocksItem(inv, p);
		setMushroomHuntingItem(inv, p);
		setBaconItem(inv, p);
		
		setRabbitsItem(inv, p);
		setBakerItem(inv, p);
		setPotatoesItem(inv, p);
		
		setCookieMonsterItem(inv, p);
		setCactusItem(inv, p);
		
		setKFCDeliveryItem(inv, p);
		setSteakItem(inv, p);
		
		setGrandmothersKitchenItem(inv, p);
		setCakesItem(inv, p);
		
		ItemStack item = new ItemStack(Material.PAPER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§f§lChallenges");
		item.setItemMeta(itemmeta);
		inv.setItem(49, item);
		
		return inv;
	}
	
	public static void setMelonsItem(Inventory inv, Player p){
	
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Melons")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.MELON, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 50 Melons");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Spruce Sapling");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(1, item);
			}
		}
	}
	
	public static void setHalloweenPartyItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Halloween Party")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.PUMPKIN, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 32 Pumpkins");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Brown Mushroom");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(19, item);
			}
		}
	}
	
	public static void setSugarcaneItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Sugarcane")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.SUGAR_CANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 55 Sugarcane");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Sand");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(37, item);
			}
		}
	}
	
	public static void setMelonBlocksItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Melons")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Melon Blocks?!")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.MELON_BLOCK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Melons");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 32 Melon Blocks");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Dirt");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 32 Melon Blocks");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Dirt");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(2, item);
			}
		}
	}
	
	public static void setMushroomHuntingItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Halloween Party")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Mushroom Hunting")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.MUSHROOM_SOUP, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Halloween Party");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 30 Mushroom Stew");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Ice");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 30 Mushroom Stew");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Ice");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(20, item);
			}
		}
	}
	
	public static void setBaconItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Sugarcane")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Bacon")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.GRILLED_PORK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Sugarcane");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 40 Cooked Porkchop");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Cactus");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 40 Cooked Porkchop");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Cactus");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(38, item);
			}
		}
	}
	
	public static void setRabbitsItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Melon Blocks?!")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Rabbits")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.CARROT_ITEM, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Melon Blocks?!");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 100 Carrots");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Dark Oak Sapling");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 100 Carrots");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Dark Oak Sapling");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(3, item);
			}
		}
	}
	
	public static void setBakerItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Mushroom Hunting")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Baker")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.BREAD, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Mushroom Hunting");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 30 Bread");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Cocoa Beans");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 30 Bread");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Cocoa Beans");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(21, item);
			}
		}
	}
	
	public static void setPotatoesItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Bacon")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Potatoes")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.BAKED_POTATO, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Bacon");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 100 Baked Potatoes");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Acacia Sapling");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 100 Baked Potatoes");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Acacia Sapling");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(39, item);
			}
		}
	}
	
	public static void setCookieMonsterItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("Rabbits")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("Baker")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Cookie Monster")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.COOKIE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Rabbits");
					lore.add("    §c- Baker");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 200 Cookies");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 5 Lapis Lazuli Ore");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Rabbits");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 200 Cookies");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 5 Lapis Lazuli Ore");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Baker");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 200 Cookies");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 5 Lapis Lazuli Ore");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 200 Cookies");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 5 Lapis Lazuli Ore");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(13, item);
			}
		}
	}
	
	public static void setCactusItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("Baker")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("Potatoes")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Cactus")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.CACTUS, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Baker");
					lore.add("    §c- Potatoes");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 100 Cactus");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Slimeball");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Baker");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 100 Cactus");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Slimeball");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Potatoes");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 100 Cactus");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Slimeball");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 100 Cactus");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Slimeball");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(31, item);
			}
		}
	}
	
	public static void setKFCDeliveryItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Cookie Monster")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("KFC Delivery")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.COOKED_CHICKEN, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Cookie Monster");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 60 Cooked Chicken");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Sheep Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 60 Cooked Chicken");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Spawn Sheep Egg");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(14, item);
			}
		}
	}
	
	public static void setSteakItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Cactus")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Steak")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Cactus");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 80 Steak");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Mossy Cobblestone");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 80 Steak");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Mossy Cobblestone");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(32, item);
			}
		}
	}
	
	public static void setGrandmothersKitchenItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("KFC Delivery")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("Steak")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Grandmother's Kitchen")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.PUMPKIN_PIE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- KFC Delivery");
					lore.add("    §c- Steak");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 125 Pumpkin Pie");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 3 Yellow Flowers");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- KFC Delivery");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 125 Pumpkin Pie");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 3 Yellow Flowers");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Steak");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 125 Pumpkin Pie");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 3 Yellow Flowers");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 125 Pumpkin Pie");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 3 Yellow Flowers");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(24, item);
			}
		}
	}
	
	public static void setCakesItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.playerschallengescompleteamount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Grandmother's Kitchen")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Cakes")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.CAKE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Grandmother's Kitchen");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 3 Cakes");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Emerald Ore");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 3 Cakes");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Emerald Ore");
					lore.add("");
					lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
					lore.add("");
				}
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				if(amount > 0){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					item = CustomItem.hideFlags(item, 1);
				}
				inv.setItem(25, item);
			}
		}
	}
}
