package me.O_o_Fadi_o_O.SpigotSpleef.managers;

public class BlockManager {

	public static void loadBlocks(){
		for(String block : ConfigManager.config.getConfigurationSection("Blocks").getKeys(false)){
			String toblock = ConfigManager.config.getString("Blocks." + block);
			StorageManager.blocktoblock.put(block, toblock);
		}
	}
}
