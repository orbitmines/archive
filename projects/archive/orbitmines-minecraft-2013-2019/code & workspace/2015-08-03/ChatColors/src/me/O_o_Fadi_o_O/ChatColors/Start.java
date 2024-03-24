package me.O_o_Fadi_o_O.ChatColors;

import java.io.File;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	HashMap<String, String> GREEN = new HashMap<>();
	HashMap<String, String> LIGHT_BLUE = new HashMap<>();
	HashMap<String, String> RED = new HashMap<>();
	HashMap<String, String> PINK = new HashMap<>();
	HashMap<String, String> YELLOW = new HashMap<>();
	HashMap<String, String> WHITE = new HashMap<>();
	HashMap<String, String> BLACK = new HashMap<>();
	HashMap<String, String> DARK_BLUE = new HashMap<>();
	HashMap<String, String> DARK_GREEN = new HashMap<>();
	HashMap<String, String> CYAN = new HashMap<>();
	HashMap<String, String> DARK_RED = new HashMap<>();
	HashMap<String, String> PURPLE = new HashMap<>();
	HashMap<String, String> GOLD = new HashMap<>();
	HashMap<String, String> GREY = new HashMap<>();
	HashMap<String, String> DARK_GREY = new HashMap<>();
	HashMap<String, String> BLUE = new HashMap<>();
	
	public String TAG = "§8[§2§lChatColors§8]";
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(!getConfig().contains(p.getName())){
			getConfig().set("players." + p.getName(), "§7");
			saveConfig();
		}
		if(p.hasPermission("Hub.Fly")){
			p.setAllowFlight(true);
			p.setFlying(true);
		}
	}
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
			
			if(p.hasPermission("ChatColors.ColorInChat")){
				String s = e.getMessage();
				e.setMessage(getConfig().getString("players." + p.getName()) + s);
			}
			else{
				String s = e.getMessage().replaceAll("§", "*");
				e.setMessage(getConfig().getString("players." + p.getName()) + s);
			}
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
				if(cmd.getName().equalsIgnoreCase("chatcolor")){
					
					if((sender instanceof Player)){
						Player player = (Player)sender;
						
							if(a.length == 0){
								if(player.hasPermission("ChatColor.ColorList")){
								
								GREEN(player);
								LIGHT_BLUE(player);
								RED(player);
								PINK(player);
								YELLOW(player);
								WHITE(player);
								BLACK(player);
								DARK_BLUE(player);
								DARK_GREEN(player);
								CYAN(player);
								DARK_RED(player);
								PURPLE(player);
								GOLD(player);
								GREY(player);
								DARK_GREY(player);
								BLUE(player);
								
								player.sendMessage(TAG + " §7Available Colors:");
								player.sendMessage(TAG + " " 
										+ GREEN.get(player.getName()) 
										+ LIGHT_BLUE.get(player.getName())
										+ RED.get(player.getName())
										+ PINK.get(player.getName())
										+ YELLOW.get(player.getName())
										+ WHITE.get(player.getName())
										+ BLACK.get(player.getName())
										+ DARK_BLUE.get(player.getName())
										+ DARK_GREEN.get(player.getName())
										+ CYAN.get(player.getName())
										+ DARK_RED.get(player.getName())
										+ PURPLE.get(player.getName())
										+ GOLD.get(player.getName())
										+ GREY.get(player.getName())
										+ DARK_GREY.get(player.getName())
										+ BLUE.get(player.getName()));
							}
							else{
								player.sendMessage(TAG + " §cBuy VIP to get access to ChatColors! §2/donate");
							}
							}
							else if(a[0].equalsIgnoreCase("help")){
								player.sendMessage(TAG + " §2ChatColors v1.2.1 §7by §2O_o_Fadi_o_O");
								player.sendMessage(TAG + " §7All Commands:");
								player.sendMessage(TAG + " §2/chatcolor §7(Shows Available Colors)");
								player.sendMessage(TAG + " §2/chatcolor help §7(Shows this Menu");
								player.sendMessage(TAG + " §2/chatcolor setcolor §7(Set your ChatColor)");
							}
							else if(a[0].equalsIgnoreCase("setcolor")){
								if(player.hasPermission("ChatColor.SetColor")){
									
									if(a.length == 2){
										if(a[1].equalsIgnoreCase("green")){
											if(player.hasPermission("ChatColor.GREEN")){
											getConfig().set("players." + player.getName(), "§a");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §agreen");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§agreen§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("lightblue")){
											if(player.hasPermission("ChatColor.LIGHT_BLUE")){
											getConfig().set("players." + player.getName(), "§b");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §blightblue");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§blightblue§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("red")){
											if(player.hasPermission("ChatColor.RED")){
											getConfig().set("players." + player.getName(), "§c");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §cred");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§cred§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("pink")){
											if(player.hasPermission("ChatColor.PINK")){
											getConfig().set("players." + player.getName(), "§d");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §dpink");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§dpink§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("yellow")){
											if(player.hasPermission("ChatColor.YELLOW")){
											getConfig().set("players." + player.getName(), "§e");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §eyellow");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§eyellow§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("white")){
											if(player.hasPermission("ChatColor.WHITE")){
											getConfig().set("players." + player.getName(), "§f");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §fwhite");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§fwhite§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("black")){
											if(player.hasPermission("ChatColor.BLACK")){
											getConfig().set("players." + player.getName(), "§0");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §0black");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§0black§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("darkblue")){
											if(player.hasPermission("ChatColor.DARK_BLUE")){
											getConfig().set("players." + player.getName(), "§1");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §1darkblue");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§1darkblue§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("darkgreen")){
											if(player.hasPermission("ChatColor.DARK_GREEN")){
											getConfig().set("players." + player.getName(), "§2");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §2darkgreen");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§2darkgreen§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("cyan")){
											if(player.hasPermission("ChatColor.CYAN")){
											getConfig().set("players." + player.getName(), "§3");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §3cyan");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§3cyan§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("darkred")){
											if(player.hasPermission("ChatColor.DARK_RED")){
											getConfig().set("players." + player.getName(), "§4");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §4darkred");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§4darkred§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("purple")){
											if(player.hasPermission("ChatColor.PURPLE")){
											getConfig().set("players." + player.getName(), "§5");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §5purple");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§5purple§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("gold")){
											if(player.hasPermission("ChatColor.GOLD")){
											getConfig().set("players." + player.getName(), "§6");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §6gold");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§6gold§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("grey")){
											if(player.hasPermission("ChatColor.GREY")){
											getConfig().set("players." + player.getName(), "§7");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §7grey");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§7grey§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("darkgrey")){
											if(player.hasPermission("ChatColor.DARK_GREY")){
											getConfig().set("players." + player.getName(), "§8");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §8darkgrey");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§8darkgrey§c)");
											}
										}
										else if(a[1].equalsIgnoreCase("blue")){
											if(player.hasPermission("ChatColor.BLUE")){
											getConfig().set("players." + player.getName(), "§9");
											saveConfig();
											player.sendMessage(TAG + " §7Your ChatColor is set to: §9blue");
											}
											else{
												player.sendMessage(TAG + " §cChatColor Access Denied! (§9blue§c)");
											}
										}
										else{
											player.sendMessage(TAG + " §7'§2" + a[1] + "§7' §cIs not a valid Color.");
										}
									}
									else if(a[0].equalsIgnoreCase("default")){
										getConfig().set("players." + player.getName(), "§7");
										saveConfig();
									}
									else{
										player.sendMessage(TAG + " §cIncorrect Use!");
										player.sendMessage(TAG + " §2/chatcolor setcolor <color>");
									}
								}
								else{
									player.sendMessage(TAG + " §cBuy VIP to get access to ChatColors! §2/donate");
								}
							}
							else{
								player.sendMessage(TAG + " §cIncorrect Use!");
								player.sendMessage(TAG + " §cHelp: §2/chatcolor help");
							}
					}
					else{
						sender.sendMessage(TAG + " §2You can't perform commands through the console!");
					}
				}
		return true;
	}
	public void GREEN(Player player){
		if(player.hasPermission("ChatColor.GREEN")){
			GREEN.put(player.getName(), "§agreen§7, ");
		}
		else{
			GREEN.put(player.getName(), "");
		}	
	}
	public void LIGHT_BLUE(Player player){
		if(player.hasPermission("ChatColor.LIGHT_BLUE")){
			LIGHT_BLUE.put(player.getName(), "§blightblue§7, ");
		}
		else{
			LIGHT_BLUE.put(player.getName(), "");
		}	
	}
	public void RED(Player player){
		if(player.hasPermission("ChatColor.RED")){
			RED.put(player.getName(), "§cred§7, ");
		}
		else{
			RED.put(player.getName(), "");
		}	
	}
	public void PINK(Player player){
		if(player.hasPermission("ChatColor.PINK")){
			PINK.put(player.getName(), "§dpink§7, ");
		}
		else{
			PINK.put(player.getName(), "");
		}	
	}
	public void YELLOW(Player player){
		if(player.hasPermission("ChatColor.YELLOW")){
			YELLOW.put(player.getName(), "§eyellow§7, ");
		}
		else{
			RED.put(player.getName(), "");
		}	
	}
	public void WHITE(Player player){
		if(player.hasPermission("ChatColor.WHITE")){
			WHITE.put(player.getName(), "§fwhite§7, ");
		}
		else{
			WHITE.put(player.getName(), "");
		}	
	}
	public void BLACK(Player player){
		if(player.hasPermission("ChatColor.BLACK")){
			BLACK.put(player.getName(), "§0black§7, ");
		}
		else{
			BLACK.put(player.getName(), "");
		}	
	}
	public void DARK_BLUE(Player player){
		if(player.hasPermission("ChatColor.DARK_BLUE")){
			DARK_BLUE.put(player.getName(), "§1darkblue§7, ");
		}
		else{
			DARK_BLUE.put(player.getName(), "");
		}	
	}
	public void DARK_GREEN(Player player){
		if(player.hasPermission("ChatColor.DARK_GREEN")){
			DARK_GREEN.put(player.getName(), "§2darkgreen§7, ");
		}
		else{
			DARK_GREEN.put(player.getName(), "");
		}	
	}
	public void CYAN(Player player){
		if(player.hasPermission("ChatColor.CYAN")){
			CYAN.put(player.getName(), "§3cyan§7, ");
		}
		else{
			CYAN.put(player.getName(), "");
		}	
	}
	public void DARK_RED(Player player){
		if(player.hasPermission("ChatColor.DARK_RED")){
			DARK_RED.put(player.getName(), "§4darkred§7, ");
		}
		else{
			DARK_RED.put(player.getName(), "");
		}	
	}
	public void PURPLE(Player player){
		if(player.hasPermission("ChatColor.PURPLE")){
			PURPLE.put(player.getName(), "§5purple§7, ");
		}
		else{
			PURPLE.put(player.getName(), "");
		}	
	}
	public void GOLD(Player player){
		if(player.hasPermission("ChatColor.GOLD")){
			GOLD.put(player.getName(), "§6gold§7, ");
		}
		else{
			GOLD.put(player.getName(), "");
		}	
	}
	public void GREY(Player player){
		if(player.hasPermission("ChatColor.GREY")){
			GREY.put(player.getName(), "§7grey§7, ");
		}
		else{
			GREY.put(player.getName(), "");
		}	
	}
	public void DARK_GREY(Player player){
		if(player.hasPermission("ChatColor.DARK_GREY")){
			DARK_GREY.put(player.getName(), "§8darkgrey§7, ");
		}
		else{
			DARK_GREY.put(player.getName(), "");
		}	
	}
	public void BLUE(Player player){
		if(player.hasPermission("ChatColor.BLUE")){
			BLUE.put(player.getName(), "§9blue§7 ");
		}
		else{
			BLUE.put(player.getName(), "");
		}	
	}
}
