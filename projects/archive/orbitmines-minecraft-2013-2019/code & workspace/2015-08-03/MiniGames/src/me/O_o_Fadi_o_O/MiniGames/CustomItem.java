package me.O_o_Fadi_o_O.MiniGames;

import net.minecraft.server.v1_8_R1.NBTTagByte;
import net.minecraft.server.v1_8_R1.NBTTagCompound;

import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class CustomItem {

    public static ItemStack hideFlags(ItemStack item, int... hideflags){
        net.minecraft.server.v1_8_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);

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
    }
}