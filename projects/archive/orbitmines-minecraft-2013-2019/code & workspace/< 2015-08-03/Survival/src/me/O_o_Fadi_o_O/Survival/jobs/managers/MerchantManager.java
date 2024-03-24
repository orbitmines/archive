package me.O_o_Fadi_o_O.Survival.jobs.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;
import me.O_o_Fadi_o_O.Survival.managers.ComponentMessageManager;
import me.O_o_Fadi_o_O.Survival.managers.ConfigManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MerchantManager {

	public static int lastdeal;
	
	public static List<Player> merchantannouncements = new ArrayList<Player>();
	public static HashMap<String, List<String>> merchantdealsid = new HashMap<String, List<String>>();
	public static HashMap<JobMaterial, Integer> merchantdealamount = new HashMap<JobMaterial, Integer>();
	
	public static HashMap<Integer, JobMaterial> merchantidtomaterial = new HashMap<Integer, JobMaterial>();

	public static HashMap<JobMaterial, Integer> merchantaverageprice = new HashMap<JobMaterial, Integer>();
	public static HashMap<JobMaterial, List<ItemStack>> merchantdealitemstacks = new HashMap<JobMaterial, List<ItemStack>>();
	public static HashMap<JobMaterial, List<String>> merchantdealplayers = new HashMap<JobMaterial, List<String>>();
	public static HashMap<JobMaterial, List<String>> merchantdealprices = new HashMap<JobMaterial, List<String>>();
	
	public static void removeDeal(Player p, JobMaterial material, int dealnumber){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		int dealid = Integer.parseInt(merchantdealsid.get(p.getName()).get(dealnumber -1));
		
		merchantdealamount.put(material, merchantdealamount.get(material) -1);
		List<ItemStack> itemstacks = merchantdealitemstacks.get(material);
		itemstacks.set(dealid, null);
		merchantdealitemstacks.put(material, itemstacks);
		List<String> players = merchantdealplayers.get(material);
		players.set(dealid, null);
		merchantdealplayers.put(material, players);
		List<String> prices = merchantdealprices.get(material);
		prices.set(dealid, null);
		merchantdealprices.put(material, prices);
		
		List<String> dealids = merchantdealsid.get(p.getName());
		dealids.remove("" + dealid);
		merchantdealsid.put(p.getName(), dealids);
		
		merchantidtomaterial.remove(dealid);
		
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + dealid, null);
		ConfigManager.savePlayerData();
		
		int totalitems = 0;
		for(ItemStack item : merchantdealitemstacks.get(material)){
			if(item != null){
				totalitems = totalitems + item.getAmount();
			}
		}
		
		int totalprice = 0;
		for(String s : merchantdealprices.get(material)){
			try{
				totalprice = totalprice + Integer.parseInt(s);
			}catch(Exception ex){}
		}
		
		if(totalitems == 0){
			merchantaverageprice.put(material, 0);
		}
		else{
			int averageprice = totalprice / totalitems;
			merchantaverageprice.put(material, averageprice);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void removeDeal(String player, JobMaterial material, int durability, int amount, int price, int dealnumber, Player buyer){
		String uuid = Start.getUUIDfromString(player).toString();
		
		int dealid = Integer.parseInt(merchantdealsid.get(player).get(dealnumber));
		
		merchantdealamount.put(material, merchantdealamount.get(material) -1);
		List<ItemStack> itemstacks = merchantdealitemstacks.get(material);
		itemstacks.set(dealid, null);
		merchantdealitemstacks.put(material, itemstacks);
		List<String> players = merchantdealplayers.get(material);
		players.set(dealid, null);
		merchantdealplayers.put(material, players);
		List<String> prices = merchantdealprices.get(material);
		prices.set(dealid, null);
		merchantdealprices.put(material, prices);
		
		List<String> dealids = merchantdealsid.get(player);
		dealids.remove("" + dealid);
		merchantdealsid.put(player, dealids);
		
		merchantidtomaterial.remove(dealid);
		
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + dealid, null);
		ConfigManager.savePlayerData();
		
		int totalitems = 0;
		for(ItemStack item : merchantdealitemstacks.get(material)){
			if(item != null){
				totalitems = totalitems + item.getAmount();
			}
		}
		
		int totalprice = 0;
		for(String s : merchantdealprices.get(material)){
			try{
				totalprice = totalprice + Integer.parseInt(s);
			}catch(Exception ex){}
		}
		
		if(totalitems == 0){
			merchantaverageprice.put(material, 0);
		}
		else{
			int averageprice = totalprice / totalitems;
			merchantaverageprice.put(material, averageprice);
		}
		
		buyer.sendMessage("");
		buyer.sendMessage("§a§lMerchant §8| §7Item Bought: " + JobManager.getItemDisplayColorName(material).substring(0, 4) + amount + " " + JobManager.getItemDisplayColorName(material));
		buyer.sendMessage("§a§lMerchant §8| §7Item Price: §a" + price + "$");
		buyer.playSound(buyer.getLocation(), Sound.LEVEL_UP, 5, 1);
		
		Material m = JobMaterial.getMaterial(material);
		ItemStack item = new ItemStack(m, amount);
		item.setDurability((short) durability); 
		if(buyer.getInventory().firstEmpty() == -1){
			buyer.sendMessage("§a§lMerchant §8| §cYou don't have enough Inventory space! Your items are now on the ground!");
			buyer.getWorld().dropItem(buyer.getLocation(), item);
		}
		else{
			buyer.getInventory().addItem(item);
		}
		
		Player seller = null;
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getName().equals(player)){
				seller = p;
			}
		}
		
		if(seller != null){
			seller.sendMessage("");
			seller.sendMessage("§a§lMerchant §8| §a" + buyer.getName() + "§7 just bought your Deal! (§6#" + dealid + "§7)");
			seller.sendMessage("§a§lMerchant §8| §7Item: " + JobManager.getItemDisplayColorName(material).substring(0, 4) + amount + " " + JobManager.getItemDisplayColorName(material));
			seller.sendMessage("§a§lMerchant §8| §7Item Price: §a" + price + "$");
			if(JobManager.joblevel.containsKey(seller)){
				double taxd = ((double) price / 100) * (20 - JobManager.joblevel.get(seller));
				int tax = (int) taxd;
				seller.sendMessage("§a§lMerchant §8| §7Merchant Tax: §c-" + tax + "$ §7(Level §9" + JobManager.joblevel.get(seller) + "§7, §c-" + (20 - JobManager.joblevel.get(seller)) +"%§7)");
				seller.sendMessage("§a§lMerchant §8| §7Total Profit: §2" + (price - tax) + "$");
				JobManager.addMoney(seller, (price - tax));
			
				if(JobManager.joblevel.get(seller) != 20){
					int xpadded = JobManager.joblevel.get(seller) +1;
					JobManager.addJobXP(seller, xpadded);
					seller.sendMessage("§a§lMerchant §8| §9+" + xpadded + " XP");
				}
				else{
					seller.sendMessage("§a§lMerchant §8| §9+0 XP (Level 20 is currently the highest level)");
				}
			}
			else{
				double taxd = ((double) price / 100) * 20;
				int tax = (int) taxd;
				seller.sendMessage("§a§lMerchant §8| §7Merchant Tax: §c-" + tax + " §7(No Job)");
				seller.sendMessage("§a§lMerchant §8| §7Total Profit: §2" + (price - tax) + "$");
				JobManager.addMoney(seller, (price - tax));
			}
			
			seller.playSound(seller.getLocation(), Sound.LEVEL_UP, 5, 1);
		}
		else{
			
			List<String> sendmessages = new ArrayList<String>();
			
			if(ConfigManager.playerdata.contains("players." + uuid + ".SendMessages")){
				for(String s : ConfigManager.playerdata.getStringList("players." + uuid + ".SendMessages")){
					sendmessages.add(s);
				}
			}
			
			sendmessages.add("");
			sendmessages.add("§a§lMerchant §8| §a" + buyer.getName() + "§7 bought your Deal! (§6#" + dealid + "§7)");
			sendmessages.add("§a§lMerchant §8| §7Item: " + JobManager.getItemDisplayColorName(material).substring(0, 4) + amount + " " + JobManager.getItemDisplayColorName(material));
			sendmessages.add("§a§lMerchant §8| §7Item Price: §a" + price + "$");
			if(ConfigManager.playerdata.contains("players." + uuid + ".JobInfo.Level")){
				int level = ConfigManager.playerdata.getInt("players." + uuid + ".JobInfo.Level");
				int xpadded = level +1;
				
				double taxd = ((double) price / 100) * (20 - level);
				int tax = (int) taxd;
				sendmessages.add("§a§lMerchant §8| §7Merchant Tax: §c-" + tax + "$ §7(Level §9" + level + "§7, §c-" + (20 - level) +"%§7)");
				sendmessages.add("§a§lMerchant §8| §7Total Profit: §2" + (price - tax) + "$");
				JobManager.addMoneyOffline(player, (price - tax));
				
				if(level != 20){
					JobManager.addJobXPOffline(player, xpadded);
					sendmessages.add("§a§lMerchant §8| §9+" + xpadded + " XP");
				}
				else{
					sendmessages.add("§a§lMerchant §8| §9+0 XP (Level 20 is currently the highest level)");
				}
			}
			else{
				double taxd = ((double) price / 100) * 20;
				int tax = (int) taxd;
				sendmessages.add("§a§lMerchant §8| §7Merchant Tax: §c-" + tax + " §7(No Job)");
				sendmessages.add("§a§lMerchant §8| §7Total Profit: §2" + (price - tax) + "$");
				JobManager.addMoneyOffline(player, (price - tax));
			}
			
			ConfigManager.playerdata.set("players." + uuid + ".SendMessages", sendmessages);
			ConfigManager.savePlayerData();
		}
				
		JobManager.removeMoney(buyer, price);
		
		buyer.closeInventory();
	}
			
	@SuppressWarnings("deprecation")
	public static void insertDeal(Player p, JobMaterial material, int durability, int amount, int price){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		int nextdealid = lastdeal +1;
		
		if(merchantdealsid.get(p.getName()).size() <= 2){
			List<String> stringlist = MerchantManager.merchantdealsid.get(p.getName());
			stringlist.add(null);
			merchantdealsid.put(p.getName(), stringlist);
		}
		
		ConfigManager.playerdata.set("LastDeal", nextdealid);
		
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + nextdealid + ".Type", JobMaterial.getMaterial(material).toString());
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + nextdealid + ".Durability", durability);
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + nextdealid + ".Amount", amount);
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + nextdealid + ".Price", price);
		
		ConfigManager.savePlayerData();
		
		merchantdealamount.put(material, merchantdealamount.get(material) +1);
		ItemStack item = new ItemStack(JobMaterial.getMaterial(material), amount);
		item.setDurability((short) durability);
		List<ItemStack> itemstacks = merchantdealitemstacks.get(material);
		itemstacks.set(nextdealid, item);
		merchantdealitemstacks.put(material, itemstacks);
		List<String> players = merchantdealplayers.get(material);
		players.set(nextdealid, p.getName());
		merchantdealplayers.put(material, players);
		List<String> prices = merchantdealprices.get(material);
		prices.set(nextdealid, "" + price);
		
		List<String> dealids = merchantdealsid.get(p.getName());
		dealids.set(merchantdealsid.get(p.getName()).size() -1, "" + nextdealid);
		merchantdealsid.put(p.getName(), dealids);
		
		merchantidtomaterial.put(nextdealid, material);
		
		lastdeal = nextdealid;
		
		int totalitems = 0;
		for(ItemStack i : merchantdealitemstacks.get(material)){
			if(i != null){
				totalitems = totalitems + i.getAmount();
			}
		}
		
		int totalprice = 0;
		for(String s : merchantdealprices.get(material)){
			try{
				totalprice = totalprice + Integer.parseInt(s);
			}catch(Exception ex){}
		}
		
		if(totalitems == 0){
			merchantaverageprice.put(material, 0);
		}
		else{
			int averageprice = totalprice / totalitems;
			merchantaverageprice.put(material, averageprice);
		}
		
		if(merchantannouncements.contains(p)){
			for(Player player : Bukkit.getOnlinePlayers()){
				ComponentMessageManager.sendComponentMessage(player, "§a" + p.getName() + "§7 made a new Deal! ", "§7»" + JobManager.getItemDisplayColorName(material) + "§7«", "show_text", "", "§7Amount: §a" + amount + "\n§7Price: §a" + price + "$", "");
			}
		}
	}
}
