package me.O_o_Fadi_o_O.OrbitMines.NMS;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.server.v1_8_R3.EntityPigZombie;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_8_R3.World;

public class NoAttackPigZombie extends EntityPigZombie {

	@SuppressWarnings("rawtypes")
	public NoAttackPigZombie(World world) {
		super(world);
		
        List targetB = (List)getPrivateField("b", PathfinderGoalSelector.class, this.targetSelector); targetB.clear();
	}
	
	@SuppressWarnings("rawtypes")
	public static Object getPrivateField(String fieldName, Class clazz, Object object){
        Field field;
        Object o = null;

        try{
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            o = field.get(object);
        }catch(NoSuchFieldException e){e.printStackTrace();}catch(IllegalAccessException e){e.printStackTrace();}

        return o;
    }
}
