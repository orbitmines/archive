package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ArrowRunnables {

	Start start = Start.getInstance();
	
	public void startArcherArrowRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.kitselected.containsKey(p)){
						if(StorageManager.kitselected.get(p) == KitPlaying.Archer_LvL_1){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lArcher §a§lLvL 1§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 32)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.Archer_LvL_2){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lArcher §a§lLvL 2§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 32)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.Archer_LvL_3){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lArcher §a§lLvL 3§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 32)){
								p.getInventory().addItem(arrow);
							}
						}
					}
				}
				
			}
		}.runTaskTimer(this.start, 0, 20 * 10);
	}
	
	public void startSoldierArrowRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.kitselected.containsKey(p)){
						if(StorageManager.kitselected.get(p) == KitPlaying.Soldier_LvL_1){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 1§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 16)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.Soldier_LvL_2){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 2§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 16)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.Soldier_LvL_3){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lSoldier §a§lLvL 3§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 20)){
								p.getInventory().addItem(arrow);
							}
						}
					}
				}
				
			}
		}.runTaskTimer(this.start, 0, 20 * 18);
	}
	
	public void startPyroArrowRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.kitselected.containsKey(p)){
						if(StorageManager.kitselected.get(p) == KitPlaying.Pyro_LvL_3){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lPyro §a§lLvL 3§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 12)){
								p.getInventory().addItem(arrow);
							}
						}
					}
				}
				
			}
		}.runTaskTimer(this.start, 0, 20 * 22);
	}
	
	public void startNecromancerArrowRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.kitselected.containsKey(p)){
						if(StorageManager.kitselected.get(p) == KitPlaying.Necromancer_LvL_1){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 1§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 5)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.Necromancer_LvL_2){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 2§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 10)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.Necromancer_LvL_3){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 10)){
								p.getInventory().addItem(arrow);
							}
						}
					}
				}
				
			}
		}.runTaskTimer(this.start, 0, 20 * 27);
	}
	
	public void startTNTArrowRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.kitselected.containsKey(p)){
						if(StorageManager.kitselected.get(p) == KitPlaying.TNT_LvL_2){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lTNT §a§lLvL 2§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 2)){
								p.getInventory().addItem(arrow);
							}
						}
						if(StorageManager.kitselected.get(p) == KitPlaying.TNT_LvL_3){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lTNT §a§lLvL 3§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 4)){
								p.getInventory().addItem(arrow);
							}
						}
					}
				}
				
			}
		}.runTaskTimer(this.start, 0, 20 * 30);
	}
	
	public void startHeavyArrowRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.kitselected.containsKey(p)){
						if(StorageManager.kitselected.get(p) == KitPlaying.Heavy_LvL_1){
							
							final ItemStack arrow = new ItemStack(Material.ARROW, 1);
							ItemMeta arrowmeta = arrow.getItemMeta();
							arrowmeta.setDisplayName("§b§lHeavy §a§lLvL 1§8 || §bArrow");
							arrow.setItemMeta(arrowmeta);
							
							if(!p.getInventory().containsAtLeast(arrow, 8)){
								p.getInventory().addItem(arrow);
							}
						}
					}
				}
				
			}
		}.runTaskTimer(this.start, 0, 20 * 21);
	}
}
