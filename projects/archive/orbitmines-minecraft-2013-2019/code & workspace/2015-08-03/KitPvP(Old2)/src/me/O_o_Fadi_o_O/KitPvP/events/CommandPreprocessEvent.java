package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.KitSelector;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Assassin.AssassinLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Beast.BeastLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.DarkMage.DarkMageLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Fish.FishLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.GrimReaper.GrimReaperLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Heavy.HeavyLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Lord.LordLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Miner.MinerLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Vampire.VampireLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardLvL3;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class CommandPreprocessEvent implements Listener {

	Start plugin;
	 
	public CommandPreprocessEvent(Start instance) {
		plugin = instance;
	}
	private KitSelector kitselector = new KitSelector(this.plugin);
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onUnknown(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			
			String s = e.getMessage().split(" ") [0];
			
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(s);
			
			if(topic == null){
				
				p.sendMessage("§c§lKitPvP §8| §7Unknown Command: §c" + s + "§7. Use §c/help§7!");
				e.setCancelled(true);
			}
			
		    String[] args = e.getMessage().split(" ");
		    if(args[0].equalsIgnoreCase("/vote")){
		    	e.setCancelled(true);
		    	
				p.sendMessage("");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §c§lKitPvP§7 Server:");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §6§l500 Coins");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
		    }
		    if(args[0].equalsIgnoreCase("/kit")){
		    	e.setCancelled(true);
		    	
		    	if(PlayerManager.isLoaded(p)){
		    		if(!p.isOp()){
		    			if(!StorageManager.PlayerKitSelected.containsKey(p)){
		    				if(!StorageManager.Spectators.contains(p)){
		    					p.sendMessage(Start.TAG + "Opening the §bKit Selector§7...");
								p.openInventory(kitselector.getKitSelector(p));
		    				}
		    				else{
		    					p.sendMessage(Start.TAG + "§4§lDENIED§7! You can't use §6/kit§7 while §espectating§7!");
		    				}
		    			}
		    			else{
		    				p.sendMessage(Start.TAG + "§4§lDENIED§7! You can't use §6/kit§7 while playing!");
		    			}
					}
					else{
						if(args.length == 1){
			    			if(!StorageManager.PlayerKitSelected.containsKey(p)){
			    				if(!StorageManager.Spectators.contains(p)){
			    					p.sendMessage(Start.TAG + "Opening the §bKit Selector§7...");
									p.openInventory(kitselector.getKitSelector(p));
			    				}
			    				else{
			    					p.sendMessage(Start.TAG + "§4§lDENIED§7! You can't use §6/kit§7 while §espectating§7!");
			    				}
			    			}
			    			else{
			    				p.sendMessage(Start.TAG + "§4§lDENIED§7! You can't use §6/kit§7 while playing!");
			    			}
						}
						else if(args.length == 3){
							String kit = args[1];
							try{
								int level = Integer.parseInt(args[2]);
								
								if(kit.equalsIgnoreCase("knight")){
									if(level == 1){
										KnightLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lKnight§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										KnightLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lKnight§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										KnightLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lKnight§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("archer")){
									if(level == 1){
										ArcherLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lArcher§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										ArcherLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lArcher§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										ArcherLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lArcher§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("soldier")){
									if(level == 1){
										SoldierLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSoldier§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										SoldierLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSoldier§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										SoldierLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSoldier§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("wizard")){
									if(level == 1){
										WizardLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lWizard§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										WizardLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lWizard§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										WizardLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lWizard§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("tank")){
									if(level == 1){
										TankLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTank§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										TankLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTank§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										TankLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTank§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("drunk")){
									if(level == 1){
										DrunkLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lDrunk§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										DrunkLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lDrunk§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										DrunkLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lDrunk§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("pyro")){
									if(level == 1){
										PyroLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lPyro§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										PyroLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lPyro§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										PyroLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lPyro§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("bunny")){
									if(level == 1){
										BunnyLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBunny§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										BunnyLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBunny§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										BunnyLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBunny§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("necromancer")){
									if(level == 1){
										NecromancerLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lNecromancer§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										NecromancerLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lNecromancer§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										NecromancerLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lNecromancer§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("king")){
									if(level == 1){
										KingLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lKing§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										KingLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lKing§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										KingLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lKing§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("tree")){
									if(level == 1){
										TreeLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTree§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										TreeLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTree§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										TreeLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTree§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("blaze")){
									if(level == 1){
										BlazeLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBlaze§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										BlazeLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBlaze§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										BlazeLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBlaze§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("tnt")){
									if(level == 1){
										TNTLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTNT§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										TNTLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTNT§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										TNTLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lTNT§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("fisherman")){
									if(level == 1){
										FishermanLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lFisherman§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										FishermanLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lFisherman§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										FishermanLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lFisherman§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("snowgolem")){
									if(level == 1){
										SnowGolemLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSnowGolem§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										SnowGolemLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSnowGolem§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										SnowGolemLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSnowGolem§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("librarian")){
									if(level == 1){
										LibrarianLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lLibrarian§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										LibrarianLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lLibrarian§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										LibrarianLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lLibrarian§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("spider")){
									if(level == 1){
										SpiderLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSpider§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										SpiderLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSpider§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										SpiderLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lSpider§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("villager")){
									if(level == 1){
										VillagerLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lVillager§7' §7§o(§a§oLvL 1§7§o)");
									}
									else if(level == 2){
										VillagerLvL2.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lVillager§7' §7§o(§a§oLvL 2§7§o)");
									}
									else if(level == 3){
										VillagerLvL3.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lVillager§7' §7§o(§a§oLvL 3§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("assassin")){
									if(level == 1){
										AssassinLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lAssassin§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("lord")){
									if(level == 1){
										LordLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lLord§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("vampire")){
									if(level == 1){
										VampireLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lVampire§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("darkmage")){
									if(level == 1){
										DarkMageLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lDarkMage§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("beast")){
									if(level == 1){
										BeastLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lBeast§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("fish")){
									if(level == 1){
										FishLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lFish§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("heavy")){
									if(level == 1){
										HeavyLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lHeavy§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("grimreaper")){
									if(level == 1){
										GrimReaperLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lGrimReaper§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								if(kit.equalsIgnoreCase("miner")){
									if(level == 1){
										MinerLvL1.give(p);
										p.sendMessage(Start.TAG + "Selected Kit: '§b§lMiner§7' §7§o(§a§oLvL 1§7§o)");
									}
									else{p.sendMessage(Start.TAG + "Kit '§b§l" + kit +"§7' doesn't have the §a§lLevel " + level + "§7!");}
								}
								
							}catch(Exception ex){
								p.sendMessage(Start.TAG + args[2] + " isn't a Number!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "Use §6/kit <kit> <level>");
						}
					}
		    	}
		    	else{
		    		e.setCancelled(true);
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		}
	}
}
