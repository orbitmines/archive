package me.O_o_Fadi_o_O.KitPvP.kits.Tree;

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

public class TreeInv {

	Start plugin;
	 
	public TreeInv(Start instance) {
	plugin = instance;
	}
	
	public Inventory TreeInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "�b�lTree �7�o(�a�oLvL 1�7�o)");
			
			// LEAVES SWORD
			ItemStack sword = new ItemStack(Material.LEAVES, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("�b�lTree �a�lLvL 1�8 || �bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
			
			// CHAIN HELMET
			ItemStack helmet = new ItemStack(Material.LEAVES, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("�b�lTree �a�lLvL 1�8 || �bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			
			// CHAIN CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("�b�lTree �a�lLvL 1�8 || �bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			
			// CHAIN LEGGINGS
			ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("�b�lTree �a�lLvL 1�8 || �bLeggings");
			leggings.setItemMeta(leggingsmeta);
			
			// CHAIN BOOTS
			ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("�b�lTree �a�lLvL 1�8 || �bBoots");
			boots.setItemMeta(bootsmeta);
			
			i.setItem(11, sword);
			i.setItem(4, helmet);
			i.setItem(13, chestplate);
			i.setItem(22, leggings);
			i.setItem(31, boots);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("�4�l�o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("�7�oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Tree LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("�b�lTree �7�o(�a�oLvL 1�7�o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Tree LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("�b�lTree �7�o(�a�oLvL 2�7�o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Tree LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("�b�lTree �7�o(�a�oLvL 3�7�o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tree.get(p.getName()) == 0){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 1�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�7�oYour Coin Balance: �6�o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("�7�oPrice: �6�o20000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tree.get(p.getName()) >= 1){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 1�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�a�lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		else if(level == 2){
			final Inventory i = Bukkit.createInventory(null, 54, "�b�lTree �7�o(�a�oLvL 2�7�o)");
				
			// LEAVES SWORD
			ItemStack sword = new ItemStack(Material.LEAVES, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("�b�lTree �a�lLvL 2�8 || �bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			// WOOD BARRIER
			ItemStack wood = new ItemStack(Material.LOG, 1);
			ItemMeta woodmeta = wood.getItemMeta();
			woodmeta.setDisplayName("�b�lTree �a�lLvL 2�8 || �dBarrier");
			List<String> woodlore = new ArrayList<String>();
			woodlore.add("�7Barrier I");
			woodmeta.setLore(woodlore);
			wood.setDurability((short) 1);
			wood.setItemMeta(woodmeta);
			
			// CHAIN HELMET
			ItemStack helmet = new ItemStack(Material.LEAVES, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("�b�lTree �a�lLvL 2�8 || �bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			
			// CHAIN CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("�b�lTree �a�lLvL 2�8 || �bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			
			// CHAIN LEGGINGS
			ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("�b�lTree �a�lLvL 2�8 || �bLeggings");
			leggings.setItemMeta(leggingsmeta);
			
			// CHAIN BOOTS
			ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("�b�lTree �a�lLvL 2�8 || �bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, wood);
			i.setItem(4, helmet);
			i.setItem(13, chestplate);
			i.setItem(22, leggings);
			i.setItem(31, boots);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("�4�l�o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("�7�oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Tree LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("�b�lTree �7�o(�a�oLvL 1�7�o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Tree LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("�b�lTree �7�o(�a�oLvL 2�7�o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Tree LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("�b�lTree �7�o(�a�oLvL 3�7�o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tree.get(p.getName()) == 0){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 2�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�4�lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tree.get(p.getName()) == 1){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 2�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�7�oYour Coin Balance: �6�o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("�7�oPrice: �6�o35000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tree.get(p.getName()) >= 2){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 2�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�a�lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		
		else if(level == 3){
			final Inventory i = Bukkit.createInventory(null, 54, "�b�lTree �7�o(�a�oLvL 3�7�o)");
			
			// LEAVES SWORD
			ItemStack sword = new ItemStack(Material.LEAVES, 1);
			ItemMeta swordmeta = sword.getItemMeta();
			swordmeta.setDisplayName("�b�lTree �a�lLvL 3�8 || �bWeapon");
			sword.setItemMeta(swordmeta);
			sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			// WOOD BARRIER
			ItemStack wood = new ItemStack(Material.LOG, 1);
			ItemMeta woodmeta = wood.getItemMeta();
			woodmeta.setDisplayName("�b�lTree �a�lLvL 3�8 || �dBarrier");
			List<String> woodlore = new ArrayList<String>();
			woodlore.add("�7Barrier II");
			woodmeta.setLore(woodlore);
			wood.setDurability((short) 1);
			wood.setItemMeta(woodmeta);
			
			// CHAIN HELMET
			ItemStack helmet = new ItemStack(Material.LEAVES, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("�b�lTree �a�lLvL 3�8 || �bHelmet");
			helmet.setItemMeta(helmetmeta);
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			
			// CHAIN CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("�b�lTree �a�lLvL 3�8 || �bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// CHAIN LEGGINGS
			ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("�b�lTree �a�lLvL 3�8 || �bLeggings");
			leggings.setItemMeta(leggingsmeta);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			// CHAIN BOOTS
			ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("�b�lTree �a�lLvL 3�8 || �bBoots");
			boots.setItemMeta(bootsmeta);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			i.setItem(11, sword);
			i.setItem(15, wood);
			i.setItem(4, helmet);
			i.setItem(13, chestplate);
			i.setItem(22, leggings);
			i.setItem(31, boots);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("�4�l�o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("�7�oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Tree LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("�b�lTree �7�o(�a�oLvL 1�7�o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Tree LVL 2
			ItemStack kit2 = new ItemStack(Material.NETHER_STAR, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("�b�lTree �7�o(�a�oLvL 2�7�o)");
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Tree LVL 3
			ItemStack kit3 = new ItemStack(Material.NETHER_STAR, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("�b�lTree �7�o(�a�oLvL 3�7�o)");
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.tree.get(p.getName()) <= 1){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 3�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�4�lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tree.get(p.getName()) == 2){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 3�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�7�oYour Coin Balance: �6�o" + StorageManager.money.get(p.getName()));
				buylore.add("");
				buylore.add("�7�oPrice: �6�o50000 Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.tree.get(p.getName()) >= 3){
				buymeta.setDisplayName("�2�l�oBuy Tree �7�o(�a�oLvL 3�7�o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("�a�lUnlocked");
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
