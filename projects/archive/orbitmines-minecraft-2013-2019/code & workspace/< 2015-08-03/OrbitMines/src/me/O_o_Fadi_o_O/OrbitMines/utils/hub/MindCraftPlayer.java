package me.O_o_Fadi_o_O.OrbitMines.utils.hub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MindCraftPlayer {

	private Player player;
	private int wins;
	private int bestgame;
	
	private int currentturn;
	private List<String> blocksfromturns;
	private List<String> statusfromturns;
	private String correctturn;
	
	public MindCraftPlayer(Player player, int wins, int bestgame){
		this.player = player;
		this.wins = wins;
		this.bestgame = bestgame;
		this.currentturn = 1;
		this.blocksfromturns = null;
		this.statusfromturns = null;
		this.correctturn = null;
	}

	public Player getPlayer(){
		return player;
	}
	public void setPlayer(Player player){
		this.player = player;
	}

	public int getWins(){
		return wins;
	}
	public void setWins(int wins){
		this.wins = wins;
	}
	public void addWin(){
		this.wins = getWins() +1;
		
		Database.get().update("MasterMind-Wins", "wins", "" + getWins(), "uuid", getPlayer().getUniqueId().toString());
	}

	public int getBestGame(){
		return bestgame;
	}
	public void setBestGame(int bestgame){
		this.bestgame = bestgame;
		
		Database.get().update("MasterMind-BestGame", "turns", "" + getBestGame(), "uuid", getPlayer().getUniqueId().toString());
	}

	public int getCurrentTurn(){
		return currentturn;
	}
	public void setCurrentTurn(int currentturn){
		this.currentturn = currentturn;
	}

	public List<String> getBlocksFromTurns(){
		return blocksfromturns;
	}
	public void setBlocksFromTurns(List<String> blocksfromturns){
		this.blocksfromturns = blocksfromturns;
	}

	public List<String> getStatusFromTurns(){
		return statusfromturns;
	}
	public void setStatusFromTurns(List<String> statusfromturns){
		this.statusfromturns = statusfromturns;
	}

	public String getCorrectTurn(){
		return correctturn;
	}
	public void setCorrectTurn(String correctturn){
		this.correctturn = correctturn;
	}
	
	public static List<MindCraftPlayer> getMCPlayers(){
		return ServerStorage.mcplayers;
	}
	
	public static MindCraftPlayer getMCPlayer(Player player){
		for(MindCraftPlayer mcplayer : ServerStorage.mcplayers){
			if(mcplayer.getPlayer() == player){
				return mcplayer;
			}
		}
		return null;
	}
	
	public static MindCraftPlayer addMCPlayer(Player player, int wins, int bestgame){
		MindCraftPlayer mcplayer = new MindCraftPlayer(player, wins, bestgame);
		ServerStorage.mcplayers.add(mcplayer);
		return mcplayer;
	}	
	
	public void join(){
		Player p = getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(player);
		
		omp.setInMindCraft(true);

		List<String> blockdata = Arrays.asList("0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0", "0|0|0|0");
		
		setBlocksFromTurns(blockdata);
		setStatusFromTurns(blockdata);
		
		setCorrectTurn(getRandomCorrectTurn());
		setCurrentTurn(1);
		
		p.teleport(ServerData.getHub().getMindCraftLocation());
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
		Title t = new Title("§c§lMindCraft", "§7Based on the boardgame 'MasterMind'");
		t.send(p);
		
		p.sendMessage("");
		p.sendMessage(" §c§lMindCraft");

		omp.sendTimeMessage(1, " §7- Goal: Guess the correct combination of colors.",  Sound.CLICK);
		omp.sendTimeMessage(4, " §7- Click with a Wool on the first row to set your turn.",  Sound.CLICK);
		omp.sendTimeMessage(7, " §7- Done? Click the Redstone Torch in your inventory to end your turn.",  Sound.CLICK);
		omp.sendTimeMessage(10, " §7- The Glass Bar on the right displays how well you did on a turn.",  Sound.CLICK);
		omp.sendTimeMessage(13, " §7- §aGreen§7: One of the colors is correct and at the right place.",  Sound.CLICK);
		omp.sendTimeMessage(16, " §7- §eYellow§7: One of the colors is correct but not on the right place.",  Sound.CLICK);
		omp.sendTimeMessage(19, " §7- §fWhite§7: One of the colors isn't correct.",  Sound.CLICK);
		omp.sendTimeMessages(22, Arrays.asList("", " §f§lGood Luck!"), Sound.CLICK);
		
		p.getInventory().clear();
		giveItems();
	}
	
	public void reset(){
		OMPlayer omp = OMPlayer.getOMPlayer(player);
		
		omp.setInMindCraft(false);
		setCurrentTurn(1);
		setBlocksFromTurns(null);
		setStatusFromTurns(null);
		setCorrectTurn(null);
		
		ServerData.getHub().giveLobbyItems(omp);
	}
	
	public void leave(){
		Player p = getPlayer();
		p.getInventory().clear();
		
		reset();
		
		p.sendMessage("§c§lMindCraft §8| §7Come back an other time to play again!");
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
	}
	
	private String getRandomCorrectTurn(){
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
		
	private int getRandomIntForCorrectTurn(List<String> canbe){
		int Rint = new Random().nextInt(canbe.size());
		int i = Integer.parseInt(canbe.get(Rint));

		return i;
	}
	
	public void giveItems(){
		Player p = getPlayer();
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
}
