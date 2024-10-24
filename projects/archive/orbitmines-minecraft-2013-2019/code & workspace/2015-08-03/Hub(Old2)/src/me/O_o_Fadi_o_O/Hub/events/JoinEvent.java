package me.O_o_Fadi_o_O.Hub.events;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.JoinItems;
import me.O_o_Fadi_o_O.Hub.managers.ConfigManager;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.VoteManager;
import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener{
	
	Hub plugin;
	 
	public JoinEvent(Hub instance) {
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		
		e.setJoinMessage("�2�l�o>> " + p.getName() + " �2�o(�a�oHub�2�o)");
		
		loadPlayer(p);
		
		JoinItems.giveItems(p);
		
		p.chat("/spawn");
	}
	
	public void loadPlayer(final Player p){
		try{
			if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Votes")){
				ConfigManager.playerdata.set("players." + p.getName() + ".Votes", 0);
				if(StorageManager.votesPlayers.contains(p.getName())){
					StorageManager.votesPlayers.remove(p.getName());
				}
				StorageManager.votesPlayers.add(p.getName());
			}
			if(!ConfigManager.playerdata.contains("players." + p.getName() + ".ClaimedMonthlyVIPPoints")){
				ConfigManager.playerdata.set("players." + p.getName() + ".ClaimedMonthlyVIPPoints", false);
			}
			ConfigManager.savePlayerData();
			
			StorageManager.hasClaimedMonthlyVIPPoints.put(p, ConfigManager.playerdata.getBoolean("players." + p.getName() + ".ClaimedMonthlyVIPPoints"));
			
			if(!DatabaseManager.containsPath("name", "Votes", p.getName().toLowerCase())){
				DatabaseManager.insertInt(p.getName().toLowerCase(), "Votes", "votes", 0);
			}
			if(!DatabaseManager.containsPath("name", "OrbitMinesTokens", p.getName())){
				DatabaseManager.insertInt(p.getName(), "OrbitMinesTokens", "omt", 0);
			}
			if(!DatabaseManager.containsPath("name", "VIPPoints", p.getName())){
				DatabaseManager.insertInt(p.getName(), "VIPPoints", "points", 0);
			}
			if(!DatabaseManager.containsPath("name", "MiniGameCoins", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameCoins", "coins", 0);
			}
			
			if(!DatabaseManager.containsPath("name", "MiniGameKills", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameKills", "kills", 0);
			}
			if(!DatabaseManager.containsPath("name", "MiniGameLoses", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameLoses", "loses", 0);
			}
			if(!DatabaseManager.containsPath("name", "MiniGameWins", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameWins", "wins", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-Kills", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Kills", "kills", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-Loses", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Loses", "loses", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-Wins", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Wins", "wins", 0);
			}
			if(!DatabaseManager.containsPath("name", "Fireworks-Passes", p.getName())){
				DatabaseManager.insertInt(p.getName(), "Fireworks-Passes", "passes", 0);
			}
			StorageManager.omt.put(p.getName(), DatabaseManager.getInt(p.getName(), "OrbitMinesTokens", "omt"));
		
			StorageManager.points.put(p.getName(), DatabaseManager.getInt(p.getName(), "VIPPoints", "points"));
			
			StorageManager.coins.put(p.getName(), DatabaseManager.getInt(p.getName(), "MiniGameCoins", "coins"));
			
			StorageManager.votes.put(p.getName(), DatabaseManager.getInt(p.getName().toLowerCase(), "Votes", "votes"));
			ConfigManager.playerdata.set("players." + p.getName() + ".Votes", StorageManager.votes.get(p.getName()));
			ConfigManager.savePlayerData();
			
			StorageManager.FireworkPasses.put(p.getName(), DatabaseManager.getInt(p.getName(), "Fireworks-Passes", "passes"));
			
			if(DatabaseManager.containsPath("name", "Gadgets-Paintballs", p.getName())){
				StorageManager.gadgetsPaintballs.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-CreeperLauncher", p.getName())){
				StorageManager.gadgetsCreeperLauncher.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-PetRide", p.getName())){
				StorageManager.gadgetsPetRide.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-BookExplosion", p.getName())){
				StorageManager.gadgetsBookExplosion.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-SwapTeleporter", p.getName())){
				StorageManager.gadgetsSwapTeleporter.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-MagmaCubeSoccer", p.getName())){
				StorageManager.gadgetsMagmaCubeSoccer.put(p.getName(), 1);
			}
			
			if(DatabaseManager.containsPath("name", "Pets-MushroomCow", p.getName())){
				StorageManager.mushroomcow.put(p.getName(), DatabaseManager.getString(p, "Pets-Ocelot", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Pig", p.getName())){
				StorageManager.pig.put(p.getName(), DatabaseManager.getString(p, "Pets-Pig", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Wolf", p.getName())){
				StorageManager.wolf.put(p.getName(), DatabaseManager.getString(p, "Pets-Wolf", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Sheep", p.getName())){
				StorageManager.sheep.put(p.getName(), DatabaseManager.getString(p, "Pets-Sheep", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Horse", p.getName())){
				StorageManager.horse.put(p.getName(), DatabaseManager.getString(p, "Pets-Horse", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-MagmaCube", p.getName())){
				StorageManager.magmacube.put(p.getName(), DatabaseManager.getString(p, "Pets-MagmaCube", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Slime", p.getName())){
				StorageManager.slime.put(p.getName(), DatabaseManager.getString(p, "Pets-Slime", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Cow", p.getName())){
				StorageManager.cow.put(p.getName(), DatabaseManager.getString(p, "Pets-Cow", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Silverfish", p.getName())){
				StorageManager.silverfish.put(p.getName(), DatabaseManager.getString(p, "Pets-Silverfish", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Ocelot", p.getName())){
				StorageManager.ocelot.put(p.getName(), DatabaseManager.getString(p, "Pets-Ocelot", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Creeper", p.getName())){
				StorageManager.creeper.put(p.getName(), DatabaseManager.getString(p, "Pets-Creeper", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Squid", p.getName())){
				StorageManager.squid.put(p.getName(), DatabaseManager.getString(p, "Pets-Squid", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Spider", p.getName())){
				StorageManager.spider.put(p.getName(), DatabaseManager.getString(p, "Pets-Spider", "petname"));
			}
			if(DatabaseManager.containsPath("name", "Pets-Chicken", p.getName())){
				StorageManager.chicken.put(p.getName(), DatabaseManager.getString(p, "Pets-Chicken", "petname"));
			}
			
			List<Color> unlockedWardrobeArmor = new ArrayList<Color>();
			
			if(DatabaseManager.containsPath("name", "Wardrobe-White", p.getName())){
				StorageManager.white.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.WHITE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Blue", p.getName())){
				StorageManager.blue.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.BLUE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Green", p.getName())){
				StorageManager.green.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.GREEN);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Black", p.getName())){
				StorageManager.black.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.BLACK);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-LightBlue", p.getName())){
				StorageManager.lightblue.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.AQUA);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Pink", p.getName())){
				StorageManager.pink.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.FUCHSIA);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-LightGreen", p.getName())){
				StorageManager.lightgreen.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.LIME);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-DarkBlue", p.getName())){
				StorageManager.darkblue.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.NAVY);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Purple", p.getName())){
				StorageManager.purple.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.PURPLE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Orange", p.getName())){
				StorageManager.orange.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.ORANGE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Red", p.getName())){
				StorageManager.red.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.RED);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Cyan", p.getName())){
				StorageManager.cyan.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.TEAL);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Yellow", p.getName())){
				StorageManager.yellow.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.YELLOW);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Gray", p.getName())){
				StorageManager.gray.put(p.getName(), 1);
				unlockedWardrobeArmor.add(Color.GRAY);
			}
			StorageManager.wardrobeUnlockedColors.put(p.getName(), unlockedWardrobeArmor);
			if(DatabaseManager.containsPath("name", "Wardrobe-Disco", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "Wardrobe-Disco", "disco");
				if(sBoolean.equals("false")){
					StorageManager.wardrobeDisco.put(p.getName(), false);
				}
				if(sBoolean.equals("true")){
					StorageManager.wardrobeDisco.put(p.getName(), true);
				}
			}
			
			if(DatabaseManager.containsPath("name", "ChatColors-DarkRed", p.getName())){
				StorageManager.chatcolordarkred.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-LightGreen", p.getName())){
				StorageManager.chatcolorlightgreen.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-DarkGray", p.getName())){
				StorageManager.chatcolordarkgray.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Red", p.getName())){
				StorageManager.chatcolorred.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-White", p.getName())){
				StorageManager.chatcolorwhite.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-LightBlue", p.getName())){
				StorageManager.chatcolorlightblue.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Pink", p.getName())){
				StorageManager.chatcolorpink.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Blue", p.getName())){
				StorageManager.chatcolorblue.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-DarkBlue", p.getName())){
				StorageManager.chatcolordarkblue.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Green", p.getName())){
				StorageManager.chatcolorgreen.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Black", p.getName())){
				StorageManager.chatcolorblack.put(p.getName(), 1);
			}
			
			if(DatabaseManager.containsPath("name", "ChatColors-Bold", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "ChatColors-Bold", "bold");
				if(sBoolean.equals("false")){
					StorageManager.BoldChatColor.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.BoldChatColor.put(p, true);
				}
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Cursive", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "ChatColors-Cursive", "cursive");
				if(sBoolean.equals("false")){
					StorageManager.CursiveChatColor.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.CursiveChatColor.put(p, true);
				}
			}
			
			if(DatabaseManager.containsPath("name", "Trails-AngryVillager", p.getName())){
				StorageManager.trailsangryvillager.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Hearts", p.getName())){
				StorageManager.trailshearts.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Bubble", p.getName())){
				StorageManager.trailsbubbles.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Crit", p.getName())){
				StorageManager.trailscrit.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-ETable", p.getName())){
				StorageManager.trailsenchantmenttable.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Explode", p.getName())){
				StorageManager.trailsexplode.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Firework", p.getName())){
				StorageManager.trailsfirework.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-HappyVillager", p.getName())){
				StorageManager.trailshappyvillager.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-MobSpawner", p.getName())){
				StorageManager.trailsmobspawner.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Music", p.getName())){
				StorageManager.trailsnote.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Slime", p.getName())){
				StorageManager.trailsslime.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Smoke", p.getName())){
				StorageManager.trailssmoke.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Snow", p.getName())){
				StorageManager.trailssnow.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Water", p.getName())){
				StorageManager.trailswater.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Trails-Witch", p.getName())){
				StorageManager.trailswitch.put(p.getName(), 1);
			}
			
			if(DatabaseManager.containsPath("name", "ChatColors", p.getName())){
				StorageManager.chatcolor.put(p, DatabaseManager.getString(p, "ChatColors", "color"));
			}
			else{
				DatabaseManager.insertString(p.getName(), "ChatColors", "color", "7");
				StorageManager.chatcolor.put(p, "7");
			}
			
			StorageManager.hatsHasAHat.put(p.getName(), false);
			if(DatabaseManager.containsPath("name", "Hats-Bedrock", p.getName())){
				StorageManager.hatsBedrock.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-BlackGlass", p.getName())){
				StorageManager.hatsBlackGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Cactus", p.getName())){
				StorageManager.hatsCactus.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-CoalBlock", p.getName())){
				StorageManager.hatsCoalBlock.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-CoalOre", p.getName())){
				StorageManager.hatsCoalOre.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Furnace", p.getName())){
				StorageManager.hatsFurnace.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Glass", p.getName())){
				StorageManager.hatsGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Grass", p.getName())){
				StorageManager.hatsGrass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-GreenGlass", p.getName())){
				StorageManager.hatsGreenGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-HayBale", p.getName())){
				StorageManager.hatsHayBale.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Ice", p.getName())){
				StorageManager.hatsIce.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-LapisBlock", p.getName())){
				StorageManager.hatsLapisBlock.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-LapisOre", p.getName())){
				StorageManager.hatsLapisOre.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Leaves", p.getName())){
				StorageManager.hatsLeaves.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-MagentaGlass", p.getName())){
				StorageManager.hatsMagentaGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Melon", p.getName())){
				StorageManager.hatsMelon.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Mycelium", p.getName())){
				StorageManager.hatsMycelium.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-OrangeGlass", p.getName())){
				StorageManager.hatsOrangeGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-QuartzBlock", p.getName())){
				StorageManager.hatsQuartzBlock.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-QuartzOre", p.getName())){
				StorageManager.hatsQuartzOre.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-RedGlass", p.getName())){
				StorageManager.hatsRedGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-RedstoneBlock", p.getName())){
				StorageManager.hatsRedstoneBlock.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-RedstoneOre", p.getName())){
				StorageManager.hatsRedstoneOre.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Snow", p.getName())){
				StorageManager.hatsSnow.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-StoneBricks", p.getName())){
				StorageManager.hatsStoneBricks.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-TNT", p.getName())){
				StorageManager.hatsTNT.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-Workbench", p.getName())){
				StorageManager.hatsWorkbench.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-YellowGlass", p.getName())){
				StorageManager.hatsYellowGlass.put(p.getName(), 1);
				StorageManager.hatsHasAHat.put(p.getName(), true);
			}
			if(DatabaseManager.containsPath("name", "Hats-BlockTrail", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "Hats-BlockTrail", "blocktrail");
				if(sBoolean.equals("false")){
					StorageManager.hatsBlockTrail.put(p.getName(), false);
				}
				if(sBoolean.equals("true")){
					StorageManager.hatsBlockTrail.put(p.getName(), true);
				}
			}
			
			if(DatabaseManager.containsPath("name", "Dis-Witch", p.getName())){
				StorageManager.disWitch.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Bat", p.getName())){
				StorageManager.disBat.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Chicken", p.getName())){
				StorageManager.disChicken.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Ocelot", p.getName())){
				StorageManager.disOcelot.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-MushroomCow", p.getName())){
				StorageManager.disMushroomCow.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Squid", p.getName())){
				StorageManager.disSquid.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Slime", p.getName())){
				StorageManager.disSlime.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-ZombiePigman", p.getName())){
				StorageManager.disZombiePigman.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-MagmaCube", p.getName())){
				StorageManager.disMagmaCube.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Skeleton", p.getName())){
				StorageManager.disSkeleton.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Wolf", p.getName())){
				StorageManager.disWolf.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Spider", p.getName())){
				StorageManager.disSpider.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Silverfish", p.getName())){
				StorageManager.disSilverfish.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Sheep", p.getName())){
				StorageManager.disSheep.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-CaveSpider", p.getName())){
				StorageManager.disCaveSpider.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Creeper", p.getName())){
				StorageManager.disCreeper.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Cow", p.getName())){
				StorageManager.disCow.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Enderman", p.getName())){
				StorageManager.disEnderman.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Horse", p.getName())){
				StorageManager.disHorse.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-IronGolem", p.getName())){
				StorageManager.disIronGolem.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Ghast", p.getName())){
				StorageManager.disGhast.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-Snowman", p.getName())){
				StorageManager.disSnowman.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Dis-SkeletonHorse", p.getName())){
				StorageManager.disSkeletonHorse.put(p.getName(), 1);
			}
			
			if(DatabaseManager.containsPath("name", "ParkourCompleted", p.getName())){
				StorageManager.PlayerCompletedParkour.put(p, true);
			}
			else{
				StorageManager.PlayerCompletedParkour.put(p, false);
			}
			
			if(DatabaseManager.containsPath("name", "MasterMind-Wins", p.getName())){
				StorageManager.PlayerMasterMindWins.put(p, DatabaseManager.getInt(p.getName(), "MasterMind-Wins", "wins"));
			}
			else{
				DatabaseManager.insertInt(p.getName(), "MasterMind-Wins", "wins", 0);
				StorageManager.PlayerMasterMindWins.put(p, 0);
			}
			
			if(DatabaseManager.containsPath("name", "MasterMind-BestGame", p.getName())){
				StorageManager.PlayerMasterMindBestGame.put(p, DatabaseManager.getInt(p.getName(), "MasterMind-BestGame", "turns"));
			}
			
			if(!DatabaseManager.containsPath("name", "Achievements-KitPvP", p.getName())){
				List<Boolean> Achievements = new ArrayList<Boolean>();
			}
			
			if(!StorageManager.EnablePlayers.containsKey(p.getName())){
				StorageManager.EnablePlayers.put(p.getName(), true);
			}
			else{
				if(StorageManager.EnablePlayers.get(p.getName()) == false){
					for(Player player : Bukkit.getOnlinePlayers()){
						p.hidePlayer(player);
					}
				}
			}
			if(!StorageManager.EnableStacker.containsKey(p.getName())){
				StorageManager.EnableStacker.put(p.getName(), true);
			}
			if(!StorageManager.EnableScoreboard.containsKey(p.getName())){
				StorageManager.EnableScoreboard.put(p.getName(), true);
			}
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.EnablePlayers.containsKey(player)){
					if(StorageManager.EnablePlayers.get(player) == false){
						player.hidePlayer(p);
					}
				}
				if(PlayerManager.isDisguised(player)){
					DisguiseAPI.disguiseToPlayers(player, DisguiseAPI.getDisguise(player), Bukkit.getOnlinePlayers());
				}
			}
			
			if(!p.isOp()){
				String rank = "User";
				
				if(p.hasPermission("Rank.Iron")){
					rank = "Iron_VIP";
				}
				if(p.hasPermission("Rank.Gold")){
					rank = "Gold_VIP";
				}
				if(p.hasPermission("Rank.Diamond")){
					rank = "Diamond_VIP";
				}
				if(p.hasPermission("Rank.Emerald")){
					rank = "Emerald_VIP";
				}
				if(!DatabaseManager.containsPath("name", "Ranks", p.getName())){
					DatabaseManager.insertString(p.getName(), "Ranks", "rank", rank);
				}
				else{
					try {
						DatabaseManager.setVIPRank(p.getName(), rank);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				p.sendMessage(rank);
			}
			
			VoteManager.checkForVotes(p);
			
			StorageManager.IsLoaded.put(p, true);
			
			new BukkitRunnable(){
				public void run(){
					p.sendMessage("�7�m----------------------------------------");
					p.sendMessage(" �6�lOrbitMines�4�lNetwork �7- �3�lHub");
					p.sendMessage(" ");
					p.sendMessage(" �cReport�7 a Player with �c/report�7.");
					p.sendMessage(" �bVote�7 for Rewards with �b/vote�7.");
					p.sendMessage(" �3Donate�7 for VIP with �3/donate�7.");
					p.sendMessage(" ");
					p.sendMessage(" �7Spawn Built By: �4O_o_Fadi_o_O�7, �dcasidas");
					p.sendMessage(" �7Developed By: �4O_o_Fadi_o_O");
					p.sendMessage("�7�m----------------------------------------");
				}
			}.runTaskLater(this.plugin, 20);
		}catch(Exception ex){
			loadAfter5Seconds(p);
			StorageManager.IsLoaded.put(p, false);
		}
	}
	
	public void loadAfter5Seconds(final Player p){
		
		new BukkitRunnable(){
			
			public void run(){
				
				if(p.isOnline()){
					
					loadPlayer(p);
					
				}
			}
		}.runTaskLater(this.plugin, 20 * 5);
		
	}
}
