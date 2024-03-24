package me.O_o_Fadi_o_O.KitPvP.kits.Necromancer;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.Start;
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

public class NecromancerInv {

	Start plugin;
	 
	public NecromancerInv(Start instance) {
	plugin = instance;
	}
	
	public Inventory NecromancerInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lNecromancer §7(§aLvL 1§7)");
			
			// GOLD HOE
			ItemStack sword = new ItemStack(Material.GOLD_HOE, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Undeath I");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 5);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 27 seconds");
			arrowlore.add(" §cMaximum: §65 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(0, 0, 0));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(0, 0, 0));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(0, 0, 0));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(0, 0, 0));
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
			
			// Necromancer LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Necromancer LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Necromancer LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.necromancer.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o50000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.necromancer.get(p.getName()) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lNecromancer §7(§aLvL 2§7)");
					
			// GOLD HOE
			ItemStack sword = new ItemStack(Material.GOLD_HOE, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Undeath II");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 10);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 27 seconds");
			arrowlore.add(" §cMaximum: §610 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(0, 0, 0));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(0, 0, 0));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(0, 0, 0));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(0, 0, 0));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
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
			
			// Necromancer LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Necromancer LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Necromancer LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.necromancer.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.necromancer.get(p.getName()) == 1){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o75000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.necromancer.get(p.getName()) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lNecromancer §7(§aLvL 3§7)");
					
			// GOLD HOE
			ItemStack sword = new ItemStack(Material.GOLD_HOE, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Undeath II");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			
			// STICK
			ItemStack stick = new ItemStack(Material.STICK, 1);
			ItemMeta stickmeta = stick.getItemMeta();
			stickmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §8Necromancer's Staff");
			List<String> sticklore = new ArrayList<String>();
			sticklore.add("§7Wither I");
			stickmeta.setLore(sticklore);
			stick.setItemMeta(stickmeta);
			stick.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 10);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 27 seconds");
			arrowlore.add(" §cMaximum: §610 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(0, 0, 0));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(0, 0, 0));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(0, 0, 0));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(0, 0, 0));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			i.setItem(11, sword);
			i.setItem(15, arrow);
			i.setItem(20, bow);
			i.setItem(24, stick);
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
			
			// Necromancer LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Necromancer LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Necromancer LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lNecromancer §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.necromancer.get(p.getName()) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.necromancer.get(p.getName()) == 2){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o100000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.necromancer.get(p.getName()) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Necromancer §7§o(§a§oLvL 3§7§o)");
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
