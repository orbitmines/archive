package me.O_o_Fadi_o_O.KitPvP.kits.TNT;

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

public class TNTLvL1 {

	public static void give(Player p){

		StorageManager.PlayerKitSelected.put(p, KitPlaying.TNT_LvL_1);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.TNT, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lTNT �a�lLvL 1�8 || �bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// REDSTONE TORCH
		ItemStack torch = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
		ItemMeta torchmeta = torch.getItemMeta();
		torchmeta.setDisplayName("�b�lTNT �a�lLvL 1�8 || �4TNT Launcher");
		List<String> torchlore = new ArrayList<String>();
		torchlore.add("�7TNT I");
		torchmeta.setLore(torchlore);
		torch.setItemMeta(torchmeta);
		torch.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
		p.getInventory().setItem(1, new ItemStack(torch));
		
		// TNT HELMET
		ItemStack helmet = new ItemStack(Material.TNT, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lTNT �a�lLvL 1�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		p.getInventory().setHelmet(helmet);
		
		// GOLD CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lTNT �a�lLvL 1�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		p.getInventory().setChestplate(chestplate);
		
		// GOLD LEGGINGS
		ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lTNT �a�lLvL 1�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		p.getInventory().setLeggings(leggings);
		
		// GOLD BOOTS
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lTNT �a�lLvL 1�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		p.getInventory().setBoots(boots);
		
	}
}
