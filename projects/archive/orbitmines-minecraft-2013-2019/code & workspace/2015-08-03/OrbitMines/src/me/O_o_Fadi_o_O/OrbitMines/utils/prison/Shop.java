package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class Shop {

	private int shopid;
	private Location signlocation;
	private List<Block> blocks;
	private UUID owner;
	private String ownername;
	private String owneruntil;
	
	public Shop(int shopid, Location signlocation, List<Block> blocks, List<Block> nointeract1, List<Block> nointeract2){
		this.shopid = shopid;
		this.signlocation = signlocation;
		this.blocks = blocks;
		this.blocks.removeAll(nointeract1);
		this.blocks.removeAll(nointeract2);
		
		if(ConfigManager.shops.contains("shops." + getShopID())){
			this.owner = UUID.fromString(ConfigManager.shops.getString("shops." + getShopID() + ".Owner"));
			this.owneruntil = ConfigManager.shops.getString("shops." + getShopID() + ".Until");
			
			if(!canRent() && expired()){
				expire();
			}
		}
	}

	public int getShopID() {
		return shopid;
	}
	public void setShopID(int shopid) {
		this.shopid = shopid;
	}

	public Location getSignLocation() {
		return signlocation;
	}
	public void setSignLocation(Location signlocation) {
		this.signlocation = signlocation;
	}

	public List<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public UUID getOwner() {
		return owner;
	}
	public void setOwner(UUID owner) {
		this.owner = owner;
		
		ConfigManager.shops.set("shops." + getShopID() + ".Owner", getOwner().toString());
		ConfigManager.saveShops();
	}

	public String getOwnerUntil() {
		return owneruntil;
	}
	public void setOwnerUntil(String owneruntil) {
		this.owneruntil = owneruntil;
		
		ConfigManager.shops.set("shops." + getShopID() + ".Until", getOwnerUntil());
		ConfigManager.saveShops();
	}
	public String getOwnerUntilForSign(){
		return getOwnerUntil().substring(0, 5) + getOwnerUntil().substring(10);
	}

	public String getOwnerName() {
		if(owner != null && ownername == null){
			ownername = Utils.getName(getOwner());
		}
		return ownername;
	}
	public void setOwnerName(String ownername) {
		this.ownername = ownername;
	}
	
	public boolean isInShop(Location l){
		for(Block b : getBlocks()){
			if(Utils.equals(l, b.getLocation())){
				return true;
			}
		}
		return false;
	}
	
	public boolean canRent(){
		return getOwner() == null;
	}
	
	public void rent(OMPlayer omp){
		Calendar until = Calendar.getInstance();
		until.add(Calendar.DATE, 2);
		
        setOwnerUntil(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(until.getTimeInMillis())));
		setOwner(omp.getUUID());
		
		omp.getPrisonPlayer().setShop(this);
		updateSign();
	}
	
	public boolean expired(){
		try{
			return new Date(Calendar.getInstance().getTimeInMillis()).compareTo(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(getOwnerUntil())) >= 0;
		}catch(ParseException ex){
			return false;
		}
	}
	
	public void expire(){
		Player p = Utils.getPlayer(getOwner());
		
		if(p != null){
			OMPlayer.getOMPlayer(p).getPrisonPlayer().setShop(null);
			p.sendMessage("§7Your Shop expired!");
		}
		
		this.owner = null;
		this.owneruntil = null;
		
		ConfigManager.shops.set("shops." + getShopID(), null);
		ConfigManager.saveShops();
		
		for(Block b : getBlocks()){
			if(b.getState() instanceof Chest){
				Chest c = (Chest) b.getState();
				c.getInventory().clear();
			}
			
			for(Entity en : b.getWorld().getEntitiesByClass(ItemFrame.class)){
				if(en.getLocation().distance(b.getLocation().add(0.5, 0.5, 0.5)) <= 0.5){
					en.remove();
				}
			}
			
			b.setType(Material.AIR);
		}
	}
	
	public void addDays() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date d = null;
		try{
			d = df.parse(getOwnerUntil());
		}catch(ParseException ex){}
        
		Calendar until = Calendar.getInstance();
		until.setTimeInMillis(d.getTime());
		until.add(Calendar.DATE, 2);
        
        setOwnerUntil(df.format(new Date(until.getTimeInMillis())));
        updateSign();
	}
	
	public void updateSign(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getWorld().getName().equals(getSignLocation().getWorld().getName()) && p.getLocation().distance(getSignLocation()) <= 16){
				String[] lines = new String[4];
				lines[0] = "§lShop " + getShopID();
				
				if(canRent()){
					lines[1] = "§o2 Days";
					lines[2] = "5000 Gold";
					if(OMPlayer.getOMPlayer(p).getPrisonPlayer().hasGold(5000)){
						lines[3] = "§2§lClick to Rent";
					}
					else{
						lines[3] = "§4§lClick to Rent";
					}
				}
				else{
					if(getOwner().toString().equals(p.getUniqueId().toString())){
						lines[1] = "§o+2 Days";
						if(OMPlayer.getOMPlayer(p).getPrisonPlayer().hasGold(5000)){
							lines[2] = "§2§lClick to Add";
						}
						else{
							lines[2] = "§4§lClick to Add";
						}
						lines[3] = "§o" + getOwnerUntilForSign();
					}
					else{
						lines[1] = getOwnerName();
						lines[2] = "";
						lines[3] = "§o" + getOwnerUntilForSign();
					}
				}
				
				p.sendSignChange(getSignLocation(), lines);
			}
		}
	}
	
	public static Shop getShop(UUID owner){
		for(Shop shop : ServerData.getPrison().getShops()){
			if(shop.getOwner() != null && shop.getOwner().toString().equals(owner.toString())){
				return shop;
			}
		}
		return null;
	}
	public static Shop getShop(Location signlocation){
		for(Shop shop : ServerData.getPrison().getShops()){
			if(Utils.equals(shop.getSignLocation(), signlocation)){
				return shop;
			}
		}
		return null;
	}
}
