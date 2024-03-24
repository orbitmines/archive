package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;

import org.bukkit.Sound;

public class AbilityMotivier {

	private Ability ability;
	private int cooldown;
	private int power;
	private Sound sound;
	private int maxamount;
	private int duration;
	
	public AbilityMotivier(Ability ability){
		this.setAbility(ability);
	}

	public Ability getAbility(){
		return ability;
	}
	public void setAbility(Ability ability){
		this.ability = ability;
	}

	public int getCooldown(){
		return cooldown;
	}
	public void setCooldown(int cooldown){
		this.cooldown = cooldown;
	}

	public int getPower(){
		return power;
	}
	public void setPower(int power){
		this.power = power;
	}
	
	public Sound getSound(){
		return sound;
	}
	public void setSound(Sound sound){
		this.sound = sound;
	}

	public int getMaxAmount(){
		return maxamount;
	}
	public void setMaxAmount(int maxamount){
		this.maxamount = maxamount;
	}

	public int getDuration(){
		return duration;
	}
	public void setDuration(int duration){
		this.duration = duration;
	}

	public static AbilityMotivier getMotivier(Ability ability){
		for(AbilityMotivier motivier : StorageManager.abilities){
			if(motivier.getAbility() == ability){
				return motivier;
			}
		}
		return null;
	}
}
