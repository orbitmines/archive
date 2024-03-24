package me.O_o_Fadi_o_O.SkyBlock.NMS;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.server.v1_8_R1.EntityVillager;
import net.minecraft.server.v1_8_R1.GenericAttributes;
import net.minecraft.server.v1_8_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_8_R1.World;

public class CustomVillager extends EntityVillager {

	@SuppressWarnings("rawtypes")
	public CustomVillager(World world) {
		super(world);
		
        List goalB = (List)getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
        List goalC = (List)getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
        List targetB = (List)getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
        List targetC = (List)getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
	}
	
	@Override
    public void g(double x, double y, double z){
        return;
    }
    
	@Override
	public void m(){
		super.m();
		// Make his walk speed 0 so he doesn't walk around on his own
		this.getAttributeInstance(GenericAttributes.d).setValue(0.0D);
		// Make his health to max a double can be
		this.getAttributeInstance(GenericAttributes.b).setValue(Double.MAX_VALUE);
		// Make his knockback resistance max double can be
		this.getAttributeInstance(GenericAttributes.c).setValue(Double.MAX_VALUE);
	} 
	
	@SuppressWarnings("rawtypes")
	public static Object getPrivateField(String fieldName, Class clazz, Object object)
    {
        Field field;
        Object o = null;

        try
        {
            field = clazz.getDeclaredField(fieldName);

            field.setAccessible(true);

            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return o;
    }
}
