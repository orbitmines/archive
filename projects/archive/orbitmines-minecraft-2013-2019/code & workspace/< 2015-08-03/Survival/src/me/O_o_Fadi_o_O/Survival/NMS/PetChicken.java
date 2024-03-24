package me.O_o_Fadi_o_O.Survival.NMS;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R1.EntityChicken;
import net.minecraft.server.v1_8_R1.EntityHuman;
import net.minecraft.server.v1_8_R1.EntityLiving;
import net.minecraft.server.v1_8_R1.World;

public class PetChicken extends EntityChicken {

	public PetChicken(World world) {
		super(world);
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
	 
	    sideMot = (float) (((EntityLiving) this.passenger).aX * 0.5F);
	    forMot = (float) ((EntityLiving) this.passenger).aY;
	    
	    if (forMot <= 0.0F) {
	        forMot *= 0.25F;
	    }
	    sideMot *= 0.75F;
	 
	    float speed = 0.35F;
	    this.aF = speed;
	    super.g(sideMot, forMot);
	 
	    Field jump = null;
	    try {
			jump = EntityLiving.class.getDeclaredField("aW");
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	    jump.setAccessible(true);
	 
	    if (jump != null && this.onGround) {
	        try {
	            if (jump.getBoolean(this.passenger)) {
	                double jumpHeight = 0.5D;
	                this.motY = jumpHeight;
	            }
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        }
	    }
	} 
}
