package me.O_o_Fadi_o_O.Hub;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.utils.AnvilGUI;
import me.O_o_Fadi_o_O.Hub.utils.Pet;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PetRenameGUI {

	public static void openAnvilGUI(final Player p, final Pet pet, int EggDurability){
	
		final AnvilGUI gui = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler(){
			@Override
			public void onAnvilClick(AnvilGUI.AnvilClickEvent e){
				if(e.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
					String s = e.getName();
					
					if(StorageManager.points.get(p.getName()) >= 10){
						
						e.setWillClose(true);
						e.setWillDestroy(true);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
						
						if(PlayerManager.isPetActive(p)){
							PlayerManager.removePet(p, "§7Pet");
						}
						
						if(pet == Pet.COW){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §8Cow Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setCowName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.HORSE){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §6Horse Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setHorseName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.MAGMACUBE){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §cMagma Cube Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setMagmaCubeName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.MUSHROOMCOW){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §4Mushroom Cow Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setMushroomCowName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.OCELOT){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §eOcelot Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setOcelotName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.PIG){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §dPig Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setPigName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.SHEEP){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §fSheep Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setSheepName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.SILVERFISH){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §7Silverfish Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setSilverfishName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.SLIME){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §aSlime Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setSlimeName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.WOLF){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §7Wolf Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setWolfName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.CREEPER){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §aCreeper Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setCreeperName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.SQUID){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §9Squid Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setSquidName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.SPIDER){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §8Spider Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setSpiderName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						if(pet == Pet.CHICKEN){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §7Chicken Pet§7 name to §f" + s + "§7!");
							try {DatabaseManager.setChickenName(p, s);} catch (SQLException e1) {e1.printStackTrace();}
						}
						
						try {DatabaseManager.removeVIPPoints(p, 10);} catch (SQLException e1) {e1.printStackTrace();}
						PlayerManager.spawnPet(p, pet);
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED§7 your §f" + s + "§7.");
					}
					else{
						e.setWillClose(false);
						e.setWillDestroy(false);
						int needed = 10 - StorageManager.points.get(p.getName());
						p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + " §7more §b§lVIP Points§7!");
						p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
					}
				}
				else{
					e.setWillClose(false);
					e.setWillDestroy(false);
				}
			}
			
		});
		
		{
		ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
		item.setDurability((short) EggDurability);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Insert Petname");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§c§oPrice: §b10 VIP Points");
		lore.add("");
		meta.setLore(lore);
		item.setItemMeta(meta);
		gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, item);
		}
	
		gui.open();
	}
}
