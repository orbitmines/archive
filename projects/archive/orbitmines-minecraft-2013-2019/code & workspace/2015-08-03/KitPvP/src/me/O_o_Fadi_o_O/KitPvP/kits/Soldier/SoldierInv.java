package me.O_o_Fadi_o_O.KitPvP.kits.Soldier;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SoldierInv {

	public Inventory SoldierInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lSoldier (Level 1)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bBow");
			bow.setItemMeta(bowmeta);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 16);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 18 seconds");
			arrowlore.add(" §cMaximum: §616 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, arrow);
			i.setItem(20, bow);
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
			
			// Soldier LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Soldier LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Soldier LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.soldier.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o7500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.soldier.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lSoldier (Level 2)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bWeapon");
			List<String> swordlore = new ArrayList<String>();
			swordlore.add("§7Lightning I");
			swordmeta.setLore(swordlore);
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			sword = CustomItem.hideFlags(sword, 1);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bBow");
			bow.setItemMeta(bowmeta);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 16);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 18 seconds");
			arrowlore.add(" §cMaximum: §616 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, arrow);
			i.setItem(20, bow);
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
			
			// Soldier LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Soldier LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Soldier LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.soldier.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.soldier.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o35000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.soldier.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lSoldier (Level 3)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bWeapon");
			List<String> swordlore = new ArrayList<String>();
			swordlore.add("§7Lightning II");
			swordmeta.setLore(swordlore);
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bBow");
			bow.setItemMeta(bowmeta);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 20);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 18 seconds");
			arrowlore.add(" §cMaximum: §620 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON LEGGINGS
			ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, arrow);
			i.setItem(20, bow);
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
			
			// Soldier LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Soldier LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Soldier LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lSoldier §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.soldier.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.soldier.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o42500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.soldier.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Soldier §7§o(§a§oLvL 3§7§o)");
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
