package me.O_o_Fadi_o_O.BungeeMSG.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import net.md_5.bungee.api.plugin.PluginDescription;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
 
public class ConfigManager {
 
	private ConfigManager() { }
 
	static ConfigManager plugin = new ConfigManager();
 
	static Start start = Start.getInstance();
	
	public static Configuration config;
	static File cfile;
	
	public static Configuration muted;
	static File mfile;
	
	public static Configuration bannedwords;
	static File bwfile;
	
	public static Configuration domainwhitelist;
	static File dwfile;
	
	public static Configuration playerdata;
	static File pdfile;

	public static ConfigManager getInstance(){
		return plugin;
	}
	
	public static void setup(){
	 
		if(!start.getDataFolder().exists()){
			start.getDataFolder().mkdir();
		}
	 
		cfile = new File(start.getDataFolder(), "config.yml");
		mfile = new File(start.getDataFolder(), "muted.yml");
		bwfile = new File(start.getDataFolder(), "banned-words.yml");
		dwfile = new File(start.getDataFolder(), "domain-whitelist.yml");
		pdfile = new File(start.getDataFolder(), "playerdata.yml");
	 
		if(!cfile.exists()){
			copyFile("config.yml", cfile.toPath());
		}
		if(!mfile.exists()){
			copyFile("muted.yml", mfile.toPath());
		}
		if(!bwfile.exists()){
			copyFile("banned-words.yml", bwfile.toPath());
		}
		if(!dwfile.exists()){
			copyFile("domain-whitelist.yml", dwfile.toPath());
		}
		if(!pdfile.exists()){
			copyFile("playerdata.yml", pdfile.toPath());
		}
		
		load();
	}
	
	@SuppressWarnings("deprecation")
	private static void load(){
		try{
			config = YamlConfiguration.getProvider(YamlConfiguration.class).load(cfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while loading config.yml");
			ex.printStackTrace();
		}
		try{
			muted = YamlConfiguration.getProvider(YamlConfiguration.class).load(mfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while loading muted.yml");
			ex.printStackTrace();
		}
		try{
			bannedwords = YamlConfiguration.getProvider(YamlConfiguration.class).load(bwfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while loading banned-words.yml");
			ex.printStackTrace();
		}
		try{
			domainwhitelist = YamlConfiguration.getProvider(YamlConfiguration.class).load(dwfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while loading domain-whitelist.yml");
			ex.printStackTrace();
		}
		try{
			playerdata = YamlConfiguration.getProvider(YamlConfiguration.class).load(pdfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while loading playerdata.yml");
			ex.printStackTrace();
		}
	}
	
	public Configuration getConfig(){
		return config;
	}
	 
	@SuppressWarnings("deprecation")
	public static void saveConfig(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(start.getDataFolder(), "config.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while saving config.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadConfig(){
		try{
			config = YamlConfiguration.getProvider(YamlConfiguration.class).load(cfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while reloading config.yml");
			ex.printStackTrace();
		}
	}
	 
	public Configuration getMuted(){
		return muted;
	}
	 
	@SuppressWarnings("deprecation")
	public static void saveMuted(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(muted, new File(start.getDataFolder(), "muted.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while saving muted.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadMuted(){
		try{
			muted = YamlConfiguration.getProvider(YamlConfiguration.class).load(mfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while reloading muted.yml");
			ex.printStackTrace();
		}
	}
	
	public Configuration getBannedWords(){
		return bannedwords;
	}
	 
	@SuppressWarnings("deprecation")
	public static void saveBannedWords(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(bannedwords, new File(start.getDataFolder(), "banned-words.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while saving banned-words.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadBannedWords(){
		try{
			bannedwords = YamlConfiguration.getProvider(YamlConfiguration.class).load(bwfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while reloading banned-words.yml");
			ex.printStackTrace();
		}
	}
	
	public Configuration getDomainWhitelist(){
		return domainwhitelist;
	}
	 
	@SuppressWarnings("deprecation")
	public static void saveDomainWhitelist(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(domainwhitelist, new File(start.getDataFolder(), "domain-whitelist.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while saving domain-whitelist.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadDomainWhitelist(){
		try{
			domainwhitelist = YamlConfiguration.getProvider(YamlConfiguration.class).load(dwfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while reloading domain-whitelist.yml");
			ex.printStackTrace();
		}
	}
	
	public Configuration getPlayerData(){
		return playerdata;
	}
	 
	@SuppressWarnings("deprecation")
	public static void savePlayerData(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(playerdata, new File(start.getDataFolder(), "playerdata.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while saving playerdata.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadPlayerData(){
		try{
			playerdata = YamlConfiguration.getProvider(YamlConfiguration.class).load(pdfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while reloading playerdata.yml");
			ex.printStackTrace();
		}
	}
	
	public PluginDescription getDesc(){
		return start.getDescription();
	}
	
	@SuppressWarnings("deprecation")
	private static void copyFile(String filename, Path path){
		try{
			Files.copy(start.getResourceAsStream(filename), path);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeMSG] Error while creating " + filename);
			ex.printStackTrace();
		}
	}
}
