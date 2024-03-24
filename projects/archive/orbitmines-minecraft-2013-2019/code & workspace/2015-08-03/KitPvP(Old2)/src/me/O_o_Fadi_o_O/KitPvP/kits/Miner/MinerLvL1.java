package me.O_o_Fadi_o_O.KitPvP.kits.Miner;

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

public class MinerLvL1 {

	public static void give(Player p){
		
		StorageManager.PlayerKitSelected.put(p, KitPlaying.Miner_LvL_1);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// GOLD PICKAXE
		ItemStack sword = new ItemStack(Material.GOLD_PICKAXE, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// HEAL COAL
		ItemStack coal = new ItemStack(Material.COAL, 1);
		ItemMeta coalmeta = coal.getItemMeta();
		coalmeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §1Miner Power");
		List<String> coallore = new ArrayList<String>();
		coallore.add("§7Healing Kit I");
		coalmeta.setLore(coallore);
		coal.setItemMeta(coalmeta);
		coal.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
		p.getInventory().setItem(1, new ItemStack(coal));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(150, 150, 150));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(150, 150, 150));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(150, 150, 150));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lMiner §a§lLvL 1§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(150, 150, 150));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
	}
}
