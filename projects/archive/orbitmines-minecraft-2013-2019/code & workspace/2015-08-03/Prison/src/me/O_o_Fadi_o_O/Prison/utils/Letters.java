package me.O_o_Fadi_o_O.Prison.utils;

import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Letters {
	
	@SuppressWarnings("deprecation")
	public static void createDPunt(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
						}
					}
					else{
						p.sendBlockChange(l1, Material.AIR, id);
						p.sendBlockChange(l2, Material.AIR, id);
					}
				}
			}
		}
		if(Direction.equals("WEST")){

			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createA(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +1, y +2, z);
			Location l9 = new Location(w, x +2, y +2, z);
			Location l10 = new Location(w, x +2, y +3, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y +2, z +1);
			Location l9 = new Location(w, x, y +2, z +2);
			Location l10 = new Location(w, x, y +3, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -1, y +2, z);
			Location l9 = new Location(w, x -2, y +2, z);
			Location l10 = new Location(w, x -2, y +3, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y +2, z -1);
			Location l9 = new Location(w, x, y +2, z -2);
			Location l10 = new Location(w, x, y +3, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createB(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +1, y +2, z);
			Location l8 = new Location(w, x +2, y +3, z);
			Location l9 = new Location(w, x +2, y +1, z);
			Location l10 = new Location(w, x +1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +2, z +1);
			Location l8 = new Location(w, x, y +3, z +2);
			Location l9 = new Location(w, x, y +1, z +2);
			Location l10 = new Location(w, x, y, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -1, y +2, z);
			Location l8 = new Location(w, x -2, y +3, z);
			Location l9 = new Location(w, x -2, y +1, z);
			Location l10 = new Location(w, x -1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +2, z -1);
			Location l8 = new Location(w, x, y +3, z -2);
			Location l9 = new Location(w, x, y +1, z -2);
			Location l10 = new Location(w, x, y, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createC(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createD(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +2, z);
			Location l8 = new Location(w, x +2, y +3, z);
			Location l9 = new Location(w, x +2, y +1, z);
			Location l10 = new Location(w, x +1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +2, z +2);
			Location l8 = new Location(w, x, y +3, z +2);
			Location l9 = new Location(w, x, y +1, z +2);
			Location l10 = new Location(w, x, y, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +2, z);
			Location l8 = new Location(w, x -2, y +3, z);
			Location l9 = new Location(w, x -2, y +1, z);
			Location l10 = new Location(w, x -1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +2, z -2);
			Location l8 = new Location(w, x, y +3, z -2);
			Location l9 = new Location(w, x, y +1, z -2);
			Location l10 = new Location(w, x, y, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createE(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createF(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createG(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createH(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +1, y +2, z);
			Location l8 = new Location(w, x +2, y +2, z);
			Location l9 = new Location(w, x +2, y +3, z);
			Location l10 = new Location(w, x +2, y +1, z);
			Location l11 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y +2, z +1);
			Location l8 = new Location(w, x, y +2, z +2);
			Location l9 = new Location(w, x, y +3, z +2);
			Location l10 = new Location(w, x, y +1, z +2);
			Location l11 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -1, y +2, z);
			Location l8 = new Location(w, x -2, y +2, z);
			Location l9 = new Location(w, x -2, y +3, z);
			Location l10 = new Location(w, x -2, y +1, z);
			Location l11 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y +2, z -1);
			Location l8 = new Location(w, x, y +2, z -2);
			Location l9 = new Location(w, x, y +3, z -2);
			Location l10 = new Location(w, x, y +1, z -2);
			Location l11 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createI(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +1, z);
			Location l3 = new Location(w, x +1, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x +1, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +2, y, z);
			Location l8 = new Location(w, x +1, y, z);
			Location l9 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z +1);
			Location l3 = new Location(w, x, y +3, z +1);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z +1);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y, z +2);
			Location l8 = new Location(w, x, y, z +1);
			Location l9 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +1, z);
			Location l3 = new Location(w, x -1, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x -1, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -2, y, z);
			Location l8 = new Location(w, x -1, y, z);
			Location l9 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z -1);
			Location l3 = new Location(w, x, y +3, z -1);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z -1);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y, z -2);
			Location l8 = new Location(w, x, y, z -1);
			Location l9 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createJ(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +2, y +1, z);
			Location l3 = new Location(w, x +2, y +3, z);
			Location l4 = new Location(w, x +2, y +4, z);
			Location l5 = new Location(w, x +1, y, z);
			Location l6 = new Location(w, x +2, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z +2);
			Location l3 = new Location(w, x, y +3, z +2);
			Location l4 = new Location(w, x, y +4, z +2);
			Location l5 = new Location(w, x, y, z +1);
			Location l6 = new Location(w, x, y +2, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -2, y +1, z);
			Location l3 = new Location(w, x -2, y +3, z);
			Location l4 = new Location(w, x -2, y +4, z);
			Location l5 = new Location(w, x -1, y, z);
			Location l6 = new Location(w, x -2, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z -2);
			Location l3 = new Location(w, x, y +3, z -2);
			Location l4 = new Location(w, x, y +4, z -2);
			Location l5 = new Location(w, x, y, z -1);
			Location l6 = new Location(w, x, y +2, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createK(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +1, y +2, z);
			Location l8 = new Location(w, x +2, y +3, z);
			Location l9 = new Location(w, x +2, y +1, z);
			Location l10 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y +2, z +1);
			Location l8 = new Location(w, x, y +3, z +2);
			Location l9 = new Location(w, x, y +1, z +2);
			Location l10 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -1, y +2, z);
			Location l8 = new Location(w, x -2, y +3, z);
			Location l9 = new Location(w, x -2, y +1, z);
			Location l10 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y +2, z -1);
			Location l8 = new Location(w, x, y +3, z -2);
			Location l9 = new Location(w, x, y +1, z -2);
			Location l10 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createL(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y, z);
			Location l7 = new Location(w, x +1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y, z +2);
			Location l7 = new Location(w, x, y, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y, z);
			Location l7 = new Location(w, x -1, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y, z -2);
			Location l7 = new Location(w, x, y, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createM(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +1, y +3, z);
			Location l8 = new Location(w, x +2, y +2, z);
			Location l9 = new Location(w, x +2, y +3, z);
			Location l10 = new Location(w, x +2, y +1, z);
			Location l11 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y +3, z +1);
			Location l8 = new Location(w, x, y +2, z +2);
			Location l9 = new Location(w, x, y +3, z +2);
			Location l10 = new Location(w, x, y +1, z +2);
			Location l11 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -1, y +3, z);
			Location l8 = new Location(w, x -2, y +2, z);
			Location l9 = new Location(w, x -2, y +3, z);
			Location l10 = new Location(w, x -2, y +1, z);
			Location l11 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y +3, z -1);
			Location l8 = new Location(w, x, y +2, z -2);
			Location l9 = new Location(w, x, y +3, z -2);
			Location l10 = new Location(w, x, y +1, z -2);
			Location l11 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createN(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +2, z);
			Location l8 = new Location(w, x +2, y +3, z);
			Location l9 = new Location(w, x +2, y +1, z);
			Location l10 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +2, z +2);
			Location l8 = new Location(w, x, y +3, z +2);
			Location l9 = new Location(w, x, y +1, z +2);
			Location l10 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +2, z);
			Location l8 = new Location(w, x -2, y +3, z);
			Location l9 = new Location(w, x -2, y +1, z);
			Location l10 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +2, z -2);
			Location l8 = new Location(w, x, y +3, z -2);
			Location l9 = new Location(w, x, y +1, z -2);
			Location l10 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createO(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createP(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +1, y +2, z);
			Location l9 = new Location(w, x +2, y +2, z);
			Location l10 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y +2, z +1);
			Location l9 = new Location(w, x, y +2, z +2);
			Location l10 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -1, y +2, z);
			Location l9 = new Location(w, x -2, y +2, z);
			Location l10 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y +2, z -1);
			Location l9 = new Location(w, x, y +2, z -2);
			Location l10 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createQ(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x +2, y, z);
			Location l2 = new Location(w, x +2, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +1, y +2, z);
			Location l9 = new Location(w, x +2, y +2, z);
			Location l10 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y, z +2);
			Location l2 = new Location(w, x, y +1, z +2);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y +2, z +1);
			Location l9 = new Location(w, x, y +2, z +2);
			Location l10 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x -2, y, z);
			Location l2 = new Location(w, x -2, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -1, y +2, z);
			Location l9 = new Location(w, x -2, y +2, z);
			Location l10 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = new Location(w, x, y, z -2);
			Location l2 = new Location(w, x, y +1, z -2);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y +1, z -1);
			Location l9 = new Location(w, x, y +2, z -2);
			Location l10 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createR(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +1, y +2, z);
			Location l8 = new Location(w, x +2, y +3, z);
			Location l9 = new Location(w, x +2, y +1, z);
			Location l10 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +2, z +1);
			Location l8 = new Location(w, x, y +3, z +2);
			Location l9 = new Location(w, x, y +1, z +2);
			Location l10 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -1, y +2, z);
			Location l8 = new Location(w, x -2, y +3, z);
			Location l9 = new Location(w, x -2, y +1, z);
			Location l10 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +2, z -1);
			Location l8 = new Location(w, x, y +3, z -2);
			Location l9 = new Location(w, x, y +1, z -2);
			Location l10 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createS(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z +1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z -1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createT(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x +1, y +1, z);
			Location l2 = new Location(w, x +1, y +3, z);
			Location l3 = new Location(w, x, y +4, z);
			Location l4 = new Location(w, x +1, y +4, z);
			Location l5 = new Location(w, x +2, y +4, z);
			Location l6 = new Location(w, x +1, y, z);
			Location l7 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y +1, z +1);
			Location l2 = new Location(w, x, y +3, z +1);
			Location l3 = new Location(w, x, y +4, z);
			Location l4 = new Location(w, x, y +4, z +1);
			Location l5 = new Location(w, x, y +4, z +2);
			Location l6 = new Location(w, x, y, z +1);
			Location l7 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x -1, y +1, z);
			Location l2 = new Location(w, x -1, y +3, z);
			Location l3 = new Location(w, x, y +4, z);
			Location l4 = new Location(w, x -1, y +4, z);
			Location l5 = new Location(w, x -2, y +4, z);
			Location l6 = new Location(w, x -1, y, z);
			Location l7 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = new Location(w, x, y +1, z -1);
			Location l2 = new Location(w, x, y +3, z -1);
			Location l3 = new Location(w, x, y +4, z);
			Location l4 = new Location(w, x, y +4, z -1);
			Location l5 = new Location(w, x, y +4, z -2);
			Location l6 = new Location(w, x, y, z -1);
			Location l7 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createU(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +2, y, z);
			Location l8 = new Location(w, x +1, y, z);
			Location l9 = new Location(w, x +2, y +2, z);
			Location l10 = new Location(w, x +2, y +1, z);
			Location l11 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y, z +2);
			Location l8 = new Location(w, x, y, z +1);
			Location l9 = new Location(w, x, y +2, z +2);
			Location l10 = new Location(w, x, y +1, z +2);
			Location l11 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -2, y, z);
			Location l8 = new Location(w, x -1, y, z);
			Location l9 = new Location(w, x -2, y +2, z);
			Location l10 = new Location(w, x -2, y +1, z);
			Location l11 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y, z -2);
			Location l8 = new Location(w, x, y, z -1);
			Location l9 = new Location(w, x, y +2, z -2);
			Location l10 = new Location(w, x, y +1, z -2);
			Location l11 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createV(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +2, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x +2, y +4, z);
			Location l6 = new Location(w, x +1, y, z);
			Location l7 = new Location(w, x +2, y +2, z);
			Location l8 = new Location(w, x +2, y +1, z);
			Location l9 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +2, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z +2);
			Location l6 = new Location(w, x, y, z +1);
			Location l7 = new Location(w, x, y +2, z +2);
			Location l8 = new Location(w, x, y +1, z +2);
			Location l9 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +2, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x -2, y +4, z);
			Location l6 = new Location(w, x -1, y, z);
			Location l7 = new Location(w, x -2, y +2, z);
			Location l8 = new Location(w, x -2, y +1, z);
			Location l9 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = new Location(w, x, y +1, z);
			Location l2 = new Location(w, x, y +2, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z -2);
			Location l6 = new Location(w, x, y, z -1);
			Location l7 = new Location(w, x, y +2, z -2);
			Location l8 = new Location(w, x, y +1, z -2);
			Location l9 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createW(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +1, y +1, z);
			Location l8 = new Location(w, x +2, y +2, z);
			Location l9 = new Location(w, x +2, y +3, z);
			Location l10 = new Location(w, x +2, y +1, z);
			Location l11 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y +1, z +1);
			Location l8 = new Location(w, x, y +2, z +2);
			Location l9 = new Location(w, x, y +3, z +2);
			Location l10 = new Location(w, x, y +1, z +2);
			Location l11 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -1, y +1, z);
			Location l8 = new Location(w, x -2, y +2, z);
			Location l9 = new Location(w, x -2, y +3, z);
			Location l10 = new Location(w, x -2, y +1, z);
			Location l11 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y +1, z -1);
			Location l8 = new Location(w, x, y +2, z -2);
			Location l9 = new Location(w, x, y +3, z -2);
			Location l10 = new Location(w, x, y +1, z -2);
			Location l11 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createX(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x +2, y +4, z);
			Location l6 = new Location(w, x +1, y +2, z);
			Location l7 = new Location(w, x +2, y +3, z);
			Location l8 = new Location(w, x +2, y +1, z);
			Location l9 = new Location(w, x +2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z +2);
			Location l6 = new Location(w, x, y +2, z +1);
			Location l7 = new Location(w, x, y +3, z +2);
			Location l8 = new Location(w, x, y +1, z +2);
			Location l9 = new Location(w, x, y, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x -2, y +4, z);
			Location l6 = new Location(w, x -1, y +2, z);
			Location l7 = new Location(w, x -2, y +3, z);
			Location l8 = new Location(w, x -2, y +1, z);
			Location l9 = new Location(w, x -2, y, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z -2);
			Location l6 = new Location(w, x, y +2, z -1);
			Location l7 = new Location(w, x, y +3, z -2);
			Location l8 = new Location(w, x, y +1, z -2);
			Location l9 = new Location(w, x, y, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createY(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x +1, y, z);
			Location l2 = new Location(w, x +1, y +1, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x +2, y +4, z);
			Location l6 = new Location(w, x +1, y +2, z);
			Location l7 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y, z +1);
			Location l2 = new Location(w, x, y +1, z +1);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z +2);
			Location l6 = new Location(w, x, y +2, z +1);
			Location l7 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x -1, y, z);
			Location l2 = new Location(w, x -1, y +1, z);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x -2, y +4, z);
			Location l6 = new Location(w, x -1, y +2, z);
			Location l7 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = new Location(w, x, y, z -1);
			Location l2 = new Location(w, x, y +1, z -1);
			Location l3 = new Location(w, x, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z -2);
			Location l6 = new Location(w, x, y +2, z -1);
			Location l7 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createZ(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x +2, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x +1, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +2, y, z);
			Location l8 = new Location(w, x +1, y, z);
			Location l9 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +3, z +2);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z +1);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y, z +2);
			Location l8 = new Location(w, x, y, z +1);
			Location l9 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x -2, y +3, z);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x -1, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -2, y, z);
			Location l8 = new Location(w, x -1, y, z);
			Location l9 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +3, z -2);
			Location l4 = new Location(w, x, y +4, z);
			Location l5 = new Location(w, x, y +4, z -1);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y, z -2);
			Location l8 = new Location(w, x, y, z -1);
			Location l9 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create0(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
							p.sendBlockChange(l12, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create1(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +1, z);
			Location l3 = new Location(w, x +1, y +3, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x +1, y +4, z);
			Location l6 = new Location(w, x +2, y, z);
			Location l7 = new Location(w, x +1, y, z);
			Location l8 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z +1);
			Location l3 = new Location(w, x, y +3, z +1);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z +1);
			Location l6 = new Location(w, x, y, z +2);
			Location l7 = new Location(w, x, y, z +1);
			Location l8 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +1, z);
			Location l3 = new Location(w, x -1, y +3, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x -1, y +4, z);
			Location l6 = new Location(w, x -2, y, z);
			Location l7 = new Location(w, x -1, y, z);
			Location l8 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z -1);
			Location l3 = new Location(w, x, y +3, z -1);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z -1);
			Location l6 = new Location(w, x, y, z -2);
			Location l7 = new Location(w, x, y, z -1);
			Location l8 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create2(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x +2, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z +1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z +2);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x -2, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z -1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z -2);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create3(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x +2, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z +1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z +2);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x -2, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z -1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z -2);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create4(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x +2, y, z);
			Location l2 = new Location(w, x +2, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +2, y +4, z);
			Location l7 = new Location(w, x +1, y +2, z);
			Location l8 = new Location(w, x +2, y +2, z);
			Location l9 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y, z +2);
			Location l2 = new Location(w, x, y +1, z +2);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +2);
			Location l7 = new Location(w, x, y +2, z +1);
			Location l8 = new Location(w, x, y +2, z +2);
			Location l9 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x -2, y, z);
			Location l2 = new Location(w, x -2, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -2, y +4, z);
			Location l7 = new Location(w, x -1, y +2, z);
			Location l8 = new Location(w, x -2, y +2, z);
			Location l9 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = new Location(w, x, y, z -2);
			Location l2 = new Location(w, x, y +1, z -2);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -2);
			Location l7 = new Location(w, x, y +1, z -1);
			Location l8 = new Location(w, x, y +2, z -2);
			Location l9 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create5(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z +1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z -1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create6(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z +1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
							p.sendBlockChange(l12, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z -1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y +1, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create7(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = new Location(w, x +2, y, z);
			Location l2 = new Location(w, x +2, y +1, z);
			Location l3 = new Location(w, x +2, y +2, z);
			Location l4 = new Location(w, x +2, y +3, z);
			Location l5 = new Location(w, x +2, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x, y +4, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = new Location(w, x, y, z +2);
			Location l2 = new Location(w, x, y +1, z +2);
			Location l3 = new Location(w, x, y +2, z +2);
			Location l4 = new Location(w, x, y +3, z +2);
			Location l5 = new Location(w, x, y +4, z +2);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = new Location(w, x -2, y, z);
			Location l2 = new Location(w, x -2, y +1, z);
			Location l3 = new Location(w, x -2, y +2, z);
			Location l4 = new Location(w, x -2, y +3, z);
			Location l5 = new Location(w, x -2, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x, y +4, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = new Location(w, x, y, z -2);
			Location l2 = new Location(w, x, y +1, z -2);
			Location l3 = new Location(w, x, y +2, z -2);
			Location l4 = new Location(w, x, y +3, z -2);
			Location l5 = new Location(w, x, y +4, z -2);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create8(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x +2, y +3, z);
			Location l13 = new Location(w, x +1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y +3, z +2);
			Location l13 = new Location(w, x, y +2, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x -2, y +3, z);
			Location l13 = new Location(w, x -1, y +2, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
							p.sendBlockChange(l12, type, id);
							p.sendBlockChange(l13, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y +3, z -2);
			Location l13 = new Location(w, x, y +2, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void create9(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x +1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x +2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z +1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y +3, z +2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x -1, y +2, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x -2, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					if(StorageManager.playerclockenabled.get(p) == true){
						if(p.getLocation().distance(l1) <= 50){
							p.sendBlockChange(l1, type, id);
							p.sendBlockChange(l2, type, id);
							p.sendBlockChange(l3, type, id);
							p.sendBlockChange(l4, type, id);
							p.sendBlockChange(l5, type, id);
							p.sendBlockChange(l6, type, id);
							p.sendBlockChange(l7, type, id);
							p.sendBlockChange(l8, type, id);
							p.sendBlockChange(l9, type, id);
							p.sendBlockChange(l10, type, id);
							p.sendBlockChange(l11, type, id);
							p.sendBlockChange(l12, type, id);
						}
					}
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +2, z -1);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y +3, z -2);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createEmpty(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x +1, y +4, z);
			Location l7 = new Location(w, x +2, y +4, z);
			Location l8 = new Location(w, x +2, y, z);
			Location l9 = new Location(w, x +1, y, z);
			Location l10 = new Location(w, x +2, y +2, z);
			Location l11 = new Location(w, x +2, y +1, z);
			Location l12 = new Location(w, x +2, y +3, z);
			Location l13 = new Location(w, x +1, y +2, z);
			Location l14 = new Location(w, x +1, y +1, z);
			Location l15 = new Location(w, x +1, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
					p.sendBlockChange(l14, type, id);
					p.sendBlockChange(l15, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z +1);
			Location l7 = new Location(w, x, y +4, z +2);
			Location l8 = new Location(w, x, y, z +2);
			Location l9 = new Location(w, x, y, z +1);
			Location l10 = new Location(w, x, y +2, z +2);
			Location l11 = new Location(w, x, y +1, z +2);
			Location l12 = new Location(w, x, y +3, z +2);
			Location l13 = new Location(w, x, y +2, z +1);
			Location l14 = new Location(w, x, y +1, z +1);
			Location l15 = new Location(w, x, y +3, z +1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
					p.sendBlockChange(l14, type, id);
					p.sendBlockChange(l15, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x -1, y +4, z);
			Location l7 = new Location(w, x -2, y +4, z);
			Location l8 = new Location(w, x -2, y, z);
			Location l9 = new Location(w, x -1, y, z);
			Location l10 = new Location(w, x -2, y +2, z);
			Location l11 = new Location(w, x -2, y +1, z);
			Location l12 = new Location(w, x -2, y +3, z);
			Location l13 = new Location(w, x -1, y +2, z);
			Location l14 = new Location(w, x -1, y +1, z);
			Location l15 = new Location(w, x -1, y +3, z);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
					p.sendBlockChange(l14, type, id);
					p.sendBlockChange(l15, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			Location l2 = new Location(w, x, y +1, z);
			Location l3 = new Location(w, x, y +2, z);
			Location l4 = new Location(w, x, y +3, z);
			Location l5 = new Location(w, x, y +4, z);
			Location l6 = new Location(w, x, y +4, z -1);
			Location l7 = new Location(w, x, y +4, z -2);
			Location l8 = new Location(w, x, y, z -2);
			Location l9 = new Location(w, x, y, z -1);
			Location l10 = new Location(w, x, y +2, z -2);
			Location l11 = new Location(w, x, y +1, z -2);
			Location l12 = new Location(w, x, y +3, z -2);
			Location l13 = new Location(w, x, y +2, z -1);
			Location l14 = new Location(w, x, y +1, z -1);
			Location l15 = new Location(w, x, y +3, z -1);
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
					p.sendBlockChange(l2, type, id);
					p.sendBlockChange(l3, type, id);
					p.sendBlockChange(l4, type, id);
					p.sendBlockChange(l5, type, id);
					p.sendBlockChange(l6, type, id);
					p.sendBlockChange(l7, type, id);
					p.sendBlockChange(l8, type, id);
					p.sendBlockChange(l9, type, id);
					p.sendBlockChange(l10, type, id);
					p.sendBlockChange(l11, type, id);
					p.sendBlockChange(l12, type, id);
					p.sendBlockChange(l13, type, id);
					p.sendBlockChange(l14, type, id);
					p.sendBlockChange(l15, type, id);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void createDOT(Location l, String Direction, Material type, byte id){
		
		World w = l.getWorld();
		
		if(Direction.equals("NORTH")){
			Location l1 = l;
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
				}
			}
		}
		if(Direction.equals("EAST")){
			
			Location l1 = l;
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
				}
			}
		}
		if(Direction.equals("SOUTH")){
			
			Location l1 = l;
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
				}
			}
		}
		if(Direction.equals("WEST")){
			Location l1 = l;
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getWorld() == w){
					p.sendBlockChange(l1, type, id);
				}
			}
		}
	}
}
