package me.O_o_Fadi_o_O.MiniGames;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import me.O_o_Fadi_o_O.MiniGames.kits.LobbyKit;
import me.O_o_Fadi_o_O.MiniGames.kits.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.utils.State;
import me.libraryaddict.disguise.DisguiseAPI;
import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Manager {
	
	/*
	 * 
	 * Storage:
	 * 
	 */
	
	public static int spawns = 0;//
	
	public static int PlayersInGame = 0;//
	public static int SpectatorsInGame = 0;//
	public static int PlayersDied = 0;//
	
	public static ArrayList<Player> Players = new ArrayList<Player>();//
	public static ArrayList<Player> Spectators = new ArrayList<Player>();//
	public static ArrayList<Player> DeadPlayers = new ArrayList<Player>();//
	
	public static ArrayList<Player> UsedEffect = new ArrayList<Player>();//
	
	public static HashMap<Player, String> Kit = new HashMap<Player, String>();//
	
	public static int Minutes = 1; //
	public static int Seconds = 0; //
	
	public static HashMap<Player, Integer> RoundKills = new HashMap<Player, Integer>();//
	public static HashMap<Player, Integer> RoundSecondsSurvived = new HashMap<Player, Integer>();//
	public static Player PlayerWon = null;//
	
	public static int BoosterMultiply = 0;//
	
	public static boolean GameEffectSpeed = false;//
	public static boolean GameEffectBlindness = false;//
	public static boolean GameEffectJump = false;//
	
	/*
	 * 
	 * Game Managing:
	 * 
	 */
	
	public static void joinChickenFight(Player p){
		
	    ((CraftPlayer) p).getHandle().setInvisible(false);
		
	    // Default Kit
	    Start.KitChickenMama.put(p.getName(), false);
	    
		if(Start.KitBabyChicken.containsKey(p.getName())){
			Start.KitBabyChicken.put(p.getName(), false);
		}
		if(Start.KitHotWing.containsKey(p.getName())){
			Start.KitHotWing.put(p.getName(), false);
		}
		if(Start.KitChickenWarrior.containsKey(p.getName())){
			Start.KitChickenWarrior.put(p.getName(), false);
		}
	    
		if(Start.state == State.LOBBY){
			
			Players.add(p);
			RoundKills.put(p, 0);
			RoundSecondsSurvived.put(p, 0);
			PlayersInGame = PlayersInGame +1;
			Kit.put(p, "None");
			
			Bukkit.broadcastMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oMiniGames§2§o)");
			
			teleportToLobby(p);
			LobbyKit.giveInventory(p);
		}
		else{
			Spectators.add(p);
			SpectatorsInGame = SpectatorsInGame +1;
			RoundKills.put(p, 0);
			RoundSecondsSurvived.put(p, 0);
			Bukkit.broadcastMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oSpectator§2§o)");
			p.setAllowFlight(true);
			p.setFlying(true);
		    ((CraftPlayer) p).getHandle().setInvisible(true);
		    teleportToChickenFightArena(p);
		    SpectatorKit.giveInventory(p);
		}
		
		try{
			TextManager.createChickenFightWord(new Location(Bukkit.getWorld("MiniGamesLobby"), 42, 70, -29));
		}catch(Exception ex){
			
		}
		if(Start.CurrentMap.equals("Lava Island")){
			try{
				TextManager.createLavaIslandWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 32));
			}catch(Exception ex){
			
			}
		}
		if(Start.CurrentMap.equals("Gladiator Arena")){
			try{
				TextManager.createHerobrinesTrainingWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
			}catch(Exception ex){
			
			}
		}
		if(Start.CurrentMap.equals("The Netherlands")){
			try{
				TextManager.createTheNetherlandsWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
			}catch(Exception ex){
			
			}
		}
	}
	
	public static void leaveChickenFight(Player p){
		
	    ((CraftPlayer) p).getHandle().setInvisible(false);
	    DisguiseAPI.undisguiseToAll(p);
		if(Players.contains(p)){
			Players.remove(p);
			PlayersInGame = PlayersInGame -1;
			RoundKills.remove(p);
			Kit.remove(p);
			
			Bukkit.broadcastMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oMiniGames§4§o)");
			
			if(Start.state == State.INGAME || Start.state == State.WARMUP){
				if(PlayersInGame == 1){
					endChickenFight();
				}
			}
		}
		if(Spectators.contains(p)){
			
			Bukkit.broadcastMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oSpectator§4§o)");
			Spectators.remove(p);
			SpectatorsInGame = SpectatorsInGame -1;
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		if(DeadPlayers.contains(p)){
			DeadPlayers.remove(p);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void startChickenFight(){
		
		Start.state = State.WARMUP;
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			
			p.setHealth(20D);
			teleportToChickenFightArena(p);
			p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
			
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			p.updateInventory();
			
		    for(Player player : Bukkit.getOnlinePlayers()){
		    	p.showPlayer(p);
		    	player.showPlayer(p);
		    }
		}
		
		Bukkit.broadcastMessage("§c§l§m###############################");
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage("                §f§l Chicken Fight");
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage("§a§o Kill all enemies or knock them into the void!");
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage("§cMap: §f" + Start.CurrentMap);	
		Bukkit.broadcastMessage("§cBuilder(s): §f" + Start.BuiltBy);
		Bukkit.broadcastMessage("§c§l§m###############################");
	}
	
	public static void endChickenFight(){
		
		PlayersDied = 0;
		
		if(PlayersInGame == 1){
			
			Player p1 = null;
			for(Player player : Bukkit.getOnlinePlayers()){
				if(Players.contains(player)){
					p1 = player;
				}
				else{
					if(DeadPlayers.contains(player)){
						player.sendMessage("§7Stats §6| §2§l+ 1 Lose");
						try {
							Start.addMiniGameLoses(player, 1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
			}
			
			Bukkit.broadcastMessage("§c§l§m###############################");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("                §f§l Chicken Fight");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("              §6§lWinner: §e" + p1.getName());
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§c§l§m###############################");	
			
			PlayerWon = p1;
			Start.state = State.ENDING;
			
			p1.sendMessage("§7Stats §6| §2§l+ 1 Win");
			try {
				Start.addMiniGameWins(p1, 1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			
			for(Player p : Bukkit.getOnlinePlayers()){
				p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
			}

			Bukkit.broadcastMessage("§c§l§m###############################");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("                §f§l Chicken Fight");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("               §6§lWinner: §4§lNONE");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§c§l§m###############################");	
			
			Start.state = State.ENDING;
		}
		
	}
	
	public static void teleportToChickenFightArena(Player p){
		
		if(Players.contains(p)){
			int max = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".SpawnsAmount");
		
			spawns++;
			
			if(spawns == max){
				spawns = 1;
			}
			
			World w = Bukkit.getWorld(SettingsManager.arenas.getString("ChickenFight." + Start.CurrentMap + ".Spawns." + spawns + ".world"));
			double x = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Spawns." + spawns + ".x");
			double y = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Spawns." + spawns + ".y");
			double z = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Spawns." + spawns + ".z");
			float yaw = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".Spawns." + spawns + ".yaw");
			float pitch = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".Spawns." + spawns + ".pitch");
			
			Location l = new Location(w, x, y, z, yaw, pitch);
			p.teleport(l);
		}
		else{
			World w = Bukkit.getWorld(SettingsManager.arenas.getString("ChickenFight." + Start.CurrentMap + ".Spectators.world"));
			double x = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Spectators.x");
			double y = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Spectators.y");
			double z = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Spectators.z");
			float yaw = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".Spectators.yaw");
			float pitch = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".Spectators.pitch");
			
			Location l = new Location(w, x, y, z, yaw, pitch);
			p.teleport(l);
		}
		
	}
	
	public static void teleportToLobby(Player p){
		
		World w = Bukkit.getWorld(SettingsManager.arenas.getString("ChickenFight." + Start.CurrentMap + ".Lobby.world"));
		double x = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Lobby.x");
		double y = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Lobby.y");
		double z = SettingsManager.arenas.getDouble("ChickenFight." + Start.CurrentMap + ".Lobby.z");
		float yaw = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".Lobby.yaw");
		float pitch = SettingsManager.arenas.getInt("ChickenFight." + Start.CurrentMap + ".Lobby.pitch");
		
		Location l = new Location(w, x, y, z, yaw, pitch);
		p.teleport(l);
		
	}
	
	public static void selectKit(Player p, String kit){
		
		Kit.put(p, kit);
		p.sendMessage("§e§l§m###############################");
		p.sendMessage("");
		p.sendMessage("§e Kit: §7" + kit);
		p.sendMessage("");
		if(kit.equals("Chicken Mama")){
			p.sendMessage("§e Ability: §7(§f§lFeather Attack§7)");
			p.sendMessage("   §e§oDamages & Knocks back nearby players.");
			p.sendMessage("   §eCooldown: §76 Seconds");
			p.sendMessage("   §eKnockback: §7220% - 240%");
			p.sendMessage("   §eDamage: §72 - 4");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7120%");
			p.sendMessage("§e Damage: §71");
			Start.KitChickenMama.put(p.getName(), true);
			if(Start.KitBabyChicken.containsKey(p.getName())){
				Start.KitBabyChicken.put(p.getName(), false);
			}
			if(Start.KitHotWing.containsKey(p.getName())){
				Start.KitHotWing.put(p.getName(), false);
			}
			if(Start.KitChickenWarrior.containsKey(p.getName())){
				Start.KitChickenWarrior.put(p.getName(), false);
			}
		}
		if(kit.equals("Baby Chicken")){
			p.sendMessage("§e Ability: §7(§f§lEgg Bom§7)");
			p.sendMessage("   §e§oShoots an Exploding Egg.");
			p.sendMessage("   §eCooldown: §77 Seconds");
			p.sendMessage("   §eKnockback: §7110% - 165%");
			p.sendMessage("   §eDamage: §71 - 8");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7140%");
			p.sendMessage("§e Damage: §71");
			Start.KitBabyChicken.put(p.getName(), true);
			if(Start.KitChickenMama.containsKey(p.getName())){
				Start.KitChickenMama.put(p.getName(), false);
			}
			if(Start.KitHotWing.containsKey(p.getName())){
				Start.KitHotWing.put(p.getName(), false);
			}
			if(Start.KitChickenWarrior.containsKey(p.getName())){
				Start.KitChickenWarrior.put(p.getName(), false);
			}
		}
		if(kit.equals("Hot Wing")){
			p.sendMessage("§e Ability: §7(§f§lFire Shield§7)");
			p.sendMessage("   §e§oYou'll get a fire shield around you which sets nearby players on fire.");
			p.sendMessage("   §eCooldown: §710 Seconds");
			p.sendMessage("   §eDamage: §71 - 4 (Fire)");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7130%");
			p.sendMessage("§e Damage Taken: §7150%");
			p.sendMessage("§e Damage: §71 + 1 - 4 (Fire)");
			Start.KitHotWing.put(p.getName(), true);
			if(Start.KitBabyChicken.containsKey(p.getName())){
				Start.KitBabyChicken.put(p.getName(), false);
			}
			if(Start.KitChickenMama.containsKey(p.getName())){
				Start.KitChickenMama.put(p.getName(), false);
			}
			if(Start.KitChickenWarrior.containsKey(p.getName())){
				Start.KitChickenWarrior.put(p.getName(), false);
			}
		}
		if(kit.equals("Chicken Warrior")){
			p.sendMessage("§e Ability: §7(§f§lKnock Knock§7)");
			p.sendMessage("   §e§oKnocks up and damages nearby players.");
			p.sendMessage("   §eCooldown: §78 Seconds");
			p.sendMessage("   §eDamage: §75");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7105%");
			p.sendMessage("§e Damage Taken: §790%");
			p.sendMessage("§e Damage: §71");
			p.sendMessage("§e Potion Effect: §7Slowness 3");
			Start.KitChickenWarrior.put(p.getName(), true);
			if(Start.KitBabyChicken.containsKey(p.getName())){
				Start.KitBabyChicken.put(p.getName(), false);
			}
			if(Start.KitHotWing.containsKey(p.getName())){
				Start.KitHotWing.put(p.getName(), false);
			}
			if(Start.KitChickenMama.containsKey(p.getName())){
				Start.KitChickenMama.put(p.getName(), false);
			}
		}
		p.sendMessage("");
		p.sendMessage("§e§l§m###############################");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
	}
	
	public static void buyKit(Player p, String kit){
		
		p.sendMessage("§e§l§m###############################");
		p.sendMessage("");
		p.sendMessage("§e Kit: §7" + kit);
		p.sendMessage("");
		if(kit.equals("Baby Chicken")){
			p.sendMessage("§e Ability: §7(§f§lEgg Bom§7)");
			p.sendMessage("   §e§oShoots an Exploding Egg.");
			p.sendMessage("   §eCooldown: §77 Seconds");
			p.sendMessage("   §eKnockback: §7110% - 165%");
			p.sendMessage("   §eDamage: §71 - 8");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7140%");
			p.sendMessage("§e Damage: §71");
			p.sendMessage("");
			{
				IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\" \",\"extra\":[{\"text\":\"§cClick here to Buy '§7§lBaby Chicken§c' (§f§l1000 Coins§c)\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§cBuy '§7§lBaby Chicken§c'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mgbuykit BabyChicken\"}}]}");
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
			}
		}
		if(kit.equals("Hot Wing")){
			p.sendMessage("§e Ability: §7(§f§lFire Shield§7)");
			p.sendMessage("   §e§oYou'll get a fire shield around you which sets nearby players on fire.");
			p.sendMessage("   §eCooldown: §710 Seconds");
			p.sendMessage("   §eDamage: §71 - 4 (Fire)");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7130%");
			p.sendMessage("§e Damage Taken: §7150%");
			p.sendMessage("§e Damage: §71 + 1 - 4 (Fire)");
			p.sendMessage("");
			{
				IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\" \",\"extra\":[{\"text\":\"§cClick here to Buy '§7§lHot Wing§c' (§f§l1000 Coins§c)\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§cBuy '§7§lHot Wing§c'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mgbuykit HotWing\"}}]}");
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
			}
		}
		if(kit.equals("Chicken Warrior")){
			p.sendMessage("§e Ability: §7(§f§lKnock Knock§7)");
			p.sendMessage("   §e§oKnocks up and damages nearby players.");
			p.sendMessage("   §eCooldown: §78 Seconds");
			p.sendMessage("   §eDamage: §75");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7105%");
			p.sendMessage("§e Damage Taken: §790%");
			p.sendMessage("§e Damage: §71");
			p.sendMessage("§e Potion Effect: §7Slowness 3");
			p.sendMessage("");
			{
				IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\" \",\"extra\":[{\"text\":\"§cClick here to Buy '§7§lChicken Warrior§c' (§f§l1000 Coins§c)\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§cBuy '§7§lChickenWarrior§c'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mgbuykit ChickenWarrior\"}}]}");
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
			}
		}
		p.sendMessage("");
		p.sendMessage("§e§l§m###############################");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
	}
	
	public static void giveReward(Player p){
		
		try{
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			int i = 0;
	
			p.sendMessage("§c§l§m###############################");
			p.sendMessage("");
			p.sendMessage("                §f§l Chicken Fight");
			p.sendMessage("");
			if(PlayerWon == p){
				p.sendMessage("§f§l +10 §7(Won Game)");
				i = i + 10;
			}
			p.sendMessage("§f§l +5 §7(Patient)");
			i = i + 5;
			if(RoundKills.get(p) != 0){
				if(RoundKills.get(p) == 1){
					p.sendMessage("§f§l +" + (RoundKills.get(p) * 2) + " §7(" + RoundKills.get(p) + " Kill)");
					i = i + RoundKills.get(p);
				}
				else{
					p.sendMessage("§f§l +" + (RoundKills.get(p) * 2) + " §7(" + RoundKills.get(p) + " Kills)");
					i = i + (RoundKills.get(p) * 3);
				}
			}
			int sR = (int) RoundSecondsSurvived.get(p) / 25;
			if(sR != 0){
				p.sendMessage("§f§l +" + sR + " §7(Survived " + RoundSecondsSurvived.get(p) + "s)");
				i = i + sR;
			}
			if(BoosterMultiply != 0){
				p.sendMessage("§f§l +" + i * BoosterMultiply + " §b(Game Effect Booster " + BoosterMultiply + "00%)");
				i = i * BoosterMultiply;
			}
			try {
				Start.addMiniGameCoins(p, i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			p.sendMessage("");
			p.sendMessage("§c§l§m###############################");	
		}catch(Exception ex){
			
		}
		
	}
}
