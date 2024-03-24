package me.O_o_Fadi_o_O.Survival.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.jobs.invs.AnimalFarmerInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.ConfirmInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.FarmerInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.HunterInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.JobSelector;
import me.O_o_Fadi_o_O.Survival.jobs.invs.LumberjackInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.MerchantInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.MinerInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.NetherExpertInv;
import me.O_o_Fadi_o_O.Survival.jobs.invs.SellInv;
import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.ConfirmReason;
import me.O_o_Fadi_o_O.Survival.jobs.utils.Job;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickEvent2 implements Listener{
	
	Start start = Start.getInstance();
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 3600;
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			final Player p = (Player) he;
			ItemStack c = e.getCurrentItem();
			
			if(e.getInventory() != null && e.getInventory().getName() != null && c != null && c.getItemMeta() != null && c.getItemMeta().getDisplayName() != null){
				if(e.getInventory().getName().equals("§0§lJob Manager")){
					e.setCancelled(true);
					
					if(c.getType() == Material.DIAMOND_PICKAXE && c.getItemMeta().getDisplayName().equals("§9§lMiner Job")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.IRON_HOE && c.getItemMeta().getDisplayName().equals("§7§lFarmer Job")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getDisplayName().equals("§6§lLumberjack Job")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getDisplayName().equals("§b§lHunter Job")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§a§lAnimal Farmer Job")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§c§lNether Expert Job")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
				}
				if(e.getInventory().getName().equals("§0§lMerchant")){
					e.setCancelled(true);
					if(c.getItemMeta().getLore() != null && c.getItemMeta().getLore().size() >= 3 && c.getItemMeta().getLore().get(2) != null && c.getItemMeta().getLore().get(2).startsWith(" §7Average Price")){
						MerchantInv.setMaterialInv(p.getOpenInventory().getTopInventory(), JobMaterial.getJobMaterial(c.getType(), c.getDurability()));
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MerchantInv.getMerchantInv(p));
					}
					if(c.getItemMeta().getLore() != null && c.getItemMeta().getLore().size() >= 7 && c.getItemMeta().getLore().get(6) != null && c.getItemMeta().getLore().get(6).equals("§2§lClick Here to Buy")){
						String dealidstring = c.getItemMeta().getLore().get(4).substring(13);
						int dealid = Integer.parseInt(dealidstring);
						if(MerchantManager.merchantidtomaterial.containsKey(dealid)){
							JobMaterial material = MerchantManager.merchantidtomaterial.get(dealid);
							String seller = c.getItemMeta().getLore().get(3).substring(13);
							if(!seller.equals(p.getName())){
								String pricestring = c.getItemMeta().getLore().get(2).substring(12, c.getItemMeta().getLore().get(2).length() -2);
								int price = Integer.parseInt(pricestring);
								if(JobManager.hasMoney(p, price)){
									p.playSound(p.getLocation(), Sound.VILLAGER_YES, 5, 1);
									MerchantManager.removeDeal(seller, material, c.getDurability(), c.getAmount(), price, MerchantManager.merchantdealsid.get(seller).indexOf(dealidstring), p);
								}
								else{
									PlayerManager.sendMoneyRequiredMessage(p, price);
								}
							}
							else{
								p.sendMessage("§a§lMerchant §8| §7You can't buy deals from yourself.");
								p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 1);
							}
						}
						else{
							MerchantInv.setMaterialInv(p.getOpenInventory().getTopInventory(), JobMaterial.getJobMaterial(c.getType(), c.getDurability()));
							p.sendMessage("§a§lMerchant §8| §7That deal doesn't exist anymore!");
							p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 1);
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lAre you sure?")){
					e.setCancelled(true);
					
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§aYes, I want to remove this Deal.")){
						
						Inventory inv = p.getOpenInventory().getTopInventory();
						
						int DealNumber = 0;
						
						if(inv.getItem(4).getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
							DealNumber = 1;
						}
						if(inv.getItem(4).getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
							DealNumber = 2;
						}
						if(inv.getItem(4).getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
							DealNumber = 3;
						}
						
						String DealIDString = inv.getItem(4).getItemMeta().getLore().get(0).substring(14);
						int DealID = Integer.parseInt(DealIDString);
				
						JobMaterial material = MerchantManager.merchantidtomaterial.get(DealID);
						Material m = JobMaterial.getMaterial(material);
						
						p.sendMessage("§6§lJobs §8| §7Removed §6#" + DealID + "§7!");
						
						ItemStack item = new ItemStack(m, MerchantManager.merchantdealitemstacks.get(material).get(DealID).getAmount());
						item.setDurability(MerchantManager.merchantdealitemstacks.get(material).get(DealID).getDurability());
						if(p.getInventory().firstEmpty() == -1){
							p.sendMessage("§6§lJobs §8| §cYou don't have enough Inventory space! Your items are now on the ground!");
							p.getWorld().dropItem(p.getLocation(), item);
						}
						else{
							p.getInventory().addItem(item);
						}
						
						MerchantManager.removeDeal(p, material, DealNumber);
						Job job = JobManager.job.get(p);
						if(job == Job.ANIMAL_FARMER){
							p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
						}
						if(job == Job.ENCHANTER){
							
						}
						if(job == Job.FARMER){
							p.openInventory(FarmerInv.getFarmerInv(p));
						}
						if(job == Job.FISHER){
							
						}
						if(job == Job.HUNTER){
							p.openInventory(HunterInv.getHunterInv(p));
						}
						if(job == Job.LUMBERJACK){
							p.openInventory(LumberjackInv.getLumberjackInv(p));
						}
						if(job == Job.MINER){
							p.openInventory(MinerInv.getMinerInv(p));
						}
						if(job == Job.NETHER_EXPERT){
							p.openInventory(NetherExpertInv.getNetherExpertInv(p));
						}
						if(job == Job.POTION_MASTER){
							
						}
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, 1);
						
					}
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§cNo, I don't want to remove this Deal.")){
						
						p.openInventory(JobSelector.getJobSelector(p));
						
					}
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§aYes, I want to quit my Job.")){
						
						lastUsage.put(p.getName(), System.currentTimeMillis());
						
						if(JobManager.job.get(p) == Job.MINER){
							p.sendMessage("§6§lJobs §8| §7You left the '§9§lMiner§7' Job.");
						}
						if(JobManager.job.get(p) == Job.POTION_MASTER){
							p.sendMessage("§6§lJobs §8| §7You left the '§e§lPotion Master§7' Job.");
						}
						if(JobManager.job.get(p) == Job.HUNTER){
							p.sendMessage("§6§lJobs §8| §7You left the '§b§lHunter§7' Job.");
						}
						if(JobManager.job.get(p) == Job.FARMER){
							p.sendMessage("§6§lJobs §8| §7You left the '§7§lFarmer§7' Job.");
						}
						if(JobManager.job.get(p) == Job.ANIMAL_FARMER){
							p.sendMessage("§6§lJobs §8| §7You left the '§a§lAnimal Farmer§7' Job.");
						}
						if(JobManager.job.get(p) == Job.LUMBERJACK){
							p.sendMessage("§6§lJobs §8| §7You left the '§6§lLumberjack§7' Job.");
						}
						if(JobManager.job.get(p) == Job.NETHER_EXPERT){
							p.sendMessage("§6§lJobs §8| §7You left the '§c§lNether Expert§7' Job.");
						}
						if(JobManager.job.get(p) == Job.ENCHANTER){
							p.sendMessage("§6§lJobs §8| §7You left the '§3§lEnchanter§7' Job.");
						}
						if(JobManager.job.get(p) == Job.FISHER){
							p.sendMessage("§6§lJobs §8| §7You left the '§d§lFisher§7' Job.");
						}
						
						p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
						JobManager.leaveJob(p);
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§cNo, I don't want to quit my Job.")){
						
						p.openInventory(JobSelector.getJobSelector(p));
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lMiner")){
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_1));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_2));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_3));
					}
					
					if(c.getType() == Material.DIAMOND_PICKAXE && c.getItemMeta().getDisplayName().equals("§9§lMiner Job §8| §f§lJoin the Miner Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, Job.MINER);
							p.openInventory(MinerInv.getMinerInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the '§9§lMiner§7' Job.");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minute before joining a job.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minutes before joining a job.");
							}
						}
							
						
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.LEAVE_JOB));
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8Coal")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCoal");
									SellInv.getSellInv(p, inv, JobMaterial.COAL);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCoal");
								SellInv.getSellInv(p, inv, JobMaterial.COAL);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7Iron Ingot")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lIron Ingot");
									SellInv.getSellInv(p, inv, JobMaterial.IRON_INGOT);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lIron Ingot");
								SellInv.getSellInv(p, inv, JobMaterial.IRON_INGOT);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7Cobblestone")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCobblestone");
									SellInv.getSellInv(p, inv, JobMaterial.COBBLESTONE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCobblestone");
								SellInv.getSellInv(p, inv, JobMaterial.COBBLESTONE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1Lapis Lazuli")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lLapis Lazuli");
									SellInv.getSellInv(p, inv, JobMaterial.LAPIS_LAZULI);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lLapis Lazuli");
								SellInv.getSellInv(p, inv, JobMaterial.LAPIS_LAZULI);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§aEmerald")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lEmerald");
									SellInv.getSellInv(p, inv, JobMaterial.EMERALD);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lEmerald");
								SellInv.getSellInv(p, inv, JobMaterial.EMERALD);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§bDiamond")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDiamond");
									SellInv.getSellInv(p, inv, JobMaterial.DIAMOND);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDiamond");
								SellInv.getSellInv(p, inv, JobMaterial.DIAMOND);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6Gold Ingot")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGold Ingot");
									SellInv.getSellInv(p, inv, JobMaterial.GOLD_INGOT);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGold Ingot");
								SellInv.getSellInv(p, inv, JobMaterial.GOLD_INGOT);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Redstone")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.MINER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRedstone");
									SellInv.getSellInv(p, inv, JobMaterial.REDSTONE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRedstone");
								SellInv.getSellInv(p, inv, JobMaterial.REDSTONE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §9§lMiner§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lFarmer")){
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_1));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_2));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_3));
					}
					
					if(c.getType() == Material.IRON_HOE && c.getItemMeta().getDisplayName().equals("§7§lFarmer Job §8| §f§lJoin the Farmer Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, Job.FARMER);
							p.openInventory(FarmerInv.getFarmerInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the '§7§lFarmer§7' Job.");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minute before joining a job.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minutes before joining a job.");
							}
						}
							
						
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.LEAVE_JOB));
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2Wheat")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lWheat");
									SellInv.getSellInv(p, inv, JobMaterial.WHEAT);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lWheat");
								SellInv.getSellInv(p, inv, JobMaterial.WHEAT);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §7§lFarmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§cMelon")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMelon");
									SellInv.getSellInv(p, inv, JobMaterial.MELON);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMelon");
								SellInv.getSellInv(p, inv, JobMaterial.MELON);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §7§lFarmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4Apple")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lApple");
									SellInv.getSellInv(p, inv, JobMaterial.APPLE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lApple");
								SellInv.getSellInv(p, inv, JobMaterial.APPLE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §7§lFarmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6Carrot")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCarrot");
									SellInv.getSellInv(p, inv, JobMaterial.CARROT_ITEM);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCarrot");
								SellInv.getSellInv(p, inv, JobMaterial.CARROT_ITEM);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §7§lFarmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§aSugarcane")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSugarcane");
									SellInv.getSellInv(p, inv, JobMaterial.SUGAR_CANE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSugarcane");
								SellInv.getSellInv(p, inv, JobMaterial.SUGAR_CANE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §7§lFarmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§ePotato")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lPotato");
									SellInv.getSellInv(p, inv, JobMaterial.POTATO_ITEM);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lPotato");
								SellInv.getSellInv(p, inv, JobMaterial.POTATO_ITEM);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §7§lFarmer§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lLumberjack")){
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_1));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_2));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_3));
					}
					
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getDisplayName().equals("§6§lLumberjack Job §8| §f§lJoin the Lumberjack Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, Job.LUMBERJACK);
							p.openInventory(LumberjackInv.getLumberjackInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the '§6§lLumberjack§7' Job.");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minute before joining a job.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minutes before joining a job.");
							}
						}
							
						
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.LEAVE_JOB));
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§cAcacia Wood")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.LUMBERJACK){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lAcacia Wood");
									SellInv.getSellInv(p, inv, JobMaterial.ACACIA_LOG);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lAcacia Wood");
								SellInv.getSellInv(p, inv, JobMaterial.ACACIA_LOG);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §6§lLumberjack§7 to sell this!");
						}
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§fBirch Wood")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.LUMBERJACK){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lBirch Wood");
									SellInv.getSellInv(p, inv, JobMaterial.BIRCH_LOG);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lBirch Wood");
								SellInv.getSellInv(p, inv, JobMaterial.BIRCH_LOG);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §6§lLumberjack§7 to sell this!");
						}
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6Oak Wood")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.LUMBERJACK){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lOak Wood");
									SellInv.getSellInv(p, inv, JobMaterial.OAK_LOG);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lOak Wood");
								SellInv.getSellInv(p, inv, JobMaterial.OAK_LOG);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §6§lLumberjack§7 to sell this!");
						}
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§eJungle Wood")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.LUMBERJACK){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lJungle Wood");
									SellInv.getSellInv(p, inv, JobMaterial.JUNGLE_LOG);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lJungle Wood");
								SellInv.getSellInv(p, inv, JobMaterial.JUNGLE_LOG);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §6§lLumberjack§7 to sell this!");
						}
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8Spruce Wood")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.LUMBERJACK){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSpruce Wood");
									SellInv.getSellInv(p, inv, JobMaterial.SPRUCE_LOG);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSpruce Wood");
								SellInv.getSellInv(p, inv, JobMaterial.SPRUCE_LOG);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §6§lLumberjack§7 to sell this!");
						}
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8Dark Oak Wood")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.LUMBERJACK){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDark Oak Wood");
									SellInv.getSellInv(p, inv, JobMaterial.DARK_OAK_LOG);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDark Oak Wood");
								SellInv.getSellInv(p, inv, JobMaterial.DARK_OAK_LOG);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §6§lLumberjack§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lHunter")){
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_1));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_2));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_3));
					}
					
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getDisplayName().equals("§b§lHunter Job §8| §f§lJoin the Hunter Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, Job.HUNTER);
							p.openInventory(HunterInv.getHunterInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the '§b§lHunter§7' Job.");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minute before joining a job.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minutes before joining a job.");
							}
						}
							
						
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.LEAVE_JOB));
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5Spider Eye")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSpider Eye");
									SellInv.getSellInv(p, inv, JobMaterial.SPIDER_EYE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSpider Eye");
								SellInv.getSellInv(p, inv, JobMaterial.SPIDER_EYE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6Blaze Rod")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lBlaze Rod");
									SellInv.getSellInv(p, inv, JobMaterial.BLAZE_ROD);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lBlaze Rod");
								SellInv.getSellInv(p, inv, JobMaterial.BLAZE_ROD);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§cRotten Flesh")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRotten Flesh");
									SellInv.getSellInv(p, inv, JobMaterial.ROTTEN_FLESH);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRotten Flesh");
								SellInv.getSellInv(p, inv, JobMaterial.ROTTEN_FLESH);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8Wither Skeleton Skull")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lWither Skull");
									SellInv.getSellInv(p, inv, JobMaterial.WITHER_SKELETON_SKULL);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lWither Skull");
								SellInv.getSellInv(p, inv, JobMaterial.WITHER_SKELETON_SKULL);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§fBone")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lBone");
									SellInv.getSellInv(p, inv, JobMaterial.BONE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lBone");
								SellInv.getSellInv(p, inv, JobMaterial.BONE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3Ender Pearl")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lEnder Pearl");
									SellInv.getSellInv(p, inv, JobMaterial.ENDER_PEARL);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lEnder Pearl");
								SellInv.getSellInv(p, inv, JobMaterial.ENDER_PEARL);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§fGhast Tear")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGhast Tear");
									SellInv.getSellInv(p, inv, JobMaterial.GHAST_TEAR);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGhast Tear");
								SellInv.getSellInv(p, inv, JobMaterial.GHAST_TEAR);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7Gunpowder")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGunpowder");
									SellInv.getSellInv(p, inv, JobMaterial.GUNPOWDER);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGunpowder");
								SellInv.getSellInv(p, inv, JobMaterial.GUNPOWDER);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§cMagma Cream")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMagma Cream");
									SellInv.getSellInv(p, inv, JobMaterial.MAGMA_CREAM);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMagma Cream");
								SellInv.getSellInv(p, inv, JobMaterial.MAGMA_CREAM);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§aSlimeball")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.HUNTER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSlimeball");
									SellInv.getSellInv(p, inv, JobMaterial.SLIME_BALL);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lSlimeball");
								SellInv.getSellInv(p, inv, JobMaterial.SLIME_BALL);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §b§lHunter§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lAnimal Farmer")){
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_1));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_2));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_3));
					}
					
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§a§lAnimal Farmer Job §8| §f§lJoin the Animal Farmer Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, Job.ANIMAL_FARMER);
							p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the '§a§lAnimal Farmer§7' Job.");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minute before joining a job.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minutes before joining a job.");
							}
						}
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.LEAVE_JOB));
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§fFeather")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lFeather");
									SellInv.getSellInv(p, inv, JobMaterial.FEATHER);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lFeather");
								SellInv.getSellInv(p, inv, JobMaterial.FEATHER);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§dRaw Chicken")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Chicken");
									SellInv.getSellInv(p, inv, JobMaterial.RAW_CHICKEN);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Chicken");
								SellInv.getSellInv(p, inv, JobMaterial.RAW_CHICKEN);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§eRabbit Hide")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRabbit Hide");
									SellInv.getSellInv(p, inv, JobMaterial.RABBIT_HIDE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRabbit Hide");
								SellInv.getSellInv(p, inv, JobMaterial.RABBIT_HIDE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§dRaw Rabbit")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Rabbit");
									SellInv.getSellInv(p, inv, JobMaterial.RAW_RABBIT);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Rabbit");
								SellInv.getSellInv(p, inv, JobMaterial.RAW_RABBIT);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§cRaw Beef")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Beef");
									SellInv.getSellInv(p, inv, JobMaterial.RAW_BEEF);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Beef");
								SellInv.getSellInv(p, inv, JobMaterial.RAW_BEEF);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6Leather")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lLeather");
									SellInv.getSellInv(p, inv, JobMaterial.LEATHER);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lLeather");
								SellInv.getSellInv(p, inv, JobMaterial.LEATHER);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§dRaw Porkchop")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Porkchop");
									SellInv.getSellInv(p, inv, JobMaterial.RAW_PORK);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Porkchop");
								SellInv.getSellInv(p, inv, JobMaterial.RAW_PORK);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§cRaw Mutton")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.ANIMAL_FARMER){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Mutton");
									SellInv.getSellInv(p, inv, JobMaterial.RAW_MUTTON);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRaw Mutton");
								SellInv.getSellInv(p, inv, JobMaterial.RAW_MUTTON);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be an §a§lAnimal Farmer§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lNether Expert")){
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_1));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_2));
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.REMOVE_DEAL_3));
					}
					
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§c§lNether Expert Job §8| §f§lJoin the Nether Expert Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, Job.NETHER_EXPERT);
							p.openInventory(NetherExpertInv.getNetherExpertInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the '§c§lNether Expert§7' Job.");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minute before joining a job.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You have to wait §6" + timeLeft + "§7 minutes before joining a job.");
							}
						}
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.LAVA_BUCKET && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						p.openInventory(ConfirmInv.getConfirmInv(p, ConfirmReason.LEAVE_JOB));
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§cNether Wart")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.NETHER_EXPERT){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Wart");
									SellInv.getSellInv(p, inv, JobMaterial.NETHER_WART);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Wart");
								SellInv.getSellInv(p, inv, JobMaterial.NETHER_WART);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §c§lNether Expert§7 to sell this!");
						}
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§cQuartz Ore")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.NETHER_EXPERT){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lQuartz Ore");
									SellInv.getSellInv(p, inv, JobMaterial.QUARTZ_ORE);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lQuartz Ore");
								SellInv.getSellInv(p, inv, JobMaterial.QUARTZ_ORE);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §c§lNether Expert§7 to sell this!");
						}
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4Nether Brick")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.NETHER_EXPERT){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Brick");
									SellInv.getSellInv(p, inv, JobMaterial.NETHER_BRICK);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Brick");
								SellInv.getSellInv(p, inv, JobMaterial.NETHER_BRICK);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §c§lNether Expert§7 to sell this!");
						}
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§cNetherrack")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.NETHER_EXPERT){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNetherrack");
									SellInv.getSellInv(p, inv, JobMaterial.NETHERRACK);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNetherrack");
								SellInv.getSellInv(p, inv, JobMaterial.NETHERRACK);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §c§lNether Expert§7 to sell this!");
						}
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§fQuartz")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.NETHER_EXPERT){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lQuartz");
									SellInv.getSellInv(p, inv, JobMaterial.QUARTZ);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lQuartz");
								SellInv.getSellInv(p, inv, JobMaterial.QUARTZ);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §c§lNether Expert§7 to sell this!");
						}
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4Nether Brick")){
						
						if(JobManager.job.containsKey(p) && JobManager.job.get(p) == Job.NETHER_EXPERT){
							if(MerchantManager.merchantdealsid.containsKey(p.getName())){
								if(MerchantManager.merchantdealsid.get(p.getName()).size() != 3){
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Brick§7");
									SellInv.getSellInv(p, inv, JobMaterial.NETHER_BRICKS);
								}
								else{
									p.sendMessage("§6§lJobs §8| §7You already reached the maximum amount of deals!");
								}
							}
							else{
								final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Brick§7");
								SellInv.getSellInv(p, inv, JobMaterial.NETHER_BRICKS);
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You have to be a §c§lNether Expert§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lCoal")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+1 Coal")){
						addItemAmount(p, 1, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+2 Coal")){
						addItemAmount(p, 2, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+3 Coal")){
						addItemAmount(p, 3, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+4 Coal")){
						addItemAmount(p, 4, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+5 Coal")){
						addItemAmount(p, 5, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+6 Coal")){
						addItemAmount(p, 6, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§l+64 Coal")){
						addItemAmount(p, 64, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.COAL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.COAL, 0);
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8§lCoal") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§8§lCoal");
					}
				}
				if(e.getInventory().getName().equals("§0§lIron Ingot")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+1 Iron Ingot")){
						addItemAmount(p, 1, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+2 Iron Ingot")){
						addItemAmount(p, 2, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+3 Iron Ingot")){
						addItemAmount(p, 3, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+4 Iron Ingot")){
						addItemAmount(p, 4, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+5 Iron Ingot")){
						addItemAmount(p, 5, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+6 Iron Ingot")){
						addItemAmount(p, 6, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§l+64 Iron Ingot")){
						addItemAmount(p, 64, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.IRON_INGOT, 0);
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§lIron Ingot") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§7§lIron Ingot");
					}
				}
				if(e.getInventory().getName().equals("§0§lCobblestone")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+1 Cobblestone")){
						addItemAmount(p, 1, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+2 Cobblestone")){
						addItemAmount(p, 2, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+3 Cobblestone")){
						addItemAmount(p, 3, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+4 Cobblestone")){
						addItemAmount(p, 4, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+5 Cobblestone")){
						addItemAmount(p, 5, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+6 Cobblestone")){
						addItemAmount(p, 6, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§l+64 Cobblestone")){
						addItemAmount(p, 64, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.COBBLESTONE, 0);
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7§lCobblestone") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§7§lCobblestone");
					}
				}
				if(e.getInventory().getName().equals("§0§lLapis Lazuli")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+1 Lapis Lazuli")){
						addItemAmount(p, 1, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+2 Lapis Lazuli")){
						addItemAmount(p, 2, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+3 Lapis Lazuli")){
						addItemAmount(p, 3, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+4 Lapis Lazuli")){
						addItemAmount(p, 4, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+5 Lapis Lazuli")){
						addItemAmount(p, 5, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+6 Lapis Lazuli")){
						addItemAmount(p, 6, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§l+64 Lapis Lazuli")){
						addItemAmount(p, 64, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.INK_SACK, 4);
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1§lLapis Lazuli") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§1§lLapis Lazuli");
					}
				}
				if(e.getInventory().getName().equals("§0§lEmerald")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+1 Emerald")){
						addItemAmount(p, 1, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+2 Emerald")){
						addItemAmount(p, 2, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+3 Emerald")){
						addItemAmount(p, 3, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+4 Emerald")){
						addItemAmount(p, 4, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+5 Emerald")){
						addItemAmount(p, 5, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+6 Emerald")){
						addItemAmount(p, 6, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§l+64 Emerald")){
						addItemAmount(p, 64, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.EMERALD, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.EMERALD, 0);
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§lEmerald") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§a§lEmerald");
					}
				}
				if(e.getInventory().getName().equals("§0§lDiamond")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+1 Diamond")){
						addItemAmount(p, 1, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+2 Diamond")){
						addItemAmount(p, 2, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+3 Diamond")){
						addItemAmount(p, 3, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+4 Diamond")){
						addItemAmount(p, 4, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+5 Diamond")){
						addItemAmount(p, 5, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+6 Diamond")){
						addItemAmount(p, 6, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§l+64 Diamond")){
						addItemAmount(p, 64, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.DIAMOND, 0);
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§lDiamond") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§b§lDiamond");
					}
				}
				if(e.getInventory().getName().equals("§0§lGold Ingot")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+1 Gold Ingot")){
						addItemAmount(p, 1, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+2 Gold Ingot")){
						addItemAmount(p, 2, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+3 Gold Ingot")){
						addItemAmount(p, 3, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+4 Gold Ingot")){
						addItemAmount(p, 4, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+5 Gold Ingot")){
						addItemAmount(p, 5, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+6 Gold Ingot")){
						addItemAmount(p, 6, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§l+64 Gold Ingot")){
						addItemAmount(p, 64, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.GOLD_INGOT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§lGold Ingot") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§6§lGold Ingot");
					}
				}
				if(e.getInventory().getName().equals("§0§lRedstone")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(MinerInv.getMinerInv(p));
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+1 Redstone")){
						addItemAmount(p, 1, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+2 Redstone")){
						addItemAmount(p, 2, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+3 Redstone")){
						addItemAmount(p, 3, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+4 Redstone")){
						addItemAmount(p, 4, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+5 Redstone")){
						addItemAmount(p, 5, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+6 Redstone")){
						addItemAmount(p, 6, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§l+64 Redstone")){
						addItemAmount(p, 64, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.REDSTONE, 0);
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4§lRedstone") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§4§lRedstone");
					}
				}
				if(e.getInventory().getName().equals("§0§lWheat")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+1 Wheat")){
						addItemAmount(p, 1, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+2 Wheat")){
						addItemAmount(p, 2, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+3 Wheat")){
						addItemAmount(p, 3, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+4 Wheat")){
						addItemAmount(p, 4, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+5 Wheat")){
						addItemAmount(p, 5, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+6 Wheat")){
						addItemAmount(p, 6, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§l+64 Wheat")){
						addItemAmount(p, 64, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.WHEAT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.WHEAT, 0);
					}
					if(c.getType() == Material.WHEAT && c.getItemMeta().getDisplayName().equals("§2§lWheat") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§2§lWheat");
					}
				}
				if(e.getInventory().getName().equals("§0§lMelon")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+1 Melon")){
						addItemAmount(p, 1, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+2 Melon")){
						addItemAmount(p, 2, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+3 Melon")){
						addItemAmount(p, 3, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+4 Melon")){
						addItemAmount(p, 4, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+5 Melon")){
						addItemAmount(p, 5, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+6 Melon")){
						addItemAmount(p, 6, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§l+64 Melon")){
						addItemAmount(p, 64, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.MELON, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.MELON, 0);
					}
					if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().equals("§c§lMelon") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lMelon");
					}
				}
				if(e.getInventory().getName().equals("§0§lApple")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+1 Apple")){
						addItemAmount(p, 1, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+2 Apple")){
						addItemAmount(p, 2, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+3 Apple")){
						addItemAmount(p, 3, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+4 Apple")){
						addItemAmount(p, 4, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+5 Apple")){
						addItemAmount(p, 5, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+6 Apple")){
						addItemAmount(p, 6, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§l+64 Apple")){
						addItemAmount(p, 64, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.APPLE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.APPLE, 0);
					}
					if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().equals("§4§lApple") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§4§lApple");
					}
				}
				if(e.getInventory().getName().equals("§0§lCarrot")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+1 Carrot")){
						addItemAmount(p, 1, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+2 Carrot")){
						addItemAmount(p, 2, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+3 Carrot")){
						addItemAmount(p, 3, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+4 Carrot")){
						addItemAmount(p, 4, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+5 Carrot")){
						addItemAmount(p, 5, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+6 Carrot")){
						addItemAmount(p, 6, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§l+64 Carrot")){
						addItemAmount(p, 64, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.CARROT_ITEM, 0);
					}
					if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().equals("§6§lCarrot") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§6§lCarrot");
					}
				}
				if(e.getInventory().getName().equals("§0§lSugarcane")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+1 Sugarcane")){
						addItemAmount(p, 1, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+2 Sugarcane")){
						addItemAmount(p, 2, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+3 Sugarcane")){
						addItemAmount(p, 3, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+4 Sugarcane")){
						addItemAmount(p, 4, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+5 Sugarcane")){
						addItemAmount(p, 5, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+6 Sugarcane")){
						addItemAmount(p, 6, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§l+64 Sugarcane")){
						addItemAmount(p, 64, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.SUGAR_CANE, 0);
					}
					if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().equals("§a§lSugarcane") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§a§lSugarcane");
					}
				}
				if(e.getInventory().getName().equals("§0§lPotato")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(FarmerInv.getFarmerInv(p));
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+1 Potato")){
						addItemAmount(p, 1, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+2 Potato")){
						addItemAmount(p, 2, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+3 Potato")){
						addItemAmount(p, 3, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+4 Potato")){
						addItemAmount(p, 4, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+5 Potato")){
						addItemAmount(p, 5, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+6 Potato")){
						addItemAmount(p, 6, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§l+64 Potato")){
						addItemAmount(p, 64, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.POTATO_ITEM, 0);
					}
					if(c.getType() == Material.POTATO_ITEM && c.getItemMeta().getDisplayName().equals("§e§lPotato") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§e§lPotato");
					}
				}
				if(e.getInventory().getName().equals("§0§lOak Wood")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+1 Oak Wood")){
						addItemAmount(p, 1, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+2 Oak Wood")){
						addItemAmount(p, 2, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+3 Oak Wood")){
						addItemAmount(p, 3, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+4 Oak Wood")){
						addItemAmount(p, 4, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+5 Oak Wood")){
						addItemAmount(p, 5, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+6 Oak Wood")){
						addItemAmount(p, 6, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§l+64 Oak Wood")){
						addItemAmount(p, 64, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LOG, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LOG, 0);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§6§lOak Wood") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§6§lOak Wood");
					}
				}
				if(e.getInventory().getName().equals("§0§lSpruce Wood")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+1 Spruce Wood")){
						addItemAmount(p, 1, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+2 Spruce Wood")){
						addItemAmount(p, 2, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+3 Spruce Wood")){
						addItemAmount(p, 3, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+4 Spruce Wood")){
						addItemAmount(p, 4, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+5 Spruce Wood")){
						addItemAmount(p, 5, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+6 Spruce Wood")){
						addItemAmount(p, 6, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§l+64 Spruce Wood")){
						addItemAmount(p, 64, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LOG, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LOG, 1);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§8§lSpruce Wood") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§8§lSpruce Wood");
					}
				}
				if(e.getInventory().getName().equals("§0§lBirch Wood")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+1 Birch Wood")){
						addItemAmount(p, 1, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+2 Birch Wood")){
						addItemAmount(p, 2, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+3 Birch Wood")){
						addItemAmount(p, 3, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+4 Birch Wood")){
						addItemAmount(p, 4, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+5 Birch Wood")){
						addItemAmount(p, 5, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+6 Birch Wood")){
						addItemAmount(p, 6, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§l+64 Birch Wood")){
						addItemAmount(p, 64, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LOG, 2);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LOG, 2);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§f§lBirch Wood") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§f§lBirch Wood");
					}
				}
				if(e.getInventory().getName().equals("§0§lJungle Wood")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+1 Jungle Wood")){
						addItemAmount(p, 1, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+2 Jungle Wood")){
						addItemAmount(p, 2, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+3 Jungle Wood")){
						addItemAmount(p, 3, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+4 Jungle Wood")){
						addItemAmount(p, 4, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+5 Jungle Wood")){
						addItemAmount(p, 5, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+6 Jungle Wood")){
						addItemAmount(p, 6, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§l+64 Jungle Wood")){
						addItemAmount(p, 64, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LOG, 3);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LOG, 3);
					}
					if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().equals("§e§lJungle Wood") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§e§lJungle Wood");
					}
				}
				if(e.getInventory().getName().equals("§0§lAcacia Wood")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+1 Acacia Wood")){
						addItemAmount(p, 1, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+2 Acacia Wood")){
						addItemAmount(p, 2, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+3 Acacia Wood")){
						addItemAmount(p, 3, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+4 Acacia Wood")){
						addItemAmount(p, 4, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+5 Acacia Wood")){
						addItemAmount(p, 5, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+6 Acacia Wood")){
						addItemAmount(p, 6, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§l+64 Acacia Wood")){
						addItemAmount(p, 64, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LOG_2, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LOG_2, 0);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§c§lAcacia Wood") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lAcacia Wood");
					}
				}
				if(e.getInventory().getName().equals("§0§lDark Oak Wood")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(LumberjackInv.getLumberjackInv(p));
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+1 Dark Oak Wood")){
						addItemAmount(p, 1, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+2 Dark Oak Wood")){
						addItemAmount(p, 2, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+3 Dark Oak Wood")){
						addItemAmount(p, 3, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+4 Dark Oak Wood")){
						addItemAmount(p, 4, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+5 Dark Oak Wood")){
						addItemAmount(p, 5, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+6 Dark Oak Wood")){
						addItemAmount(p, 6, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§l+64 Dark Oak Wood")){
						addItemAmount(p, 64, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LOG_2, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LOG_2, 1);
					}
					if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().equals("§8§lDark Oak Wood") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§8§lDark Oak Wood");
					}
				}
				if(e.getInventory().getName().equals("§0§lSpider Eye")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+1 Spider Eye")){
						addItemAmount(p, 1, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+2 Spider Eye")){
						addItemAmount(p, 2, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+3 Spider Eye")){
						addItemAmount(p, 3, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+4 Spider Eye")){
						addItemAmount(p, 4, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+5 Spider Eye")){
						addItemAmount(p, 5, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+6 Spider Eye")){
						addItemAmount(p, 6, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§l+64 Spider Eye")){
						addItemAmount(p, 64, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.SPIDER_EYE, 0);
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§lSpider Eye") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§5§lSpider Eye");
					}
				}
				if(e.getInventory().getName().equals("§0§lBlaze Rod")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+1 Blaze Rod")){
						addItemAmount(p, 1, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+2 Blaze Rod")){
						addItemAmount(p, 2, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+3 Blaze Rod")){
						addItemAmount(p, 3, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+4 Blaze Rod")){
						addItemAmount(p, 4, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+5 Blaze Rod")){
						addItemAmount(p, 5, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+6 Blaze Rod")){
						addItemAmount(p, 6, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§l+64 Blaze Rod")){
						addItemAmount(p, 64, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.BLAZE_ROD, 0);
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getDisplayName().equals("§6§lBlaze Rod") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§6§lBlaze Rod");
					}
				}
				if(e.getInventory().getName().equals("§0§lRotten Flesh")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+1 Rotten Flesh")){
						addItemAmount(p, 1, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+2 Rotten Flesh")){
						addItemAmount(p, 2, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+3 Rotten Flesh")){
						addItemAmount(p, 3, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+4 Rotten Flesh")){
						addItemAmount(p, 4, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+5 Rotten Flesh")){
						addItemAmount(p, 5, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+6 Rotten Flesh")){
						addItemAmount(p, 6, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§l+64 Rotten Flesh")){
						addItemAmount(p, 64, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.ROTTEN_FLESH, 0);
					}
					if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().equals("§c§lRotten Flesh") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lRotten Flesh");
					}
				}
				if(e.getInventory().getName().equals("§0§lWither Skull")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+1 Wither Skeleton Skull")){
						addItemAmount(p, 1, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+2 Wither Skeleton Skull")){
						addItemAmount(p, 2, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+3 Wither Skeleton Skull")){
						addItemAmount(p, 3, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+4 Wither Skeleton Skull")){
						addItemAmount(p, 4, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+5 Wither Skeleton Skull")){
						addItemAmount(p, 5, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+6 Wither Skeleton Skull")){
						addItemAmount(p, 6, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§l+64 Wither Skeleton Skull")){
						addItemAmount(p, 64, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.SKULL_ITEM, 1);
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§8§lWither Skeleton Skull") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§8§lWither Skeleton Skull");
					}
				}
				if(e.getInventory().getName().equals("§0§lBone")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+1 Bone")){
						addItemAmount(p, 1, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+2 Bone")){
						addItemAmount(p, 2, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+3 Bone")){
						addItemAmount(p, 3, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+4 Bone")){
						addItemAmount(p, 4, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+5 Bone")){
						addItemAmount(p, 5, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+6 Bone")){
						addItemAmount(p, 6, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§l+64 Bone")){
						addItemAmount(p, 64, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.BONE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.BONE, 0);
					}
					if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§f§lBone") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§f§lBone");
					}
				}
				if(e.getInventory().getName().equals("§0§lEnder Pearl")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+1 Ender Pearl")){
						addItemAmount(p, 1, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+2 Ender Pearl")){
						addItemAmount(p, 2, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+3 Ender Pearl")){
						addItemAmount(p, 3, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+4 Ender Pearl")){
						addItemAmount(p, 4, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+5 Ender Pearl")){
						addItemAmount(p, 5, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+6 Ender Pearl")){
						addItemAmount(p, 6, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§l+64 Ender Pearl")){
						addItemAmount(p, 64, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.ENDER_PEARL, 0);
					}
					if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§lEnder Pearl") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§3§lEnder Pearl");
					}
				}
				if(e.getInventory().getName().equals("§0§lGhast Tear")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+1 Ghast Tear")){
						addItemAmount(p, 1, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+2 Ghast Tear")){
						addItemAmount(p, 2, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+3 Ghast Tear")){
						addItemAmount(p, 3, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+4 Ghast Tear")){
						addItemAmount(p, 4, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+5 Ghast Tear")){
						addItemAmount(p, 5, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+6 Ghast Tear")){
						addItemAmount(p, 6, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§l+64 Ghast Tear")){
						addItemAmount(p, 64, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.GHAST_TEAR, 0);
					}
					if(c.getType() == Material.GHAST_TEAR && c.getItemMeta().getDisplayName().equals("§f§lGhast Tear") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§f§lGhast Tear");
					}
				}
				if(e.getInventory().getName().equals("§0§lGunpowder")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+1 Gunpowder")){
						addItemAmount(p, 1, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+2 Gunpowder")){
						addItemAmount(p, 2, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+3 Gunpowder")){
						addItemAmount(p, 3, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+4 Gunpowder")){
						addItemAmount(p, 4, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+5 Gunpowder")){
						addItemAmount(p, 5, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+6 Gunpowder")){
						addItemAmount(p, 6, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§l+64 Gunpowder")){
						addItemAmount(p, 64, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.SULPHUR, 0);
					}
					if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().equals("§7§lGunpowder") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§7§lGunpowder");
					}
				}
				if(e.getInventory().getName().equals("§0§lMagma Cream")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+1 Magma Cream")){
						addItemAmount(p, 1, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+2 Magma Cream")){
						addItemAmount(p, 2, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+3 Magma Cream")){
						addItemAmount(p, 3, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+4 Magma Cream")){
						addItemAmount(p, 4, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+5 Magma Cream")){
						addItemAmount(p, 5, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+6 Magma Cream")){
						addItemAmount(p, 6, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§l+64 Magma Cream")){
						addItemAmount(p, 64, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.MAGMA_CREAM, 0);
					}
					if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§lMagma Cream") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lMagma Cream");
					}
				}
				if(e.getInventory().getName().equals("§0§lSlimeball")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(HunterInv.getHunterInv(p));
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+1 Slimeball")){
						addItemAmount(p, 1, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+2 Slimeball")){
						addItemAmount(p, 2, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+3 Slimeball")){
						addItemAmount(p, 3, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+4 Slimeball")){
						addItemAmount(p, 4, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+5 Slimeball")){
						addItemAmount(p, 5, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+6 Slimeball")){
						addItemAmount(p, 6, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§l+64 Slimeball")){
						addItemAmount(p, 64, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.SLIME_BALL, 0);
					}
					if(c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§lSlimeball") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§a§lSlimeball");
					}
				}
				if(e.getInventory().getName().equals("§0§lFeather")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+1 Feather")){
						addItemAmount(p, 1, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+2 Feather")){
						addItemAmount(p, 2, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+3 Feather")){
						addItemAmount(p, 3, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+4 Feather")){
						addItemAmount(p, 4, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+5 Feather")){
						addItemAmount(p, 5, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+6 Feather")){
						addItemAmount(p, 6, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§l+64 Feather")){
						addItemAmount(p, 64, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.FEATHER, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.FEATHER, 0);
					}
					if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§lFeather") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§f§lFeather");
					}
				}
				if(e.getInventory().getName().equals("§0§lRaw Chicken")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+1 Raw Chicken")){
						addItemAmount(p, 1, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+2 Raw Chicken")){
						addItemAmount(p, 2, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+3 Raw Chicken")){
						addItemAmount(p, 3, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+4 Raw Chicken")){
						addItemAmount(p, 4, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+5 Raw Chicken")){
						addItemAmount(p, 5, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+6 Raw Chicken")){
						addItemAmount(p, 6, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§l+64 Raw Chicken")){
						addItemAmount(p, 64, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.RAW_CHICKEN, 0);
					}
					if(c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().equals("§d§lRaw Chicken") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§d§lRaw Chicken");
					}
				}
				if(e.getInventory().getName().equals("§0§lRabbit Hide")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+1 Rabbit Hide")){
						addItemAmount(p, 1, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+2 Rabbit Hide")){
						addItemAmount(p, 2, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+3 Rabbit Hide")){
						addItemAmount(p, 3, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+4 Rabbit Hide")){
						addItemAmount(p, 4, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+5 Rabbit Hide")){
						addItemAmount(p, 5, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+6 Rabbit Hide")){
						addItemAmount(p, 6, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§l+64 Rabbit Hide")){
						addItemAmount(p, 64, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.RABBIT_HIDE, 0);
					}
					if(c.getType() == Material.RABBIT_HIDE && c.getItemMeta().getDisplayName().equals("§e§lRabbit Hide") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§e§lRabbit Hide");
					}
				}
				if(e.getInventory().getName().equals("§0§lRaw Rabbit")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+1 Raw Rabbit")){
						addItemAmount(p, 1, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+2 Raw Rabbit")){
						addItemAmount(p, 2, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+3 Raw Rabbit")){
						addItemAmount(p, 3, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+4 Raw Rabbit")){
						addItemAmount(p, 4, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+5 Raw Rabbit")){
						addItemAmount(p, 5, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+6 Raw Rabbit")){
						addItemAmount(p, 6, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§l+64 Raw Rabbit")){
						addItemAmount(p, 64, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.RABBIT, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.RABBIT, 0);
					}
					if(c.getType() == Material.RABBIT && c.getItemMeta().getDisplayName().equals("§d§lRaw Rabbit") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§d§lRaw Rabbit");
					}
				}
				if(e.getInventory().getName().equals("§0§lRaw Beef")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+1 Raw Beef")){
						addItemAmount(p, 1, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+2 Raw Beef")){
						addItemAmount(p, 2, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+3 Raw Beef")){
						addItemAmount(p, 3, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+4 Raw Beef")){
						addItemAmount(p, 4, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+5 Raw Beef")){
						addItemAmount(p, 5, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+6 Raw Beef")){
						addItemAmount(p, 6, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§l+64 Raw Beef")){
						addItemAmount(p, 64, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.RAW_BEEF, 0);
					}
					if(c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§lRaw Beef") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lRaw Beef");
					}
				}
				if(e.getInventory().getName().equals("§0§lLeather")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+1 Leather")){
						addItemAmount(p, 1, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+2 Leather")){
						addItemAmount(p, 2, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+3 Leather")){
						addItemAmount(p, 3, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+4 Leather")){
						addItemAmount(p, 4, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+5 Leather")){
						addItemAmount(p, 5, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+6 Leather")){
						addItemAmount(p, 6, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§l+64 Leather")){
						addItemAmount(p, 64, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.LEATHER, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.LEATHER, 0);
					}
					if(c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§6§lLeather") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§6§lLeather");
					}
				}
				if(e.getInventory().getName().equals("§0§lRaw Porkchop")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+1 Raw Porkchop")){
						addItemAmount(p, 1, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+2 Raw Porkchop")){
						addItemAmount(p, 2, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+3 Raw Porkchop")){
						addItemAmount(p, 3, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+4 Raw Porkchop")){
						addItemAmount(p, 4, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+5 Raw Porkchop")){
						addItemAmount(p, 5, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+6 Raw Porkchop")){
						addItemAmount(p, 6, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§l+64 Raw Porkchop")){
						addItemAmount(p, 64, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.PORK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.PORK, 0);
					}
					if(c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§lRaw Porkchop") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§d§lRaw Porkchop");
					}
				}
				if(e.getInventory().getName().equals("§0§lRaw Mutton")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(AnimalFarmerInv.getAnimalFarmerInv(p));
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+1 Raw Mutton")){
						addItemAmount(p, 1, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+2 Raw Mutton")){
						addItemAmount(p, 2, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+3 Raw Mutton")){
						addItemAmount(p, 3, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+4 Raw Mutton")){
						addItemAmount(p, 4, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+5 Raw Mutton")){
						addItemAmount(p, 5, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+6 Raw Mutton")){
						addItemAmount(p, 6, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§l+64 Raw Mutton")){
						addItemAmount(p, 64, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.MUTTON, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.MUTTON, 0);
					}
					if(c.getType() == Material.MUTTON && c.getItemMeta().getDisplayName().equals("§c§lRaw Mutton") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lRaw Mutton");
					}
				}
				if(e.getInventory().getName().equals("§0§lNether Wart")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+1 Nether Wart")){
						addItemAmount(p, 1, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+2 Nether Wart")){
						addItemAmount(p, 2, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+3 Nether Wart")){
						addItemAmount(p, 3, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+4 Nether Wart")){
						addItemAmount(p, 4, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+5 Nether Wart")){
						addItemAmount(p, 5, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+6 Nether Wart")){
						addItemAmount(p, 6, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§l+64 Nether Wart")){
						addItemAmount(p, 64, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.NETHER_STALK, 0);
					}
					if(c.getType() == Material.NETHER_STALK && c.getItemMeta().getDisplayName().equals("§c§lNether Wart") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lNether Wart");
					}
				}
				if(e.getInventory().getName().equals("§0§lQuartz Ore")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+1 Quartz Ore")){
						addItemAmount(p, 1, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+2 Quartz Ore")){
						addItemAmount(p, 2, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+3 Quartz Ore")){
						addItemAmount(p, 3, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+4 Quartz Ore")){
						addItemAmount(p, 4, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+5 Quartz Ore")){
						addItemAmount(p, 5, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+6 Quartz Ore")){
						addItemAmount(p, 6, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§l+64 Quartz Ore")){
						addItemAmount(p, 64, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.QUARTZ_ORE, 0);
					}
					if(c.getType() == Material.QUARTZ_ORE && c.getItemMeta().getDisplayName().equals("§c§lQuartz Ore") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lQuartz Ore");
					}
				}
				if(e.getInventory().getName().equals("§0§lNether Brick")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+1 Nether Brick")){
						addItemAmount(p, 1, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+2 Nether Brick")){
						addItemAmount(p, 2, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+3 Nether Brick")){
						addItemAmount(p, 3, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+4 Nether Brick")){
						addItemAmount(p, 4, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+5 Nether Brick")){
						addItemAmount(p, 5, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+6 Nether Brick")){
						addItemAmount(p, 6, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§l+64 Nether Brick")){
						addItemAmount(p, 64, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.NETHER_BRICK_ITEM, 0);
					}
					if(c.getType() == Material.NETHER_BRICK_ITEM && c.getItemMeta().getDisplayName().equals("§4§lNether Brick") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§4§lNether Brick");
					}
				}
				if(e.getInventory().getName().equals("§0§lNetherrack")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+1 Netherrack")){
						addItemAmount(p, 1, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+2 Netherrack")){
						addItemAmount(p, 2, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+3 Netherrack")){
						addItemAmount(p, 3, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+4 Netherrack")){
						addItemAmount(p, 4, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+5 Netherrack")){
						addItemAmount(p, 5, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+6 Netherrack")){
						addItemAmount(p, 6, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§l+64 Netherrack")){
						addItemAmount(p, 64, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.NETHERRACK, 0);
					}
					if(c.getType() == Material.NETHERRACK && c.getItemMeta().getDisplayName().equals("§c§lNetherrack") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§c§lNetherrack");
					}
				}
				if(e.getInventory().getName().equals("§0§lQuartz")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+1 Quartz")){
						addItemAmount(p, 1, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+2 Quartz")){
						addItemAmount(p, 2, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+3 Quartz")){
						addItemAmount(p, 3, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+4 Quartz")){
						addItemAmount(p, 4, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+5 Quartz")){
						addItemAmount(p, 5, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+6 Quartz")){
						addItemAmount(p, 6, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§l+64 Quartz")){
						addItemAmount(p, 64, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.QUARTZ, 0);
					}
					if(c.getType() == Material.QUARTZ && c.getItemMeta().getDisplayName().equals("§f§lQuartz") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§f§lQuartz");
					}
				}
				if(e.getInventory().getName().equals("§0§lNether Brick§7")){
					
					e.setCancelled(true);
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(NetherExpertInv.getNetherExpertInv(p));
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+1 Nether Brick")){
						addItemAmount(p, 1, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+2 Nether Brick")){
						addItemAmount(p, 2, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+3 Nether Brick")){
						addItemAmount(p, 3, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+4 Nether Brick")){
						addItemAmount(p, 4, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+5 Nether Brick")){
						addItemAmount(p, 5, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+6 Nether Brick")){
						addItemAmount(p, 6, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§l+64 Nether Brick")){
						addItemAmount(p, 64, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
						addMoneyToItem(p, 1, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
						addMoneyToItem(p, 5, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
						addMoneyToItem(p, 10, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
						addMoneyToItem(p, 50, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
						addMoneyToItem(p, 100, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
						addMoneyToItem(p, 500, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
						addMoneyToItem(p, 1000, Material.NETHER_BRICK, 0);
					}
					if(c.getType() == Material.NETHER_BRICK && c.getItemMeta().getDisplayName().equals("§4§lNether Brick") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
						SellInv.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§4§lNether Brick");
					}
				}
				
				
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	private void addMoneyToItem(Player p, int priceadded, Material material, int durability){
		String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
		int price = Integer.parseInt(s.substring(12));
		
		Inventory inv = p.getOpenInventory().getTopInventory();
		
		SellInv.StatsItem(p, inv, inv.getItem(40).getAmount(), price +priceadded, material, durability);
		
		p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
	}
	
	private void addItemAmount(Player p, int added, Material material, int durability){
		String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
		int price = Integer.parseInt(s.substring(12));
		
		Inventory inv = p.getOpenInventory().getTopInventory();
		
		SellInv.StatsItem(p, inv, inv.getItem(40).getAmount() + added, price, material, durability);
		
		SellInv.SellItem1(p, inv, material, durability);
		SellInv.SellItem2(p, inv, material, durability);
		SellInv.SellItem3(p, inv, material, durability);
		SellInv.SellItem4(p, inv, material, durability);
		SellInv.SellItem5(p, inv, material, durability);
		SellInv.SellItem6(p, inv, material, durability);
		SellInv.SellItem64(p, inv, material, durability);
		
		SellInv.Money1(p, inv);
		SellInv.Money5(p, inv);
		SellInv.Money10(p, inv);
		SellInv.Money50(p, inv);
		SellInv.Money100(p, inv);
		SellInv.Money500(p, inv);
		SellInv.Money1000(p, inv);
	}
}
