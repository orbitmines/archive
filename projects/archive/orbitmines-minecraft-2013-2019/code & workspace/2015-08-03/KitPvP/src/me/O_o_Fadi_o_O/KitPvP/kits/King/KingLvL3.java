package me.O_o_Fadi_o_O.KitPvP.kits.King;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.TitleManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class KingLvL3 {

	public static void give(Player p){

		StorageManager.kitselected.put(p, KitPlaying.King_LvL_3);
		TitleManager.setTitle(p, "", "�7Selected Kit '�b�lKing�7' (�aLevel 3�7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lKing �a�lLvL 3�8 || �bWeapon");
		List<String> swordlore = new ArrayList<String>();
		swordlore.add("�7Healing II");
		swordmeta.setLore(swordlore);
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// DIAMOND HELMET
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lKing �a�lLvL 3�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// GOLD CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lKing �a�lLvL 3�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// GOLD LEGGINGS
		ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lKing �a�lLvL 3�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// GOLD BOOTS
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lKing �a�lLvL 3�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
	}
}
