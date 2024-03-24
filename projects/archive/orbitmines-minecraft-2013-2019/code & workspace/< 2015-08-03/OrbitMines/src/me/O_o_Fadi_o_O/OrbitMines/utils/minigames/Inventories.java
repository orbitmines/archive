package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.InvType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.Rarity;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.Uses;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Inventories {
	
	public static class StatsInv {
		
		private Inventory inventory;
		
		public StatsInv(){
			Inventory inventory = Bukkit.createInventory(null, 27, "§0§lYour Stats");
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
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			SurvivalGamesPlayer sgp = omp.getSGPlayer();
			SkywarsPlayer swp = omp.getSWPlayer();
			GhostAttackPlayer gap = omp.getGAPlayer();
			SplatcraftPlayer scp = omp.getSCPlayer();
			UHCPlayer uhcp = omp.getUHCPlayer();
			ChickenFightPlayer cfp = omp.getCFPlayer();
			SpleefPlayer spp = omp.getSPPlayer();
			
			{
				ItemStack item = new ItemStack(Material.COMPASS, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Games Played: §f" + (sgp.getWins() + sgp.getLoses() + swp.getWins() + swp.getLoses() + gap.getWins() + gap.getLoses() + gap.getGhostWins() + scp.getWins() + scp.getLoses() + uhcp.getWins() + uhcp.getLoses() + cfp.getWins() + cfp.getLoses() + spp.getWins()+ spp.getLoses()));
				item.setItemMeta(meta);
				contents[4] = item;
			}
			{
				ItemStack item = new ItemStack(MiniGameType.SURVIVAL_GAMES.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.SURVIVAL_GAMES.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (sgp.getWins() + sgp.getLoses()) + " ");
				lore.add(" §7Wins: §f" + sgp.getWins() + " ");
				lore.add(" §7Kills: §f" + sgp.getKills() + " ");
				lore.add(" §7Best Streak: §f" + sgp.getBeststreak() + " ");
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.SURVIVAL_GAMES.getDurability());
				contents[10] = Utils.hideFlags(item, 2);
			}
			{
				ItemStack item = new ItemStack(MiniGameType.SKYWARS.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.SKYWARS.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (swp.getWins() + swp.getLoses()) + " ");
				lore.add(" §7Wins: §f" + swp.getWins() + " ");
				lore.add(" §7Kills: §f" + swp.getKills() + " ");
				lore.add(" §7Best Streak: §f" + swp.getBeststreak() + " ");
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.SKYWARS.getDurability());
				contents[12] = item;
			}
			{
				ItemStack item = new ItemStack(MiniGameType.GHOST_ATTACK.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.GHOST_ATTACK.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (gap.getWins() + gap.getLoses() + gap.getGhostWins()) + " ");
				lore.add(" §7Wins (Player): §f" + gap.getWins() + " ");
				lore.add(" §7Kills (Player): §f" + gap.getKills() + " ");
				lore.add(" §7Wins (Ghost): §f" + gap.getGhostWins() + " ");
				lore.add(" §7Kills (Ghost): §f" + gap.getGhostKills() + " ");
				lore.add(" §7Best Streak: §f" + gap.getBeststreak() + " ");
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.GHOST_ATTACK.getDurability());
				contents[14] = item;
			}
			{
				ItemStack item = new ItemStack(MiniGameType.SPLATCRAFT.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.SPLATCRAFT.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (scp.getWins() + scp.getLoses()) + " ");
				lore.add(" §7Wins: §f" + scp.getWins() + " ");
				lore.add(" §7Kills: §f" + scp.getKills() + " ");
				lore.add(" §7Best Streak: §f" + scp.getBeststreak() + " ");
				lore.add(" §7Blocks Colored: §f" + scp.getBlocksColored() + " ");
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.SPLATCRAFT.getDurability());
				contents[16] = item;
			}
			{
				ItemStack item = new ItemStack(MiniGameType.ULTRA_HARD_CORE.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.ULTRA_HARD_CORE.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (uhcp.getWins() + uhcp.getLoses()) + " ");
				lore.add(" §7Wins: §f" + uhcp.getWins() + " ");
				lore.add(" §7Kills: §f" + uhcp.getKills() + " ");
				lore.add(" §7Best Streak: §f" + uhcp.getBeststreak());
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.ULTRA_HARD_CORE.getDurability());
				contents[20] = item;
			}
			{
				ItemStack item = new ItemStack(MiniGameType.CHICKEN_FIGHT.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.CHICKEN_FIGHT.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (cfp.getWins() + cfp.getLoses()) + " ");
				lore.add(" §7Wins: §f" + cfp.getWins() + " ");
				lore.add(" §7Kills: §f" + cfp.getKills() + " ");
				lore.add(" §7Best Streak: §f" + cfp.getBeststreak() + " ");
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.CHICKEN_FIGHT.getDurability());
				contents[22] = item;
			}
			{
				ItemStack item = new ItemStack(MiniGameType.SPLEEF.getMaterial(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l" + MiniGameType.SPLEEF.getName());
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §7Games Played: §f" + (spp.getWins() + spp.getLoses()) + " ");
				lore.add(" §7Wins: §f" + spp.getWins() + " ");
				lore.add(" §7Kills: §f" + spp.getKills() + " ");
				lore.add(" §7Best Streak: §f" + spp.getBeststreak() + " ");
				lore.add(" §7Blocks Broken: §f" + spp.getBlocksBroken() + " ");
				lore.add("");
				lore.add(" §aClick for Details ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(MiniGameType.SPLEEF.getDurability());
				contents[24] = Utils.hideFlags(item, 2);
			}
			
			return contents;
		}
	}

	public static class TicketInv {
		
		private Inventory inventory;
		private boolean gambling;
		private int index = 0;
		private int longindex = 2;
		
		public TicketInv(boolean gambling){
			int size = 9;
			if(gambling){
				size = 45;
			}
			
			Inventory inventory = Bukkit.createInventory(null, size, "§0§lTicket Gamble");
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
		
		public void update(final Player player){
			inventory.setContents(getGambleContects());
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
								Ticket ticket = TicketType.getTicket(item);
								
								if(omp != null){
									if(ticket.getType().getUses() == Uses.ONE_TIME || omp.getTicketAmount(ticket.getType()) == 0){
										Bukkit.broadcastMessage(omp.getName() + " §7found " + item.getItemMeta().getDisplayName() + "§7! (" + ticket.getType().getRarity().getName() + "§7)");
									}
									else{
										player.sendMessage("§7You found " + item.getItemMeta().getDisplayName() + "§7! (" + ticket.getType().getRarity().getName() + "§7)");
										player.sendMessage("§7Already §a§lUnlocked§7! (§f§l+" + ticket.getType().getRarity().getRefund() + " Coins§7)");
										
										omp.addMiniGameCoins(ticket.getType().getRarity().getRefund());
									}
									omp.getPlayer().closeInventory();
									omp.addTicketAmount(ticket.getType(), ticket.getAmount());
									
									if(ticket.getType().getRarity() == Rarity.LEGENDARY){
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
						update(player);
					}
				}
			}.runTaskLater(Start.getInstance(), longindex);
		}
		
		private ItemStack[] getContects(){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lStart Ticket Gamble");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §f§l3 Tickets ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability((short) 5);
				contents[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§lCancel");
				item.setItemMeta(meta);
				item.setDurability((short) 14);
				contents[2] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMPTY_MAP, 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l+5 Tickets");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §b40 VIP Points ");
				meta.setLore(lore);
				item.setItemMeta(meta);;
				contents[5] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMPTY_MAP, 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§0§f§l+3 Tickets");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §e3 OMT ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[6] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMPTY_MAP, 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§l+3 Tickets");
				List<String> lore = new ArrayList<String>();
				lore.add(" §cPrice: §f§l100 Coins ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[7] = item;
			}
			
			return contents;
		}
		
		private ItemStack[] getGambleContects(){
			ItemStack[] contents = inventory.getContents();
			
			ItemStack slot1 = contents[4];
			ItemStack slot2 = contents[13];
			ItemStack slot3 = contents[22];
			ItemStack slot4 = contents[31];
			if(slot1 == null){
				contents[4] = TicketType.getRandom();
				contents[13] = TicketType.getRandom();
				contents[22] = TicketType.getRandom();
				contents[31] = TicketType.getRandom();
				contents[40] = TicketType.getRandom();
			}
			else{
				contents[4] = TicketType.getRandom();
				contents[13] = slot1;
				contents[22] = slot2;
				contents[31] = slot3;
				contents[40] = slot4;
			}
			
			contents[21] = getBlackRollingItemStack();
			contents[23] = getBlackRollingItemStack();
			
			for(int i = 0; i < 45; i++){
				if(i != 4 && i != 13 && i != 22 && i != 31 && i != 40 && i != 21 && i != 23){
					contents[i] = getRollingItemStack();
				}
			}
			
			return contents;
		}
		
		private ItemStack getRollingItemStack(){
			List<Short> durabilities = Arrays.asList((short) 0, (short) 1, (short) 3, (short) 4, (short) 5, (short) 6, (short) 14);
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

	public static class MiniGamesInv {
		
		private Inventory inventory;
		
		public MiniGamesInv(){
			Inventory inventory = Bukkit.createInventory(null, 9, "§0§lMiniGames");
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
			
			{
				ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§lTicket Gamble");
				item.setItemMeta(meta);
				contents[2] = item;
			}
			{
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setDisplayName("§2§lStats");
				meta.setOwner(player.getName());
				item.setItemMeta(meta);
				item.setDurability((short) 3);
				contents[6] = item;
			}
			return contents;
		}
	}

	public static class MiniGameTicketInv {
		
		private Inventory inventory;
		private MiniGameType type;
		private InvType invtype;
		
		public MiniGameTicketInv(MiniGameType type, InvType invtype){
			if(invtype == InvType.KITS || type == MiniGameType.ULTRA_HARD_CORE || type == MiniGameType.SKYWARS || type == MiniGameType.CHICKEN_FIGHT){
				Inventory inventory = Bukkit.createInventory(null, 45, "§0§l" + type.getName());
				this.inventory = inventory;
			}
			else{
				Inventory inventory = Bukkit.createInventory(null, 54, "§0§l" + type.getName());
				this.inventory = inventory;
			}
			this.type = type;
			this.invtype = invtype;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public MiniGameType getMiniGameType(){
			return type;
		}
		public void setMiniGameType(MiniGameType type){
			this.type = type;
		}
		
		public InvType getInvType(){
			return invtype;
		}
		public void setInvType(InvType invtype){
			this.invtype = invtype;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			switch(getMiniGameType()){
				case CHICKEN_FIGHT:
					if(getInvType() == InvType.KITS){
						for(TicketType type : TicketType.getCFKits()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					else{
						for(TicketType type : TicketType.getCFPerks()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					break;
				case GHOST_ATTACK:
					break;
				case SKYWARS:
					if(getInvType() == InvType.KITS){
						for(TicketType type : TicketType.getSkywarsKits()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					else{
						for(TicketType type : TicketType.getSkywarsPerks()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					break;
				case SPLATCRAFT:
					break;
				case SPLEEF:
					break;
				case SURVIVAL_GAMES:
					if(getInvType() == InvType.KITS){
						for(TicketType type : TicketType.getSGKits()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					else{
						for(TicketType type : TicketType.getSGPerks()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					break;
				case ULTRA_HARD_CORE:
					if(getInvType() == InvType.KITS){
						for(TicketType type : TicketType.getUHCKits()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					else{
						for(TicketType type : TicketType.getUHCPerks()){
							contents[type.getSlot()] = getItemStack(omp, type);
						}
					}
					break;
			}
			
			if(getInvType() == InvType.KITS){
				contents[39] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.WORKBENCH), "§a§lKits"), Enchantment.DURABILITY, 1), 1);
				contents[40] = Utils.getSkull(player.getName(), "§2§lStats");
				contents[41] = Utils.setDisplayname(new ItemStack(Material.APPLE), "§7§lPerks");
			}
			else{
				if(getMiniGameType() != MiniGameType.ULTRA_HARD_CORE && getMiniGameType() != MiniGameType.SKYWARS && getMiniGameType() != MiniGameType.CHICKEN_FIGHT){
					contents[48] = Utils.setDisplayname(new ItemStack(Material.WORKBENCH), "§7§lKits");
					contents[49] = Utils.getSkull(player.getName(), "§2§lStats");
					contents[50] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.APPLE), "§a§lPerks"), Enchantment.DURABILITY, 1), 1);
				}
				else{
					contents[39] = Utils.setDisplayname(new ItemStack(Material.WORKBENCH), "§7§lKits");
					contents[40] = Utils.getSkull(player.getName(), "§2§lStats");
					contents[41] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.APPLE), "§a§lPerks"), Enchantment.DURABILITY, 1), 1);
				}
			}
			
			return contents;
		}
		
		private ItemStack getItemStack(OMPlayer omp, TicketType type){
			ItemStack item = type.getItemStack();
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(type.getRarity().getColor() + type.getName());
			List<String> lore = new ArrayList<String>();
			if(type.getUses() == Uses.ONE_TIME){
				lore.add(" §7Amount: " + type.getRarity().getColor() + omp.getTicketAmount(type) + " ");
			}
			else{
				if(omp.getTicketAmount(type) != 0){
					lore.add(" §a§lUnlocked");
				}
				else{
					lore.add(" §4§lLocked");
				}
			}
			lore.add(" §7Rarity: " + type.getRarity().getName() + " ");
			lore.add("");
			for(String s : type.getDescription()){
				lore.add(" " + type.getRarity().getColor() + "- " + s);
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			
			return Utils.hideFlags(item, 34);
		}
	}

	public static class MGKitInv {
		
		private Inventory inventory;
		private TicketType type;
		
		public MGKitInv(TicketType type){
			Inventory inventory = Bukkit.createInventory(null, 9, "§0§l" + type.getName());
			this.inventory = inventory;
			this.type = type;
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
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			{
				ItemStack item = new ItemStack(type.getItemStack().getType(), 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§lSelect " + type.getName());
				List<String> lore = new ArrayList<String>();
				
				if(type.getUses() == Uses.ONE_TIME){
					lore.add(" §7Amount: " + type.getRarity().getColor() + omp.getTicketAmount(type) + " ");
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						lore.add(" §a§lUnlocked ");
					}
					else{
						lore.add(" §4§lLocked ");
					}
				}
				lore.add(" §7Rarity: " + type.getRarity().getName() + " ");
				lore.add("");
				for(String s : type.getDescription()){
					lore.add(" " + type.getRarity().getColor() + "- " + s);
				}
				lore.add("");
				lore.add(" " + type.getRarity().getColor() + "Kit Ticket will be used ");
				lore.add(" " + type.getRarity().getColor() + "once the game starts. ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(type.getItemStack().getDurability());
				contents[4] = Utils.hideFlags(item, 34);
			}
			
			return contents;
		}
	}
	
	public static class GameEffectsInv {
		
		private Inventory inventory;
		private MiniGameType type;
		
		public GameEffectsInv(MiniGameType type){
			int size = 45;
			if(type == MiniGameType.ULTRA_HARD_CORE || type == MiniGameType.SKYWARS || type == MiniGameType.CHICKEN_FIGHT){
				size = 36;
			}
			Inventory inventory = Bukkit.createInventory(null, size, "§0§lGame Effects");
			this.inventory = inventory;
			this.type = type;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public MiniGameType getMiniGameType(){
			return type;
		}
		public void setMiniGameType(MiniGameType type){
			this.type = type;
		}
		
		public void open(Player player){
			inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			switch(getMiniGameType()){
				case CHICKEN_FIGHT:
					for(TicketType type : TicketType.getCFPerks()){
						contents[type.getSlot()] = getItemStack(omp, type);
					}
					break;
				case GHOST_ATTACK:
					break;
				case SKYWARS:
					for(TicketType type : TicketType.getSkywarsPerks()){
						contents[type.getSlot()] = getItemStack(omp, type);
					}
					break;
				case SPLATCRAFT:
					break;
				case SPLEEF:
					break;
				case SURVIVAL_GAMES:
					for(TicketType type : TicketType.getSGPerks()){
						contents[type.getSlot()] = getItemStack(omp, type);
					}
					break;
				case ULTRA_HARD_CORE:
					for(TicketType type : TicketType.getUHCPerks()){
						contents[type.getSlot()] = getItemStack(omp, type);
					}
					break;
			}
			
			return contents;
		}
		
		private ItemStack getItemStack(OMPlayer omp, TicketType type){
			Arena arena = omp.getArena();
			String status = null;
			
			if(type == TicketType.ENABLE_POTIONS){
				if(arena.getSG().isEnablePotions()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.ENABLE_POTIONS_PLAYER){
				if(arena.getSG().isEnablePotions()){
					status = " §7Status: §4§lUnavailable";
				}
				else if(omp.getSGPlayer().isEnablePotions()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.DOUBLE_LOOT){
				if(arena.getSG().isDoubleLoot()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.DOUBLE_LOOT_PLAYER){
				if(arena.getSG().isDoubleLoot()){
					status = " §7Status: §4§lUnavailable";
				}
				else if(omp.getSGPlayer().isDoubleLoot()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.DOUBLE_IRON){
				if(arena.getUHC().isDoubleIron()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.DOUBLE_IRON_PLAYER){
				if(arena.getUHC().isDoubleIron()){
					status = " §7Status: §4§lUnavailable";
				}
				else if(omp.getUHCPlayer().isDoubleIron()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.GOLD_FROM_LAPIS){
				if(omp.getUHCPlayer().isBlueGold()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.GOLD_FROM_REDSTONE){
				if(omp.getUHCPlayer().isRedGold()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.JUMP_BOOST){
				if(arena.getCF().isJumpBoost()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else if(type == TicketType.SPEED_BOOST){
				if(arena.getCF().isSpeedBoost()){
					status = " §7Status: §a§lActivated";
				}
				else{
					if(omp.getTicketAmount(type) != 0){
						status = " §7Status: §a§lClick to Activate";
					}
					else{
						status = " §7Status: §4§lUnavailable";
					}
				}
			}
			else{
				if(getMiniGameType() == MiniGameType.SURVIVAL_GAMES){
					Color color = ((LeatherArmorMeta) type.getItemStack().getItemMeta()).getColor();
					Color activated = omp.getSGPlayer().getLeatherColor();
					
					if(activated != null && color == activated){
						status = " §7Status: §a§lActivated";
					}
					else{
						if(omp.getTicketAmount(type) != 0){
							status = " §7Status: §a§lClick to Activate";
						}
					}
				}
				else if(getMiniGameType() == MiniGameType.SKYWARS){
					TicketType cage = omp.getSWPlayer().getCage();
					
					if(cage != null && type == cage){
						status = " §7Status: §a§lActivated";
					}
					else{
						if(omp.getTicketAmount(type) != 0){
							status = " §7Status: §a§lClick to Activate";
						}
					}
				}
				else{}
			}
			
			ItemStack item = type.getItemStack();
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(type.getRarity().getColor() + type.getName());
			List<String> lore = new ArrayList<String>();
			if(type.getUses() == Uses.ONE_TIME){
				lore.add(" §7Amount: " + type.getRarity().getColor() + omp.getTicketAmount(type) + " ");
			}
			else{
				if(omp.getTicketAmount(type) != 0){
					lore.add(" §a§lUnlocked");
				}
				else{
					lore.add(" §4§lLocked");
				}
			}
			lore.add(" §7Rarity: " + type.getRarity().getName() + " ");
			lore.add("");
			if(status != null){
				lore.add(status);
				lore.add("");
			}
			for(String s : type.getDescription()){
				lore.add(" " + type.getRarity().getColor() + "- " + s);
			}
			if(type.getUses() == Uses.ONE_TIME){
				lore.add("");
				lore.add(" " + type.getRarity().getColor() + "Perk Ticket will be used ");
				lore.add(" " + type.getRarity().getColor() + "once the game starts. ");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			
			if(status != null && status.equals(" §7Status: §a§lActivated")){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				return Utils.hideFlags(item, 35);
			}
			return Utils.hideFlags(item, 34);
		}
	}
}