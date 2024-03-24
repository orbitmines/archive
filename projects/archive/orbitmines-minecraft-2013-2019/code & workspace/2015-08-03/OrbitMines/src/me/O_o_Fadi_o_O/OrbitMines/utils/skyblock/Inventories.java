package me.O_o_Fadi_o_O.OrbitMines.utils.skyblock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockUtils.ChallengeType;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Inventories {

	public static class ChallengesInv {
		
		private Inventory inventory;
		private ChallengeType type;
		
		public ChallengesInv(ChallengeType type){
			this.inventory = Bukkit.createInventory(null, 45, "§0§lChallenges");
			this.type = type;
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public ChallengeType getChallengeType(){
			return type;
		}
		public void setChallengeType(ChallengeType type){
			this.type = type;
		}
		
		public void open(Player player){
			this.inventory.setContents(getContects(player));
			player.openInventory(getInventory());
		}
		
		public ItemStack[] getContects(Player player){
			ItemStack[] contents = inventory.getContents();
			OMPlayer omp = OMPlayer.getOMPlayer(player);
			SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
			
			switch(this.type){
				case GATHER:
					contents[0] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.COBBLESTONE), "§a§lGather Challenges"), Enchantment.DURABILITY, 1), 1);
					contents[9] = Utils.setDisplayname(new ItemStack(Material.WHEAT), "§f§lFarm Challenges");
					contents[18] = Utils.setDisplayname(new ItemStack(Material.SPIDER_EYE), "§f§lMob Challenges");
					
					contents[2] = getChallengeItem(sbp, Challenge.getChallenge(0));
					contents[20] = getChallengeItem(sbp, Challenge.getChallenge(1));
					contents[38] = getChallengeItem(sbp, Challenge.getChallenge(2));
					contents[3] = getChallengeItem(sbp, Challenge.getChallenge(3));
					contents[21] = getChallengeItem(sbp, Challenge.getChallenge(4));
					contents[39] = getChallengeItem(sbp, Challenge.getChallenge(5));
					contents[4] = getChallengeItem(sbp, Challenge.getChallenge(6));
					contents[22] = getChallengeItem(sbp, Challenge.getChallenge(7));
					contents[40] = getChallengeItem(sbp, Challenge.getChallenge(8));
					contents[14] = getChallengeItem(sbp, Challenge.getChallenge(9));
					contents[32] = getChallengeItem(sbp, Challenge.getChallenge(10));
					contents[15] = getChallengeItem(sbp, Challenge.getChallenge(11));
					contents[33] = getChallengeItem(sbp, Challenge.getChallenge(12));
					contents[25] = getChallengeItem(sbp, Challenge.getChallenge(13));
					contents[26] = getChallengeItem(sbp, Challenge.getChallenge(14));
					break;
				case FARM:
					contents[0] = Utils.setDisplayname(new ItemStack(Material.COBBLESTONE), "§f§lGather Challenges");
					contents[9] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.WHEAT), "§a§lFarm Challenges"), Enchantment.DURABILITY, 1), 1);
					contents[18] = Utils.setDisplayname(new ItemStack(Material.SPIDER_EYE), "§f§lMob Challenges");
					
					contents[2] = getChallengeItem(sbp, Challenge.getChallenge(15));
					contents[20] = getChallengeItem(sbp, Challenge.getChallenge(16));
					contents[38] = getChallengeItem(sbp, Challenge.getChallenge(17));
					contents[3] = getChallengeItem(sbp, Challenge.getChallenge(18));
					contents[21] = getChallengeItem(sbp, Challenge.getChallenge(19));
					contents[39] = getChallengeItem(sbp, Challenge.getChallenge(20));
					contents[4] = getChallengeItem(sbp, Challenge.getChallenge(21));
					contents[22] = getChallengeItem(sbp, Challenge.getChallenge(22));
					contents[40] = getChallengeItem(sbp, Challenge.getChallenge(23));
					contents[14] = getChallengeItem(sbp, Challenge.getChallenge(24));
					contents[32] = getChallengeItem(sbp, Challenge.getChallenge(25));
					contents[15] = getChallengeItem(sbp, Challenge.getChallenge(26));
					contents[33] = getChallengeItem(sbp, Challenge.getChallenge(27));
					contents[25] = getChallengeItem(sbp, Challenge.getChallenge(28));
					contents[26] = getChallengeItem(sbp, Challenge.getChallenge(29));
					break;
				case MOB:
					contents[0] = Utils.setDisplayname(new ItemStack(Material.COBBLESTONE), "§f§lGather Challenges");
					contents[9] = Utils.setDisplayname(new ItemStack(Material.WHEAT), "§f§lFarm Challenges");
					contents[18] = Utils.hideFlags(Utils.addEnchantment(Utils.setDisplayname(new ItemStack(Material.SPIDER_EYE), "§a§lMob Challenges"), Enchantment.DURABILITY, 1), 1);
					
					contents[2] = getChallengeItem(sbp, Challenge.getChallenge(30));
					contents[20] = getChallengeItem(sbp, Challenge.getChallenge(31));
					contents[38] = getChallengeItem(sbp, Challenge.getChallenge(37));
					contents[3] = getChallengeItem(sbp, Challenge.getChallenge(32));
					contents[21] = getChallengeItem(sbp, Challenge.getChallenge(33));
					contents[39] = getChallengeItem(sbp, Challenge.getChallenge(38));
					contents[4] = getChallengeItem(sbp, Challenge.getChallenge(34));
					contents[22] = getChallengeItem(sbp, Challenge.getChallenge(35));
					contents[40] = getChallengeItem(sbp, Challenge.getChallenge(39));
					contents[14] = getChallengeItem(sbp, Challenge.getChallenge(36));
					contents[32] = getChallengeItem(sbp, Challenge.getChallenge(40));
					//contents[15] = getChallengeItem(sbp, Challenge.getChallenge(26));
					//contents[33] = getChallengeItem(sbp, Challenge.getChallenge(27));
					//contents[25] = getChallengeItem(sbp, Challenge.getChallenge(28));
					//contents[26] = getChallengeItem(sbp, Challenge.getChallenge(29));
					
					ItemStack item = Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.STAINED_GLASS_PANE), "§fComing Soon"), 7);
					contents[15] = item;
					contents[33] = item;
					contents[25] = item;
					contents[26] = item;
					
					break;
				default:
					break;
			}
			
			return contents;
		}
		
		public ItemStack getChallengeItem(SkyBlockPlayer sbp, Challenge c){
			ItemData itemdata = c.getItem();
			List<ItemData> requirements = c.getRequirements();
			List<ItemData> rewards = c.getRewards();
			
			if(c.canComplete(sbp)){
				ItemStack item = new ItemStack(itemdata.getMaterial(), itemdata.getAmount());
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§l" + itemdata.getDisplayName() + " ");
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(" §2§lRequired: ");
				for(ItemData idata : requirements){
					int amount = 0;
					
					for(ItemStack i : sbp.getPlayer().getInventory().getContents()){
						if(i != null && i.getType() == idata.getMaterial() && i.getDurability() == idata.getDurability()){
							amount += i.getAmount();
						}
					}
					
					if(amount < idata.getAmount()){
						lore.add("   §c✘ " + idata.getDisplayName() + " ");
					}
					else{
						lore.add("   §a✔ " + idata.getDisplayName() + " ");
					}
				}
				lore.add("");
				lore.add(" §6§lReward: ");
				for(ItemData idata : rewards){
					lore.add("   §e- " + idata.getDisplayName() + " ");
				}
				lore.add("");
				lore.add(" §b§lTimes Completed: §f§l" + sbp.getChallengeCompleted(c) + " ");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(itemdata.getDurability());
				
				return item;
			}

			ItemStack item = new ItemStack(itemdata.getMaterial(), itemdata.getAmount());
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§c§l" + itemdata.getDisplayName() + " ");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §4§lRequires the following Challenges: ");
			for(Challenge challenge : c.getRequired()){
				if(sbp.getChallengeCompleted(challenge) == 0){
					lore.add("   §c✘ " + challenge.getItem().getDisplayName() + " ");
				}
				else{
					lore.add("   §a✔ " + challenge.getItem().getDisplayName() + " ");
				}
			}
			lore.add("");
			lore.add(" §7§lRequired: ");
			for(ItemData idata : requirements){
				int amount = 0;
				
				for(ItemStack i : sbp.getPlayer().getInventory().getContents()){
					if(i != null && i.getType() == idata.getMaterial() && i.getDurability() == idata.getDurability()){
						amount += i.getAmount();
					}
				}
				
				if(amount < idata.getAmount()){
					lore.add("   §8✘ " + idata.getDisplayName() + " ");
				}
				else{
					lore.add("   §8✔ " + idata.getDisplayName() + " ");
				}
			}
			lore.add("");
			lore.add(" §7§lReward: ");
			for(ItemData idata : rewards){
				lore.add("   §8- " + idata.getDisplayName() + " ");
			}
			lore.add("");
			lore.add(" §8§lTimes Completed: §7§l" + sbp.getChallengeCompleted(c) + " ");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			item.setDurability(itemdata.getDurability());
			
			return item;
		}
	}

	public static class IslandInfoInv {
		
		private Inventory inventory;
		
		public IslandInfoInv(){
			this.inventory = Bukkit.createInventory(null, 9, "§0§lIsland Info");
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(SkyBlockPlayer sbp){
			if(sbp.hasIsland()){
				this.inventory.setContents(getContects(sbp));
				sbp.getPlayer().openInventory(getInventory());
			}
			else{
				sbp.getPlayer().sendMessage("§7You don't have an §dIsland§7!");
			}
		}
		
		public ItemStack[] getContects(SkyBlockPlayer sbp){
			ItemStack[] contents = inventory.getContents();
			Island is = sbp.getIsland();
			
			{
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				item.setDurability((short) 3);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setDisplayName("§6§lIsland Party §6(§7" + (is.getMembers().size() +1) + "§6/§7" + is.getMaxMembers() + "§6)");
				meta.setOwner(sbp.getPlayer().getName());
				item.setItemMeta(meta);
				
				contents[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.PAPER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§lIsland " + is.getIslandID());
				List<String> lore = new ArrayList<String>();
				lore.add("  §dOwner: §7" + is.getOwnerName());
				lore.add("  §dCreated: §7" + is.getCreatedDate());
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[3] = item;
			}
			{
				ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);				
				if(is.isTeleportEnabled()){
					item.setType(Material.EYE_OF_ENDER);
				}
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§3§lTeleport " + Utils.statusString(is.isTeleportEnabled()));
				item.setItemMeta(meta);
				
				contents[5] = item;
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);				
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§lIsland Protection " + Utils.statusString(is.hasIslandProtection()));
				item.setItemMeta(meta);
				item.setDurability(Utils.statusDurability(is.hasIslandProtection()));
				
				contents[7] = item;
			}
			
			return contents;
		}
	}

	public static class IslandMembersInv {
		
		private Inventory inventory;
		
		public IslandMembersInv(){
			Inventory inventory = Bukkit.createInventory(null, 45, "§0§lIsland Party");
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
			SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
			Island is = sbp.getIsland();
			
			{
				String owner = is.getOwnerName();
				
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				item.setDurability((short) 3);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setDisplayName("§d§l" + owner);
				List<String> lore = new ArrayList<String>();
				lore.add("  §dRank: §7Owner  ");
				if(Utils.getPlayer(is.getOwner()) != null){
					lore.add("  §dStatus: §aOnline  ");
				}
				else{
					lore.add("  §dStatus: §cOffline  ");
				}
				meta.setOwner(owner);
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[1] = item;
			}
			
			List<UUID> uuids = is.getMembers();
			int index = 2;
			for(int i = 1; i <= 20; i++){
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				if((is.getMaxMembers() -1) >= i){
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
				meta.setDisplayName("§d§lIsland Info");
				item.setItemMeta(meta);
				
				contents[40] = item;
			}
			
			return contents;
		}
	}

	public static class KitInv {
		
		private Inventory inventory;
		
		public KitInv(){
			this.inventory = Bukkit.createInventory(null, 9, "§0§lKits");
		}
		
		public Inventory getInventory(){
			return inventory;
		}
		public void setInventory(Inventory inventory){
			this.inventory = inventory;
		}
		
		public void open(SkyBlockPlayer sbp){
			if(sbp.hasIsland()){
				this.inventory.setContents(getContects(sbp));
				sbp.getPlayer().openInventory(getInventory());
			}
			else{
				sbp.getPlayer().sendMessage("§7You don't have an §dIsland§7!");
			}
		}
		
		public ItemStack[] getContects(SkyBlockPlayer sbp){
			ItemStack[] contents = inventory.getContents();
			
			{
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§lIron VIP Kit");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7- 32 Cobblestone ");
				lore.add(" §7- 3 Iron Ingots ");
				lore.add(" §7- 1 EXP Level ");
				lore.add("");
				lore.add(" §7Cooldown: §e24h ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[1] = item;
			}
			{
				ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lGold VIP Kit");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7- 48 Cobblestone ");
				lore.add(" §7- 5 Iron Ingots ");
				lore.add(" §7- 1 Dirt ");
				lore.add(" §7- 2 EXP Levels ");
				lore.add("");
				lore.add(" §7Cooldown: §e24h ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[3] = item;
			}
			{
				ItemStack item = new ItemStack(Material.DIAMOND, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§9§lDiamond VIP Kit");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7- 64 Cobblestone ");
				lore.add(" §7- 8 Iron Ingots ");
				lore.add(" §7- 1 Dirt ");
				lore.add(" §7- 1 Sand ");
				lore.add(" §7- 5 EXP Levels ");
				lore.add("");
				lore.add(" §7Cooldown: §e24h ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[5] = item;
			}
			{
				ItemStack item = new ItemStack(Material.EMERALD, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lEmerald VIP Kit");
				List<String> lore = new ArrayList<String>();
				lore.add(" §7- 128 Cobblestone ");
				lore.add(" §7- 10 Iron Ingots ");
				lore.add(" §7- 2 Dirt ");
				lore.add(" §7- 2 Sand ");
				lore.add(" §7- 8 EXP Levels ");
				lore.add(" §7- 1 Diamond ");
				lore.add("");
				lore.add(" §7Cooldown: §e24h ");
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				contents[7] = item;
			}
			
			return contents;
		}
	}
}