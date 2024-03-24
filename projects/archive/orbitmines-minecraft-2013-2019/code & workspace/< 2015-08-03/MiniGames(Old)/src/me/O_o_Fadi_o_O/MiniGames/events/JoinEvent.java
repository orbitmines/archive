package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
	Start plugin;
	 
	public JoinEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		Manager.joinChickenFight(p);
		
		if(!plugin.containsPath("name", "OrbitMinesTokens", p.getName())){
			plugin.insertInt(p.getName(), "OrbitMinesTokens", "omt", 0);
		}
		if(!plugin.containsPath("name", "VIPPoints", p.getName())){
			plugin.insertInt(p.getName(), "VIPPoints", "points", 0);
		}
		if(!plugin.containsPath("name", "MiniGameCoins", p.getName())){
			plugin.insertInt(p.getName(), "MiniGameCoins", "coins", 0);
		}
		
		if(!plugin.containsPath("name", "MiniGameKills", p.getName())){
			plugin.insertInt(p.getName(), "MiniGameKills", "kills", 0);
		}
		if(!plugin.containsPath("name", "MiniGameLoses", p.getName())){
			plugin.insertInt(p.getName(), "MiniGameLoses", "loses", 0);
		}
		if(!plugin.containsPath("name", "MiniGameWins", p.getName())){
			plugin.insertInt(p.getName(), "MiniGameWins", "wins", 0);
		}
		if(!plugin.containsPath("name", "Fireworks-Passes", p.getName())){
			plugin.insertInt(p.getName(), "Fireworks-Passes", "passes", 0);
		}
		
		Start.kills.put(p.getName(), Start.getInt(p, "MiniGameKills", "kills"));
		Start.loses.put(p.getName(), Start.getInt(p, "MiniGameLoses", "loses"));
		Start.wins.put(p.getName(), Start.getInt(p, "MiniGameWins", "wins"));
		
		Start.omt.put(p.getName(), Start.getInt(p, "OrbitMinesTokens", "omt"));
	
		Start.points.put(p.getName(), Start.getInt(p, "VIPPoints", "points"));
		
		Start.coins.put(p.getName(), Start.getInt(p, "MiniGameCoins", "coins"));
		
		Start.FireworkPasses.put(p.getName(), Start.getInt(p, "Fireworks-Passes", "passes"));
		
		if(plugin.containsPath("name", "ChickenFight-BabyChicken", p.getName())){
			Start.KitBabyChicken.put(p.getName(), false);
		}
		if(plugin.containsPath("name", "ChickenFight-HotWing", p.getName())){
			Start.KitHotWing.put(p.getName(), false);
		}
		if(plugin.containsPath("name", "ChickenFight-ChickenWarrior", p.getName())){
			Start.KitChickenWarrior.put(p.getName(), false);
		}
		
		if(plugin.containsPath("name", "Gadgets-Paintballs", p.getName())){
			Start.gadgetsPaintballs.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Gadgets-CreeperLauncher", p.getName())){
			Start.gadgetsCreeperLauncher.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Gadgets-PetRide", p.getName())){
			Start.gadgetsPetRide.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Gadgets-BookExplosion", p.getName())){
			Start.gadgetsBookExplosion.put(p.getName(), 1);
		}
		
		if(plugin.containsPath("name", "Pets-MushroomCow", p.getName())){
			Start.mushroomcow.put(p.getName(), Start.getString(p, "Pets-Ocelot", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Pig", p.getName())){
			Start.pig.put(p.getName(), Start.getString(p, "Pets-Pig", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Wolf", p.getName())){
			Start.wolf.put(p.getName(), Start.getString(p, "Pets-Wolf", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Sheep", p.getName())){
			Start.sheep.put(p.getName(), Start.getString(p, "Pets-Sheep", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Horse", p.getName())){
			Start.horse.put(p.getName(), Start.getString(p, "Pets-Horse", "petname"));
		}
		if(plugin.containsPath("name", "Pets-MagmaCube", p.getName())){
			Start.magmacube.put(p.getName(), Start.getString(p, "Pets-MagmaCube", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Slime", p.getName())){
			Start.slime.put(p.getName(), Start.getString(p, "Pets-Slime", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Cow", p.getName())){
			Start.cow.put(p.getName(), Start.getString(p, "Pets-Cow", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Silverfish", p.getName())){
			Start.silverfish.put(p.getName(), Start.getString(p, "Pets-Silverfish", "petname"));
		}
		if(plugin.containsPath("name", "Pets-Ocelot", p.getName())){
			Start.ocelot.put(p.getName(), Start.getString(p, "Pets-Ocelot", "petname"));
		}
		
		if(plugin.containsPath("name", "Wardrobe-White", p.getName())){
			Start.white.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Blue", p.getName())){
			Start.blue.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Green", p.getName())){
			Start.green.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Black", p.getName())){
			Start.black.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-LightBlue", p.getName())){
			Start.lightblue.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Pink", p.getName())){
			Start.pink.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-LightGreen", p.getName())){
			Start.lightgreen.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-DarkBlue", p.getName())){
			Start.darkblue.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Purple", p.getName())){
			Start.purple.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Orange", p.getName())){
			Start.orange.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Red", p.getName())){
			Start.red.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Cyan", p.getName())){
			Start.cyan.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Yellow", p.getName())){
			Start.yellow.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Wardrobe-Gray", p.getName())){
			Start.gray.put(p.getName(), 1);
		}
		
		if(plugin.containsPath("name", "ChatColors-DarkRed", p.getName())){
			Start.chatcolordarkred.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-LightGreen", p.getName())){
			Start.chatcolorlightgreen.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-DarkGray", p.getName())){
			Start.chatcolordarkgray.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-Red", p.getName())){
			Start.chatcolorred.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-White", p.getName())){
			Start.chatcolorwhite.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-LightBlue", p.getName())){
			Start.chatcolorlightblue.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-Pink", p.getName())){
			Start.chatcolorpink.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-Blue", p.getName())){
			Start.chatcolorblue.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-DarkBlue", p.getName())){
			Start.chatcolordarkblue.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-Green", p.getName())){
			Start.chatcolorgreen.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "ChatColors-Black", p.getName())){
			Start.chatcolorblack.put(p.getName(), 1);
		}
		
		if(plugin.containsPath("name", "Trails-AngryVillager", p.getName())){
			Start.trailsangryvillager.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Hearts", p.getName())){
			Start.trailshearts.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Bubble", p.getName())){
			Start.trailsbubbles.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Crit", p.getName())){
			Start.trailscrit.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-ETable", p.getName())){
			Start.trailsenchantmenttable.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Explode", p.getName())){
			Start.trailsexplode.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Firework", p.getName())){
			Start.trailsfirework.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-HappyVillager", p.getName())){
			Start.trailshappyvillager.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-MobSpawner", p.getName())){
			Start.trailsmobspawner.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Music", p.getName())){
			Start.trailsnote.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Slime", p.getName())){
			Start.trailsslime.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Smoke", p.getName())){
			Start.trailssmoke.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Snow", p.getName())){
			Start.trailssnow.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Water", p.getName())){
			Start.trailswater.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Trails-Witch", p.getName())){
			Start.trailswitch.put(p.getName(), 1);
		}
		
		if(plugin.containsPath("name", "ChatColors", p.getName())){
			Start.chatcolor.put(p, Start.getString(p, "ChatColors", "color"));
		}
		else{
			plugin.insertString(p.getName(), "ChatColors", "color", "7");
			Start.chatcolor.put(p, "7");
		}
		
		if(plugin.containsPath("name", "Hats-Bedrock", p.getName())){
			Start.hatsBedrock.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-BlackGlass", p.getName())){
			Start.hatsBlackGlass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Cactus", p.getName())){
			Start.hatsCactus.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-CoalBlock", p.getName())){
			Start.hatsCoalBlock.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-CoalOre", p.getName())){
			Start.hatsCoalOre.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Furnace", p.getName())){
			Start.hatsFurnace.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Glass", p.getName())){
			Start.hatsGlass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Grass", p.getName())){
			Start.hatsGrass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-GreenGlass", p.getName())){
			Start.hatsGreenGlass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-HayBale", p.getName())){
			Start.hatsHayBale.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Ice", p.getName())){
			Start.hatsIce.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-LapisBlock", p.getName())){
			Start.hatsLapisBlock.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-LapisOre", p.getName())){
			Start.hatsLapisOre.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Leaves", p.getName())){
			Start.hatsLeaves.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-MagentaGlass", p.getName())){
			Start.hatsMagentaGlass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Melon", p.getName())){
			Start.hatsMelon.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Mycelium", p.getName())){
			Start.hatsMycelium.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-OrangeGlass", p.getName())){
			Start.hatsOrangeGlass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-QuartzBlock", p.getName())){
			Start.hatsQuartzBlock.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-QuartzOre", p.getName())){
			Start.hatsQuartzOre.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-RedGlass", p.getName())){
			Start.hatsRedGlass.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-RedstoneBlock", p.getName())){
			Start.hatsRedstoneBlock.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-RedstoneOre", p.getName())){
			Start.hatsRedstoneOre.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Snow", p.getName())){
			Start.hatsSnow.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-StoneBricks", p.getName())){
			Start.hatsStoneBricks.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-TNT", p.getName())){
			Start.hatsTNT.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-Workbench", p.getName())){
			Start.hatsWorkbench.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Hats-YellowGlass", p.getName())){
			Start.hatsYellowGlass.put(p.getName(), 1);
		}
		
		if(plugin.containsPath("name", "Dis-Witch", p.getName())){
			Start.disWitch.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Bat", p.getName())){
			Start.disBat.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Chicken", p.getName())){
			Start.disChicken.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Ocelot", p.getName())){
			Start.disOcelot.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-MushroomCow", p.getName())){
			Start.disMushroomCow.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Squid", p.getName())){
			Start.disSquid.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Slime", p.getName())){
			Start.disSlime.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-ZombiePigman", p.getName())){
			Start.disZombiePigman.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-MagmaCube", p.getName())){
			Start.disMagmaCube.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Skeleton", p.getName())){
			Start.disSkeleton.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Wolf", p.getName())){
			Start.disWolf.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Spider", p.getName())){
			Start.disSpider.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Silverfish", p.getName())){
			Start.disSilverfish.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Sheep", p.getName())){
			Start.disSheep.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-CaveSpider", p.getName())){
			Start.disCaveSpider.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Creeper", p.getName())){
			Start.disCreeper.put(p.getName(), 1);
		}
		if(plugin.containsPath("name", "Dis-Cow", p.getName())){
			Start.disCow.put(p.getName(), 1);
		}
		
	}
}
