package me.O_o_Fadi_o_O.MiniGames.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelEvent implements Listener{

	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		
		
		e.setFoodLevel(20);
	}
}
