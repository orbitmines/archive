package me.O_o_Fadi_o_O.KitPvP.kits.Soldier;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;

public class SoldierLvL1 {

	public static void give(Player p){
		
		StorageManager.PlayerKitSelected.put(p, KitPlaying.Soldier_LvL_1);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BOW
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bBow");
		bow.setItemMeta(bowmeta);
		p.getInventory().setItem(1, new ItemStack(bow));
		
		// ARROWS
		ItemStack arrow = new ItemStack(Material.ARROW, 16);
		ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bArrow");
		arrow.setItemMeta(arrowmeta);
		p.getInventory().setItem(2, new ItemStack(arrow));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// IRON CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
	}
}
