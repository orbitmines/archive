package me.O_o_Fadi_o_O.SkyBlock.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.inventories.ChallengesInv;
import me.O_o_Fadi_o_O.SkyBlock.inventories.IslandInfoInv;
import me.O_o_Fadi_o_O.SkyBlock.inventories.IslandPartyInv;
import me.O_o_Fadi_o_O.SkyBlock.inventories.challenges.FarmChallenges;
import me.O_o_Fadi_o_O.SkyBlock.inventories.challenges.GatherChallenges;
import me.O_o_Fadi_o_O.SkyBlock.inventories.challenges.MobChallenges;
import me.O_o_Fadi_o_O.SkyBlock.managers.ConfigManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.IslandManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener{

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			final Player p = (Player) he;
			ItemStack c = e.getCurrentItem();
			
			try{
				if(c != null){
					if(e.getInventory().getName().equals("§0§lChallenges")){
						e.setCancelled(true);
						
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().startsWith("§f§lGather Challenges")){
							
							p.openInventory(GatherChallenges.getGatherChallengesInv(p));
							
						}
						if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().startsWith("§f§lFarm Challenges")){
							
							p.openInventory(FarmChallenges.getFarmChallengesInv(p));
							
						}
						if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().startsWith("§f§lMob Challenges")){
							
							p.openInventory(MobChallenges.getMobChallengesInv(p));
							
						}
					}
					if(e.getInventory().getName().equals("§0§lIsland Party")){
						e.setCancelled(true);
						
						if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().startsWith("§d§lIsland Info")){
							
							p.openInventory(IslandInfoInv.getIslandInfoInv(p));
							
						}
					}
					if(e.getInventory().getName().equals("§0§lIsland Info")){
						e.setCancelled(true);
						
						if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§6§lIsland Party")){
							
							p.openInventory(IslandPartyInv.getIslandPartyInv(p));
							
						}
						if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().startsWith("§3§lTeleport")){
							int IslandNumber = StorageManager.PlayersIslandNumber.get(p);
							
							if(StorageManager.IslandOwner.get(IslandNumber).equals(p.getName())){
								if(c.getItemMeta().getDisplayName().endsWith("§c§lDISABLED")){
									IslandManager.setIslandTeleportEnabled(IslandNumber, true);	
									IslandInfoInv.setTeleportEnabledItem(p.getOpenInventory().getTopInventory(), 15, p, IslandNumber);
									p.sendMessage(Start.TAG + "§a§lENABLED§7 §3Teleporting§7 to your §dIsland§7!");
									p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								}
								if(c.getItemMeta().getDisplayName().endsWith("§a§lENABLED")){
									IslandManager.setIslandTeleportEnabled(IslandNumber, false);	
									IslandInfoInv.setTeleportEnabledItem(p.getOpenInventory().getTopInventory(), 15, p, IslandNumber);
									p.sendMessage(Start.TAG + "§c§lDISABLED§7 §3Teleporting§7 to your §dIsland§7!");
									p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You aren't the §downer§7 of your §dIsland§7!");
							}
						}
					}
					if(e.getInventory().getName().equals("§0§lMob Challenges")){
						e.setCancelled(true);
						
						if(c.getType() == Material.BONE && c.getItemMeta().getDisplayName().endsWith("§lSkeletons")){
						
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.BONE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 150)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Skeletons")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Jungle Sapling");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -150;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SAPLING, 1);
											item.setDurability((short) 3);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dBones§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.ARROW && c.getItemMeta().getDisplayName().endsWith("§lArrows!")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.ARROW);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 200)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Arrows!")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l20 Cobblestone");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -200;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.COBBLESTONE, 20);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dArrows§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.ROTTEN_FLESH && c.getItemMeta().getDisplayName().endsWith("§lZombie Apocalypse")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.ROTTEN_FLESH);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 175)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Zombie Apocalypse")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l3 Raw Fish");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -175;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.RAW_FISH, 3);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dRotten Flesh§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.SULPHUR && c.getItemMeta().getDisplayName().endsWith("§lCreepy Creeper")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.SULPHUR);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 225)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Creepy Creeper")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Spawn Squid Egg");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -225;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
											item.setDurability((short) 94);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dGunpowder§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.STRING && c.getItemMeta().getDisplayName().endsWith("§lDestroy the Webs!")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.STRING);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 200)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Destroy the Webs!")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Red Mushroom");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -200;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.RED_MUSHROOM, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dString§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().endsWith("§lSpider Eyes")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.SPIDER_EYE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 15)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Spider Eyes")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Wheat");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -15;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.WHEAT, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dSpider Eyes§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().endsWith("§lEnderwoman")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.ENDER_PEARL);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 16)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Enderwoman")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Spawn Chicken Egg");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -16;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
											item.setDurability((short) 93);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dEnderpearls§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§f§lChallenges")){
							
							p.openInventory(ChallengesInv.getChallengesInv(p));
							
						}
					}
					if(e.getInventory().getName().equals("§0§lFarm Challenges")){
						e.setCancelled(true);
						
						if(c.getType() == Material.MELON && c.getItemMeta().getDisplayName().endsWith("§lMelons")){
						
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.MELON);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 50)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Melons")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Spruce Sapling");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -50;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SAPLING, 1);
											item.setDurability((short) 1);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dMelons§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.PUMPKIN && c.getItemMeta().getDisplayName().endsWith("§lHalloween Party")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.PUMPKIN);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 32)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Halloween Party")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Brown Mushroom");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -32;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.BROWN_MUSHROOM, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dPumpkins§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.SUGAR_CANE && c.getItemMeta().getDisplayName().endsWith("§lSugarcane")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.SUGAR_CANE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 55)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Sugarcane")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Sand");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -55;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SAND, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dSugarcane§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.MELON_BLOCK && c.getItemMeta().getDisplayName().endsWith("§lMelon Blocks?!")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.MELON_BLOCK);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 32)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Melon Blocks?!")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Dirt");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -32;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.DIRT, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dMelon Blocks§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.MUSHROOM_SOUP && c.getItemMeta().getDisplayName().endsWith("§lMushroom Hunting")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.MUSHROOM_SOUP);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 30)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Mushroom Hunting")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Ice");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -30;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.ICE, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dMushroom Stew§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.GRILLED_PORK && c.getItemMeta().getDisplayName().endsWith("§lBacon")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.GRILLED_PORK);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 40)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Bacon")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Cactus");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -50;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.CACTUS, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCooked Porkchop§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.CARROT_ITEM && c.getItemMeta().getDisplayName().endsWith("§lRabbits")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.CARROT_ITEM);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 100)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Rabbits")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Dark Oak Sapling");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -100;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SAPLING, 1);
											item.setDurability((short) 5);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCarrots§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.BREAD && c.getItemMeta().getDisplayName().endsWith("§lBaker")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.BREAD);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 30)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Baker")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Cocoa Beans");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -30;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.INK_SACK, 1);
											item.setDurability((short) 3);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dBread§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.BAKED_POTATO && c.getItemMeta().getDisplayName().endsWith("§lPotatoes")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.BAKED_POTATO);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 100)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Potatoes")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Acacia Sapling");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -100;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SAPLING, 1);
											item.setDurability((short) 4);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dPotatoes§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.COOKIE && c.getItemMeta().getDisplayName().endsWith("§lCookie Monster")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.COOKIE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 200)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Cookie Monster")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l5 Lapis Lazuli Ore");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -200;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.LAPIS_ORE, 5);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCookies§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.CACTUS && c.getItemMeta().getDisplayName().endsWith("§lCactus")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.CACTUS);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 100)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Cactus")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Slimeball");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -100;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCactus§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.COOKED_CHICKEN && c.getItemMeta().getDisplayName().endsWith("§lKFC Delivery")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.COOKED_CHICKEN);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 60)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("KFC Delivery")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Spawn Sheep Egg");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -60;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
											item.setDurability((short) 91);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCooked Chicken§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.COOKED_BEEF && c.getItemMeta().getDisplayName().endsWith("§lSteak")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.COOKED_BEEF);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 80)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Steak")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l80 Steak");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -80;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
											item.setDurability((short) 1);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dSteak§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.PUMPKIN_PIE && c.getItemMeta().getDisplayName().endsWith("§lGrandmother's Kitchen")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.PUMPKIN_PIE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 125)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Grandmother's Kitchen")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l3 Yellow Flowers");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -125;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.YELLOW_FLOWER, 3);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dPumpkin Pie§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.CAKE && c.getItemMeta().getDisplayName().endsWith("§lCakes")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.CAKE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 3)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Cakes")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Emerald Ore");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -3;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.EMERALD_ORE, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCakes§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§f§lChallenges")){
							
							p.openInventory(ChallengesInv.getChallengesInv(p));
							
						}
					}
					if(e.getInventory().getName().equals("§0§lGather Challenges")){
						e.setCancelled(true);
						
						if(c.getType() == Material.COBBLESTONE && c.getItemMeta().getDisplayName().endsWith("§lCobblestone Generator")){
						
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.COBBLESTONE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 32)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Cobblestone Generator")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Birch Sapling");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.COBBLESTONE && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -32;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SAPLING, 1);
											item.setDurability((short) 2);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dCobblestone§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.SMOOTH_BRICK && c.getItemMeta().getDisplayName().endsWith("§lMore Smoothness")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.SMOOTH_BRICK);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 40)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("More Smoothness")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Iron Ingot");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.SMOOTH_BRICK && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -40;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dStone Bricks§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.COMPASS && c.getItemMeta().getDisplayName().endsWith("§lNavigation")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.COMPASS);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 1)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Navigation")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Pumpkin Seed");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.COMPASS && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -1;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.PUMPKIN_SEEDS, 1);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dCompass§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.APPLE && c.getItemMeta().getDisplayName().endsWith("§lApples")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.APPLE);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 1)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Apples")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Sugarcane");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.APPLE && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -1;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.SUGAR_CANE, 1);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dApple§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.RAW_FISH && c.getItemMeta().getDisplayName().endsWith("§lFishing Time!")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.RAW_FISH);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 10)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Fishing Time!")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l2 Leather");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.RAW_FISH && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -10;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.LEATHER, 2);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dRaw Fish§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getDisplayName().endsWith("§lLibrarian")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.BOOKSHELF);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 2)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Librarian")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l3 Gold Ore");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.BOOKSHELF && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -2;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.GOLD_ORE, 3);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dBookshelfs§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().endsWith("§lJack the Lumberjack")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.LOG);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 25)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Jack the Lumberjack")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Melon Seed");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -25;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MELON_SEEDS, 1);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dOak Logs§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.LOG && c.getItemMeta().getDisplayName().endsWith("§lChop Chop")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.LOG);
								itemR.setDurability((short) 0);//OAK
								
								ItemStack itemR2 = new ItemStack(Material.LOG);
								itemR2.setDurability((short) 2);//BIRCH
								
								ItemStack itemR3 = new ItemStack(Material.LOG);
								itemR3.setDurability((short) 1); //SPRUCE
								if(p.getInventory().containsAtLeast(itemR, 32) && p.getInventory().containsAtLeast(itemR2, 32) && p.getInventory().containsAtLeast(itemR3, 32)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Chop Chop")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l16 Clay");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount1 = 0;
											int totalamount2 = 0;
											int totalamount3 = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR.getDurability()){
														totalamount1 = totalamount1 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR2.getDurability()){
														totalamount2 = totalamount2 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR3.getDurability()){
														totalamount3 = totalamount3 + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount1 = totalamount1 -32;
											totalamount2 = totalamount2 -32;
											totalamount3 = totalamount3 -32;

											for(int i = 1; i <= totalamount1; i++){
												p.getInventory().addItem(itemR);
											}
											for(int i = 1; i <= totalamount2; i++){
												p.getInventory().addItem(itemR2);
											}
											for(int i = 1; i <= totalamount3; i++){
												p.getInventory().addItem(itemR3);
											}
											
											ItemStack item = new ItemStack(Material.CLAY_BALL, 16);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dLogs§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getDisplayName().endsWith("§lLibrarian")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.BOOKSHELF);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 2)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Librarian")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l3 Gold Ore");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.BOOKSHELF && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -2;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.GOLD_ORE, 3);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dBookshelfs§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().endsWith("§lThe Dark Forest")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.LOG_2);
								itemR.setDurability((short) 1);
								if(p.getInventory().containsAtLeast(itemR, 64)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("The Dark Forest")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l2 Poppies");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.LOG_2 && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -64;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.RED_ROSE, 2);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dDark Oak Logs§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.WATCH && c.getItemMeta().getDisplayName().endsWith("§lIt's Time")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.WATCH);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 1)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("It's Time")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Spawn Pig Egg");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.WATCH && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -1;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
											item.setDurability((short) 90);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dClock§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().endsWith("§lSheep Shearing")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.WOOL);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 50)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Sheep Shearing")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l3 Gravel");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.WOOL && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -50;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.GRAVEL, 3);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dWhite Wool§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.STAINED_CLAY && c.getItemMeta().getDisplayName().endsWith("§lStained Clay")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.STAINED_CLAY);
								itemR.setDurability((short) 14);
								if(p.getInventory().containsAtLeast(itemR, 28)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Stained Clay")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Mycelium");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.STAINED_CLAY && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -28;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.MYCEL, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dRed Stained Clay§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.STAINED_GLASS && c.getItemMeta().getDisplayName().endsWith("§lWindows")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.STAINED_GLASS);
								itemR.setDurability((short) 14);
								if(p.getInventory().containsAtLeast(itemR, 16)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Windows")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l2 Obsidian");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.STAINED_GLASS && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -16;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.OBSIDIAN, 2);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dRed Stained Glass§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.LOG_2 && c.getItemMeta().getDisplayName().endsWith("§lWood Factory")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.LOG);
								itemR.setDurability((short) 0);//OAK
								
								ItemStack itemR2 = new ItemStack(Material.LOG);
								itemR2.setDurability((short) 2);//BIRCH
								
								ItemStack itemR3 = new ItemStack(Material.LOG);
								itemR3.setDurability((short) 1); //SPRUCE
								
								ItemStack itemR4 = new ItemStack(Material.LOG);
								itemR4.setDurability((short) 3); //JUNGLE
								
								ItemStack itemR5 = new ItemStack(Material.LOG_2);
								itemR5.setDurability((short) 0); //ACACIA
								
								ItemStack itemR6 = new ItemStack(Material.LOG_2);
								itemR6.setDurability((short) 1); //DARK OAK
								if(p.getInventory().containsAtLeast(itemR, 64) && p.getInventory().containsAtLeast(itemR2, 64) && p.getInventory().containsAtLeast(itemR3, 64) && p.getInventory().containsAtLeast(itemR4, 64) && p.getInventory().containsAtLeast(itemR5, 64) && p.getInventory().containsAtLeast(itemR6, 64)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Wood Factory")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Spawn Cow Egg");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount1 = 0;
											int totalamount2 = 0;
											int totalamount3 = 0;
											int totalamount4 = 0;
											int totalamount5 = 0;
											int totalamount6 = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR.getDurability()){
														totalamount1 = totalamount1 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR2.getDurability()){
														totalamount2 = totalamount2 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR3.getDurability()){
														totalamount3 = totalamount3 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG && item.getDurability() == itemR4.getDurability()){
														totalamount4 = totalamount4 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG_2 && item.getDurability() == itemR5.getDurability()){
														totalamount5 = totalamount5 + item.getAmount();
														p.getInventory().remove(item);
													}
													
													if(item.getType() == Material.LOG_2 && item.getDurability() == itemR6.getDurability()){
														totalamount6 = totalamount6 + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount1 = totalamount1 -64;
											totalamount2 = totalamount2 -64;
											totalamount3 = totalamount3 -64;
											totalamount4 = totalamount4 -64;
											totalamount5 = totalamount5 -64;
											totalamount6 = totalamount6 -64;

											for(int i = 1; i <= totalamount1; i++){
												p.getInventory().addItem(itemR);
											}
											for(int i = 1; i <= totalamount2; i++){
												p.getInventory().addItem(itemR2);
											}
											for(int i = 1; i <= totalamount3; i++){
												p.getInventory().addItem(itemR3);
											}
											for(int i = 1; i <= totalamount4; i++){
												p.getInventory().addItem(itemR4);
											}
											for(int i = 1; i <= totalamount5; i++){
												p.getInventory().addItem(itemR5);
											}
											for(int i = 1; i <= totalamount6; i++){
												p.getInventory().addItem(itemR6);
											}
											
											ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
											item.setDurability((short) 92);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dLogs§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.NAME_TAG && c.getItemMeta().getDisplayName().endsWith("§lLucky Fishing")){
							
							if(c.getItemMeta().getDisplayName().startsWith("§a")){
								ItemStack itemR = new ItemStack(Material.NAME_TAG);
								itemR.setDurability((short) 0);
								if(p.getInventory().containsAtLeast(itemR, 3)){
									
									List<String> challenges = StorageManager.PlayersChallengesCompleteAmount.get(p);
									
									for(String s : challenges){
										if(s.startsWith("Lucky Fishing")){
											String[] challengeFormat = s.split("\\|");
											
											String challenge = challengeFormat[0];
											int amount = Integer.parseInt(challengeFormat[1]) +1;
											
											IslandManager.setChallengeCompletedAmount(p, challenge, amount);
											p.sendMessage("");
											p.sendMessage(Start.TAG + "§dChallenge Completed: §f§l" + challenge);
											p.sendMessage(Start.TAG + "§dTimes Completed: §f§l" + amount);
											p.sendMessage(Start.TAG + "§dReward: §f§l1 Diamond");
											p.sendMessage("");
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.closeInventory();
											
											int totalamount = 0;
											
											for(ItemStack item : p.getInventory().getContents()){
												try{
													
													if(item.getType() == Material.NAME_TAG && item.getDurability() == itemR.getDurability()){
														totalamount = totalamount + item.getAmount();
														p.getInventory().remove(item);
													}
													
												}catch(Exception ex){
													
												}
											}
											
											totalamount = totalamount -3;

											for(int i = 1; i <= totalamount; i++){
												p.getInventory().addItem(itemR);
											}
											
											ItemStack item = new ItemStack(Material.DIAMOND, 1);
											item.setDurability((short) 0);
											p.getInventory().addItem(item);
											
											List<String> challenges1 = new ArrayList<String>();
											for(String s1 : StorageManager.Challenges){
												if(!ConfigManager.playerdata.contains("players." + p.getName() + ".Challenges." + s1)){
													IslandManager.setChallengeCompletedAmount(p, s1, 0);
												}
												challenges1.add(s1 + "|" + IslandManager.getChallengeCompletedAmount(p, s1));
											}
											StorageManager.PlayersChallengesCompleteAmount.put(p, challenges1);
											
										}
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have enough §dName Tags§7!");
								}
							}
							if(c.getItemMeta().getDisplayName().startsWith("§c")){
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You haven't completed the §drequired Challenges§7!");
							}
						}
						
						if(c.getType() == Material.PAPER && c.getItemMeta().getDisplayName().equals("§f§lChallenges")){
							
							p.openInventory(ChallengesInv.getChallengesInv(p));
							
						}
					}
				}
			}catch(Exception ex){
		
			}
		}
	}
}
