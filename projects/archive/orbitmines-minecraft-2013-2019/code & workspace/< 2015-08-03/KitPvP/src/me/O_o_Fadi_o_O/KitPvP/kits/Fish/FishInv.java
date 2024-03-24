package me.O_o_Fadi_o_O.KitPvP.kits.Fish;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FishInv {

	public Inventory FishInventory(Player p, int level){
		
		if(level == 1){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lFish (Level 1)");
			
			// FISH1
			ItemStack fish1 = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fish1meta = fish1.getItemMeta();
			fish1meta.setDisplayName("§b§lFish §a§lLvL 1§8 || §bFish Weapon");
			fish1.setDurability((short) 0);
			fish1.setItemMeta(fish1meta);
			fish1.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
			
			// FISH2
			ItemStack fish2 = new ItemStack(Material.RAW_FISH, 1);
			ItemMeta fish2meta = fish2.getItemMeta();
			fish2meta.setDisplayName("§b§lFish §a§lLvL 1§8 || §6Knockback Fish");
			fish2.setDurability((short) 2);
			fish2.setItemMeta(fish2meta);
			fish2.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
			
			// FISH3
			ItemStack fish3 = new ItemStack(Material.COOKED_FISH, 1);
			ItemMeta fish3meta = fish3.getItemMeta();
			fish3meta.setDisplayName("§b§lFish §a§lLvL 1§8 || §4Hot Fish");
			fish3.setDurability((short) 0);
			fish3.setItemMeta(fish3meta);
			fish3.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
			fish3.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			
			// CHAIN HELMET
			ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
			ItemMeta helmetmeta = helmet.getItemMeta();
			helmetmeta.setDisplayName("§b§lFish §a§lLvL 1§8 || §bHelmet");
			helmet.setItemMeta(helmetmeta);
			
			// CHAIN CHESTPLATE
			ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			ItemMeta chestplatemeta = chestplate.getItemMeta();
			chestplatemeta.setDisplayName("§b§lFish §a§lLvL 1§8 || §bChestplate");
			chestplate.setItemMeta(chestplatemeta);
			
			// CHAIN LEGGINGS
			ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
			ItemMeta leggingsmeta = leggings.getItemMeta();
			leggingsmeta.setDisplayName("§b§lFish §a§lLvL 1§8 || §bLeggings");
			leggings.setItemMeta(leggingsmeta);
			
			// CHAIN BOOTS
			ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
			ItemMeta bootsmeta = boots.getItemMeta();
			bootsmeta.setDisplayName("§b§lFish §a§lLvL 1§8 || §bBoots");
			boots.setItemMeta(bootsmeta);
			
			// POTIONEFFECT
			ItemStack potioneffect = new ItemStack(Material.POTION, 1);
			ItemMeta potioneffectmeta = potioneffect.getItemMeta();
			potioneffectmeta.setDisplayName("§8§l§oWater Breathing III");
			potioneffect.setItemMeta(potioneffectmeta);
			
			i.setItem(18, potioneffect);
			i.setItem(26, potioneffect);
			i.setItem(11, fish1);
			i.setItem(20, fish2);
			i.setItem(15, fish3);
			i.setItem(4, helmet);
			i.setItem(13, chestplate);
			i.setItem(22, leggings);
			i.setItem(31, boots);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§4§l§o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("§7§oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Fish LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lFish §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Fish LVL 2
			ItemStack kit2 = new ItemStack(Material.INK_SACK, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§4§l§oUnavailable");
			kit2.setDurability((short) 1);
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Fish LVL 3
			ItemStack kit3 = new ItemStack(Material.INK_SACK, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§4§l§oUnavailable");
			kit3.setDurability((short) 1);
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.fish.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour OMT Balance: §e§o" + StorageManager.orbitminestokens.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §e§o150 OMT");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fish.get(p) >= 1){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 1§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§a§lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		else if(level == 2){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lFish (Level 2)");
		
			// Fish LVL 2
			ItemStack red = new ItemStack(Material.INK_SACK, 3);
			ItemMeta redmeta = red.getItemMeta();
			redmeta.setDisplayName("§4§l§oUnavailable");
			red.setDurability((short) 1);
			red.setItemMeta(redmeta);
		
			i.setItem(4, red);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§4§l§o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("§7§oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Fish LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lFish §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Fish LVL 2
			ItemStack kit2 = new ItemStack(Material.INK_SACK, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§4§l§oUnavailable");
			kit2.setDurability((short) 1);
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Fish LVL 3
			ItemStack kit3 = new ItemStack(Material.INK_SACK, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§4§l§oUnavailable");
			kit3.setDurability((short) 1);
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.fish.get(p) == 0){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fish.get(p) == 1){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour OMT Balance: §e§o" + StorageManager.orbitminestokens.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §e§o### Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fish.get(p) >= 2){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 2§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§a§lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		
		else if(level == 3){
			final Inventory i = Bukkit.createInventory(null, 54, "§0§lFish (Level 3)");
			
			// Fish LVL 3
			ItemStack red = new ItemStack(Material.INK_SACK, 3);
			ItemMeta redmeta = red.getItemMeta();
			redmeta.setDisplayName("§4§l§oUnavailable");
			red.setDurability((short) 1);
			red.setItemMeta(redmeta);
		
			i.setItem(4, red);
			
			// BACK TO KIT SELECTOR
			ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§4§l§o<< Back");
			List<String> backlore = new ArrayList<String>();		
			backlore.add("");
			backlore.add("§7§oBack to the Kit Selector");
			backlore.add("");
			backmeta.setLore(backlore);
			back.setItemMeta(backmeta);
			i.setItem(45, back);
			
			// Fish LVL 1
			ItemStack kit1 = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta kit1meta = kit1.getItemMeta();
			kit1meta.setDisplayName("§b§lFish §7§o(§a§oLvL 1§7§o)");
			kit1.setItemMeta(kit1meta);
			i.setItem(48, kit1);
			
			// Fish LVL 2
			ItemStack kit2 = new ItemStack(Material.INK_SACK, 2);
			ItemMeta kit2meta = kit2.getItemMeta();
			kit2meta.setDisplayName("§4§l§oUnavailable");
			kit2.setDurability((short) 1);
			kit2.setItemMeta(kit2meta);
			i.setItem(49, kit2);
			
			// Fish LVL 3
			ItemStack kit3 = new ItemStack(Material.INK_SACK, 3);
			ItemMeta kit3meta = kit3.getItemMeta();
			kit3meta.setDisplayName("§4§l§oUnavailable");
			kit3.setDurability((short) 1);
			kit3.setItemMeta(kit3meta);
			i.setItem(50, kit3);
			
			// BACK TO KIT SELECTOR
			ItemStack buy = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta buymeta = buy.getItemMeta();
			if(StorageManager.fish.get(p) <= 1){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§4§lLocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fish.get(p) == 2){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§7§oYour OMT Balance: §e§o" + StorageManager.orbitminestokens.get(p));
				buylore.add("");
				buylore.add("§7§oPrice: §e§o### Coins");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			if(StorageManager.fish.get(p) >= 3){
				buymeta.setDisplayName("§2§l§oBuy Fish §7§o(§a§oLvL 3§7§o)");
				List<String> buylore = new ArrayList<String>();		
				buylore.add("");
				buylore.add("§a§lUnlocked");
				buylore.add("");
				buymeta.setLore(buylore);
			}
			buy.setItemMeta(buymeta);
			i.setItem(53, buy);

			return i;
		}
		else{
			
			return null;
		}
	}
}
