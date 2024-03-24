package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungee.passes.Password;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.VIPRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BungeePlayer {

	private ProxiedPlayer player;
	private Password password;
	private VIPRank viprank;
	private StaffRank staffrank;
	private HashMap<Cooldown, Long> cooldowns;
	private List<UUID> friends;
	private UUID friendrequest;
	private UUID lastmsg;
	private boolean showstaffmessage;
	private boolean silent;
	private boolean allchat;
	private boolean loggedin;
	private int logintime;
	
	public BungeePlayer(ProxiedPlayer player){
		this.player = player;
		this.cooldowns = new HashMap<Cooldown, Long>();
		this.friends = new ArrayList<UUID>();
		this.showstaffmessage = true;
		this.silent = false;
		this.allchat = false;
		this.loggedin = false;
		this.logintime = 15;
		
		ServerData.getBungee().getPlayers().add(this);
	}
	
	public Server getServer(){
		return Server.valueOf(getPlayer().getServer().getInfo().getName().toUpperCase());
	}

	public ProxiedPlayer getPlayer() {
		return player;
	}
	public void setPlayer(ProxiedPlayer player) {
		this.player = player;
	}

	public Password getPassword() {
		return password;
	}
	public void setPassword(Password password) {
		this.password = password;
	}
	public boolean hasPassword(){
		return password != null;
	}

	public VIPRank getVIPRank() {
		return viprank;
	}
	public void setVIPRank(VIPRank viprank) {
		this.viprank = viprank;
	}

	public StaffRank getStaffRank() {
		return staffrank;
	}
	public void setStaffRank(StaffRank staffrank) {
		this.staffrank = staffrank;
	}
	
	public HashMap<Cooldown, Long> getCooldowns(){
		return cooldowns;
	}
	public void setCooldowns(HashMap<Cooldown, Long> cooldowns){
		this.cooldowns = cooldowns;
	}
	public long getCooldown(Cooldown cooldown){
		if(this.cooldowns.containsKey(cooldown)){
			return this.cooldowns.get(cooldown);
		}
		return 0;
	}
	public void resetCooldown(Cooldown cooldown){
		this.cooldowns.put(cooldown, System.currentTimeMillis());
	}
	public void removeCooldown(Cooldown cooldown){
		this.cooldowns.remove(cooldown);
	}
	public boolean onCooldown(Cooldown cooldown){
		if(this.cooldowns.containsKey(cooldown)){
			if(System.currentTimeMillis() - this.cooldowns.get(cooldown) >= cooldown.getCooldown()){
				return false;
			}
			return true;
		}
		return false;
	}

	public List<UUID> getFriends() {
		return friends;
	}
	public void setFriends(List<UUID> friends) {
		this.friends = friends;
	}

	public UUID getFriendRequest() {
		return friendrequest;
	}
	public void setFriendRequest(UUID friendrequest) {
		this.friendrequest = friendrequest;
	}
	public boolean hasFriendRequest(){
		return friendrequest != null;
	}

	public UUID getLastMSG() {
		return lastmsg;
	}
	public void setLastMSG(UUID lastmsg) {
		this.lastmsg = lastmsg;
	}
	public boolean hasLastMSG(){
		return lastmsg != null;
	}

	public boolean canShowStaffMessage() {
		return showstaffmessage;
	}
	public void setShowStaffMessage(boolean showstaffmessage) {
		this.showstaffmessage = showstaffmessage;
	}

	public boolean isSilent() {
		return silent;
	}
	public void setSilent(boolean silent) {
		this.silent = silent;
		
		if(!Database.get().containsPath("PlayerSilentJoin", "uuid", "uuid", getUUID().toString())){
			Database.get().insert("PlayerSilentJoin", "uuid`, `silentjoin", getUUID().toString() + "', '" + this.silent);
		}
		else{
			Database.get().update("PlayerSilentJoin", "silentjoin", "" + this.silent, "uuid", getUUID().toString());
		}
	}

	public boolean hasAllChat() {
		return allchat;
	}
	public void setAllChat(boolean allchat) {
		this.allchat = allchat;
	}

	public boolean isLoggedIn() {
		return loggedin;
	}
	public void setLoggedIn(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public int getLoginTime() {
		return logintime;
	}
	public void setLoginTime(int logintime) {
		this.logintime = logintime;
	}
	public void tickLoginTimer(){
		this.logintime -= 1;
	}
	
	public String getColor(){
		if(getStaffRank() != StaffRank.User){
			return getStaffRank().getColor();
		}
		else{
			return getVIPRank().getColor();
		}
	}
	
	public String getChatPrefix(){
		if(getStaffRank() != StaffRank.User){
			return getStaffRank().getChatPrefix();
		}
		else{
			return getVIPRank().getChatPrefix();
		}
	}
	
	public String getName(){
		return getChatPrefix() + getPlayer().getName();
	}
	
	public boolean hasPerms(StaffRank rank){
		StaffRank staffrank = getStaffRank();
		
		if(staffrank == StaffRank.Owner){
			return true;
		}
		
		if(rank == StaffRank.User){
			if(staffrank == StaffRank.User || staffrank == StaffRank.Builder || staffrank == StaffRank.Moderator){
				return true;
			}
		}
		else if(rank == StaffRank.Builder){
			if(staffrank == StaffRank.Builder || staffrank == StaffRank.Moderator){
				return true;
			}
		}
		else if(rank == StaffRank.Moderator){
			if(staffrank == StaffRank.Moderator){
				return true;
			}
		}
		else{
			return false;
		}
		return false;
	}
	
	public boolean hasPerms(VIPRank rank){
		VIPRank viprank = getVIPRank();
		
		if(getStaffRank() == StaffRank.Owner){
			return true;
		}
		
		if(rank == VIPRank.Iron_VIP){
			if(viprank == VIPRank.Iron_VIP || viprank == VIPRank.Gold_VIP || viprank == VIPRank.Diamond_VIP || viprank == VIPRank.Emerald_VIP){
				return true;
			}
		}
		else if(rank == VIPRank.Gold_VIP){
			if(viprank == VIPRank.Gold_VIP || viprank == VIPRank.Diamond_VIP || viprank == VIPRank.Emerald_VIP){
				return true;
			}
		}
		else if(rank == VIPRank.Diamond_VIP){
			if(viprank == VIPRank.Diamond_VIP || viprank == VIPRank.Emerald_VIP){
				return true;
			}
		}
		else if(rank == VIPRank.Emerald_VIP){
			if(viprank == VIPRank.Emerald_VIP){
				return true;
			}
		}
		else{
			return true;
		}
		return false;
	}
	
	public int getMaxFriendsAllowed(){
		switch(viprank){
			case Diamond_VIP:
				return 20;
			case Emerald_VIP:
				return 25;
			case Gold_VIP:
				return 15;
			case Iron_VIP:
				return 10;
			default:
				return 5;
		}
	}
    
    public void toMiniGameArea(){
    	ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
 
        try{
        	out.writeUTF("Forward");
        	out.writeUTF("hub");
        	out.writeUTF("MGArea");
    	
        	out.writeUTF(getPlayer().getName());
    	}catch(IOException ex){
    		ex.printStackTrace();
    	}
        
    	ProxyServer.getInstance().getServerInfo("hub").sendData("BungeeCord", b.toByteArray());
    }
	
	public void report(BungeePlayer bp, String reason){
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String reportedon = df.format(new Date(Calendar.getInstance().getTimeInMillis()));
        
        Database.get().insert("PlayerReports", "uuid`, `reportedby`, `reason`, `reportedon`, `server", bp.getPlayer().getUniqueId().toString() + "', '" + getPlayer().getUniqueId().toString() + "', '" + reason.replace("'", "`") + "', '" + reportedon + "', '" + bp.getServer().getNameWithoutColor());
	}
	
	public BannedPlayer ban(UUID banneduuid, String reason, int years, int days, int hours, int minutes){
		Calendar until = Calendar.getInstance();
		until.add(Calendar.YEAR, years);
		until.add(Calendar.MINUTE, minutes);
		until.add(Calendar.HOUR_OF_DAY, hours);
		until.add(Calendar.DATE, days);
        
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String banneduntil = df.format(new Date(until.getTimeInMillis()));
        String bannedon = df.format(new Date(Calendar.getInstance().getTimeInMillis()));
        
        BannedPlayer bannedp = new BannedPlayer(banneduuid, getName(), reason, bannedon, banneduntil);
        
        Database.get().insert("PlayerBans", "uuid`, `bannedby`, `reason`, `bannedon`, `banneduntil", banneduuid.toString() + "', '" + getName() +"', '" + reason + "', '" + bannedon + "', '" + banneduntil);
	
        return bannedp;
	}
	
	public void unban(UUID banneduuid){
		ServerData.getBungee().getBannedPlayers().remove(BannedPlayer.getBannedPlayer(banneduuid));
		
		Database.get().delete("PlayerBans", "uuid", banneduuid.toString());
	}
	
	public BannedIP banIP(String bannedip, String reason, int years, int days, int hours, int minutes){
		Calendar until = Calendar.getInstance();
		until.add(Calendar.YEAR, years);
		until.add(Calendar.MINUTE, minutes);
		until.add(Calendar.HOUR_OF_DAY, hours);
		until.add(Calendar.DATE, days);
        
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String banneduntil = df.format(new Date(until.getTimeInMillis()));
        String bannedon = df.format(new Date(Calendar.getInstance().getTimeInMillis()));
        
        BannedIP banned = new BannedIP(bannedip, getName(), reason, bannedon, banneduntil);
        
        Database.get().insert("PlayerIPBans", "ip`, `bannedby`, `reason`, `bannedon`, `banneduntil", bannedip + "', '" + getName() +"', '" + reason + "', '" + bannedon + "', '" + banneduntil);
	
        return banned;
	}
	
	public void unban(String bannedip){
		ServerData.getBungee().getBannedIPs().remove(BannedIP.getBannedIP(bannedip));
		
		Database.get().delete("PlayerIPBans", "ip", bannedip);
	}
	
	private UUID getUUID(){
		return this.player.getUniqueId();
	}
	
	public static List<BungeePlayer> getPlayers(){
		return ServerData.getBungee().getPlayers();
	}
	public static BungeePlayer getBungeePlayer(ProxiedPlayer player){
		for(BungeePlayer bp : ServerData.getBungee().getPlayers()){
			if(bp.getPlayer() == player){
				return bp;
			}
		}
		return null;
	}
	
	public void load(){
		try{
			String uuid = getUUID().toString();
			ProxiedPlayer p = this.player;
			
			for(Password password : ServerStorage.passwords){
				if(password.getUUID().toString().equals(uuid)){
					this.password = password;
				}
			}
			
	        String lastonline = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(Calendar.getInstance().getTimeInMillis()));

			if(Database.get().containsPath("PlayerLastOnline", "uuid", "uuid", p.getUniqueId().toString())){
				Database.get().update("PlayerLastOnline", "date", lastonline, "uuid", p.getUniqueId().toString());
			}
			else{
				Database.get().insert("PlayerLastOnline", "uuid`, `date", p.getUniqueId().toString() + "', '" + lastonline);
			}
			
			if(Database.get().containsPath("PlayerUUIDs", "name", "name", p.getName())){
				Database.get().update("PlayerUUIDs", "uuid", p.getUniqueId().toString(), "name", p.getName());
			}
			else{
				Database.get().insert("PlayerUUIDs", "name`, `uuid", p.getName() + "', '" + p.getUniqueId().toString());
			}
			
			ServerData.getBungee().getIPs().put(p.getUniqueId(), p.getAddress().getHostString());
			if(Database.get().containsPath("PlayerIPs", "uuid", "uuid", p.getUniqueId().toString())){
				Database.get().update("PlayerIPs", "ip", p.getAddress().getHostString(), "uuid", p.getUniqueId().toString());
			}
			else{
				Database.get().insert("PlayerIPs", "uuid`, `ip", p.getUniqueId().toString() + "', '" + p.getAddress().getHostString());
			}
			
			if(Database.get().containsPath("PlayerSilentJoin", "uuid", "uuid", uuid)){
				this.silent = Boolean.parseBoolean(Database.get().getString("PlayerSilentJoin", "silentjoin", "uuid", uuid));
			}
			else{
				this.silent = false;
			}
			
			if(Database.get().containsPath("Rank-VIP", "uuid", "uuid", uuid)){
				this.viprank = VIPRank.valueOf(Database.get().getString("Rank-VIP", "vip", "uuid", uuid));
			}
			else{
				this.viprank = VIPRank.User;
			}
			
			if(Database.get().containsPath("Rank-Staff", "uuid", "uuid", uuid)){
				this.staffrank = StaffRank.valueOf(Database.get().getString("Rank-Staff", "staff", "uuid", uuid));
			}
			else{
				this.staffrank = StaffRank.User;
			}
			
			if(Database.get().containsPath("Friends", "uuid", "uuid", uuid)){
				String[] friends = Database.get().getString("Friends", "friends", "uuid", uuid).split("\\|");
				List<UUID> friendsS = new ArrayList<UUID>();
				for(String friend : friends){
					friendsS.add(UUID.fromString(friend));
				}
				this.friends = friendsS;
			}
			
		}catch(Exception ex){ex.printStackTrace();}
	}
}
