package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.ChatColor;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Currency;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Disguise;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Gadget;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Hat;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.InventoryEnum;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Pet;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Trail;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.TrailType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.ChickenFightPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SkywarsPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.SurvivalGamesPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.UHCPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Inventories {

	public static class TeleporterInv {
		
		private Inventory inventory;
		
		public TeleporterInv(){
			Inventory inventory = Bukkit.createInventory(null, 27, "§0§lTeleporter");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			update(player, inventory);
		}
		
		public static void update(Player player, Inventory inventory){
			OMPlayer omp = OMPlayer.getOMPlayer(player);

			List<OMPlayer> players = new ArrayList<OMPlayer>();
			
			for(Player p : Bukkit.getOnlinePlayers()){
				OMPlayer omplayer = OMPlayer.getOMPlayer(p);
				
				if(ServerData.isServer(Server.KITPVP)){
					KitPvPPlayer kp = omplayer.getKitPvPPlayer();
					
					if(kp.isPlayer() && kp.getKitSelected() != null){
						players.add(omplayer);
					}
				}
			}
			
			if(ServerData.isServer(Server.MINIGAMES)){
				Arena arena = omp.getArena();
				
				if(arena != null){
					players.addAll(arena.getPlayers());
				}
			}

			if(players.size() > 45){
				inventory = Bukkit.createInventory(null, 54, "§0§lTeleporter");
			}
			else if(players.size() > 36){
				inventory = Bukkit.createInventory(null, 45, "§0§lTeleporter");
			}
			else if(players.size() > 27){
				inventory = Bukkit.createInventory(null, 36, "§0§lTeleporter");
			}
			else if(players.size() > 18){
				inventory = Bukkit.createInventory(null, 27, "§0§lTeleporter");
			}
			else if(players.size() > 9){
				inventory = Bukkit.createInventory(null, 18, "§0§lTeleporter");
			}
			else{
				inventory = Bukkit.createInventory(null, 9, "§0§lTeleporter");
			}
			
			int index = 0;
			for(OMPlayer omplayer : players){
				if(index <= 53){
					inventory.setItem(index, getItem(omplayer));
				}
				
				index++;
			}
			
			omp.getPlayer().openInventory(inventory);
		}
		
		private static ItemStack getItem(OMPlayer omp){
			ItemStack item = Utils.getSkull(omp.getPlayer().getName());
			ItemMeta itemmeta = (ItemMeta) item.getItemMeta();
			itemmeta.setDisplayName(omp.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(ServerData.isServer(Server.KITPVP)){
				KitPvPPlayer kp = omp.getKitPvPPlayer();
				
				itemlore.add("§7Kit: " + kp.getKitSelected().getSelectedKitName(kp.getKitLevelSelected()));
				itemlore.add("§cHealth: §f" + String.format("%.1f", ((CraftPlayer) omp.getPlayer()).getHealth() / 2).replaceAll(",", ".") + "/10.0");
				itemlore.add("§6Food: §f" + String.format("%.1f", (double) omp.getPlayer().getFoodLevel() / 2).replaceAll(",", ".") + "/10.0");
				itemlore.add("§9Current Streak: §f" + kp.getCurrentStreak());
				itemlore.add("");
				itemlore.add("§c§lKitPvP Stats:");
				itemlore.add("§cKills: §f" + kp.getKills());
				itemlore.add("§4Deaths: §f" + kp.getDeaths());
				itemlore.add("§eLevel: §f" + kp.getLevels());
				itemlore.add("§bBest Streak: §f" + kp.getBestStreak());
			}
			else if(ServerData.isServer(Server.MINIGAMES)){
				Arena arena = omp.getArena();
				
				switch(arena.getType()){
					case CHICKEN_FIGHT:
						ChickenFightPlayer cfp = omp.getCFPlayer();
						
						itemlore.add("§cHealth: §f" + String.format("%.1f", ((CraftPlayer) omp.getPlayer()).getHealth() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§7Kills: §f" + cfp.getRoundKills());
						itemlore.add("");
						itemlore.add("§2§lChicken Fight Stats:");
						itemlore.add("§cGames Played: §f" + (cfp.getWins() + cfp.getLoses()));
						itemlore.add("§aWins: §f" + cfp.getWins());
						itemlore.add("§7Total Kills: §f" + cfp.getKills());
						itemlore.add("§bBest Streak: §f" + cfp.getBeststreak());
						break;
					case GHOST_ATTACK:
						break;
					case SKYWARS:
						SkywarsPlayer swp = omp.getSWPlayer();
						
						itemlore.add("§cHealth: §f" + String.format("%.1f", ((CraftPlayer) omp.getPlayer()).getHealth() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§6Food: §f" + String.format("%.1f", (double) omp.getPlayer().getFoodLevel() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§7Kills: §f" + swp.getRoundKills());
						itemlore.add("");
						itemlore.add("§2§lSkywars Stats:");
						itemlore.add("§cGames Played: §f" + (swp.getWins() + swp.getLoses()));
						itemlore.add("§aWins: §f" + swp.getWins());
						itemlore.add("§7Total Kills: §f" + swp.getKills());
						itemlore.add("§bBest Streak: §f" + swp.getBeststreak());
						break;
					case SPLATCRAFT:
						break;
					case SPLEEF:
						break;
					case SURVIVAL_GAMES:
						SurvivalGamesPlayer sgp = omp.getSGPlayer();
						
						itemlore.add("§cHealth: §f" + String.format("%.1f", ((CraftPlayer) omp.getPlayer()).getHealth() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§6Food: §f" + String.format("%.1f", (double) omp.getPlayer().getFoodLevel() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§7Kills: §f" + sgp.getRoundKills());
						itemlore.add("");
						itemlore.add("§2§lSurvival Games Stats:");
						itemlore.add("§cGames Played: §f" + (sgp.getWins() + sgp.getLoses()));
						itemlore.add("§aWins: §f" + sgp.getWins());
						itemlore.add("§7Total Kills: §f" + sgp.getKills());
						itemlore.add("§bBest Streak: §f" + sgp.getBeststreak());
						break;
					case ULTRA_HARD_CORE:
						UHCPlayer uhcp = omp.getUHCPlayer();
						
						itemlore.add("§cHealth: §f" + String.format("%.1f", ((CraftPlayer) omp.getPlayer()).getHealth() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§6Food: §f" + String.format("%.1f", (double) omp.getPlayer().getFoodLevel() / 2).replaceAll(",", ".") + "/10.0");
						itemlore.add("§7Kills: §f" + uhcp.getRoundKills());
						itemlore.add("");
						itemlore.add("§2§lUHC Stats:");
						itemlore.add("§cGames Played: §f" + (uhcp.getWins() + uhcp.getLoses()));
						itemlore.add("§aWins: §f" + uhcp.getWins());
						itemlore.add("§7Total Kills: §f" + uhcp.getKills());
						itemlore.add("§bBest Streak: §f" + uhcp.getBeststreak());
						break;
				}
			}
			else{}
			itemlore.add("");
			itemlore.add("§e§lClick Here to Teleport");
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
	}
	
	public static class InventoryInv {
		
		private Inventory inventory;
		
		public InventoryInv(Player player){
			if(player != null){
				Inventory inventory = Bukkit.createInventory(null, 45, "§0§l" + player.getName() + "'s Inventory");
				this.inventory = inventory;
				this.inventory.setContents(getContects(player));
			}
			else{
				Inventory inventory = Bukkit.createInventory(null, 45, "'s Inventory");
				this.inventory = inventory;
			}
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			player.openInventory(getInventory());
		}
		
		private ItemStack[] getContects(Player player){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			PlayerInventory inv = player.getInventory();
			for(int i = 0; i < 27; i++){
				contents[i] = inv.getItem(i + 9);
			}
			for(int i = 27; i < 36; i++){
				contents[i] = inv.getItem(i - 27);
			}
			contents[36] = inv.getHelmet();
			contents[37] = inv.getChestplate();
			contents[38] = inv.getLeggings();
			contents[39] = inv.getBoots();
			
			return contents;
		}
	}
	
	public static class OMTShopInv {
		
		private Inventory inventory;
		
		public OMTShopInv(){
			Inventory inventory = Bukkit.createInventory(null, 27, "§0§lOMT Shop");
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
			
			if(ServerData.isServer(Server.KITPVP)){
				contents[10] = getItemKitPvP(omp, 200, 1);
				contents[12] = getItemKitPvP(omp, 1000, 4);
				contents[14] = getItemKitPvP(omp, 2500, 9);
				contents[16] = getItemKitPvP(omp, 5000, 16);
			}
			else if(ServerData.isServer(Server.CREATIVE)){
				contents[10] = getItemCreative(omp, "//set", 75, 1);
				contents[12] = getItemCreative(omp, "//walls", 75, 2);
				contents[14] = getItemCreative(omp, "//line", 50, 3);
				contents[16] = getItemCreative(omp, "//replace", 175, 4);
			}
			else if(ServerData.isServer(Server.SURVIVAL)){
				{
					ItemStack item = new ItemStack(Material.STONE_HOE, 1);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§8§l+100 Claimblocks");
					List<String> lore = new ArrayList<String>();
					lore.add("");
					lore.add("§cPrice: §e2 OrbitMines Tokens");
					lore.add("");
					meta.setLore(lore);
					item.setItemMeta(meta);
					contents[10] = item;
				}
				{
					ItemStack item = new ItemStack(Material.EMPTY_MAP, 1);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§2§l+400$");
					List<String> lore = new ArrayList<String>();
					lore.add("");
					lore.add("§cPrice: §e3 OrbitMines Tokens");
					lore.add("");
					meta.setLore(lore);
					item.setItemMeta(meta);
					contents[12] = item;
				}
				{
					ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
					item.setDurability((short) 3);
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					meta.setDisplayName("§7§lYour Skull");
					meta.setOwner(omp.getPlayer().getName());
					List<String> lore = new ArrayList<String>();
					lore.add("");
					lore.add("§cPrice: §e50 OrbitMines Tokens");
					lore.add("");
					meta.setLore(lore);
					item.setItemMeta(meta);
					contents[14] = item;
				}
				{
					ItemStack item = new ItemStack(Material.CHEST, 1);
					item.setDurability((short) 3);
					ItemMeta meta = (ItemMeta) item.getItemMeta();
					meta.setDisplayName("§6§l+1 Chest Shop");
					List<String> lore = new ArrayList<String>();
					lore.add("");
					lore.add("§cPrice: §e30 OrbitMines Tokens");
					lore.add("");
					meta.setLore(lore);
					item.setItemMeta(meta);
					contents[16] = item;
				}
			}
			else{}
			//TODO OTHER SERVERS
			return contents;
		}
		
		private ItemStack getItemKitPvP(OMPlayer omp, int coins, int price){
			ItemStack item = new ItemStack(Material.GOLD_NUGGET, (int) coins / 100);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l+" + coins + " Coins");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			if(price == 1){
				lore.add("§cPrice: §e" + price + " OrbitMines Token");
			}
			else{
				lore.add("§cPrice: §e" + price + " OrbitMines Tokens");
			}
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			
			return item;
		}
		private ItemStack getItemCreative(OMPlayer omp, String cmd, int price, int index){
			ItemStack item = new ItemStack(Material.WOOD_AXE, index);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7WorldEdit Command: §d§l" + cmd);
			List<String> lore = new ArrayList<String>();
			if(!omp.getCreativePlayer().hasWEAccess(cmd)){
				lore.add("");
				lore.add("§cPrice: §e" + price + " OrbitMines Tokens");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
			}
			else{
				lore.add("");
				lore.add("§a§lUnlocked");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			}
			
			return Utils.hideFlags(item, 3);
		}
	}
	
	public static class ChatColorInv {
		
		private Inventory inventory;
		
		public ChatColorInv(){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lChatColors");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
				inventory.setContents(getContects(player));
				player.openInventory(getInventory());
			}
			else{
				player.sendMessage("§7You cannot use this command here.");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[9] = getItem(omp, ChatColor.DARK_RED);
			contents[10] = getItem(omp, ChatColor.LIGHT_GREEN);
			contents[11] = getItem(omp, ChatColor.DARK_GRAY);
			contents[12] = getItem(omp, ChatColor.RED);
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(omp.getChatColor().getColor() + "§lBold ChatColor: " + Utils.statusString(omp.isBold()));
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(omp.hasPerms(VIPRank.Emerald_VIP)){
					if(!omp.hasUnlockedBold()){
						itemlore.add("§cPrice: §b3000 VIP Points");
					}
					else{
						itemlore.add("§a§lUnlocked");
					}
				}
				else{
					itemlore.add("§cPrice: §b3000 VIP Points");
					itemlore.add("§cRequired: §a§lEmerald VIP");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				item.setDurability(Utils.statusDurability(omp.isBold()));
				contents[13] = item;
			}
			contents[14] = getItem(omp, ChatColor.YELLOW);
			contents[15] = getItem(omp, ChatColor.WHITE);
			contents[16] = getItem(omp, ChatColor.LIGHT_BLUE);
			contents[17] = getItem(omp, ChatColor.PINK);
			contents[18] = getItem(omp, ChatColor.BLUE);
			contents[19] = getItem(omp, ChatColor.DARK_BLUE);
			contents[20] = getItem(omp, ChatColor.GRAY);
			contents[21] = getItem(omp, ChatColor.ORANGE);
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(omp.getChatColor().getColor() + "§oCursive ChatColor: " + Utils.statusString(omp.isCursive()));
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!omp.hasPerms(VIPRank.Diamond_VIP)){
					itemlore.add("§cPrice: §b2000 VIP Points");
					itemlore.add("§cRequired: §b§lDiamond VIP");
				}
				else{
					if(!omp.hasUnlockedCursive()){
						itemlore.add("§cPrice: §b2000 VIP Points");
					}
					else{
						itemlore.add("§a§lUnlocked");
					}
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				item.setDurability(Utils.statusDurability(omp.isCursive()));
				contents[22] = item;
			}
			contents[23] = getItem(omp, ChatColor.PURPLE);
			contents[24] = getItem(omp, ChatColor.CYAN);
			contents[25] = getItem(omp, ChatColor.GREEN);
			contents[26] = getItem(omp, ChatColor.BLACK);
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[39] = item;
			}
			{		
				ChatColor cc = omp.getChatColor();
				ItemStack item = new ItemStack(cc.getMaterial(), 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(cc.getName());
				item.setDurability(cc.getDurability());
				item.setItemMeta(itemmeta);
				contents[41] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, ChatColor chatcolor){
			ItemStack item = new ItemStack(chatcolor.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(chatcolor.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!chatcolor.hasChatColor(omp)){
				itemlore.add(chatcolor.getPriceName());
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setDurability(chatcolor.getDurability());
			item.setItemMeta(itemmeta);
			
			return item;
		}
	}

	public static class ConfirmInv {
		
		private Inventory inventory;
		private ItemStack itemstack;
		private Currency currency;
		private int price;
		
		public ConfirmInv(ItemStack itemstack, Currency currency, int price){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lConfirm your Purchase");
			if(itemstack != null){
				inventory.setContents(getContects());
				this.itemstack = itemstack;
				this.currency = currency;
				this.price = price;
			}
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public ItemStack getItemStack(){
			return itemstack;
		}
		public void setItemStack(ItemStack itemstack){
			this.itemstack = itemstack;
		}
		
		public Currency getCurrency(){
			return currency;
		}
		public void setCurrency(Currency currency){
			this.currency = currency;
		}
		
		public int getPrice(){
			return price;
		}
		public void setPrice(int price){
			this.price = price;
		}
		
		public void open(Player player){
			setPriceItemStack();
			setBuyingItemStack();
			player.openInventory(getInventory());
		}
		
		private void setBuyingItemStack(){
			ItemStack item = getItemStack();
			
			// Check
			if(item.getItemMeta().getDisplayName() != null){
				ItemMeta meta = item.getItemMeta();
				if(meta.getDisplayName().equals("§6§l+5 Firework Passes")){
					meta.setDisplayName("§6§l5 Firework Passes");
				}
				if(meta.getDisplayName().equals("§6§l+25 Firework Passes")){
					meta.setDisplayName("§6§l25 Firework Passes");
				}
				if(meta.getDisplayName().startsWith("§7Hat Block Trail")){
					meta.setDisplayName("§7Hat Block Trail");
				}
				if(meta.getDisplayName().endsWith(": §c§lDISABLED")){
					meta.setDisplayName(meta.getDisplayName().replace(": §c§lDISABLED", ""));
				}
				
				for(TrailType trailtype : TrailType.values()){
					if(meta.getDisplayName().startsWith(trailtype.getName())){
						meta.setDisplayName(trailtype.getName());
					}
				}
				meta.setLore(null);
				item.setItemMeta(meta);
			}
			
			this.inventory.setItem(13, item);
		}
		
		private void setPriceItemStack(){
			ItemStack item = new ItemStack(Material.DIAMOND, 1);
			ItemMeta meta = item.getItemMeta();
			
			Currency currency = getCurrency();
			
			if(currency == Currency.VIP_POINTS){
				item.setType(Material.DIAMOND);
				meta.setDisplayName("§cPrice: §b§l" + getPrice() + " VIP Points");
			}
			else if(currency == Currency.ORBITMINES_TOKENS){
				item.setType(Material.GOLD_INGOT);
				if(getPrice() == 1){
					meta.setDisplayName("§cPrice: §e§l" + getPrice() + " OrbitMines Token");
				}
				else{
					meta.setDisplayName("§cPrice: §e§l" + getPrice() + " OrbitMines Tokens");
				}
			}
			else if(currency == Currency.MINIGAME_POINTS){
				item.setType(Material.SNOW_BALL);
				meta.setDisplayName("§cPrice: §f§l" + getPrice() + " MiniGame Coins");
			}
			else if(currency == Currency.PRISON_GOLD){
				item.setType(Material.GOLD_INGOT);
				meta.setDisplayName("§cPrice: §6§l" + getPrice() + " Gold");
			}
			else{}
			
			item.setItemMeta(meta);
			this.inventory.setItem(31, item);
		}
		
		private ItemStack[] getContects(){
			ItemStack[] contents = ServerStorage.inventorycontents.get(InventoryEnum.CONFIRM_PURCHASE);
			
			if(contents == null){
				registerContents(InventoryEnum.CONFIRM_PURCHASE);
				contents = ServerStorage.inventorycontents.get(InventoryEnum.CONFIRM_PURCHASE);
			}
			
			return contents;
		}
		
		public static void setDiscoItem(Inventory inv, OMPlayer omp){
			Color color = Utils.getRandomColor(Utils.getWardrobeColors());
			
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();	
			meta.setColor(color);
			meta.setDisplayName(Utils.getColor(color) + "Disco Armor");
			item.setItemMeta(meta);
			
			inv.setItem(13, item);
		}
	}
	
	public static class CosmeticPerksInv {
		
		private Inventory inventory;
		
		public CosmeticPerksInv(){
			Inventory inventory = Bukkit.createInventory(null, 36, "§0§lCosmetic Perks");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
				inventory.setContents(getContects(player));
				player.openInventory(getInventory());
				player.playSound(player.getLocation(), Sound.CHEST_OPEN, 5, 1);
			}
			else{
				player.sendMessage("§7You cannot use this command here.");
			}
		}
		
		private ItemStack[] getContects(Player player){
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Pets");
				item.setDurability((short) 95);
				item.setItemMeta(itemmeta);
				contents[10] = item;
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4ChatColors");
				item.setDurability((short) 1);
				item.setItemMeta(itemmeta);
				contents[12] = item;
			}
			{
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§2Disguises");
				if(ServerData.isServer(Server.KITPVP)){
					itemmeta.setDisplayName("§2Disguises §8| §c§lDISABLED");
				}
				item.setDurability((short) 2);
				item.setItemMeta(itemmeta);
				contents[14] = item;
			}
			{
				ItemStack item = new ItemStack(Material.COMPASS, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§bGadgets");
				if(!ServerData.isServer(Server.HUB, Server.MINIGAMES)){
					itemmeta.setDisplayName("§bGadgets §8| §c§lDISABLED");
				}
				item.setItemMeta(itemmeta);
				contents[16] = item;
			}
			{
				ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
				itemmeta.setDisplayName("§1Wardrobe");
				if(!ServerData.isServer(Server.HUB, Server.MINIGAMES, Server.CREATIVE)){
					itemmeta.setDisplayName("§1Wardrobe §8| §c§lDISABLED");
				}
				itemmeta.setColor(Color.fromBGR(204, 100, 2));
				item.setItemMeta(itemmeta);
				contents[19] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STRING, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§fTrails");
				item.setItemMeta(itemmeta);
				contents[21] = item;
			}
			{
				ItemStack item = new ItemStack(Material.PUMPKIN, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Hats");
				if(!ServerData.isServer(Server.HUB, Server.MINIGAMES, Server.CREATIVE)){
					itemmeta.setDisplayName("§6Hats §8| §c§lDISABLED");
				}
				item.setItemMeta(itemmeta);
				contents[23] = item;
			}
			{
				ItemStack item = new ItemStack(Material.FIREWORK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§cFireworks");
				if(!ServerData.isServer(Server.HUB, Server.MINIGAMES)){
					itemmeta.setDisplayName("§cFireworks §8| §c§lDISABLED");
				}
				item.setItemMeta(itemmeta);
				contents[25] = item;
			}
			
			return contents;
		}
	}

	public static class DisguiseInv {
		
		private Inventory inventory;
		
		public DisguiseInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lDisguises");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(!ServerData.isServer(Server.KITPVP)){
				if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
					inventory.setContents(getContects(player));
					player.openInventory(getInventory());
				}
				else{
					player.sendMessage("§7You cannot use this command here.");
				}
			}
			else{
				player.sendMessage("§2§lDisguises§7 are §c§lDISABLED§7 in " + ServerData.getServer().getName() + "§7!");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[9] = getItem(omp, Disguise.ENDERMAN);
			contents[10] = getItem(omp, Disguise.WITCH);
			contents[11] = getItem(omp, Disguise.BAT);
			contents[12] = getItem(omp, Disguise.CHICKEN);
			contents[13] = getItem(omp, Disguise.OCELOT);
			contents[14] = getItem(omp, Disguise.MUSHROOM_COW);
			contents[15] = getItem(omp, Disguise.SQUID);
			contents[16] = getItem(omp, Disguise.PIG);
			contents[17] = getItem(omp, Disguise.IRON_GOLEM);
			contents[18] = getItem(omp, Disguise.GHAST);
			contents[19] = getItem(omp, Disguise.BLAZE);
			contents[20] = getItem(omp, Disguise.SLIME);
			contents[21] = getItem(omp, Disguise.ZOMBIE_PIGMAN);
			contents[22] = getItem(omp, Disguise.MAGMA_CUBE);
			contents[23] = getItem(omp, Disguise.SKELETON);
			contents[24] = getItem(omp, Disguise.ZOMBIE);
			contents[25] = getItem(omp, Disguise.VILLAGER);
			contents[26] = getItem(omp, Disguise.HORSE);
			contents[27] = getItem(omp, Disguise.RABBIT);
			contents[28] = getItem(omp, Disguise.WOLF);
			contents[29] = getItem(omp, Disguise.SPIDER);
			contents[30] = getItem(omp, Disguise.SILVERFISH);
			contents[31] = getItem(omp, Disguise.SHEEP);
			contents[32] = getItem(omp, Disguise.CAVE_SPIDER);
			contents[33] = getItem(omp, Disguise.CREEPER);
			contents[34] = getItem(omp, Disguise.COW);
			contents[35] = getItem(omp, Disguise.SNOWMAN);
			
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[48] = item;
			}
			{
				ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4§nDisable Disguise");
				item.setItemMeta(itemmeta);
				contents[50] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, Disguise disguise){
			ItemStack item = new ItemStack(disguise.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(disguise.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!disguise.hasDisguise(omp)){
				itemlore.add(disguise.getPriceName());
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			item.setDurability(disguise.getDurability());
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
	}
	
	public static class FireworkInv {
		
		private Inventory inventory;
		
		public FireworkInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lFireworks");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
				if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
					inventory.setContents(getContects(player));
					player.openInventory(getInventory());
				}
				else{
					player.sendMessage("§7You cannot use this command here.");
				}
			}
			else{
				player.sendMessage("§c§lFireworks§7 are §c§lDISABLED§7 in " + ServerData.getServer().getName() + "§7!");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			FireworkSettings fwsettings = omp.getFWSettings();
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Color 1: §l" + Utils.getColorName(fwsettings.getColor1()));
				item.setItemMeta(itemmeta);
				item.setDurability((short) Utils.getColorDurability(fwsettings.getColor1()));
				if(fwsettings.getColor1() == Color.MAROON){
					item.setType(Material.REDSTONE);
				}
				contents[10] = item;
			}
			{
				Color color2 = fwsettings.getColor2();
				if(color2 != null){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Color 2: §l" + Utils.getColorName(color2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) Utils.getColorDurability(color2));
					if(color2 == Color.MAROON){
						item.setType(Material.REDSTONE);
					}
					contents[28] = item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Color 2: §c§lDISABLED");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					contents[28] = item;
				}
			}
			{
				Color fade1 = fwsettings.getFade1();
				if(fade1 != null){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Fade 1: §l" + Utils.getColorName(fade1));
					item.setItemMeta(itemmeta);
					item.setDurability((short) Utils.getColorDurability(fade1));
					if(fade1 == Color.MAROON){
						item.setType(Material.REDSTONE);
					}
					contents[12] = item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Fade 1: §c§lDISABLED");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					contents[12] = item;
				}
			}
			{
				Color fade2 = fwsettings.getFade2();
				if(fade2 != null){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Fade 2: §l" + Utils.getColorName(fade2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) Utils.getColorDurability(fade2));
					if(fade2 == Color.MAROON){
						item.setType(Material.REDSTONE);
					}
					contents[30] = item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Fade 2: §c§lDISABLED");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					contents[30] = item;
				}
			}

			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Trail: " + Utils.statusString(fwsettings.hasTrail()));
				item.setItemMeta(itemmeta);
				item.setDurability((short) Utils.statusDurability(fwsettings.hasTrail()));
				contents[14] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Flicker: " + Utils.statusString(fwsettings.hasFlicker()));
				item.setItemMeta(itemmeta);
				item.setDurability((short) Utils.statusDurability(fwsettings.hasFlicker()));
				contents[32] = item;
			}
			{
				ItemStack item = new ItemStack(Utils.getTypeMaterial(fwsettings.getType()), 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Type: " + Utils.getTypeString(fwsettings.getType()));
				item.setItemMeta(itemmeta);
				item.setDurability((short) Utils.getTypeDurability(fwsettings.getType()));
				contents[25] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[48] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ANVIL, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§e§nCreate Firework");
				item.setItemMeta(itemmeta);
				contents[49] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMPTY_MAP, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c§nFirework Passes:§r §6§n" + omp.getFireworkPasses());
				item.setItemMeta(itemmeta);
				contents[50] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMPTY_MAP, 5);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6§l+5 Firework Passes");
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§cPrice: §b2 VIP Points");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				contents[52] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMPTY_MAP, 25);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6§l+25 Firework Passes");
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§cPrice: §b10 VIP Points");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				contents[53] = item;
			}
			
			return contents;
		}
	}

	public static class GadgetInv {
		
		private Inventory inventory;
		
		public GadgetInv(){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lGadgets");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
				if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
					inventory.setContents(getContects(player));
					player.openInventory(getInventory());
				}
				else{
					player.sendMessage("§7You cannot use this command here.");
				}
			}
			else{
				player.sendMessage("§b§lGadgets§7 are §c§lDISABLED§7 in " + ServerData.getServer().getName() + "§7!");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[10] = getItem(omp, Gadget.STACKER);
			contents[11] = getItem(omp, Gadget.PAINTBALLS);
			contents[12] = getItem(omp, Gadget.CREEPER_LAUNCHER);
			contents[13] = getItem(omp, Gadget.PET_RIDE);
			contents[14] = getItem(omp, Gadget.BOOK_EXPLOSION);
			contents[15] = getItem(omp, Gadget.SWAP_TELEPORTER);
			contents[16] = getItem(omp, Gadget.MAGMACUBE_SOCCER);
			contents[19] = getItem(omp, Gadget.SNOWMAN_ATTACK);
			contents[20] = getItem(omp, Gadget.FLAME_THROWER);
			contents[21] = getItem(omp, Gadget.GRAPPLING_HOOK);
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[39] = item;
			}
			
			try{
				ItemStack itemInInv = omp.getPlayer().getInventory().getItem(5);
				ItemStack item = new ItemStack(itemInInv.getType());
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(itemInInv.getItemMeta().getDisplayName());
				List<String> lore = new ArrayList<String>();
				lore.add("§c§lDISABLE §bGadget");
				meta.setLore(lore);
				item.setItemMeta(meta);
				contents[41] = item;
			}catch(NullPointerException ex){}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, Gadget gadget){
			ItemStack item = new ItemStack(gadget.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(gadget.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!gadget.hasGadget(omp)){
				itemlore.add(gadget.getPriceName(omp));
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability(gadget.getDurability());
			
			return item;
		}
	}
	
	public static class HatInv {
		
		private Inventory inventory;
		
		public HatInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lHats");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(ServerData.isServer(Server.HUB, Server.MINIGAMES, Server.CREATIVE)){
				if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
					inventory.setContents(getContects(player));
					player.openInventory(getInventory());
				}
				else{
					player.sendMessage("§7You cannot use this command here.");
				}
			}
			else{
				player.sendMessage("§6§lHats§7 are §c§lDISABLED§7 in " + ServerData.getServer().getName() + "§7!");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
		
			setPage(omp, omp.getHatsInvPage());
			
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				inventory.setItem(48, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Hat Block Trail: " + Utils.statusString(omp.hasHatsBlockTrail()));
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(omp.hasHat()){
					if(!omp.hasUnlockedHatsBlockTrail()){
						itemlore.add("§cPrice: §b750 VIP Points");
						item.setDurability((short) 14);
					}
					else{
						itemlore.add("§a§lUnlocked");
						item.setDurability(Utils.statusDurability(omp.hasHatsBlockTrail()));
					}
				}
				else{
					itemlore.add("§cPrice: §b750 VIP Points");
					itemlore.add("§cRequired: §6A Hat");
					item.setDurability((short) 14);
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				inventory.setItem(49, item);
			}
			{
				ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4§nDisable Hat");
				item.setItemMeta(itemmeta);
				inventory.setItem(50, item);
			}
			
			return inventory.getContents();
		}
		
		public void setPage(OMPlayer omp, int page){
			if(page == 1){
				getInventory().setItem(36, null);
				getInventory().setItem(44, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§nMore Hats >>"));
				
				setItem(omp, Hat.GOLD_ORE, 0);
				setItem(omp, Hat.GOLD_ORE, 0);
				setItem(omp, Hat.STONE_BRICKS, 1);
				setItem(omp, Hat.GREEN_GLASS, 2);
				setItem(omp, Hat.CACTUS, 3);
				setItem(omp, Hat.EMERALD_ORE, 4);
				setItem(omp, Hat.IRON_BLOCK, 5);
				setItem(omp, Hat.SNOW, 6);
				setItem(omp, Hat.TNT, 7);
				setItem(omp, Hat.COAL_ORE, 8);
				setItem(omp, Hat.BLACK_GLASS, 9);
				setItem(omp, Hat.GOLD_BLOCK, 10);
				setItem(omp, Hat.FURNACE, 11);
				setItem(omp, Hat.QUARTZ_BLOCK, 12);
				setItem(omp, Hat.HAY_BALE, 13);
				setItem(omp, Hat.REDSTONE_ORE, 14);
				setItem(omp, Hat.ICE, 15);
				setItem(omp, Hat.WORKBENCH, 16);
				setItem(omp, Hat.DIAMOND_BLOCK, 17);
				setItem(omp, Hat.IRON_ORE, 18);
				setItem(omp, Hat.GRASS, 19);
				setItem(omp, Hat.RED_GLASS, 20);
				setItem(omp, Hat.BEDROCK, 21);
				setItem(omp, Hat.LAPIS_ORE, 22);
				setItem(omp, Hat.REDSTONE_BLOCK, 23);
				setItem(omp, Hat.QUARTZ_BLOCK, 24);
				setItem(omp, Hat.LAPIS_BLOCK, 25);
				setItem(omp, Hat.MAGENTA_GLASS, 26);
				setItem(omp, Hat.COAL_BLOCK, 27);
				setItem(omp, Hat.EMERALD_BLOCK, 28);
				setItem(omp, Hat.MELON, 29);
				setItem(omp, Hat.GLASS, 30);
				setItem(omp, Hat.YELLOW_GLASS, 31);
				setItem(omp, Hat.MYCELIUM, 32);
				setItem(omp, Hat.LEAVES, 33);
				setItem(omp, Hat.DIAMOND_ORE, 34);
				setItem(omp, Hat.ORANGE_GLASS, 35);
			}
			else if(page == 2){
				getInventory().setItem(36, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§n<< More Hats"));
				getInventory().setItem(44, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§nMore Hats >>"));
				
				setItem(omp, Hat.STONE_BRICKS, 0);
				setItem(omp, Hat.GREEN_GLASS, 1);
				setItem(omp, Hat.CACTUS, 2);
				setItem(omp, Hat.EMERALD_ORE, 3);
				setItem(omp, Hat.IRON_BLOCK, 4);
				setItem(omp, Hat.SNOW, 5);
				setItem(omp, Hat.TNT, 6);
				setItem(omp, Hat.COAL_ORE, 7);
				setItem(omp, Hat.DIORITE, 8);
				setItem(omp, Hat.GOLD_BLOCK, 9);
				setItem(omp, Hat.FURNACE, 10);
				setItem(omp, Hat.QUARTZ_BLOCK, 11);
				setItem(omp, Hat.HAY_BALE, 12);
				setItem(omp, Hat.REDSTONE_ORE, 13);
				setItem(omp, Hat.ICE, 14);
				setItem(omp, Hat.WORKBENCH, 15);
				setItem(omp, Hat.DIAMOND_BLOCK, 16);
				setItem(omp, Hat.DARK_PRISMARINE, 17);
				setItem(omp, Hat.GRASS, 18);
				setItem(omp, Hat.RED_GLASS, 19);
				setItem(omp, Hat.BEDROCK, 20);
				setItem(omp, Hat.LAPIS_ORE, 21);
				setItem(omp, Hat.REDSTONE_BLOCK, 22);
				setItem(omp, Hat.QUARTZ_BLOCK, 23);
				setItem(omp, Hat.LAPIS_BLOCK, 24);
				setItem(omp, Hat.MAGENTA_GLASS, 25);
				setItem(omp, Hat.SPONGE, 26);
				setItem(omp, Hat.EMERALD_BLOCK, 27);
				setItem(omp, Hat.MELON, 28);
				setItem(omp, Hat.GLASS, 29);
				setItem(omp, Hat.YELLOW_GLASS, 30);
				setItem(omp, Hat.MYCELIUM, 31);
				setItem(omp, Hat.LEAVES, 32);
				setItem(omp, Hat.DIAMOND_ORE, 33);
				setItem(omp, Hat.ORANGE_GLASS, 34);
				setItem(omp, Hat.SLIME_BLOCK, 35);
			}
			else if(page == 3){
				getInventory().setItem(36, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§n<< More Hats"));
				getInventory().setItem(44, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§nMore Hats >>"));
				
				setItem(omp, Hat.GREEN_GLASS, 0);
				setItem(omp, Hat.CACTUS, 1);
				setItem(omp, Hat.EMERALD_ORE, 2);
				setItem(omp, Hat.IRON_BLOCK, 3);
				setItem(omp, Hat.SNOW, 4);
				setItem(omp, Hat.TNT, 5);
				setItem(omp, Hat.COAL_ORE, 6);
				setItem(omp, Hat.DIORITE, 7);
				setItem(omp, Hat.SEA_LANTERN, 8);
				setItem(omp, Hat.FURNACE, 9);
				setItem(omp, Hat.QUARTZ_BLOCK, 10);
				setItem(omp, Hat.HAY_BALE, 11);
				setItem(omp, Hat.REDSTONE_ORE, 12);
				setItem(omp, Hat.ICE, 13);
				setItem(omp, Hat.WORKBENCH, 14);
				setItem(omp, Hat.DIAMOND_BLOCK, 15);
				setItem(omp, Hat.DARK_PRISMARINE, 16);
				setItem(omp, Hat.PRISMARINE_BRICKS, 17);
				setItem(omp, Hat.RED_GLASS, 18);
				setItem(omp, Hat.BEDROCK, 19);
				setItem(omp, Hat.LAPIS_ORE, 20);
				setItem(omp, Hat.REDSTONE_BLOCK, 21);
				setItem(omp, Hat.QUARTZ_BLOCK, 22);
				setItem(omp, Hat.LAPIS_BLOCK, 23);
				setItem(omp, Hat.MAGENTA_GLASS, 24);
				setItem(omp, Hat.SPONGE, 25);
				setItem(omp, Hat.GRANITE, 26);
				setItem(omp, Hat.MELON, 27);
				setItem(omp, Hat.GLASS, 28);
				setItem(omp, Hat.YELLOW_GLASS, 29);
				setItem(omp, Hat.MYCELIUM, 30);
				setItem(omp, Hat.LEAVES, 31);
				setItem(omp, Hat.DIAMOND_ORE, 32);
				setItem(omp, Hat.ORANGE_GLASS, 33);
				setItem(omp, Hat.SLIME_BLOCK, 34);
				setItem(omp, Hat.CHEST, 35);
			}
			else if(page == 4){
				getInventory().setItem(36, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§n<< More Hats"));
				getInventory().setItem(44, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§nMore Hats >>"));
				
				setItem(omp, Hat.CACTUS, 0);
				setItem(omp, Hat.EMERALD_ORE, 1);
				setItem(omp, Hat.IRON_BLOCK, 2);
				setItem(omp, Hat.SNOW, 3);
				setItem(omp, Hat.TNT, 4);
				setItem(omp, Hat.COAL_ORE, 5);
				setItem(omp, Hat.DIORITE, 6);
				setItem(omp, Hat.SEA_LANTERN, 7);
				setItem(omp, Hat.GLOWSTONE, 8);
				setItem(omp, Hat.QUARTZ_BLOCK, 9);
				setItem(omp, Hat.HAY_BALE, 10);
				setItem(omp, Hat.REDSTONE_ORE, 11);
				setItem(omp, Hat.ICE, 12);
				setItem(omp, Hat.WORKBENCH, 13);
				setItem(omp, Hat.DIAMOND_BLOCK, 14);
				setItem(omp, Hat.DARK_PRISMARINE, 15);
				setItem(omp, Hat.PRISMARINE_BRICKS, 16);
				setItem(omp, Hat.WET_SPONGE, 17);
				setItem(omp, Hat.BEDROCK, 18);
				setItem(omp, Hat.LAPIS_ORE, 19);
				setItem(omp, Hat.REDSTONE_BLOCK, 20);
				setItem(omp, Hat.QUARTZ_BLOCK, 21);
				setItem(omp, Hat.LAPIS_BLOCK, 22);
				setItem(omp, Hat.MAGENTA_GLASS, 23);
				setItem(omp, Hat.SPONGE, 24);
				setItem(omp, Hat.GRANITE, 25);
				setItem(omp, Hat.ANDESITE, 26);
				setItem(omp, Hat.GLASS, 27);
				setItem(omp, Hat.YELLOW_GLASS, 28);
				setItem(omp, Hat.MYCELIUM, 29);
				setItem(omp, Hat.LEAVES, 30);
				setItem(omp, Hat.DIAMOND_ORE, 31);
				setItem(omp, Hat.ORANGE_GLASS, 32);
				setItem(omp, Hat.SLIME_BLOCK, 33);
				setItem(omp, Hat.CHEST, 34);
				setItem(omp, Hat.BLUE_GLASS, 35);
			}
			else if(page == 5){
				getInventory().setItem(36, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§n<< More Hats"));
				getInventory().setItem(44, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§nMore Hats >>"));
				
				setItem(omp, Hat.EMERALD_ORE, 0);
				setItem(omp, Hat.IRON_BLOCK, 1);
				setItem(omp, Hat.SNOW, 2);
				setItem(omp, Hat.TNT, 3);
				setItem(omp, Hat.COAL_ORE, 4);
				setItem(omp, Hat.DIORITE, 5);
				setItem(omp, Hat.SEA_LANTERN, 6);
				setItem(omp, Hat.GLOWSTONE, 7);
				setItem(omp, Hat.ACACIA_WOOD, 8);
				setItem(omp, Hat.HAY_BALE, 9);
				setItem(omp, Hat.REDSTONE_ORE, 10);
				setItem(omp, Hat.ICE, 11);
				setItem(omp, Hat.WORKBENCH, 12);
				setItem(omp, Hat.DIAMOND_BLOCK, 13);
				setItem(omp, Hat.DARK_PRISMARINE, 14);
				setItem(omp, Hat.PRISMARINE_BRICKS, 15);
				setItem(omp, Hat.WET_SPONGE, 16);
				setItem(omp, Hat.RED_WOOL, 17);
				setItem(omp, Hat.LAPIS_ORE, 18);
				setItem(omp, Hat.REDSTONE_BLOCK, 19);
				setItem(omp, Hat.QUARTZ_BLOCK, 20);
				setItem(omp, Hat.LAPIS_BLOCK, 21);
				setItem(omp, Hat.MAGENTA_GLASS, 22);
				setItem(omp, Hat.SPONGE, 23);
				setItem(omp, Hat.GRANITE, 24);
				setItem(omp, Hat.ANDESITE, 25);
				setItem(omp, Hat.BROWN_GLASS, 26);
				setItem(omp, Hat.YELLOW_GLASS, 27);
				setItem(omp, Hat.MYCELIUM, 28);
				setItem(omp, Hat.LEAVES, 29);
				setItem(omp, Hat.DIAMOND_ORE, 30);
				setItem(omp, Hat.ORANGE_GLASS, 31);
				setItem(omp, Hat.SLIME_BLOCK, 32);
				setItem(omp, Hat.CHEST, 33);
				setItem(omp, Hat.BLUE_GLASS, 34);
				setItem(omp, Hat.SOUL_SAND, 35);
			}
			else if(page == 6){
				getInventory().setItem(36, Utils.setDisplayname(new ItemStack(Material.EMPTY_MAP), "§e§n<< More Hats"));
				getInventory().setItem(44, null);
				
				setItem(omp, Hat.IRON_BLOCK, 0);
				setItem(omp, Hat.SNOW, 1);
				setItem(omp, Hat.TNT, 2);
				setItem(omp, Hat.COAL_ORE, 3);
				setItem(omp, Hat.DIORITE, 4);
				setItem(omp, Hat.SEA_LANTERN, 5);
				setItem(omp, Hat.GLOWSTONE, 6);
				setItem(omp, Hat.ACACIA_WOOD, 7);
				setItem(omp, Hat.CHISELLED_STONE_BRICKS, 8);
				setItem(omp, Hat.REDSTONE_ORE, 9);
				setItem(omp, Hat.ICE, 10);
				setItem(omp, Hat.WORKBENCH, 11);
				setItem(omp, Hat.DIAMOND_BLOCK, 12);
				setItem(omp, Hat.DARK_PRISMARINE, 13);
				setItem(omp, Hat.PRISMARINE_BRICKS, 14);
				setItem(omp, Hat.WET_SPONGE, 15);
				setItem(omp, Hat.RED_WOOL, 16);
				setItem(omp, Hat.BOOKSHELF, 17);
				setItem(omp, Hat.REDSTONE_BLOCK, 18);
				setItem(omp, Hat.QUARTZ_BLOCK, 19);
				setItem(omp, Hat.LAPIS_BLOCK, 20);
				setItem(omp, Hat.MAGENTA_GLASS, 21);
				setItem(omp, Hat.SPONGE, 22);
				setItem(omp, Hat.GRANITE, 23);
				setItem(omp, Hat.ANDESITE, 24);
				setItem(omp, Hat.BROWN_GLASS, 25);
				setItem(omp, Hat.NETHERRACK, 26);
				setItem(omp, Hat.MYCELIUM, 27);
				setItem(omp, Hat.LEAVES, 28);
				setItem(omp, Hat.DIAMOND_ORE, 29);
				setItem(omp, Hat.ORANGE_GLASS, 30);
				setItem(omp, Hat.SLIME_BLOCK, 31);
				setItem(omp, Hat.CHEST, 32);
				setItem(omp, Hat.BLUE_GLASS, 33);
				setItem(omp, Hat.SOUL_SAND, 34);
				setItem(omp, Hat.CYAN_GLASS, 35);
			}
			else{}
		}
		
		private void setItem(OMPlayer omp, Hat hat, int slot){
			Inventory inv = getInventory();

			ItemStack item = new ItemStack(hat.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(hat.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!hat.hasHat(omp)){
				itemlore.add(hat.getPriceName());
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability(hat.getDurability());
			inv.setItem(slot, item); 
		}
	}

	public static class PetInv {
		
		private Inventory inventory;
		
		public PetInv(){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lPets");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
				inventory.setContents(getContects(player));
				player.openInventory(getInventory());
			}
			else{
				player.sendMessage("§7You cannot use this command here.");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[10] = getItem(omp, Pet.SQUID);
			contents[11] = getItem(omp, Pet.MUSHROOM_COW);
			contents[12] = getItem(omp, Pet.PIG);
			contents[13] = getItem(omp, Pet.WOLF);
			contents[14] = getItem(omp, Pet.SHEEP);
			contents[15] = getItem(omp, Pet.HORSE);
			contents[16] = getItem(omp, Pet.CREEPER);
			contents[19] = getItem(omp, Pet.SPIDER);
			contents[20] = getItem(omp, Pet.MAGMA_CUBE);
			contents[21] = getItem(omp, Pet.SLIME);
			contents[22] = getItem(omp, Pet.COW);
			contents[23] = getItem(omp, Pet.SILVERFISH);
			contents[24] = getItem(omp, Pet.OCELOT);
			contents[25] = getItem(omp, Pet.CHICKEN);
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[39] = item;
			}
			{
				ItemStack item = new ItemStack(Material.NAME_TAG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				if(omp.getPetEnabled() != null){
					itemmeta.setDisplayName("§fRename your " + omp.getPetEnabled().getName());
				}
				else{
					itemmeta.setDisplayName("§fRename §fPet");
				}
				
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§cPrice: §b10 VIP Points");
				lore.add("");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				contents[40] = item;
			}
			{
				ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4§nDisable Pet");
				item.setItemMeta(itemmeta);
				contents[41] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, Pet pet){
			ItemStack item = new ItemStack(pet.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(pet.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!pet.hasPet(omp)){
				itemlore.add(pet.getPriceName());
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability(pet.getDurability());
			
			return item;
		}
	}

	public static class ServerSelectorInv {
		
		private Inventory inventory;
		
		public ServerSelectorInv(){
			Inventory inventory = Bukkit.createInventory(null, 27, "§0§lServer Selector");
			this.inventory = inventory;
			
			ServerStorage.serverselector = this;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			player.openInventory(getInventory());
		}
		
		public void update(){
			this.inventory.setItem(10, getItem(Server.KITPVP));
			this.inventory.setItem(11, getItem(Server.PRISON));
			this.inventory.setItem(12, getItem(Server.CREATIVE));
			this.inventory.setItem(13, getItem(Server.HUB));
			this.inventory.setItem(14, getItem(Server.SURVIVAL));
			this.inventory.setItem(15, getItem(Server.SKYBLOCK));
			this.inventory.setItem(16, getItem(Server.MINIGAMES));
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals(getInventory().getName())){
					p.openInventory(getInventory());
				}
			}
		}
		
		private ItemStack getItem(Server server){
			ItemStack item = new ItemStack(server.getMaterial(), 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(server.getName() + " §8» §7§l" + server.getVersion());
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §7Status: " + server.getStatusString() + " ");
			if(server.isOnline()){
				lore.add(" §7Players: §a§l" + server.getOnlinePlayers() + "§7/§a§l" + server.getMaxPlayers() + " ");
			}
			lore.add("");
			if(server.isOnline()){
				if(!ServerData.isServer(server)){
					lore.add(" §7§oClick Here to Connect ");
				}
				else{
					lore.add(" §7§oCurrently Connected ");
				}
				lore.add("");
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
	      
			if(ServerData.isServer(server)){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = Utils.hideFlags(item, 1, 2);
			}
			else{
				item = Utils.hideFlags(item, 2);
			}
			
			return item;
		}
		
		public static ServerSelectorInv get(){
			return ServerStorage.serverselector;
		}
	}

	public static class SettingsInv {
		
		private Inventory inventory;
		
		public SettingsInv(Player player){
			Inventory inventory = Bukkit.createInventory(null, 27, "§0§lSettings (" + player.getName() + ")");
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
			
			if(omp.hasPlayersEnabled()){
				contents[11] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.EYE_OF_ENDER), "§3§lPlayers §a§lENABLED"), Enchantment.DURABILITY, 1), 1);
			}
			else{
				contents[11] = Utils.setDisplayname(new ItemStack(Material.EYE_OF_ENDER), "§3§lPlayers §c§lDISABLED");
			}
			
			if(omp.hasScoreboardEnabled()){
				contents[13] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.PAPER), "§f§lScoreboard §a§lENABLED"), Enchantment.DURABILITY, 1), 1);
			}
			else{
				contents[13] = Utils.setDisplayname(new ItemStack(Material.PAPER), "§f§lScoreboard §c§lDISABLED");
			}
			
			if(omp.hasStackerEnabled()){
				contents[15] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.LEASH), "§6§lStacker §a§lENABLED"), Enchantment.DURABILITY, 1), 1);
			}
			else{
				contents[15] = Utils.setDisplayname(new ItemStack(Material.LEASH), "§6§lStacker §c§lDISABLED");
			}
					
			return contents;
		}
	}

	public static class TrailInv {
		
		private Inventory inventory;
		
		public TrailInv(){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lTrails");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
				inventory.setContents(getContects(player));
				player.openInventory(getInventory());
			}
			else{
				player.sendMessage("§7You cannot use this command here.");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[9] = getItem(omp, Trail.FIREWORK_SPARK);
			contents[10] = getItem(omp, Trail.HAPPY_VILLAGER);
			contents[11] = getItem(omp, Trail.HEART);
			contents[12] = getItem(omp, Trail.TNT);
			contents[13] = getItem(omp, Trail.MAGIC);
			contents[14] = getItem(omp, Trail.ANGRY_VILLAGER);
			contents[15] = getItem(omp, Trail.LAVA);
			contents[16] = getItem(omp, Trail.SLIME);
			contents[17] = getItem(omp, Trail.SMOKE);
			contents[18] = getItem(omp, Trail.WITCH);
			contents[19] = getItem(omp, Trail.CRIT);
			contents[20] = getItem(omp, Trail.WATER);
			contents[21] = getItem(omp, Trail.MUSIC);
			contents[22] = getItem(omp, Trail.SNOW);
			contents[23] = getItem(omp, Trail.ENCHANTMENT_TABLE);
			contents[24] = getItem(omp, Trail.RAINBOW);
			contents[25] = getItem(omp, Trail.MOB_SPAWNER);
			contents[26] = getItem(omp, Trail.BUBBLE);
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[39] = item;
			}
			{
				ItemStack item = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§f§nTrail Settings");	
				item.setItemMeta(itemmeta);
				contents[40] = item;
			}
			{
				ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4§nRemove Current Trail");
				item.setItemMeta(itemmeta);
				contents[41] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, Trail trail){
			ItemStack item = new ItemStack(trail.getMaterial(), 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(trail.getName());
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!trail.hasTrail(omp)){
				itemlore.add(trail.getPriceName());
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability(trail.getDurability());
			
			if(trail == Trail.CRIT){
				item = Utils.hideFlags(item, 2);
			}
			
			return item;
		}
	}
	
	public static class TrailSettingsInv {
		
		private Inventory inventory;
		
		public TrailSettingsInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lTrail Settings");
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
			
			contents[4] = Utils.setDisplayname(new ItemStack(Material.COMPASS), "§7Trail Types");
			contents[9] = getItem(omp, TrailType.BASIC_TRAIL);
			contents[10] = getItem(omp, TrailType.GROUND_TRAIL);
			contents[11] = getItem(omp, TrailType.HEAD_TRAIL);
			contents[12] = getItem(omp, TrailType.BODY_TRAIL);
			contents[13] = getItem(omp, TrailType.BIG_TRAIL);
			contents[14] = getItem(omp, TrailType.VERTICAL_TRAIL);
			contents[15] = getItem(omp, TrailType.ORBIT_TRAIL);
			contents[16] = getItem(omp, TrailType.CYLINDER_TRAIL);
			contents[17] = getItem(omp, TrailType.SNAKE_TRAIL);
			
			{
				ItemStack item = Utils.setDisplayname(new ItemStack(Material.STAINED_GLASS_PANE), "§fComing Soon...");
				
				contents[18] = item;
				contents[19] = item;
				contents[20] = item;
				contents[21] = item;
				contents[22] = item;
				contents[23] = item;
				contents[24] = item;
				contents[25] = item;
				contents[26] = item;
			}
			
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7§lSpecial Trail: " + Utils.statusString(omp.hasSpecialTrail()));
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(omp.hasUnlockedSpecialTrail()){
					itemlore.add("§a§lUnlocked");
				}
				else{
					itemlore.add("§cPrice: §b750 VIP Points");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				item.setDurability(Utils.statusDurability(omp.hasSpecialTrail()));
				contents[37] = item;
			}
			{
				ItemStack item = new ItemStack(Material.NETHER_STAR, omp.getTrailPA());
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7§lParticle Amount: §f§l" + omp.getTrailPA());
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(omp.hasPerms(VIPRank.Gold_VIP)){
					itemlore.add("§a§lUnlocked");
				}
				else{
					itemlore.add("§c§oRequired: §6§lGold VIP");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				contents[43] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[49] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, TrailType trailtype){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(trailtype.getName() + ": " + Utils.statusString(omp.getTrailType() == trailtype));
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(trailtype.hasTrailType(omp)){
				itemlore.add("§a§lUnlocked");
			}
			else{
				itemlore.add(trailtype.getPriceString());
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability(Utils.statusDurability(omp.getTrailType() == trailtype));
			
			return item;
		}
	}

	public static class WardrobeInv {
		
		private Inventory inventory;
		
		public WardrobeInv(){
			Inventory inventory = Bukkit.createInventory(null, 54, "§0§lWardrobe");
			this.inventory = inventory;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(Player player){
			if(ServerData.isServer(Server.HUB, Server.MINIGAMES, Server.CREATIVE)){
				if(!ServerData.isServer(Server.MINIGAMES) || OMPlayer.getOMPlayer(player).getArena().getState() == GameState.WAITING){
					inventory.setContents(getContects(player));
					player.openInventory(getInventory());
				}
				else{
					player.sendMessage("§7You cannot use this command here.");
				}
			}
			else{
				player.sendMessage("§7The §1§lWardrobe§7 is §c§lDISABLED§7 in " + ServerData.getServer().getName() + "§7!");
			}
		}
		
		private ItemStack[] getContects(Player player){
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			ItemStack[] contents = new ItemStack[getInventory().getSize()];
			
			contents[10] = getItem(omp, Color.WHITE);
			contents[11] = getItem(omp, Color.BLUE);
			contents[12] = getItem(omp, Color.GREEN);
			contents[13] = getItem(omp, Color.BLACK);
			contents[14] = getItem(omp, Color.AQUA);
			contents[15] = getItem(omp, Color.FUCHSIA);
			contents[16] = getItem(omp, Color.LIME);
			contents[19] = getItem(omp, Color.NAVY);
			contents[20] = getItem(omp, Color.PURPLE);
			contents[21] = getItem(omp, Color.ORANGE);
			contents[22] = getItem(omp, Color.RED);
			contents[23] = getItem(omp, Color.TEAL);
			contents[24] = getItem(omp, Color.YELLOW);
			contents[25] = getItem(omp, Color.GRAY);
			{
				ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Iron Armor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!omp.hasPerms(VIPRank.Iron_VIP)){
					itemlore.add("§cRequired: §7§lIron VIP");
				}
				else{
					itemlore.add("§a§lUnlocked");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				contents[29] = item;
			}
			{
				ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Gold Armor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!omp.hasPerms(VIPRank.Gold_VIP)){
					itemlore.add("§cRequired: §6§lGold VIP");
				}
				else{
					itemlore.add("§a§lUnlocked");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				contents[30] = item;
			}
			{
				ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§bDiamond Armor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!omp.hasPerms(VIPRank.Diamond_VIP)){
					itemlore.add("§cRequired: §b§lDiamond VIP");
				}
				else{
					itemlore.add("§a§lUnlocked");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				contents[32] = item;
			}
			{
				ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Chainmail Armor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!omp.hasPerms(VIPRank.Emerald_VIP)){
					itemlore.add("§cRequired: §a§lEmerald VIP");
				}
				else{
					itemlore.add("§a§lUnlocked");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				contents[33] = item;
			}
			
			contents[31] = setDiscoItem(this.inventory, omp);
			
			{
				ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9§nCosmetic Perks");
				item.setItemMeta(itemmeta);
				contents[48] = item;
			}
			{
				ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4§nRemove Current Armor");
				item.setItemMeta(itemmeta);
				contents[50] = item;
			}
			
			return contents;
		}
		
		private ItemStack getItem(OMPlayer omp, Color color){
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(Utils.getColorName(color) + " Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!omp.hasWardrobe(color)){
				itemlore.add(Utils.getColorPriceName(color));
			}
			else{
				itemlore.add("§a§lUnlocked");
			}
			itemlore.add("");
			itemmeta.setColor(color);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		
		public static ItemStack setDiscoItem(Inventory inv, OMPlayer omp){
			Color color = Utils.getRandomColor(Utils.getWardrobeColors());
			
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(Utils.getColor(color) + "Disco Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("§7§o(Uses your unlocked Armor)");
			itemlore.add("");
			
			if(omp.getWardrobe().size() >= 2){
				if(!omp.hasUnlockedWardrobeDisco()){
					itemlore.add("§cPrice: §b500 VIP Points");
				}
				else{
					itemlore.add("§a§lUnlocked");
				}
			}
			else{
				itemlore.add("§cPrice: §b500 VIP Points");
				itemlore.add("§cRequired: " + Utils.getColor(color) + "2 Armor Sets");
			}
			itemlore.add("");
			itemmeta.setColor(color);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(31, item);
			return item;
		}
	}

	public static class PetRenameGUI {
		
		private AnvilGUI anvilgui;
		
		public PetRenameGUI(final OMPlayer omp, final Pet pet){
			this.anvilgui = new AnvilGUI(omp.getPlayer(), new AnvilGUI.AnvilClickEventHandler(){
				
				@Override
				public void onAnvilClick(AnvilGUI.AnvilClickEvent e){
					if(e.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
						String petname = e.getName();
						Player p = omp.getPlayer();
						
						if(omp.hasVIPPoints(10)){
							
							e.setWillClose(true);
							e.setWillDestroy(true);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
							
							if(omp.getPetEnabled() != null){
								omp.disablePet();
							}

							p.sendMessage("§9Cosmetic Perks §8| §7Changed your " + pet.getName() + "§7 name to §f" + petname + "§7!");
							
							omp.setPetName(pet, petname);
							omp.removeVIPPoints(10);
							omp.spawnPet(pet);
						}
						else{
							e.setWillClose(false);
							e.setWillDestroy(false);
							omp.requiredVIPPoints(10);
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
				item.setDurability((short) pet.getDurability());
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Insert Petname");
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§cPrice: §b10 VIP Points");
				lore.add("");
				meta.setLore(lore);
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

	public static void registerContents(InventoryEnum inventory){
		switch(inventory){
			case CONFIRM_PURCHASE:
				ItemStack confirm = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta confirmmeta = confirm.getItemMeta();
				confirmmeta.setDisplayName("§a§lConfirm");
				confirm.setItemMeta(confirmmeta);
				confirm.setDurability((short) 5);
				
				ItemStack cancel = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta cancelmeta = cancel.getItemMeta();
				cancelmeta.setDisplayName("§c§lCancel");
				cancel.setItemMeta(cancelmeta);
				cancel.setDurability((short) 14);
				
				ItemStack[] contents = new ItemStack[45];
				contents[0] = confirm;
				contents[1] = confirm;
				contents[2] = confirm;
				contents[9] = confirm;
				contents[10] = confirm;
				contents[11] = confirm;
				contents[18] = confirm;
				contents[19] = confirm;
				contents[20] = confirm;
				contents[27] = confirm;
				contents[28] = confirm;
				contents[29] = confirm;
				contents[36] = confirm;
				contents[37] = confirm;
				contents[38] = confirm;
				
				contents[6] = cancel;
				contents[7] = cancel;
				contents[8] = cancel;
				contents[15] = cancel;
				contents[16] = cancel;
				contents[17] = cancel;
				contents[24] = cancel;
				contents[25] = cancel;
				contents[26] = cancel;
				contents[33] = cancel;
				contents[34] = cancel;
				contents[35] = cancel;
				contents[42] = cancel;
				contents[43] = cancel;
				contents[44] = cancel;
				
				ServerStorage.inventorycontents.put(inventory, contents);
				break;
			default:
				break;
		}
	}
}
