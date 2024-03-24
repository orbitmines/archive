package me.O_o_Fadi_o_O.KitPvP.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeEvent implements Listener{
	
	@EventHandler(priority = EventPriority.NORMAL)
    public void EntityExplodeEvent(EntityExplodeEvent e) {
        e.blockList().clear();
    }
}
