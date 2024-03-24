package me.O_o_Fadi_o_O.KitPvP.kits.Archer;

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

public class ArcherLvL3 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.Archer_LvL_3);
		TitleManager.setTitle(p, "", "§7Selected Kit '§b§lArcher§7' (§aLevel 3§7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BOW
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bBow");
		List<String> bowlore = new ArrayList<String>();
		bowlore.add("§7Lightning I");
		bowmeta.setLore(bowlore);
		bow.setItemMeta(bowmeta);
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		bow = CustomItem.setUnbreakable(bow);
		bow = CustomItem.hideFlags(bow, 4);
		p.getInventory().setItem(1, new ItemStack(bow));
		
		// ARROWS
		ItemStack arrow = new ItemStack(Material.ARROW, 32);
		ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bArrow");
		arrow.setItemMeta(arrowmeta);
		p.getInventory().setItem(2, new ItemStack(arrow));
		
		// HEALING POTION
		ItemStack potion1 = new ItemStack(Material.POTION, 1);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §cHealing Potion");
		potion1.setDurability((short) 16389);
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(3, new ItemStack(potion1));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(204, 255, 51));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(204, 255, 51));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(204, 255, 51));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(204, 255, 51));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
	}
}
