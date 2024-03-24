package me.O_o_Fadi_o_O.Survival.jobs.utils;

public enum Job {

	MINER,
	FARMER,
	NETHER_EXPERT,
	POTION_MASTER,
	ANIMAL_FARMER,
	ENCHANTER,
	HUNTER,
	LUMBERJACK,
	FISHER;
	
	public static String getScoreboardName(Job job){
		if(job == MINER){return "Miner";}
		else if(job == FARMER){return "Farmer";}
		else if(job == NETHER_EXPERT){return "Nether Expert";}
		else if(job == POTION_MASTER){return "Potion Master";}
		else if(job == ANIMAL_FARMER){return "Animal Farmer";}
		else if(job == ENCHANTER){return "Enchanter";}
		else if(job == HUNTER){return "Hunter";}
		else if(job == LUMBERJACK){return "Lumberjack";}
		else if(job == FISHER){return "Fisher";}
		else{return null;}
	}
}
