package me.O_o_Fadi_o_O.Survival.events;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.Inv.OMTShop;
import me.O_o_Fadi_o_O.Survival.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Survival.jobs.invs.JobSelector;
import me.O_o_Fadi_o_O.Survival.jobs.invs.MerchantInv;
import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.RegionManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener{
	
	Start start = Start.getInstance();
	
	private Map<String, Long> lastclicked = new HashMap<String, Long>();
	private final int clickcooldown = 1;
	
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		
		final Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		//ItemStack item = p.getItemInHand();

		if(StorageManager.petowner.containsValue(en)){
			e.setCancelled(true);
		}
		
		if(StorageManager.loaded.get(p) == true){
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
				}
			}
			
			long lastclick = 0;
			if(lastclicked.containsKey(p.getName())){
				lastclick = lastclicked.get(p.getName());
			}
			int cdmillis = clickcooldown * 1000;
					
			if(System.currentTimeMillis()-lastclick>=cdmillis){
				if(StorageManager.regiontpworld1 == en){
					p.openInventory(RegionManager.getRegionInv(p));
					
					p.playSound(p.getLocation(), Sound.ENDERMAN_IDLE, 5, 1);
				}
				if(StorageManager.omtnpc == en){
					p.openInventory(OMTShop.getOMTShop(p));
				}
				if(StorageManager.merchantnpc == en){
					p.openInventory(MerchantInv.getMerchantInv(p));
					
					p.playSound(p.getLocation(), Sound.VILLAGER_IDLE, 5, 1);
				}
				if(StorageManager.jobmanagernpc == en){
					p.openInventory(JobSelector.getJobSelector(p));
			        
					p.playSound(p.getLocation(), Sound.VILLAGER_IDLE, 5, 1);
					int rint = new Random().nextInt(8);
					p.sendMessage("");
					if(rint == 0){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6I'm apparantly your favorite Villager.");
						}
						else{
							p.sendMessage("§6Looking for a job? Then you're at the right place!");
						}
					}
					else if(rint == 1){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6Ready to make some deals again?");
						}
						else{
							p.sendMessage("§6Still a hobo? Don't be that lazy!");
						}
					}
					else if(rint == 2){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6Finally you decided to work.");
						}
						else{
							p.sendMessage("§6So many hobos in this world...");
						}
					}
					else if(rint == 3){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6You again? Seems like you're having fun with your job.");
						}
						else{
							p.sendMessage("§6Don't be lazy! Accept a job and get to work!");
						}
					}
					else if(rint == 4){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6You again?");
						}
						else{
							p.sendMessage("§6You should take a job.");
						}
					}
					else if(rint == 5){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6Let's get to work!");
						}
						else{
							p.sendMessage("§6Looks like you need more money.");
						}
					}
					else if(rint == 6){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6Don't look ate my nose like that, no one is perfect.");
						}
						else{
							p.sendMessage("§6No one leaves here without having a job.");
						}
					}
					else if(rint == 7){
						if(JobManager.job.containsKey(p)){
							p.sendMessage("§6Fair prices, that's what we like.");
						}
						else{
							p.sendMessage("§6No scamming around here. Make profit in a fair way.");
						}
					}
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.serverselector == en){
					e.setCancelled(true);
					p.openInventory(ServerSelector.serverSelector);
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				/*
				if(StorageManager.soccermagmacubes.contains(en)){
					if(StorageManager.soccermagmacube.get(p) == en){
						en.remove();
						StorageManager.soccermagmacube.remove(p);
						p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED§7 your §cMagmaCube Ball§7!");
					}
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.alphanpc == en){
					if(StorageManager.onlineplayers.get(Server.ALPHA) != -1){
						hub.teleportToServer(p, Server.ALPHA);
					}
					else{
						p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §e§lAlpha§7 Server is §4§lOffline§7!");
					}
			        
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.mindcraftnpc == en){
					if(StorageManager.playersinmindcraft.contains(p)){
						MindCraftManager.leaveMindCraft(p);
					}
					else{
						MindCraftManager.joinMindCraft(p);
					}
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.lapisparkournpc == en){
					
					if(StorageManager.playersinlapisparkour.contains(p)){
						StorageManager.playersinlapisparkour.remove(p);
						p.sendMessage("§1§lLapis Parkour §8| §7You left the Parkour. Try again an other time!");
					}
					else{
						StorageManager.playersinlapisparkour.add(p);
						p.sendMessage("");
						p.sendMessage("§1§lLapis Parkour");
						p.sendMessage(" §7- You can't stop sprinting.");
						p.sendMessage(" §7- Reward: §b§l250 VIP Points§7.");
						p.sendMessage("");
						p.sendMessage("§f§lGood Luck!");
						
						TitleManager.setTitle(p, "§1§lLapis Parkour", "§7You can't stop sprinting!");
						
						if(StorageManager.pet.get(p) != Pet.NONE){
							PlayerManager.removePet(p, "§7Pet");
						}
						for(PotionEffect eff : p.getActivePotionEffects()){
							p.removePotionEffect(eff.getType());
						}
					}
					
					if(p.getVehicle() != null){
						p.leaveVehicle();
					}
					p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				
				if(item != null && item.getType() == Material.SADDLE && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null && item.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
					if(StorageManager.petentity.containsKey(p)){
						if(StorageManager.petentity.get(p) == en){					
							en.setPassenger(p);
						}
					}
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				*/
			}				
		}
		else{
			e.setCancelled(true);
			p.updateInventory();
			PlayerManager.warnPlayerNotLoaded(p);
		}
		
		/*
		if(item != null && item.getType() == Material.MONSTER_EGG || item != null && item.getType() == Material.EGG){
			e.setCancelled(true);
			p.updateInventory();
		}
		
		new BukkitRunnable(){
			public void run(){
				p.updateInventory();
			}
		}.runTaskLater(this.hub, 1);
		*/
	}
}
