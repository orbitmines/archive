package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.NPCType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class NPCArmorStand {

	private Location location;
	private ArmorStand armorstand;
	private NPCType npctype;
	private boolean arms;
	private boolean baseplate;
	private EulerAngle bodypose;
	private EulerAngle headpose;
	private EulerAngle leftarmpose;
	private EulerAngle leftlegpose;
	private EulerAngle rightarmpose;
	private EulerAngle rightlegpose;
	private ItemStack iteminhand;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	private String customname;
	private boolean customnamevisible;
	private int fireticks;
	private boolean gravity;
	private boolean small;
	private boolean visible;
	private Item item;
	private ItemStack itemstack;
	private String itemname;
	private boolean useitem;
	
	public NPCArmorStand(NPCType npctype, Location location){
		this.location = location;
		this.npctype = npctype;
		this.arms = false;
		this.baseplate = false;
		this.bodypose = EulerAngle.ZERO;
		this.headpose = EulerAngle.ZERO;
		this.leftarmpose = EulerAngle.ZERO;
		this.leftlegpose = EulerAngle.ZERO;
		this.rightarmpose = EulerAngle.ZERO;
		this.rightlegpose = EulerAngle.ZERO;
		this.customnamevisible = false;
		this.fireticks = 0;
		this.gravity = true;
		this.small = false;
		this.visible = true;
	}
	
	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	
	public ArmorStand getArmorStand(){
		return armorstand;
	}
	public void setArmorStand(ArmorStand armorstand){
		this.armorstand = armorstand;
	}
	
	public NPCType getNPCType(){
		return npctype;
	}
	public void setNPCType(NPCType npctype){
		this.npctype = npctype;
	}

	public boolean hasArms(){
		return arms;
	}
	public void setArms(boolean arms) {
		this.arms = arms;
	}

	public boolean hasBasePlate(){
		return baseplate;
	}
	public void setBasePlate(boolean baseplate) {
		this.baseplate = baseplate;
	}

	public EulerAngle getBodyPose(){
		return bodypose;
	}
	public void setBodyPose(EulerAngle bodypose) {
		this.bodypose = bodypose;
	}

	public EulerAngle getHeadPose(){
		return headpose;
	}
	public void setHeadPose(EulerAngle headpose) {
		this.headpose = headpose;
	}

	public EulerAngle getLeftArmPose(){
		return leftarmpose;
	}
	public void setLeftArmPose(EulerAngle leftarmpose) {
		this.leftarmpose = leftarmpose;
	}

	public EulerAngle getLeftLegPose(){
		return leftlegpose;
	}
	public void setLeftLegPose(EulerAngle leftlegpose) {
		this.leftlegpose = leftlegpose;
	}

	public EulerAngle getRightArmPose(){
		return rightarmpose;
	}
	public void setRightArmPose(EulerAngle rightarmpose) {
		this.rightarmpose = rightarmpose;
	}

	public EulerAngle getRightLegPose(){
		return rightlegpose;
	}
	public void setRightLegPose(EulerAngle rightlegpose) {
		this.rightlegpose = rightlegpose;
	}

	public ItemStack getItemInHand(){
		return iteminhand;
	}
	public void setItemInHand(ItemStack iteminhand) {
		this.iteminhand = iteminhand;
	}

	public ItemStack getHelmet(){
		return helmet;
	}
	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}

	public ItemStack getChestplate(){
		return chestplate;
	}
	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}

	public ItemStack getLeggings(){
		return leggings;
	}
	public void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}

	public ItemStack getBoots(){
		return boots;
	}
	public void setBoots(ItemStack boots) {
		this.boots = boots;
	}

	public String getCustomName(){
		return customname;
	}
	public void setCustomName(String customname) {
		this.customname = customname;
	}

	public boolean isCustomNameVisible(){
		return customnamevisible;
	}
	public void setCustomNameVisible(boolean customnamevisible) {
		this.customnamevisible = customnamevisible;
	}

	public int getFireTicks(){
		return fireticks;
	}
	public void setFireTicks(int fireticks) {
		this.fireticks = fireticks;
	}

	public boolean isGravity(){
		return gravity;
	}
	public void setGravity(boolean gravity) {
		this.gravity = gravity;
	}

	public boolean isSmall(){
		return small;
	}
	public void setSmall(boolean small) {
		this.small = small;
	}

	public boolean isVisible(){
		return visible;
	}	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Item getItem(){
		return this.item;
	}
	public void setItem(Item item){
		this.item = item;
	}

	public ItemStack getItemStack(){
		return this.itemstack;
	}
	public void setItemStack(ItemStack itemstack){
		this.itemstack = itemstack;
	}

	public String getItemName(){
		return this.itemname;
	}
	public void setItemName(String itemname){
		this.itemname = itemname;
	}

	public boolean hasItem(){
		return this.useitem;
	}
	public void setUseItem(boolean useitem){
		this.useitem = useitem;
	}
	
	public void checkEntity(){
		if(hasItem()){
		    if(getArmorStand().getPassenger() == null){
		    	Item item = getLocation().getWorld().dropItem(location, getItemStack());
		    	item.setPickupDelay(Integer.MAX_VALUE);
		    	if(getItemName() != null){
		    		item.setCustomName(getItemName());
			    	item.setCustomNameVisible(true);
		    	}
			    
		    	getArmorStand().setPassenger(item);
			    setItem(item);
		    }
		    if(getArmorStand() != null){
		    	if(getArmorStand().getLocation().distance(getLocation()) >= 0.1){
		    		getArmorStand().teleport(getLocation());
		    	}
		    }
		}
	}
	
	public void spawn(){
		ArmorStand as = (ArmorStand) getLocation().getWorld().spawnEntity(getLocation(), EntityType.ARMOR_STAND);
		as.setRemoveWhenFarAway(false);
		as.setArms(hasArms());
		as.setBasePlate(hasBasePlate());
		as.setBodyPose(getBodyPose());
		as.setBoots(getBoots());
		as.setChestplate(getChestplate());
		as.setCustomName(getCustomName());
		as.setCustomNameVisible(isCustomNameVisible());
		as.setFireTicks(getFireTicks());
		as.setGravity(isGravity());
		as.setHeadPose(getHeadPose());
		as.setHelmet(getHelmet());
		as.setItemInHand(getItemInHand());
		as.setLeftArmPose(getLeftArmPose());
		as.setLeftLegPose(getLeftLegPose());
		as.setLeggings(getLeggings());
		as.setRightArmPose(getRightArmPose());
		as.setRightLegPose(getRightLegPose());
		as.setSmall(isSmall());
		as.setVisible(isVisible());
		
		setArmorStand(as);
		if(getNPCType() == NPCType.SERVER_SELECTOR){
		    Item item = getLocation().getWorld().dropItem(location, new ItemStack(Material.ENDER_PEARL));
		    item.setPickupDelay(Integer.MAX_VALUE);
		    item.setCustomName("§3§lServer Selector");
		    item.setCustomNameVisible(true);
		    
		    as.setPassenger(item);
			setItem(item);
		}
	}
	
	public void update(){
		ArmorStand as = getArmorStand();
		as.setRemoveWhenFarAway(false);
		as.setArms(hasArms());
		as.setBasePlate(hasBasePlate());
		as.setBodyPose(getBodyPose());
		as.setBoots(getBoots());
		as.setChestplate(getChestplate());
		as.setCustomName(getCustomName());
		as.setCustomNameVisible(isCustomNameVisible());
		as.setFireTicks(getFireTicks());
		as.setGravity(isGravity());
		as.setHeadPose(getHeadPose());
		as.setHelmet(getHelmet());
		as.setItemInHand(getItemInHand());
		as.setLeftArmPose(getLeftArmPose());
		as.setLeftLegPose(getLeftLegPose());
		as.setLeggings(getLeggings());
		as.setRightArmPose(getRightArmPose());
		as.setRightLegPose(getRightLegPose());
		as.setSmall(isSmall());
		as.setVisible(isVisible());
	}
	
	public void delete(){
		if(this.armorstand != null){
			this.armorstand.remove();
		}
		if(this.item != null){
			this.item.remove();
		}
		ServerStorage.armorstands.remove(this);
	}
	
	public static List<NPCArmorStand> getNPCArmorStands(){
		return ServerStorage.asnpcs;
	}
	
	public static NPCArmorStand getNPCArmorStand(ArmorStand armorstand){
		for(NPCArmorStand npcas : ServerStorage.asnpcs){
			if(npcas.getArmorStand() == armorstand){
				return npcas;
			}
		}
		return null;
	}
	
	public static NPCArmorStand getNPCArmorStand(NPCType npctype){
		for(NPCArmorStand npcas : ServerStorage.asnpcs){
			if(npcas.getNPCType() == npctype){
				return npcas;
			}
		}
		return null;
	}
	
	public static NPCArmorStand addNPCArmorStand(NPCType npctype, Location location){
		NPCArmorStand npcas = new NPCArmorStand(npctype, location);
		ServerStorage.asnpcs.add(npcas);
		return npcas;
	}
}
