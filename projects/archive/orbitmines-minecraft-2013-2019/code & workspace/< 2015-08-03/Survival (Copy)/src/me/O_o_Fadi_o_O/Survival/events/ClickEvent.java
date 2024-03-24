package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.DisguisePlayer;
import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.Inv.ChatColors;
import me.O_o_Fadi_o_O.Survival.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Survival.Inv.Disguises;
import me.O_o_Fadi_o_O.Survival.Inv.OMTShop;
import me.O_o_Fadi_o_O.Survival.Inv.PetRenameGUI;
import me.O_o_Fadi_o_O.Survival.Inv.Pets;
import me.O_o_Fadi_o_O.Survival.Inv.Trails;
import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;
import me.O_o_Fadi_o_O.Survival.managers.ConfigManager;
import me.O_o_Fadi_o_O.Survival.managers.ConfirmManager;
import me.O_o_Fadi_o_O.Survival.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.RegionManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;
import me.O_o_Fadi_o_O.Survival.utils.ChatColor;
import me.O_o_Fadi_o_O.Survival.utils.Currency;
import me.O_o_Fadi_o_O.Survival.utils.Disguise;
import me.O_o_Fadi_o_O.Survival.utils.Pet;
import me.O_o_Fadi_o_O.Survival.utils.ReflectionUtil;
import me.O_o_Fadi_o_O.Survival.utils.Server;
import me.O_o_Fadi_o_O.Survival.utils.StaffRank;
import me.O_o_Fadi_o_O.Survival.utils.Trail;
import me.O_o_Fadi_o_O.Survival.utils.TrailType;
import me.O_o_Fadi_o_O.Survival.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ClickEvent implements Listener {
	
	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		if(e.getWhoClicked() instanceof Player){
			
			final Player p = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			
			try{
		
						
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().equals("§c§lCancel")){
						
						if(bitem.getItemMeta().getDisplayName().equals("§8§l+100 Claimblocks") || bitem.getItemMeta().getDisplayName().equals("§2§l+400$") || bitem.getItemMeta().getDisplayName().equals("§7§lYour Skull") || bitem.getItemMeta().getDisplayName().equals("§c§lMerchant Announcements")){
							p.openInventory(OMTShop.getOMTShop(p));
						}
						
					}
				}
				
				
				
			}catch(Exception ex){}
		}
	}
}
