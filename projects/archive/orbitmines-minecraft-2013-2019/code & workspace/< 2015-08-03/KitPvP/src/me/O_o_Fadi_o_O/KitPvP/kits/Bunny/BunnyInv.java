package me.O_o_Fadi_o_O.KitPvP.kits.Bunny;

import java.util.ArrayList;
import java.util.List;

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

public class BunnyInv {

	public Inventory BunnyInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lBunny (Level 1)");
			
			// IRON SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// POISON POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §2Poison Potion");
			potion1.setDurability((short) 16420);
			potion1.setItemMeta(potion1meta);
			
			// INSTANT DAMAGE POTION
			ItemStack potion2 = new ItemStack(Material.POTION, 1);
			ItemMeta potion2meta = potion2.getItemMeta();
			potion2meta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §4Harming Potion");
			potion2.setDurability((short) 16396);
			potion2.setItemMeta(potion2meta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(250, 250, 250));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(250, 250, 250));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(250, 250, 250));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lBunny §a§lLvL 1§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(250, 250, 250));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oJump Boost IV");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(15, potion2);
			i.setItem(24, potion2);
			i.setItem(20, potion1);
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
			
			// Bunny LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Bunny LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Bunny LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.bunny.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o37500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.bunny.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lBunny (Level 2)");
					
			// IRON SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			
			// CARROT
			ItemStack carrot = new ItemStack(Material.CARROT_ITEM, 1);
			ItemMeta carrotmeta = carrot.getItemMeta();
			carrotmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §6Knockback Carrot");
			carrot.setItemMeta(carrotmeta);
			carrot.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			carrot.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
			
			// POISON POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §2Poison Potion");
			potion1.setDurability((short) 16420);
			potion1.setItemMeta(potion1meta);
			
			// INSTANT DAMAGE POTION
			ItemStack potion2 = new ItemStack(Material.POTION, 1);
			ItemMeta potion2meta = potion2.getItemMeta();
			potion2meta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §4Harming Potion");
			potion2.setDurability((short) 16396);
			potion2.setItemMeta(potion2meta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(250, 250, 250));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(250, 250, 250));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(250, 250, 250));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(250, 250, 250));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oJump Boost IV");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(15, potion1);
			i.setItem(24, potion2);
			i.setItem(33, potion2);
			i.setItem(20, carrot);
			i.setItem(29, potion1);
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
			
			// Bunny LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Bunny LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Bunny LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.bunny.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.bunny.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o50000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.bunny.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lBunny (Level 3)");
			
			// IRON SWORD
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			// CARROT
			ItemStack carrot = new ItemStack(Material.CARROT_ITEM, 1);
			ItemMeta carrotmeta = carrot.getItemMeta();
			carrotmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §6Knockback Carrot");
			carrot.setItemMeta(carrotmeta);
			carrot.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			carrot.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
			
			// POISON POTION
			ItemStack potion1 = new ItemStack(Material.POTION, 1);
			ItemMeta potion1meta = potion1.getItemMeta();
			potion1meta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §2Poison Potion");
			potion1.setDurability((short) 16420);
			potion1.setItemMeta(potion1meta);
			
			// INSTANT DAMAGE POTION
			ItemStack potion2 = new ItemStack(Material.POTION, 1);
			ItemMeta potion2meta = potion2.getItemMeta();
			potion2meta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §4Harming Potion");
			potion2.setDurability((short) 16396);
			potion2.setItemMeta(potion2meta);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(250, 250, 250));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(250, 250, 250));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(250, 250, 250));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(250, 250, 250));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oJump Boost IV");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, sword);
			i.setItem(15, potion1);
			i.setItem(24, potion2);
			i.setItem(33, potion2);
			i.setItem(20, carrot);
			i.setItem(29, potion1);
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
			
			// Bunny LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Bunny LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Bunny LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lBunny §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.bunny.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.bunny.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o72500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.bunny.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Bunny §7§o(§a§oLvL 3§7§o)");
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
