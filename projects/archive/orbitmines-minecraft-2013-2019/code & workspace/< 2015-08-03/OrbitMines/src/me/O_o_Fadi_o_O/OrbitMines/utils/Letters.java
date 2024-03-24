package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Direction;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Letters {

	public String word;
	public Direction direction;
	public Location location;
	
	public Letters(String word, Direction direction, Location location){
		this.word = word;
		this.direction = direction;
		this.location = location;
	}
	
	@SuppressWarnings("deprecation")
	public void generate(Material material, int durability){
		Location l = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
		
		int index = 0;
		String lastletter = null;
		for(String letter : word.toUpperCase().split("")){
			if(index != 0){
				int nextletter = 4;
				if(lastletter != null && (lastletter.equals(":") || lastletter.equals(".") || lastletter.equals(" ") || lastletter.equals("'"))){
					nextletter = 2;
				}
				
				switch(direction){
					case NORTH:
						l.add(nextletter, 0, 0);
						break;
					case EAST:
						l.add(0, 0, nextletter);
						break;
					case SOUTH:
						l.subtract(nextletter, 0, 0);
						break;
					case WEST:
						l.subtract(0, 0, nextletter);
						break;
				}
			}
			
			for(Location location : getLocations(l, letter)){
				Block b = location.getWorld().getBlockAt(location);
				b.setType(material);
				b.setData((byte) durability);
			}
			
			lastletter = letter;
			index++;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void generate(Material material, int durability, List<Player> players){
		Location l = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
		
		List<Location> locations = new ArrayList<Location>();
		
		int index = 0;
		String lastletter = null;
		for(String letter : word.toUpperCase().split("")){
			if(index != 0){
				int nextletter = 4;
				if(lastletter != null && (lastletter.equals(":") || lastletter.equals(".") || lastletter.equals(" ") || lastletter.equals("'"))){
					nextletter = 2;
				}
				
				switch(direction){
					case NORTH:
						l.add(nextletter, 0, 0);
						break;
					case EAST:
						l.add(0, 0, nextletter);
						break;
					case SOUTH:
						l.subtract(nextletter, 0, 0);
						break;
					case WEST:
						l.subtract(0, 0, nextletter);
						break;
				}
			}
			
			locations.addAll(getLocations(l, letter));
			
			lastletter = letter;
			index++;
		}
		
		for(Player p : players){
			for(Location loc : locations){
				p.sendBlockChange(loc, material, (byte) durability);
			}
		}
	}
	
	private List<Location> getLocations(Location location, String letter){
		World w = location.getWorld();
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		
		if(letter.equals("A")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("B")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +1, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +2, z +1), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -1, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +2, z -1), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -1));
			}
		}
		else if(letter.equals("C")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1));
			}
		}
		else if(letter.equals("D")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +1, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -1, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -1));
			}
		}
		else if(letter.equals("E")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals("F")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals("G")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2));
			}
		}
		else if(letter.equals("H")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("I")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +1, z), new Location(w, x +1, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z +1), new Location(w, x, y +3, z +1), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +1, z), new Location(w, x -1, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z -1), new Location(w, x, y +3, z -1), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals("J")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +4, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +4, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2));
			}
		}
		else if(letter.equals("K")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y +2, z -1), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("L")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y, z +2), new Location(w, x, y, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y, z -2), new Location(w, x, y, z -1));
			}
		}
		else if(letter.equals("M")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +3, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +3, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +3, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y +3, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("N")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("O")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("P")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("Q")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x +2, y, z), new Location(w, x +2, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x -2, y, z), new Location(w, x -2, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y +1, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("R")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +2, z +1), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +2, z -1), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("S")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2));
			}
		}
		else if(letter.equals("T")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x +1, y +1, z), new Location(w, x +1, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y +1, z +1), new Location(w, x, y +3, z +1), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x -1, y +1, z), new Location(w, x -1, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y +1, z -1), new Location(w, x, y +3, z -1), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals("U")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("V")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("W")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +1, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +1, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +1, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y +1, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("X")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +3, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y +2, z -1), new Location(w, x, y +3, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y, z -2));
			}
		}
		else if(letter.equals("Y")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x +1, y, z), new Location(w, x +1, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z +1), new Location(w, x, y +1, z +1), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x -1, y, z), new Location(w, x -1, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x -1, y, z), new Location(w, x -1, y +1, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +3, z));
			}
		}
		else if(letter.equals("Z")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x +2, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +3, z +2), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x -2, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +3, z -2), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals(":")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +3, z));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +3, z));
			}
		}
		else if(letter.equals("0")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("1")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +1, z), new Location(w, x +1, y +3, z), new Location(w, x, y +3, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z +1), new Location(w, x, y +3, z +1), new Location(w, x, y +3, z), new Location(w, x, y +4, z +1), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +1));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +1, z), new Location(w, x -1, y +3, z), new Location(w, x, y +3, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z -1), new Location(w, x, y +3, z -1), new Location(w, x, y +3, z), new Location(w, x, y +4, z -1), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals("2")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +2, z), new Location(w, x, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x, y +1, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z), new Location(w, x, y +3, z +2), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +2, z), new Location(w, x, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x, y +1, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z), new Location(w, x, y +3, z -2), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z));
			}
		}
		else if(letter.equals("3")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +2, z), new Location(w, x, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z), new Location(w, x, y +3, z +2), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +2, z), new Location(w, x, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z), new Location(w, x, y +3, z -2), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2));
			}
		}
		else if(letter.equals("4")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x +2, y, z), new Location(w, x +2, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +2, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +2), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x -2, y, z), new Location(w, x -2, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +2, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -2), new Location(w, x, y +1, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals("5")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2));
			}
		}
		else if(letter.equals("6")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x, y +1, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +1, z));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x, y +1, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +1, z));
			}
		}
		else if(letter.equals("7")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x +2, y, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +3, z), new Location(w, x +2, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x, y +4, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +2, z +2), new Location(w, x, y +3, z +2), new Location(w, x, y +4, z +2), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z));
				case SOUTH:
					return Arrays.asList(new Location(w, x -2, y, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +3, z), new Location(w, x -2, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x, y +4, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +2, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +4, z -2), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z));
			}
		}
		else if(letter.equals("8")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z), new Location(w, x +1, y +2, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z), new Location(w, x -1, y +2, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +1, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2), new Location(w, x, y +2, z -1));
			}
		}
		else if(letter.equals("9")){
			switch(direction){
				case NORTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x +1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x +1, y +4, z), new Location(w, x +2, y +4, z), new Location(w, x +2, y, z), new Location(w, x +1, y, z), new Location(w, x +2, y +2, z), new Location(w, x +2, y +1, z), new Location(w, x +2, y +3, z));
				case EAST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z +1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z +1), new Location(w, x, y +4, z +2), new Location(w, x, y, z +2), new Location(w, x, y, z +1), new Location(w, x, y +2, z +2), new Location(w, x, y +1, z +2), new Location(w, x, y +3, z +2));
				case SOUTH:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x -1, y +2, z), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x -1, y +4, z), new Location(w, x -2, y +4, z), new Location(w, x -2, y, z), new Location(w, x -1, y, z), new Location(w, x -2, y +2, z), new Location(w, x -2, y +1, z), new Location(w, x -2, y +3, z));
				case WEST:
					return Arrays.asList(new Location(w, x, y, z), new Location(w, x, y +2, z -1), new Location(w, x, y +2, z), new Location(w, x, y +3, z), new Location(w, x, y +4, z), new Location(w, x, y +4, z -1), new Location(w, x, y +4, z -2), new Location(w, x, y, z -2), new Location(w, x, y, z -1), new Location(w, x, y +2, z -2), new Location(w, x, y +1, z -2), new Location(w, x, y +3, z -2));
			}
		}
		else if(letter.equals(".")){
			return Arrays.asList(location);
		}
		else if(letter.equals(":")){
			return Arrays.asList(new Location(w, x, y +1, z), new Location(w, x, y +3, z));
		}
		else if(letter.equals("'")){
			return Arrays.asList(new Location(w, x, y +3, z), new Location(w, x, y +4, z));
		}
		else{}
		
		return new ArrayList<Location>();
	}
}
