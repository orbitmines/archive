package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.Letters;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Direction;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.MineType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Mine {

	private Rank rank;
	private MineType type;
	private List<Block> blocks;
	private List<MineBlock> mineblocks;
	private List<Block> timerblocks;
	private Location spawn;
	private Location timer;
	private Location resetlocation;
	private Location timersign;
	private Location clocksign;
	private Location goldsign;
	private Location ranksign;
	private Location rankupsign;
	private int minutes;
	private int seconds;
	
	public Mine(Rank rank, List<Block> blocks, List<MineBlock> mineblocks, Location spawn, Location timer, Location resetlocation, Location timersign, Location clocksign, Location goldsign, Location ranksign, Location rankupsign){
		this.rank = rank;
		this.type = MineType.NORMAL;
		this.blocks = blocks;
		this.mineblocks = mineblocks;
		this.spawn = spawn;
		this.timer = timer;
		this.timerblocks = Utils.getBlocksBetween(getTimer(), new Location(getTimer().getWorld(), getTimer().getX() +16, getTimer().getY() +4, getTimer().getZ()));
		this.resetlocation = resetlocation;
		this.timersign = timersign;
		this.clocksign = clocksign;
		this.goldsign = goldsign;
		this.ranksign = ranksign;
		this.rankupsign = rankupsign;
		
		reset(null);
	}
	
	public Mine(Rank rank, List<Block> blocks){
		this.rank = rank;
		this.type = MineType.WOOD;
		this.blocks = blocks;
	}

	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public MineType getType() {
		return type;
	}
	public void setType(MineType type) {
		this.type = type;
	}

	public List<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public List<MineBlock> getMineBlocks() {
		return mineblocks;
	}
	public void setMineBlocks(List<MineBlock> mineblocks) {
		this.mineblocks = mineblocks;
	}

	public Location getSpawn() {
		return spawn;
	}
	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}

	public Location getTimer() {
		return timer;
	}
	public void setTimer(Location timer) {
		this.timer = timer;
	}

	public Location getResetLocation() {
		return resetlocation;
	}
	public void setResetLocation(Location resetlocation) {
		this.resetlocation = resetlocation;
	}

	public Location getTimerSign() {
		return timersign;
	}
	public void setTimerSign(Location timersign) {
		this.timersign = timersign;
	}

	public Location getClockSign() {
		return clocksign;
	}
	public void setClockSign(Location clocksign) {
		this.clocksign = clocksign;
	}

	public Location getGoldSign() {
		return goldsign;
	}
	public void setGoldSign(Location goldsign) {
		this.goldsign = goldsign;
	}

	public Location getRankSign() {
		return ranksign;
	}
	public void setRankSign(Location ranksign) {
		this.ranksign = ranksign;
	}

	public Location getRankupSign() {
		return rankupsign;
	}
	public void setRankupSign(Location rankupsign) {
		this.rankupsign = rankupsign;
	}
	
	public void updateSigns(){
		String[] timersign = new String[4];
		
		for(OMPlayer omp : OMPlayer.getOMPlayers()){
			Player p = omp.getPlayer();
			
			if(p.getWorld().getName().equals(ServerData.getPrison().getPrisonWorld().getName())){
				PrisonPlayer pp = omp.getPrisonPlayer();
				
				if(pp.hasPerms(getRank())){
					String[] clocksign = new String[4];
					String[] goldsign = new String[4];
					String[] ranksign = new String[4];
					String[] rankupsign = new String[4];
					
					if(p.getLocation().distance(getTimerSign()) <= 16){
						String minutes = getMinutes() + "";
						String seconds = getSeconds() + "";
						
						if(getMinutes() < 10){
							minutes = "0" + minutes;
						}
						if(getSeconds() < 10){
							seconds = "0" + seconds;
						}
						
						timersign[0] = "";
						timersign[1] = "§lReset Timer";
						timersign[2] = "§o" + minutes + ":" + seconds;
						timersign[3] = "";
						p.sendSignChange(getTimerSign(), timersign);
						
						clocksign[0] = "";
						if(pp.isClockEnabled()){
							clocksign[0] = "Lagg Problems?";
						}
						
						clocksign[1] = "§lToggle Clock";
						clocksign[2] = "";
						
						clocksign[3] = "§lClock §c§lOFF";
						if(pp.isClockEnabled()){
							clocksign[3] = "§lClock §a§lON";
						}
						p.sendSignChange(getClockSign(), clocksign);
					}
					
					if(p.getLocation().distance(getRankSign()) <= 16){
						goldsign[0] = "";
						goldsign[1] = "§lYour Gold";
						goldsign[2] = "§6§l" + pp.getGold();
						goldsign[3] = "";
						p.sendSignChange(getGoldSign(), goldsign);
						
						ranksign[0] = "";
						ranksign[1] = "§lYour Rank";
						ranksign[2] = "§a§l" + pp.getRank().toString();
						ranksign[3] = "";
						p.sendSignChange(getRankSign(), ranksign);
						
						rankupsign[0] = "";
						rankupsign[1] = "§lRankup Price";
						if(pp.getRank().getNextRank() != null){
							rankupsign[2] = "§6§l" + pp.getRank().getRankupPrice(); 
							rankupsign[3] = "§o(Price to " + pp.getRank().getNextRank().toString() + ")";
						}
						else{
							rankupsign[2] = "§4Highest Rank"; 
							rankupsign[3] = "";
						}
						p.sendSignChange(getRankupSign(), rankupsign);
					}
					
				}
			}
		}
	}

	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public void tickTimer(){
		if(getSeconds() != -1){
			setSeconds(getSeconds() -1);
		}
		if(getSeconds() == -1){
			setMinutes(getMinutes() -1);
			setSeconds(59);
		}
	}
	
	public boolean isInMine(Location l){
		for(Block b : getBlocks()){
			if(Utils.equals(l, b.getLocation())){
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public void reset(OMPlayer omp){
		if(omp == null){
			setMinutes(20);
			setSeconds(0);
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(isInMine(p.getLocation())){
				p.teleport(getResetLocation());
				if(omp != null){
					p.sendMessage("§7Mine §a§l" + getRank().toString() + "§7 has been reset by " + omp.getName() + "§7!");
				}
				else{
					p.sendMessage("§7Mine §a§l" + getRank().toString() + "§7 has been reset!");
				}
			}
		}
		
		List<MineBlock> mineblocks = new ArrayList<MineBlock>();
		for(MineBlock mb : getMineBlocks()){
			for(int amount = 0; amount < mb.getPercentage(); amount++){
				mineblocks.add(new MineBlock(mb));
			}
		}
		
		for(Block b : getBlocks()){
			MineBlock mb = mineblocks.get(new Random().nextInt(mineblocks.size()));
			b.setType(mb.getMaterial());
			b.setData(mb.getDurability());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void hideTimer(Player p){
		for(Block b : timerblocks){
			p.sendBlockChange(b.getLocation(), Material.AIR, (byte) 0);
		}
	}
	
	public void updateTimer(){
		List<Player> players = new ArrayList<Player>();
		for(OMPlayer omp : OMPlayer.getOMPlayers()){
			if(omp.getPlayer().getWorld().getName().equals(ServerData.getPrison().getPrisonWorld().getName())){
				if(omp.getPrisonPlayer().hasPerms(getRank())){
					hideTimer(omp.getPlayer());
					
					if(omp.getPrisonPlayer().isClockEnabled()){
						players.add(omp.getPlayer());
					}
				}
			}
		}
		
		String minutes = getMinutes() + "";
		String seconds = getSeconds() + "";
		
		if(getMinutes() < 10){
			minutes = "0" + minutes;
		}
		if(getSeconds() < 10){
			seconds = "0" + seconds;
		}
		
		if(players.size() > 0){
			new Letters(minutes + ":" + seconds, Direction.NORTH, timer).generate(Material.REDSTONE_BLOCK, 0, players);
		}
	}
	
	public static List<Mine> getMines(){
		return ServerData.getPrison().getMines();
	}
	
	public static Mine getMine(Rank rank, MineType type){
		for(Mine mine : ServerData.getPrison().getMines()){
			if(mine.getRank() == rank && mine.getType() == type){
				return mine;
			}
		}
		return null;
	}
}
