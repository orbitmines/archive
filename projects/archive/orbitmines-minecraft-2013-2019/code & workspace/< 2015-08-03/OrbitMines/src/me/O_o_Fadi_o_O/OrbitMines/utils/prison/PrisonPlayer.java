package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.ActionBar;
import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rank;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.ShopSign;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PrisonPlayer {

	private Player player;
	private Rank rank;
	private int gold;
	private int gambletickets;
	private boolean clockenabled;
	private List<ShopSign> shopsigns;
	private Shop shop;
	
	public PrisonPlayer(Player player, Rank rank, int gold, int gambletickets, boolean clockenabled){
		this.player = player;
		this.rank = rank;
		this.gold = gold;
		this.gambletickets = gambletickets;
		this.clockenabled = clockenabled;
		this.shopsigns = ShopSign.getShopSigns(player);
		this.shop = Shop.getShop(getUUID());
		
		if(getShop() != null){
			getShop().setOwnerName(player.getName());
		}
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
		
		Database.get().update("Prison-Rank", "rank", "" + getRank().ordinal(), "uuid", getUUID().toString());
	}
	public List<Rank> getRankPerms(){
		List<Rank> ranks = new ArrayList<Rank>();
		
		for(Rank rank : Rank.values()){
			if(hasPerms(rank)){
				ranks.add(rank);
			}
		}
		
		return ranks;
	}
	public boolean hasPerms(Rank rank){
		return getRank().ordinal() >= rank.ordinal();
	}
	public boolean canRankup(){
		return hasGold(getRank().getRankupPrice());
	}
	public void rankup(){
		Rank nextrank = getRank().getNextRank();
		
		getPlayer().playSound(getPlayer().getLocation(), Sound.LEVEL_UP, 5, 1);
		Bukkit.broadcastMessage(OMPlayer.getOMPlayer(player).getName() + "§7 ranked up to §a§l" + nextrank.toString() + "§7!");
		
		if(nextrank.getNextRank() == null){
			getPlayer().sendMessage("§7You've reached the highest rank! More ranks are coming soon!");
		}
		
		removeGold(getRank().getRankupPrice());
		setRank(nextrank);
	}

	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
		
		Database.get().update("Prison-Gold", "gold", "" + getGold(), "uuid", getUUID().toString());
	}
	public void addGold(int gold) {
		this.gold += gold;
		
		ActionBar ab = new ActionBar("§6+" + gold + " Gold");
		ab.send(getPlayer());
		
		Database.get().update("Prison-Gold", "gold", "" + getGold(), "uuid", getUUID().toString());
	}
	public void removeGold(int gold) {
		this.gold -= gold;
		
		ActionBar ab = new ActionBar("§6-" + gold + " Gold");
		ab.send(getPlayer());
		
		Database.get().update("Prison-Gold", "gold", "" + getGold(), "uuid", getUUID().toString());
	}
	public boolean hasGold(int gold){
		return getGold() >= gold;
	}

	public int getGambleTickets() {
		return gambletickets;
	}
	public void setGambleTickets(int gambletickets) {
		this.gambletickets = gambletickets;
		
		Database.get().update("Prison-GambleTickets", "gambletickets", "" + getGambleTickets(), "uuid", getUUID().toString());
	}
	public void addGambleTickets(int gambletickets) {
		this.gambletickets += gambletickets;
		
		Database.get().update("Prison-GambleTickets", "gambletickets", "" + getGambleTickets(), "uuid", getUUID().toString());
	}
	public void removeGambleTickets(int gambletickets) {
		this.gambletickets -= gambletickets;
		
		Database.get().update("Prison-GambleTickets", "gambletickets", "" + getGambleTickets(), "uuid", getUUID().toString());
	}
	public boolean hasGambleTickets(int gambletickets){
		return getGambleTickets() >= gambletickets;
	}

	public boolean isClockEnabled() {
		return clockenabled;
	}
	public void setClockEnabled(boolean clockenabled) {
		this.clockenabled = clockenabled;
		
		getPlayer().sendMessage("§7Clock " + Utils.statusString(clockenabled) + "§7!");
		
		if(!clockenabled){
			for(Mine mine : Mine.getMines()){
				if(hasPerms(mine.getRank())){
					mine.hideTimer(getPlayer());
				}
			}
		}
	}

	public List<ShopSign> getShopSigns() {
		return shopsigns;
	}
	public void setShopSigns(List<ShopSign> shopsigns) {
		this.shopsigns = shopsigns;
	}

	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public boolean inMine(Location l, boolean message){
		boolean inmine = false;
		
		for(Mine mine : Mine.getMines()){
			if(!inmine && hasPerms(mine.getRank()) && mine.isInMine(l)){
				inmine = true;
			}
		}
		
		if(!inmine && message){
			OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
			if(!omp.onCooldown(Cooldown.MESSAGE)){
				getPlayer().sendMessage("§7You cannot do that here!");
				
				omp.resetCooldown(Cooldown.MESSAGE);
			}
		}
		
		return inmine;
	}
	
	public boolean isInPvP(){
		return getPlayer().getWorld().getName().equals(ServerData.getLobbyWorld().getName()) && (getPlayer().getLocation().getZ() <= -14 || getPlayer().getLocation().getY() <= 0);
	}
	
	public void requiredGold(int gold){
		Player p = getPlayer();
		
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
		int required = gold - getGold();
		getPlayer().sendMessage("§7You need §6§l" + required + " §7more §6§lGold§7.");
	}
	public void requiredGambleTickets(int tickets){
		Player p = getPlayer();
		
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
		int needed = tickets - getGambleTickets();
		if(needed == 1){
			p.sendMessage("§7You need §a" + needed + "§7 more §aGamble Ticket§7!");
		}
		else{
			p.sendMessage("§7You need §a" + needed + "§7 more §aGamble Tickets§7!");
		}
	}
	
	public double getGoldMultiplier(){
		OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
		
		if(omp.hasPerms(VIPRank.Emerald_VIP)){
			return 1.75;
		}
		else if(omp.hasPerms(VIPRank.Diamond_VIP)){
			return 1.4;
		}
		else if(omp.hasPerms(VIPRank.Gold_VIP)){
			return 1.2;
		}
		else if(omp.hasPerms(VIPRank.Iron_VIP)){
			return 1.1;
		}
		else{
			return 1;
		}
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public static List<PrisonPlayer> getPrisonPlayers(){
		return ServerStorage.prisonplayers;
	}
	
	public static PrisonPlayer getPrisonPlayer(Player p){
		for(PrisonPlayer pp : ServerStorage.prisonplayers){
			if(pp.getPlayer() == p){
				return pp;
			}
		}
		return null;
	}
	
	public static PrisonPlayer addPrisonPlayer(Player player, Rank rank, int gold, int gambletickets, boolean clockenabled){
		PrisonPlayer pplayer = new PrisonPlayer(player, rank, gold, gambletickets, clockenabled);
		ServerStorage.prisonplayers.add(pplayer);
		return pplayer;
	}
}
