package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.NameFetcher;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.UUIDFetcher;

public class Utils {

	public static UUID getUUID(String playername){
		UUIDFetcher uuidf = new UUIDFetcher(Arrays.asList(playername));
		try{
			return uuidf.call().get(playername);
		}catch(Exception ex){
			return null;
		}
	}
	public static String getName(UUID uuid){
		NameFetcher namef = new NameFetcher(uuid);
		try{
			String name = namef.call().get(uuid).get(namef.call().get(uuid).size() -1);
			String[] nameparts = name.split(" ");
			return nameparts[0];
		}catch(Exception ex){
			return null;
		}
	}
	public static String getNameDate(UUID uuid){
		NameFetcher namef = new NameFetcher(uuid);
		try{
			String name = namef.call().get(uuid).get(namef.call().get(uuid).size() -1);
			String[] nameparts = name.split(" ", 1);
			return nameparts[1];
		}catch(Exception ex){
			return null;
		}
	}
	public static HashMap<String, String> getNames(UUID uuid){
		NameFetcher namef = new NameFetcher(uuid);
		try{
			HashMap<String, String> names = new HashMap<String, String>();
			for(String name : namef.call().get(uuid)){
				String[] nameparts = name.split(" ", 1);
				if(nameparts.length > 1){
					names.put(nameparts[0], nameparts[1]);
				}
				else{
					names.put(nameparts[0], null);
				}
			}
			
			return names;
		}catch(Exception ex){
			return null;
		}
	}
}
