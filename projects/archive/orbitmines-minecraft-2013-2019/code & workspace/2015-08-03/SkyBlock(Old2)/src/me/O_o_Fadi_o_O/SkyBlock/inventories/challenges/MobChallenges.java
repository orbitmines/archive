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

public class MobChallenges {

	public static Inventory getMobChallengesInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 54, "§0§lMob Challenges");

		setSkeletonItem(inv, p);
		setArrowsItem(inv, p);
		setComingSoon(inv, p, 37);//setSugarcaneItem(inv, p);
		
		setZombieApocalypseItem(inv, p);
		setCreepyCreeperItem(inv, p);
		setComingSoon(inv, p, 38);///setBaconItem(inv, p);
		
		setDestoryTheWebsItem(inv, p);
		
		setSpiderEyesItem(inv, p);
		setComingSoon(inv, p, 39);//setPotatoesItem(inv, p);
		
		setEnderwomanItem(inv, p);
		setComingSoon(inv, p, 31);//setCactusItem(inv, p);
		
		setComingSoon(inv, p, 14);//setKFCDeliveryItem(inv, p);
		setComingSoon(inv, p, 32);//setSteakItem(inv, p);
		
		setComingSoon(inv, p, 24);//setGrandmothersKitchenItem(inv, p);
		setComingSoon(inv, p, 25);//setCakesItem(inv, p);
		
		ItemStack item = new ItemStack(Material.PAPER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§f§lChallenges");
		item.setItemMeta(itemmeta);
		inv.setItem(49, item);
		
		return inv;
	}
	
	public static void setComingSoon(Inventory inv, Player p, int slot){
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§a§oComing Soon...");
		item.setItemMeta(itemmeta);
		item.setDurability((short) 15);
		inv.setItem(slot, item);
	}
	
	public static void setSkeletonItem(Inventory inv, Player p){
	
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Skeletons")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.BONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 150 Bones");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 1 Jungle Sapling");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(1, item);
			}
		}
	}
	
	public static void setArrowsItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		for(String s : challenges){
			if(s.startsWith("Arrows!")){
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.ARROW, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§l" + challenge);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("  §2§lRequired:");
				lore.add("    §d- 200 Arrows");
				lore.add("");
				lore.add("  §6§lReward:");
				lore.add("    §d- 20 Cobblestone");
				lore.add("");
				lore.add("  §b§lTimes Completed: §f§l" + amount + "  ");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				inv.setItem(19, item);
			}
		}
	}
	
	//TODO: COMING SOON
	public static void setSugarcaneItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(37, item);
			}
		}
	}
	
	public static void setZombieApocalypseItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Skeletons")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Zombie Apocalypse")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.ROTTEN_FLESH, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Skeletons");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 175 Zombie Flesh");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 3 Raw Fish");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 175 Zombie Flesh");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 3 Raw Fish");
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
	
	public static void setCreepyCreeperItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Arrows!")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Creepy Creeper")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.SULPHUR, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Arrows!");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 225 Gunpowder");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Squid Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 225 Gunpowder");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Spawn Squid Egg");
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
	
	//TODO: COMING SOON
	public static void setBaconItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(38, item);
			}
		}
	}
	
	public static void setDestoryTheWebsItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Zombie Apocalypse")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Destroy the Webs!")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.STRING, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Zombie Apocalypse");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 200 String");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Red Mushroom");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 200 String");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Red Mushroom");
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
	
	public static void setSpiderEyesItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete = false;
		
		for(String s : challenges){
			if(s.startsWith("Creepy Creeper")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Spider Eyes")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.SPIDER_EYE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				if(canComplete == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Creepy Creeper");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 15 Spider Eyes");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Wheat");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 15 Spider Eyes");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Wheat");
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
	
	public static void setPotatoesItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(39, item);
			}
		}
	}
	
	public static void setEnderwomanItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
		boolean canComplete1 = false;
		boolean canComplete2 = false;
		
		for(String s : challenges){
			if(s.startsWith("Destroy the Webs!")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete1 = true;
				}
			}
			if(s.startsWith("Spider Eyes")){
				String[] challengeFormat = s.split("\\|");
				
				int amount = Integer.parseInt(challengeFormat[1]);
				
				if(amount >= 1){
					canComplete2 = true;
				}
			}
		}
		
		for(String s : challenges){
			if(s.startsWith("Enderwoman")){
				
				String[] challengeFormat = s.split("\\|");
				
				String challenge = challengeFormat[0];
				int amount = Integer.parseInt(challengeFormat[1]);
				
				ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				
				if(canComplete1 == false && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Destroy the Webs!");
					lore.add("    §c- Spider Eyes");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 16 Enderpearls");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Chicken Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == false && canComplete2 == true){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Destroy the Webs!");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 16 Enderpearls");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Chicken Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else if(canComplete1 == true && canComplete2 == false){
					itemmeta.setDisplayName("§c§l" + challenge);
					lore.add("");
					lore.add("  §4§lRequires the following Challenges:  ");
					lore.add("    §c- Spider Eyes");
					lore.add("");
					lore.add("  §7§lRequired:");
					lore.add("    §8- 16 Enderpearls");
					lore.add("");
					lore.add("  §7§lReward:");
					lore.add("    §8- 1 Spawn Chicken Egg");
					lore.add("");
					lore.add("  §8§lTimes Completed: §7§l" + amount + "  ");
					lore.add("");
				}
				else{
					itemmeta.setDisplayName("§a§l" + challenge);
					lore.add("");
					lore.add("  §2§lRequired:");
					lore.add("    §d- 16 Enderpearls");
					lore.add("");
					lore.add("  §6§lReward:");
					lore.add("    §d- 1 Spawn Chicken Egg");
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
	
	public static void setCactusItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(31, item);
			}
		}
	}
	
	public static void setKFCDeliveryItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(14, item);
			}
		}
	}
	
	public static void setSteakItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(32, item);
			}
		}
	}
	
	public static void setGrandmothersKitchenItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(24, item);
			}
		}
	}
	
	public static void setCakesItem(Inventory inv, Player p){
		
		List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
		
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
				inv.setItem(25, item);
			}
		}
	}
}
