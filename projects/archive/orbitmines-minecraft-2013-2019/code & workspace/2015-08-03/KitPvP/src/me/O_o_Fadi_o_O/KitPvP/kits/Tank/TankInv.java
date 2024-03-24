package me.O_o_Fadi_o_O.KitPvP.kits.Tank;

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

public class TankInv {

	public Inventory TankInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lTank (Level 1)");
			
			// WOOD SWORD
			ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lTank §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.KNOCKBACK, 1);
			
			// GOLDEN APPLE
			ItemStack potion1 = new ItemStack(Material.GOLDEN_APPLE, 2);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lTank §a§lLvL 1§8 || §eGolden Apple");
			potion1.setItemMeta(potion1meta);
			
			// IRON HELMET
			ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lTank §a§lLvL 1§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			
			// DIAMOND CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lTank §a§lLvL 1§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON LEGGINGS
			ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lTank §a§lLvL 1§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			
			// IRON BOOTS
			ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lTank §a§lLvL 1§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oSlowness III");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(15, potion1);
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
			
			// Tank LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lTank §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Tank LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lTank §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Tank LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lTank §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tank.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o15000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tank.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lTank (Level 2)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lTank §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.KNOCKBACK, 2);
			
			// GOLDEN APPLE
			ItemStack potion1 = new ItemStack(Material.GOLDEN_APPLE, 3);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lTank §a§lLvL 2§8 || §eGolden Apple");
			potion1.setItemMeta(potion1meta);
			
			// IRON HELMET
			ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lTank §a§lLvL 2§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			
			// DIAMOND CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lTank §a§lLvL 2§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON LEGGINGS
			ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lTank §a§lLvL 2§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON BOOTS
			ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lTank §a§lLvL 2§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oSlowness III");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(15, potion1);
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
			
			// Tank LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lTank §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Tank LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lTank §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Tank LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lTank §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tank.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tank.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o50000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tank.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lTank (Level 3)");
			
			// IRON SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addEnchantment(Enchantment.KNOCKBACK, 2);
			
			// GOLDEN APPLE
			ItemStack potion1 = new ItemStack(Material.GOLDEN_APPLE, 4);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lTank §a§lLvL 3§8 || §eGolden Apple");
			potion1.setItemMeta(potion1meta);
			
			// IRON HELMET
			ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// DIAMOND CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON LEGGINGS
			ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// IRON BOOTS
			ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oSlowness III");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(15, potion1);
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
			
			// Tank LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lTank §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Tank LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lTank §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Tank LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lTank §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tank.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tank.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o80000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tank.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Tank §7§o(§a§oLvL 3§7§o)");
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
