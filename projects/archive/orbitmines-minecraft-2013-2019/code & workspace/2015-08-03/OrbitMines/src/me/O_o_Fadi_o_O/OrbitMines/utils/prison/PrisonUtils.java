package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PrisonUtils {

	public static ItemStack[] applyFortune(ItemStack inhand, ItemStack toadd){
		if(inhand != null && (inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.DIAMOND_PICKAXE) && (toadd.getType() == Material.IRON_INGOT || toadd.getType() == Material.GOLD_INGOT || toadd.getType() == Material.DIAMOND || toadd.getType() == Material.EMERALD || toadd.getType() == Material.COAL || toadd.getType() == Material.QUARTZ || toadd.getType() == Material.INK_SACK && toadd.getDurability() == 4 || toadd.getType() == Material.REDSTONE) && inhand.getEnchantments() != null && inhand.getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)){
			int level = inhand.getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS);
			int r = new Random().nextInt(level +2);
			
			int multiplier = 2;
			for(int i = 0; i < level; i++){
				if(r == i){
					int amount = toadd.getAmount() * multiplier;
					int itemsleft = amount % toadd.getType().getMaxStackSize();
					
					if(itemsleft != amount){
						int stacks = (amount - itemsleft) / toadd.getType().getMaxStackSize();
						
						ItemStack[] items = new ItemStack[stacks +1];
						
						for(int i2 = 0; i2 < stacks; i2++){
							ItemStack item = new ItemStack(toadd);
							item.setAmount(item.getType().getMaxStackSize());
							items[i2] = item;
						}
						
						toadd.setAmount(itemsleft);
						items[stacks] = toadd;
						
						return items;
					}
					else{
						ItemStack[] items = new ItemStack[1];
						toadd.setAmount(amount);
						items[0] = toadd;
						
						return items;
					}
				}
				
				multiplier++;
			}
		}
		
		ItemStack[] items = new ItemStack[1];
		items[0] = toadd;
		
		return items;
	}
	
	public static void reduceDurability(OMPlayer omp, ItemStack item){
		if(item != null && (item.getType() == Material.WOOD_PICKAXE || item.getType() == Material.STONE_PICKAXE || item.getType() == Material.GOLD_PICKAXE || item.getType() == Material.IRON_PICKAXE || item.getType() == Material.DIAMOND_PICKAXE)){
			boolean reduce = true;
			if(item.getEnchantments() != null && item.getEnchantments().containsKey(Enchantment.DURABILITY)){
				int level = item.getEnchantments().get(Enchantment.DURABILITY);
				int r = new Random().nextInt(100);
				
				reduce = r < (100 / (level +1));
			}
			
			if(reduce){
				if(item.getDurability() == item.getType().getMaxDurability()){
					omp.getPlayer().getInventory().setItem(omp.getPlayer().getInventory().getHeldItemSlot(), null);
					omp.getPlayer().playSound(omp.getPlayer().getLocation(), Sound.ITEM_BREAK, 5, 1);
				}
				else{
					item.setDurability((short) (item.getDurability() +1));
				}
				
				omp.updateInventory();
			}
		}
	}
	
	public static int getReward(Material material){
		switch(material){
			case LOG:
				return 5;
			case WOOD:
				return 1;
			case COBBLESTONE:
				return 2;
			case SMOOTH_BRICK:
				return 7;
			case COAL:
				return 10;
			case COAL_BLOCK:
				return 90;
			case IRON_INGOT:
				return 25;
			case IRON_BLOCK:
				return 225;
			case DIAMOND:
				return 100;
			case DIAMOND_BLOCK:
				return 900;
			case EMERALD:
				return 200;
			case EMERALD_BLOCK:
				return 1800;
			case REDSTONE:
				return 35;
			case REDSTONE_BLOCK:
				return 315;
			case INK_SACK:
				return 50;
			case LAPIS_BLOCK:
				return 450;
			case GOLD_INGOT:
				return 400;
			case GOLD_BLOCK:
				return 3600;
			default:
				return 0;
		}
	}
	
	public static String getDisplayname(Material material, int amount){
		String s = "";
		if(amount > 1){
			s = "s";
		}
		
		switch(material){
			case LOG:
				if(amount > 1){s = "s";}
				return "§e" + amount + " Oak Log" + s;
			case WOOD:
				if(amount > 1){s = "s";}
				return "§e" + amount + " Oak Plank" + s;
			case COBBLESTONE:
				return "§7" + amount + " Cobblestone";
			case SMOOTH_BRICK:
				return "§7" + amount + " Stone Brick" + s;
			case COAL:
				return "§8" + amount + " Coal";
			case COAL_BLOCK:
				return "§8" + amount + " Coal Block" + s;
			case IRON_INGOT:
				return "§7" + amount + " Iron Ingot" + s;
			case IRON_BLOCK:
				return "§7" + amount + " Iron Block" + s;
			case DIAMOND:
				return "§b" + amount + " Diamond" + s;
			case DIAMOND_BLOCK:
				return "§b" + amount + " Diamond Block" + s;
			case EMERALD:
				return "§a" + amount + " Emerald" + s;
			case EMERALD_BLOCK:
				return "§a" + amount + " Emerald Block" + s;
			case REDSTONE:
				return "§c" + amount + " Redstone";
			case REDSTONE_BLOCK:
				return "§c" + amount + " Redstone Block" + s;
			case INK_SACK:
				return "§1" + amount + " Lapis Lazuli";
			case LAPIS_BLOCK:
				return "§1" + amount + " Lapis Lazuli Block" + s;
			case GOLD_INGOT:
				return "§6" + amount + " Gold Ingot" + s;
			case GOLD_BLOCK:
				return "§6" + amount + " Gold Block" + s;
			default:
				return null;
		}
	}
	
	public static Material getFirstMaterial(Material material){
		switch(material){
			case WOOD:
				return Material.LOG;
			case SMOOTH_BRICK:
				return Material.COBBLESTONE;
			case COAL_BLOCK:
				return Material.COAL;
			case IRON_BLOCK:
				return Material.IRON_INGOT;
			case DIAMOND_BLOCK:
				return Material.DIAMOND;
			case EMERALD_BLOCK:
				return Material.EMERALD;
			case REDSTONE_BLOCK:
				return Material.REDSTONE;
			case LAPIS_BLOCK:
				return Material.INK_SACK;
			case GOLD_BLOCK:
				return Material.GOLD_INGOT;
			default:
				return null;
		}
	}
	
	public static Material getSecondMaterial(Material material){
		switch(material){
			case LOG:
				return Material.WOOD;
			case COBBLESTONE:
				return Material.SMOOTH_BRICK;
			case COAL:
				return Material.COAL_BLOCK;
			case IRON_INGOT:
				return Material.IRON_BLOCK;
			case DIAMOND:
				return Material.DIAMOND_BLOCK;
			case EMERALD:
				return Material.EMERALD_BLOCK;
			case REDSTONE:
				return Material.REDSTONE_BLOCK;
			case INK_SACK:
				return Material.LAPIS_BLOCK;
			case GOLD_INGOT:
				return Material.GOLD_BLOCK;
			default:
				return null;
		}
	}
	
	public static short getDurability(Material material){
		switch(material){
			case INK_SACK:
				return 4;
			default:
				return 0;
		}
	}
	
	public static enum Rank {

		Z(0),
		Y(1);
		
		Rank(int rankid){}
		
		public int getRankupPrice(){
			switch(this){
				case Y:
					return 200000;
				case Z:
					return 10000;
			}
			return 0;
		}
		
		public Rank getNextRank(){
			return fromID(ordinal() +1);
		}
		
		public static Rank fromID(int rankid){
			for(Rank rank : Rank.values()){
				if(rank.ordinal() == rankid){
					return rank;
				}
			}
			return null;
		}
	}
	
	public static enum MineType {
		
		NORMAL,
		WOOD;
		
	}
	
	public enum GambleType {
		
		IRON_MACHINE,
		GOLD_MACHINE,
		DIAMOND_MACHINE;
		
	}
	
	public enum Rarity {
		
		COMMON,
		RARE,
		LEGENDARY;
		
		public String getName(){
			switch(this){
				case COMMON:
					return "§a§lCommon";
				case LEGENDARY:
					return "§c§lLegendary";
				case RARE:
					return "§6§lRare";
				default:
					return null;
			}
		}
		
		public String getColor(){
			switch(this){
				case COMMON:
					return "§a";
				case LEGENDARY:
					return "§c";
				case RARE:
					return "§6";
				default:
					return null;
			}
		}
		
		public int getAmount(){
			switch(this){
				case COMMON:
					return 15;
				case LEGENDARY:
					return 1;
				case RARE:
					return 5;
				default:
					return 0;
			}
		}
	}
	
	public enum GambleTicketType {

		GOLD_100(0),
		GOLD_2500(1),
		GOLD_5000(2),
		GOLD_10000(3),
		GOLD_20000(4),
		GOLD_30000(5),
		GOLD_50000(6),
		GOLD_75000(7),
		GOLD_100000(8),
		
		GAMBLE_TICKET_1(9),
		GAMBLE_TICKET_2(10),
		GAMBLE_TICKET_3(11),
		GAMBLE_TICKET_4(12),
		GAMBLE_TICKET_5(13),
		
		// Efficiency, Unbreaking, Fortune \\
		PICKAXE_IRON_4_0_4(14),
		PICKAXE_IRON_5_0_5(15),
		PICKAXE_IRON_5_1_2(16),
		PICKAXE_IRON_4_4_4(17),
		PICKAXE_IRON_5_5_5(18),
		PICKAXE_IRON_6_6_6(19),
		PICKAXE_IRON_7_7_7(20),
		PICKAXE_IRON_8_8_8(21),
		PICKAXE_DIAMOND_2_2_2(22),
		PICKAXE_DIAMOND_3_3_3(23),
		PICKAXE_DIAMOND_4_4_4(24),
		PICKAXE_DIAMOND_5_5_5(25),
		PICKAXE_DIAMOND_4_2_4(26);
		
		GambleTicketType(int ticketid){}
		
		public String getName(){
			switch(this){
				case GAMBLE_TICKET_1:
					return "1 Gamble Ticket";
				case GAMBLE_TICKET_2:
					return "2 Gamble Tickets";
				case GAMBLE_TICKET_3:
					return "3 Gamble Tickets";
				case GAMBLE_TICKET_4:
					return "4 Gamble Tickets";
				case GAMBLE_TICKET_5:
					return "5 Gamble Tickets";
				case GOLD_100:
					return "100 Gold";
				case GOLD_10000:
					return "10000 Gold";
				case GOLD_100000:
					return "100000 Gold";
				case GOLD_20000:
					return "20000 Gold";
				case GOLD_2500:
					return "2500 Gold";
				case GOLD_30000:
					return "30000 Gold";
				case GOLD_5000:
					return "5000 Gold";
				case GOLD_50000:
					return "50000 Gold";
				case GOLD_75000:
					return "75000 Gold";
				case PICKAXE_DIAMOND_2_2_2:
					return "Diamond Pickaxe";
				case PICKAXE_DIAMOND_3_3_3:
					return "Diamond Pickaxe";
				case PICKAXE_DIAMOND_4_2_4:
					return "Diamond Pickaxe";
				case PICKAXE_DIAMOND_4_4_4:
					return "Diamond Pickaxe";
				case PICKAXE_DIAMOND_5_5_5:
					return "Diamond Pickaxe";
				case PICKAXE_IRON_4_0_4:
					return "Iron Pickaxe";
				case PICKAXE_IRON_4_4_4:
					return "Iron Pickaxe";
				case PICKAXE_IRON_5_0_5:
					return "Iron Pickaxe";
				case PICKAXE_IRON_5_1_2:
					return "Iron Pickaxe";
				case PICKAXE_IRON_5_5_5:
					return "Iron Pickaxe";
				case PICKAXE_IRON_6_6_6:
					return "Iron Pickaxe";
				case PICKAXE_IRON_7_7_7:
					return "Iron Pickaxe";
				case PICKAXE_IRON_8_8_8:
					return "Iron Pickaxe";
			}
			return null;
		}
		
		public Rarity getRarity(GambleType type){
			switch(this){
				case GAMBLE_TICKET_1:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case GAMBLE_TICKET_2:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case GAMBLE_TICKET_3:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return null;
					}
				case GAMBLE_TICKET_4:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.COMMON;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return null;
					}
				case GAMBLE_TICKET_5:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.COMMON;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return null;
					}
				case GOLD_100:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case GOLD_10000:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case GOLD_100000:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.LEGENDARY;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return null;
					}
				case GOLD_20000:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.RARE;
					}
				case GOLD_2500:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case GOLD_30000:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.COMMON;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.LEGENDARY;
					}
				case GOLD_5000:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case GOLD_50000:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.COMMON;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return null;
					}
				case GOLD_75000:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.RARE;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return null;
					}
				case PICKAXE_DIAMOND_2_2_2:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case PICKAXE_DIAMOND_3_3_3:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case PICKAXE_DIAMOND_4_2_4:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.RARE;
					}
				case PICKAXE_DIAMOND_4_4_4:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.COMMON;
						case GOLD_MACHINE:
							return Rarity.RARE;
						case IRON_MACHINE:
							return Rarity.LEGENDARY;
					}
				case PICKAXE_DIAMOND_5_5_5:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.RARE;
						case GOLD_MACHINE:
							return Rarity.LEGENDARY;
						case IRON_MACHINE:
							return null;
					}
				case PICKAXE_IRON_4_0_4:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return Rarity.COMMON;
					}
				case PICKAXE_IRON_4_4_4:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.RARE;
					}
				case PICKAXE_IRON_5_0_5:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.RARE;
					}
				case PICKAXE_IRON_5_1_2:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.COMMON;
						case IRON_MACHINE:
							return Rarity.RARE;
					}
				case PICKAXE_IRON_5_5_5:
					switch(type){
						case DIAMOND_MACHINE:
							return null;
						case GOLD_MACHINE:
							return Rarity.RARE;
						case IRON_MACHINE:
							return Rarity.LEGENDARY;
					}
				case PICKAXE_IRON_6_6_6:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.COMMON;
						case GOLD_MACHINE:
							return Rarity.RARE;
						case IRON_MACHINE:
							return null;
					}
				case PICKAXE_IRON_7_7_7:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.RARE;
						case GOLD_MACHINE:
							return Rarity.LEGENDARY;
						case IRON_MACHINE:
							return null;
					}
				case PICKAXE_IRON_8_8_8:
					switch(type){
						case DIAMOND_MACHINE:
							return Rarity.LEGENDARY;
						case GOLD_MACHINE:
							return null;
						case IRON_MACHINE:
							return null;
					}
			}
			return null;
		}
		
		public ItemStack getItemStack(){
			switch(this){
				case GAMBLE_TICKET_1:
					return new ItemStack(Material.EMERALD, 1);
				case GAMBLE_TICKET_2:
					return new ItemStack(Material.EMERALD, 2);
				case GAMBLE_TICKET_3:
					return new ItemStack(Material.EMERALD, 3);
				case GAMBLE_TICKET_4:
					return new ItemStack(Material.EMERALD, 4);
				case GAMBLE_TICKET_5:
					return new ItemStack(Material.EMERALD, 5);
				case GOLD_100:
					return new ItemStack(Material.GOLD_INGOT, 1);
				case GOLD_10000:
					return new ItemStack(Material.GOLD_INGOT, 1);
				case GOLD_100000:
					return new ItemStack(Material.GOLD_BLOCK, 1);
				case GOLD_20000:
					return new ItemStack(Material.GOLD_INGOT, 1);
				case GOLD_2500:
					return new ItemStack(Material.GOLD_INGOT, 1);
				case GOLD_30000:
					return new ItemStack(Material.GOLD_BLOCK, 1);
				case GOLD_5000:
					return new ItemStack(Material.GOLD_INGOT, 1);
				case GOLD_50000:
					return new ItemStack(Material.GOLD_BLOCK, 1);
				case GOLD_75000:
					return new ItemStack(Material.GOLD_BLOCK, 1);
				case PICKAXE_DIAMOND_2_2_2:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE, 1), Enchantment.DIG_SPEED, 2), Enchantment.DURABILITY, 2), Enchantment.LOOT_BONUS_BLOCKS, 2);
				case PICKAXE_DIAMOND_3_3_3:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE, 1), Enchantment.DIG_SPEED, 3), Enchantment.DURABILITY, 3), Enchantment.LOOT_BONUS_BLOCKS, 3);
				case PICKAXE_DIAMOND_4_2_4:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE, 1), Enchantment.DIG_SPEED, 4), Enchantment.DURABILITY, 2), Enchantment.LOOT_BONUS_BLOCKS, 4);
				case PICKAXE_DIAMOND_4_4_4:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE, 1), Enchantment.DIG_SPEED, 4), Enchantment.DURABILITY, 4), Enchantment.LOOT_BONUS_BLOCKS, 4);
				case PICKAXE_DIAMOND_5_5_5:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE, 1), Enchantment.DIG_SPEED, 5), Enchantment.DURABILITY, 5), Enchantment.LOOT_BONUS_BLOCKS, 5);
				case PICKAXE_IRON_4_0_4:
					return Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 4), Enchantment.LOOT_BONUS_BLOCKS, 4);
				case PICKAXE_IRON_4_4_4:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 4), Enchantment.DURABILITY, 4), Enchantment.LOOT_BONUS_BLOCKS, 4);
				case PICKAXE_IRON_5_0_5:
					return Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 5), Enchantment.LOOT_BONUS_BLOCKS, 5);
				case PICKAXE_IRON_5_1_2:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 5), Enchantment.DURABILITY, 1), Enchantment.LOOT_BONUS_BLOCKS, 2);
				case PICKAXE_IRON_5_5_5:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 5), Enchantment.DURABILITY, 5), Enchantment.LOOT_BONUS_BLOCKS, 5);
				case PICKAXE_IRON_6_6_6:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 6), Enchantment.DURABILITY, 6), Enchantment.LOOT_BONUS_BLOCKS, 6);
				case PICKAXE_IRON_7_7_7:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 7), Enchantment.DURABILITY, 7), Enchantment.LOOT_BONUS_BLOCKS, 7);
				case PICKAXE_IRON_8_8_8:
					return Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(new ItemStack(Material.IRON_PICKAXE, 1), Enchantment.DIG_SPEED, 8), Enchantment.DURABILITY, 8), Enchantment.LOOT_BONUS_BLOCKS, 8);
			}
			return null;
		}
		
		public void giveReward(PrisonPlayer pp){
			switch(this){
				case GAMBLE_TICKET_1:
					pp.addGambleTickets(1);
					break;
				case GAMBLE_TICKET_2:
					pp.addGambleTickets(2);
					break;
				case GAMBLE_TICKET_3:
					pp.addGambleTickets(3);
					break;
				case GAMBLE_TICKET_4:
					pp.addGambleTickets(4);
					break;
				case GAMBLE_TICKET_5:
					pp.addGambleTickets(5);
					break;
				case GOLD_100:
					pp.addGold(100);
					break;
				case GOLD_10000:
					pp.addGold(10000);
					break;
				case GOLD_100000:
					pp.addGold(100000);
					break;
				case GOLD_20000:
					pp.addGold(20000);
					break;
				case GOLD_2500:
					pp.addGold(2500);
					break;
				case GOLD_30000:
					pp.addGold(30000);
					break;
				case GOLD_5000:
					pp.addGold(5000);
					break;
				case GOLD_50000:
					pp.addGold(50000);
					break;
				case GOLD_75000:
					pp.addGold(75000);
					break;
				case PICKAXE_DIAMOND_2_2_2:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.DIAMOND_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 2), Enchantment.DURABILITY, 2), Enchantment.LOOT_BONUS_BLOCKS, 2));
					break;
				case PICKAXE_DIAMOND_3_3_3:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.DIAMOND_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 3), Enchantment.DURABILITY, 3), Enchantment.LOOT_BONUS_BLOCKS, 3));
					break;
				case PICKAXE_DIAMOND_4_2_4:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.DIAMOND_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 4), Enchantment.DURABILITY, 2), Enchantment.LOOT_BONUS_BLOCKS, 4));
					break;
				case PICKAXE_DIAMOND_4_4_4:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.DIAMOND_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 4), Enchantment.DURABILITY, 4), Enchantment.LOOT_BONUS_BLOCKS, 4));
					break;
				case PICKAXE_DIAMOND_5_5_5:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.DIAMOND_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 5), Enchantment.DURABILITY, 5), Enchantment.LOOT_BONUS_BLOCKS, 5));
					break;
				case PICKAXE_IRON_4_0_4:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 4), Enchantment.LOOT_BONUS_BLOCKS, 4));
					break;
				case PICKAXE_IRON_4_4_4:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 4), Enchantment.DURABILITY, 4), Enchantment.LOOT_BONUS_BLOCKS, 4));
					break;
				case PICKAXE_IRON_5_0_5:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 5), Enchantment.LOOT_BONUS_BLOCKS, 5));
					break;
				case PICKAXE_IRON_5_1_2:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 5), Enchantment.DURABILITY, 1), Enchantment.LOOT_BONUS_BLOCKS, 2));
					break;
				case PICKAXE_IRON_5_5_5:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 5), Enchantment.DURABILITY, 5), Enchantment.LOOT_BONUS_BLOCKS, 5));
					break;
				case PICKAXE_IRON_6_6_6:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 6), Enchantment.DURABILITY, 6), Enchantment.LOOT_BONUS_BLOCKS, 6));
					break;
				case PICKAXE_IRON_7_7_7:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 7), Enchantment.DURABILITY, 7), Enchantment.LOOT_BONUS_BLOCKS, 7));
					break;
				case PICKAXE_IRON_8_8_8:
					pp.getPlayer().getInventory().addItem(Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(new ItemStack(Material.IRON_PICKAXE, 1), Arrays.asList("§2Villager Gamble")), Enchantment.DIG_SPEED, 8), Enchantment.DURABILITY, 8), Enchantment.LOOT_BONUS_BLOCKS, 8));
					break;
			}
		}
		
		public static GambleTicketType getTicket(ItemStack item, GambleType type){
			String name = item.getItemMeta().getDisplayName();
			
			for(GambleTicketType gtype : getMachine(type)){
				if((gtype.getRarity(type).getColor() + gtype.getName()).equals(name)){
					return gtype;
				}
			}
			return null;
		}
		
		public static ItemStack getRandom(GambleType gtype){
			List<GambleTicketType> tickets = new ArrayList<GambleTicketType>();
			for(GambleTicketType type : getMachine(gtype)){
				for(int i = 0; i < type.getRarity(gtype).getAmount(); i++){
					tickets.add(type);
				}
			}
			
			GambleTicketType type = tickets.get(new Random().nextInt(tickets.size()));
			
			ItemStack item = type.getItemStack();
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(type.getRarity(gtype).getColor() + type.getName());
			item.setItemMeta(meta);
			
			return Utils.hideFlags(item, 34);
		}
		
		public static List<GambleTicketType> getMachine(GambleType type){
			List<GambleTicketType> tickets = new ArrayList<GambleTicketType>();
			
			for(GambleTicketType gtype : GambleTicketType.values()){
				if(gtype.getRarity(type) != null){
					tickets.add(gtype);
				}
			}
			return tickets;
		}
		
		public static GambleTicketType fromID(int ticketid){
			for(GambleTicketType type : GambleTicketType.values()){
				if(type.ordinal() == ticketid){
					return type;
				}
			}
			return null;
		}
	}

}
