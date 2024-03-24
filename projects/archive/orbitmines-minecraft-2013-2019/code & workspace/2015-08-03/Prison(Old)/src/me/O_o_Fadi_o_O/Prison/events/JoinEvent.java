package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.Start;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
	Start plugin;
	 
	public JoinEvent(Start instance) {
	plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		
		e.setJoinMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oPrison§2§o)");
		
		if(!plugin.containsElement("name", "OMT", p.getName())){
			plugin.insertElement(p.getName(), "OMT", 0);
		}
		if(!plugin.containsElement("name", "POINTS", p.getName())){
			plugin.insertElement(p.getName(), "POINTS", 0);
		}
		if(!plugin.containsPath("name", "MiniGameCoins", p.getName())){
			plugin.insertPath(p.getName(), "MiniGameCoins", "coins", 0);
		}
		
		Start.omt.put(p.getName(), plugin.getOMT(p));
	
		Start.points.put(p.getName(), plugin.getVIPPoints(p));
		
		Start.coins.put(p.getName(), Start.getMiniGameCoins(p));
		
		
		if(plugin.containsElement("name", "MUSHROOMCOW", p.getName())){
			Start.mushroomcow.put(p.getName(), plugin.getMushroomCowName(p));
		}
		if(plugin.containsElement("name", "PIG", p.getName())){
			Start.pig.put(p.getName(), plugin.getPigName(p));
		}
		if(plugin.containsElement("name", "WOLF", p.getName())){
			Start.wolf.put(p.getName(), plugin.getWolfName(p));
		}
		if(plugin.containsElement("name", "SHEEP", p.getName())){
			Start.sheep.put(p.getName(), plugin.getSheepName(p));
		}
		if(plugin.containsElement("name", "HORSE", p.getName())){
			Start.horse.put(p.getName(), plugin.getHorseName(p));
		}
		if(plugin.containsElement("name", "MAGMACUBE", p.getName())){
			Start.magmacube.put(p.getName(), plugin.getMagmaCubeName(p));
		}
		if(plugin.containsElement("name", "SLIME", p.getName())){
			Start.slime.put(p.getName(), plugin.getSlimeName(p));
		}
		if(plugin.containsElement("name", "COW", p.getName())){
			Start.cow.put(p.getName(), plugin.getCowName(p));
		}
		if(plugin.containsElement("name", "SILVERFISH", p.getName())){
			Start.silverfish.put(p.getName(), plugin.getSilverfishName(p));
		}
		if(plugin.containsElement("name", "OCELOT", p.getName())){
			Start.ocelot.put(p.getName(), plugin.getOcelotName(p));
		}
		
		if(plugin.containsElement("name", "WHITE", p.getName())){
			Start.white.put(p.getName(), plugin.getWhiteWardrobe(p));
		}
		if(plugin.containsElement("name", "BLUE", p.getName())){
			Start.blue.put(p.getName(), plugin.getBlueWardrobe(p));
		}
		if(plugin.containsElement("name", "GREEN", p.getName())){
			Start.green.put(p.getName(), plugin.getGreenWardrobe(p));
		}
		if(plugin.containsElement("name", "BLACK", p.getName())){
			Start.black.put(p.getName(), plugin.getBlackWardrobe(p));
		}
		if(plugin.containsElement("name", "LIGHTBLUE", p.getName())){
			Start.lightblue.put(p.getName(), plugin.getLightBlueWardrobe(p));
		}
		if(plugin.containsElement("name", "PINK", p.getName())){
			Start.pink.put(p.getName(), plugin.getPinkWardrobe(p));
		}
		if(plugin.containsElement("name", "LIGHTGREEN", p.getName())){
			Start.lightgreen.put(p.getName(), plugin.getLightGreenWardrobe(p));
		}
		if(plugin.containsElement("name", "DARKBLUE", p.getName())){
			Start.darkblue.put(p.getName(), plugin.getDarkBlueWardrobe(p));
		}
		if(plugin.containsElement("name", "PURPLE", p.getName())){
			Start.purple.put(p.getName(), plugin.getPurpleWardrobe(p));
		}
		if(plugin.containsElement("name", "ORANGE", p.getName())){
			Start.orange.put(p.getName(), plugin.getOrangeWardrobe(p));
		}
		if(plugin.containsElement("name", "RED", p.getName())){
			Start.red.put(p.getName(), plugin.getRedWardrobe(p));
		}
		if(plugin.containsElement("name", "CYAN", p.getName())){
			Start.cyan.put(p.getName(), plugin.getCyanWardrobe(p));
		}
		if(plugin.containsElement("name", "YELLOW", p.getName())){
			Start.yellow.put(p.getName(), plugin.getYellowWardrobe(p));
		}
		if(plugin.containsElement("name", "GRAY", p.getName())){
			Start.gray.put(p.getName(), plugin.getGrayWardrobe(p));
		}
		
		if(plugin.containsElement("name", "CHATCOLORDARKRED", p.getName())){
			Start.chatcolordarkred.put(p.getName(), plugin.getChatColorDarkRed(p));
		}
		if(plugin.containsElement("name", "CHATCOLORLIGHTGREEN", p.getName())){
			Start.chatcolorlightgreen.put(p.getName(), plugin.getChatColorLightGreen(p));
		}
		if(plugin.containsElement("name", "CHATCOLORDARKGRAY", p.getName())){
			Start.chatcolordarkgray.put(p.getName(), plugin.getChatColorDarkGray(p));
		}
		if(plugin.containsElement("name", "CHATCOLORRED", p.getName())){
			Start.chatcolorred.put(p.getName(), plugin.getChatColorRed(p));
		}
		if(plugin.containsElement("name", "CHATCOLORWHITE", p.getName())){
			Start.chatcolorwhite.put(p.getName(), plugin.getChatColorWhite(p));
		}
		if(plugin.containsElement("name", "CHATCOLORLIGHTBLUE", p.getName())){
			Start.chatcolorlightblue.put(p.getName(), plugin.getChatColorLightBlue(p));
		}
		if(plugin.containsElement("name", "CHATCOLORPINK", p.getName())){
			Start.chatcolorpink.put(p.getName(), plugin.getChatColorPink(p));
		}
		if(plugin.containsElement("name", "CHATCOLORBLUE", p.getName())){
			Start.chatcolorblue.put(p.getName(), plugin.getChatColorBlue(p));
		}
		if(plugin.containsElement("name", "CHATCOLORDARKBLUE", p.getName())){
			Start.chatcolordarkblue.put(p.getName(), plugin.getChatColorDarkBlue(p));
		}
		if(plugin.containsElement("name", "CHATCOLORGREEN", p.getName())){
			Start.chatcolorgreen.put(p.getName(), plugin.getChatColorGreen(p));
		}
		if(plugin.containsElement("name", "CHATCOLORBLACK", p.getName())){
			Start.chatcolorblack.put(p.getName(), plugin.getChatColorBlack(p));
		}
		
		if(plugin.containsElement("name", "TRAILSANGRYVILLAGER", p.getName())){
			Start.trailsangryvillager.put(p.getName(), plugin.getTrailAngryVillager(p));
		}
		if(plugin.containsElement("name", "TRAILSHEART", p.getName())){
			Start.trailshearts.put(p.getName(), plugin.getTrailHearts(p));
		}
		if(plugin.containsElement("name", "TRAILSBUBBLE", p.getName())){
			Start.trailsbubbles.put(p.getName(), plugin.getTrailBubble(p));
		}
		if(plugin.containsElement("name", "TRAILSCRIT", p.getName())){
			Start.trailscrit.put(p.getName(), plugin.getTrailCrit(p));
		}
		if(plugin.containsElement("name", "TRAILSETABLE", p.getName())){
			Start.trailsenchantmenttable.put(p.getName(), plugin.getTrailETable(p));
		}
		if(plugin.containsElement("name", "TRAILSEXPLODE", p.getName())){
			Start.trailsexplode.put(p.getName(), plugin.getTrailExplode(p));
		}
		if(plugin.containsElement("name", "TRAILSFIREWORK", p.getName())){
			Start.trailsfirework.put(p.getName(), plugin.getTrailFirework(p));
		}
		if(plugin.containsElement("name", "TRAILSHAPPYVILLAGER", p.getName())){
			Start.trailshappyvillager.put(p.getName(), plugin.getTrailHappyVillager(p));
		}
		if(plugin.containsElement("name", "TRAILSMOBSPAWNER", p.getName())){
			Start.trailsmobspawner.put(p.getName(), plugin.getTrailMobSpawner(p));
		}
		if(plugin.containsElement("name", "TRAILSMUSIC", p.getName())){
			Start.trailsnote.put(p.getName(), plugin.getTrailMusic(p));
		}
		if(plugin.containsElement("name", "TRAILSSLIME", p.getName())){
			Start.trailsslime.put(p.getName(), plugin.getTrailSlime(p));
		}
		if(plugin.containsElement("name", "TRAILSSMOKE", p.getName())){
			Start.trailssmoke.put(p.getName(), plugin.getTrailSmoke(p));
		}
		if(plugin.containsElement("name", "TRAILSSNOW", p.getName())){
			Start.trailssnow.put(p.getName(), plugin.getTrailSnow(p));
		}
		if(plugin.containsElement("name", "TRAILSWATER", p.getName())){
			Start.trailswater.put(p.getName(), plugin.getTrailWater(p));
		}
		if(plugin.containsElement("name", "TRAILSWITCH", p.getName())){
			Start.trailswitch.put(p.getName(), plugin.getTrailWitch(p));
		}
		
		if(plugin.containsElement("name", "CHATCOLOR", p.getName())){
			Start.chatcolor.put(p, plugin.getChatColor(p));
		}
		else{
			plugin.insertColorCode(p.getName(), "CHATCOLOR", "7");
			Start.chatcolor.put(p, "7");
		}
		
		if(plugin.containsHats("name", "Hats-Bedrock", p.getName())){
			Start.hatsBedrock.put(p.getName(), plugin.getHat(p, "Hats-Bedrock", "bedrock"));
		}
		if(plugin.containsHats("name", "Hats-BlackGlass", p.getName())){
			Start.hatsBlackGlass.put(p.getName(), plugin.getHat(p, "Hats-BlackGlass", "blackglass"));
		}
		if(plugin.containsHats("name", "Hats-Cactus", p.getName())){
			Start.hatsCactus.put(p.getName(), plugin.getHat(p, "Hats-Cactus", "cactus"));
		}
		if(plugin.containsHats("name", "Hats-CoalBlock", p.getName())){
			Start.hatsCoalBlock.put(p.getName(), plugin.getHat(p, "Hats-CoalBlock", "coalblock"));
		}
		if(plugin.containsHats("name", "Hats-CoalOre", p.getName())){
			Start.hatsCoalOre.put(p.getName(), plugin.getHat(p, "Hats-CoalOre", "coalore"));
		}
		if(plugin.containsHats("name", "Hats-Furnace", p.getName())){
			Start.hatsFurnace.put(p.getName(), plugin.getHat(p, "Hats-Furnace", "furnace"));
		}
		if(plugin.containsHats("name", "Hats-Glass", p.getName())){
			Start.hatsGlass.put(p.getName(), plugin.getHat(p, "Hats-Glass", "glass"));
		}
		if(plugin.containsHats("name", "Hats-Grass", p.getName())){
			Start.hatsGrass.put(p.getName(), plugin.getHat(p, "Hats-Grass", "grass"));
		}
		if(plugin.containsHats("name", "Hats-GreenGlass", p.getName())){
			Start.hatsGreenGlass.put(p.getName(), plugin.getHat(p, "Hats-GreenGlass", "greenglass"));
		}
		if(plugin.containsHats("name", "Hats-HayBale", p.getName())){
			Start.hatsHayBale.put(p.getName(), plugin.getHat(p, "Hats-HayBale", "haybale"));
		}
		if(plugin.containsHats("name", "Hats-Ice", p.getName())){
			Start.hatsIce.put(p.getName(), plugin.getHat(p, "Hats-Ice", "ice"));
		}
		if(plugin.containsHats("name", "Hats-LapisBlock", p.getName())){
			Start.hatsLapisBlock.put(p.getName(), plugin.getHat(p, "Hats-LapisBlock", "lapisblock"));
		}
		if(plugin.containsHats("name", "Hats-LapisOre", p.getName())){
			Start.hatsLapisOre.put(p.getName(), plugin.getHat(p, "Hats-LapisOre", "lapisore"));
		}
		if(plugin.containsHats("name", "Hats-Leaves", p.getName())){
			Start.hatsLeaves.put(p.getName(), plugin.getHat(p, "Hats-Leaves", "leaves"));
		}
		if(plugin.containsHats("name", "Hats-MagentaGlass", p.getName())){
			Start.hatsMagentaGlass.put(p.getName(), plugin.getHat(p, "Hats-MagentaGlass", "magentaglass"));
		}
		if(plugin.containsHats("name", "Hats-Melon", p.getName())){
			Start.hatsMelon.put(p.getName(), plugin.getHat(p, "Hats-Melon", "melon"));
		}
		if(plugin.containsHats("name", "Hats-Mycelium", p.getName())){
			Start.hatsMycelium.put(p.getName(), plugin.getHat(p, "Hats-Mycelium", "mycelium"));
		}
		if(plugin.containsHats("name", "Hats-OrangeGlass", p.getName())){
			Start.hatsOrangeGlass.put(p.getName(), plugin.getHat(p, "Hats-OrangeGlass", "orangeglass"));
		}
		if(plugin.containsHats("name", "Hats-QuartzBlock", p.getName())){
			Start.hatsQuartzBlock.put(p.getName(), plugin.getHat(p, "Hats-QuartzBlock", "quartzblock"));
		}
		if(plugin.containsHats("name", "Hats-QuartzOre", p.getName())){
			Start.hatsQuartzOre.put(p.getName(), plugin.getHat(p, "Hats-QuartzOre", "quartzore"));
		}
		if(plugin.containsHats("name", "Hats-RedGlass", p.getName())){
			Start.hatsRedGlass.put(p.getName(), plugin.getHat(p, "Hats-RedGlass", "redglass"));
		}
		if(plugin.containsHats("name", "Hats-RedstoneBlock", p.getName())){
			Start.hatsRedstoneBlock.put(p.getName(), plugin.getHat(p, "Hats-RedstoneBlock", "redstoneblock"));
		}
		if(plugin.containsHats("name", "Hats-RedstoneOre", p.getName())){
			Start.hatsRedstoneOre.put(p.getName(), plugin.getHat(p, "Hats-RedstoneOre", "redstoneore"));
		}
		if(plugin.containsHats("name", "Hats-Snow", p.getName())){
			Start.hatsSnow.put(p.getName(), plugin.getHat(p, "Hats-Snow", "snow"));
		}
		if(plugin.containsHats("name", "Hats-StoneBricks", p.getName())){
			Start.hatsStoneBricks.put(p.getName(), plugin.getHat(p, "Hats-StoneBricks", "stonebricks"));
		}
		if(plugin.containsHats("name", "Hats-TNT", p.getName())){
			Start.hatsTNT.put(p.getName(), plugin.getHat(p, "Hats-TNT", "tnt"));
		}
		if(plugin.containsHats("name", "Hats-Workbench", p.getName())){
			Start.hatsWorkbench.put(p.getName(), plugin.getHat(p, "Hats-Workbench", "workbench"));
		}
		if(plugin.containsHats("name", "Hats-YellowGlass", p.getName())){
			Start.hatsYellowGlass.put(p.getName(), plugin.getHat(p, "Hats-YellowGlass", "yellowglass"));
		}
		
		if(plugin.containsDisguises("name", "Dis-Witch", p.getName())){
			Start.disWitch.put(p.getName(), plugin.getDisguise(p, "Dis-Witch", "witch"));
		}
		if(plugin.containsDisguises("name", "Dis-Bat", p.getName())){
			Start.disBat.put(p.getName(), plugin.getDisguise(p, "Dis-Bat", "bat"));
		}
		if(plugin.containsDisguises("name", "Dis-Chicken", p.getName())){
			Start.disChicken.put(p.getName(), plugin.getDisguise(p, "Dis-Chicken", "chicken"));
		}
		if(plugin.containsDisguises("name", "Dis-Ocelot", p.getName())){
			Start.disOcelot.put(p.getName(), plugin.getDisguise(p, "Dis-Ocelot", "ocelot"));
		}
		if(plugin.containsDisguises("name", "Dis-MushroomCow", p.getName())){
			Start.disMushroomCow.put(p.getName(), plugin.getDisguise(p, "Dis-MushroomCow", "mushroomcow"));
		}
		if(plugin.containsDisguises("name", "Dis-Squid", p.getName())){
			Start.disSquid.put(p.getName(), plugin.getDisguise(p, "Dis-Squid", "squid"));
		}
		if(plugin.containsDisguises("name", "Dis-Slime", p.getName())){
			Start.disSlime.put(p.getName(), plugin.getDisguise(p, "Dis-Slime", "slime"));
		}
		if(plugin.containsDisguises("name", "Dis-ZombiePigman", p.getName())){
			Start.disZombiePigman.put(p.getName(), plugin.getDisguise(p, "Dis-ZombiePigman", "zombiepigman"));
		}
		if(plugin.containsDisguises("name", "Dis-MagmaCube", p.getName())){
			Start.disMagmaCube.put(p.getName(), plugin.getDisguise(p, "Dis-MagmaCube", "magmacube"));
		}
		if(plugin.containsDisguises("name", "Dis-Skeleton", p.getName())){
			Start.disSkeleton.put(p.getName(), plugin.getDisguise(p, "Dis-Skeleton", "skeleton"));
		}
		if(plugin.containsDisguises("name", "Dis-Wolf", p.getName())){
			Start.disWolf.put(p.getName(), plugin.getDisguise(p, "Dis-Wolf", "wolf"));
		}
		if(plugin.containsDisguises("name", "Dis-Spider", p.getName())){
			Start.disSpider.put(p.getName(), plugin.getDisguise(p, "Dis-Spider", "spider"));
		}
		if(plugin.containsDisguises("name", "Dis-Silverfish", p.getName())){
			Start.disSilverfish.put(p.getName(), plugin.getDisguise(p, "Dis-Silverfish", "silverfish"));
		}
		if(plugin.containsDisguises("name", "Dis-Sheep", p.getName())){
			Start.disSheep.put(p.getName(), plugin.getDisguise(p, "Dis-Sheep", "sheep"));
		}
		if(plugin.containsDisguises("name", "Dis-CaveSpider", p.getName())){
			Start.disCaveSpider.put(p.getName(), plugin.getDisguise(p, "Dis-CaveSpider", "cavespider"));
		}
		if(plugin.containsDisguises("name", "Dis-Creeper", p.getName())){
			Start.disCreeper.put(p.getName(), plugin.getDisguise(p, "Dis-Creeper", "creeper"));
		}
		if(plugin.containsDisguises("name", "Dis-Cow", p.getName())){
			Start.disCow.put(p.getName(), plugin.getDisguise(p, "Dis-Cow", "cow"));
		}
		
		p.chat("/spawn");
	}
}
