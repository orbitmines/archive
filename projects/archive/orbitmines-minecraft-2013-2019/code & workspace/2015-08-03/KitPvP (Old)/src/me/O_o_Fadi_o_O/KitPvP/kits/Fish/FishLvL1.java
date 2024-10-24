package me.O_o_Fadi_o_O.KitPvP.kits.Fish;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FishLvL1 {

	public static void give(Player p){
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// FISH1
		ItemStack fish1 = new ItemStack(Material.RAW_FISH, 1);
		ItemMeta fish1meta = fish1.getItemMeta();
		fish1meta.setDisplayName("�b�lFish �a�lLvL 1�8 || �bFish Weapon");
		fish1.setDurability((short) 0);
		fish1.setItemMeta(fish1meta);
		fish1.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
		p.getInventory().setItem(0, new ItemStack(fish1));
		
		// FISH2
		ItemStack fish2 = new ItemStack(Material.RAW_FISH, 1);
		ItemMeta fish2meta = fish2.getItemMeta();
		fish2meta.setDisplayName("�b�lFish �a�lLvL 1�8 || �6Knockback Fish");
		fish2.setDurability((short) 2);
		fish2.setItemMeta(fish2meta);
		fish2.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
		p.getInventory().setItem(1, new ItemStack(fish2));
		
		// FISH3
		ItemStack fish3 = new ItemStack(Material.COOKED_FISH, 1);
		ItemMeta fish3meta = fish3.getItemMeta();
		fish3meta.setDisplayName("�b�lFish �a�lLvL 1�8 || �4Hot Fish");
		fish3.setDurability((short) 0);
		fish3.setItemMeta(fish3meta);
		fish3.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		fish3.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().setItem(2, new ItemStack(fish3));
		
		// CHAIN HELMET
		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lFish �a�lLvL 1�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lFish �a�lLvL 1�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lFish �a�lLvL 1�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lFish �a�lLvL 1�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		p.getInventory().setBoots(boots);
		
		// WATER BREATH
		p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 2000000, 2));
	}
}
