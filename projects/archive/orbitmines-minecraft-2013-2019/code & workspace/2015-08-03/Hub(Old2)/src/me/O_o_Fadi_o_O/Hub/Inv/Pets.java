package me.O_o_Fadi_o_O.Hub.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pets {
	
	public static Inventory getPetsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lPets");
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9Squid Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.squid.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b600 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 94);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Mushroom Cow Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.mushroomcow.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 96);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dPig Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.pig.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 90);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Wolf Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.wolf.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 95);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSheep Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.sheep.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 91);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Horse Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.horse.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b525 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 100);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aCreeper Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.creeper.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b525 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 50);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(16, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Spider Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.spider.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 52);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cMagma Cube Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.magmacube.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 62);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aSlime Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.slime.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 55);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(21, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Cow Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.cow.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 92);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(22, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Silverfish Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.silverfish.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b450 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 60);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(23, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eOcelot Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.ocelot.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b450 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 98);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Chicken Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.chicken.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 93);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(25, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(39, item);
		}
		{
			ItemStack item = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(PlayerManager.isPetActive(p)){
				Entity en = StorageManager.ownerpets.get(p);
				if(en instanceof MushroomCow){
					itemmeta.setDisplayName("§fRename your §4Mushroom Cow Pet");
				}
				else if(en instanceof Pig){
					itemmeta.setDisplayName("§fRename your §dPig Pet");
				}
				else if(en instanceof Wolf){
					itemmeta.setDisplayName("§fRename your §7Wolf Pet");
				}
				else if(en instanceof Sheep){
					itemmeta.setDisplayName("§fRename your §fSheep Pet");
				}
				else if(en instanceof Horse){
					itemmeta.setDisplayName("§fRename your §6Horse Pet");
				}
				else if(en instanceof MagmaCube){
					itemmeta.setDisplayName("§fRename your §cMagma Cube Pet");
				}
				else if(en instanceof Slime){
					itemmeta.setDisplayName("§fRename your §aSlime Pet");
				}
				else if(en instanceof Cow){
					itemmeta.setDisplayName("§fRename your §8Cow Pet");
				}
				else if(en instanceof Silverfish){
					itemmeta.setDisplayName("§fRename your §7Silverfish Pet");
				}
				else if(en instanceof Ocelot){
					itemmeta.setDisplayName("§fRename your §eOcelot Pet");
				}
				else if(en instanceof Creeper){
					itemmeta.setDisplayName("§fRename your §aCreeper Pet");
				}
				else if(en instanceof Skeleton){//FAKE SQUID
					itemmeta.setDisplayName("§fRename your §9Squid Pet");
				}
				else if(en instanceof Spider){
					itemmeta.setDisplayName("§fRename your §8Spider Pet");
				}
				else if(en instanceof Chicken){
					itemmeta.setDisplayName("§fRename your §7Chicken Pet");
				}
			}
			else{
				itemmeta.setDisplayName("§fRename §fPet");
			}
			
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b10 VIP Points");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			inv.setItem(40, item);
		}
		{
			ItemStack item = new ItemStack(Material.FIRE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nDisable Pet");
			item.setItemMeta(itemmeta);
			inv.setItem(41, item);
		}
		
		return inv;
	}
}
