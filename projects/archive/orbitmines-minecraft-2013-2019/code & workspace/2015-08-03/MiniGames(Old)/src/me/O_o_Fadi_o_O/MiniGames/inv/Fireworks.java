package me.O_o_Fadi_o_O.MiniGames.inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fireworks {
	
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
		itemmeta.setDisplayName("§c§nFirework Passes:§r §6§n" + Start.FireworkPasses.get(p.getName()));
		item.setItemMeta(itemmeta);
		inv.setItem(slot, item);
	}
	
	public static void getColor1(Inventory inv, Player p, int slot){
		
		if(Start.FireworkColor1.get(p.getName()) != null){
			if(Start.FireworkColor1.get(p.getName()) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor1.get(p.getName()) == Color.YELLOW){
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
		
		if(Start.FireworkColor2.get(p.getName()) != null){
			if(Start.FireworkColor2.get(p.getName()) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 2: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkColor2.get(p.getName()) == Color.YELLOW){
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
		
		if(Start.FireworkFade1.get(p.getName()) != null){
			if(Start.FireworkFade1.get(p.getName()) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 1: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade1.get(p.getName()) == Color.YELLOW){
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
		
		if(Start.FireworkFade2.get(p.getName()) != null){
			if(Start.FireworkFade2.get(p.getName()) == Color.AQUA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §b§lLight Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.BLACK){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §0§lBlack");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.BLUE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §1§lDark Blue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.FUCHSIA){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §d§lPink");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 9);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.GRAY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §8§lGray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 8);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.GREEN){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §2§lGreen");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 2);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.LIME){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §a§lLight Green");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 10);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.MAROON){
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §4§lDark Red");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.NAVY){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §9§lBlue");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 12);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.ORANGE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §6§lOrange");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.PURPLE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §5§lPurple");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.RED){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §c§lRed");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 1);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.SILVER){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §7§lLight Gray");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 7);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.TEAL){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §3§lCyan");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 6);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.WHITE){
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Fade 2: §f§lWhite");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFade2.get(p.getName()) == Color.YELLOW){
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
		
		if(Start.FireworkTrail.get(p.getName()) != null){
			if(Start.FireworkTrail.get(p.getName()) == false){
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Trail: §c§lDISABLED");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkTrail.get(p.getName()) == true){
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Trail: §a§lENABLED");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
		}
		else{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Trail: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
	}
	
	public static void getFlicker(Inventory inv, Player p, int slot){
		
		if(Start.FireworkFlicker.get(p.getName()) != null){
			if(Start.FireworkFlicker.get(p.getName()) == false){
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Flicker: §c§lDISABLED");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkFlicker.get(p.getName()) == true){
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Flicker: §a§lENABLED");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 5);
				inv.setItem(slot, item);
			}
		}
		else{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Flicker: §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
	}
	
	public static void getType(Inventory inv, Player p, int slot){
		
		if(Start.FireworkType.get(p.getName()) != null){
			if(Start.FireworkType.get(p.getName()) == Type.BALL){
				ItemStack item = new ItemStack(Material.FIREWORK_CHARGE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §e§lSmall");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkType.get(p.getName()) == Type.BALL_LARGE){
				ItemStack item = new ItemStack(Material.FIREBALL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §6§lLarge");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkType.get(p.getName()) == Type.BURST){
				ItemStack item = new ItemStack(Material.TNT, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §c§lSpecial");
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkType.get(p.getName()) == Type.CREEPER){
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: §a§lCreeper");
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(slot, item);
			}
			else if(Start.FireworkType.get(p.getName()) == Type.STAR){
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
			inv.setItem(slot, item);
		}
	}
}
