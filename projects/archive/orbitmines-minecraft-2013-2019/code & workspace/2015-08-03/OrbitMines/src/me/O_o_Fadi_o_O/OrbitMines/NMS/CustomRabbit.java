package me.O_o_Fadi_o_O.OrbitMines.NMS;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.server.v1_8_R3.EntityRabbit;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_8_R3.World;

public class CustomRabbit extends EntityRabbit {

	@SuppressWarnings("rawtypes")
	public CustomRabbit(World world) {
		super(world);
		
        List goalB = (List)getPrivateField("b", PathfinderGoalSelector.class, this.goalSelector); goalB.clear();
        List goalC = (List)getPrivateField("c", PathfinderGoalSelector.class, this.goalSelector); goalC.clear();
        List targetB = (List)getPrivateField("b", PathfinderGoalSelector.class, this.targetSelector); targetB.clear();
        List targetC = (List)getPrivateField("c", PathfinderGoalSelector.class, this.targetSelector); targetC.clear();
	}
	
	@Override
    public void g(double x, double y, double z){
        return;
    }
    
	@Override
	public void m(){
		super.m();
		this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.0D);
		this.getAttributeInstance(GenericAttributes.maxHealth).setValue(Double.MAX_VALUE);
		this.getAttributeInstance(GenericAttributes.c).setValue(Double.MAX_VALUE);
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
