package me.O_o_Fadi_o_O.OrbitMines.utils.skyblock;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockUtils.IslandRank;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SkyBlockPlayer {

	private Player player;
	private Island island;
	private IslandRank islandrank;
	private Location homelocation;
	private HashMap<Challenge, Integer> challenges;
	private Island teleportingto;
	private Island invited;
	private String nextusage;
	
	public SkyBlockPlayer(Player player){
		this.player = player;
		this.challenges = new HashMap<Challenge, Integer>();
		
		FileConfiguration playerdata = ConfigManager.playerdata;
		this.nextusage = playerdata.getString("players." + getUUID().toString() + ".NextKitUsage");
		if(playerdata.contains("players." + getUUID().toString() + ".IslandInfo")){
			this.island = Island.getIsland(playerdata.getInt("players." + getUUID().toString() + ".IslandInfo.IslandNumber"));
			this.islandrank = IslandRank.valueOf(playerdata.getString("players." + getUUID().toString() + ".IslandInfo.IslandRank"));
			this.homelocation = Utils.getLocationFromString(playerdata.getString("players." + getUUID().toString() + ".IslandInfo.HomeLocation"));
		}
		if(playerdata.contains("players." + getUUID().toString() + ".Challenges")){
			String[] challengeparts = playerdata.getString("players." + getUUID().toString() + ".Challenges").split("\\|");
			for(String challenge : challengeparts){
				String[] cparts = challenge.split("\\:");
				
				this.challenges.put(Challenge.getChallenge(Integer.parseInt(cparts[0])), Integer.parseInt(cparts[1]));
			}
		}
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Island getIsland() {
		return island;
	}
	public void setIsland(Island island, IslandRank islandrank) {
		this.island = island;
		this.islandrank = islandrank;
		this.challenges = new HashMap<Challenge, Integer>();
		
		OMPlayer omp = OMPlayer.getOMPlayer(this.player);
		omp.clearInventory();
		omp.clearPotionEffects();
		omp.clearLevels();

		if(island != null){
			FileConfiguration playerdata = ConfigManager.playerdata;
			playerdata.set("players." + getUUID().toString() + ".IslandInfo.IslandNumber", island.getIslandID());
			playerdata.set("players." + getUUID().toString() + ".IslandInfo.IslandRank", islandrank.toString());
			if(isOwner()){
				Location l = island.getLocation();
				Location l2 = new Location(l.getWorld(), l.getBlockX() +0.5, l.getBlockY(), l.getBlockZ() +2.5, 180, 0);
				playerdata.set("players." + getUUID().toString() + ".IslandInfo.HomeLocation", Utils.getStringFromLocation(l2));
				this.homelocation = l2;
			}
			else{
				Location l = island.getOwnersHomeLocation();
				playerdata.set("players." + getUUID().toString() + ".IslandInfo.HomeLocation", Utils.getStringFromLocation(l));
				this.homelocation = l;
			}
			playerdata.set("players." + getUUID().toString() + ".Challenges", null);
			ConfigManager.savePlayerData();
		}
		else{
			this.homelocation = null;
		}
	}
	public boolean hasIsland(){
		return this.island != null;
	}

	public IslandRank getIslandRank() {
		return islandrank;
	}
	public void setIslandRank(IslandRank islandrank) {
		this.islandrank = islandrank;
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".IslandInfo.IslandRank", islandrank.toString());
		ConfigManager.savePlayerData();
	}
	public boolean isOwner(){
		return this.islandrank != null && this.islandrank == IslandRank.OWNER;
	}
	public boolean isMember(){
		return this.islandrank != null && this.islandrank == IslandRank.MEMBER;
	}

	public Location getHomeLocation() {
		return homelocation;
	}
	public void setHomeLocation(Location homelocation) {
		this.homelocation = homelocation;
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".IslandInfo.HomeLocation", Utils.getStringFromLocation(this.homelocation));
		ConfigManager.savePlayerData();
	}

	public HashMap<Challenge, Integer> getChallenges() {
		return challenges;
	}
	public void setChallenges(HashMap<Challenge, Integer> challenges) {
		this.challenges = challenges;
		
		saveChallenges();
	}
	public void setChallengeCompleted(Challenge challenge){
		if(this.challenges.containsKey(challenge)){
			this.challenges.put(challenge, this.challenges.get(challenge) +1);
		}
		else{
			this.challenges.put(challenge, 1);
		}
		
		saveChallenges();
	}
	public int getChallengeCompleted(Challenge challenge){
		if(this.challenges.containsKey(challenge)){
			return this.challenges.get(challenge);
		}
		return 0;
	}
	private void saveChallenges(){
		String cstring = null;
		
		for(Challenge c : this.challenges.keySet()){
			if(cstring == null){
				cstring = c.getChallengeID() + ":" + this.challenges.get(c);
			}
			else{
				cstring += "|" + c.getChallengeID() + ":" + this.challenges.get(c);
			}
		}
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".Challenges", cstring);
		ConfigManager.savePlayerData();
	}
	public void resetChallenges(){
		this.challenges = new HashMap<Challenge, Integer>();
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".Challenges", null);
		ConfigManager.savePlayerData();
	}

	public Island getTeleportingTo() {
		return teleportingto;
	}
	public void setTeleportingTo(Island teleportingto) {
		this.teleportingto = teleportingto;
	}

	public Island getInvited() {
		return invited;
	}
	public void setInvited(Island invited) {
		this.invited = invited;
	}
	public boolean isInvited(){
		return this.invited != null;
	}
	
	public int getMaxMembers(){
		OMPlayer omp = OMPlayer.getOMPlayer(player);
		
		if(omp.hasPerms(VIPRank.Emerald_VIP) || omp.hasPerms(StaffRank.Owner)){
			return 21;
		}
		else if(omp.hasPerms(VIPRank.Diamond_VIP)){
			return 14;
		}
		else if(omp.hasPerms(VIPRank.Gold_VIP)){
			return 9;
		}
		else if(omp.hasPerms(VIPRank.Iron_VIP)){
			return 5;
		}
		else{
			return 3;
		}
	}
	
	public boolean inVoid(){
		Location l = getPlayer().getLocation();
		
		for(int i = 1; i <= l.getBlockY(); i++){
			Block b = l.getWorld().getBlockAt(new Location(l.getWorld(), l.getBlockX(), i, l.getBlockZ()));
			
			if(!b.isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean onOwnIsland(Location l2, boolean message){
		Location l = getIsland().getLocation();
		int x = l.getBlockX();
		int z = l.getBlockZ();
		
		int bDistance = 0;
		int xB = l2.getBlockX() -x;
		int zB = l2.getBlockZ() -z;
		
		if(xB < 0){
			xB = -xB;
		}
		if(zB < 0){
			zB = -zB;
		}
		
		if(xB <= zB){
			bDistance = zB;
		}
		else{
			bDistance = xB;
		}
		
		bDistance = 50 - bDistance;
		
		if(bDistance < 0){
			OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
			if(message && !omp.onCooldown(Cooldown.MESSAGE)){
				getPlayer().sendMessage("§7You're not on your own §dIsland§7!");
				
				omp.resetCooldown(Cooldown.MESSAGE);
			}
			
			return false;
		}
		return true;
	}
	
	public boolean onIsland(Location l2, boolean message){
		if(onOwnIsland(l2, false)){
			return true;
		}
		
		boolean onisland = false;
		for(Island is : Island.getUnprotectedIslands()){
			if(!onisland){
				Location l = is.getLocation();
				int x = l.getBlockX();
				int z = l.getBlockZ();
				
				int bDistance = 0;
				int xB = l2.getBlockX() -x;
				int zB = l2.getBlockZ() -z;
				
				if(xB < 0){
					xB = -xB;
				}
				if(zB < 0){
					zB = -zB;
				}
				
				if(xB <= zB){
					bDistance = zB;
				}
				else{
					bDistance = xB;
				}
				
				bDistance = 50 - bDistance;
				
				if(bDistance >= 0){
					onisland = true;
				}
			}
		}
		
		if(!onisland && message){
			OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
			if(message && !omp.onCooldown(Cooldown.MESSAGE)){
				getPlayer().sendMessage("§7You're not on your own §dIsland§7!");
				
				omp.resetCooldown(Cooldown.MESSAGE);
			}
		}
		return onisland;
	}
	
	public void useKit(VIPRank viprank){
		Player p = getPlayer();
		Calendar nextuse = Calendar.getInstance();
		nextuse.add(Calendar.DATE, 1);
        
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String nextusage = df.format(new Date(nextuse.getTimeInMillis()));
        
        Kit.getKit(viprank.toString()).addItems(p);
        switch(viprank){
			case Diamond_VIP:
				p.setLevel(p.getLevel() + 5);
				break;
			case Emerald_VIP:
				p.setLevel(p.getLevel() + 8);
				break;
			case Gold_VIP:
				p.setLevel(p.getLevel() + 2);
				break;
			case Iron_VIP:
				p.setLevel(p.getLevel() + 1);
				break;
			default:
				break;
        }
        
        this.nextusage = nextusage;
        ConfigManager.playerdata.set("players." + getUUID().toString() + ".NextKitUsage", nextusage);
        ConfigManager.savePlayerData();
	}
	public boolean canUseKit(){
		if(nextusage == null){
			return true;
		}
		
		try{
			return new Date(Calendar.getInstance().getTimeInMillis()).compareTo(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(this.nextusage)) >= 0;
		}catch(ParseException e){
			return false;
		}
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public static List<SkyBlockPlayer> getSkyBlockPlayers(){
		return ServerStorage.skyblockplayers;
	}
	
	public static SkyBlockPlayer getSkyBlockPlayer(Player player){
		for(SkyBlockPlayer sbp : ServerStorage.skyblockplayers){
			if(sbp.getPlayer() == player){
				return sbp;
			}
		}
		return null;
	}
	
	public static SkyBlockPlayer addSkyBlockPlayer(Player player){
		SkyBlockPlayer sbp = new SkyBlockPlayer(player);
		ServerStorage.skyblockplayers.add(sbp);
		return sbp;
	}
}
