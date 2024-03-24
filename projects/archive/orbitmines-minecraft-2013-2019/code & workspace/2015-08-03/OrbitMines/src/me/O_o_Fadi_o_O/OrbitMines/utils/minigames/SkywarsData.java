package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SkywarsData {

	private Arena arena;
	private List<Chest> lootedchests;
	private List<Block> placedchests;
	private OMPlayer firstplace;
	private OMPlayer secondplace;
	private OMPlayer thirdplace;
	
	public SkywarsData(Arena arena){
		this.arena = arena;
		this.lootedchests = new ArrayList<Chest>();
		this.placedchests = new ArrayList<Block>();
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
	}

	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public List<Chest> getLootedChests() {
		return lootedchests;
	}
	public void setLootedChests(List<Chest> lootedchests) {
		this.lootedchests = lootedchests;
	}

	public List<Block> getPlacedChests() {
		return placedchests;
	}
	public void setPlacedChests(List<Block> placedchests) {
		this.placedchests = placedchests;
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
		arena.setMinutes(0);
		arena.setSeconds(15);
		
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
			
		arena.playSound(Sound.WITHER_DEATH, 5, 1);
		arena.sendMessage("§6§m--------------------------------------------------");
		arena.sendMessage(" §f§lSkywars §7- §6Results");
		arena.sendMessage("");
		arena.sendMessage(" §61st: " + getFirstPlace().getName());
		arena.sendMessage(" §72nd: " + getSecondPlace().getName());
		arena.sendMessage(" §c3rd: " + getThirdPlace().getName());
		arena.sendMessage("");
		arena.sendMessage("§6§m--------------------------------------------------");
		
		for(OMPlayer omp : arena.getDeadPlayers()){
			omp.getPlayer().sendMessage("§c§l+1 Lose");
			omp.getSWPlayer().addLose();
		}
		
		getFirstPlace().getPlayer().sendMessage("§2§l+1 Win");
		getFirstPlace().getPlayer().sendMessage("§f§l+3 Tickets");
		getFirstPlace().getSWPlayer().addWin();
		getFirstPlace().addMGTickets(3);

		arena.clearScoreboards();
		arena.setState(GameState.ENDING);
	}
	
	public void start(){
		arena.setMinutes(15);
		arena.setSeconds(0);
		
		for(OMPlayer omp : arena.getPlayers()){
			omp.clearInventory();
			omp.getSWPlayer().setRoundKills(0);
			TicketType cage = omp.getSWPlayer().getCage();
			
			if(cage == TicketType.CACTUS_CAGE || cage == TicketType.HOT_AIR_BALLOON_CAGE || cage == TicketType.DEATH_CAGE || cage == TicketType.WOODEN_CAGE){
				Block[] blocks = new Block[omp.getSWPlayer().getCageBlocks().size()];
				int index = 1;
				
				for(Block b : omp.getSWPlayer().getCageBlocks()){
					blocks[omp.getSWPlayer().getCageBlocks().size() - index] = b;
					
					index++;
				}
				for(Block b : blocks){
					if(b != null && (b.getType() == Material.CACTUS || b.getType() == Material.LADDER || b.getType() == Material.REDSTONE_TORCH_ON || b.getType() == Material.TORCH)){
						b.setType(Material.AIR);
					}
				}
			}
			for(Block b : omp.getSWPlayer().getCageBlocks()){
				b.setType(Material.AIR);
			}

			Kit kit = omp.getSWPlayer().getKit();
			if(kit != null){
				TicketType type = TicketType.valueOf(kit.getKitName());
				omp.removeTicket(type);
				
				kit.setItems(omp.getPlayer());
			}
			
			omp.updateInventory();
		}

		arena.getMap().getWorld().setTime(0);
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
		arena.sendMessage(" §f§lSkywars §7- §6Info");
		arena.sendMessage("");
		arena.sendMessage(" §a§oGather loot and kill all opponents!");
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
		
		this.lootedchests = new ArrayList<Chest>();
		this.placedchests = new ArrayList<Block>();
		this.firstplace = null;
		this.secondplace = null;
		this.thirdplace = null;
		
		arena.setState(GameState.WAITING);
	}
	
	public void rewardPlayers(){
		for(OMPlayer omp : arena.getAllPlayers()){
			Player p = omp.getPlayer();

			if(arena.isPlayer(omp) || arena.isSpectator(omp) && arena.getDeadPlayers().contains(omp)){
				int amount = 0;
				
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				p.sendMessage("§6§m--------------------------------------------------");
				p.sendMessage(" §f§lSkywars §7- §6Rewards");
				p.sendMessage("");
				if(getFirstPlace() == omp){
					p.sendMessage(" §f§l+15 §7(1st Place)");
					amount += 15;
				}
				else if(getSecondPlace() == omp){
					p.sendMessage(" §f§l+8 §7(2nd Place)");
					amount += 8;
				}
				else if(getThirdPlace() == omp){
					p.sendMessage(" §f§l+4 §7(3rd Place)");
					amount += 4;
				}
				else{
					p.sendMessage(" §f§l+2 §7(Patient)");
					amount += 2;
				}
				
				int kills = omp.getSWPlayer().getRoundKills();
				if(kills != 0){
					if(kills == 1){
						p.sendMessage(" §f§l+" + 3 + " §7(1 Kill)");
					}
					else{
						p.sendMessage(" §f§l+" + 3 * kills + " §7(" + kills + " Kills)");
					}
					amount += 3 * kills;
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
			
			generateCage(omp, l);
			
			omp.getPlayer().teleport(l);
		}
	}
	
	public void randomChest(OMPlayer omp, Chest c){
		c.getInventory().clear();
		int size = c.getInventory().getSize();
		
		List<ChestItem> chestitems = ServerData.getMiniGames().getSWChestItems();
		for(Location l : getArena().getMap().getSWTier2Chests()){
			if(c.getLocation().getBlockX() == l.getBlockX() && c.getLocation().getBlockY() == l.getBlockY() && c.getLocation().getBlockZ() == l.getBlockZ()){
				chestitems = ServerData.getMiniGames().getSWTier2ChestItems();
			}
		}
		
		for(int i = 0; i <= new Random().nextInt(7) +1; i++){
			List<ItemStack> items = new ArrayList<ItemStack>();
			for(ChestItem sgitem : chestitems){
				for(int amount = 0; amount < sgitem.getPercentage(); amount++){
					items.add(sgitem.getItemStack());
				}
			}
			c.getInventory().setItem(new Random().nextInt(size), items.get(new Random().nextInt(items.size())));
		}
		
		c.update();
		getLootedChests().add(c);
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
	
	public void generateCage(OMPlayer omp, Location l){
		TicketType cage = omp.getSWPlayer().getCage();
		Block b = l.getBlock();

		List<Block> blocks = new ArrayList<Block>();
		
		if(cage != null){
			switch(cage){
				case CACTUS_CAGE:
					setBlock(blocks, b.getRelative(0, -1, 0), Material.SANDSTONE, 0);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.STEP, 9);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.STEP, 9);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.STEP, 9);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.STEP, 9);
					
					setBlock(blocks, b.getRelative(1, 0, 0), Material.SAND, 0);
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.SAND, 0);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.SAND, 0);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.SAND, 0);
					setBlock(blocks, b.getRelative(-2, 0, 0), Material.SANDSTONE_STAIRS, 4);
					setBlock(blocks, b.getRelative(2, 0, 0), Material.SANDSTONE_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, 0, -2), Material.SANDSTONE_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, 0, 2), Material.SANDSTONE_STAIRS, 7);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.STEP, 9);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.STEP, 9);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.STEP, 9);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.STEP, 9);

					setBlock(blocks, b.getRelative(1, 1, 0), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(-1, 1, 0), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(-1, 2, 0), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.CACTUS, 0);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.CACTUS, 0);
					
					setBlock(blocks, b.getRelative(1, 4, 0), Material.SAND, 0);
					setBlock(blocks, b.getRelative(-1, 4, 0), Material.SAND, 0);
					setBlock(blocks, b.getRelative(0, 4, 1), Material.SAND, 0);
					setBlock(blocks, b.getRelative(0, 4, -1), Material.SAND, 0);
					setBlock(blocks, b.getRelative(1, 4, 1), Material.STEP, 1);
					setBlock(blocks, b.getRelative(-1, 4, 1), Material.STEP, 1);
					setBlock(blocks, b.getRelative(1, 4, -1), Material.STEP, 1);
					setBlock(blocks, b.getRelative(-1, 4, -1), Material.STEP, 1);
					setBlock(blocks, b.getRelative(-2, 4, 0), Material.SANDSTONE_STAIRS, 0);
					setBlock(blocks, b.getRelative(2, 4, 0), Material.SANDSTONE_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 4, -2), Material.SANDSTONE_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 4, 2), Material.SANDSTONE_STAIRS, 3);
					
					setBlock(blocks, b.getRelative(0, 5, 0), Material.SANDSTONE, 0);
					setBlock(blocks, b.getRelative(1, 5, 0), Material.STEP, 1);
					setBlock(blocks, b.getRelative(-1, 5, 0), Material.STEP, 1);
					setBlock(blocks, b.getRelative(0, 5, 1), Material.STEP, 1);
					setBlock(blocks, b.getRelative(0, 5, -1), Material.STEP, 1);
					break;
				case CAVE_CAGE:
					setBlock(blocks, b.getRelative(-1, -2, 0), Material.SMOOTH_STAIRS, 4);
					setBlock(blocks, b.getRelative(1, -2, 0), Material.SMOOTH_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, -2, -1), Material.SMOOTH_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, -2, 1), Material.SMOOTH_STAIRS, 7);
					setBlock(blocks, b.getRelative(-2, -2, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(2, -2, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, -2, -2), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, -2, 2), Material.SMOOTH_STAIRS, 3);

					setBlock(blocks, b.getRelative(0, -1, 0), Material.DIAMOND_ORE, 0);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.STONE, 0);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.STONE, 0);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.STONE, 0);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.STONE, 0);
					setBlock(blocks, b.getRelative(-2, -1, 0), Material.SMOOTH_STAIRS, 4);
					setBlock(blocks, b.getRelative(2, -1, 0), Material.SMOOTH_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, -1, -2), Material.SMOOTH_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, -1, 2), Material.SMOOTH_STAIRS, 7);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.STEP, 13);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.STEP, 13);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.STEP, 13);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.STEP, 13);
					
					setBlock(blocks, b.getRelative(-2, 0, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(2, 0, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 0, -2), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 0, 2), Material.SMOOTH_STAIRS, 3);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.COBBLE_WALL, 0);
					
					setBlock(blocks, b.getRelative(1, 1, 1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.COBBLE_WALL, 0);
					
					setBlock(blocks, b.getRelative(1, 2, 1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.COBBLE_WALL, 0);
					setBlock(blocks, b.getRelative(-2, 2, 0), Material.SMOOTH_STAIRS, 4);
					setBlock(blocks, b.getRelative(2, 2, 0), Material.SMOOTH_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, 2, -2), Material.SMOOTH_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, 2, 2), Material.SMOOTH_STAIRS, 7);
					
					setBlock(blocks, b.getRelative(-2, 3, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(2, 3, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 3, -2), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 3, 2), Material.SMOOTH_STAIRS, 3);
					setBlock(blocks, b.getRelative(1, 3, 1), Material.STEP, 5);
					setBlock(blocks, b.getRelative(-1, 3, 1), Material.STEP, 5);
					setBlock(blocks, b.getRelative(1, 3, -1), Material.STEP, 5);
					setBlock(blocks, b.getRelative(-1, 3, -1), Material.STEP, 5);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.STONE, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.STONE, 0);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.STONE, 0);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.STONE, 0);

					setBlock(blocks, b.getRelative(0, 4, 0), Material.DIAMOND_ORE, 0);
					setBlock(blocks, b.getRelative(-2, 4, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(2, 4, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(0, 4, -2), Material.SMOOTH_STAIRS, 3);
					setBlock(blocks, b.getRelative(0, 4, 2), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(-1, 4, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 4, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 4, -1), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 4, 1), Material.SMOOTH_STAIRS, 3);

					setBlock(blocks, b.getRelative(0, 5, 0), Material.DIAMOND_ORE, 0);
					setBlock(blocks, b.getRelative(-1, 5, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 5, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 5, -1), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 5, 1), Material.SMOOTH_STAIRS, 3);
					break;
				case DEATH_CAGE:
					setBlock(blocks, b.getRelative(0, -3, 0), Material.NETHER_FENCE, 0);
					
					setBlock(blocks, b.getRelative(0, -2, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, -2, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, -2, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, -2, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, -2, -1), Material.NETHER_FENCE, 0);

					setBlock(blocks, b.getRelative(0, -1, 0), Material.STONE, 6);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.SPRUCE_WOOD_STAIRS, 4);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.SPRUCE_WOOD_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.SPRUCE_WOOD_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.SPRUCE_WOOD_STAIRS, 7);
					
					setBlock(blocks, b.getRelative(1, 0, 1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-2, 0, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-2, 0, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 0, -2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, -2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 0, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 0, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 0, 2), Material.DARK_OAK_FENCE, 0);

					setBlock(blocks, b.getRelative(-1, 1, 0), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(-2, 1, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-2, 1, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 1, -2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, -2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 1, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 1, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, 2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 1, 2), Material.DARK_OAK_FENCE, 0);
					setSkull(blocks, b.getRelative(1, 1, 1), Material.SKULL, SkullType.WITHER, BlockFace.NORTH_WEST);
					setSkull(blocks, b.getRelative(-1, 1, 1), Material.SKULL, SkullType.WITHER, BlockFace.NORTH_EAST);
					setSkull(blocks, b.getRelative(1, 1, -1), Material.SKULL, SkullType.WITHER, BlockFace.SOUTH_WEST);
					setSkull(blocks, b.getRelative(-1, 1, -1), Material.SKULL, SkullType.WITHER, BlockFace.SOUTH_EAST);
					
					setBlock(blocks, b.getRelative(1, 2, 1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(-2, 2, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-2, 2, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, -2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, -2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 2, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 2, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, 2), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, 2), Material.DARK_OAK_FENCE, 0);
					
					setBlock(blocks, b.getRelative(0, 3, 0), Material.STONE, 6);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.LOG, 9);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.LOG, 9);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.LOG, 5);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.LOG, 5);
					setBlock(blocks, b.getRelative(1, 3, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 3, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 3, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 3, -1), Material.DARK_OAK_FENCE, 0);

					setBlock(blocks, b.getRelative(0, 4, 0), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 4, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 4, 1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 4, -1), Material.DARK_OAK_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 4, -1), Material.DARK_OAK_FENCE, 0);
					
					setBlock(blocks, b.getRelative(0, 5, 0), Material.DARK_OAK_FENCE, 0);
					break;
				case ENCHANTER_CAGE:
					setBlock(blocks, b.getRelative(0, -2, 0), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, -2, 0), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(1, -2, 0), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(0, -2, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(0, -2, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(1, -2, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, -2, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(1, -2, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, -2, -1), Material.BARRIER, 0);
					
					setBlock(blocks, b.getRelative(0, -1, 0), Material.ENCHANTMENT_TABLE, 0);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(2, -1, 0), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(2, -1, 1), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-2, -1, 0), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-2, -1, -1), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(0, -1, -2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(1, -1, -2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(0, -1, 2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-1, -1, 2), Material.BOOKSHELF, 0);

					setBlock(blocks, b.getRelative(1, 0, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(2, 0, 0), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(2, 0, 1), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-2, 0, 0), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-2, 0, -1), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(0, 0, -2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(1, 0, -2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(0, 0, 2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-1, 0, 2), Material.BOOKSHELF, 0);

					setBlock(blocks, b.getRelative(1, 1, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.BARRIER, 0);
					setBlock(blocks, b.getRelative(2, 1, 0), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(2, 1, 1), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-2, 1, 0), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-2, 1, -1), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(0, 1, -2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(1, 1, -2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(0, 1, 2), Material.BOOKSHELF, 0);
					setBlock(blocks, b.getRelative(-1, 1, 2), Material.BOOKSHELF, 0);
					break;
				case GRAY_RAINBOW_CAGE:
					for(Block block : Arrays.asList(b.getRelative(0, -1, 0), b.getRelative(1, 0, 0), b.getRelative(-1, 0, 0), b.getRelative(0, 0, 1), b.getRelative(0, 0, -1), b.getRelative(1, 1, 0), b.getRelative(-1, 1, 0), b.getRelative(0, 1, 1), b.getRelative(0, 1, -1), b.getRelative(1, 2, 0), b.getRelative(-1, 2, 0), b.getRelative(0, 2, 1), b.getRelative(0, 2, -1), b.getRelative(1, 3, 0), b.getRelative(-1, 3, 0), b.getRelative(0, 3, 1), b.getRelative(0, 3, -1), b.getRelative(0, 4, 0))){
						setBlock(blocks, block, Material.STAINED_GLASS, Arrays.asList(0, 7, 8, 15).get(new Random().nextInt(4)));
					}
					break;
				case HOT_AIR_BALLOON_CAGE:
					setBlock(blocks, b.getRelative(0, -2, 0), Material.WOOD_STEP, 8);
					
					setBlock(blocks, b.getRelative(0, -1, 0), Material.WOOD_STEP, 0);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.WOOD, 0);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.WOOD, 0);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.WOOD, 0);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.WOOD, 0);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.STEP, 15);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.STEP, 15);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.STEP, 15);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.STEP, 15);

					setBlock(blocks, b.getRelative(1, 0, 0), Material.WOOD, 1);
					setBlock(blocks, b.getRelative(0, 0, 0), Material.LADDER, 4);
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.BIRCH_FENCE, 0);
					
					setBlock(blocks, b.getRelative(1, 1, 0), Material.WOOD, 1);
					setBlock(blocks, b.getRelative(0, 1, 0), Material.LADDER, 4);
					setBlock(blocks, b.getRelative(1, 1, 1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.BIRCH_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.BIRCH_FENCE, 0);

					setBlock(blocks, b.getRelative(1, 2, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 2, 0), Material.LADDER, 4);
					setBlock(blocks, b.getRelative(-1, 2, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 2, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.WOOL, 0);
					
					setBlock(blocks, b.getRelative(-2, 3, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-2, 3, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-2, 3, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 3, -2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 3, -2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 3, -2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(2, 3, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(2, 3, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(2, 3, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 3, 2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 3, 2), Material.WOOL, 5);
					setBlock(blocks, b.getRelative(1, 3, 2), Material.WOOL, 5);
					
					setBlock(blocks, b.getRelative(-2, 4, 0), Material.STAINED_GLASS, 14);
					setBlock(blocks, b.getRelative(-2, 4, -1), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(-2, 4, 1), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(0, 4, -2), Material.STAINED_GLASS, 5);
					setBlock(blocks, b.getRelative(-1, 4, -2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(1, 4, -2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(2, 4, 0), Material.STAINED_GLASS, 5);
					setBlock(blocks, b.getRelative(2, 4, -1), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(2, 4, 1), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(0, 4, 2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(-1, 4, 2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(1, 4, 2), Material.STAINED_GLASS, 0);
					
					setBlock(blocks, b.getRelative(-2, 5, 0), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(-2, 5, -1), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(-2, 5, 1), Material.STAINED_GLASS, 5);
					setBlock(blocks, b.getRelative(0, 5, -2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(-1, 5, -2), Material.STAINED_GLASS, 14);
					setBlock(blocks, b.getRelative(1, 5, -2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(2, 5, 0), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(2, 5, -1), Material.STAINED_GLASS, 14);
					setBlock(blocks, b.getRelative(2, 5, 1), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(0, 5, 2), Material.STAINED_GLASS, 14);
					setBlock(blocks, b.getRelative(-1, 5, 2), Material.STAINED_GLASS, 0);
					setBlock(blocks, b.getRelative(1, 5, 2), Material.STAINED_GLASS, 0);
					
					setBlock(blocks, b.getRelative(-2, 6, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-2, 6, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-2, 6, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 6, -2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 6, -2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 6, -2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(2, 6, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(2, 6, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(2, 6, 1), Material.WOOL, 14);
					setBlock(blocks, b.getRelative(0, 6, 2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 6, 2), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 6, 2), Material.WOOL, 0);

					setBlock(blocks, b.getRelative(0, 7, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 7, 0), Material.WOOL, 5);
					setBlock(blocks, b.getRelative(-1, 7, 0), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 7, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(0, 7, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(1, 7, 1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 7, 1), Material.WOOL, 5);
					setBlock(blocks, b.getRelative(1, 7, -1), Material.WOOL, 0);
					setBlock(blocks, b.getRelative(-1, 7, -1), Material.WOOL, 14);
					break;
				case MESA_CAGE:
					setBlock(blocks, b.getRelative(0, -2, 0), Material.STONE_SLAB2, 8);

					setBlock(blocks, b.getRelative(0, -1, 0), Material.RED_SANDSTONE, 0);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.RED_SANDSTONE_STAIRS, 4);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.RED_SANDSTONE_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.RED_SANDSTONE_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.RED_SANDSTONE_STAIRS, 7);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.STONE_SLAB2, 0);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.STONE_SLAB2, 0);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.STONE_SLAB2, 0);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.STONE_SLAB2, 0);

					setBlock(blocks, b.getRelative(-1, 0, 0), Material.STONE_SLAB2, 8);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.STONE_SLAB2, 8);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.STONE_SLAB2, 8);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.STONE_SLAB2, 8);
					
					setBlock(blocks, b.getRelative(1, 1, 1), Material.STAINED_GLASS, 1);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.STAINED_GLASS, 1);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.STAINED_GLASS, 1);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.STAINED_GLASS, 1);

					setBlock(blocks, b.getRelative(-1, 2, 0), Material.STONE_SLAB2, 0);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.STONE_SLAB2, 0);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.STONE_SLAB2, 0);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.STONE_SLAB2, 0);
					
					setBlock(blocks, b.getRelative(0, 3, 0), Material.RED_SANDSTONE, 0);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.RED_SANDSTONE_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.RED_SANDSTONE_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.RED_SANDSTONE_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.RED_SANDSTONE_STAIRS, 3);
					setBlock(blocks, b.getRelative(1, 3, 1), Material.STONE_SLAB2, 8);
					setBlock(blocks, b.getRelative(-1, 3, 1), Material.STONE_SLAB2, 8);
					setBlock(blocks, b.getRelative(1, 3, -1), Material.STONE_SLAB2, 8);
					setBlock(blocks, b.getRelative(-1, 3, -1), Material.STONE_SLAB2, 8);
					
					setBlock(blocks, b.getRelative(0, 4, 0), Material.STONE_SLAB2, 0);
					break;
				case NETHER_CAGE:
					setBlock(blocks, b.getRelative(-1, -2, 0), Material.STEP, 14);
					setBlock(blocks, b.getRelative(1, -2, 0), Material.STEP, 14);
					setBlock(blocks, b.getRelative(0, -2, -1), Material.STEP, 14);
					setBlock(blocks, b.getRelative(0, -2, 1), Material.STEP, 14);
					
					setBlock(blocks, b.getRelative(0, -1, 0), Material.CAULDRON, 3);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.NETHERRACK, 1);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.NETHERRACK, 1);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.NETHERRACK, 1);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.NETHERRACK, 1);
					setBlock(blocks, b.getRelative(-2, -1, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(2, -1, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(0, -1, -2), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(0, -1, 2), Material.NETHER_BRICK, 0);

					setBlock(blocks, b.getRelative(-1, 0, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.FIRE, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.FIRE, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.FIRE, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.FIRE, 0);
					setBlock(blocks, b.getRelative(-2, 0, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(2, 0, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(0, 0, -2), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(0, 0, 2), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(2, 0, -1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(2, 0, 1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-2, 0, -1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-2, 0, 1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-1, 0, 2), Material.STEP, 6);
					setBlock(blocks, b.getRelative(1, 0, 2), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-1, 0, -2), Material.STEP, 6);
					setBlock(blocks, b.getRelative(1, 0, -2), Material.STEP, 6);
					
					setBlock(blocks, b.getRelative(-1, 1, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, 1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-2, 1, 0), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(2, 1, 0), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(0, 1, -2), Material.REDSTONE_TORCH_ON, 0);
					setBlock(blocks, b.getRelative(0, 1, 2), Material.REDSTONE_TORCH_ON, 0);
					
					setBlock(blocks, b.getRelative(-1, 2, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.NETHER_FENCE, 0);
					
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.NETHER_FENCE, 0);

					setBlock(blocks, b.getRelative(0, 4, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(-1, 4, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(1, 4, 0), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(0, 4, -1), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(0, 4, 1), Material.NETHER_BRICK, 0);
					setBlock(blocks, b.getRelative(1, 4, 1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-1, 4, 1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(1, 4, -1), Material.STEP, 6);
					setBlock(blocks, b.getRelative(-1, 4, -1), Material.STEP, 6);
					
					setBlock(blocks, b.getRelative(0, 5, 0), Material.NETHER_FENCE, 0);
					break;
				case SEA_CAGE:
					setBlock(blocks, b.getRelative(0, -1, 0), Material.SEA_LANTERN, 0);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.PRISMARINE, 1);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.PRISMARINE, 1);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.PRISMARINE, 1);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.PRISMARINE, 1);

					setBlock(blocks, b.getRelative(-1, 0, 0), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.PRISMARINE, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.PRISMARINE, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.PRISMARINE, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.PRISMARINE, 0);

					setBlock(blocks, b.getRelative(-1, 1, 0), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 1, 1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.STAINED_GLASS, 3);

					setBlock(blocks, b.getRelative(-1, 2, 0), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.STAINED_GLASS, 3);
					setBlock(blocks, b.getRelative(1, 2, 1), Material.PRISMARINE, 0);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.PRISMARINE, 0);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.PRISMARINE, 0);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.PRISMARINE, 0);
					
					setBlock(blocks, b.getRelative(0, 3, 0), Material.SEA_LANTERN, 0);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.PRISMARINE, 1);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.PRISMARINE, 1);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.PRISMARINE, 1);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.PRISMARINE, 1);
					break;
				case SLIME_CAGE:
					setBlock(blocks, b.getRelative(0, -1, 0), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.SLIME_BLOCK, 0);

					setBlock(blocks, b.getRelative(-1, 0, 0), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.SLIME_BLOCK, 0);

					setBlock(blocks, b.getRelative(-1, 1, 0), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 1, 1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(-1, 1, 1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 1, -1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(-1, 1, -1), Material.STAINED_GLASS, 13);

					setBlock(blocks, b.getRelative(-1, 2, 0), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.STAINED_GLASS, 13);
					setBlock(blocks, b.getRelative(1, 2, 1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.SLIME_BLOCK, 0);
					
					setBlock(blocks, b.getRelative(0, 3, 0), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.SLIME_BLOCK, 0);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.SLIME_BLOCK, 0);
					break;
				case SUN_CAGE:
					setBlock(blocks, b.getRelative(0, -2, 0), Material.STAINED_GLASS, 1);
					
					setBlock(blocks, b.getRelative(0, -1, 0), Material.STAINED_GLASS, 1);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.STAINED_GLASS, 4);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.STAINED_GLASS, 4);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.STAINED_GLASS, 4);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.STAINED_GLASS, 4);
					
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.STAINED_GLASS_PANE, 14);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.STAINED_GLASS_PANE, 14);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.STAINED_GLASS_PANE, 14);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.STAINED_GLASS_PANE, 14);
					
					setBlock(blocks, b.getRelative(-1, 1, 0), Material.STAINED_GLASS_PANE, 1);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.STAINED_GLASS_PANE, 1);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.STAINED_GLASS_PANE, 1);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.STAINED_GLASS_PANE, 1);
					
					setBlock(blocks, b.getRelative(-1, 2, 0), Material.STAINED_GLASS_PANE, 14);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.STAINED_GLASS_PANE, 14);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.STAINED_GLASS_PANE, 14);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.STAINED_GLASS_PANE, 14);

					setBlock(blocks, b.getRelative(0, 3, 0), Material.STAINED_GLASS, 1);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.STAINED_GLASS, 4);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.STAINED_GLASS, 4);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.STAINED_GLASS, 4);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.STAINED_GLASS, 4);

					setBlock(blocks, b.getRelative(0, 4, 0), Material.STAINED_GLASS, 1);
					break;
				case THE_END_CAGE:
					setBlock(blocks, b.getRelative(-1, -2, 0), Material.OBSIDIAN, 0);
					setBlock(blocks, b.getRelative(1, -2, 0), Material.OBSIDIAN, 0);
					setBlock(blocks, b.getRelative(0, -2, -1), Material.OBSIDIAN, 0);
					setBlock(blocks, b.getRelative(0, -2, 1), Material.OBSIDIAN, 0);
					setBlock(blocks, b.getRelative(1, -2, 1), Material.SMOOTH_STAIRS, 7);
					setBlock(blocks, b.getRelative(-1, -2, 1), Material.SMOOTH_STAIRS, 7);
					setBlock(blocks, b.getRelative(1, -2, -1), Material.SMOOTH_STAIRS, 6);
					setBlock(blocks, b.getRelative(-1, -2, -1), Material.SMOOTH_STAIRS, 6);
					
					setBlock(blocks, b.getRelative(0, -1, 0), Material.ENDER_STONE, 0);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.ENDER_PORTAL_FRAME, 5);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.ENDER_PORTAL_FRAME, 5);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.ENDER_PORTAL_FRAME, 5);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.ENDER_PORTAL_FRAME, 5);
					setBlock(blocks, b.getRelative(1, -1, 1), Material.ENDER_STONE, 0);
					setBlock(blocks, b.getRelative(-1, -1, 1), Material.ENDER_STONE, 0);
					setBlock(blocks, b.getRelative(1, -1, -1), Material.ENDER_STONE, 0);
					setBlock(blocks, b.getRelative(-1, -1, -1), Material.ENDER_STONE, 0);
					
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.NETHER_FENCE, 0);
					
					setBlock(blocks, b.getRelative(-1, 1, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.NETHER_FENCE, 0);
					
					setBlock(blocks, b.getRelative(-1, 2, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.NETHER_FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.NETHER_FENCE, 0);
					
					setBlock(blocks, b.getRelative(0, 3, 0), Material.STONE, 0);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.SMOOTH_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.SMOOTH_STAIRS, 3);
					setBlock(blocks, b.getRelative(1, 3, 1), Material.SMOOTH_STAIRS, 3);
					setBlock(blocks, b.getRelative(-1, 3, 1), Material.SMOOTH_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 3, -1), Material.SMOOTH_STAIRS, 2);
					setBlock(blocks, b.getRelative(-1, 3, -1), Material.SMOOTH_STAIRS, 0);
					break;
				case THE_WOOL_HUT_CAGE:
					setBlock(blocks, b.getRelative(0, -1, 0), Material.WOOL, 11);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.SPRUCE_WOOD_STAIRS, 4);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.SPRUCE_WOOD_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.SPRUCE_WOOD_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.SPRUCE_WOOD_STAIRS, 7);
					
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.WOOL, 4);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.WOOL, 11);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.WOOL, 14);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.WOOL, 4);
					setBlock(blocks, b.getRelative(1, 0, 1), Material.WOOL, 2);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.WOOL, 11);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.WOOL, 3);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.WOOL, 2);
					
					setBlock(blocks, b.getRelative(-2, 1, 0), Material.WOOD_STAIRS, 4);
					setBlock(blocks, b.getRelative(2, 1, 0), Material.WOOD_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, 1, -2), Material.WOOD_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, 1, 2), Material.WOOD_STAIRS, 7);
					setBlock(blocks, b.getRelative(-2, 1, -1), Material.WOOL, 11);
					setBlock(blocks, b.getRelative(-2, 1, 1), Material.WOOL, 4);
					setBlock(blocks, b.getRelative(2, 1, -1), Material.WOOL, 3);
					setBlock(blocks, b.getRelative(2, 1, 1), Material.WOOL, 14);
					setBlock(blocks, b.getRelative(-1, 1, -2), Material.WOOL, 4);
					setBlock(blocks, b.getRelative(1, 1, -2), Material.WOOL, 14);
					setBlock(blocks, b.getRelative(-1, 1, 2), Material.WOOL, 2);
					setBlock(blocks, b.getRelative(1, 1, 2), Material.WOOL, 2);
					
					setBlock(blocks, b.getRelative(-2, 2, 0), Material.IRON_FENCE, 0);
					setBlock(blocks, b.getRelative(2, 2, 0), Material.IRON_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, -2), Material.IRON_FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, 2), Material.IRON_FENCE, 0);
					setBlock(blocks, b.getRelative(-2, 2, -1), Material.SPRUCE_WOOD_STAIRS, 0);
					setBlock(blocks, b.getRelative(-2, 2, 1), Material.SPRUCE_WOOD_STAIRS, 0);
					setBlock(blocks, b.getRelative(2, 2, -1), Material.SPRUCE_WOOD_STAIRS, 1);
					setBlock(blocks, b.getRelative(2, 2, 1), Material.SPRUCE_WOOD_STAIRS, 1);
					setBlock(blocks, b.getRelative(-1, 2, -2), Material.SPRUCE_WOOD_STAIRS, 2);
					setBlock(blocks, b.getRelative(1, 2, -2), Material.SPRUCE_WOOD_STAIRS, 2);
					setBlock(blocks, b.getRelative(-1, 2, 2), Material.SPRUCE_WOOD_STAIRS, 3);
					setBlock(blocks, b.getRelative(1, 2, 2), Material.SPRUCE_WOOD_STAIRS, 3);
					setBlock(blocks, b.getRelative(1, 2, 1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.WOOD_STEP, 13);
					
					setBlock(blocks, b.getRelative(1, 3, 1), Material.WOOL, 11);
					setBlock(blocks, b.getRelative(-1, 3, 1), Material.WOOL, 4);
					setBlock(blocks, b.getRelative(1, 3, -1), Material.WOOL, 3);
					setBlock(blocks, b.getRelative(-1, 3, -1), Material.WOOL, 2);
					
					setBlock(blocks, b.getRelative(1, 4, 1), Material.WOOL, 2);
					setBlock(blocks, b.getRelative(-1, 4, 1), Material.WOOL, 11);
					setBlock(blocks, b.getRelative(1, 4, -1), Material.WOOL, 14);
					setBlock(blocks, b.getRelative(-1, 4, -1), Material.WOOL, 3);
					
					setBlock(blocks, b.getRelative(-2, 4, 0), Material.WOOD_STEP, 8);
					setBlock(blocks, b.getRelative(2, 4, 0), Material.WOOD_STEP, 8);
					setBlock(blocks, b.getRelative(0, 4, -2), Material.WOOD_STEP, 8);
					setBlock(blocks, b.getRelative(0, 4, 2), Material.WOOD_STEP, 8);
					setBlock(blocks, b.getRelative(-2, 4, -1), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(-2, 4, 1), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(2, 4, -1), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(2, 4, 1), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(-1, 4, -2), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(1, 4, -2), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(-1, 4, 2), Material.WOOD_STEP, 9);
					setBlock(blocks, b.getRelative(1, 4, 2), Material.WOOD_STEP, 9);

					setBlock(blocks, b.getRelative(0, 5, 0), Material.WOOD, 0);
					setBlock(blocks, b.getRelative(1, 5, 1), Material.WOOD_STEP, 0);
					setBlock(blocks, b.getRelative(-1, 5, 1), Material.WOOD_STEP, 0);
					setBlock(blocks, b.getRelative(1, 5, -1), Material.WOOD_STEP, 0);
					setBlock(blocks, b.getRelative(-1, 5, -1), Material.WOOD_STEP, 0);
					setBlock(blocks, b.getRelative(-1, 5, 0), Material.SPRUCE_WOOD_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 5, 0), Material.SPRUCE_WOOD_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 5, -1), Material.SPRUCE_WOOD_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 5, 1), Material.SPRUCE_WOOD_STAIRS, 3);
					break;
				case WOODEN_CAGE:
					setBlock(blocks, b.getRelative(0, -1, 0), Material.WOOD, 1);
					setBlock(blocks, b.getRelative(-1, -1, 0), Material.DARK_OAK_STAIRS, 4);
					setBlock(blocks, b.getRelative(1, -1, 0), Material.DARK_OAK_STAIRS, 5);
					setBlock(blocks, b.getRelative(0, -1, -1), Material.DARK_OAK_STAIRS, 6);
					setBlock(blocks, b.getRelative(0, -1, 1), Material.DARK_OAK_STAIRS, 7);

					setBlock(blocks, b.getRelative(1, 0, 1), Material.WOOD_STEP, 5);
					setBlock(blocks, b.getRelative(-1, 0, 1), Material.WOOD_STEP, 5);
					setBlock(blocks, b.getRelative(1, 0, -1), Material.WOOD_STEP, 5);
					setBlock(blocks, b.getRelative(-1, 0, -1), Material.WOOD_STEP, 5);
					setBlock(blocks, b.getRelative(-1, 0, 0), Material.LOG, 1);
					setBlock(blocks, b.getRelative(1, 0, 0), Material.LOG, 1);
					setBlock(blocks, b.getRelative(0, 0, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(0, 0, 1), Material.LOG, 1);
					
					setBlock(blocks, b.getRelative(-1, 1, 0), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(1, 1, 0), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(0, 1, -1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(0, 1, 1), Material.FENCE, 0);

					setBlock(blocks, b.getRelative(1, 2, 1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, 1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, -1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, -1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(-1, 2, 0), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(1, 2, 0), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, -1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(0, 2, 1), Material.FENCE, 0);

					setBlock(blocks, b.getRelative(1, 3, 1), Material.TORCH, 0);
					setBlock(blocks, b.getRelative(-1, 3, 1), Material.TORCH, 0);
					setBlock(blocks, b.getRelative(1, 3, -1), Material.TORCH, 0);
					setBlock(blocks, b.getRelative(-1, 3, -1), Material.TORCH, 0);
					setBlock(blocks, b.getRelative(-1, 3, 0), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(1, 3, 0), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(0, 3, -1), Material.FENCE, 0);
					setBlock(blocks, b.getRelative(0, 3, 1), Material.FENCE, 0);

					setBlock(blocks, b.getRelative(1, 4, 1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(-1, 4, 1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(1, 4, -1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(-1, 4, -1), Material.WOOD_STEP, 13);
					setBlock(blocks, b.getRelative(-1, 4, 0), Material.LOG, 1);
					setBlock(blocks, b.getRelative(1, 4, 0), Material.LOG, 1);
					setBlock(blocks, b.getRelative(0, 4, -1), Material.LOG, 1);
					setBlock(blocks, b.getRelative(0, 4, 1), Material.LOG, 1);
					
					setBlock(blocks, b.getRelative(0, 5, 0), Material.WOOD, 1);
					setBlock(blocks, b.getRelative(-1, 5, 0), Material.DARK_OAK_STAIRS, 0);
					setBlock(blocks, b.getRelative(1, 5, 0), Material.DARK_OAK_STAIRS, 1);
					setBlock(blocks, b.getRelative(0, 5, -1), Material.DARK_OAK_STAIRS, 2);
					setBlock(blocks, b.getRelative(0, 5, 1), Material.DARK_OAK_STAIRS, 3);
					break;
				default:
					break;
			}
		}
		else{
			for(Block block : Arrays.asList(b.getRelative(0, -1, 0), b.getRelative(1, 0, 0), b.getRelative(-1, 0, 0), b.getRelative(0, 0, 1), b.getRelative(0, 0, -1), b.getRelative(1, 1, 0), b.getRelative(-1, 1, 0), b.getRelative(0, 1, 1), b.getRelative(0, 1, -1), b.getRelative(1, 2, 0), b.getRelative(-1, 2, 0), b.getRelative(0, 2, 1), b.getRelative(0, 2, -1), b.getRelative(0, 3, 0))){
				setBlock(blocks, block, Material.GLASS, 0);
			}
		}
		
		omp.getSWPlayer().setCageBlocks(blocks);
	}

	@SuppressWarnings("deprecation")
	private void setBlock(List<Block> blocks, Block b, Material m, int data){
		blocks.add(b);
		b.setType(m);
		b.setData((byte) data);
	}

	@SuppressWarnings("deprecation")
	private void setSkull(List<Block> blocks, Block b, Material m, SkullType type, BlockFace blockface){
		blocks.add(b);
		b.setType(m);
		b.setData((byte) 0x1);
		
		Skull s = (Skull) b.getState();
		s.setSkullType(type);
		s.setRotation(blockface);
		s.update();
	}
}
