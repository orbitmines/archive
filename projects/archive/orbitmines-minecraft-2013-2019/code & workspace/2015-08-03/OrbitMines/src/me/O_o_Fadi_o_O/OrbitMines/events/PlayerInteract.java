package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.InteractManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener{
	
	Start hub = Start.getInstance();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		ItemStack item = e.getItem();
		
		if(omp.isLoaded()){
			InteractManager manager = new InteractManager(e);
			
			if(omp.isAFK()){
				omp.noLongerAFK();
			}
			
			if(ServerData.isServer(Server.HUB)){
				if(!p.getWorld().getName().equals(ServerData.getHub().getBuilderWorld().getName())){
					if(p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
						manager.handleKickSign();
						manager.handleMindCraft();
						manager.handleSpawnInteract();
						manager.handlePhysicalAction();
						manager.handleMiniGameSigns();
					}
					
					if(item != null){
						if(!omp.isOpMode() && manager.handleWrittenBook() && manager.handleGrapplingHook()){
							e.setCancelled(true);
						}
	
						if(item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
							// Lobby Inventory \\
							manager.handleCosmeticPerks();
							manager.handleSettings();
							manager.handleFly();
							manager.handleServerSelector();
							manager.handleAchievements();
						}
					}
				}
			}
			else if(ServerData.isServer(Server.KITPVP)){
				KitPvPPlayer kp = omp.getKitPvPPlayer();

				manager.handlePhysicalAction();
				manager.handleSpectator();
				manager.handleClickable();
				
				if(item != null){
					if(!omp.isOpMode() && kp.getKitSelected() == null && manager.handleWrittenBook()){
						e.setCancelled(true);
					}
					
					manager.handleSnowball();
					manager.handleKitPvPEnchantments();
					
					if(item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
						// Lobby Inventory \\
						manager.handleAchievements();
						manager.handleServerSelector();
						manager.handleBoosters();
						manager.handleCosmeticPerks();
						manager.handleKitSelector();
						
						// Spectator Inventory \\
						manager.handleTeleporter();
						manager.handleBackToLobby();
					}
				}
			}
			else if(ServerData.isServer(Server.CREATIVE)){
				manager.handlePlotInteract();
				manager.handleMonsterEggs();
			}
			else if(ServerData.isServer(Server.SURVIVAL)){
				manager.handleClaimHoe();
				manager.handleSpawnInteract();
				manager.handleChestShops();
			}
			else if(ServerData.isServer(Server.SKYBLOCK)){
				manager.handleIsland();
			}
			else if(ServerData.isServer(Server.PRISON)){
				manager.handleMineSigns();
				manager.handleChestShops();
				manager.handleShopSigns();
				manager.handleShops();
			}
			else if(ServerData.isServer(Server.MINIGAMES)){
				manager.handleChests();
				manager.handleSpectator();
				
				if(item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
					manager.handleStats();
					manager.handleGameEffects();
					manager.handleBackToHub();
					manager.handleCosmeticPerks();
					manager.handleTeleporter();
					
					Arena arena = omp.getArena();
					if(arena != null && arena.getType() == MiniGameType.CHICKEN_FIGHT && arena.getState() == GameState.IN_GAME && !arena.isSpectator(omp)){
						Kit kit = omp.getCFPlayer().getKit();
						
						if(kit != null){
							manager.handleFeatherAttack();
							manager.handleEggBomb();
							manager.handleFireShield();
							manager.handleIronFist();
						}
					}
				}
			}
			else{}
			
			if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
				if(item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
					// Pets \\
					if(omp.getPet() != null){
						manager.handleChickenPetEggBomb();
						manager.handleChickenPetAge();
						manager.handleCreeperPetType();
						manager.handleCreeperPetExplode();
						manager.handleOcelotPetColor();
						manager.handleOcelotPetKittyCannon();
						manager.handleHorsePetColor();
						manager.handleHorsePetSpeed();
						manager.handleSilverfishPetLeap();
						manager.handleSilverfishPetBomb();
						manager.handleSheepPetDisco();
						manager.handleSheepPetColor();
						manager.handleCowPetMilkExplosion();
						manager.handleCowPetAge();
						manager.handleWolfPetAge();
						manager.handleWolfPetBark();
						manager.handleSlimePetJump();
						manager.handleSlimePetSize();
						manager.handlePetPigBabies();
						manager.handlePetPigAge();
						manager.handleMagmaCubePetSize();
						manager.handleMagmaCubePetFireball();
						manager.handleMushroomCowPetShroomTrail();
						manager.handleMushroomCowPetFirework();
						manager.handleSpiderPetWebs();
						manager.handleSpiderPetLauncher();
						manager.handleSquidPetInkBomb();
						manager.handleSquidPetWaterSpout();
					}
					
					// Gadets \\
					manager.handleFlameThrower();
					manager.handleMagmaCubeSoccer();
					manager.handleSwapTeleporter();
					manager.handleCreeperLauncher();
					manager.handlePaintballs();
					manager.handleBookExplosion();
					manager.handleSnowGolemAttack();
					manager.handlePetRide();
					manager.handleStacker();
					manager.handleFireworkGun();
				}
			}			
		}
		else{
			omp.notLoaded();
		}
	}
}
