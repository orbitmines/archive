package me.O_o_Fadi_o_O.OrbitMines.utils.survival;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SurvivalUtils {

	public Chest getChestShop(Block block){
		for(BlockFace bf : Arrays.asList(BlockFace.DOWN, BlockFace.UP, BlockFace.EAST, BlockFace.NORTH, BlockFace.WEST, BlockFace.SOUTH)){
			Block b = block.getRelative(bf);
			
			if(b.getState() instanceof Chest){
				return (Chest) b.getState();
			}
		}
		return null;
	}
	
	public Material getMaterial(Biome b){
		switch(b){
			case BEACH:
				return Material.SAND;
			case BIRCH_FOREST:
				return Material.SAPLING;
			case BIRCH_FOREST_HILLS:
				return Material.SAPLING;
			case BIRCH_FOREST_HILLS_MOUNTAINS:
				return Material.SAPLING;
			case BIRCH_FOREST_MOUNTAINS:
				return Material.SAPLING;
			case COLD_BEACH:
				return Material.SAND;
			case COLD_TAIGA:
				return Material.SAPLING;
			case COLD_TAIGA_HILLS:
				return Material.SAPLING;
			case COLD_TAIGA_MOUNTAINS:
				return Material.SAPLING;
			case DEEP_OCEAN:
				return Material.WATER_BUCKET;
			case DESERT:
				return Material.SAND;
			case DESERT_HILLS:
				return Material.SAND;
			case DESERT_MOUNTAINS:
				return Material.SAND;
			case EXTREME_HILLS:
				return Material.STONE;
			case EXTREME_HILLS_MOUNTAINS:
				return Material.STONE;
			case EXTREME_HILLS_PLUS:
				return Material.STONE;
			case EXTREME_HILLS_PLUS_MOUNTAINS:
				return Material.STONE;
			case FLOWER_FOREST:
				return Material.RED_ROSE;
			case FOREST:
				return Material.SAPLING;
			case FOREST_HILLS:
				return Material.SAPLING;
			case FROZEN_OCEAN:
				return Material.ICE;
			case FROZEN_RIVER:
				return Material.ICE;
			case HELL:
				return Material.NETHERRACK;
			case ICE_MOUNTAINS:
				return Material.ICE;
			case ICE_PLAINS:
				return Material.ICE;
			case ICE_PLAINS_SPIKES:
				return Material.ICE;
			case JUNGLE:
				return Material.SAPLING;
			case JUNGLE_EDGE:
				return Material.SAPLING;
			case JUNGLE_EDGE_MOUNTAINS:
				return Material.SAPLING;
			case JUNGLE_HILLS:
				return Material.SAPLING;
			case JUNGLE_MOUNTAINS:
				return Material.SAPLING;
			case MEGA_SPRUCE_TAIGA:
				return Material.SAPLING;
			case MEGA_SPRUCE_TAIGA_HILLS:
				return Material.SAPLING;
			case MEGA_TAIGA:
				return Material.SAPLING;
			case MEGA_TAIGA_HILLS:
				return Material.SAPLING;
			case MESA:
				return Material.STAINED_CLAY;
			case MESA_BRYCE:
				return Material.STAINED_CLAY;
			case MESA_PLATEAU:
				return Material.STAINED_CLAY;
			case MESA_PLATEAU_FOREST:
				return Material.STAINED_CLAY;
			case MESA_PLATEAU_FOREST_MOUNTAINS:
				return Material.STAINED_CLAY;
			case MESA_PLATEAU_MOUNTAINS:
				return Material.STAINED_CLAY;
			case MUSHROOM_ISLAND:
				return Material.HUGE_MUSHROOM_2;
			case MUSHROOM_SHORE:
				return Material.HUGE_MUSHROOM_2;
			case OCEAN:
				return Material.WATER_BUCKET;
			case PLAINS:
				return Material.GRASS;
			case RIVER:
				return Material.WATER_BUCKET;
			case ROOFED_FOREST:
				return Material.SAPLING;
			case ROOFED_FOREST_MOUNTAINS:
				return Material.SAPLING;
			case SAVANNA:
				return Material.SAPLING;
			case SAVANNA_MOUNTAINS:
				return Material.SAPLING;
			case SAVANNA_PLATEAU:
				return Material.SAPLING;
			case SAVANNA_PLATEAU_MOUNTAINS:
				return Material.SAPLING;
			case SKY:
				return Material.SNOW_BLOCK;
			case SMALL_MOUNTAINS:
				return Material.STONE;
			case STONE_BEACH:
				return Material.STONE;
			case SUNFLOWER_PLAINS:
				return Material.DOUBLE_PLANT;
			case SWAMPLAND:
				return Material.VINE;
			case SWAMPLAND_MOUNTAINS:
				return Material.VINE;
			case TAIGA:
				return Material.SAPLING;
			case TAIGA_HILLS:
				return Material.SAPLING;
			case TAIGA_MOUNTAINS:
				return Material.SAPLING;
			default:
				return null;
		}
	}
	
	public short getDurability(Biome b){
		switch(b){
			case BIRCH_FOREST:
				return 2;
			case BIRCH_FOREST_HILLS:
				return 2;
			case BIRCH_FOREST_HILLS_MOUNTAINS:
				return 2;
			case BIRCH_FOREST_MOUNTAINS:
				return 2;
			case COLD_TAIGA:
				return 1;
			case COLD_TAIGA_HILLS:
				return 1;
			case COLD_TAIGA_MOUNTAINS:
				return 1;
			case JUNGLE:
				return 3;
			case JUNGLE_EDGE:
				return 3;
			case JUNGLE_EDGE_MOUNTAINS:
				return 3;
			case JUNGLE_HILLS:
				return 3;
			case JUNGLE_MOUNTAINS:
				return 3;
			case MEGA_SPRUCE_TAIGA:
				return 1;
			case MEGA_SPRUCE_TAIGA_HILLS:
				return 1;
			case MEGA_TAIGA:
				return 1;
			case MEGA_TAIGA_HILLS:
				return 1;
			case MESA:
				return 4;
			case MESA_BRYCE:
				return 4;
			case MESA_PLATEAU:
				return 4;
			case MESA_PLATEAU_FOREST:
				return 4;
			case MESA_PLATEAU_FOREST_MOUNTAINS:
				return 4;
			case MESA_PLATEAU_MOUNTAINS:
				return 4;
			case ROOFED_FOREST:
				return 5;
			case ROOFED_FOREST_MOUNTAINS:
				return 5;
			case SAVANNA:
				return 4;
			case SAVANNA_MOUNTAINS:
				return 4;
			case SAVANNA_PLATEAU:
				return 4;
			case SAVANNA_PLATEAU_MOUNTAINS:
				return 4;
			case TAIGA:
				return 1;
			case TAIGA_HILLS:
				return 1;
			case TAIGA_MOUNTAINS:
				return 1;
			default:
				return 0;
		}
	}
	
	public String getBiomeName(Biome b){
		switch(b){
			case BEACH:
				return "§eBeach"; 
			case BIRCH_FOREST:
				return "§fBirch Forest"; 
			case BIRCH_FOREST_HILLS:
				return "§fBirch Forest Hills"; 
			case BIRCH_FOREST_HILLS_MOUNTAINS:
				return "§fBirch Forest Mountain Hills"; 
			case BIRCH_FOREST_MOUNTAINS:
				return "§fBirch Forest Mountains"; 
			case COLD_BEACH:
				return "§bCold Beach"; 
			case COLD_TAIGA:
				return "§2Cold Taiga"; 
			case COLD_TAIGA_HILLS:
				return "§2Cold Taiga Hills"; 
			case COLD_TAIGA_MOUNTAINS:
				return "§2Cold Taiga Mountains"; 
			case DEEP_OCEAN:
				return "§9Deep Ocean"; 
			case DESERT:
				return "§eDesert"; 
			case DESERT_HILLS:
				return "§eDesert Hills"; 
			case DESERT_MOUNTAINS:
				return "§eDesert Mountains"; 
			case EXTREME_HILLS:
				return "§7Extreme Hills"; 
			case EXTREME_HILLS_MOUNTAINS:
				return "§7Extreme Mountain Hills"; 
			case EXTREME_HILLS_PLUS:
				return "§7Extreme Hills"; 
			case EXTREME_HILLS_PLUS_MOUNTAINS:
				return "§7Extreme Mountain Hills"; 
			case FLOWER_FOREST:
				return "§cFlower Forest"; 
			case FOREST:
				return "§aForest"; 
			case FOREST_HILLS:
				return "§aForest Hills"; 
			case FROZEN_OCEAN:
				return "§bFrozen Ocean"; 
			case FROZEN_RIVER:
				return "§fFrozen River"; 
			case HELL:
				return "§cNether"; 
			case ICE_MOUNTAINS:
				return "§bCold Mountains"; 
			case ICE_PLAINS:
				return "§bIce Plains"; 
			case ICE_PLAINS_SPIKES:
				return "§bIce Spike Plains"; 
			case JUNGLE:
				return "§2Jungle"; 
			case JUNGLE_EDGE:
				return "§2Jungle"; 
			case JUNGLE_EDGE_MOUNTAINS:
				return "§2Jungle Mountains"; 
			case JUNGLE_HILLS:
				return "§2Jungle Hills"; 
			case JUNGLE_MOUNTAINS:
				return "§2Jungle Mountains"; 
			case MEGA_SPRUCE_TAIGA:
				return "§2Mega Taiga"; 
			case MEGA_SPRUCE_TAIGA_HILLS:
				return "§2Mega Taiga Hills"; 
			case MEGA_TAIGA:
				return "§2Mega Taiga"; 
			case MEGA_TAIGA_HILLS:
				return "§2Mega Taiga Hills"; 
			case MESA:
				return "§6Mesa"; 
			case MESA_BRYCE:
				return "§6Mesa"; 
			case MESA_PLATEAU:
				return "§6Mesa"; 
			case MESA_PLATEAU_FOREST:
				return "§6Mesa"; 
			case MESA_PLATEAU_FOREST_MOUNTAINS:
				return "§6Mesa"; 
			case MESA_PLATEAU_MOUNTAINS:
				return "§6Mesa"; 
			case MUSHROOM_ISLAND:
				return "§cMushroom"; 
			case MUSHROOM_SHORE:
				return "§cMushroom"; 
			case OCEAN:
				return "§9Ocean"; 
			case PLAINS:
				return "§aPlains"; 
			case RIVER:
				return "§9River"; 
			case ROOFED_FOREST:
				return "§2Roofed Forest"; 
			case ROOFED_FOREST_MOUNTAINS:
				return "§2Roofed Mountain Forest"; 
			case SAVANNA:
				return "§eSavanna"; 
			case SAVANNA_MOUNTAINS:
				return "§eSavanna Mountains"; 
			case SAVANNA_PLATEAU:
				return "§eSavanna"; 
			case SAVANNA_PLATEAU_MOUNTAINS:
				return "§eSavanna Mountains"; 
			case SKY:
				return "§fSky"; 
			case SMALL_MOUNTAINS:
				return "§7Mountains"; 
			case STONE_BEACH:
				return "§7Stone Beach"; 
			case SUNFLOWER_PLAINS:
				return "§6Sunflower Plains"; 
			case SWAMPLAND:
				return "§8Swampland"; 
			case SWAMPLAND_MOUNTAINS:
				return "§8Swampland"; 
			case TAIGA:
				return "§2Taiga"; 
			case TAIGA_HILLS:
				return "§2Taiga Hills"; 
			case TAIGA_MOUNTAINS:
				return "§2Taiga Mountains"; 
			default:
				return null;
		}
	}
	
	public ItemStack getRegionItemStack(Region region){
		ItemStack item = new ItemStack(getMaterial(region.getBiome()), region.getRegionID());
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§7§lRegion §a§l" + region.getRegionID());
		List<String> lore = new ArrayList<String>();
		lore.add(" §7Biome: " + getBiomeName(region.getBiome()));
		lore.add(" §7XYZ: §a" + region.getLocation().getBlockX() + " §7/ §a" + region.getLocation().getBlockY() + " §7/ §a" + region.getLocation().getBlockZ());
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability(getDurability(region.getBiome()));
		
		return item;
	}

	public String getMaterialName(Material m){
		switch(m){
			case ACACIA_DOOR_ITEM:
				return "Acacia Door";
			case ACACIA_FENCE:
				return "Fence";
			case ACACIA_FENCE_GATE:
				return "Fence Gate";
			case ACACIA_STAIRS:
				return "Wooden Stairs";
			case ACTIVATOR_RAIL:
				return "Activator Rail";
			case ANVIL:
				return "Anvil";
			case APPLE:
				return "Apple";
			case ARMOR_STAND:
				return "Armor Stand";
			case ARROW:
				return "Arrow";
			case BAKED_POTATO:
				return "Baked Potato";
			case BANNER:
				return "Banner";
			case BEACON:
				return "Beacon";
			case BED:
				return "Bed";
			case BEDROCK:
				return "Bedrock";
			case BIRCH_DOOR_ITEM:
				return "Brich Door";
			case BIRCH_FENCE:
				return "Fence";
			case BIRCH_FENCE_GATE:
				return "Fence Gate";
			case BIRCH_WOOD_STAIRS:
				return "Wooden Stairs";
			case BLAZE_POWDER:
				return "Blaze Powder";
			case BLAZE_ROD:
				return "Blaze Rod";
			case BOAT:
				return "Boat";
			case BONE:
				return "Bone";
			case BOOK:
				return "Book";
			case BOOKSHELF:
				return "Bookshelf";
			case BOOK_AND_QUILL:
				return "Book and Quill";
			case BOW:
				return "Bow";
			case BOWL:
				return "Bowl";
			case BREAD:
				return "Bread";
			case BREWING_STAND_ITEM:
				return "Brewing Stand";
			case BRICK:
				return "Bricks";
			case BRICK_STAIRS:
				return "Brick Stairs";
			case BROWN_MUSHROOM:
				return "Brown Mushroom";
			case BUCKET:
				return "Bucket";
			case CACTUS:
				return "Cactus";
			case CAKE:
				return "Cake";
			case CARPET:
				return "Carpet";
			case CARROT_ITEM:
				return "Carrot";
			case CARROT_STICK:
				return "Carrot on Stick";
			case CAULDRON_ITEM:
				return "Cauldron";
			case CHAINMAIL_BOOTS:
				return "Chain Boots";
			case CHAINMAIL_CHESTPLATE:
				return "Chain Chestplate";
			case CHAINMAIL_HELMET:
				return "Chain Helmet";
			case CHAINMAIL_LEGGINGS:
				return "Chain Leggings";
			case CHEST:
				return "Chest";
			case CLAY:
				return "Clay";
			case CLAY_BALL:
				return "Clay Ball";
			case CLAY_BRICK:
				return "Clay";
			case COAL:
				return "Coal";
			case COAL_BLOCK:
				return "Coal Block";
			case COAL_ORE:
				return "Coal Ore";
			case COBBLESTONE:
				return "Cobblestone";
			case COBBLESTONE_STAIRS:
				return "Cobble Stairs";
			case COBBLE_WALL:
				return "Cobblestone Wall";
			case COCOA:
				return "Cocoa Beans";
			case COMPASS:
				return "Compass";
			case COOKED_BEEF:
				return "Cooked Beef";
			case COOKED_CHICKEN:
				return "Cooked Chicken";
			case COOKED_FISH:
				return "Cooked Fish";
			case COOKED_MUTTON:
				return "Cooked Mutton";
			case COOKED_RABBIT:
				return "Cooked Rabbit";
			case COOKIE:
				return "Cookie";
			case DARK_OAK_DOOR_ITEM:
				return "Dark Oak Door";
			case DARK_OAK_FENCE:
				return "Fence";
			case DARK_OAK_FENCE_GATE:
				return "Fence Gate";
			case DARK_OAK_STAIRS:
				return "Wooden Stairs";
			case DAYLIGHT_DETECTOR:
				return "DaylightDetector";
			case DAYLIGHT_DETECTOR_INVERTED:
				return "DaylightDetector";
			case DEAD_BUSH:
				return "Dead Bush";
			case DETECTOR_RAIL:
				return "Detector Rail";
			case DIAMOND:
				return "Diamond";
			case DIAMOND_AXE:
				return "Diamond Axe";
			case DIAMOND_BARDING:
				return "Dia Horse Armor";
			case DIAMOND_BLOCK:
				return "Diamond Block";
			case DIAMOND_BOOTS:
				return "Diamond Boots";
			case DIAMOND_CHESTPLATE:
				return "Dia Chestplate";
			case DIAMOND_HELMET:
				return "Diamond Helmet";
			case DIAMOND_HOE:
				return "Diamond Hoe";
			case DIAMOND_LEGGINGS:
				return "Diamond Leggings";
			case DIAMOND_ORE:
				return "Diamond Ore";
			case DIAMOND_PICKAXE:
				return "Diamond Pickaxe";
			case DIAMOND_SPADE:
				return "Diamond Spade";
			case DIAMOND_SWORD:
				return "Diamond Sword";
			case DIODE:
				return "Repeater";
			case DIODE_BLOCK_OFF:
				return "Repeater";
			case DIRT:
				return "Dirt";
			case DISPENSER:
				return "Dispeser";
			case DOUBLE_PLANT:
				return "Tall Grass";
			case DRAGON_EGG:
				return "Dragon Egg";
			case DROPPER:
				return "Dropper";
			case EGG:
				return "Egg";
			case EMERALD:
				return "Emerald";
			case EMERALD_BLOCK:
				return "Emerald Block";
			case EMERALD_ORE:
				return "Emerald Ore";
			case EMPTY_MAP:
				return "Empty Map";
			case ENCHANTED_BOOK:
				return "Enchanted Book";
			case ENCHANTMENT_TABLE:
				return "EnchantmentTable";
			case ENDER_CHEST:
				return "Ender Chest";
			case ENDER_PEARL:
				return "Ender Pearl";
			case ENDER_PORTAL:
				return "End Portal";
			case ENDER_STONE:
				return "End Stone";
			case EXPLOSIVE_MINECART:
				return "TNT Minecart";
			case EXP_BOTTLE:
				return "EXP Bottle";
			case EYE_OF_ENDER:
				return "Eye of Ender";
			case FEATHER:
				return "Feather";
			case FENCE:
				return "Fence";
			case FENCE_GATE:
				return "Fence Gate";
			case FERMENTED_SPIDER_EYE:
				return "F. Spider Eye";
			case FIREBALL:
				return "Fire Charge";
			case FIREWORK:
				return "Firework";
			case FIREWORK_CHARGE:
				return "Firework Star";
			case FISHING_ROD:
				return "Fishing Rod";
			case FLINT:
				return "Flint";
			case FLINT_AND_STEEL:
				return "Flint and Steel";
			case FLOWER_POT_ITEM:
				return "Flower Pot";
			case FURNACE:
				return "Furnace";
			case GHAST_TEAR:
				return "Ghast Tear";
			case GLASS:
				return "Glass";
			case GLASS_BOTTLE:
				return "Glass Bottle";
			case GLOWSTONE:
				return "Glowstone";
			case GLOWSTONE_DUST:
				return "Glowstone Dust";
			case GOLDEN_APPLE:
				return "Golden Apple";
			case GOLDEN_CARROT:
				return "Golden Carrot";
			case GOLD_AXE:
				return "Golden Axe";
			case GOLD_BARDING:
				return "Gold Horse Armor";
			case GOLD_BLOCK:
				return "Golden Block";
			case GOLD_BOOTS:
				return "Golden Boots";
			case GOLD_CHESTPLATE:
				return "GoldenChestplate";
			case GOLD_HELMET:
				return "Golden Helmet";
			case GOLD_HOE:
				return "Golden Hoe";
			case GOLD_INGOT:
				return "Gold Ingot";
			case GOLD_LEGGINGS:
				return "Golden Leggings";
			case GOLD_NUGGET:
				return "Golden Nugget";
			case GOLD_ORE:
				return "Gold Ore";
			case GOLD_PICKAXE:
				return "Golden Pickaxe";
			case GOLD_PLATE:
				return "Pressure Plate";
			case GOLD_RECORD:
				return "Music Disc";
			case GOLD_SPADE:
				return "Golden Spade";
			case GOLD_SWORD:
				return "Golden Sword";
			case GRASS:
				return "Grass";
			case GRAVEL:
				return "Gravel";
			case GREEN_RECORD:
				return "Music Disc";
			case GRILLED_PORK:
				return "Cooked Pork Chop";
			case HARD_CLAY:
				return "Hardened Clay";
			case HAY_BLOCK:
				return "Hay Block";
			case HOPPER:
				return "Hopper";
			case HOPPER_MINECART:
				return "Hopper Minecart";
			case ICE:
				return "Ice";
			case INK_SACK:
				return "Ink Sack";
			case IRON_AXE:
				return "Iron Axe";
			case IRON_BARDING:
				return "Iron Horse Armor";
			case IRON_BLOCK:
				return "Iron Block";
			case IRON_BOOTS:
				return "Iron Boots";
			case IRON_CHESTPLATE:
				return "Iron Chestplate";
			case IRON_DOOR_BLOCK:
				return "Iron Door";
			case IRON_FENCE:
				return "Iron Bars";
			case IRON_HELMET:
				return "Iron Helmet";
			case IRON_HOE:
				return "Iron Hoe";
			case IRON_INGOT:
				return "Iron Ingot";
			case IRON_LEGGINGS:
				return "Iron Leggings";
			case IRON_ORE:
				return "Iron Ore";
			case IRON_PICKAXE:
				return "Iron Pickaxe";
			case IRON_PLATE:
				return "Pressure Plate";
			case IRON_SPADE:
				return "Iron Spade";
			case IRON_SWORD:
				return "Iron Sword";
			case IRON_TRAPDOOR:
				return "Iron Trapdoor";
			case ITEM_FRAME:
				return "Item Frame";
			case JACK_O_LANTERN:
				return "Jack o'Lantern";
			case JUKEBOX:
				return "Jukebox";
			case JUNGLE_DOOR_ITEM:
				return "Jungle Door";
			case JUNGLE_FENCE:
				return "Fence";
			case JUNGLE_FENCE_GATE:
				return "Fence Gate";
			case JUNGLE_WOOD_STAIRS:
				return "Wood Stairs";
			case LADDER:
				return "Ladder";
			case LAPIS_BLOCK:
				return "Lapis Block";
			case LAPIS_ORE:
				return "Lapis Ore";
			case LAVA:
				return "Lava";
			case LAVA_BUCKET:
				return "Lava Bucket";
			case LEASH:
				return "Lead";
			case LEATHER:
				return "Leather";
			case LEATHER_BOOTS:
				return "Leather Boots";
			case LEATHER_CHESTPLATE:
				return "Leat. Chestplate";
			case LEATHER_HELMET:
				return "Leather Helmet";
			case LEATHER_LEGGINGS:
				return "Leather Leggings";
			case LEAVES:
				return "Leaves";
			case LEAVES_2:
				return "Leaves";
			case LEVER:
				return "Lever";
			case LOG:
				return "Log";
			case LOG_2:
				return "Log";
			case LONG_GRASS:
				return "Tall Grass";
			case MAGMA_CREAM:
				return "Magma Cream";
			case MAP:
				return "Map";
			case MELON:
				return "Melon";
			case MELON_BLOCK:
				return "Melon Block";
			case MELON_SEEDS:
				return "Melon Seeds";
			case MILK_BUCKET:
				return "Milk Bucket";
			case MINECART:
				return "Minecart";
			case MOB_SPAWNER:
				return "Mob Spawner";
			case MONSTER_EGG:
				return "Monster Egg";
			case MONSTER_EGGS:
				return "Monster Egg";
			case MOSSY_COBBLESTONE:
				return "MossyCobblestone";
			case MUSHROOM_SOUP:
				return "Mushroom Soup";
			case MUTTON:
				return "Raw Mutton";
			case MYCEL:
				return "Mycelium";
			case NAME_TAG:
				return "Name Tag";
			case NETHERRACK:
				return "Netherrack";
			case NETHER_BRICK:
				return "Nether Brick";
			case NETHER_BRICK_ITEM:
				return "Nether Brick";
			case NETHER_BRICK_STAIRS:
				return "Nether Stairs";
			case NETHER_FENCE:
				return "Nether Fence";
			case NETHER_STALK:
				return "Nether Wart";
			case NETHER_STAR:
				return "Nether Star";
			case NOTE_BLOCK:
				return "Note Block";
			case OBSIDIAN:
				return "Obsidian";
			case PACKED_ICE:
				return "Packed Ice";
			case PAINTING:
				return "Painting";
			case PAPER:
				return "Paper";
			case PISTON_BASE:
				return "Piston";
			case PISTON_STICKY_BASE:
				return "Sticky Piston";
			case POISONOUS_POTATO:
				return "Poisonous Potato";
			case PORK:
				return "Raw Pork Chop";
			case POTATO_ITEM:
				return "Potato";
			case POTION:
				return "Potion";
			case POWERED_MINECART:
				return "Powered Minecart";
			case POWERED_RAIL:
				return "Powered Rail";
			case PRISMARINE:
				return "Prismarine";
			case PRISMARINE_CRYSTALS:
				return "Crystals";
			case PRISMARINE_SHARD:
				return "Prismarine Shard";
			case PUMPKIN:
				return "Pumpkin";
			case PUMPKIN_PIE:
				return "Pumpkin Pie";
			case PUMPKIN_SEEDS:
				return "Pumpkin Seeds";
			case QUARTZ:
				return "Quartz";
			case QUARTZ_BLOCK:
				return "Quartz Block";
			case QUARTZ_ORE:
				return "Quartz Ore";
			case QUARTZ_STAIRS:
				return "Quartz Stairs";
			case RABBIT:
				return "Cooked Rabbit";
			case RABBIT_FOOT:
				return "Rabbit's Foot";
			case RABBIT_HIDE:
				return "Rabbit Hide";
			case RABBIT_STEW:
				return "Rabbit Stew";
			case RAILS:
				return "Rails";
			case RAW_BEEF:
				return "Raw Beef";
			case RAW_CHICKEN:
				return "Raw Chicken";
			case RAW_FISH:
				return "Raw Fish";
			case RECORD_10:
				return "Music Disc";
			case RECORD_11:
				return "Music Disc";
			case RECORD_12:
				return "Music Disc";
			case RECORD_3:
				return "Music Disc";
			case RECORD_4:
				return "Music Disc";
			case RECORD_5:
				return "Music Disc";
			case RECORD_6:
				return "Music Disc";
			case RECORD_7:
				return "Music Disc";
			case RECORD_8:
				return "Music Disc";
			case RECORD_9:
				return "Music Disc";
			case REDSTONE:
				return "Redstone";
			case REDSTONE_BLOCK:
				return "Redstone Block";
			case REDSTONE_COMPARATOR:
				return "Comparator";
			case REDSTONE_COMPARATOR_OFF:
				return "Comparator";
			case REDSTONE_LAMP_OFF:
				return "Redstone Lamp";
			case REDSTONE_ORE:
				return "Redstone Ore";
			case REDSTONE_TORCH_ON:
				return "Redstone Torch";
			case RED_MUSHROOM:
				return "Red Mushroom";
			case RED_ROSE:
				return "Flower";
			case RED_SANDSTONE:
				return "Sandstone";
			case RED_SANDSTONE_STAIRS:
				return "Sandstone Stairs";
			case ROTTEN_FLESH:
				return "Rotten Flesh";
			case SADDLE:
				return "Saddle";
			case SAND:
				return "Sand";
			case SANDSTONE:
				return "Sandstone";
			case SANDSTONE_STAIRS:
				return "Sandstone Stairs";
			case SAPLING:
				return "Sapling";
			case SEA_LANTERN:
				return "Sea Lantern";
			case SEEDS:
				return "Seeds";
			case SHEARS:
				return "Shears";
			case SIGN:
				return "Sign";
			case SKULL_ITEM:
				return "Skull";
			case SLIME_BALL:
				return "Slime Ball";
			case SLIME_BLOCK:
				return "Slime Block";
			case SMOOTH_BRICK:
				return "Stone Brick";
			case SMOOTH_STAIRS:
				return "Stone Stairs";
			case SNOW:
				return "Snow";
			case SNOW_BALL:
				return "Snow Ball";
			case SNOW_BLOCK:
				return "Snow Block";
			case SOUL_SAND:
				return "Soul Sand";
			case SPECKLED_MELON:
				return "Glistering Melon";
			case SPIDER_EYE:
				return "Spider Eye";
			case SPONGE:
				return "Sponge";
			case SPRUCE_DOOR_ITEM:
				return "Spruce Door";
			case SPRUCE_FENCE:
				return "Fence";
			case SPRUCE_FENCE_GATE:
				return "Fence Gate";
			case SPRUCE_WOOD_STAIRS:
				return "Wooden Stairs";
			case STAINED_CLAY:
				return "Stained Clay";
			case STAINED_GLASS:
				return "Stained Glass";
			case STAINED_GLASS_PANE:
				return "StainedGlassPane";
			case STEP:
				return "Slab";
			case STICK:
				return "Stick";
			case STONE:
				return "Stone";
			case STONE_AXE:
				return "Stone Axe";
			case STONE_BUTTON:
				return "Stone Button";
			case STONE_HOE:
				return "Stone Hoe";
			case STONE_PICKAXE:
				return "Stone Pickaxe";
			case STONE_PLATE:
				return "Pressure Plate";
			case STONE_SLAB2:
				return "Stone Slab";
			case STONE_SPADE:
				return "Stone Spade";
			case STONE_SWORD:
				return "Stone Sword";
			case STORAGE_MINECART:
				return "Storage Minecart";
			case STRING:
				return "String";
			case SUGAR:
				return "Sugar";
			case SUGAR_CANE:
				return "Sugar Cane";
			case SULPHUR:
				return "Gunpowder";
			case THIN_GLASS:
				return "Glass Pane";
			case TNT:
				return "TNT";
			case TORCH:
				return "Torch";
			case TRAPPED_CHEST:
				return "Trapped Chest";
			case TRAP_DOOR:
				return "Trap Door";
			case TRIPWIRE:
				return "Tripwire";
			case TRIPWIRE_HOOK:
				return "Tripwire Hook";
			case VINE:
				return "Vine";
			case WATCH:
				return "Watch";
			case WATER:
				return "Water";
			case WATER_BUCKET:
				return "Water Bucket";
			case WATER_LILY:
				return "Water Lily";
			case WEB:
				return "Web";
			case WHEAT:
				return "Wheat";
			case WOOD:
				return "Wood";
			case WOODEN_DOOR:
				return "Oak Wood Door";
			case WOOD_AXE:
				return "Wooden Axe";
			case WOOD_BUTTON:
				return "Wooden Button";
			case WOOD_DOOR:
				return "Wooden Door";
			case WOOD_HOE:
				return "Wooden Hoe";
			case WOOD_PICKAXE:
				return "Wooden Pickaxe";
			case WOOD_PLATE:
				return "Pressure Plate";
			case WOOD_SPADE:
				return "Wooden Spade";
			case WOOD_STAIRS:
				return "Wood Stairs";
			case WOOD_STEP:
				return "Wood Slab";
			case WOOD_SWORD:
				return "Wooden Sword";
			case WOOL:
				return "Wool";
			case WORKBENCH:
				return "Workbench";
			case WRITTEN_BOOK:
				return "Written Book";
			case YELLOW_FLOWER:
				return "Yellow Flower";
			default:
				return null;
		}
	}
	
	public static enum ShopType {
		
		BUY,
		SELL;
		
		public String getStatusName(boolean sold){
			if(sold){
				switch(this){
					case BUY:
						return "§4§lBuy";
					case SELL:
						return "§4§lSell";
					default:
						return null;
				}
			}
			else{
				switch(this){
					case BUY:
						return "§2§lBuy";
					case SELL:
						return "§2§lSell";
					default:
						return null;
				}
			}
		}
	}
}
