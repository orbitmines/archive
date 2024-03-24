package me.O_o_Fadi_o_O.Survival.Managers;

import java.util.HashMap;

import me.O_o_Fadi_o_O.Survival.SettingsManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JobManager {

	public static HashMap<Player, String> JobName = new HashMap<Player, String>();
	public static HashMap<Player, Integer> JobLevel = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> JobEXP = new HashMap<Player, Integer>();
	public static HashMap<Player, Boolean> DaylyQuestUsed = new HashMap<Player, Boolean>();
	
	public static int MinerRequests = 0;
	public static int FarmerRequests = 0;
	public static int NetherExpertRequests = 0;
	public static int PotionMasterRequests = 0;
	public static int AnimalFarmerRequests = 0;
	public static int EnchanterRequests = 0;
	public static int HunterRequests = 0;
	public static int LumberjackRequests = 0;
	public static int FisherRequests = 0;
	
	public static void joinJob(Player p, String job){
		
		SettingsManager.jobs.set("players." + p.getName() + ".JobName", job);
		SettingsManager.jobs.set("players." + p.getName() + ".JobLevel", 0);
		SettingsManager.jobs.set("players." + p.getName() + ".JobEXP", 0);
		SettingsManager.jobs.set("players." + p.getName() + ".DaylyQuestUsed", false);
		SettingsManager.jobs.set("players." + p.getName() + ".DealsAmount", 0);
		SettingsManager.saveJobs();
		
		JobName.put(p, "Miner");
		JobLevel.put(p, 0);
		JobEXP.put(p, 0);
		DaylyQuestUsed.put(p, false);
		
	}
	
	public static void leaveJob(Player p, String job){
		SettingsManager.jobs.set("players." + p.getName() + ".JobName", null);
		SettingsManager.jobs.set("players." + p.getName() + ".JobLevel", null);
		SettingsManager.jobs.set("players." + p.getName() + ".JobEXP", null);
		SettingsManager.jobs.set("players." + p.getName() + ".DealsAmount", null);
		SettingsManager.saveJobs();
		
		JobName.remove(p);
		JobLevel.remove(p);
		JobEXP.remove(p);
		DaylyQuestUsed.remove(p);
	}
	
	public static void joinServer(Player p){
		
		if(SettingsManager.jobs.contains("players." + p.getName())){
			
			JobName.put(p, SettingsManager.jobs.getString("players." + p.getName() + ".JobName"));
			JobLevel.put(p, SettingsManager.jobs.getInt("players." + p.getName() + ".JobLevel"));
			JobEXP.put(p, SettingsManager.jobs.getInt("players." + p.getName() + ".JobEXP"));
			DaylyQuestUsed.put(p, SettingsManager.jobs.getBoolean("players." + p.getName() + ".DaylyQuestUsed"));
			MerchantManager.PlayerDealsAmount.put(p, SettingsManager.jobs.getInt("players." + p.getName() + ".DealsAmount"));
			
			if(SettingsManager.jobs.contains("players." + p.getName() + ".Deals")){
				for(String s : SettingsManager.jobs.getConfigurationSection("players." + p.getName() + ".Deals").getKeys(false)){
					
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Coal")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.CoalItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.COAL, ItemAmount);
							
							MerchantManager.CoalItemStack.put(DealID, item);
							MerchantManager.CoalPlayer.put(DealID, p);
							MerchantManager.CoalPrice.put(DealID, Price);
							MerchantManager.CoalDeals = MerchantManager.CoalDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Iron Ingot")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.IronIngotItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.IRON_INGOT, ItemAmount);
							
							MerchantManager.IronIngotItemStack.put(DealID, item);
							MerchantManager.IronIngotPlayer.put(DealID, p);
							MerchantManager.IronIngotPrice.put(DealID, Price);
							MerchantManager.IronIngotDeals = MerchantManager.IronIngotDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Cobblestone")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.CobblestoneItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.COBBLESTONE, ItemAmount);
							
							MerchantManager.CobblestoneItemStack.put(DealID, item);
							MerchantManager.CobblestonePlayer.put(DealID, p);
							MerchantManager.CobblestonePrice.put(DealID, Price);
							MerchantManager.CobblestoneDeals = MerchantManager.CobblestoneDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Lapis Lazuli")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.LapisLazuliItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.INK_SACK, ItemAmount);
							item.setDurability((short) 4);
							
							MerchantManager.LapisLazuliItemStack.put(DealID, item);
							MerchantManager.LapisLazuliPlayer.put(DealID, p);
							MerchantManager.LapisLazuliPrice.put(DealID, Price);
							MerchantManager.LapisLazuliDeals = MerchantManager.LapisLazuliDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Emerald")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.EmeraldItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.EMERALD, ItemAmount);
							
							MerchantManager.EmeraldItemStack.put(DealID, item);
							MerchantManager.EmeraldPlayer.put(DealID, p);
							MerchantManager.EmeraldPrice.put(DealID, Price);
							MerchantManager.EmeraldDeals = MerchantManager.EmeraldDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Diamond")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.DiamondItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.DIAMOND, ItemAmount);
							
							MerchantManager.DiamondItemStack.put(DealID, item);
							MerchantManager.DiamondPlayer.put(DealID, p);
							MerchantManager.DiamondPrice.put(DealID, Price);
							MerchantManager.DiamondDeals = MerchantManager.DiamondDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Gold Ingot")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.GoldIngotItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.GOLD_INGOT, ItemAmount);
							
							MerchantManager.GoldIngotItemStack.put(DealID, item);
							MerchantManager.GoldIngotPlayer.put(DealID, p);
							MerchantManager.GoldIngotPrice.put(DealID, Price);
							MerchantManager.GoldIngotDeals = MerchantManager.GoldIngotDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
					if(SettingsManager.jobs.getString("players." + p.getName() + ".Deals." + s + ".Material").equals("Redstone")){
						
						int DealID = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".DealNumber");
						if(!MerchantManager.RedstoneItemStack.containsKey(DealID)){
							int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Amount");
							int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals." + s + ".Price");
							
							ItemStack item = new ItemStack(Material.REDSTONE, ItemAmount);
							
							MerchantManager.RedstoneItemStack.put(DealID, item);
							MerchantManager.RedstonePlayer.put(DealID, p);
							MerchantManager.RedstonePrice.put(DealID, Price);
							MerchantManager.RedstoneDeals = MerchantManager.RedstoneDeals +1;
							
							if(s.equals("Deal1")){
								MerchantManager.PlayerDeals1ID.put(p, DealID);
							}
							if(s.equals("Deal2")){
								MerchantManager.PlayerDeals2ID.put(p, DealID);
							}
							if(s.equals("Deal3")){
								MerchantManager.PlayerDeals3ID.put(p, DealID);
							}
						}
					}
				}
			}
		}
	}
}
