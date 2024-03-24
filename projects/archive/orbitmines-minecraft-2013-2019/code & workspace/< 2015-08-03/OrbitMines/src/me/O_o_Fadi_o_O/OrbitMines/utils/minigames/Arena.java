package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.Letters;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPC;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Direction;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.NPCType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class Arena {

	private MiniGameType type;
	private int arenaid;
	private GameState state;
	private Location lobby;
	private Map map;
	private List<OMPlayer> players;
	private List<OMPlayer> deadplayers;
	private List<OMPlayer> spectators;
	private int minutes;
	private int seconds;
	private HashMap<Kit, NPC> npcs;
	private SurvivalGamesData sgdata;
	private UHCData uhcdata;
	private SkywarsData swdata;
	private ChickenFightData cfdata;
	
	public Arena(MiniGameType type, int arenaid, Location lobby){
		this.type = type;
		this.arenaid = arenaid;
		this.state = GameState.WAITING;
		this.lobby = lobby;
		this.players = new ArrayList<OMPlayer>();
		this.deadplayers = new ArrayList<OMPlayer>();
		this.spectators = new ArrayList<OMPlayer>();
		this.minutes = 1;
		this.seconds = 0;
		this.npcs = new HashMap<Kit, NPC>();
	
		switch(type){
			case CHICKEN_FIGHT:
				this.cfdata = new ChickenFightData(this);
				break;
			case GHOST_ATTACK:
				break;
			case SKYWARS:
				this.swdata = new SkywarsData(this);
				break;
			case SPLATCRAFT:
				break;
			case SPLEEF:
				break;
			case SURVIVAL_GAMES:
				this.sgdata = new SurvivalGamesData(this);
				break;
			case ULTRA_HARD_CORE:
				this.uhcdata = new UHCData(this);
				break;
		}
		
		setRandomMap();
	}

	public MiniGameType getType() {
		return type;
	}

	public int getArenaID() {
		return arenaid;
	}

	public Location getLobby() {
		return lobby;
	}

	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setRandomMap(){
		List<Map> maps = ServerData.getMiniGames().getMaps().get(type);
		List<Map> availablemaps = new ArrayList<Map>();
		for(Map map : maps){
			if(!map.isInUse()){
				availablemaps.add(map);
			}
		}
		this.map = availablemaps.get(new Random().nextInt(availablemaps.size()));
		this.map.setInUse(true);
		
		generateWords();
	}

	public GameState getState() {
		return state;
	}
	public void setState(GameState state) {
		this.state = state;
	}

	public List<OMPlayer> getPlayers() {
		return players;
	}
	public void setPlayers(List<OMPlayer> players) {
		this.players = players;
	}

	public List<OMPlayer> getDeadPlayers() {
		return deadplayers;
	}
	public void setDeadPlayers(List<OMPlayer> deadplayers) {
		this.deadplayers = deadplayers;
	}

	public List<OMPlayer> getSpectators() {
		return spectators;
	}
	public void setSpectators(List<OMPlayer> spectators) {
		this.spectators = spectators;
	}
	
	public List<OMPlayer> getAllPlayers(){
		List<OMPlayer> players = new ArrayList<OMPlayer>();
		players.addAll(getPlayers());
		players.addAll(getSpectators());
		
		return players;
	}
	
	public Player[] getAllPlayerEntities(){
		List<OMPlayer> omplayers = getAllPlayers();
		Player[] players = new Player[omplayers.size()];
		
		int index = 0;
		for(OMPlayer omp : omplayers){
			players[index] = omp.getPlayer();
			index++;
		}
		return players;
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
	
	public SurvivalGamesData getSG() {
		return sgdata;
	}
	public void setSG(SurvivalGamesData sgdata) {
		this.sgdata = sgdata;
	}
	
	public UHCData getUHC() {
		return uhcdata;
	}
	public void setUHC(UHCData uhcdata) {
		this.uhcdata = uhcdata;
	}
	
	public SkywarsData getSW() {
		return swdata;
	}
	public void setSW(SkywarsData swdata) {
		this.swdata = swdata;
	}
	
	public ChickenFightData getCF() {
		return cfdata;
	}
	public void setCF(ChickenFightData cfdata) {
		this.cfdata = cfdata;
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
	
	public void sendMessage(String message){
		for(OMPlayer omp : getAllPlayers()){
			omp.getPlayer().sendMessage(message);
		}
	}
	
	public void sendMessage(String[] messages){
		for(OMPlayer omp : getAllPlayers()){
			for(String message : messages){
				omp.getPlayer().sendMessage(message);
			}
		}
	}
	
	public void playSound(Sound sound, float arg2, float arg3){
		for(OMPlayer omp : getAllPlayers()){
			omp.getPlayer().playSound(omp.getPlayer().getLocation(), sound, arg2, arg3);
		}
	}
	
	public void showPlayers(OMPlayer omp){
		for(OMPlayer omplayer : getAllPlayers()){
			omplayer.getPlayer().showPlayer(omp.getPlayer());
			omp.getPlayer().showPlayer(omplayer.getPlayer());
		}
	}
	
	public void clearScoreboards(){
		for(OMPlayer omp : getAllPlayers()){
			omp.getPlayer().getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		}
	}
	
	public boolean isSpectator(OMPlayer omp){
		return this.spectators.contains(omp);
	}
	public boolean isPlayer(OMPlayer omp){
		return this.players.contains(omp);
	}
	
	public void join(final OMPlayer omp){
		final String playername = omp.getPlayer().getName();
		
		omp.setArena(this);
		omp.getPlayer().setFoodLevel(20);
		omp.getPlayer().setHealth(20D);
		omp.clearLevels();
		omp.clearPotionEffects();
		showPlayers(omp);
		omp.getPlayer().getInventory().setHeldItemSlot(0);
		
		if(getState() != GameState.ENDING && getState() != GameState.RESTARTING){
			if(getState() != GameState.WARMUP && getState() != GameState.IN_GAME){
				if(getPlayers().size() != getType().getMaxPlayers()){
					getPlayers().add(omp);
					omp.getPlayer().teleport(getLobby());
					
					sendMessage(" §2» §l§o" + omp.getPlayer().getName() + " §2(§f§l" + getType().getSignName() + " " + getArenaID() + "§2) §a" + getPlayers().size() + "§7/§a" + getType().getMaxPlayers());
					Kit.getKit("Lobby").setItems(omp.getPlayer());

					omp.getPlayer().setAllowFlight(false);
					omp.getPlayer().setFlying(false);
				}
				else{
					omp.toServer(Server.HUB);
					
					new BukkitRunnable(){
						public void run(){
							if(Utils.getPlayer(playername) != null){
								omp.getPlayer().kickPlayer("§7Couldn't connect to the §3§lHub§7.");
							}
						}
					}.runTaskLater(Start.getInstance(), 100);
				}
			}
			else{
				getSpectators().add(omp);
				omp.getPlayer().teleport(getMap().getSpectatorLocation());
				
				sendMessage(" §2» §l§o" + omp.getPlayer().getName() + " §2(§f§l" + getType().getSignName() + " " + getArenaID() + "§2) §e[§lSpectator§e]");
				Kit.getKit("Spectator").setItems(omp.getPlayer());

				((CraftPlayer) omp.getPlayer()).getHandle().setInvisible(true);
				omp.getPlayer().setAllowFlight(true);
				omp.getPlayer().setFlying(true);
			}
		}
		else{
			omp.toServer(Server.HUB);
			
			new BukkitRunnable(){
				public void run(){
					if(Utils.getPlayer(playername) != null){
						omp.getPlayer().kickPlayer("§7Couldn't connect to the §3§lHub§7.");
					}
				}
			}.runTaskLater(Start.getInstance(), 100);
		}
	}
	
	public void leave(final OMPlayer omp){
		final String playername = omp.getPlayer().getName();
		showPlayers(omp);
		
		if(omp.getPlayer() != null && isPlayer(omp)){
			getPlayers().remove(omp);
			sendMessage(" §4« §l§o" + omp.getPlayer().getName() + " §4(§f§l" + getType().getSignName() + " " + getArenaID() + "§4) §c" + getPlayers().size() + "§7/§c" + getType().getMaxPlayers());
			
			switch(getType()){
				case CHICKEN_FIGHT:
				    if(getState() == GameState.IN_GAME || getState() == GameState.WARMUP){
						omp.getPlayer().damage(100D);
						
					    if(getPlayers().size() == 1){
					    	getCF().setSecondPlace(omp);
					    	getCF().ending();
					    }
					    else if(getPlayers().size() == 2){
					    	getCF().setThirdPlace(omp);
					    }
					    else{}
					    
					    omp.getCFPlayer().addLose();
					    
					    if(omp.isDisguised()){
					    	omp.undisguise();
					    }
				    }
				    if(getState() == GameState.IN_GAME || getState() == GameState.ENDING){
					    omp.getCFPlayer().updateHologram();
				    }
				    else{}
					break;
				case GHOST_ATTACK:
					break;
				case SKYWARS:
					if(getState() == GameState.IN_GAME || getState() == GameState.WARMUP){
						if(getState() == GameState.WARMUP){
							for(Block b : omp.getSWPlayer().getCageBlocks()){
								b.setType(Material.AIR);
							}
						}
						
						omp.getPlayer().damage(100D);
						
					    if(getPlayers().size() == 1){
					    	getSW().setSecondPlace(omp);
					    	getSW().ending();
					    }
					    else if(getPlayers().size() == 2){
					    	getSW().setThirdPlace(omp);
					    }
					    else{}
					    
					    omp.getSWPlayer().addLose();
				    }
				    else{}
					break;
				case SPLATCRAFT:
					break;
				case SPLEEF:
					break;
				case SURVIVAL_GAMES:
				    if(getState() == GameState.WAITING || getState() == GameState.STARTING){
				    	if(omp.getSGPlayer().isDoubleLoot()){
				    		omp.getSGPlayer().setDoubleLoot(false);
				    		omp.addTicketAmount(TicketType.DOUBLE_LOOT_PLAYER, 1);
				    	}
				    	if(omp.getSGPlayer().isEnablePotions()){
				    		omp.getSGPlayer().setEnablePotions(false);
				    		omp.addTicketAmount(TicketType.ENABLE_POTIONS_PLAYER, 1);
				    	}
				    }
				    else if(getState() == GameState.IN_GAME || getState() == GameState.WARMUP){
						omp.getPlayer().damage(100D);
						
					    if(getPlayers().size() == 1){
					    	getSG().setSecondPlace(omp);
					    	getSG().ending();
					    }
					    else if(getPlayers().size() == 2){
					    	getSG().setThirdPlace(omp);
					    }
					    else{}
					    
					    omp.getSGPlayer().addLose();
					    
					    if(!getSG().isInDeathMatch() && getMinutes() != 0 && getPlayers().size() != 1 && getPlayers().size() <= 3){
					    	setMinutes(1);
					    	setSeconds(0);
					    	
							playSound(Sound.WITHER_DEATH, 5, 1);
							sendMessage("§c§lDeathmatch starting in §f§l1m 0s§c§l!");
					    }
				    }
				    else{}
					break;
				case ULTRA_HARD_CORE:
				    if(getState() == GameState.WAITING || getState() == GameState.STARTING){
				    	if(omp.getUHCPlayer().isBlueGold()){
				    		omp.getUHCPlayer().setBlueGold(false);
				    		omp.addTicketAmount(TicketType.GOLD_FROM_LAPIS, 1);
				    	}
				    	if(omp.getUHCPlayer().isRedGold()){
				    		omp.getUHCPlayer().setRedGold(false);
				    		omp.addTicketAmount(TicketType.GOLD_FROM_REDSTONE, 1);
				    	}
				    }
					if(getState() == GameState.IN_GAME || getState() == GameState.WARMUP){
						omp.getPlayer().damage(100D);
						
					    if(getPlayers().size() == 1){
					    	getUHC().setSecondPlace(omp);
					    	getUHC().ending();
					    }
					    else if(getPlayers().size() == 2){
					    	getUHC().setThirdPlace(omp);
					    }
					    else{}
					    
					    omp.getUHCPlayer().addLose();
				    }
					break;
			}
		}
		else{
			getSpectators().remove(omp);
			((CraftPlayer) omp.getPlayer()).getHandle().setInvisible(false);
			sendMessage(" §4« §l§o" + omp.getPlayer().getName() + " §4(§f§l" + getType().getSignName() + " " + getArenaID() + "§4) §e[§lSpectator§e]");
			
			switch(getType()){
				case CHICKEN_FIGHT:
					if(getDeadPlayers().contains(omp)){
						omp.getCFPlayer().addLose();
					}
					break;
				case GHOST_ATTACK:
					break;
				case SKYWARS:
					if(getDeadPlayers().contains(omp)){
						omp.getSWPlayer().addLose();
					}
					break;
				case SPLATCRAFT:
					break;
				case SPLEEF:
					break;
				case SURVIVAL_GAMES:
					if(getDeadPlayers().contains(omp)){
						omp.getSGPlayer().addLose();
					}
					break;
				case ULTRA_HARD_CORE:
					if(getDeadPlayers().contains(omp)){
						omp.getUHCPlayer().addLose();
					}
					break;
			}
		}
		
		if(omp.getPlayer().getVehicle() != null){
			omp.getPlayer().leaveVehicle();
		}
		
		if(omp.getPlayer() != null && omp.getArena() != null){
			omp.getPlayer().teleport(omp.getArena().getLobby());
			omp.setArena(null);
			omp.toServer(Server.HUB);
			
			new BukkitRunnable(){
				public void run(){
					if(Utils.getPlayer(playername) != null){
						omp.getPlayer().kickPlayer("§7Couldn't connect to the §3§lHub§7.");
					}
				}
			}.runTaskLater(Start.getInstance(), 100);
		}
	}
	
	public void generateWords(){
		Location l1 = new Location(getLobby().getWorld(), getLobby().getX() -14, getLobby().getY() +9, getLobby().getZ() -30);
		Location l2 = new Location(getLobby().getWorld(), getLobby().getX() -18, getLobby().getY() +3, getLobby().getZ() -30);
		
		//Clear Previous Words\\
		for(Block b : Utils.getBlocksBetween(l1, new Location(getLobby().getWorld(), getLobby().getX() +50, getLobby().getY() +13, getLobby().getZ() -30))){
			if(b.getType() != Material.AIR){
				b.setType(Material.AIR);
			}
		}
		for(Block b : Utils.getBlocksBetween(l2, new Location(getLobby().getWorld(), getLobby().getX() +50, getLobby().getY() +7, getLobby().getZ() -30))){
			if(b.getType() != Material.AIR){
				b.setType(Material.AIR);
			}
		}
		
		new Letters(getType().getName(), Direction.NORTH, l1).generate(Material.STAINED_CLAY, 0);
		new Letters(getMap().getMapName(), Direction.NORTH, l2).generate(Material.STAINED_CLAY, 0);
	}
	
	public void starting(){
		for(OMPlayer omp : getPlayers()){
			if(omp.hasPetEnabled()){
				omp.disablePet();
			}
			if(omp.hasWardrobeEnabled()){
				omp.disableWardrobe();
			}
			if(omp.isDisguised()){
				omp.undisguise();
			}
			if(omp.hasHatEnabled()){
				omp.disableHat();
			}
			omp.disableGadget();
			
			Player p = omp.getPlayer();
			if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null){
				p.closeInventory();
			}
			if(p.getVehicle() != null){
				p.leaveVehicle();
			}
			
			if(getType() == MiniGameType.CHICKEN_FIGHT && omp.getCFPlayer().getKit() == null){
				omp.getCFPlayer().setKit(TicketType.CHICKEN_MAMA_KIT.getKit());
			}
		}
		
		setState(GameState.STARTING);
	}
	
	public void updateWarmup(){
		playSound(Sound.CLICK, 5, 1);
		Color color = null;
		
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, getSeconds());
		ItemMeta meta = item.getItemMeta();
		if(getSeconds() <= 2){
			meta.setDisplayName("§fStarting in §4" + getSeconds() + "§f...");
			item.setItemMeta(meta);
			item.setDurability((short) 14);
			
			color = Color.RED;
		}
		else if(getSeconds() <= 4){
			meta.setDisplayName("§fStarting in §6" + getSeconds() + "§f...");
			item.setItemMeta(meta);
			item.setDurability((short) 1);
			
			color = Color.ORANGE;
		}
		else if(getSeconds() <= 6){
			meta.setDisplayName("§fStarting in §a" + getSeconds() + "§f...");
			item.setItemMeta(meta);
			item.setDurability((short) 13);
			
			color = Color.GREEN;
		}
		else{
			meta.setDisplayName("§fStarting in §2" + getSeconds() + "§f...");
			item.setItemMeta(meta);
			item.setDurability((short) 5);
			
			color = Color.LIME;
		}
		
		ItemStack helmet = Utils.addColor(new ItemStack(Material.LEATHER_HELMET), color);
		ItemStack chestplate = Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), color);
		ItemStack leggings = Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS), color);
		ItemStack boots = Utils.addColor(new ItemStack(Material.LEATHER_BOOTS), color);
		
		for(OMPlayer omp : getPlayers()){
			Player p = omp.getPlayer();
			p.getInventory().setHelmet(helmet);
			p.getInventory().setChestplate(chestplate);
			p.getInventory().setLeggings(leggings);
			p.getInventory().setBoots(boots);
			
			for(int i = 0; i < 9; i++){
				p.getInventory().setItem(i, item);
			}
		}
	}

	public HashMap<Kit, NPC> getNPCs() {
		return npcs;
	}
	public void setNPCs(HashMap<Kit, NPC> npcs) {
		this.npcs = npcs;
	}
	
	public void sendData(){
		if(Bukkit.getOnlinePlayers().size() > 0){
			ByteArrayOutputStream b = new ByteArrayOutputStream();
        	DataOutputStream out = new DataOutputStream(b);
 
        	try{
        		out.writeUTF("Forward");
        		out.writeUTF("ALL");
        		out.writeUTF(getType().getShortName());
            	
            	out.writeUTF(getArenaID() + "|" + getState().toString() + "|" + getPlayers().size() + "|" + getMinutes() + "|" + getSeconds());
        	}catch(IOException ex){
        		ex.printStackTrace();
        	}
        	
        	Player player = null;
        	for(Player p : Bukkit.getOnlinePlayers()){
        		if(player == null){
        			player = p;
        		}
        	}
    		player.sendPluginMessage(Start.getInstance(), "BungeeCord", b.toByteArray());
    	}
	}
	
	public void checkNPCs(){
		Location l = getLobby();
		
		for(NPC npc : this.npcs.values()){
			if(npc.getEntity() == null || npc.getEntity().isDead()){
				switch(getType()){
					case CHICKEN_FIGHT:
						if(npc.getNPCType() == NPCType.CHICKEN_MAMA_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l1 = new Location(l.getWorld(), l.getX() -12, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l1, "§f§lChicken Mama", false);
							npc.setItemInHand(new ItemStack(Material.FEATHER));
						}
						else if(npc.getNPCType() == NPCType.BABY_CHICKEN_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l2 = new Location(l.getWorld(), l.getX() -9, l.getY() +1, l.getZ() -20);
							npc.newEntity(EntityType.ZOMBIE, l2, "§f§lBaby Chicken", false);
							npc.setItemInHand(new ItemStack(Material.EGG));
						}
						else if(npc.getNPCType() == NPCType.HOT_WING_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l3 = new Location(l.getWorld(), l.getX() -3, l.getY() +1, l.getZ() -21);
							npc.newEntity(EntityType.ZOMBIE, l3, "§f§lHot Wing", false);
							npc.setItemInHand(new ItemStack(Material.FIREBALL));
							npc.getEntity().setFireTicks(Integer.MAX_VALUE);
						}
						else if(npc.getNPCType() == NPCType.CHICKEN_WARLORD_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l4 = new Location(l.getWorld(), l.getX() +2, l.getY() +1, l.getZ() -18);
							npc.newEntity(EntityType.ZOMBIE, l4, "§f§lChicken Warlord", false);
							npc.setHelmet(new ItemStack(Material.IRON_HELMET));
							npc.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
							npc.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
							npc.setBoots(new ItemStack(Material.IRON_BOOTS));
							npc.setItemInHand(new ItemStack(Material.IRON_INGOT));
						}
						else if(npc.getNPCType() == NPCType.CHICKEN_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l5 = new Location(l.getWorld(), l.getX() +8, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l5, "§f§l'Chicken'", false);
							npc.setItemInHand(new ItemStack(Material.WOOL));
						}
						else{}
						break;
					case GHOST_ATTACK:
						break;
					case SKYWARS:
						if(npc.getNPCType() == NPCType.TANK_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l1 = new Location(l.getWorld(), l.getX() -12, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l1, "§f§lTank", false);
							npc.setHelmet(new ItemStack(Material.LEATHER_HELMET));
							npc.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
							npc.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
							npc.setBoots(new ItemStack(Material.LEATHER_BOOTS));
						}
						else if(npc.getNPCType() == NPCType.SNOWGOLEM_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l2 = new Location(l.getWorld(), l.getX() -9, l.getY() +1, l.getZ() -20);
							npc.newEntity(EntityType.ZOMBIE, l2, "§f§lSnowGolem", false);
							npc.setItemInHand(new ItemStack(Material.SNOW_BALL));
							npc.setHelmet(new ItemStack(Material.PUMPKIN));
						}
						else if(npc.getNPCType() == NPCType.CREEPER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l3 = new Location(l.getWorld(), l.getX() -3, l.getY() +1, l.getZ() -21);
							npc.newEntity(EntityType.ZOMBIE, l3, "§f§lCreeper", false);
							npc.setItemInHand(new ItemStack(Material.TNT));
						}
						else if(npc.getNPCType() == NPCType.ENCHANTER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l4 = new Location(l.getWorld(), l.getX() +2, l.getY() +1, l.getZ() -18);
							npc.newEntity(EntityType.ZOMBIE, l4, "§f§lEnchanter", false);
							npc.setItemInHand(new ItemStack(Material.ENCHANTMENT_TABLE));
						}
						else if(npc.getNPCType() == NPCType.ENDERMAN_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l5 = new Location(l.getWorld(), l.getX() +8, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l5, "§f§lEnderman", false);
							npc.setItemInHand(new ItemStack(Material.ENDER_PEARL));
						}
						else{}
						break;
					case SPLATCRAFT:
						break;
					case SPLEEF:
						break;
					case SURVIVAL_GAMES:
						if(npc.getNPCType() == NPCType.RUNNER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l1 = new Location(l.getWorld(), l.getX() -12, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l1, "§f§lRunner", false);
							npc.setBoots(new ItemStack(Material.LEATHER_BOOTS));
						}
						else if(npc.getNPCType() == NPCType.FIGHTER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l2 = new Location(l.getWorld(), l.getX() -9, l.getY() +1, l.getZ() -20);
							npc.newEntity(EntityType.ZOMBIE, l2, "§f§lFigher", false);
							npc.setItemInHand(new ItemStack(Material.STONE_AXE));
						}
						else if(npc.getNPCType() == NPCType.ARCHER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l3 = new Location(l.getWorld(), l.getX() -3, l.getY() +1, l.getZ() -21);
							npc.newEntity(EntityType.ZOMBIE, l3, "§f§lArcher", false);
							npc.setItemInHand(new ItemStack(Material.BOW));
						}
						else if(npc.getNPCType() == NPCType.WARRIOR_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l4 = new Location(l.getWorld(), l.getX() +2, l.getY() +1, l.getZ() -18);
							npc.newEntity(EntityType.ZOMBIE, l4, "§f§lWarrior", false);
							npc.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
							npc.setBoots(new ItemStack(Material.IRON_BOOTS));
						}
						else if(npc.getNPCType() == NPCType.BOMBER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l5 = new Location(l.getWorld(), l.getX() +8, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l5, "§f§lBomber", false);
							npc.setItemInHand(new ItemStack(Material.TNT));
						}
						else{}
						break;
					case ULTRA_HARD_CORE:
						if(npc.getNPCType() == NPCType.SURVIVOR_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l1 = new Location(l.getWorld(), l.getX() -12, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l1, "§f§lSurvivor", false);
							npc.setItemInHand(new ItemStack(Material.COOKED_BEEF));
						}
						else if(npc.getNPCType() == NPCType.STARTER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l2 = new Location(l.getWorld(), l.getX() -9, l.getY() +1, l.getZ() -20);
							npc.newEntity(EntityType.ZOMBIE, l2, "§f§lStarter", false);
							npc.setItemInHand(new ItemStack(Material.WOOD_AXE));
						}
						else if(npc.getNPCType() == NPCType.APPLETREE_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l3 = new Location(l.getWorld(), l.getX() -3, l.getY() +1, l.getZ() -21);
							npc.newEntity(EntityType.ZOMBIE, l3, "§f§lAppletree", false);
							npc.setItemInHand(new ItemStack(Material.APPLE));
						}
						else if(npc.getNPCType() == NPCType.SPEEDSTER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l4 = new Location(l.getWorld(), l.getX() +2, l.getY() +1, l.getZ() -18);
							npc.newEntity(EntityType.ZOMBIE, l4, "§f§lSpeedster", false);
							npc.setItemInHand(Utils.setDurability(new ItemStack(Material.POTION), 8194));
						}
						else if(npc.getNPCType() == NPCType.MINER_KIT){
							if(npc.getItem() != null){
								npc.getItem().remove();
							}
							
							Location l5 = new Location(l.getWorld(), l.getX() +8, l.getY() +1, l.getZ() -15);
							npc.newEntity(EntityType.ZOMBIE, l5, "§f§lMiner", false);
							npc.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
						}
						else{}
						break;
				}
			}
		}
	}
	
	public void spawnNPCs(){
		Location l = getLobby();
		Location l1 = new Location(l.getWorld(), l.getX() -12, l.getY() +1, l.getZ() -15);
		Location l2 = new Location(l.getWorld(), l.getX() -9, l.getY() +1, l.getZ() -20);
		Location l3 = new Location(l.getWorld(), l.getX() -3, l.getY() +1, l.getZ() -21);
		Location l4 = new Location(l.getWorld(), l.getX() +2, l.getY() +1, l.getZ() -18);
		Location l5 = new Location(l.getWorld(), l.getX() +8, l.getY() +1, l.getZ() -15);
		
		switch(getType()){
			case CHICKEN_FIGHT:
				{
					NPC npc = NPC.addNPC(NPCType.CHICKEN_MAMA_KIT);
					npc.newEntity(EntityType.ZOMBIE, l1, "§f§lChicken Mama", false);
					npc.setItemInHand(new ItemStack(Material.FEATHER));
					this.npcs.put(TicketType.CHICKEN_MAMA_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.BABY_CHICKEN_KIT);
					npc.newEntity(EntityType.ZOMBIE, l2, "§f§lBaby Chicken", false);
					npc.setItemInHand(new ItemStack(Material.EGG));
					this.npcs.put(TicketType.BABY_CHICKEN_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.HOT_WING_KIT);
					npc.newEntity(EntityType.ZOMBIE, l3, "§f§lHot Wing", false);
					npc.setItemInHand(new ItemStack(Material.FIREBALL));
					npc.getEntity().setFireTicks(Integer.MAX_VALUE);
					this.npcs.put(TicketType.HOT_WING_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.CHICKEN_WARLORD_KIT);
					npc.newEntity(EntityType.ZOMBIE, l4, "§f§lChicken Warlord", false);
					npc.setHelmet(new ItemStack(Material.IRON_HELMET));
					npc.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					npc.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					npc.setBoots(new ItemStack(Material.IRON_BOOTS));
					npc.setItemInHand(new ItemStack(Material.IRON_INGOT));
					this.npcs.put(TicketType.CHICKEN_WARLORD_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.CHICKEN_KIT);
					npc.newEntity(EntityType.ZOMBIE, l5, "§f§l'Chicken'", false);
					npc.setItemInHand(new ItemStack(Material.WOOL));
					this.npcs.put(TicketType.CHICKEN_KIT.getKit(), npc);
				}
				break;
			case GHOST_ATTACK:
				break;
			case SKYWARS:
				{
					NPC npc = NPC.addNPC(NPCType.TANK_KIT);
					npc.newEntity(EntityType.ZOMBIE, l1, "§f§lTank", false);
					npc.setHelmet(new ItemStack(Material.LEATHER_HELMET));
					npc.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
					npc.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
					npc.setBoots(new ItemStack(Material.LEATHER_BOOTS));
					this.npcs.put(TicketType.TANK_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.SNOWGOLEM_KIT);
					npc.newEntity(EntityType.ZOMBIE, l2, "§f§lSnowGolem", false);
					npc.setItemInHand(new ItemStack(Material.SNOW_BALL));
					npc.setHelmet(new ItemStack(Material.PUMPKIN));
					this.npcs.put(TicketType.SNOWGOLEM_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.CREEPER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l3, "§f§lCreeper", false);
					npc.setItemInHand(new ItemStack(Material.TNT));
					this.npcs.put(TicketType.CREEPER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.ENCHANTER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l4, "§f§lEnchanter", false);
					npc.setItemInHand(new ItemStack(Material.ENCHANTMENT_TABLE));
					this.npcs.put(TicketType.ENCHANTER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.ENDERMAN_KIT);
					npc.newEntity(EntityType.ZOMBIE, l5, "§f§lEnderman", false);
					npc.setItemInHand(new ItemStack(Material.ENDER_PEARL));
					this.npcs.put(TicketType.ENDERMAN_KIT.getKit(), npc);
				}
				break;
			case SPLATCRAFT:
				break;
			case SPLEEF:
				break;
			case SURVIVAL_GAMES:
				{
					NPC npc = NPC.addNPC(NPCType.RUNNER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l1, "§f§lRunner", false);
					npc.setBoots(new ItemStack(Material.LEATHER_BOOTS));
					this.npcs.put(TicketType.RUNNER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.FIGHTER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l2, "§f§lFigher", false);
					npc.setItemInHand(new ItemStack(Material.STONE_AXE));
					this.npcs.put(TicketType.FIGHTER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.ARCHER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l3, "§f§lArcher", false);
					npc.setItemInHand(new ItemStack(Material.BOW));
					this.npcs.put(TicketType.ARCHER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.WARRIOR_KIT);
					npc.newEntity(EntityType.ZOMBIE, l4, "§f§lWarrior", false);
					npc.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
					npc.setBoots(new ItemStack(Material.IRON_BOOTS));
					this.npcs.put(TicketType.WARRIOR_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.BOMBER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l5, "§f§lBomber", false);
					npc.setItemInHand(new ItemStack(Material.TNT));
					this.npcs.put(TicketType.BOMBER_KIT.getKit(), npc);
				}
				break;
			case ULTRA_HARD_CORE:
				{
					NPC npc = NPC.addNPC(NPCType.SURVIVOR_KIT);
					npc.newEntity(EntityType.ZOMBIE, l1, "§f§lSurvivor", false);
					npc.setItemInHand(new ItemStack(Material.COOKED_BEEF));
					this.npcs.put(TicketType.SURVIVOR_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.STARTER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l2, "§f§lStarter", false);
					npc.setItemInHand(new ItemStack(Material.WOOD_AXE));
					this.npcs.put(TicketType.STARTER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.APPLETREE_KIT);
					npc.newEntity(EntityType.ZOMBIE, l3, "§f§lAppletree", false);
					npc.setItemInHand(new ItemStack(Material.APPLE));
					this.npcs.put(TicketType.APPLETREE_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.SPEEDSTER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l4, "§f§lSpeedster", false);
					npc.setItemInHand(Utils.setDurability(new ItemStack(Material.POTION), 8194));
					this.npcs.put(TicketType.SPEEDSTER_KIT.getKit(), npc);
				}
				{
					NPC npc = NPC.addNPC(NPCType.MINER_KIT);
					npc.newEntity(EntityType.ZOMBIE, l5, "§f§lMiner", false);
					npc.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
					this.npcs.put(TicketType.MINER_KIT.getKit(), npc);
				}
				break;
		}
	}
	
	public static Arena getArena(MiniGameType type, int arenaid){
		for(Arena arena : ServerData.getMiniGames().getArenas()){
			if(arena.getType() == type && arena.getArenaID() == arenaid){
				return arena;
			}
		}
		return null;
	}
}
