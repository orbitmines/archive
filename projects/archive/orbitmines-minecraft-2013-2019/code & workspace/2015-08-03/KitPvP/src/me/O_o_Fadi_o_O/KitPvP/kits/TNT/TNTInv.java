package me.O_o_Fadi_o_O.KitPvP.kits.TNT;

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

public class TNTInv {

	public Inventory TNTInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lTNT (Level 1)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.TNT, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lTNT §a§lLvL 1§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
			
			// REDSTONE TORCH
			ItemStack torch = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
			ItemMeta torchmeta = torch.getItemMeta();
			torchmeta.setDisplayName("§b§lTNT §a§lLvL 1§8 || §4TNT Launcher");
			List<String> torchlore = new ArrayList<String>();
			torchlore.add("§7TNT I");
			torchmeta.setLore(torchlore);
			torch.setItemMeta(torchmeta);
			torch.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			torch = CustomItem.hideFlags(torch, 1);
			
			// TNT HELMET
			ItemStack helmet = new ItemStack(Material.TNT, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lTNT §a§lLvL 1§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lTNT §a§lLvL 1§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lTNT §a§lLvL 1§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lTNT §a§lLvL 1§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
			
			i.setItem(11, sword);
			i.setItem(15, torch);
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
			
			// TNT LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// TNT LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// TNT LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tnt.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o40000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tnt.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 1§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lTNT (Level 2)");
				
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.TNT, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Explode I");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			bow = CustomItem.hideFlags(bow, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 2);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 30 seconds");
			arrowlore.add(" §cMaximum: §62 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// REDSTONE TORCH
			ItemStack torch = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
			ItemMeta torchmeta = torch.getItemMeta();
			torchmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §4TNT Launcher");
			List<String> torchlore = new ArrayList<String>();
			torchlore.add("§7TNT I");
			torchmeta.setLore(torchlore);
			torch.setItemMeta(torchmeta);
			torch.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			torch = CustomItem.hideFlags(torch, 1);
			
			// TNT HELMET
			ItemStack helmet = new ItemStack(Material.TNT, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
			
			i.setItem(11, sword);
			i.setItem(15, torch);
			i.setItem(20, bow);
			i.setItem(24, arrow);
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
			
			// TNT LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// TNT LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// TNT LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tnt.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tnt.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o65000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tnt.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 2§7§o)");
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
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lTNT (Level 3)");
			
			// STONE SWORD
			ItemStack sword = new ItemStack(Material.TNT, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
			
			// BOW
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bBow");
			List<String> bowlore = new ArrayList<String>();
			bowlore.add("§7Explode I");
			bowmeta.setLore(bowlore);
			bow.setItemMeta(bowmeta);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			bow = CustomItem.hideFlags(bow, 1);
			
			// ARROWS
			ItemStack arrow = new ItemStack(Material.ARROW, 4);
			ItemMeta arrowmeta = arrow.getItemMeta();
			arrowmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bArrow");
			List<String> arrowlore = new ArrayList<String>();		
			arrowlore.add(" §c+1 Arrow: §6Every 30 seconds");
			arrowlore.add(" §cMaximum: §64 Arrows");
			arrowmeta.setLore(arrowlore);
			arrow.setItemMeta(arrowmeta);
			
			// REDSTONE TORCH
			ItemStack torch = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
			ItemMeta torchmeta = torch.getItemMeta();
			torchmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §4TNT Launcher");
			List<String> torchlore = new ArrayList<String>();
			torchlore.add("§7TNT I");
			torchmeta.setLore(torchlore);
			torch.setItemMeta(torchmeta);
			torch.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			torch = CustomItem.hideFlags(torch, 1);
			
			// TNT HELMET
			ItemStack helmet = new ItemStack(Material.TNT, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			
			// GOLD CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// GOLD LEGGINGS
			ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// GOLD BOOTS
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, torch);
			i.setItem(20, bow);
			i.setItem(24, arrow);
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
			
			// TNT LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// TNT LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 2§7§o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// TNT LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§b§lTNT §7§o(§a§oLvL 3§7§o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tnt.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tnt.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour Coin Balance: §6§o" + StorageManager.money.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §6§o42500 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tnt.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy TNT §7§o(§a§oLvL 3§7§o)");
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
