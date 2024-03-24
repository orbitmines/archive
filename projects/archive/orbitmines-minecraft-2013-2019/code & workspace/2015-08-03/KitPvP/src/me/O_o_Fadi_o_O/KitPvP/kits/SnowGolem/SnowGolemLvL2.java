package me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem;

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
import org.bukkit.potion.PotionEffectType;

public class SnowGolemLvL2 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.SnowGolem_LvL_2);
		TitleManager.setTitle(p, "", "§7Selected Kit '§b§lSnowGolem§7' (§aLevel 2§7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// SNOWBALL
		ItemStack sword = new ItemStack(Material.SNOW_BALL, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lSnowGolem §a§lLvL 2§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
		sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// SHIELD
		ItemStack shield = new ItemStack(Material.IRON_FENCE, 1);
		ItemMeta shieldmeta = shield.getItemMeta();
		shieldmeta.setDisplayName("§b§lSnowGolem §a§lLvL 2§8 || §7Shield");
		List<String> shieldlore = new ArrayList<String>();
		shieldlore.add("§7Shield I");
		shieldmeta.setLore(shieldlore);
		shield.setItemMeta(shieldmeta);
		shield.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		shield = CustomItem.hideFlags(shield, 1);
		p.getInventory().setItem(1, new ItemStack(shield));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.PUMPKIN, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lSnowGolem §a§lLvL 2§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lSnowGolem §a§lLvL 2§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(200, 200, 200));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lSnowGolem §a§lLvL 2§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(200, 200, 200));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lSnowGolem §a§lLvL 2§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(200, 200, 200));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
		// SPEED
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 0));
	}
}
