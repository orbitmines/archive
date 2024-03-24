package me.O_o_Fadi_o_O.SkyGamesRuleBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.O_o_Fadi_o_O.SkyGamesRuleBook.events.ClickEvent;
import me.O_o_Fadi_o_O.SkyGamesRuleBook.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.SkyGamesRuleBook.events.DropEvent;
import me.O_o_Fadi_o_O.SkyGamesRuleBook.events.JoinEvent;
import me.O_o_Fadi_o_O.SkyGamesRuleBook.managers.ConfigManager;

import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {
	
	private static Start plugin;
	private RuleBook book;
	
	public void onEnable(){
		plugin = this;
		
		ConfigManager.setup();
		
		registerEvents();
		registerRuleBook();
	}
	
	public void onDisable(){
		
	}

	public static Start getInstance(){
		return plugin;
	}
	public RuleBook getRuleBook(){
		return book;
	}
	
	private void registerEvents(){
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
	}
	
	public void registerRuleBook(){
		String displayname = ConfigManager.config.getString("Book.DisplayName");
		String author = ConfigManager.config.getString("Book.Author");
		Set<String> pageset = ConfigManager.config.getConfigurationSection("Book.Pages").getKeys(false);
		int slot = ConfigManager.config.getInt("Book.Slot") -1;

		String[] pagenumbers = new String[pageset.size()];
		List<String> pages = new ArrayList<String>();
		
		int index = 0;
		for(String pagenumber : pageset){
			pagenumbers[index] = pagenumber;
			
			List<String> lines = ConfigManager.config.getStringList("Book.Pages." + pagenumber);
			String page = "";
			for(String line : lines){
				if(page.equals("")){
					page = line;
				}
				else{
					page = page + "\n" + line;
				}
			}
			pages.add(page);
			
			index++;
		}
		
		this.book = new RuleBook(displayname, author, pagenumbers, pages, slot);
	}
}
