package me.O_o_Fadi_o_O.KitPvP.kits.Archer;

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

public class ArcherInv {

	public Inventory ArcherInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lArcher (Level 1)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bBow");
			bow.setItemMeta(bowmeta);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 32);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 10 seconds");
			arrowlore.add(" §cMaximum: §632 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// HEALING POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §cHealing Potion");
			potion1.setDurability((short) 8197);
			potion1.setItemMeta(potion1meta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(204, 255, 51));
			helmet.setItemMeta(helmetmeta);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(204, 255, 51));
			chestplate.setItemMeta(chestplatemeta);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(204, 255, 51));
			leggings.setItemMeta(leggingsmeta);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(204, 255, 51));
			boots.setItemMeta(bootsmeta);

			i.setItem(11, sword);
			i.setItem(15, potion1);
			i.setItem(24, arrow);
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
			
			// ARCHER LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// ARCHER LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// ARCHER LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.archer.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o2500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.archer.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lArcher (Level 2)");
					
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Lightning I");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			bow = CustomItem.hideFlags(bow, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 32);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 10 seconds");
			arrowlore.add(" §cMaximum: §632 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// HEALING POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §cHealing Potion");
			potion1.setDurability((short) 8197);
			potion1.setItemMeta(potion1meta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(204, 255, 51));
			helmet.setItemMeta(helmetmeta);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(204, 255, 51));
			chestplate.setItemMeta(chestplatemeta);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(204, 255, 51));
			leggings.setItemMeta(leggingsmeta);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(204, 255, 51));
			boots.setItemMeta(bootsmeta);
			
			i.setItem(11, sword);
			i.setItem(15, potion1);
			i.setItem(24, arrow);
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
			
			// ARCHER LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// ARCHER LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// ARCHER LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.archer.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.archer.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o25000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.archer.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lArcher (Level 3)");
					
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Lightning I");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 32);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 10 seconds");
			arrowlore.add(" §cMaximum: §632 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// HEALING POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §cHealing Potion");
			potion1.setDurability((short) 16389);
			potion1.setItemMeta(potion1meta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(204, 255, 51));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(204, 255, 51));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(204, 255, 51));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(204, 255, 51));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, potion1);
			i.setItem(24, arrow);
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
			
			// ARCHER LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// ARCHER LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// ARCHER LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lArcher §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.archer.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.archer.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o50000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.archer.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Archer §7§o(§a§oLvL 3§7§o)");
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
