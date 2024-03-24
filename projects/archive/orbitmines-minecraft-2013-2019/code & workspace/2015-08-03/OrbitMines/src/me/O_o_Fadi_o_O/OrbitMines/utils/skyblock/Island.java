package me.O_o_Fadi_o_O.OrbitMines.utils.skyblock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SkyBlockServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockUtils.IslandRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Island {

	private int islandid;
	private Location location;
	private String createddate;
	private UUID owner;
	private List<UUID> members;
	private boolean teleportenabled;
	private boolean islandprotection;
	private int maxmembers;
	private boolean nethergenerated;

	public Island(int islandid, Location location, String createddate, UUID owner, List<UUID> members, boolean teleportenabled, boolean islandprotection, boolean nethergenerated){
		this.islandid = islandid;
		this.location = location;
		this.createddate = createddate;
		this.owner = owner;
		this.members = members;
		this.teleportenabled = teleportenabled;
		this.islandprotection = islandprotection;
		this.nethergenerated = nethergenerated;
		this.maxmembers = 0;
	}

	public int getIslandID() {
		return islandid;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
		
		ConfigManager.islands.set("islands." + this.islandid + ".IslandLocation", Utils.getStringFromLocation(this.location));
		ConfigManager.saveIslands();
	}
	public Location getNetherLocation(){
		return new Location(ServerData.getSkyBlock().getSkyblockNetherWorld(), getLocation().getX(), 50.0, getLocation().getZ());
	}
	public Location getNetherHomeLocation(){
		return new Location(ServerData.getSkyBlock().getSkyblockNetherWorld(), getLocation().getX() +0.5, 51.0, getLocation().getZ() +0.5, 180, 0);
	}

	public String getCreatedDate() {
		return createddate;
	}
	public void setCreatedDate(String createddate) {
		this.createddate = createddate;
		
		ConfigManager.islands.set("islands." + this.islandid + ".CreatedDate", this.createddate);
		ConfigManager.saveIslands();
	}

	public UUID getOwner() {
		return owner;
	}
	public void setOwner(UUID owner) {
		this.owner = owner;
		
		ConfigManager.islands.set("islands." + this.islandid + ".Players.Owner", this.owner.toString());
		ConfigManager.saveIslands();
	}
	public String getOwnerName(){
		Player p = Utils.getPlayer(this.owner);
		
		if(p != null){
			return p.getName();
		}
		return Utils.getName(this.owner);
	}
	public Location getOwnersHomeLocation(){
		Player p = Utils.getPlayer(this.owner);
		
		if(p != null){
			return OMPlayer.getOMPlayer(p).getSkyBlockPlayer().getHomeLocation();
		}
		return Utils.getLocationFromString(ConfigManager.playerdata.getString("players." + getOwner().toString() + ".IslandInfo.HomeLocation"));
	}
	
	public List<UUID> getMembers() {
		return members;
	}
	public void setMembers(List<UUID> members) {
		this.members = members;
		
		ConfigManager.islands.set("islands." + this.islandid + ".Players.Members", Utils.getStringList(this.members));
		ConfigManager.saveIslands();
	}
	public void addMember(UUID member){
		this.members.add(member);
		
		ConfigManager.islands.set("islands." + this.islandid + ".Players.Members", Utils.getStringList(this.members));
		ConfigManager.saveIslands();
	}
	public void removeMember(UUID member){
		this.members.remove(member);
		
		ConfigManager.islands.set("islands." + this.islandid + ".Players.Members", Utils.getStringList(this.members));
		ConfigManager.saveIslands();
	}

	public boolean isTeleportEnabled() {
		return teleportenabled;
	}
	public void setTeleportEnabled(boolean teleportenabled) {
		this.teleportenabled = teleportenabled;
		
		ConfigManager.islands.set("islands." + this.islandid + ".TeleportEnabled", this.teleportenabled);
		ConfigManager.saveIslands();
	}

	public boolean hasIslandProtection() {
		return islandprotection;
	}
	public void setIslandProtection(boolean islandprotection) {
		this.islandprotection = islandprotection;
		
		ConfigManager.islands.set("islands." + this.islandid + ".IslandProtection", this.islandprotection);
		ConfigManager.saveIslands();
	}
	
	public void sendMessageToMembers(String message){
		List<String> stringuuids = Utils.getStringList(this.members);
		for(Player p : Bukkit.getOnlinePlayers()){
			if(stringuuids.contains(p.getUniqueId().toString())){
				p.sendMessage(message);
			}
		}
	}

	public int getMaxMembers() {
		if(maxmembers == 0){
			Player p = Utils.getPlayer(this.owner);
			
			if(p != null){
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				
				if(omp.hasPerms(VIPRank.Emerald_VIP) || omp.hasPerms(StaffRank.Owner)){
					this.maxmembers = 21;
					return 21;
				}
				else if(omp.hasPerms(VIPRank.Diamond_VIP)){
					this.maxmembers = 14;
					return 14;
				}
				else if(omp.hasPerms(VIPRank.Gold_VIP)){
					this.maxmembers = 9;
					return 9;
				}
				else if(omp.hasPerms(VIPRank.Iron_VIP)){
					this.maxmembers = 5;
					return 5;
				}
				else{
					this.maxmembers = 3;
					return 3;
				}
			}
			else{
				VIPRank viprank = VIPRank.User;
				StaffRank staffrank = null;
				
				if(Database.get().containsPath("Rank-VIP", "uuid", "uuid", this.owner.toString())){
					viprank = VIPRank.valueOf(Database.get().getString("Rank-VIP", "vip", "uuid", this.owner.toString()));
				}
				
				if(Database.get().containsPath("Rank-Staff", "uuid", "uuid", this.owner.toString())){
					staffrank = StaffRank.valueOf(Database.get().getString("Rank-Staff", "staff", "uuid", this.owner.toString()));
				}
				
				if(viprank == VIPRank.Emerald_VIP || staffrank == StaffRank.Owner){
					this.maxmembers = 21;
					return 21;
				}
				else if(viprank == VIPRank.Diamond_VIP){
					this.maxmembers = 14;
					return 14;
				}
				else if(viprank == VIPRank.Gold_VIP){
					this.maxmembers = 9;
					return 9;
				}
				else if(viprank == VIPRank.Iron_VIP){
					this.maxmembers = 5;
					return 5;
				}
				else{
					this.maxmembers = 3;
					return 3;
				}
			}
		}
		return maxmembers;
	}
	public void setMaxMembers(int maxmembers) {
		this.maxmembers = maxmembers;
	}

	public boolean isNetherGenerated() {
		return nethergenerated;
	}
	public void setNetherGenerated(boolean nethergenerated) {
		this.nethergenerated = nethergenerated;
		
		ConfigManager.islands.set("islands." + this.islandid + ".NetherGenerated", nethergenerated);
		ConfigManager.saveIslands();
	}
	
	public void saveAll(){
		FileConfiguration islands = ConfigManager.islands;
		islands.set("islands." + this.islandid + ".IslandLocation", Utils.getStringFromLocation(this.location));
		islands.set("islands." + this.islandid + ".CreatedDate", this.createddate);
		islands.set("islands." + this.islandid + ".TeleportEnabled", this.teleportenabled);
		islands.set("islands." + this.islandid + ".NetherGenerated", this.nethergenerated);
		islands.set("islands." + this.islandid + ".Players.Owner", this.owner.toString());
		islands.set("islands." + this.islandid + ".Players.Members", Utils.getStringList(this.members));
		ConfigManager.saveIslands();
	}
	
	public void delete(){
		ServerData.getSkyBlock().getIslands().remove(this);
		
		ConfigManager.islands.set("islands." + this.islandid, null);
		ConfigManager.saveIslands();
	}
	
	public static List<Island> getIslands(){
		return ServerData.getSkyBlock().getIslands();
	}
	
	public static List<Island> getUnprotectedIslands(){
		List<Island> islands = new ArrayList<Island>();
		for(Player p : Bukkit.getOnlinePlayers()){
			SkyBlockPlayer sbp = OMPlayer.getOMPlayer(p).getSkyBlockPlayer();
			Island is = sbp.getIsland();
			
			if(sbp.hasIsland() && !is.hasIslandProtection() && !islands.contains(is)){
				islands.add(is);
			}
		}
		return islands;
	}
	
	public static Island getIsland(int islandid){
		for(Island is : ServerData.getSkyBlock().getIslands()){
			if(is.getIslandID() == islandid){
				return is;
			}
		}
		return null;
	}
	
	public static Island getIsland(Player player){
		for(Island is : ServerData.getSkyBlock().getIslands()){
			if(is.getOwner().toString().equals(player.getUniqueId().toString()) || Utils.getStringList(is.getMembers()).contains(player.getUniqueId().toString())){
				return is;
			}
		}
		return null;
	}
	
	public static void generate(final SkyBlockPlayer sbp){
		SkyBlockServer skyblock = ServerData.getSkyBlock();
		Player p = sbp.getPlayer();
		int islandid = skyblock.getTotalIslands() +1;
		
		World w = skyblock.getSkyblockWorld();	
				
		Location l = SkyBlockUtils.getNextLocation(w);
		for(Player player : Bukkit.getOnlinePlayers()){
			OMPlayer omplayer = OMPlayer.getOMPlayer(player);
			if(omplayer.hasPerms(StaffRank.Moderator)){
				if(l != null){
					player.sendMessage("§7Generating §d" + p.getName() + "'s Island§7... §7(§d" + l.getWorld().getName() + "§7, §d" + l.getBlockX() + "§7, §d" + l.getBlockY() + "§7, §d" + l.getBlockZ() + "§7)");
				}
				else{
					player.sendMessage("§4§lERROR§7! §d" + p.getName() + "§7tried to generate an §dIsland§7.");
					Bukkit.getConsoleSender().sendMessage("§4§lERROR§7! §d" + p.getName() + "§7tried to generate an §dIsland§7.");
				}
			}
		}
		
		SkyBlockUtils.generateIsland(l);
					
		Island is = new Island(islandid, l, new SimpleDateFormat("dd-MM-yyyy").format(new Date()), p.getUniqueId(), new ArrayList<UUID>(), false, true, false);
		is.saveAll();
		skyblock.getIslands().add(is);
		skyblock.setTotalIslands(islandid);
		skyblock.setLastLocation(l);
		
		sbp.setIsland(is, IslandRank.OWNER);
								
		p.teleport(sbp.getHomeLocation());
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);

		Title t = new Title("", "§7Teleported to your §dIsland§7.");
		t.send(p);
	}
}