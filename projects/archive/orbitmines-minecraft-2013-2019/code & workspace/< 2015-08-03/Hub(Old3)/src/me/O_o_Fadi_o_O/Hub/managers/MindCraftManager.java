package me.O_o_Fadi_o_O.Hub.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MindCraftManager {
	
	static Hub hub = Hub.getInstance();
	
	public static void joinMindCraft(final Player p){
		StorageManager.playersinmindcraft.add(p);

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
		
		StorageManager.mindcraftblocksfromturns.put(p, blockdata);
		StorageManager.mindcraftstatusfromturns.put(p, blockdata);
		
		String correctturn = getRandomCorrectTurn();
		StorageManager.mindcraftcorrectturn.put(p, correctturn);
		
		StorageManager.mindcraftcurrentturn.put(p, 1);
		
		p.teleport(StorageManager.mindcraftlocation);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
		TitleManager.setTitle(p, "§c§lMindCraft", "§7Based on the boardgame 'MasterMind'");
		
		p.sendMessage("");
		p.sendMessage(" §c§lMindCraft");
		

		hub.sendTimeMessage(p, " §7- Goal: Guess the correct combination of colors.", 1, true);
		hub.sendTimeMessage(p, " §7- Click with a Wool on the first row to set your turn.", 4, true);
		hub.sendTimeMessage(p, " §7- Done? Click the Redstone Torch in your inventory to end your turn.", 7, true);
		hub.sendTimeMessage(p, " §7- The Glass Bar on the right displays how well you did on a turn.", 10, true);
		hub.sendTimeMessage(p, " §7- §aGreen§7: One of the colors is correct and at the right place.", 13, true);
		hub.sendTimeMessage(p, " §7- §eYellow§7: One of the colors is correct but not on the right place.", 16, true);
		hub.sendTimeMessage(p, " §7- §fWhite§7: One of the colors isn't correct.", 19, true);
		hub.sendTimeMessage(p, "", 22, false);
		hub.sendTimeMessage(p, " §f§lGood Luck!", 22, true);
		
		p.getInventory().clear();
		giveMindCraftItems(p);
	}
	
	public static void leaveMindCraft(Player p){
		
		StorageManager.playersinmindcraft.remove(p);
		StorageManager.mindcraftcurrentturn.remove(p);
		StorageManager.mindcraftblocksfromturns.remove(p);
		StorageManager.mindcraftstatusfromturns.remove(p);
		StorageManager.mindcraftcorrectturn.remove(p);
		
		p.getInventory().clear();
		p.sendMessage("§c§lMindCraft §8| §7Come back an other time to play again!");
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		
	}
	
	public static String getRandomCorrectTurn(){
		List<String> canbe = new ArrayList<String>();
		canbe.add("1");
		canbe.add("3");
		canbe.add("4");
		canbe.add("5");
		canbe.add("11");
		canbe.add("14");
		int first = getRandomIntForCorrectTurn(canbe);
		canbe.remove("" + first);
		int second = getRandomIntForCorrectTurn(canbe);
		canbe.remove("" + second);
		int thirth = getRandomIntForCorrectTurn(canbe);
		canbe.remove("" + thirth);
		int fourth = getRandomIntForCorrectTurn(canbe);
		canbe.remove("" + fourth);
		
		String correctturn = first + "|" + second + "|" + thirth + "|" + fourth;
		
		return correctturn;
	}
		
	public static int getRandomIntForCorrectTurn(List<String> canbe){
		int Rint = new Random().nextInt(canbe.size());
		int i = Integer.parseInt(canbe.get(Rint));

		return i;
	}
	
	public static void giveMindCraftItems(Player p){
		
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
		blocksforturn0.add(w.getBlockAt(new Location(w, 42, 75, 5)));
		blocksforturn0.add(w.getBlockAt(new Location(w, 40, 75, 5)));
		blocksforturn0.add(w.getBlockAt(new Location(w, 38, 75, 5)));
		blocksforturn0.add(w.getBlockAt(new Location(w, 36, 75, 5)));
		StorageManager.mindcraftblocksforturn.put(0, blocksforturn0);
		
		List<Block> blocksforturn1 = new ArrayList<Block>();
		blocksforturn1.add(w.getBlockAt(new Location(w, 42, 74, 8)));
		blocksforturn1.add(w.getBlockAt(new Location(w, 40, 74, 8)));
		blocksforturn1.add(w.getBlockAt(new Location(w, 38, 74, 8)));
		blocksforturn1.add(w.getBlockAt(new Location(w, 36, 74, 8)));
		StorageManager.mindcraftblocksforturn.put(1, blocksforturn1);
		
		List<Block> blocksforturn2 = new ArrayList<Block>();
		blocksforturn2.add(w.getBlockAt(new Location(w, 42, 74, 10)));
		blocksforturn2.add(w.getBlockAt(new Location(w, 40, 74, 10)));
		blocksforturn2.add(w.getBlockAt(new Location(w, 38, 74, 10)));
		blocksforturn2.add(w.getBlockAt(new Location(w, 36, 74, 10)));
		StorageManager.mindcraftblocksforturn.put(2, blocksforturn2);
		
		List<Block> blocksforturn3 = new ArrayList<Block>();
		blocksforturn3.add(w.getBlockAt(new Location(w, 42, 74, 12)));
		blocksforturn3.add(w.getBlockAt(new Location(w, 40, 74, 12)));
		blocksforturn3.add(w.getBlockAt(new Location(w, 38, 74, 12)));
		blocksforturn3.add(w.getBlockAt(new Location(w, 36, 74, 12)));
		StorageManager.mindcraftblocksforturn.put(3, blocksforturn3);
		
		List<Block> blocksforturn4 = new ArrayList<Block>();
		blocksforturn4.add(w.getBlockAt(new Location(w, 42, 74, 14)));
		blocksforturn4.add(w.getBlockAt(new Location(w, 40, 74, 14)));
		blocksforturn4.add(w.getBlockAt(new Location(w, 38, 74, 14)));
		blocksforturn4.add(w.getBlockAt(new Location(w, 36, 74, 14)));
		StorageManager.mindcraftblocksforturn.put(4, blocksforturn4);
		
		List<Block> blocksforturn5 = new ArrayList<Block>();
		blocksforturn5.add(w.getBlockAt(new Location(w, 42, 74, 16)));
		blocksforturn5.add(w.getBlockAt(new Location(w, 40, 74, 16)));
		blocksforturn5.add(w.getBlockAt(new Location(w, 38, 74, 16)));
		blocksforturn5.add(w.getBlockAt(new Location(w, 36, 74, 16)));
		StorageManager.mindcraftblocksforturn.put(5, blocksforturn5);
		
		List<Block> blocksforturn6 = new ArrayList<Block>();
		blocksforturn6.add(w.getBlockAt(new Location(w, 42, 74, 18)));
		blocksforturn6.add(w.getBlockAt(new Location(w, 40, 74, 18)));
		blocksforturn6.add(w.getBlockAt(new Location(w, 38, 74, 18)));
		blocksforturn6.add(w.getBlockAt(new Location(w, 36, 74, 18)));
		StorageManager.mindcraftblocksforturn.put(6, blocksforturn6);
		
		List<Block> blocksforturn7 = new ArrayList<Block>();
		blocksforturn7.add(w.getBlockAt(new Location(w, 42, 74, 20)));
		blocksforturn7.add(w.getBlockAt(new Location(w, 40, 74, 20)));
		blocksforturn7.add(w.getBlockAt(new Location(w, 38, 74, 20)));
		blocksforturn7.add(w.getBlockAt(new Location(w, 36, 74, 20)));
		StorageManager.mindcraftblocksforturn.put(7, blocksforturn7);
		
		List<Block> blocksforturn8 = new ArrayList<Block>();
		blocksforturn8.add(w.getBlockAt(new Location(w, 42, 74, 22)));
		blocksforturn8.add(w.getBlockAt(new Location(w, 40, 74, 22)));
		blocksforturn8.add(w.getBlockAt(new Location(w, 38, 74, 22)));
		blocksforturn8.add(w.getBlockAt(new Location(w, 36, 74, 22)));
		StorageManager.mindcraftblocksforturn.put(8, blocksforturn8);
		
		List<Block> blocksforturn9 = new ArrayList<Block>();
		blocksforturn9.add(w.getBlockAt(new Location(w, 42, 74, 24)));
		blocksforturn9.add(w.getBlockAt(new Location(w, 40, 74, 24)));
		blocksforturn9.add(w.getBlockAt(new Location(w, 38, 74, 24)));
		blocksforturn9.add(w.getBlockAt(new Location(w, 36, 74, 24)));
		StorageManager.mindcraftblocksforturn.put(9, blocksforturn9);
		
		List<Block> blocksforturn10 = new ArrayList<Block>();
		blocksforturn10.add(w.getBlockAt(new Location(w, 42, 74, 26)));
		blocksforturn10.add(w.getBlockAt(new Location(w, 40, 74, 26)));
		blocksforturn10.add(w.getBlockAt(new Location(w, 38, 74, 26)));
		blocksforturn10.add(w.getBlockAt(new Location(w, 36, 74, 26)));
		StorageManager.mindcraftblocksforturn.put(10, blocksforturn10);
		
		List<Block> blocksforturn11 = new ArrayList<Block>();
		blocksforturn11.add(w.getBlockAt(new Location(w, 42, 76, 29)));
		blocksforturn11.add(w.getBlockAt(new Location(w, 40, 76, 29)));
		blocksforturn11.add(w.getBlockAt(new Location(w, 38, 76, 29)));
		blocksforturn11.add(w.getBlockAt(new Location(w, 36, 76, 29)));
		StorageManager.mindcraftblocksforturn.put(11, blocksforturn11);
	}
	
	public static void registerAllBlockStatusForTurn(World w){
		
		List<Block> blocksforturn1 = new ArrayList<Block>();
		blocksforturn1.add(w.getBlockAt(new Location(w, 32, 76, 8)));
		blocksforturn1.add(w.getBlockAt(new Location(w, 32, 77, 8)));
		blocksforturn1.add(w.getBlockAt(new Location(w, 32, 78, 8)));
		blocksforturn1.add(w.getBlockAt(new Location(w, 32, 79, 8)));
		StorageManager.mindcraftblocksforturnstatus.put(1, blocksforturn1);
		
		List<Block> blocksforturn2 = new ArrayList<Block>();
		blocksforturn2.add(w.getBlockAt(new Location(w, 32, 76, 10)));
		blocksforturn2.add(w.getBlockAt(new Location(w, 32, 77, 10)));
		blocksforturn2.add(w.getBlockAt(new Location(w, 32, 78, 10)));
		blocksforturn2.add(w.getBlockAt(new Location(w, 32, 79, 10)));
		StorageManager.mindcraftblocksforturnstatus.put(2, blocksforturn2);
		
		List<Block> blocksforturn3 = new ArrayList<Block>();
		blocksforturn3.add(w.getBlockAt(new Location(w, 32, 76, 12)));
		blocksforturn3.add(w.getBlockAt(new Location(w, 32, 77, 12)));
		blocksforturn3.add(w.getBlockAt(new Location(w, 32, 78, 12)));
		blocksforturn3.add(w.getBlockAt(new Location(w, 32, 79, 12)));
		StorageManager.mindcraftblocksforturnstatus.put(3, blocksforturn3);
		
		List<Block> blocksforturn4 = new ArrayList<Block>();
		blocksforturn4.add(w.getBlockAt(new Location(w, 32, 76, 14)));
		blocksforturn4.add(w.getBlockAt(new Location(w, 32, 77, 14)));
		blocksforturn4.add(w.getBlockAt(new Location(w, 32, 78, 14)));
		blocksforturn4.add(w.getBlockAt(new Location(w, 32, 79, 14)));
		StorageManager.mindcraftblocksforturnstatus.put(4, blocksforturn4);
		
		List<Block> blocksforturn5 = new ArrayList<Block>();
		blocksforturn5.add(w.getBlockAt(new Location(w, 32, 76, 16)));
		blocksforturn5.add(w.getBlockAt(new Location(w, 32, 77, 16)));
		blocksforturn5.add(w.getBlockAt(new Location(w, 32, 78, 16)));
		blocksforturn5.add(w.getBlockAt(new Location(w, 32, 79, 16)));
		StorageManager.mindcraftblocksforturnstatus.put(5, blocksforturn5);
		
		List<Block> blocksforturn6 = new ArrayList<Block>();
		blocksforturn6.add(w.getBlockAt(new Location(w, 32, 76, 18)));
		blocksforturn6.add(w.getBlockAt(new Location(w, 32, 77, 18)));
		blocksforturn6.add(w.getBlockAt(new Location(w, 32, 78, 18)));
		blocksforturn6.add(w.getBlockAt(new Location(w, 32, 79, 18)));
		StorageManager.mindcraftblocksforturnstatus.put(6, blocksforturn6);
		
		List<Block> blocksforturn7 = new ArrayList<Block>();
		blocksforturn7.add(w.getBlockAt(new Location(w, 32, 76, 20)));
		blocksforturn7.add(w.getBlockAt(new Location(w, 32, 77, 20)));
		blocksforturn7.add(w.getBlockAt(new Location(w, 32, 78, 20)));
		blocksforturn7.add(w.getBlockAt(new Location(w, 32, 79, 20)));
		StorageManager.mindcraftblocksforturnstatus.put(7, blocksforturn7);
		
		List<Block> blocksforturn8 = new ArrayList<Block>();
		blocksforturn8.add(w.getBlockAt(new Location(w, 32, 76, 22)));
		blocksforturn8.add(w.getBlockAt(new Location(w, 32, 77, 22)));
		blocksforturn8.add(w.getBlockAt(new Location(w, 32, 78, 22)));
		blocksforturn8.add(w.getBlockAt(new Location(w, 32, 79, 22)));
		StorageManager.mindcraftblocksforturnstatus.put(8, blocksforturn8);
		
		List<Block> blocksforturn9 = new ArrayList<Block>();
		blocksforturn9.add(w.getBlockAt(new Location(w, 32, 76, 24)));
		blocksforturn9.add(w.getBlockAt(new Location(w, 32, 77, 24)));
		blocksforturn9.add(w.getBlockAt(new Location(w, 32, 78, 24)));
		blocksforturn9.add(w.getBlockAt(new Location(w, 32, 79, 24)));
		StorageManager.mindcraftblocksforturnstatus.put(9, blocksforturn9);
		
		List<Block> blocksforturn10 = new ArrayList<Block>();
		blocksforturn10.add(w.getBlockAt(new Location(w, 32, 76, 26)));
		blocksforturn10.add(w.getBlockAt(new Location(w, 32, 77, 26)));
		blocksforturn10.add(w.getBlockAt(new Location(w, 32, 78, 26)));
		blocksforturn10.add(w.getBlockAt(new Location(w, 32, 79, 26)));
		StorageManager.mindcraftblocksforturnstatus.put(10, blocksforturn10);
	}
}
