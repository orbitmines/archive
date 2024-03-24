package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.LobbyManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.PlayerDataManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.SpectatorManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;

public class Arena {

	Start start = Start.getInstance();
	
	private int arenaid;
	private Location lobbyspawn;
	private int minplayers;
	private int maxplayers;
	private Map map;
	private List<SpleefPlayer> players;
	private List<SpleefPlayer> diedplayers;
	private List<SpleefPlayer> spectators;
	private SpleefStatus status;
	private int minutes;
	private int seconds;
	
	private SpleefPlayer first;
	private SpleefPlayer second;
	private SpleefPlayer third;

	private List<ArenaSign> arenasigns = new ArrayList<ArenaSign>();
	
	private List<SpleefPlayer> playerblocks = new ArrayList<SpleefPlayer>();
	private List<Location> blocklocations = new ArrayList<Location>();
	private List<OldBlock> oldblocks = new ArrayList<OldBlock>();

	private List<Projectile> rangesmall = new ArrayList<Projectile>();
	private List<Projectile> rangemedium = new ArrayList<Projectile>();
	private List<Projectile> rangebig = new ArrayList<Projectile>();
	private List<Projectile> teleportarrows = new ArrayList<Projectile>();
	
	BukkitTask task;
	
	public Arena(int arenaid, Location lobbyspawn, int minplayers, int maxplayers, Map map, List<SpleefPlayer> players, List<SpleefPlayer> spectators, SpleefStatus status, int minutes, int seconds){
		this.arenaid = arenaid;
		this.lobbyspawn = lobbyspawn;
		this.minplayers = minplayers;
		this.maxplayers = maxplayers;
		this.map = map;
		this.players = players;
		this.diedplayers = new ArrayList<SpleefPlayer>();
		this.spectators = spectators;
		this.status = status;
		this.minutes = minutes;
		this.seconds = seconds;
		
		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false || StorageManager.bungeecord == false){
			if(lobbyspawn != null){
				selectRandomMap();
			}
		}
		
		BukkitTask task = new BukkitRunnable(){
			public void run(){
				
				if(StorageManager.bungeecord == true && StorageManager.ishubserver == false || StorageManager.bungeecord == false){
					if(isStatus(SpleefStatus.WAITING)){
						updateLobbyInventory();
						
						if(enoughPlayers()){
							timeCheck();
							
							if(StorageManager.startingmessageat.contains(getMinutes() + ":" + getSeconds())){
								sendStartingMessage();
							}
							
							if(getMinutes() == 0 && getSeconds() == 11){
								toStarting();
							}
						}
						else{
							setMinutes(StorageManager.waittimeminutes);
							setSeconds(StorageManager.waittimeseconds);
						}
					}
					else if(isStatus(SpleefStatus.STARTING)){
						timeCheck();
						updateLobbyInventory();
	
						if(StorageManager.startingmessageat.contains(getMinutes() + ":" + getSeconds())){
							sendStartingMessage();
						}
						
						if(getMinutes() == 0 && getSeconds() == 0){
							toWarmup();
						}
					}
					else if(isStatus(SpleefStatus.WARMUP)){
						timeCheck();
						
						if(getMinutes() == 0 && getSeconds() == 0){
							toInGame();
						}
					}
					else if(isStatus(SpleefStatus.INGAME)){
						timeCheck();
						
						if(StorageManager.endingmessageat.contains(getMinutes() + ":" + getSeconds())){
							sendEndingMessage();
						}
						
						for(SpleefPlayer sp : getPlayers()){
							sp.updateKitInventory(false);
						}
	
						if(getMinutes() == 0 && getSeconds() == 0){
							toEnding();
						}
						else{
							updateSpectators();
						}
					}
					else if(isStatus(SpleefStatus.ENDING)){
						timeCheck();
	
						if(getMinutes() == 0 && getSeconds() == 0){
							toRestarting();
						}
					}
					else if(isStatus(SpleefStatus.RESTARTING)){
						if(getBlockLocations().size() != 0){
							resetMapPart();
						}
						else{
							toWaiting();
						}
					}
					else{}
					
					setScoreboard();
				}
				
				updateBungeeArena();
				updateSigns();
			}
		}.runTaskTimer(this.start, 0, 20);
		this.task = task;
	}
	
	public void cancelArena(){
		task.cancel();
	}
	
	public int getArenaID(){
		return this.arenaid;
	}
	
	public Location getLobby(){
		return this.lobbyspawn;
	}
	public void setLobby(Location lobbyspawn){
		this.lobbyspawn = lobbyspawn;
	}
	
	public int getMinPlayers(){
		return this.minplayers;
	}
	public void setMinPlayers(int minplayers){
		this.minplayers = minplayers;
	}
	
	public int getMaxPlayers(){
		return this.maxplayers;
	}
	public void setMaxPlayers(int maxplayers){
		this.maxplayers = maxplayers;
	}
	
	public Map getMap(){
		return this.map;
	}
	public void setMap(Map map){
		this.map = map;
		this.map.setInUse(true);
	}
	
	public List<SpleefPlayer> getPlayers(){
		return players;
	}
	public void setPlayers(List<SpleefPlayer> players){
		this.players = players;
	}	
	public void addPlayer(SpleefPlayer p){
		this.players.add(p);
	}	
	public void removePlayer(SpleefPlayer p){
		this.players.remove(p);
	}
	
	public List<SpleefPlayer> getDiedPlayers(){
		return diedplayers;
	}
	public void setDiedPlayers(List<SpleefPlayer> diedplayers){
		this.diedplayers = diedplayers;
	}	
	public void addDiedPlayer(SpleefPlayer p){
		this.diedplayers.add(p);
	}	
	public void removeDiedPlayer(SpleefPlayer p){
		this.diedplayers.remove(p);
	}
	
	public List<SpleefPlayer> getSpectators(){
		return spectators;
	}
	public void setSpectators(List<SpleefPlayer> spectators){
		this.spectators = spectators;
	}	
	public void addSpectator(SpleefPlayer p){
		this.spectators.add(p);
	}	
	public void removeSpectator(SpleefPlayer p){
		this.spectators.remove(p);
	}
	
	public SpleefStatus getStatus(){
		return status;
	}
	public boolean isStatus(SpleefStatus status){
		return this.status == status;
	}
	public void setStatus(SpleefStatus status){
		this.status = status;
	}
	
	public int getMinutes(){
		return this.minutes;
	}
	public void subtractMinute(){
		this.minutes = this.minutes -1;
	}
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	public int getSeconds(){
		return this.seconds;
	}
	public void subtractSecond(){
		this.seconds = this.seconds -1;
	}
	public void setSeconds(int seconds){
		this.seconds = seconds;
	}
	
	public List<ArenaSign> getArenaSigns(){
		return this.arenasigns;
	}
	public void addArenaSign(ArenaSign arenasign){
		this.arenasigns.add(arenasign);
	}
	public void removeArenaSign(ArenaSign arenasign){
		this.arenasigns.remove(arenasign);
	}
	public void setArenaSigns(List<ArenaSign> arenasigns){
		this.arenasigns = arenasigns;
	}

	public List<SpleefPlayer> getPlayerBlocks(){
		return this.playerblocks;
	}
	public void addPlayerBlocks(SpleefPlayer sp){
		this.playerblocks.add(sp);
	}
	public void setPlayerBlocks(List<SpleefPlayer> playerblocks){
		this.playerblocks = playerblocks;
	}

	public List<Location> getBlockLocations(){
		return this.blocklocations;
	}
	public void addBlockLocation(Location location){
		this.blocklocations.add(location);
	}
	public void removeBlockLocation(Location location){
		this.blocklocations.remove(location);
	}
	public void setBlockLocations(List<Location> blocklocations){
		this.blocklocations = blocklocations;
	}
	
	public List<OldBlock> getOldBlocks(){
		return this.oldblocks;
	}
	public void addOldBlock(Location location, Material material, byte durability){
		this.oldblocks.add(new OldBlock(this, location, material, durability));
	}
	public void removeOldBlock(OldBlock oldblock){
		this.oldblocks.remove(oldblock);
	}
	public void setOldBlocks(List<OldBlock> oldblocks){
		this.oldblocks = oldblocks;
	}
	
	public List<Projectile> getProjectilesSmall(){
		return this.rangesmall;
	}
	public void addProjectileSmall(Projectile proj){
		this.rangesmall.add(proj);
	}
	public void removeProjectileSmall(Projectile proj){
		this.rangesmall.remove(proj);
	}
	public void setProjectilesSmall(List<Projectile> proj){
		this.rangesmall = proj;
	}
	
	public List<Projectile> getProjectilesMedium(){
		return this.rangemedium;
	}
	public void addProjectileMedium(Projectile proj){
		this.rangemedium.add(proj);
	}
	public void removeProjectileMedium(Projectile proj){
		this.rangemedium.remove(proj);
	}
	public void setProjectilesMedium(List<Projectile> proj){
		this.rangemedium = proj;
	}
	
	public List<Projectile> getProjectilesBig(){
		return this.rangebig;
	}
	public void addProjectileBig(Projectile proj){
		this.rangebig.add(proj);
	}
	public void removeProjectileBig(Projectile proj){
		this.rangebig.remove(proj);
	}
	public void setProjectilesBig(List<Projectile> proj){
		this.rangebig = proj;
	}
	
	public List<Projectile> getTeleportArrows(){
		return this.teleportarrows;
	}
	public void addTeleportArrow(Projectile proj){
		this.teleportarrows.add(proj);
	}
	public void removeTeleportArrow(Projectile proj){
		this.teleportarrows.remove(proj);
	}
	public void setTeleportArrows(List<Projectile> proj){
		this.teleportarrows = proj;
	}

	public void setScoreboard(){
		for(SpleefPlayer sp : this.getPlayers()){
			sp.setScoreboard();
		}
	}
	
	public List<SpleefPlayer> getAllPlayers(){
		List<SpleefPlayer> players = new ArrayList<SpleefPlayer>();
		for(SpleefPlayer sps : getPlayers()){
			players.add(sps);
		}
		for(SpleefPlayer sps : getSpectators()){
			players.add(sps);
		}
		return players;
	}
	
	public void timeCheck(){
		if(getSeconds() != -1){
			setSeconds(getSeconds() -1);
		}
		if(getSeconds() == -1){
			setMinutes(getMinutes() -1);
			setSeconds(59);
		}
	}
	
	public boolean enoughPlayers(){
		if(getPlayers().size() >= getMinPlayers()){
			return true;
		}
		return false;
	}
	public boolean isFull(){
		if(getPlayers().size() >= getMaxPlayers()){
			return true;
		}
		return false;
	}
	
	public void checkGameFinish(){
		if(getPlayers().size() == 1){
			toEnding();
		}
	}
	
	public void updateBungeeArena(){
		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false){
			if(Bukkit.getOnlinePlayers().size() > 0){
				ByteArrayOutputStream b = new ByteArrayOutputStream();
	        	DataOutputStream out = new DataOutputStream(b);
	 
	        	try{
	        		out.writeUTF("Forward");
	        		out.writeUTF("ALL");
	        		out.writeUTF("SpigotSpleef");
	            	String mapname = "";
	            	if(getMap() == null || getMap().getName() == null){
	            		mapname = "";
	            	}
	            	else{
	            		mapname = getMap().getName();
	            	}
	            	out.writeUTF(StorageManager.thisbungeeservername + "|" + getArenaID() + "|" + getMinPlayers() + "|" + getMaxPlayers() + "|" + mapname + "|" + getPlayers().size() + "|" + getSpectators().size() + "|" + getStatus().toString() + "|" + getMinutes() + "|" + getSeconds());
	        	}catch(IOException eee){
	        		eee.printStackTrace();
	        	}
	        	
	        	Player player = null;
	        	for(Player p : Bukkit.getOnlinePlayers()){
	        		player = p;
	        	}
        		player.sendPluginMessage(Start.getInstance(), "BungeeCord", b.toByteArray());
        	}
		}
	}
	
	public void toWaiting(){
		if(getMap() != null){
			getMap().setInUse(false);
		}
		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false || StorageManager.bungeecord == false){
			selectRandomMap();
		}
		setStatus(SpleefStatus.WAITING);
		setMinutes(StorageManager.waittimeminutes);
		setSeconds(StorageManager.waittimeseconds);
		setPlayers(new ArrayList<SpleefPlayer>());
		setDiedPlayers(new ArrayList<SpleefPlayer>());
		setSpectators(new ArrayList<SpleefPlayer>());
		setPlayerBlocks(new ArrayList<SpleefPlayer>());
		setBlockLocations(new ArrayList<Location>());
		setOldBlocks(new ArrayList<OldBlock>());
		setProjectilesSmall(new ArrayList<Projectile>());
		setProjectilesMedium(new ArrayList<Projectile>());
		setProjectilesBig(new ArrayList<Projectile>());
		setTeleportArrows(new ArrayList<Projectile>());
		this.first = null;
		this.second = null;
		this.third = null;
	}
	
	public void toStarting(){
		setStatus(SpleefStatus.STARTING);
		for(SpleefPlayer sp : getPlayers()){
			if(sp.getKit() == null){
				sp.setKit(sp.getUnlockedKits().get(0));
			}
		}
	}

	public void toWarmup(){
		for(SpleefPlayer sp : getPlayers()){
			sp.clearInventory();
		}
		setStatus(SpleefStatus.WARMUP);
		setMinutes(0);
		setSeconds(StorageManager.warmuptimeseconds);
		getMap().teleport(this.players);
		sendStartedMessage();
		resetScoreboard();
	}

	public void toInGame(){
		setStatus(SpleefStatus.INGAME);
		setMinutes(StorageManager.maxgametimeminutes);
		setSeconds(StorageManager.maxgametimeseconds);
		for(SpleefPlayer sp : getPlayers()){
			sp.updateKitInventory(true);
		}
		sendStartedGameMessage();
	}

	public void toEnding(){
		setStatus(SpleefStatus.ENDING);
		setMinutes(0);
		setSeconds(StorageManager.endingtimeseconds);
		
		SpleefPlayer sp = getPlayers().get(0);
		first = sp;
		sp.addWin();
		PlayerDataManager.setWins(sp.getPlayer().getUniqueId(), sp.getWins());
		
		if(getPlayers().size() > 1){
			second = getPlayers().get(1);
		}
		else if(getDiedPlayers().size() > 0){
			second = getDiedPlayers().get(getDiedPlayers().size() -1);
		}
		else{}
		
		if(getPlayers().size() > 2){
			third = getPlayers().get(2);
		}
		else if(getDiedPlayers().size() > 1){
			third = getDiedPlayers().get(getDiedPlayers().size() -2);
		}
		else{}
		
		sendEndedMessage();
	}
	
	public void updateLobbyInventory(){
		for(SpleefPlayer sp : getPlayers()){
			LobbyManager.give(sp);
		}
	}

	public void updateSpectators(){
		for(SpleefPlayer sp : getSpectators()){
			sp.getPlayer().setGameMode(GameMode.CREATIVE);
			sp.getPlayer().setAllowFlight(true);
			sp.getPlayer().setFlying(true);
			SpectatorManager.give(sp);
			
			for(SpleefPlayer sps : getPlayers()){
				sp.getPlayer().showPlayer(sps.getPlayer());
				sps.getPlayer().hidePlayer(sp.getPlayer());
			}
			
			((CraftPlayer) sp.getPlayer()).getHandle().setInvisible(true);
		}
	}

	public void toRestarting(){
		setStatus(SpleefStatus.RESTARTING);
		for(SpleefPlayer sp : getAllPlayers()){
			int received = 0;
			
			Message m = Message.getMessage(MessageName.TOKENS_RECEIVED);
			m.replace("&", "§");
			int killsreward = (StorageManager.tokensperkill * sp.getRoundKills());
			received = received + killsreward;
			m.replace("%kills-reward%", "" + killsreward);
			m.replace("%round-kills%", "" + sp.getRoundKills());
			m.replace("%multiplier-name%", sp.getMultiplierName());
			if(sp.getRoundKills() == 1){
				m.replace("%kill-grammer%", "" + Message.getMessage(MessageName.KILL_GRAMMER_ONE).getMessage().replace("&", "§"));
			}
			else{
				m.replace("%kill-grammer%", "" + Message.getMessage(MessageName.KILL_GRAMMER_MULTIPLE).getMessage().replace("&", "§"));
			}
			
			if(this.first == sp){
				sp.addWin();
				received = received + StorageManager.tokensfirstplace;
				sp.addTokens((int) (StorageManager.tokensfirstplace * sp.getMultiplier()));
				
				m.replace("%placement-reward%", "" + StorageManager.tokensfirstplace);
				m.replace("%placement-grammer%", "" + Message.getMessage(MessageName.GRAMMER_FIRST).getMessage().replace("&", "§"));
				received = (int) (received * sp.getMultiplier());
				m.replace("%received-tokens%", "" + received);
				m.send(sp.getPlayer());
				
				if(StorageManager.usecommandrewards == true){
					for(String command : StorageManager.firstplacecommands){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("&", "§").replace("%player%", sp.getPlayer().getName()));
					}
				}
			}
			else if(this.second == sp){
				if(sp.isPlayer()){
					sp.addLose();
				}
				received = received + StorageManager.tokenssecondsplace;
				sp.addTokens((int) (StorageManager.tokenssecondsplace * sp.getMultiplier()));
				m.replace("%placement-reward%", "" + StorageManager.tokenssecondsplace);
				m.replace("%placement-grammer%", "" + Message.getMessage(MessageName.GRAMMER_SECOND).getMessage().replace("&", "§"));
				received = (int) (received * sp.getMultiplier());
				m.replace("%received-tokens%", "" + received);
				m.send(sp.getPlayer());
				
				if(StorageManager.usecommandrewards == true){
					for(String command : StorageManager.secondplacecommands){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("&", "§").replace("%player%", sp.getPlayer().getName()));
					}
				}
			}
			else if(this.third == sp){
				if(sp.isPlayer()){
					sp.addLose();
				}
				received = received + StorageManager.tokensthirdplace;
				sp.addTokens((int) (StorageManager.tokensthirdplace * sp.getMultiplier()));
				m.replace("%placement-reward%", "" + StorageManager.tokensthirdplace);
				m.replace("%placement-grammer%", "" + Message.getMessage(MessageName.GRAMMER_THIRD).getMessage().replace("&", "§"));
				received = (int) (received * sp.getMultiplier());
				m.replace("%received-tokens%", "" + received);
				m.send(sp.getPlayer());
				
				if(StorageManager.usecommandrewards == true){
					for(String command : StorageManager.thirdplacecommands){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("&", "§").replace("%player%", sp.getPlayer().getName()));
					}
				}
			}
			else{
				if(sp.isPlayer()){
					sp.addLose();
				}
				received = (int) (received * sp.getMultiplier());
				m.replace("%received-tokens%", "" + received);
				m.send(sp.getPlayer(), "%placement-reward%", "%placement-grammer%");
			}
			
			try{
				sp.quitSpleef();
			}catch(NullPointerException ex){
				Bukkit.getLogger().warning("Error: SS-QS");
			}
		}
	}
	
	public void resetScoreboard(){
		for(SpleefPlayer sp : getAllPlayers()){
			sp.setScoreboard(null);
			sp.setRows(new ArrayList<String>());
			sp.getPlayer().getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		}
	}
	
	public void resetMapPart(){
		for(int i = 0; i <= 50; i++){
			try{
				Location location = getBlockLocations().get(0);
				restoreBlock(location);
				removeBlockLocation(location);
			}
			catch(IndexOutOfBoundsException ex){
				i = 50;
			}
		}
	}
	public void resetMap(){
		if(getBlockLocations().size() != 0){
			for(Location location : getBlockLocations()){
				try{
					restoreBlock(location);
					removeBlockLocation(location);
				}catch(Exception ex){}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void restoreBlock(Location location){
		try{
			for(OldBlock oldblock : getOldBlocks()){
				if(oldblock.getLocation().getBlockX() == location.getBlockX() && oldblock.getLocation().getBlockY() == location.getBlockY() && oldblock.getLocation().getBlockZ() == location.getBlockZ()){
					Block b = location.getBlock();
					b.setType(oldblock.getMaterial());
					b.setData(oldblock.getDurability());
					removeOldBlock(oldblock);
				}
			}
		}catch(ConcurrentModificationException ex){}
	}
	
	public void selectRandomMap(){
		List<Map> maps = StorageManager.maps;
		List<Map> notinuse = new ArrayList<Map>();
		for(Map map : maps){
			if(!map.isInUse()){
				notinuse.add(map);
			}
		}
		setMap(notinuse.get(new Random().nextInt(notinuse.size())));
	}
	
	public void updateSigns(){
		for(ArenaSign sign : StorageManager.signs){
			if(sign.getArena() != null && sign.isArena(getArenaID())){
				try{sign.update();}catch(ArrayIndexOutOfBoundsException ex){}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void breakBlock(SpleefPlayer sp, Block b){
		if(!containsBlockLocation(b.getLocation())){
			addBlockLocation(b.getLocation());
			addPlayerBlocks(sp);
			addOldBlock(b.getLocation(), b.getType(), b.getData());
		}
			
		for(SpleefPlayer sps : getPlayers()){
			sps.getPlayer().playEffect(b.getLocation().add(0.5, 0, 0.5), Effect.STEP_SOUND, b.getTypeId());
		}
		
		String block = b.getTypeId() + ":" + b.getData();
		if(StorageManager.blocktoblock.containsKey(block)){
			String to = StorageManager.blocktoblock.get(block);
			String[] toparts = to.split("\\:");
			Material material = Material.getMaterial(Integer.parseInt(toparts[0]));
			byte durability = (byte) Integer.parseInt(toparts[1]);
			
			b.setType(material);
			b.setData(durability);
		}
		else{
			b.setType(Material.AIR);
		}
	}
	public boolean containsBlockLocation(Location location){
		return getBlockLocations().contains(location);
	}

	public void sendStartedGameMessage(){
		Message message = Message.getMessage(MessageName.GAME_STARTED);
		message.updateForArena(this, null, null, null);
		message.send(getAllPlayers());
	}
	public void sendDeathMessage(SpleefPlayer died, SpleefPlayer killer){
		List<SpleefPlayer> tosps = getAllPlayers();
		tosps.remove(died);
		if(killer != null){
			tosps.remove(killer);
		}

		if(killer == null){
			Message message = Message.getMessage(MessageName.DEATHMESSAGE_UNKNOWN_KILLER);
			message.updateForArena(this, killer, died, null);
			message.send(tosps);
		}
		else{
			Message message = Message.getMessage(MessageName.DEATHMESSAGE);
			message.updateForArena(this, killer, died, null);
			message.send(tosps);
		}
		
		if(killer != null){
			Message message1 = Message.getMessage(MessageName.DEATHMESSAGE_TO_PLAYER);
			message1.updateForArena(this, killer, died, null);
			message1.send(Arrays.asList(died));

			Message message2 = Message.getMessage(MessageName.DEATHMESSAGE_TO_KILLER);
			message2.updateForArena(this, killer, died, null);
			message2.send(Arrays.asList(killer));
		}
		else{
			Message message = Message.getMessage(MessageName.DEATHMESSAGE_TO_PLAYER_UNKNOWN_KILLER);
			message.updateForArena(this, killer, died, null);
			message.send(Arrays.asList(died));
		}
	}
	public void sendEndedMessage(){
		Message message = Message.getMessage(MessageName.ENDED);
		message.updateForArena(this, first, second, third);
		message.send(getAllPlayers());
	}
	public void sendEndingMessage(){
		Message message = Message.getMessage(MessageName.ENDING);
		message.updateForArena(this, null, null, null);
		message.send(getAllPlayers());
	}
	public void sendStartedMessage(){
		Message message = Message.getMessage(MessageName.STARTED);
		message.updateForArena(this, null, null, null);
		message.send(getAllPlayers());
	}
	public void sendStartingMessage(){
		Message message = Message.getMessage(MessageName.STARTING);
		message.updateForArena(this, null, null, null);
		message.send(getAllPlayers());
	}
	public void sendJoinMessage(SpleefPlayer sp){
		MessageName messagename;
		if(sp.isPlayer()){
			messagename = MessageName.PLAYER_JOIN;
		}
		else{
			messagename = MessageName.SPECTATOR_JOIN;
		}
		
		Message message = Message.getMessage(messagename);
		message.updateForArena(this, sp, null, null);
		message.send(getAllPlayers());
	}
	public void sendQuitMessage(SpleefPlayer sp){
		MessageName messagename;
		if(sp.isPlayer()){
			messagename = MessageName.PLAYER_QUIT;
		}
		else{
			messagename = MessageName.SPECTATOR_QUIT;
		}
		
		Message message = Message.getMessage(messagename);
		message.updateForArena(this, sp, null, null);
		message.send(getAllPlayers());
	}
	
	public static Arena getArenaFromID(int arenaid){
		for(Arena arena : StorageManager.arenas){
			if(arena.getArenaID() == arenaid){
				return arena;
			}
		}
		return null;
	}
}
