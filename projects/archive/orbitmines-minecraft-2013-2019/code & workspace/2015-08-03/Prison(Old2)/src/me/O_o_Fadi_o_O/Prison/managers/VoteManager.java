package me.O_o_Fadi_o_O.Prison.managers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class VoteManager {

	public static void registerVote(Player p){
		giveVoteReward(p);
		sendVoteBroadCast(p);
	}
	
	public static void giveVoteReward(Player p){
		/*
		p.giveExpLevels(10);
		Start.economy.depositPlayer(p.getName(), 10);	
		if(p.hasPermission("nametag.group.A")){
			Start.economy.depositPlayer(p.getName(), 2500000);	
		}
		else if(p.hasPermission("nametag.group.B")){
			Start.economy.depositPlayer(p.getName(), 2000000);		
		}
		else if(p.hasPermission("nametag.group.C")){
			Start.economy.depositPlayer(p.getName(), 1500000);	
		}
		else if(p.hasPermission("nametag.group.D")){
			Start.economy.depositPlayer(p.getName(), 1000000);	
		}
		else if(p.hasPermission("nametag.group.E")){
			Start.economy.depositPlayer(p.getName(), 600000);
		}
		else if(p.hasPermission("nametag.group.F")){
			Start.economy.depositPlayer(p.getName(), 400000);
		}
		else if(p.hasPermission("nametag.group.G")){
			Start.economy.depositPlayer(p.getName(), 300000);
		}
		else if(p.hasPermission("nametag.group.H")){
			Start.economy.depositPlayer(p.getName(), 200000);
		}
		else if(p.hasPermission("nametag.group.I")){
			Start.economy.depositPlayer(p.getName(), 175000);
		}
		else if(p.hasPermission("nametag.group.J")){
			Start.economy.depositPlayer(p.getName(), 150000);
		}
		else if(p.hasPermission("nametag.group.K")){
			Start.economy.depositPlayer(p.getName(), 125000);
		}
		else if(p.hasPermission("nametag.group.L")){
			Start.economy.depositPlayer(p.getName(), 100000);
		}
		else if(p.hasPermission("nametag.group.M")){
			Start.economy.depositPlayer(p.getName(), 75000);
		}
		else if(p.hasPermission("nametag.group.N")){
			Start.economy.depositPlayer(p.getName(), 50000);
		}
		else if(p.hasPermission("nametag.group.O")){
			Start.economy.depositPlayer(p.getName(), 40000);
		}
		else if(p.hasPermission("nametag.group.P")){
			Start.economy.depositPlayer(p.getName(), 25000);	
		}
		*TODO: FIX
		*/
		
	}
	
	public static void sendVoteBroadCast(Player p){
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(player != p){
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §b§l" + p.getName() + "§7 has voted with §b§l/vote");
			}
			else{
				player.sendMessage("");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Thank you, §b§l" + p.getName() + " §7for your §b§lVote§7!");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your reward in the §4§lPrison§7 Server:");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				if(p.hasPermission("nametag.group.A")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l2.500.000$ §7(§c§lA§7)");	
				}
				else if(p.hasPermission("nametag.group.B")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l2.000.000$ §7(§a§lB§7)");	
				}
				else if(p.hasPermission("nametag.group.C")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l1.500.000$ §7(§b§lC§7)");	
				}
				else if(p.hasPermission("nametag.group.D")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l1.000.000$ §7(§d§lD§7)");	
				}
				else if(p.hasPermission("nametag.group.E")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l600.000$ §7(§5§lE§7)");	
				}
				else if(p.hasPermission("nametag.group.F")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l400.000$ §7(§1§lF§7)");	
				}
				else if(p.hasPermission("nametag.group.G")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l300.000$ §7(§e§lG§7)");	
				}
				else if(p.hasPermission("nametag.group.H")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l200.000$ §7(§4§lH§7)");	
				}
				else if(p.hasPermission("nametag.group.I")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l175.000$ §7(§2§lI§7)");	
				}
				else if(p.hasPermission("nametag.group.J")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l150.000$ §7(§f§lJ§7)");	
				}
				else if(p.hasPermission("nametag.group.K")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l125.000$ §7(§6§lK§7)");	
				}
				else if(p.hasPermission("nametag.group.L")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l100.000$ §7(§7§lL§7)");	
				}
				else if(p.hasPermission("nametag.group.M")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l75.000$ §7(§8§lM§7)");	
				}
				else if(p.hasPermission("nametag.group.N")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l50.000$ §7(§0§lN§7)");	
				}
				else if(p.hasPermission("nametag.group.O")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l40.000$ §7(§3§lO§7)");	
				}
				else if(p.hasPermission("nametag.group.P")){
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l25.000$ §7(§f§lP§7)");	
				}
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l10 EXP Levels");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			}
		}
	}
}
