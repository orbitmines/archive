package me.O_o_Fadi_o_O.SkyGamesRuleBook;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class RuleBook {
	
	private String displayname;
	private String author;
	private String[] pagenumbers;
	private List<String> pages;
	private int slot;
	
	public RuleBook(String displayname, String author, String[] pagenumbers, List<String> pages, int slot){
		this.displayname = displayname;
		this.author = author;
		this.pagenumbers = pagenumbers;
		this.pages = pages;
		this.slot = slot;
	}

	public String getDisplayName() {
		return displayname;
	}

	public void setDisplayName(String displayname) {
		this.displayname = displayname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String[] getPageNumbers() {
		return pagenumbers;
	}

	public void setPageNumbers(String[] pagenumbers) {
		this.pagenumbers = pagenumbers;
	}

	public List<String> getPages() {
		return pages;
	}

	public void setPages(List<String> pages) {
		this.pages = pages;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public void give(Player p){
		ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta itemmeta = (BookMeta) item.getItemMeta();
		itemmeta.setDisplayName(this.displayname.replace("&", "§"));
		itemmeta.addPage(this.pagenumbers);
		
		int index = 1;
		for(String page : this.pages){
			itemmeta.setPage(index, page.replace("&", "§"));
			index++;
		}
		
		itemmeta.setAuthor(this.author.replace("&", "§"));
		item.setItemMeta(itemmeta);
		
		p.getInventory().setItem(this.slot, new ItemStack(item));
	}
}
