package me.O_o_Fadi_o_O.Prison.prisonInv;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VillagerGamble {

	public static void openVillagerGambleInv(Player p){
		Inventory inv = Bukkit.createInventory(null, 45, "§0§lVillager Gamble");
		
		
		setItem(inv, p, Material.EMERALD, (short) 0, 1, "§aYour Gamble Tickets: §2§l" + StorageManager.PlayerGambleTickets.get(p), getGambleTicketsItemLore(), 13, false);
		setItem(inv, p, Material.IRON_BLOCK, (short) 0, 1, "§7§lIron Gamble Machine", getIronGambleMachineItemLore(), 30, false);
		setItem(inv, p, Material.GOLD_BLOCK, (short) 0, 1, "§6§lGold Gamble Machine", getGoldGambleMachineItemLore(), 31, false);
		setItem(inv, p, Material.DIAMOND_BLOCK, (short) 0, 1, "§b§lDiamond Gamble Machine", getDiamondGambleMachineItemLore(), 32, false);

		
		p.openInventory(inv);
	}
	
	public static List<String> getIronGambleMachineItemLore(){
		List<String> list = new ArrayList<String>();
		
		list.add("");
		list.add("§c§oPrice: §a1 Gamble Ticket");
		list.add("");
		list.add("§fAvailable Prizes:");
		list.add("  §7- Iron Pickaxe (Efficiency IV, Unbreaking V)");
		list.add("  §7- 10000 Gold");
		list.add("  §7- 2500 Gold");
		list.add("  §7- 2 Gamble Tickets");
		list.add("  §7- 5000 Gold");
		list.add("  §7- Iron Pickaxe (Efficiency III)");
		list.add("  §7- 1 Rare Chest");
		list.add("  §7- Diamond Pickaxe (Efficiency IV, Unbreaking V)");
		list.add("  §7- 100 Gold");
		list.add("  §7- 20000 Gold");
		list.add("  §7- Diamond Pickaxe (Efficiency IV)");
		list.add("  §7- 1 Gamble Ticket");
		list.add("  §7- 30000 Gold");
		
		return list;
	}
	
	public static List<String> getGoldGambleMachineItemLore(){
		List<String> list = new ArrayList<String>();
		
		list.add("");
		list.add("§a§oComing Soon");
		list.add("");
		
		return list;
	}
	
	public static List<String> getDiamondGambleMachineItemLore(){
		List<String> list = new ArrayList<String>();
		
		list.add("");
		list.add("§a§oComing Soon");
		list.add("");
		
		return list;
	}
	
	public static void clearInventory(Inventory inv){
		inv.clear();
	}
	
	public static void setAllRandomItemsIronGambleMachine(Inventory inv){
		
		setRandomItemIronGamble(inv, 2);
		setRandomItemIronGamble(inv, 11);
		setRandomItemIronGamble(inv, 20);
		setRandomItemIronGamble(inv, 29);
		setRandomItemIronGamble(inv, 38);
		
		setRandomItemIronGamble(inv, 4);
		setRandomItemIronGamble(inv, 13);
		setRandomItemIronGamble(inv, 22);
		setRandomItemIronGamble(inv, 31);
		setRandomItemIronGamble(inv, 40);
		
		setRandomItemIronGamble(inv, 6);
		setRandomItemIronGamble(inv, 15);
		setRandomItemIronGamble(inv, 24);
		setRandomItemIronGamble(inv, 33);
		setRandomItemIronGamble(inv, 42);
		
	}
	
	public static void setAllPreviousItemIronGamble(Inventory inv){
		
		setPreviousItemIronGamble(inv, 38);
		setPreviousItemIronGamble(inv, 40);
		setPreviousItemIronGamble(inv, 42);
		
		setPreviousItemIronGamble(inv, 29);
		setPreviousItemIronGamble(inv, 31);
		setPreviousItemIronGamble(inv, 33);
		
		setPreviousItemIronGamble(inv, 20);
		setPreviousItemIronGamble(inv, 22);
		setPreviousItemIronGamble(inv, 24);
		
		setPreviousItemIronGamble(inv, 11);
		setPreviousItemIronGamble(inv, 13);
		setPreviousItemIronGamble(inv, 15);
		
		setPreviousItemIronGamble(inv, 2);
		setPreviousItemIronGamble(inv, 4);
		setPreviousItemIronGamble(inv, 6);
	}
	
	public static void setPreviousItemIronGamble(Inventory inv, int slot){
		int prevSlot = slot -9;
		try{
		inv.setItem(slot, inv.getItem(prevSlot));
		}catch(Exception ex){setRandomItemIronGamble(inv, slot);}
	}
	
	public static void setRandomItemIronGamble(Inventory inv, int slot){
		Random r = new Random();
		int rInt = r.nextInt(1000);
		
		int nextLowestInt = 0;
		
		ItemStack item = null;
		
		if(Prison.isIntEqualTo(rInt, 0, nextLowestInt + 50)){
			item = new ItemStack(Material.IRON_PICKAXE);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 200)){
			item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l10000 Gold");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 200;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 150)){
			item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l2500 Gold");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 150;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			item = new ItemStack(Material.EMERALD);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§a2 Gamble Tickets");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 150)){
			item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l5000 Gold");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 150;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 100)){
			item = new ItemStack(Material.IRON_PICKAXE);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
		}
		nextLowestInt = nextLowestInt + 100;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 10)){
			item = new ItemStack(Material.CHEST);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§c1 Rare Chest");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 10;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 10)){
			item = new ItemStack(Material.DIAMOND_PICKAXE);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		}
		nextLowestInt = nextLowestInt + 10;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 100)){
			item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l100 Gold");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 100;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 50)){
			item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l20000 Gold");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 50;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 10)){
			item = new ItemStack(Material.DIAMOND_PICKAXE);
			item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
		}
		nextLowestInt = nextLowestInt + 10;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 100)){
			item = new ItemStack(Material.EMERALD);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§a1 Gamble Ticket");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 100;
		
		if(Prison.isIntEqualTo(rInt, nextLowestInt +1, nextLowestInt + 20)){
			item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l30000 Gold");
			item.setItemMeta(meta);
		}
		nextLowestInt = nextLowestInt + 20;
		
		inv.setItem(slot, item);
		
	}
	
	public static List<String> getGambleTicketsItemLore(){
		List<String> list = new ArrayList<String>();
		
		list.add("");
		list.add("§a1 Gamble Ticket");
		list.add("");
		list.add("§c§oPrice: §6§l10000 Gold");
		list.add("§7§oClick Here to Buy");
		list.add("");
		
		return list;
	}
	
	public static void setItem(Inventory inv, Player p, Material material, short durability, int amount, String displayName, List<String> lore, int slot, boolean setGlowing){
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability(durability);
		if(setGlowing == true){item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);}
		inv.setItem(slot, item);
	}
}
