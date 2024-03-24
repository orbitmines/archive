package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class UHCData {

	private Arena arena;
	private boolean inpvp;
	private double border;
	private OMPlayer firstplace;
	private OMPlayer secondplace;
	private OMPlayer thirdplace;
	private boolean doubleiron;
	private List<Block> ironoresplaced;
	
	public UHCData(Arena arena){
		this.arena = arena;
		this.inpvp = false;
		this.border = 1000D;
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		this.doubleiron = false;
		this.ironoresplaced = new ArrayList<Block>();
	}

	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public boolean isInPvP() {
		return inpvp;
	}
	public void setInPvP(boolean inpvp) {
		this.inpvp = inpvp;
	}

	public double getBorder() {
		return border;
	}
	public void setBorder(double border) {
		this.border = border;
		
		WorldBorder wb = arena.getMap().getSpectatorLocation().getWorld().getWorldBorder();
		wb.setCenter(arena.getMap().getSpectatorLocation());
		wb.setSize(border);
	}
	public void tickBorder(){
		this.border -= 1.5;
		
		WorldBorder wb = arena.getMap().getSpectatorLocation().getWorld().getWorldBorder();
		wb.setCenter(arena.getMap().getSpectatorLocation());
		wb.setSize(getBorder());
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

	public boolean isDoubleIron() {
		return doubleiron;
	}
	public void setDoubleIron(boolean doubleiron) {
		this.doubleiron = doubleiron;
	}

	public List<Block> getIronOresPlaced() {
		return ironoresplaced;
	}
	public void setIronOresPlaced(List<Block> ironoresplaced) {
		this.ironoresplaced = ironoresplaced;
	}
	
	public void pvp(){
		setInPvP(true);
		
		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lUHC §7- §cPvP §a§lENABLED");
		arena.sendMessage("");
		arena.sendMessage(" §a§oThe Border will shrink §l1.5 Blocks§a§o per second.");
		arena.sendMessage(" §a§oThe World will be §l100x100 Blocks§a§o after 10 minutes.");
		arena.sendMessage("§6§m--------------------------------------------------");
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
		arena.sendMessage(" §f§lUHC §7- §6Results");
		arena.sendMessage("");
		arena.sendMessage(" §61st: " + getFirstPlace().getName());
		arena.sendMessage(" §72nd: " + getSecondPlace().getName());
		arena.sendMessage(" §c3rd: " + getThirdPlace().getName());
		arena.sendMessage("");
		arena.sendMessage("§6§m--------------------------------------------------");
		
		for(OMPlayer omp : arena.getDeadPlayers()){
			omp.getPlayer().sendMessage("§c§l+1 Lose");
			omp.getUHCPlayer().addLose();
		}
		
		getFirstPlace().getPlayer().sendMessage("§2§l+1 Win");
		getFirstPlace().getPlayer().sendMessage("§f§l+5 Tickets");
		getFirstPlace().getUHCPlayer().addWin();
		getFirstPlace().addMGTickets(3);

		arena.clearScoreboards();
		arena.setState(GameState.ENDING);
	}
	
	public void start(){
		arena.setMinutes(30);
		arena.setSeconds(0);
		
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.getUHCPlayer().setRoundKills(0);

			Kit kit = omp.getUHCPlayer().getKit();
			if(kit != null){
				TicketType type = TicketType.valueOf(kit.getKitName());
				omp.removeTicket(type);
				
				kit.setItems(omp.getPlayer());
			}
			
			omp.updateInventory();
		}

		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§cPvP§7 enabled in §6" + (arena.getMinutes() -15) + "m " + arena.getSeconds() + "s§7.");

		setBorder(getBorder());
		arena.getMap().getWorld().setTime(0);
		arena.clearScoreboards();
		arena.setState(GameState.IN_GAME);
	}
	
	public void warmup(){
		int totalseconds = 25 + arena.getPlayers().size() * 5;
		int seconds = totalseconds % 60;
		int minutes = 0;
		
		if(seconds == totalseconds){
			arena.setMinutes(minutes);
			arena.setSeconds(totalseconds);
		}
		else{
			minutes = (totalseconds - seconds) / 60;
			
			arena.setMinutes(minutes);
			arena.setSeconds(seconds);
		}
		
		teleportToWorldLobby();
		
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.updateInventory();
			
			for(OMPlayer omplayer : arena.getPlayers()){
				omp.getPlayer().showPlayer(omplayer.getPlayer());
			}
		}
		
		arena.getMap().getWorld().setTime(0);
		Utils.removeEntities(arena.getMap().getWorld());

		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lUHC §7- §6Info");
		arena.sendMessage("");
		arena.sendMessage(" §a§oGather recources.");
		arena.sendMessage(" §a§oPvP Enabled after 15 minutes.");
		arena.sendMessage(" §a§oThe Border will shrink 1.5 Blocks per second after 15 minutes.");
		arena.sendMessage(" §a§oThe last player alive wins!");
		arena.sendMessage(" §a§oThe Nether is disabled.");
		arena.sendMessage("");	
		arena.sendMessage(" §7Spawn Builders: §6" +  arena.getMap().getBuilder());
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage("§7Teleporting all Players...");
		
		arena.clearScoreboards();
		arena.setState(GameState.WARMUP);
	}
	
	public void waiting(){
		arena.setMinutes(1);
		arena.setSeconds(0);
		arena.setPlayers(new ArrayList<OMPlayer>());
		arena.setDeadPlayers(new ArrayList<OMPlayer>());
		arena.setSpectators(new ArrayList<OMPlayer>());
		
		this.inpvp = false;
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		this.border = 1000D;
		this.doubleiron = false;
		this.ironoresplaced = new ArrayList<Block>();
		
		arena.setState(GameState.WAITING);
	}
	
	public void rewardPlayers(){
		for(OMPlayer omp : arena.getAllPlayers()){
			Player p = omp.getPlayer();

			if(arena.isPlayer(omp) || arena.isSpectator(omp) && arena.getDeadPlayers().contains(omp)){
				int amount = 0;
				
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				p.sendMessage("§6§m--------------------------------------------------");
				p.sendMessage(" §f§lUHC §7- §6Rewards");
				p.sendMessage("");
				if(getFirstPlace() == omp){
					p.sendMessage(" §f§l+200 §7(1st Place)");
					amount += 200;
				}
				else if(getSecondPlace() == omp){
					p.sendMessage(" §f§l+120 §7(2nd Place)");
					amount += 120;
				}
				else if(getThirdPlace() == omp){
					p.sendMessage(" §f§l+80 §7(3rd Place)");
					amount += 80;
				}
				else{
					p.sendMessage(" §f§l+40 §7(Patient)");
					amount += 40;
				}
				
				int kills = omp.getUHCPlayer().getRoundKills();
				if(kills != 0){
					if(kills == 1){
						p.sendMessage(" §f§l+" + 10 + " §7(1 Kill)");
					}
					else{
						p.sendMessage(" §f§l+" + 10 * kills + " §7(" + kills + " Kills)");
					}
					amount += 10 * kills;
				}
				
				//TODO Boosters
				
				p.sendMessage(" §7New Balance: §f§l" + (omp.getMiniGameCoins() + amount) + " Coins");
				p.sendMessage("§6§m--------------------------------------------------");
				
				omp.addMiniGameCoins(amount);
			}
		}
	}
	
	public void teleportToArena(OMPlayer omp){
		Map map = getArena().getMap();
		
		List<Location> locations = new ArrayList<Location>();
		for(Location l : map.getSpawns()){
			if(!map.getPlayerSpawns().containsValue(l)){
				locations.add(l);
			}
		}
		Location l = locations.get(new Random().nextInt(locations.size()));
		Location location = new Location(l.getWorld(), l.getX(), getHighestYPos(l), l.getZ());
		arena.getMap().getPlayerSpawns().put(omp, location);
		arena.getMap().getSpawns().remove(l);
		arena.getMap().getSpawns().add(location);
		
		omp.getPlayer().teleport(location);
		location.getBlock().getRelative(BlockFace.DOWN).setType(Material.BEDROCK);
	}
	
	public int getHighestYPos(Location l){
		for(int i = 250; i > 0; i--){
			Block b = l.getWorld().getBlockAt(l.getBlockX(), i, l.getBlockZ());
			
			if(b != null && !b.isEmpty()){
				return i +1;
			}
		}
		return 100;
	}
	
	public void teleportToWorldLobby(){
		for(OMPlayer omp : arena.getPlayers()){
			omp.getPlayer().teleport(arena.getMap().getSpectatorLocation());
		}
	}

	public int getBorderDistance(OMPlayer omp){
		int distance = 0;
		int x = omp.getPlayer().getLocation().getBlockX();
		int z = omp.getPlayer().getLocation().getBlockZ();
		
		if(x < 0){
			x = -x;
		}
		if(z < 0){
			z = -z;
		}
		
		if(x <= z){
			distance = z;
		}
		else{
			distance = x;
		}
		
		distance = (int) (getBorder() / 2 - distance);
		
		return distance;
	}
	
	public int getSpawnDistance(OMPlayer omp){
		int distance = 0;
		int x = omp.getPlayer().getLocation().getBlockX();
		int z = omp.getPlayer().getLocation().getBlockZ();
		
		if(x < 0){
			x = -x;
		}
		if(z < 0){
			z = -z;
		}
		
		if(x <= z){
			distance = z;
		}
		else{
			distance = x;
		}
		
		return distance;
	}
	
	public OMPlayer getMostKills(List<OMPlayer> players){
		int highestkills = 0;
		OMPlayer highest = null;
		
		for(OMPlayer omp : players){
			int kills = omp.getUHCPlayer().getRoundKills();
			if(kills >= highestkills);{
				highestkills = kills;
			    highest = omp;
			}
		}
		return highest;
	}
}
