package me.O_o_Fadi_o_O.KitPvP.kits.Wizard;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WizardInv {

	Start plugin;
	 
	public WizardInv(Start instance) {
	plugin = instance;
	}
	
	public Inventory WizardInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lWizard §7§o(§a§oLvL 1§7§o)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// REGENERATION POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §dRegeneration Potion");
			potion1.setDurability((short) 8193);
			potion1.setItemMeta(potion1meta);
			
			// SPEED POTION
			ItemStack potion3 = new ItemStack(Material.POTION, 1);
			ItemMeta potion3meta = potion3.getItemMeta();
			potion3meta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §bSpeed Potion");
			potion3.setDurability((short) 8194);
			potion3.setItemMeta(potion3meta);
			
			// WEAKNESS POTION
			ItemStack potion4 = new ItemStack(Material.POTION, 1);
			ItemMeta potion4meta = potion4.getItemMeta();
			potion4meta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §7Weakness Potion");
			potion4.setDurability((short) 16392);
			potion4.setItemMeta(potion4meta);
			
			// HEALING POTION
			ItemStack potion2 = new ItemStack(Material.POTION, 1);
			ItemMeta potion2meta = potion2.getItemMeta();
			potion2meta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §cHealing Potion");
			potion2.setDurability((short) 16389);
			potion2.setItemMeta(potion2meta);
			
			// GOLD HELMET
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lWizard §a§lLvL 1§8 || §bBoots");
			boots.setItemMeta(bootsmeta);

			i.setItem(2, sword);
			i.setItem(6, potion4);
			i.setItem(15, potion2);
			i.setItem(24, potion2);
			i.setItem(11, potion1);
			i.setItem(20, potion3);
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
			
			// Wizard LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Wizard LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Wizard LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.wizard.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o10000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.wizard.get(p.getName()) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lWizard §7§o(§a§oLvL 2§7§o)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			// REGENERATION POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §dRegeneration Potion");
			potion1.setDurability((short) 8193);
			potion1.setItemMeta(potion1meta);
			
			// SPEED POTION
			ItemStack potion3 = new ItemStack(Material.POTION, 1);
			ItemMeta potion3meta = potion3.getItemMeta();
			potion3meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bSpeed Potion");
			potion3.setDurability((short) 8194);
			potion3.setItemMeta(potion3meta);
			
			// WEAKNESS POTION
			ItemStack potion4 = new ItemStack(Material.POTION, 1);
			ItemMeta potion4meta = potion4.getItemMeta();
			potion4meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §7Weakness Potion");
			potion4.setDurability((short) 16392);
			potion4.setItemMeta(potion4meta);
			
			// HEALING POTION
			ItemStack potion2 = new ItemStack(Material.POTION, 1);
			ItemMeta potion2meta = potion2.getItemMeta();
			potion2meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §cHealing Potion");
			potion2.setDurability((short) 16389);
			potion2.setItemMeta(potion2meta);
			
			// BLAZE ROD | WAND
			ItemStack blazerod = new ItemStack(Material.BLAZE_ROD, 1);
			ItemMeta blazerodmeta = blazerod.getItemMeta();
			blazerodmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §cFire Wand");
			List<String> blazerodlore = new ArrayList<String>();
			blazerodlore.add("§7Fire Spell I");
			blazerodmeta.setLore(blazerodlore);
			blazerod.setItemMeta(blazerodmeta);
			
			// GOLD HELMET
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(2, sword);
			i.setItem(6, potion4);
			i.setItem(15, potion2);
			i.setItem(24, potion2);
			i.setItem(11, potion1);
			i.setItem(20, potion3);
			i.setItem(29, blazerod);
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
			
			// Wizard LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Wizard LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Wizard LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.wizard.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.wizard.get(p.getName()) == 1){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o30000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.wizard.get(p.getName()) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lWizard §7§o(§a§oLvL 3§7§o)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			// REGENERATION POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §dRegeneration Potion");
			potion1.setDurability((short) 8193);
			potion1.setItemMeta(potion1meta);
			
			// SPEED POTION
			ItemStack potion3 = new ItemStack(Material.POTION, 1);
			ItemMeta potion3meta = potion3.getItemMeta();
			potion3meta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §bSpeed Potion");
			potion3.setDurability((short) 8194);
			potion3.setItemMeta(potion3meta);
			
			// WEAKNESS POTION
			ItemStack potion4 = new ItemStack(Material.POTION, 1);
			ItemMeta potion4meta = potion4.getItemMeta();
			potion4meta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §7Weakness Potion");
			potion4.setDurability((short) 16392);
			potion4.setItemMeta(potion4meta);
			
			// HEALING POTION
			ItemStack potion2 = new ItemStack(Material.POTION, 1);
			ItemMeta potion2meta = potion2.getItemMeta();
			potion2meta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §cHealing Potion");
			potion2.setDurability((short) 16389);
			potion2.setItemMeta(potion2meta);
			
			// BLAZE ROD | WAND
			ItemStack blazerod = new ItemStack(Material.BLAZE_ROD, 1);
			ItemMeta blazerodmeta = blazerod.getItemMeta();
			blazerodmeta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §cFire Wand");
			List<String> blazerodlore = new ArrayList<String>();
			blazerodlore.add("§7Fire Spell II");
			blazerodmeta.setLore(blazerodlore);
			blazerod.setItemMeta(blazerodmeta);
			
			// GOLD HELMET
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lWizard §a§lLvL 3§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			i.setItem(2, sword);
			i.setItem(6, potion4);
			i.setItem(15, potion2);
			i.setItem(24, potion2);
			i.setItem(11, potion1);
			i.setItem(20, potion3);
			i.setItem(29, blazerod);
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
			
			// Wizard LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Wizard LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Wizard LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lWizard §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.wizard.get(p.getName()) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.wizard.get(p.getName()) == 2){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o45000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.wizard.get(p.getName()) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Wizard §7§o(§a§oLvL 3§7§o)");
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
