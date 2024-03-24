package me.O_o_Fadi_o_O.KitPvP.kits.Pyro;

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

public class PyroInv {

	public Inventory PyroInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lPyro (Level 1)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lPyro §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
			
			// GOLD HELMET
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lPyro §a§lLvL 1§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lPyro §a§lLvL 1§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lPyro §a§lLvL 1§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lPyro §a§lLvL 1§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oFire Resistance IV");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
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
			
			// Pyro LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Pyro LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Pyro LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.pyro.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o25000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.pyro.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lPyro (Level 2)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lPyro §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			// GOLD HELMET
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lPyro §a§lLvL 2§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lPyro §a§lLvL 2§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lPyro §a§lLvL 2§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lPyro §a§lLvL 2§8 || §bBoots");
			List<String> bootslore = new ArrayList<String>();
			bootslore.add("§7Fire Trail I");
			bootsmeta.setLore(bootslore);
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oFire Resistance IV");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
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
			
			// Pyro LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Pyro LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Pyro LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.pyro.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.pyro.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o65000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.pyro.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lPyro (Level 3)");
		
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bBow");
			bow.setItemMeta(bowmeta);
			bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 12);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 22 seconds");
			arrowlore.add(" §cMaximum: §612 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// GOLD HELMET
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bBoots");
			List<String> bootslore = new ArrayList<String>();
			bootslore.add("§7Fire Trail I");
			bootsmeta.setLore(bootslore);
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oFire Resistance IV");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(20, bow);
			i.setItem(15, arrow);
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
			
			// Pyro LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Pyro LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Pyro LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lPyro §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.pyro.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.pyro.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o95000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.pyro.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Pyro §7§o(§a§oLvL 3§7§o)");
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
