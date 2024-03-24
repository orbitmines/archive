package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.CustomItem;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.AnvilGUI;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPCType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NPCManager {
	
	public static void openNPCInventory(Player p, NPC npc){
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lEdit NPC");
	
		if(npc.getNPCType() == NPCType.ARENA_SELECTOR){
			{
				ItemStack item = new ItemStack(Material.NAME_TAG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§e§lSet NPC Name");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7Current Name: §f" + npc.getDisplayname().replace("&", "§") + " ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(10, item);
			}
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSet Mob Type");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7Current Mob: " + getEntityTypeDisplayname(npc.getEntityType()) + " ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(npc.getSpawnEggID());
				inv.setItem(13, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§2§lSave");
				item.setItemMeta(meta);
				item.setDurability((short) 13);
				inv.setItem(16, item);
			}
		}
		if(npc.getNPCType() == NPCType.KIT_SELECTOR){
			{
				ItemStack item = new ItemStack(Material.NAME_TAG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§e§lSet NPC Name");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7Current Name: §f" + npc.getDisplayname().replace("&", "§") + " ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(10, item);
			}
			{
				ItemStack item = new ItemStack(Material.IRON_SPADE, npc.getKit().getKitID());
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§lSet Kit");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7Current Kit: §6§l" + npc.getKit().getName() + " ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(12, CustomItem.hideFlags(item, 2));
			}
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSet Mob Type");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7Current Mob: " + getEntityTypeDisplayname(npc.getEntityType()) + " ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(npc.getSpawnEggID());
				inv.setItem(14, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§2§lSave");
				item.setItemMeta(meta);
				item.setDurability((short) 13);
				inv.setItem(16, item);
			}
		}
		
		p.openInventory(inv);
	}
	
	public static void openNPCKitEditor(Player p, NPC npc){
		Message m = Message.getMessage(MessageName.OPEN_NPC_KIT_EDITOR);
		m.replace("&", "§");
		m.send(p);
		
		Inventory inv = Bukkit.createInventory(null, 9, "§0§lEdit NPC - Kit Editor");
	
		int index = 0;
		for(Kit kit : StorageManager.kits){
			if(inv.getSize() <= (index +1)){
				inv.setMaxStackSize(inv.getSize() +9);
			}
			
			ItemStack item = new ItemStack(Material.IRON_SPADE, kit.getKitID());
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7§lSet NPC Kit to: §6§l" + kit.getName());
			item.setItemMeta(meta);
			
			if(kit == npc.getKit()){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			}
					
			inv.setItem(index, CustomItem.hideFlags(item, 1, 2));
			index++;
		}
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static void openNPCMobEditor(Player p, NPC npc){
		Message m = Message.getMessage(MessageName.OPEN_NPC_MOB_EDITOR);
		m.replace("&", "§");
		m.send(p);
		
		Inventory inv = Bukkit.createInventory(null, 36, "§0§lEdit NPC - Mob Editor");
	
		int index = 0;
		for(EntityType type : getValidNPCTypes()){
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§lSet NPC Mob to: " + getEntityTypeDisplayname(type));
			item.setItemMeta(meta);
			item.setDurability((short) type.getTypeId());
			
			if(type == npc.getEntityType()){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = CustomItem.hideFlags(item, 1);
			}
					
			inv.setItem(index, item);
			index++;
		}
		
		p.openInventory(inv);
	}
	
	public static List<EntityType> getValidNPCTypes(){
		return Arrays.asList(EntityType.BAT, EntityType.BLAZE, EntityType.CAVE_SPIDER, EntityType.CHICKEN, EntityType.COW, EntityType.CREEPER, EntityType.ENDERMAN, EntityType.ENDERMITE, EntityType.GHAST, /*EntityType.GUARDIAN,*/ EntityType.HORSE, EntityType.IRON_GOLEM, EntityType.MAGMA_CUBE, EntityType.MUSHROOM_COW, EntityType.OCELOT, EntityType.PIG, EntityType.PIG_ZOMBIE, EntityType.RABBIT, EntityType.SHEEP, EntityType.SILVERFISH, EntityType.SKELETON, EntityType.SLIME, EntityType.SNOWMAN, EntityType.SPIDER, EntityType.SQUID, EntityType.VILLAGER, EntityType.WITCH, /*EntityType.WITHER,*/ EntityType.WOLF, EntityType.ZOMBIE);
	}
	
	public static String getEntityTypeDisplayname(EntityType type){
		switch(type){
			case ARMOR_STAND:
				break;
			case ARROW:
				break;
			case BAT:
				return "§8§lBat";
			case BLAZE:
				return "§6§lBlaze";
			case BOAT:
				break;
			case CAVE_SPIDER:
				return "§3§lCave Spider";
			case CHICKEN:
				return "§7§lChicken";
			case COMPLEX_PART:
				break;
			case COW:
				return "§8§lCow";
			case CREEPER:
				return "§a§lCreeper";
			case DROPPED_ITEM:
				break;
			case EGG:
				break;
			case ENDERMAN:
				return "§3§lEnderman";
			case ENDERMITE:
				return "§8§lEndermite";
			case ENDER_CRYSTAL:
				break;
			case ENDER_DRAGON:
				break;
			case ENDER_PEARL:
				break;
			case ENDER_SIGNAL:
				break;
			case EXPERIENCE_ORB:
				break;
			case FALLING_BLOCK:
				break;
			case FIREBALL:
				break;
			case FIREWORK:
				break;
			case FISHING_HOOK:
				break;
			case GHAST:
				return "§f§lGhast";
			case GIANT:
				break;
			case GUARDIAN:
				//return "§3§lGuardian";
				break;
			case HORSE:
				return "§e§lHorse";
			case IRON_GOLEM:
				return "§f§lIron Golem";
			case ITEM_FRAME:
				break;
			case LEASH_HITCH:
				break;
			case LIGHTNING:
				break;
			case MAGMA_CUBE:
				return "§c§lMagma Cube";
			case MINECART:
				break;
			case MINECART_CHEST:
				break;
			case MINECART_COMMAND:
				break;
			case MINECART_FURNACE:
				break;
			case MINECART_HOPPER:
				break;
			case MINECART_MOB_SPAWNER:
				break;
			case MINECART_TNT:
				break;
			case MUSHROOM_COW:
				return "§c§lMushroom Cow";
			case OCELOT:
				return "§e§lOcelot";
			case PAINTING:
				break;
			case PIG:
				return "§d§lPig";
			case PIG_ZOMBIE:
				return "§d§lZombie Pigman";
			case PLAYER:
				break;
			case PRIMED_TNT:
				break;
			case RABBIT:
				return "§6§lRabbit";
			case SHEEP:
				return "§f§lSheep";
			case SILVERFISH:
				return "§7§lSilverfish";
			case SKELETON:
				return "§7§lSkeleton";
			case SLIME:
				return "§a§lSlime";
			case SMALL_FIREBALL:
				break;
			case SNOWBALL:
				break;
			case SNOWMAN:
				return "§f§lSnowman";
			case SPIDER:
				return "§8§lSpider";
			case SPLASH_POTION:
				break;
			case SQUID:
				return "§3§lSquid";
			case THROWN_EXP_BOTTLE:
				break;
			case UNKNOWN:
				break;
			case VILLAGER:
				return "§6§lVillager";
			case WEATHER:
				break;
			case WITCH:
				return "§3§lWitch";
			case WITHER:
				//return "§8§lWither";
				break;
			case WITHER_SKULL:
				break;
			case WOLF:
				return "§7§lWolf";
			case ZOMBIE:
				return "§2§lZombie";
			default:
				break;
		}
		return "";
	}
	
	public static void openNPCNameEditor(final Player p, final NPC npc){
		Message m = Message.getMessage(MessageName.OPEN_MAP_SETUP_NAME_EDITOR);
		m.replace("&", "§");
		m.send(p);
		
		final AnvilGUI gui = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler(){
			@Override
			public void onAnvilClick(AnvilGUI.AnvilClickEvent e){
				if(e.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
					String s = e.getName();
					e.setWillClose(true);
					e.setWillDestroy(true);
					
					npc.setDisplayname(s);
					npc.getEntity().setCustomName(s.replace("&", "§"));
					if(npc.getKit() != null){
						npc.getEntity().setCustomName(npc.getEntity().getCustomName().replace("%kit-name%", npc.getKit().getName()));
					}

					if(npc.getItem() != null){
						npc.getItem().remove();
						npc.setItem(null);
					}
					
					Message m = Message.getMessage(MessageName.SET_NPC_NAME);
					m.replace("&", "§");
					m.replace("%npc-name%", s.replace("&", "§"));
					m.send(p);
				}
				else{
					e.setWillClose(false);
					e.setWillDestroy(false);
				}
			}
		});
		
		{
			ItemStack item = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("Insert Mobname");
			item.setItemMeta(meta);
			gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, item);
		}
	
		gui.open();
	}
	
	public static void setNPCMob(Player p, NPC npc, EntityType type){
		Message m = Message.getMessage(MessageName.SET_NPC_MOB);
		m.replace("&", "§");
		m.replace("%mob-name%", getEntityTypeDisplayname(type));
		m.send(p);
		
		Location location = npc.getEntity().getLocation();
		String displayname = npc.getEntity().getCustomName();
		npc.setEntityType(type);
		npc.getEntity().remove();
		npc.setEntity(null);
		if(npc.getItem() != null){
			npc.getItem().remove();
			npc.setItem(null);
		}
		npc.newEntity(type, location, displayname);
		p.closeInventory();
	}
	
	public static void setNPCKit(Player p, NPC npc, Kit kit){
		Message m = Message.getMessage(MessageName.SET_NPC_KIT);
		m.replace("&", "§");
		m.replace("%kit-name%", kit.getName());
		m.send(p);
		
		npc.setKit(kit);

		npc.getEntity().setCustomName(npc.getDisplayname().replace("&", "§").replace("%kit-name%", kit.getName()));

		if(npc.getItem() != null){
			npc.getItem().remove();
			npc.setItem(null);
		}
		p.closeInventory();
	}
	
	public static void saveNPCs(Player p){
		Message m = Message.getMessage(MessageName.SAVE_NPC_EDITOR);
		m.replace("&", "§");
		m.send(p);
		
		ArenaManager.saveArenaSelectors();
		ArenaManager.saveKitSelectors();
		p.closeInventory();
	}
}
