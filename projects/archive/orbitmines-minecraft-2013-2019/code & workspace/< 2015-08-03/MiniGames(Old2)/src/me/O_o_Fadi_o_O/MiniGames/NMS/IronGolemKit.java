package me.O_o_Fadi_o_O.MiniGames.NMS;

import net.minecraft.server.v1_7_R3.EntityIronGolem;
import net.minecraft.server.v1_7_R3.GenericAttributes;
import net.minecraft.server.v1_7_R3.World;

public class IronGolemKit extends EntityIronGolem {

	public IronGolemKit(World world) {
		super(world);
	}
	
	@Override
    public void g(double x, double y, double z){
        return;
    }
	
	@Override
	protected void aC(){
		super.aC();
		// Make his walk speed 0 so he doesn't walk around on his own
		this.getAttributeInstance(GenericAttributes.d).setValue(0.0D);
		// Make his health to max a double can be
		this.getAttributeInstance(GenericAttributes.a).setValue(Double.MAX_VALUE);
		// Make his knockback resistance max double can be
		this.getAttributeInstance(GenericAttributes.c).setValue(Double.MAX_VALUE);
	}
}
