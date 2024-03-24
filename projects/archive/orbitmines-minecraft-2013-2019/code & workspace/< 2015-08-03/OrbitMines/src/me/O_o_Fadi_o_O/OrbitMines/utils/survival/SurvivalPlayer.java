package me.O_o_Fadi_o_O.OrbitMines.utils.survival;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SurvivalPlayer {

	private Player player;
	private int money;
	private int extrahomes;
	private int extrashops;
	private int extrawarps;
	private List<Home> homes;
	private boolean hometeleporting;
	private boolean warpteleporting;
	private Home teleportingto;
	private Warp teleportingtowarp;
	private List<ShopSign> shopsigns;
	private List<Warp> warps;
	private List<Warp> favoritewarps;
	private SurvivalPlayer tprequest;
	private SurvivalPlayer tphererequest;
	private Location lastlocation;
	
	public SurvivalPlayer(Player player, int money, int extrahomes, int extrashops, int extrawarps){
		this.player = player;
		this.money = money;
		this.extrahomes = extrahomes;
		this.extrashops = extrashops;
		this.extrawarps = extrawarps;
		this.homes = new ArrayList<Home>();
		this.hometeleporting = false;
		this.shopsigns = ShopSign.getShopSigns(player);
		this.warps = Warp.getWarps(player);
		this.favoritewarps = new ArrayList<Warp>();
		
		FileConfiguration playerdata = ConfigManager.playerdata;
		if(playerdata.contains("players." + getUUID().toString() + ".FavoriteWarps")){
			String[] warpids = playerdata.getString("players." + getUUID().toString() + ".FavoriteWarps").split("\\|");
			
			for(String warpid : warpids){
				this.favoritewarps.add(Warp.getWarp(Integer.parseInt(warpid)));
			}
		}
		if(playerdata.contains("players." + getUUID().toString() + ".LastLocation")){
			this.lastlocation = Utils.getLocationFromString(playerdata.getString("players." + getUUID().toString() + ".LastLocation"));
		}
		if(playerdata.contains("players." + getUUID().toString() + ".Homes")){
			for(String homename : playerdata.getConfigurationSection("players." + getUUID().toString() + ".Homes").getKeys(false)){
				this.homes.add(new Home(this, homename, Utils.getLocationFromString(playerdata.getString("players." + getUUID().toString() + ".Homes." + homename))));
			}
		}
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
		
		Database.get().update("Survival-Money", "money", "" + getMoney(), "uuid", getUUID().toString());
	}
	public void addMoney(int money) {
		this.money += money;
		
		Database.get().update("Survival-Money", "money", "" + getMoney(), "uuid", getUUID().toString());
		
		Title t = new Title("", "§2+" + money + "$");
		t.send(getPlayer());
	}
	public void removeMoney(int money) {
		this.money -= money;
		
		Database.get().update("Survival-Money", "money", "" + getMoney(), "uuid", getUUID().toString());
	}
	public boolean hasMoney(int money) {
		return this.money >= money;
	}

	public int getExtraHomes() {
		return extrahomes;
	}
	public void setExtraHomes(int extrahomes) {
		this.extrahomes = extrahomes;
		
		if(Database.get().containsPath("Survival-ExtraHomes", "uuid", "uuid", getUUID().toString())){
			Database.get().update("Survival-ExtraHomes", "extrahomes", "" + getExtraHomes(), "uuid", getUUID().toString());
		}
		else{
			Database.get().insert("Survival-ExtraHomes", "uuid`, `extrahomes", getUUID().toString() + "', '" + extrahomes);
		}
	}

	public int getExtraShops() {
		return extrashops;
	}
	public void setExtraShops(int extrashops) {
		this.extrashops = extrashops;
		
		if(Database.get().containsPath("Survival-ExtraShops", "uuid", "uuid", getUUID().toString())){
			Database.get().update("Survival-ExtraShops", "extrashops", "" + getExtraShops(), "uuid", getUUID().toString());
		}
		else{
			Database.get().insert("Survival-ExtraShops", "uuid`, `extrashops", getUUID().toString() + "', '" + extrashops);
		}
	}

	public int getExtraWarps() {
		return extrawarps;
	}
	public void setExtraWarps(int extrawarps) {
		this.extrawarps = extrawarps;
		
		if(Database.get().containsPath("Survival-ExtraWarps", "uuid", "uuid", getUUID().toString())){
			Database.get().update("Survival-ExtraWarps", "extrawarps", "" + getExtraWarps(), "uuid", getUUID().toString());
		}
		else{
			Database.get().insert("Survival-ExtraWarps", "uuid`, `extrawarps", getUUID().toString() + "', '" + extrawarps);
		}
	}

	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	public Home getHome(String homename){
		for(Home home : this.homes){
			if(home.getName().equals(homename)){
				return home;
			}
		}
		return null;
	}
	public void removeHome(Home home){
		this.homes.remove(this);
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".Homes." + home.getName(), null);
		ConfigManager.savePlayerData();
	}
	public void setHome(String homename){
		Home home = getHome(homename);
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".Homes." + homename, Utils.getStringFromLocation(this.player.getLocation()));
		ConfigManager.savePlayerData();
		
		if(home == null){
			this.homes.add(new Home(this, homename, this.player.getLocation()));
			this.player.sendMessage("§7New home §6set§7! (§6" + homename + "§7)");
		}
		else{
			home.setLocation(this.player.getLocation());
			this.player.sendMessage("§7Home §6set§7! (§6" + home.getName() + "§7)");
		}
	}

	public Home getTeleportingTo() {
		return teleportingto;
	}
	public void setTeleportingTo(Home teleportingto) {
		this.teleportingto = teleportingto;
	}

	public Warp getWarpingTo() {
		return teleportingtowarp;
	}
	public void setWarpingTo(Warp teleportingtowarp) {
		this.teleportingtowarp = teleportingtowarp;
	}

	public boolean isHomeTeleporting() {
		return hometeleporting;
	}
	public void setHomeTeleporting(boolean hometeleporting) {
		this.hometeleporting = hometeleporting;
	}

	public boolean isWarpTeleporting() {
		return warpteleporting;
	}
	public void setWarpTeleporting(boolean warpteleporting) {
		this.warpteleporting = warpteleporting;
	}

	public List<ShopSign> getShopSigns() {
		return shopsigns;
	}
	public void setShopSigns(List<ShopSign> shopsigns) {
		this.shopsigns = shopsigns;
	}

	public List<Warp> getWarps() {
		return warps;
	}
	public void setWarps(List<Warp> warps) {
		this.warps = warps;
	}

	public List<Warp> getFavoriteWarps() {
		return favoritewarps;
	}
	public void setFavoriteWarps(List<Warp> favoritewarps) {
		this.favoritewarps = favoritewarps;
		
		saveFavoriteWarps();
	}
	public void addFavoriteWarp(Warp favoritewarp) {
		this.favoritewarps.add(favoritewarp);
		
		saveFavoriteWarps();
	}
	public void removeFavoriteWarp(Warp favoritewarp) {
		this.favoritewarps.remove(favoritewarp);
		
		saveFavoriteWarps();
	}

	public SurvivalPlayer getTPRequest() {
		return tprequest;
	}
	public void setTPRequest(SurvivalPlayer tprequest) {
		this.tprequest = tprequest;
	}
	public boolean hasTPRequest(){
		return this.tprequest != null;
	}

	public SurvivalPlayer getTPHereRequest() {
		return tphererequest;
	}
	public void setTPHereRequest(SurvivalPlayer tphererequest) {
		this.tphererequest = tphererequest;
	}
	public boolean hasTPHereRequest(){
		return this.tphererequest != null;
	}

	public Location getLastLocation() {
		return lastlocation;
	}
	public void setLastLocation(Location lastlocation) {
		this.lastlocation = lastlocation;
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".LastLocation", Utils.getStringFromLocation(this.lastlocation));
		ConfigManager.savePlayerData();
	}
	public boolean hasLastLocation(){
		return this.lastlocation != null;
	}
	
	private void saveFavoriteWarps(){
		String fwarps = "";
		for(Warp warp : this.favoritewarps){
			if(fwarps.equals("")){
				fwarps = warp.getWarpID() + "";
			}
			else{
				fwarps += "|" + warp.getWarpID();
			}
		}
		
		if(!fwarps.equals("")){
			ConfigManager.playerdata.set("players." + getUUID().toString() + ".FavoriteWarps", fwarps);
		}
		else{
			ConfigManager.playerdata.set("players." + getUUID().toString() + ".FavoriteWarps", null);
		}
		ConfigManager.savePlayerData();
	}
	
	public void addClaimBlocks(int claimblocks) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adjustbonusclaimblocks " + this.player.getName() + " " + claimblocks);
	}
	
	public int getHomesAllowed(){
		OMPlayer omp = OMPlayer.getOMPlayer(this.player);
		
		if(omp.hasPerms(VIPRank.Emerald_VIP)){
			return 100 + this.extrahomes;
		}
		else if(omp.hasPerms(VIPRank.Diamond_VIP)){
			return 50 + this.extrahomes;
		}
		else if(omp.hasPerms(VIPRank.Gold_VIP)){
			return 25 + this.extrahomes;
		}
		else if(omp.hasPerms(VIPRank.Iron_VIP)){
			return 10 + this.extrahomes;
		}
		else{
			return 3 + this.extrahomes;
		}
	}
	
	public int getShopsAllowed(){
		OMPlayer omp = OMPlayer.getOMPlayer(this.player);
		
		if(omp.hasPerms(VIPRank.Emerald_VIP)){
			return 70 + this.extrashops;
		}
		else if(omp.hasPerms(VIPRank.Diamond_VIP)){
			return 30 + this.extrashops;
		}
		else if(omp.hasPerms(VIPRank.Gold_VIP)){
			return 10 + this.extrashops;
		}
		else if(omp.hasPerms(VIPRank.Iron_VIP)){
			return 5 + this.extrashops;
		}
		else{
			return 3 + this.extrashops;
		}
	}
	
	public int getWarpsAllowed(){
		OMPlayer omp = OMPlayer.getOMPlayer(this.player);
		
		if(omp.hasPerms(VIPRank.Emerald_VIP)){
			return 1 + this.extrawarps;
		}
		else{
			return this.extrawarps;
		}
	}
	
	public boolean isInPvP(){
		if(player.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
			Location l = player.getLocation();
			
			if(l.getX() >= 12 && l.getX() <= 29 && l.getZ() >= 40 && l.getZ() <= 65){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void teleportToPvPArea(){
		List<Location> pvpspawns = ServerData.getSurvival().getPvPSpawns();
		getPlayer().teleport(pvpspawns.get(new Random().nextInt(pvpspawns.size())));
	}
	
	public UUID getUUID(){
		return this.player.getUniqueId();
	}
	
	public static List<SurvivalPlayer> getSurvivalPlayers(){
		return ServerStorage.survivalplayers;
	}
	
	public static SurvivalPlayer getSurvivalPlayer(Player player){
		for(SurvivalPlayer sp : ServerStorage.survivalplayers){
			if(sp.getPlayer() == player){
				return sp;
			}
		}
		return null;
	}
	
	public static SurvivalPlayer addSurvivalPlayer(Player player, int money, int extrahomes, int extrashops, int extrawarps){
		SurvivalPlayer sp = new SurvivalPlayer(player, money, extrahomes, extrashops, extrawarps);
		ServerStorage.survivalplayers.add(sp);
		return sp;
	}
}
