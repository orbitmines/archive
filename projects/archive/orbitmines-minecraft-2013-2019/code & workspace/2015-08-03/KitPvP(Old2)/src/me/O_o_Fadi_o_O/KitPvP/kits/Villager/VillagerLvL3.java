package me.O_o_Fadi_o_O.KitPvP.kits.Villager;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class VillagerLvL3 {

	public static void give(Player p){

		StorageManager.PlayerKitSelected.put(p, KitPlaying.Villager_LvL_3);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// EMERALD
		ItemStack sword = new ItemStack(Material.EMERALD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 9);
		sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BREAD
		ItemStack bread = new ItemStack(Material.BREAD, 1);
		ItemMeta breadmeta = bread.getItemMeta();
		breadmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §aTrade System");
		List<String> breadlore = new ArrayList<String>();
		breadlore.add("§7Trade I");
		breadmeta.setLore(breadlore);
		bread.setItemMeta(breadmeta);
		bread.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
		p.getInventory().setItem(1, new ItemStack(bread));
		
		// CHAIN HELMET
		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
	}
}
