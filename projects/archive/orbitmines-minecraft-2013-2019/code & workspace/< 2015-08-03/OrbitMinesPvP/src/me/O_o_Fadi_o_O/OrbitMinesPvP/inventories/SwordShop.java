package me.O_o_Fadi_o_O.OrbitMinesPvP.inventories;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwordShop implements Listener {
	
	public static Inventory getSwordShopInventory(Player p){
		
		Inventory i = Bukkit.createInventory(null, 9, "           §9§lBuy Weapons");
		
		{
			// WEAPON TIER 1
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 1);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+1 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 1");
			l.add(" ");
			// IF WEAPON TIER = -1
			if(Start.WeaponTier.get(p.getName()) <= -1){
				l.add("§7§oBuy Price: §e§o100 Coins");
				l.add(" ");
				
				l.add("§4§lLocked");
				l.add("§4§oBuy At Least the Tier 0 Weapon.");
			}
			// IF WEAPON TIER = 0
			if(Start.WeaponTier.get(p.getName()) == 0){
				
				l.add("§7§oBuy Price: §e§o100 Coins");
				l.add(" ");
				
				l.add("§c§lLocked");
				l.add("§c§oClick Here to Upgrade your Weapon.");
				
			}
			// IF WEAPON TIER = 1+
			if(Start.WeaponTier.get(p.getName()) >= 1){
				// IF WEAPON TIER 1 IS EQUIPED
				if(Start.WeaponTierEquiped.get(p.getName()) == 1){
					l.add("§6§lEquiped");
				}
				// IF WEAPON TIER 1 IS UNLOCKED BUT NOT EQUIPED
				else if(Start.WeaponTier.get(p.getName()) >= 1){
				
					l.add("§a§lUnlocked");
					l.add("§a§oClick Here to Equip.");
				}
				
			}
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(0, weapon);
			
		}
		{
			// WEAPON TIER 2
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 2);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+2 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 2");
			l.add(" ");
			// IF WEAPON TIER = 0
			if(Start.WeaponTier.get(p.getName()) <= 0){
				l.add("§7§oBuy Price: §e§o#TODO# Coins");
				l.add(" ");
				
				l.add("§4§lLocked");
				l.add("§4§oBuy At Least the Tier 1 Weapon.");
			}
			// IF WEAPON TIER = 1
			if(Start.WeaponTier.get(p.getName()) == 1){
				
				l.add("§7§oBuy Price: §e§o#TODO# Coins");
				l.add(" ");
				
				l.add("§c§lLocked");
				l.add("§c§oClick Here to Upgrade your Weapon.");
				
			}
			// IF WEAPON TIER = 2+
			if(Start.WeaponTier.get(p.getName()) >= 2){
				// IF WEAPON TIER 2 IS EQUIPED
				if(Start.WeaponTierEquiped.get(p.getName()) == 2){
					l.add("§6§lEquiped");
				}
				// IF WEAPON TIER 2 IS UNLOCKED BUT NOT EQUIPED
				else if(Start.WeaponTier.get(p.getName()) >= 2){
				
					l.add("§a§lUnlocked");
					l.add("§a§oClick Here to Equip.");
				}
				
			}
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(1, weapon);
			
		}
		{
			// WEAPON TIER 4
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 4);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+4 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 4");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(2, weapon);
			
		}
		{
			// WEAPON TIER 5
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 5);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+5 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 5");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(3, weapon);
			
		}
		{
			// WEAPON TIER 6
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 6);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+6 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 6");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(4, weapon);
			
		}
		{
			// WEAPON TIER 7
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 7);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+7 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 7");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(5, weapon);
			
		}
		{
			// WEAPON TIER 8
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 8);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+8 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 8");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(6, weapon);
			
		}
		{
			// WEAPON TIER 9
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 9);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+10 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 9");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(7, weapon);
			
		}
		{
			// WEAPON TIER 10
			ItemStack weapon = new ItemStack(Material.WOOD_SWORD, 10);
			ItemMeta weaponmeta = weapon.getItemMeta();
			weaponmeta.setDisplayName("§bWeapon §8|| §9+15 Attack Damage");
			List<String> l = new ArrayList<String>();
			l.add("§7§oTier 10");
			l.add(" ");
			l.add("§7§oBuy Price: §e§o#TODO# Coins");
			weaponmeta.setLore(l);
			weapon.setItemMeta(weaponmeta);
			i.setItem(8, weapon);
			
		}
	return i;
	}
}
