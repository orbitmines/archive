package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class ChickenFightData {

	private Arena arena;
	private OMPlayer firstplace;
	private OMPlayer secondplace;
	private OMPlayer thirdplace;
	private boolean jumpboost;
	private boolean speedboost;
	private HashMap<OMPlayer, List<Block>> chickenblocks;
	
	public ChickenFightData(Arena arena){
		this.arena = arena;
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		this.jumpboost = false;
		this.speedboost = false;
		this.chickenblocks = new HashMap<OMPlayer, List<Block>>();
	}

	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public OMPlayer getFirstPlace() {
		return firstplace;
	}
	public void setFirstPlace(OMPlayer firstplace) {
		this.firstplace = firstplace;
	}

	public OMPlayer getSecondPlace() {
		return secondplace;
	}
	public void setSecondPlace(OMPlayer secondplace) {
		this.secondplace = secondplace;
	}

	public OMPlayer getThirdPlace() {
		return thirdplace;
	}
	public void setThirdPlace(OMPlayer thirdplace) {
		this.thirdplace = thirdplace;
	}

	public boolean isJumpBoost() {
		return jumpboost;
	}
	public void setJumpBoost(boolean jumpboost) {
		this.jumpboost = jumpboost;
	}

	public boolean isSpeedBoost() {
		return speedboost;
	}
	public void setSpeedBoost(boolean speedboost) {
		this.speedboost = speedboost;
	}

	public HashMap<OMPlayer, List<Block>> getChickenBlocks() {
		return chickenblocks;
	}
	public void setChickenBlocks(HashMap<OMPlayer, List<Block>> chickenblocks) {
		this.chickenblocks = chickenblocks;
	}
	@SuppressWarnings("deprecation")
	public void setChickenBlock(final OMPlayer omp){
		final Block b = omp.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN);
		
		if(!b.isEmpty() && !b.isLiquid()){
			if(!getChickenBlocks().containsKey(omp)){
				getChickenBlocks().put(omp, new ArrayList<Block>());
			}
			
			if(!containsChickenBlock(b)){
				getChickenBlocks().get(omp).add(b);

				for(OMPlayer omplayer : getArena().getAllPlayers()){
					omplayer.getPlayer().sendBlockChange(b.getLocation(), Material.WOOL, (byte) 0);
				}
				
				new BukkitRunnable(){
					public void run(){
						if(getChickenBlocks().containsKey(omp) && getChickenBlocks().get(omp).contains(b)){
							getChickenBlocks().get(omp).remove(b);
							
							for(OMPlayer omplayer : getArena().getAllPlayers()){
								omplayer.getPlayer().sendBlockChange(b.getLocation(), b.getType(), b.getData());
							}
						}
					}
				}.runTaskLater(Start.getInstance(), 50);
			}
		}
	}
	public OMPlayer getChickenBlockPlayer(Block b){
		for(OMPlayer omp : getChickenBlocks().keySet()){
			if(getChickenBlocks().get(omp).contains(b)){
				return omp;
			}
		}
		return null;
	}
	private boolean containsChickenBlock(Block b){
		for(OMPlayer omp : getChickenBlocks().keySet()){
			if(getChickenBlocks().get(omp).contains(b)){
				return true;
			}
		}
		return false;
	}
	
	public void restart(){
		arena.setState(GameState.RESTARTING);
		
		Map map = arena.getMap();
		map.setInUse(false);
		map.restoreWorld();
		arena.setRandomMap();
		
		new BukkitRunnable(){
			public void run(){
				waiting();
			}
		}.runTaskLater(Start.getInstance(), 100);
	}
	
	public void ending(){
		if(arena.getPlayers().size() == 1){
			setFirstPlace(arena.getPlayers().get(0));
		}
		else{
			List<OMPlayer> players = new ArrayList<OMPlayer>();
			players.addAll(arena.getPlayers());
			
			if(getFirstPlace() == null){
				OMPlayer omp = getMostKills(players);
				setFirstPlace(omp);
				players.remove(omp);
			}
			if(getSecondPlace() == null){
				OMPlayer omp = getMostKills(players);
				setSecondPlace(omp);
				players.remove(omp);
			}
			if(getThirdPlace() == null){
				OMPlayer omp = getMostKills(players);
				setThirdPlace(omp);
				players.remove(omp);
			}
		}
		
		getFirstPlace().getCFPlayer().setSecondsSurvived(900 - (arena.getMinutes() * 60 + arena.getSeconds()));
		
		arena.setMinutes(0);
		arena.setSeconds(15);
			
		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lChicken Fight §7- §6Results");
		arena.sendMessage("");
		arena.sendMessage(" §61st: " + getFirstPlace().getName());
		arena.sendMessage(" §72nd: " + getSecondPlace().getName());
		arena.sendMessage(" §c3rd: " + getThirdPlace().getName());
		arena.sendMessage("");
		arena.sendMessage("§6§m--------------------------------------------------");
		
		for(OMPlayer omp : arena.getDeadPlayers()){
			omp.getPlayer().sendMessage("§c§l+1 Lose");
			omp.getCFPlayer().addLose();
		}
		
		getFirstPlace().getPlayer().sendMessage("§2§l+1 Win");
		getFirstPlace().getPlayer().sendMessage("§f§l+2 Tickets");
		getFirstPlace().getCFPlayer().addWin();
		getFirstPlace().addMGTickets(2);

		arena.clearScoreboards();
		arena.setState(GameState.ENDING);
	}
	
	public void start(){
		arena.setMinutes(15);
		arena.setSeconds(0);
		
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.getCFPlayer().setRoundKills(0);

			Kit kit = omp.getCFPlayer().getKit();
			if(kit != null){
				TicketType type = TicketType.valueOf(kit.getKitName());
				omp.removeTicket(type);
				
				kit.setItems(omp.getPlayer());
				
				if(kit.getKitName().equals(TicketType.CHICKEN_MAMA_KIT.toString())){
					omp.disguiseAsMob(EntityType.CHICKEN, false, getArena().getAllPlayerEntities());
				}
				else if(kit.getKitName().equals(TicketType.BABY_CHICKEN_KIT.toString())){
					omp.disguiseAsMob(EntityType.CHICKEN, true, getArena().getAllPlayerEntities());
				}
				else if(kit.getKitName().equals(TicketType.HOT_WING_KIT.toString())){
					omp.disguiseAsMob(EntityType.CHICKEN, false, getArena().getAllPlayerEntities());
					omp.getDisguise().getBukkitEntity().setFireTicks(Integer.MAX_VALUE);
				}
				else if(kit.getKitName().equals(TicketType.CHICKEN_WARLORD_KIT.toString())){
					omp.disguiseAsMob(EntityType.IRON_GOLEM, false, getArena().getAllPlayerEntities());
				}
				else if(kit.getKitName().equals(TicketType.CHICKEN_KIT.toString())){
					omp.disguiseAsMob(EntityType.SHEEP, false, getArena().getAllPlayerEntities());
				}
				else{}
				
				if(isJumpBoost()){
					omp.addPotionEffect(PotionEffectType.JUMP, 100000, 4);
				}
				if(isSpeedBoost()){
					omp.addPotionEffect(PotionEffectType.SPEED, 100000, 4);
				}
			}
			
			omp.getCFPlayer().updateHologram();
			omp.updateInventory();
		}

		arena.getMap().getWorld().setTime(20000);
		arena.clearScoreboards();
		arena.setState(GameState.IN_GAME);
	}
	
	public void warmup(){
		arena.setMinutes(0);
		arena.setSeconds(15);
		
		teleportToArena();
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.updateInventory();
			
			for(OMPlayer omplayer : arena.getPlayers()){
				omp.getPlayer().showPlayer(omplayer.getPlayer());
			}
		}
		
		arena.getMap().getWorld().setTime(20000);
		Utils.removeEntities(arena.getMap().getWorld());

		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lChicken Fight §7- §6Info");
		arena.sendMessage("");
		arena.sendMessage(" §a§oKill other opponents and be the last player alive.");
		arena.sendMessage("");
		arena.sendMessage(" §7Map: §6" + arena.getMap().getMapName());	
		arena.sendMessage(" §7Builders: §6" +  arena.getMap().getBuilder());
		arena.sendMessage("§6§m--------------------------------------------------");
		
		arena.clearScoreboards();
		arena.setState(GameState.WARMUP);
	}
	
	public void waiting(){
		arena.setMinutes(1);
		arena.setSeconds(0);
		arena.setPlayers(new ArrayList<OMPlayer>());
		arena.setDeadPlayers(new ArrayList<OMPlayer>());
		arena.setSpectators(new ArrayList<OMPlayer>());
		
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		this.jumpboost = false;
		this.speedboost = false;
		this.chickenblocks = new HashMap<OMPlayer, List<Block>>();
		
		arena.setState(GameState.WAITING);
	}
	
	public void rewardPlayers(){
		for(OMPlayer omp : arena.getAllPlayers()){
			Player p = omp.getPlayer();

			if(arena.isPlayer(omp) || arena.isSpectator(omp) && arena.getDeadPlayers().contains(omp)){
				int amount = 0;
				
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				p.sendMessage("§6§m--------------------------------------------------");
				p.sendMessage(" §f§lChicken Fight §7- §6Rewards");
				p.sendMessage("");
				if(getFirstPlace() == omp){
					p.sendMessage(" §f§l+10 §7(1st Place)");
					amount += 15;
				}
				else if(getSecondPlace() == omp){
					p.sendMessage(" §f§l+5 §7(2nd Place)");
					amount += 8;
				}
				else if(getThirdPlace() == omp){
					p.sendMessage(" §f§l+3 §7(3rd Place)");
					amount += 4;
				}
				else{
					p.sendMessage(" §f§l+2 §7(Patient)");
					amount += 2;
				}
				
				int kills = omp.getCFPlayer().getRoundKills();
				if(kills != 0){
					if(kills == 1){
						p.sendMessage(" §f§l+" + 3 + " §7(1 Kill)");
					}
					else{
						p.sendMessage(" §f§l+" + 3 * kills + " §7(" + kills + " Kills)");
					}
					amount += 3 * kills;
				}
				
				int totalseconds = omp.getCFPlayer().getSecondsSurvived();
				int seconds = totalseconds % 60;
				int minutes = 0;
				int survivereward = (int) totalseconds / 25;
				
				if(totalseconds != seconds){
					minutes = (totalseconds - seconds) / 60;
				}
				
				if(survivereward != 0){
					p.sendMessage(" §f§l+" + survivereward + " §7(Survived " + minutes + "m " + seconds + "s)");
					amount += survivereward;
				}
				
				//TODO Boosters
				
				p.sendMessage(" §7New Balance: §f§l" + (omp.getMiniGameCoins() + amount) + " Coins");
				p.sendMessage("§6§m--------------------------------------------------");
				
				omp.addMiniGameCoins(amount);
			}
		}
	}
	
	public void teleportToArena(){
		Map map = getArena().getMap();
		
		for(OMPlayer omp : arena.getPlayers()){
			List<Location> locations = new ArrayList<Location>();
			for(Location l : map.getSpawns()){
				if(!map.getPlayerSpawns().containsValue(l)){
					locations.add(l);
				}
			}
			Location l = locations.get(new Random().nextInt(locations.size()));
			arena.getMap().getPlayerSpawns().put(omp, l);
			
			omp.getPlayer().teleport(l);
		}
	}
	
	public OMPlayer getMostKills(List<OMPlayer> players){
		int highestkills = 0;
		OMPlayer highest = null;
		
		for(OMPlayer omp : players){
			int kills = omp.getSGPlayer().getRoundKills();
			if(kills >= highestkills);{
				highestkills = kills;
			    highest = omp;
			}
		}
		return highest;
	}
}
