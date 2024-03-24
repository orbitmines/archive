package me.O_o_Fadi_o_O.KitPvP.kits.Pyro;

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
import org.bukkit.potion.PotionEffectType;

public class PyroLvL3 {

	public static void give(Player p){

		StorageManager.kitselected.put(p, KitPlaying.Pyro_LvL_3);
		TitleManager.setTitle(p, "", "§7Selected Kit '§b§lPyro§7' (§aLevel 3§7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BOW
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bBow");
		bow.setItemMeta(bowmeta);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		bow = CustomItem.setUnbreakable(bow);
		bow = CustomItem.hideFlags(bow, 4);
		p.getInventory().setItem(1, new ItemStack(bow));
		
		// ARROWS
		ItemStack arrow = new ItemStack(Material.ARROW, 12);
		ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bArrow");
		arrow.setItemMeta(arrowmeta);
		p.getInventory().setItem(2, new ItemStack(arrow));
		
		// GOLD HELMET
		ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// GOLD CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// GOLD LEGGINGS
		ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// GOLD BOOTS
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bBoots");
		List<String> bootslore = new ArrayList<String>();
		bootslore.add("§7Fire Trail I");
		bootsmeta.setLore(bootslore);
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		boots.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
		// FIRE RESISTANCE
		p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000000, 3));
		
	}
}
