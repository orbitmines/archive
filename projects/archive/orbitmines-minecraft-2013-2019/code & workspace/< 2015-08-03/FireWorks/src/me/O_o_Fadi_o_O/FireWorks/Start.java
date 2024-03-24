package me.O_o_Fadi_o_O.FireWorks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 5;
	
	HashMap<String, String> TRAIL = new HashMap<>();
	HashMap<String, String> FLICKER = new HashMap<>();
	HashMap<String, String> FADE1 = new HashMap<>();
	HashMap<String, String> FADE2 = new HashMap<>();
	HashMap<String, String> COLOR1 = new HashMap<>();
	HashMap<String, String> COLOR2 = new HashMap<>();
	HashMap<String, String> TYPE = new HashMap<>();
	
	public String TAG = "§8[§6§lFire§4§lWorks§8]";
	
	public void onEnable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
		if((sender instanceof Player)){
			Player player = (Player)sender;
			
			if(a.length == 0){
				player.sendMessage(TAG + " §cIncorrect Use!");
				player.sendMessage(TAG + " §6Type /fw help for help!");
			}
			else if(a[0].equalsIgnoreCase("help")){
				player.sendMessage(TAG + " §6FireWorks v1.0 §7by §6O_o_Fadi_o_O");
				player.sendMessage(TAG + " §7All Commands:");
				player.sendMessage(TAG + " §6/fw help §7(Shows this Menu)");
				player.sendMessage(TAG + " §6/fw random §7(Random FireWork)");
				player.sendMessage(TAG + " §6/fw setup help §7(Setup FireWork Help)");
			}
			else if(a[0].equalsIgnoreCase("setup")){
				if(player.hasPermission("FireWorks.Setup")){
				if(a.length == 8){
					
					long lastUsed = 0;
					if(lastUsage.containsKey(player.getName())){
						lastUsed = lastUsage.get(player.getName());
					}
					int cdmillis = cdtime * 1000;
					
					if(System.currentTimeMillis()-lastUsed>=cdmillis){
						
					// TRAIL
					if(a[1].equalsIgnoreCase("true")){
						TRAIL.put(player.getName(), "true");
						player.sendMessage(TAG + " §7Trail §aenabled§7.");
					}
					else if(a[1].equalsIgnoreCase("false")){
						TRAIL.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Trail §cdisabled§7.");
					}
					else{
						TRAIL.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Trail §cdisabled§7. (Selected Default)");
						player.sendMessage(TAG + " §cTrail: invalid argument: '" + a[1] + "'!");
					}
					// FLICKER
					if(a[2].equalsIgnoreCase("true")){
						FLICKER.put(player.getName(), "true");
						player.sendMessage(TAG + " §7Flicker §aenabled§7.");
					}
					else if(a[2].equalsIgnoreCase("false")){
						FLICKER.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Flicker §cdisabled§7.");
					}
					else{
						FLICKER.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Flicker §cdisabled§7. (Selected Default)");
						player.sendMessage(TAG + " §cFlicker: invalid argument: '" + a[2] + "'!");
					}
					// FADE 1
					if(a[3].equalsIgnoreCase("green")){
						FADE1.put(player.getName(), "GREEN");
						player.sendMessage(TAG + " §7Fade 1: §agreen§7.");
					}
					else if(a[3].equalsIgnoreCase("lightblue")){
						FADE1.put(player.getName(), "LIGHT_BLUE");
						player.sendMessage(TAG + " §7Fade 1: §blightblue§7.");
					}
					else if(a[3].equalsIgnoreCase("brown")){
						FADE1.put(player.getName(), "BROWN");
						player.sendMessage(TAG + " §7Fade 1: §fbrown§7.");
					}
					else if(a[3].equalsIgnoreCase("pink")){
						FADE1.put(player.getName(), "PINK");
						player.sendMessage(TAG + " §7Fade 1: §dpink§7.");
					}
					else if(a[3].equalsIgnoreCase("yellow")){
						FADE1.put(player.getName(), "YELLOW");
						player.sendMessage(TAG + " §7Fade 1: §eyellow§7.");
					}
					else if(a[3].equalsIgnoreCase("white")){
						FADE1.put(player.getName(), "WHITE");
						player.sendMessage(TAG + " §7Fade 1: §fwhite§7.");
					}
					else if(a[3].equalsIgnoreCase("black")){
						FADE1.put(player.getName(), "BLACK");
						player.sendMessage(TAG + " §7Fade 1: §0black§7.");
					}
					else if(a[3].equalsIgnoreCase("darkblue")){
						FADE1.put(player.getName(), "DARK_BLUE");
						player.sendMessage(TAG + " §7Fade 1: §1darkblue§7.");
					}
					else if(a[3].equalsIgnoreCase("darkgreen")){
						FADE1.put(player.getName(), "DARK_GREEN");
						player.sendMessage(TAG + " §7Fade 1: §2darkgreen§7.");
					}
					else if(a[3].equalsIgnoreCase("cyan")){
						FADE1.put(player.getName(), "CYAN");
						player.sendMessage(TAG + " §7Fade 1: §3cyan§7.");
					}
					else if(a[3].equalsIgnoreCase("red")){
						FADE1.put(player.getName(), "DARK_RED");
						player.sendMessage(TAG + " §7Fade 1: §cred§7.");
					}
					else if(a[3].equalsIgnoreCase("purple")){
						FADE1.put(player.getName(), "PURPLE");
						player.sendMessage(TAG + " §7Fade 1: §5purple§7.");
					}
					else if(a[3].equalsIgnoreCase("gold")){
						FADE1.put(player.getName(), "GOLD");
						player.sendMessage(TAG + " §7Fade 1: §6gold§7.");
					}
					else if(a[3].equalsIgnoreCase("grey")){
						FADE1.put(player.getName(), "GREY");
						player.sendMessage(TAG + " §7Fade 1: §7grey§7.");
					}
					else if(a[3].equalsIgnoreCase("darkgrey")){
						FADE1.put(player.getName(), "DARKGREY");
						player.sendMessage(TAG + " §7Fade 1: §8darkgrey§7.");
					}
					else if(a[3].equalsIgnoreCase("blue")){
						FADE1.put(player.getName(), "BLUE");
						player.sendMessage(TAG + " §7Fade 1: §9blue§7.");
					}
					else if(a[3].equalsIgnoreCase("false")){
						FADE1.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Fade 1: §cdisabled§7.");
					}
					else{
						FADE1.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Fade 1: §cdisabled§7. (Selected Default)");
						player.sendMessage(TAG + " §cFade 1: invalid argument: '" + a[3] + "'!");
					}
					// FADE 2
					if(a[4].equalsIgnoreCase("green")){
						FADE2.put(player.getName(), "GREEN");
						player.sendMessage(TAG + " §7Fade 2: §agreen§7.");
					}
					else if(a[4].equalsIgnoreCase("lightblue")){
						FADE2.put(player.getName(), "LIGHT_BLUE");
						player.sendMessage(TAG + " §7Fade 2: §blightblue§7.");
					}
					else if(a[4].equalsIgnoreCase("brown")){
						FADE2.put(player.getName(), "BROWN");
						player.sendMessage(TAG + " §7Fade 2: §fbrown§7.");
					}
					else if(a[4].equalsIgnoreCase("pink")){
						FADE2.put(player.getName(), "PINK");
						player.sendMessage(TAG + " §7Fade 2: §dpink§7.");
					}
					else if(a[4].equalsIgnoreCase("yellow")){
						FADE2.put(player.getName(), "YELLOW");
						player.sendMessage(TAG + " §7Fade 2: §eyellow§7.");
					}
					else if(a[4].equalsIgnoreCase("white")){
						FADE2.put(player.getName(), "WHITE");
						player.sendMessage(TAG + " §7Fade 2: §fwhite§7.");
					}
					else if(a[4].equalsIgnoreCase("black")){
						FADE2.put(player.getName(), "BLACK");
						player.sendMessage(TAG + " §7Fade 2: §0black§7.");
					}
					else if(a[4].equalsIgnoreCase("darkblue")){
						FADE2.put(player.getName(), "DARK_BLUE");
						player.sendMessage(TAG + " §7Fade 2: §1darkblue§7.");
					}
					else if(a[4].equalsIgnoreCase("darkgreen")){
						FADE2.put(player.getName(), "DARK_GREEN");
						player.sendMessage(TAG + " §7Fade 2: §2darkgreen§7.");
					}
					else if(a[4].equalsIgnoreCase("cyan")){
						FADE2.put(player.getName(), "CYAN");
						player.sendMessage(TAG + " §7Fade 2: §3cyan§7.");
					}
					else if(a[4].equalsIgnoreCase("red")){
						FADE2.put(player.getName(), "DARK_RED");
						player.sendMessage(TAG + " §7Fade 2: §cred§7.");
					}
					else if(a[4].equalsIgnoreCase("purple")){
						FADE2.put(player.getName(), "PURPLE");
						player.sendMessage(TAG + " §7Fade 2: §5purple§7.");
					}
					else if(a[4].equalsIgnoreCase("gold")){
						FADE2.put(player.getName(), "GOLD");
						player.sendMessage(TAG + " §7Fade 2: §6gold§7.");
					}
					else if(a[4].equalsIgnoreCase("grey")){
						FADE2.put(player.getName(), "GREY");
						player.sendMessage(TAG + " §7Fade 2: §7grey§7.");
					}
					else if(a[4].equalsIgnoreCase("darkgrey")){
						FADE2.put(player.getName(), "DARKGREY");
						player.sendMessage(TAG + " §7Fade 2: §8darkgrey§7.");
					}
					else if(a[4].equalsIgnoreCase("blue")){
						FADE2.put(player.getName(), "BLUE");
						player.sendMessage(TAG + " §7Fade 2: §9blue§7.");
					}
					else if(a[4].equalsIgnoreCase("false")){
						FADE2.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Fade 2: §cdisabled§7.");
					}
					else{
						FADE2.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Fade 2: §cdisabled§7. (Selected Default)");
						player.sendMessage(TAG + " §cFade 2: invalid argument: '" + a[4] + "'!");
					}
					// COLOR 1
					if(a[5].equalsIgnoreCase("green")){
						COLOR1.put(player.getName(), "GREEN");
						player.sendMessage(TAG + " §7Color 1: §agreen§7.");
					}
					else if(a[5].equalsIgnoreCase("lightblue")){
						COLOR1.put(player.getName(), "LIGHT_BLUE");
						player.sendMessage(TAG + " §7Color 1: §blightblue§7.");
					}
					else if(a[5].equalsIgnoreCase("brown")){
						COLOR1.put(player.getName(), "BROWN");
						player.sendMessage(TAG + " §7Color 1: §fbrown§7.");
					}
					else if(a[5].equalsIgnoreCase("pink")){
						COLOR1.put(player.getName(), "PINK");
						player.sendMessage(TAG + " §7Color 1: §dpink§7.");
					}
					else if(a[5].equalsIgnoreCase("yellow")){
						COLOR1.put(player.getName(), "YELLOW");
						player.sendMessage(TAG + " §7Color 1: §eyellow§7.");
					}
					else if(a[5].equalsIgnoreCase("white")){
						COLOR1.put(player.getName(), "WHITE");
						player.sendMessage(TAG + " §7Color 1: §fwhite§7.");
					}
					else if(a[5].equalsIgnoreCase("black")){
						COLOR1.put(player.getName(), "BLACK");
						player.sendMessage(TAG + " §7Color 1: §0black§7.");
					}
					else if(a[5].equalsIgnoreCase("darkblue")){
						COLOR1.put(player.getName(), "DARK_BLUE");
						player.sendMessage(TAG + " §7Color 1: §1darkblue§7.");
					}
					else if(a[5].equalsIgnoreCase("darkgreen")){
						COLOR1.put(player.getName(), "DARK_GREEN");
						player.sendMessage(TAG + " §7Color 1: §2darkgreen§7.");
					}
					else if(a[5].equalsIgnoreCase("cyan")){
						COLOR1.put(player.getName(), "CYAN");
						player.sendMessage(TAG + " §7Color 1: §3cyan§7.");
					}
					else if(a[5].equalsIgnoreCase("red")){
						COLOR1.put(player.getName(), "DARK_RED");
						player.sendMessage(TAG + " §7Color 1: §cred§7.");
					}
					else if(a[5].equalsIgnoreCase("purple")){
						COLOR1.put(player.getName(), "PURPLE");
						player.sendMessage(TAG + " §7Color 1: §5purple§7.");
					}
					else if(a[5].equalsIgnoreCase("gold")){
						COLOR1.put(player.getName(), "GOLD");
						player.sendMessage(TAG + " §7Color 1: §6gold§7.");
					}
					else if(a[5].equalsIgnoreCase("grey")){
						COLOR1.put(player.getName(), "GREY");
						player.sendMessage(TAG + " §7Color 1: §7grey§7.");
					}
					else if(a[5].equalsIgnoreCase("darkgrey")){
						COLOR1.put(player.getName(), "DARKGREY");
						player.sendMessage(TAG + " §7Color 1: §8darkgrey§7.");
					}
					else if(a[5].equalsIgnoreCase("blue")){
						COLOR1.put(player.getName(), "BLUE");
						player.sendMessage(TAG + " §7Color 1: §9blue§7.");
					}
					else{
						COLOR1.put(player.getName(), "WHITE");
						player.sendMessage(TAG + " §7Color 1: §fwhite§7. (Selected Default)");
						player.sendMessage(TAG + " §cColor 1: invalid argument: '" + a[5] + "'!");
					}
					// COLOR 2
					if(a[6].equalsIgnoreCase("green")){
						COLOR2.put(player.getName(), "GREEN");
						player.sendMessage(TAG + " §7Color 2: §agreen§7.");
					}
					else if(a[6].equalsIgnoreCase("lightblue")){
						COLOR2.put(player.getName(), "LIGHT_BLUE");
						player.sendMessage(TAG + " §7Color 2: §blightblue§7.");
					}
					else if(a[6].equalsIgnoreCase("brown")){
						COLOR2.put(player.getName(), "BROWN");
						player.sendMessage(TAG + " §7Color 2: §fbrown§7.");
					}
					else if(a[6].equalsIgnoreCase("pink")){
						COLOR2.put(player.getName(), "PINK");
						player.sendMessage(TAG + " §7Color 2: §dpink§7.");
					}
					else if(a[6].equalsIgnoreCase("yellow")){
						COLOR2.put(player.getName(), "YELLOW");
						player.sendMessage(TAG + " §7Color 2: §eyellow§7.");
					}
					else if(a[6].equalsIgnoreCase("white")){
						COLOR2.put(player.getName(), "WHITE");
						player.sendMessage(TAG + " §7Color 2: §fwhite§7.");
					}
					else if(a[6].equalsIgnoreCase("black")){
						COLOR2.put(player.getName(), "BLACK");
						player.sendMessage(TAG + " §7Color 2: §0black§7.");
					}
					else if(a[6].equalsIgnoreCase("darkblue")){
						COLOR2.put(player.getName(), "DARK_BLUE");
						player.sendMessage(TAG + " §7Color 2: §1darkblue§7.");
					}
					else if(a[6].equalsIgnoreCase("darkgreen")){
						COLOR2.put(player.getName(), "DARK_GREEN");
						player.sendMessage(TAG + " §7Color 2: §2darkgreen§7.");
					}
					else if(a[6].equalsIgnoreCase("cyan")){
						COLOR2.put(player.getName(), "CYAN");
						player.sendMessage(TAG + " §7Color 2: §3cyan§7.");
					}
					else if(a[6].equalsIgnoreCase("red")){
						COLOR2.put(player.getName(), "DARK_RED");
						player.sendMessage(TAG + " §7Color 2: §cred§7.");
					}
					else if(a[6].equalsIgnoreCase("purple")){
						COLOR2.put(player.getName(), "PURPLE");
						player.sendMessage(TAG + " §7Color 2: §5purple§7.");
					}
					else if(a[6].equalsIgnoreCase("gold")){
						COLOR2.put(player.getName(), "GOLD");
						player.sendMessage(TAG + " §7Color 2: §6gold§7.");
					}
					else if(a[6].equalsIgnoreCase("grey")){
						COLOR2.put(player.getName(), "GREY");
						player.sendMessage(TAG + " §7Color 2: §7grey§7.");
					}
					else if(a[6].equalsIgnoreCase("darkgrey")){
						COLOR2.put(player.getName(), "DARKGREY");
						player.sendMessage(TAG + " §7Color 2: §8darkgrey§7.");
					}
					else if(a[6].equalsIgnoreCase("blue")){
						COLOR2.put(player.getName(), "BLUE");
						player.sendMessage(TAG + " §7Color 2: §9blue§7.");
					}
					else if(a[6].equalsIgnoreCase("false")){
						COLOR2.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Color 2: §cdisabled§7.");
					}
					else{
						COLOR2.put(player.getName(), "false");
						player.sendMessage(TAG + " §7Color 2: §cdisabled§7.(Selected Default)");
						player.sendMessage(TAG + " §cColor 2: invalid argument: '" + a[6] + "'!");
					}
					// TYPE
					if(a[7].equalsIgnoreCase("small")){
						TYPE.put(player.getName(), "SMALL");
						player.sendMessage(TAG + " §7Type: §3small§7.");
					}
					else if(a[7].equalsIgnoreCase("large")){
						TYPE.put(player.getName(), "LARGE");
						player.sendMessage(TAG + " §7Type: §8large§7.");
					}
					else if(a[7].equalsIgnoreCase("special")){
						TYPE.put(player.getName(), "SPECIAL");
						player.sendMessage(TAG + " §7Type: §5special§7.");
					}
					else if(a[7].equalsIgnoreCase("creeper")){
						TYPE.put(player.getName(), "CREEPER");
						player.sendMessage(TAG + " §7Type: §acreeper§7.");
					}
					else if(a[7].equalsIgnoreCase("star")){
						TYPE.put(player.getName(), "STAR");
						player.sendMessage(TAG + " §7Type: §6star§7.");
					}
					else{
						TYPE.put(player.getName(), "SMALL");
						player.sendMessage(TAG + " §7Type: §3small§7. (Selected Default)");
						player.sendMessage(TAG + " §cType: invalid argument: '" + a[7] + "'!");
					}
					
			        Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
			        FireworkMeta fwmeta = fw.getFireworkMeta();
			        FireworkEffect.Builder builder = FireworkEffect.builder();
			        
			        // ADD TRAIL
			        if(TRAIL.get(player.getName()) == "true"){
			        	builder.withTrail();
			        }
			        // ADD FLICKER
			        if(FLICKER.get(player.getName()) == "true"){
			        	builder.withFlicker();
			        }
			        // ADD FADE 1
			        if(FADE1.get(player.getName()) == "LIGHT_BLUE"){
			        	builder.withFade(Color.AQUA);
			        }
			        if(FADE1.get(player.getName()) == "GREEN"){
			        	builder.withFade(Color.LIME);
			        }
			        if(FADE1.get(player.getName()) == "BLACK"){
			        	builder.withFade(Color.BLACK);
			        }
			        if(FADE1.get(player.getName()) == "DARK_BLUE"){
			        	builder.withFade(Color.BLUE);
			        }
			        if(FADE1.get(player.getName()) == "PINK"){
			        	builder.withFade(Color.FUCHSIA);
			        }
			        if(FADE1.get(player.getName()) == "DARK_GREY"){
			        	builder.withFade(Color.GRAY);
			        }
			        if(FADE1.get(player.getName()) == "DARK_GREEN"){
			        	builder.withFade(Color.GREEN);
			        }
			        if(FADE1.get(player.getName()) == "BROWN"){  
			        	builder.withFade(Color.MAROON);
			        }
			        if(FADE1.get(player.getName()) == "BLUE"){
			        	builder.withFade(Color.NAVY);
			        }
			        if(FADE1.get(player.getName()) == "GOLD"){
			        	builder.withFade(Color.ORANGE);
			        }
			        if(FADE1.get(player.getName()) == "PURPLE"){
			        	builder.withFade(Color.PURPLE);
			        }
			        if(FADE1.get(player.getName()) == "DARK_RED"){
			        	builder.withFade(Color.RED);
			        }
			        if(FADE1.get(player.getName()) == "GREY"){
			        	builder.withFade(Color.SILVER);
			        }
			        if(FADE1.get(player.getName()) == "CYAN"){
			        	builder.withFade(Color.TEAL);
			        }
			        if(FADE1.get(player.getName()) == "WHITE"){
			        	builder.withFade(Color.WHITE);
			        }
			        if(FADE1.get(player.getName()) == "YELLOW"){
			        	builder.withFade(Color.YELLOW);
			        }
			        // ADD FADE 2
			        if(FADE2.get(player.getName()) == "LIGHT_BLUE"){
			        	builder.withFade(Color.AQUA);
			        }
			        if(FADE2.get(player.getName()) == "GREEN"){
			        	builder.withFade(Color.LIME);
			        }
			        if(FADE2.get(player.getName()) == "BLACK"){
			        	builder.withFade(Color.BLACK);
			        }
			        if(FADE2.get(player.getName()) == "DARK_BLUE"){
			        	builder.withFade(Color.BLUE);
			        }
			        if(FADE2.get(player.getName()) == "PINK"){
			        	builder.withFade(Color.FUCHSIA);
			        }
			        if(FADE2.get(player.getName()) == "DARK_GREY"){
			        	builder.withFade(Color.GRAY);
			        }
			        if(FADE2.get(player.getName()) == "DARK_GREEN"){
			        	builder.withFade(Color.GREEN);
			        }
			        if(FADE2.get(player.getName()) == "BROWN"){  
			        	builder.withFade(Color.MAROON);
			        }
			        if(FADE2.get(player.getName()) == "BLUE"){
			        	builder.withFade(Color.NAVY);
			        }
			        if(FADE2.get(player.getName()) == "GOLD"){
			        	builder.withFade(Color.ORANGE);
			        }
			        if(FADE2.get(player.getName()) == "PURPLE"){
			        	builder.withFade(Color.PURPLE);
			        }
			        if(FADE2.get(player.getName()) == "DARK_RED"){
			        	builder.withFade(Color.RED);
			        }
			        if(FADE2.get(player.getName()) == "GREY"){
			        	builder.withFade(Color.SILVER);
			        }
			        if(FADE2.get(player.getName()) == "CYAN"){
			        	builder.withFade(Color.TEAL);
			        }
			        if(FADE2.get(player.getName()) == "WHITE"){
			        	builder.withFade(Color.WHITE);
			        }
			        if(FADE2.get(player.getName()) == "YELLOW"){
			        	builder.withFade(Color.YELLOW);
			        }
			        // COLOR 1
			        if(COLOR1.get(player.getName()) == "LIGHT_BLUE"){
			        	builder.withColor(Color.AQUA);
			        }
			        if(COLOR1.get(player.getName()) == "GREEN"){
			        	builder.withColor(Color.LIME);
			        }
			        if(COLOR1.get(player.getName()) == "BLACK"){
			        	builder.withColor(Color.BLACK);
			        }
			        if(COLOR1.get(player.getName()) == "DARK_BLUE"){
			        	builder.withColor(Color.BLUE);
			        }
			        if(COLOR1.get(player.getName()) == "PINK"){
			        	builder.withColor(Color.FUCHSIA);
			        }
			        if(COLOR1.get(player.getName()) == "DARK_GREY"){
			        	builder.withColor(Color.GRAY);
			        }
			        if(COLOR1.get(player.getName()) == "DARK_GREEN"){
			        	builder.withColor(Color.GREEN);
			        }
			        if(COLOR1.get(player.getName()) == "BROWN"){  
			        	builder.withColor(Color.MAROON);
			        }
			        if(COLOR1.get(player.getName()) == "BLUE"){
			        	builder.withColor(Color.NAVY);
			        }
			        if(COLOR1.get(player.getName()) == "GOLD"){
			        	builder.withColor(Color.ORANGE);
			        }
			        if(COLOR1.get(player.getName()) == "PURPLE"){
			        	builder.withColor(Color.PURPLE);
			        }
			        if(COLOR1.get(player.getName()) == "DARK_RED"){
			        	builder.withColor(Color.RED);
			        }
			        if(COLOR1.get(player.getName()) == "GREY"){
			        	builder.withColor(Color.SILVER);
			        }
			        if(COLOR1.get(player.getName()) == "CYAN"){
			        	builder.withColor(Color.TEAL);
			        }
			        if(COLOR1.get(player.getName()) == "WHITE"){
			        	builder.withColor(Color.WHITE);
			        }
			        if(COLOR1.get(player.getName()) == "YELLOW"){
			        	builder.withColor(Color.YELLOW);
			        }
			        // COLOR 2
			        if(COLOR2.get(player.getName()) == "LIGHT_BLUE"){
			        	builder.withColor(Color.AQUA);
			        }
			        if(COLOR2.get(player.getName()) == "GREEN"){
			        	builder.withColor(Color.LIME);
			        }
			        if(COLOR2.get(player.getName()) == "BLACK"){
			        	builder.withColor(Color.BLACK);
			        }
			        if(COLOR2.get(player.getName()) == "DARK_BLUE"){
			        	builder.withColor(Color.BLUE);
			        }
			        if(COLOR2.get(player.getName()) == "PINK"){
			        	builder.withColor(Color.FUCHSIA);
			        }
			        if(COLOR2.get(player.getName()) == "DARK_GREY"){
			        	builder.withColor(Color.GRAY);
			        }
			        if(COLOR2.get(player.getName()) == "DARK_GREEN"){
			        	builder.withColor(Color.GREEN);
			        }
			        if(COLOR2.get(player.getName()) == "BROWN"){  
			        	builder.withColor(Color.MAROON);
			        }
			        if(COLOR2.get(player.getName()) == "BLUE"){
			        	builder.withColor(Color.NAVY);
			        }
			        if(COLOR2.get(player.getName()) == "GOLD"){
			        	builder.withColor(Color.ORANGE);
			        }
			        if(COLOR2.get(player.getName()) == "PURPLE"){
			        	builder.withColor(Color.PURPLE);
			        }
			        if(COLOR2.get(player.getName()) == "DARK_RED"){
			        	builder.withColor(Color.RED);
			        }
			        if(COLOR2.get(player.getName()) == "GREY"){
			        	builder.withColor(Color.SILVER);
			        }
			        if(COLOR2.get(player.getName()) == "CYAN"){
			        	builder.withColor(Color.TEAL);
			        }
			        if(COLOR2.get(player.getName()) == "WHITE"){
			        	builder.withColor(Color.WHITE);
			        }
			        if(COLOR2.get(player.getName()) == "YELLOW"){
			        	builder.withColor(Color.YELLOW);
			        }
			        // ADD TYPE
			        if(TYPE.get(player.getName()) == "SMALL"){
			        	builder.with(FireworkEffect.Type.BALL);
			        }
			        if(TYPE.get(player.getName()) == "LARGE"){
			        	builder.with(FireworkEffect.Type.BALL_LARGE);
			        }
			        if(TYPE.get(player.getName()) == "SPECIAL"){
			        	builder.with(FireworkEffect.Type.BURST);
			        }
			        if(TYPE.get(player.getName()) == "CREEPER"){
			        	builder.with(FireworkEffect.Type.CREEPER);
			        }
			        if(TYPE.get(player.getName()) == "STAR"){
			        	builder.with(FireworkEffect.Type.STAR);
			        }
			        
			        fwmeta.addEffects(builder.build());
			        fw.setFireworkMeta(fwmeta);
					
					lastUsage.put(player.getName(), System.currentTimeMillis());
					}
					else{
						int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000));
						player.sendMessage(TAG + " §6Wait " + timeLeft + " more seconds before using this command.");
					}
				}
				else if(a.length == 2){
				 	if(a[1].equalsIgnoreCase("help")){
				 		player.sendMessage(TAG + " §7Firework setup Help:");
				 		player.sendMessage(TAG + " §6/fw setup");
				 		player.sendMessage(TAG + " §6false | true §7(Enable/Disable Trail)");
				 		player.sendMessage(TAG + " §6false | true §7(Enable/Disable Flicker)");
				 		player.sendMessage(TAG + " §6<color> §7(Set First Fade Color)");
						player.sendMessage(TAG + " §6<color> | false §7(Set Second Fade Color)");
						player.sendMessage(TAG + " §6<color> §7(Set First Color)");
						player.sendMessage(TAG + " §6<color> | false §7(Set Second Color)");
						player.sendMessage(TAG + " §6<type> §7(Set FireWork Type)");
						player.sendMessage(TAG + " §7Available Colors:");
						player.sendMessage(TAG + " §agreen§7, §blightblue§7, §fbrown§7, §dpink§7, §eyellow§7, §fwhite§7, §0black§7, §1darkblue§7, §3cyan§7, §cred§7, §5purple§7, §6gold§7, §7grey§7, §8darkgrey§7, §9blue");
						player.sendMessage(TAG + " §7(Use §6disable§7 to disable the Second Color/Fade)");
						player.sendMessage(TAG + " §7Available Types:");
						player.sendMessage(TAG + " §3small§7, §8large§7, §5special§7, §acreeper§7, §6star");
						player.sendMessage(TAG + " §7Example:");
						player.sendMessage(TAG + " §6/fw setup false true red false green darkblue creeper");
				 	}
				 	else{
				 		player.sendMessage(TAG + " §cIncorrect Use!");
						player.sendMessage(TAG + " §6Type /fw setup help for Help");
				 	}
				}
				else{
					player.sendMessage(TAG + " §cIncorrect Use!");
					player.sendMessage(TAG + " §6Type /fw setup help for Help");
				}
				}
				else{
					player.sendMessage(TAG + " §7Buy VIP to get access to the FireWorks! §6/donate");
				}
			}
			else if(a[0].equalsIgnoreCase("random")){
				
				if(player.hasPermission("FireWorks.Random")){
				
				long lastUsed = 0;
				if(lastUsage.containsKey(player.getName())){
					lastUsed = lastUsage.get(player.getName());
				}
				int cdmillis = cdtime * 1000;
				
				if(System.currentTimeMillis()-lastUsed>=cdmillis){
				
				player.sendMessage(TAG + " §7Generating Random Firework...");
				
		        Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
		        FireworkMeta fwmeta = fw.getFireworkMeta();
		        FireworkEffect.Builder builder = FireworkEffect.builder();
		        
		        // RANDOM TRAIL
		        Random Trail = new Random();
		        int TrailInt;
		        
		        for(int TrailCount = 1; TrailCount <= 1; TrailCount++){
		        	TrailInt = 1 + Trail.nextInt(2);
		        	
		        	if(TrailInt == 1){
		        		builder.withTrail();
		        		player.sendMessage(TAG + " §7Trail §aenabled§7.");
		        	}
		        	else if(TrailInt == 2){
		        		player.sendMessage(TAG + " §7Trail §cdisabled§7.");
		        	}
		        }
		        
		        // RANDOM FLICKER
		        Random Flicker = new Random();
		        int FlickerInt;
		        
		        for(int FlickerCount = 1; FlickerCount <= 1; FlickerCount++){
		        	FlickerInt = 1 + Flicker.nextInt(2);
		        	
		        	if(FlickerInt == 1){
		        		builder.withFlicker();
		        		player.sendMessage(TAG + " §7Flicker §aenabled§7.");
		        	}
		        	else if(FlickerInt == 2){
		        		player.sendMessage(TAG + " §7Flicker §cdisabled§7.");
		        	}
		        }
		        
		        // RANDOM FADE 1
		        Random Fade1 = new Random();
		        int Fade1Int;
		        
		        for(int Fade1Count = 1; Fade1Count <= 1; Fade1Count++){
		        	Fade1Int = 1 + Fade1.nextInt(16);
		        	
		        	if(Fade1Int == 1){
		        		builder.withFade(Color.AQUA);
		        		player.sendMessage(TAG + " §7Fade 1: §blightblue§7.");
		        	}
		        	else if(Fade1Int == 2){
		        		builder.withFade(Color.BLACK);
		        		player.sendMessage(TAG + " §7Fade 1: §0black§7.");
		        	}
		        	else if(Fade1Int == 3){
		        		builder.withFade(Color.BLUE);
		        		player.sendMessage(TAG + " §7Fade 1: §1darkblue§7.");
		        	}
		        	else if(Fade1Int == 4){
		        		builder.withFade(Color.FUCHSIA);
		        		player.sendMessage(TAG + " §7Fade 1: §dpink§7.");
		        	}
		        	else if(Fade1Int == 5){
		        		builder.withFade(Color.GRAY);
		        		player.sendMessage(TAG + " §7Fade 1: §8darkgrey§7.");
		        	}
		        	else if(Fade1Int == 6){
		        		builder.withFade(Color.GREEN);
		        		player.sendMessage(TAG + " §7Fade 1: §2darkgreen§7.");
		        	}
		        	else if(Fade1Int == 7){
		        		builder.withFade(Color.LIME);
		        		player.sendMessage(TAG + " §7Fade 1: §agreen§7.");
		        	}
		        	else if(Fade1Int == 8){
		        		builder.withFade(Color.MAROON);
		        		player.sendMessage(TAG + " §7Fade 1: §fbrown§7.");
		        	}
		        	else if(Fade1Int == 9){
		        		builder.withFade(Color.NAVY);
		        		player.sendMessage(TAG + " §7Fade 1: §9blue§7.");
		        	}
		        	else if(Fade1Int == 10){
		        		builder.withFade(Color.ORANGE);
		        		player.sendMessage(TAG + " §7Fade 1: §6gold§7.");
		        	}
		        	else if(Fade1Int == 11){
		        		builder.withFade(Color.PURPLE);
		        		player.sendMessage(TAG + " §7Fade 1: §5purple§7.");
		        	}
		        	else if(Fade1Int == 12){
		        		builder.withFade(Color.RED);
		        		player.sendMessage(TAG + " §7Fade 1: §cred§7.");
		        	}
		        	else if(Fade1Int == 13){
		        		builder.withFade(Color.SILVER);
		        		player.sendMessage(TAG + " §7Fade 1: §7grey§7.");
		        	}
		        	else if(Fade1Int == 14){
		        		builder.withFade(Color.TEAL);
		        		player.sendMessage(TAG + " §7Fade 1: §3cyan§7.");
		        	}
		        	else if(Fade1Int == 15){
		        		builder.withFade(Color.WHITE);
		        		player.sendMessage(TAG + " §7Fade 1: §fwhite§7.");
		        	}
		        	else if(Fade1Int == 16){
		        		builder.withFade(Color.YELLOW);
		        		player.sendMessage(TAG + " §7Fade 1: §eyellow§7.");
		        	}
		        }
		        
		        // RANDOM FADE 2
		        Random Fade2 = new Random();
		        int Fade2Int;
		        
		        for(int Fade2Count = 1; Fade2Count <= 1; Fade2Count++){
		        	Fade2Int = 1 + Fade2.nextInt(17);
		        	
		        	if(Fade2Int == 1){
		        		builder.withFade(Color.AQUA);
		        		player.sendMessage(TAG + " §7Fade 2: §blightblue§7.");
		        	}
		        	else if(Fade2Int == 2){
		        		builder.withFade(Color.BLACK);
		        		player.sendMessage(TAG + " §7Fade 2: §0black§7.");
		        	}
		        	else if(Fade2Int == 3){
		        		builder.withFade(Color.BLUE);
		        		player.sendMessage(TAG + " §7Fade 2: §1darkblue§7.");
		        	}
		        	else if(Fade2Int == 4){
		        		builder.withFade(Color.FUCHSIA);
		        		player.sendMessage(TAG + " §7Fade 2: §dpink§7.");
		        	}
		        	else if(Fade2Int == 5){
		        		builder.withFade(Color.GRAY);
		        		player.sendMessage(TAG + " §7Fade 2: §8darkgrey§7.");
		        	}
		        	else if(Fade2Int == 6){
		        		builder.withFade(Color.GREEN);
		        		player.sendMessage(TAG + " §7Fade 2: §2darkgreen§7.");
		        	}
		        	else if(Fade2Int == 7){
		        		builder.withFade(Color.LIME);
		        		player.sendMessage(TAG + " §7Fade 2: §agreen§7.");
		        	}
		        	else if(Fade2Int == 8){
		        		builder.withFade(Color.MAROON);
		        		player.sendMessage(TAG + " §7Fade 2: §fbrown§7.");
		        	}
		        	else if(Fade2Int == 9){
		        		builder.withFade(Color.NAVY);
		        		player.sendMessage(TAG + " §7Fade 2: §9blue§7.");
		        	}
		        	else if(Fade2Int == 10){
		        		builder.withFade(Color.ORANGE);
		        		player.sendMessage(TAG + " §7Fade 2: §6gold§7.");
		        	}
		        	else if(Fade2Int == 11){
		        		builder.withFade(Color.PURPLE);
		        		player.sendMessage(TAG + " §7Fade 2: §5purple§7.");
		        	}
		        	else if(Fade2Int == 12){
		        		builder.withFade(Color.RED);
		        		player.sendMessage(TAG + " §7Fade 2: §cred§7.");
		        	}
		        	else if(Fade2Int == 13){
		        		builder.withFade(Color.SILVER);
		        		player.sendMessage(TAG + " §7Fade 2: §7grey§7.");
		        	}
		        	else if(Fade2Int == 14){
		        		builder.withFade(Color.TEAL);
		        		player.sendMessage(TAG + " §7Fade 2: §3cyan§7.");
		        	}
		        	else if(Fade2Int == 15){
		        		builder.withFade(Color.WHITE);
		        		player.sendMessage(TAG + " §7Fade 2: §fwhite§7.");
		        	}
		        	else if(Fade2Int == 16){
		        		builder.withFade(Color.YELLOW);
		        		player.sendMessage(TAG + " §7Fade 2: §eyellow§7.");
		        	}
		        	else if(Fade2Int == 17){
		        		player.sendMessage(TAG + " §7Fade 2: §cdisabled§7.");
		        	}
		        }
		        
		        // RANDOM COLOR 1
		        Random Color1 = new Random();
		        int Color1Int;
		        
		        for(int Color1Count = 1; Color1Count <= 1; Color1Count++){
		        	Color1Int = 1 + Color1.nextInt(16);
		        	
		        	if(Color1Int == 1){
		        		builder.withColor(Color.AQUA);
		        		player.sendMessage(TAG + " §7Color 1: §blightblue§7.");
		        	}
		        	else if(Color1Int == 2){
		        		builder.withColor(Color.BLACK);
		        		player.sendMessage(TAG + " §7Color 1: §0black§7.");
		        	}
		        	else if(Color1Int == 3){
		        		builder.withColor(Color.BLUE);
		        		player.sendMessage(TAG + " §7Color 1: §1darkblue§7.");
		        	}
		        	else if(Color1Int == 4){
		        		builder.withColor(Color.FUCHSIA);
		        		player.sendMessage(TAG + " §7Color 1: §dpink§7.");
		        	}
		        	else if(Color1Int == 5){
		        		builder.withColor(Color.GRAY);
		        		player.sendMessage(TAG + " §7Color 1: §8darkgrey§7.");
		        	}
		        	else if(Color1Int == 6){
		        		builder.withColor(Color.GREEN);
		        		player.sendMessage(TAG + " §7Color 1: §2darkgreen§7.");
		        	}
		        	else if(Color1Int == 7){
		        		builder.withColor(Color.LIME);
		        		player.sendMessage(TAG + " §7Color 1: §agreen§7.");
		        	}
		        	else if(Color1Int == 8){
		        		builder.withColor(Color.MAROON);
		        		player.sendMessage(TAG + " §7Color 1: §fbrown§7.");
		        	}
		        	else if(Color1Int == 9){
		        		builder.withColor(Color.NAVY);
		        		player.sendMessage(TAG + " §7Color 1: §9blue§7.");
		        	}
		        	else if(Color1Int == 10){
		        		builder.withColor(Color.ORANGE);
		        		player.sendMessage(TAG + " §7Color 1: §6gold§7.");
		        	}
		        	else if(Color1Int == 11){
		        		builder.withColor(Color.PURPLE);
		        		player.sendMessage(TAG + " §7Color 1: §5purple§7.");
		        	}
		        	else if(Color1Int == 12){
		        		builder.withColor(Color.RED);
		        		player.sendMessage(TAG + " §7Color 1: §cred§7.");
		        	}
		        	else if(Color1Int == 13){
		        		builder.withColor(Color.SILVER);
		        		player.sendMessage(TAG + " §7Color 1: §7grey§7.");
		        	}
		        	else if(Color1Int == 14){
		        		builder.withColor(Color.TEAL);
		        		player.sendMessage(TAG + " §7Color 1: §3cyan§7.");
		        	}
		        	else if(Color1Int == 15){
		        		builder.withColor(Color.WHITE);
		        		player.sendMessage(TAG + " §7Color 1: §fwhite§7.");
		        	}
		        	else if(Color1Int == 16){
		        		builder.withColor(Color.YELLOW);
		        		player.sendMessage(TAG + " §7Color 1: §eyellow§7.");
		        	}
		        }
		        
		     // RANDOM FADE 2
		        Random Color2 = new Random();
		        int Color2Int;
		        
		        for(int Color2Count = 1; Color2Count <= 1; Color2Count++){
		        	Color2Int = 1 + Color2.nextInt(17);
		        	
		        	if(Color2Int == 1){
		        		builder.withColor(Color.AQUA);
		        		player.sendMessage(TAG + " §7Color 2: §blightblue§7.");
		        	}
		        	else if(Color2Int == 2){
		        		builder.withColor(Color.BLACK);
		        		player.sendMessage(TAG + " §7Color 2: §0black§7.");
		        	}
		        	else if(Color2Int == 3){
		        		builder.withColor(Color.BLUE);
		        		player.sendMessage(TAG + " §7Color 2: §1darkblue§7.");
		        	}
		        	else if(Color2Int == 4){
		        		builder.withColor(Color.FUCHSIA);
		        		player.sendMessage(TAG + " §7Color 2: §dpink§7.");
		        	}
		        	else if(Color2Int == 5){
		        		builder.withColor(Color.GRAY);
		        		player.sendMessage(TAG + " §7Color 2: §8darkgrey§7.");
		        	}
		        	else if(Color2Int == 6){
		        		builder.withColor(Color.GREEN);
		        		player.sendMessage(TAG + " §7Color 2: §2darkgreen§7.");
		        	}
		        	else if(Color2Int == 7){
		        		builder.withColor(Color.LIME);
		        		player.sendMessage(TAG + " §7Color 2: §agreen§7.");
		        	}
		        	else if(Color2Int == 8){
		        		builder.withColor(Color.MAROON);
		        		player.sendMessage(TAG + " §7Color 2: §fbrown§7.");
		        	}
		        	else if(Color2Int == 9){
		        		builder.withColor(Color.NAVY);
		        		player.sendMessage(TAG + " §7Color 2: §9blue§7.");
		        	}
		        	else if(Color2Int == 10){
		        		builder.withColor(Color.ORANGE);
		        		player.sendMessage(TAG + " §7Color 2: §6gold§7.");
		        	}
		        	else if(Color2Int == 11){
		        		builder.withColor(Color.PURPLE);
		        		player.sendMessage(TAG + " §7Color 2: §5purple§7.");
		        	}
		        	else if(Color2Int == 12){
		        		builder.withColor(Color.RED);
		        		player.sendMessage(TAG + " §7Color 2: §cred§7.");
		        	}
		        	else if(Color2Int == 13){
		        		builder.withColor(Color.SILVER);
		        		player.sendMessage(TAG + " §7Color 2: §7grey§7.");
		        	}
		        	else if(Color2Int == 14){
		        		builder.withColor(Color.TEAL);
		        		player.sendMessage(TAG + " §7Color 2: §3cyan§7.");
		        	}
		        	else if(Color2Int == 15){
		        		builder.withColor(Color.WHITE);
		        		player.sendMessage(TAG + " §7Color 2: §fwhite§7.");
		        	}
		        	else if(Color2Int == 16){
		        		builder.withColor(Color.YELLOW);
		        		player.sendMessage(TAG + " §7Color 2: §eyellow§7.");
		        	}
		        	else if(Color2Int == 17){
		        		player.sendMessage(TAG + " §7Color 2: §cdisabled§7.");
		        	}
		        }
		        
		        // RANDOM TYPE
		        Random Type = new Random();
		        int Type2Int;
		        
		        for(int TypeCount = 1; TypeCount <= 1; TypeCount++){
		        	Type2Int = 1 + Type.nextInt(5);
		        	
		        	if(Type2Int == 1){
		        		builder.with(FireworkEffect.Type.BALL);
		        		player.sendMessage(TAG + " §7Type: §3small§7.");
		        	}
		        	else if(Type2Int == 2){
		        		builder.with(FireworkEffect.Type.BALL_LARGE);
		        		player.sendMessage(TAG + " §7Type: §8large§7.");
		        	}
		        	else if(Type2Int == 3){
		        		builder.with(FireworkEffect.Type.BURST);
		        		player.sendMessage(TAG + " §7Type: §5special§7.");
		        	}
		        	else if(Type2Int == 4){
		        		builder.with(FireworkEffect.Type.CREEPER);
		        		player.sendMessage(TAG + " §7Type: §acreeper§7.");
		        	}
		        	else if(Type2Int == 5){
		        		builder.with(FireworkEffect.Type.STAR);
		        		player.sendMessage(TAG + " §7Type: §6star§7.");
		        	}
		        } 

		        fwmeta.addEffects(builder.build());
		        fw.setFireworkMeta(fwmeta);
		        
				lastUsage.put(player.getName(), System.currentTimeMillis());
				}
				else{
					int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000));
					player.sendMessage(TAG + " §6Wait " + timeLeft + " more seconds before using this command.");
				}
				}
				else{
					player.sendMessage(TAG + " §7Buy VIP to get access to the FireWorks! §6/donate");
				}
			}
			else{
				player.sendMessage(TAG + " §cIncorrect Use!");
				player.sendMessage(TAG + " §6Type /fw help for help!");
			}
		}
		else{
			sender.sendMessage(TAG + " §4You can't perform commands through the console!");
		}
		return false;
	}
}
		

