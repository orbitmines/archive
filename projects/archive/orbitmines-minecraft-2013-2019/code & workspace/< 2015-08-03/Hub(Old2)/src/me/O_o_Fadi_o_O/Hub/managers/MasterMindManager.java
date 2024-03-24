package me.O_o_Fadi_o_O.Hub.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MasterMindManager {
	
	public static void joinMasterMind(Player p){
		StorageManager.PlayersInMasterMind.add(p);

		List<String> blockdata = new ArrayList<String>();
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		blockdata.add("0|0|0|0");
		
		StorageManager.MasterMindBlocksFromTurns.put(p, blockdata);
		
		StorageManager.MasterMindStatusFromTurns.put(p, blockdata);
		
		String correctturn = getRandomCorrectTurn();
		StorageManager.MasterMindCorrectTurn.put(p, correctturn);
		
		StorageManager.MasterMindCurrentTurn.put(p, 1);
		StorageManager.MasterMindAnimation.put(p, true);
		StorageManager.MasterMindAnimationSeconds.put(p, 0);
		
		p.teleport(StorageManager.MasterMindLocation);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
		p.sendMessage(" §c§lMasterMind");
		p.sendMessage("");
		p.sendMessage(" §7- Goal: Guess the correct combination of colors.");
		p.sendMessage(" §7- Click with a Wool on the first row to set your turn.");
		p.sendMessage(" §7- Done? Click the Redstone Torch in your inventory to end your turn.");
		p.sendMessage(" §7- The Glass Bar on the right displays how well you did on a turn.");
		p.sendMessage(" §7- §aGreen§7: One of the colors is correct and at the right place.");
		p.sendMessage(" §7- §eYellow§7: One of the colors is correct but not on the right place.");
		p.sendMessage(" §7- §fWhite§7: One of the colors isn't correct.");
		p.sendMessage("");
		p.sendMessage(" §f§lGood Luck!");
		p.sendMessage("");
		
		p.getInventory().clear();
	}
	
	public static void leaveMasterMind(Player p){
		
		StorageManager.PlayersInMasterMind.remove(p);
		StorageManager.MasterMindAnimation.remove(p);
		StorageManager.MasterMindAnimationSeconds.remove(p);
		StorageManager.MasterMindCurrentTurn.remove(p);
		StorageManager.MasterMindBlocksFromTurns.remove(p);
		StorageManager.MasterMindStatusFromTurns.remove(p);
		StorageManager.MasterMindCorrectTurn.remove(p);
		
		p.getInventory().clear();
		p.sendMessage("§c§lMasterMind §8| §7Come back an other time to play again!");
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void animateBlocks(Player p, int Turn){		
		for(Block b : StorageManager.MasterMindBlocksForTurn.get(Turn)){
			p.playEffect(b.getLocation(), Effect.STEP_SOUND, Material.WOOL);
			p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) getRandomIntForCorrectTurn());
		}
		
		if(Turn == 11){
			for(int i = 0; i <= Turn; i++){
				for(Block b : StorageManager.MasterMindBlocksForTurn.get(i)){
					p.sendBlockChange(b.getLocation(), Material.WOOL, b.getData());
				}
			}
			
			StorageManager.MasterMindAnimation.put(p, false);
			giveMasterMindItems(p);
		}
	}
	
	public static String getRandomCorrectTurn(){
		
		String correctturn = getRandomIntForCorrectTurn() + "|" + getRandomIntForCorrectTurn() + "|" + getRandomIntForCorrectTurn() + "|" + getRandomIntForCorrectTurn();
		
		return correctturn;
	}
		
	public static int getRandomIntForCorrectTurn(){
		int i = 0;
		
		int Rint = new Random().nextInt(6);
		if(Rint == 0){i = 1;}
		if(Rint == 1){i = 3;}
		if(Rint == 2){i = 4;}
		if(Rint == 3){i = 5;}
		if(Rint == 4){i = 11;}
		if(Rint == 5){i = 14;}
		
		return i;
	}
	
	public static void giveMasterMindItems(Player p){
		
		{
			ItemStack item = new ItemStack(Material.TNT, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§4§lReset Colors");
			item.setItemMeta(meta);
			p.getInventory().setItem(0, item);
		}
		{
			ItemStack item = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§c§lEnd Turn");
			item.setItemMeta(meta);
			p.getInventory().setItem(1, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§1§lBlue");
			item.setItemMeta(meta);
			item.setDurability((short) 11);
			p.getInventory().setItem(3, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§e§lYellow");
			item.setItemMeta(meta);
			item.setDurability((short) 4);
			p.getInventory().setItem(4, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§a§lGreen");
			item.setItemMeta(meta);
			item.setDurability((short) 5);
			p.getInventory().setItem(5, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§c§lRed");
			item.setItemMeta(meta);
			item.setDurability((short) 14);
			p.getInventory().setItem(6, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§b§lLight Blue");
			item.setItemMeta(meta);
			item.setDurability((short) 3);
			p.getInventory().setItem(7, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOL, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§lOrange");
			item.setItemMeta(meta);
			item.setDurability((short) 1);
			p.getInventory().setItem(8, item);
		}
	}
	
	public static void registerAllBlocksForTurn(World w){
		
		List<Block> blocksforturn0 = new ArrayList<Block>();
		blocksforturn0.add(w.getBlockAt(new Location(w, -443, 42, 982)));
		blocksforturn0.add(w.getBlockAt(new Location(w, -445, 42, 982)));
		blocksforturn0.add(w.getBlockAt(new Location(w, -447, 42, 982)));
		blocksforturn0.add(w.getBlockAt(new Location(w, -449, 42, 982)));
		StorageManager.MasterMindBlocksForTurn.put(0, blocksforturn0);
		
		List<Block> blocksforturn1 = new ArrayList<Block>();
		blocksforturn1.add(w.getBlockAt(new Location(w, -443, 41, 985)));
		blocksforturn1.add(w.getBlockAt(new Location(w, -445, 41, 985)));
		blocksforturn1.add(w.getBlockAt(new Location(w, -447, 41, 985)));
		blocksforturn1.add(w.getBlockAt(new Location(w, -449, 41, 985)));
		StorageManager.MasterMindBlocksForTurn.put(1, blocksforturn1);
		
		List<Block> blocksforturn2 = new ArrayList<Block>();
		blocksforturn2.add(w.getBlockAt(new Location(w, -443, 41, 987)));
		blocksforturn2.add(w.getBlockAt(new Location(w, -445, 41, 987)));
		blocksforturn2.add(w.getBlockAt(new Location(w, -447, 41, 987)));
		blocksforturn2.add(w.getBlockAt(new Location(w, -449, 41, 987)));
		StorageManager.MasterMindBlocksForTurn.put(2, blocksforturn2);
		
		List<Block> blocksforturn3 = new ArrayList<Block>();
		blocksforturn3.add(w.getBlockAt(new Location(w, -443, 41, 989)));
		blocksforturn3.add(w.getBlockAt(new Location(w, -445, 41, 989)));
		blocksforturn3.add(w.getBlockAt(new Location(w, -447, 41, 989)));
		blocksforturn3.add(w.getBlockAt(new Location(w, -449, 41, 989)));
		StorageManager.MasterMindBlocksForTurn.put(3, blocksforturn3);
		
		List<Block> blocksforturn4 = new ArrayList<Block>();
		blocksforturn4.add(w.getBlockAt(new Location(w, -443, 41, 991)));
		blocksforturn4.add(w.getBlockAt(new Location(w, -445, 41, 991)));
		blocksforturn4.add(w.getBlockAt(new Location(w, -447, 41, 991)));
		blocksforturn4.add(w.getBlockAt(new Location(w, -449, 41, 991)));
		StorageManager.MasterMindBlocksForTurn.put(4, blocksforturn4);
		
		List<Block> blocksforturn5 = new ArrayList<Block>();
		blocksforturn5.add(w.getBlockAt(new Location(w, -443, 41, 993)));
		blocksforturn5.add(w.getBlockAt(new Location(w, -445, 41, 993)));
		blocksforturn5.add(w.getBlockAt(new Location(w, -447, 41, 993)));
		blocksforturn5.add(w.getBlockAt(new Location(w, -449, 41, 993)));
		StorageManager.MasterMindBlocksForTurn.put(5, blocksforturn5);
		
		List<Block> blocksforturn6 = new ArrayList<Block>();
		blocksforturn6.add(w.getBlockAt(new Location(w, -443, 41, 995)));
		blocksforturn6.add(w.getBlockAt(new Location(w, -445, 41, 995)));
		blocksforturn6.add(w.getBlockAt(new Location(w, -447, 41, 995)));
		blocksforturn6.add(w.getBlockAt(new Location(w, -449, 41, 995)));
		StorageManager.MasterMindBlocksForTurn.put(6, blocksforturn6);
		
		List<Block> blocksforturn7 = new ArrayList<Block>();
		blocksforturn7.add(w.getBlockAt(new Location(w, -443, 41, 997)));
		blocksforturn7.add(w.getBlockAt(new Location(w, -445, 41, 997)));
		blocksforturn7.add(w.getBlockAt(new Location(w, -447, 41, 997)));
		blocksforturn7.add(w.getBlockAt(new Location(w, -449, 41, 997)));
		StorageManager.MasterMindBlocksForTurn.put(7, blocksforturn7);
		
		List<Block> blocksforturn8 = new ArrayList<Block>();
		blocksforturn8.add(w.getBlockAt(new Location(w, -443, 41, 999)));
		blocksforturn8.add(w.getBlockAt(new Location(w, -445, 41, 999)));
		blocksforturn8.add(w.getBlockAt(new Location(w, -447, 41, 999)));
		blocksforturn8.add(w.getBlockAt(new Location(w, -449, 41, 999)));
		StorageManager.MasterMindBlocksForTurn.put(8, blocksforturn8);
		
		List<Block> blocksforturn9 = new ArrayList<Block>();
		blocksforturn9.add(w.getBlockAt(new Location(w, -443, 41, 1001)));
		blocksforturn9.add(w.getBlockAt(new Location(w, -445, 41, 1001)));
		blocksforturn9.add(w.getBlockAt(new Location(w, -447, 41, 1001)));
		blocksforturn9.add(w.getBlockAt(new Location(w, -449, 41, 1001)));
		StorageManager.MasterMindBlocksForTurn.put(9, blocksforturn9);
		
		List<Block> blocksforturn10 = new ArrayList<Block>();
		blocksforturn10.add(w.getBlockAt(new Location(w, -443, 41, 1003)));
		blocksforturn10.add(w.getBlockAt(new Location(w, -445, 41, 1003)));
		blocksforturn10.add(w.getBlockAt(new Location(w, -447, 41, 1003)));
		blocksforturn10.add(w.getBlockAt(new Location(w, -449, 41, 1003)));
		StorageManager.MasterMindBlocksForTurn.put(10, blocksforturn10);
		
		List<Block> blocksforturn11 = new ArrayList<Block>();
		blocksforturn11.add(w.getBlockAt(new Location(w, -443, 43, 1006)));
		blocksforturn11.add(w.getBlockAt(new Location(w, -445, 43, 1006)));
		blocksforturn11.add(w.getBlockAt(new Location(w, -447, 43, 1006)));
		blocksforturn11.add(w.getBlockAt(new Location(w, -449, 43, 1006)));
		StorageManager.MasterMindBlocksForTurn.put(11, blocksforturn11);
	}
	
	public static void registerAllBlockStatusForTurn(World w){
		
		List<Block> blocksforturn1 = new ArrayList<Block>();
		blocksforturn1.add(w.getBlockAt(new Location(w, -453, 43, 985)));
		blocksforturn1.add(w.getBlockAt(new Location(w, -453, 44, 985)));
		blocksforturn1.add(w.getBlockAt(new Location(w, -453, 45, 985)));
		blocksforturn1.add(w.getBlockAt(new Location(w, -453, 46, 985)));
		StorageManager.MasterMindBlocksForTurnStatus.put(1, blocksforturn1);
		
		List<Block> blocksforturn2 = new ArrayList<Block>();
		blocksforturn2.add(w.getBlockAt(new Location(w, -453, 43, 987)));
		blocksforturn2.add(w.getBlockAt(new Location(w, -453, 44, 987)));
		blocksforturn2.add(w.getBlockAt(new Location(w, -453, 45, 987)));
		blocksforturn2.add(w.getBlockAt(new Location(w, -453, 46, 987)));
		StorageManager.MasterMindBlocksForTurnStatus.put(2, blocksforturn2);
		
		List<Block> blocksforturn3 = new ArrayList<Block>();
		blocksforturn3.add(w.getBlockAt(new Location(w, -453, 43, 989)));
		blocksforturn3.add(w.getBlockAt(new Location(w, -453, 44, 989)));
		blocksforturn3.add(w.getBlockAt(new Location(w, -453, 45, 989)));
		blocksforturn3.add(w.getBlockAt(new Location(w, -453, 46, 989)));
		StorageManager.MasterMindBlocksForTurnStatus.put(3, blocksforturn3);
		
		List<Block> blocksforturn4 = new ArrayList<Block>();
		blocksforturn4.add(w.getBlockAt(new Location(w, -453, 43, 991)));
		blocksforturn4.add(w.getBlockAt(new Location(w, -453, 44, 991)));
		blocksforturn4.add(w.getBlockAt(new Location(w, -453, 45, 991)));
		blocksforturn4.add(w.getBlockAt(new Location(w, -453, 46, 991)));
		StorageManager.MasterMindBlocksForTurnStatus.put(4, blocksforturn4);
		
		List<Block> blocksforturn5 = new ArrayList<Block>();
		blocksforturn5.add(w.getBlockAt(new Location(w, -453, 43, 993)));
		blocksforturn5.add(w.getBlockAt(new Location(w, -453, 44, 993)));
		blocksforturn5.add(w.getBlockAt(new Location(w, -453, 45, 993)));
		blocksforturn5.add(w.getBlockAt(new Location(w, -453, 46, 993)));
		StorageManager.MasterMindBlocksForTurnStatus.put(5, blocksforturn5);
		
		List<Block> blocksforturn6 = new ArrayList<Block>();
		blocksforturn6.add(w.getBlockAt(new Location(w, -453, 43, 995)));
		blocksforturn6.add(w.getBlockAt(new Location(w, -453, 44, 995)));
		blocksforturn6.add(w.getBlockAt(new Location(w, -453, 45, 995)));
		blocksforturn6.add(w.getBlockAt(new Location(w, -453, 46, 995)));
		StorageManager.MasterMindBlocksForTurnStatus.put(6, blocksforturn6);
		
		List<Block> blocksforturn7 = new ArrayList<Block>();
		blocksforturn7.add(w.getBlockAt(new Location(w, -453, 43, 997)));
		blocksforturn7.add(w.getBlockAt(new Location(w, -453, 44, 997)));
		blocksforturn7.add(w.getBlockAt(new Location(w, -453, 45, 997)));
		blocksforturn7.add(w.getBlockAt(new Location(w, -453, 46, 997)));
		StorageManager.MasterMindBlocksForTurnStatus.put(7, blocksforturn7);
		
		List<Block> blocksforturn8 = new ArrayList<Block>();
		blocksforturn8.add(w.getBlockAt(new Location(w, -453, 43, 999)));
		blocksforturn8.add(w.getBlockAt(new Location(w, -453, 44, 999)));
		blocksforturn8.add(w.getBlockAt(new Location(w, -453, 45, 999)));
		blocksforturn8.add(w.getBlockAt(new Location(w, -453, 46, 999)));
		StorageManager.MasterMindBlocksForTurnStatus.put(8, blocksforturn8);
		
		List<Block> blocksforturn9 = new ArrayList<Block>();
		blocksforturn9.add(w.getBlockAt(new Location(w, -453, 43, 1001)));
		blocksforturn9.add(w.getBlockAt(new Location(w, -453, 44, 1001)));
		blocksforturn9.add(w.getBlockAt(new Location(w, -453, 45, 1001)));
		blocksforturn9.add(w.getBlockAt(new Location(w, -453, 46, 1001)));
		StorageManager.MasterMindBlocksForTurnStatus.put(9, blocksforturn9);
		
		List<Block> blocksforturn10 = new ArrayList<Block>();
		blocksforturn10.add(w.getBlockAt(new Location(w, -453, 43, 1003)));
		blocksforturn10.add(w.getBlockAt(new Location(w, -453, 44, 1003)));
		blocksforturn10.add(w.getBlockAt(new Location(w, -453, 45, 1003)));
		blocksforturn10.add(w.getBlockAt(new Location(w, -453, 46, 1003)));
		StorageManager.MasterMindBlocksForTurnStatus.put(10, blocksforturn10);
	}
}
