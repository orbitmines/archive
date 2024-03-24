package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeArena;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ArenaSelectorItemStack {

	private ItemStack itemstack;
	private String displayname;
	private List<String> lore;
	private ItemType itemtype;
	private int arenaid = 0;
	private Arena arena;
	private BungeeArena bungeearena;
	
	public ArenaSelectorItemStack(ItemStack itemstack, String displayname, List<String> lore, ItemType itemtype){
		this.itemstack = itemstack;
		this.displayname = displayname;
		this.lore = lore;
		this.itemtype = itemtype;
	}	
	
	public ArenaSelectorItemStack(ItemType itemtype, int arenaid, Arena arena){
		this.itemtype = itemtype;
		this.arenaid = arenaid;
		this.arena = arena;
	}

	public ItemStack getItemStack(){
		return this.itemstack;
	}
	public void setItemStack(ItemStack itemstack){
		this.itemstack = itemstack;
	}

	public String getDisplayname(){
		return this.displayname;
	}
	public void setDisplayname(String displayname){
		this.displayname = displayname;
	}

	public List<String> getLore(){
		return this.lore;
	}
	public void setLore(List<String> lore){
		this.lore = lore;
	}

	public ItemType getItemType(){
		return this.itemtype;
	}
	public void setItemType(ItemType itemtype){
		this.itemtype = itemtype;
	}

	public int getArenaID(){
		return this.arenaid;
	}
	public void setArenaID(int arenaid){
		this.arenaid = arenaid;
	}

	public Arena getArena(){
		return this.arena;
	}
	public void setArena(Arena arena){
		this.arena = arena;
	}

	public BungeeArena getBungeeArena(){
		return this.bungeearena;
	}
	public void setBungeeArena(final BungeeArena bungeearena){
		this.bungeearena = bungeearena;	
		
		new BukkitRunnable(){
			public void run(){
				setBungeeArena(null);
				List<BungeeArena> arenas = StorageManager.bungeearenas;
				arenas.remove(bungeearena);
				StorageManager.bungeearenas = arenas;
			}
		}.runTaskLater(Start.getInstance(), 40);
	}
	
	public void update(){
		if(getArenaID() != 0){
			if(StorageManager.bungeecord == true){
				if(getBungeeArena() != null){
					if(getBungeeArena().isStatus(SpleefStatus.WAITING) || getBungeeArena().isStatus(SpleefStatus.STARTING)){
						if(getBungeeArena().enoughPlayers()){
							if(getBungeeArena().isFull()){
								updateFull();
							}
							else{
								updateEnoughPlayers();
							}
						}
						else{
							updateWaiting();
						}
					}
					else if(getBungeeArena().isStatus(SpleefStatus.WARMUP) || getBungeeArena().isStatus(SpleefStatus.INGAME)){
						updateInGame();
					}
					else{
						updateRestarting();
					}
				}
				else{
					updateWaiting();
				}
			}
			else if(getArena() != null){
				if(getArena().isStatus(SpleefStatus.WAITING) || getArena().isStatus(SpleefStatus.STARTING)){
					if(getArena().enoughPlayers()){
						if(getArena().isFull()){
							updateFull();
						}
						else{
							updateEnoughPlayers();
						}
					}
					else{
						updateWaiting();
					}
				}
				else if(getArena().isStatus(SpleefStatus.WARMUP) || getArena().isStatus(SpleefStatus.INGAME)){
					updateInGame();
				}
				else{
					updateRestarting();
				}
			}
			else{
				updateRestarting();
			}
		}
		else{
			ItemMeta meta = getItemStack().getItemMeta();
			meta.setDisplayName(getReplacedString(getDisplayname().replace("&", "§")));
			List<String> lore = new ArrayList<String>();
			for(String s : getLore()){
				lore.add(getReplacedString(s.replace("&", "§")));
			}
			meta.setLore(lore);
			getItemStack().setItemMeta(meta);
		}
	}
	
	public void updateWaiting(){
		int amount = Integer.parseInt(StorageManager.npcinvwaitingamount.replace("%players%", "" + 1).replace("%arena-id%", "" + getArenaID()));
		ItemStack item = new ItemStack(StorageManager.npcinvwaitingmaterial, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getReplacedString(StorageManager.npcinvwaitingname.replace("&", "§")));
		List<String> lore = new ArrayList<String>();
		for(String s : StorageManager.npcinvwaitinglore){
			lore.add(getReplacedString(s.replace("&", "§")));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) StorageManager.npcinvwaitingdurability); 
		
		setItemStack(item);
	}
	
	public void updateEnoughPlayers(){
		int amount = Integer.parseInt(StorageManager.npcinvenoughplayersamount.replace("%players%", "" + 1).replace("%arena-id%", "" + getArenaID()));
		ItemStack item = new ItemStack(StorageManager.npcinvenoughplayersmaterial, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getReplacedString(StorageManager.npcinvenoughplayersname.replace("&", "§")));
		List<String> lore = new ArrayList<String>();
		for(String s : StorageManager.npcinvenoughplayerslore){
			lore.add(getReplacedString(s.replace("&", "§")));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) StorageManager.npcinvenoughplayersdurability); 
		
		setItemStack(item);
	}
	
	public void updateFull(){
		int amount = Integer.parseInt(StorageManager.npcinvfullamount.replace("%players%", "" + 1).replace("%arena-id%", "" + getArenaID()));
		ItemStack item = new ItemStack(StorageManager.npcinvfullmaterial, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getReplacedString(StorageManager.npcinvfullname.replace("&", "§")));
		List<String> lore = new ArrayList<String>();
		for(String s : StorageManager.npcinvfulllore){
			lore.add(getReplacedString(s.replace("&", "§")));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) StorageManager.npcinvfulldurability); 
		
		setItemStack(item);
	}
	
	public void updateInGame(){
		int amount = Integer.parseInt(StorageManager.npcinvingameamount.replace("%players%", "" + 1).replace("%arena-id%", "" + getArenaID()));
		ItemStack item = new ItemStack(StorageManager.npcinvingamematerial, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getReplacedString(StorageManager.npcinvingamename.replace("&", "§")));
		List<String> lore = new ArrayList<String>();
		for(String s : StorageManager.npcinvingamelore){
			lore.add(getReplacedString(s.replace("&", "§")));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) StorageManager.npcinvingamedurability); 
		
		setItemStack(item);
	}
	
	public void updateRestarting(){
		int amount = Integer.parseInt(StorageManager.npcinvrestartingamount.replace("%players%", "" + 1).replace("%arena-id%", "" + getArenaID()));
		ItemStack item = new ItemStack(StorageManager.npcinvrestartingmaterial, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getReplacedString(StorageManager.npcinvrestartingname.replace("&", "§")));
		List<String> lore = new ArrayList<String>();
		for(String s : StorageManager.npcinvrestartinglore){
			lore.add(getReplacedString(s.replace("&", "§")));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) StorageManager.npcinvrestartingdurability); 
		
		setItemStack(item);
	}
	
	public String getReplacedString(String s){
		if(StorageManager.bungeecord == true){
			if(getBungeeArena() != null){
				return s.replace("%minutes%", "" + getBungeeArena().getMinutes()).replace("%seconds%", "" + getBungeeArena().getSeconds()).replace("%min-players%", "" + getBungeeArena().getMinPlayers()).replace("%players%", "" + getBungeeArena().getPlayers()).replace("%max-players%", "" + getBungeeArena().getMaxPlayers()).replace("%arena-id%", "" + getArenaID()).replace("%spectators%", "" + getBungeeArena().getSpectators()).replace("%map-name%", getBungeeArena().getMapName()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
			}
			return s.replace("%minutes%", "" + StorageManager.waittimeminutes).replace("%seconds%", "" + StorageManager.waittimeseconds).replace("%min-players%", "" + StorageManager.minplayers).replace("%players%", "" + 0).replace("%max-players%", "" + StorageManager.maxplayers).replace("%arena-id%", "" + getArenaID()).replace("%spectators%", "" + 0).replace("%map-name%", "").replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
		}
		else if(getArena() != null){
			if(getArena().getMap() != null){
				s = s.replace("%map-name%", getArena().getMap().getName());
			}
			return s.replace("%minutes%", "" + getArena().getMinutes()).replace("%seconds%", "" + getArena().getSeconds()).replace("%min-players%", "" + getArena().getMinPlayers()).replace("%players%", "" + getArena().getPlayers().size()).replace("%max-players%", "" + getArena().getMaxPlayers()).replace("%arena-id%", "" + getArenaID()).replace("%spectators%", "" + getArena().getSpectators().size()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
		}
		else{
			return s.replace("%arena-id%", "" + getArenaID()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
		}
	}
}
