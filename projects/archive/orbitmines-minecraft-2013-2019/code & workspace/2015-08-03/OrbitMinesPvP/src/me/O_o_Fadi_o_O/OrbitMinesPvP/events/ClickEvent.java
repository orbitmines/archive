package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.SellMaterials;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.SwordShop;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.TradeMaterials;
import me.O_o_Fadi_o_O.OrbitMinesPvP.items.WeaponTier1;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener{
	Start plugin;
	 
	public ClickEvent(Start instance) {
	plugin = instance;
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			Player p = (Player) he;
				e.setCancelled(true);
			// SWORD SHOP
			if(e.getInventory().getName().equals(SwordShop.getSwordShopInventory(p).getName())){
				
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// TIER 1 WEAPON
					if(c.getType() == Material.WOOD_SWORD && c.getItemMeta().getDisplayName().equals("§bWeapon §8|| §9+1 Attack Damage")){
						
						if(c.getItemMeta().getLore().contains("§4§lLocked")){
							p.sendMessage("§8[§9§lWeapons§8] §7You can't use this! It's §4§lLocked!");
						}
						else if(c.getItemMeta().getLore().contains("§c§lLocked")){
							if(plugin.getConfig().getInt("players." + p.getName() + ".Coins") >= 100){
								
								p.sendMessage("§8[§9§lWeapons§8] §7You have bought the §9Tier 1 Weapon§7! Click on it again to §6Equip §7it!");
								plugin.removeCoins(p, 100);
								plugin.setWeaponTier(p, 1);
								p.closeInventory();
								p.openInventory(SwordShop.getSwordShopInventory(p));
								
							}
							else{
								int current = plugin.getConfig().getInt("players." + p.getName() + ".Coins");
								int coinsneeded = 100 - current;
								p.sendMessage("§8[§9§lWeapons§8] §7You need §9" + coinsneeded + "§7 more §eCoins§7 to buy this!");
							}
						}
						else if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							plugin.setWeaponTierEquiped(p, 1);
							
							p.closeInventory();
							p.openInventory(SwordShop.getSwordShopInventory(p));
							WeaponTier1.giveWeaponTier1(p);
								
						}
						else if(c.getItemMeta().getLore().contains("§6§lEquiped")){
							p.sendMessage("§8[§9§lWeapons§8] §7You already equiped the §9Tier 1 Weapon§7!");
						}
					}
					// TIER 2 WEAPON
					if(c.getType() == Material.WOOD_SWORD && c.getItemMeta().getDisplayName().equals("§bWeapon §8|| §9+2 Attack Damage")){
						
						if(c.getItemMeta().getLore().contains("§4§lLocked")){
							p.sendMessage("§8[§9§lWeapons§8] §7You can't use this! It's §4§lLocked!");
						}
						else if(c.getItemMeta().getLore().contains("§c§lLocked")){
							if(plugin.getConfig().getInt("players." + p.getName() + ".Coins") >= 100){
								
								p.sendMessage("§8[§9§lWeapons§8] §7You have bought the §9Tier 1 Weapon§7! Click on it again to §6Equip §7it!");
								plugin.removeCoins(p, 100);
								plugin.setWeaponTier(p, 1);
								p.closeInventory();
								p.openInventory(SwordShop.getSwordShopInventory(p));
								
							}
							else{
								int current = plugin.getConfig().getInt("players." + p.getName() + ".Coins");
								int coinsneeded = 100 - current;
								p.sendMessage("§8[§9§lWeapons§8] §7You need §9" + coinsneeded + "§7 more §eCoins§7 to buy this!");
							}
						}
						else if(c.getItemMeta().getLore().contains("§a§lUnlocked")){
							plugin.setWeaponTierEquiped(p, 1);
							
							p.closeInventory();
							p.openInventory(SwordShop.getSwordShopInventory(p));
							WeaponTier1.giveWeaponTier1(p);
								
						}
						else if(c.getItemMeta().getLore().contains("§6§lEquiped")){
							p.sendMessage("§8[§9§lWeapons§8] §7You already equiped the §9Tier 1 Weapon§7!");
						}
					}
				}
			}
			// TRADE MATERIALS
			if(e.getInventory().getName().equals(TradeMaterials.getMaterialsInventory().getName())){
				
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// CRAFT PURPLE MATERIAL
					if(c.getType() == Material.INK_SACK && c.getDurability() == 5){
						
						ItemStack red = new ItemStack(Material.INK_SACK);
						red.setDurability((short) 1);
						
						ItemStack blue = new ItemStack(Material.INK_SACK);
						blue.setDurability((short) 4);
						
						ItemStack purple = new ItemStack(Material.INK_SACK);
						purple.setDurability((short) 5);
						if(p.getInventory().containsAtLeast(red, 10) && p.getInventory().containsAtLeast(blue, 5)){
							
							ItemStack removered = new ItemStack(Material.INK_SACK, 10);
							removered.setDurability((short) 1);
							
							ItemStack removeblue = new ItemStack(Material.INK_SACK, 5);
							removeblue.setDurability((short) 4);
							
							p.getInventory().removeItem(removered);
							p.getInventory().removeItem(removeblue);
							p.getInventory().addItem(purple);
							p.sendMessage("§8[§c§lMaterials§8]§7 Crafted §51 Purple Material§7.");
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§c 10 Red Material");
							p.sendMessage("§8[§c§lMaterials§8]§1 5 Blue Material");
						}
					}
					// CRAFT CYAN MATERIAL
					if(c.getType() == Material.INK_SACK && c.getDurability() == 6){
						
						ItemStack green = new ItemStack(Material.INK_SACK);
						green.setDurability((short) 2);
						
						ItemStack blue = new ItemStack(Material.INK_SACK);
						blue.setDurability((short) 4);
						
						ItemStack cyan = new ItemStack(Material.INK_SACK);
						cyan.setDurability((short) 6);
						if(p.getInventory().containsAtLeast(green, 10) && p.getInventory().containsAtLeast(blue, 10)){
							
							ItemStack removegreen = new ItemStack(Material.INK_SACK, 10);
							removegreen.setDurability((short) 2);
							
							ItemStack removeblue = new ItemStack(Material.INK_SACK, 10);
							removeblue.setDurability((short) 4);
							
							p.getInventory().removeItem(removegreen);
							p.getInventory().removeItem(removeblue);
							p.getInventory().addItem(cyan);
							p.sendMessage("§8[§c§lMaterials§8]§7 Crafted §31 Cyan Material§7.");
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§1 10 Blue Material");
							p.sendMessage("§8[§c§lMaterials§8]§2 10 Green Material");
						}
					}
					// CRAFT LIME MATERIAL
					if(c.getType() == Material.INK_SACK && c.getDurability() == 10){
						
						ItemStack green = new ItemStack(Material.INK_SACK);
						green.setDurability((short) 2);
						
						ItemStack yellow = new ItemStack(Material.INK_SACK);
						yellow.setDurability((short) 11);
						
						ItemStack lime = new ItemStack(Material.INK_SACK);
						lime.setDurability((short) 10);
						if(p.getInventory().containsAtLeast(green, 5) && p.getInventory().containsAtLeast(yellow, 10)){
							
							ItemStack removegreen = new ItemStack(Material.INK_SACK, 5);
							removegreen.setDurability((short) 2);
							
							ItemStack removeyellow = new ItemStack(Material.INK_SACK, 10);
							removeyellow.setDurability((short) 11);
							
							p.getInventory().removeItem(removegreen);
							p.getInventory().removeItem(removeyellow);
							p.getInventory().addItem(lime);
							p.sendMessage("§8[§c§lMaterials§8]§7 Crafted §a1 Lime Material§7.");
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§e 10 Yellow Material");
							p.sendMessage("§8[§c§lMaterials§8]§2 5 Green Material");
						}
					}
					// CRAFT MAGENTA MATERIAL
					if(c.getType() == Material.INK_SACK && c.getDurability() == 13){
						
						ItemStack purple = new ItemStack(Material.INK_SACK);
						purple.setDurability((short) 5);
						
						ItemStack cyan = new ItemStack(Material.INK_SACK);
						cyan.setDurability((short) 6);
						
						ItemStack magenta = new ItemStack(Material.INK_SACK);
						magenta.setDurability((short) 13);
						if(p.getInventory().containsAtLeast(purple, 15) && p.getInventory().containsAtLeast(cyan, 10)){
							
							ItemStack removepurple = new ItemStack(Material.INK_SACK, 15);
							removepurple.setDurability((short) 5);
							
							ItemStack removecyan = new ItemStack(Material.INK_SACK, 10);
							removecyan.setDurability((short) 6);
							
							p.getInventory().removeItem(removepurple);
							p.getInventory().removeItem(removecyan);
							p.getInventory().addItem(magenta);
							p.sendMessage("§8[§c§lMaterials§8]§7 Crafted §d1 Magenta Material§7.");
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§5 15 Purple Material");
							p.sendMessage("§8[§c§lMaterials§8]§3 10 Cyan Material");
						}
					}
					// CRAFT LIGHTBLUE MATERIAL
					if(c.getType() == Material.INK_SACK && c.getDurability() == 12){
						
						ItemStack green = new ItemStack(Material.INK_SACK);
						green.setDurability((short) 10);
						
						ItemStack cyan = new ItemStack(Material.INK_SACK);
						cyan.setDurability((short) 6);
						
						ItemStack lightblue = new ItemStack(Material.INK_SACK);
						lightblue.setDurability((short) 12);
						if(p.getInventory().containsAtLeast(green, 15) && p.getInventory().containsAtLeast(cyan, 10)){
							
							ItemStack removegreen = new ItemStack(Material.INK_SACK, 15);
							removegreen.setDurability((short) 10);
							
							ItemStack removecyan = new ItemStack(Material.INK_SACK, 10);
							removecyan.setDurability((short) 6);
							
							p.getInventory().removeItem(removegreen);
							p.getInventory().removeItem(removecyan);
							p.getInventory().addItem(lightblue);
							p.sendMessage("§8[§c§lMaterials§8]§7 Crafted §b1 Light Blue Material§7.");
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§a 15 Lime Material");
							p.sendMessage("§8[§c§lMaterials§8]§3 10 Cyan Material");
						}
					}
					// CRAFT GRAY MATERIAL
					if(c.getType() == Material.INK_SACK && c.getDurability() == 8){
						
						ItemStack magenta = new ItemStack(Material.INK_SACK);
						magenta.setDurability((short) 13);
						
						ItemStack lightblue = new ItemStack(Material.INK_SACK);
						lightblue.setDurability((short) 12);
						
						ItemStack gray = new ItemStack(Material.INK_SACK);
						gray.setDurability((short) 8);
						if(p.getInventory().containsAtLeast(magenta, 10) && p.getInventory().containsAtLeast(lightblue, 10)){
							
							ItemStack removemagenta = new ItemStack(Material.INK_SACK, 10);
							removemagenta.setDurability((short) 13);
							
							ItemStack removelightblue = new ItemStack(Material.INK_SACK, 10);
							removelightblue.setDurability((short) 12);
							
							p.getInventory().removeItem(removemagenta);
							p.getInventory().removeItem(removelightblue);
							p.getInventory().addItem(gray);
							p.sendMessage("§8[§c§lMaterials§8]§7 Crafted §81 Gray Material§7.");
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§d 10 Magenta Material");
							p.sendMessage("§8[§c§lMaterials§8]§b 10 Light Blue Material");
						}
					}
				}
			}
			// SELL MATERIALS
			// SELL RED MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 1){
						
						ItemStack red = new ItemStack(Material.INK_SACK);
						red.setDurability((short) 1);
						
						if(p.getInventory().containsAtLeast(red, 1)){
							p.getInventory().removeItem(red);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §c1 Red Material §7for §e5 Coins");
							plugin.addCoins(p, 5);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§c 1 Red Material");
						}
					}
				}
			}
			// SELL BLUE MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 4){
						
						ItemStack blue = new ItemStack(Material.INK_SACK);
						blue.setDurability((short) 4);
						
						if(p.getInventory().containsAtLeast(blue, 1)){
							p.getInventory().removeItem(blue);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §11 Blue Material §7for §e10 Coins");
							plugin.addCoins(p, 10);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§1 1 Blue Material");
						}
					}
				}
			}
			// SELL GREEN MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 2){
						
						ItemStack green = new ItemStack(Material.INK_SACK);
						green.setDurability((short) 2);
						
						if(p.getInventory().containsAtLeast(green, 1)){
							p.getInventory().removeItem(green);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §21 Green Material §7for §e15 Coins");
							plugin.addCoins(p, 15);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§2 1 Green Material");
						}
					}
				}
			}
			// SELL YELLOW MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 11){
						
						ItemStack yellow = new ItemStack(Material.INK_SACK);
						yellow.setDurability((short) 11);
						
						if(p.getInventory().containsAtLeast(yellow, 1)){
							p.getInventory().removeItem(yellow);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §e1 Yellow Material §7for §e20 Coins");
							plugin.addCoins(p, 20);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§e 1 Yellow Material");
						}
					}
				}
			}
			// SELL PURPLE MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 5){
						
						ItemStack purple = new ItemStack(Material.INK_SACK);
						purple.setDurability((short) 5);
						
						if(p.getInventory().containsAtLeast(purple, 1)){
							p.getInventory().removeItem(purple);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §51 Purple Material §7for §e100 Coins");
							plugin.addCoins(p, 100);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§5 1 Purple Material");
						}
					}
				}
			}
			// SELL CYAN MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 6){
						
						ItemStack cyan = new ItemStack(Material.INK_SACK);
						cyan.setDurability((short) 6);
						
						if(p.getInventory().containsAtLeast(cyan, 1)){
							p.getInventory().removeItem(cyan);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §31 Cyan Material §7for §e250 Coins");
							plugin.addCoins(p, 250);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§3 1 Cyan Material");
						}
					}
				}
			}
			// SELL LIME MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 10){
						
						ItemStack green = new ItemStack(Material.INK_SACK);
						green.setDurability((short) 10);
						
						if(p.getInventory().containsAtLeast(green, 1)){
							p.getInventory().removeItem(green);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §a1 Lime Material §7for §e275 Coins");
							plugin.addCoins(p, 275);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§a 1 Lime Material");
						}
					}
				}
			}
			// SELL MAGENTA MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 13){
						
						ItemStack magenta = new ItemStack(Material.INK_SACK);
						magenta.setDurability((short) 13);
						
						if(p.getInventory().containsAtLeast(magenta, 1)){
							p.getInventory().removeItem(magenta);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §d1 Magenta Material §7for §e4000 Coins");
							plugin.addCoins(p, 4000);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§d 1 Magenta Material");
						}
					}
				}
			}
			// SELL LIGHT BLUE MATERIAL
			if(e.getInventory().getName().equals(SellMaterials.getSellMaterialsInventory().getName())){
				e.setCancelled(true);
				
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.INK_SACK && c.getDurability() == 12){
						
						ItemStack lightblue = new ItemStack(Material.INK_SACK);
						lightblue.setDurability((short) 12);
						
						if(p.getInventory().containsAtLeast(lightblue, 1)){
							p.getInventory().removeItem(lightblue);
							p.sendMessage("§8[§c§lMaterials§8]§7 Sold §b1 Light Blue Material §7for §e6625 Coins");
							plugin.addCoins(p, 6625);
						}
						else{
							p.sendMessage("§8[§c§lMaterials§8]§7 You need:");
							p.sendMessage("§8[§c§lMaterials§8]§b 1 Light Blue Material");
						}
					}
				}
			}
		}
	}
}
