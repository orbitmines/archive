package me.O_o_Fadi_o_O.OrbitMines.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.HubServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.StringInt;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;

import org.bukkit.Bukkit;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;

public class VoteManager {
	
	private void registerNotOnline(UUID uuid){
		boolean hasVoteWaiting = false;
		
		List<String> list = new ArrayList<String>();
		
		for(String s : ServerStorage.pendingvoters){
			list.add(s);
		}
		
		if(list.size() != 0){
			try{
				List<String> newlist = new ArrayList<String>();
				newlist.addAll(list);
				
				for(String s : newlist){
					if(s.startsWith(uuid.toString())){
						list.remove(s);
						hasVoteWaiting = true;
						String[] sList = s.split("\\|");
						int amount = Integer.parseInt(sList[1]) +1;
						
						list.add(uuid.toString() + "|" + amount + "|");
					}
				}
			}catch(ArrayIndexOutOfBoundsException ex){}
		}
		
		if(hasVoteWaiting == false){
			list.add(uuid.toString() + "|1|");
		}
		
		ServerStorage.pendingvoters.clear();
		ServerStorage.pendingvoters.addAll(list);
		
		ConfigManager.config.set("VoteRewardsNotGiven", list);
		ConfigManager.saveConfig();
	}
	
	public void check(OMPlayer omp){
		UUID uuid = omp.getUUID();
		
		List<String> list = new ArrayList<String>();
		
		for(String s : ServerStorage.pendingvoters){
			list.add(s);
		}
		
		if(list.size() != 0){
			try{
				List<String> newlist = new ArrayList<String>();
				newlist.addAll(list);
				
				for(String s : newlist){
					if(s.startsWith(uuid.toString())){
						list.remove(s);
						String[] sList = s.split("\\|");
						int amount = Integer.parseInt(sList[1]);
						
						for(int i = 1; i <= amount; i++){
							omp.vote();
						}
						
						ServerStorage.pendingvoters = list;
						
						ConfigManager.config.set("VoteRewardsNotGiven", list);
						ConfigManager.saveConfig();
					}
				}
			}catch(ArrayIndexOutOfBoundsException ex){}
		}
	}
	
	public void registerVote(String playername){
		OMPlayer omp = null;
		
		for(OMPlayer omplayer : OMPlayer.getOMPlayers()){
			if(omplayer.getPlayer().getName().equalsIgnoreCase(playername)){
				omp = omplayer;
			}
		}
		
		if(omp != null){
			omp.vote();
			
			UUID uuid = omp.getUUID();
			
			if(ServerData.isServer(Server.HUB)){
				if(Database.get().containsPath("Votes", "votes", "uuid", uuid.toString())){
					Database.get().update("Votes", "votes", "" + (Database.get().getInt("Votes", "votes", "uuid", uuid.toString()) + 1), "uuid", uuid.toString());
				}
				else{
					Database.get().insert("Votes", "uuid`, `votes", uuid.toString() + "', '" + 1);
				}
			}
		}
		else{
			UUID uuid = Utils.getUUID(playername);
			
			if(uuid != null){
				registerNotOnline(uuid);
				
				if(ServerData.isServer(Server.HUB)){
					if(Database.get().containsPath("Votes", "votes", "uuid", uuid.toString())){
						Database.get().update("Votes", "votes", "" + (Database.get().getInt("Votes", "votes", "uuid", uuid.toString()) + 1), "uuid", uuid.toString());
					}
					else{
						Database.get().insert("Votes", "uuid`, `votes", uuid.toString() + "', '" + 1);
					}
				}
			}
		}
	}
	
	public void updateTop(){
		if(ServerData.isServer(Server.HUB)){		
			List<StringInt> voters = ServerStorage.voters;	
			HubServer hub = ServerData.getHub();
			World hubworld = hub.getHubWorld();
			
			Skull topvoter1 = (Skull) hubworld.getBlockAt(hub.getTopVoter1()).getState();
			Skull topvoter2 = (Skull) hubworld.getBlockAt(hub.getTopVoter2()).getState();
			Skull topvoter3 = (Skull) hubworld.getBlockAt(hub.getTopVoter3()).getState();
			
			if(voters != null && voters.size() > 0){
				if(voters.get(0).getString() == null){
					topvoter1.setOwner(null);
					topvoter1.setSkullType(SkullType.SKELETON);	
				}
				else{
					topvoter1.setSkullType(SkullType.PLAYER);
					topvoter1.setOwner(voters.get(0).getString());
				}
				if(voters.get(1).getString() == null){
					topvoter2.setOwner(null);
					topvoter2.setSkullType(SkullType.SKELETON);	
				}
				else{
					topvoter2.setSkullType(SkullType.PLAYER);
					topvoter2.setOwner(voters.get(1).getString());
				}
				if(voters.get(2).getString() == null){
					topvoter3.setOwner(null);
					topvoter3.setSkullType(SkullType.SKELETON);	
				}
				else{
					topvoter3.setSkullType(SkullType.PLAYER);
					topvoter3.setOwner(voters.get(2).getString());
				}
				
				topvoter1.setRotation(BlockFace.WEST);
				topvoter2.setRotation(BlockFace.WEST);
				topvoter3.setRotation(BlockFace.WEST);
				
				topvoter1.update();
				topvoter2.update();
				topvoter3.update();
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getWorld().getName().equals(hubworld.getName())){
						if(p.getLocation().distance(hub.getTopVoterSign1()) <= 20){
							String[] sign1 = new String[4];
							sign1[0] = "§lTop Voter (1)";
							sign1[1] = "";
							
							if(voters.get(0).getString() == null){
								sign1[2] = "";
								sign1[3] = "";
							}
							else{
								sign1[2] = voters.get(0).getString();
								
								if(voters.get(0).getInteger() == 1){
									sign1[3] = "§o" + voters.get(0).getInteger() + " Vote";
								}
								else{
									sign1[3] = "§o" + voters.get(0).getInteger() + " Votes";
								}
							}
							p.sendSignChange(hub.getTopVoterSign1(), sign1);
							
							String[] sign2 = new String[4];
							sign2[0] = "§lTop Voter (2)";
							sign2[1] = "";
							
							if(voters.get(1).getString() == null){
								sign2[2] = "";
								sign2[3] = "";
							}
							else{
								sign2[2] = voters.get(1).getString();
								
								if(voters.get(1).getInteger() == 1){
									sign2[3] = "§o" + voters.get(1).getInteger() + " Vote";
								}
								else{
									sign2[3] = "§o" + voters.get(1).getInteger() + " Votes";
								}
							}
							p.sendSignChange(hub.getTopVoterSign2(), sign2);
							
							String[] sign3 = new String[4];
							sign3[0] = "§lTop Voter (3)";
							sign3[1] = "";
							
							if(voters.get(2).getString() == null){
								sign3[2] = "";
								sign3[3] = "";
							}
							else{
								sign3[2] = voters.get(2).getString();
								
								if(voters.get(0).getInteger() == 1){
									sign3[3] = "§o" + voters.get(2).getInteger() + " Vote";
								}
								else{
									sign3[3] = "§o" + voters.get(2).getInteger() + " Votes";
								}
							}
							p.sendSignChange(hub.getTopVoterSign3(), sign3);
						}
					}
				}
			}
		}
	}
}
