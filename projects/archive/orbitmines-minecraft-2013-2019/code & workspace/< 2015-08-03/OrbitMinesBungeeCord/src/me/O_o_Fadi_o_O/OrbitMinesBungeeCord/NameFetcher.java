package me.O_o_Fadi_o_O.OrbitMinesBungeeCord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.json.JSONArray;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.json.JSONObject;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.json.parser.JSONParser;
 
public class NameFetcher implements Callable<Map<UUID, List<String>>> {
    private static Map<UUID, List<String>> cache = new HashMap<>();
 
    public NameFetcher(UUID uuid){
    	cache.put(uuid, getHistory(uuid));
    }
    
    private List<String> getHistory(UUID uuid) {
        if(cache.containsKey(uuid)) return cache.get(uuid);
        URLConnection connection;
        try{
            connection = new URL("https://api.mojang.com/user/profiles/" + uuid.toString().replace("-", "").toLowerCase() + "/names").openConnection();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String string = in.readLine();
            in.close();
            JSONParser parser = new JSONParser();
            List<String> names = new ArrayList<String>();
            try{
                JSONArray array = (JSONArray) parser.parse(string);
                if(array.size() != 1){
	                for(int i = 0; i < array.size(); i++){
	                    JSONObject obj = (JSONObject) array.get(i);
	                    if(i == 0){
	                    	names.add(obj.get("name") + "");
	                    }
	                    else if(i == array.size()){
	                        SimpleDateFormat sd = new SimpleDateFormat();
	                        sd.applyPattern( "dd-MM-yyyy HH:mm:ss" );
	                        String date = sd.format(new Date((long) obj.get("changedToAt")));
	                    	
	                    	names.add(obj.get("name") + " §7(§6" + date + "§7)");   
	                    }
	                    else{
	                        SimpleDateFormat sd = new SimpleDateFormat();
	                        sd.applyPattern( "dd-MM-yyyy HH:mm:ss" );
	                        String date = sd.format(new Date((long) obj.get("changedToAt")));
	                        
	                    	names.add(obj.get("name") + " §7(§6" + date + "§7)");
	                    }
	                }
                }else{
                	names.add(((JSONObject) array.get(0)).get("name") + "");
                }
            }catch(Exception e){
                names = null;
            }
            
            cache.put(uuid, names);
            
            return names;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void invalidateCache() {
        cache.clear();
    }

	@Override
	public Map<UUID, List<String>> call() throws Exception {
		return cache;
	}
}
