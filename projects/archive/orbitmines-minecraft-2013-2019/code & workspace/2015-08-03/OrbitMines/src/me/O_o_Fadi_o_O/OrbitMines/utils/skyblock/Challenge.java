package me.O_o_Fadi_o_O.OrbitMines.utils.skyblock;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;

public class Challenge {

	private int challengeid;
	private ItemData item;
	private List<ItemData> requirements;
	private List<ItemData> rewards;
	private List<Challenge> required;
	private int[] requiredids;
	
	public Challenge(int challengeid, ItemData item, List<ItemData> requirements, List<ItemData> rewards, int... required){
		this.challengeid = challengeid;
		this.item = item;
		this.requirements = requirements;
		this.rewards = rewards;
		this.requiredids = required;
		this.required = new ArrayList<Challenge>();
	}
	
	public int getChallengeID() {
		return challengeid;
	}
	
	public ItemData getItem() {
		return item;
	}
	public void setItem(ItemData item) {
		this.item = item;
	}

	public List<ItemData> getRequirements() {
		return requirements;
	}
	public void setRequirements(List<ItemData> requirements) {
		this.requirements = requirements;
	}

	public List<ItemData> getRewards() {
		return rewards;
	}
	public void setRewards(List<ItemData> rewards) {
		this.rewards = rewards;
	}

	public List<Challenge> getRequired() {
		return required;
	}
	public void setRequired(List<Challenge> required) {
		this.required = required;
	}
	
	public void updateRequired(){
		if(requiredids != null){
			for(int i : requiredids){
				Challenge c = Challenge.getChallenge(i);
				this.required.add(c);
			}
		}
	}
	
	public boolean canComplete(SkyBlockPlayer sbp){
		for(Challenge c : this.required){
			if(sbp.getChallengeCompleted(c) == 0){
				return false;
			}
		}
		return true;
	}
	
	public static List<Challenge> getChallenges(){
		return ServerData.getSkyBlock().getChallenges();
	}
	
	public static Challenge getChallenge(int challengeid){
		for(Challenge c : ServerData.getSkyBlock().getChallenges()){
			if(c.getChallengeID() == challengeid){
				return c;
			}
		}
		return null;
	}
	
	public static Challenge addChallenge(int challengeid, ItemData item, List<ItemData> requirements, List<ItemData> rewards, int... required){
		Challenge c = new Challenge(challengeid, item, requirements, rewards, required);
		ServerData.getSkyBlock().getChallenges().add(c);
		return c;
	}
}
