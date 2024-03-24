package me.O_o_Fadi_o_O.Survival.events;

import java.util.HashMap;
import java.util.Map;
import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.JobInvs.Confirm;
import me.O_o_Fadi_o_O.Survival.JobInvs.JobSelector;
import me.O_o_Fadi_o_O.Survival.JobInvs.Miner;
import me.O_o_Fadi_o_O.Survival.JobInvs.Sell;
import me.O_o_Fadi_o_O.Survival.Managers.JobManager;
import me.O_o_Fadi_o_O.Survival.Managers.MerchantManager;
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
	
	Start plugin;
	 
	public ClickEvent2(Start instance) {
	plugin = instance;
	}
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 3600;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			final Player p = (Player) he;
			ItemStack c = e.getCurrentItem();
			
			try{
				if(e.getInventory().getName().equals("§0§lJob Manager")){
					
					e.setCancelled(true);
					
					if(c.getType() == Material.DIAMOND_PICKAXE && c.getItemMeta().getDisplayName().equals("§9§lMiner Job")){
						
						p.openInventory(Miner.getMinerInv(p));
						
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
						
						String material = inv.getItem(4).getItemMeta().getLore().get(1).substring(13);
						String DealIDString = inv.getItem(4).getItemMeta().getLore().get(0).substring(14);
						int DealID = Integer.parseInt(DealIDString);
				
						p.sendMessage("§6§lJobs §8| §7Removed §6#" + DealID + "§7!");
						
						if(material.equals("Coal")){
							ItemStack item = new ItemStack(Material.COAL, MerchantManager.CoalItemStack.get(DealID).getAmount());
							if(p.getInventory().firstEmpty() == -1){
								p.sendMessage("§6§lJobs §8| §cYou don't have enough Inventory space! Your items are now on the ground!");
								p.getWorld().dropItem(p.getLocation(), item);
							}
							else{
								p.getInventory().addItem(item);
							}
						}
						if(material.equals("Iron Ingot")){
							ItemStack item = new ItemStack(Material.IRON_INGOT, MerchantManager.IronIngotItemStack.get(DealID).getAmount());
							p.getInventory().addItem(item);
						}
						if(material.equals("Cobblestone")){
							ItemStack item = new ItemStack(Material.COBBLESTONE, MerchantManager.CobblestoneItemStack.get(DealID).getAmount());
							p.getInventory().addItem(item);
						}
						if(material.equals("Lapis Lazuli")){
							ItemStack item = new ItemStack(Material.INK_SACK, MerchantManager.LapisLazuliItemStack.get(DealID).getAmount());
							item.setDurability((short) 4);
							p.getInventory().addItem(item);
						}
						if(material.equals("Emerald")){
							ItemStack item = new ItemStack(Material.EMERALD, MerchantManager.EmeraldItemStack.get(DealID).getAmount());
							p.getInventory().addItem(item);
						}
						if(material.equals("Diamond")){
							ItemStack item = new ItemStack(Material.DIAMOND, MerchantManager.DiamondItemStack.get(DealID).getAmount());
							p.getInventory().addItem(item);
						}
						if(material.equals("Gold Ingot")){
							ItemStack item = new ItemStack(Material.GOLD_INGOT, MerchantManager.GoldIngotItemStack.get(DealID).getAmount());
							p.getInventory().addItem(item);
						}
						if(material.equals("Redstone")){
							ItemStack item = new ItemStack(Material.REDSTONE, MerchantManager.RedstoneItemStack.get(DealID).getAmount());
							p.getInventory().addItem(item);
						}
						
						MerchantManager.removeDeal(p, material, DealNumber, DealID);
						p.openInventory(Miner.getMinerInv(p));
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, 1);
						
					}
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§cNo, I don't want to remove this Deal.")){
						
						p.openInventory(JobSelector.getJobSelector(p));
						
					}
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§aYes, I want to quit my Job.")){
						
						lastUsage.put(p.getName(), System.currentTimeMillis());
						
						if(JobManager.JobName.get(p).equals("Miner")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§9§lMiner§7'");
						}
						if(JobManager.JobName.get(p).equals("Potion Master")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§e§lPotion Master§7'");
						}
						if(JobManager.JobName.get(p).equals("Hunter")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§b§lHunter§7'");
						}
						if(JobManager.JobName.get(p).equals("Farmer")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§7§lFarmer§7'");
						}
						if(JobManager.JobName.get(p).equals("Animal Farmer")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§a§lAnimal Farmer§7'");
						}
						if(JobManager.JobName.get(p).equals("Lumberjack")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§6§lLumberjack§7'");
						}
						if(JobManager.JobName.get(p).equals("Nether Expert")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§c§lNether Expert§7'");
						}
						if(JobManager.JobName.get(p).equals("Enchanter")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§3§lEnchanter§7'");
						}
						if(JobManager.JobName.get(p).equals("Fisher")){
							p.sendMessage("§6§lJobs §8| §7You left the Job '§d§lFisher§7'");
						}
						
						p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
						JobManager.leaveJob(p, JobManager.JobName.get(p));
						p.openInventory(JobSelector.getJobSelector(p));
					}
					if(c.getType() == Material.STAINED_GLASS_PANE && c.getItemMeta().getDisplayName().equals("§cNo, I don't want to quit my Job.")){
						
						p.openInventory(JobSelector.getJobSelector(p));
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lMiner")){
					
					e.setCancelled(true);
					
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 1:")){
						
						p.openInventory(Confirm.getConfirmInv(p, "RemoveDeal1"));
						
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 2:")){
						
						p.openInventory(Confirm.getConfirmInv(p, "RemoveDeal2"));
						
					}
					if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§6§lDeal 3:")){
						
						p.openInventory(Confirm.getConfirmInv(p, "RemoveDeal3"));
						
					}
					
					if(c.getType() == Material.DIAMOND_PICKAXE && c.getItemMeta().getDisplayName().equals("§9§lMiner Job §8| §f§lJoin the Miner Job")){
			
						long lastUsed = 0;
						if(lastUsage.containsKey(p.getName())){
							lastUsed = lastUsage.get(p.getName());
						}
						int cdmillis = cdtime * 1000;
						
						if(System.currentTimeMillis()-lastUsed>=cdmillis){
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							JobManager.joinJob(p, "Miner");
							p.openInventory(Miner.getMinerInv(p));
							p.sendMessage("§6§lJobs §8| §7You joined the Job '§9§lMiner§7'");
						}
						else{
							int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000)) / 60;
							if(timeLeft == 1){
								p.sendMessage("§6§lJobs §8| §7Wait§6 " + timeLeft + "§7 more minute to join a job again.");
							}
							else{
								p.sendMessage("§6§lJobs §8| §7Wait§6 " + timeLeft + "§7 more minutes to join a job again.");
							}
						}
							
						
					}
					if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						p.openInventory(JobSelector.getJobSelector(p));
						
					}
					if(c.getType() == Material.FIRE && c.getItemMeta().getDisplayName().equals("§cLeave Job")){
						
						p.openInventory(Confirm.getConfirmInv(p, "LeaveJob"));
						
					}
					if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8Coal")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCoal (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Coal");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCoal (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Coal");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7Iron Ingot")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lIron Ingot (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Iron Ingot");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lIron Ingot (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Iron Ingot");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7Cobblestone")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCobblestone (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Cobblestone");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lCobblestone (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Cobblestone");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1Lapis Lazuli")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lLapis Lazuli (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Lapis Lazuli");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lLapis Lazuli (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Lapis Lazuli");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§aEmerald")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lEmerald (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Emerald");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lEmerald (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Emerald");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§bDiamond")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDiamond (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Diamond");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDiamond (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Diamond");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6Gold Ingot")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGold Ingot (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Gold Ingot");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lGold Ingot (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Gold Ingot");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Redstone")){
						
						if(JobManager.JobName.containsKey(p)){
							if(JobManager.JobName.get(p).equals("Miner")){
								if(MerchantManager.PlayerDealsAmount.containsKey(p)){
									if(MerchantManager.PlayerDealsAmount.get(p) != 3){
										final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRedstone (" + p.getName() + ")");
										Sell.getSellInv(p, inv, "Redstone");
									}
									else{
										p.sendMessage("§6§lJobs §8| §7You already have §63 Deals§7!");
									}
								}
								else{
									final Inventory inv = Bukkit.createInventory(null, 54, "§0§lRedstone (" + p.getName() + ")");
									Sell.getSellInv(p, inv, "Redstone");
								}
							}
							else{
								p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
							}
						}
						else{
							p.sendMessage("§6§lJobs §8| §7You need to be a §9§lMiner§7 to sell this!");
						}
					}
				}
				if(e.getInventory().getName().equals("§0§lCoal (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+1 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+2 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+3 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+4 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+5 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+6 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8+64 Coal")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Coal");
							
							Sell.SellItem1(p, inv, "Coal");
							Sell.SellItem2(p, inv, "Coal");
							Sell.SellItem3(p, inv, "Coal");
							Sell.SellItem4(p, inv, "Coal");
							Sell.SellItem5(p, inv, "Coal");
							Sell.SellItem6(p, inv, "Coal");
							Sell.SellItem64(p, inv, "Coal");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Coal");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.COAL && c.getItemMeta().getDisplayName().equals("§8Coal") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§8§lCoal");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lIron Ingot (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+1 Iron Ingot")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+2 Iron Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+3 Iron Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+4 Iron Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+5 Iron Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+6 Iron Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7+64 Iron Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Iron Ingot");
							
							Sell.SellItem1(p, inv, "Iron Ingot");
							Sell.SellItem2(p, inv, "Iron Ingot");
							Sell.SellItem3(p, inv, "Iron Ingot");
							Sell.SellItem4(p, inv, "Iron Ingot");
							Sell.SellItem5(p, inv, "Iron Ingot");
							Sell.SellItem6(p, inv, "Iron Ingot");
							Sell.SellItem64(p, inv, "Iron Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Iron Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7Iron Ingot") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§7§lIron Ingot");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lCobblestone (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+1 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+2 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+3 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+4 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+5 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+6 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7+64 Cobblestone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Cobblestone");
							
							Sell.SellItem1(p, inv, "Cobblestone");
							Sell.SellItem2(p, inv, "Cobblestone");
							Sell.SellItem3(p, inv, "Cobblestone");
							Sell.SellItem4(p, inv, "Cobblestone");
							Sell.SellItem5(p, inv, "Cobblestone");
							Sell.SellItem6(p, inv, "Cobblestone");
							Sell.SellItem64(p, inv, "Cobblestone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Cobblestone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().equals("§7Cobblestone") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§7§lCobblestone");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lLapis Lazuli (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+1 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+2 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+3 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+4 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+5 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+6 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1+64 Lapis Lazuli")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Lapis Lazuli");
							
							Sell.SellItem1(p, inv, "Lapis Lazuli");
							Sell.SellItem2(p, inv, "Lapis Lazuli");
							Sell.SellItem3(p, inv, "Lapis Lazuli");
							Sell.SellItem4(p, inv, "Lapis Lazuli");
							Sell.SellItem5(p, inv, "Lapis Lazuli");
							Sell.SellItem6(p, inv, "Lapis Lazuli");
							Sell.SellItem64(p, inv, "Lapis Lazuli");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Lapis Lazuli");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§1Lapis Lazuli") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§1§lLapis Lazuli");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lEmerald (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+1 Emerald")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+2 Emeralds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+3 Emeralds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+4 Emeralds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+5 Emeralds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+6 Emeralds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a+64 Emeralds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Emerald");
							
							Sell.SellItem1(p, inv, "Emerald");
							Sell.SellItem2(p, inv, "Emerald");
							Sell.SellItem3(p, inv, "Emerald");
							Sell.SellItem4(p, inv, "Emerald");
							Sell.SellItem5(p, inv, "Emerald");
							Sell.SellItem6(p, inv, "Emerald");
							Sell.SellItem64(p, inv, "Emerald");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Emerald");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§aEmerald") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§a§lEmerald");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lDiamond (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+1 Diamond")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+2 Diamonds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+3 Diamonds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+4 Diamonds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+5 Diamonds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+6 Diamonds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b+64 Diamonds")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Diamond");
							
							Sell.SellItem1(p, inv, "Diamond");
							Sell.SellItem2(p, inv, "Diamond");
							Sell.SellItem3(p, inv, "Diamond");
							Sell.SellItem4(p, inv, "Diamond");
							Sell.SellItem5(p, inv, "Diamond");
							Sell.SellItem6(p, inv, "Diamond");
							Sell.SellItem64(p, inv, "Diamond");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Diamond");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§bDiamond") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§b§lDiamond");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lGold Ingot (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1 Gold Ingot")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+2 Gold Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+3 Gold Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+4 Gold Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+5 Gold Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+6 Gold Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+64 Gold Ingots")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Gold Ingot");
							
							Sell.SellItem1(p, inv, "Gold Ingot");
							Sell.SellItem2(p, inv, "Gold Ingot");
							Sell.SellItem3(p, inv, "Gold Ingot");
							Sell.SellItem4(p, inv, "Gold Ingot");
							Sell.SellItem5(p, inv, "Gold Ingot");
							Sell.SellItem6(p, inv, "Gold Ingot");
							Sell.SellItem64(p, inv, "Gold Ingot");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Gold Ingot");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6Gold Ingot") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§6§lGold Ingot");
							
						}
					}catch(Exception ex){
						
					}
					
				}
				if(e.getInventory().getName().equals("§0§lRedstone (" + p.getName() + ")")){
					
					e.setCancelled(true);
					
					try{
						if(c.getType() == Material.WORKBENCH && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
							
							p.openInventory(Miner.getMinerInv(p));
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+1 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 1, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+2 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 2, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+3 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 3, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+4 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 4, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+5 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 5, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+6 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount() + 6, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4+64 Redstone")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, 64, price, "Redstone");
							
							Sell.SellItem1(p, inv, "Redstone");
							Sell.SellItem2(p, inv, "Redstone");
							Sell.SellItem3(p, inv, "Redstone");
							Sell.SellItem4(p, inv, "Redstone");
							Sell.SellItem5(p, inv, "Redstone");
							Sell.SellItem6(p, inv, "Redstone");
							Sell.SellItem64(p, inv, "Redstone");
							
							Sell.Money1(p, inv);
							Sell.Money5(p, inv);
							Sell.Money10(p, inv);
							Sell.Money50(p, inv);
							Sell.Money100(p, inv);
							Sell.Money500(p, inv);
							Sell.Money1000(p, inv);
							
							
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+1$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+5$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +5, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+10$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +10, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§6+50$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +50, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+100$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +100, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+500$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +500, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6+1000$")){
							String s = p.getOpenInventory().getTopInventory().getItem(40).getItemMeta().getLore().get(1);	
							int price = Integer.parseInt(s.substring(10));
							
							Inventory inv = p.getOpenInventory().getTopInventory();
							
							Sell.StatsItem(p, inv, inv.getItem(40).getAmount(), price +1000, "Redstone");
							
							p.playEffect(p.getLocation(), Effect.STEP_SOUND, 41);
						}
						if(c.getType() == Material.REDSTONE && c.getItemMeta().getDisplayName().equals("§4Redstone") && c.getItemMeta().getLore().contains("§a§l§oConfirm Deal")){
							
							Sell.confirmDeal(p, p.getOpenInventory().getTopInventory(), "§4§lRedstone");
							
						}
					}catch(Exception ex){
						
					}
					
				}
			}catch(Exception ex){
				
			}
		}
	}
}
