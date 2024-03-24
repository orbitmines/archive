package me.O_o_Fadi_o_O.KitPvP.kits.Bunny;

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

public class BunnyLvL3 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.Bunny_LvL_3);
		TitleManager.setTitle(p, "", "§7Selected Kit '§b§lBunny§7' (§aLevel 3§7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// IRON SWORD
		ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		sword = CustomItem.setUnbreakable(sword);
		sword = CustomItem.hideFlags(sword, 4);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// CARROT
		ItemStack carrot = new ItemStack(Material.CARROT_ITEM, 1);
		ItemMeta carrotmeta = carrot.getItemMeta();
		carrotmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §6Knockback Carrot");
		carrot.setItemMeta(carrotmeta);
		carrot.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		carrot.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
		p.getInventory().setItem(1, new ItemStack(carrot));
		
		// POISON POTION
		ItemStack potion1 = new ItemStack(Material.POTION, 1);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §2Poison Potion");
		potion1.setDurability((short) 16420);
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(2, new ItemStack(potion1));
		p.getInventory().setItem(3, new ItemStack(potion1));
		
		// INSTANT DAMAGE POTION
		ItemStack potion2 = new ItemStack(Material.POTION, 1);
		ItemMeta potion2meta = potion2.getItemMeta();
		potion2meta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §4Harming Potion");
		potion2.setDurability((short) 16396);
		potion2.setItemMeta(potion2meta);
		p.getInventory().setItem(4, new ItemStack(potion2));
		p.getInventory().setItem(5, new ItemStack(potion2));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(250, 250, 250));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		helmet = CustomItem.setUnbreakable(helmet);
		helmet = CustomItem.hideFlags(helmet, 4);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(250, 250, 250));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(250, 250, 250));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lBunny §a§lLvL 3§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(250, 250, 250));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
		// JUMP BOOST
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000000, 3));
		
	}
}
