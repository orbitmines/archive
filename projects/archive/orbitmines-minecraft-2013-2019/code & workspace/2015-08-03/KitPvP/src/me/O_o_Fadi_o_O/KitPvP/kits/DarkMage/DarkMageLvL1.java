package me.O_o_Fadi_o_O.KitPvP.kits.DarkMage;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.TitleManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;

public class DarkMageLvL1 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.DarkMage_LvL_1);
		TitleManager.setTitle(p, "", "�7Selected Kit '�b�lDarkMage�7' (�aLevel 1�7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lDarkMage �a�lLvL 1�8 || �bWeapon");
		List<String> swordlore = new ArrayList<String>();
		swordlore.add("�7Magic I");
		swordmeta.setLore(swordlore);
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// POTION LAUNCHER
		ItemStack potionlauncher = new ItemStack(Material.BREWING_STAND_ITEM, 1);
		ItemMeta potionlaunchermeta = potionlauncher.getItemMeta();
		potionlaunchermeta.setDisplayName("�b�lDarkMage �a�lLvL 1�8 || �ePotion Launcher");
		List<String> potionlauncherlore = new ArrayList<String>();
		potionlauncherlore.add("�7Potion Launcher I");
		potionlaunchermeta.setLore(potionlauncherlore);
		potionlauncher.setItemMeta(potionlaunchermeta);
		p.getInventory().setItem(1, new ItemStack(potionlauncher));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lDarkMage �a�lLvL 1�8 || �bHelmet");
		helmetmeta.setColor(Color.fromBGR(0, 0, 0));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lDarkMage �a�lLvL 1�8 || �bChestplate");
		List<String> chestplatelore = new ArrayList<String>();
		chestplatelore.add("�7Wither Armor I");
		chestplatemeta.setLore(chestplatelore);
		chestplatemeta.setColor(Color.fromBGR(0, 0, 0));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lDarkMage �a�lLvL 1�8 || �bLeggings");
		leggingsmeta.setColor(Color.fromBGR(0, 0, 0));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lDarkMage �a�lLvL 1�8 || �bBoots");
		bootsmeta.setColor(Color.fromBGR(0, 0, 0));
		//List<String> bootslore = new ArrayList<String>();
		//bootslore.add("�7Fly I");
		//bootsmeta.setLore(bootslore);
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
	}
}
