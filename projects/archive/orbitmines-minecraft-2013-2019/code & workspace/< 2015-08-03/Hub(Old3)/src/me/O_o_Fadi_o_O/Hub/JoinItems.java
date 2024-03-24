package me.O_o_Fadi_o_O.Hub;

import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.utils.Gadget;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItems {

	static Hub hub = Hub.getInstance();
	
	public static void giveItems(Player p){
		
		Gadget g = PlayerManager.getGadgetEnabled(p);
		ItemStack i = p.getInventory().getItem(5);
		
		p.getInventory().clear();
	
		{
			ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta itemmeta = (BookMeta) item.getItemMeta();
			itemmeta.setDisplayName("§4§nServer Rules");
			itemmeta.addPage("1");
			itemmeta.setPage(1, "   §6§lOrbitMines§4§lRules" + "\n" + "§0§m-------------------" + "\n" + "§4DO NOT§0 Advertise!" + "\n" + "§0Watch your Language!" + "\n" + "Listen to Staff!" + "\n" + "§4DO NOT§0 Abuse Bugs!" + "\n" + "§4DO NOT§0 Hack!" + "\n" + "§4DO NOT§0 Spam!" + "\n" + "§4DO NOT§0 Bully Players!" + "\n" + "§0\n" + "§0§lHave Fun!");
			itemmeta.setAuthor("§6§lOrbitMines §4§lNetwork");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(0, new ItemStack(item));
			
		}
		{
			ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§d§nAchievements");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(1, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§c§nSettings");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(3, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§nServer Selector");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(4, new ItemStack(item));
		}
		if(g == Gadget.STACKER){
			ItemStack item = new ItemStack(Material.LEASH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§nStacker");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(5, new ItemStack(item));
		}
		else{
			p.getInventory().setItem(5, i);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(7, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.FEATHER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§nFly");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(8, new ItemStack(item));
		}
	}
}
