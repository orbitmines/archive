package me.O_o_Fadi_o_O.Survival.jobs.utils;

import org.bukkit.Material;

public enum JobMaterial {

	//MINER
	COAL,
	IRON_INGOT,
	COBBLESTONE,
	LAPIS_LAZULI,
	EMERALD,
	DIAMOND,
	GOLD_INGOT,
	REDSTONE,
	
	//FARMER
	WHEAT,
	MELON,
	APPLE,
	CARROT_ITEM,
	SUGAR_CANE,
	POTATO_ITEM,
	
	//LUMBERJACK
	OAK_LOG,
	SPRUCE_LOG,
	BIRCH_LOG,
	JUNGLE_LOG,
	ACACIA_LOG,
	DARK_OAK_LOG,
	
	//HUNTER
	SPIDER_EYE,
	BLAZE_ROD,
	ROTTEN_FLESH,
	WITHER_SKELETON_SKULL,
	BONE,
	ENDER_PEARL,
	GHAST_TEAR,
	GUNPOWDER,
	MAGMA_CREAM,
	SLIME_BALL,
	
	//ANIMAL FARMER
	FEATHER,
	RAW_CHICKEN,
	RABBIT_HIDE,
	RAW_RABBIT,
	RAW_BEEF,
	LEATHER,
	RAW_PORK,
	RAW_MUTTON,
	
	NETHER_WART,
	QUARTZ_ORE,
	NETHER_BRICK,
	NETHER_BRICKS,
	NETHERRACK,
	QUARTZ,
	;
	
	public static Material getMaterial(JobMaterial material){
		if(material == COAL){return Material.COAL;}
		else if(material == IRON_INGOT){return Material.IRON_INGOT;}
		else if(material == COBBLESTONE){return Material.COBBLESTONE;}
		else if(material == LAPIS_LAZULI){return Material.INK_SACK;}
		else if(material == EMERALD){return Material.EMERALD;}
		else if(material == DIAMOND){return Material.DIAMOND;}
		else if(material == GOLD_INGOT){return Material.GOLD_INGOT;}
		else if(material == REDSTONE){return Material.REDSTONE;}
		
		else if(material == WHEAT){return Material.WHEAT;}
		else if(material == MELON){return Material.MELON;}
		else if(material == APPLE){return Material.APPLE;}
		else if(material == CARROT_ITEM){return Material.CARROT_ITEM;}
		else if(material == SUGAR_CANE){return Material.SUGAR_CANE;}
		else if(material == POTATO_ITEM){return Material.POTATO_ITEM;}
		
		else if(material == OAK_LOG){return Material.LOG;}
		else if(material == SPRUCE_LOG){return Material.LOG;}
		else if(material == BIRCH_LOG){return Material.LOG;}
		else if(material == JUNGLE_LOG){return Material.LOG;}
		else if(material == ACACIA_LOG){return Material.LOG_2;}
		else if(material == DARK_OAK_LOG){return Material.LOG_2;}
		
		else if(material == SPIDER_EYE){return Material.SPIDER_EYE;}
		else if(material == BLAZE_ROD){return Material.BLAZE_ROD;}
		else if(material == ROTTEN_FLESH){return Material.ROTTEN_FLESH;}
		else if(material == WITHER_SKELETON_SKULL){return Material.SKULL_ITEM;}
		else if(material == BONE){return Material.BONE;}
		else if(material == ENDER_PEARL){return Material.ENDER_PEARL;}
		else if(material == GHAST_TEAR){return Material.GHAST_TEAR;}
		else if(material == GUNPOWDER){return Material.SULPHUR;}
		else if(material == MAGMA_CREAM){return Material.MAGMA_CREAM;}
		else if(material == SLIME_BALL){return Material.SLIME_BALL;}
		
		else if(material == FEATHER){return Material.FEATHER;}
		else if(material == RAW_CHICKEN){return Material.RAW_CHICKEN;}
		else if(material == RABBIT_HIDE){return Material.RABBIT_HIDE;}
		else if(material == RAW_RABBIT){return Material.RABBIT;}
		else if(material == RAW_BEEF){return Material.RAW_BEEF;}
		else if(material == LEATHER){return Material.LEATHER;}
		else if(material == RAW_PORK){return Material.PORK;}
		else if(material == RAW_MUTTON){return Material.MUTTON;}
		
		else if(material == NETHER_WART){return Material.NETHER_STALK;}
		else if(material == QUARTZ_ORE){return Material.QUARTZ_ORE;}
		else if(material == NETHER_BRICK){return Material.NETHER_BRICK_ITEM;}
		else if(material == NETHERRACK){return Material.NETHERRACK;}
		else if(material == QUARTZ){return Material.QUARTZ;}
		else if(material == NETHER_BRICKS){return Material.NETHER_BRICK;}
		
		else{return null;}
	}
	
	public static JobMaterial getJobMaterial(Material material, int durability){
		if(material == Material.COAL){return JobMaterial.COAL;}
		else if(material == Material.IRON_INGOT){return JobMaterial.IRON_INGOT;}
		else if(material == Material.COBBLESTONE){return JobMaterial.COBBLESTONE;}
		else if(material == Material.INK_SACK && durability == 4){return JobMaterial.LAPIS_LAZULI;}
		else if(material == Material.EMERALD){return JobMaterial.EMERALD;}
		else if(material == Material.DIAMOND){return JobMaterial.DIAMOND;}
		else if(material == Material.GOLD_INGOT){return JobMaterial.GOLD_INGOT;}
		else if(material == Material.REDSTONE){return JobMaterial.REDSTONE;}
		
		else if(material == Material.WHEAT){return JobMaterial.WHEAT;}
		else if(material == Material.MELON){return JobMaterial.MELON;}
		else if(material == Material.APPLE){return JobMaterial.APPLE;}
		else if(material == Material.CARROT_ITEM){return JobMaterial.CARROT_ITEM;}
		else if(material == Material.SUGAR_CANE){return JobMaterial.SUGAR_CANE;}
		else if(material == Material.POTATO_ITEM){return JobMaterial.POTATO_ITEM;}
		
		else if(material == Material.LOG && durability == 0){return JobMaterial.OAK_LOG;}
		else if(material == Material.LOG && durability == 1){return JobMaterial.SPRUCE_LOG;}
		else if(material == Material.LOG && durability == 2){return JobMaterial.BIRCH_LOG;}
		else if(material == Material.LOG && durability == 3){return JobMaterial.JUNGLE_LOG;}
		else if(material == Material.LOG_2 && durability == 0){return JobMaterial.ACACIA_LOG;}
		else if(material == Material.LOG_2 && durability == 1){return JobMaterial.DARK_OAK_LOG;}
		
		else if(material == Material.SPIDER_EYE){return JobMaterial.SPIDER_EYE;}
		else if(material == Material.BLAZE_ROD){return JobMaterial.BLAZE_ROD;}
		else if(material == Material.ROTTEN_FLESH){return JobMaterial.ROTTEN_FLESH;}
		else if(material == Material.SKULL_ITEM && durability == 1){return JobMaterial.WITHER_SKELETON_SKULL;}
		else if(material == Material.BONE){return JobMaterial.BONE;}
		else if(material == Material.ENDER_PEARL){return JobMaterial.ENDER_PEARL;}
		else if(material == Material.GHAST_TEAR){return JobMaterial.GHAST_TEAR;}
		else if(material == Material.SULPHUR){return JobMaterial.GUNPOWDER;}
		else if(material == Material.MAGMA_CREAM){return JobMaterial.MAGMA_CREAM;}
		else if(material == Material.SLIME_BALL){return JobMaterial.SLIME_BALL;}
		
		else if(material == Material.FEATHER){return JobMaterial.FEATHER;}
		else if(material == Material.RAW_CHICKEN){return JobMaterial.RAW_CHICKEN;}
		else if(material == Material.RABBIT_HIDE){return JobMaterial.RABBIT_HIDE;}
		else if(material == Material.RABBIT){return JobMaterial.RAW_RABBIT;}
		else if(material == Material.RAW_BEEF){return JobMaterial.RAW_BEEF;}
		else if(material == Material.LEATHER){return JobMaterial.LEATHER;}
		else if(material == Material.PORK){return JobMaterial.RAW_PORK;}
		else if(material == Material.MUTTON){return JobMaterial.RAW_MUTTON;}
		
		else if(material == Material.NETHER_STALK){return JobMaterial.NETHER_WART;}
		else if(material == Material.QUARTZ_ORE){return JobMaterial.QUARTZ_ORE;}
		else if(material == Material.NETHER_BRICK_ITEM){return JobMaterial.NETHER_BRICK;}
		else if(material == Material.NETHERRACK){return JobMaterial.NETHERRACK;}
		else if(material == Material.QUARTZ){return JobMaterial.QUARTZ;}
		else if(material == Material.NETHER_BRICK){return JobMaterial.NETHER_BRICKS;}
		
		else{return null;}
	}
	
	public static short getDurability(JobMaterial material){
		if(material == LAPIS_LAZULI){
			return (short) 4;
		}
		else if(material == SPRUCE_LOG){
			return (short) 1;
		}
		else if(material == BIRCH_LOG){
			return (short) 2;
		}
		else if(material == JUNGLE_LOG){
			return (short) 3;
		}
		else if(material == DARK_OAK_LOG){
			return (short) 1;
		}
		else if(material == WITHER_SKELETON_SKULL){
			return (short) 1;
		}
		else{
			return (short) 0;
		}
	}
}
