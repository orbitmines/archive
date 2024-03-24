package me.O_o_Fadi_o_O.OrbitMinesPvP.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Teleporter {

	public static Inventory getTeleportInventory(Player p){
		
		Inventory i = Bukkit.createInventory(null, 9, "            §3§lTeleporter");
		
		{	
			
			ItemStack Mars1 = new ItemStack(Material.NETHERRACK, 1);
			ItemMeta Mars1Meta = Mars1.getItemMeta();
			Mars1Meta.setDisplayName("§c§lMars §8| §c1-1");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			
			if(p.hasPermission("OrbitMinesPvP.Mars")){
				l.add("§7§oTeleport Price: §6§o#TODO# Gold");
				l.add("§7§oRequired Level: §f§o1");
			}
			
			else if(p.hasPermission("OrbitMinesPvP.Earth")){
				l.add("§7§oTeleport Price: §6§o#TODO# Gold");
				l.add("§7§oRequired Level: §f§o#TODO#");
			}
			
			else if(p.hasPermission("OrbitMinesPvP.Venus")){
				l.add("§7§oTeleport Price: §6§o#TODO# Gold");
				l.add("§7§oRequired Level: §f§o#TODO#");
			}
			
			Mars1Meta.setLore(l);
			Mars1.setItemMeta(Mars1Meta);
			Mars1.setDurability((short) 1);
			i.setItem(0, Mars1);
			
		}
		return i;
		
	}
}
