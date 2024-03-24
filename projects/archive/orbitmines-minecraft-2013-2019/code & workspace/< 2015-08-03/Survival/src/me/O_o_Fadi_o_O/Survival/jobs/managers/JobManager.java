package me.O_o_Fadi_o_O.Survival.jobs.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.jobs.utils.Job;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;
import me.O_o_Fadi_o_O.Survival.managers.ConfigManager;
import me.O_o_Fadi_o_O.Survival.managers.TitleManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JobManager {

	public static HashMap<Player, Integer> money = new HashMap<Player, Integer>();
	
	public static HashMap<Player, Job> job = new HashMap<Player, Job>();
	public static HashMap<Player, Integer> joblevel = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> jobxp = new HashMap<Player, Integer>();

	public static void joinJob(Player p, Job j){
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		ConfigManager.playerdata.set("players." + uuid + ".JobInfo.Name", j.toString());
		ConfigManager.playerdata.set("players." + uuid + ".JobInfo.Level", 0);
		ConfigManager.playerdata.set("players." + uuid + ".JobInfo.XP", 0);
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo", null);
		ConfigManager.savePlayerData();
		
		job.put(p, j);
		joblevel.put(p, 0);
		jobxp.put(p, 0);
	}
	
	public static void leaveJob(Player p){
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		ConfigManager.playerdata.set("players." + uuid + ".JobInfo", null);
		ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo", null);
		ConfigManager.savePlayerData();
		
		job.remove(p);
		joblevel.remove(p);
		jobxp.remove(p);
	}
	
	public static void addJobXP(Player p, int amount){
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		int xpneeded = joblevel.get(p) * 50 + 75;
		int xp = jobxp.get(p);
		int newxp = xp + amount;
		
		if(xpneeded <= newxp){
			int extraxp = newxp - xpneeded;
			jobxp.put(p, extraxp);
			joblevel.put(p, joblevel.get(p) +1);
			
			ConfigManager.playerdata.set("players." + uuid + ".JobInfo.XP", extraxp);
			ConfigManager.playerdata.set("players." + uuid + ".JobInfo.Level", joblevel.get(p));
			ConfigManager.savePlayerData();
		}
		else{
			jobxp.put(p, newxp);
			
			ConfigManager.playerdata.set("players." + uuid + ".JobInfo.XP", newxp);
			ConfigManager.savePlayerData();
		}
	}
	
	public static void addJobXPOffline(String player, int amount){
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		int xp = ConfigManager.playerdata.getInt("players." + uuid + ".JobInfo.XP");
		int level = ConfigManager.playerdata.getInt("players." + uuid + ".JobInfo.Level");
		int xpneeded = xp * 50 + 75;
		int newxp = xp + amount;
		
		if(xpneeded <= newxp){
			int extraxp = newxp - xpneeded;
			
			ConfigManager.playerdata.set("players." + uuid + ".JobInfo.XP", extraxp);
			ConfigManager.playerdata.set("players." + uuid + ".JobInfo.Level", level +1);
			ConfigManager.savePlayerData();
		}
		else{
			ConfigManager.playerdata.set("players." + uuid + ".JobInfo.XP", newxp);
			ConfigManager.savePlayerData();
		}
	}
	
	public static void addMoneyOffline(String player, int amount){
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		ConfigManager.playerdata.set("players." + uuid + ".Money", ConfigManager.playerdata.getInt("players." + uuid + ".Money") + amount);
		ConfigManager.savePlayerData();
	}
	public static void removeMoneyOffline(String player, int amount){
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		ConfigManager.playerdata.set("players." + uuid + ".Money", ConfigManager.playerdata.getInt("players." + uuid + ".Money") - amount);
		ConfigManager.savePlayerData();
	}
	public static void addMoney(Player p, int amount){
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		TitleManager.setTitle(p, "", "§2+" + amount + "$");
		money.put(p, money.get(p) + amount);
		
		ConfigManager.playerdata.set("players." + uuid + ".Money", money.get(p));
		ConfigManager.savePlayerData();
	}
	public static void removeMoney(Player p, int amount){
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		money.put(p, money.get(p) - amount);
		
		ConfigManager.playerdata.set("players." + uuid + ".Money", money.get(p));
		ConfigManager.savePlayerData();
	}
	public static boolean hasMoney(Player p, int amount){
		if(money.containsKey(p)){
			if(money.get(p) >= amount){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public static void registerMerchantData(final Player p){
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		if(ConfigManager.playerdata.contains("players." + p.getName())){
			ConfigManager.playerdata.set("players." + uuid + ".MaxHomesAllowed", ConfigManager.playerdata.getInt("players." + p.getName() + ".MaxHomesAllowed"));
			ConfigManager.playerdata.set("players." + uuid + ".Money", ConfigManager.playerdata.getInt("players." + p.getName() + ".Money"));
			
			if(ConfigManager.playerdata.contains("players." + p.getName() + ".Homes")){
				for(String home : ConfigManager.playerdata.getConfigurationSection("players." + p.getName() + ".Homes").getKeys(false)){
					ConfigManager.playerdata.set("players." + uuid + ".Homes." + home, ConfigManager.playerdata.getString("players." + p.getName() + ".Homes." + home));
				}
			}
			if(ConfigManager.playerdata.contains("players." + p.getName() + ".JobInfo")){
				ConfigManager.playerdata.set("players." + uuid + ".JobInfo.Name", ConfigManager.playerdata.getString("players." + p.getName() + ".JobInfo.Name"));
				ConfigManager.playerdata.set("players." + uuid + ".JobInfo.Level", ConfigManager.playerdata.getInt("players." + p.getName() + ".JobInfo.Level"));
				ConfigManager.playerdata.set("players." + uuid + ".JobInfo.XP", ConfigManager.playerdata.getInt("players." + p.getName() + ".JobInfo.XP"));
			}
			if(ConfigManager.playerdata.contains("players." + p.getName() + ".MerchantInfo.Selling")){
				for(String deal : ConfigManager.playerdata.getConfigurationSection("players." + p.getName() + ".MerchantInfo.Selling").getKeys(false)){
					ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + deal + ".Type", ConfigManager.playerdata.getString("players." + p.getName() + ".MerchantInfo.Selling." + deal + ".Type"));
					ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + deal + ".Durability", ConfigManager.playerdata.getInt("players." + p.getName() + ".MerchantInfo.Selling." + deal + ".Durability"));
					ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + deal + ".Amount", ConfigManager.playerdata.getInt("players." + p.getName() + ".MerchantInfo.Selling." + deal + ".Amount"));
					ConfigManager.playerdata.set("players." + uuid + ".MerchantInfo.Selling." + deal + ".Price", ConfigManager.playerdata.getInt("players." + p.getName() + ".MerchantInfo.Selling." + deal + ".Price"));
				}
			}
			if(ConfigManager.playerdata.contains("players." + p.getName() + ".Announce")){
				ConfigManager.playerdata.set("players." + uuid + ".Announce", ConfigManager.playerdata.getBoolean("players." + p.getName() + ".Announce"));
			}
			ConfigManager.playerdata.set("players." + p.getName(), null);
			ConfigManager.savePlayerData();
		}
		
		if(!MerchantManager.merchantdealsid.containsKey(p.getName())){
			List<String> stringlist = new ArrayList<String>();
			MerchantManager.merchantdealsid.put(p.getName(), stringlist);
		}
		if(ConfigManager.playerdata.contains("players." + uuid + ".Announce")){
			MerchantManager.merchantannouncements.add(p);
		}
		if(!ConfigManager.playerdata.contains("players." + uuid + ".Money")){
			ConfigManager.playerdata.set("players." + uuid + ".Money", 50);
			ConfigManager.savePlayerData();
			money.put(p, 50);
			Start.getInstance().teleportToSpawn(p);
		}
		else{
			money.put(p, ConfigManager.playerdata.getInt("players." + uuid + ".Money"));
		}
		
		if(ConfigManager.playerdata.contains("players." + uuid + ".JobInfo")){
			
			job.put(p, Job.valueOf(ConfigManager.playerdata.getString("players." + uuid + ".JobInfo.Name")));
			joblevel.put(p, ConfigManager.playerdata.getInt("players." + uuid + ".JobInfo.Level"));
			jobxp.put(p, ConfigManager.playerdata.getInt("players." + uuid + ".JobInfo.XP"));
			
		}
		if(ConfigManager.playerdata.contains("players." + uuid + ".MerchantInfo.Selling")){
			for(String s : ConfigManager.playerdata.getConfigurationSection("players." + uuid + ".MerchantInfo.Selling").getKeys(false)){
				int dealid = Integer.parseInt(s);
				Material m = Material.valueOf(ConfigManager.playerdata.getString("players." + uuid + ".MerchantInfo.Selling." + dealid + ".Type"));
				int durability = ConfigManager.playerdata.getInt("players." + uuid + ".MerchantInfo.Selling." + s + ".Durability");
				
				JobMaterial material = JobMaterial.getJobMaterial(m, durability);
				if(MerchantManager.merchantdealitemstacks.get(material).get(dealid) == null){
					int amount = ConfigManager.playerdata.getInt("players." + uuid + ".MerchantInfo.Selling." + s + ".Amount");
					int price = ConfigManager.playerdata.getInt("players." + uuid + ".MerchantInfo.Selling." + s + ".Price");
					
					ItemStack item = new ItemStack(m, amount);
					item.setDurability((short) durability);
					
					List<ItemStack> itemstacks = MerchantManager.merchantdealitemstacks.get(material);
					itemstacks.set(dealid, item);
					MerchantManager.merchantdealitemstacks.put(material, itemstacks);
					
					List<String> players = MerchantManager.merchantdealplayers.get(material);
					players.set(dealid, p.getName());
					MerchantManager.merchantdealplayers.put(material, players);
					
					List<String> prices = MerchantManager.merchantdealprices.get(material);
					prices.set(dealid, "" + price);
					MerchantManager.merchantdealprices.put(material, prices);
					
					MerchantManager.merchantdealamount.put(material, MerchantManager.merchantdealamount.get(material) +1);
					
					List<String> dealids = MerchantManager.merchantdealsid.get(p.getName());
					dealids.add(null);
					dealids.set(dealids.size() -1, "" + dealid);
					MerchantManager.merchantdealsid.put(p.getName(), dealids);
					
					MerchantManager.merchantidtomaterial.put(dealid, material);
					
					int totalitems = 0;
					for(ItemStack i : MerchantManager.merchantdealitemstacks.get(material)){
						if(i != null){
							totalitems = totalitems + i.getAmount();
						}
					}
					
					int totalprice = 0;
					for(String s2 : MerchantManager.merchantdealprices.get(material)){
						try{
							totalprice = totalprice + Integer.parseInt(s2);
						}catch(Exception ex){}
					}
					
					if(totalitems == 0){
						MerchantManager.merchantaverageprice.put(material, 0);
					}
					else{
						int averageprice = totalprice / totalitems;
						MerchantManager.merchantaverageprice.put(material, averageprice);
					}
				}
			}
		}
	}
	
	public static String getItemDisplayColorName(JobMaterial material){
		
		if(material == JobMaterial.COAL){
			return "§8§lCoal";
		}
		else if(material == JobMaterial.IRON_INGOT){
			return "§7§lIron Ingot";
		}
		else if(material == JobMaterial.COBBLESTONE){
			return "§7§lCobblestone";
		}
		else if(material == JobMaterial.LAPIS_LAZULI){
			return "§1§lLapis Lazuli";
		}
		else if(material == JobMaterial.EMERALD){
			return "§a§lEmerald";
		}
		else if(material == JobMaterial.DIAMOND){
			return "§b§lDiamond";
		}
		else if(material == JobMaterial.GOLD_INGOT){
			return "§6§lGold Ingot";
		}
		else if(material == JobMaterial.REDSTONE){
			return "§4§lRedstone";
		}
		else if(material == JobMaterial.WHEAT){
			return "§2§lWheat";
		}
		else if(material == JobMaterial.MELON){
			return "§c§lMelon";
		}
		else if(material == JobMaterial.APPLE){
			return "§4§lApple";
		}
		else if(material == JobMaterial.CARROT_ITEM){
			return "§6§lCarrot";
		}
		else if(material == JobMaterial.SUGAR_CANE){
			return "§a§lSugarcane";
		}
		else if(material == JobMaterial.POTATO_ITEM){
			return "§e§lPotato";
		}
		else if(material == JobMaterial.ACACIA_LOG){
			return "§c§lAcacia Wood";
		}
		else if(material == JobMaterial.BIRCH_LOG){
			return "§f§lBirch Wood";
		}
		else if(material == JobMaterial.OAK_LOG){
			return "§6§lOak Wood";
		}
		else if(material == JobMaterial.JUNGLE_LOG){
			return "§e§lJungle Wood";
		}
		else if(material == JobMaterial.SPRUCE_LOG){
			return "§8§lSpruce Wood";
		}
		else if(material == JobMaterial.DARK_OAK_LOG){
			return "§8§lDark Oak Wood";
		}
		else if(material == JobMaterial.SPIDER_EYE){
			return "§5§lSpider Eye";
		}
		else if(material == JobMaterial.BLAZE_ROD){
			return "§6§lBlaze Rod";
		}
		else if(material == JobMaterial.ROTTEN_FLESH){
			return "§c§lRotten Flesh";
		}
		else if(material == JobMaterial.WITHER_SKELETON_SKULL){
			return "§8§lWither Skeleton Skull";
		}
		else if(material == JobMaterial.BONE){
			return "§f§lBone";
		}
		else if(material == JobMaterial.ENDER_PEARL){
			return "§3§lEnder Pearl";
		}
		else if(material == JobMaterial.GHAST_TEAR){
			return "§f§lGhast Tear";
		}
		else if(material == JobMaterial.GUNPOWDER){
			return "§7§lGunpowder";
		}
		else if(material == JobMaterial.MAGMA_CREAM){
			return "§c§lMagma Cream";
		}
		else if(material == JobMaterial.SLIME_BALL){
			return "§a§lSlimeball";
		}
		else if(material == JobMaterial.FEATHER){
			return "§f§lFeather";
		}
		else if(material == JobMaterial.RAW_CHICKEN){
			return "§d§lRaw Chicken";
		}
		else if(material == JobMaterial.RABBIT_HIDE){
			return "§e§lRabbit Hide";
		}
		else if(material == JobMaterial.RAW_RABBIT){
			return "§d§lRaw Rabbit";
		}
		else if(material == JobMaterial.RAW_BEEF){
			return "§c§lRaw Beef";
		}
		else if(material == JobMaterial.LEATHER){
			return "§6§lLeather";
		}
		else if(material == JobMaterial.RAW_PORK){
			return "§d§lRaw Porkchop";
		}
		else if(material == JobMaterial.RAW_MUTTON){
			return "§c§lRaw Mutton";
		}
		else if(material == JobMaterial.NETHER_WART){
			return "§c§lNether Wart";
		}
		else if(material == JobMaterial.QUARTZ_ORE){
			return "§c§lQuartz Ore";
		}
		else if(material == JobMaterial.NETHER_BRICK){
			return "§4§lNether Brick";
		}
		else if(material == JobMaterial.NETHERRACK){
			return "§c§lNetherrack";
		}
		else if(material == JobMaterial.QUARTZ){
			return "§f§lQuartz";
		}
		else if(material == JobMaterial.NETHER_BRICKS){
			return "§4§lNether Brick";
		}
		else{
			return null;
		}
	}
}
