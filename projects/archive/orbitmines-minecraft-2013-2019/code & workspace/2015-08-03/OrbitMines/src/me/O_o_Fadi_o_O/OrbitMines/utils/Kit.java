package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

public class Kit {

	private String kitname;
	private ItemStack[] armorcontents;
	private ItemStack[] contents;
	private List<List<ItemStack>> randomitems;
	
	private PotionEffect potioneffect;
	
	public Kit(String kitname){
		this.kitname = kitname;
		this.armorcontents = new ItemStack[4];
		this.contents = new ItemStack[36];
		this.randomitems = new ArrayList<List<ItemStack>>();
		for(int i = 0; i < 36; i++){
			this.randomitems.add(new ArrayList<ItemStack>());
		}
		
		ServerStorage.kits.add(this);
	}

	public String getKitName() {
		return kitname;
	}

	public void setKitName(String kitname) {
		this.kitname = kitname;
	}

	public ItemStack getHelmet() {
		return this.armorcontents[3];
	}

	public void setHelmet(ItemStack helmet) {
		this.armorcontents[3] = helmet;
	}

	public ItemStack getChestplate() {
		return this.armorcontents[2];
	}

	public void setChestplate(ItemStack chestplate) {
		this.armorcontents[2] = chestplate;
	}

	public ItemStack getLeggings() {
		return this.armorcontents[1];
	}

	public void setLeggings(ItemStack leggings) {
		this.armorcontents[1] = leggings;
	}

	public ItemStack getBoots() {
		return this.armorcontents[0];
	}

	public void setBoots(ItemStack boots) {
		this.armorcontents[0] = boots;
	}
	
	public ItemStack[] getArmorContents() {
		return armorcontents;
	}

	public void setArmorContents(ItemStack[] armorcontents) {
		this.armorcontents = armorcontents;
	}

	public ItemStack[] getContents() {
		return contents;
	}

	public void setContents(ItemStack[] contents) {
		this.contents = contents;
	}
	
	public void setItem(int index, ItemStack content) {
		this.contents[index] = content;
	}

	public ItemStack getItem(int index) {
		return this.contents[index];
	}
	
	public ItemStack getFirstItem(){
		for(ItemStack item : this.contents){
			if(item != null){
				return item;
			}
		}
		return null;
	}

	public List<List<ItemStack>> getRandomItems() {
		return randomitems;
	}

	public void setRandomItems(List<List<ItemStack>> randomitems) {
		this.randomitems = randomitems;
	}
	
	public void setRandomItem(int index, List<ItemStack> content) {
		this.randomitems.set(index, content);
	}

	public List<ItemStack> getRandomItem(int index) {
		return this.randomitems.get(index);
	}
	
	public int contentItems(){
		int amount = 0;
		for(ItemStack item : getContents()){
			if(item != null){
				amount++;
			}
		}
		return amount;
	}

	public PotionEffect getPotionEffect() {
		return potioneffect;
	}

	public void setPotionEffect(PotionEffect potioneffect) {
		this.potioneffect = potioneffect;
	}
	
	public void setItems(Player p){
		for(ItemStack item : getContents()){
			if(item != null && item.getType() == Material.SKULL_ITEM && item.getDurability() == (short) 3){
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setOwner(p.getName());
				item.setItemMeta(meta);
			}
		}
		
		p.getInventory().setArmorContents(getArmorContents());
		p.getInventory().setContents(getContents());
		
		int index = 0;
		for(List<ItemStack> items : getRandomItems()){
			if(items != null && items.size() > 0){
				p.getInventory().setItem(index, items.get(new Random().nextInt(items.size())));
			}
			index++;
		}

		if(getPotionEffect() != null){
			p.addPotionEffect(getPotionEffect());
		}
	}
	
	public void addItems(Player p){
		for(ItemStack item : getContents()){
			if(item != null){
				p.getInventory().addItem(item);
			}
		}
		int index = 0;
		for(ItemStack item : getArmorContents()){
			ItemStack item2 = p.getInventory().getArmorContents()[index];
			
			if(item2 != null){
				p.getInventory().addItem(item2);
			}
			
			if(index == 0){
				p.getInventory().setBoots(item);
			}
			else if(index == 1){
				p.getInventory().setLeggings(item);
			}
			else if(index == 2){
				p.getInventory().setChestplate(item);
			}
			else{
				p.getInventory().setHelmet(item);
			}
			
			index++;
		}
		
		if(getPotionEffect() != null){
			p.addPotionEffect(getPotionEffect());
		}
	}
	
	public static List<Kit> getKits(){
		return ServerStorage.kits;
	}
	
	public static Kit getKit(String kitname){
		for(Kit kit : ServerStorage.kits){
			if(kit.getKitName().equals(kitname)){
				return kit;
			}
		}
		return null;
	}
	
	public void saveToConfig(FileConfiguration file, String path){
		int index = 0;
		for(ItemStack item : getArmorContents()){
			if(item != null){
				file.set(path + ".ArmorContents." + index, Utils.getStringFromItemStack(item));
			}
			index++;
		}
		index = 0;
		for(ItemStack item : getContents()){
			if(item != null){
				file.set(path + ".Contents." + index, Utils.getStringFromItemStack(item));
			}
			index++;
		}
	}
	
	public void saveToConfig(FileConfiguration file, String path, Material... bannedmaterials){
		int index = 0;
		for(ItemStack item : getArmorContents()){
			boolean clear = false;
			
			if(item != null){
				for(Material bannedmaterial : bannedmaterials){
					if(item.getType() == bannedmaterial){
						clear = true;
					}
				}
				
				if(!clear){
					file.set(path + ".ArmorContents." + index, Utils.getStringFromItemStack(item));
				}
			}
			else{
				clear = true;
			}
			
			if(clear){
				file.set(path + ".ArmorContents." + index, null);
			}
			index++;
		}
		index = 0;
		for(ItemStack item : getContents()){
			boolean clear = false;
			
			if(item != null){
				for(Material bannedmaterial : bannedmaterials){
					if(item.getType() == bannedmaterial){
						clear = true;
					}
				}
				
				if(!clear){
					file.set(path + ".Contents." + index, Utils.getStringFromItemStack(item));
				}
			}
			else{
				clear = true;
			}
			
			if(clear){
				file.set(path + ".Contents." + index, null);
			}
			index++;
		}
	}
	
	public static Kit getKitFromConfig(String kitname, FileConfiguration file, String path){
		Kit kit = new Kit(kitname);
		for(String stringindex : file.getConfigurationSection(path + ".ArmorContents").getKeys(false)){
			kit.getArmorContents()[Integer.parseInt(stringindex)] = Utils.getItemStackFromString(file.getString(path + ".ArmorContents." + stringindex));
		}
		for(String stringindex : file.getConfigurationSection(path + ".Contents").getKeys(false)){
			kit.getContents()[Integer.parseInt(stringindex)] = Utils.getItemStackFromString(file.getString(path + ".Contents." + stringindex));
		}
		
		return kit;
	}
}
