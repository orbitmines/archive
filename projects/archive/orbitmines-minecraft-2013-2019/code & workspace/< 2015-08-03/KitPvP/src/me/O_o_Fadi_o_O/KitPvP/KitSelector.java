package me.O_o_Fadi_o_O.KitPvP;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelector {
	
	Start start = Start.getInstance();
	
	public Inventory getKitSelector(final Player p){
		
		final Inventory i = Bukkit.createInventory(null, 45, "§0§lKit Selector");
		
		{		
			i.setItem(9, KnightItem(p)); //1
			i.setItem(10, ArcherItem(p)); //2
			i.setItem(11, SoldierItem(p)); //3
			i.setItem(12, WizardItem(p)); //4
			i.setItem(13, TankItem(p)); //5
			i.setItem(14, DrunkItem(p)); //6
			i.setItem(15, PyroItem(p)); //7
			i.setItem(16, BunnyItem(p)); //8
			i.setItem(17, NecromancerItem(p)); //9
			i.setItem(18, KingItem(p)); //10
			i.setItem(19, TreeItem(p)); //11
			i.setItem(20, BlazeItem(p)); //12
			i.setItem(21, TNTItem(p)); //13
			i.setItem(22, FishermanItem(p)); //14
			i.setItem(23, SnowGolemItem(p)); //15
			i.setItem(24, LibrarianItem(p)); //16
			i.setItem(25, SpiderItem(p)); //17
			i.setItem(26, VillagerItem(p)); //18
			i.setItem(27, AssassinItem(p)); //19
			i.setItem(28, LordItem(p)); //20
			i.setItem(29, VampireItem(p)); //21
			i.setItem(30, DarkMageItem(p)); //22
			i.setItem(31, BeastItem(p)); //23
			i.setItem(32, FishItem(p)); //24
			i.setItem(33, HeavyItem(p)); //25
			i.setItem(34, GrimReaperItem(p)); //26
			i.setItem(35, MinerItem(p)); //27
		}

		
		return i;
	}
	
	public ItemStack KnightItem(Player p){
		ItemStack item = new ItemStack(Material.STONE_SWORD);
		item.setAmount(StorageManager.knight.get(p));
		if(StorageManager.knight.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.knight.get(p) == 0){
			itemmeta.setDisplayName("§b§lKnight");
		}
		else if(StorageManager.knight.get(p) == 1){
			itemmeta.setDisplayName("§b§lKnight §a§lLvL 1");
		}
		else if(StorageManager.knight.get(p) == 2){
			itemmeta.setDisplayName("§b§lKnight §a§lLvL 2");
		}
		else if(StorageManager.knight.get(p) == 3){
			itemmeta.setDisplayName("§b§lKnight §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.knight.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.knight.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.knight.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.knight.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack ArcherItem(Player p){
		ItemStack item = new ItemStack(Material.BOW);
		item.setAmount(StorageManager.archer.get(p));
		if(StorageManager.archer.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.archer.get(p) == 0){
			itemmeta.setDisplayName("§b§lArcher");
		}
		else if(StorageManager.archer.get(p) == 1){
			itemmeta.setDisplayName("§b§lArcher §a§lLvL 1");
		}
		else if(StorageManager.archer.get(p) == 2){
			itemmeta.setDisplayName("§b§lArcher §a§lLvL 2");
		}
		else if(StorageManager.archer.get(p) == 3){
			itemmeta.setDisplayName("§b§lArcher §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.archer.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.archer.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.archer.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.archer.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	public ItemStack SoldierItem(Player p){
		ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
		item.setAmount(StorageManager.soldier.get(p));
		if(StorageManager.soldier.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.soldier.get(p) == 0){
			itemmeta.setDisplayName("§b§lSoldier");
		}
		else if(StorageManager.soldier.get(p) == 1){
			itemmeta.setDisplayName("§b§lSoldier §a§lLvL 1");
		}
		else if(StorageManager.soldier.get(p) == 2){
			itemmeta.setDisplayName("§b§lSoldier §a§lLvL 2");
		}
		else if(StorageManager.soldier.get(p) == 3){
			itemmeta.setDisplayName("§b§lSoldier §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.soldier.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.soldier.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.soldier.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.soldier.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack WizardItem(Player p){
		ItemStack item = new ItemStack(Material.POTION);
		item.setAmount(StorageManager.wizard.get(p));
		if(StorageManager.wizard.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.wizard.get(p) == 0){
			itemmeta.setDisplayName("§b§lWizard");
		}
		else if(StorageManager.wizard.get(p) == 1){
			itemmeta.setDisplayName("§b§lWizard §a§lLvL 1");
		}
		else if(StorageManager.wizard.get(p) == 2){
			itemmeta.setDisplayName("§b§lWizard §a§lLvL 2");
		}
		else if(StorageManager.wizard.get(p) == 3){
			itemmeta.setDisplayName("§b§lWizard §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.wizard.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.wizard.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.wizard.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.wizard.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack TankItem(Player p){
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		item.setAmount(StorageManager.tank.get(p));
		if(StorageManager.tank.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.tank.get(p) == 0){
			itemmeta.setDisplayName("§b§lTank");
		}
		else if(StorageManager.tank.get(p) == 1){
			itemmeta.setDisplayName("§b§lTank §a§lLvL 1");
		}
		else if(StorageManager.tank.get(p) == 2){
			itemmeta.setDisplayName("§b§lTank §a§lLvL 2");
		}
		else if(StorageManager.tank.get(p) == 3){
			itemmeta.setDisplayName("§b§lTank §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.tank.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.tank.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.tank.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.tank.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack DrunkItem(Player p){
		ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		item.setAmount(StorageManager.drunk.get(p));
		if(StorageManager.drunk.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.drunk.get(p) == 0){
			itemmeta.setDisplayName("§b§lDrunk");
		}
		else if(StorageManager.drunk.get(p) == 1){
			itemmeta.setDisplayName("§b§lDrunk §a§lLvL 1");
		}
		else if(StorageManager.drunk.get(p) == 2){
			itemmeta.setDisplayName("§b§lDrunk §a§lLvL 2");
		}
		else if(StorageManager.drunk.get(p) == 3){
			itemmeta.setDisplayName("§b§lDrunk §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.drunk.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.drunk.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.drunk.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.drunk.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack PyroItem(Player p){
		ItemStack item = new ItemStack(Material.GOLD_HELMET);
		item.setAmount(StorageManager.pyro.get(p));
		if(StorageManager.pyro.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.pyro.get(p) == 0){
			itemmeta.setDisplayName("§b§lPyro");
		}
		else if(StorageManager.pyro.get(p) == 1){
			itemmeta.setDisplayName("§b§lPyro §a§lLvL 1");
		}
		else if(StorageManager.pyro.get(p) == 2){
			itemmeta.setDisplayName("§b§lPyro §a§lLvL 2");
		}
		else if(StorageManager.pyro.get(p) == 3){
			itemmeta.setDisplayName("§b§lPyro §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.pyro.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.pyro.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.pyro.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.pyro.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack BunnyItem(Player p){
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		item.setAmount(StorageManager.bunny.get(p));
		if(StorageManager.bunny.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.bunny.get(p) == 0){
			itemmeta.setDisplayName("§b§lBunny");
		}
		else if(StorageManager.bunny.get(p) == 1){
			itemmeta.setDisplayName("§b§lBunny §a§lLvL 1");
		}
		else if(StorageManager.bunny.get(p) == 2){
			itemmeta.setDisplayName("§b§lBunny §a§lLvL 2");
		}
		else if(StorageManager.bunny.get(p) == 3){
			itemmeta.setDisplayName("§b§lBunny §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.bunny.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.bunny.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.bunny.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.bunny.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack NecromancerItem(Player p){
		ItemStack item = new ItemStack(Material.GOLD_HOE);
		item.setAmount(StorageManager.necromancer.get(p));
		if(StorageManager.necromancer.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.necromancer.get(p) == 0){
			itemmeta.setDisplayName("§b§lNecromancer");
		}
		else if(StorageManager.necromancer.get(p) == 1){
			itemmeta.setDisplayName("§b§lNecromancer §a§lLvL 1");
		}
		else if(StorageManager.necromancer.get(p) == 2){
			itemmeta.setDisplayName("§b§lNecromancer §a§lLvL 2");
		}
		else if(StorageManager.necromancer.get(p) == 3){
			itemmeta.setDisplayName("§b§lNecromancer §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.necromancer.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.necromancer.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.necromancer.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.necromancer.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack KingItem(Player p){
		ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
		item.setAmount(StorageManager.king.get(p));
		if(StorageManager.king.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.king.get(p) == 0){
			itemmeta.setDisplayName("§b§lKing");
		}
		else if(StorageManager.king.get(p) == 1){
			itemmeta.setDisplayName("§b§lKing §a§lLvL 1");
		}
		else if(StorageManager.king.get(p) == 2){
			itemmeta.setDisplayName("§b§lKing §a§lLvL 2");
		}
		else if(StorageManager.king.get(p) == 3){
			itemmeta.setDisplayName("§b§lKing §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.king.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.king.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.king.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.king.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack TreeItem(Player p){
		ItemStack item = new ItemStack(Material.LEAVES);
		item.setAmount(StorageManager.tree.get(p));
		if(StorageManager.tree.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.tree.get(p) == 0){
			itemmeta.setDisplayName("§b§lTree");
		}
		else if(StorageManager.tree.get(p) == 1){
			itemmeta.setDisplayName("§b§lTree §a§lLvL 1");
		}
		else if(StorageManager.tree.get(p) == 2){
			itemmeta.setDisplayName("§b§lTree §a§lLvL 2");
		}
		else if(StorageManager.tree.get(p) == 3){
			itemmeta.setDisplayName("§b§lTree §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.tree.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.tree.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.tree.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.tree.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack BlazeItem(Player p){
		ItemStack item = new ItemStack(Material.BLAZE_POWDER);
		item.setAmount(StorageManager.blaze.get(p));
		if(StorageManager.blaze.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.blaze.get(p) == 0){
			itemmeta.setDisplayName("§b§lBlaze");
		}
		else if(StorageManager.blaze.get(p) == 1){
			itemmeta.setDisplayName("§b§lBlaze §a§lLvL 1");
		}
		else if(StorageManager.blaze.get(p) == 2){
			itemmeta.setDisplayName("§b§lBlaze §a§lLvL 2");
		}
		else if(StorageManager.blaze.get(p) == 3){
			itemmeta.setDisplayName("§b§lBlaze §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.blaze.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.blaze.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.blaze.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.blaze.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack TNTItem(Player p){
		ItemStack item = new ItemStack(Material.TNT);
		item.setAmount(StorageManager.tnt.get(p));
		if(StorageManager.tnt.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.tnt.get(p) == 0){
			itemmeta.setDisplayName("§b§lTNT");
		}
		else if(StorageManager.tnt.get(p) == 1){
			itemmeta.setDisplayName("§b§lTNT §a§lLvL 1");
		}
		else if(StorageManager.tnt.get(p) == 2){
			itemmeta.setDisplayName("§b§lTNT §a§lLvL 2");
		}
		else if(StorageManager.tnt.get(p) == 3){
			itemmeta.setDisplayName("§b§lTNT §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.tnt.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.tnt.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.tnt.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.tnt.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack FishermanItem(Player p){
		ItemStack item = new ItemStack(Material.FISHING_ROD);
		item.setAmount(StorageManager.fisherman.get(p));
		if(StorageManager.fisherman.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.fisherman.get(p) == 0){
			itemmeta.setDisplayName("§b§lFisherman");
		}
		else if(StorageManager.fisherman.get(p) == 1){
			itemmeta.setDisplayName("§b§lFisherman §a§lLvL 1");
		}
		else if(StorageManager.fisherman.get(p) == 2){
			itemmeta.setDisplayName("§b§lFisherman §a§lLvL 2");
		}
		else if(StorageManager.fisherman.get(p) == 3){
			itemmeta.setDisplayName("§b§lFisherman §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.fisherman.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.fisherman.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.fisherman.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.fisherman.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack SnowGolemItem(Player p){
		ItemStack item = new ItemStack(Material.PUMPKIN);
		item.setAmount(StorageManager.snowgolem.get(p));
		if(StorageManager.snowgolem.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.snowgolem.get(p) == 0){
			itemmeta.setDisplayName("§b§lSnowGolem");
		}
		else if(StorageManager.snowgolem.get(p) == 1){
			itemmeta.setDisplayName("§b§lSnowGolem §a§lLvL 1");
		}
		else if(StorageManager.snowgolem.get(p) == 2){
			itemmeta.setDisplayName("§b§lSnowGolem §a§lLvL 2");
		}
		else if(StorageManager.snowgolem.get(p) == 3){
			itemmeta.setDisplayName("§b§lSnowGolem §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.snowgolem.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.snowgolem.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.snowgolem.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.snowgolem.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack LibrarianItem(Player p){
		ItemStack item = new ItemStack(Material.BOOKSHELF);
		item.setAmount(StorageManager.librarian.get(p));
		if(StorageManager.librarian.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.librarian.get(p) == 0){
			itemmeta.setDisplayName("§b§lLibrarian");
		}
		else if(StorageManager.librarian.get(p) == 1){
			itemmeta.setDisplayName("§b§lLibrarian §a§lLvL 1");
		}
		else if(StorageManager.librarian.get(p) == 2){
			itemmeta.setDisplayName("§b§lLibrarian §a§lLvL 2");
		}
		else if(StorageManager.librarian.get(p) == 3){
			itemmeta.setDisplayName("§b§lLibrarian §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.librarian.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.librarian.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.librarian.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.librarian.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack SpiderItem(Player p){
		ItemStack item = new ItemStack(Material.SPIDER_EYE);
		item.setAmount(StorageManager.spider.get(p));
		if(StorageManager.spider.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.spider.get(p) == 0){
			itemmeta.setDisplayName("§b§lSpider");
		}
		else if(StorageManager.spider.get(p) == 1){
			itemmeta.setDisplayName("§b§lSpider §a§lLvL 1");
		}
		else if(StorageManager.spider.get(p) == 2){
			itemmeta.setDisplayName("§b§lSpider §a§lLvL 2");
		}
		else if(StorageManager.spider.get(p) == 3){
			itemmeta.setDisplayName("§b§lSpider §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.spider.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.spider.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.spider.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.spider.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack VillagerItem(Player p){
		ItemStack item = new ItemStack(Material.EMERALD);
		item.setAmount(StorageManager.villager.get(p));
		if(StorageManager.villager.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.villager.get(p) == 0){
			itemmeta.setDisplayName("§b§lVillager");
		}
		else if(StorageManager.villager.get(p) == 1){
			itemmeta.setDisplayName("§b§lVillager §a§lLvL 1");
		}
		else if(StorageManager.villager.get(p) == 2){
			itemmeta.setDisplayName("§b§lVillager §a§lLvL 2");
		}
		else if(StorageManager.villager.get(p) == 3){
			itemmeta.setDisplayName("§b§lVillager §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.villager.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.villager.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.villager.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.villager.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack AssassinItem(Player p){
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		if(StorageManager.assassin.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.assassin.get(p) == 0){
			itemmeta.setDisplayName("§b§lAssassin");
		}
		else if(StorageManager.assassin.get(p) == 1){
			itemmeta.setDisplayName("§b§lAssassin §a§lLvL 1");
		}
		else if(StorageManager.assassin.get(p) == 2){
			itemmeta.setDisplayName("§b§lAssassin §a§lLvL 2");
		}
		else if(StorageManager.assassin.get(p) == 3){
			itemmeta.setDisplayName("§b§lAssassin §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.assassin.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.assassin.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.assassin.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.assassin.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack LordItem(Player p){
		ItemStack item = new ItemStack(Material.GOLD_SWORD);
		item.setAmount(StorageManager.lord.get(p));
		if(StorageManager.lord.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.lord.get(p) == 0){
			itemmeta.setDisplayName("§b§lLord");
		}
		else if(StorageManager.lord.get(p) == 1){
			itemmeta.setDisplayName("§b§lLord §a§lLvL 1");
		}
		else if(StorageManager.lord.get(p) == 2){
			itemmeta.setDisplayName("§b§lLord §a§lLvL 2");
		}
		else if(StorageManager.lord.get(p) == 3){
			itemmeta.setDisplayName("§b§lLord §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.lord.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.lord.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.lord.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.lord.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack VampireItem(Player p){
		ItemStack item = new ItemStack(Material.REDSTONE);
		item.setAmount(StorageManager.vampire.get(p));
		if(StorageManager.vampire.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.vampire.get(p) == 0){
			itemmeta.setDisplayName("§b§lVampire");
		}
		else if(StorageManager.vampire.get(p) == 1){
			itemmeta.setDisplayName("§b§lVampire §a§lLvL 1");
		}
		else if(StorageManager.vampire.get(p) == 2){
			itemmeta.setDisplayName("§b§lVampire §a§lLvL 2");
		}
		else if(StorageManager.vampire.get(p) == 3){
			itemmeta.setDisplayName("§b§lVampire §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.vampire.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.vampire.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.vampire.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.vampire.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack DarkMageItem(Player p){
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		item.setAmount(StorageManager.darkmage.get(p));
		if(StorageManager.darkmage.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.darkmage.get(p) == 0){
			itemmeta.setDisplayName("§b§lDarkMage");
		}
		else if(StorageManager.darkmage.get(p) == 1){
			itemmeta.setDisplayName("§b§lDarkMage §a§lLvL 1");
		}
		else if(StorageManager.darkmage.get(p) == 2){
			itemmeta.setDisplayName("§b§lDarkMage §a§lLvL 2");
		}
		else if(StorageManager.darkmage.get(p) == 3){
			itemmeta.setDisplayName("§b§lDarkMage §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.darkmage.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.darkmage.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.darkmage.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.darkmage.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack BeastItem(Player p){
		ItemStack item = new ItemStack(Material.IRON_AXE);
		item.setAmount(StorageManager.beast.get(p));
		if(StorageManager.beast.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.beast.get(p) == 0){
			itemmeta.setDisplayName("§b§lBeast");
		}
		else if(StorageManager.beast.get(p) == 1){
			itemmeta.setDisplayName("§b§lBeast §a§lLvL 1");
		}
		else if(StorageManager.beast.get(p) == 2){
			itemmeta.setDisplayName("§b§lBeast §a§lLvL 2");
		}
		else if(StorageManager.beast.get(p) == 3){
			itemmeta.setDisplayName("§b§lBeast §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.beast.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.beast.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.beast.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.beast.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack FishItem(Player p){
		ItemStack item = new ItemStack(Material.RAW_FISH);
		item.setAmount(StorageManager.fish.get(p));
		if(StorageManager.fish.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.fish.get(p) == 0){
			itemmeta.setDisplayName("§b§lFish");
		}
		else if(StorageManager.fish.get(p) == 1){
			itemmeta.setDisplayName("§b§lFish §a§lLvL 1");
		}
		else if(StorageManager.fish.get(p) == 2){
			itemmeta.setDisplayName("§b§lFish §a§lLvL 2");
		}
		else if(StorageManager.fish.get(p) == 3){
			itemmeta.setDisplayName("§b§lFish §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.fish.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.fish.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.fish.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.fish.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack HeavyItem(Player p){
		ItemStack item = new ItemStack(Material.ARROW);
		item.setAmount(StorageManager.heavy.get(p));
		if(StorageManager.heavy.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.heavy.get(p) == 0){
			itemmeta.setDisplayName("§b§lHeavy");
		}
		else if(StorageManager.heavy.get(p) == 1){
			itemmeta.setDisplayName("§b§lHeavy §a§lLvL 1");
		}
		else if(StorageManager.heavy.get(p) == 2){
			itemmeta.setDisplayName("§b§lHeavy §a§lLvL 2");
		}
		else if(StorageManager.heavy.get(p) == 3){
			itemmeta.setDisplayName("§b§lHeavy §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.heavy.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.heavy.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.heavy.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.heavy.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack GrimReaperItem(Player p){
		ItemStack item = new ItemStack(Material.SKULL_ITEM);
		item.setAmount(StorageManager.grimreaper.get(p));
		if(StorageManager.grimreaper.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		item.setDurability((short) 1);
		// DISPLAY ON KIT LEVEL
		if(StorageManager.grimreaper.get(p) == 0){
			itemmeta.setDisplayName("§b§lGrimReaper");
		}
		else if(StorageManager.grimreaper.get(p) == 1){
			itemmeta.setDisplayName("§b§lGrimReaper §a§lLvL 1");
		}
		else if(StorageManager.grimreaper.get(p) == 2){
			itemmeta.setDisplayName("§b§lGrimReaper §a§lLvL 2");
		}
		else if(StorageManager.grimreaper.get(p) == 3){
			itemmeta.setDisplayName("§b§lGrimReaper §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.grimreaper.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.grimreaper.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.grimreaper.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.grimreaper.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
	
	public ItemStack MinerItem(Player p){
		ItemStack item = new ItemStack(Material.GOLD_PICKAXE);
		item.setAmount(StorageManager.miner.get(p));
		if(StorageManager.miner.get(p) != 0){
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		}
		ItemMeta itemmeta = item.getItemMeta();
		// DISPLAY ON KIT LEVEL
		if(StorageManager.miner.get(p) == 0){
			itemmeta.setDisplayName("§b§lMiner");
		}
		else if(StorageManager.miner.get(p) == 1){
			itemmeta.setDisplayName("§b§lMiner §a§lLvL 1");
		}
		else if(StorageManager.miner.get(p) == 2){
			itemmeta.setDisplayName("§b§lMiner §a§lLvL 2");
		}
		else if(StorageManager.miner.get(p) == 3){
			itemmeta.setDisplayName("§b§lMiner §a§lLvL 3");
		}
		
		List<String> l = new ArrayList<String>();
				
		// LORE ON KIT LEVEL
		if(StorageManager.miner.get(p) == 0){
			if(Start.freekitenabled == false){
				l.add("");
				l.add("§4§lLocked");
				l.add("");
				l.add("§c§o§l§mRight Click §c§m(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Buy Kit)");
			}
			else{
				l.add("");
				l.add("§d§lFREE Kit Saturday!");
				l.add("");
				l.add("§e§l§oRight Click §7(Select Kit)");
				l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
			}
		}
		if(StorageManager.miner.get(p) == 1){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 1§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.miner.get(p) == 2){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 2§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details & Upgrade Kit)");
		}
		if(StorageManager.miner.get(p) == 3){
			l.add("");
			l.add("§a§lUnlocked §7§o(§a§oLvL 3§7§o)");
			l.add("");
			l.add("§e§l§oRight Click §7(Select Kit)");
			l.add("§6§l§oLeft Click §7(Details)");
		}
				
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item = CustomItem.hideFlags(item, 3);
			
		return item;
	}
}
