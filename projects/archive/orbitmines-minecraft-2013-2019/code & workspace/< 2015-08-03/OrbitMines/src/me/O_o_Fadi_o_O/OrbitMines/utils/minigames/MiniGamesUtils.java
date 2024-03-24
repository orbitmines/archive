package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class MiniGamesUtils {

	public enum InvType {
		
		KITS,
		PERKS;
		
	}
	
	public enum Uses {
		
		ONE_TIME,
		PERMANENT;
		
		public String getName(){
			switch(this){
				case ONE_TIME:
					return "One time use.";
				case PERMANENT:
					return "Permanent";
			}
			return null;
		}
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
		
		public int getRefund(){
			switch(this){
				case COMMON:
					return 25;
				case LEGENDARY:
					return 100;
				case RARE:
					return 50;
			}
			return 0;
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
					return 25;
				case LEGENDARY:
					return 1;
				case RARE:
					return 5;
				default:
					return 0;
			}
		}
	}
	
	public enum TicketType {
		
		// SG Kits \\
		RUNNER_KIT(0),
		FIGHTER_KIT(1),
		WARRIOR_KIT(2),
		BOMBER_KIT(3),
		ARCHER_KIT(4),
		
		// SG Game Effects \\
		WHITE_ARMOR(5),
		BLUE_ARMOR(6),
		GREEN_ARMOR(7),
		BLACK_ARMOR(8),
		LIGHT_BLUE_ARMOR(9),
		PINK_ARMOR(10),
		LIGHT_GREEN_ARMOR(11),
		DARK_BLUE_ARMOR(12),
		PURPLE_ARMOR(13),
		ORANGE_ARMOR(14),
		RED_ARMOR(15),
		CYAN_ARMOR(16),
		YELLOW_ARMOR(17),
		GRAY_ARMOR(18),
		ENABLE_POTIONS(19),
		DOUBLE_LOOT(20),
		ENABLE_POTIONS_PLAYER(21),
		DOUBLE_LOOT_PLAYER(22),
		
		// UHC Kits \\
		SURVIVOR_KIT(23),
		STARTER_KIT(24),
		APPLETREE_KIT(25),
		SPEEDSTER_KIT(26),
		MINER_KIT(27),
		
		// UHC Game Effects \\
		DOUBLE_IRON(28),
		DOUBLE_IRON_PLAYER(29),
		GOLD_FROM_LAPIS(30),
		GOLD_FROM_REDSTONE(31),
		
		// Skywars Kits \\
		TANK_KIT(32),
		SNOWGOLEM_KIT(33),
		CREEPER_KIT(34),
		ENCHANTER_KIT(35),
		ENDERMAN_KIT(36),
		
		// Skywars Perks \\
		THE_WOOL_HUT_CAGE(37),
		NETHER_CAGE(38),
		DEATH_CAGE(39),
		CAVE_CAGE(40),
		SUN_CAGE(41),
		HOT_AIR_BALLOON_CAGE(42),
		MESA_CAGE(43),
		SEA_CAGE(44),
		WOODEN_CAGE(45),
		CACTUS_CAGE(46),
		ENCHANTER_CAGE(47),
		GRAY_RAINBOW_CAGE(48),
		SLIME_CAGE(49),
		THE_END_CAGE(50),
		
		// Chicken Fight Kits \\
		CHICKEN_MAMA_KIT(51),
		BABY_CHICKEN_KIT(52),
		HOT_WING_KIT(53),
		CHICKEN_WARLORD_KIT(54),
		CHICKEN_KIT(55),
		
		// Chicken Fight Perks \\
		SPEED_BOOST(56),
		JUMP_BOOST(57);
		
		TicketType(int ticketid){}
		
		public String getName(){
			switch(this){
				case ARCHER_KIT:
					return "Archer Kit";
				case BOMBER_KIT:
					return "Bomber Kit";
				case FIGHTER_KIT:
					return "Fighter Kit";
				case RUNNER_KIT:
					return "Runner Kit";
				case WARRIOR_KIT:
					return "Warrior Kit";
				case BLACK_ARMOR:
					return "Black Armor";
				case BLUE_ARMOR:
					return "Blue Armor";
				case CYAN_ARMOR:
					return "Cyan Armor";
				case DARK_BLUE_ARMOR:
					return "Dark Blue Armor";
				case GRAY_ARMOR:
					return "Gray Armor";
				case GREEN_ARMOR:
					return "Green Armor";
				case LIGHT_BLUE_ARMOR:
					return "Light Blue Armor";
				case LIGHT_GREEN_ARMOR:
					return "Light Green Armor";
				case ORANGE_ARMOR:
					return "Orange Armor";
				case PINK_ARMOR:
					return "Pink Armor";
				case PURPLE_ARMOR:
					return "Purple Armor";
				case RED_ARMOR:
					return "Red Armor";
				case WHITE_ARMOR:
					return "White Armor";
				case YELLOW_ARMOR:
					return "Yellow Armor";
				case DOUBLE_LOOT:
					return "Double Loot [All]";
				case DOUBLE_LOOT_PLAYER:
					return "Double Loot [Solo]";
				case ENABLE_POTIONS:
					return "Enable Potions [All]";
				case ENABLE_POTIONS_PLAYER:
					return "Enable Potions [Solo]";
				case APPLETREE_KIT:
					return "Appletree Kit";
				case DOUBLE_IRON:
					return "Double Iron [All]";
				case DOUBLE_IRON_PLAYER:
					return "Double Iron [Solo]";
				case MINER_KIT:
					return "Miner Kit";
				case GOLD_FROM_LAPIS:
					return "Blue Gold [Solo]";
				case GOLD_FROM_REDSTONE:
					return "Red Gold [Solo]";
				case SPEEDSTER_KIT:
					return "Speedster Kit";
				case STARTER_KIT:
					return "Starter Kit";
				case SURVIVOR_KIT:
					return "Survivor Kit";
				case CACTUS_CAGE:
					return "Cactus Cage";
				case CAVE_CAGE:
					return "Cave Cage";
				case CREEPER_KIT:
					return "Creeper Kit";
				case DEATH_CAGE:
					return "Death Cage";
				case ENCHANTER_CAGE:
					return "Enchanter Cage";
				case ENCHANTER_KIT:
					return "Enchanter Kit";
				case ENDERMAN_KIT:
					return "Enderman Kit";
				case GRAY_RAINBOW_CAGE:
					return "Gray Rainbow Cage";
				case HOT_AIR_BALLOON_CAGE:
					return "Hot Air Balloon Cage";
				case MESA_CAGE:
					return "Mesa Cage";
				case NETHER_CAGE:
					return "Nether Cage";
				case SEA_CAGE:
					return "Sea Cage";
				case SLIME_CAGE:
					return "Slime Cage";
				case SNOWGOLEM_KIT:
					return "SnowGolem Kit";
				case SUN_CAGE:
					return "Sun Cage";
				case TANK_KIT:
					return "Tank Kit";
				case THE_END_CAGE:
					return "End Cage";
				case THE_WOOL_HUT_CAGE:
					return "The Wool Hut";
				case WOODEN_CAGE:
					return "Wooden Cage";
				case BABY_CHICKEN_KIT:
					return "Baby Chicken Kit";
				case CHICKEN_KIT:
					return "'Chicken' Kit";
				case CHICKEN_MAMA_KIT:
					return "Chicken Mama Kit";
				case CHICKEN_WARLORD_KIT:
					return "Chicken Warlord Kit";
				case HOT_WING_KIT:
					return "Hot Wing Kit";
				case JUMP_BOOST:
					return "Jump Boost [All]";
				case SPEED_BOOST:
					return "Speed Boost [All]";
			}
			return null;
		}
		
		public String getNameWithGame(){
			switch(this){
				case ARCHER_KIT:
					return "Archer Kit (SG)";
				case BOMBER_KIT:
					return "Bomber Kit (SG)";
				case FIGHTER_KIT:
					return "Fighter Kit (SG)";
				case RUNNER_KIT:
					return "Runner Kit (SG)";
				case WARRIOR_KIT:
					return "Warrior Kit (SG)";
				case BLACK_ARMOR:
					return "Black Armor (SG)";
				case BLUE_ARMOR:
					return "Blue Armor (SG)";
				case CYAN_ARMOR:
					return "Cyan Armor (SG)";
				case DARK_BLUE_ARMOR:
					return "Dark Blue Armor (SG)";
				case GRAY_ARMOR:
					return "Gray Armor (SG)";
				case GREEN_ARMOR:
					return "Green Armor (SG)";
				case LIGHT_BLUE_ARMOR:
					return "Light Blue Armor (SG)";
				case LIGHT_GREEN_ARMOR:
					return "Light Green Armor (SG)";
				case ORANGE_ARMOR:
					return "Orange Armor (SG)";
				case PINK_ARMOR:
					return "Pink Armor (SG)";
				case PURPLE_ARMOR:
					return "Purple Armor (SG)";
				case RED_ARMOR:
					return "Red Armor (SG)";
				case WHITE_ARMOR:
					return "White Armor (SG)";
				case YELLOW_ARMOR:
					return "Yellow Armor (SG)";
				case DOUBLE_LOOT:
					return "Double Loot [All] (SG)";
				case DOUBLE_LOOT_PLAYER:
					return "Double Loot [Solo] (SG)";
				case ENABLE_POTIONS:
					return "Enable Potions [All] (SG)";
				case ENABLE_POTIONS_PLAYER:
					return "Enable Potions [Solo] (SG)";
				case APPLETREE_KIT:
					return "Appletree Kit (UHC)";
				case DOUBLE_IRON:
					return "Double Iron [All] (UHC)";
				case DOUBLE_IRON_PLAYER:
					return "Double Iron [Solo] (UHC)";
				case MINER_KIT:
					return "Miner Kit (UHC)";
				case GOLD_FROM_LAPIS:
					return "Blue Gold [Solo] (UHC)";
				case GOLD_FROM_REDSTONE:
					return "Red Gold [Solo] (UHC)";
				case SPEEDSTER_KIT:
					return "Speedster Kit (UHC)";
				case STARTER_KIT:
					return "Starter Kit (UHC)";
				case SURVIVOR_KIT:
					return "Survivor Kit (UHC)";
				case CACTUS_CAGE:
					return "Cactus Cage (Skywars)";
				case CAVE_CAGE:
					return "Cave Cage (Skywars)";
				case CREEPER_KIT:
					return "Creeper Kit (Skywars)";
				case DEATH_CAGE:
					return "Death Cage (Skywars)";
				case ENCHANTER_CAGE:
					return "Enchanter Cage (Skywars)";
				case ENCHANTER_KIT:
					return "Enchanter Kit (Skywars)";
				case ENDERMAN_KIT:
					return "Enderman Kit (Skywars)";
				case GRAY_RAINBOW_CAGE:
					return "Gray Rainbow Cage (Skywars)";
				case HOT_AIR_BALLOON_CAGE:
					return "Hot Air Balloon Cage (Skywars)";
				case MESA_CAGE:
					return "Mesa Cage (Skywars)";
				case NETHER_CAGE:
					return "Nether Cage (Skywars)";
				case SEA_CAGE:
					return "Sea Cage (Skywars)";
				case SLIME_CAGE:
					return "Slime Cage (Skywars)";
				case SNOWGOLEM_KIT:
					return "SnowGolem Kit (Skywars)";
				case SUN_CAGE:
					return "Sun Cage (Skywars)";
				case TANK_KIT:
					return "Tank Kit (Skywars)";
				case THE_END_CAGE:
					return "End Cage (Skywars)";
				case THE_WOOL_HUT_CAGE:
					return "The Wool Hut (Skywars)";
				case WOODEN_CAGE:
					return "Wooden Cage (Skywars)";
				case BABY_CHICKEN_KIT:
					return "Baby Chicken Kit (CF)";
				case CHICKEN_KIT:
					return "'Chicken' Kit (CF)";
				case CHICKEN_MAMA_KIT:
					return "Chicken Mama Kit (CF)";
				case CHICKEN_WARLORD_KIT:
					return "Chicken Warlord Kit (CF)";
				case HOT_WING_KIT:
					return "Hot Wing Kit (CF)";
				case JUMP_BOOST:
					return "Jump Boost [All] (CF)";
				case SPEED_BOOST:
					return "Speed Boost [All] (CF)";
			}
			return null;
		}
		
		public MiniGameType getGameType(){
			switch(this){
				case ARCHER_KIT:
					return MiniGameType.SURVIVAL_GAMES;
				case BLACK_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case BLUE_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case BOMBER_KIT:
					return MiniGameType.SURVIVAL_GAMES;
				case CYAN_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case DARK_BLUE_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case DOUBLE_LOOT:
					return MiniGameType.SURVIVAL_GAMES;
				case DOUBLE_LOOT_PLAYER:
					return MiniGameType.SURVIVAL_GAMES;
				case ENABLE_POTIONS:
					return MiniGameType.SURVIVAL_GAMES;
				case ENABLE_POTIONS_PLAYER:
					return MiniGameType.SURVIVAL_GAMES;
				case FIGHTER_KIT:
					return MiniGameType.SURVIVAL_GAMES;
				case GRAY_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case GREEN_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case LIGHT_BLUE_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case LIGHT_GREEN_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case ORANGE_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case PINK_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case PURPLE_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case RED_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case RUNNER_KIT:
					return MiniGameType.SURVIVAL_GAMES;
				case WARRIOR_KIT:
					return MiniGameType.SURVIVAL_GAMES;
				case WHITE_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case YELLOW_ARMOR:
					return MiniGameType.SURVIVAL_GAMES;
				case APPLETREE_KIT:
					return MiniGameType.ULTRA_HARD_CORE;
				case DOUBLE_IRON:
					return MiniGameType.ULTRA_HARD_CORE;
				case DOUBLE_IRON_PLAYER:
					return MiniGameType.ULTRA_HARD_CORE;
				case MINER_KIT:
					return MiniGameType.ULTRA_HARD_CORE;
				case GOLD_FROM_LAPIS:
					return MiniGameType.ULTRA_HARD_CORE;
				case GOLD_FROM_REDSTONE:
					return MiniGameType.ULTRA_HARD_CORE;
				case SPEEDSTER_KIT:
					return MiniGameType.ULTRA_HARD_CORE;
				case STARTER_KIT:
					return MiniGameType.ULTRA_HARD_CORE;
				case SURVIVOR_KIT:
					return MiniGameType.ULTRA_HARD_CORE;
				case CACTUS_CAGE:
					return MiniGameType.SKYWARS;
				case CAVE_CAGE:
					return MiniGameType.SKYWARS;
				case CREEPER_KIT:
					return MiniGameType.SKYWARS;
				case DEATH_CAGE:
					return MiniGameType.SKYWARS;
				case ENCHANTER_CAGE:
					return MiniGameType.SKYWARS;
				case ENCHANTER_KIT:
					return MiniGameType.SKYWARS;
				case ENDERMAN_KIT:
					return MiniGameType.SKYWARS;
				case GRAY_RAINBOW_CAGE:
					return MiniGameType.SKYWARS;
				case HOT_AIR_BALLOON_CAGE:
					return MiniGameType.SKYWARS;
				case MESA_CAGE:
					return MiniGameType.SKYWARS;
				case NETHER_CAGE:
					return MiniGameType.SKYWARS;
				case SEA_CAGE:
					return MiniGameType.SKYWARS;
				case SLIME_CAGE:
					return MiniGameType.SKYWARS;
				case SNOWGOLEM_KIT:
					return MiniGameType.SKYWARS;
				case SUN_CAGE:
					return MiniGameType.SKYWARS;
				case TANK_KIT:
					return MiniGameType.SKYWARS;
				case THE_END_CAGE:
					return MiniGameType.SKYWARS;
				case THE_WOOL_HUT_CAGE:
					return MiniGameType.SKYWARS;
				case WOODEN_CAGE:
					return MiniGameType.SKYWARS;
				case BABY_CHICKEN_KIT:
					return MiniGameType.CHICKEN_FIGHT;
				case CHICKEN_KIT:
					return MiniGameType.CHICKEN_FIGHT;
				case CHICKEN_MAMA_KIT:
					return MiniGameType.CHICKEN_FIGHT;
				case CHICKEN_WARLORD_KIT:
					return MiniGameType.CHICKEN_FIGHT;
				case HOT_WING_KIT:
					return MiniGameType.CHICKEN_FIGHT;
				case JUMP_BOOST:
					return MiniGameType.CHICKEN_FIGHT;
				case SPEED_BOOST:
					return MiniGameType.CHICKEN_FIGHT;
			}
			return null;
		}
		
		public Rarity getRarity(){
			switch(this){
				case ARCHER_KIT:
					return Rarity.RARE;
				case BLACK_ARMOR:
					return Rarity.LEGENDARY;
				case BLUE_ARMOR:
					return Rarity.RARE;
				case BOMBER_KIT:
					return Rarity.LEGENDARY;
				case CYAN_ARMOR:
					return Rarity.COMMON;
				case DARK_BLUE_ARMOR:
					return Rarity.COMMON;
				case DOUBLE_LOOT:
					return Rarity.RARE;
				case DOUBLE_LOOT_PLAYER:
					return Rarity.LEGENDARY;
				case ENABLE_POTIONS:
					return Rarity.RARE;
				case ENABLE_POTIONS_PLAYER:
					return Rarity.LEGENDARY;
				case FIGHTER_KIT:
					return Rarity.RARE;
				case GRAY_ARMOR:
					return Rarity.COMMON;
				case GREEN_ARMOR:
					return Rarity.COMMON;
				case LIGHT_BLUE_ARMOR:
					return Rarity.RARE;
				case LIGHT_GREEN_ARMOR:
					return Rarity.RARE;
				case ORANGE_ARMOR:
					return Rarity.COMMON;
				case PINK_ARMOR:
					return Rarity.RARE;
				case PURPLE_ARMOR:
					return Rarity.COMMON;
				case RED_ARMOR:
					return Rarity.LEGENDARY;
				case RUNNER_KIT:
					return Rarity.COMMON;
				case WARRIOR_KIT:
					return Rarity.COMMON;
				case WHITE_ARMOR:
					return Rarity.COMMON;
				case YELLOW_ARMOR:
					return Rarity.RARE;
				case APPLETREE_KIT:
					return Rarity.RARE;
				case DOUBLE_IRON:
					return Rarity.RARE;
				case DOUBLE_IRON_PLAYER:
					return Rarity.RARE;
				case MINER_KIT:
					return Rarity.LEGENDARY;
				case GOLD_FROM_LAPIS:
					return Rarity.RARE;
				case GOLD_FROM_REDSTONE:
					return Rarity.LEGENDARY;
				case SPEEDSTER_KIT:
					return Rarity.RARE;
				case STARTER_KIT:
					return Rarity.COMMON;
				case SURVIVOR_KIT:
					return Rarity.COMMON;
				case CACTUS_CAGE:
					return Rarity.RARE;
				case CAVE_CAGE:
					return Rarity.RARE;
				case CREEPER_KIT:
					return Rarity.RARE;
				case DEATH_CAGE:
					return Rarity.RARE;
				case ENCHANTER_CAGE:
					return Rarity.RARE;
				case ENCHANTER_KIT:
					return Rarity.RARE;
				case ENDERMAN_KIT:
					return Rarity.LEGENDARY;
				case GRAY_RAINBOW_CAGE:
					return Rarity.LEGENDARY;
				case HOT_AIR_BALLOON_CAGE:
					return Rarity.LEGENDARY;
				case MESA_CAGE:
					return Rarity.COMMON;
				case NETHER_CAGE:
					return Rarity.COMMON;
				case SEA_CAGE:
					return Rarity.RARE;
				case SLIME_CAGE:
					return Rarity.RARE;
				case SNOWGOLEM_KIT:
					return Rarity.COMMON;
				case SUN_CAGE:
					return Rarity.RARE;
				case TANK_KIT:
					return Rarity.COMMON;
				case THE_END_CAGE:
					return Rarity.COMMON;
				case THE_WOOL_HUT_CAGE:
					return Rarity.LEGENDARY;
				case WOODEN_CAGE:
					return Rarity.COMMON;
				case BABY_CHICKEN_KIT:
					return Rarity.COMMON;
				case CHICKEN_KIT:
					return Rarity.LEGENDARY;
				case CHICKEN_MAMA_KIT:
					return Rarity.COMMON;
				case CHICKEN_WARLORD_KIT:
					return Rarity.RARE;
				case HOT_WING_KIT:
					return Rarity.RARE;
				case JUMP_BOOST:
					return Rarity.RARE;
				case SPEED_BOOST:
					return Rarity.COMMON;
			}
			return null;
		}
		
		public Uses getUses(){
			switch(this){
				case ARCHER_KIT:
					return Uses.ONE_TIME;
				case BLACK_ARMOR:
					return Uses.PERMANENT;
				case BLUE_ARMOR:
					return Uses.PERMANENT;
				case BOMBER_KIT:
					return Uses.ONE_TIME;
				case CYAN_ARMOR:
					return Uses.PERMANENT;
				case DARK_BLUE_ARMOR:
					return Uses.PERMANENT;
				case DOUBLE_LOOT:
					return Uses.ONE_TIME;
				case DOUBLE_LOOT_PLAYER:
					return Uses.ONE_TIME;
				case ENABLE_POTIONS:
					return Uses.ONE_TIME;
				case ENABLE_POTIONS_PLAYER:
					return Uses.ONE_TIME;
				case FIGHTER_KIT:
					return Uses.ONE_TIME;
				case GRAY_ARMOR:
					return Uses.PERMANENT;
				case GREEN_ARMOR:
					return Uses.PERMANENT;
				case LIGHT_BLUE_ARMOR:
					return Uses.PERMANENT;
				case LIGHT_GREEN_ARMOR:
					return Uses.PERMANENT;
				case ORANGE_ARMOR:
					return Uses.PERMANENT;
				case PINK_ARMOR:
					return Uses.PERMANENT;
				case PURPLE_ARMOR:
					return Uses.PERMANENT;
				case RED_ARMOR:
					return Uses.PERMANENT;
				case RUNNER_KIT:
					return Uses.ONE_TIME;
				case WARRIOR_KIT:
					return Uses.ONE_TIME;
				case WHITE_ARMOR:
					return Uses.PERMANENT;
				case YELLOW_ARMOR:
					return Uses.PERMANENT;
				case APPLETREE_KIT:
					return Uses.ONE_TIME;
				case DOUBLE_IRON:
					return Uses.ONE_TIME;
				case DOUBLE_IRON_PLAYER:
					return Uses.ONE_TIME;
				case GOLD_FROM_LAPIS:
					return Uses.ONE_TIME;
				case GOLD_FROM_REDSTONE:
					return Uses.ONE_TIME;
				case MINER_KIT:
					return Uses.ONE_TIME;
				case SPEEDSTER_KIT:
					return Uses.ONE_TIME;
				case STARTER_KIT:
					return Uses.ONE_TIME;
				case SURVIVOR_KIT:
					return Uses.ONE_TIME;
				case CACTUS_CAGE:
					return Uses.PERMANENT;
				case CAVE_CAGE:
					return Uses.PERMANENT;
				case CREEPER_KIT:
					return Uses.ONE_TIME;
				case DEATH_CAGE:
					return Uses.PERMANENT;
				case ENCHANTER_CAGE:
					return Uses.PERMANENT;
				case ENCHANTER_KIT:
					return Uses.ONE_TIME;
				case ENDERMAN_KIT:
					return Uses.ONE_TIME;
				case GRAY_RAINBOW_CAGE:
					return Uses.PERMANENT;
				case HOT_AIR_BALLOON_CAGE:
					return Uses.PERMANENT;
				case MESA_CAGE:
					return Uses.PERMANENT;
				case NETHER_CAGE:
					return Uses.PERMANENT;
				case SEA_CAGE:
					return Uses.PERMANENT;
				case SLIME_CAGE:
					return Uses.PERMANENT;
				case SNOWGOLEM_KIT:
					return Uses.ONE_TIME;
				case SUN_CAGE:
					return Uses.PERMANENT;
				case TANK_KIT:
					return Uses.ONE_TIME;
				case THE_END_CAGE:
					return Uses.PERMANENT;
				case THE_WOOL_HUT_CAGE:
					return Uses.PERMANENT;
				case WOODEN_CAGE:
					return Uses.PERMANENT;
				case BABY_CHICKEN_KIT:
					return Uses.ONE_TIME;
				case CHICKEN_KIT:
					return Uses.ONE_TIME;
				case CHICKEN_MAMA_KIT:
					return Uses.PERMANENT;
				case CHICKEN_WARLORD_KIT:
					return Uses.ONE_TIME;
				case HOT_WING_KIT:
					return Uses.ONE_TIME;
				case JUMP_BOOST:
					return Uses.ONE_TIME;
				case SPEED_BOOST:
					return Uses.ONE_TIME;
			}
			return null;
		}
		
		public ItemStack getItemStack(){
			switch(this){
				case ARCHER_KIT:
					return new ItemStack(Material.BOW);
				case BLACK_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.BLACK);
				case BLUE_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.BLUE);
				case BOMBER_KIT:
					return new ItemStack(Material.TNT);
				case CYAN_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.TEAL);
				case DARK_BLUE_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.NAVY);
				case DOUBLE_LOOT:
					return new ItemStack(Material.CHEST);
				case DOUBLE_LOOT_PLAYER:
					return new ItemStack(Material.CHEST);
				case ENABLE_POTIONS:
					return new ItemStack(Material.POTION);
				case ENABLE_POTIONS_PLAYER:
					return new ItemStack(Material.POTION);
				case FIGHTER_KIT:
					return new ItemStack(Material.STONE_AXE);
				case GRAY_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.GRAY);
				case GREEN_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.GREEN);
				case LIGHT_BLUE_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.AQUA);
				case LIGHT_GREEN_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.LIME);
				case ORANGE_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.ORANGE);
				case PINK_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.FUCHSIA);
				case PURPLE_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.PURPLE);
				case RED_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.RED);
				case RUNNER_KIT:
					return new ItemStack(Material.LEATHER_BOOTS);
				case WARRIOR_KIT:
					return new ItemStack(Material.IRON_CHESTPLATE);
				case WHITE_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.WHITE);
				case YELLOW_ARMOR:
					return Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.YELLOW);
				case APPLETREE_KIT:
					return new ItemStack(Material.SAPLING);
				case DOUBLE_IRON:
					return new ItemStack(Material.IRON_ORE);
				case DOUBLE_IRON_PLAYER:
					return new ItemStack(Material.IRON_ORE);
				case GOLD_FROM_LAPIS:
					return new ItemStack(Material.LAPIS_ORE);
				case GOLD_FROM_REDSTONE:
					return new ItemStack(Material.REDSTONE_ORE);
				case MINER_KIT:
					return new ItemStack(Material.DIAMOND_PICKAXE);
				case SPEEDSTER_KIT:
					return Utils.hideFlags(Utils.setDurability(new ItemStack(Material.POTION), 8194), 2);
				case STARTER_KIT:
					return new ItemStack(Material.WOOD_AXE);
				case SURVIVOR_KIT:
					return new ItemStack(Material.COOKED_BEEF);
				case CACTUS_CAGE:
					return new ItemStack(Material.CACTUS);
				case CAVE_CAGE:
					return new ItemStack(Material.SMOOTH_BRICK);
				case CREEPER_KIT:
					return new ItemStack(Material.TNT);
				case DEATH_CAGE:
					return Utils.setDurability(new ItemStack(Material.SKULL_ITEM), 1);
				case ENCHANTER_CAGE:
					return new ItemStack(Material.ENCHANTMENT_TABLE);
				case ENCHANTER_KIT:
					return new ItemStack(Material.ENCHANTMENT_TABLE);
				case ENDERMAN_KIT:
					return new ItemStack(Material.ENDER_PEARL);
				case GRAY_RAINBOW_CAGE:
					return Utils.setDurability(new ItemStack(Material.STAINED_GLASS), 7);
				case HOT_AIR_BALLOON_CAGE:
					return new ItemStack(Material.WOOL);
				case MESA_CAGE:
					return new ItemStack(Material.RED_SANDSTONE);
				case NETHER_CAGE:
					return new ItemStack(Material.NETHER_BRICK);
				case SEA_CAGE:
					return new ItemStack(Material.PRISMARINE);
				case SLIME_CAGE:
					return new ItemStack(Material.SLIME_BLOCK);
				case SNOWGOLEM_KIT:
					return new ItemStack(Material.SNOW_BALL);
				case SUN_CAGE:
					return Utils.setDurability(new ItemStack(Material.STAINED_GLASS), 4);
				case TANK_KIT:
					return new ItemStack(Material.CHAINMAIL_CHESTPLATE);
				case THE_END_CAGE:
					return new ItemStack(Material.ENDER_PORTAL_FRAME);
				case THE_WOOL_HUT_CAGE:
					return Utils.setDurability(new ItemStack(Material.WOOL), 11);
				case WOODEN_CAGE:
					return Utils.setDurability(new ItemStack(Material.LOG), 1);
				case BABY_CHICKEN_KIT:
					return new ItemStack(Material.EGG);
				case CHICKEN_KIT:
					return new ItemStack(Material.WOOL);
				case CHICKEN_MAMA_KIT:
					return new ItemStack(Material.FEATHER);
				case CHICKEN_WARLORD_KIT:
					return new ItemStack(Material.IRON_INGOT);
				case HOT_WING_KIT:
					return new ItemStack(Material.FIREBALL);
				case JUMP_BOOST:
					return Utils.hideFlags(Utils.setDurability(new ItemStack(Material.POTION), 8203), 2);
				case SPEED_BOOST:
					return Utils.hideFlags(Utils.setDurability(new ItemStack(Material.POTION), 8194), 2);
			}
			return null;
		}
		
		public int getSlot(){
			switch(this){
				case ARCHER_KIT:
					return 13;
				case BLACK_ARMOR:
					return 13;
				case BLUE_ARMOR:
					return 21;
				case BOMBER_KIT:
					return 15;
				case CYAN_ARMOR:
					return 20;
				case DARK_BLUE_ARMOR:
					return 23;
				case DOUBLE_LOOT:
					return 33;
				case DOUBLE_LOOT_PLAYER:
					return 32;
				case ENABLE_POTIONS:
					return 29;
				case ENABLE_POTIONS_PLAYER:
					return 30;
				case FIGHTER_KIT:
					return 21;
				case GRAY_ARMOR:
					return 11;
				case GREEN_ARMOR:
					return 14;
				case LIGHT_BLUE_ARMOR:
					return 16;
				case LIGHT_GREEN_ARMOR:
					return 25;
				case ORANGE_ARMOR:
					return 19;
				case PINK_ARMOR:
					return 10;
				case PURPLE_ARMOR:
					return 24;
				case RED_ARMOR:
					return 22;
				case RUNNER_KIT:
					return 11;
				case WARRIOR_KIT:
					return 23;
				case WHITE_ARMOR:
					return 12;
				case YELLOW_ARMOR:
					return 15;
				case APPLETREE_KIT:
					return 13;
				case DOUBLE_IRON:
					return 12;
				case DOUBLE_IRON_PLAYER:
					return 21;
				case GOLD_FROM_LAPIS:
					return 14;
				case GOLD_FROM_REDSTONE:
					return 23;
				case MINER_KIT:
					return 15;
				case SPEEDSTER_KIT:
					return 23;
				case STARTER_KIT:
					return 21;
				case SURVIVOR_KIT:
					return 11;
				case CACTUS_CAGE:
					return 14;
				case CAVE_CAGE:
					return 24;
				case CREEPER_KIT:
					return 13;
				case DEATH_CAGE:
					return 13;
				case ENCHANTER_CAGE:
					return 19;
				case ENCHANTER_KIT:
					return 23;
				case ENDERMAN_KIT:
					return 15;
				case GRAY_RAINBOW_CAGE:
					return 11;
				case HOT_AIR_BALLOON_CAGE:
					return 21;
				case MESA_CAGE:
					return 20;
				case NETHER_CAGE:
					return 10;
				case SEA_CAGE:
					return 23;
				case SLIME_CAGE:
					return 25;
				case SNOWGOLEM_KIT:
					return 21;
				case SUN_CAGE:
					return 15;
				case TANK_KIT:
					return 11;
				case THE_END_CAGE:
					return 22;
				case THE_WOOL_HUT_CAGE:
					return 12;
				case WOODEN_CAGE:
					return 16;
				case BABY_CHICKEN_KIT:
					return 21;
				case CHICKEN_KIT:
					return 15;
				case CHICKEN_MAMA_KIT:
					return 11;
				case CHICKEN_WARLORD_KIT:
					return 23;
				case HOT_WING_KIT:
					return 13;
				case JUMP_BOOST:
					return 13;
				case SPEED_BOOST:
					return 22;
			}
			return 0;
		}
		
		public List<String> getDescription(){
			switch(this){
				case ARCHER_KIT:
					return Arrays.asList("Bow", "2 Arrows", getUses().getName());
				case BLACK_ARMOR:
					return Arrays.asList("Your Leather Armor will be Black!", getUses().getName());
				case BLUE_ARMOR:
					return Arrays.asList("Your Leather Armor will be Blue!", getUses().getName());
				case BOMBER_KIT:
					return Arrays.asList("10 TNT", getUses().getName());
				case CYAN_ARMOR:
					return Arrays.asList("Your Leather Armor will be Cyan!", getUses().getName());
				case DARK_BLUE_ARMOR:
					return Arrays.asList("Your Leather Armor will be Dark Blue!", getUses().getName());
				case DOUBLE_LOOT:
					return Arrays.asList("Double loot in Chests.", "(Effects all Players)", getUses().getName());
				case DOUBLE_LOOT_PLAYER:
					return Arrays.asList("Double loot in Chests.", "(Effects you)", getUses().getName());
				case ENABLE_POTIONS:
					return Arrays.asList("Potions in Chests.", "(Effects all Players)", getUses().getName());
				case ENABLE_POTIONS_PLAYER:
					return Arrays.asList("Potions in Chests.", "(Effects you)", getUses().getName());
				case FIGHTER_KIT:
					return Arrays.asList("Wood/Stone Weapon", getUses().getName());
				case GRAY_ARMOR:
					return Arrays.asList("Your Leather Armor will be Gray!", getUses().getName());
				case GREEN_ARMOR:
					return Arrays.asList("Your Leather Armor will be Green!", getUses().getName());
				case LIGHT_BLUE_ARMOR:
					return Arrays.asList("Your Leather Armor will be Light Blue!", getUses().getName());
				case LIGHT_GREEN_ARMOR:
					return Arrays.asList("Your Leather Armor will be Light Green!", getUses().getName());
				case ORANGE_ARMOR:
					return Arrays.asList("Your Leather Armor will be Orange!", getUses().getName());
				case PINK_ARMOR:
					return Arrays.asList("Your Leather Armor will be Pink!", getUses().getName());
				case PURPLE_ARMOR:
					return Arrays.asList("Your Leather Armor will be Purple!", getUses().getName());
				case RED_ARMOR:
					return Arrays.asList("Your Leather Armor will be Red!", getUses().getName());
				case RUNNER_KIT:
					return Arrays.asList("Can't deal/take damage in the first 30s.", getUses().getName());
				case WARRIOR_KIT:
					return Arrays.asList("Start with two armor items.", getUses().getName());
				case WHITE_ARMOR:
					return Arrays.asList("Your Leather Armor will be White!", getUses().getName());
				case YELLOW_ARMOR:
					return Arrays.asList("Your Leather Armor will be Yellow!", getUses().getName());
				case APPLETREE_KIT:
					return Arrays.asList("+1 Apple every 4m.", getUses().getName());
				case DOUBLE_IRON:
					return Arrays.asList("+1 Iron Ore from Iron Ore.", "50% Chance (Effects all Players)", getUses().getName());
				case DOUBLE_IRON_PLAYER:
					return Arrays.asList("+1 Iron Ore from Iron Ore.", "50% Chance (Effects you)", getUses().getName());
				case GOLD_FROM_LAPIS:
					return Arrays.asList("+1 Gold Ore from Lapis Ore", "50% Chance (Effect you)", getUses().getName());
				case GOLD_FROM_REDSTONE:
					return Arrays.asList("+1 Gold Ore from Redstone Ore", "50% Chance", getUses().getName());
				case MINER_KIT:
					return Arrays.asList("Haste I the first 15m.", getUses().getName());
				case SPEEDSTER_KIT:
					return Arrays.asList("Swiftness I Potion (3:00).", getUses().getName());
				case STARTER_KIT:
					return Arrays.asList("Wooden Sword", "Wooden Pickaxe", "Wooden Axe", "Wooden Shovel", getUses().getName());
				case SURVIVOR_KIT:
					return Arrays.asList("15 Cooked Steak.", getUses().getName());
				case CACTUS_CAGE:
					return Arrays.asList("Spawn in the Cactus Cage.", getUses().getName());
				case CAVE_CAGE:
					return Arrays.asList("Spawn in the Cave Cage.", getUses().getName());
				case CREEPER_KIT:
					return Arrays.asList("20 TNT", "Flint and Steel", getUses().getName());
				case DEATH_CAGE:
					return Arrays.asList("Spawn in the Death Cage.", getUses().getName());
				case ENCHANTER_CAGE:
					return Arrays.asList("Spawn in the Enchanter Cage.", getUses().getName());
				case ENCHANTER_KIT:
					return Arrays.asList("Enchantment Table", "15 EXP Potions", getUses().getName());
				case ENDERMAN_KIT:
					return Arrays.asList("2 Enderpearls", getUses().getName());
				case GRAY_RAINBOW_CAGE:
					return Arrays.asList("Spawn in the Gray Rainbow Cage.", getUses().getName());
				case HOT_AIR_BALLOON_CAGE:
					return Arrays.asList("Spawn in the Hot Air Balloon Cage.", getUses().getName());
				case MESA_CAGE:
					return Arrays.asList("Spawn in the Mesa Cage.", getUses().getName());
				case NETHER_CAGE:
					return Arrays.asList("Spawn in the Nether Cage.", getUses().getName());
				case SEA_CAGE:
					return Arrays.asList("Spawn in the Sea Cage.", getUses().getName());
				case SLIME_CAGE:
					return Arrays.asList("Spawn in the Slime Cage.", getUses().getName());
				case SNOWGOLEM_KIT:
					return Arrays.asList("Black Leather Helmet", "1 Carrot", "48 Snowballs", getUses().getName());
				case SUN_CAGE:
					return Arrays.asList("Spawn in the Sun Cage.", getUses().getName());
				case TANK_KIT:
					return Arrays.asList("Leather Helmet", "Chainmail Chestplate", "Chainmail Leggings", "Leather Boots", getUses().getName());
				case THE_END_CAGE:
					return Arrays.asList("Spawn in the End Cage.", getUses().getName());
				case THE_WOOL_HUT_CAGE:
					return Arrays.asList("Spawn in the Wool Hut Cage.", getUses().getName());
				case WOODEN_CAGE:
					return Arrays.asList("Spawn in the Wooden Cage.", getUses().getName());
				case BABY_CHICKEN_KIT:
					return Arrays.asList("Ability: Egg Bomb", "Taken Knockback: 150%", "Taken Damage: 110%", "Damage: 100%", getUses().getName());
				case CHICKEN_KIT:
					return Arrays.asList("Ability: Wool Trail", "Taken Knockback: 95%", "Taken Damage: 90%", "Damage: 120%", getUses().getName());
				case CHICKEN_MAMA_KIT:
					return Arrays.asList("Ability: Feather Attack", "Taken Knockback: 120%", "Taken Damage: 100%", "Damage: 100%", getUses().getName());
				case CHICKEN_WARLORD_KIT:
					return Arrays.asList("Ability: Iron Fist", "Taken Knockback: 90%", "Taken Damage: 80%", "Damage: 150%", getUses().getName());
				case HOT_WING_KIT:
					return Arrays.asList("Ability: Fire Shield", "Taken Knockback: 130%", "Taken Damage: 150%", "Damage: 100-400% [Fire]", getUses().getName());
				case JUMP_BOOST:
					return Arrays.asList("Jump Boost V.", "(Effects all Players)", getUses().getName());
				case SPEED_BOOST:
					return Arrays.asList("Speed Boost V.", "(Effects all Players)", getUses().getName());
			}
			return new ArrayList<String>();
		}
		
		public int getMaxAmount(){
			switch(this){
				case ARCHER_KIT:
					return 3;
				case BOMBER_KIT:
					return 3;
				case FIGHTER_KIT:
					return 3;
				case RUNNER_KIT:
					return 3;
				case WARRIOR_KIT:
					return 3;
				case APPLETREE_KIT:
					return 3;
				case MINER_KIT:
					return 3;
				case SPEEDSTER_KIT:
					return 3;
				case STARTER_KIT:
					return 3;
				case SURVIVOR_KIT:
					return 3;
				case TANK_KIT:
					return 3;
				case SNOWGOLEM_KIT:
					return 3;
				case ENCHANTER_KIT:
					return 3;
				case CREEPER_KIT:
					return 3;
				case ENDERMAN_KIT:
					return 3;
				case BABY_CHICKEN_KIT:
					return 3;
				case HOT_WING_KIT:
					return 3;
				case CHICKEN_WARLORD_KIT:
					return 3;
				case CHICKEN_KIT:
					return 3;
				default:
					return 1;
			}
		}
		
		public Kit getKit(){
			return Kit.getKit(toString());
		}
		
		public static Ticket getTicket(ItemStack item){
			TicketType type = null;
			for(TicketType tickettype : TicketType.values()){
				if(item.getItemMeta().getDisplayName().endsWith(tickettype.getNameWithGame())){
					type = tickettype;
				}
			}
			
			if(type.getMaxAmount() != 1){
				return new Ticket(type, Integer.parseInt(item.getItemMeta().getDisplayName().split(" ")[0].substring(2).replace("x", "")));
			}
			return new Ticket(type, 1);
		}
		
		public static ItemStack getRandom(){
			List<Ticket> tickets = new ArrayList<Ticket>();
			for(TicketType type : TicketType.values()){
				for(int i = 0; i < type.getRarity().getAmount(); i++){
					tickets.add(new Ticket(type, new Random().nextInt(type.getMaxAmount()) +1));
				}
			}
			
			Ticket ticket = tickets.get(new Random().nextInt(tickets.size()));
			TicketType type = ticket.getType();
			
			ItemStack item = type.getItemStack();
			ItemMeta meta = item.getItemMeta();
			if(type.getMaxAmount() != 1){
				meta.setDisplayName(type.getRarity().getColor() + ticket.getAmount() + "x " + type.getNameWithGame());
			}
			else{
				meta.setDisplayName(type.getRarity().getColor() + type.getNameWithGame());
			}
			item.setItemMeta(meta);
			
			return Utils.hideFlags(item, 34);
		}
		
		public static List<TicketType> getSGKits(){
			return Arrays.asList(TicketType.ARCHER_KIT, TicketType.BOMBER_KIT, TicketType.FIGHTER_KIT, TicketType.RUNNER_KIT, TicketType.WARRIOR_KIT);
		}
		
		public static List<TicketType> getSGPerks(){
			return Arrays.asList(TicketType.BLACK_ARMOR, TicketType.BLUE_ARMOR, TicketType.CYAN_ARMOR, TicketType.DARK_BLUE_ARMOR, TicketType.GRAY_ARMOR, TicketType.GREEN_ARMOR, TicketType.LIGHT_BLUE_ARMOR, TicketType.LIGHT_GREEN_ARMOR, TicketType.ORANGE_ARMOR, TicketType.PINK_ARMOR, TicketType.PURPLE_ARMOR, TicketType.RED_ARMOR, TicketType.WHITE_ARMOR, TicketType.YELLOW_ARMOR, TicketType.DOUBLE_LOOT, TicketType.DOUBLE_LOOT_PLAYER, TicketType.ENABLE_POTIONS, TicketType.ENABLE_POTIONS_PLAYER);
		}
		
		public static List<TicketType> getUHCKits(){
			return Arrays.asList(TicketType.APPLETREE_KIT, TicketType.MINER_KIT, TicketType.SPEEDSTER_KIT,  TicketType.STARTER_KIT, TicketType.SURVIVOR_KIT);
		}
		
		public static List<TicketType> getUHCPerks(){
			return Arrays.asList(TicketType.DOUBLE_IRON, TicketType.DOUBLE_IRON_PLAYER, TicketType.GOLD_FROM_LAPIS, TicketType.GOLD_FROM_REDSTONE);
		}
		
		public static List<TicketType> getSkywarsKits(){
			return Arrays.asList(TicketType.CREEPER_KIT, TicketType.ENCHANTER_KIT, TicketType.ENDERMAN_KIT, TicketType.SNOWGOLEM_KIT, TicketType.TANK_KIT);
		}
		
		public static List<TicketType> getSkywarsPerks(){
			return Arrays.asList(TicketType.CACTUS_CAGE, TicketType.CAVE_CAGE, TicketType.DEATH_CAGE, TicketType.ENCHANTER_CAGE, TicketType.GRAY_RAINBOW_CAGE, TicketType.HOT_AIR_BALLOON_CAGE, TicketType.MESA_CAGE, TicketType.NETHER_CAGE, TicketType.SEA_CAGE, TicketType.SLIME_CAGE, TicketType.SUN_CAGE, TicketType.THE_END_CAGE, TicketType.THE_WOOL_HUT_CAGE, TicketType.WOODEN_CAGE);
		}
		
		public static List<TicketType> getCFKits(){
			return Arrays.asList(TicketType.CHICKEN_MAMA_KIT, TicketType.BABY_CHICKEN_KIT, TicketType.HOT_WING_KIT, TicketType.CHICKEN_WARLORD_KIT, TicketType.CHICKEN_KIT);
		}
		
		public static List<TicketType> getCFPerks(){
			return Arrays.asList(TicketType.JUMP_BOOST, TicketType.SPEED_BOOST);
		}
		
		public static List<TicketType> getKits(){
			return Arrays.asList(TicketType.RUNNER_KIT, TicketType.FIGHTER_KIT, TicketType.ARCHER_KIT, TicketType.WARRIOR_KIT, TicketType.BOMBER_KIT, TicketType.APPLETREE_KIT, TicketType.MINER_KIT, TicketType.SPEEDSTER_KIT, TicketType.STARTER_KIT, TicketType.SURVIVOR_KIT, TicketType.CREEPER_KIT, TicketType.ENCHANTER_KIT, TicketType.ENDERMAN_KIT, TicketType.SNOWGOLEM_KIT, TicketType.TANK_KIT, TicketType.CHICKEN_MAMA_KIT, TicketType.BABY_CHICKEN_KIT, TicketType.HOT_WING_KIT, TicketType.CHICKEN_WARLORD_KIT, TicketType.CHICKEN_KIT);
		}
		
		public static TicketType fromID(int ticketid){
			for(TicketType type : TicketType.values()){
				if(type.ordinal() == ticketid){
					return type;
				}
			}
			return null;
		}
	}
}
