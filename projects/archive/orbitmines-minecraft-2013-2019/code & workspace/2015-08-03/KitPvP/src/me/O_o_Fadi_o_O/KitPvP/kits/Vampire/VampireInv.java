package me.O_o_Fadi_o_O.KitPvP.kits.Vampire;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class VampireInv {

	public Inventory VampireInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lVampire (Level 1)");
			
			// IRON SWORD 1
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bWeapon");
			List<String> swordlore = new ArrayList<String>();
			swordlore.add("§7Vampire I");
			swordmeta.setLore(swordlore);
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			sword = CustomItem.hideFlags(sword, 1);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(50, 10, 150));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(50, 10, 150));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(50, 10, 150));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(50, 10, 150));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			i.setItem(11, sword);
			i.setItem(4, helmet);
			i.setItem(13, chestplate);
			i.setItem(22, leggings);
			i.setItem(31, boots);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§4§l§o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("§7§oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Vampire LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lVampire §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Vampire LVL 2
			ItemStack kit2 = new ItemStack(Material.INK_SACK, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§4§l§oUnavailable");
			kit2.setDurability((short) 1);
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Vampire LVL 3
			ItemStack kit3 = new ItemStack(Material.INK_SACK, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§4§l§oUnavailable");
			kit3.setDurability((short) 1);
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.vampire.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour OMT Balance: §e§o" + StorageManager.orbitminestokens.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §e§o150 OMT");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.vampire.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§a§lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		else if(level == 2){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lVampire (Level 2)");
		
			// Vampire LVL 2
			ItemStack red = new ItemStack(Material.INK_SACK, 3);
			ItemMeta redmeta = red.getItemMeta();
			redmeta.setDisplayName("§4§l§oUnavailable");
			red.setDurability((short) 1);
			red.setItemMeta(redmeta);
		
			i.setItem(4, red);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§4§l§o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("§7§oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Vampire LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lVampire §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Vampire LVL 2
			ItemStack kit2 = new ItemStack(Material.INK_SACK, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§4§l§oUnavailable");
			kit2.setDurability((short) 1);
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Vampire LVL 3
			ItemStack kit3 = new ItemStack(Material.INK_SACK, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§4§l§oUnavailable");
			kit3.setDurability((short) 1);
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.vampire.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.vampire.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour OMT Balance: §e§o" + StorageManager.orbitminestokens.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §e§o### Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.vampire.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§a§lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		
		else if(level == 3){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lVampire (Level 3)");
			
			// Vampire LVL 3
			ItemStack red = new ItemStack(Material.INK_SACK, 3);
			ItemMeta redmeta = red.getItemMeta();
			redmeta.setDisplayName("§4§l§oUnavailable");
			red.setDurability((short) 1);
			red.setItemMeta(redmeta);
		
			i.setItem(4, red);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§4§l§o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("§7§oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Vampire LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lVampire §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Vampire LVL 2
			ItemStack kit2 = new ItemStack(Material.INK_SACK, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§4§l§oUnavailable");
			kit2.setDurability((short) 1);
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Vampire LVL 3
			ItemStack kit3 = new ItemStack(Material.INK_SACK, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§4§l§oUnavailable");
			kit3.setDurability((short) 1);
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.vampire.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.vampire.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour OMT Balance: §e§o" + StorageManager.orbitminestokens.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §e§o### Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.vampire.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Vampire §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§a§lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		else{
			
			return null;
		}
	}
}
