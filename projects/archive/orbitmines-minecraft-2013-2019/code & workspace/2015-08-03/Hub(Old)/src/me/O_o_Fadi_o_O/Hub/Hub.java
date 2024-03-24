package me.O_o_Fadi_o_O.Hub;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.Hub.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.NMS.CustomCow;
import me.O_o_Fadi_o_O.Hub.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.Hub.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.Hub.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.Hub.NMS.CustomPig;
import me.O_o_Fadi_o_O.Hub.NMS.CustomServerSelector;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSheep;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSlime;
import me.O_o_Fadi_o_O.Hub.NMS.CustomWolf;
import me.O_o_Fadi_o_O.Hub.events.AnimationEvent;
import me.O_o_Fadi_o_O.Hub.events.BlockChangeEvent;
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
import me.O_o_Fadi_o_O.Hub.events.PlayerChat;
import me.O_o_Fadi_o_O.Hub.events.PlayerInteract;
import me.O_o_Fadi_o_O.Hub.events.PlayerMove;
import me.O_o_Fadi_o_O.Hub.events.ProjectileHit;
import me.O_o_Fadi_o_O.Hub.events.QuitEvent;
import me.O_o_Fadi_o_O.Hub.events.VoteEvent;
import me.O_o_Fadi_o_O.Hub.managers.ConfigManager;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.NPCManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.VoteManager;
import me.confuser.barapi.BarAPI;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

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
	
	public int i = 0;
	public int i2 = 0;
	public int i3 = 0;
	
	public int bi = 0;
	
	public int test = 0;
	
	static Connection connection;
    
	public static String TAG = "§3§lHub §8| §7";
	
	JoinEvent joinEvent = new JoinEvent(this);
	ServerSelector sinv = new ServerSelector();
	NPCManager npcManager = new NPCManager(this);
	
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
		
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
				this, ConnectionSide.SERVER_SIDE, ListenerPriority.HIGH, 
				Packets.Server.SET_SLOT, Packets.Server.WINDOW_ITEMS) {
			@Override
			public void onPacketSending(PacketEvent event) {
				if (event.getPacketID() == Packets.Server.SET_SLOT) {
					addGlow(new ItemStack[] { event.getPacket().getItemModifier().read(0) });
				} else {
					addGlow(event.getPacket().getItemArrayModifier().read(0));
				}
			}
		});
		ProtocolLibrary.getProtocolManager().addPacketListener(
				  new PacketAdapter(this, PacketType.Play.Server.NAMED_SOUND_EFFECT) {
				    @Override
				    public void onPacketSending(PacketEvent e) {
						// You can also get the location of the sound effect -
				        // see PacketWrapper's WrapperPlayServerNamedSoundEffect
				        String soundName = e.getPacket().getStrings().read(0);
				        e.setCancelled(soundName.startsWith("mob.cat"));
				    }
				});
		
		try{
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					if(en instanceof Player){
						
					}
					else{
						en.remove();
					}
				}
			}
		}catch(Exception ex){
			
		}
		
		npcManager.spawnAllOcelots(StorageManager.HubWorld);
		npcManager.spawnSkeleton(StorageManager.HubWorld, new Location(StorageManager.HubWorld, -396.5, 15, 1025.5, 0, 0), "§4§lPrison §c§lv3 §e§lAlpha", Material.ENDER_PEARL);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ClickEventENG(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DropEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PickupEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockChangeEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ProjectileHit(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityInteractEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DespawnEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChunkUnload(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VoteEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new AnimationEvent(), this);
		
		ConfigManager.setup(this);

		if(ConfigManager.playerdata.getStringList("VoteRewardsNotGiven") != null){
			List<String> list = new ArrayList<String>();
			for(String s : ConfigManager.playerdata.getStringList("VoteRewardsNotGiven")){
				list.add(s);
			}
			StorageManager.VoteRewardsNotGiven.clear();
			StorageManager.VoteRewardsNotGiven.addAll(list);
		}
		
		new BukkitRunnable(){

			@Override
			public void run() {
				try{
					for(String s : ConfigManager.playerdata.getConfigurationSection("players").getKeys(false)){
						StorageManager.votes.put(s, ConfigManager.playerdata.getInt("players." + s + ".Votes"));
						if(StorageManager.votesPlayers.contains(s)){
							StorageManager.votesPlayers.remove(s);
						}
						StorageManager.votesPlayers.add(s);
					}
				}
				catch(Exception ex){}
				
			}
		}.runTaskTimer(this, 0, 20 * 60 * 60);
		
		new BukkitRunnable(){
			
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					if(!BarAPI.hasBar(p)){
						
						if(bi == 0){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6Welcome §6§l" + p.getName() + "§6!", 10);
							bi++;
						}
						else if(bi == 1){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.omt.get(p.getName()) + "§6 OMT", 10);
							bi++;
						}
						else if(bi == 2){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6§lwww.orbitmines.com", 10);
							bi++;
						}
						else if(bi == 3){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6IP: §6§lHub.OrbitMinesMC.com", 10);
							bi++;
						}
						else if(bi == 4){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.points.get(p.getName()) + "§6 VIP Points", 10);
							bi++;
						}
						else if(bi == 5){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.votes.get(p.getName()) + "§6 Votes", 10);
							bi = 0;
						}
					}
					
					if(StorageManager.EnablePlayers.containsKey(p.getName())){
						if(StorageManager.EnablePlayers.get(p.getName()) == false){
							for(Player player : Bukkit.getOnlinePlayers()){
								p.hidePlayer(player);
							}
						}
					}
				}

			}
		}.runTaskTimer(this, 0, 20);
		
		new BukkitRunnable(){
			
			@Override
			public void run(){
				
				try{
			        FallingBlock block1 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -419, 14, 1054), Material.WATER, (byte) 0);
		            float x1 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y1 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z1 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            
			        FallingBlock block2 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -375, 14, 1054), Material.WATER, (byte) 0);
		            float x2 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y2 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z2 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            
			        FallingBlock block3 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -376, 14, 1011), Material.WATER, (byte) 0);
		            float x3 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y3 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z3 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            
			        FallingBlock block4 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -419, 14, 1011), Material.WATER, (byte) 0);
		            float x4 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y4 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z4 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
					
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block1.getLocation().getX(), (float) block1.getLocation().getY(), (float) block1.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block2.getLocation().getX(), (float) block2.getLocation().getY(), (float) block2.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block3.getLocation().getX(), (float) block3.getLocation().getY(), (float) block3.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block4.getLocation().getX(), (float) block4.getLocation().getY(), (float) block4.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
					}
		            
		            Random i = new Random();
		            int iInt;
		            
		            for(int iCount = 1; iCount <= 1; iCount++){
		            	iInt = 1 + i.nextInt(4);
		            	
		            	if(iInt == 1){
		            		block1.setVelocity(new Vector(x1 -0.2, y1, z1 -0.2));
		            		block2.setVelocity(new Vector(x2 -0.2, y2, z2 -0.2));
		            		block3.setVelocity(new Vector(x3 -0.2, y3, z3 -0.2));
		            		block4.setVelocity(new Vector(x4 -0.2, y4, z4 -0.2));
		            	}
		            	else if(iInt == 2){
		            		block1.setVelocity(new Vector(x1, y1, z1));
		            		block2.setVelocity(new Vector(x2, y2, z2));
		            		block3.setVelocity(new Vector(x3, y3, z3));
		            		block4.setVelocity(new Vector(x4, y4, z4));
		            	}
		            	else if(iInt == 3){
		            		block1.setVelocity(new Vector(x1 -0.2, y1, z1));
		            		block2.setVelocity(new Vector(x2 -0.2, y2, z2));
		            		block3.setVelocity(new Vector(x3 -0.2, y3, z3));
		            		block4.setVelocity(new Vector(x4 -0.2, y4, z4));
		            	}
		              	else if(iInt == 4){
		            		block1.setVelocity(new Vector(x1, y1, z1 -0.2));
		            		block2.setVelocity(new Vector(x2, y2, z2 -0.2));
		            		block3.setVelocity(new Vector(x3, y3, z3 -0.2));
		            		block4.setVelocity(new Vector(x4, y4, z4 -0.2));
		            	}
		            }
					
					for(Entity en : Bukkit.getWorld("Hub").getEntities()){
						if(en instanceof MagmaCube){
							if(StorageManager.SoccerMagmaCubes.contains(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
			                                "flame", 
			                                (float) en.getLocation().getX(),
			                                (float) en.getLocation().getY(), 
			                                (float) en.getLocation().getZ(), 
			                                0, 0, 0,(float) 0, 1));
								}
							}
						}
						if(en instanceof Item){
							if(((Item) en).getItemStack().getType() != Material.PAPER && ((Item) en).getItemStack().getType() != Material.ENDER_PEARL && ((Item) en).getItemStack().getType() != Material.EYE_OF_ENDER){
								en.remove();
							}
							if(StorageManager.SwapTeleporter.containsKey(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("largesmoke", (float) en.getLocation().getX(), (float) en.getLocation().getY(), (float) en.getLocation().getZ(), 0, 0, 0,(float) 0, 10));
								}
								Player player = StorageManager.SwapTeleporter.get(en);
								for(Entity e : en.getNearbyEntities(0.5, 1, 0.5)){
									if(e instanceof Player){
										if(player != e){
											Player player2 = (Player) e;
											Location l1 = player.getLocation();
											Location l2 = player2.getLocation();
											
											player.teleport(l2);
											player2.teleport(l1);
											
											player.sendMessage("§fYou've §2§lswapped§f positions with " + PlayerManager.playerDisplayName(player2) + "§f!");
											player2.sendMessage(PlayerManager.playerDisplayName(player) + " §2§lswapped§f positions with you!");
											
											player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
											player2.playSound(player2.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
											
											StorageManager.SwapTeleporter.remove(en);
											en.remove();
										}
									}
								}
							}
						}
					}
				}catch(Exception ex){
					
				}
			}
			
		}.runTaskTimer(this, 40, 2);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					if(p.getOpenInventory().getTopInventory() instanceof AnvilInventory){
						{
						ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§9§nCosmetic Perks");
						item.setItemMeta(meta);
						p.getInventory().setItem(12, item);
						}
						{
						ItemStack item = new ItemStack(Material.NAME_TAG, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§f§oClick the §6§oRight§f§o Egg to rename your Pet!");
						item.setItemMeta(meta);
						p.getInventory().setItem(14, item);
						}
					}
					else{
						p.getInventory().setItem(12, null);
						p.getInventory().setItem(14, null);
					}
				}
			}
		}.runTaskTimer(this, 0, 10);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					ScoreboardManager sm = Bukkit.getScoreboardManager();
					Scoreboard b = sm.getNewScoreboard();

					Objective o = b.registerNewObjective("Test", "Test2");
					
					if(StorageManager.EnableScoreboard.get(p.getName()) != null && StorageManager.EnableScoreboard.get(p.getName()) == true){
						
						o.setDisplayName("§6§lOrbitMines");
						
						o.setDisplaySlot(DisplaySlot.SIDEBAR);
					
						Score score1 = o.getScore("");
						score1.setScore(12);
	
						Team omt = b.registerNewTeam("OMT");
						omt.setSuffix(" Tokens");
						OfflinePlayer omt1 = getServer().getOfflinePlayer("§e§lOrbitMines");
						omt.addPlayer(omt1);
						
						Score score2 = o.getScore(omt1.getName());
						score2.setScore(11);
	
						if(StorageManager.omt.get(p.getName()) != null){
							Score score3 = o.getScore(" " + StorageManager.omt.get(p.getName()) + "  ");
							score3.setScore(10);
						}
						else{
							Score score3 = o.getScore(" " + "Loading..." + "  ");
							score3.setScore(10);
						}
					
						Score score4 = o.getScore(" ");
						score4.setScore(9);
	
						Score score5 = o.getScore("§b§lVIP Points");
						score5.setScore(8);
	
						if(StorageManager.points.get(p.getName()) != null){
							Score score6 = o.getScore(" " + StorageManager.points.get(p.getName()) + "");
							score6.setScore(7);
						}
						else{
							Score score6 = o.getScore(" " + "Loading..." + "");
							score6.setScore(7);
						}
	
						Score score7 = o.getScore("  ");
						score7.setScore(6);
						
						Team coin = b.registerNewTeam("Coins");
						coin.setSuffix(" Coins");
						OfflinePlayer coins1 = getServer().getOfflinePlayer("§f§lMiniGame");
						coin.addPlayer(coins1);
						
						Score score8 = o.getScore(coins1.getName());
						score8.setScore(5);
						
						if(StorageManager.coins.get(p.getName()) != null){
							Score score9 = o.getScore(" " + StorageManager.coins.get(p.getName()) + " ");
							score9.setScore(4);
						}
						else{
							Score score9 = o.getScore(" " + "Loading..." + " ");
							score9.setScore(4);
						}
				
						Score score10 = o.getScore("   ");
						score10.setScore(3);
					}
					
					Team IronVIP = b.registerNewTeam("IronVIP");
					IronVIP.setPrefix("§7§lIron §f");
					Team GoldVIP = b.registerNewTeam("GoldVIP");
					GoldVIP.setPrefix("§6§lGold §f");
					Team DiamondVIP = b.registerNewTeam("DiamondVIP");
					DiamondVIP.setPrefix("§9§lDiamond §f");
					Team EmeraldVIP = b.registerNewTeam("EmeraldVIP");
					EmeraldVIP.setPrefix("§a§lEmerald §f");
					Team Builder = b.registerNewTeam("Builder");
					Builder.setPrefix("§d§lBuilder §f");
					Team Moderator = b.registerNewTeam("Moderator");
					Moderator.setPrefix("§b§lMod §f");
					Team Owner = b.registerNewTeam("Owner");
					Owner.setPrefix("§4§lOwner §f");
					
					for(Player player : Bukkit.getOnlinePlayers()){
						if(player.hasPermission("Rank.Owner")){
							Owner.addPlayer(player);
						}
						else if(player.hasPermission("Rank.Moderator")){
							Moderator.addPlayer(player);
						}
						else if(player.hasPermission("Rank.Builder")){
							Builder.addPlayer(player);
						}
						else if(player.hasPermission("Rank.Emerald")){
							EmeraldVIP.addPlayer(player);
						}
						else if(player.hasPermission("Rank.Diamond")){
							DiamondVIP.addPlayer(player);
						}
						else if(player.hasPermission("Rank.Gold")){
							GoldVIP.addPlayer(player);
						}
						else if(player.hasPermission("Rank.Iron")){
							IronVIP.addPlayer(player);
						}
						else{
							
						}
					}
					
					if(StorageManager.EnableScoreboard.get(p.getName()) != null && StorageManager.EnableScoreboard.get(p.getName()) == true){
						Score score11 = o.getScore("§c§lRank");
						score11.setScore(2);
						
						if(p.hasPermission("Rank.Owner")){
							Score score12 = o.getScore(" §4§lOwner");
							score12.setScore(1);
						}
						else if(p.hasPermission("Rank.Moderator")){
							Score score12 = o.getScore(" §b§lModerator");
							score12.setScore(1);
						}
						else if(p.hasPermission("Rank.Builder")){
							Score score12 = o.getScore(" §d§lBuilder");
							score12.setScore(1);
						}
						else if(p.hasPermission("Rank.Emerald")){
							Score score12 = o.getScore(" §a§lEmerald VIP");
							score12.setScore(1);
						}
						else if(p.hasPermission("Rank.Diamond")){
							Score score12 = o.getScore(" §b§lDiamond VIP");
							score12.setScore(1);
						}
						else if(p.hasPermission("Rank.Gold")){
							Score score12 = o.getScore(" §6§lGold VIP");
							score12.setScore(1);
						}
						else if(p.hasPermission("Rank.Iron")){
							Score score12 = o.getScore(" §7§lIron VIP");
							score12.setScore(1);
						}
						else{
							Score score12 = o.getScore(" §fNo Rank");
							score12.setScore(1);
						}
						
						Score score13 = o.getScore("    ");
						score13.setScore(0);
						
						o.setDisplayName("§6§lOrbitMines§4§lNetwork");
					}
					
					p.setScoreboard(b);
					
				}

			}
		}.runTaskTimer(this, 0, 100);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.ownerpets.containsKey(p)){
						UUID uuid = StorageManager.ownerpets.get(p);
						if(StorageManager.owners.containsKey(uuid)){
							for(World w : Bukkit.getWorlds()){
								for(Entity en : w.getEntities()){
									if(en.getUniqueId() == uuid){
										if(en instanceof LivingEntity){
											LivingEntity ent = (LivingEntity) en;
											Location l = StorageManager.owners.get(uuid).getLocation();
											
											if(ClickEventENG.getDistance(l, ent.getLocation()) < 20){
												ClickEventENG.navigate(ent, l, 1.2);
											}
											else{
												ent.teleport(l);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this, 20, 3);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				i2++;
					
				ServerSelector.KitPvPServerItem(ServerSelector.sinv, i2);
				ServerSelector.PrisonServerItem(ServerSelector.sinv, i2);;
				ServerSelector.CreativeServerItem(ServerSelector.sinv, i2);
				ServerSelector.SurvivalServerItem(ServerSelector.sinv, i2);
				ServerSelector.SkyBlockServerItem(ServerSelector.sinv, i2);
				ServerSelector.MiniGamesServerItem(ServerSelector.sinv, i2);
				
				if(i2 == 2){
					i2 = 0;
				}
				
			}
		}.runTaskTimer(this, 0, 3);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				DatabaseManager.openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadAfter5Seconds(p);
		}
		
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
	
	private void addGlow(ItemStack[] stacks) {
		for (ItemStack stack : stacks) {
			if (stack != null) {
				// Only update those stacks that have our flag enchantment
				if (stack.getEnchantmentLevel(Enchantment.SILK_TOUCH) == 32) {
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
			if(sender instanceof Player){
				//Player p = (Player) sender;
				//p.sendMessage("");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §3§lHub§7 Server:");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l1 OrbitMines Token");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(p.getName()));
				//p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
			}
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
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
				p.openInventory(sinv.getServerSelectorInv(p, 1));
				
			}
		}
		if(cmd.getName().equalsIgnoreCase("perks")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(PlayerManager.isLoaded(p)){
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					p.openInventory(CosmeticPerks.getCosmeticPerks(p));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
			}
		}

		return false;
	}
}
