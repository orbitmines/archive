package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.KitSelector;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Archer.ArcherLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Assassin.AssassinInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Assassin.AssassinLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Beast.BeastInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Beast.BeastLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Blaze.BlazeLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Bunny.BunnyLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.DarkMage.DarkMageInv;
import me.O_o_Fadi_o_O.KitPvP.kits.DarkMage.DarkMageLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Drunk.DrunkLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Fish.FishInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Fish.FishLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Fisherman.FishermanLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.GrimReaper.GrimReaperInv;
import me.O_o_Fadi_o_O.KitPvP.kits.GrimReaper.GrimReaperLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Heavy.HeavyInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Heavy.HeavyLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingInv;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.King.KingLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Knight.KnightLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Librarian.LibrarianLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Lord.LordInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Lord.LordLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Miner.MinerInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Miner.MinerLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Necromancer.NecromancerLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Pyro.PyroLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemInv;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.SnowGolem.SnowGolemLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Soldier.SoldierLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Spider.SpiderLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTInv;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.TNT.TNTLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Tank.TankLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Tree.TreeLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Vampire.VampireInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Vampire.VampireLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Villager.VillagerLvL3;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardInv;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardLvL1;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardLvL2;
import me.O_o_Fadi_o_O.KitPvP.kits.Wizard.WizardLvL3;
import me.O_o_Fadi_o_O.KitPvP.managers.ConfirmManager;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.Currency;
import me.O_o_Fadi_o_O.KitPvP.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent2 implements Listener{
	
	Start start = Start.getInstance();
	
	private KnightInv knightinv = new KnightInv();
	private ArcherInv archerinv = new ArcherInv();
	private SoldierInv soldierinv = new SoldierInv();
	private WizardInv wizardinv = new WizardInv();
	private TankInv tankinv = new TankInv();
	private DrunkInv drunkinv = new DrunkInv();
	private PyroInv pyroinv = new PyroInv();
	private BunnyInv bunnyinv = new BunnyInv();	
	private NecromancerInv necromancerinv = new NecromancerInv();	
	private KingInv kinginv = new KingInv();
	private TreeInv treeinv = new TreeInv();
	private BlazeInv blazeinv = new BlazeInv();
	private TNTInv tntinv = new TNTInv();
	private FishermanInv fishermaninv = new FishermanInv();
	private SnowGolemInv snowgoleminv = new SnowGolemInv();
	private SpiderInv spiderinv = new SpiderInv();
	private LibrarianInv librarianinv = new LibrarianInv();
	private VillagerInv villagerinv = new VillagerInv();
	private AssassinInv assassininv = new AssassinInv();
	private LordInv lordinv = new LordInv();
	private VampireInv vampireinv = new VampireInv();
	private DarkMageInv darkmageinv = new DarkMageInv();
	private BeastInv beastinv = new BeastInv();
	private FishInv fishinv = new FishInv();
	private HeavyInv heavyinv = new HeavyInv();
	private GrimReaperInv grimreaperinv = new GrimReaperInv();
	private MinerInv minerinv = new MinerInv();
	
	private KitSelector kitselector = new KitSelector();
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		InventoryAction a = e.getAction();
		ItemStack c = e.getCurrentItem();
		
		if(he instanceof Player){
			Player p = (Player) he;

			if(e.getInventory() == null || e.getInventory().getName() == null || c == null){
				return;
			}
			
			if(e.getInventory().getName().equals("§0§lKit Selector")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					if(c.getType() == Material.STONE_SWORD && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(knightinv.KnightInventory(p, 1));
						}
					}
					if(c.getType() == Material.STONE_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.STONE_SWORD && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lKnight§7' §7§o(§a§oLvL 1§7§o)");
							KnightLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(knightinv.KnightInventory(p, 2));
						}
					}
					if(c.getType() == Material.STONE_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lKnight§7' §7§o(§a§oLvL 2§7§o)");
							KnightLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(knightinv.KnightInventory(p, 3));
						}
					}
					if(c.getType() == Material.STONE_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lKnight§7' §7§o(§a§oLvL 3§7§o)");
							KnightLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(knightinv.KnightInventory(p, 3));
						}
					}
					if(c.getType() == Material.BOW && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(archerinv.ArcherInventory(p, 1));
						}
					}
					if(c.getType() == Material.BOW && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.BOW && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lArcher§7' §7§o(§a§oLvL 1§7§o)");
							ArcherLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(archerinv.ArcherInventory(p, 2));
						}
					}
					if(c.getType() == Material.BOW && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lArcher§7' §7§o(§a§oLvL 2§7§o)");
							ArcherLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(archerinv.ArcherInventory(p, 3));
						}
					}
					if(c.getType() == Material.BOW && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lArcher§7' §7§o(§a§oLvL 3§7§o)");
							ArcherLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(archerinv.ArcherInventory(p, 3));
						}
					}
					if(c.getType() == Material.LEATHER_LEGGINGS && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(soldierinv.SoldierInventory(p, 1));
						}
					}
					if(c.getType() == Material.LEATHER_LEGGINGS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.LEATHER_LEGGINGS && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSoldier§7' §7§o(§a§oLvL 1§7§o)");
							SoldierLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(soldierinv.SoldierInventory(p, 2));
						}
					}
					if(c.getType() == Material.LEATHER_LEGGINGS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSoldier§7' §7§o(§a§oLvL 2§7§o)");
							SoldierLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(soldierinv.SoldierInventory(p, 3));
						}
					}
					if(c.getType() == Material.LEATHER_LEGGINGS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSoldier§7' §7§o(§a§oLvL 3§7§o)");
							SoldierLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(soldierinv.SoldierInventory(p, 3));
						}
					}
					if(c.getType() == Material.POTION && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 1));
						}
					}
					if(c.getType() == Material.POTION && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.POTION && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lWizard§7' §7§o(§a§oLvL 1§7§o)");
							WizardLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(wizardinv.WizardInventory(p, 2));
						}
					}
					if(c.getType() == Material.POTION && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lWizard§7' §7§o(§a§oLvL 2§7§o)");
							WizardLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(wizardinv.WizardInventory(p, 3));
						}
					}
					if(c.getType() == Material.POTION && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lWizard§7' §7§o(§a§oLvL 3§7§o)");
							WizardLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(wizardinv.WizardInventory(p, 3));
						}
					}
					if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tankinv.TankInventory(p, 1));
						}
					}
					if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTank§7' §7§o(§a§oLvL 1§7§o)");
							TankLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tankinv.TankInventory(p, 2));
						}
					}
					if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTank§7' §7§o(§a§oLvL 2§7§o)");
							TankLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 3));
						}
					}
					if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTank§7' §7§o(§a§oLvL 3§7§o)");
							TankLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tankinv.TankInventory(p, 3));
						}
					}
					if(c.getType() == Material.CHAINMAIL_LEGGINGS && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(drunkinv.DrunkInventory(p, 1));
						}
					}
					if(c.getType() == Material.CHAINMAIL_LEGGINGS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.CHAINMAIL_LEGGINGS && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lDrunk§7' §7§o(§a§oLvL 1§7§o)");
							DrunkLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(drunkinv.DrunkInventory(p, 2));
						}
					}
					if(c.getType() == Material.CHAINMAIL_LEGGINGS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lDrunk§7' §7§o(§a§oLvL 2§7§o)");
							DrunkLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(drunkinv.DrunkInventory(p, 3));
						}
					}
					if(c.getType() == Material.CHAINMAIL_LEGGINGS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lDrunk§7' §7§o(§a§oLvL 3§7§o)");
							DrunkLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(drunkinv.DrunkInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_HELMET && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(pyroinv.PyroInventory(p, 1));
						}
					}
					if(c.getType() == Material.GOLD_HELMET && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.GOLD_HELMET && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lPyro§7' §7§o(§a§oLvL 1§7§o)");
							PyroLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(pyroinv.PyroInventory(p, 2));
						}
					}
					if(c.getType() == Material.GOLD_HELMET && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lPyro§7' §7§o(§a§oLvL 2§7§o)");
							PyroLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(pyroinv.PyroInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_HELMET && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lPyro§7' §7§o(§a§oLvL 3§7§o)");
							PyroLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(pyroinv.PyroInventory(p, 3));
						}
					}
					if(c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(bunnyinv.BunnyInventory(p, 1));
						}
					}
					if(c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBunny§7' §7§o(§a§oLvL 1§7§o)");
							BunnyLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(bunnyinv.BunnyInventory(p, 2));
						}
					}
					if(c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBunny§7' §7§o(§a§oLvL 2§7§o)");
							BunnyLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(bunnyinv.BunnyInventory(p, 3));
						}
					}
					if(c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBunny§7' §7§o(§a§oLvL 3§7§o)");
							BunnyLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(bunnyinv.BunnyInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_HOE && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(necromancerinv.NecromancerInventory(p, 1));
						}
					}
					if(c.getType() == Material.GOLD_HOE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.GOLD_HOE && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lNecromancer§7' §7§o(§a§oLvL 1§7§o)");
							NecromancerLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(necromancerinv.NecromancerInventory(p, 2));
						}
					}
					if(c.getType() == Material.GOLD_HOE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lNecromancer§7' §7§o(§a§oLvL 2§7§o)");
							NecromancerLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(necromancerinv.NecromancerInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_HOE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lNecromancer§7' §7§o(§a§oLvL 3§7§o)");
							NecromancerLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(necromancerinv.NecromancerInventory(p, 3));
						}
					}
					if(c.getType() == Material.DIAMOND_HELMET && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(kinginv.KingInventory(p, 1));
						}
					}
					if(c.getType() == Material.DIAMOND_HELMET && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.DIAMOND_HELMET && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lKing§7' §7§o(§a§oLvL 1§7§o)");
							KingLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(kinginv.KingInventory(p, 2));
						}
					}
					if(c.getType() == Material.DIAMOND_HELMET && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lKing§7' §7§o(§a§oLvL 2§7§o)");
							KingLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(kinginv.KingInventory(p, 3));
						}
					}
					if(c.getType() == Material.DIAMOND_HELMET && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lKing§7' §7§o(§a§oLvL 3§7§o)");
							KingLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(kinginv.KingInventory(p, 3));
						}
					}
					if(c.getType() == Material.LEAVES && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(treeinv.TreeInventory(p, 1));
						}
					}
					if(c.getType() == Material.LEAVES && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.LEAVES && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTree§7' §7§o(§a§oLvL 1§7§o)");
							TreeLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(treeinv.TreeInventory(p, 2));
						}
					}
					if(c.getType() == Material.LEAVES && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTree§7' §7§o(§a§oLvL 2§7§o)");
							TreeLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(treeinv.TreeInventory(p, 3));
						}
					}
					if(c.getType() == Material.LEAVES && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTree§7' §7§o(§a§oLvL 3§7§o)");
							TreeLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(treeinv.TreeInventory(p, 3));
						}
					}
					if(c.getType() == Material.BLAZE_POWDER && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(blazeinv.BlazeInventory(p, 1));
						}
					}
					if(c.getType() == Material.BLAZE_POWDER && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.BLAZE_POWDER && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBlaze§7' §7§o(§a§oLvL 1§7§o)");
							BlazeLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(blazeinv.BlazeInventory(p, 2));
						}
					}
					if(c.getType() == Material.BLAZE_POWDER && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBlaze§7' §7§o(§a§oLvL 2§7§o)");
							BlazeLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(blazeinv.BlazeInventory(p, 3));
						}
					}
					if(c.getType() == Material.BLAZE_POWDER && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBlaze§7' §7§o(§a§oLvL 3§7§o)");
							BlazeLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(blazeinv.BlazeInventory(p, 3));
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tntinv.TNTInventory(p, 1));
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.TNT && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTNT§7' §7§o(§a§oLvL 1§7§o)");
							TNTLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tntinv.TNTInventory(p, 2));
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTNT§7' §7§o(§a§oLvL 2§7§o)");
							TNTLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tntinv.TNTInventory(p, 3));
						}
					}
					if(c.getType() == Material.TNT && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lTNT§7' §7§o(§a§oLvL 3§7§o)");
							TNTLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(tntinv.TNTInventory(p, 3));
						}
					}
					if(c.getType() == Material.FISHING_ROD && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishermaninv.FishermanInventory(p, 1));
						}
					}
					if(c.getType() == Material.FISHING_ROD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.FISHING_ROD && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lFisherman§7' §7§o(§a§oLvL 1§7§o)");
							FishermanLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishermaninv.FishermanInventory(p, 2));
						}
					}
					if(c.getType() == Material.FISHING_ROD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lFisherman§7' §7§o(§a§oLvL 2§7§o)");
							FishermanLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishermaninv.FishermanInventory(p, 3));
						}
					}
					if(c.getType() == Material.FISHING_ROD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lFisherman§7' §7§o(§a§oLvL 3§7§o)");
							FishermanLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishermaninv.FishermanInventory(p, 3));
						}
					}
					if(c.getType() == Material.PUMPKIN && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
						}
					}
					if(c.getType() == Material.PUMPKIN && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.PUMPKIN && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSnowGolem§7' §7§o(§a§oLvL 1§7§o)");
							SnowGolemLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
						}
					}
					if(c.getType() == Material.PUMPKIN && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSnowGolem§7' §7§o(§a§oLvL 2§7§o)");
							SnowGolemLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
						}
					}
					if(c.getType() == Material.PUMPKIN && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSnowGolem§7' §7§o(§a§oLvL 3§7§o)");
							SnowGolemLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
						}
					}
					if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(librarianinv.LibrarianInventory(p, 1));
						}
					}
					if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.BOOKSHELF && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lLibrarian§7' §7§o(§a§oLvL 1§7§o)");
							LibrarianLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(librarianinv.LibrarianInventory(p, 2));
						}
					}
					if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lLibrarian§7' §7§o(§a§oLvL 2§7§o)");
							LibrarianLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(librarianinv.LibrarianInventory(p, 3));
						}
					}
					if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lLibrarian§7' §7§o(§a§oLvL 3§7§o)");
							LibrarianLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(librarianinv.LibrarianInventory(p, 3));
						}
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(spiderinv.SpiderInventory(p, 1));
						}
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.SPIDER_EYE && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSpider§7' §7§o(§a§oLvL 1§7§o)");
							SpiderLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(spiderinv.SpiderInventory(p, 2));
						}
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSpider§7' §7§o(§a§oLvL 2§7§o)");
							SpiderLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(spiderinv.SpiderInventory(p, 3));
						}
					}
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lSpider§7' §7§o(§a§oLvL 3§7§o)");
							SpiderLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(spiderinv.SpiderInventory(p, 3));
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(villagerinv.VillagerInventory(p, 1));
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.EMERALD && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lVillager§7' §7§o(§a§oLvL 1§7§o)");
							VillagerLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(villagerinv.VillagerInventory(p, 2));
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lVillager§7' §7§o(§a§oLvL 2§7§o)");
							VillagerLvL2.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(villagerinv.VillagerInventory(p, 3));
						}
					}
					if(c.getType() == Material.EMERALD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lVillager§7' §7§o(§a§oLvL 3§7§o)");
							VillagerLvL3.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(villagerinv.VillagerInventory(p, 3));
						}
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(assassininv.AssassinInventory(p, 1));
						}
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lAssassin§7' §7§o(§a§oLvL 1§7§o)");
							AssassinLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(assassininv.AssassinInventory(p, 1));
						}
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lAssassin§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Assassin LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(assassininv.AssassinInventory(p, 3));
						}
					}
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lAssassin§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Assassin LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(assassininv.AssassinInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_SWORD && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(lordinv.LordInventory(p, 1));
						}
					}
					if(c.getType() == Material.GOLD_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.GOLD_SWORD && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lLord§7' §7§o(§a§oLvL 1§7§o)");
							LordLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(lordinv.LordInventory(p, 1));
						}
					}
					if(c.getType() == Material.GOLD_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lLord§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Lord LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(lordinv.LordInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_SWORD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lLord§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Lord LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(lordinv.LordInventory(p, 3));
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(vampireinv.VampireInventory(p, 1));
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.REDSTONE && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lVampire§7' §7§o(§a§oLvL 1§7§o)");
							VampireLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(vampireinv.VampireInventory(p, 1));
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lVampire§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Vampire LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(vampireinv.VampireInventory(p, 3));
						}
					}
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lVampire§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Vampire LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(vampireinv.VampireInventory(p, 3));
						}
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(darkmageinv.DarkMageInventory(p, 1));
						}
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.BLAZE_ROD && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lDarkMage§7' §7§o(§a§oLvL 1§7§o)");
							DarkMageLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(darkmageinv.DarkMageInventory(p, 1));
						}
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lDarkMage§7' §7§o(§a§oLvL 2§7§o)");
							// TODO DarkMage LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(darkmageinv.DarkMageInventory(p, 3));
						}
					}
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lDarkMage§7' §7§o(§a§oLvL 3§7§o)");
							// TODO DarkMage LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(darkmageinv.DarkMageInventory(p, 3));
						}
					}
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(beastinv.BeastInventory(p, 1));
						}
					}
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.IRON_AXE && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBeast§7' §7§o(§a§oLvL 1§7§o)");
							BeastLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(beastinv.BeastInventory(p, 1));
						}
					}
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBeast§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Beast LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(beastinv.BeastInventory(p, 3));
						}
					}
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lBeast§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Beast LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(beastinv.BeastInventory(p, 3));
						}
					}
					if(c.getType() == Material.RAW_FISH && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishinv.FishInventory(p, 1));
						}
					}
					if(c.getType() == Material.RAW_FISH && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.RAW_FISH && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lFish§7' §7§o(§a§oLvL 1§7§o)");
							FishLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishinv.FishInventory(p, 1));
						}
					}
					if(c.getType() == Material.RAW_FISH && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lFish§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Fish LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){	
							p.openInventory(fishinv.FishInventory(p, 3));
						}
					}
					if(c.getType() == Material.RAW_FISH && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lFish§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Fish LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(fishinv.FishInventory(p, 3));
						}
					}
					if(c.getType() == Material.ARROW && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(heavyinv.HeavyInventory(p, 1));
						}
					}
					if(c.getType() == Material.ARROW && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.ARROW && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lHeavy§7' §7§o(§a§oLvL 1§7§o)");
							HeavyLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(heavyinv.HeavyInventory(p, 1));
						}
					}
					if(c.getType() == Material.ARROW && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){	
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lHeavy§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Heavy LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(heavyinv.HeavyInventory(p, 3));
						}
					}
					if(c.getType() == Material.ARROW && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lHeavy§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Heavy LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(heavyinv.HeavyInventory(p, 3));
						}
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
						}
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.SKULL_ITEM && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lGrimReaper§7' §7§o(§a§oLvL 1§7§o)");
							GrimReaperLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
						}
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lGrimReaper§7' §7§o(§a§oLvL 2§7§o)");
							// TODO GrimReaper LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 3));
						}
					}
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lGrimReaper§7' §7§o(§a§oLvL 3§7§o)");
							// TODO GrimReaper LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_PICKAXE && c.getItemMeta().getLore().contains("§4§lLocked")){
						if(a == InventoryAction.PICKUP_HALF){
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(minerinv.MinerInventory(p, 1));
						}
					}
					if(c.getType() == Material.GOLD_PICKAXE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 1§7§o)") || c.getType() == Material.GOLD_PICKAXE && c.getItemMeta().getLore().contains("§d§lFREE Kit Saturday!")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lMiner§7' §7§o(§a§oLvL 1§7§o)");
							MinerLvL1.give(p);
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(minerinv.MinerInventory(p, 1));
						}
					}
					if(c.getType() == Material.GOLD_PICKAXE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 2§7§o)")){
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lMiner§7' §7§o(§a§oLvL 2§7§o)");
							// TODO Miner LvL 2
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(minerinv.MinerInventory(p, 3));
						}
					}
					if(c.getType() == Material.GOLD_PICKAXE && c.getItemMeta().getLore().contains("§a§lUnlocked §7§o(§a§oLvL 3§7§o)")){
						
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "Selected Kit: '§b§lMiner§7' §7§o(§a§oLvL 3§7§o)");
							// TODO Miner LvL 3
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 6, 1);
							Start.RandomSpawn(p);
						}
						if(a == InventoryAction.PICKUP_ALL){
							p.openInventory(minerinv.MinerInventory(p, 3));
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lKnight (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o0 Coins")){
						
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p) >= 0){
								
								if(!DatabaseManager.containsPath("name", "Kits-Knight", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Knight", "knight", 0);
								}

								DatabaseManager.addKnightLvL(p, 1);

								DatabaseManager.removeMoney(p, 0);
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lKnight§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(knightinv.KnightInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lKnight (Level 2)")){
				e.setCancelled(true);

				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o10000 Coins")){
						if(StorageManager.money.get(p) >= 10000){

							DatabaseManager.addKnightLvL(p, 1);
							DatabaseManager.removeMoney(p, 10000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lKnight§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(knightinv.KnightInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lKnight (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(knightinv.KnightInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						if(StorageManager.money.get(p) >= 50000){

							DatabaseManager.addKnightLvL(p, 1);
							DatabaseManager.removeMoney(p, 50000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lKnight§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(knightinv.KnightInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}		
			if(e.getInventory().getName().equals("§0§lArcher (Level 1)")){
				e.setCancelled(true);

				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 2§7§o)")){	
						p.openInventory(archerinv.ArcherInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o2500 Coins")){
						if(StorageManager.money.get(p) >= 2500){
							
							if(!DatabaseManager.containsPath("name", "Kits-Archer", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Archer", "archer", 0);
							}
								
							DatabaseManager.addArcherLvL(p, 1);
							DatabaseManager.removeMoney(p, 2500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lArcher§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(archerinv.ArcherInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lArcher (Level 2)")){
				e.setCancelled(true);

				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o25000 Coins")){
						if(StorageManager.money.get(p) >= 25000){
							
							DatabaseManager.addArcherLvL(p, 1);
							DatabaseManager.removeMoney(p, 25000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lArcher§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(archerinv.ArcherInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lArcher (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(archerinv.ArcherInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						if(StorageManager.money.get(p) >= 50000){

							DatabaseManager.addArcherLvL(p, 1);
							DatabaseManager.removeMoney(p, 50000);
								
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lArcher§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(archerinv.ArcherInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSoldier (Level 1)")){
				e.setCancelled(true);

				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o7500 Coins")){
						if(StorageManager.money.get(p) >= 7500){
							
							if(!DatabaseManager.containsPath("name", "Kits-Soldier", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Soldier", "soldier", 0);
							}
						
							DatabaseManager.addSoldierLvL(p, 1);
							DatabaseManager.removeMoney(p, 7500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lSoldier§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(soldierinv.SoldierInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSoldier (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o35000 Coins")){
						if(StorageManager.money.get(p) >= 35000){

							DatabaseManager.addSoldierLvL(p, 1);
							DatabaseManager.removeMoney(p, 35000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lSoldier§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(soldierinv.SoldierInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
						
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSoldier (Level 3)")){
				e.setCancelled(true);

				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(soldierinv.SoldierInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o42500 Coins")){
						if(StorageManager.money.get(p) >= 42500){

							DatabaseManager.addSoldierLvL(p, 1);
							DatabaseManager.removeMoney(p, 42500);
								
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lSoldier§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(soldierinv.SoldierInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lWizard (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o10000 Coins")){
						if(StorageManager.money.get(p) >= 10000){
							
							if(!DatabaseManager.containsPath("name", "Kits-Wizard", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Wizard", "wizard", 0);
							}
							
							DatabaseManager.addWizardLvL(p, 1);
							DatabaseManager.removeMoney(p, 10000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lWizard§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(wizardinv.WizardInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lWizard (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o30000 Coins")){
						if(StorageManager.money.get(p) >= 30000){

							DatabaseManager.addWizardLvL(p, 1);
							DatabaseManager.removeMoney(p, 30000);
								
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lWizard§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(wizardinv.WizardInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lWizard (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(wizardinv.WizardInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o45000 Coins")){
						if(StorageManager.money.get(p) >= 45000){
								
							DatabaseManager.addWizardLvL(p, 1);
							DatabaseManager.removeMoney(p, 45000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lWizard§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(wizardinv.WizardInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTank (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o15000 Coins")){
						if(StorageManager.money.get(p) >= 15000){
								
							if(!DatabaseManager.containsPath("name", "Kits-Tank", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Tank", "tank", 0);
							}

							DatabaseManager.addTankLvL(p, 1);
							DatabaseManager.removeMoney(p, 15000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lTank§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(tankinv.TankInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTank (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						if(StorageManager.money.get(p) >= 50000){

							DatabaseManager.addTankLvL(p, 1);
							DatabaseManager.removeMoney(p, 50000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lTank§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(tankinv.TankInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTank (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(tankinv.TankInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o80000 Coins")){
						if(StorageManager.money.get(p) >= 80000){
							
							DatabaseManager.addTankLvL(p, 1);
							DatabaseManager.removeMoney(p, 80000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lTank§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(tankinv.TankInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lDrunk (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
						
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o17500 Coins")){
						if(StorageManager.money.get(p) >= 17500){
								
							if(!DatabaseManager.containsPath("name", "Kits-Drunk", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Drunk", "drunk", 0);
							}
							
							DatabaseManager.addDrunkLvL(p, 1);
							DatabaseManager.removeMoney(p, 17500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lDrunk§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(drunkinv.DrunkInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lDrunk (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o52500 Coins")){
						if(StorageManager.money.get(p) >= 52500){

							DatabaseManager.addDrunkLvL(p, 1);
							DatabaseManager.removeMoney(p, 52500);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lDrunk§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(drunkinv.DrunkInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lDrunk (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(drunkinv.DrunkInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o87500 Coins")){
						if(StorageManager.money.get(p) >= 87500){
						
							DatabaseManager.addDrunkLvL(p, 1);
							DatabaseManager.removeMoney(p, 87500);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lDrunk§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(drunkinv.DrunkInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lPyro (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o25000 Coins")){
						if(StorageManager.money.get(p) >= 25000){
								
							if(!DatabaseManager.containsPath("name", "Kits-Pyro", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Pyro", "pyro", 0);
							}
							
							DatabaseManager.addPyroLvL(p, 1);
							DatabaseManager.removeMoney(p, 25000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lPyro§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(pyroinv.PyroInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lPyro (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o65000 Coins")){
						if(StorageManager.money.get(p) >= 65000){
								
							DatabaseManager.addPyroLvL(p, 1);
							DatabaseManager.removeMoney(p, 65000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lPyro§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(pyroinv.PyroInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lPyro (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(pyroinv.PyroInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o95000 Coins")){
						if(StorageManager.money.get(p) >= 95000){
								
							DatabaseManager.addPyroLvL(p, 1);
							DatabaseManager.removeMoney(p, 95000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lPyro§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(pyroinv.PyroInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBunny (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o37500 Coins")){
						if(StorageManager.money.get(p) >= 37500){
								
							if(!DatabaseManager.containsPath("name", "Kits-Bunny", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Bunny", "bunny", 0);
							}
							
							DatabaseManager.addBunnyLvL(p, 1);
							DatabaseManager.removeMoney(p, 37500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lBunny§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(bunnyinv.BunnyInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBunny (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						if(StorageManager.money.get(p) >= 50000){
							
							DatabaseManager.addBunnyLvL(p, 1);
							DatabaseManager.removeMoney(p, 50000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lBunny§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(bunnyinv.BunnyInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBunny (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(bunnyinv.BunnyInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o72500 Coins")){
						if(StorageManager.money.get(p) >= 72500){
							
							DatabaseManager.addBunnyLvL(p, 1);
							DatabaseManager.removeMoney(p, 72500);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lBunny§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(bunnyinv.BunnyInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lNecromancer (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						if(StorageManager.money.get(p) >= 50000){
								
							if(!DatabaseManager.containsPath("name", "Kits-Necromancer", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Necromancer", "necromancer", 0);
							}
							
							DatabaseManager.addNecromancerLvL(p, 1);
							DatabaseManager.removeMoney(p, 50000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lNecromancer§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(necromancerinv.NecromancerInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lNecromancer (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o75000 Coins")){
						if(StorageManager.money.get(p) >= 75000){
								
							DatabaseManager.addNecromancerLvL(p, 1);
							DatabaseManager.removeMoney(p, 75000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lNecromancer§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(necromancerinv.NecromancerInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lNecromancer (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(necromancerinv.NecromancerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o100000 Coins")){
						if(StorageManager.money.get(p) >= 100000){
								
							DatabaseManager.addNecromancerLvL(p, 1);
							DatabaseManager.removeMoney(p, 100000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lNecromancer§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(necromancerinv.NecromancerInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lKing (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o10000 Coins")){
						if(StorageManager.money.get(p) >= 10000){
								
							if(!DatabaseManager.containsPath("name", "Kits-King", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-King", "king", 0);
							}
							
							DatabaseManager.addKingLvL(p, 1);
							DatabaseManager.removeMoney(p, 10000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lKing§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(kinginv.KingInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lKing (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o25000 Coins")){
						if(StorageManager.money.get(p) >= 25000){
							
							DatabaseManager.addKingLvL(p, 1);
							DatabaseManager.removeMoney(p, 25000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lKing§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(kinginv.KingInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lKing (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(kinginv.KingInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						if(StorageManager.money.get(p) >= 40000){
								
							DatabaseManager.addKingLvL(p, 1);
							DatabaseManager.removeMoney(p, 40000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lKing§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(kinginv.KingInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTree (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o20000 Coins")){
						if(StorageManager.money.get(p) >= 20000){
								
							if(!DatabaseManager.containsPath("name", "Kits-Tree", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Tree", "tree", 0);
							}
							
							DatabaseManager.addTreeLvL(p, 1);
							DatabaseManager.removeMoney(p, 20000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lTree§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(treeinv.TreeInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTree (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o35000 Coins")){
						if(StorageManager.money.get(p) >= 35000){
								
							DatabaseManager.addTreeLvL(p, 1);
							DatabaseManager.removeMoney(p, 35000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lTree§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(treeinv.TreeInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTree (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(treeinv.TreeInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						if(StorageManager.money.get(p) >= 50000){
							
							DatabaseManager.addTreeLvL(p, 1);
							DatabaseManager.removeMoney(p, 50000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lTree§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(treeinv.TreeInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}	
			if(e.getInventory().getName().equals("§0§lBlaze (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o30000 Coins")){
						if(StorageManager.money.get(p) >= 30000){
								
							if(!DatabaseManager.containsPath("name", "Kits-Blaze", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Blaze", "blaze", 0);
							}
							
							DatabaseManager.addBlazeLvL(p, 1);
							DatabaseManager.removeMoney(p, 30000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lBlaze§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(blazeinv.BlazeInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBlaze (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o60000 Coins")){
						if(StorageManager.money.get(p) >= 60000){
								
							DatabaseManager.addBlazeLvL(p, 1);
							DatabaseManager.removeMoney(p, 60000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lBlaze§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(blazeinv.BlazeInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBlaze (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(blazeinv.BlazeInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						if(StorageManager.money.get(p) >= 40000){
							
							DatabaseManager.addBlazeLvL(p, 1);
							DatabaseManager.removeMoney(p, 40000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lBlaze§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(blazeinv.BlazeInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTNT (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						if(StorageManager.money.get(p) >= 40000){
								
							if(!DatabaseManager.containsPath("name", "Kits-TNT", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-TNT", "tnt", 0);
							}
							
							DatabaseManager.addTNTLvL(p, 1);
							DatabaseManager.removeMoney(p, 40000);

							p.sendMessage(Start.TAG + "You have bought the '§b§lTNT§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(tntinv.TNTInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTNT (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o65000 Coins")){
						if(StorageManager.money.get(p) >= 65000){
							
							DatabaseManager.addTNTLvL(p, 1);
							DatabaseManager.removeMoney(p, 65000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lTNT§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(tntinv.TNTInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTNT (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(tntinv.TNTInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o42500 Coins")){
						if(StorageManager.money.get(p) >= 42500){
								
							DatabaseManager.addTNTLvL(p, 1);
							DatabaseManager.removeMoney(p, 42500);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lTNT§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(tntinv.TNTInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lFisherman (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o32500 Coins")){
						if(StorageManager.money.get(p) >= 32500){
							
							if(!DatabaseManager.containsPath("name", "Kits-Fisherman", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Fisherman", "fisherman", 0);
							}
							
							DatabaseManager.addFishermanLvL(p, 1);
							DatabaseManager.removeMoney(p, 32500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lFisherman§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(fishermaninv.FishermanInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lFisherman (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						if(StorageManager.money.get(p) >= 40000){
								
							DatabaseManager.addFishermanLvL(p, 1);
							DatabaseManager.removeMoney(p, 40000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lFisherman§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(fishermaninv.FishermanInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lFisherman (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));	
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(fishermaninv.FishermanInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o45000 Coins")){
						if(StorageManager.money.get(p) >= 45000){
								
							DatabaseManager.addFishermanLvL(p, 1);
							DatabaseManager.removeMoney(p, 45000);

							p.sendMessage(Start.TAG + "You have upgraded the '§b§lFisherman§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(fishermaninv.FishermanInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSnowGolem (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						if(StorageManager.money.get(p) >= 40000){
								
							if(!DatabaseManager.containsPath("name", "Kits-SnowGolem", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-SnowGolem", "snowgolem", 0);
							}
							
							DatabaseManager.addSnowGolemLvL(p, 1);
							DatabaseManager.removeMoney(p, 40000);

							p.sendMessage(Start.TAG + "You have bought the '§b§lSnowGolem§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSnowGolem (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o55000 Coins")){
						if(StorageManager.money.get(p) >= 55000){
								
							DatabaseManager.addSnowGolemLvL(p, 1);
							DatabaseManager.removeMoney(p, 55000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lSnowGolem§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSnowGolem (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o60000 Coins")){
						if(StorageManager.money.get(p) >= 60000){
								
							DatabaseManager.addSnowGolemLvL(p, 1);
							DatabaseManager.removeMoney(p, 60000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lSnowGolem§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lLibrarian (Level 1)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o60000 Coins")){
						if(StorageManager.money.get(p) >= 60000){
								
							if(!DatabaseManager.containsPath("name", "Kits-Librarian", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Librarian", "librarian", 0);
							}
							
							DatabaseManager.addLibrarianLvL(p, 1);
							DatabaseManager.removeMoney(p, 60000);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lLibrarian§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(librarianinv.LibrarianInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lLibrarian (Level 2)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o70000 Coins")){
						if(StorageManager.money.get(p) >= 70000){
								
							DatabaseManager.addLibrarianLvL(p, 1);
							DatabaseManager.removeMoney(p, 70000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lLibrarian§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(librarianinv.LibrarianInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lLibrarian (Level 3)")){
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(librarianinv.LibrarianInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o80000 Coins")){
						if(StorageManager.money.get(p) >= 80000){
								
							DatabaseManager.addLibrarianLvL(p, 1);
							DatabaseManager.removeMoney(p, 80000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lLibrarian§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(librarianinv.LibrarianInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSpider (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o67500 Coins")){
						if(StorageManager.money.get(p) >= 67500){
								
							if(!DatabaseManager.containsPath("name", "Kits-Spider", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Spider", "spider", 0);
							}
							
							DatabaseManager.addSpiderLvL(p, 1);
							DatabaseManager.removeMoney(p, 67500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lSpider§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(spiderinv.SpiderInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSpider (Level 2)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o75000 Coins")){
						if(StorageManager.money.get(p) >= 75000){
								
							DatabaseManager.addSpiderLvL(p, 1);
							DatabaseManager.removeMoney(p, 75000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lSpider§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(spiderinv.SpiderInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lSpider (Level 3)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(spiderinv.SpiderInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o85000 Coins")){
						if(StorageManager.money.get(p) >= 85000){
								
							DatabaseManager.addSpiderLvL(p, 1);
							DatabaseManager.removeMoney(p, 85000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lSpider§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(spiderinv.SpiderInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lVillager (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o72500 Coins")){
						if(StorageManager.money.get(p) >= 72500){
								
							if(!DatabaseManager.containsPath("name", "Kits-Villager", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Villager", "villager", 0);
							}
							
							DatabaseManager.addVillagerLvL(p, 1);
							DatabaseManager.removeMoney(p, 72500);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lVillager§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(villagerinv.VillagerInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lVillager (Level 2)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o85000 Coins")){
						if(StorageManager.money.get(p) >= 85000){
							
							DatabaseManager.addVillagerLvL(p, 1);
							DatabaseManager.removeMoney(p, 85000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lVillager§7' kit! §7§o(§a§oLvL 2§7§o)");
							p.openInventory(villagerinv.VillagerInventory(p, 2));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lVillager (Level 3)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(villagerinv.VillagerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o100000 Coins")){
						if(StorageManager.money.get(p) >= 100000){
								
							DatabaseManager.addVillagerLvL(p, 1);
							DatabaseManager.removeMoney(p, 100000);
							
							p.sendMessage(Start.TAG + "You have upgraded the '§b§lVillager§7' kit! §7§o(§a§oLvL 3§7§o)");
							p.openInventory(villagerinv.VillagerInventory(p, 3));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lAssassin (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lAssassin §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(assassininv.AssassinInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lAssassin §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(assassininv.AssassinInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lAssassin §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(assassininv.AssassinInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-Assassin", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Assassin", "assassin", 0);
							}
							
							DatabaseManager.addAssassinLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lAssassin§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(assassininv.AssassinInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lLord (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLord §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(lordinv.LordInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLord §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(lordinv.LordInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLord §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(lordinv.LordInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-Lord", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Lord", "lord", 0);
							}
							
							DatabaseManager.addLordLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lLord§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(lordinv.LordInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lVampire (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVampire §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(vampireinv.VampireInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVampire §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(vampireinv.VampireInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVampire §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(vampireinv.VampireInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-Vampire", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Vampire", "vampire", 0);
							}
							
							DatabaseManager.addVampireLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lVampire§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(vampireinv.VampireInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lDarkMage (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDarkMage §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(darkmageinv.DarkMageInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDarkMage §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(darkmageinv.DarkMageInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDarkMage §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(darkmageinv.DarkMageInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-DarkMage", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-DarkMage", "darkmage", 0);
							}
							
							DatabaseManager.addDarkMageLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lDarkMage§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(darkmageinv.DarkMageInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBeast (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBeast §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(beastinv.BeastInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBeast §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(beastinv.BeastInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBeast §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(beastinv.BeastInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-Beast", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Beast", "beast", 0);
							}
							
							DatabaseManager.addBeastLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lBeast§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(beastinv.BeastInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lFish (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFish §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(fishinv.FishInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFish §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(fishinv.FishInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFish §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(fishinv.FishInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-Fish", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Fish", "fish", 0);
							}
							
							DatabaseManager.addFishLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lFish§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(fishinv.FishInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lHeavy (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lHeavy §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(heavyinv.HeavyInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lHeavy §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(heavyinv.HeavyInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lHeavy §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(heavyinv.HeavyInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-Heavy", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Heavy", "Heavy", 0);
							}
							
							DatabaseManager.addHeavyLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lHeavy§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(heavyinv.HeavyInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lGrimReaper (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lGrimReaper §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lGrimReaper §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(grimreaperinv.GrimReaperInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lGrimReaper §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(grimreaperinv.GrimReaperInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
								
							if(!DatabaseManager.containsPath("name", "Kits-GrimReaper", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-GrimReaper", "grimreaper", 0);
							}
							
							DatabaseManager.addGrimReaperLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
								
							p.sendMessage(Start.TAG + "You have bought the '§b§lGrimReaper§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lMiner (Level 1)")){	
				e.setCancelled(true);
				
				if(c != null){
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						p.openInventory(kitselector.getKitSelector(p));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lMiner §7§o(§a§oLvL 1§7§o)")){
						p.openInventory(minerinv.MinerInventory(p, 1));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lMiner §7§o(§a§oLvL 2§7§o)")){
						p.openInventory(minerinv.MinerInventory(p, 2));
					}
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lMiner §7§o(§a§oLvL 3§7§o)")){
						p.openInventory(minerinv.MinerInventory(p, 3));
					}
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						if(StorageManager.orbitminestokens.get(p) >= 150){
							
							if(!DatabaseManager.containsPath("name", "Kits-Miner", p.getName())){
								DatabaseManager.insertInt(p.getName(), "Kits-Miner", "miner", 0);
							}
							
							DatabaseManager.addMinerLvL(p, 1);
							DatabaseManager.removeOMT(p, 150);
							
							p.sendMessage(Start.TAG + "You have bought the '§b§lMiner§7' kit! §7§o(§a§oLvL 1§7§o)");
							p.openInventory(minerinv.MinerInventory(p, 1));
							
						}
						else{
							p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lBoosters")){
				e.setCancelled(true);
				if(c.getType() == Material.IRON_INGOT && c.getItemMeta().getDisplayName().equals("§7§lIron VIP Booster")){
					if(!PlayerManager.hasVIPPerms(p, VIPRank.Iron_VIP)){
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);

						p.sendMessage(Start.TAG + "§4§lDENIED §7Required: §7§lIron VIP§7!");
						
					}
					else{
						if(StorageManager.vippoints.get(p) >= 200){
							if(StorageManager.boosterplayer.equals("")){
								p.openInventory(ConfirmManager.getConfirmInv(c, Currency.VIP_POINTS, 200));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage(Start.TAG + "§4§lDENIED§7! §a" + StorageManager.boosterplayer + "§7 already used a §aBooster§7.");
							}
						}
						else{
							PlayerManager.sendVIPPointsRequiredMessage(p, 200);
						}
					}
				}
				if(c.getType() == Material.GOLD_INGOT && c.getItemMeta().getDisplayName().equals("§6§lGold VIP Booster")){
					if(!PlayerManager.hasVIPPerms(p, VIPRank.Gold_VIP)){
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);

						p.sendMessage(Start.TAG + "§4§lDENIED §7Required: §6§lGold VIP§7!");
					}
					else{
						if(StorageManager.vippoints.get(p) >= 200){
							if(StorageManager.boosterplayer.equals("")){
								p.openInventory(ConfirmManager.getConfirmInv(c, Currency.VIP_POINTS, 200));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage(Start.TAG + "§4§lDENIED§7! §a" + StorageManager.boosterplayer + "§7 already used a §aBooster§7.");
							}
						}
						else{
							PlayerManager.sendVIPPointsRequiredMessage(p, 200);
						}
					}
				}
				if(c.getType() == Material.DIAMOND && c.getItemMeta().getDisplayName().equals("§b§lDiamond VIP Booster")){
					if(!PlayerManager.hasVIPPerms(p, VIPRank.Diamond_VIP)){
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);

						p.sendMessage(Start.TAG + "§4§lDENIED §7Required: §b§lDiamond VIP§7!");
						
					}
					else{
						if(StorageManager.vippoints.get(p) >= 200){
							if(StorageManager.boosterplayer.equals("")){
								p.openInventory(ConfirmManager.getConfirmInv(c, Currency.VIP_POINTS, 200));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage(Start.TAG + "§4§lDENIED§7! §a" + StorageManager.boosterplayer + "§7 already used a §aBooster§7.");
							}
						}
						else{
							PlayerManager.sendVIPPointsRequiredMessage(p, 200);
						}
					}
				}
				if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§a§lEmerald VIP Booster")){
					if(!PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);

						p.sendMessage(Start.TAG + "§4§lDENIED §7Required: §a§lEmerald VIP§7!");
						
					}
					else{
						if(StorageManager.vippoints.get(p) >= 200){
							if(StorageManager.boosterplayer.equals("")){
								p.openInventory(ConfirmManager.getConfirmInv(c, Currency.VIP_POINTS, 200));
							}
							else{
								p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
								p.sendMessage(Start.TAG + "§4§lDENIED§7! §a" + StorageManager.boosterplayer + "§7 already used a §aBooster§7.");
							}
						}
						else{
							PlayerManager.sendVIPPointsRequiredMessage(p, 200);
						}
					}
				}
			}
			if(e.getInventory().getName().equals("§0§lTeleporter")){
				e.setCancelled(true);
				
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§8")){
					
					String s = c.getItemMeta().getDisplayName().substring(2);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§7")){
					
					String s = c.getItemMeta().getDisplayName().substring(11);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§6")){
					
					String s = c.getItemMeta().getDisplayName().substring(11);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§9")){
					
					String s = c.getItemMeta().getDisplayName().substring(14);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§a")){
					
					String s = c.getItemMeta().getDisplayName().substring(14);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§d")){
					
					String s = c.getItemMeta().getDisplayName().substring(14);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§b")){
					
					String s = c.getItemMeta().getDisplayName().substring(10);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
				if(c.getType() != null && c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().startsWith("§4")){
					
					String s = c.getItemMeta().getDisplayName().substring(12);
					
					Player player = Bukkit.getPlayer(s);
					
					p.closeInventory();
					p.teleport(player);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.sendMessage("§eTeleporting to " + c.getItemMeta().getDisplayName());
					
				}
			}
		}
	}
}
