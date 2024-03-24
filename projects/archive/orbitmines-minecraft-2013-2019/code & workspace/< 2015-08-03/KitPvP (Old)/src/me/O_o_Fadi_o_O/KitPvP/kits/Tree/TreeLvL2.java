package me.O_o_Fadi_o_O.KitPvP.kits.Tree;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class TreeLvL2 {

	public static void give(Player p){
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// LEAVES SWORD
		ItemStack sword = new ItemStack(Material.LEAVES, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lTree §a§lLvL 2§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// WOOD BARRIER
		ItemStack wood = new ItemStack(Material.LOG, 1);
		ItemMeta woodmeta = wood.getItemMeta();
		woodmeta.setDisplayName("§b§lTree §a§lLvL 2§8 || §dBarrier");
		List<String> woodlore = new ArrayList<String>();
		woodlore.add("§7Barrier I");
		woodmeta.setLore(woodlore);
		wood.setDurability((short) 1);
		wood.setItemMeta(woodmeta);
		p.getInventory().setItem(1, new ItemStack(wood));
		
		// CHAIN HELMET
		ItemStack helmet = new ItemStack(Material.LEAVES, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lTree §a§lLvL 2§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lTree §a§lLvL 2§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lTree §a§lLvL 2§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lTree §a§lLvL 2§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
	}
}
