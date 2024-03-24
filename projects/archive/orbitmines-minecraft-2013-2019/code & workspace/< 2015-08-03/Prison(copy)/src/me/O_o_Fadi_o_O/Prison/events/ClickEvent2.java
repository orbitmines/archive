package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.prisonInv.Shop;
import me.O_o_Fadi_o_O.Prison.prisonInv.VillagerGamble;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent2 implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			final Player p = (Player) he;
			ItemStack c = e.getCurrentItem();
			
			try{
				if(c != null){
					if(e.getInventory().getName().equals("§0§lVillager Gamble")){
						e.setCancelled(true);
						try{
							if(c.getItemMeta().getDisplayName().startsWith("§aYour Gamble Tickets:")){
								if(PlayerManager.hasMoney(p, 10000)){
									PlayerManager.removeMoney(p, 10000);
									PlayerManager.giveGambleTickets(p, 1);
									p.sendMessage("§2§lVillager Gamble §8|§7 Bought §a1 Gamble Ticket §7for §6§l10000 Gold§7!");
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
									VillagerGamble.setItem(e.getInventory(), p, Material.EMERALD, (short) 0, 1, "§aYour Gamble Tickets: §2§l" + StorageManager.playergambletickets.get(p), VillagerGamble.getGambleTicketsItemLore(), 13, false);
								}
								else{
									int needed = 10000 - StorageManager.money.get(p);
									if(needed == 1){
										p.sendMessage("§2§lVillager Gamble §8|§7 You need §6" + needed + "§7 more §6§lGold§7!");
									}
									else{
										p.sendMessage("§2§lVillager Gamble §8|§7 You need §6" + needed + "§7 more §6§lGold§7!");
									}
									p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								}
							}
							if(c.getItemMeta().getDisplayName().equals("§7§lIron Gamble Machine")){
								if(StorageManager.playergambletickets.get(p) >= 1){
									VillagerGamble.clearInventory(e.getInventory());
									VillagerGamble.setAllRandomItemsIronGambleMachine(e.getInventory());
									PlayerManager.removeGambleTickets(p, 1);
									StorageManager.playersgambling.put(p, e.getInventory());
									StorageManager.playergamblingseconds.put(p, 0);
								}
								else{
									int needed = 1 - StorageManager.playergambletickets.get(p);
									if(needed == 1){
										p.sendMessage("§2§lVillager Gamble §8|§7 You need §a" + needed + "§7 more §aGamble Ticket§7!");
									}
									else{
										p.sendMessage("§2§lVillager Gamble §8|§7 You need §a" + needed + "§7 more §aGamble Tickets§7!");
									}
									p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								}
							}
						}catch(Exception ex){}
					}
					
				}
			}catch(Exception ex){
				
			}
		}
	}
}
