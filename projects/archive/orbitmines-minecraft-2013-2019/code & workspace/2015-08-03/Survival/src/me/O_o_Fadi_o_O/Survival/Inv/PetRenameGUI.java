package me.O_o_Fadi_o_O.Survival.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;
import me.O_o_Fadi_o_O.Survival.utils.AnvilGUI;
import me.O_o_Fadi_o_O.Survival.utils.Pet;

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
					
					if(StorageManager.vippoints.get(p) >= 10){
						
						e.setWillClose(true);
						e.setWillDestroy(true);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
						
						if(StorageManager.pet.get(p) != Pet.NONE){
							PlayerManager.removePet(p, "§7Pet");
						}
						
						if(pet == Pet.COW){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §8Cow Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setCowName(p, s);
						}
						if(pet == Pet.HORSE){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §6Horse Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setHorseName(p, s);
						}
						if(pet == Pet.MAGMACUBE){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §cMagma Cube Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setMagmaCubeName(p, s);
						}
						if(pet == Pet.MUSHROOMCOW){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §4Mushroom Cow Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setMushroomCowName(p, s);
						}
						if(pet == Pet.OCELOT){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §eOcelot Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setOcelotName(p, s);
						}
						if(pet == Pet.PIG){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §dPig Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setPigName(p, s);
						}
						if(pet == Pet.SHEEP){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §fSheep Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setSheepName(p, s);
						}
						if(pet == Pet.SILVERFISH){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §7Silverfish Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setSilverfishName(p, s);
						}
						if(pet == Pet.SLIME){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §aSlime Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setSlimeName(p, s);
						}
						if(pet == Pet.WOLF){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §7Wolf Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setWolfName(p, s);
						}
						if(pet == Pet.CREEPER){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §aCreeper Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setCreeperName(p, s);
						}
						if(pet == Pet.SQUID){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §9Squid Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setSquidName(p, s);
						}
						if(pet == Pet.SPIDER){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §8Spider Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setSpiderName(p, s);
						}
						if(pet == Pet.CHICKEN){
							p.sendMessage("§9Cosmetic Perks §8| §7Changed your §7Chicken Pet§7 name to §f" + s + "§7!");
							DatabaseManager.setChickenName(p, s);
						}
						
						DatabaseManager.removeVIPPoints(p, 10);
						PlayerManager.spawnPet(p, pet);
						p.sendMessage("§9Cosmetic Perks §8| §a§lENABLED§7 your §f" + s + "§7.");
					}
					else{
						e.setWillClose(false);
						e.setWillDestroy(false);
						PlayerManager.sendVIPPointsRequiredMessage(p, 10);
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
