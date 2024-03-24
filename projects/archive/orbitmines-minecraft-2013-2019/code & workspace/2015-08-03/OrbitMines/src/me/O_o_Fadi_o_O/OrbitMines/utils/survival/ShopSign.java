package me.O_o_Fadi_o_O.OrbitMines.utils.survival;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalUtils.ShopType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ShopSign {

	private UUID uuid;
	private Location location;
	private int materialid;
	private short durability;
	private ShopType shoptype;
	private int amount;
	private int price;
	
	public ShopSign(UUID uuid, Location location, int materialid, short durability, ShopType shoptype, int amount, int price){
		this.uuid = uuid;
		this.location = location;
		this.materialid = materialid;
		this.durability = durability;
		this.shoptype = shoptype;
		this.amount = amount;
		this.price = price;
	}

	public UUID getUUID() {
		return uuid;
	}

	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getMaterialID() {
		return materialid;
	}

	public void setMaterialID(int materialid) {
		this.materialid = materialid;
	}

	public short getDurability() {
		return durability;
	}

	public void setDurability(short durability) {
		this.durability = durability;
	}

	public ShopType getShopType() {
		return shoptype;
	}

	public void setShopType(ShopType shoptype) {
		this.shoptype = shoptype;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@SuppressWarnings("deprecation")
	public void buyItems(OMPlayer omp){
		Player p = omp.getPlayer();
		Material m = Material.getMaterial(this.materialid);
		Chest chest = getChest();

		List<ItemStack> items = new ArrayList<ItemStack>();
		for(ItemStack item : chest.getInventory().getContents()){
			if(item != null && item.getType() == m && item.getDurability() == this.durability){
				chest.getInventory().remove(item);
				items.add(item);
			}
		}
		List<ItemStack> itemstoremove = new ArrayList<ItemStack>();
		List<ItemStack> itemstoadd = new ArrayList<ItemStack>();
		
		int amount = 0;
		for(ItemStack item : items){
			if(amount != this.amount){
				if(amount + item.getAmount() <= this.amount){
					p.getInventory().addItem(item);
					itemstoremove.add(item);
					
					amount += item.getAmount();
				}
				else{
					ItemStack item2 = new ItemStack(item);
					item2.setAmount(this.amount - amount);
					p.getInventory().addItem(item2);
					itemstoremove.add(item);
					
					ItemStack item3 = new ItemStack(item);
					item3.setAmount(item.getAmount() - (this.amount - amount));
					itemstoadd.add(item3);
					
					amount = this.amount;
				}
			}
		}
		
		for(ItemStack item : itemstoremove){
			items.remove(item);
		}
		for(ItemStack item : itemstoadd){
			items.add(item);
		}
		
		chest.getInventory().addItem(items.toArray(new ItemStack[items.size()]));
		
		omp.updateInventory();
		if(ServerData.isServer(Server.SURVIVAL)){
			omp.getSurvivalPlayer().removeMoney(this.price);
		}
		else{
			omp.getPrisonPlayer().removeGold(this.price);
		}
		
		String currency = "$";
		if(ServerData.isServer(Server.PRISON)){
			currency = " Gold";
		}
		
		Player p2 = Utils.getPlayer(this.uuid);
		if(p2 != null){
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp2 = OMPlayer.getOMPlayer(p2).getSurvivalPlayer();
				sp2.addMoney(this.price);
			}
			else{
				PrisonPlayer pp2 = OMPlayer.getOMPlayer(p2).getPrisonPlayer();
				pp2.addGold(this.price);
			}

			p.sendMessage("§7You've bought §6" + new SurvivalUtils().getMaterialName(m) + "§7(§6" + this.amount + "§7) from §6" + p2.getName() + " §7for §6" + this.price + currency + "§7.");
			p2.sendMessage("§6" + p.getName() + "§7 bought §6" + new SurvivalUtils().getMaterialName(m) + "§7(§6" + this.amount + "x§7) from you for §6" + this.price + currency + "§7.");
		}
		else{
			p.sendMessage("§7You've bought §6" + new SurvivalUtils().getMaterialName(m) + "§7(§6" + this.amount + "§7) from §6" + Utils.getName(this.uuid) + " §7for §6" + this.price + currency + "§7.");
			
			if(ServerData.isServer(Server.SURVIVAL)){
				Database.get().update("Survival-Money", "money", "" + (getMoneyOffline() + this.price), "uuid", this.uuid.toString());
			}
			else{
				Database.get().update("Prison-Gold", "gold", "" + (getMoneyOffline() + this.price), "uuid", this.uuid.toString());
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void sellItems(OMPlayer omp){
		Player p = omp.getPlayer();
		Material m = Material.getMaterial(this.materialid);
		Chest chest = getChest();

		List<ItemStack> items = new ArrayList<ItemStack>();
		for(ItemStack item : p.getInventory().getContents()){
			if(item != null && item.getType() == m && item.getDurability() == this.durability){
				p.getInventory().remove(item);
				items.add(item);
			}
		}
		List<ItemStack> itemstoremove = new ArrayList<ItemStack>();
		List<ItemStack> itemstoadd = new ArrayList<ItemStack>();
		
		int amount = 0;
		for(ItemStack item : items){
			if(amount != this.amount){
				if(amount + item.getAmount() <= this.amount){
					chest.getInventory().addItem(item);
					itemstoremove.add(item);
					
					amount += item.getAmount();
				}
				else{
					ItemStack item2 = new ItemStack(item);
					item2.setAmount(this.amount - amount);
					chest.getInventory().addItem(item2);
					itemstoremove.add(item);
					
					ItemStack item3 = new ItemStack(item);
					item3.setAmount(item.getAmount() - (this.amount - amount));
					itemstoadd.add(item3);
					
					amount = this.amount;
				}
			}
		}
		
		for(ItemStack item : itemstoremove){
			items.remove(item);
		}
		for(ItemStack item : itemstoadd){
			items.add(item);
		}
		
		p.getInventory().addItem(items.toArray(new ItemStack[items.size()]));
		
		omp.updateInventory();
		if(ServerData.isServer(Server.SURVIVAL)){
			omp.getSurvivalPlayer().addMoney(this.price);
		}
		else{
			omp.getPrisonPlayer().addGold(this.price);
		}
		
		String currency = "$";
		if(ServerData.isServer(Server.PRISON)){
			currency = " Gold";
		}
		
		Player p2 = Utils.getPlayer(this.uuid);
		if(p2 != null){
			if(ServerData.isServer(Server.SURVIVAL)){
				SurvivalPlayer sp2 = OMPlayer.getOMPlayer(p2).getSurvivalPlayer();
				sp2.removeMoney(this.price);
			}
			else{
				PrisonPlayer pp2 = OMPlayer.getOMPlayer(p2).getPrisonPlayer();
				pp2.removeGold(this.price);
			}

			omp.getPlayer().sendMessage("§7You've sold §6" + new SurvivalUtils().getMaterialName(m) + "§7(§6" + this.amount + "§7) to §6" + p2.getName() + " §7for §6" + this.price + currency + "§7.");
			p2.sendMessage("§6" + omp.getPlayer().getName() + "§7 sold §6" + new SurvivalUtils().getMaterialName(m) + "§7(§6" + this.amount + "x§7) to you for §6" + this.price + currency + "§7.");
		}
		else{
			omp.getPlayer().sendMessage("§7You've sold §6" + new SurvivalUtils().getMaterialName(m) + "§7(§6" + this.amount + "§7) to §6" + Utils.getName(this.uuid) + " §7for §6" + this.price + currency + "§7.");
			
			if(ServerData.isServer(Server.SURVIVAL)){
				Database.get().update("Survival-Money", "money", "" + (getMoneyOffline() - this.price), "uuid", this.uuid.toString());
			}
			else{
				Database.get().update("Prison-Gold", "gold", "" + (getMoneyOffline() - this.price), "uuid", this.uuid.toString());
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean isSold(){
		Chest chest = getChest();
		int amount = 0;
		
		for(ItemStack item : chest.getInventory().getContents()){
			if(item != null && item.getType() == Material.getMaterial(this.materialid) && item.getDurability() == this.durability){
				amount += item.getAmount();
			}
		}
		
		return amount < this.amount;
	}
	
	@SuppressWarnings("deprecation")
	public boolean canSell(){
		return Utils.getEmptySlots(getChest().getInventory()) >= Utils.getSlotsRequired(this.amount, Material.getMaterial(this.materialid));
	}
	
	public Chest getChest(){
		return new SurvivalUtils().getChestShop(this.location.getWorld().getBlockAt(this.location));
	}
	
	@SuppressWarnings("deprecation")
	public void update(){
		Block b = this.location.getWorld().getBlockAt(this.location);
		
		if(b != null && (b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN)){
			String currency = "$";
			if(ServerData.isServer(Server.PRISON)){
				currency = " G";
			}
			
			String[] lines = new String[4];
			if(this.shoptype == ShopType.BUY){
				lines[0] = this.shoptype.getStatusName(isSold());
			}
			else{
				lines[0] = this.shoptype.getStatusName(!canSell());
			}
			lines[1] = new SurvivalUtils().getMaterialName(Material.getMaterial(this.materialid));
			lines[2] = this.amount + " : " + this.price + currency;
			lines[3] = Utils.getName(this.uuid);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld().getName().equals(this.location.getWorld().getName()) && this.location.distance(p.getLocation()) <= 16){
					p.sendSignChange(this.location, lines);
				}
			}
		}
		else{
			delete();
		}
	}
	
	public boolean hasMoney(){
		Player p = Utils.getPlayer(this.uuid);
		
		if(p != null){
			return OMPlayer.getOMPlayer(p).getSurvivalPlayer().hasMoney(this.price);
		}
		return getMoneyOffline() >= this.price;
	}
	
	public int getMoneyOffline(){
		return Database.get().getInt("Survival-Money", "money", "uuid", this.uuid.toString());
	}
	
	public boolean hasGold(){
		Player p = Utils.getPlayer(this.uuid);
		
		if(p != null){
			return OMPlayer.getOMPlayer(p).getPrisonPlayer().hasGold(this.price);
		}
		return getGoldOffline() >= this.price;
	}
	
	public int getGoldOffline(){
		return Database.get().getInt("Prison-Gold", "money", "uuid", this.uuid.toString());
	}
	
	public void delete(){
		new BukkitRunnable(){
			public void run(){
				Player p = Utils.getPlayer(getUUID());
				
				if(p != null){
					if(ServerData.isServer(Server.SURVIVAL)){
						OMPlayer.getOMPlayer(p).getSurvivalPlayer().getShopSigns().remove(this);
					}
					else{
						OMPlayer.getOMPlayer(p).getPrisonPlayer().getShopSigns().remove(this);
					}
				}
				getShopSigns().remove(this);
				saveToConfig();
			}
		}.runTaskLater(Start.getInstance(), 1);
	}
	
	public static List<ShopSign> getShopSigns(Player player){
		List<ShopSign> signs = new ArrayList<ShopSign>();
		
		for(ShopSign sign : getShopSigns()){
			if(sign.getUUID().toString().equals(player.getUniqueId().toString())){
				signs.add(sign);
			}
		}
		return signs;
	}
	
	public static List<ShopSign> readFromConfig(){
		List<ShopSign> signs = new ArrayList<ShopSign>();
		
		for(String signstring : ConfigManager.chestshops.getStringList("signs")){
			String[] signparts = signstring.split("\\;");
			
			signs.add(new ShopSign(UUID.fromString(signparts[6]), Utils.getLocationFromString(signparts[0]), Integer.parseInt(signparts[1]), Short.parseShort(signparts[2]), ShopType.valueOf(signparts[3]), Integer.parseInt(signparts[4]), Integer.parseInt(signparts[5])));
		}
		return signs;
	}
	
	public static void saveToConfig(){
		List<String> signs = new ArrayList<String>();
		
		for(ShopSign sign : getShopSigns()){
			signs.add(Utils.getStringFromLocation(sign.getLocation()) + ";" + sign.getMaterialID() + ";" + sign.getDurability() + ";" + sign.getShopType().toString() + ";" + sign.getAmount() + ";" + sign.getPrice() + ";" + sign.getUUID().toString());
		}
		
		ConfigManager.chestshops.set("signs", signs);
		ConfigManager.saveChestShops();
	}
	
	public static List<ShopSign> getShopSigns(){
		if(ServerData.isServer(Server.SURVIVAL)){
			return ServerData.getSurvival().getShopSigns();
		}
		else{
			return ServerData.getPrison().getShopSigns();
		}
	}
	
	public static ShopSign getShopSign(Location location){
		for(ShopSign sign : getShopSigns()){
			Location l = sign.getLocation();
			if(l.getBlockX() == location.getBlockX() && l.getBlockY() == location.getBlockY() && l.getBlockZ() == location.getBlockZ()){
				return sign;
			}
		}
		return null;
	}
}
