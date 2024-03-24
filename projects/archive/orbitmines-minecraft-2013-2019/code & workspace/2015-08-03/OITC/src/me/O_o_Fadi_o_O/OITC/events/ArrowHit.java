package me.O_o_Fadi_o_O.OITC.events;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHit implements Listener{
	
	@EventHandler
	public void onArrowHit(ProjectileHitEvent e){
		Projectile proj = e.getEntity();
		if((proj instanceof Arrow)){
			Arrow arrow = (Arrow)proj;
			try {
                Method getHandleMethod = arrow.getClass().getMethod("getHandle");
                Object handle = getHandleMethod.invoke(arrow);
                Field fromPlayerField = handle.getClass().getField("fromPlayer");
                fromPlayerField.setInt(handle, 2);
                Method setDamageMethod = handle.getClass().getMethod("b", Double.TYPE);
                setDamageMethod.invoke(handle, 20);
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
		}
	}
}
