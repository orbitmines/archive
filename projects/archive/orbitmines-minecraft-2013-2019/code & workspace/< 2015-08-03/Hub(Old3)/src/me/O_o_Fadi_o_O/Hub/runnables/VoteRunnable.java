package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.ConfigManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class VoteRunnable {

	Hub hub = Hub.getInstance();
	
	public void startVoteRunnable(){
		
		new BukkitRunnable(){

			@Override
			public void run() {
				try{
					for(String s : ConfigManager.playerdata.getConfigurationSection("players").getKeys(false)){
						
						try{
							String uuid = s;
							
							if(s.length() <= 16){
								int votes = ConfigManager.playerdata.getInt("players." + uuid + ".Votes");
								ConfigManager.playerdata.set("players." + uuid, null);
								
								uuid = Hub.getUUIDfromString(s).toString();
								
								ConfigManager.playerdata.set("players." + uuid + ".Votes", votes);
								ConfigManager.savePlayerData();
							}
							StorageManager.votes.put(UUID.fromString(uuid), ConfigManager.playerdata.getInt("players." + uuid + ".Votes"));
							List<UUID> allvoters = StorageManager.allvoters;
							if(allvoters.contains(UUID.fromString(s))){
								allvoters.remove(UUID.fromString(s));
							}
							allvoters.add(UUID.fromString(uuid));
							StorageManager.allvoters = allvoters;
						}catch(Exception ex){
							ConfigManager.playerdata.set("players." + s, null);
						}
					}
				}
				catch(Exception ex){}
			}
		}.runTaskTimer(this.hub, 100, 20 * 60 * 60);
		
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				int votes1 = 0;
				int votes2 = 0;
				int votes3 = 0;
				
				UUID uuid1 = null;
				UUID uuid2 = null;
				UUID uuid3 = null;
				
				for(UUID uuid : StorageManager.allvoters){
					int votes = StorageManager.votes.get(uuid);
					if(votes >= votes1){
						votes3 = votes2;
						votes2 = votes1;
						votes1 = votes;
						
						uuid3 = uuid2;
						uuid2 = uuid1;
						uuid1 = uuid;
						
					}
					else if(votes >= votes2){
						votes3 = votes2;
						votes2 = votes;
						
						uuid3 = uuid2;
						uuid2 = uuid;
					}
					else if(votes >= votes3){
						votes3 = votes;
						
						uuid3 = uuid;
					}else{}
				}
				
				Skull topvoter1 = (Skull) StorageManager.hubworld.getBlockAt(StorageManager.topvoter1).getState();
				Skull topvoter2 = (Skull) StorageManager.hubworld.getBlockAt(StorageManager.topvoter2).getState();
				Skull topvoter3 = (Skull) StorageManager.hubworld.getBlockAt(StorageManager.topvoter3).getState();
				
				if(uuid1 == null){
					topvoter1.setOwner(null);
					topvoter1.setSkullType(SkullType.SKELETON);	
				}
				else{
					topvoter1.setSkullType(SkullType.PLAYER);
					topvoter1.setOwner(Hub.getPlayerNamefromUUID(uuid1));
				}
				if(uuid2 == null){
					topvoter2.setOwner(null);
					topvoter2.setSkullType(SkullType.SKELETON);	
				}
				else{
					topvoter2.setSkullType(SkullType.PLAYER);
					topvoter2.setOwner(Hub.getPlayerNamefromUUID(uuid2));
				}
				if(uuid3 == null){
					topvoter3.setOwner(null);
					topvoter3.setSkullType(SkullType.SKELETON);	
				}
				else{
					topvoter3.setSkullType(SkullType.PLAYER);
					topvoter3.setOwner(Hub.getPlayerNamefromUUID(uuid3));
				}
				
				topvoter1.setRotation(BlockFace.WEST);
				topvoter2.setRotation(BlockFace.WEST);
				topvoter3.setRotation(BlockFace.WEST);
				
				topvoter1.update();
				topvoter2.update();
				topvoter3.update();
				
				for(Player p : Bukkit.getOnlinePlayers()){
					try{
						if(p.getLocation().distance(StorageManager.topvotersign1) <= 20){
							String[] sign1 = new String[4];
							sign1[0] = "§lTop Voter (1)";
							sign1[1] = "";
							sign1[2] = Hub.getPlayerNamefromUUID(uuid1);
							
							if(uuid1.equals("")){
								sign1[3] = "";
							}
							else{
								if(StorageManager.votes.get(uuid1) == 1){
									sign1[3] = "§o" + StorageManager.votes.get(uuid1) + " Vote";
								}
								else{
									sign1[3] = "§o" + StorageManager.votes.get(uuid1) + " Votes";
								}
								
								p.sendSignChange(StorageManager.topvotersign1, sign1);
							}
							
							String[] sign2 = new String[4];
							sign2[0] = "§lTop Voter (2)";
							sign2[1] = "";
							sign2[2] = Hub.getPlayerNamefromUUID(uuid2);
							if(uuid2.equals("")){
								sign2[3] = "";
							}
							else{
								if(StorageManager.votes.get(uuid2) == 1){
									sign2[3] = "§o" + StorageManager.votes.get(uuid2) + " Vote";
								}
								else{
									sign2[3] = "§o" + StorageManager.votes.get(uuid2) + " Votes";
								}
							}
							
							p.sendSignChange(StorageManager.topvotersign2, sign2);
							
							String[] sign3 = new String[4];
							sign3[0] = "§lTop Voter (3)";
							sign3[1] = "";
							sign3[2] = Hub.getPlayerNamefromUUID(uuid3);
							if(uuid3.equals("")){
								sign3[3] = "";
							}
							else{
								if(StorageManager.votes.get(uuid3) == 1){
									sign3[3] = "§o" + StorageManager.votes.get(uuid3) + " Vote";
								}
								else{
									sign3[3] = "§o" + StorageManager.votes.get(uuid3) + " Votes";
								}
							}
							
							p.sendSignChange(StorageManager.topvotersign3, sign3);
						}
					}catch(Exception ex){}
				}
			}
		}.runTaskTimer(this.hub, 100, 20);
		
	}
}
