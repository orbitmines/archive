package me.O_o_Fadi_o_O.SpigotSpleef;

import net.minecraft.server.v1_8_R2.NBTTagByte;
import net.minecraft.server.v1_8_R2.NBTTagCompound;

import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class CustomItem {

    public static ItemStack hideFlags(ItemStack item, int... hideflags){
	    try{
	        net.minecraft.server.v1_8_R2.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
	
	        NBTTagCompound tag = new NBTTagCompound();
	        
	        if(nmsStack.hasTag()){
	        	tag = nmsStack.getTag();
	        }
	        
	        int hide = 0;
	        
	        for(int i : hideflags){
	        	hide = hide + i;
	        }
	        
	        if(hide != 0){
	        	tag.set("HideFlags", new NBTTagByte((byte) hide));
	    		nmsStack.setTag(tag);
	        }
	       
	        return CraftItemStack.asCraftMirror(nmsStack);
    	}catch(NullPointerException ex){}
    	return item;
    }
    
    public static ItemStack setUnbreakable(ItemStack item){
    	try{
    		net.minecraft.server.v1_8_R2.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);

	        NBTTagCompound tag = new NBTTagCompound();
	        
	        if(nmsStack.hasTag()){
	        	tag = nmsStack.getTag();
	        }
	     
	        tag.set("Unbreakable", new NBTTagByte((byte) 1));
	    	nmsStack.setTag(tag);
	       
	        return CraftItemStack.asCraftMirror(nmsStack);
    	}catch(NullPointerException ex){}
    	return item;
    }
}