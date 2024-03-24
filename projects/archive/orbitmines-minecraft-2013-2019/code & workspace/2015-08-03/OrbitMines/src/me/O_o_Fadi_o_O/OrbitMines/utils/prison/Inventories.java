package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.GambleTicketType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.GambleType;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Inventories {
	
	public static class GoldShopInv {
		
		private Inventory inventory;
		
		public GoldShopInv(){
			this.inventory = Bukkit.createInventory(null, 45, "§0§lGold Shop");
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(OMPlayer omp, Material material){
			this.inventory.setContents(getContects(omp, material));
			omp.getPlayer().openInventory(getInventory());
		}
		
		public ItemStack[] getContects(OMPlayer omp, Material material){
			ItemStack[] contents = inventory.getContents();
			
			contents[0] = getCategoryItem(Material.LOG, 0, "§eWood", material);
			contents[1] = getCategoryItem(Material.COBBLESTONE, 0, "§7Stone", material);
			contents[2] = getCategoryItem(Material.COAL, 0, "§8Coal", material);
			contents[3] = getCategoryItem(Material.IRON_INGOT, 0, "§7Iron", material);
			contents[4] = getCategoryItem(Material.DIAMOND, 0, "§bDiamond", material);
			contents[5] = getCategoryItem(Material.EMERALD, 0, "§aEmerald", material);
			contents[6] = getCategoryItem(Material.REDSTONE, 0, "§cRedstone", material);
			contents[7] = getCategoryItem(Material.INK_SACK, 4, "§1Lapis Lazuli", material);
			contents[8] = getCategoryItem(Material.GOLD_INGOT, 0, "§6Gold", material);
			
			if(material != null){
				int durability1 = PrisonUtils.getDurability(material);
				contents[19] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 1), 1, material);
				contents[20] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 4), 4, material);
				contents[21] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 8), 8, material);
				contents[22] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 16), 16, material);
				contents[23] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 32), 32, material);
				contents[24] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 48), 48, material);
				contents[25] = getSellItem(omp, material, durability1, PrisonUtils.getDisplayname(material, 64), 64, material);
				
				Material material2 = PrisonUtils.getSecondMaterial(material);
				int durability2 = PrisonUtils.getDurability(material2);
				contents[28] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 1), 1, material2);
				contents[29] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 4), 4, material2);
				contents[30] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 8), 8, material2);
				contents[31] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 16), 16, material2);
				contents[32] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 32), 32, material2);
				contents[33] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 48), 48, material2);
				contents[34] = getSellItem(omp, material2, durability2, PrisonUtils.getDisplayname(material2, 64), 64, material2);
			}
			else{
				for(int i = 19; i < 35; i++){
					if(i != 26 && i != 27){
						contents[i] = getSellItem(omp, null, 0, "", 0, null);
					}
				}
			}
			
			return contents;
		}
		
		private ItemStack getSellItem(OMPlayer omp, Material m, int durability, String displayname, int amount, Material material){
			if(material != null){
				int reward = (PrisonUtils.getReward(m) * amount);
				double multiplier = omp.getPrisonPlayer().getGoldMultiplier();
				
				if(omp.getPlayer().getInventory().containsAtLeast(Utils.setDurability(new ItemStack(m), durability), amount)){
					ItemStack item = new ItemStack(m, amount);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(displayname);
					List<String> lore = new ArrayList<String>();
					lore.add(" §7Reward: §6§l" + reward + " Gold ");
					if(multiplier != 1){
						lore.add(" §7VIP Bonus: §6§l" + (int) ((reward * multiplier) - reward) + " Gold ");
					}
					meta.setLore(lore);
					item.setItemMeta(meta);
					item.setDurability((short) durability);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§8" + displayname.substring(2));
					List<String> lore = new ArrayList<String>();
					lore.add(" §7Reward: §6§l" + reward + " Gold ");
					if(multiplier != 1){
						lore.add(" §7VIP Bonus: §6§l" + (int) ((reward * multiplier) - reward) + " Gold ");
					}
					meta.setLore(lore);
					item.setItemMeta(meta);
					item.setDurability((short) 15);
					
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8§l???");
				item.setItemMeta(meta);
				item.setDurability((short) 15);
				
				return item;
			}
		}
		
		private ItemStack getCategoryItem(Material m, int durability, String displayname, Material material){
			ItemStack item = new ItemStack(m, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(displayname);
			item.setItemMeta(meta);
			item.setDurability((short) durability);
			
			if(material != null && m == material){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			}
			
			return Utils.hideFlags(item, 1);
		}
	}

	public static class MineInv {
		
		private Inventory inventory;
		
		public MineInv(){
			this.inventory = Bukkit.createInventory(null, 45, "§0§lMines");
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(PrisonPlayer pp){
			this.inventory.setContents(getContects(pp));
			pp.getPlayer().openInventory(getInventory());
		}
		
		public ItemStack[] getContects(PrisonPlayer pp){
			ItemStack[] contents = inventory.getContents();
			
			contents[10] = getMineItem(pp, Rank.Z);
			contents[11] = getMineItem(pp, Rank.Y);
			
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Coming Soon...");
				item.setItemMeta(meta);
				item.setDurability((short) 15);
				
				int index = 3;
				for(int i = 12; i < 35; i++){
					if(i != 17 && i != 18 && i != 26 && i != 27){
						ItemStack item2 = new ItemStack(item);
						item2.setAmount(index);
						contents[i] = item2;
						
						index++;
					}
				}
			}
			
			return contents;
		}
		
		private ItemStack getMineItem(PrisonPlayer pp, Rank rank){
			boolean hasperms = pp.hasPerms(rank);
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, rank.ordinal() +1);
			ItemMeta meta = item.getItemMeta();
			if(hasperms){
				meta.setDisplayName("§7§lMine §a§l" + rank.toString());
			}
			else{
				meta.setDisplayName("§7§lMine §c§l" + rank.toString());
			}
			List<String> lore = new ArrayList<String>();
			if(hasperms){
				if(rank.getNextRank() != null){
					lore.add(" §7Rankup Price: §a" + rank.getRankupPrice() + " Gold ");
				}
				else{
					lore.add(" §7Highest Rank");
				}
				lore.add("");
				lore.add(" §7§lClick to Teleport");
			}
			else{
				if(rank.getNextRank() != null){
					lore.add(" §7Rankup Price: §c" + rank.getRankupPrice() + " Gold ");
				}
				else{
					lore.add(" §7Highest Rank");
				}
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			item.setDurability(Utils.statusDurability(hasperms));
			
			return item;
		}
	}

	public static class VillagerGambleInv {
		
		private Inventory inventory;
		private boolean gambling;
		private int index = 0;
		private int longindex = 2;
		
		public VillagerGambleInv(boolean gambling){
			int size = 9;
			if(gambling){
				size = 45;
			}
			
			Inventory inventory = Bukkit.createInventory(null, size, "§0§lVillager Gamble");
			this.inventory = inventory;
			this.gambling = gambling;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public boolean isGambling(){
			return gambling;
		}
		
		public void open(Player player){
			if(!gambling){
				inventory.setContents(getContects());
			}
			player.openInventory(getInventory());
		}
		
		public void update(final Player player, final GambleType type){
			inventory.setContents(getGambleContects(type));
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 5, 1);
			open(player);
			
			new BukkitRunnable(){
				public void run(){
					index++;
					if(index == 25){
						longindex = 5;
					}
					else if(index == 35){
						longindex = 7;
					}
					else if(index == 42){
						longindex = 10;
					}
					else if(index == 47){
						longindex = 13;
					}
					else if(index == 51){
						longindex = 16;
					}
					else if(index == 54){
						longindex = 20;
					}
					else if(index == 56){
						index = -1;
						
						new BukkitRunnable(){
							public void run(){
								OMPlayer omp = OMPlayer.getOMPlayer(player);
								ItemStack item = inventory.getItem(22);
								GambleTicketType gtype = GambleTicketType.getTicket(item, type);
							
								if(omp != null){
									Bukkit.broadcastMessage(omp.getName() + " §7found " + item.getItemMeta().getDisplayName() + "§7! (" + gtype.getRarity(type).getName() + "§7)");
									
									omp.getPlayer().closeInventory();
									gtype.giveReward(omp.getPrisonPlayer());
									
									if(gtype.getRarity(type) == me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rarity.LEGENDARY){
										for(Player p : Bukkit.getOnlinePlayers()){
											p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
										}
									}
									else{
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
									}
								}
							}
						}.runTaskLater(Start.getInstance(), 40);
					}
					else{}
					
					if(index != -1){
						update(player, type);
					}
				}
			}.runTaskLater(Start.getInstance(), longindex);
		}
		
		private ItemStack[] getContects(){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			{
				ItemStack item = new ItemStack(Material.IRON_BLOCK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§lStart Iron Gamble Machine");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §a§l1 Gamble Ticket ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lStart Gold Gamble Machine");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §a§l3 Gamble Tickets ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[2] = item;
			}
			{
				ItemStack item = new ItemStack(Material.DIAMOND_BLOCK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§b§lStart Diamond Gamble Machine");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §a§l5 Gamble Tickets ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[3] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMERALD, 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§l+5 Gamble Tickets");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §b250 VIP Points ");
				meta.setLore(lore);
				item.setItemMeta(meta);;
				contents[5] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMERALD, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§0§a§l+1 Gamble Ticket");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §e5 OMT ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[6] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMERALD, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§l+1 Gamble Ticket");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §6§l10000 Gold ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[7] = item;
			}
			
			return contents;
		}
		
		private ItemStack[] getGambleContects(GambleType type){
			ItemStack[] contents = inventory.getContents();
			
			ItemStack slot1 = contents[4];
			ItemStack slot2 = contents[13];
			ItemStack slot3 = contents[22];
			ItemStack slot4 = contents[31];
			if(slot1 == null){
				contents[4] = GambleTicketType.getRandom(type);
				contents[13] = GambleTicketType.getRandom(type);
				contents[22] = GambleTicketType.getRandom(type);
				contents[31] = GambleTicketType.getRandom(type);
				contents[40] = GambleTicketType.getRandom(type);
			}
			else{
				contents[4] = GambleTicketType.getRandom(type);
				contents[13] = slot1;
				contents[22] = slot2;
				contents[31] = slot3;
				contents[40] = slot4;
			}
			
			contents[21] = getBlackRollingItemStack();
			contents[23] = getBlackRollingItemStack();
			
			for(int i = 0; i < 45; i++){
				if(i != 4 && i != 13 && i != 22 && i != 31 && i != 40 && i != 21 && i != 23){
					contents[i] = getRollingItemStack(type);
				}
			}
			
			return contents;
		}
		
		private ItemStack getRollingItemStack(GambleType type){
			List<Short> durabilities = Arrays.asList((short) 5, (short) 13);
			switch(type){
				case DIAMOND_MACHINE:
					durabilities = Arrays.asList((short) 5, (short) 13, (short) 3);
					break;
				case GOLD_MACHINE:
					durabilities = Arrays.asList((short) 5, (short) 13, (short) 4);
					break;
				case IRON_MACHINE:
					durabilities = Arrays.asList((short) 5, (short) 13, (short) 8);
					break;
			}
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			item.setDurability(durabilities.get(new Random().nextInt(durabilities.size())));

			return item;
		}
		private ItemStack getBlackRollingItemStack(){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			item.setDurability((short) 15);

			return item;
		}
	}

}
