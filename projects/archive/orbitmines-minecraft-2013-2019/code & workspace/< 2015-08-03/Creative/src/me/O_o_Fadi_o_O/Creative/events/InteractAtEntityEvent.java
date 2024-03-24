package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.PlotInv.PlotEditor;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.plot.PvPPlotManager;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class InteractAtEntityEvent implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent e){
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		
		ItemStack item = p.getItemInHand();
		
		if(StorageManager.armorstands.contains(en)){
			e.setCancelled(true);
		}
		if(StorageManager.loaded.get(p) == true){
			if(p.getWorld().getName().equals(StorageManager.creativeworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(!PlayerManager.isOnOwnPlot(p, en.getLocation()));
				}
				
				for(int PlotNumber : StorageManager.plotpvpnpcs.keySet()){
					for(Entity ent : StorageManager.plotpvpnpcs.get(PlotNumber)){
						if(en == ent){
							e.setCancelled(true);
							
							if(StorageManager.plotmode.get(PlotNumber) == PlotMode.PVP){
								if(StorageManager.plotpvpplayers.get(PlotNumber).contains(p) && !StorageManager.plotpvpplayersselectedkit.get(PlotNumber).contains(p)){
									PvPPlotManager.selectKit(p, PlotNumber, StorageManager.plotpvpkitnames.get(PlotNumber).get(StorageManager.plotpvpnpcs.get(PlotNumber).indexOf(ent)));
								}
							}
							if(StorageManager.playersinpvpsetup.contains(p) && StorageManager.playersplotnumber.get(p) == PlotNumber){
								PvPPlotManager.openInventory(p, ent);
							}
						}
					}
				}
			}
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
				}
				if(en == StorageManager.ploteditornpc){
					e.setCancelled(true);
					p.openInventory(PlotEditor.getPlotEditor(p));
				}
			}
			if(item != null && item.getType() != null && item.getType() == Material.MONSTER_EGG){
				e.setCancelled(true);
				p.updateInventory();
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}
}
