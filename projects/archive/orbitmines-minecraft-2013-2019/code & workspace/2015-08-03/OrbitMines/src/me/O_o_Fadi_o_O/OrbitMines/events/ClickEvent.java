package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.ClickManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Inventories.PlotKitInv;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener {
	
	Start hub = Start.getInstance();
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			final Player p = (Player) e.getWhoClicked();
			OMPlayer omp = OMPlayer.getOMPlayer(p);
			ClickManager manager = new ClickManager(e);
			ItemStack item = e.getCurrentItem();
			
			if(omp.isLoaded()){
				if(ServerData.isServer(Server.CREATIVE) && p.getOpenInventory().getTopInventory().getType() != InventoryType.CRAFTING && p.getOpenInventory().getTopInventory().getType() != InventoryType.CREATIVE && !e.getInventory().getName().startsWith(new PlotKitInv(null, null).getInventory().getName()) || ServerData.isServer(Server.KITPVP) && (e.getSlotType() == SlotType.ARMOR || omp.getKitPvPPlayer().isSpectator()) || ServerData.isServer(Server.HUB) && p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
					e.setResult(Result.DENY);
					omp.updateInventory();
				}
			
				manager.handleServerSelector();
				manager.handleSettings();
				manager.handleCosmeticPerks();
				manager.handleAnvilInventory();
				manager.handleFireworks();
				manager.handleHats();
				manager.handleGadgets();
				manager.handleTrails();
				manager.handleWardrobe();
				manager.handleChatColors();
				manager.handleDisguises();
				manager.handlePets();
				manager.handleTrailSettings();
				manager.handleConfirm();
				manager.handleInventoryViewer();
				
				if(!ServerData.isServer(Server.HUB, Server.MINIGAMES)){
					manager.handleOMTShop();
				}
				
				if(ServerData.isServer(Server.HUB)){
					manager.handleMiniGames();
					manager.handleMiniGameTickets();
					manager.handleTicketGamble();
					manager.handleStats();
				}
				else if(ServerData.isServer(Server.KITPVP)){
					manager.handleKitSelector();
					manager.handleKits();
					manager.handleBoosters();
					manager.handleTeleporter();
					manager.handleMasteries();
				}
				else if(ServerData.isServer(Server.CREATIVE)){
					manager.handlePlotKits();
					manager.handlePlotInfo();
					manager.handlePlotMembers();
					manager.handlePlotSetup();
					
					if(!(item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null)){
						if(e.getClickedInventory() != null && e.getClickedInventory().getName() != null){
							if(e.getClickedInventory().getName().startsWith(new PlotKitInv(null, null).getInventory().getName())){
								int slot = e.getSlot();
								if(!(slot == 0 || slot == 1 || slot == 2 || slot == 3 || slot == 18 || slot == 19 || slot == 20 || slot == 21 || slot == 22 || slot == 23 || slot == 24 || slot == 25 || slot == 26)){
									e.setResult(Result.DENY);
									omp.updateInventory();
								}
							}
							
							if(p.getOpenInventory().getTopInventory().getName().startsWith(new PlotKitInv(null, null).getInventory().getName())){
								CreativePlayer cp = omp.getCreativePlayer();
								cp.updateNPCInventory(e.getClickedInventory());
							}
						}
					}
				}
				else if(ServerData.isServer(Server.SURVIVAL)){
					manager.handleChestShopViewer();
					manager.handleRegions();
					manager.handleWarps();
					manager.handleWarpEditor();
					manager.handleWarpItemEditor();
				}
				else if(ServerData.isServer(Server.SKYBLOCK)){
					manager.handleIslandInfo();
					manager.handleIslandMembers();
					manager.handleChallenges();
					manager.handleSkyBlockKits();
				}
				else if(ServerData.isServer(Server.PRISON)){
					manager.handleMines();
					manager.handleGoldShop();
					manager.handleChestShopViewer();
					manager.handleVillagerGamble();
				}
				else if(ServerData.isServer(Server.MINIGAMES)){
					manager.handleStats();
					manager.handleMiniGameTickets();
					manager.handleGameEffects();
					manager.handleTeleporter();
					manager.handleKitSelect();
				}
				else{}
			}
		}
	}
}
