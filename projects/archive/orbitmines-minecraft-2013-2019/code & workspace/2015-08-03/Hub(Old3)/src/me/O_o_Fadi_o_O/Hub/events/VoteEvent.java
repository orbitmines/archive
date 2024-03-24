package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.VoteManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteEvent implements Listener{
	
	Hub hub = Hub.getInstance();
	
	@EventHandler
	public void onVote(VotifierEvent e){
		Vote vote = e.getVote();
		
		VoteManager.registerVote(vote.getUsername());
	}
}
