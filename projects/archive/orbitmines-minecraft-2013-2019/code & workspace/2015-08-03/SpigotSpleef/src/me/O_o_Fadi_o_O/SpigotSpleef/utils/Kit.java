package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.CustomItem;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.AbilityManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kit {

	private int kitid;
	private String kitname;
	private int price;
	private List<KitItemStack> items;
	
	public Kit(int kitid, String kitname, int price, List<KitItemStack> items){
		this.kitid = kitid;
		this.kitname = kitname;
		this.price = price;
		this.items = items;
	}
	
	public int getKitID(){
		return this.kitid;
	}
	
	public String getName(){
		return this.kitname;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public List<KitItemStack> getItems(){
		return items;
	}
	
	public void give(SpleefPlayer sp){
		Player p = sp.getPlayer();
		String animatedrightclick = sp.nextAnimatedRightClick().replace("&", "§");
		
		int index = 0;
		for(KitItemStack item : this.items){
			ItemStack i = getReplacedItemStack(sp, item, index, animatedrightclick);
			if(index < 36){
				if(p.getInventory().getItem(index) == null || p.getInventory().getItem(index).getType() != Material.BOW){
					p.getInventory().setItem(index, i);
				}
			}
			else{
				if(index == 36){
					p.getInventory().setBoots(i);
				}
				else if(index == 37){
					p.getInventory().setLeggings(i);
				}
				else if(index == 38){
					p.getInventory().setChestplate(i);
				}
				else if(index == 39){
					p.getInventory().setHelmet(i);
				}
				else{}
			}
			index++;
		}
	}
	
	public ItemStack getReplacedItemStack(SpleefPlayer sp, KitItemStack item, int index, String animatedrightclick){
		if(item.getItemStack().getType() != Material.AIR){
			ItemStack i = item.getItemStack();
			
			ItemStack newi = new ItemStack(i.getType(), i.getAmount());
			ItemMeta meta = i.getItemMeta();
			String displayname = meta.getDisplayName().replace("&", "§");
			//Check Abilities
			if(item.containsAbility(Ability.JUMP)){
				long last = 0;
				if(sp.getCooldown(item) != null){
					last = sp.getCooldown(item);
				}
				
				int cooldown = 1000;
				AbilityMotivier motivier = AbilityMotivier.getMotivier(Ability.JUMP);
				
				if(motivier != null){
					cooldown = cooldown * motivier.getCooldown();
				}
				else{
					cooldown = cooldown * 5;
				}
						
				if(System.currentTimeMillis() - last >= cooldown){
					displayname = displayname.replace("%animated-right-click%", animatedrightclick);
				}
				else{
					int cooldowntime = (int) (cooldown / 1000 - ((System.currentTimeMillis() - last) / 1000));
					displayname = displayname.replace("%animated-right-click%", Message.getMessage(MessageName.ANIMATED_RIGHT_CLICK_ON_COOLDOWN).getMessage().replace("&", "§").replace("%cooldown%", "" + cooldowntime));
				}
			}
			
			if(item.containsAbility(Ability.THROW_EGG)){
				long last = 0;
				if(sp.getCooldown(item) != null){
					last = sp.getCooldown(item);
				}
				
				int cooldown = 1000;
				AbilityMotivier motivier = AbilityMotivier.getMotivier(Ability.THROW_EGG);
				
				if(motivier != null){
					cooldown = cooldown * motivier.getCooldown();
				}
				else{
					cooldown = cooldown * 5;
				}
						
				if(System.currentTimeMillis() - last >= cooldown){
					displayname = displayname.replace("%animated-right-click%", animatedrightclick);
				}
				else{
					int cooldowntime = (int) (cooldown / 1000 - ((System.currentTimeMillis() - last) / 1000));
					displayname = displayname.replace("%animated-right-click%", Message.getMessage(MessageName.ANIMATED_RIGHT_CLICK_ON_COOLDOWN).getMessage().replace("&", "§").replace("%cooldown%", "" + cooldowntime));
				}
			}
			
			if(item.containsAbility(Ability.SPEED_BOOST)){
				long last = 0;
				if(sp.getCooldown(item) != null){
					last = sp.getCooldown(item);
				}
				
				int cooldown = 1000;
				AbilityMotivier motivier = AbilityMotivier.getMotivier(Ability.SPEED_BOOST);
				
				if(motivier != null){
					cooldown = cooldown * motivier.getCooldown();
				}
				else{
					cooldown = cooldown * 5;
				}
						
				if(System.currentTimeMillis() - last >= cooldown){
					displayname = displayname.replace("%animated-right-click%", animatedrightclick);
				}
				else{
					int cooldowntime = (int) (cooldown / 1000 - ((System.currentTimeMillis() - last) / 1000));
					displayname = displayname.replace("%animated-right-click%", Message.getMessage(MessageName.ANIMATED_RIGHT_CLICK_ON_COOLDOWN).getMessage().replace("&", "§").replace("%cooldown%", "" + cooldowntime));
				}
			}
			
			if(item.containsAbility(Ability.NEAREST_PLAYER)){
				SpleefPlayer target = sp.getNearestPlayer();
				int distance = sp.getNearestPlayerDistance();
				
				if(target != null){
					displayname = displayname.replace("%target%", target.getPlayer().getName());
					sp.getPlayer().setCompassTarget(target.getPlayer().getLocation());
				}
				else{
					displayname = displayname.replace("%target%", "");
				}
				
				displayname = displayname.replace("%distance%", distance + "");
			}
			
			if(item.containsAbility(Ability.PLUS_ONE_1)){
				newi = new AbilityManager().handlePlusOne(Ability.PLUS_ONE_1, sp, item, index, newi, meta);
				if(newi != null && newi.getItemMeta() != null){
					meta = newi.getItemMeta();
				}
			}
			else if(item.containsAbility(Ability.PLUS_ONE_2)){
				newi = new AbilityManager().handlePlusOne(Ability.PLUS_ONE_2, sp, item, index, newi, meta);
				if(newi != null && newi.getItemMeta() != null){
					meta = newi.getItemMeta();
				}
			}
			else if(item.containsAbility(Ability.PLUS_ONE_3)){
				newi = new AbilityManager().handlePlusOne(Ability.PLUS_ONE_3, sp, item, index, newi, meta);
				if(newi != null && newi.getItemMeta() != null){
					meta = newi.getItemMeta();
				}
			}
			else if(item.containsAbility(Ability.PLUS_ONE_4)){
				newi = new AbilityManager().handlePlusOne(Ability.PLUS_ONE_4, sp, item, index, newi, meta);
				if(newi != null && newi.getItemMeta() != null){
					meta = newi.getItemMeta();
				}
			}
			else if(item.containsAbility(Ability.PLUS_ONE_5)){
				newi = new AbilityManager().handlePlusOne(Ability.PLUS_ONE_5, sp, item, index, newi, meta);
				if(newi != null && newi.getItemMeta() != null){
					meta = newi.getItemMeta();
				}
			}
			else{}
			
			meta.setDisplayName(displayname);
			if(newi != null){
				newi.setItemMeta(meta);
			}
			return CustomItem.hideFlags(CustomItem.setUnbreakable(newi), 2, 4);
		}
		return CustomItem.hideFlags(CustomItem.setUnbreakable(item.getItemStack()), 2, 4);
	}
	
	public static Kit getKitFromID(int kitid){
		for(Kit kit : StorageManager.kits){
			if(kit.getKitID() == kitid){
				return kit;
			}
		}
		return null;
	}
}
