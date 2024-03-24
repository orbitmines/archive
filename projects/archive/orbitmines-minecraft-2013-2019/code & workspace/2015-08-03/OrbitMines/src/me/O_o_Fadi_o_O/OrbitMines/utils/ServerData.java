package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Inventories.ServerSelectorInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.InventoryEnum;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.NPCType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Plot;
import me.O_o_Fadi_o_O.OrbitMines.utils.hub.MGArena;
import me.O_o_Fadi_o_O.OrbitMines.utils.hub.MindCraftPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.ActiveBooster;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPMap;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ArmorType;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ItemType;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.KitPvPKit;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ProjectileType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.ChestItem;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.ChickenFightPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.GhostAttackPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Map;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SkywarsPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SplatcraftPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SpleefPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SurvivalGamesPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.UHCPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Lumberjack;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Mine;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.MineBlock;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rank;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Shop;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Challenge;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.Island;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.ItemData;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Inventories.RegionInv;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Region;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.ShopSign;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Warp;
import net.minecraft.server.v1_8_R3.EnumParticle;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class ServerData {
	
	public static int getOnlinePlayers(Server server){
		return ServerStorage.onlineplayers.get(server);
	}
	public static Server getServer(){
		return ServerStorage.server;
	}
	public static boolean isServer(Server... servers){
		Server thisserver = getServer();
		for(Server server : servers){
			if(thisserver == server){
				return true;
			}
		}
		return false;
	}
	public static HubServer getHub(){
		return ServerStorage.hub;
	}
	public static KitPvPServer getKitPvP(){
		return ServerStorage.kitpvp;
	}
	public static CreativeServer getCreative(){
		return ServerStorage.creative;
	}
	public static SurvivalServer getSurvival(){
		return ServerStorage.survival;
	}
	public static SkyBlockServer getSkyBlock(){
		return ServerStorage.skyblock;
	}
	public static PrisonServer getPrison(){
		return ServerStorage.prison;
	}
	public static MiniGamesServer getMiniGames(){
		return ServerStorage.minigames;
	}
	public static World getLobbyWorld(){
		return ServerStorage.lobbyworld;
	}
	public static String getSpawnBuilders(){
		return ServerStorage.spawnbuilders;
	}
	public static HashMap<Cooldown, Long> getPrevCooldowns(UUID uuid){
		if(!ServerStorage.prevcooldowns.containsKey(uuid)){
			return null;
		}
		return ServerStorage.prevcooldowns.get(uuid);
	}
	
	public static class ServerStorage {
		public static Database database;
		
		public static List<OMPlayer> omplayers = new ArrayList<OMPlayer>();
		public static List<KitPvPPlayer> kitpvpplayers = new ArrayList<KitPvPPlayer>();
		public static List<CreativePlayer> creativeplayers = new ArrayList<CreativePlayer>();
		public static List<SurvivalPlayer> survivalplayers = new ArrayList<SurvivalPlayer>();
		public static List<SkyBlockPlayer> skyblockplayers = new ArrayList<SkyBlockPlayer>();
		public static List<PrisonPlayer> prisonplayers = new ArrayList<PrisonPlayer>();
		public static List<MindCraftPlayer> mcplayers = new ArrayList<MindCraftPlayer>();
		public static List<SurvivalGamesPlayer> sgplayers = new ArrayList<SurvivalGamesPlayer>();
		public static List<UHCPlayer> uhcplayers = new ArrayList<UHCPlayer>();
		public static List<SkywarsPlayer> swplayers = new ArrayList<SkywarsPlayer>();
		public static List<ChickenFightPlayer> cfplayers = new ArrayList<ChickenFightPlayer>();
		public static List<GhostAttackPlayer> gaplayers = new ArrayList<GhostAttackPlayer>();
		public static List<SpleefPlayer> spplayers = new ArrayList<SpleefPlayer>();
		public static List<SplatcraftPlayer> scplayers = new ArrayList<SplatcraftPlayer>();
		public static List<Hologram> holograms = new ArrayList<Hologram>();
		public static List<NPC> npcs = new ArrayList<NPC>();
		public static List<NPCArmorStand> asnpcs = new ArrayList<NPCArmorStand>();
		public static List<Kit> kits = new ArrayList<Kit>();
		
		public static HashMap<Player, OMPlayer> players = new HashMap<Player, OMPlayer>();
		public static HashMap<Server, Integer> onlineplayers = new HashMap<Server, Integer>();
		public static HashMap<UUID, HashMap<Cooldown, Long>> prevcooldowns = new HashMap<UUID, HashMap<Cooldown, Long>>();
		
		public static HashMap<InventoryEnum, ItemStack[]> inventorycontents = new HashMap<InventoryEnum, ItemStack[]>();
		
		public static Server server;
		public static String spawnbuilders;
		public static HubServer hub;
		public static KitPvPServer kitpvp;
		public static CreativeServer creative;
		public static SurvivalServer survival;
		public static SkyBlockServer skyblock;
		public static PrisonServer prison;
		public static MiniGamesServer minigames;
		public static World lobbyworld;
		
		public static ServerSelectorInv serverselector;
		
		public static List<StringInt> voters = new ArrayList<StringInt>();
		public static List<String> pendingvoters = new ArrayList<String>();
		 
		public static HashMap<Entity, OMPlayer> swapteleporter = new HashMap<Entity, OMPlayer>();
		public static List<Entity> creeperlaunched = new ArrayList<Entity>();
		public static List<Entity> paintballs = new ArrayList<Entity>();
		public static List<Entity> soccermagmacubes = new ArrayList<Entity>();
		public static List<Entity> eggbombs = new ArrayList<Entity>();
		public static List<Entity> fireballs = new ArrayList<Entity>();
		public static List<Entity> inkbombs = new ArrayList<Entity>();
		public static HashMap<Entity, Integer> inkbombtime = new HashMap<Entity, Integer>();
		public static List<Entity> silverfishbombs = new ArrayList<Entity>();
		public static List<Entity> pets = new ArrayList<Entity>();
		public static List<Entity> snowgolemattackballs = new ArrayList<Entity>();
		public static List<Entity> armorstands = new ArrayList<Entity>();
	}

	public static class HubServer {
		
		private World hubworld;
		private World builderworld;
		private Location spawn;
		private Location mgarea;
		private Location lapisparkour;
		private Location mindcraft;
		private int playercounter;
		private HashMap<Integer, List<Block>> mcblocksforturn;
		private HashMap<Integer, List<Block>> mcblocksforturnstatus;
		private Location mcwinssign;
		private Location mcbestgamesign;
		private Location topvoter1;
		private Location topvoter2;
		private Location topvoter3;
		private Location topvotersign1;
		private Location topvotersign2;
		private Location topvotersign3;
		private Location lastdonatorsign;
		private String lastdonatorstring;
		private HashMap<Server, List<Block>> serverportals;
		private List<Location> waterfalls;
		private ItemStack[] lobbyitems;
		private List<MGArena> mgarenas;
		private HashMap<MiniGameType, Location> mgsigns;
		private Location mglocation;
		
		public HubServer(){
			ServerStorage.server = Server.HUB;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §brienk222\n§b§lMod §bsharewoods\n§b§lMod §beekhoorn2000\n§d§lBuilder §dcasidas\n§4§lOwner §4O_o_Fadi_o_O";
			ServerStorage.hub = this;
			this.hubworld = Bukkit.getWorld("Hub");
			ServerStorage.lobbyworld = this.hubworld;
			this.builderworld = Bukkit.getWorld("BuilderWorld");
			this.spawn = new Location(getHubWorld(), 0.5, 75, 0.5, 90, 0);
			this.mgarea = new Location(getHubWorld(), -48.5, 75, 54.5, 30, 0);
			this.lapisparkour = new Location(getHubWorld(), -36.5, 75, 37.5, 100, 0);
			this.mindcraft = new Location(getHubWorld(), 39.5, 77, 1.5, 0, 0);
			this.playercounter = ConfigManager.config.getInt("PlayerCounter");
			this.topvoter1 = new Location(getHubWorld(), -5, 78, 38);
			this.topvoter2 = new Location(getHubWorld(), -5, 77, 39);
			this.topvoter3 = new Location(getHubWorld(), -5, 76, 37);
			this.topvotersign1 = new Location(getHubWorld(), -6, 77, 38);
			this.topvotersign2 = new Location(getHubWorld(), -6, 76, 39);
			this.topvotersign3 = new Location(getHubWorld(), -6, 75, 37);
			this.lastdonatorsign = new Location(getHubWorld(), -7, 76, 8);
			this.lastdonatorstring = Utils.getName(UUID.fromString(ConfigManager.config.getString("LastDonator")));
			this.mcwinssign = new Location(getHubWorld(), 41, 79, 2);
			this.mcbestgamesign = new Location(getHubWorld(), 37, 79, 2);
			this.mglocation = new Location(getHubWorld(), -54.5, 76, 64.5, -90, 0);
			
			registerLobbyItems();
			registerMindCraft();
			registerServerPortals();
			registerWaterFalls();
			registerMGArenas();
			regiterMGSigns();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n    §7Restarting §3§lHub§7 Server...");
			}
			
			new BukkitRunnable(){
				public void run(){
					Utils.removeAllEntities();
					spawnNPCs();
				}
			}.runTaskLater(Start.getInstance(), 100);
		}

		public World getHubWorld(){
			return hubworld;
		}
		public void setHubWorld(World hubworld){
			this.hubworld = hubworld;
			ServerStorage.lobbyworld = hubworld;
		}

		public World getBuilderWorld(){
			return builderworld;
		}
		public void setBuilderWorld(World builderworld){
			this.builderworld = builderworld;
		}

		public Location getSpawn(){
			return spawn;
		}
		public void setSpawn(Location spawn){
			this.spawn = spawn;
		}

		public Location getMGArea(){
			return mgarea;
		}
		public void setMGArea(Location mgarea){
			this.mgarea = mgarea;
		}

		public Location getLapisParkour(){
			return lapisparkour;
		}
		public void setLapisParkour(Location lapisparkour){
			this.lapisparkour = lapisparkour;
		}

		public Location getMindCraftLocation(){
			return mindcraft;
		}
		public void setMindCraftLocation(Location mindcraft){
			this.mindcraft = mindcraft;
		}

		public int getPlayerCounter(){
			return playercounter;
		}
		public void setPlayerCounter(int playercounter){
			this.playercounter = playercounter;
			
			ConfigManager.config.set("PlayerCounter", playercounter);
			ConfigManager.saveConfig();
		}

		public HashMap<Integer, List<Block>> getMCBlocksForTurn(){
			return mcblocksforturn;
		}
		public void setMCBlocksForTurn(HashMap<Integer, List<Block>> mcblocksforturn){
			this.mcblocksforturn = mcblocksforturn;
		}
		public void addMCBlockForTurn(int turn, List<Block> mcblocksforturn){
			this.mcblocksforturn.put(turn, mcblocksforturn);
		}

		public HashMap<Integer, List<Block>> getMCBlocksForTurnStatus(){
			return mcblocksforturnstatus;
		}
		public void setMCBlocksForTurnStatus(HashMap<Integer, List<Block>> mcblocksforturnstatus){
			this.mcblocksforturnstatus = mcblocksforturnstatus;
		}
		public void addMCBlockForTurnStatus(int turn, List<Block> mcblocksforturnstatus){
			this.mcblocksforturnstatus.put(turn, mcblocksforturnstatus);
		}

		public Location getMCWinsSign(){
			return mcwinssign;
		}
		public void setMCWinsSign(Location mcwinssign){
			this.mcwinssign = mcwinssign;
		}

		public Location getMCBestGameSign(){
			return mcbestgamesign;
		}
		public void setMCBestGameSign(Location mcbestgamesign){
			this.mcbestgamesign = mcbestgamesign;
		}

		public Location getTopVoter1(){
			return topvoter1;
		}
		public void setTopVoter1(Location topvoter1){
			this.topvoter1 = topvoter1;
		}

		public Location getTopVoter2(){
			return topvoter2;
		}
		public void setTopVoter2(Location topvoter2){
			this.topvoter2 = topvoter2;
		}

		public Location getTopVoter3(){
			return topvoter3;
		}
		public void setTopVoter3(Location topvoter3){
			this.topvoter3 = topvoter3;
		}

		public Location getTopVoterSign1(){
			return topvotersign1;
		}
		public void setTopVoterSign1(Location topvotersign1){
			this.topvotersign1 = topvotersign1;
		}

		public Location getTopVoterSign2(){
			return topvotersign2;
		}
		public void setTopVoterSign2(Location topvotersign2){
			this.topvotersign2 = topvotersign2;
		}

		public Location getTopVoterSign3(){
			return topvotersign3;
		}
		public void setTopVoterSign3(Location topvotersign3){
			this.topvotersign3 = topvotersign3;
		}

		public Location getLastDonatorSign(){
			return lastdonatorsign;
		}
		public void setLastDonatorSign(Location lastdonatorsign){
			this.lastdonatorsign = lastdonatorsign;
		}

		public String getLastDonatorString(){
			return lastdonatorstring;
		}
		public void setLastDonatorString(String lastdonatorstring){
			UUID uuid = Utils.getUUID(lastdonatorstring);
			
			if(uuid != null){
				this.lastdonatorstring = lastdonatorstring;
			
				ConfigManager.config.set("LastDonator", Utils.getUUID(lastdonatorstring).toString());
				ConfigManager.saveConfig();
			}
		}

		public HashMap<Server, List<Block>> getServerPortals(){
			return serverportals;
		}
		public void setServerPortals(HashMap<Server, List<Block>> serverportals){
			this.serverportals = serverportals;
		}
		public void setServerPortal(Server server, List<Block> serverportal){
			this.serverportals.put(server, serverportal);
		}

		public List<Location> getWaterfalls(){
			return waterfalls;
		}
		public void setWaterfalls(List<Location> waterfalls){
			this.waterfalls = waterfalls;
		}
		public void addWaterfall(Location waterfall){
			this.waterfalls.add(waterfall);
		}
		
		public ItemStack[] getLobbyItems(){
			return lobbyitems;
		}
		public void setLobbyItems(ItemStack[] lobbyitems){
			this.lobbyitems = lobbyitems;
		}
		public void giveLobbyItems(OMPlayer omplayer){
			Player p = omplayer.getPlayer();
			
			ItemStack gadgetitem = p.getInventory().getItem(5);
			p.getInventory().setContents(getLobbyItems());
			p.getInventory().setItem(5, gadgetitem);
		}

		public List<MGArena> getMGArenas(){
			return mgarenas;
		}
		public void setMGArenas(List<MGArena> mgarenas){
			this.mgarenas = mgarenas;
		}

		public HashMap<MiniGameType, Location> getMGSigns(){
			return mgsigns;
		}
		public void setMGSigns(HashMap<MiniGameType, Location> mgsigns){
			this.mgsigns = mgsigns;
		}
		public void addMGSign(MiniGameType type, Location location){
			this.mgsigns.put(type, location);
		}

		public Location getMGLocation(){
			return mglocation;
		}
		public void setMGLocation(Location mglocation){
			this.mglocation = mglocation;
		}
		
		public void updateWaterfalls(){
			for(Location location : getWaterfalls()){
				RandomFallingBlock b = new RandomFallingBlock(location);
				b.setMaterial(Material.STAINED_GLASS);
				b.setDurability((byte) 11);
				b.setDrop(false);
				b.spawn();
				
				Particle p = new Particle(EnumParticle.WATER_SPLASH, location);
				p.setSize(1, 1, 1);
				p.send(Bukkit.getOnlinePlayers());
			}
		}
		
		private void spawnNPCs(){
			{
				NPC npc = NPC.addNPC(NPCType.LAPIS_PARKOUR);
				npc.newEntity(EntityType.SKELETON, new Location(getHubWorld(), -37.5, 75, 40.5, -130, 0), "§1§lLapis Parkour §8| §b§l250 VIP Points", false);
				npc.setSkeletonType(SkeletonType.WITHER);
				npc.setHelmet(new ItemStack(Material.LAPIS_BLOCK));
				npc.setItemInHand(new ItemStack(Material.DIAMOND));
				npc.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.NAVY));
				npc.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS), Color.NAVY));
				npc.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS), Color.NAVY));
			}
			{
				NPC npc = NPC.addNPC(NPCType.MINDCRAFT);
				npc.newEntity(EntityType.SKELETON, new Location(getHubWorld(), 31.5, 75, 5.5, 140, 0), "§c§lMindCraft §7| §e§lClick to Join", false);
				npc.setSkeletonType(SkeletonType.WITHER);
				npc.setItemInHand(new ItemStack(Material.WOOL));
				npc.setHelmet(Utils.addColor(new ItemStack(Material.LEATHER_HELMET), Color.BLACK));
				npc.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.BLACK));
				npc.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS), Color.BLACK));
				npc.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS), Color.BLACK));
			}
			{
				NPC npc = NPC.addNPC(NPCType.ALPHA);
				npc.newEntity(EntityType.SKELETON, new Location(getHubWorld(), 5.5, 75, 5.5, 135, 0), "§e§lAlpha (Test) Server", false);
				npc.setSkeletonType(SkeletonType.WITHER);
				npc.setItemInHand(new ItemStack(Material.EMPTY_MAP));
				npc.setHelmet(new ItemStack(Material.GOLD_BLOCK));
				npc.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
				npc.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
				npc.setBoots(new ItemStack(Material.GOLD_BOOTS));
			}
			{
				NPC npc = NPC.addNPC(NPCType.MINIGAMES);
				npc.newEntity(EntityType.SNOWMAN, new Location(getHubWorld(), -54.5, 76, 64.5, -90, 0), "§f§lMiniGames", false);
			}
			{
				Hologram h = Hologram.addHologram(new Location(getHubWorld(), -3.5, 76, 0.5, -90, 0));
				h.addLine("§6§lOrbitMines§4§lNetwork §3§l1.8");
				h.addLine("§d§oReport bugs at §6§owww.orbitmines.com§d§o!");
				h.create();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_SELECTOR, new Location(getHubWorld(), -3.5, 75, -3.5, -45, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.setItemName("§3§lServer Selector");
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.TOP_DONATOR, new Location(getHubWorld(), -6.5, 76, 8.5, -140, 0));
				npcas.setCustomName("§7Recent Donator");
				npcas.setCustomNameVisible(true);
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(new ItemStack(Material.SKULL_ITEM, 1));
				npcas.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
				npcas.setItemInHand(new ItemStack(Material.ENDER_CHEST, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getHubWorld(), -4.0, 76, 0.5, -90, 0));
				npcas.setCustomName("§7Welcome to the §6§lOrbitMines§4§lNetwork§7!");
				npcas.setCustomNameVisible(true);
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(-0.2));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0.2));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(new ItemStack(Material.DIAMOND_BLOCK, 1));
				npcas.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
				npcas.setItemInHand(new ItemStack(Material.DIAMOND_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getHubWorld(), -23.5, 77, 8.5, -90, 0));
				npcas.setCustomName("§4§lOwner §4O_o_Fadi_o_O");
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(Utils.getSkull("O_o_Fadi_o_O"));
				npcas.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE, 1), Color.RED));
				npcas.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS, 1), Color.RED));
				npcas.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS, 1), Color.RED));
				npcas.setItemInHand(new ItemStack(Material.REDSTONE_COMPARATOR, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getHubWorld(), -23.5, 77, 7.5, -90, 0));
				npcas.setCustomName("§b§lMob §beekhoorn2000");
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(Utils.getSkull("eekhoorn2000"));
				npcas.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE, 1), Color.AQUA));
				npcas.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS, 1), Color.AQUA));
				npcas.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS, 1), Color.AQUA));
				npcas.setItemInHand(new ItemStack(Material.COMPASS, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getHubWorld(), -23.5, 77, 6.5, -90, 0));
				npcas.setCustomName("§b§lMob §bsharewoods");
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(Utils.getSkull("sharewoods"));
				npcas.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE, 1), Color.AQUA));
				npcas.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS, 1), Color.AQUA));
				npcas.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS, 1), Color.AQUA));
				npcas.setItemInHand(new ItemStack(Material.COMPASS, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getHubWorld(), -23.5, 77, 5.5, -90, 0));
				npcas.setCustomName("§b§lMob §brienk222");
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(Utils.getSkull("rienk222"));
				npcas.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE, 1), Color.AQUA));
				npcas.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS, 1), Color.AQUA));
				npcas.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS, 1), Color.AQUA));
				npcas.setItemInHand(new ItemStack(Material.COMPASS, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getHubWorld(), -23.5, 77, 4.5, -90, 0));
				npcas.setCustomName("§d§lBuilder §dcasidas");
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHelmet(Utils.getSkull("casidas"));
				npcas.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE, 1), Color.FUCHSIA));
				npcas.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS, 1), Color.FUCHSIA));
				npcas.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS, 1), Color.FUCHSIA));
				npcas.setItemInHand(new ItemStack(Material.WOOD_AXE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_INFO_KITPVP, new Location(getHubWorld(), -49.5, 78, 3.5, -90, 0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
				npcas.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
				npcas.setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_INFO_PRISON, new Location(getHubWorld(), -43.5, 78, -33.5, -90, 0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setHelmet(new ItemStack(Material.IRON_HELMET, 1));
				npcas.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.IRON_BOOTS, 1));
				npcas.setItemInHand(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE, 1), Enchantment.DIG_SPEED, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_INFO_CREATIVE, new Location(getHubWorld(), -38.5, 78, -63.5, -90, 0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
				npcas.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
				npcas.setItemInHand(new ItemStack(Material.WOOD_AXE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_INFO_SURVIVAL, new Location(getHubWorld(), 7.5, 78, -65.5, 0, 0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
				npcas.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
				npcas.setItemInHand(new ItemStack(Material.STONE_HOE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_INFO_SKYBLOCK, new Location(getHubWorld(), -9.5, 78, 74.5, -180, 0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
				npcas.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
				npcas.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
				npcas.setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
				npcas.setItemInHand(new ItemStack(Material.FISHING_ROD, 1));
				npcas.spawn();
			}
		}
		
		private void registerLobbyItems(){
			ItemStack[] lobbyitems = new ItemStack[36];
			{
				ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
				BookMeta itemmeta = (BookMeta) item.getItemMeta();
				itemmeta.setDisplayName("§4§nServer Rules");
				itemmeta.addPage("1");
				itemmeta.setPage(1, "   §6§lOrbitMines§4§lRules" + "\n" + "§0§m-------------------" + "\n" + "§4DO NOT§0 Advertise!" + "\n" + "§0Watch your Language!" + "\n" + "Listen to Staff!" + "\n" + "§4DO NOT§0 Abuse Bugs!" + "\n" + "§4DO NOT§0 Hack!" + "\n" + "§4DO NOT§0 Spam!" + "\n" + "§4DO NOT§0 Bully Players!" + "\n" + "§0\n" + "§0§lHave Fun!");
				itemmeta.setAuthor("§6§lOrbitMines §4§lNetwork");
				item.setItemMeta(itemmeta);
				lobbyitems[0] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§d§nAchievements");
				item.setItemMeta(itemmeta);
				lobbyitems[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c§nSettings");
				item.setItemMeta(itemmeta);
				lobbyitems[3] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§3§nServer Selector");
				item.setItemMeta(itemmeta);
				lobbyitems[4] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				lobbyitems[7] = item;
			}
			{
				ItemStack item = new ItemStack(Material.FEATHER, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§f§nFly");
				item.setItemMeta(itemmeta);
				lobbyitems[8] = item;
			}
			this.lobbyitems = lobbyitems;
		}
		
		private void registerMindCraft(){
			World w = getHubWorld();
			
			HashMap<Integer, List<Block>> blocksforturns = new HashMap<Integer, List<Block>>();
			blocksforturns.put(0, Arrays.asList(w.getBlockAt(new Location(w, 42, 75, 5)), w.getBlockAt(new Location(w, 40, 75, 5)), w.getBlockAt(new Location(w, 38, 75, 5)), w.getBlockAt(new Location(w, 36, 75, 5))));
			blocksforturns.put(1, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 8)), w.getBlockAt(new Location(w, 40, 74, 8)), w.getBlockAt(new Location(w, 38, 74, 8)), w.getBlockAt(new Location(w, 36, 74, 8))));
			blocksforturns.put(2, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 10)), w.getBlockAt(new Location(w, 40, 74, 10)), w.getBlockAt(new Location(w, 38, 74, 10)), w.getBlockAt(new Location(w, 36, 74, 10))));
			blocksforturns.put(3, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 12)), w.getBlockAt(new Location(w, 40, 74, 12)), w.getBlockAt(new Location(w, 38, 74, 12)), w.getBlockAt(new Location(w, 36, 74, 12))));
			blocksforturns.put(4, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 14)), w.getBlockAt(new Location(w, 40, 74, 14)), w.getBlockAt(new Location(w, 38, 74, 14)), w.getBlockAt(new Location(w, 36, 74, 14))));
			blocksforturns.put(5, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 16)), w.getBlockAt(new Location(w, 40, 74, 16)), w.getBlockAt(new Location(w, 38, 74, 16)), w.getBlockAt(new Location(w, 36, 74, 16))));
			blocksforturns.put(6, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 18)), w.getBlockAt(new Location(w, 40, 74, 18)), w.getBlockAt(new Location(w, 38, 74, 18)), w.getBlockAt(new Location(w, 36, 74, 18))));
			blocksforturns.put(7, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 20)), w.getBlockAt(new Location(w, 40, 74, 20)), w.getBlockAt(new Location(w, 38, 74, 20)), w.getBlockAt(new Location(w, 36, 74, 20))));
			blocksforturns.put(8, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 22)), w.getBlockAt(new Location(w, 40, 74, 22)), w.getBlockAt(new Location(w, 38, 74, 22)), w.getBlockAt(new Location(w, 36, 74, 22))));
			blocksforturns.put(9, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 24)), w.getBlockAt(new Location(w, 40, 74, 24)), w.getBlockAt(new Location(w, 38, 74, 24)), w.getBlockAt(new Location(w, 36, 74, 24))));
			blocksforturns.put(10, Arrays.asList(w.getBlockAt(new Location(w, 42, 74, 26)), w.getBlockAt(new Location(w, 40, 74, 26)), w.getBlockAt(new Location(w, 38, 74, 26)), w.getBlockAt(new Location(w, 36, 74, 26))));
			blocksforturns.put(11, Arrays.asList(w.getBlockAt(new Location(w, 42, 76, 29)), w.getBlockAt(new Location(w, 40, 76, 29)), w.getBlockAt(new Location(w, 38, 76, 29)), w.getBlockAt(new Location(w, 36, 76, 29))));
			
			setMCBlocksForTurn(blocksforturns);
			
			HashMap<Integer, List<Block>> statusforturns = new HashMap<Integer, List<Block>>();
			statusforturns.put(1, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 8)), w.getBlockAt(new Location(w, 32, 77, 8)), w.getBlockAt(new Location(w, 32, 78, 8)), w.getBlockAt(new Location(w, 32, 79, 8))));
			statusforturns.put(2, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 10)), w.getBlockAt(new Location(w, 32, 77, 10)), w.getBlockAt(new Location(w, 32, 78, 10)), w.getBlockAt(new Location(w, 32, 79, 10))));
			statusforturns.put(3, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 12)), w.getBlockAt(new Location(w, 32, 77, 12)), w.getBlockAt(new Location(w, 32, 78, 12)), w.getBlockAt(new Location(w, 32, 79, 12))));
			statusforturns.put(4, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 14)), w.getBlockAt(new Location(w, 32, 77, 14)), w.getBlockAt(new Location(w, 32, 78, 14)), w.getBlockAt(new Location(w, 32, 79, 14))));
			statusforturns.put(5, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 16)), w.getBlockAt(new Location(w, 32, 77, 16)), w.getBlockAt(new Location(w, 32, 78, 16)), w.getBlockAt(new Location(w, 32, 79, 16))));
			statusforturns.put(6, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 18)), w.getBlockAt(new Location(w, 32, 77, 18)), w.getBlockAt(new Location(w, 32, 78, 18)), w.getBlockAt(new Location(w, 32, 79, 18))));
			statusforturns.put(7, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 20)), w.getBlockAt(new Location(w, 32, 77, 20)), w.getBlockAt(new Location(w, 32, 78, 20)), w.getBlockAt(new Location(w, 32, 79, 20))));
			statusforturns.put(8, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 22)), w.getBlockAt(new Location(w, 32, 77, 22)), w.getBlockAt(new Location(w, 32, 78, 22)), w.getBlockAt(new Location(w, 32, 79, 22))));
			statusforturns.put(9, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 24)), w.getBlockAt(new Location(w, 32, 77, 24)), w.getBlockAt(new Location(w, 32, 78, 24)), w.getBlockAt(new Location(w, 32, 79, 24))));
			statusforturns.put(10, Arrays.asList(w.getBlockAt(new Location(w, 32, 76, 26)), w.getBlockAt(new Location(w, 32, 77, 26)), w.getBlockAt(new Location(w, 32, 78, 26)), w.getBlockAt(new Location(w, 32, 79, 26))));
			
			setMCBlocksForTurnStatus(statusforturns);
		}
		
		private void registerServerPortals(){
			this.serverportals = new HashMap<Server, List<Block>>();
			setServerPortal(Server.KITPVP, Utils.getBlocksBetween(new Location(getHubWorld(), -52, 75, 6), new Location(getHubWorld(), -52, 87, 0)));
			setServerPortal(Server.PRISON, Utils.getBlocksBetween(new Location(getHubWorld(), -46, 87, -37), new Location(getHubWorld(), -46, 75, -31)));
			setServerPortal(Server.CREATIVE, Utils.getBlocksBetween(new Location(getHubWorld(), -41, 75, -61), new Location(getHubWorld(), -41, 87, -67)));
			setServerPortal(Server.SURVIVAL, Utils.getBlocksBetween(new Location(getHubWorld(), 4, 75, -68), new Location(getHubWorld(), 10, 87, -68)));
			setServerPortal(Server.SKYBLOCK, Utils.getBlocksBetween(new Location(getHubWorld(), -7, 75, 76), new Location(getHubWorld(), -13, 86, 76)));
		}
		
		private void registerWaterFalls(){
			this.waterfalls = new ArrayList<Location>();
			addWaterfall(new Location(getHubWorld(), -16.5, 74.25, 56.5));
			addWaterfall(new Location(getHubWorld(), 40.5, 81.25, -64.5));
		}
		
		private void registerMGArenas(){
			this.mgarenas = new ArrayList<MGArena>();
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 1, GameState.WAITING, new Location(getHubWorld(), -52, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 2, GameState.WAITING, new Location(getHubWorld(), -53, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 3, GameState.WAITING, new Location(getHubWorld(), -54, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 4, new Location(getHubWorld(), -52, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 5, new Location(getHubWorld(), -53, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 6, new Location(getHubWorld(), -54, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 7, new Location(getHubWorld(), -52, 75, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 8, new Location(getHubWorld(), -53, 75, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SURVIVAL_GAMES, 9, new Location(getHubWorld(), -54, 75, 74)));
			
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 1, GameState.WAITING, new Location(getHubWorld(), -55, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 2, new Location(getHubWorld(), -56, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 3, new Location(getHubWorld(), -57, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 4, new Location(getHubWorld(), -55, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 5, new Location(getHubWorld(), -56, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 6, new Location(getHubWorld(), -57, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 7, new Location(getHubWorld(), -55, 75, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 8, new Location(getHubWorld(), -56, 75, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.ULTRA_HARD_CORE, 9, new Location(getHubWorld(), -57, 75, 74)));

			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 1, GameState.WAITING, new Location(getHubWorld(), -58, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 2, GameState.WAITING, new Location(getHubWorld(), -59, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 3, GameState.WAITING, new Location(getHubWorld(), -60, 77, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 4, new Location(getHubWorld(), -58, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 5, new Location(getHubWorld(), -59, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 6, new Location(getHubWorld(), -60, 76, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 7, new Location(getHubWorld(), -58, 75, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 8, new Location(getHubWorld(), -59, 75, 74)));
			this.mgarenas.add(new MGArena(MiniGameType.SKYWARS, 9, new Location(getHubWorld(), -60, 75, 74)));

			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 1, GameState.WAITING, new Location(getHubWorld(), -66, 77, 66)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 2, GameState.WAITING, new Location(getHubWorld(), -66, 77, 65)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 3, GameState.WAITING, new Location(getHubWorld(), -66, 77, 64)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 4, new Location(getHubWorld(), -66, 76, 66)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 5, new Location(getHubWorld(), -66, 76, 65)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 6, new Location(getHubWorld(), -66, 76, 64)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 7, new Location(getHubWorld(), -66, 75, 66)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 8, new Location(getHubWorld(), -66, 75, 65)));
			this.mgarenas.add(new MGArena(MiniGameType.CHICKEN_FIGHT, 9, new Location(getHubWorld(), -66, 75, 64)));

			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 1, new Location(getHubWorld(), -66, 77, 63)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 2, new Location(getHubWorld(), -66, 77, 62)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 3, new Location(getHubWorld(), -66, 77, 61)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 4, new Location(getHubWorld(), -66, 76, 63)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 5, new Location(getHubWorld(), -66, 76, 62)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 6, new Location(getHubWorld(), -66, 76, 61)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 7, new Location(getHubWorld(), -66, 75, 63)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 8, new Location(getHubWorld(), -66, 75, 62)));
			this.mgarenas.add(new MGArena(MiniGameType.GHOST_ATTACK, 9, new Location(getHubWorld(), -66, 75, 61)));
			
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 1, new Location(getHubWorld(), -66, 77, 60)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 2, new Location(getHubWorld(), -66, 77, 59)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 3, new Location(getHubWorld(), -66, 77, 58)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 4, new Location(getHubWorld(), -66, 76, 60)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 5, new Location(getHubWorld(), -66, 76, 59)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 6, new Location(getHubWorld(), -66, 76, 58)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 7, new Location(getHubWorld(), -66, 75, 60)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 8, new Location(getHubWorld(), -66, 75, 59)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLEEF, 9, new Location(getHubWorld(), -66, 75, 58)));
			
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 1, new Location(getHubWorld(), -61, 77, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 2, new Location(getHubWorld(), -60, 77, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 3, new Location(getHubWorld(), -59, 77, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 4, new Location(getHubWorld(), -61, 76, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 5, new Location(getHubWorld(), -60, 76, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 6, new Location(getHubWorld(), -59, 76, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 7, new Location(getHubWorld(), -61, 75, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 8, new Location(getHubWorld(), -60, 75, 52)));
			this.mgarenas.add(new MGArena(MiniGameType.SPLATCRAFT, 9, new Location(getHubWorld(), -59, 75, 52)));
		}
		
		private void regiterMGSigns(){
			this.mgsigns = new HashMap<MiniGameType, Location>();
			addMGSign(MiniGameType.SURVIVAL_GAMES, new Location(getHubWorld(), -53, 78, 74));
			addMGSign(MiniGameType.ULTRA_HARD_CORE, new Location(getHubWorld(), -56, 78, 74));
			addMGSign(MiniGameType.SKYWARS, new Location(getHubWorld(), -59, 78, 74));
			addMGSign(MiniGameType.CHICKEN_FIGHT, new Location(getHubWorld(), -66, 78, 65));
			addMGSign(MiniGameType.GHOST_ATTACK, new Location(getHubWorld(), -66, 78, 62));
			addMGSign(MiniGameType.SPLEEF, new Location(getHubWorld(), -66, 78, 59));
			addMGSign(MiniGameType.SPLATCRAFT, new Location(getHubWorld(), -60, 78, 52));
		}
	}
	
	public static class KitPvPServer {
		
		private boolean freekitenabled;
		private World kitpvpworld;
		private World arenaworld;
		private Location spawn;
		private List<KitPvPMap> maps;
		private KitPvPMap currentmap;
		private HashMap<Projectile, ProjectileType> projectiles;
		private ActiveBooster booster;
		private HashMap<Block, Integer> paintballblocks = new HashMap<Block, Integer>();
		private HashMap<Block, Player> paintballblockplayers = new HashMap<Block, Player>();
		private ItemStack[] lobbyitems;
		private ItemStack[] spectatoritems;
		
		public KitPvPServer(){
			ServerStorage.server = Server.KITPVP;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §brienk222";
			ServerStorage.kitpvp = this;
			this.kitpvpworld = Bukkit.getWorld("KitPvPLobby");
			ServerStorage.lobbyworld = this.kitpvpworld;
			this.arenaworld = Bukkit.getWorld("KitPvPArenas");
			this.spawn = new Location(getKitPvPWorld(), -0.5, 74, -0.5, 90, 0);
			this.projectiles = new HashMap<Projectile, ProjectileType>();
			
			registerLobbyItems();
			registerSpectatorItems();
			registerMaps();
			registerKits();
			setRandomMap();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n    §7Restarting §c§lKitPvP§7 Server...");
			}
			
			new BukkitRunnable(){
				public void run(){
					Utils.removeAllEntities();
					spawnNPCs();
				}
			}.runTaskLater(Start.getInstance(), 100);
		}

		public boolean isFreeKitEnabled(){
			return freekitenabled;
		}
		public void setFreeKitEnabled(boolean freekitenabled){
			this.freekitenabled = freekitenabled;
		}
		
		public World getKitPvPWorld(){
			return kitpvpworld;
		}
		public void setKitPvPWorld(World kitpvpworld){
			this.kitpvpworld = kitpvpworld;
		}
		
		public World getArenaWorld(){
			return arenaworld;
		}
		public void setArenaWorld(World arenaworld){
			this.arenaworld = arenaworld;
		}

		public Location getSpawn(){
			return spawn;
		}
		public void setSpawn(Location spawn){
			this.spawn = spawn;
		}
		
		public List<KitPvPMap> getMaps(){
			return maps;
		}
		public void setMaps(List<KitPvPMap> maps){
			this.maps = maps;
		}
		
		public KitPvPMap getCurrentMap(){
			return currentmap;
		}
		public void setCurrentMap(KitPvPMap currentmap){
			this.currentmap = currentmap;
		}
		public void setRandomMap(){
			this.currentmap = maps.get(new Random().nextInt(maps.size()));
			this.currentmap.resetTimer();
		}
		public void setNextMap(){
			List<KitPvPMap> maps = Utils.asNewMapList(this.maps);
			if(this.currentmap != null){
				maps.remove(this.currentmap);
			}
			this.currentmap = maps.get(new Random().nextInt(maps.size()));
			this.currentmap.resetTimer();
		}
		
		public HashMap<Projectile, ProjectileType> getProjectiles(){
			return projectiles;
		}
		public void setProjectiles(HashMap<Projectile, ProjectileType> projectiles){
			this.projectiles = projectiles;
		}
		public boolean isProjectile(Projectile projectile){
			return projectiles.containsKey(projectile);
		}
		public ProjectileType getProjectileType(Projectile projectile){
			return this.projectiles.get(projectile);
		}
		public void addProjectile(Projectile projectile, ProjectileType type){
			this.projectiles.put(projectile, type);
		}
		public void removeProjectile(Projectile projectile){
			this.projectiles.remove(projectile);
		}
		
		public ActiveBooster getBooster(){
			return booster;
		}
		public void setBooster(ActiveBooster booster){
			this.booster = booster;
		}
		public boolean hasBooster(){
			return booster != null;
		}
		
		public HashMap<Block, Integer> getPaintballBlocks(){
			return paintballblocks;
		}
		public void setPaintballBlocks(HashMap<Block, Integer> paintballblocks){
			this.paintballblocks = paintballblocks;
		}
		
		public HashMap<Block, Player> getPaintballBlockPlayers(){
			return paintballblockplayers;
		}
		public void setPaintballBlockPlayers(HashMap<Block, Player> paintballblockplayers){
			this.paintballblockplayers = paintballblockplayers;
		}

		public ItemStack[] getLobbyItems(){
			return lobbyitems;
		}
		public void setLobbyItems(ItemStack[] lobbyitems){
			this.lobbyitems = lobbyitems;
		}
		public void giveLobbyItems(OMPlayer omplayer){
			Player p = omplayer.getPlayer();
			
			omplayer.clearInventory();
			omplayer.clearPotionEffects();
			omplayer.addPotionEffect(PotionEffectType.SPEED, 100000, 0);
			p.getInventory().setContents(getLobbyItems());
		}
		
		public ItemStack[] getSpectatorItems(){
			return spectatoritems;
		}
		public void setSpectatorItems(ItemStack[] spectatoritems){
			this.spectatoritems = spectatoritems;
		}
		public void giveSpectatorItems(OMPlayer omplayer){
			Player p = omplayer.getPlayer();
			
			omplayer.clearInventory();
			p.getInventory().setContents(getSpectatorItems());
			omplayer.updateInventory();
		}
		
		private void registerMaps(){
			List<KitPvPMap> maps = new ArrayList<KitPvPMap>();
			{
				KitPvPMap map = new KitPvPMap("Snow Town");
				map.setBuilders("§4§lOwner §4O_o_Fadi_o_O\n§b§lMod §brienk222");
				map.setSpawns(Arrays.asList(new Location(getArenaWorld(), -63.5, 9, -1182.5, -45, 0), new Location(getArenaWorld(), -92.5, 14, -1079.5, -166, 0), new Location(getArenaWorld(), -134.5, 9, -1131.5, -113, 0), new Location(getArenaWorld(), -115, 12.5, -1187.5, -70, 0), new Location(getArenaWorld(), -90.5, 9, -1171.5, 143, 0), new Location(getArenaWorld(), -62.5, 9, -1138.5, -71, 0), new Location(getArenaWorld(), -108.5, 11, -1150.5, -139, 0), new Location(getArenaWorld(), -91.5, 10, -1205.5, -30, 0), new Location(getArenaWorld(), -144.5, 10, -1165.5, -75, 0), new Location(getArenaWorld(), -66.5, 10, -1098.5, -126, 0)));
				map.setSpectatorSpawn(new Location(getArenaWorld(), -93.5, 22, -1154.5, 145, 0));
				map.setMaxY(30);
				maps.add(map);
			}
			{
				KitPvPMap map = new KitPvPMap("Mountain Village");
				map.setBuilders("§b§lMod §brienk222\n§b§lMod §bsharewoods\n§4§lOwner §4O_o_Fadi_o_O");
				map.setSpawns(Arrays.asList(new Location(getArenaWorld(), -352.5, 5, -1366.5, -54, 0), new Location(getArenaWorld(), -317.5, 4, -1329.5, 46, 0), new Location(getArenaWorld(), -283.5, 4, -1296.5, 165, 0), new Location(getArenaWorld(), -303.5, 5, -1315.5, 39, 0), new Location(getArenaWorld(), -284.5, 4, -1348.5, 168, 0), new Location(getArenaWorld(), -303.5, 4, -1345.5, 135, 0), new Location(getArenaWorld(), -316.5, 9, -1364.5, 30, 0), new Location(getArenaWorld(), -337.5, 5, -1344.5, -126, 0), new Location(getArenaWorld(), -349.5, 4, -1327.5, -113, 0), new Location(getArenaWorld(), -323.5, 5, -1296.5, -161, 0)));
				map.setSpectatorSpawn(new Location(getArenaWorld(), -308.5, 16, -1326.5, 137, 0));
				map.setMaxY(26);
				maps.add(map);
			}
			{
				KitPvPMap map = new KitPvPMap("Desert");
				map.setBuilders("§b§lMod §brienk222");
				map.setSpawns(Arrays.asList(new Location(getArenaWorld(), -463.5, 29.5, -1139, 20, 0), new Location(getArenaWorld(), -422.5, 36, -1140.5, 105, 0), new Location(getArenaWorld(), -484, 33, -1060, 155, 0), new Location(getArenaWorld(), -523, 40, -1084, -90, 0), new Location(getArenaWorld(), -516.5, 37, -1123.5, 140, 0), new Location(getArenaWorld(), -450, 29, -1042.5, 156, 0), new Location(getArenaWorld(), -430.5, 34, -1080.5, 93, 0), new Location(getArenaWorld(), -451.5, 29, -1098.5, 20, 0), new Location(getArenaWorld(), -430.5, 38, -1035.5, 135, 0), new Location(getArenaWorld(), -510.5, 36, -1099.5, -123, 0)));
				map.setSpectatorSpawn(new Location(getArenaWorld(), -465, 43.5, -1085, 89, 17));
				map.setMaxY(47);
				maps.add(map);
			}
			
			this.maps = maps;
		}
		
		private void registerKits(){
			{// Knight Level 1 \\
				Kit kit = new Kit(KitPvPKit.KNIGHT.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lKnight §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lKnight §a§lLvL 1§8 || §cHealing Potion"), 8197));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lKnight §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lKnight §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lKnight §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lKnight §a§lLvL 1§8 || §bBoots")), 4));
			}
			{// Knight Level 2 \\
				Kit kit = new Kit(KitPvPKit.KNIGHT.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lKnight §a§lLvL 2§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lKnight §a§lLvL 2§8 || §cHealing Potion"), 16389));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lKnight §a§lLvL 2§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lKnight §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lKnight §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lKnight §a§lLvL 2§8 || §bBoots")), 4));
			}
			{// Knight Level 3 \\
				Kit kit = new Kit(KitPvPKit.KNIGHT.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lKnight §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lKnight §a§lLvL 3§8 || §cHealing Potion"), 16389));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lKnight §a§lLvL 3§8 || §cHealing Potion"), 16389));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lKnight §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lKnight §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lKnight §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lKnight §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Archer Level 1 \\
				Kit kit = new Kit(KitPvPKit.ARCHER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lArcher §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lArcher §a§lLvL 1§8 || §bBow")), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 32), "§b§lArcher §a§lLvL 1§8 || §bArrow"));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lArcher §a§lLvL 1§8 || §cHealing Potion"), 8197));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lArcher §a§lLvL 1§8 || §bHelmet"), Color.fromBGR(204, 255, 51))), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lArcher §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(204, 255, 51))), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lArcher §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(204, 255, 51))), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lArcher §a§lLvL 1§8 || §bBoots"), Color.fromBGR(204, 255, 51))), 4));
			}
			{// Archer Level 2 \\
				Kit kit = new Kit(KitPvPKit.ARCHER.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lArcher §a§lLvL 2§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lArcher §a§lLvL 2§8 || §bBow"), ProjectileType.LIGHTNING_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 32), "§b§lArcher §a§lLvL 2§8 || §bArrow"));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lArcher §a§lLvL 2§8 || §cHealing Potion"), 8197));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lArcher §a§lLvL 2§8 || §bHelmet"), Color.fromBGR(204, 255, 51))), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lArcher §a§lLvL 2§8 || §bChestplate"), Color.fromBGR(204, 255, 51))), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lArcher §a§lLvL 2§8 || §bLeggings"), Color.fromBGR(204, 255, 51))), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lArcher §a§lLvL 2§8 || §bBoots"), Color.fromBGR(204, 255, 51))), 4));
			}
			{// Archer Level 3 \\
				Kit kit = new Kit(KitPvPKit.ARCHER.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lArcher §a§lLvL 3§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lArcher §a§lLvL 3§8 || §bBow"), ProjectileType.LIGHTNING_I.addEnchantment(new ArrayList<String>())), Enchantment.ARROW_DAMAGE, 1)), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 32), "§b§lArcher §a§lLvL 3§8 || §bArrow"));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lArcher §a§lLvL 3§8 || §cHealing Potion"), 16389));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lArcher §a§lLvL 3§8 || §bHelmet"), Color.fromBGR(204, 255, 51)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lArcher §a§lLvL 3§8 || §bChestplate"), Color.fromBGR(204, 255, 51)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lArcher §a§lLvL 3§8 || §bLeggings"), Color.fromBGR(204, 255, 51)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lArcher §a§lLvL 3§8 || §bBoots"), Color.fromBGR(204, 255, 51)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Soldier Level 1 \\
				Kit kit = new Kit(KitPvPKit.SOLDIER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lSoldier §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lSoldier §a§lLvL 1§8 || §bBow")), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 16), "§b§lSoldier §a§lLvL 1§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lSoldier §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_CHESTPLATE), "§b§lSoldier §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSoldier §a§lLvL 1§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSoldier §a§lLvL 1§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Soldier Level 2 \\
				Kit kit = new Kit(KitPvPKit.SOLDIER.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lSoldier §a§lLvL 2§8 || §bWeapon"), ItemType.LIGHTNING_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lSoldier §a§lLvL 2§8 || §bBow")), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 16), "§b§lSoldier §a§lLvL 2§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lSoldier §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_CHESTPLATE), "§b§lSoldier §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSoldier §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSoldier §a§lLvL 2§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Soldier Level 3 \\
				Kit kit = new Kit(KitPvPKit.SOLDIER.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lSoldier §a§lLvL 3§8 || §bWeapon"), ItemType.LIGHTNING_II.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lSoldier §a§lLvL 3§8 || §bBow"), Enchantment.ARROW_DAMAGE, 1)), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 20), "§b§lSoldier §a§lLvL 3§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lSoldier §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_CHESTPLATE), "§b§lSoldier §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSoldier §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSoldier §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Wizard Level 1 \\
				Kit kit = new Kit(KitPvPKit.WIZARD.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lWizard §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 1§8 || §dRegeneration Potion"), 8193));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 1§8 || §bSpeed Potion"), 8194));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 1§8 || §7Weakness Potion"), 16392));
				kit.setItem(4, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 1§8 || §cHealing Potion"), 16389));
				kit.setItem(5, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 1§8 || §cHealing Potion"), 16389));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lWizard §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lWizard §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lWizard §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lWizard §a§lLvL 1§8 || §bBoots")), 4));
			}
			{// Wizard Level 2 \\
				Kit kit = new Kit(KitPvPKit.WIZARD.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lWizard §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 2§8 || §dRegeneration Potion"), 8193));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 2§8 || §bSpeed Potion"), 8194));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 2§8 || §7Weakness Potion"), 16392));
				kit.setItem(4, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 2§8 || §cHealing Potion"), 16389));
				kit.setItem(5, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 2§8 || §cHealing Potion"), 16389));
				kit.setItem(6, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BLAZE_ROD), "§b§lWizard §a§lLvL 2§8 || §cFire Wand"), ItemType.FIRE_SPELL_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lWizard §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lWizard §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lWizard §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lWizard §a§lLvL 2§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Wizard Level 3 \\
				Kit kit = new Kit(KitPvPKit.WIZARD.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lWizard §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 3§8 || §dRegeneration Potion"), 8193));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 3§8 || §bSpeed Potion"), 8194));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 3§8 || §7Weakness Potion"), 16392));
				kit.setItem(4, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 3§8 || §cHealing Potion"), 16389));
				kit.setItem(5, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lWizard §a§lLvL 3§8 || §cHealing Potion"), 16389));
				kit.setItem(6, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BLAZE_ROD), "§b§lWizard §a§lLvL 3§8 || §cFire Wand"), ItemType.FIRE_SPELL_II.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lWizard §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lWizard §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lWizard §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lWizard §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Tank Level 1 \\
				Kit kit = new Kit(KitPvPKit.TANK.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.WOOD_SWORD), "§b§lTank §a§lLvL 1§8 || §bWeapon"), Enchantment.KNOCKBACK, 1)), 4));
				kit.setItem(1, Utils.setDisplayname(new ItemStack(Material.GOLDEN_APPLE, 2), "§b§lTank §a§lLvL 1§8 || §eGolden Apple"));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_HELMET), "§b§lTank §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.DIAMOND_CHESTPLATE), "§b§lTank §a§lLvL 1§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_LEGGINGS), "§b§lTank §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_BOOTS), "§b§lTank §a§lLvL 1§8 || §bBoots")), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 2));
			}
			{// Tank Level 2 \\
				Kit kit = new Kit(KitPvPKit.TANK.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lTank §a§lLvL 2§8 || §bWeapon"), Enchantment.KNOCKBACK, 2)), 4));
				kit.setItem(1, Utils.setDisplayname(new ItemStack(Material.GOLDEN_APPLE, 3), "§b§lTank §a§lLvL 2§8 || §eGolden Apple"));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_HELMET), "§b§lTank §a§lLvL 2§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.DIAMOND_CHESTPLATE), "§b§lTank §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_LEGGINGS), "§b§lTank §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_BOOTS), "§b§lTank §a§lLvL 2§8 || §bBoots")), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 2));
			}
			{// Tank Level 3 \\
				Kit kit = new Kit(KitPvPKit.TANK.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lTank §a§lLvL 3§8 || §bWeapon"), Enchantment.KNOCKBACK, 2)), 4));
				kit.setItem(1, Utils.setDisplayname(new ItemStack(Material.GOLDEN_APPLE, 4), "§b§lTank §a§lLvL 3§8 || §eGolden Apple"));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_HELMET), "§b§lTank §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.DIAMOND_CHESTPLATE), "§b§lTank §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_LEGGINGS), "§b§lTank §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_BOOTS), "§b§lTank §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 2));
			}
			{// Drunk Level 1 \\
				Kit kit = new Kit(KitPvPKit.DRUNK.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lDrunk §a§lLvL 1§8 || §bWeapon"), Enchantment.KNOCKBACK, 2)), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lDrunk §a§lLvL 1§8 || §5Strength Potion"), 8201));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lDrunk §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lDrunk §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lDrunk §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lDrunk §a§lLvL 1§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000000, 1));
			}
			{// Drunk Level 2 \\
				Kit kit = new Kit(KitPvPKit.DRUNK.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lDrunk §a§lLvL 2§8 || §bWeapon"), ItemType.BLINDNESS_I.addEnchantment(new ArrayList<String>())), Enchantment.KNOCKBACK, 2)), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lDrunk §a§lLvL 2§8 || §5Strength Potion"), 8201));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lDrunk §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lDrunk §a§lLvL 2§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lDrunk §a§lLvL 2§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lDrunk §a§lLvL 2§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000000, 0));
			}
			{// Drunk Level 3 \\
				Kit kit = new Kit(KitPvPKit.DRUNK.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.DIAMOND_SWORD), "§b§lDrunk §a§lLvL 3§8 || §bWeapon"), ItemType.BLINDNESS_II.addEnchantment(new ArrayList<String>())), Enchantment.KNOCKBACK, 2)), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lDrunk §a§lLvL 3§8 || §5Strength Potion"), 8201));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lDrunk §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lDrunk §a§lLvL 3§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lDrunk §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lDrunk §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000000, 0));
			}
			{// Pyro Level 1 \\
				Kit kit = new Kit(KitPvPKit.PYRO.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lPyro §a§lLvL 1§8 || §bWeapon"), Enchantment.FIRE_ASPECT, 2)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lPyro §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_FIRE, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lPyro §a§lLvL 1§8 || §bChestplate"), Enchantment.PROTECTION_FIRE, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lPyro §a§lLvL 1§8 || §bLeggings"), Enchantment.PROTECTION_FIRE, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lPyro §a§lLvL 1§8 || §bBoots"), Enchantment.PROTECTION_FIRE, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000000, 3));
			}
			{// Pyro Level 2 \\
				Kit kit = new Kit(KitPvPKit.PYRO.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lPyro §a§lLvL 2§8 || §bWeapon"), Enchantment.FIRE_ASPECT, 2), Enchantment.DAMAGE_ALL, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lPyro §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_FIRE, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lPyro §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_FIRE, 1), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lPyro §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_FIRE, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lPyro §a§lLvL 2§8 || §bBoots"), ArmorType.FIRE_TRAIL_I.addEnchantment(new ArrayList<String>())), Enchantment.PROTECTION_FIRE, 1), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000000, 3));
			}
			{// Pyro Level 3 \\
				Kit kit = new Kit(KitPvPKit.PYRO.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lPyro §a§lLvL 3§8 || §bWeapon"), Enchantment.FIRE_ASPECT, 2), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lPyro §a§lLvL 3§8 || §bBow"), Enchantment.ARROW_FIRE, 1)), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 12), "§b§lPyro §a§lLvL 3§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lPyro §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_FIRE, 1), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lPyro §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_FIRE, 1), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lPyro §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_FIRE, 1), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lPyro §a§lLvL 3§8 || §bBoots"), ArmorType.FIRE_TRAIL_I.addEnchantment(new ArrayList<String>())), Enchantment.PROTECTION_FIRE, 1), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000000, 3));
			}
			{// Bunny Level 1 \\
				Kit kit = new Kit(KitPvPKit.BUNNY.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lBunny §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 1§8 || §2Poison Potion"), 16420));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 1§8 || §4Harming Potion"), 16396));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 1§8 || §4Harming Potion"), 16396));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lBunny §a§lLvL 1§8 || §bHelmet"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBunny §a§lLvL 1§8 || §bChestplate"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBunny §a§lLvL 1§8 || §bLeggings"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBunny §a§lLvL 1§8 || §bBoots"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000000, 3));
			}
			{// Bunny Level 2 \\
				Kit kit = new Kit(KitPvPKit.BUNNY.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lBunny §a§lLvL 2§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CARROT_ITEM), "§b§lBunny §a§lLvL 2§8 || §6Knockback Carrot"), Enchantment.DAMAGE_ALL, 5), Enchantment.KNOCKBACK, 10));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 2§8 || §2Poison Potion"), 16420));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 2§8 || §2Poison Potion"), 16420));
				kit.setItem(4, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 2§8 || §4Harming Potion"), 16396));
				kit.setItem(5, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 2§8 || §4Harming Potion"), 16396));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lBunny §a§lLvL 2§8 || §bHelmet"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBunny §a§lLvL 2§8 || §bChestplate"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBunny §a§lLvL 2§8 || §bLeggings"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBunny §a§lLvL 2§8 || §bBoots"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000000, 3));
			}
			{// Bunny Level 3 \\
				Kit kit = new Kit(KitPvPKit.BUNNY.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lBunny §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CARROT_ITEM), "§b§lBunny §a§lLvL 3§8 || §6Knockback Carrot"), Enchantment.DAMAGE_ALL, 5), Enchantment.KNOCKBACK, 10));
				kit.setItem(2, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 3§8 || §2Poison Potion"), 16420));
				kit.setItem(3, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 3§8 || §2Poison Potion"), 16420));
				kit.setItem(4, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 3§8 || §4Harming Potion"), 16396));
				kit.setItem(5, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.POTION), "§b§lBunny §a§lLvL 3§8 || §4Harming Potion"), 16396));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lBunny §a§lLvL 3§8 || §bHelmet"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBunny §a§lLvL 3§8 || §bChestplate"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBunny §a§lLvL 3§8 || §bLeggings"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBunny §a§lLvL 3§8 || §bBoots"), Color.WHITE), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000000, 3));
			}
			{// Necromancer Level 1 \\
				Kit kit = new Kit(KitPvPKit.NECROMANCER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HOE), "§b§lNecromancer §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lNecromancer §a§lLvL 1§8 || §bBow"), ProjectileType.UNDEATH_I.addEnchantment(new ArrayList<String>())), Enchantment.ARROW_DAMAGE, 1)), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 5), "§b§lNecromancer §a§lLvL 1§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lNecromancer §a§lLvL 1§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lNecromancer §a§lLvL 1§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lNecromancer §a§lLvL 1§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lNecromancer §a§lLvL 1§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Necromancer Level 2 \\
				Kit kit = new Kit(KitPvPKit.NECROMANCER.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HOE), "§b§lNecromancer §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lNecromancer §a§lLvL 2§8 || §bBow"), ProjectileType.UNDEATH_II.addEnchantment(new ArrayList<String>())), Enchantment.ARROW_DAMAGE, 1)), 4));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 10), "§b§lNecromancer §a§lLvL 2§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lNecromancer §a§lLvL 2§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lNecromancer §a§lLvL 2§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lNecromancer §a§lLvL 2§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lNecromancer §a§lLvL 2§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Necromancer Level 3 \\
				Kit kit = new Kit(KitPvPKit.NECROMANCER.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_HOE), "§b§lNecromancer §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STICK), "§b§lNecromancer §a§lLvL 3§8 || §8Necromancer's Staff"), ItemType.WITHER_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				kit.setItem(2, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lNecromancer §a§lLvL 3§8 || §bBow"), ProjectileType.UNDEATH_II.addEnchantment(new ArrayList<String>())), Enchantment.ARROW_DAMAGE, 1)), 4));
				kit.setItem(3, Utils.setDisplayname(new ItemStack(Material.ARROW, 10), "§b§lNecromancer §a§lLvL 3§8 || §bArrow"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lNecromancer §a§lLvL 3§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lNecromancer §a§lLvL 3§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lNecromancer §a§lLvL 3§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lNecromancer §a§lLvL 3§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// King Level 1 \\
				Kit kit = new Kit(KitPvPKit.KING.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lKing §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.DIAMOND_HELMET), "§b§lKing §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lKing §a§lLvL 1§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lKing §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lKing §a§lLvL 1§8 || §bBoots")), 4));
			}
			{// King Level 2 \\
				Kit kit = new Kit(KitPvPKit.KING.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lKing §a§lLvL 2§8 || §bWeapon§a"), ItemType.HEALING_I.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.DIAMOND_HELMET), "§b§lKing §a§lLvL 2§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lKing §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lKing §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lKing §a§lLvL 2§8 || §bBoots")), 4));
			}
			{// King Level 3 \\
				Kit kit = new Kit(KitPvPKit.KING.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lKing §a§lLvL 3§8 || §bWeapon§a"), ItemType.HEALING_II.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.DIAMOND_HELMET), "§b§lKing §a§lLvL 3§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lKing §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lKing §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lKing §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Tree Level 1 \\
				Kit kit = new Kit(KitPvPKit.TREE.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEAVES), "§b§lTree §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 4)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEAVES), "§b§lTree §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lTree §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lTree §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lTree §a§lLvL 1§8 || §bBoots")), 4));
			}
			{// Tree Level 2 \\
				Kit kit = new Kit(KitPvPKit.TREE.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEAVES), "§b§lTree §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.LOG), "§b§lTree §a§lLvL 2§8 || §dBarrier"), 1), ItemType.BARRIER_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEAVES), "§b§lTree §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 4)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lTree §a§lLvL 2§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lTree §a§lLvL 2§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lTree §a§lLvL 2§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Tree Level 3 \\
				Kit kit = new Kit(KitPvPKit.TREE.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEAVES), "§b§lTree §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.LOG), "§b§lTree §a§lLvL 3§8 || §dBarrier"), 1), ItemType.BARRIER_II.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEAVES), "§b§lTree §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 4)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lTree §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lTree §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lTree §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Blaze Level 1 \\
				Kit kit = new Kit(KitPvPKit.BLAZE.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BLAZE_POWDER), "§b§lBlaze §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 4), Enchantment.FIRE_ASPECT, 2)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.STAINED_CLAY), "§b§lBlaze §a§lLvL 1§8 || §bHelmet"), 4), Enchantment.PROTECTION_ENVIRONMENTAL, 2), Enchantment.PROTECTION_FIRE, 3), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBlaze §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 1), Enchantment.PROTECTION_FIRE, 3)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBlaze §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 1), Enchantment.PROTECTION_FIRE, 3)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBlaze §a§lLvL 1§8 || §bBoots"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 1), Enchantment.PROTECTION_FIRE, 3)), 4));
			}
			{// Blaze Level 2 \\
				Kit kit = new Kit(KitPvPKit.BLAZE.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BLAZE_POWDER), "§b§lBlaze §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5), Enchantment.FIRE_ASPECT, 3)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.STAINED_CLAY), "§b§lBlaze §a§lLvL 2§8 || §bHelmet"), 4), Enchantment.PROTECTION_ENVIRONMENTAL, 2), Enchantment.PROTECTION_FIRE, 3), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBlaze §a§lLvL 2§8 || §bChestplate"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 2), Enchantment.PROTECTION_FIRE, 3)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBlaze §a§lLvL 2§8 || §bLeggings"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 1), Enchantment.PROTECTION_FIRE, 3)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBlaze §a§lLvL 2§8 || §bBoots"), ArmorType.LIGHT_I.addEnchantment(new ArrayList<String>())), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 1), Enchantment.PROTECTION_FIRE, 3)), 4));
			}
			{// Blaze Level 3 \\
				Kit kit = new Kit(KitPvPKit.BLAZE.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BLAZE_POWDER), "§b§lBlaze §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 6), Enchantment.FIRE_ASPECT, 4)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.STAINED_CLAY), "§b§lBlaze §a§lLvL 3§8 || §bHelmet"), 4), Enchantment.PROTECTION_ENVIRONMENTAL, 3), Enchantment.PROTECTION_FIRE, 3), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBlaze §a§lLvL 3§8 || §bChestplate"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 2), Enchantment.PROTECTION_FIRE, 3)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBlaze §a§lLvL 3§8 || §bLeggings"), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 2), Enchantment.PROTECTION_FIRE, 3)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.addColor(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBlaze §a§lLvL 3§8 || §bBoots"), ArmorType.LIGHT_I.addEnchantment(new ArrayList<String>())), Color.fromBGR(10, 130, 180)), Enchantment.PROTECTION_ENVIRONMENTAL, 2), Enchantment.PROTECTION_FIRE, 3)), 4));
			}
			{// TNT Level 1 \\
				Kit kit = new Kit(KitPvPKit.TNT.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.TNT), "§b§lTNT §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5), Enchantment.KNOCKBACK, 3), 4));
				kit.setItem(1, Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.REDSTONE_TORCH_ON), "§b§lTNT §a§lLvL 1§8 || §4TNT Launcher"), 8193), ItemType.TNT_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1));

				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.TNT), "§b§lTNT §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 4), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lTNT §a§lLvL 1§8 || §bChestplate"), Enchantment.PROTECTION_EXPLOSIONS, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lTNT §a§lLvL 1§8 || §bLeggings"), Enchantment.PROTECTION_EXPLOSIONS, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lTNT §a§lLvL 1§8 || §bBoots"), Enchantment.PROTECTION_EXPLOSIONS, 1)), 4));
			}
			{// TNT Level 2 \\
				Kit kit = new Kit(KitPvPKit.TNT.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.TNT), "§b§lTNT §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5), Enchantment.KNOCKBACK, 4), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lTNT §a§lLvL 3§8 || §bBow"), ProjectileType.EXPLOSIVE_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 2), "§b§lTNT §a§lLvL 2§8 || §bArrow"));
				kit.setItem(3, Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.REDSTONE_TORCH_ON), "§b§lTNT §a§lLvL 2§8 || §4TNT Launcher"), 8193), ItemType.TNT_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1));

				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.TNT), "§b§lTNT §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 4), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lTNT §a§lLvL 2§8 || §bChestplate"), Enchantment.PROTECTION_EXPLOSIONS, 2), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lTNT §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_EXPLOSIONS, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lTNT §a§lLvL 2§8 || §bBoots"), Enchantment.PROTECTION_EXPLOSIONS, 2)), 4));
			}
			{// TNT Level 3 \\
				Kit kit = new Kit(KitPvPKit.TNT.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.TNT), "§b§lTNT §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5), Enchantment.KNOCKBACK, 4), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lTNT §a§lLvL 3§8 || §bBow"), ProjectileType.EXPLOSIVE_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 4), "§b§lTNT §a§lLvL 3§8 || §bArrow"));
				kit.setItem(3, Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.REDSTONE_TORCH_ON), "§b§lTNT §a§lLvL 3§8 || §4TNT Launcher"), 8193), ItemType.TNT_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1));

				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.TNT), "§b§lTNT §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 4), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_CHESTPLATE), "§b§lTNT §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_EXPLOSIONS, 3), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_LEGGINGS), "§b§lTNT §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_EXPLOSIONS, 3), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_BOOTS), "§b§lTNT §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_EXPLOSIONS, 3), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Fisherman Level 1 \\
				Kit kit = new Kit(KitPvPKit.FISHERMAN.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.FISHING_ROD), "§b§lFisherman §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 6)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFisherman §a§lLvL 1§8 || §bFish"), 1), Enchantment.KNOCKBACK, 4), Enchantment.FIRE_ASPECT, 2), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lFisherman §a§lLvL 1§8 || §bHelmet"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lFisherman §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lFisherman §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lFisherman §a§lLvL 1§8 || §bBoots"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Fisherman Level 2 \\
				Kit kit = new Kit(KitPvPKit.FISHERMAN.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.FISHING_ROD), "§b§lFisherman §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 6)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFisherman §a§lLvL 2§8 || §bFish"), 1), Enchantment.KNOCKBACK, 4), Enchantment.FIRE_ASPECT, 2), 4));
				kit.setItem(2, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFisherman §a§lLvL 2§8 || §9Fish Attack"), 3), ItemType.FISH_ATTACK_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lFisherman §a§lLvL 2§8 || §bHelmet"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lFisherman §a§lLvL 2§8 || §bChestplate"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lFisherman §a§lLvL 2§8 || §bLeggings"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lFisherman §a§lLvL 2§8 || §bBoots"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Fisherman Level 3 \\
				Kit kit = new Kit(KitPvPKit.FISHERMAN.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.FISHING_ROD), "§b§lFisherman §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 6)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFisherman §a§lLvL 3§8 || §bFish"), 1), Enchantment.KNOCKBACK, 5), Enchantment.FIRE_ASPECT, 2), 4));
				kit.setItem(2, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFisherman §a§lLvL 3§8 || §9Fish Attack"), 3), ItemType.FISH_ATTACK_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lFisherman §a§lLvL 3§8 || §bHelmet"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lFisherman §a§lLvL 3§8 || §bChestplate"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lFisherman §a§lLvL 3§8 || §bLeggings"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lFisherman §a§lLvL 3§8 || §bBoots"), Color.fromBGR(10, 130, 120)), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
			}
			{// SnowGolem Level 1 \\
				Kit kit = new Kit(KitPvPKit.SNOWGOLEM.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.SNOW_BALL), "§b§lSnowGolem §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 6), Enchantment.KNOCKBACK, 2), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PUMPKIN), "§b§lSnowGolem §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 5)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lSnowGolem §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSnowGolem §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSnowGolem §a§lLvL 1§8 || §bBoots"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 0));
			}
			{// SnowGolem Level 2 \\
				Kit kit = new Kit(KitPvPKit.SNOWGOLEM.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.SNOW_BALL), "§b§lSnowGolem §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 6), Enchantment.KNOCKBACK, 2), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.IRON_FENCE), "§b§lSnowGolem §a§lLvL 2§8 || §7Shield"), 3), ItemType.SHIELD_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PUMPKIN), "§b§lSnowGolem §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 5)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lSnowGolem §a§lLvL 2§8 || §bChestplate"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSnowGolem §a§lLvL 2§8 || §bLeggings"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSnowGolem §a§lLvL 2§8 || §bBoots"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 0));
			}
			{// SnowGolem Level 3 \\
				Kit kit = new Kit(KitPvPKit.SNOWGOLEM.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.SNOW_BALL), "§b§lSnowGolem §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 7), Enchantment.KNOCKBACK, 3), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.IRON_FENCE), "§b§lSnowGolem §a§lLvL 3§8 || §7Shield"), 3), ItemType.SHIELD_II.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PUMPKIN), "§b§lSnowGolem §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 5)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lSnowGolem §a§lLvL 3§8 || §bChestplate"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 3)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSnowGolem §a§lLvL 3§8 || §bLeggings"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSnowGolem §a§lLvL 3§8 || §bBoots"), Color.fromBGR(200, 200, 200)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 0));
			}
			{// Librarian Level 1 \\
				Kit kit = new Kit(KitPvPKit.LIBRARIAN.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PAPER), "§b§lLibrarian §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOOKSHELF), "§b§lLibrarian §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 6), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lLibrarian §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lLibrarian §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lLibrarian §a§lLvL 1§8 || §bBoots")), 4));
			}
			{// Librarian Level 2 \\
				Kit kit = new Kit(KitPvPKit.LIBRARIAN.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PAPER), "§b§lLibrarian §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOOK), "§b§lLibrarian §a§lLvL 2§8 || §6Knockback Book"), Enchantment.KNOCKBACK, 5), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOOKSHELF), "§b§lLibrarian §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 6), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lLibrarian §a§lLvL 2§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lLibrarian §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lLibrarian §a§lLvL 2§8 || §bBoots")), 4));
			}
			{// Librarian Level 3 \\
				Kit kit = new Kit(KitPvPKit.LIBRARIAN.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PAPER), "§b§lLibrarian §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOOK), "§b§lLibrarian §a§lLvL 3§8 || §6Knockback Book"), Enchantment.KNOCKBACK, 6), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.BOOKSHELF), "§b§lLibrarian §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 6), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lLibrarian §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lLibrarian §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lLibrarian §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Spider Level 1 \\
				Kit kit = new Kit(KitPvPKit.SPIDER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.SPIDER_EYE), "§b§lSpider §a§lLvL 1§8 || §bWeapon"), ItemType.ARTHROPODS_I.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 6)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lSpider §a§lLvL 1§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lSpider §a§lLvL 1§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSpider §a§lLvL 1§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSpider §a§lLvL 1§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Spider Level 2 \\
				Kit kit = new Kit(KitPvPKit.SPIDER.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.SPIDER_EYE), "§b§lSpider §a§lLvL 2§8 || §bWeapon"), ItemType.ARTHROPODS_II.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 6)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lSpider §a§lLvL 2§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lSpider §a§lLvL 2§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSpider §a§lLvL 2§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSpider §a§lLvL 2§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Spider Level 3 \\
				Kit kit = new Kit(KitPvPKit.SPIDER.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.SPIDER_EYE), "§b§lSpider §a§lLvL 3§8 || §bWeapon"), ItemType.ARTHROPODS_III.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 6)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lSpider §a§lLvL 3§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lSpider §a§lLvL 3§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lSpider §a§lLvL 3§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lSpider §a§lLvL 3§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// Villager Level 1 \\
				Kit kit = new Kit(KitPvPKit.VILLAGER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.EMERALD), "§b§lVillager §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 9), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lVillager §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lVillager §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lVillager §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lVillager §a§lLvL 1§8 || §bBoots")), 4));
			}
			{// Villager Level 2 \\
				Kit kit = new Kit(KitPvPKit.VILLAGER.getName() + " 2");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.EMERALD), "§b§lVillager §a§lLvL 2§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 9), Enchantment.FIRE_ASPECT, 1), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lVillager §a§lLvL 2§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lVillager §a§lLvL 2§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lVillager §a§lLvL 2§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lVillager §a§lLvL 2§8 || §bBoots")), 4));
			}
			{// Villager Level 3 \\
				Kit kit = new Kit(KitPvPKit.VILLAGER.getName() + " 3");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.EMERALD), "§b§lVillager §a§lLvL 3§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 9), Enchantment.FIRE_ASPECT, 1), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BREAD), "§b§lVillager §a§lLvL 3§8 || §aTrade System"), ItemType.TRADE_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lVillager §a§lLvL 3§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lVillager §a§lLvL 3§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lVillager §a§lLvL 3§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lVillager §a§lLvL 3§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Assassin Level 1 \\
				Kit kit = new Kit(KitPvPKit.ASSASSIN.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.DIAMOND_SWORD), "§b§lAssassin §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lAssassin §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lAssassin §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lAssassin §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.DIAMOND_BOOTS), "§b§lAssassin §a§lLvL 1§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1), Enchantment.PROTECTION_FALL, 3)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 1));
			}
			{// Lord Level 1 \\
				Kit kit = new Kit(KitPvPKit.LORD.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_SWORD), "§b§lLord §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.setDisplayname(new ItemStack(Material.GOLDEN_APPLE, 5), "§b§lLord §a§lLvL 1§8 || §eGolden Apple"));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.GOLD_HELMET), "§b§lLord §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lLord §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lLord §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lLord §a§lLvL 1§8 || §bBoots")), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2000000, 1));
			}
			{// Vampire Level 1 \\
				Kit kit = new Kit(KitPvPKit.VAMPIRE.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lVampire §a§lLvL 1§8 || §bWeapon"), ItemType.VAMPIRE_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lVampire §a§lLvL 1§8 || §bHelmet"), Color.fromBGR(50, 10, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lVampire §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(50, 10, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lVampire §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(50, 10, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lVampire §a§lLvL 1§8 || §bBoots"), Color.fromBGR(50, 10, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// DarkMage Level 1 \\
				Kit kit = new Kit(KitPvPKit.DARKMAGE.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lDarkMage §a§lLvL 1§8 || §bWeapon§5"), ItemType.MAGIC_I.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BREWING_STAND_ITEM), "§b§lDarkMage §a§lLvL 1§8 || §ePotion Launcher"), ItemType.POTION_LAUNCHER_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lDarkMage §a§lLvL 1§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lDarkMage §a§lLvL 1§8 || §bChestplate"), ArmorType.WITHER_ARMOR_I.addEnchantment(new ArrayList<String>())), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lDarkMage §a§lLvL 1§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lDarkMage §a§lLvL 1§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Beast Level 1 \\
				Kit kit = new Kit(KitPvPKit.BEAST.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.IRON_AXE), "§b§lBeast §a§lLvL 1§8 || §bWeapon"), ItemType.KNOCKUP_I.addEnchantment(new ArrayList<String>())), Enchantment.DAMAGE_ALL, 1)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lBeast §a§lLvL 1§8 || §bHelmet"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lBeast §a§lLvL 1§8 || §bChestplate"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lBeast §a§lLvL 1§8 || §bLeggings"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lBeast §a§lLvL 1§8 || §bBoots"), Color.BLACK), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
			{// Fish Level 1 \\
				Kit kit = new Kit(KitPvPKit.FISH.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFish §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 8), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.RAW_FISH), "§b§lFish §a§lLvL 1§8 || §6Knockback Fish"), 2), Enchantment.KNOCKBACK, 5), 4));
				kit.setItem(2, Utils.hideFlags(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.COOKED_FISH), "§b§lFish §a§lLvL 1§8 || §4Hot Fish"), Enchantment.DAMAGE_ALL, 2), Enchantment.FIRE_ASPECT, 2), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_HELMET), "§b§lFish §a§lLvL 1§8 || §bHelmet")), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "§b§lFish §a§lLvL 1§8 || §bChestplate")), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_LEGGINGS), "§b§lFish §a§lLvL 1§8 || §bLeggings")), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.CHAINMAIL_BOOTS), "§b§lFish §a§lLvL 1§8 || §bBoots")), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 2000000, 2));
			}
			{// Heavy Level 1 \\
				Kit kit = new Kit(KitPvPKit.HEAVY.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.setDisplayname(new ItemStack(Material.IRON_SWORD), "§b§lHeavy §a§lLvL 1§8 || §bWeapon")), 4));
				kit.setItem(1, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.BOW), "§b§lHeavy §a§lLvL 1§8 || §bBow"), ProjectileType.ARROW_SPLIT_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1)), 5));
				kit.setItem(2, Utils.setDisplayname(new ItemStack(Material.ARROW, 8), "§b§lHeavy §a§lLvL 1§8 || §bArrow"));

				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lHeavy §a§lLvL 1§8 || §bHelmet"), Color.fromBGR(204, 100, 2)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lHeavy §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(204, 100, 2)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lHeavy §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(204, 100, 2)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lHeavy §a§lLvL 1§8 || §bBoots"), Color.fromBGR(204, 100, 2)), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
			}
			{// GrimReaper Level 1 \\
				Kit kit = new Kit(KitPvPKit.GRIMREAPER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_AXE), "§b§lGrimReaper §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 3)), 4));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.SKULL_ITEM), "§b§lGrimReaper §a§lLvL 1§8 || §bHelmet"), 1), Enchantment.PROTECTION_ENVIRONMENTAL, 7)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setLore(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lGrimReaper §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(100, 100, 100)), ArmorType.MOLTEN_ARMOR_I.addEnchantment(new ArrayList<String>())), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lGrimReaper §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(100, 100, 100))), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lGrimReaper §a§lLvL 1§8 || §bBoots"), Color.fromBGR(100, 100, 100))), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 0));
			}
			{// Miner Level 1 \\
				Kit kit = new Kit(KitPvPKit.MINER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_PICKAXE), "§b§lMiner §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 5)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.COAL), "§b§lMiner §a§lLvL 1§8 || §1Miner Power"), ItemType.HEALING_KIT_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lMiner §a§lLvL 1§8 || §bHelmet"), Color.fromBGR(150, 150, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lMiner §a§lLvL 1§8 || §bChestplate"), Color.fromBGR(150, 150, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lMiner §a§lLvL 1§8 || §bLeggings"), Color.fromBGR(150, 150, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lMiner §a§lLvL 1§8 || §bBoots"), Color.fromBGR(150, 150, 150)), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 0));
			}
			{// Farmer Level 1 \\
				Kit kit = new Kit(KitPvPKit.FARMER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.STONE_SWORD), "§b§lFarmer §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 2)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.HAY_BLOCK), "§b§lFarmer §a§lLvL 1§8 || §eBlock Explosion"), ItemType.BLOCK_EXPLOSION_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lFarmer §a§lLvL 1§8 || §bHelmet"), Color.YELLOW), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lFarmer §a§lLvL 1§8 || §bChestplate"), Color.YELLOW), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lFarmer §a§lLvL 1§8 || §bLeggings"), Color.YELLOW), Enchantment.PROTECTION_ENVIRONMENTAL, 2)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lFarmer §a§lLvL 1§8 || §bBoots"), Color.YELLOW), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000000, 0));
			}
			{// Undeath King Level 1 \\
				Kit kit = new Kit(KitPvPKit.UNDEATH_KING.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.GOLD_SWORD), "§b§lUndeath King §a§lLvL 1§8 || §bWeapon"), Enchantment.DAMAGE_ALL, 1)), 4));
				kit.setItem(1, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.ROTTEN_FLESH), "§b§lUndeath King §a§lLvL 1§8 || §dSummon the Undeath"), ItemType.UNDEATH_SUMMON_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lUndeath King §a§lLvL 1§8 || §bHelmet"), Color.FUCHSIA)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lUndeath King §a§lLvL 1§8 || §bChestplate"), Color.FUCHSIA)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lUndeath King §a§lLvL 1§8 || §bLeggings"), Color.FUCHSIA)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addColor(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lUndeath King §a§lLvL 1§8 || §bBoots"), Color.FUCHSIA)), 4));
			}
			{// Engineer Level 1 \\
				Kit kit = new Kit(KitPvPKit.ENGINEER.getName() + " 1");
				kit.setItem(0, Utils.hideFlags(Utils.addEnchantment(Utils.setLore(Utils.setDisplayname(new ItemStack(Material.ENDER_PEARL), "§b§lEngineer §a§lLvL 1§8 || §c§lRed §8|| §bWeapon§f"), ItemType.PAINTBALLS_I.addEnchantment(new ArrayList<String>())), Enchantment.DURABILITY, 1), 5));
				
				kit.setHelmet(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_HELMET), "§b§lEngineer §a§lLvL 1§8 || §bHelmet"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setChestplate(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_CHESTPLATE), "§b§lEngineer §a§lLvL 1§8 || §bChestplate"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setLeggings(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_LEGGINGS), "§b§lEngineer §a§lLvL 1§8 || §bLeggings"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
				kit.setBoots(Utils.hideFlags(Utils.setUnbreakable(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEATHER_BOOTS), "§b§lEngineer §a§lLvL 1§8 || §bBoots"), Enchantment.PROTECTION_ENVIRONMENTAL, 1)), 4));
			}
		}
		
		private void spawnNPCs(){
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_SELECTOR, new Location(getKitPvPWorld(), -5.5, 74, -7.5, -45, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.setItemName("§3§lServer Selector");
				npcas.spawn();
			}
			{
				NPC npc = NPC.addNPC(NPCType.KIT_SELECTOR);
				npc.newEntity(EntityType.SKELETON, new Location(getKitPvPWorld(), -11.5, 74, 10.5, -135, 0), "§b§lKit Selector", false);
				npc.setSkeletonType(SkeletonType.WITHER);
				npc.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			}
			{
				NPC npc = NPC.addNPC(NPCType.SPECTATE);
				npc.newEntity(EntityType.SKELETON, new Location(getKitPvPWorld(), 10.5, 74, -11.5, 45, 0), "§e§lSpectate", false);
				npc.setSkeletonType(SkeletonType.WITHER);
				npc.setItemInHand(new ItemStack(Material.ENDER_PEARL));
			}
			{
				NPC npc = NPC.addNPC(NPCType.OMT_SHOP);
				npc.newEntity(EntityType.BLAZE, new Location(getKitPvPWorld(), -4.5, 75, -11.5, 0, 0), "§e§lOMT Shop", false);
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), -2.5, 75, 1, -135, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), -2, 75, -2.5, -45, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), 1.5, 75, -2, 45, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), 1, 75, 1.5, 135, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), -9.25, 73.5, 11.92, 90, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-2).setY(0).setZ(0.4));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.DIAMOND_SWORD, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), -10.25, 73.1, 9.875, 90, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-3.1).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.GOLDEN_APPLE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), -10.1, 73.15, 9.8, 60, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-3.1).setY(0).setZ(-0.25));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.GOLDEN_APPLE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), 9.5, 75, -12.5, 0, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getKitPvPWorld(), 10.5, 74.5, -9.5, 0, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.MASTERIES, new Location(getKitPvPWorld(), 2.5, 76, 8.5, -180, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.DIAMOND_SWORD, 1));
				npcas.setItemName("§c§lMasteries");
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.CRATES, new Location(getKitPvPWorld(), 7.5, 74, 2.5, 90, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.CHEST, 1));
				npcas.setItemName("§6§lCrates");
				npcas.spawn();
			}
			{
				Hologram h = Hologram.addHologram(new Location(getKitPvPWorld(), 7.5, 74, 2.5, 90, 0));
				h.addLine("§a§oComing Soon...");
				h.create();
			}
		}
		
		private void registerLobbyItems(){
			ItemStack[] lobbyitems = new ItemStack[36];
			{
				ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
				BookMeta itemmeta = (BookMeta) item.getItemMeta();
				itemmeta.setDisplayName("§c§nBook of Enchantments");
				itemmeta.addPage("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
				itemmeta.setPage(1, 
				"\n\n          §0§lBook\n"
				+ "         §0§lof \n"
				+ "   §0§lEnchantments");
				itemmeta.setPage(2, 
				"§0§lLightning §0§o(Sword)\n"
				+ " §0§l- Lightning I\n"
				+ "  §0§oOn Hit, 25% chance for a lightning to strike on your opponent.\n"
				+ " §0§l- Lightning II\n"
				+ "  §0§oOn Hit, 33% chance for a lightning to strike on your opponent.\n");
				itemmeta.setPage(3, 
				"§0§lBlindness\n"
				+ " §0§l- Blindness I\n"
				+ "  §0§oOn Hit, giving 2 seconds of Blindness to your opponent.\n"
				+ " §0§l- Blindness II\n"
				+ "  §0§oOn Hit, giving 3 seconds of Blindness to your opponent.\n");
				itemmeta.setPage(4, 
				"§0§lHealing\n"
				+ " §0§l- Healing I\n"
				+ "  §0§oSHIFT + Right Click, giving 4 seconds of Regeneration III to yourself.\n"
				+ " §0§l- Healing II\n"
				+ "  §0§oSHIFT + Right Click, giving 5 seconds of Regeneration III to yourself.\n");
				itemmeta.setPage(5, 
				"§0§lVampire\n"
				+ " §0§l- Vampire I\n"
				+ "  §0§oOn Hit, restoring 1.5 hearts to your health.\n");
				itemmeta.setPage(6, 
				"§0§lMagic\n"
				+ " §0§l- Magic I\n"
				+ "  §0§oOn Hit, giving 4 second of Wither I to your opponent.\n");
				itemmeta.setPage(7, 
				"§0§lKnockup\n"
				+ " §0§l- Knockup I\n"
				+ "  §0§oOn Hit, 50% chance to knockup your opponent in the air.\n");
				itemmeta.setPage(8, 
				"§0§lLightning §0§o(Bow)\n"
				+ " §0§l- Lightning I\n"
				+ "  §0§oOn Hit, striking a lightning on your opponent.\n");
				itemmeta.setPage(9, 
				"§0§lUndeath\n"
				+ " §0§l- Undeath I\n"
				+ "  §0§oOn Hit, spawning 3 Undeath Knights that will attack your opponent.\n"
				+ " §0§l- Undeath II\n"
				+ "  §0§oOn Hit, spawning 3 Undeath Knights and 1 Undeath Archer that will attack your opponent.\n");
				itemmeta.setPage(10, 
				"§0§lExplosive\n"
				+ " §0§l- Explosive I\n"
				+ "  §0§oOn Hit, spawning a TNT at your opponents position.\n");
				itemmeta.setPage(11, 
				"§0§lArrow Split\n"
				+ " §0§l- Arrow Split I\n"
				+ "  §0§oWhen releasing an arrow, 4 more will spawn at its side.\n");
				itemmeta.setPage(12, 
				"§0§lWither Armor\n"
				+ " §0§l- Wither Armor I\n"
				+ "  §0§oWhen getting hit, 5 seconds of Wither II to your opponent.\n");
				itemmeta.setPage(13, 
				"§0§lMolten Armor\n"
				+ " §0§l- Molten Armor I\n"
				+ "  §0§oWhen getting hit, giving 5 seconds of Blindness and 5 seconds of Slowness VI to your opponent.\n");
				itemmeta.setPage(14, 
				"§0§lFire Trail\n"
				+ " §0§l- Fire Trail I\n"
				+ "  §0§oWhen walking, a path of fire will appear behind you.\n");
				itemmeta.setPage(15, 
				"§0§lLight\n"
				+ " §0§l- Light I\n"
				+ "  §0§oWhen walking over water, replacing nearby blocks with Cobblestone.\n");
				itemmeta.setPage(16, 
				"§0§lFly\n"
				+ " §0§l- Fly I\n"
				+ "  §0§oSHIFT, ability to fly!\n");
				itemmeta.setPage(17, 
				"§0§lArthropods\n"
				+ " §0§l- Arthropods I\n"
				+ "  §0§oOn Hit, 16.67% chance for a Spider to spawn on your opponent.\n"
				+ " §0§l- Arthropods II\n"
				+ "  §0§oOn Hit, 20% chance for a Spider Jockey to spawn on your opponent.\n");
				itemmeta.setPage(18,
				" §0§l- Arthropods III\n"
				+ "  §0§oOn Hit, 25% chance for a Spider and a Spider Jockey to spawn on your opponent.\n");
				itemmeta.setPage(19, 
				"§0§lWither\n"
				+ " §0§l- Wither I\n"
				+ "  §0§oRight Click, shooting 4 Wither Skulls from your position. Price: 1 Soul. Killing an opponent will give you a Soul.\n");
				itemmeta.setPage(20,
				"§0§lBarrier\n"
				+ " §0§l- Barrier I\n"
				+ "  §0§oRight Click, spawning a force shield around you, giving 5 seconds of Resistance.\n"
				+ " §0§l- Barrier II\n"
				+ "  §0§oRight Click, spawning a force shield around you, giving 5 seconds of Resistance II.\n");
				itemmeta.setPage(21,
				"§0§lTNT\n"
				+ " §0§l- TNT I\n"
				+ "  §0§oRight Click, shooting a TNT where you're looking at.\n");
				itemmeta.setPage(22,
				"§0§lFish Attack\n"
				+ " §0§l- Fish Attack I\n"
				+ "  §0§oRight Click, giving 4 seconds of Poison III to all nearby opponents.\n");
				itemmeta.setPage(23,
				"§0§lShield\n"
				+ " §0§l- Shield I\n"
				+ "  §0§oRight Click, giving 10 seconds of Resistance to yourself.\n"
				+ " §0§l- Shield II\n"
				+ "  §0§oRight Click, giving 12 seconds of Resistance II to yourself.\n");
				itemmeta.setPage(24,
				"§0§lTrade\n"
				+ " §0§l- Trade I\n"
				+ "  §0§oOn Hit, removing this item and stealing your opponents weapon.\n");
				itemmeta.setPage(25,
				"§0§lHealing Kit\n"
				+ " §0§l- Healing Kit I\n"
				+ "  §0§oRight Click, removing this item and restoring you to full health.\n");
				itemmeta.setPage(26,
				"§0§lBlock Explosion\n"
				+ " §0§l- Block Explosion I\n"
				+ "  §0§oRight Click, creating an explosion of blocks which will blind and slow nearby opponents.\n");
				itemmeta.setPage(27,
				"§0§lUndeath Summon\n"
				+ " §0§l- Undeath Summon I\n"
				+ "  §0§oRight Click, spawning two baby pigmans that will kill for you!\n");
				itemmeta.setPage(28,
				"§0§lPaintballs\n"
				+ " §0§l- Paintballs I\n"
				+ "  §0§oRight Click, creating an area which will give an effect specified to its color.\n  §0§oLeft Click, change color.\n");
				itemmeta.setAuthor("§6§lOrbitMines§c§lKitPvP");
				item.setItemMeta(itemmeta);
				lobbyitems[0] = item;
				
			}
			{
				ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§d§nAchievements");
				item.setItemMeta(itemmeta);
				lobbyitems[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§3§nServer Selector");
				item.setItemMeta(itemmeta);
				lobbyitems[4] = item;
			}
			{
				ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§a§nBoosters");
				item.setItemMeta(itemmeta);
				lobbyitems[5] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				lobbyitems[7] = item;
			}
			{
				ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§b§nKit Selector");
				item.setItemMeta(itemmeta);
				lobbyitems[8] = item;
			}
			
			this.lobbyitems = lobbyitems;
		}
	
		private void registerSpectatorItems(){
			ItemStack[] spectatoritems = new ItemStack[36];
			
			{
				ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§3§nBack to the Lobby");
				item.setItemMeta(itemmeta);
				spectatoritems[3] = item;
			}
			{
				ItemStack item = new ItemStack(Material.NAME_TAG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§e§nTeleporter");
				item.setItemMeta(itemmeta);
				spectatoritems[5] = item;
			}
			
			this.spectatoritems = spectatoritems;
		}
	}

	public static class CreativeServer {
		
		private World creativeworld;
		private World plotworld;
		private Location spawn;
		private List<Plot> plots;
		private int lastplotid;
		private List<Block> beacons;
		
		public CreativeServer(){
			ServerStorage.server = Server.CREATIVE;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §brienk222";
			ServerStorage.creative = this;
			this.creativeworld = Bukkit.getWorld("CreativeLobby");
			ServerStorage.lobbyworld = this.creativeworld;
			this.plotworld = Bukkit.getWorld("Creative");
			this.spawn = new Location(getCreativeWorld(), 0, 74, 0, 45, 0);
			this.lastplotid = ConfigManager.plots.getInt("LastPlotID");
			this.beacons = Arrays.asList(getCreativeWorld().getBlockAt(new Location(getCreativeWorld(), -5, 74, 12)), getCreativeWorld().getBlockAt(new Location(getCreativeWorld(), -13, 74, 4)));
			
			loadPlots();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n    §7Restarting §d§lCreative§7 Server...");
			}
			
			new BukkitRunnable(){
				public void run(){
					Utils.removeAllEntitiesIF();
					spawnNPCs();
				}
			}.runTaskLater(Start.getInstance(), 100);
		}

		public World getCreativeWorld() {
			return creativeworld;
		}
		public void setCreativeWorld(World creativeworld) {
			this.creativeworld = creativeworld;
		}

		public World getPlotWorld() {
			return plotworld;
		}
		public void setPlotWorld(World plotworld) {
			this.plotworld = plotworld;
		}

		public Location getSpawn() {
			return spawn;
		}
		public void setSpawn(Location spawn) {
			this.spawn = spawn;
		}

		public List<Plot> getPlots() {
			return plots;
		}
		public void setPlots(List<Plot> plots) {
			this.plots = plots;
		}

		public int getLastPlotID() {
			return lastplotid;
		}
		public void setLastPlotID(int lastplotid) {
			this.lastplotid = lastplotid;
			
			ConfigManager.plots.set("LastPlotID", this.lastplotid);
			ConfigManager.savePlots();
		}

		public List<Block> getBeacons() {
			return beacons;
		}
		public void setBeacons(List<Block> beacons) {
			this.beacons = beacons;
		}
		
		private void loadPlots(){
			List<Plot> plots = new ArrayList<Plot>();
			if(ConfigManager.plots.contains("plots")){
				for(String stringplotid : ConfigManager.plots.getConfigurationSection("plots").getKeys(false)){
					Plot plot = new Plot(Integer.parseInt(stringplotid));
					plot.load();
					plots.add(plot);
				}
			}
			this.plots = plots;
		}
		
		private void spawnNPCs(){
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_SELECTOR, new Location(getCreativeWorld(), 7.5, 74, -7.5, 45, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.setItemName("§3§lServer Selector");
				npcas.spawn();
			}
			{
				NPC npc = NPC.addNPC(NPCType.OMT_SHOP);
				npc.newEntity(EntityType.BLAZE, new Location(getCreativeWorld(), 4.5, 74, -9.5, 0, 0), "§e§lOMT Shop", false);
			}
			{
				Hologram h = new Hologram(new Location(getCreativeWorld(), -6.5, 75, 6.5, -50, 0));
				h.addLine("§d§lCreative");
				h.create();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getCreativeWorld(), -6.75, 75.5, 6.25, -50, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-1.1).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.WOOD_AXE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getCreativeWorld(), -6.75, 75.5, 7.25, 140, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-1.1).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setItemInHand(new ItemStack(Material.WOOD_AXE, 1));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.PLOT_INFO, new Location(getCreativeWorld(), 9.5, 74, -4.5, 90, 0));
				npcas.setBodyPose(EulerAngle.ZERO.setX(0.1).setY(0).setZ(0));
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.15).setY(0).setZ(0));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0).setY(0).setZ(0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setHelmet(Utils.addColor(new ItemStack(Material.LEATHER_HELMET), Color.FUCHSIA));
				npcas.setChestplate(Utils.addColor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.FUCHSIA));
				npcas.setLeggings(Utils.addColor(new ItemStack(Material.LEATHER_LEGGINGS), Color.FUCHSIA));
				npcas.setBoots(Utils.addColor(new ItemStack(Material.LEATHER_BOOTS), Color.FUCHSIA));
				npcas.setItemInHand(new ItemStack(Material.WOOD_AXE, 1));
				npcas.spawn();
			}
		}
	}

	public static class SurvivalServer {
		
		private World survivalworld;
		private World lobbyworld;
		private Location spawn;
		private List<Location> pvpspawns;
		private List<Region> regions;
		private RegionInv regionteleporter;
		private HashMap<World, List<Block>> worldportals;
		private List<StringInt> topmoney;
		private List<ShopSign> shopsigns;
		private List<Warp> warps;
		private Location tutorials;
		
		public SurvivalServer(){
			ServerStorage.server = Server.SURVIVAL;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §brienk222";
			ServerStorage.survival = this;
			this.lobbyworld = Bukkit.getWorld("SurvivalLobby");
			ServerStorage.lobbyworld = this.lobbyworld;
			this.survivalworld = Bukkit.getWorld("SurvivalWorld");
			this.spawn = new Location(getLobbyWorld(), 0.5, 74, 0.5, 0, 0);
			this.pvpspawns = Arrays.asList(new Location(getLobbyWorld(), 4, 68, 51, 45, 0), new Location(getLobbyWorld(), 20, 69, 48, 75, 0), new Location(getLobbyWorld(), 14, 68, 54, 170, 0));
			this.setTopMoney(new ArrayList<StringInt>());
			this.shopsigns = ShopSign.readFromConfig();
			this.warps = Warp.readFromConfig();
			this.tutorials = new Location(getLobbyWorld(), -48.5, 79, -0.5, 180, 0);
			
			registerWorldPortals();
			registerRegions();
			
			this.regionteleporter = new RegionInv();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n    §7Restarting §a§lSurvival§7 Server...");
			}
			
			new BukkitRunnable(){
				public void run(){
					Utils.removeEntities(getLobbyWorld());
					spawnNPCs();
				}
			}.runTaskLater(Start.getInstance(), 100);
		}

		public World getSurvivalWorld() {
			return survivalworld;
		}
		public void getSurvivalWorld(World survivalworld) {
			this.survivalworld = survivalworld;
		}

		public World getLobbyWorld() {
			return lobbyworld;
		}
		public void getLobbyWorld(World lobbyworld) {
			this.lobbyworld = lobbyworld;
		}

		public Location getSpawn() {
			return spawn;
		}
		public void setSpawn(Location spawn) {
			this.spawn = spawn;
		}

		public List<Location> getPvPSpawns() {
			return pvpspawns;
		}
		public void setPvPSpawns(List<Location> pvpspawns) {
			this.pvpspawns = pvpspawns;
		}

		public List<Region> getRegions() {
			return regions;
		}
		public void setRegions(List<Region> regions) {
			this.regions = regions;
		}

		public RegionInv getRegionTeleporter() {
			return regionteleporter;
		}
		public void setRegionTeleporter(RegionInv regionteleporter) {
			this.regionteleporter = regionteleporter;
		}
		public void openRegionTeleporter(OMPlayer omp){
			this.regionteleporter.open(omp.getPlayer());
		}

		public HashMap<World, List<Block>> getWorldPortals(){
			return worldportals;
		}
		public void setWorldPortals(HashMap<World, List<Block>> worldportals){
			this.worldportals = worldportals;
		}
		public void setWorldPortal(World world, List<Block> worldportal){
			this.worldportals.put(world, worldportal);
		}

		public List<StringInt> getTopMoney() {
			return topmoney;
		}
		public void setTopMoney(List<StringInt> topmoney) {
			this.topmoney = topmoney;
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

		public Location getTutorials() {
			return tutorials;
		}
		public void setTutorials(Location tutorials) {
			this.tutorials = tutorials;
		}
		
		private void spawnNPCs(){
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_SELECTOR, new Location(getLobbyWorld(), 5, 72, 14, 180, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.setItemName("§3§lServer Selector");
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.REGION_TELEPORTER, new Location(getLobbyWorld(), 13, 68, -8, 0, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.EYE_OF_ENDER, 1));
				npcas.setItemName("§a§lRegion Teleporter");
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.PVP_AREA, new Location(getLobbyWorld(), -5.5, 74, 7.5, -90, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.5));
				npcas.setHelmet(Utils.setDurability(new ItemStack(Material.SKULL_ITEM), 2));
				npcas.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
				npcas.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
				npcas.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
				npcas.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
				npcas.setCustomName("§2§lPvP Area");
				npcas.setCustomNameVisible(true);
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getLobbyWorld(), -5, 74.5, 5.5, -45, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.1));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(0.5));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(-0.5));
				npcas.setHelmet(Utils.setDurability(new ItemStack(Material.SKULL_ITEM), 2));
				npcas.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
				npcas.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
				npcas.setBoots(new ItemStack(Material.GOLD_BOOTS));
				npcas.setItemInHand(new ItemStack(Material.GOLD_SWORD));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getLobbyWorld(), -4.2, 77, 11.2, -145, 25));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHeadPose(EulerAngle.ZERO.setX(-0.1));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.5));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(0.5));
				npcas.setHelmet(Utils.setDurability(new ItemStack(Material.SKULL_ITEM), 2));
				npcas.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
				npcas.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
				npcas.setBoots(new ItemStack(Material.GOLD_BOOTS));
				npcas.setItemInHand(new ItemStack(Material.GOLD_SWORD));
				npcas.spawn();
			}
			{
				NPC npc = NPC.addNPC(NPCType.OMT_SHOP);
				npc.newEntity(EntityType.BLAZE, new Location(getLobbyWorld(), 7, 71, 0.5, 0, 0), "§e§lOMT Shop", false);
			}
			{
				NPC npc = NPC.addNPC(NPCType.TUTORIALS);
				npc.newEntity(EntityType.VILLAGER, new Location(getLobbyWorld(), 16.5, 70, 0.5, 90, 0), "§f§lTutorials", false);
				npc.setVillagerProfession(Profession.LIBRARIAN);
			}
			{
				NPC npc = NPC.addNPC(NPCType.SPAWN);
				npc.newEntity(EntityType.VILLAGER, new Location(getLobbyWorld(), -48.5, 79, -10.5, 0, 0), "§f§lBack to Spawn", false);
				npc.setVillagerProfession(Profession.LIBRARIAN);
			}
			{
				NPC npc = NPC.addNPC(NPCType.CLAIM_TUTORIAL);
				npc.newEntity(EntityType.SKELETON, new Location(getLobbyWorld(), -48.5, 79, -3.5, 180, 0), "", true);
				npc.addMoveLocation(new Location(getLobbyWorld(), -48.5, 79, -3.5, 180, 0), 10);
				npc.addMoveLocation(new Location(getLobbyWorld(), -53.5, 79, -5.5, 135, 45), 10);
				npc.addMoveLocation(new Location(getLobbyWorld(), -53, 79, -13.5, 180, 0), 0);
				npc.addMoveLocation(new Location(getLobbyWorld(), -46, 79, -15.5, -65, 45), 10);
				npc.addMoveLocation(new Location(getLobbyWorld(), -44, 79, -7.5, 0, 0), 0);
			}
			{
				Hologram h = new Hologram(new Location(getLobbyWorld(), -42.5, 79, -4.5));
				h.addLine("§6§lChest Shop Tutorial");
				h.create();
			}
		}
		

		private void registerWorldPortals(){
			this.worldportals = new HashMap<World, List<Block>>();
			setWorldPortal(getLobbyWorld(), Utils.getBlocksBetween(new Location(getLobbyWorld(), 10, 72, -13), new Location(getLobbyWorld(), 14, 68, -13)));
		}
		
		private void registerRegions(){
			World w = this.survivalworld;
			this.regions = new ArrayList<Region>();
			
			this.regions.add(new Region(1, new Location(w, -445.5, 67, -279.5, -70, -90), Biome.BIRCH_FOREST, 22));
			this.regions.add(new Region(2, new Location(w, -445.5, 84, -1279.5, -70, -90), Biome.FOREST_HILLS, 21));
			this.regions.add(new Region(3, new Location(w, -445.5, 63, -2279.5, -70, -90), Biome.SWAMPLAND, 20));
			this.regions.add(new Region(4, new Location(w, -445.5, 72, -3279.5, -70, -90), Biome.EXTREME_HILLS, 19));
			this.regions.add(new Region(5, new Location(w, -445.5, 63, -4279.5, -70, -90), Biome.RIVER, 18));
			this.regions.add(new Region(6, new Location(w, 1055.5, 68, -279.5, -70, -90), Biome.SAVANNA, 13));
			this.regions.add(new Region(7, new Location(w, 2555.5, 63, -279.5, -70, -90), Biome.DEEP_OCEAN, 4));
			this.regions.add(new Region(8, new Location(w, -445.5, 63, 721.5, -70, -90), Biome.DEEP_OCEAN, 23));
			this.regions.add(new Region(9, new Location(w, -445.5, 63, 1721.5, -70, -90), Biome.DEEP_OCEAN, 24));
			this.regions.add(new Region(10, new Location(w, -445.5, 80, 2721.5, -70, -90), Biome.FOREST_HILLS, 25));
			this.regions.add(new Region(11, new Location(w, -445.5, 63, 3721.5, -70, -90), Biome.BEACH, 26));
			this.regions.add(new Region(12, new Location(w, -1945.5, 69, -279.5, -70, -90), Biome.FOREST, 31));
			this.regions.add(new Region(13, new Location(w, -3445.5, 64, -279.5, -70, -90), Biome.ROOFED_FOREST, 40));
			this.regions.add(new Region(14, new Location(w, 1055.5, 63, -1279.5, -70, -90), Biome.DEEP_OCEAN, 12));
			this.regions.add(new Region(15, new Location(w, 2555.5, 70, -1279.5, -70, -90), Biome.SAVANNA, 3));
			this.regions.add(new Region(16, new Location(w, 1055.5, 71, -2279.5, -70, -90), Biome.TAIGA, 11));
			this.regions.add(new Region(17, new Location(w, 2555.5, 63, -2279.5, -70, -90), Biome.OCEAN, 2));
			this.regions.add(new Region(18, new Location(w, 1055.5, 63, -3279.5, -70, -90), Biome.OCEAN, 10));
			this.regions.add(new Region(19, new Location(w, 2555.5, 63, -3279.5, -70, -90), Biome.OCEAN, 1));
			this.regions.add(new Region(20, new Location(w, 1055.5, 67, -4279.5, -70, -90), Biome.FOREST_HILLS, 9));
			this.regions.add(new Region(21, new Location(w, 2555.5, 71, -4279.5, -70, -90), Biome.SAVANNA, 0));
			this.regions.add(new Region(22, new Location(w, 1055.5, 63, 721.5, -70, -90), Biome.OCEAN, 14));
			this.regions.add(new Region(23, new Location(w, 2555.5, 65, 721.5, -70, -90), Biome.BEACH, 5));
			this.regions.add(new Region(24, new Location(w, 1055.5, 66, 1721.5, -70, -90), Biome.SWAMPLAND, 15));
			this.regions.add(new Region(25, new Location(w, 2555.5, 63, 1721.5, -70, -90), Biome.DESERT, 6));
			this.regions.add(new Region(26, new Location(w, 1055.5, 70, 2721.5, -70, -90), Biome.FOREST, 16));
			this.regions.add(new Region(27, new Location(w, 2555.5, 63, 2721.5, -70, -90), Biome.DEEP_OCEAN, 7));
			this.regions.add(new Region(28, new Location(w, 1055.5, 73, 3721.5, -70, -90), Biome.COLD_TAIGA, 17));
			this.regions.add(new Region(29, new Location(w, 2555.5, 66, 3721.5, -70, -90), Biome.DEEP_OCEAN, 8));
			this.regions.add(new Region(30, new Location(w, -1945.5, 65, 721.5, -70, -90), Biome.SWAMPLAND, 32));
			this.regions.add(new Region(31, new Location(w, -3445.5, 64, 721.5, -70, -90), Biome.PLAINS, 41));
			this.regions.add(new Region(32, new Location(w, -1945.5, 80, 1721.5, -70, -90), Biome.FOREST, 33));
			this.regions.add(new Region(33, new Location(w, -3445.5, 86, 1721.5, -70, -90), Biome.EXTREME_HILLS, 42));
			this.regions.add(new Region(34, new Location(w, -1945.5, 66, 2721.5, -70, -90), Biome.FOREST, 34));
			this.regions.add(new Region(35, new Location(w, -3445.5, 68, 2721.5, -70, -90), Biome.ICE_PLAINS, 43));
			this.regions.add(new Region(36, new Location(w, -1945.5, 63, 3721.5, -70, -90), Biome.RIVER, 35));
			this.regions.add(new Region(37, new Location(w, -3445.5, 71, 3721.5, -70, -90), Biome.TAIGA, 44));
			this.regions.add(new Region(38, new Location(w, -1945.5, 67, -1279.5, -70, -90), Biome.TAIGA, 30));
			this.regions.add(new Region(39, new Location(w, -3445.5, 66, -1279.5, -70, -90), Biome.PLAINS, 39));
			this.regions.add(new Region(40, new Location(w, -1945.5, 71, -2279.5, -70, -90), Biome.PLAINS, 29));
			this.regions.add(new Region(41, new Location(w, -3445.5, 72, -2279.5, -70, -90), Biome.BIRCH_FOREST, 38));
			this.regions.add(new Region(42, new Location(w, -1945.5, 64, -3279.5, -70, -90), Biome.BEACH, 28));
			this.regions.add(new Region(43, new Location(w, -3445.5, 70, -3279.5, -70, -90), Biome.PLAINS, 37));
			this.regions.add(new Region(44, new Location(w, -1945.5, 67, -4279.5, -70, -90), Biome.PLAINS, 27));
			this.regions.add(new Region(45, new Location(w, -3445.5, 63, -4279.5, -70, -90), Biome.TAIGA, 36));
		}
	}

	public static class SkyBlockServer {
		
		private World skyblockworld;
		private World skyblocknetherworld;
		private World lobbyworld;
		private Location spawn;
		private List<Island> islands;
		private List<Challenge> challenges;
		private int totalislands;
		private Location lastlocation;
		
		public SkyBlockServer(){
			ServerStorage.server = Server.SKYBLOCK;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §bsharewoods\n§b§lMod §beekhoorn2000";
			ServerStorage.skyblock = this;
			this.lobbyworld = Bukkit.getWorld("SkyBlockLobby");
			ServerStorage.lobbyworld = this.lobbyworld;
			this.skyblockworld = Bukkit.getWorld("SkyBlock");
			this.skyblocknetherworld = Bukkit.getWorld("SkyBlock_nether");
			this.spawn = new Location(getLobbyWorld(), 0.5, 74, 0.5, 0, 0);
			this.totalislands = ConfigManager.islands.getInt("TotalIslands");
			this.lastlocation = Utils.getLocationFromString(ConfigManager.islands.getString("LastLocation"));
			
			Utils.removeEntities(this.lobbyworld);
			spawnNPCs();
			registerIslands();
			registerChallenges();
			registerKits();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n    §7Restarting §5§lSkyBlock§7 Server...");
			}
		}

		public World getLobbyWorld() {
			return lobbyworld;
		}
		public void setLobbyWorld(World lobbyworld) {
			this.lobbyworld = lobbyworld;
		}

		public World getSkyblockWorld() {
			return skyblockworld;
		}
		public void setSkyblockWorld(World skyblockworld) {
			this.skyblockworld = skyblockworld;
		}

		public World getSkyblockNetherWorld() {
			return skyblocknetherworld;
		}
		public void setSkyblockNetherWorld(World skyblocknetherworld) {
			this.skyblocknetherworld = skyblocknetherworld;
		}

		public Location getSpawn() {
			return spawn;
		}
		public void setSpawn(Location spawn) {
			this.spawn = spawn;
		}

		public List<Island> getIslands() {
			return islands;
		}
		public void setIslands(List<Island> islands) {
			this.islands = islands;
		}

		public List<Challenge> getChallenges() {
			return challenges;
		}
		public void setChallenges(List<Challenge> challenges) {
			this.challenges = challenges;
		}

		public int getTotalIslands() {
			return totalislands;
		}
		public void setTotalIslands(int totalislands) {
			this.totalislands = totalislands;
			
			ConfigManager.islands.set("TotalIslands", this.totalislands);
			ConfigManager.saveIslands();
		}

		public Location getLastLocation() {
			return lastlocation;
		}
		public void setLastLocation(Location lastlocation) {
			this.lastlocation = lastlocation;
		}
		
		private void spawnNPCs(){
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_SELECTOR, new Location(getLobbyWorld(), 3.5, 76, 5.5, 0, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.setItemName("§3§lServer Selector");
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getLobbyWorld(), 2.5, 74, 12.5, -12, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75));
				npcas.setItemInHand(new ItemStack(Material.GRASS));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getLobbyWorld(), 3.25, 73.75, 12.13, -38, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75));
				npcas.setItemInHand(new ItemStack(Material.GRASS));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getLobbyWorld(), 5, 73.75, 11.79, 50, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.75));
				npcas.setItemInHand(new ItemStack(Material.GRASS));
				npcas.spawn();
			}
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.NORMAL, new Location(getLobbyWorld(), 3.85, 75.1, 12.32, 47, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setHeadPose(EulerAngle.ZERO.setX(0.45));
				npcas.setLeftArmPose(EulerAngle.ZERO.setX(1.25));
				npcas.setLeftLegPose(EulerAngle.ZERO.setX(-0.65));
				npcas.setRightArmPose(EulerAngle.ZERO.setX(-0.25));
				npcas.setRightLegPose(EulerAngle.ZERO.setX(1.1));
				npcas.setHelmet(new ItemStack(Material.LEATHER_HELMET));
				npcas.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				npcas.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
				npcas.setBoots(new ItemStack(Material.LEATHER_BOOTS));
				npcas.spawn();
			}
			{
				NPC npc = NPC.addNPC(NPCType.OMT_SHOP);
				npc.newEntity(EntityType.BLAZE, new Location(getLobbyWorld(), -2.5, 75, -5.5, 0, 0), "§e§lOMT Shop", false);
			}
			{
				Hologram h = new Hologram(new Location(getLobbyWorld(), 0.5, 71.5, 20.5, 180, 0));
				h.addLine("§dJump down to §d§lPlay§d!");
				h.create();
			}
		}
		
		private void registerIslands(){
			this.islands = new ArrayList<Island>();
			
			if(ConfigManager.islands.contains("islands")){
				for(String islandidstring : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
					int islandid = Integer.parseInt(islandidstring);
					boolean nethergenerated = false;
					if(ConfigManager.islands.contains("islands." + islandid + ".NetherGenerated")){
						nethergenerated = ConfigManager.islands.getBoolean("islands." + islandid + ".NetherGenerated");
					}
					
					this.islands.add(new Island(islandid, Utils.getLocationFromString(ConfigManager.islands.getString("islands." + islandid + ".IslandLocation")), ConfigManager.islands.getString("islands." + islandid + ".CreatedDate"), UUID.fromString(ConfigManager.islands.getString("islands." + islandid + ".Players.Owner")), Utils.getUUIDList(ConfigManager.islands.getStringList("islands." + islandid + ".Players.Members")), Boolean.parseBoolean(ConfigManager.islands.getString("islands." + islandid + ".TeleportEnabled")), Boolean.parseBoolean(ConfigManager.islands.getString("islands." + islandid + ".IslandProtection")), nethergenerated));
				}
			}
		}
		
		private void registerChallenges(){
			this.challenges = new ArrayList<Challenge>();
			
			// Gather Challenges \\
			Challenge.addChallenge(0, new ItemData("Cobblestone Generator", 1, Material.COBBLESTONE, 0), Arrays.asList(new ItemData("32 Cobblestone", 32, Material.COBBLESTONE, 0)), Arrays.asList(new ItemData("1 Birch Sapling", 1, Material.SAPLING, 2)), null);
			Challenge.addChallenge(1, new ItemData("Apples", 1, Material.APPLE, 0), Arrays.asList(new ItemData("1 Apple", 1, Material.APPLE, 0)), Arrays.asList(new ItemData("1 Sugarcane", 1, Material.SUGAR_CANE, 0)), null);
			Challenge.addChallenge(2, new ItemData("Jack the Lumberjack", 1, Material.LOG, 0), Arrays.asList(new ItemData("25 Oak Logs", 25, Material.LOG, 0)), Arrays.asList(new ItemData("1 Melon Seed", 1, Material.MELON_SEEDS, 0)), null);
			Challenge.addChallenge(3, new ItemData("More Smoothness", 1, Material.SMOOTH_BRICK, 0), Arrays.asList(new ItemData("40 Stone Bricks", 40, Material.SMOOTH_BRICK, 0)), Arrays.asList(new ItemData("1 Iron Ingot", 1, Material.IRON_INGOT, 0)), 0);
			Challenge.addChallenge(4, new ItemData("Fishing Time!", 1, Material.RAW_FISH, 0), Arrays.asList(new ItemData("10 Raw Fish", 10, Material.RAW_FISH, 0)), Arrays.asList(new ItemData("2 Leather", 2, Material.LEATHER, 0)), 1);
			Challenge.addChallenge(5, new ItemData("Chop Chop", 1, Material.LOG, 1), Arrays.asList(new ItemData("32 Oak Logs", 32, Material.LOG, 0), new ItemData("32 Birch Logs", 32, Material.LOG, 2), new ItemData("32 Spruce Logs", 32, Material.LOG, 1)), Arrays.asList(new ItemData("16 Clay", 16, Material.CLAY_BALL, 0)), 2);
			Challenge.addChallenge(6, new ItemData("Navigation", 1, Material.COMPASS, 0), Arrays.asList(new ItemData("1 Compass", 1, Material.COMPASS, 0)), Arrays.asList(new ItemData("1 Pumpkin Seed", 1, Material.PUMPKIN_SEEDS, 0)), 3);
			Challenge.addChallenge(7, new ItemData("Librarian", 1, Material.BOOKSHELF, 0), Arrays.asList(new ItemData("2 Bookshelfs", 2, Material.BOOKSHELF, 0)), Arrays.asList(new ItemData("3 Gold Ore", 3, Material.GOLD_ORE, 0)), 4);
			Challenge.addChallenge(8, new ItemData("The Dark Forest", 1, Material.LOG_2, 1), Arrays.asList(new ItemData("256 Dark Oak Logs", 256, Material.LOG_2, 1)), Arrays.asList(new ItemData("1 Wolf Spawn Egg", 1, Material.MONSTER_EGG, 95)), 5);
			Challenge.addChallenge(9, new ItemData("It's Time", 1, Material.WATCH, 0), Arrays.asList(new ItemData("1 Clock", 1, Material.WATCH, 0)), Arrays.asList(new ItemData("1 Pig Spawn Egg", 1, Material.MONSTER_EGG, 90)), 6, 7);
			Challenge.addChallenge(10, new ItemData("Stained Clay", 1, Material.STAINED_CLAY, 11), Arrays.asList(new ItemData("28 Blue Stained Clay", 28, Material.STAINED_CLAY, 11)), Arrays.asList(new ItemData("1 Mycelium", 1, Material.MYCEL, 0)), 7, 8);
			Challenge.addChallenge(11, new ItemData("Sheep Shearing", 1, Material.WOOL, 0), Arrays.asList(new ItemData("50 White Wool", 50, Material.WOOL, 0)), Arrays.asList(new ItemData("3 Gravel", 3, Material.GRAVEL, 0)), 9);
			Challenge.addChallenge(12, new ItemData("Windows", 1, Material.STAINED_GLASS, 11), Arrays.asList(new ItemData("16 Blue Stained Glass", 16, Material.STAINED_GLASS, 11)), Arrays.asList(new ItemData("2 Obsidian", 2, Material.OBSIDIAN, 0)), 10);
			Challenge.addChallenge(13, new ItemData("Wood Factory", 1, Material.LOG_2, 0), Arrays.asList(new ItemData("64 Oak Logs", 64, Material.LOG, 0), new ItemData("64 Birch Logs", 64, Material.LOG, 2), new ItemData("64 Spruce Logs", 64, Material.LOG, 1), new ItemData("64 Dark Oak Logs", 64, Material.LOG_2, 1), new ItemData("64 Jungle Logs", 64, Material.LOG, 3), new ItemData("64 Acacia Logs", 64, Material.LOG_2, 0)), Arrays.asList(new ItemData("1 Cow Spawn Egg", 1, Material.MONSTER_EGG, 92)), 11, 12);
			Challenge.addChallenge(14, new ItemData("'Lucky' Fishing", 1, Material.NAME_TAG, 0), Arrays.asList(new ItemData("3 Name Tags", 3, Material.NAME_TAG, 0)), Arrays.asList(new ItemData("1 Diamond Ore", 1, Material.DIAMOND_ORE, 0)), 13);
			
			// Farm Challenges \\
			Challenge.addChallenge(15, new ItemData("Melons", 1, Material.MELON, 0), Arrays.asList(new ItemData("50 Melons", 50, Material.MELON, 0)), Arrays.asList(new ItemData("1 Spruce Sapling", 1, Material.SAPLING, 1)), null);
			Challenge.addChallenge(16, new ItemData("Halloween Party", 1, Material.PUMPKIN, 0), Arrays.asList(new ItemData("32 Pumpkins", 32, Material.PUMPKIN, 0)), Arrays.asList(new ItemData("1 Brown Mushroom", 1, Material.BROWN_MUSHROOM, 0)), null);
			Challenge.addChallenge(17, new ItemData("Sugarcane", 1, Material.SUGAR_CANE, 0), Arrays.asList(new ItemData("55 Sugarcane", 55, Material.SUGAR_CANE, 0)), Arrays.asList(new ItemData("1 Sand", 1, Material.SAND, 0)), null);
			Challenge.addChallenge(18, new ItemData("Melon Blocks?!", 1, Material.MELON_BLOCK, 0), Arrays.asList(new ItemData("32 Melon Blocks", 32, Material.MELON_BLOCK, 0)), Arrays.asList(new ItemData("1 Dirt", 1, Material.DIRT, 0)), 15);
			Challenge.addChallenge(19, new ItemData("Mushroom Hunting", 1, Material.MUSHROOM_SOUP, 0), Arrays.asList(new ItemData("30 Mushroom Stew", 30, Material.MUSHROOM_SOUP, 0)), Arrays.asList(new ItemData("1 Ice Block", 1, Material.ICE, 0)), 16);
			Challenge.addChallenge(20, new ItemData("Bacon", 1, Material.GRILLED_PORK, 0), Arrays.asList(new ItemData("40 Cooked Pork Chop", 40, Material.GRILLED_PORK, 0)), Arrays.asList(new ItemData("1 Cactus", 1, Material.CACTUS, 0)), 17);
			Challenge.addChallenge(21, new ItemData("Rabbits", 1, Material.CARROT_ITEM, 0), Arrays.asList(new ItemData("100 Carrots", 100, Material.CARROT_ITEM, 0)), Arrays.asList(new ItemData("1 Dark Oak Sapling", 1, Material.SAPLING, 5)), 18);
			Challenge.addChallenge(22, new ItemData("Baker", 1, Material.BREAD, 0), Arrays.asList(new ItemData("30 Bread", 30, Material.BREAD, 0)), Arrays.asList(new ItemData("1 Cocoa Bean", 1, Material.INK_SACK, 3)), 19);
			Challenge.addChallenge(23, new ItemData("Potatoes", 1, Material.BAKED_POTATO, 0), Arrays.asList(new ItemData("100 Baked Potatoes", 100, Material.BAKED_POTATO, 0)), Arrays.asList(new ItemData("1 Acacia Sapling", 1, Material.SAPLING, 4)), 20);
			Challenge.addChallenge(24, new ItemData("Cookie Monster", 1, Material.COOKIE, 0), Arrays.asList(new ItemData("200 Cookies", 200, Material.COOKIE, 0)), Arrays.asList(new ItemData("5 Lapis Lazuli Ore", 5, Material.LAPIS_ORE, 0)), 21, 22);
			Challenge.addChallenge(25, new ItemData("Cactus", 1, Material.CACTUS, 0), Arrays.asList(new ItemData("100 Cacti", 100, Material.CACTUS, 0)), Arrays.asList(new ItemData("1 Slimeball", 1, Material.SLIME_BALL, 0)), 22, 23);
			Challenge.addChallenge(26, new ItemData("KFC Delivery", 1, Material.COOKED_CHICKEN, 0), Arrays.asList(new ItemData("60 Cooked Chicken", 60, Material.COOKED_CHICKEN, 0)), Arrays.asList(new ItemData("1 Spawn Sheep Egg", 1, Material.MONSTER_EGG, 91)), 24);
			Challenge.addChallenge(27, new ItemData("Steak", 1, Material.COOKED_BEEF, 0), Arrays.asList(new ItemData("80 Steak", 80, Material.COOKED_BEEF, 0)), Arrays.asList(new ItemData("1 Mossy Cobblestone", 1, Material.MOSSY_COBBLESTONE, 0)), 25);
			Challenge.addChallenge(28, new ItemData("Grandmother's Kitchen", 1, Material.PUMPKIN_PIE, 0), Arrays.asList(new ItemData("125 Pumpkin Pies", 125, Material.PUMPKIN_PIE, 0)), Arrays.asList(new ItemData("1 Soul Sand", 1, Material.SOUL_SAND, 0)), 26, 27);
			Challenge.addChallenge(29, new ItemData("Cakes", 1, Material.CAKE, 0), Arrays.asList(new ItemData("3 Cakes", 3, Material.CAKE, 0)), Arrays.asList(new ItemData("1 Emerald Ore", 1, Material.EMERALD_ORE, 0)), 28);
			
			// Mob Challenges \\
			Challenge.addChallenge(30, new ItemData("Skeletons", 1, Material.BONE, 0), Arrays.asList(new ItemData("150 Bones", 150, Material.BONE, 0)), Arrays.asList(new ItemData("1 Jungle Sapling", 1, Material.SAPLING, 3)), null);
			Challenge.addChallenge(31, new ItemData("Arrows!", 1, Material.ARROW, 0), Arrays.asList(new ItemData("200 Arrows", 200, Material.ARROW, 0)), Arrays.asList(new ItemData("64 Cobblestone", 64, Material.COBBLESTONE, 0)), null);
			Challenge.addChallenge(32, new ItemData("Zombie Apocalypse", 1, Material.ROTTEN_FLESH, 0), Arrays.asList(new ItemData("175 Zombie Flesh", 175, Material.ROTTEN_FLESH, 0)), Arrays.asList(new ItemData("3 Raw Fish", 3, Material.RAW_FISH, 0)), 30);
			Challenge.addChallenge(33, new ItemData("Creepy Creeper", 1, Material.SULPHUR, 0), Arrays.asList(new ItemData("225 Gunpowder", 225, Material.SULPHUR, 0)), Arrays.asList(new ItemData("1 Squid Spawn Egg", 1, Material.MONSTER_EGG, 94)), 31);
			Challenge.addChallenge(34, new ItemData("Destroy the Webs!", 1, Material.STRING, 0), Arrays.asList(new ItemData("200 String", 200, Material.STRING, 0)), Arrays.asList(new ItemData("1 Red Mushroom", 1, Material.RED_MUSHROOM, 0)), 32);
			Challenge.addChallenge(35, new ItemData("Spider Eyes", 1, Material.SPIDER_EYE, 0), Arrays.asList(new ItemData("15 Spider Eyes", 15, Material.SPIDER_EYE, 0)), Arrays.asList(new ItemData("1 Ocelot Spawn Egg", 1, Material.MONSTER_EGG, 98)), 33);
			Challenge.addChallenge(36, new ItemData("Enderwoman", 1, Material.ENDER_PEARL, 0), Arrays.asList(new ItemData("16 Ender Pearls", 16, Material.ENDER_PEARL, 0)), Arrays.asList(new ItemData("1 Chicken Spawn Egg", 1, Material.MONSTER_EGG, 93)), 34, 35);
			Challenge.addChallenge(37, new ItemData("Goblins", 1, Material.GOLD_SWORD, 0), Arrays.asList(new ItemData("35 Gold Swords", 35, Material.GOLD_SWORD, 0)), Arrays.asList(new ItemData("1 Mooshroom Spawn Egg", 1, Material.MONSTER_EGG, 96)), null);
			Challenge.addChallenge(38, new ItemData("Blazepow(d)er", 1, Material.BLAZE_ROD, 0), Arrays.asList(new ItemData("50 Blaze Rods", 50, Material.BLAZE_ROD, 0)), Arrays.asList(new ItemData("1 Rabbit Spawn Egg", 1, Material.MONSTER_EGG, 101)), 37);
			Challenge.addChallenge(39, new ItemData("The Scream", 1, Material.GHAST_TEAR, 0), Arrays.asList(new ItemData("10 Ghast Tears", 10, Material.GHAST_TEAR, 0)), Arrays.asList(new ItemData("1 Villager Spawn Egg", 1, Material.MONSTER_EGG, 120)), 38);
			Challenge.addChallenge(40, new ItemData("Black Money", 1, Material.SKULL_ITEM, 1), Arrays.asList(new ItemData("1 Wither Skeleton Skull", 1, Material.SKULL_ITEM, 1)), Arrays.asList(new ItemData("2 Diamond Ore", 2, Material.DIAMOND_ORE, 0)), 35, 39);
			
			for(Challenge c : this.challenges){
				c.updateRequired();
			}
		}
		
		private void registerKits(){
			{
				Kit kit = new Kit("Iron_VIP");
				kit.setItem(0, new ItemStack(Material.COBBLESTONE, 32));
				kit.setItem(1, new ItemStack(Material.IRON_INGOT, 3));
			}
			{
				Kit kit = new Kit("Gold_VIP");
				kit.setItem(0, new ItemStack(Material.COBBLESTONE, 48));
				kit.setItem(1, new ItemStack(Material.IRON_INGOT, 5));
				kit.setItem(2, new ItemStack(Material.DIRT, 1));
			}
			{
				Kit kit = new Kit("Diamond_VIP");
				kit.setItem(0, new ItemStack(Material.COBBLESTONE, 64));
				kit.setItem(1, new ItemStack(Material.IRON_INGOT, 8));
				kit.setItem(2, new ItemStack(Material.DIRT, 1));
				kit.setItem(3, new ItemStack(Material.SAND, 1));
			}
			{
				Kit kit = new Kit("Emerald_VIP");
				kit.setItem(0, new ItemStack(Material.COBBLESTONE, 64));
				kit.setItem(1, new ItemStack(Material.COBBLESTONE, 64));
				kit.setItem(2, new ItemStack(Material.IRON_INGOT, 10));
				kit.setItem(3, new ItemStack(Material.DIRT, 2));
				kit.setItem(4, new ItemStack(Material.SAND, 2));
				kit.setItem(5, new ItemStack(Material.DIAMOND, 1));
			}
		}
	}

	public static class PrisonServer {
		
		private World lobbyworld;
		private World prisonworld;
		private Location spawn;
		private List<Mine> mines;
		private List<Lumberjack> lumberjacks;
		private List<StringInt> topgold;
		private List<ShopSign> shopsigns;
		private List<Shop> shops;
		
		public PrisonServer(){
			ServerStorage.server = Server.PRISON;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §brienk222\n§9§lDiamond §9jomancool55\n§6§lGold §6gapisabelle §7(PvP Area)";
			ServerStorage.prison = this;
			this.lobbyworld = Bukkit.getWorld("PrisonLobby");
			ServerStorage.lobbyworld = this.lobbyworld;
			this.prisonworld = Bukkit.getWorld("PrisonWorld");
			this.spawn = new Location(getLobbyWorld(), 0, 70, 0, 135, 0);
			this.shopsigns = ShopSign.readFromConfig();
			this.lumberjacks = new ArrayList<Lumberjack>();
			
			loadMines();
			loadShops();
			registerKits();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n     §7Restarting §4§lPrison§7 Server...");
			}
			
			new BukkitRunnable(){
				public void run(){
					Utils.removeAllEntitiesIF();
					spawnNPCs();
				}
			}.runTaskLater(Start.getInstance(), 100);
		}

		public World getLobbyWorld() {
			return lobbyworld;
		}
		public void setLobbyWorld(World lobbyworld) {
			this.lobbyworld = lobbyworld;
		}

		public World getPrisonWorld() {
			return prisonworld;
		}
		public void setPrisonWorld(World prisonworld) {
			this.prisonworld = prisonworld;
		}

		public Location getSpawn() {
			return spawn;
		}
		public void setSpawn(Location spawn) {
			this.spawn = spawn;
		}

		public List<Mine> getMines() {
			return mines;
		}
		public void setMines(List<Mine> mines) {
			this.mines = mines;
		}

		public List<Lumberjack> getLumberjacks() {
			return lumberjacks;
		}
		public void setLumberjacks(List<Lumberjack> lumberjacks) {
			this.lumberjacks = lumberjacks;
		}

		public List<StringInt> getTopGold() {
			return topgold;
		}
		public void setTopGold(List<StringInt> topgold) {
			this.topgold = topgold;
		}

		public List<ShopSign> getShopSigns() {
			return shopsigns;
		}
		public void setShopSigns(List<ShopSign> shopsigns) {
			this.shopsigns = shopsigns;
		}

		public List<Shop> getShops() {
			return shops;
		}
		public void setShops(List<Shop> shops) {
			this.shops = shops;
		}
		
		private void loadMines(){
			this.mines = new ArrayList<Mine>();
			
			this.mines.add(new Mine(Rank.Z, Utils.getBlocksBetween(new Location(getPrisonWorld(), 2, 51, -29), new Location(getPrisonWorld(), 28, 68, -57)), Arrays.asList(new MineBlock(Material.STONE, 0, 98), new MineBlock(Material.COAL_ORE, 0, 2)), new Location(getPrisonWorld(), 0.5, 70, 0.5, 180, 0),  new Location(getPrisonWorld(), 7, 80, -43),  new Location(getPrisonWorld(), 0.5, 69, -26.5, -135, 0), new Location(getPrisonWorld(), 9, 70, -20), new Location(getPrisonWorld(), 8, 70, -20), new Location(getPrisonWorld(), 7, 70, -5), new Location(getPrisonWorld(), 7, 70, -4), new Location(getPrisonWorld(), 7, 70, -3)));
			
			this.mines.add(new Mine(Rank.Y, 
					Utils.getBlocksBetween(new Location(getPrisonWorld(), 985, 55, -37), new Location(getPrisonWorld(), 1013, 69, -10)), 
					Arrays.asList(new MineBlock(Material.STONE, 0, 90), new MineBlock(Material.COAL_ORE, 0, 10)), 
					new Location(getPrisonWorld(), 1000.5, 70, -0.5, 180, 0), 
					new Location(getPrisonWorld(), 991, 81, -23), 
					new Location(getPrisonWorld(), 1016.5, 70, -6.5, 135, 0),
					
					new Location(getPrisonWorld(), 1019, 71, -11),
					new Location(getPrisonWorld(), 1019, 71, -12),
					new Location(getPrisonWorld(), 994, 72, -45),
					new Location(getPrisonWorld(), 995, 72, -45),
					new Location(getPrisonWorld(), 996, 72, -45)
					));
		}
		
		private void loadShops(){
			this.shops = new ArrayList<Shop>();
			
			this.shops.add(new Shop(1, new Location(getLobbyWorld(), 9, 74, 15), Utils.getBlocksBetween(new Location(getLobbyWorld(), 10, 73, 16), new Location(getLobbyWorld(), 13, 76, 19)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 10, 73, 16), new Location(getLobbyWorld(), 10, 73, 19)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 13, 76, 16), new Location(getLobbyWorld(), 13, 76, 19))));
			this.shops.add(new Shop(2, new Location(getLobbyWorld(), 1, 74, 20), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 73, 19), new Location(getLobbyWorld(), -3, 76, 16)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 73, 19), new Location(getLobbyWorld(), 0, 73, 16)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -3, 76, 19), new Location(getLobbyWorld(), -3, 76, 16))));
			this.shops.add(new Shop(3, new Location(getLobbyWorld(), 10, 74, 22), Utils.getBlocksBetween(new Location(getLobbyWorld(), 11, 73, 23), new Location(getLobbyWorld(), 14, 76, 26)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 11, 73, 23), new Location(getLobbyWorld(), 11, 73, 26)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 14, 76, 23), new Location(getLobbyWorld(), 14, 76, 26))));
			this.shops.add(new Shop(4, new Location(getLobbyWorld(), 0, 74, 27), Utils.getBlocksBetween(new Location(getLobbyWorld(), -1, 73, 26), new Location(getLobbyWorld(), -4, 76, 23)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -1, 73, 26), new Location(getLobbyWorld(), -1, 73, 23)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -4, 76, 26), new Location(getLobbyWorld(), -4, 76, 23))));
			this.shops.add(new Shop(5, new Location(getLobbyWorld(), 9, 74, 29), Utils.getBlocksBetween(new Location(getLobbyWorld(), 10, 73, 30), new Location(getLobbyWorld(), 13, 76, 33)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 10, 73, 30), new Location(getLobbyWorld(), 10, 73, 33)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 13, 76, 30), new Location(getLobbyWorld(), 13, 76, 33))));
			this.shops.add(new Shop(6, new Location(getLobbyWorld(), 1, 74, 34), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 73, 33), new Location(getLobbyWorld(), -3, 76, 30)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 73, 33), new Location(getLobbyWorld(), 0, 73, 30)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -3, 76, 33), new Location(getLobbyWorld(), -3, 76, 30))));
			this.shops.add(new Shop(7, new Location(getLobbyWorld(), 5, 71, 43), Utils.getBlocksBetween(new Location(getLobbyWorld(), 6, 70, 44), new Location(getLobbyWorld(), 9, 73, 47)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 6, 70, 44), new Location(getLobbyWorld(), 6, 70, 47)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 9, 73, 44), new Location(getLobbyWorld(), 9, 73, 47))));
			this.shops.add(new Shop(8, new Location(getLobbyWorld(), 0, 71, 50), Utils.getBlocksBetween(new Location(getLobbyWorld(), -1, 70, 49), new Location(getLobbyWorld(), -4, 73, 46)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -1, 70, 49), new Location(getLobbyWorld(), -1, 70, 46)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -4, 73, 49), new Location(getLobbyWorld(), -4, 73, 46))));
			this.shops.add(new Shop(9, new Location(getLobbyWorld(), 6, 71, 50), Utils.getBlocksBetween(new Location(getLobbyWorld(), 7, 70, 51), new Location(getLobbyWorld(), 10, 73, 54)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 7, 70, 51), new Location(getLobbyWorld(), 7, 70, 54)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 10, 73, 51), new Location(getLobbyWorld(), 10, 73, 54))));
			this.shops.add(new Shop(10, new Location(getLobbyWorld(), 1, 71, 57), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 70, 56), new Location(getLobbyWorld(), -3, 73, 53)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 70, 56), new Location(getLobbyWorld(), 0, 70, 53)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -3, 73, 56), new Location(getLobbyWorld(), -3, 73, 53))));
			this.shops.add(new Shop(11, new Location(getLobbyWorld(), -1, 71, 75), Utils.getBlocksBetween(new Location(getLobbyWorld(), -2, 70, 74), new Location(getLobbyWorld(), -5, 73, 71)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -2, 70, 74), new Location(getLobbyWorld(), -2, 70, 71)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -5, 73, 74), new Location(getLobbyWorld(), -5, 73, 71))));
			this.shops.add(new Shop(12, new Location(getLobbyWorld(), 1, 71, 82), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 70, 81), new Location(getLobbyWorld(), -3, 73, 78)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 0, 70, 71), new Location(getLobbyWorld(), 0, 70, 78)), Utils.getBlocksBetween(new Location(getLobbyWorld(), -3, 73, 81), new Location(getLobbyWorld(), -3, 73, 78))));
			this.shops.add(new Shop(13, new Location(getLobbyWorld(), 7, 71, 82), Utils.getBlocksBetween(new Location(getLobbyWorld(), 6, 70, 83), new Location(getLobbyWorld(), 3, 73, 86)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 6, 70, 83), new Location(getLobbyWorld(), 3, 70, 83)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 6, 73, 86), new Location(getLobbyWorld(), 3, 73, 86))));
			this.shops.add(new Shop(14, new Location(getLobbyWorld(), 14, 71, 81), Utils.getBlocksBetween(new Location(getLobbyWorld(), 13, 70, 82), new Location(getLobbyWorld(), 10, 73, 85)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 13, 70, 82), new Location(getLobbyWorld(), 10, 70, 82)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 13, 73, 85), new Location(getLobbyWorld(), 10, 73, 85))));
			this.shops.add(new Shop(15, new Location(getLobbyWorld(), 21, 71, 79), Utils.getBlocksBetween(new Location(getLobbyWorld(), 20, 70, 80), new Location(getLobbyWorld(), 17, 73, 83)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 20, 70, 80), new Location(getLobbyWorld(), 17, 70, 80)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 20, 73, 83), new Location(getLobbyWorld(), 17, 73, 83))));
			this.shops.add(new Shop(16, new Location(getLobbyWorld(), 16, 71, 67), Utils.getBlocksBetween(new Location(getLobbyWorld(), 15, 70, 68), new Location(getLobbyWorld(), 12, 73, 71)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 15, 70, 68), new Location(getLobbyWorld(), 12, 70, 68)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 15, 73, 71), new Location(getLobbyWorld(), 12, 73, 71))));
			this.shops.add(new Shop(17, new Location(getLobbyWorld(), 23, 71, 66), Utils.getBlocksBetween(new Location(getLobbyWorld(), 22, 70, 67), new Location(getLobbyWorld(), 19, 73, 70)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 22, 70, 67), new Location(getLobbyWorld(), 19, 70, 67)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 22, 73, 70), new Location(getLobbyWorld(), 19, 73, 70))));
			this.shops.add(new Shop(18, new Location(getLobbyWorld(), 25, 71, 53), Utils.getBlocksBetween(new Location(getLobbyWorld(), 24, 70, 52), new Location(getLobbyWorld(), 21, 73, 49)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 24, 70, 52), new Location(getLobbyWorld(), 24, 70, 49)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 21, 73, 52), new Location(getLobbyWorld(), 21, 73, 49))));
			this.shops.add(new Shop(19, new Location(getLobbyWorld(), 29, 71, 47), Utils.getBlocksBetween(new Location(getLobbyWorld(), 30, 70, 48), new Location(getLobbyWorld(), 33, 73, 51)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 30, 70, 48), new Location(getLobbyWorld(), 30, 70, 51)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 33, 73, 48), new Location(getLobbyWorld(), 33, 73, 51))));
			this.shops.add(new Shop(20, new Location(getLobbyWorld(), 26, 71, 46), Utils.getBlocksBetween(new Location(getLobbyWorld(), 25, 70, 45), new Location(getLobbyWorld(), 22, 73, 42)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 25, 70, 45), new Location(getLobbyWorld(), 25, 70, 42)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 22, 73, 45), new Location(getLobbyWorld(), 22, 73, 42))));
			this.shops.add(new Shop(21, new Location(getLobbyWorld(), 29, 71, 37), Utils.getBlocksBetween(new Location(getLobbyWorld(), 30, 70, 38), new Location(getLobbyWorld(), 33, 73, 41)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 30, 70, 38), new Location(getLobbyWorld(), 30, 70, 41)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 33, 73, 38), new Location(getLobbyWorld(), 33, 73, 41))));
			this.shops.add(new Shop(22, new Location(getLobbyWorld(), 28, 71, 29), Utils.getBlocksBetween(new Location(getLobbyWorld(), 29, 70, 30), new Location(getLobbyWorld(), 32, 73, 33)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 29, 70, 30), new Location(getLobbyWorld(), 29, 70, 33)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 32, 73, 30), new Location(getLobbyWorld(), 32, 73, 33))));
			this.shops.add(new Shop(23, new Location(getLobbyWorld(), 27, 71, 12), Utils.getBlocksBetween(new Location(getLobbyWorld(), 28, 70, 13), new Location(getLobbyWorld(), 31, 73, 16)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 28, 70, 13), new Location(getLobbyWorld(), 28, 70, 16)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 31, 73, 13), new Location(getLobbyWorld(), 31, 73, 16))));
			this.shops.add(new Shop(24, new Location(getLobbyWorld(), 26, 71, 4), Utils.getBlocksBetween(new Location(getLobbyWorld(), 27, 70, 5), new Location(getLobbyWorld(), 30, 73, 8)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 27, 70, 5), new Location(getLobbyWorld(), 27, 70, 8)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 30, 73, 5), new Location(getLobbyWorld(), 30, 73, 8))));
			this.shops.add(new Shop(25, new Location(getLobbyWorld(), 20, 71, 4), Utils.getBlocksBetween(new Location(getLobbyWorld(), 21, 70, 3), new Location(getLobbyWorld(), 24, 73, 0)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 21, 70, 3), new Location(getLobbyWorld(), 24, 70, 3)), Utils.getBlocksBetween(new Location(getLobbyWorld(), 21, 73, 0), new Location(getLobbyWorld(), 24, 73, 0))));
		}
		
		private void spawnNPCs(){
			{
				NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.SERVER_SELECTOR, new Location(getLobbyWorld(), 3, 70.5, 3, 0, 0));
				npcas.setGravity(false);
				npcas.setVisible(false);
				npcas.setSmall(true);
				npcas.setUseItem(true);
				npcas.setItemStack(new ItemStack(Material.ENDER_PEARL, 1));
				npcas.setItemName("§3§lServer Selector");
				npcas.spawn();
			}
			{
				NPC npc = NPC.addNPC(NPCType.VILLAGER_GAMBLE);
				npc.newEntity(EntityType.VILLAGER, new Location(getLobbyWorld(), 13.5, 70, 5.5, 180, 0), "§a§lVillager Gamble", false);
				npc.setVillagerProfession(Profession.LIBRARIAN);
			}
			{
				NPC npc = NPC.addNPC(NPCType.SHOP);
				npc.newEntity(EntityType.SKELETON, new Location(getPrisonWorld(), 7.5, 69, -66.5, 0, 0), "§6§lGold Shop", false);
				npc.setItemInHand(new ItemStack(Material.GOLD_INGOT));
			}
			{
				NPC npc = NPC.addNPC(NPCType.SHOP);
				npc.newEntity(EntityType.SKELETON, new Location(getPrisonWorld(), 991, 70, -41, 0, 0), "§6§lGold Shop", false);
				npc.setItemInHand(new ItemStack(Material.GOLD_INGOT));
			}
			{
				NPC npc = NPC.addNPC(NPCType.RESET_MINE);
				npc.newEntity(EntityType.SKELETON, new Location(getPrisonWorld(), 1.5, 69, -21.5, 0, 0), "§7§lReset Mine §a§lZ", false);
				npc.setItemInHand(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE), Enchantment.DURABILITY, 1));
			}
			{
				NPC npc = NPC.addNPC(NPCType.RESET_MINE);
				npc.newEntity(EntityType.SKELETON, new Location(getPrisonWorld(), 1022.5, 70, -24.5, 0, 0), "§7§lReset Mine §a§lY", false);
				npc.setItemInHand(Utils.addEnchantment(new ItemStack(Material.DIAMOND_PICKAXE), Enchantment.DURABILITY, 1));
			}
			
			{
				NPC npc = NPC.addNPC(NPCType.LUMBERJACK);
				npc.newEntity(EntityType.ZOMBIE, new Location(getPrisonWorld(), -35.5, 72, -49.5, -90, 0), "§e§lLumberjack", false);
				npc.setItemInHand(new ItemStack(Material.IRON_AXE));
				npc.setHelmet(new ItemStack(Material.IRON_HELMET));
				npc.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				npc.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				npc.setBoots(new ItemStack(Material.IRON_BOOTS));
				
				this.lumberjacks.add(new Lumberjack(Rank.Z, npc, npc.getLocation(), getPrisonWorld().getBlockAt(new Location(getPrisonWorld(), -37, 73, -49)), Utils.getBlocksBetween(new Location(getPrisonWorld(), -23, 72, -49), new Location(getPrisonWorld(), -34, 72, -49))));
			}
			{
				NPC npc = NPC.addNPC(NPCType.LUMBERJACK);
				npc.newEntity(EntityType.ZOMBIE, new Location(getPrisonWorld(), 1048.5, 70, -5.5, -90, 0), "§e§lLumberjack", false);
				npc.setItemInHand(new ItemStack(Material.IRON_AXE));
				npc.setHelmet(new ItemStack(Material.IRON_HELMET));
				npc.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				npc.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				npc.setBoots(new ItemStack(Material.IRON_BOOTS));
				
				this.lumberjacks.add(new Lumberjack(Rank.Y, npc, npc.getLocation(), getPrisonWorld().getBlockAt(new Location(getPrisonWorld(), 1049, 70, -5)), Utils.getBlocksBetween(new Location(getPrisonWorld(), 1035, 69, -5), new Location(getPrisonWorld(), 1045, 69, -5))));
			}
			
			{
				Hologram h = new Hologram(new Location(getPrisonWorld(), -1.5, 69, -8.5));
				h.addLine("§7§l/kit starter");
				h.create();
			}
		}
		
		private void registerKits(){
			{
				Kit kit = new Kit("Starter");
				kit.setItem(0, Utils.addEnchantment(Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_PICKAXE), "§9Starter Pickaxe"), Enchantment.DIG_SPEED, 3), Enchantment.DURABILITY, 3), Enchantment.LOOT_BONUS_BLOCKS, 3));
				kit.setItem(1, Utils.addEnchantment(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.IRON_AXE), "§9Starter Axe"), Enchantment.DIG_SPEED, 3), Enchantment.DURABILITY, 3));
				kit.setItem(2, new ItemStack(Material.COOKED_BEEF, 32));
			}
		}
	}
	
	public static class MiniGamesServer {
		
		private World lobbyworld;
		private List<Arena> arenas;
		private HashMap<MiniGameType, List<Map>> maps;
		private HashMap<String, Arena> playerstojoin;
		private List<ChestItem> sgchestitems;
		private List<ChestItem> sgchestpotions;
		private List<ChestItem> swchestitems;
		private List<ChestItem> swtier2chestitems;
		
		public MiniGamesServer(){
			ServerStorage.server = Server.MINIGAMES;
			ConfigManager.setup();
			
			ServerStorage.spawnbuilders = "§b§lMod §brienk222";
			ServerStorage.minigames = this;
			this.lobbyworld = Bukkit.getWorld("MiniGamesLobby");
			ServerStorage.lobbyworld = this.lobbyworld;
			this.playerstojoin = new HashMap<String, Arena>();
			
			registerKits();
			registerMaps();
			registerArenas();
			registerSGChestItems();
			registerSWChestItems();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("§6§lOrbitMines§4§lNetwork\n   §7Restarting §f§lMiniGames§7 Server...");
			}
			
			new BukkitRunnable(){
				public void run(){
					Utils.removeAllEntities();
					spawnNPCs();
				}
			}.runTaskLater(Start.getInstance(), 100);
		}

		public World getLobbyWorld() {
			return lobbyworld;
		}
		public void setLobbyWorld(World lobbyworld) {
			this.lobbyworld = lobbyworld;
		}

		public List<Arena> getArenas() {
			return arenas;
		}
		public void setArenas(List<Arena> arenas) {
			this.arenas = arenas;
		}

		public HashMap<MiniGameType, List<Map>> getMaps() {
			return maps;
		}
		public void setMaps(HashMap<MiniGameType, List<Map>> maps) {
			this.maps = maps;
		}

		public HashMap<String, Arena> getPlayersToJoin() {
			return playerstojoin;
		}
		public void setPlayersToJoin(HashMap<String, Arena> playerstojoin) {
			this.playerstojoin = playerstojoin;
		}

		public List<ChestItem> getSGChestItems() {
			return sgchestitems;
		}
		public void setSGChestItems(List<ChestItem> sgchestitems) {
			this.sgchestitems = sgchestitems;
		}

		public List<ChestItem> getSGChestPotions() {
			return sgchestpotions;
		}
		public void setSGChestPotions(List<ChestItem> sgchestpotions) {
			this.sgchestpotions = sgchestpotions;
		}

		public List<ChestItem> getSWChestItems() {
			return swchestitems;
		}
		public void setSWChestItems(List<ChestItem> swchestitems) {
			this.swchestitems = swchestitems;
		}

		public List<ChestItem> getSWTier2ChestItems() {
			return swtier2chestitems;
		}
		public void setSWTier2ChestItems(List<ChestItem> swtier2chestitems) {
			this.swtier2chestitems = swtier2chestitems;
		}
		
		private void registerKits(){
			{
				Kit kit = new Kit("Lobby");
				kit.setItem(0, Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.SKULL_ITEM), "§2§nStats"), 3));
				kit.setItem(1, Utils.setDisplayname(new ItemStack(Material.BREWING_STAND_ITEM), "§e§nGame Effects"));
				kit.setItem(4, Utils.setDisplayname(new ItemStack(Material.ENDER_PEARL), "§3§nBack to the Hub"));
				kit.setItem(8, Utils.setDisplayname(new ItemStack(Material.ENDER_CHEST), "§9§nCosmetic Perks"));
			}
			{
				Kit kit = new Kit("Spectator");
				kit.setItem(3, Utils.setDisplayname(new ItemStack(Material.NAME_TAG), "§e§nTeleporter"));
				kit.setItem(5, Utils.setDisplayname(new ItemStack(Material.ENDER_PEARL), "§3§nBack to the Hub"));
			}
			
			{
				@SuppressWarnings("unused")
				Kit kit = new Kit(TicketType.RUNNER_KIT.toString());
			}
			{
				String type = TicketType.FIGHTER_KIT.getRarity().getColor() + TicketType.FIGHTER_KIT.getName();
				Kit kit = new Kit(TicketType.FIGHTER_KIT.toString());
				kit.setRandomItem(0, Arrays.asList(Utils.setLore(new ItemStack(Material.WOOD_SWORD), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.WOOD_AXE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.STONE_SWORD), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.STONE_AXE), Arrays.asList(type))));
			}
			{
				String type = TicketType.ARCHER_KIT.getRarity().getColor() + TicketType.FIGHTER_KIT.getName();
				Kit kit = new Kit(TicketType.ARCHER_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.BOW), Arrays.asList(type)));
				kit.setItem(8, Utils.setLore(new ItemStack(Material.ARROW, 2), Arrays.asList(type)));
			}
			{
				String type = TicketType.WARRIOR_KIT.getRarity().getColor() + TicketType.WARRIOR_KIT.getName();
				Kit kit = new Kit(TicketType.WARRIOR_KIT.toString());
				kit.setRandomItem(0, Arrays.asList(Utils.setLore(new ItemStack(Material.LEATHER_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.LEATHER_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.LEATHER_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.LEATHER_HELMET), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_HELMET), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_HELMET), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_HELMET), Arrays.asList(type))));
				kit.setRandomItem(1, Arrays.asList(Utils.setLore(new ItemStack(Material.LEATHER_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.LEATHER_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.LEATHER_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.LEATHER_HELMET), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.GOLD_HELMET), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.CHAINMAIL_HELMET), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_BOOTS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_LEGGINGS), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_CHESTPLATE), Arrays.asList(type)), Utils.setLore(new ItemStack(Material.IRON_HELMET), Arrays.asList(type))));
			}
			{
				String type = TicketType.BOMBER_KIT.getRarity().getColor() + TicketType.BOMBER_KIT.getName();
				Kit kit = new Kit(TicketType.BOMBER_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.TNT, 10), Arrays.asList(type)));
			}

			{
				String type = TicketType.SURVIVOR_KIT.getRarity().getColor() + TicketType.SURVIVOR_KIT.getName();
				Kit kit = new Kit(TicketType.SURVIVOR_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.COOKED_BEEF, 15), Arrays.asList(type)));
			}
			{
				String type = TicketType.STARTER_KIT.getRarity().getColor() + TicketType.STARTER_KIT.getName();
				Kit kit = new Kit(TicketType.STARTER_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.WOOD_SWORD), Arrays.asList(type)));
				kit.setItem(1, Utils.setLore(new ItemStack(Material.WOOD_PICKAXE), Arrays.asList(type)));
				kit.setItem(2, Utils.setLore(new ItemStack(Material.WOOD_AXE), Arrays.asList(type)));
				kit.setItem(3, Utils.setLore(new ItemStack(Material.WOOD_SPADE), Arrays.asList(type)));
			}
			{
				@SuppressWarnings("unused")
				Kit kit = new Kit(TicketType.APPLETREE_KIT.toString());
			}
			{
				String type = TicketType.SPEEDSTER_KIT.getRarity().getColor() + TicketType.SPEEDSTER_KIT.getName();
				Kit kit = new Kit(TicketType.SPEEDSTER_KIT.toString());
				kit.setItem(0, Utils.setLore(Utils.setDurability(new ItemStack(Material.POTION), 8194), Arrays.asList(type)));
			}
			{
				Kit kit = new Kit(TicketType.MINER_KIT.toString());
				kit.setPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 18000, 0));
			}
			{
				String type = TicketType.TANK_KIT.getRarity().getColor() + TicketType.TANK_KIT.getName();
				Kit kit = new Kit(TicketType.TANK_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.LEATHER_HELMET), Arrays.asList(type)));
				kit.setItem(1, Utils.setLore(new ItemStack(Material.CHAINMAIL_CHESTPLATE), Arrays.asList(type)));
				kit.setItem(2, Utils.setLore(new ItemStack(Material.CHAINMAIL_LEGGINGS), Arrays.asList(type)));
				kit.setItem(3, Utils.setLore(new ItemStack(Material.LEATHER_BOOTS), Arrays.asList(type)));
			}
			{
				String type = TicketType.SNOWGOLEM_KIT.getRarity().getColor() + TicketType.SNOWGOLEM_KIT.getName();
				Kit kit = new Kit(TicketType.SNOWGOLEM_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.CARROT_ITEM), Arrays.asList(type)));
				kit.setItem(1, Utils.setLore(Utils.addColor(new ItemStack(Material.LEATHER_HELMET), Color.BLACK), Arrays.asList(type)));
				kit.setItem(2, Utils.setLore(new ItemStack(Material.SNOW_BALL, 16), Arrays.asList(type)));
				kit.setItem(3, Utils.setLore(new ItemStack(Material.SNOW_BALL, 16), Arrays.asList(type)));
				kit.setItem(4, Utils.setLore(new ItemStack(Material.SNOW_BALL, 16), Arrays.asList(type)));
			}
			{
				String type = TicketType.CREEPER_KIT.getRarity().getColor() + TicketType.CREEPER_KIT.getName();
				Kit kit = new Kit(TicketType.CREEPER_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.TNT, 20), Arrays.asList(type)));
				kit.setItem(1, Utils.setLore(new ItemStack(Material.FLINT_AND_STEEL), Arrays.asList(type)));
			}
			{
				String type = TicketType.ENCHANTER_KIT.getRarity().getColor() + TicketType.ENCHANTER_KIT.getName();
				Kit kit = new Kit(TicketType.ENCHANTER_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.ENCHANTMENT_TABLE), Arrays.asList(type)));
				kit.setItem(1, Utils.setLore(new ItemStack(Material.EXP_BOTTLE, 15), Arrays.asList(type)));
			}
			{
				String type = TicketType.ENDERMAN_KIT.getRarity().getColor() + TicketType.ENDERMAN_KIT.getName();
				Kit kit = new Kit(TicketType.ENDERMAN_KIT.toString());
				kit.setItem(0, Utils.setLore(new ItemStack(Material.ENDER_PEARL, 2), Arrays.asList(type)));
			}
			{
				String type = TicketType.CHICKEN_MAMA_KIT.getRarity().getColor() + TicketType.CHICKEN_MAMA_KIT.getName();
				Kit kit = new Kit(TicketType.CHICKEN_MAMA_KIT.toString());
				kit.setItem(0, Utils.setLore(Utils.setDisplayname(new ItemStack(Material.FEATHER, 1), "§f§lFeather Attack"), Arrays.asList(type)));
			}
			{
				String type = TicketType.BABY_CHICKEN_KIT.getRarity().getColor() + TicketType.BABY_CHICKEN_KIT.getName();
				Kit kit = new Kit(TicketType.BABY_CHICKEN_KIT.toString());
				kit.setItem(0, Utils.setLore(Utils.setDisplayname(new ItemStack(Material.EGG, 1), "§f§lEgg Bomb"), Arrays.asList(type)));
			}
			{
				String type = TicketType.HOT_WING_KIT.getRarity().getColor() + TicketType.HOT_WING_KIT.getName();
				Kit kit = new Kit(TicketType.HOT_WING_KIT.toString());
				kit.setItem(0, Utils.setLore(Utils.setDisplayname(new ItemStack(Material.FIREBALL, 1), "§f§lFire Shield"), Arrays.asList(type)));
			}
			{
				String type = TicketType.CHICKEN_WARLORD_KIT.getRarity().getColor() + TicketType.CHICKEN_WARLORD_KIT.getName();
				Kit kit = new Kit(TicketType.CHICKEN_WARLORD_KIT.toString());
				kit.setItem(0, Utils.setLore(Utils.setDisplayname(new ItemStack(Material.IRON_INGOT, 1), "§f§lIron Fist"), Arrays.asList(type)));
				kit.setPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 2));
			}
			{
				@SuppressWarnings("unused")
				Kit kit = new Kit(TicketType.CHICKEN_KIT.toString());
			}
		}
		
		private void registerMaps(){
			this.maps = new HashMap<MiniGameType, List<Map>>();
			List<Map> sgmaps = new ArrayList<Map>();
			{
				Map map = new Map("Abrax Park", "xFrozenYeti§7, §6iClarify", MiniGameType.SURVIVAL_GAMES, "AbraxParkSG", false);
				map.setSpectatorLocation(new Location(map.getWorld(), -183.5, 85.5, 64.5, -180, 90));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -183.5, 66, 89.5, 180, 0), new Location(map.getWorld(), -177.5, 66, 89.5, 165, 0), new Location(map.getWorld(), -171.5, 66, 86.5, 150, 0), new Location(map.getWorld(), -165.5, 66, 82.5, 135, 0), new Location(map.getWorld(), -161.5, 66, 76.5, 120, 0), new Location(map.getWorld(), -158.5, 66, 70.5, 105, 0), new Location(map.getWorld(), -158.5, 66, 64.5, 90, 0), new Location(map.getWorld(), -158.5, 66, 58.5, 75, 0), new Location(map.getWorld(), -161.5, 66, 52.5, 60, 0), new Location(map.getWorld(), -165.5, 66, 46.5, 45, 0), new Location(map.getWorld(), -171.5, 66, 42.5, 30, 0), new Location(map.getWorld(), -177.5, 66, 39.5, 15, 0), new Location(map.getWorld(), -183.5, 66, 39.5, 0, 0), new Location(map.getWorld(), -183.5, 66, 89.5, -15, 0), new Location(map.getWorld(), -195.5, 66, 42.5, -30, 0), new Location(map.getWorld(), -201.5, 66, 46.5, -45, 0), new Location(map.getWorld(), -205.5, 66, 52.5, -60, 0), new Location(map.getWorld(), -208.5, 66, 58.5, -75, 0), new Location(map.getWorld(), -208.5, 66, 64.5, -90, 0), new Location(map.getWorld(), -208.5, 66, 70.5, -105, 0), new Location(map.getWorld(), -205.5, 66, 76.5, -120, 0), new Location(map.getWorld(), -201.5, 66, 82.5, -135, 0), new Location(map.getWorld(), -195.5, 66, 86.5, -150, 0), new Location(map.getWorld(), -189.5, 66, 89.5, -165, 0)));
				sgmaps.add(map);
			}
			{
				Map map = new Map("Breeze Island 2", "xBayani§7, §6static_nightmare§7, §6cameron224", MiniGameType.SURVIVAL_GAMES, "Breeze_Island2", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 16.5, 83, 26.5, 0, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), 16.5, 67, 49.5, 180, 0), new Location(map.getWorld(), 22.5, 67, 48.5, 165, 0), new Location(map.getWorld(), 27.5, 67, 46.5, 150, 0), new Location(map.getWorld(), 32.5, 67, 42.5, 135, 0), new Location(map.getWorld(), 36.5, 67, 37.5, 120, 0), new Location(map.getWorld(), 38.5, 67, 32.5, 105, 0), new Location(map.getWorld(), 39.5, 67, 26.5, 90, 0), new Location(map.getWorld(), 38.5, 67, 20.5, 75, 0), new Location(map.getWorld(), 36.5, 67, 15.5, 60, 0), new Location(map.getWorld(), 32.5, 67, 10.5, 45, 0), new Location(map.getWorld(), 27.5, 67, 6.5, 30, 0), new Location(map.getWorld(), 22.5, 67, 4.5, 15, 0), new Location(map.getWorld(), 16.5, 67, 3.5, 0, 0), new Location(map.getWorld(), 10.5, 67, 4.5, -15, 0), new Location(map.getWorld(), 5.5, 67, 6.5, -30, 0), new Location(map.getWorld(), 0.5, 67, 10.5, -45, 0), new Location(map.getWorld(), -3.5, 67, 15.5, -60, 0), new Location(map.getWorld(), -5.5, 67, 20.5, -75, 0), new Location(map.getWorld(), -6.5, 67, 26.5, -90, 0), new Location(map.getWorld(), -5.5, 67, 32.5, -105, 0), new Location(map.getWorld(), -3.5, 67, 37.5, -120, 0), new Location(map.getWorld(), 0.5, 67, 42.5, -135, 0), new Location(map.getWorld(), 5.5, 67, 46.5, -150, 0), new Location(map.getWorld(), 10.5, 67, 48.5, -165, 0)));
				sgmaps.add(map);
			}
			{
				Map map = new Map("Estyr", "Team Dmon", MiniGameType.SURVIVAL_GAMES, "Estyr", false);
				map.setSpectatorLocation(new Location(map.getWorld(), -0.5, 92.5, 0.5, 90, 90));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -0.5, 74, 25.5, 180, 0), new Location(map.getWorld(), 6.5, 74, 24.5, 165, 0), new Location(map.getWorld(), 12.5, 74, 21.5, 150, 0), new Location(map.getWorld(), 17.5, 74, 18.5, 135, 0), new Location(map.getWorld(), 20.5, 74, 13.5, 120, 0), new Location(map.getWorld(), 23.5, 74, 7.5, 105, 0), new Location(map.getWorld(), 24.5, 74, 0.5, 90, 0), new Location(map.getWorld(), 23.5, 74, -6.5, 75, 0), new Location(map.getWorld(), 20.5, 74, -12.5, 60, 0), new Location(map.getWorld(), 17.5, 74, -17.5, 45, 0), new Location(map.getWorld(), 12.5, 74, -20.5, 30, 0), new Location(map.getWorld(), 6.5, 74, -23.5, 15, 0), new Location(map.getWorld(), -0.5, 74, -24.5, 0, 0), new Location(map.getWorld(), -7.5, 74, -23.5, -15, 0), new Location(map.getWorld(), -13.5, 74, -20.5, -30, 0), new Location(map.getWorld(), -18.5, 74, -17.5, -45, 0), new Location(map.getWorld(), -21.5, 74, -12.5, -60, 0), new Location(map.getWorld(), -24.5, 74, -6.5, -75, 0), new Location(map.getWorld(), -25.5, 74, 0.5, -90, 0), new Location(map.getWorld(), -24.5, 74, 7.5, -105, 0), new Location(map.getWorld(), -21.5, 74, 13.5, -120, 0), new Location(map.getWorld(), -18.5, 74, 18.5, -135, 0), new Location(map.getWorld(), -13.5, 74, 21.5, -150, 0), new Location(map.getWorld(), -7.5, 74, 24.5, -165, 0)));
				sgmaps.add(map);
			}
			{
				Map map = new Map("Rise of the Orient", "Team OPAlien", MiniGameType.SURVIVAL_GAMES, "Rise_of_the_Orient", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 0.5, 49.5, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), 0.5, 26, 20.5, 180, 0), new Location(map.getWorld(), 5.5, 26, 19.5, 165, 0), new Location(map.getWorld(), 10.5, 26, 17.5, 150, 0), new Location(map.getWorld(), 14.5, 26, 20.5, 135, 0), new Location(map.getWorld(), 17.5, 26, 10.5, 120, 0), new Location(map.getWorld(), 19.5, 26, 5.5, 105, 0), new Location(map.getWorld(), 19.5, 26, 0.5, 90, 0), new Location(map.getWorld(), 19.5, 26, -4.5, 75, 0), new Location(map.getWorld(), 17.5, 26, -9.5, 60, 0), new Location(map.getWorld(), 14.5, 26, -13.5, 45, 0), new Location(map.getWorld(), 10.5, 26, -16.5, 30, 0), new Location(map.getWorld(), 5.5, 26, -18.5, 15, 0), new Location(map.getWorld(), 0.5, 26, -18.5, 0, 0), new Location(map.getWorld(), 4.5, 26, -18.5, -15, 0), new Location(map.getWorld(), -9.5, 26, -16.5, -30, 0), new Location(map.getWorld(), -13.5, 26, -13.5, -45, 0), new Location(map.getWorld(), -16.5, 26, -9.5, -60, 0), new Location(map.getWorld(), -18.5, 26, -4.5, -75, 0), new Location(map.getWorld(), -18.5, 26, 0.5, -90, 0), new Location(map.getWorld(), -18.5, 26, 5.5, -105, 0), new Location(map.getWorld(), -16.5, 26, 10.5, -120, 0), new Location(map.getWorld(), -13.5, 26, 14.5, -135, 0), new Location(map.getWorld(), -9.5, 26, 17.5, -150, 0), new Location(map.getWorld(), -4.5, 26, 19.5, -165, 0)));
				sgmaps.add(map);
			}
			this.maps.put(MiniGameType.SURVIVAL_GAMES, sgmaps);
			
			List<Map> uhcmaps = new ArrayList<Map>();
			{
				Map map = new Map("UHC World", "rienk222§7, §6playwarrior§7, §6eekhoorn2000", MiniGameType.ULTRA_HARD_CORE, "UHC_1", true);
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -400.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -400.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -400.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 0.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 400.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 400.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 300.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 300.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 0.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 300.5, 90, 0)));
				uhcmaps.add(map);
			}
			/*{
				Map map = new Map("UHC World", "rienk222§7, §6playwarrior§7, §6eekhoorn2000", MiniGameType.ULTRA_HARD_CORE, "UHC_2", true);
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -400.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -400.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -400.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 0.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 400.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 400.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 300.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 300.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 0.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 300.5, 90, 0)));
				uhcmaps.add(map);
			}
			{
				Map map = new Map("UHC World", "rienk222§7, §6playwarrior§7, §6eekhoorn2000", MiniGameType.ULTRA_HARD_CORE, "UHC_3", true);
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -400.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -400.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -400.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 0.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -400.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -300.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -300.5, 100, 400.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -200.5, 100, -100.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 100.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -200.5, 100, 400.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -400.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -300.5, 90, 0), new Location(map.getWorld(), -100.5, 100, -200.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 200.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 300.5, 90, 0), new Location(map.getWorld(), -100.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 100.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 300.5, 90, 0), new Location(map.getWorld(), 100.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 200.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 300.5, 90, 0), new Location(map.getWorld(), 200.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -400.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 300.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 300.5, 100, 400.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -300.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -200.5, 90, 0), new Location(map.getWorld(), 400.5, 100, -100.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 0.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 100.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 200.5, 90, 0), new Location(map.getWorld(), 400.5, 100, 300.5, 90, 0)));
				uhcmaps.add(map);
			}*/
			this.maps.put(MiniGameType.ULTRA_HARD_CORE, uhcmaps);
			
			List<Map> swmaps = new ArrayList<Map>();
			{
				Map map = new Map("Balloons", "partycasper", MiniGameType.SKYWARS, "Balloons", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 0.5, 84, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), 11.5, 103, 25.5, 156, 0), new Location(map.getWorld(), -10.5, 103, 25.5, -156, 0), new Location(map.getWorld(), -20.5, 103, 9.5, -113, 0), new Location(map.getWorld(), -20.5, 103, -8.5, -66, 0), new Location(map.getWorld(), -10.5, 103, -24.5, -24, 0), new Location(map.getWorld(), 11.5, 103, -24.5, 24, 0), new Location(map.getWorld(), 21.5, 103, -8.5, 67, 0), new Location(map.getWorld(), 21.5, 103, 9.5, 113, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), 1, 72, 3), new Location(map.getWorld(), -1, 72, 3), new Location(map.getWorld(), 2, 72, -1), new Location(map.getWorld(), -1, 72, -3), new Location(map.getWorld(), 0, 72, -4)));
				swmaps.add(map);
			}
			{
				Map map = new Map("Candy", "Koning_paul§7, §6Brutuske02", MiniGameType.SKYWARS, "Candy", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 1.5, 86, -1.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -16.5, 80, -17.5, -50, 0), new Location(map.getWorld(), 1.5, 80, -29.5, 0, 0), new Location(map.getWorld(), 19.5, 80, -17.5, 50, 0), new Location(map.getWorld(), 31.5, 80, 0.5, 90, 0), new Location(map.getWorld(), 19.5, 80, 18.5, 138, 0), new Location(map.getWorld(), 1.5, 80, 30.5, 180, 0), new Location(map.getWorld(), -16.5, 80, 18.5, 138, 0), new Location(map.getWorld(), -28.5, 80, 0.5, -90, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), 1, 84, -5), new Location(map.getWorld(), 3, 80, -2), new Location(map.getWorld(), 1, 80, 0), new Location(map.getWorld(), -1, 80, -2), new Location(map.getWorld(), 9, 80, -5), new Location(map.getWorld(), 2, 73, -5), new Location(map.getWorld(), -5, 72, -2), new Location(map.getWorld(), 1, 70, 5)));
				swmaps.add(map);
			}
			{
				Map map = new Map("Citadel", "rienk222", MiniGameType.SKYWARS, "Citadel", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 0.5, 85.5, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -23.5, 78, 0.5, -90, 0), new Location(map.getWorld(), -17.5, 78, -17.5, -45, 0), new Location(map.getWorld(), 0.5, 78, -23.5, 0, 0), new Location(map.getWorld(), 18.5, 78, -17.5, 45, 0), new Location(map.getWorld(), 24.5, 78, 0.5, 90, 0), new Location(map.getWorld(), 18.5, 78, 18.5, 135, 0), new Location(map.getWorld(), 0.5, 78, 24.5, 180, 0), new Location(map.getWorld(), -17.5, 78, 18.5, -135, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), 0, 70, 4), new Location(map.getWorld(), 0, 70, -4), new Location(map.getWorld(), 1, 64, -2), new Location(map.getWorld(), 1, 64, 2), new Location(map.getWorld(), -1, 64, 2), new Location(map.getWorld(), -1, 64, -2)));
				swmaps.add(map);
			}
			{
				Map map = new Map("Mesa", "Koning_paul§7, §6Brutuske02§7, §6partycasper", MiniGameType.SKYWARS, "Mesa", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 0.5, 77, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), 6.5, 85, -24.5, 15, 0), new Location(map.getWorld(), 24.5, 85, -15.5, 55, 0), new Location(map.getWorld(), 29.5, 85, 0.5, 90, 0), new Location(map.getWorld(), 22.5, 85, 13.5, 120, 0), new Location(map.getWorld(), 1.5, 85, 28.5, -180, 0), new Location(map.getWorld(), -15.5, 85, 22.5, -142, 0), new Location(map.getWorld(), -24.5, 85, 1.5, -90, 0), new Location(map.getWorld(), -12.5, 85, -21.5, -30, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), 6, 69, -7), new Location(map.getWorld(), 8, 70, 7), new Location(map.getWorld(), -7, 71, 11), new Location(map.getWorld(), -8, 70, -6), new Location(map.getWorld(), 2, 70, -3), new Location(map.getWorld(), 2, 70, 3), new Location(map.getWorld(), -2, 70, 3), new Location(map.getWorld(), -2, 70, -3), new Location(map.getWorld(), 2, 66, 0)));
				swmaps.add(map);
			}
			{
				Map map = new Map("Snowy", "Koning_paul§7, §6Brutuske02", MiniGameType.SKYWARS, "Snowy", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 0.5, 76.25, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -5.5,  78, -39.5, -8, 0), new Location(map.getWorld(), 6.5, 78, 39.5, 9, 0), new Location(map.getWorld(), 6.5, 78, -27.5, 13, 0), new Location(map.getWorld(), -5.5, 78, -27.5, -12, 0), new Location(map.getWorld(), 6.5, 78, 40.5, 171, 0), new Location(map.getWorld(), -5.5, 78, 40.5, -171, 0), new Location(map.getWorld(), -5.5, 78, 28.5, -168, 0), new Location(map.getWorld(), 6.5, 78, 28.5, 168, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), -10, 72, 3), new Location(map.getWorld(), 9, 73, 12), new Location(map.getWorld(), 3, 73, -2), new Location(map.getWorld(), -6, 76, -8), new Location(map.getWorld(), -1, 69, 1), new Location(map.getWorld(), -1, 69, -1), new Location(map.getWorld(), 1, 69, -1), new Location(map.getWorld(), 1, 69, 1), new Location(map.getWorld(), 0, 64, 0)));
				swmaps.add(map);
			}
			{
				Map map = new Map("Transparent", "playwarrior", MiniGameType.SKYWARS, "Transparent", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 0.5, 70.75, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), 0.5, 80, -33.5, 0, 0), new Location(map.getWorld(), 23.5, 80, -23.5, 45, 0), new Location(map.getWorld(), 35.5, 80, 0.5, 90, 0), new Location(map.getWorld(), 24.5, 80, 23.5, 132, 0), new Location(map.getWorld(), 0.5, 80, 35.5, 180, 0), new Location(map.getWorld(), -22.5, 80, 24.5, -138, 0), new Location(map.getWorld(), -34.5, 80, 0.5, -90, 0), new Location(map.getWorld(), -23.5, 80, -22.5, -45, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), 0, 78, -6), new Location(map.getWorld(), 6, 78, 0), new Location(map.getWorld(), 0, 78, 6), new Location(map.getWorld(), -6, 78, 0), new Location(map.getWorld(), 0, 64, 0)));
				swmaps.add(map);
			}
			{
				Map map = new Map("Village", "partycasper", MiniGameType.SKYWARS, "Village", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 1, 76, 0.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -30.5, 87, 15.5, -117, 0), new Location(map.getWorld(), -30.5, 87, -14.5, -64, 0), new Location(map.getWorld(), -14.5, 87, -30.5, -27, 0), new Location(map.getWorld(), -15.5, 87, -30.5, 27, 0), new Location(map.getWorld(), 31.5, 87, -14.5, 63, 0), new Location(map.getWorld(), 31.5, 87, 15.5, 116, 0), new Location(map.getWorld(), 15.5, 87, 31.5, 154, 0), new Location(map.getWorld(), -14.5, 87, 31.5, -154, 0)));
				map.setSWTier2Chests(Arrays.asList(new Location(map.getWorld(), 4, 69, -2), new Location(map.getWorld(), 4, 69, 2), new Location(map.getWorld(), -3, 69, 2), new Location(map.getWorld(), -3, 69, -2), new Location(map.getWorld(), -1, 70, 2), new Location(map.getWorld(), -1, 70, 1), new Location(map.getWorld(), 2, 70, -2), new Location(map.getWorld(), 2, 70, -1), new Location(map.getWorld(), -1, 65, 2), new Location(map.getWorld(), -1, 65, 1)));
				swmaps.add(map);
			}
			this.maps.put(MiniGameType.SKYWARS, swmaps);
			
			List<Map> cfmaps = new ArrayList<Map>();
			{
				Map map = new Map("Herobrine's Arena", "sharewoods§7, §6eekhoorn2000§7, §6Selasie", MiniGameType.CHICKEN_FIGHT, "HerobrinesArena", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 4.5, 20, 3.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -0.5, 8, 15.5, -160, 0), new Location(map.getWorld(), -7.5, 8, 7.5, -108, 0), new Location(map.getWorld(), 2.5, 8, -8.5, -10, 0), new Location(map.getWorld(), 10.5, 8, 8.5, 130, 0), new Location(map.getWorld(), 17.5, 8, 0.5, 77, 0), new Location(map.getWorld(), 8.5, 8, 16.5, 162, 0), new Location(map.getWorld(), -6.5, 8, 13.5, -132, 0), new Location(map.getWorld(), -7.5, 8, -8.5, -45, 0), new Location(map.getWorld(), 13.5, 8, -5.5, 45, 0), new Location(map.getWorld(), 0.5, 8, 0.5, -54, 0), new Location(map.getWorld(), 16.5, 8, 13.5, 130, 0), new Location(map.getWorld(), 16.5, 8, 5.5, 99, 0), new Location(map.getWorld(), 3.5, 8, 9.5, -169, 0), new Location(map.getWorld(), -11.5, 8, 2.5, -86, 0), new Location(map.getWorld(), 8.5, 8, -14.5, 12, 0), new Location(map.getWorld(), 12.5, 8, 1.5, 75, 0)));
				cfmaps.add(map);
			}
			{
				Map map = new Map("Lava Island", "O_o_Fadi_o_O", MiniGameType.CHICKEN_FIGHT, "LavaIsland", false);
				map.setSpectatorLocation(new Location(map.getWorld(), 4.5, 80, 2.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -2.5, 64, -9.5, -30, 0), new Location(map.getWorld(), -1.5, 66, -0.5, -90, 0), new Location(map.getWorld(), 4.5, 64, 11.5, 163, 0), new Location(map.getWorld(), 14.5, 64, 4.5, 111, 0), new Location(map.getWorld(), 10.5, 64, -2.5, 74, 0), new Location(map.getWorld(), 9.5, 65, 9.5, 140, 0), new Location(map.getWorld(), -0.5, 64, 8.5, -165, 0), new Location(map.getWorld(), 1.5, 67, 1.5, -164, 0), new Location(map.getWorld(), 4.5, 64, -8.5, 15, 0), new Location(map.getWorld(), -7.5, 64, -3.5, -76, 0), new Location(map.getWorld(), -5.5, 64, 2.5, -115, 0), new Location(map.getWorld(), -6.5, 64, 10.5, -145, 0), new Location(map.getWorld(), 10.5, 66, 16.5, 153, 0), new Location(map.getWorld(), 5.5, 64, 17.5, 167, 0), new Location(map.getWorld(), -5.5, 64, 14.5, -154, 0), new Location(map.getWorld(), 8.5, 64, 4.5, 130, 0)));
				cfmaps.add(map);
			}
			{
				Map map = new Map("The Netherlands", "rienk222§7, §6casidas§7, §6jim5491158", MiniGameType.CHICKEN_FIGHT, "TheNetherlands", false);
				map.setSpectatorLocation(new Location(map.getWorld(), -5.5, 50, 8.5, 180, 0));
				map.setSpawns(Arrays.asList(new Location(map.getWorld(), -17.5, 38, 0.5, -57, 0), new Location(map.getWorld(), -5.5, 40, -9.5, 0, 0), new Location(map.getWorld(), 4.5, 38, -2.5, 42, 0), new Location(map.getWorld(), 4.5, 40, 9.5, 95, 0), new Location(map.getWorld(), 2.5, 38, 20.5, 147, 0), new Location(map.getWorld(), -11.5, 38, 32.5, -166, 0), new Location(map.getWorld(), -27.5, 38, 16.5, -111, 0), new Location(map.getWorld(), -32.5, 38, 10.5, -94, 0), new Location(map.getWorld(), -27.5, 38, -2.5, -63, 0), new Location(map.getWorld(), -17.5, 38, -13.5, -29, 0), new Location(map.getWorld(), 14.5, 38, 0.5, 69, 0), new Location(map.getWorld(), 13.5, 38, 20.5, 122, 0), new Location(map.getWorld(), 21.5, 38, 10.5, 92, 0), new Location(map.getWorld(), 6.5, 38, -10.5, 32, 0), new Location(map.getWorld(), -12.5, 40, 13.5, -125, 0), new Location(map.getWorld(), -9.5, 38, -3.5, -18, 0)));
				cfmaps.add(map);
			}
			this.maps.put(MiniGameType.CHICKEN_FIGHT, cfmaps);
		}
		
		private void registerArenas(){
			this.arenas = new ArrayList<Arena>();
			this.arenas.add(new Arena(MiniGameType.SURVIVAL_GAMES, 1, new Location(getLobbyWorld(), -0.5, 70, 0.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.SURVIVAL_GAMES, 2, new Location(getLobbyWorld(), 1000.5, 70, 0.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.SURVIVAL_GAMES, 3, new Location(getLobbyWorld(), 0.5, 70, 1000.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.ULTRA_HARD_CORE, 1, new Location(getLobbyWorld(), -999.5, 70, 0.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.SKYWARS, 1, new Location(getLobbyWorld(), 0.5, 70, -999.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.SKYWARS, 2, new Location(getLobbyWorld(), 0.5, 70, 2000.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.SKYWARS, 3, new Location(getLobbyWorld(), 0.5, 70, -1999.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.CHICKEN_FIGHT, 1, new Location(getLobbyWorld(), 2000.5, 70, 0.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.CHICKEN_FIGHT, 2, new Location(getLobbyWorld(), -1999.5, 70, 0.5, 180, 0)));
			this.arenas.add(new Arena(MiniGameType.CHICKEN_FIGHT, 3, new Location(getLobbyWorld(), 1000.5, 70, 1000.5, 180, 0)));
		}
		
		private void spawnNPCs(){
			for(Arena arena : getArenas()){
				arena.spawnNPCs();
			}
		}
		
		private void registerSGChestItems(){
			this.sgchestitems = new ArrayList<ChestItem>();
			this.sgchestitems.add(new ChestItem(Material.STONE_SWORD, 1, 1, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.COOKED_BEEF, 1, 2, null, 0, 30));
			this.sgchestitems.add(new ChestItem(Material.DIAMOND, 1, 1, null, 0, 2));
			this.sgchestitems.add(new ChestItem(Material.GOLD_AXE, 1, 1, null, 0, 10));
			this.sgchestitems.add(new ChestItem(Material.CAKE, 1, 1, null, 0, 15));
			this.sgchestitems.add(new ChestItem(Material.COOKED_CHICKEN, 1, 3, "§cChili Chicken", 0, 35));
			this.sgchestitems.add(new ChestItem(Material.BAKED_POTATO, 1, 4, null, 0, 40));
			this.sgchestitems.add(new ChestItem(Material.PORK, 1, 3, null, 0, 38));
			this.sgchestitems.add(new ChestItem(Material.WOOD_SWORD, 1, 1, null, 0, 10));
			this.sgchestitems.add(new ChestItem(Material.CHAINMAIL_CHESTPLATE, 1, 1, null, 0, 9));
			this.sgchestitems.add(new ChestItem(Material.CHAINMAIL_LEGGINGS, 1, 1, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.CHAINMAIL_HELMET, 1, 1, null, 0, 10));
			this.sgchestitems.add(new ChestItem(Material.CHAINMAIL_BOOTS, 1, 1, null, 0, 11));
			this.sgchestitems.add(new ChestItem(Material.LEATHER_CHESTPLATE, 1, 1, null, 0, 21));
			this.sgchestitems.add(new ChestItem(Material.LEATHER_LEGGINGS, 1, 1, null, 0, 22));
			this.sgchestitems.add(new ChestItem(Material.LEATHER_HELMET, 1, 1, null, 0, 26));
			this.sgchestitems.add(new ChestItem(Material.LEATHER_BOOTS, 1, 1, null, 0, 26));
			this.sgchestitems.add(new ChestItem(Material.IRON_HELMET, 1, 1, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.IRON_BOOTS, 1, 1, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.IRON_CHESTPLATE, 1, 1, null, 0, 5));
			this.sgchestitems.add(new ChestItem(Material.IRON_LEGGINGS, 1, 1, null, 0, 5));
			this.sgchestitems.add(new ChestItem(Material.GOLD_HELMET, 1, 1, null, 0, 16));
			this.sgchestitems.add(new ChestItem(Material.GOLD_BOOTS, 1, 1, null, 0, 17));
			this.sgchestitems.add(new ChestItem(Material.GOLD_CHESTPLATE, 1, 1, null, 0, 14));
			this.sgchestitems.add(new ChestItem(Material.GOLD_LEGGINGS, 1, 1, null, 0, 13));
			this.sgchestitems.add(new ChestItem(Material.STICK, 1, 2, null, 0, 13));
			this.sgchestitems.add(new ChestItem(Material.APPLE, 1, 2, null, 0, 17));
			this.sgchestitems.add(new ChestItem(Material.GOLD_INGOT, 1, 5, null, 0, 14));
			this.sgchestitems.add(new ChestItem(Material.IRON_INGOT, 1, 1, null, 0, 4));
			this.sgchestitems.add(new ChestItem(Material.WOOD_AXE, 1, 1, null, 0, 25));
			this.sgchestitems.add(new ChestItem(Material.STONE_AXE, 1, 1, null, 0, 9));
			this.sgchestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 10));
			this.sgchestitems.add(new ChestItem(Material.ARROW, 1, 5, null, 0, 15));
			this.sgchestitems.add(new ChestItem(Material.ROTTEN_FLESH, 1, 4, null, 0, 45));
			this.sgchestitems.add(new ChestItem(Material.BOWL, 1, 4, null, 0, 30));
			this.sgchestitems.add(new ChestItem(Material.EXP_BOTTLE, 1, 5, null, 0, 13));
			this.sgchestitems.add(new ChestItem(Material.GOLD_SWORD, 1, 1, null, 0, 11));
			this.sgchestitems.add(new ChestItem(Material.FISHING_ROD, 1, 1, null, 0, 16));
			this.sgchestitems.add(new ChestItem(Material.FLINT, 1, 3, null, 0, 13));
			this.sgchestitems.add(new ChestItem(Material.FEATHER, 1, 3, null, 0, 11));
			this.sgchestitems.add(new ChestItem(Material.STRING, 1, 2, null, 0, 16));
			this.sgchestitems.add(new ChestItem(Material.FLINT_AND_STEEL, 1, 1, null, 64, 6));
			this.sgchestitems.add(new ChestItem(Material.BOAT, 1, 1, null, 0, 12));
			this.sgchestitems.add(new ChestItem(Material.WHEAT, 1, 5, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.COOKIE, 1, 3, null, 0, 6));
			this.sgchestitems.add(new ChestItem(Material.MELON, 1, 5, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.COOKED_FISH, 1, 2, null, 0, 9));
			this.sgchestitems.add(new ChestItem(Material.RAW_FISH, 1, 4, null, 0, 8));
			this.sgchestitems.add(new ChestItem(Material.CARROT_ITEM, 1, 2, null, 0, 11));
			this.sgchestitems.add(new ChestItem(Material.POTATO_ITEM, 1, 6, null, 0, 13));
			this.sgchestitems.add(new ChestItem(Material.COMPASS, 1, 1, "§6§lPlayer Tracker", 0, 4));
			this.sgchestitems.add(new ChestItem(Material.TNT, 1, 3, null, 0, 6));
			
			this.sgchestpotions = new ArrayList<ChestItem>();
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8193, 10));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8225, 5));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8194, 15));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8226, 5));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8227, 8));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8259, 8));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16388, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16420, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16452, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16453, 5));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16421, 2));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8261, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8262, 8));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16424, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16456, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8201, 2));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16426, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16458, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8203, 4));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8235, 4));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16460, 6));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 16428, 6));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8269, 7));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8238, 3));
			this.sgchestpotions.add(new ChestItem(Material.POTION, 1, 1, null, 8270, 2));
		}
		
		private void registerSWChestItems(){
			this.swchestitems = new ArrayList<ChestItem>();
			this.swchestitems.add(new ChestItem(Material.STONE_SWORD, 1, 1, null, 0, 8));
			this.swchestitems.add(new ChestItem(Material.STONE_SWORD, 1, 1, null, 0, 4, Enchantment.DAMAGE_ALL, 1));
			this.swchestitems.add(new ChestItem(Material.COOKED_BEEF, 1, 16, null, 0, 30));
			this.swchestitems.add(new ChestItem(Material.BAKED_POTATO, 1, 16, null, 0, 40));
			this.swchestitems.add(new ChestItem(Material.WOOD_SWORD, 1, 1, null, 0, 30));
			this.swchestitems.add(new ChestItem(Material.CHAINMAIL_CHESTPLATE, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.CHAINMAIL_LEGGINGS, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.CHAINMAIL_HELMET, 1, 1, null, 0, 5));
			this.swchestitems.add(new ChestItem(Material.CHAINMAIL_BOOTS, 1, 1, null, 0, 5));
			this.swchestitems.add(new ChestItem(Material.LEATHER_CHESTPLATE, 1, 1, null, 0, 20));
			this.swchestitems.add(new ChestItem(Material.LEATHER_LEGGINGS, 1, 1, null, 0, 25));
			this.swchestitems.add(new ChestItem(Material.LEATHER_HELMET, 1, 1, null, 0, 25));
			this.swchestitems.add(new ChestItem(Material.LEATHER_BOOTS, 1, 1, null, 0, 20));
			this.swchestitems.add(new ChestItem(Material.IRON_HELMET, 1, 1, null, 0, 5));
			this.swchestitems.add(new ChestItem(Material.IRON_BOOTS, 1, 1, null, 0, 5));
			this.swchestitems.add(new ChestItem(Material.IRON_CHESTPLATE, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.IRON_LEGGINGS, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.GOLD_HELMET, 1, 1, null, 0, 6));
			this.swchestitems.add(new ChestItem(Material.GOLD_BOOTS, 1, 1, null, 0, 6));
			this.swchestitems.add(new ChestItem(Material.GOLD_CHESTPLATE, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.GOLD_LEGGINGS, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.GOLDEN_APPLE, 1, 3, null, 0, 3));
			this.swchestitems.add(new ChestItem(Material.WOOD_AXE, 1, 1, null, 0, 30));
			this.swchestitems.add(new ChestItem(Material.STONE_AXE, 1, 1, null, 0, 6));
			this.swchestitems.add(new ChestItem(Material.STONE_AXE, 1, 1, null, 0, 6, Enchantment.DIG_SPEED, 2));
			this.swchestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 2, Enchantment.ARROW_DAMAGE, 1));
			this.swchestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 2, Enchantment.ARROW_KNOCKBACK, 1));
			this.swchestitems.add(new ChestItem(Material.ARROW, 1, 20, null, 0, 10));
			this.swchestitems.add(new ChestItem(Material.EXP_BOTTLE, 1, 32, null, 0, 10));
			this.swchestitems.add(new ChestItem(Material.FISHING_ROD, 1, 1, null, 0, 10));
			this.swchestitems.add(new ChestItem(Material.COOKIE, 1, 64, null, 0, 6));
			this.swchestitems.add(new ChestItem(Material.COOKED_FISH, 1, 20, null, 0, 8));
			this.swchestitems.add(new ChestItem(Material.COMPASS, 1, 1, "§6§lPlayer Tracker", 0, 1));
			this.swchestitems.add(new ChestItem(Material.ENDER_PEARL, 1, 3, null, 0, 2));
			this.swchestitems.add(new ChestItem(Material.SNOW_BALL, 1, 16, null, 0, 20));
			this.swchestitems.add(new ChestItem(Material.EGG, 1, 16, null, 0, 20));
			this.swchestitems.add(new ChestItem(Material.LOG, 1, 16, null, 0, 20));
			this.swchestitems.add(new ChestItem(Material.STONE, 10, 48, null, 0, 30));
			this.swchestitems.add(new ChestItem(Material.COBBLESTONE, 16, 64, null, 0, 20));
			this.swchestitems.add(new ChestItem(Material.WOOD, 16, 32, null, 0, 30));
			this.swchestitems.add(new ChestItem(Material.FLINT_AND_STEEL, 1, 1, null, 0, 2));
			this.swchestitems.add(new ChestItem(Material.LAVA_BUCKET, 1, 1, null, 0, 2));
			this.swchestitems.add(new ChestItem(Material.IRON_SWORD, 1, 1, null, 0, 4));
			this.swchestitems.add(new ChestItem(Material.STONE_PICKAXE, 1, 1, null, 0, 8));
			this.swchestitems.add(new ChestItem(Material.IRON_PICKAXE, 1, 1, null, 0, 7));
			
			this.swtier2chestitems = new ArrayList<ChestItem>();
			this.swtier2chestitems.add(new ChestItem(Material.COMPASS, 1, 1, "§6§lPlayer Tracker", 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.TNT, 1, 13, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.ENDER_PEARL, 1, 3, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 4, Enchantment.ARROW_DAMAGE, 1));
			this.swtier2chestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 2, Enchantment.ARROW_DAMAGE, 2));
			this.swtier2chestitems.add(new ChestItem(Material.BOW, 1, 1, null, 0, 4, Enchantment.ARROW_KNOCKBACK, 1));
			this.swtier2chestitems.add(new ChestItem(Material.EXP_BOTTLE, 1, 32, null, 0, 10));
			this.swtier2chestitems.add(new ChestItem(Material.FISHING_ROD, 1, 1, null, 0, 10));
			this.swtier2chestitems.add(new ChestItem(Material.ARROW, 1, 20, null, 0, 10));
			this.swtier2chestitems.add(new ChestItem(Material.STONE_AXE, 1, 1, null, 0, 6, Enchantment.DIG_SPEED, 2));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_CHESTPLATE, 1, 1, null, 0, 1));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_HELMET, 1, 1, null, 0, 2));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_BOOTS, 1, 1, null, 0, 2));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_LEGGINGS, 1, 1, null, 0, 1));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_LEGGINGS, 1, 1, null, 0, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_HELMET, 1, 1, null, 0, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_BOOTS, 1, 1, null, 0, 1, Enchantment.PROTECTION_PROJECTILE, 2));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_HELMET, 1, 1, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_BOOTS, 1, 1, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_BOOTS, 1, 1, null, 0, 5, Enchantment.PROTECTION_FALL, 3));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_CHESTPLATE, 1, 1, null, 0, 4));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_CHESTPLATE, 1, 1, null, 0, 3, Enchantment.PROTECTION_EXPLOSIONS, 3));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_CHESTPLATE, 1, 1, null, 0, 2, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_CHESTPLATE, 1, 1, null, 0, 2, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_LEGGINGS, 1, 1, null, 0, 4));
			this.swtier2chestitems.add(new ChestItem(Material.GOLD_HELMET, 1, 1, null, 0, 7));
			this.swtier2chestitems.add(new ChestItem(Material.GOLD_BOOTS, 1, 1, null, 0, 7));
			this.swtier2chestitems.add(new ChestItem(Material.GOLD_CHESTPLATE, 1, 1, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.GOLD_LEGGINGS, 1, 1, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.GOLDEN_APPLE, 1, 3, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.CHAINMAIL_CHESTPLATE, 1, 1, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.CHAINMAIL_LEGGINGS, 1, 1, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.CHAINMAIL_HELMET, 1, 1, null, 0, 6));
			this.swtier2chestitems.add(new ChestItem(Material.CHAINMAIL_BOOTS, 1, 1, null, 0, 6));
			this.swtier2chestitems.add(new ChestItem(Material.STONE_SWORD, 1, 1, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.STONE_SWORD, 1, 1, null, 0, 4, Enchantment.DAMAGE_ALL, 1));
			this.swtier2chestitems.add(new ChestItem(Material.COOKED_BEEF, 1, 16, null, 0, 30));
			this.swtier2chestitems.add(new ChestItem(Material.BAKED_POTATO, 1, 16, null, 0, 40));
			this.swtier2chestitems.add(new ChestItem(Material.SNOW_BALL, 1, 16, null, 0, 30));
			this.swtier2chestitems.add(new ChestItem(Material.EGG, 1, 16, null, 0, 30));
			this.swtier2chestitems.add(new ChestItem(Material.LOG, 16, 32, null, 0, 7));
			this.swtier2chestitems.add(new ChestItem(Material.STONE, 16, 32, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.COBBLESTONE, 16, 64, null, 0, 10));
			this.swtier2chestitems.add(new ChestItem(Material.WOOD, 16, 64, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.FLINT_AND_STEEL, 1, 1, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.LAVA_BUCKET, 1, 1, null, 0, 5));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_SWORD, 1, 1, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_SWORD, 1, 1, null, 0, 4));
			this.swtier2chestitems.add(new ChestItem(Material.DIAMOND_PICKAXE, 1, 1, null, 0, 8));
			this.swtier2chestitems.add(new ChestItem(Material.IRON_PICKAXE, 1, 1, null, 0, 7));
		}
	}
}
