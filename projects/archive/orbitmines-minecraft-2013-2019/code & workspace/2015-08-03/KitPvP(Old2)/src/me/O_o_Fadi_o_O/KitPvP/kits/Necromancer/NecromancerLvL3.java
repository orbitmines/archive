package me.O_o_Fadi_o_O.KitPvP.kits.Necromancer;

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

public class NecromancerLvL3 {

	public static void give(Player p){
		
		StorageManager.PlayerKitSelected.put(p, KitPlaying.Necromancer_LvL_3);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// GOLD HOE
		ItemStack sword = new ItemStack(Material.GOLD_HOE, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BOW
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bBow");
		List<String> bowlore = new ArrayList<String>();
		bowlore.add("§7Undeath II");
		bowmeta.setLore(bowlore);
		bow.setItemMeta(bowmeta);
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		p.getInventory().setItem(2, new ItemStack(bow));
		
		// STICK
		ItemStack stick = new ItemStack(Material.STICK, 1);
		ItemMeta stickmeta = stick.getItemMeta();
		stickmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §8Necromancer's Staff");
		List<String> sticklore = new ArrayList<String>();
		sticklore.add("§7Wither I");
		stickmeta.setLore(sticklore);
		stick.setItemMeta(stickmeta);
		stick.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
		p.getInventory().setItem(1, new ItemStack(stick));
		
		// ARROWS
		ItemStack arrow = new ItemStack(Material.ARROW, 10);
		ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bArrow");
		arrow.setItemMeta(arrowmeta);
		p.getInventory().setItem(3, new ItemStack(arrow));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(0, 0, 0));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(0, 0, 0));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(0, 0, 0));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(0, 0, 0));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setBoots(boots);
		
	}
}
