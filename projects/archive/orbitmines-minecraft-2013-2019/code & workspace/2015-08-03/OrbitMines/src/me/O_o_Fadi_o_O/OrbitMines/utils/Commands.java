package me.O_o_Fadi_o_O.OrbitMines.utils;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.VoteManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Commands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String l, String[] a) {
		if(ServerData.isServer(Server.HUB) && cmd.getName().equalsIgnoreCase("setlastdonator")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				if(a.length == 0){
					sender.sendMessage("§4§lOP §8| §7Use §6/setlastdonator <player>");
				}
				else if(a.length == 1){
		    		ServerData.getHub().setLastDonatorString(a[0]);
					sender.sendMessage("§4§lOP §8| §7You set §6" + a[0] + "§7 as the last Donator§7!");
				}
				else{
					sender.sendMessage("§4§lOP §8| §7Use §6/setlastdonator <player>");
				}
			}
			else{
				OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
				omp.unknownCommand("/" + cmd.getName().toLowerCase());
			}
		}
		else if(cmd.getName().equalsIgnoreCase("setvip")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				if(a.length == 1){
					sender.sendMessage("§4§lOP §8| §7Use §6/setvip <player> <vip>");
				}
				else if(a.length == 2){			
		    		Player p2 = Utils.getPlayer(a[0]);
		    		
		    		if(p2 != null){
						try{
							VIPRank rank = VIPRank.valueOf(a[1]);
							
							OMPlayer omp = OMPlayer.getOMPlayer(p2);
							omp.setVIP(rank);
							
							sender.sendMessage("§4§lOP §8| §7You set §6" + p2.getName() + "'s§7 VIP Rank to §6" + rank.toString() + "§7!");
							
						}catch(Exception ex){
							sender.sendMessage("§4§lOP §8| §7VIP Rank §6" + a[1] + "§7 isn't a valid rank!");
						}
		    		}
		    		else{
		    			sender.sendMessage("§4§lOP §8| §7Player §6" + a[0] + "§7 isn't §aOnline§7!");
		    		}
				}
				else{
					sender.sendMessage("§4§lOP §8| §7Use §6/setvip <player> <vip>");
				}
			}
			else{
				OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
				omp.unknownCommand("/" + cmd.getName().toLowerCase());
			}
		}
		else if(cmd.getName().equalsIgnoreCase("setstaff")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				if(a.length == 1){
					sender.sendMessage("§4§lOP §8| §7Use §6/setstaff <player> <staff>");
				}
				else if(a.length == 2){			
		    		Player p2 = Utils.getPlayer(a[0]);
		    		
		    		if(p2 != null){
						try{
							StaffRank rank = StaffRank.valueOf(a[1]);
							
							OMPlayer omp = OMPlayer.getOMPlayer(p2);
							omp.setStaff(rank);
							
							sender.sendMessage("§4§lOP §8| §7You set §6" + p2.getName() + "'s§7 Staff Rank to §6" + rank.toString() + "§7!");
							
						}catch(Exception ex){
							sender.sendMessage("§4§lOP §8| §7Staff Rank §6" + a[1] + "§7 isn't a valid rank!");
						}
		    		}
		    		else{
		    			sender.sendMessage("§4§lOP §8| §7Player §6" + a[0] + "§7 isn't §aOnline§7!");
		    		}
				}
				else{
					sender.sendMessage("§4§lOP §8| §7Use §6/setstaff <player> <staff>");
				}
			}
			else{
				OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
				omp.unknownCommand("/" + cmd.getName().toLowerCase());
			}
		}
		else if(cmd.getName().equalsIgnoreCase("resetMonthlyVIPPoints")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				
				if(a.length == 1){
					Player player = Utils.getPlayer(a[0]);
					
					if(player != null){
						final OMPlayer omplayer = OMPlayer.getOMPlayer(player);
						omplayer.setReceivedMonthlyBonus(false);
						
						final Title t = new Title("", "§7You can now claim your §bMonthly VIP Points§7.");
						new BukkitRunnable(){
							public void run(){
								t.send(omplayer.getPlayer());
							}
						}.runTaskLater(Start.getInstance(), 100);
						
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
		else if(cmd.getName().equalsIgnoreCase("giveMonthlyVIPPoints")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				
				if(a.length == 1){
					Player player = Utils.getPlayer(a[0]);
					
					if(player != null){
						final OMPlayer omplayer = OMPlayer.getOMPlayer(player);
						
						if(!omplayer.hasReceivedMonthlyBonus()){
							int amount = omplayer.getVIPRank().getMonthlyBonus();
							if(amount != 0){
								omplayer.addVIPPoints(amount);
								omplayer.setReceivedMonthlyBonus(true);
							}
							sender.sendMessage("§b§lVIP Points §8| §7You gave §b" + omplayer.getName() + " §b§l" + amount + " VIP Points§7!");
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 already claimed their §bMonthly VIP Points§7!");
							
							final Title t = new Title("", "§7You already claimed your §bMonthly VIP Points§7!");
							new BukkitRunnable(){
								public void run(){
									t.send(omplayer.getPlayer());
								}
							}.runTaskLater(Start.getInstance(), 100);
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
		else if(cmd.getName().equalsIgnoreCase("votes")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				if(a.length == 0){
					if(sender instanceof Player){
						OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
						sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + omp.getVotes());
					}
				}
				else if(a.length == 2){
					if(a[0].equalsIgnoreCase("add")){
						sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7You gave §b" + a[1] + "§7 a §b§lVote§7!");
						new VoteManager().registerVote(a[1]);
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
				OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
				sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + omp.getVotes());
			}
		}
		else if(cmd.getName().equalsIgnoreCase("vippoints")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				if(a.length == 0){
					if(sender instanceof Player){
						OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
						sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + omp.getVIPPoints());
					}
				}
				else if(a.length == 3){
					if(a[0].equalsIgnoreCase("give")){
						int amount = Integer.parseInt(a[2]);
						Player player = Utils.getPlayer(a[1]);
						
						if(player != null){
							OMPlayer omplayer = OMPlayer.getOMPlayer(player);
							omplayer.addVIPPoints(amount);
							
							sender.sendMessage("§b§lVIP Points §8| §7You gave §b" + a[1] + " §b§l" + amount + " VIP Points§7!");
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[1] + " §7isn't §aOnline§7!");
						}
					}
					else if(a[0].equalsIgnoreCase("remove")){
						int amount = Integer.parseInt(a[2]);
						Player player = Utils.getPlayer(a[1]);
						
						if(player != null){
							OMPlayer omplayer = OMPlayer.getOMPlayer(player);
							omplayer.removeVIPPoints(amount);
							
							sender.sendMessage("§b§lVIP Points §8| §7You removed §b§l" + amount + " VIP Points§7 from §b" + a[1] + "§7!");
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[1] + " §7isn't §aOnline§7!");
						}
					}
					else{
						sender.sendMessage("§b§lVIP Points §8| §7/vippoints give|remove <player> <amount>");
					}
				}
				else{
					sender.sendMessage("§b§lVIP Points §8| §7/vippoints give|remove <player> <amount>");
				}
			}
			else{
				OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
				sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + omp.getVIPPoints());
			}
		}
		else if(cmd.getName().equalsIgnoreCase("omt")){
			if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
				if(a.length == 0){
					if(sender instanceof Player){
						OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
						sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + omp.getOrbitMinesTokens());
					}
				}
				else if(a.length == 3){
					if(a[0].equalsIgnoreCase("give")){
						int amount = Integer.parseInt(a[2]);
						Player player = Utils.getPlayer(a[1]);
						
						if(player != null){
							OMPlayer omplayer = OMPlayer.getOMPlayer(player);
							omplayer.addOrbitMinesTokens(amount);
							
							sender.sendMessage("§e§lOMT §8| §7You gave §e" + a[1] + " §e§l" + amount + " OMT§7!");
							
						}
						else{
							sender.sendMessage("§e§lOMT §8| §7Player §e" + a[1] + " §7isn't §aOnline§7!");
						}
					}
					else if(a[0].equalsIgnoreCase("remove")){
						int amount = Integer.parseInt(a[2]);
						Player player = Utils.getPlayer(a[1]);
						
						if(player != null){
							OMPlayer omplayer = OMPlayer.getOMPlayer(player);
							omplayer.removeOrbitMinesTokens(amount);
							
							sender.sendMessage("§e§lOMT §8| §7You removed §e§l" + amount + " OMT§7 from §e" + a[1] + "§7!");
						}
						else{
							sender.sendMessage("§e§lOMT §8| §7Player §e" + a[1] + " §7isn't §aOnline§7!");
						}
					}
					else{
						sender.sendMessage("§e§lOMT §8| §7/omt give|remove <player> <amount>");
					}
				}
				else{
					sender.sendMessage("§e§lOMT §8| §7/omt give|remove <player> <amount>");
				}
			}
			else{
				OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
				sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + omp.getOrbitMinesTokens());
			}
		}
		else if(cmd.getName().equalsIgnoreCase("money")){
			if(ServerData.isServer(Server.SURVIVAL)){
				if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
					if(a.length == 0){
						if(sender instanceof Player){
							OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
							sender.sendMessage("§7Your Money: §2§l" + omp.getSurvivalPlayer().getMoney() + "$");
						}
					}
					else if(a.length == 3){
						if(a[0].equalsIgnoreCase("give")){
							int amount = Integer.parseInt(a[2]);
							Player player = Utils.getPlayer(a[1]);
							
							if(player != null){
								SurvivalPlayer sp = OMPlayer.getOMPlayer(player).getSurvivalPlayer();
								sp.addMoney(amount);
								
								sender.sendMessage("§7You gave §2" + a[1] + " §2§l" + a[2] + "$§7!");
							}
							else{
								sender.sendMessage("§7Player §2" + a[1] + " §7isn't §aOnline§7!");
							}
						}
						else if(a[0].equalsIgnoreCase("remove")){
							int amount = Integer.parseInt(a[2]);
							Player player = Utils.getPlayer(a[1]);
							
							if(player != null){
								SurvivalPlayer sp = OMPlayer.getOMPlayer(player).getSurvivalPlayer();
								sp.removeMoney(amount);
								
								sender.sendMessage("§7You removed §2§l" + a[2] + "$§7 from §2" + a[1] + "§7!");
							}
							else{
								sender.sendMessage("§7Player §2" + a[1] + " §7isn't §aOnline§7!");
							}
							
						}
						else{
							sender.sendMessage("§7/money give|remove <player> <amount>");
						}
						
					}
					else{
						sender.sendMessage("§7/money give|remove <player> <amount>");
					}
				}
				else{
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					sender.sendMessage("§7Your Money: §2§l" + omp.getSurvivalPlayer().getMoney() + "$");
				}
			}
			else{
				if(sender instanceof Player){
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
		}
		else if(cmd.getName().equalsIgnoreCase("addhomes")){
			if(ServerData.isServer(Server.SURVIVAL)){
				if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
					if(a.length == 2){
						final int amount = Integer.parseInt(a[1]);
						final Player player = Utils.getPlayer(a[0]);
						
						if(player != null){
							SurvivalPlayer sp = OMPlayer.getOMPlayer(player).getSurvivalPlayer();
							sp.setExtraHomes(sp.getExtraHomes() + amount);
							
							sender.sendMessage("§7You gave §2" + a[0] + " §6" + a[1] + " Homes§7!");
							
							new BukkitRunnable(){
								public void run(){
									Title t = new Title("", "§6+" + amount + " Homes");
									t.send(player);
								}
							}.runTaskLater(Start.getInstance(), 40);
						}
						else{
							sender.sendMessage("§7Player §2" + a[0] + " §7isn't §aOnline§7!");
						}
					}
					else{
						sender.sendMessage("§7/addhomes <player> <amount>");
					}
				}
				else{
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
			else{
				if(sender instanceof Player){
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
		}
		else if(cmd.getName().equalsIgnoreCase("addshops")){
			if(ServerData.isServer(Server.SURVIVAL)){
				if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
					if(a.length == 2){
						final int amount = Integer.parseInt(a[1]);
						final Player player = Utils.getPlayer(a[0]);
						
						if(player != null){
							SurvivalPlayer sp = OMPlayer.getOMPlayer(player).getSurvivalPlayer();
							sp.setExtraShops(sp.getExtraShops() + amount);
							
							sender.sendMessage("§7You gave §2" + a[0] + " §6" + a[1] + " Chest Shops§7!");
							
							new BukkitRunnable(){
								public void run(){
									Title t = new Title("", "§6+" + amount + " Chest Shops");
									t.send(player);
								}
							}.runTaskLater(Start.getInstance(), 40);
						}
						else{
							sender.sendMessage("§7Player §2" + a[0] + " §7isn't §aOnline§7!");
						}
					}
					else{
						sender.sendMessage("§7/addshops <player> <amount>");
					}
				}
				else{
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
			else{
				if(sender instanceof Player){
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
		}
		else if(cmd.getName().equalsIgnoreCase("addwarps")){
			if(ServerData.isServer(Server.SURVIVAL)){
				if(sender instanceof ConsoleCommandSender || sender instanceof Player && OMPlayer.getOMPlayer((Player) sender).isOpMode()){
					if(a.length == 2){
						final int amount = Integer.parseInt(a[1]);
						final Player player = Utils.getPlayer(a[0]);
						
						if(player != null){
							SurvivalPlayer sp = OMPlayer.getOMPlayer(player).getSurvivalPlayer();
							sp.setExtraWarps(sp.getExtraWarps() + amount);
							
							sender.sendMessage("§7You gave §2" + a[0] + " §3" + a[1] + " Warp§7!");
							
							new BukkitRunnable(){
								public void run(){
									Title t = new Title("", "§3+" + amount + " Warp");
									t.send(player);
								}
							}.runTaskLater(Start.getInstance(), 40);
						}
						else{
							sender.sendMessage("§7Player §2" + a[0] + " §7isn't §aOnline§7!");
						}
					}
					else{
						sender.sendMessage("§7/addwarps <player> <amount>");
					}
				}
				else{
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
			else{
				if(sender instanceof Player){
					OMPlayer omp = OMPlayer.getOMPlayer((Player) sender);
					omp.unknownCommand("/" + cmd.getName());
				}
			}
		}
		else{}
		
		return false;
	}
}
