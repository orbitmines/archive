package me.O_o_Fadi_o_O.OrbitMines.utils.creative;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.AnvilGUI;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Inventories {

	public static class PlotKitInv {
		
		private Inventory inventory;
		private Kit kit;
		
		public PlotKitInv(Plot plot, Kit kit){
			this.kit = kit;
			
			if(kit != null){
				this.inventory = Bukkit.createInventory(null, 27, "§0§lKit: " + kit.getKitName());
			}
			else{
				this.inventory = Bukkit.createInventory(null, 27, "§0§lKit: ");
			}
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			inventory.setContents(getContects());
			player.openInventory(getInventory());
		}
		
		public ItemStack[] getContects(){
			ItemStack[] contents = inventory.getContents();
			
			if(contents[0] == null){
				if(kit.getBoots() == null){
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§fHelmet Slot: §7§lEmpty");
					item.setItemMeta(meta);
					contents[0] = item;
				}
				else{
					contents[0] = new ItemStack(kit.getBoots());
				}
			}
			if(contents[1] == null){
				if(kit.getLeggings() == null){
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§fChestplate Slot: §7§lEmpty");
					item.setItemMeta(meta);
					contents[1] = item;
				}
				else{
					contents[1] = new ItemStack(kit.getLeggings());
				}
			}
			if(contents[2] == null){
				if(kit.getChestplate() == null){
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§fLeggings Slot: §7§lEmpty");
					item.setItemMeta(meta);
					contents[2] = item;
				}
				else{
					contents[2] = new ItemStack(kit.getChestplate());
				}
			}
			if(contents[3] == null){
				if(kit.getHelmet() == null){
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§fBoots Slot: §7§lEmpty");
					item.setItemMeta(meta);
					contents[3] = item;
				}
				else{
					contents[3] = new ItemStack(kit.getHelmet());
				}
			}
			
			if(contents[8] == null){
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§lDelete Kit");
				item.setItemMeta(meta);
				item.setDurability((short) 14);
				contents[8] = item;
			}
			
			for(int i = 18; i <= 26; i++){
				if(contents[i] == null){
					if(kit.getItem(i - 18) == null){
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, (i - 17));
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§fHotbar Slot " + (i - 17) + ": §7§lEmpty");
						item.setItemMeta(meta);
						contents[i] = item;
					}
					else{
						contents[i] = new ItemStack(kit.getItem(i - 18));
					}
				}
			}
			
			return contents;
		}
	}

	public static class PlotSetupInv {
		
		private Inventory inventory;
		
		public PlotSetupInv(){
			Inventory inventory = Bukkit.createInventory(null, 27, "§0§lPlot Setup");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			CreativePlayer cp = omp.getCreativePlayer();
			Plot plot = cp.getPlot();
			
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Set Max Players to: §a§l" + (plot.getPvPMaxPlayers() +1));
				if(plot.getPvPMaxPlayers() == 50){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[0] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Set §a§lSpawnpoint #" + (plot.getPvPSpawns().size() +1));
				if(plot.getPvPSpawns().size() == 50){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Set §a§lLobby§7");
				item.setItemMeta(meta);
					
				contents[2] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lENABLE§7 Arrow Entities");
				if(plot.hasPvPArrows()){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[3] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lENABLE§7 Building");
				if(plot.canPvPBuild()){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[4] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lENABLE§7 Item Drops");
				if(plot.hasPvPDrops()){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[5] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Add §a§lKit");
				if(plot.getPvPKits().size() == 4){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[6] = item;
			}
			{
				ItemStack item = new ItemStack(Material.SKULL_ITEM, plot.getPvPMaxPlayers());
				item.setDurability((short) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Max Players: §7§l" + plot.getPvPMaxPlayers());
				item.setItemMeta(meta);
					
				contents[9] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_PEARL, plot.getPvPSpawns().size());
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Spawnpoints: §7§l" + plot.getPvPSpawns().size());
				item.setItemMeta(meta);
					
				contents[10] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Lobby");
				item.setItemMeta(meta);
					
				contents[11] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ARROW, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Arrow Entities: " + Utils.statusString(plot.hasPvPArrows()));
				item.setItemMeta(meta);
					
				contents[12] = item;
			}
			{
				ItemStack item = new ItemStack(Material.GRASS, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Building: " + Utils.statusString(plot.canPvPBuild()));
				item.setItemMeta(meta);
					
				contents[13] = item;
			}
			{
				ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Item Drops: " + Utils.statusString(plot.hasPvPDrops()));
				item.setItemMeta(meta);
					
				contents[14] = item;
			}
			{
				ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Kits: §7§l" + plot.getPvPKits().size());
				if(plot.getPvPKits().size() > 0){
					List<String> lore = new ArrayList<String>();
					lore.add("");
					for(Kit kit : plot.getPvPKits()){
						lore.add(" §7- §7§l" + kit.getKitName() + " ");
					}
					meta.setLore(lore);
				}
				item.setItemMeta(meta);
					
				contents[15] = Utils.hideFlags(item, 2);
			}
			{
				boolean canfinish = true;
				
				ItemStack item = new ItemStack(Material.STAINED_CLAY, 1);
				item.setDurability((short) 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lFinish Setup");
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Max Players: §a§l✔ ");
				if(plot.getPvPSpawns().size() > 0){
					lore.add(" §7Spawnpoints: §a§l✔ ");
				}
				else{
					lore.add(" §7Spawnpoints: §4§l✘ ");
					canfinish = false;
				}
				if(plot.getPvPLobbyLocation() != null){
					lore.add(" §7Lobby: §a§l✔ ");
				}
				else{
					lore.add(" §7Lobby: §4§l✘ ");
					canfinish = false;
				}
				lore.add(" §7Arrow Entities: §a§l✔ ");
				lore.add(" §7Building: §a§l✔ ");
				lore.add(" §7Item Drops: §a§l✔ ");
				if(plot.getPvPKits().size() > 0){
					lore.add(" §7Kits: §a§l✔ ");
				}
				else{
					lore.add(" §7Kits: §4§l✘ ");
					canfinish = false;
				}
				lore.add("");
				if(canfinish){
					lore.add(" §7Can Finish Setup: §a§l✔ ");
				}
				else{
					meta.setDisplayName("§c§lFinish Setup");
					item.setDurability((short) 14);
					lore.add(" §7Can Finish Setup: §4§l✘ ");
				}
				meta.setLore(lore);
				item.setItemMeta(meta);
					
				contents[17] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 14);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Set Max Players to: §c§l" + (plot.getPvPMaxPlayers() -1));
				if(plot.getPvPMaxPlayers() == 4){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[18] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 14);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Reset §c§lSpawnpoints");
				if(plot.getPvPSpawns().size() == 0){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[19] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 7);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8Unavailable");
				item.setItemMeta(meta);
					
				contents[20] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 14);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§lDISABLE§7 Arrow Entities");
				if(!plot.hasPvPArrows()){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[21] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 14);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§lDISABLE§7 Building");
				if(!plot.canPvPBuild()){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[22] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 14);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§lDISABLE§7 Item Drops");
				if(!plot.hasPvPDrops()){
					item.setDurability((short) 7);
					meta.setDisplayName("§8Unavailable");
				}
				item.setItemMeta(meta);
					
				contents[23] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				item.setDurability((short) 7);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8Unavailable");
				item.setItemMeta(meta);
					
				contents[24] = item;
			}
			
			return contents;
		}
	}

	public static class PlotInfoInv {
		
		private Inventory inventory;
		
		public PlotInfoInv(){
			Inventory inventory = Bukkit.createInventory(null, 9, "§0§lPlot Info");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			CreativePlayer cp = omp.getCreativePlayer();
			
			if(cp.hasPlot()){
				inventory.setContents(getContects(player));
				player.openInventory(getInventory());
			}
			else{
				player.sendMessage("§7Your §dPlot§7 hasn't been generated yet!");
			}
		}
		
		private ItemStack[] getContects(Player player){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			CreativePlayer cp = omp.getCreativePlayer();
			Plot plot = cp.getPlot();
			
			{
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				item.setDurability((short) 3);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setDisplayName("§6§lPlot Members §6(§7" + (plot.getMemberUUIDs().size() +1) + "§6/§7" + cp.getMaxMembers() + "§6)");
				meta.setOwner(player.getName());
				item.setItemMeta(meta);
				
				contents[2] = item;
			}
			{
				ItemStack item = new ItemStack(Material.PAPER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§lPlot " + plot.getPlotID());
				List<String> lore = new ArrayList<String>();
				lore.add("  §dOwner: §7" + player.getName());
				lore.add("  §dCreated: §7" + plot.getCreatedDate());
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[4] = item;
			}
			{
				ItemStack item = new ItemStack(plot.getPlotType().getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§lPlot Mode §8| " + plot.getPlotType().getName());
				if(!omp.hasPerms(VIPRank.Emerald_VIP)){
					List<String> lore = new ArrayList<String>();
					lore.add("");
					lore.add("§7Required: §a§lEmerald VIP");
					lore.add("");
					meta.setLore(lore);
				}
				item.setItemMeta(meta);
				contents[6] = Utils.hideFlags(item, 2);
			}
			
			return contents;
		}
	}

	public static class PlotMembersInv {
		
		private Inventory inventory;
		
		public PlotMembersInv(){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lPlot Members");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			CreativePlayer cp = omp.getCreativePlayer();
			Plot plot = cp.getPlot();
			
			{
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				item.setDurability((short) 3);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setDisplayName("§d§l" + player.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("  §dRank: §7Owner  ");
				lore.add("  §dStatus: §aOnline  ");
				meta.setOwner(player.getName());
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[1] = item;
			}
			
			List<UUID> uuids = plot.getMemberUUIDs();
			int index = 2;
			for(int i = 1; i <= 20; i++){
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				if((cp.getMaxMembers() -1) >= i){
					item.setDurability((short) 1);
					
					if(uuids.size() >= i){
						item.setDurability((short) 3);
						List<String> lore = new ArrayList<String>();
						UUID uuid = uuids.get((i -1));
						Player p = Utils.getPlayer(uuid);
						
						if(p == null){
							String pname = Utils.getName(uuid);
							meta.setDisplayName("§d§l" + pname);
							lore.add("  §dRank: §7Member  ");
							lore.add("  §dStatus: §cOffline  ");
							meta.setOwner(pname);
						}
						else{
							meta.setDisplayName("§d§l" + p.getName());
							lore.add("  §dRank: §7Member  ");
							lore.add("  §dStatus: §aOnline  ");
							meta.setOwner(p.getName());
						}
						meta.setLore(lore);
					}
					else{
						meta.setDisplayName("§7§lEmpty Slot");
					}

					item.setItemMeta(meta);
				}
				else{
					if(i >= 14){
						meta.setDisplayName("§a§lEmerald VIP §7§lSlot");
					}
					else if(i >= 9){
						meta.setDisplayName("§9§lDiamond VIP §7§lSlot");
					}
					else if(i >= 5){
						meta.setDisplayName("§6§lGold VIP §7§lSlot");
					}
					else if(i >= 3){
						meta.setDisplayName("§7§lIron VIP §7§lSlot");
					}
					else{}
				}
				item.setItemMeta(meta);
				
				contents[index] = item;
				
				index++;
				if(index == 8){index = 10;}
				if(index == 17){index = 19;}
			}
			{
				ItemStack item = new ItemStack(Material.PAPER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§lPlot Info");
				item.setItemMeta(meta);
				
				contents[40] = item;
			}
			
			return contents;
		}
	}
	
	public static class PlotKitNameGUI {
		
		private AnvilGUI anvilgui;
		
		public PlotKitNameGUI(final OMPlayer omp){
			this.anvilgui = new AnvilGUI(omp.getPlayer(), new AnvilGUI.AnvilClickEventHandler(){
				
				@Override
				public void onAnvilClick(AnvilGUI.AnvilClickEvent e){
					if(e.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
						String kitname = e.getName();
						Player p = omp.getPlayer();
						CreativePlayer cp = omp.getCreativePlayer();
						Plot plot = cp.getPlot();
						
						Kit kit = null;
						for(Kit k : plot.getPvPKits()){
							if(k.getKitName().equals(kitname)){
								kit = k;
							}
						}
						
						if(kit == null){
							if(kitname.length() <= 20){
								boolean cancreate = true;
								for(int i = 0; i < kitname.length(); i++){
									int c = kitname.charAt(i);
									if(!Character.isAlphabetic(c) && !Character.isDigit(c)){
										cancreate = false;
									}
								}
	
								e.setWillClose(cancreate);
								e.setWillDestroy(cancreate);
								if(cancreate){
									p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
									p.sendMessage("§7Created a Kit! (§a§l" + kitname + "§7)");
									plot.createKit(p.getLocation(), kitname);
								}
								else{
									p.sendMessage("§7Only §dalphabetic§7 and §dnumeric§7 characters are allowed!");
								}
							}
							else{
								e.setWillClose(false);
								e.setWillDestroy(false);
								
								p.sendMessage("§7You may only use §d20 characters§7 in the name of a kit!");
							}
						}
						else{
							e.setWillClose(false);
							e.setWillDestroy(false);
							
							p.sendMessage("§7You already have a Kit named '§a§l" + kitname + "§7'.");
						}
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
				meta.setDisplayName("Insert Kit name");
				item.setItemMeta(meta);
				this.anvilgui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, item);
			}
		}
		
		public AnvilGUI getAnvilGUI(){
			return anvilgui;
		}
		public void setAnvilGUI(AnvilGUI anvilgui){
			this.anvilgui = anvilgui;
		}
		
		public void open(){
			anvilgui.open();
		}
	}
}