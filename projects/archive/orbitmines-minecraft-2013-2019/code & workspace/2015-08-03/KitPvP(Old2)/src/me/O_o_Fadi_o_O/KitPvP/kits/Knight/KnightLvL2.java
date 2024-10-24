package me.O_o_Fadi_o_O.KitPvP.kits.Knight;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class KnightLvL2 {

	public static void give(Player p){

		StorageManager.PlayerKitSelected.put(p, KitPlaying.Knight_LvL_2);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lKnight �a�lLvL 2�8 || �bWeapon");
		sword.setItemMeta(swordmeta);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// HEALING POTION
		ItemStack potion1 = new ItemStack(Material.POTION, 1);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("�b�lKnight �a�lLvL 2�8 || �cHealing Potion");
		potion1.setDurability((short) 16389);
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(1, new ItemStack(potion1));
		
		// CHAIN HELMET
		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lKnight �a�lLvL 2�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lKnight �a�lLvL 2�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lKnight �a�lLvL 2�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lKnight �a�lLvL 2�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		p.getInventory().setBoots(boots);
		
	}
}
