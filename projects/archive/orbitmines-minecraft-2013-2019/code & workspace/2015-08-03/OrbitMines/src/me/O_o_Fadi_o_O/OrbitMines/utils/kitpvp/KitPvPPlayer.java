package me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.Hologram;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.KitPvPKit;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KitPvPPlayer {

	private Player player;
	private int kills;
	private int deaths;
	private int levels;
	private int exp;
	private int money;
	private int beststreak;
	private int currentstreak;
	private HashMap<KitPvPKit, Integer> unlockedkits;
	private KitPvPKit kitselected;
	private Masteries masteries;
	private int kitlevelselected;
	private boolean isspectator;
	private int arrowseconds;
	private List<Entity> summonedundeath;
	
	public KitPvPPlayer(Player player, int kills, int deaths, int levels, int exp, int money, int beststreak, HashMap<KitPvPKit, Integer> unlockedkits, Masteries masteries){
		this.player = player;
		this.kills = kills;
		this.deaths = deaths;
		this.levels = levels;
		this.exp = exp;
		this.money = money;
		this.beststreak = beststreak;
		this.currentstreak = 0;
		this.unlockedkits = unlockedkits;
		this.masteries = masteries;
		this.isspectator = false;
		this.summonedundeath = new ArrayList<Entity>();
	}

	public Player getPlayer(){
		return player;
	}
	public void setPlayer(Player player){
		this.player = player;
	}

	public int getKills(){
		return kills;
	}
	public void setKills(int kills){
		this.kills = kills;
		
		Database.get().update("KitPvP-Kills", "kills", "" + this.kills, "uuid", getUUID().toString());
	}
	public void addKill(){
		this.kills = getKills() +1;
		
		Database.get().update("KitPvP-Kills", "kills", "" + this.kills, "uuid", getUUID().toString());
	}

	public int getDeaths(){
		return deaths;
	}
	public void setDeaths(int deaths){
		this.deaths = deaths;
		
		Database.get().update("KitPvP-Deaths", "deaths", "" + this.deaths, "uuid", getUUID().toString());
	}
	public void addDeath(){
		this.deaths += 1;
		
		Database.get().update("KitPvP-Deaths", "deaths", "" + this.deaths, "uuid", getUUID().toString());
	}

	public int getLevels(){
		return levels;
	}
	public void setLevels(int levels){
		this.levels = levels;
		
		Database.get().update("KitPvP-Levels", "levels", "" + this.levels, "uuid", getUUID().toString());
	}
	public void addLevel(){
		this.levels += 1;

		getPlayer().playSound(getPlayer().getLocation(), Sound.LEVEL_UP, 5, 1);
		getPlayer().sendMessage("§a§lLevel Up! §7(§c§l+ 1 Mastery Point§7)");
		getMasteries().addPoints(1);
		getMasteries().update();
		Database.get().update("KitPvP-Levels", "levels", "" + this.levels, "uuid", getUUID().toString());
	}

	public int getExp(){
		return exp;
	}
	public void setExp(int exp){
		this.exp = exp;
		
		Database.get().update("KitPvP-Exp", "exp", "" + this.exp, "uuid", getUUID().toString());
	}
	public void addExp(int exp){
		this.exp += exp * getExpBooster();
		
		Database.get().update("KitPvP-Exp", "exp", "" + this.exp, "uuid", getUUID().toString());
	}
	
	public double getExpRequired(){
		int level = this.levels +1;
		return ((level * 10) / 3 + level * level) * 3;
	}
	public boolean isLevelUp(){
		return getExp() >= getExpRequired();
	}

	public int getMoney(){
		return money;
	}
	public void setMoney(int money){
		this.money = money;
		
		Database.get().update("KitPvP-Money", "money", "" + this.money, "uuid", getUUID().toString());
	}
	public void addMoney(int money){
		this.money += money;
		
		Database.get().update("KitPvP-Money", "money", "" + this.money, "uuid", getUUID().toString());
	}
	public void removeMoney(int money){
		this.money -= money;
		
		Database.get().update("KitPvP-Money", "money", "" + this.money, "uuid", getUUID().toString());
	}
	public boolean hasMoney(int money){
		if(getMoney() >= money){
			return true;
		}
		return false;
	}

	public int getBestStreak(){
		return beststreak;
	}
	public void setBestStreak(int beststreak){
		this.beststreak = beststreak;
		
		Database.get().update("KitPvP-BestStreak", "beststreak", "" + this.beststreak, "uuid", getUUID().toString());
	}

	public int getCurrentStreak(){
		return currentstreak;
	}
	public void setCurrentStreak(int currentstreak){
		this.currentstreak = currentstreak;
	}

	public HashMap<KitPvPKit, Integer> getUnlockedKits(){
		return unlockedkits;
	}
	public void setUnlockedKits(HashMap<KitPvPKit, Integer> unlockedkits){
		this.unlockedkits = unlockedkits;
	}
	public void setUnlockedKitLevel(KitPvPKit kit, int level){
		this.unlockedkits.put(kit, level);
		
		if(!Database.get().containsPath("Kits-" + kit.getName(), "uuid", "uuid", getUUID().toString())){
			Database.get().insert("Kits-" + kit.getName(), "uuid`, `" + kit.getName().toLowerCase(), getUUID().toString() + "', '" + 1);
		}
		else{
			Database.get().update("Kits-" + kit.getName(), kit.getName().toLowerCase(), "" + level, "uuid", getUUID().toString());
		}
	}
	public int getUnlockedLevel(KitPvPKit kit){
		if(this.unlockedkits.containsKey(kit)){
			return this.unlockedkits.get(kit);
		}
		return 0;
	}

	public KitPvPKit getKitSelected(){
		return kitselected;
	}
	public void setKitSelected(KitPvPKit kitselected){
		this.kitselected = kitselected;
		
		// Reset Cooldowns \\
		this.arrowseconds = -1;
		if(kitselected == null){
			OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
			
			for(Cooldown cooldown : Cooldown.getKitPvPCooldowns()){
				omp.removeCooldown(cooldown);
			}
		}
	}

	public Masteries getMasteries(){
		return masteries;
	}
	public void setMasteries(Masteries masteries){
		this.masteries = masteries;
	}

	public int getKitLevelSelected(){
		return kitlevelselected;
	}
	public void setKitLevelSelected(int kitlevelselected){
		this.kitlevelselected = kitlevelselected;
	}

	public boolean isSpectator(){
		return isspectator;
	}
	public void setSpectator(){
		this.isspectator = true;
	}
	public boolean isPlayer(){
		return !isspectator;
	}
	public void setPlayer(){
		this.isspectator = false;
	}

	public int getArrowSeconds(){
		return arrowseconds;
	}
	public void setArrowSeconds(int arrowseconds){
		this.arrowseconds = arrowseconds;
	}
	public void tickArrowTimer(){
		this.arrowseconds--;
	}

	public List<Entity> getSummonedUndeath(){
		return summonedundeath;
	}
	public void setSummonedUndeath(List<Entity> summonedundeath){
		this.summonedundeath = summonedundeath;
	}
	
	public void giveKit(KitPvPKit kitpvpkit, int level){
		OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
		
		omp.clearInventory();
		omp.clearPotionEffects();
		
		Kit kit = kitpvpkit.getKit(level);
		kit.setItems(getPlayer());
		
		setKitSelected(kitpvpkit);
		setKitLevelSelected(level);

		getPlayer().sendMessage("§7Selected Kit: '§b§l" + kitpvpkit.getName() + "§7' §7§o(§a§oLvL " + level + "§7§o)");
		Title t = new Title("", "§7Selected Kit '§b§l" + kitpvpkit.getName() + "§7' (§aLevel " + level + "§7)");
		t.send(getPlayer());
	}
	
	public void updateLevel(){
		getPlayer().setLevel(this.levels);
		getPlayer().setExp((float) getExp() / (float) getExpRequired());
	}
	
	public UUID getUUID(){
		return this.player.getUniqueId();
	}
	
	public void teleportToMap(){
		KitPvPMap map = ServerData.getKitPvP().getCurrentMap();
		
		if(isPlayer()){
			getPlayer().teleport(map.getRandomSpawn());
		}
		else{
			getPlayer().teleport(map.getSpectatorSpawn());
		}
		map.sendJoinMessage(getPlayer());
    	getPlayer().playSound(getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	}
	
	public void createKillHologram(Player killer, int coinsadded){
		final Hologram h = new Hologram(getPlayer().getLocation());
		h.addLine("§7You killed §6" + getPlayer().getName() + "§7!");
		h.addLine("§6§l+" + coinsadded + " Coins");
		h.create(killer);
		
		new BukkitRunnable(){
			public void run(){
				h.delete();
			}
		}.runTaskLater(Start.getInstance(), 100);
	}
	
	public void requiredMoney(int price){
		Player p = getPlayer();
		
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
		int needed = price - getMoney();
		if(needed == 1){
			p.sendMessage("§c§lKitPvP §8| §7You need §6§l" + needed + "§7 more §6§lCoins§7!");
		}
		else{
			p.sendMessage("§c§lKitPvP §8| §7You need §6§l" + needed + "§7 more §6§lCoins§7!");
		}
	}
	
	public double getVIPBooster(){
		OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
		
		switch(omp.getVIPRank()){
			case Diamond_VIP:
				return 1.20;
			case Emerald_VIP:
				return 1.50;
			default:
				return 1.00;
		}
	}
	
	public double getExpBooster(){
		OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
		
		switch(omp.getVIPRank()){
			case Diamond_VIP:
				return 2.00;
			case Emerald_VIP:
				return 2.50;
			case Gold_VIP:
				return 1.50;
			default:
				return 1.00;
		}
	}
	
	public static List<KitPvPPlayer> getKitPvPPlayers(){
		return ServerStorage.kitpvpplayers;
	}
	
	public static KitPvPPlayer getKitPvPPlayer(Player player){
		for(KitPvPPlayer kitpvpplayer : ServerStorage.kitpvpplayers){
			if(kitpvpplayer.getPlayer() == player){
				return kitpvpplayer;
			}
		}
		return null;
	}
	
	public static KitPvPPlayer addKitPvPPlayer(Player player, int kills, int deaths, int levels, int exp, int money, int beststreak, HashMap<KitPvPKit, Integer> unlockedkits, Masteries masteries){
		KitPvPPlayer kitpvpplayer = new KitPvPPlayer(player, kills, deaths, levels, exp, money, beststreak, unlockedkits, masteries);
		ServerStorage.kitpvpplayers.add(kitpvpplayer);
		return kitpvpplayer;
	}
}
