package me.O_o_Fadi_o_O.KitPvP.kits.Tank;

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
import org.bukkit.potion.PotionEffectType;

public class TankLvL1 {

	public static void give(Player p){

		StorageManager.kitselected.put(p, KitPlaying.Tank_LvL_1);
		TitleManager.setTitle(p, "", "�7Selected Kit '�b�lTank�7' (�aLevel 1�7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// WOOD SWORD
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lTank �a�lLvL 1�8 || �bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.KNOCKBACK, 1);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// GOLDEN APPLE
		ItemStack potion1 = new ItemStack(Material.GOLDEN_APPLE, 2);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("�b�lTank �a�lLvL 1�8 || �eGolden Apple");
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(1, new ItemStack(potion1));
		
		// IRON HELMET
		ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lTank �a�lLvL 1�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// DIAMOND CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lTank �a�lLvL 1�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// IRON LEGGINGS
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lTank �a�lLvL 1�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// IRON BOOTS
		ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lTank �a�lLvL 1�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
		// SLOWNESS
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 2));
		
	}
}
