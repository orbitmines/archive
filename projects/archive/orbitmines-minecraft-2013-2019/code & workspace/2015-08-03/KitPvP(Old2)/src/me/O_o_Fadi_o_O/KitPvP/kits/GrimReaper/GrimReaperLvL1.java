package me.O_o_Fadi_o_O.KitPvP.kits.GrimReaper;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GrimReaperLvL1 {

	public static void give(Player p){
		
		StorageManager.PlayerKitSelected.put(p, KitPlaying.GrimReaper_LvL_1);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE AXE
		ItemStack sword = new ItemStack(Material.STONE_AXE, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lGrimReaper §a§lLvL 1§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lGrimReaper §a§lLvL 1§8 || §bHelmet");
		helmet.setDurability((short) 1);
		helmet.setItemMeta(helmetmeta);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lGrimReaper §a§lLvL 1§8 || §bChestplate");
		List<String> chestplatelore = new ArrayList<String>();
		chestplatelore.add("§7Molten Armor I");
		chestplatemeta.setLore(chestplatelore);
		chestplatemeta.setColor(Color.fromBGR(100, 100, 100));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lGrimReaper §a§lLvL 1§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(100, 100, 100));
		leggings.setItemMeta(leggingsmeta);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lGrimReaper §a§lLvL 1§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(100, 100, 100));
		boots.setItemMeta(bootsmeta);
		p.getInventory().setBoots(boots);
		
		// SLOWNESS
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 0));
	}
}
