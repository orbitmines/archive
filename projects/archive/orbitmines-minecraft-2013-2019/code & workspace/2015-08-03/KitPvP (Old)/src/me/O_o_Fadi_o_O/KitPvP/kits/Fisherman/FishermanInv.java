package me.O_o_Fadi_o_O.KitPvP.kits.Fisherman;

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

public class FishermanInv {

	Start plugin;
	 
	public FishermanInv(Start instance) {
	plugin = instance;
	}
	
	public Inventory FishermanInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lFisherman §7(§aLvL 1§7)");

			// FISHING ROD
			ItemStack sword = new ItemStack(Material.FISHING_ROD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lFisherman §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
			
			// FISH
			ItemStack fish = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fishmeta = fish.getItemMeta();
			fishmeta.setDisplayName("§b§lFisherman §a§lLvL 1§8 || §bFish");
			fish.setDurability((short) 1);
			fish.setItemMeta(fishmeta);
			fish.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
			fish.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lFisherman §a§lLvL 1§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(10, 130, 120));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lFisherman §a§lLvL 1§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(10, 130, 120));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lFisherman §a§lLvL 1§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(10, 130, 120));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lFisherman §a§lLvL 1§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(10, 130, 120));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			i.setItem(11, sword);
			i.setItem(15, fish);
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
			
			// Fisherman LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Fisherman LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Fisherman LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.fisherman.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o32500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fisherman.get(p.getName()) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lFisherman §7(§aLvL 2§7)");
				
			// FISHING ROD
			ItemStack sword = new ItemStack(Material.FISHING_ROD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
			
			// FISH
			ItemStack fish = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fishmeta = fish.getItemMeta();
			fishmeta.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §bFish");
			fish.setDurability((short) 1);
			fish.setItemMeta(fishmeta);
			fish.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
			fish.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			
			// FISH 2
			ItemStack fish2 = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fishmeta2 = fish2.getItemMeta();
			fishmeta2.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §9Fish Attack");
			fish2.setDurability((short) 3);
			List<String> fishlore = new ArrayList<String>();
			fishlore.add("§7Fish Attack I");
			fishmeta2.setLore(fishlore);
			fish2.setItemMeta(fishmeta2);
			fish2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(10, 130, 120));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(10, 130, 120));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(10, 130, 120));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lFisherman §a§lLvL 2§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(10, 130, 120));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			i.setItem(11, sword);
			i.setItem(15, fish);
			i.setItem(20, fish2);
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
			
			// Fisherman LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Fisherman LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Fisherman LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.fisherman.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fisherman.get(p.getName()) == 1){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o40000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fisherman.get(p.getName()) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lFisherman §7(§aLvL 3§7)");
			
			// FISHING ROD
			ItemStack sword = new ItemStack(Material.FISHING_ROD, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
			
			// FISH
			ItemStack fish = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fishmeta = fish.getItemMeta();
			fishmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bFish");
			fish.setDurability((short) 1);
			fish.setItemMeta(fishmeta);
			fish.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
			fish.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			
			// FISH 2
			ItemStack fish2 = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fishmeta2 = fish2.getItemMeta();
			fishmeta2.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §9Fish Attack");
			fish2.setDurability((short) 3);
			List<String> fishlore = new ArrayList<String>();
			fishlore.add("§7Fish Attack I");
			fishmeta2.setLore(fishlore);
			fish2.setItemMeta(fishmeta2);
			fish2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bHelmet");
			helmetmeta.setColor(Color.fromBGR(10, 130, 120));
			helmet.setItemMeta(helmetmeta);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(10, 130, 120));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(10, 130, 120));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(10, 130, 120));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			i.setItem(11, sword);
			i.setItem(15, fish);
			i.setItem(20, fish2);
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
			
			// Fisherman LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Fisherman LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Fisherman LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lFisherman §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.fisherman.get(p.getName()) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fisherman.get(p.getName()) == 2){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o45000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fisherman.get(p.getName()) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Fisherman §7§o(§a§oLvL 3§7§o)");
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
