package me.O_o_Fadi_o_O.KitPvP.kits.Assassin;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.TitleManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AssassinLvL1 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.Assassin_LvL_1);
		TitleManager.setTitle(p, "", "�7Selected Kit '�b�lAssassin�7' (�aLevel 1�7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// DIAMOND SWORD
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lAssassin �a�lLvL 1�8 || �bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lAssassin �a�lLvL 1�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lAssassin �a�lLvL 1�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lAssassin �a�lLvL 1�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lAssassin �a�lLvL 1�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
		// SPEED
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 1));
		
	}
}
