package me.O_o_Fadi_o_O.OrbitMines.NMS;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntitySilverfish;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_8_R3.World;

public class PetSilverfish extends EntitySilverfish {

	@SuppressWarnings("rawtypes")
	public PetSilverfish(World world) {
		super(world);
		
        List goalB = (List)getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
        List targetB = (List)getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
	}

	@Override
	public void g(float sideMot, float forMot) {
	    if (this.passenger == null || !(this.passenger instanceof EntityHuman)) {
	        super.g(sideMot, forMot);
	        this.S = 0.5F;
	        return;
	    }
	 
	    this.lastYaw = this.yaw = this.passenger.yaw;
	    this.pitch = this.passenger.pitch * 0.5F;
	 
	    this.setYawPitch(this.yaw, this.pitch);
	    this.aI = this.aG = this.yaw;
	 
	    this.S = 1.0F;
	 
	    sideMot = (float) (((EntityLiving) this.passenger).aZ * 0.5F);
	    forMot = (float) ((EntityLiving) this.passenger).ba;
	    
	    if (forMot <= 0.0F) {
	        forMot *= 0.25F;
	    }
	    sideMot *= 0.75F;
	 
	    float speed = 0.35F;
	    this.aF = speed;
	    super.g(sideMot, forMot);
	 
	    Field jump = null;
	    try{
			jump = EntityLiving.class.getDeclaredField("aY");
		}catch(NoSuchFieldException ex){
			ex.printStackTrace();
		}catch(SecurityException ex){
			ex.printStackTrace();
		}
	    jump.setAccessible(true);
	 
	    if(jump != null && this.onGround){
	        try{
	            if(jump.getBoolean(this.passenger)){
	                double jumpHeight = 0.5D;
	                this.motY = jumpHeight;
	            }
	        }catch(IllegalAccessException ex){
	            ex.printStackTrace();
	        }
	    }
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
