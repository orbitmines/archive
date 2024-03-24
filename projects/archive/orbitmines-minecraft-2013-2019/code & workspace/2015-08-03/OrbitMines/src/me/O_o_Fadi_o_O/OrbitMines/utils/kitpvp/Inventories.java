package me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Currency;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.Booster;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.KitPvPKit;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.Mastery;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Inventories {

	public static class BoosterInv {
		
		private Inventory inventory;
		
		public BoosterInv(){
			Inventory inventory = Bukkit.createInventory(null, 9, "§0§lBoosters");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[1] = getItem(omp, Booster.IRON_BOOSTER);
			contents[3] = getItem(omp, Booster.GOLD_BOOSTER);
			contents[5] = getItem(omp, Booster.DIAMOND_BOOSTER);
			contents[7] = getItem(omp, Booster.EMERALD_BOOSTER);
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, Booster booster){
			ItemStack item = new ItemStack(booster.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(booster.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("§7Multiplier: §ax" + booster.getMultiplier());
			itemlore.add("§7Duration: §a30 Minutes");
			itemlore.add("");
			itemlore.add(booster.getPriceName(omp));
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
	}
	
	public static class KitSelectorInv {
		
		private Inventory inventory;
		
		public KitSelectorInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lKit Selector");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			player.sendMessage("§7Opening the §bKit Selector§7...");
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[9] = getItem(omp, KitPvPKit.KNIGHT);
			contents[10] = getItem(omp, KitPvPKit.ARCHER);
			contents[11] = getItem(omp, KitPvPKit.SOLDIER);
			contents[12] = getItem(omp, KitPvPKit.WIZARD);
			contents[13] = getItem(omp, KitPvPKit.TANK);
			contents[14] = getItem(omp, KitPvPKit.DRUNK);
			contents[15] = getItem(omp, KitPvPKit.PYRO);
			contents[16] = getItem(omp, KitPvPKit.BUNNY);
			contents[17] = getItem(omp, KitPvPKit.NECROMANCER);
			contents[18] = getItem(omp, KitPvPKit.KING);
			contents[19] = getItem(omp, KitPvPKit.TREE);
			contents[20] = getItem(omp, KitPvPKit.BLAZE);
			contents[21] = getItem(omp, KitPvPKit.TNT);
			contents[22] = getItem(omp, KitPvPKit.FISHERMAN);
			contents[23] = getItem(omp, KitPvPKit.SNOWGOLEM);
			contents[24] = getItem(omp, KitPvPKit.LIBRARIAN);
			contents[25] = getItem(omp, KitPvPKit.SPIDER);
			contents[26] = getItem(omp, KitPvPKit.VILLAGER);
			contents[27] = getItem(omp, KitPvPKit.ASSASSIN);
			contents[28] = getItem(omp, KitPvPKit.LORD);
			contents[29] = getItem(omp, KitPvPKit.VAMPIRE);
			contents[30] = getItem(omp, KitPvPKit.DARKMAGE);
			contents[31] = getItem(omp, KitPvPKit.BEAST);
			contents[32] = getItem(omp, KitPvPKit.FISH);
			contents[33] = getItem(omp, KitPvPKit.HEAVY);
			contents[34] = getItem(omp, KitPvPKit.GRIMREAPER);
			contents[35] = getItem(omp, KitPvPKit.MINER);
			contents[36] = getItem(omp, KitPvPKit.FARMER);
			contents[37] = getItem(omp, KitPvPKit.UNDEATH_KING);
			contents[38] = getItem(omp, KitPvPKit.ENGINEER);
			
			{
				ItemStack item = Utils.setDisplayname(new ItemStack(Material.STAINED_GLASS_PANE), "§oComing Soon...");
				contents[39] = item;
				contents[40] = item;
				contents[41] = item;
				contents[42] = item;
				contents[43] = item;
				contents[44] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, KitPvPKit kit){
			KitPvPPlayer kp = omp.getKitPvPPlayer();
			int kitlevel = kp.getUnlockedLevel(kit);
			if(kit.getVIPRank() != null){
				if(omp.hasPerms(kit.getVIPRank())){
					kitlevel = 1;
				}
			}
			
			ItemStack item = new ItemStack(kit.getMaterial(), kitlevel);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(kit.getKitName(kitlevel));
			itemmeta.setLore(kit.getKitLore(kitlevel));
			item.setItemMeta(itemmeta);
			item.setDurability(kit.getDurability());
			if(ServerData.getKitPvP().isFreeKitEnabled() || kitlevel != 0){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			}
			
			return Utils.hideFlags(item, 3);
		}
	}


	public static class KitInv {
		
		private Inventory inventory;
		private KitPvPKit kitpvpkit;
		private int level;
		
		public KitInv(KitPvPKit kit, int level){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§l" + kit.getName() + " (Level " + level + ")");
			this.inventory = inventory;
			this.kitpvpkit = kit;
			this.level = level;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			Kit kit = kitpvpkit.getKit(this.level);
			int items = kit.contentItems();
			
			contents[45] = Utils.setDisplayname(new ItemStack(Material.REDSTONE_BLOCK, 1), "§4§l§o<< Back");
			contents[48] = getItem(omp, 1);
			contents[49] = getItem(omp, 2);
			contents[50] = getItem(omp, 3);
			
			contents[4] = kit.getHelmet();
			contents[13] = kit.getChestplate();
			contents[22] = kit.getLeggings();
			contents[31] = kit.getBoots();
			
			if(level == omp.getKitPvPPlayer().getUnlockedLevel(kitpvpkit) +1){
				ItemStack item = new ItemStack(Material.EMERALD_BLOCK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§2§l§oBuy " + kitpvpkit.getName() + " §7§o(§a§oLvL " + level + "§7§o)");
				List<String> itemlore = new ArrayList<String>();
				if(kitpvpkit.getVIPRank() == null){
					itemlore.add("");
					if(kitpvpkit.getCurrency() == Currency.ORBITMINES_TOKENS){
						itemlore.add("§7Price: §e" + kitpvpkit.getPrice(level) + " OMT");
					}
					else{
						itemlore.add("§7Price: §6" + kitpvpkit.getPrice(level) + " Coins");
					}
					itemlore.add("");
				}
				else{
					if(!omp.hasPerms(kitpvpkit.getVIPRank())){
						itemmeta.setDisplayName("§7Required: " + kitpvpkit.getVIPRank().getRankString() + " §lVIP");
					}
					else{
						item = null;
					}
				}
				
				if(item != null){
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					contents[53] = item;
				}
			}
			
			if(items == 7 || items == 8){
				contents[2] = getItem(omp, kit.getItem(0));
				contents[6] = getItem(omp, kit.getItem(1));
				contents[11] = getItem(omp, kit.getItem(2));
				contents[15] = getItem(omp, kit.getItem(3));
				contents[20] = getItem(omp, kit.getItem(4));
				contents[24] = getItem(omp, kit.getItem(5));
				contents[29] = getItem(omp, kit.getItem(6));
				
				if(items == 8){
					contents[33] = getItem(omp, kit.getItem(7));
				}
			}
			else{
				if(items >= 1){
					contents[11] = getItem(omp, kit.getItem(0));
				}
				if(items >= 2){
					contents[15] = getItem(omp, kit.getItem(1));
				}
				if(items >= 3){
					contents[20] = getItem(omp, kit.getItem(2));
				}
				if(items >= 4){
					contents[24] = getItem(omp, kit.getItem(3));
				}
				if(items >= 5){
					contents[29] = getItem(omp, kit.getItem(4));
				}
				if(items == 6){
					contents[33] = getItem(omp, kit.getItem(5));
				}
			}
			
			PotionEffect effect = kit.getPotionEffect();
			if(effect != null){
				ItemStack item = getItem(omp, effect.getType(), effect.getAmplifier() +1);
				contents[18] = item;
				contents[26] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, PotionEffectType type, int level){
			String levelname = "";
			for(int i = 0; i < level; i++){
				levelname += "I";
			}
			levelname.replace("IIIIIII", "VII");
			levelname.replace("IIIIII", "VI");
			levelname.replace("IIIII", "V");
			levelname.replace("IIII", "IV");
			
			ItemStack item = new ItemStack(Material.POTION);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§b§l§o" + Utils.getPotionName(type) + " " + levelname);
			item.setItemMeta(meta);
			
			return item;
		}
		
		private ItemStack getItem(OMPlayer omp, ItemStack item){
			if(item != null && item.getType() == Material.ARROW){
				ItemMeta meta = item.getItemMeta();
				List<String> itemlore = new ArrayList<String>();
				itemlore.add(" §c+1 Arrow: §6Every " + kitpvpkit.getNextArrow() + " seconds");
				itemlore.add(" §cMaximum: §6" + item.getAmount() + " Arrows");
				meta.setLore(itemlore);
				item.setItemMeta(meta);
			}
			
			return item;
		}
		
		private ItemStack getItem(OMPlayer omp, int level){
			if(kitpvpkit.getHighestLevel() >= level){
				return Utils.setDisplayname(new ItemStack(Material.NETHER_STAR, level), "§b§l" + kitpvpkit.getName() + " §7§o(§a§oLvL " + level + "§7§o)");
			}
			return Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.INK_SACK, level), "§4§l§oUnavailable"), 1);
		}
	}

	public static class MasteryInv {
		
		private Inventory inventory;
		
		public MasteryInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lMasteries");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			KitPvPPlayer kp = omp.getKitPvPPlayer();
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[1] = getUpgradeItem(kp, Mastery.MELEE);
			contents[3] = getUpgradeItem(kp, Mastery.MELEE_PROTECTION);
			contents[5] = getUpgradeItem(kp, Mastery.RANGE);
			contents[7] = getUpgradeItem(kp, Mastery.RANGE_PROTECTION);
			
			contents[19] = getItem(kp, Mastery.MELEE);
			contents[21] = getItem(kp, Mastery.MELEE_PROTECTION);
			contents[23] = getItem(kp, Mastery.RANGE);
			contents[25] = getItem(kp, Mastery.RANGE_PROTECTION);
			
			contents[37] = getDowngradeItem(kp, Mastery.MELEE);
			contents[39] = getDowngradeItem(kp, Mastery.MELEE_PROTECTION);
			contents[41] = getDowngradeItem(kp, Mastery.RANGE);
			contents[43] = getDowngradeItem(kp, Mastery.RANGE_PROTECTION);
			
			{
				int points = kp.getMasteries().getPoints();
				ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Mastery Points: §c" + points);
				item.setItemMeta(meta);
				if(points > 64){
					item.setAmount(64);
				}
				else{
					item.setAmount(points);
				}
				contents[49] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(KitPvPPlayer kp, Mastery mastery){
			Masteries masteries = kp.getMasteries();
			
			ItemStack item = new ItemStack(mastery.getMaterial(), masteries.getMasteryLevel(mastery));
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(mastery.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add(" §7Level: §c" + masteries.getMasteryLevel(mastery));
			itemlore.add(" §7Effect: §c" + (int) ((masteries.getMasteryEffect(mastery) +1) * 100) + "% " + mastery.getEffectName());
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item = Utils.hideFlags(item, 2);
			
			return item;
		}
		
		private ItemStack getUpgradeItem(KitPvPPlayer kp, Mastery mastery){
			Masteries masteries = kp.getMasteries();
			
			if(masteries.getPoints() > 0){
				int nextlevel = masteries.getMasteryLevel(mastery) +1;
				if(nextlevel > 64){
					nextlevel = 64;
				}
				
				ItemStack item = new ItemStack(Material.EMERALD, nextlevel);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(mastery.getColor() + (int) (mastery.getMultiplier() * 100) + "% " + mastery.getEffectName());
				List<String> itemlore = new ArrayList<String>();
				itemlore.add(" §7Price: §c§l1 Mastery Point");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);			
				
				return item;
			}
			return null;
		}
		
		private ItemStack getDowngradeItem(KitPvPPlayer kp, Mastery mastery){
			Masteries masteries = kp.getMasteries();
			
			if(masteries.getMasteryLevel(mastery) > 0){
				int nextlevel = masteries.getMasteryLevel(mastery) -1;
				if(nextlevel > 64){
					nextlevel = 64;
				}
				
				ItemStack item = new ItemStack(Material.BLAZE_POWDER, nextlevel);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(mastery.getOpositeColor() + (int) (mastery.getMultiplier() * 100) + "% " + mastery.getEffectName());
				List<String> itemlore = new ArrayList<String>();
				itemlore.add(" §7Price: §b§l20 VIP Points");
				itemlore.add(" §7(+ 1 Mastery Point)");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);			
				
				return item;
			}
			return null;
		}
	}
}