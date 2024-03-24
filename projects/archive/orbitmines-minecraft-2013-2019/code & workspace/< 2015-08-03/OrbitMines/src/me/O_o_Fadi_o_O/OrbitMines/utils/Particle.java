package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Particle {
		
	private EnumParticle enumparticle;
	private Location location;
	private boolean positiv;
	private double xadded;
	private double yadded;
	private double zadded;
	private int xsize;
	private int ysize;
	private int zsize;
	private int special;
	private int amount;
	private int index;
	
	public Particle(EnumParticle enumparticle){
		this.enumparticle = enumparticle;
		this.xadded = 0;
		this.yadded = 0;
		this.zadded = 0;
		this.xsize = 0;
		this.ysize = 0;
		this.zsize = 0;
		this.special = 0;
		this.amount = 1;
	}
	public Particle(EnumParticle enumparticle, Location location){
		this.enumparticle = enumparticle;
		this.location = location;
		this.xadded = 0;
		this.yadded = 0;
		this.zadded = 0;
		this.xsize = 0;
		this.ysize = 0;
		this.zsize = 0;
		this.special = 0;
		this.amount = 1;
	}

	public EnumParticle getEnumParticle(){
		return enumparticle;
	}
	public void setEnumParticle(EnumParticle enumparticle){
		this.enumparticle = enumparticle;
	}
	
	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	
	public boolean isPositiv() {
		return positiv;
	}
	public void setPositiv(boolean positiv) {
		this.positiv = positiv;
	}
	
	public void add(double x, double y, double z){
		this.location.add(x, y, z);
	}
	
	public void subtract(double x, double y, double z){
		this.location.subtract(x, y, z);
	}

	public double getX(){
		return this.location.getX();
	}
	public void setX(double x){
		this.location.setX(x);
	}
	public void addX(double xadded){
		this.xadded += xadded;
	}

	public double getY(){
		return this.location.getY();
	}
	public void setY(double y){
		this.location.setX(y);
	}
	public void addY(double yadded){
		this.yadded += yadded;
	}

	public double getZ(){
		return this.location.getZ();
	}
	public void setZ(double z){
		this.location.setX(z);
	}
	public void addZ(double zadded){
		this.zadded += zadded;
	}
	
	public double getXAdded(){
		return xadded;
	}
	public void setXAdded(double xadded){
		this.xadded = xadded;
	}
	
	public double getYAdded(){
		return yadded;
	}
	public void setYAdded(double yadded){
		this.yadded = yadded;
	}
	
	public double getZAdded(){
		return zadded;
	}
	public void setZAdded(double zadded){
		this.zadded = zadded;
	}

	public void setSize(int xsize, int ysize, int zsize){
		this.xsize = xsize;
		this.ysize = ysize;
		this.zsize = zsize;
	}

	public int getXSize(){
		return xsize;
	}

	public int getYSize(){
		return ysize;
	}

	public int getZSize(){
		return zsize;
	}

	public int getSpecial(){
		return special;
	}
	public void setSpecial(int special){
		this.special = special;
	}

	public int getAmount(){
		return amount;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getIndex(){
		return index;
	}
	public void setIndex(int index){
		this.index = index;
	}

	public void send(Player... players){
		try{
			for(Player player : players){
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(getEnumParticle(), true, (float) (getX() + getXAdded()), (float) (getY() + getYAdded()), (float) (getZ() + getZAdded()), getXSize(), getYSize(), getZSize(), getSpecial(), getAmount(), null));
			}
		}catch(InstantiationException | IllegalAccessException| IllegalArgumentException | InvocationTargetException| NoSuchMethodException | SecurityException e){}
	}
	
	public void send(List<Player> players){
		try{
			for(Player player : players){
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(getEnumParticle(), true, (float) (getX() + getXAdded()), (float) (getY() + getYAdded()), (float) (getZ() + getZAdded()), getXSize(), getYSize(), getZSize(), getSpecial(), getAmount(), null));
			}
		}catch(InstantiationException | IllegalAccessException| IllegalArgumentException | InvocationTargetException| NoSuchMethodException | SecurityException e){}
	}
	
	public void send(Collection<? extends Player> players){
		try{
			for(Player player : players){
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(getEnumParticle(), true, (float) (getX() + getXAdded()), (float) (getY() + getYAdded()), (float) (getZ() + getZAdded()), getXSize(), getYSize(), getZSize(), getSpecial(), getAmount(), null));
			}
		}catch(InstantiationException | IllegalAccessException| IllegalArgumentException | InvocationTargetException| NoSuchMethodException | SecurityException e){}
	}
	public void sendOposite(Collection<? extends Player> players){
		try{
			for(Player player : players){
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(getEnumParticle(), true, (float) (getX() - getXAdded()), (float) (getY() + getYAdded()), (float) (getZ() - getZAdded()), getXSize(), getYSize(), getZSize(), getSpecial(), getAmount(), null));
			}
		}catch(InstantiationException | IllegalAccessException| IllegalArgumentException | InvocationTargetException| NoSuchMethodException | SecurityException e){}
	}
}
