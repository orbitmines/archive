package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.VoteManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener{
	
	Start plugin;
	 
	public JoinEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(!StorageManager.PlayersGame.containsKey(player)){
				player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oMiniGames§2§o)");
			}
		}
		
		p.setAllowFlight(true);
		Start.clearInventory(p);
		MiniGamesLobbyKit.giveInventory(p);
		
		loadPlayer(p);
		
	}
	
	public void loadPlayer(final Player p){
		try{
			if(!DatabaseManager.containsPath("name", "Votes", p.getName().toLowerCase())){
				DatabaseManager.insertInt(p.getName(), "Votes", "votes", 0);
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
			
			if(!DatabaseManager.containsPath("name", "ChickenFight-BestStreak", p.getName())){
				DatabaseManager.insertInt(p.getName(), "ChickenFight-BestStreak", "beststreak", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-BestStreak", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-BestStreak", "beststreak", 0);
			}
			
			StorageManager.ChickenFightKills.put(p.getName(), DatabaseManager.getInt(p.getName(), "MiniGameKills", "kills"));
			StorageManager.ChickenFightLoses.put(p.getName(), DatabaseManager.getInt(p.getName(), "MiniGameLoses", "loses"));
			StorageManager.ChickenFightWins.put(p.getName(), DatabaseManager.getInt(p.getName(), "MiniGameWins", "wins"));
			StorageManager.ChickenFightBestStreak.put(p.getName(), DatabaseManager.getInt(p.getName(), "ChickenFight-BestStreak", "beststreak"));
			
			StorageManager.SurvivalGamesKills.put(p.getName(), DatabaseManager.getInt(p.getName(), "SurvivalGames-Kills", "kills"));
			StorageManager.SurvivalGamesLoses.put(p.getName(), DatabaseManager.getInt(p.getName(), "SurvivalGames-Loses", "loses"));
			StorageManager.SurvivalGamesWins.put(p.getName(), DatabaseManager.getInt(p.getName(), "SurvivalGames-Wins", "wins"));
			StorageManager.SurvivalGamesBestStreak.put(p.getName(), DatabaseManager.getInt(p.getName(), "SurvivalGames-BestStreak", "beststreak"));
			
			StorageManager.omt.put(p.getName(), DatabaseManager.getInt(p.getName(), "OrbitMinesTokens", "omt"));
			
			StorageManager.points.put(p.getName(), DatabaseManager.getInt(p.getName(), "VIPPoints", "points"));
			
			StorageManager.coins.put(p.getName(), DatabaseManager.getInt(p.getName(), "MiniGameCoins", "coins"));
			
			StorageManager.votes.put(p.getName(), DatabaseManager.getInt(p.getName().toLowerCase(), "Votes", "votes"));
			
			StorageManager.FireworkPasses.put(p.getName(), DatabaseManager.getInt(p.getName(), "Fireworks-Passes", "passes"));
			
			StorageManager.KitChickenMama.put(p.getName(), false);
			
			if(DatabaseManager.containsPath("name", "ChickenFight-BabyChicken", p.getName())){
				StorageManager.KitBabyChicken.put(p.getName(), false);
			}
			if(DatabaseManager.containsPath("name", "ChickenFight-HotWing", p.getName())){
				StorageManager.KitHotWing.put(p.getName(), false);
			}
			if(DatabaseManager.containsPath("name", "ChickenFight-ChickenWarrior", p.getName())){
				StorageManager.KitChickenWarrior.put(p.getName(), false);
			}
			
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
			
			if(DatabaseManager.containsPath("name", "Wardrobe-White", p.getName())){
				StorageManager.white.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Blue", p.getName())){
				StorageManager.blue.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Green", p.getName())){
				StorageManager.green.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Black", p.getName())){
				StorageManager.black.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-LightBlue", p.getName())){
				StorageManager.lightblue.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Pink", p.getName())){
				StorageManager.pink.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-LightGreen", p.getName())){
				StorageManager.lightgreen.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-DarkBlue", p.getName())){
				StorageManager.darkblue.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Purple", p.getName())){
				StorageManager.purple.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Orange", p.getName())){
				StorageManager.orange.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Red", p.getName())){
				StorageManager.red.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Cyan", p.getName())){
				StorageManager.cyan.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Yellow", p.getName())){
				StorageManager.yellow.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Gray", p.getName())){
				StorageManager.gray.put(p.getName(), 1);
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
			
			if(DatabaseManager.containsPath("name", "Hats-Bedrock", p.getName())){
				StorageManager.hatsBedrock.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-BlackGlass", p.getName())){
				StorageManager.hatsBlackGlass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Cactus", p.getName())){
				StorageManager.hatsCactus.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-CoalBlock", p.getName())){
				StorageManager.hatsCoalBlock.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-CoalOre", p.getName())){
				StorageManager.hatsCoalOre.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Furnace", p.getName())){
				StorageManager.hatsFurnace.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Glass", p.getName())){
				StorageManager.hatsGlass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Grass", p.getName())){
				StorageManager.hatsGrass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-GreenGlass", p.getName())){
				StorageManager.hatsGreenGlass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-HayBale", p.getName())){
				StorageManager.hatsHayBale.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Ice", p.getName())){
				StorageManager.hatsIce.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-LapisBlock", p.getName())){
				StorageManager.hatsLapisBlock.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-LapisOre", p.getName())){
				StorageManager.hatsLapisOre.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Leaves", p.getName())){
				StorageManager.hatsLeaves.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-MagentaGlass", p.getName())){
				StorageManager.hatsMagentaGlass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Melon", p.getName())){
				StorageManager.hatsMelon.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Mycelium", p.getName())){
				StorageManager.hatsMycelium.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-OrangeGlass", p.getName())){
				StorageManager.hatsOrangeGlass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-QuartzBlock", p.getName())){
				StorageManager.hatsQuartzBlock.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-QuartzOre", p.getName())){
				StorageManager.hatsQuartzOre.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-RedGlass", p.getName())){
				StorageManager.hatsRedGlass.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-RedstoneBlock", p.getName())){
				StorageManager.hatsRedstoneBlock.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-RedstoneOre", p.getName())){
				StorageManager.hatsRedstoneOre.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Snow", p.getName())){
				StorageManager.hatsSnow.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-StoneBricks", p.getName())){
				StorageManager.hatsStoneBricks.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-TNT", p.getName())){
				StorageManager.hatsTNT.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-Workbench", p.getName())){
				StorageManager.hatsWorkbench.put(p.getName(), 1);
			}
			if(DatabaseManager.containsPath("name", "Hats-YellowGlass", p.getName())){
				StorageManager.hatsYellowGlass.put(p.getName(), 1);
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
			
			VoteManager.checkForVotes(p);
			
			StorageManager.IsLoaded.put(p, true);
			
			new BukkitRunnable(){
				public void run(){
					p.sendMessage("§7§m----------------------------------------");
					p.sendMessage(" §6§lOrbitMines§4§lNetwork §7- §f§lMiniGames");
					p.sendMessage(" ");
					p.sendMessage(" §cReport§7 a Player with §c/report§7.");
					p.sendMessage(" §bVote§7 for Rewards with §b/vote§7.");
					p.sendMessage(" §3Donate§7 for VIP with §3/donate§7.");
					p.sendMessage(" ");
					p.sendMessage(" §7Spawn Built By: §drienk222");
					p.sendMessage(" §7Developed By: §4O_o_Fadi_o_O");
					p.sendMessage("§7§m----------------------------------------");
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
