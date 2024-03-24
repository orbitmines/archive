package me.O_o_Fadi_o_O.KitPvP.kits.Fisherman;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;

public class FishermanLvL3 {

	public static void give(Player p){
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// FISHING ROD
		ItemStack sword = new ItemStack(Material.FISHING_ROD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// FISH
		ItemStack fish = new ItemStack(Material.RAW_FISH, 1);
		ItemMeta fishmeta = fish.getItemMeta();
		fishmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bFish");
		fish.setDurability((short) 1);
		fish.setItemMeta(fishmeta);
		fish.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
		fish.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().setItem(1, new ItemStack(fish));
		
		// FISH 2
		ItemStack fish2 = new ItemStack(Material.RAW_FISH, 1);
		ItemMeta fishmeta2 = fish2.getItemMeta();
		fishmeta2.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §9Fish Attack");
		fish2.setDurability((short) 3);
		List<String> fishlore = new ArrayList<String>();
		fishlore.add("§7Fish Attack I");
		fishmeta2.setLore(fishlore);
		fish2.setItemMeta(fishmeta2);
		fish2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		p.getInventory().setItem(2, new ItemStack(fish2));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(10, 130, 120));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(10, 130, 120));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(10, 130, 120));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lFisherman §a§lLvL 3§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(10, 130, 120));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		p.getInventory().setBoots(boots);
		
	}
}
