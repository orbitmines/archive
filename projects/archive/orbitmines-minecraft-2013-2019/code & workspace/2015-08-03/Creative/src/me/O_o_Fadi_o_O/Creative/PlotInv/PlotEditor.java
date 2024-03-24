package me.O_o_Fadi_o_O.Creative.PlotInv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Creative.CustomItem;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;
import me.O_o_Fadi_o_O.Creative.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlotEditor {

	@SuppressWarnings("deprecation")
	public static Inventory getPlotEditor(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lPlot Editor");
		
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			if(PlayerManager.hasPlot(p)){
				DyeColor c = StorageManager.plotcolor.get(StorageManager.playersplotnumber.get(p));
				switch (c) {
				case BLACK:
					meta.setDisplayName("§7§lPlot Color §8| §0§lBlack");
					break;
				case BLUE:
					meta.setDisplayName("§7§lPlot Color §8| §1§lBlue");
					break;
				case BROWN:
					meta.setDisplayName("§7§lPlot Color §8| §f§lBrown");
					break;
				case CYAN:
					meta.setDisplayName("§7§lPlot Color §8| §3§lCyan");
					break;
				case GRAY:
					meta.setDisplayName("§7§lPlot Color §8| §8§lDark Gray");
					break;
				case GREEN:
					meta.setDisplayName("§7§lPlot Color §8| §2§lGreen");
					break;
				case LIGHT_BLUE:
					meta.setDisplayName("§7§lPlot Color §8| §b§lLight Blue");
					break;
				case LIME:
					meta.setDisplayName("§7§lPlot Color §8| §a§lLight Green");
					break;
				case MAGENTA:
					meta.setDisplayName("§7§lPlot Color §8| §d§lMagenta");
					break;
				case ORANGE:
					meta.setDisplayName("§7§lPlot Color §8| §6§lOrange");
					break;
				case PINK:
					meta.setDisplayName("§7§lPlot Color §8| §d§lPink");
					break;
				case PURPLE:
					meta.setDisplayName("§7§lPlot Color §8| §5§lPurple");
					break;
				case RED:
					meta.setDisplayName("§7§lPlot Color §8| §c§lRed");
					break;
				case SILVER:
					meta.setDisplayName("§7§lPlot Color §8| §7§lGray");
					break;
				case WHITE:
					meta.setDisplayName("§7§lPlot Color §8| §f§lWhite");
					break;
				case YELLOW:
					meta.setDisplayName("§7§lPlot Color §8| §e§lYellow");
					break;
				default:
					meta.setDisplayName("§7§lPlot Color §8| §c§lNONE");
					break;
				}
				
				item.setDurability((short) c.getWoolData());
			}
			else{
				meta.setDisplayName("§7§lPlot Color §8| §c§lNONE");
				item.setDurability((short) 14);
				item.setAmount(0);
			}
			List<String> lore = new ArrayList<String>();
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Diamond_VIP)){
				lore.add("");
				lore.add("§c§oRequired: §b§lDiamond VIP");
				lore.add("§7§o§nClick Here to Change");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
			}
			else{
				lore.add("");
				lore.add("§7§o§nClick Here to Change");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
			}
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.SIGN, 1);
			ItemMeta meta = item.getItemMeta();
			if(PlayerManager.hasPlot(p)){
				PlotMode mode = StorageManager.plotmode.get(StorageManager.playersplotnumber.get(p));
				switch(mode){
				case NORMAL:
					item.setType(Material.WOOD_AXE);
					meta = item.getItemMeta();
					meta.setDisplayName("§7§lPlot Mode §8| §d§lBuild Mode");
					break;
				case PVP:
					item.setType(Material.STONE_SWORD);
					meta = item.getItemMeta();
					meta.setDisplayName("§7§lPlot Mode §8| §c§lPvP Mode");
					break;
				default:
					break;
				}
			}
			else{
				meta.setDisplayName("§7§lPlot Mode §8| §c§lNONE");
				item.setAmount(0);
			}
			List<String> lore = new ArrayList<String>();
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
				lore.add("");
				lore.add("§c§oRequired: §a§lEmerald VIP");
				lore.add("§7§o§nClick Here to Change");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
			}
			else{
				lore.add("");
				lore.add("§7§o§nClick Here to Change");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
			}
			item = CustomItem.hideFlags(item, 2);
			inv.setItem(15, item);
		}
		
		return inv;
	}
}
