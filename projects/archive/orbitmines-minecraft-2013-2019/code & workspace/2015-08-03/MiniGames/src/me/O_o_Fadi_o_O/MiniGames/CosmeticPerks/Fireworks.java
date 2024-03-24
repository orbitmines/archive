package me.O_o_Fadi_o_O.MiniGames.CosmeticPerks;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.CustomItem;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fireworks {
	
	Start start = Start.getInstance();
	
	public static void getFireworksInv(Player p, Inventory invs){
		
		getColor1(invs, p, 10);
		getColor2(invs, p, 28);
		getFade1(invs, p, 12);
		getFade2(invs, p, 30);
		getTrail(invs, p, 14);
		getFlicker(invs, p, 32);
		getType(invs, p, 25);
		
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			invs.setItem(48, item);
		}
		{
			ItemStack item = new ItemStack(Material.ANVIL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§e§nCreate Firework");
			item.setItemMeta(itemmeta);
			invs.setItem(49, item);
		}
		
		getVIPPasses(invs, p, 50);
		
		{
			ItemStack item = new ItemStack(Material.EMPTY_MAP, 5);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§l+5 Firework Passes");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b2 VIP Points");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			invs.setItem(52, item);
		}
		{
			ItemStack item = new ItemStack(Material.EMPTY_MAP, 25);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§l+25 Firework Passes");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b10 VIP Points");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			invs.setItem(53, item);
		}
		p.openInventory(invs);
	}
	
	public static void getVIPPasses(Inventory inv, Player p, int slot){
		ItemStack item = new ItemStack(Material.EMPTY_MAP, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§c§nFirework Passes:§r §6§n" + StorageManager.fireworkpasses.get(p));
		item.setItemMeta(itemmeta);
		inv.setItem(slot, item);
	}
	
	public static void getColor1(Inventory inv, Player p, int slot){
		
		if(StorageManager.fireworkcolor1.get(p) != null){
			if(StorageManager.fireworkcolor1.get(p) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.YELLOW){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §e§lYellow");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 11);
				inv.setItem(slot, item);
			}

		}
		else{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Color 1: §b§lLight Blue");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 12);
			inv.setItem(slot, item);
		}
	}
	
	public static void getColor2(Inventory inv, Player p, int slot){
		
		if(StorageManager.fireworkcolor2.get(p) != null){
			if(StorageManager.fireworkcolor2.get(p) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.YELLOW){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §e§lYellow");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 11);
				inv.setItem(slot, item);
			}

		}
		else{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Color 2: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
	}
	
	public static void getFade1(Inventory inv, Player p, int slot){
		
		if(StorageManager.fireworkfade1.get(p) != null){
			if(StorageManager.fireworkfade1.get(p) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.YELLOW){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §e§lYellow");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 11);
				inv.setItem(slot, item);
			}

		}
		else{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Fade 1: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
	}
	
	public static void getFade2(Inventory inv, Player p, int slot){
		
		if(StorageManager.fireworkfade2.get(p) != null){
			if(StorageManager.fireworkfade2.get(p) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.YELLOW){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §e§lYellow");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 11);
				inv.setItem(slot, item);
			}

		}
		else{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Fade 2: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
	}
	
	public static void getTrail(Inventory inv, Player p, int slot){
		if(StorageManager.fireworktrail.get(p) == false){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Trail: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
		else if(StorageManager.fireworktrail.get(p) == true){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Trail: §a§lENABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 5);
			inv.setItem(slot, item);
		}
	}
	
	public static void getFlicker(Inventory inv, Player p, int slot){
		if(StorageManager.fireworkflicker.get(p) == false){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Flicker: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
		else if(StorageManager.fireworkflicker.get(p) == true){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Flicker: §a§lENABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 5);
			inv.setItem(slot, item);
		}
	}
	
	public static void getType(Inventory inv, Player p, int slot){
		
		if(StorageManager.fireworktype.get(p) != null){
			if(StorageManager.fireworktype.get(p) == Type.BALL){
				ItemStack item = new ItemStack(Material.FIREWORK_CHARGE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §e§lSmall");
				item.setItemMeta(itemmeta);
				item = CustomItem.hideFlags(item, 2);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworktype.get(p) == Type.BALL_LARGE){
				ItemStack item = new ItemStack(Material.FIREBALL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §6§lLarge");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworktype.get(p) == Type.BURST){
				ItemStack item = new ItemStack(Material.TNT, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §c§lSpecial");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworktype.get(p) == Type.CREEPER){
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §a§lCreeper");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(StorageManager.fireworktype.get(p) == Type.STAR){
				ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §f§lStar");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
		}
		else{
			ItemStack item = new ItemStack(Material.FIREWORK_CHARGE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Type: §e§lSmall");
			item.setItemMeta(itemmeta);
			item = CustomItem.hideFlags(item, 2);
			inv.setItem(slot, item);
		}
	}
	
	public static void getNextColor1(Player p, Inventory inv){
		if(StorageManager.fireworkcolor1.get(p) != null){
			
			if(StorageManager.fireworkcolor1.get(p) == Color.AQUA){
				StorageManager.fireworkcolor1.put(p, Color.BLACK);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.BLACK){
				StorageManager.fireworkcolor1.put(p, Color.BLUE);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.BLUE){
				StorageManager.fireworkcolor1.put(p, Color.FUCHSIA);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.FUCHSIA){
				StorageManager.fireworkcolor1.put(p, Color.GRAY);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.GRAY){
				StorageManager.fireworkcolor1.put(p, Color.GREEN);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.GREEN){
				StorageManager.fireworkcolor1.put(p, Color.LIME);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.LIME){
				StorageManager.fireworkcolor1.put(p, Color.MAROON);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.MAROON){
				StorageManager.fireworkcolor1.put(p, Color.NAVY);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.NAVY){
				StorageManager.fireworkcolor1.put(p, Color.ORANGE);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.ORANGE){
				StorageManager.fireworkcolor1.put(p, Color.PURPLE);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.PURPLE){
				StorageManager.fireworkcolor1.put(p, Color.RED);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.RED){
				StorageManager.fireworkcolor1.put(p, Color.SILVER);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.SILVER){
				StorageManager.fireworkcolor1.put(p, Color.TEAL);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.TEAL){
				StorageManager.fireworkcolor1.put(p, Color.WHITE);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.WHITE){
				StorageManager.fireworkcolor1.put(p, Color.YELLOW);
				Fireworks.getColor1(inv, p, 10);
			}
			else if(StorageManager.fireworkcolor1.get(p) == Color.YELLOW){
				StorageManager.fireworkcolor1.put(p, Color.AQUA);
				Fireworks.getColor1(inv, p, 10);
			}
			
		}
		else{
			StorageManager.fireworkcolor1.put(p, Color.BLACK);
			Fireworks.getColor1(inv, p, 10);
		}
	}
	
	public static void getNextColor2(Player p, Inventory inv){
		if(StorageManager.fireworkcolor2.get(p) != null){
			
			if(StorageManager.fireworkcolor2.get(p) == Color.AQUA){
				StorageManager.fireworkcolor2.put(p, Color.BLACK);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.BLACK){
				StorageManager.fireworkcolor2.put(p, Color.BLUE);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.BLUE){
				StorageManager.fireworkcolor2.put(p, Color.FUCHSIA);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.FUCHSIA){
				StorageManager.fireworkcolor2.put(p, Color.GRAY);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.GRAY){
				StorageManager.fireworkcolor2.put(p, Color.GREEN);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.GREEN){
				StorageManager.fireworkcolor2.put(p, Color.LIME);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.LIME){
				StorageManager.fireworkcolor2.put(p, Color.MAROON);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.MAROON){
				StorageManager.fireworkcolor2.put(p, Color.NAVY);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.NAVY){
				StorageManager.fireworkcolor2.put(p, Color.ORANGE);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.ORANGE){
				StorageManager.fireworkcolor2.put(p, Color.PURPLE);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.PURPLE){
				StorageManager.fireworkcolor2.put(p, Color.RED);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.RED){
				StorageManager.fireworkcolor2.put(p, Color.SILVER);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.SILVER){
				StorageManager.fireworkcolor2.put(p, Color.TEAL);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.TEAL){
				StorageManager.fireworkcolor2.put(p, Color.WHITE);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.WHITE){
				StorageManager.fireworkcolor2.put(p, Color.YELLOW);
				Fireworks.getColor2(inv, p, 28);
			}
			else if(StorageManager.fireworkcolor2.get(p) == Color.YELLOW){
				StorageManager.fireworkcolor2.remove(p);
				Fireworks.getColor2(inv, p, 28);
			}
			
		}
		else{
			StorageManager.fireworkcolor2.put(p, Color.AQUA);
			Fireworks.getColor2(inv, p, 28);
		}
	}
	
	public static void getNextFade1(Player p, Inventory inv){
		if(StorageManager.fireworkfade1.get(p) != null){
			
			if(StorageManager.fireworkfade1.get(p) == Color.AQUA){
				StorageManager.fireworkfade1.put(p, Color.BLACK);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.BLACK){
				StorageManager.fireworkfade1.put(p, Color.BLUE);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.BLUE){
				StorageManager.fireworkfade1.put(p, Color.FUCHSIA);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.FUCHSIA){
				StorageManager.fireworkfade1.put(p, Color.GRAY);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.GRAY){
				StorageManager.fireworkfade1.put(p, Color.GREEN);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.GREEN){
				StorageManager.fireworkfade1.put(p, Color.LIME);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.LIME){
				StorageManager.fireworkfade1.put(p, Color.MAROON);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.MAROON){
				StorageManager.fireworkfade1.put(p, Color.NAVY);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.NAVY){
				StorageManager.fireworkfade1.put(p, Color.ORANGE);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.ORANGE){
				StorageManager.fireworkfade1.put(p, Color.PURPLE);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.PURPLE){
				StorageManager.fireworkfade1.put(p, Color.RED);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.RED){
				StorageManager.fireworkfade1.put(p, Color.SILVER);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.SILVER){
				StorageManager.fireworkfade1.put(p, Color.TEAL);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.TEAL){
				StorageManager.fireworkfade1.put(p, Color.WHITE);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.WHITE){
				StorageManager.fireworkfade1.put(p, Color.YELLOW);
				Fireworks.getFade1(inv, p, 12);
			}
			else if(StorageManager.fireworkfade1.get(p) == Color.YELLOW){
				StorageManager.fireworkfade1.remove(p);
				Fireworks.getFade1(inv, p, 12);
			}
			
		}
		else{
			StorageManager.fireworkfade1.put(p, Color.AQUA);
			Fireworks.getFade1(inv, p, 12);
		}
	}
	
	public static void getNextFade2(Player p, Inventory inv){
		if(StorageManager.fireworkfade2.get(p) != null){
			
			if(StorageManager.fireworkfade2.get(p) == Color.AQUA){
				StorageManager.fireworkfade2.put(p, Color.BLACK);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.BLACK){
				StorageManager.fireworkfade2.put(p, Color.BLUE);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.BLUE){
				StorageManager.fireworkfade2.put(p, Color.FUCHSIA);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.FUCHSIA){
				StorageManager.fireworkfade2.put(p, Color.GRAY);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.GRAY){
				StorageManager.fireworkfade2.put(p, Color.GREEN);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.GREEN){
				StorageManager.fireworkfade2.put(p, Color.LIME);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.LIME){
				StorageManager.fireworkfade2.put(p, Color.MAROON);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.MAROON){
				StorageManager.fireworkfade2.put(p, Color.NAVY);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.NAVY){
				StorageManager.fireworkfade2.put(p, Color.ORANGE);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.ORANGE){
				StorageManager.fireworkfade2.put(p, Color.PURPLE);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.PURPLE){
				StorageManager.fireworkfade2.put(p, Color.RED);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.RED){
				StorageManager.fireworkfade2.put(p, Color.SILVER);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.SILVER){
				StorageManager.fireworkfade2.put(p, Color.TEAL);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.TEAL){
				StorageManager.fireworkfade2.put(p, Color.WHITE);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.WHITE){
				StorageManager.fireworkfade2.put(p, Color.YELLOW);
				Fireworks.getFade2(inv, p, 30);
			}
			else if(StorageManager.fireworkfade2.get(p) == Color.YELLOW){
				StorageManager.fireworkfade2.remove(p);
				Fireworks.getFade2(inv, p, 30);
			}
			
		}
		else{
			StorageManager.fireworkfade2.put(p, Color.AQUA);
			Fireworks.getFade2(inv, p, 30);
		}
	}
	
	public static void getNextTrail(Player p, Inventory inv){
		if(StorageManager.fireworktrail.get(p) != null){
			
			if(StorageManager.fireworktrail.get(p) == false){
				StorageManager.fireworktrail.put(p, true);
				Fireworks.getTrail(inv, p, 14);
			}
			else if(StorageManager.fireworktrail.get(p) == true){
				StorageManager.fireworktrail.put(p, false);
				Fireworks.getTrail(inv, p, 14);
			}
			
		}
		else{
			StorageManager.fireworktrail.put(p, true);
			Fireworks.getTrail(inv, p, 14);
		}
	}
	
	public static void getNextFlicker(Player p, Inventory inv){
		if(StorageManager.fireworkflicker.get(p) != null){
			
			if(StorageManager.fireworkflicker.get(p) == false){
				StorageManager.fireworkflicker.put(p, true);
				Fireworks.getFlicker(inv, p, 32);
			}
			else if(StorageManager.fireworkflicker.get(p) == true){
				StorageManager.fireworkflicker.put(p, false);
				Fireworks.getFlicker(inv, p, 32);
			}
			
		}
		else{
			StorageManager.fireworkflicker.put(p, true);
			Fireworks.getFlicker(inv, p, 32);
		}
	}
	
	public static void getNextType(Player p, Inventory inv){
		if(StorageManager.fireworktype.get(p) != null){
			
			if(StorageManager.fireworktype.get(p) == Type.BALL){
				StorageManager.fireworktype.put(p, Type.BALL_LARGE);
				Fireworks.getType(inv, p, 25);
			}
			else if(StorageManager.fireworktype.get(p) == Type.BALL_LARGE){
				StorageManager.fireworktype.put(p, Type.BURST);
				Fireworks.getType(inv, p, 25);
			}
			else if(StorageManager.fireworktype.get(p) == Type.BURST){
				StorageManager.fireworktype.put(p, Type.CREEPER);
				Fireworks.getType(inv, p, 25);
			}
			else if(StorageManager.fireworktype.get(p) == Type.CREEPER){
				StorageManager.fireworktype.put(p, Type.STAR);
				Fireworks.getType(inv, p, 25);
			}
			else if(StorageManager.fireworktype.get(p) == Type.STAR){
				StorageManager.fireworktype.put(p, Type.BALL);
				Fireworks.getType(inv, p, 25);
			}
			
		}
		else{
			StorageManager.fireworktype.put(p, Type.BALL_LARGE);
			Fireworks.getType(inv, p, 25);
		}
	}
}
