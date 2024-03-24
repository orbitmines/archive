package me.O_o_Fadi_o_O.KitPvP.kits.Lord;

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

public class LordLvL1 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.Lord_LvL_1);
		TitleManager.setTitle(p, "", "§7Selected Kit '§b§lLord§7' (§aLevel 1§7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// GOLD SWORD
		ItemStack sword = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lLord §a§lLvL 1§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.DURABILITY, 3);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// GOLDEN POTION
		ItemStack apple = new ItemStack(Material.GOLDEN_APPLE, 5);
		ItemMeta applemeta = apple.getItemMeta();
		applemeta.setDisplayName("§b§lLord §a§lLvL 1§8 || §eGolden Apple");
		apple.setItemMeta(applemeta);
		p.getInventory().setItem(1, new ItemStack(apple));
		
		// GOLD HELMET
		ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lLord §a§lLvL 1§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.DURABILITY, 3);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lLord §a§lLvL 1§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lLord §a§lLvL 1§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lLord §a§lLvL 1§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
		// STRENGTH
		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2000000, 0));
		
	}
}
