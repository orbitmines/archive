package me.O_o_Fadi_o_O.KitPvP.kits.Fisherman;

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

public class FishermanLvL2 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.Fisherman_LvL_2);
		TitleManager.setTitle(p, "", "�7Selected Kit '�b�lFisherman�7' (�aLevel 2�7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// FISHING ROD
		ItemStack sword = new ItemStack(Material.FISHING_ROD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// FISH
		ItemStack fish = new ItemStack(Material.RAW_FISH, 1);
		ItemMeta fishmeta = fish.getItemMeta();
		fishmeta.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �bFish");
		fish.setDurability((short) 1);
		fish.setItemMeta(fishmeta);
		fish.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
		fish.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().setItem(1, new ItemStack(fish));
		
		// FISH 2
		ItemStack fish2 = new ItemStack(Material.RAW_FISH, 1);
		ItemMeta fishmeta2 = fish2.getItemMeta();
		fishmeta2.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �9Fish Attack");
		fish2.setDurability((short) 3);
		List<String> fishlore = new ArrayList<String>();
		fishlore.add("�7Fish Attack I");
		fishmeta2.setLore(fishlore);
		fish2.setItemMeta(fishmeta2);
		fish2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		fish2 = CustomItem.hideFlags(fish2, 1);
		p.getInventory().setItem(2, new ItemStack(fish2));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �bHelmet");
		helmetmeta.setColor(Color.fromBGR(10, 130, 120));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �bChestplate");
		chestplatemeta.setColor(Color.fromBGR(10, 130, 120));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �bLeggings");
		leggingsmeta.setColor(Color.fromBGR(10, 130, 120));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lFisherman �a�lLvL 2�8 || �bBoots");
		bootsmeta.setColor(Color.fromBGR(10, 130, 120));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
	}
}
