package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.json.parser;

import java.util.List;
import java.util.Map;

/**
 * Container factory for creating containers for JSON object and JSON array.
 * 
 * @see org.json.simple.parser.JSONParser#parse(java.io.Reader, ContainerFactory)
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public interface ContainerFactory {
	/**
	 * @return A Map instance to store JSON object, or null if you want to use org.json.simple.JSONObject.
	 */
	@SuppressWarnings("rawtypes")
	Map createObjectContainer();
	
	/**
	 * @return A List instance to store JSON array, or null if you want to use org.json.simple.JSONArray. 
	 */
	@SuppressWarnings("rawtypes")
	List creatArrayContainer();
}