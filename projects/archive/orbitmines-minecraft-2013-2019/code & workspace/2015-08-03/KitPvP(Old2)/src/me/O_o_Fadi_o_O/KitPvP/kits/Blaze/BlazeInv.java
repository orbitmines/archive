package me.O_o_Fadi_o_O.KitPvP.kits.Blaze;

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

public class BlazeInv {

	Start plugin;
	 
	public BlazeInv(Start instance) {
	plugin = instance;
	}
	
	public Inventory BlazeInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lBlaze §7§o(§a§oLvL 1§7§o)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.BLAZE_POWDER, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lBlaze §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
			sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.STAINED_CLAY, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lBlaze §a§lLvL 1§8 || §bHelmet");
			helmet.setDurability((short) 4);
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lBlaze §a§lLvL 1§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(10, 130, 180));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lBlaze §a§lLvL 1§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(10, 130, 180));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lBlaze §a§lLvL 1§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(10, 130, 180));
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
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
			
			// Blaze LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Blaze LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Blaze LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.blaze.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o30000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.blaze.get(p.getName()) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lBlaze §7§o(§a§oLvL 2§7§o)");
				
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.BLAZE_POWDER, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lBlaze §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.STAINED_CLAY, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lBlaze §a§lLvL 2§8 || §bHelmet");
			helmet.setDurability((short) 4);
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lBlaze §a§lLvL 2§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(10, 130, 180));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lBlaze §a§lLvL 2§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(10, 130, 180));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lBlaze §a§lLvL 2§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(10, 130, 180));
			List<String> bootslore = new ArrayList<String>();
			bootslore.add("§7Light I");
			bootsmeta.setLore(bootslore);
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
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
			
			// Blaze LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Blaze LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Blaze LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.blaze.get(p.getName()) == 0){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.blaze.get(p.getName()) == 1){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o60000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.blaze.get(p.getName()) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§b§lBlaze §7§o(§a§oLvL 3§7§o)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.BLAZE_POWDER, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lBlaze §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
			sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
			
			// LEATHER HELMET
			ItemStack helmet = new ItemStack(Material.STAINED_CLAY, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lBlaze §a§lLvL 3§8 || §bHelmet");
			helmet.setDurability((short) 4);
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lBlaze §a§lLvL 3§8 || §bChestplate");
			chestplatemeta.setColor(Color.fromBGR(10, 130, 180));
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER LEGGINGS
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lBlaze §a§lLvL 3§8 || §bLeggings");
			leggingsmeta.setColor(Color.fromBGR(10, 130, 180));
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			// LEATHER BOOTS
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lBlaze §a§lLvL 3§8 || §bBoots");
			bootsmeta.setColor(Color.fromBGR(10, 130, 180));
			List<String> bootslore = new ArrayList<String>();
			bootslore.add("§7Light I");
			bootsmeta.setLore(bootslore);
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
	
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
			
			// Blaze LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Blaze LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Blaze LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lBlaze §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.blaze.get(p.getName()) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.blaze.get(p.getName()) == 2){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o40000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.blaze.get(p.getName()) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Blaze §7§o(§a§oLvL 3§7§o)");
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
