package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.PlayerDataManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeArena;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

public class SpleefPlayer {

	private Player player;
	private List<Kit> unlockedkits;
	private Map<KitItemStack, Long> cooldowns = new HashMap<KitItemStack, Long>();
	private Scoreboard scoreboard;
	private int lastscoreboardid;
	private List<String> scoreboardrows;
	private Arena arena;
	private Kit kit;
	private int tokens;
	private int kills;
	private int wins;
	private int loses;
	private int animateddots;
	private int animtedrightclick;
	private List<TNTPrimed> instanttnt;
	private List<Egg> throwneggs;
	private boolean spectator;
	private int roundkills;
	
	public SpleefPlayer(Player player, List<Kit> unlockedkits, Arena arena, Kit kit, int tokens, int kills, int wins, int loses, boolean spectator){
		this.player = player;
		this.unlockedkits = unlockedkits;
		this.scoreboard = null;
		this.scoreboardrows = new ArrayList<String>();
		this.arena = arena;
		this.kit = kit;
		this.tokens = tokens;
		this.kills = kills;
		this.wins = wins;
		this.loses = loses;
		this.animateddots = 0;
		this.animtedrightclick = 0;
		this.spectator = spectator;
		this.roundkills = 0;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public List<Kit> getUnlockedKits(){
		return this.unlockedkits;
	}
	public void addUnlockedKit(Kit kit){
		this.unlockedkits.add(kit);
	}
	
	public Map<KitItemStack, Long> getCooldowns(){
		return cooldowns;
	}
	public Long getCooldown(KitItemStack kititemstack){
		if(getCooldowns().containsKey(kititemstack)){
			return getCooldowns().get(kititemstack);
		}
		return null;
	}
	public void setCooldown(KitItemStack kititemstack, Long l){
		this.cooldowns.put(kititemstack, l);
	}
	public void setCooldowns(Map<KitItemStack, Long> cooldowns){
		this.cooldowns = cooldowns;
	}

	public Scoreboard getScoreboard(){
		return this.scoreboard;
	}
	public void setScoreboard(Scoreboard scoreboard){
		this.scoreboard = scoreboard;
	}
	public void setScoreboard(){
		if(this.scoreboard == null){
			Scoreboard scoreboard = ScoreboardManager.getNewScoreboard(this);
			this.scoreboard = scoreboard;
			this.player.setScoreboard(scoreboard);
		}
		else{
			Scoreboard scoreboard = ScoreboardManager.updateScoreboard(this);
			this.scoreboard = scoreboard;
		}
	}
	
	public int getScoreboardID(){
		return this.lastscoreboardid;
	}
	public void setScoreboardID(int lastscoreboardid){
		this.lastscoreboardid = lastscoreboardid;
	}

	public List<String> getScoreboardRows(){
		return this.scoreboardrows;
	}
	public String getRow(int index){
		try{
			String op = this.scoreboardrows.get(index);
			return op;
		}catch(IndexOutOfBoundsException ex){
			return null;
		}
	}
	public void setRows(List<String> scoreboardrows){
		this.scoreboardrows = scoreboardrows;
	}
	public void setRow(int index, String op){
		this.scoreboardrows.set(index, op);
	}
	public void removeRow(String op){
		this.scoreboardrows.remove(op);
	}
	public void addRow(String op){
		this.scoreboardrows.add(op);
	}
	
	public Arena getArena(){
		return this.arena;
	}
	public void setArena(Arena arena){
		this.arena = arena;
	}	
	
	public Kit getKit(){
		return this.kit;
	}
	public void setKit(Kit kit){
		this.kit = kit;
	}
	
	@SuppressWarnings("deprecation")
	public int getTokens(){
		if(StorageManager.usecustomtokens == true){
			return this.tokens;
		}
		else if(StorageManager.usevault == true && Start.economy != null){
			return (int) Start.economy.getBalance(getPlayer().getName());
		}
		else{
			return 0;
		}
	}
	@SuppressWarnings("deprecation")
	public void addTokens(int tokens){
		if(StorageManager.usecustomtokens == true){
			this.tokens = this.tokens +tokens;
			PlayerDataManager.setTokens(getPlayer().getUniqueId(), getTokens());
		}
		else if(StorageManager.usevault == true && Start.economy != null){
			Start.economy.depositPlayer(getPlayer().getName(), tokens);
			this.tokens = (int) Start.economy.getBalance(getPlayer().getName());
		}
		else{}
	}
	@SuppressWarnings("deprecation")
	public void removeTokens(int tokens){
		if(StorageManager.usecustomtokens == true){
			this.tokens = this.tokens -tokens;
			PlayerDataManager.setTokens(getPlayer().getUniqueId(), getTokens());
		}
		else if(StorageManager.usevault == true && Start.economy != null){
			Start.economy.withdrawPlayer(getPlayer().getName(), tokens);
			this.tokens = (int) Start.economy.getBalance(getPlayer().getName());
		}
		else{}
	}
	
	public int getKills(){
		return this.kills;
	}
	public void addKill(){
		this.kills = this.kills +1;
		PlayerDataManager.setKills(getPlayer().getUniqueId(), getKills());
	}
	
	public int getWins(){
		return this.wins;
	}
	public void addWin(){
		this.wins = this.wins +1;
		PlayerDataManager.setWins(getPlayer().getUniqueId(), getWins());
	}
	
	public int getLoses(){
		return this.loses;
	}
	public void addLose(){
		this.loses = this.loses +1;
		PlayerDataManager.setLoses(getPlayer().getUniqueId(), getLoses());
	}

	public int getAnimatedDots(){
		return this.animateddots;
	}
	public String getAnimatedDotsString(){
		return Message.getMessage(MessageName.ANIMATED_DOTS).getMessages().get((getAnimatedDots() -1));
	}
	public String nextAnimatedDots(){
		List<String> messages = Message.getMessage(MessageName.ANIMATED_DOTS).getMessages();
		
		if(this.animateddots >= messages.size()){this.animateddots = 0;}
		this.animateddots = getAnimatedDots() +1;
		return messages.get((getAnimatedDots() -1));
	}
	
	public int getAnimatedRightClick(){
		return this.animtedrightclick;
	}
	public String nextAnimatedRightClick(){
		List<String> messages = Message.getMessage(MessageName.ANIMATED_RIGHT_CLICK).getMessages();
		
		if(this.animtedrightclick >= messages.size()){this.animtedrightclick = 0;}
		this.animtedrightclick = getAnimatedRightClick() +1;
		return messages.get((getAnimatedRightClick() -1));
	}
	
	public List<TNTPrimed> getInstantTNT(){
		return instanttnt;
	}
	public void addInstantTNT(TNTPrimed instanttnt){
		this.instanttnt.add(instanttnt);
	}
	public void removeInstantTNT(TNTPrimed instanttnt){
		this.instanttnt.remove(instanttnt);
	}
	public void setInstantTNT(List<TNTPrimed> instanttnt){
		this.instanttnt = instanttnt;
	}
	
	public List<Egg> getThrownEggs(){
		return throwneggs;
	}
	public void addThrownEgg(Egg throwneggs){
		this.throwneggs.add(throwneggs);
	}
	public void removeThrownEgg(Egg throwneggs){
		this.throwneggs.remove(throwneggs);
	}
	public void setThrownEggs(List<Egg> throwneggs){
		this.throwneggs = throwneggs;
	}

	public int getRoundKills(){
		return roundkills;
	}
	public void setRoundKills(int roundkills){
		this.roundkills = roundkills;
	}

	public void die(){
		if(isPlayer()){
			getPlayer().setGameMode(GameMode.CREATIVE);
			getPlayer().setAllowFlight(true);
			getPlayer().setFlying(true);
			
			getArena().resetScoreboard();
			clearInventory();
			getArena().sendDeathMessage(this, getKilledBy());
			getPlayer().teleport(getArena().getMap().getSpectatorLocation());
			getArena().removePlayer(this);
			getArena().addDiedPlayer(this);
			getArena().addSpectator(this);
			this.spectator = true;
			
			addLose();
			PlayerDataManager.setLoses(getPlayer().getUniqueId(), getLoses());
			if(getKilledBy() != null && getKilledBy() != this){
				getKilledBy().setRoundKills(getRoundKills() +1);
			    getKilledBy().addKill();
			    getKilledBy().addTokens((int) (StorageManager.tokensperkill * getKilledBy().getMultiplier()));
				
				if(StorageManager.usecommandrewards == true){
					for(String command : StorageManager.killcommands){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("&", "§").replace("%player%", getKilledBy().getPlayer().getName()));
					}
				}
			}
			
			getArena().checkGameFinish();
		}
	}
	
	public SpleefPlayer getKilledBy(){
		List<Location> blocklocations = getArena().getBlockLocations();
		int index = 0;
		int closestindex = -1;
		double closest = -1;
		
		if(blocklocations.size() > 0){
			for(Location l : blocklocations){
				double distance = l.distance(getPlayer().getLocation());
				if(!(distance >= 16)){
					if(closest == -1 || closest > distance){
						closestindex = index;
						closest = distance;
					}
				}
				index++;
			}
			
			if(closestindex != -1){
				SpleefPlayer sp = getArena().getPlayerBlocks().get(closestindex);
				if(sp != this){
					return sp;
				}
				else{
					return null;
				}
			}
			return null;
		}
		return null;
	}
	
	public boolean isInArena(){
		if(getArena() == null){
			return false;
		}
		return true;
	}
	
	public boolean isSpectator(){
		return this.spectator;
	}
	public boolean isPlayer(){
		return !this.spectator;
	}
	
	public void teleportToArena(){
		getPlayer().teleport(getArena().getLobby());
	}
	public void teleportToLobby(){
		if(StorageManager.bungeecord == false || StorageManager.ishubserver == true){
			getPlayer().teleport(StorageManager.minigameslobby);
		}
		else{
			teleportToServer(StorageManager.hubserver.toString());
		}
	}
	
	public void teleportToServer(String server){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
 
        try{
            out.writeUTF("Connect");
            out.writeUTF(server);
        }catch(IOException eee){
        	getPlayer().kickPlayer("Kicked");
        }
 
        getPlayer().sendPluginMessage(Start.getInstance(), "BungeeCord", b.toByteArray());
	}
	
	public void clearInventory(){
		getPlayer().getInventory().setHelmet(null);
		getPlayer().getInventory().setChestplate(null);
		getPlayer().getInventory().setLeggings(null);
		getPlayer().getInventory().setBoots(null);
		getPlayer().getInventory().clear();
		getPlayer().setHealth(20D);
		getPlayer().setFoodLevel(20);
		getPlayer().updateInventory();
	}
	
	public void removeItem(ItemStack item, int index){
		final Player p = getPlayer();
		
		if(item.getAmount() != 1){
			ItemStack itemstack = new ItemStack(item.getType(), item.getAmount() -1);
			itemstack.setDurability(item.getDurability());
			itemstack.setItemMeta(item.getItemMeta());
			p.getInventory().setItem(index, itemstack);
		}
		else{
			p.getInventory().setItem(index, null);
		}
		
		new BukkitRunnable(){
			public void run(){
				p.updateInventory();
			}
		}.runTaskLater(Start.getInstance(), 1);
	}
	
	public void joinSpleef(Arena arena){
		getPlayer().setGameMode(GameMode.SURVIVAL);
		getPlayer().setAllowFlight(false);
		getPlayer().setFlying(false);
		
		setCooldowns(new HashMap<KitItemStack, Long>());
		setInstantTNT(new ArrayList<TNTPrimed>());
		setThrownEggs(new ArrayList<Egg>());
		setArena(arena);
		
		if(arena.isStatus(SpleefStatus.WAITING) || arena.isStatus(SpleefStatus.STARTING)){
			getPlayer().teleport(arena.getLobby());
			arena.addPlayer(this);
			
			if(arena.getMinutes() == 0 && arena.getSeconds() <= 10){
				if(getKit() == null){
					setKit(getUnlockedKits().get(0));
				}
			}
			else{
				setKit(null);
			}
			this.spectator = false;
			
			for(SpleefPlayer sp : getArena().getAllPlayers()){
				sp.getPlayer().showPlayer(getPlayer());
				getPlayer().showPlayer(sp.getPlayer());
			}
		}
		else{
			getPlayer().teleport(arena.getMap().getSpectatorLocation());
			arena.addSpectator(this);
			this.spectator = true;
			
			for(SpleefPlayer sp : getArena().getPlayers()){
				sp.getPlayer().hidePlayer(getPlayer());
				getPlayer().showPlayer(sp.getPlayer());
			}
			for(SpleefPlayer sp : getArena().getSpectators()){
				sp.getPlayer().showPlayer(getPlayer());
				getPlayer().showPlayer(sp.getPlayer());
			}
		}
		
		arena.sendJoinMessage(this);
		clearInventory();
		getArena().resetScoreboard();
	}
	
	public void joinSpleef(BungeeArena arena){
		teleportToServer(arena.getServer());
	}
	
	public void quitSpleef(){
		setCooldowns(new HashMap<KitItemStack, Long>());
		clearInventory();
		getArena().resetScoreboard();
		this.spectator = false;
		setRoundKills(0);
		getPlayer().setGameMode(GameMode.SURVIVAL);
		getPlayer().setAllowFlight(false);
		getPlayer().setFlying(false);
		for(SpleefPlayer sp : getArena().getAllPlayers()){
			sp.getPlayer().showPlayer(getPlayer());
			getPlayer().showPlayer(sp.getPlayer());
		}
		if(isPlayer()){
			getArena().removePlayer(this);
			getArena().sendQuitMessage(this);
			if(getArena().isStatus(SpleefStatus.INGAME)){
				getArena().checkGameFinish();
			}
			if(getArena().isStatus(SpleefStatus.STARTING)){
				if(getArena().getPlayers().size() == 1){
					getArena().setStatus(SpleefStatus.WAITING);
					getArena().setMinutes(StorageManager.waittimeminutes);
					getArena().setSeconds(StorageManager.waittimeseconds);
				}
			}
			getArena().updateBungeeArena();
			setArena(null);
			setKit(null);
			teleportToLobby();
		}
		else{
			getArena().removeSpectator(this);
			getArena().removeDiedPlayer(this);
			getArena().sendQuitMessage(this);
			getArena().updateBungeeArena();
			setArena(null);
			setKit(null);
			teleportToLobby();
			
			//Again these methods for spectators that bug.
			getPlayer().setGameMode(GameMode.SURVIVAL);
			getPlayer().setAllowFlight(false);
			getPlayer().setFlying(false);
			for(SpleefPlayer sp : getArena().getAllPlayers()){
				sp.getPlayer().showPlayer(getPlayer());
				getPlayer().showPlayer(sp.getPlayer());
			}
		}
	}
	
	public void openArenaSelector(){
		StorageManager.arenaselector.openInventory(getPlayer());
	}
	
	public void openKitSelector(Kit kit){
		if(isInArena()){
			if(kit != null){
				if(getArena().isStatus(SpleefStatus.WAITING) || getArena().isStatus(SpleefStatus.STARTING)){
					if(!getUnlockedKits().contains(kit)){
						if(getTokens() >= kit.getPrice()){
							StorageManager.kitselector.openInventory(getPlayer(), kit);
						}
						else{
							Message m = Message.getMessage(MessageName.NOT_ENOUGH_TOKENS);
							m.replace("&", "§");
							m.replace("%kit-name%", kit.getName());
							m.replace("%kit-id%", "" + kit.getKitID());
							m.replace("%tokens-needed%", "" + (kit.getPrice() - getTokens()));
							m.replace("%tokens%", "" + getTokens());
							m.replace("%price%", "" + kit.getPrice());
							m.send(getPlayer());
						}
					}
					else{
						Message m = Message.getMessage(MessageName.SELECT_KIT);
						m.replace("&", "§");
						m.replace("%kit-name%", kit.getName());
						m.replace("%kit-id%", "" + kit.getKitID());
						m.send(getPlayer());
						
						setKit(kit);
					}
				}
			}
			else{
				Message m = Message.getMessage(MessageName.UNKNOWN_KIT);
				m.replace("&", "§");
				m.send(getPlayer());
			}
		}
		else{
			Message m = Message.getMessage(MessageName.NOT_IN_ARENA);
			m.replace("&", "§");
			m.send(getPlayer());
		}
	}
	
	public void updateKitInventory(boolean clear){
		if(clear == true){
			clearInventory();
		}
		getKit().give(this);
	}
	
	public String getMultiplierName(){
		String multipliername = "";
		for(String vip : StorageManager.vips){
			if(getPlayer().hasPermission(StorageManager.vippermission.get(vip))){
				multipliername = StorageManager.vipmultipliername.get(vip);
			}
		}
		return multipliername.replace("&", "§");
	}
	
	public double getMultiplier(){
		double multiplier = 1.0;
		for(String vip : StorageManager.vips){
			if(getPlayer().hasPermission(StorageManager.vippermission.get(vip))){
				multiplier = StorageManager.vipmultiplier.get(vip);
			}
		}
		return multiplier;
	}
	
	public SpleefPlayer getNearestPlayer(){
		List<SpleefPlayer> list = getArena().getPlayers();
		
		if(list.size() != 0){
			double distance = 100000;
			SpleefPlayer tracker = null;
			
			for(SpleefPlayer sps : list){
				if(sps != this){
					if(sps.getPlayer().getWorld().getName().equals(getPlayer().getWorld().getName())){
						double dis = sps.getPlayer().getLocation().distance(getPlayer().getLocation());
						if(dis <= distance){
							distance = dis;
							tracker = sps;
						}
					}
				}
			}
			
			return tracker;
		}
		return null;
	}
	
	public int getNearestPlayerDistance(){
		List<SpleefPlayer> list = getArena().getPlayers();
		
		if(list.size() != 0){
			double distance = 100000;
			
			for(SpleefPlayer sps : list){
				if(sps != this){
					if(sps.getPlayer().getWorld().getName().equals(getPlayer().getWorld().getName())){
						double dis = sps.getPlayer().getLocation().distance(getPlayer().getLocation());
						if(dis <= distance){
							distance = dis;
						}
					}
				}
			}
			
			return (int) distance;
		}
		return 0;
	}
	
	public NPC getNearestNPC(){
		NPC closest = null;
		double distance = 100;
		
		for(NPC npc : StorageManager.npcs){
			if(npc.getEntity() != null && npc.getEntity().getWorld().getName().equals(getPlayer().getWorld().getName())){
				double distance2 = npc.getEntity().getLocation().distance(getPlayer().getLocation());
				if(distance2 < 10){
					if(distance2 < distance){
						closest = npc;
						distance = distance2;
					}
				}
			}
		}
		return closest;
	}
	
	public NPC getNearestKitSelector(){
		NPC closest = null;
		double distance = 100;
		
		for(NPC npc : StorageManager.npcs){
			if(npc.getNPCType() == NPCType.KIT_SELECTOR && npc.getEntity().getWorld().getName().equals(getPlayer().getWorld().getName())){
				double distance2 = npc.getEntity().getLocation().distance(getPlayer().getLocation());
				if(distance2 < 10){
					if(distance2 < distance){
						closest = npc;
						distance = distance2;
					}
				}
			}
		}
		return closest;
	}
	
	public NPC getNearestArenaSelector(){
		NPC closest = null;
		double distance = 100;
		
		for(NPC npc : StorageManager.npcs){
			if(npc.getNPCType() == NPCType.ARENA_SELECTOR && npc.getEntity().getWorld().getName().equals(getPlayer().getWorld().getName())){
				double distance2 = npc.getEntity().getLocation().distance(getPlayer().getLocation());
				if(distance2 < 10){
					if(distance2 < distance){
						closest = npc;
						distance = distance2;
					}
				}
			}
		}
		return closest;
	}
}
