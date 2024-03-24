package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SurvivalGamesData {

	private Arena arena;
	private List<Chest> lootedchests;
	private boolean indeathmatch;
	private OMPlayer firstplace;
	private OMPlayer secondplace;
	private OMPlayer thirdplace;
	private boolean doubleloot;
	private boolean enablepotions;
	
	public SurvivalGamesData(Arena arena){
		this.arena = arena;
		this.lootedchests = new ArrayList<Chest>();
		this.indeathmatch = false;
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		this.doubleloot = false;
		this.enablepotions = false;
	}

	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public List<Chest> getLootedChests() {
		return lootedchests;
	}
	public void setLootedChests(List<Chest> lootedchests) {
		this.lootedchests = lootedchests;
	}

	public boolean isInDeathMatch() {
		return indeathmatch;
	}
	public void setInDeathMatch(boolean indeathmatch) {
		this.indeathmatch = indeathmatch;
	}

	public OMPlayer getFirstPlace() {
		return firstplace;
	}
	public void setFirstPlace(OMPlayer firstplace) {
		this.firstplace = firstplace;
	}

	public OMPlayer getSecondPlace() {
		return secondplace;
	}
	public void setSecondPlace(OMPlayer secondplace) {
		this.secondplace = secondplace;
	}

	public OMPlayer getThirdPlace() {
		return thirdplace;
	}
	public void setThirdPlace(OMPlayer thirdplace) {
		this.thirdplace = thirdplace;
	}

	public boolean isEnablePotions() {
		return enablepotions;
	}
	public void setEnablePotions(boolean enablepotions) {
		this.enablepotions = enablepotions;
	}

	public boolean isDoubleLoot() {
		return doubleloot;
	}
	public void setDoubleLoot(boolean doubleloot) {
		this.doubleloot = doubleloot;
	}
	
	public void restockChests(){
		arena.sendMessage("§a§l§oAll Chests have been restocked!");
		arena.playSound(Sound.LEVEL_UP, 5, 1);
		
		getLootedChests().clear();
	}
	
	public void deathmatch(){
		restockChests();
		setInDeathMatch(true);
		
		arena.setMinutes(3);
		arena.setSeconds(0);
		
		for(OMPlayer omp : arena.getPlayers()){
			if(omp.getPlayer().getVehicle() != null){
				omp.getPlayer().leaveVehicle();
			}
			
			omp.getPlayer().teleport(arena.getMap().getPlayerSpawns().get(omp));
		}
		for(OMPlayer omp : arena.getSpectators()){
			omp.getPlayer().teleport(arena.getMap().getSpectatorLocation());
		}
		
		WorldBorder border = arena.getMap().getSpectatorLocation().getWorld().getWorldBorder();
		border.setCenter(arena.getMap().getSpectatorLocation());
		border.setSize(80);
	}
	
	public void restart(){
		arena.setState(GameState.RESTARTING);
		
		Map map = arena.getMap();
		map.setInUse(false);
		map.restoreWorld();
		arena.setRandomMap();
		
		new BukkitRunnable(){
			public void run(){
				waiting();
			}
		}.runTaskLater(Start.getInstance(), 100);
	}
	
	public void ending(){
		arena.setMinutes(0);
		arena.setSeconds(15);
		
		if(arena.getPlayers().size() == 1){
			setFirstPlace(arena.getPlayers().get(0));
		}
		else{
			List<OMPlayer> players = new ArrayList<OMPlayer>();
			players.addAll(arena.getPlayers());
			
			if(getFirstPlace() == null){
				OMPlayer omp = getMostKills(players);
				setFirstPlace(omp);
				players.remove(omp);
			}
			if(getSecondPlace() == null){
				OMPlayer omp = getMostKills(players);
				setSecondPlace(omp);
				players.remove(omp);
			}
			if(getThirdPlace() == null){
				OMPlayer omp = getMostKills(players);
				setThirdPlace(omp);
				players.remove(omp);
			}
		}
			
		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lSurvival Games §7- §6Results");
		arena.sendMessage("");
		arena.sendMessage(" §61st: " + getFirstPlace().getName());
		arena.sendMessage(" §72nd: " + getSecondPlace().getName());
		arena.sendMessage(" §c3rd: " + getThirdPlace().getName());
		arena.sendMessage("");
		arena.sendMessage("§6§m--------------------------------------------------");
		
		for(OMPlayer omp : arena.getDeadPlayers()){
			omp.getPlayer().sendMessage("§c§l+1 Lose");
			omp.getSGPlayer().addLose();
		}
		
		getFirstPlace().getPlayer().sendMessage("§2§l+1 Win");
		getFirstPlace().getPlayer().sendMessage("§f§l+3 Tickets");
		getFirstPlace().getSGPlayer().addWin();
		getFirstPlace().addMGTickets(3);

		arena.clearScoreboards();
		arena.setState(GameState.ENDING);
	}
	
	public void start(){
		arena.setMinutes(20);
		arena.setSeconds(0);
		
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.getSGPlayer().setRoundKills(0);

			Kit kit = omp.getSGPlayer().getKit();
			if(kit != null){
				TicketType type = TicketType.valueOf(kit.getKitName());
				omp.removeTicket(type);
				
				kit.setItems(omp.getPlayer());
			}
			
			omp.updateInventory();
		}

		arena.getMap().getWorld().setTime(0);
		arena.clearScoreboards();
		arena.setState(GameState.IN_GAME);
	}
	
	public void warmup(){
		arena.setMinutes(0);
		arena.setSeconds(15);
		
		teleportToArena();
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.updateInventory();
			
			for(OMPlayer omplayer : arena.getPlayers()){
				omp.getPlayer().showPlayer(omplayer.getPlayer());
			}
		}
		
		arena.getMap().getWorld().setTime(20000);
		Utils.removeEntities(arena.getMap().getWorld());

		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lSurvival Games §7- §6Info");
		arena.sendMessage("");
		arena.sendMessage(" §a§oGather loot from chests and kill all opponents!");
		arena.sendMessage("");
		arena.sendMessage(" §7Map: §6" + arena.getMap().getMapName());	
		arena.sendMessage(" §7Builders: §6" +  arena.getMap().getBuilder());
		arena.sendMessage("§6§m--------------------------------------------------");
		
		arena.clearScoreboards();
		arena.setState(GameState.WARMUP);
	}
	
	public void waiting(){
		arena.setMinutes(1);
		arena.setSeconds(0);
		arena.setPlayers(new ArrayList<OMPlayer>());
		arena.setDeadPlayers(new ArrayList<OMPlayer>());
		arena.setSpectators(new ArrayList<OMPlayer>());
		
		this.lootedchests = new ArrayList<Chest>();
		this.indeathmatch = false;
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		this.doubleloot = false;
		this.enablepotions = false;
		
		arena.setState(GameState.WAITING);
	}
	
	public void rewardPlayers(){
		for(OMPlayer omp : arena.getAllPlayers()){
			Player p = omp.getPlayer();

			if(arena.isPlayer(omp) || arena.isSpectator(omp) && arena.getDeadPlayers().contains(omp)){
				int amount = 0;
				
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				p.sendMessage("§6§m--------------------------------------------------");
				p.sendMessage(" §f§lSurvival Games §7- §6Rewards");
				p.sendMessage("");
				if(getFirstPlace() == omp){
					p.sendMessage(" §f§l+25 §7(1st Place)");
					amount += 25;
				}
				else if(getSecondPlace() == omp){
					p.sendMessage(" §f§l+15 §7(2nd Place)");
					amount += 15;
				}
				else if(getThirdPlace() == omp){
					p.sendMessage(" §f§l+10 §7(3rd Place)");
					amount += 10;
				}
				else{
					p.sendMessage(" §f§l+5 §7(Patient)");
					amount += 5;
				}
				
				int kills = omp.getSGPlayer().getRoundKills();
				if(kills != 0){
					if(kills == 1){
						p.sendMessage(" §f§l+" + 4 + " §7(1 Kill)");
					}
					else{
						p.sendMessage(" §f§l+" + 4 * kills + " §7(" + kills + " Kills)");
					}
					amount += 4 * kills;
				}
				
				//TODO Boosters
				
				p.sendMessage(" §7New Balance: §f§l" + (omp.getMiniGameCoins() + amount) + " Coins");
				p.sendMessage("§6§m--------------------------------------------------");
				
				omp.addMiniGameCoins(amount);
			}
		}
	}
	
	public void teleportToArena(){
		Map map = getArena().getMap();
		
		for(OMPlayer omp : arena.getPlayers()){
			List<Location> locations = new ArrayList<Location>();
			for(Location l : map.getSpawns()){
				if(!map.getPlayerSpawns().containsValue(l)){
					locations.add(l);
				}
			}
			Location l = locations.get(new Random().nextInt(locations.size()));
			arena.getMap().getPlayerSpawns().put(omp, l);
			
			omp.getPlayer().teleport(l);
		}
	}
	
	public void randomChest(OMPlayer omp, Chest c){
		c.getInventory().clear();
		int size = c.getInventory().getSize();
		
		int extraitems = 0;
		if(isDoubleLoot() || omp.getSGPlayer().isDoubleLoot()){
			extraitems = 6;
		}
		
		for(int i = 0; i <= extraitems + new Random().nextInt(6) +1; i++){
			List<ItemStack> items = new ArrayList<ItemStack>();
			for(ChestItem sgitem : ServerData.getMiniGames().getSGChestItems()){
				for(int amount = 0; amount < sgitem.getPercentage(); amount++){
					items.add(sgitem.getItemStack());
				}
			}
			if(isEnablePotions() || omp.getSGPlayer().isEnablePotions()){
				for(ChestItem sgitem : ServerData.getMiniGames().getSGChestPotions()){
					for(int amount = 0; amount < sgitem.getPercentage(); amount++){
						items.add(sgitem.getItemStack());
					}
				}
			}
			c.getInventory().setItem(new Random().nextInt(size), items.get(new Random().nextInt(items.size())));
		}
		
		c.update();
		getLootedChests().add(c);
	}
	
	public OMPlayer getMostKills(List<OMPlayer> players){
		int highestkills = 0;
		OMPlayer highest = null;
		
		for(OMPlayer omp : players){
			int kills = omp.getSGPlayer().getRoundKills();
			if(kills >= highestkills);{
				highestkills = kills;
			    highest = omp;
			}
		}
		return highest;
	}
}
