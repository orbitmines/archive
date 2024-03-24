package me.O_o_Fadi_o_O.Hub;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.O_o_Fadi_o_O.Hub.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.NMS.CustomChicken;
import me.O_o_Fadi_o_O.Hub.NMS.CustomCow;
import me.O_o_Fadi_o_O.Hub.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Hub.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.Hub.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.Hub.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.Hub.NMS.CustomPig;
import me.O_o_Fadi_o_O.Hub.NMS.CustomServerSelector;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSheep;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSlime;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSpider;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSquid;
import me.O_o_Fadi_o_O.Hub.NMS.CustomWolf;
import me.O_o_Fadi_o_O.Hub.events.AnimationEvent;
import me.O_o_Fadi_o_O.Hub.events.BlockChangeEvent;
import me.O_o_Fadi_o_O.Hub.events.BreakEvent;
import me.O_o_Fadi_o_O.Hub.events.ChunkUnload;
import me.O_o_Fadi_o_O.Hub.events.ClickEventENG;
import me.O_o_Fadi_o_O.Hub.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Hub.events.DamageEvent;
import me.O_o_Fadi_o_O.Hub.events.DespawnEvent;
import me.O_o_Fadi_o_O.Hub.events.DropEvent;
import me.O_o_Fadi_o_O.Hub.events.EntityDamage;
import me.O_o_Fadi_o_O.Hub.events.EntityDeath;
import me.O_o_Fadi_o_O.Hub.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Hub.events.ExplodeEvent;
import me.O_o_Fadi_o_O.Hub.events.FoodEvent;
import me.O_o_Fadi_o_O.Hub.events.JoinEvent;
import me.O_o_Fadi_o_O.Hub.events.PickupEvent;
import me.O_o_Fadi_o_O.Hub.events.PlaceEvent;
import me.O_o_Fadi_o_O.Hub.events.PlayerChat;
import me.O_o_Fadi_o_O.Hub.events.PlayerInteract;
import me.O_o_Fadi_o_O.Hub.events.PlayerMove;
import me.O_o_Fadi_o_O.Hub.events.ProjectileHit;
import me.O_o_Fadi_o_O.Hub.events.QuitEvent;
import me.O_o_Fadi_o_O.Hub.events.VoteEvent;
import me.O_o_Fadi_o_O.Hub.managers.ConfigManager;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.MasterMindManager;
import me.O_o_Fadi_o_O.Hub.managers.NPCManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.VoteManager;
import me.O_o_Fadi_o_O.Hub.runnables.BossBarRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.EntityRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.MasterMindRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.ParkourRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.PetRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.VoteRunnable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;

@SuppressWarnings("deprecation")
public class Hub extends JavaPlugin {

	static Connection connection;
    
	public static String Server = "hub";
	public static String TAG = "§3§lHub §8| §7";
	
	JoinEvent joinEvent = new JoinEvent(this);
	ServerSelector sinv = new ServerSelector(this);
	NPCManager npcManager = new NPCManager(this);
	
	BossBarRunnable bossBarRunnable = new BossBarRunnable(this);
	DatabaseRunnable databaseRunnable = new DatabaseRunnable(this);
	EntityRunnable entityRunnable = new EntityRunnable(this);
	PetRunnable petRunnable = new PetRunnable(this);
	PlayerRunnable playerRunnable = new PlayerRunnable(this);
	ScoreboardRunnable scoreboardRunnable = new ScoreboardRunnable(this);
	ServerSelectorRunnable serverSelectorRunnable = new ServerSelectorRunnable(this);
	VoteRunnable voteRunnable = new VoteRunnable(this);
	ParkourRunnable parkourRunnable = new ParkourRunnable(this);
	MasterMindRunnable mastermindRunnable = new MasterMindRunnable(this);
	
	protected static Field mapStringToClassField, mapClassToStringField, mapClassToIdField, mapStringToIdField;
	//protected static Field mapIdToClassField;
	
	static
	{
	    try
	    {
	        mapStringToClassField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("c");
	        mapClassToStringField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("d");
	        //mapIdtoClassField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("e");
	        mapClassToIdField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("f");
	        mapStringToIdField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("g");
	 
	        mapStringToClassField.setAccessible(true);
	        mapClassToStringField.setAccessible(true);
	        //mapIdToClassField.setAccessible(true);
	        mapClassToIdField.setAccessible(true);
	        mapStringToIdField.setAccessible(true);
	    }
	    catch(Exception e) {e.printStackTrace();}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static void addCustomEntity(Class entityClass, String name, int id)
	{
	    if (mapStringToClassField == null || mapStringToIdField == null || mapClassToStringField == null || mapClassToIdField == null)
	    {
	        return;
	    }
	    else
	    {
	        try
	        {
	            Map mapStringToClass = (Map) mapStringToClassField.get(null);
	            Map mapStringToId = (Map) mapStringToIdField.get(null);
	            Map mapClasstoString = (Map) mapClassToStringField.get(null);
	            Map mapClassToId = (Map) mapClassToIdField.get(null);
	 
	            mapStringToClass.put(name, entityClass);
	            mapStringToId.put(name, Integer.valueOf(id));
	            mapClasstoString.put(entityClass, name);
	            mapClassToId.put(entityClass, Integer.valueOf(id));
	 
	            mapStringToClassField.set(null, mapStringToClass);
	            mapStringToIdField.set(null, mapStringToId);
	            mapClassToStringField.set(null, mapClasstoString);
	            mapClassToIdField.set(null, mapClassToId);
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void onEnable(){
		
		setupAllCustomEntities();
		setupProtocolLibLibrary();
		removeAllEntities();
		registerAllEvents();
		
		npcManager.spawnAllOcelots(StorageManager.HubWorld);
		npcManager.spawnSkeleton(StorageManager.HubWorld, new Location(StorageManager.HubWorld, -396.5, 15, 1025.5, 0, 0), "§4§lPrison §c§lv3 §e§lAlpha", Material.ENDER_PEARL);
		npcManager.spawnParkourSkeleton(StorageManager.HubWorld, new Location(StorageManager.HubWorld, -336.5, 12, 1057.5, 65, 0), "§6§lParkour §8| §b§l250 VIP Points", Material.DIAMOND);
		npcManager.spawnMasterMindSkeleton(StorageManager.HubWorld, new Location(StorageManager.HubWorld, -439.5, 42, 985.5, 153, 0), "§c§lMasterMind §8| §e§lClick to Play", Material.WOOL);
		
		MasterMindManager.registerAllBlocksForTurn(StorageManager.HubWorld);
		MasterMindManager.registerAllBlockStatusForTurn(StorageManager.HubWorld);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeReceiving());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, Server + "Bungee");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, Server + "Bungee", new BungeeReceiving());

		ConfigManager.setup(this);

		if(ConfigManager.playerdata.getStringList("VoteRewardsNotGiven") != null){
			List<String> list = new ArrayList<String>();
			for(String s : ConfigManager.playerdata.getStringList("VoteRewardsNotGiven")){
				list.add(s);
			}
			StorageManager.VoteRewardsNotGiven.clear();
			StorageManager.VoteRewardsNotGiven.addAll(list);
		}
		
		startAllRunnables();
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadAfter5Seconds(p);
		}
		
		new BukkitRunnable(){
		
			public void run(){
				registerPlayersOnline("kitpvp");
				registerPlayersOnline("prison");
				registerPlayersOnline("creative");
				registerPlayersOnline("hub");
				registerPlayersOnline("skyblock");
				registerPlayersOnline("survival");
				registerPlayersOnline("minigames");
			}
		}.runTaskTimer(this, 0, 20);
	}
	
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(StorageManager.FireworkPasses.get(p.getName()) != null){
				try {
					DatabaseManager.setFireworksPasses(p, StorageManager.FireworkPasses.get(p.getName()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private void registerAllEvents(){
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEventENG(this), this);
		getServer().getPluginManager().registerEvents(new DropEvent(this), this);
		getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new PickupEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(this), this);
		getServer().getPluginManager().registerEvents(new BlockChangeEvent(this), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(this), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(this), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(this), this);
		getServer().getPluginManager().registerEvents(new DespawnEvent(), this);
		getServer().getPluginManager().registerEvents(new ChunkUnload(), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
		getServer().getPluginManager().registerEvents(new AnimationEvent(), this);
		getServer().getPluginManager().registerEvents(new BreakEvent(this), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(this), this);
	}
	
	private void startAllRunnables(){
		bossBarRunnable.startBossBarRunnable();
		databaseRunnable.startDatabaseRunnable();
		entityRunnable.startEntityRunnable();
		petRunnable.startPetRunnable();
		playerRunnable.startPlayerRunnable();
		scoreboardRunnable.startScoreboardRunnable();
		serverSelectorRunnable.startServerSelectorRunnable();
		voteRunnable.startVoteRunnable();
		parkourRunnable.startParkourRunnable();
		mastermindRunnable.startMasterMindRunnable();
	}
	
	public void registerPlayersOnline(String server){
	    
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
    
		try {
			out.writeUTF("PlayerCount");
		  	out.writeUTF(server);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Bukkit.getServer().sendPluginMessage(this, "BungeeCord", b.toByteArray());
  	}
	
	public void removeAllEntities(){
		for(World w : Bukkit.getWorlds()){
			for(Entity en : w.getEntities()){
				if(en instanceof Player){
					
				}
				else{
					en.remove();
				}
			}
		}
	}
	
	private void setupAllCustomEntities(){
		addCustomEntity(CustomMushroomCow.class, "CustomMushroomCow", 96);
		addCustomEntity(CustomPig.class, "CustomPig", 90);
		addCustomEntity(CustomWolf.class, "CustomWolf", 95);
		addCustomEntity(CustomSheep.class, "CustomSheep", 91);
		addCustomEntity(CustomMagmaCube.class, "CustomMagmaCube", 62);
		addCustomEntity(CustomSlime.class, "CustomSlime", 55);
		addCustomEntity(CustomCow.class, "CustomCow", 92);
		addCustomEntity(CustomSilverfish.class, "CustomSilverfish", 60);
		addCustomEntity(CustomOcelot.class, "CustomOcelot", 98);
		addCustomEntity(CustomServerSelector.class, "CustomServerSelector", 98);
		addCustomEntity(CustomSkeleton.class, "CustomSkeleton", 51);
		addCustomEntity(CustomCreeper.class, "CustomCreeper", 50);
		addCustomEntity(CustomSpider.class, "CustomSpider", 52);
		addCustomEntity(CustomSquid.class, "CustomSquid", 94);
		addCustomEntity(CustomChicken.class, "CustomChicken", 93);
	}
	
	private void setupProtocolLibLibrary(){
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, ConnectionSide.SERVER_SIDE, ListenerPriority.HIGH, Packets.Server.SET_SLOT, Packets.Server.WINDOW_ITEMS){
			
			@Override
			public void onPacketSending(PacketEvent e){
				if (e.getPacketID() == Packets.Server.SET_SLOT){
					addGlow(new ItemStack[] {e.getPacket().getItemModifier().read(0)});
				} else {
					addGlow(e.getPacket().getItemArrayModifier().read(0));
				}
			}
			
		});
		
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, PacketType.Play.Server.NAMED_SOUND_EFFECT){
			
		    @Override
		    public void onPacketSending(PacketEvent e){
		        String soundName = e.getPacket().getStrings().read(0);
		        if(soundName.startsWith("mob.cat")){
			        e.setCancelled(soundName.startsWith("mob.cat"));	
		        }
		        if(soundName.startsWith("mob.skeleton")){
			        e.setCancelled(soundName.startsWith("mob.skeleton"));	
		        }
		    }
		    
		});
	}
	
	private void addGlow(ItemStack[] stacks) {
		for(ItemStack stack : stacks){
			if(stack != null){
				if(stack.getType() != null && stack.getType() == Material.IRON_SWORD || stack.getType() != null && stack.getType() == Material.DIAMOND_PICKAXE || stack.getType() != null && stack.getType() == Material.WOOD_AXE){
					NbtCompound compound = (NbtCompound) NbtFactory.fromItemTag(stack);
					compound.put(NbtFactory.ofList("AttributeModifiers"));
				}
				if(stack.getEnchantmentLevel(Enchantment.SILK_TOUCH) == 32){
					NbtCompound compound = (NbtCompound) NbtFactory.fromItemTag(stack);
					compound.put(NbtFactory.ofList("ench"));
				}
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {

		if(cmd.getName().equalsIgnoreCase("staffhelp")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("Rank.Owner") || p.hasPermission("Rank.Moderator")){
					p.sendMessage("");
					p.sendMessage("§6§lOrbitMines§4§lPrison §e§lStaff Commands:");
					p.sendMessage(" §7- §6/opmode §7(Switch §4§lOP Mode§7)");
				}
				else{
					p.sendMessage(TAG + "§4§lDENIED§7! You have to be a §b§lModerator§7 to view this!");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("topvoters")){
			if(sender instanceof Player){
				int votes1 = 0;
				int votes2 = 0;
				int votes3 = 0;
				int votes4 = 0;
				int votes5 = 0;
				
				String name1 = "";
				String name2 = "";
				String name3 = "";
				String name4 = "";
				String name5 = "";
				
				for(String p : StorageManager.votesPlayers){
					int votes = StorageManager.votes.get(p);
					if(votes >= votes1){
						votes5 = votes4;
						votes4 = votes3;
						votes3 = votes2;
						votes2 = votes1;
						votes1 = votes;
						
						name5 = name4;
						name4 = name3;
						name3 = name2;
						name2 = name1;
						name1 = p;
						
					}
					else if(votes >= votes2){
						votes5 = votes4;
						votes4 = votes3;
						votes3 = votes2;
						votes2 = votes;
						
						name5 = name4;
						name4 = name3;
						name3 = name2;
						name2 = p;
					}
					else if(votes >= votes3){
						votes5 = votes4;
						votes4 = votes3;
						votes3 = votes;
						
						name5 = name4;
						name4 = name3;
						name3 = p;
					}
					else if(votes >= votes4){
						votes5 = votes4;
						votes4 = votes;
						
						name5 = name4;
						name4 = p;
					}
					else if(votes >= votes5){
						votes5 = votes;
						
						name5 = p;
					}
					else{}
				}
				
				Player p = (Player) sender;
				
				p.sendMessage("");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §b§lTop 5 Voters:");
				if(votes1 == 1){
					p.sendMessage("  §6§l1. §6" + name1 + " §7| §b" + votes1 + " Vote");
				}
				else{
					if(name1 == ""){
						p.sendMessage("  §6§l1. §6");
					}
					else{
						p.sendMessage("  §6§l1. §6" + name1 + " §7| §b" + votes1 + " Votes");
					}
				}
				if(votes2 == 1){
					p.sendMessage("  §6§l1. §6" + name2 + " §7| §b" + votes2 + " Vote");
				}
				else{
					if(name2 == ""){
						p.sendMessage("  §7§l2. §7");
					}
					else{
						p.sendMessage("  §7§l2. §7" + name2 + " §7| §b" + votes2 + " Votes");
					}
				}
				if(votes3 == 1){
					p.sendMessage("  §c§l3. §6" + name3 + " §7| §b" + votes3 + " Vote");
				}
				else{
					if(name3 == ""){
						p.sendMessage("  §c§l3. §c");
					}
					else{
						p.sendMessage("  §c§l3. §c" + name3 + " §7| §b" + votes3 + " Votes");
					}
				}
				if(votes4 == 1){
					p.sendMessage("  §8§l4. §8" + name4 + " §7| §b" + votes4 + " Vote");
				}
				else{
					if(name4 == ""){
						p.sendMessage("  §8§l4. §8");
					}
					else{
						p.sendMessage("  §8§l4. §8" + name4 + " §7| §b" + votes4 + " Votes");
					}
				}
				if(votes5 == 1){
					p.sendMessage("  §8§l5. §8" + name5 + " §7| §b" + votes5 + " Vote");
				}
				else{
					if(name5 == ""){
						p.sendMessage("  §8§l5. §8");
					}
					else{
						p.sendMessage("  §8§l5. §8" + name5 + " §7| §b" + votes5 + " Votes");
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("opmode")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp()){
					if(PlayerManager.isInOPMode(p)){
						StorageManager.PlayerInOPMode.put(p, false);
						p.sendMessage(TAG + "Your §4§lOP Mode§7 is now §c§lDISABLED§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
					else{
						StorageManager.PlayerInOPMode.put(p, true);
						p.sendMessage(TAG + "Your §4§lOP Mode§7 is now §a§lENABLED§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("vote")){
			
		}
		if(cmd.getName().equalsIgnoreCase("resetMonthlyVIPPoints")){
			if(sender.isOp()){
				
				if(a.length == 1){
					Player player = null;
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName().equalsIgnoreCase(a[0])){
							player = p;
						}
					}
					
					if(player != null){
						
						ConfigManager.playerdata.set("players." + player.getName() + ".ClaimedMonthlyVIPPoints", false);
						ConfigManager.savePlayerData();
						StorageManager.hasClaimedMonthlyVIPPoints.put(player, false);
						sender.sendMessage("§b§lVIP Points §8| §b" + player.getName() + "§7 can claim their §b§lMonthly VIP Points§7!");
					}
					else{
						sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 isn't §aOnline§7!");
					}
				}
				else{
					sender.sendMessage("§b§lVIP Points §8| §7Use §b/resetMonthlyVIPPoints <player>");
				}
				
			}
		}
		if(cmd.getName().equalsIgnoreCase("giveMonthlyVIPPoints")){
			
			if(sender.isOp()){
				
				if(a.length == 1){
					Player player = null;
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName().equalsIgnoreCase(a[0])){
							player = p;
						}
					}
					
					if(player != null){
						
						if(!StorageManager.hasClaimedMonthlyVIPPoints.containsKey(player)){
							StorageManager.hasClaimedMonthlyVIPPoints.put(player, ConfigManager.playerdata.getBoolean("players." + player.getName() + ".ClaimedMonthlyVIPPoints"));
						}
						
						if(StorageManager.hasClaimedMonthlyVIPPoints.get(player) == false){
							int amount = 0;
							
							if(player.hasPermission("Rank.Iron")){
								amount = 250;
							}
							if(player.hasPermission("Rank.Gold")){
								amount = 500;
							}
							if(player.hasPermission("Rank.Diamond")){
								amount = 1250;
							}
							if(player.hasPermission("Rank.Emerald")){
								amount = 2500;
							}
							
							try {
								DatabaseManager.addVIPPoints(player, amount);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("§b§lVIP Points §8| §7You gave §b" + PlayerManager.playerDisplayName(player) + " §b§l" + amount + " VIP Points§7!");
							ConfigManager.playerdata.set("players." + player.getName() + ".ClaimedMonthlyVIPPoints", true);
							ConfigManager.savePlayerData();
							StorageManager.hasClaimedMonthlyVIPPoints.put(player, true);
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 already claimed their §bMonthly VIP Points§7!");
						}
					}
					else{
						sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 isn't §aOnline§7!");
					}
				}
				else{
					sender.sendMessage("§b§lVIP Points §8| §7Use §b/giveMonthlyVIPPoints <player>");
				}
				
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("votes")){
			
			if(sender.hasPermission("Rank.Owner")){
				if(a.length == 0){
					sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(sender.getName()));
				}
				else if(a.length == 2){
					
					if(a[0].equalsIgnoreCase("add")){
						
						sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7You gave §b" + a[1] + "§7 a §b§lVote§7!");
						VoteManager.registerVote(a[1]);
				
					}
					else{
						sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Use §b/votes add <player>");
					}
				}
				else{
					sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Use §b/votes add <player>");
				}
				
			}
			else{
				sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(sender.getName()));
			}
		}
		if(cmd.getName().equalsIgnoreCase("vippoints")){
			
			if(sender.hasPermission("Rank.Owner")){
				if(a.length == 0){
					sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + StorageManager.points.get(sender.getName()));
				}
				else if(a.length == 3){
					
					if(a[0].equalsIgnoreCase("give")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								DatabaseManager.addVIPPoints(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You gave " + a[1] + " " + a[2] + " VIP Points!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else if(a[0].equalsIgnoreCase("remove")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								DatabaseManager.removeVIPPoints(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You removed " + a[2] + " VIP Points from " + a[1] + "!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else{
						sender.sendMessage("Incorrect Use!");
					}
					
				}
				else{
					sender.sendMessage("Incorrect Use!");
				}
			}
			else{
				sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + StorageManager.points.get(sender.getName()));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("omt")){
			if(sender.hasPermission("Rank.Owner")){
				if(a.length == 0){
					sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + StorageManager.omt.get(sender.getName()));
				}
				else if(a.length == 3){
					
					if(a[0].equalsIgnoreCase("give")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								DatabaseManager.addOMT(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You gave " + a[1] + " " + a[2] + " OMT!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else if(a[0].equalsIgnoreCase("remove")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								DatabaseManager.removeOMT(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You removed " + a[2] + " OMT from " + a[1] + "!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else{
						sender.sendMessage("Incorrect Use!");
					}
					
				}
				else{
					sender.sendMessage("Incorrect Use!");
				}
				
			}
			else{
				sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + StorageManager.omt.get(sender.getName()));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("servers")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(!StorageManager.PlayersInParkour.contains(p)){
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(ServerSelector.serverSelector);
				}
				
			}
		}
		if(cmd.getName().equalsIgnoreCase("perks")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(PlayerManager.isLoaded(p)){
					if(!StorageManager.PlayersInParkour.contains(p)){
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
					}
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
			}
		}

		return false;
	}
	
    public static List<Block> getBlocksBetween(Location l1, Location l2)
    {
        List<Block> blocks = new ArrayList<Block>();
 
        int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
        int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
 
        int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
        int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
 
        int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
        int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    Block block = l1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
    }
    
}
