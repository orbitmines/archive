package me.O_o_Fadi_o_O.KitPvP.events;

import java.sql.SQLException;

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
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

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
	
	Start plugin;
	 
	public ClickEvent2(Start instance) {
	plugin = instance;
	}
	private KnightInv knightinv = new KnightInv(this.plugin);
	private ArcherInv archerinv = new ArcherInv(this.plugin);
	private SoldierInv soldierinv = new SoldierInv(this.plugin);
	private WizardInv wizardinv = new WizardInv(this.plugin);
	private TankInv tankinv = new TankInv(this.plugin);
	private DrunkInv drunkinv = new DrunkInv(this.plugin);
	private PyroInv pyroinv = new PyroInv(this.plugin);
	private BunnyInv bunnyinv = new BunnyInv(this.plugin);	
	private NecromancerInv necromancerinv = new NecromancerInv(this.plugin);	
	private KingInv kinginv = new KingInv(this.plugin);
	private TreeInv treeinv = new TreeInv(this.plugin);
	private BlazeInv blazeinv = new BlazeInv(this.plugin);
	private TNTInv tntinv = new TNTInv(this.plugin);
	private FishermanInv fishermaninv = new FishermanInv(this.plugin);
	private SnowGolemInv snowgoleminv = new SnowGolemInv(this.plugin);
	private SpiderInv spiderinv = new SpiderInv(this.plugin);
	private LibrarianInv librarianinv = new LibrarianInv(this.plugin);
	private VillagerInv villagerinv = new VillagerInv(this.plugin);
	private AssassinInv assassininv = new AssassinInv(this.plugin);
	private LordInv lordinv = new LordInv(this.plugin);
	private VampireInv vampireinv = new VampireInv(this.plugin);
	private DarkMageInv darkmageinv = new DarkMageInv(this.plugin);
	private BeastInv beastinv = new BeastInv(this.plugin);
	private FishInv fishinv = new FishInv(this.plugin);
	private HeavyInv heavyinv = new HeavyInv(this.plugin);
	private GrimReaperInv grimreaperinv = new GrimReaperInv(this.plugin);
	private MinerInv minerinv = new MinerInv(this.plugin);
	
	private KitSelector kitselector = new KitSelector(this.plugin);
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		HumanEntity he = e.getWhoClicked();
		if((he instanceof Player)){
			Player p = (Player) he;
			// KIT SELECTOR
			if(e.getInventory().getName().equals(kitselector.getKitSelector(p).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					if(c.getType() == Material.ENDER_CHEST){
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					}
					// KNIGHT LVL 0
					if(c.getType() == Material.STONE_SWORD && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 1));
							
						}
					}
					// KNIGHT LVL 1
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
					// KNIGHT LVL 2
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
					// KNIGHT LVL 3
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
					// ARCHER LVL 0
					if(c.getType() == Material.BOW && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 1));
							
						}
					}
					// ARCHER LVL 1
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
					// ARCHER LVL 2
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
					// ARCHER LVL 3
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
					// SOLDIER LVL 0
					if(c.getType() == Material.LEATHER_LEGGINGS && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 1));
							
						}
					}
					// SOLDIER LVL 1
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
					// SOLDIER LVL 2
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
					// SOLDIER LVL 3
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
					// WIZARD LVL 0
					if(c.getType() == Material.POTION && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 1));
							
						}
					}
					// WIZARD LVL 1
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
					// WIZARD LVL 2
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
					// WIZARD LVL 3
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
					// TANK LVL 0
					if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 1));
							
						}
					}
					// TANK LVL 1
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
					// TANK LVL 2
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
					// TANK LVL 3
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
					// Drunk LVL 0
					if(c.getType() == Material.CHAINMAIL_LEGGINGS && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 1));
							
						}
					}
					// Drunk LVL 1
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
					// Drunk LVL 2
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
					// Drunk LVL 3
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
					// Pyro LVL 0
					if(c.getType() == Material.GOLD_HELMET && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 1));
							
						}
					}
					// Pyro LVL 1
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
					// Pyro LVL 2
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
					// Pyro LVL 3
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
					// Bunny LVL 0
					if(c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 1));
							
						}
					}
					// Bunny LVL 1
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
					// Bunny LVL 2
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
					// Bunny LVL 3
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
					// Necromancer LVL 0
					if(c.getType() == Material.GOLD_HOE && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 1));
							
						}
					}
					// Necromancer LVL 1
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
					// Necromancer LVL 2
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
					// Necromancer LVL 3
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
					// King LVL 0
					if(c.getType() == Material.DIAMOND_HELMET && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 1));
							
						}
					}
					// King LVL 1
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
					// King LVL 2
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
					// King LVL 3
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
					// Tree LVL 0
					if(c.getType() == Material.LEAVES && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 1));
							
						}
					}
					// Tree LVL 1
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
					// Tree LVL 2
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
					// Tree LVL 3
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
					// Blaze LVL 0
					if(c.getType() == Material.BLAZE_POWDER && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 1));
							
						}
					}
					// Blaze LVL 1
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
					// Blaze LVL 2
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
					// Blaze LVL 3
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
					// TNT LVL 0
					if(c.getType() == Material.TNT && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 1));
							
						}
					}
					// TNT LVL 1
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
					// TNT LVL 2
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
					// TNT LVL 3
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
					// Fisherman LVL 0
					if(c.getType() == Material.FISHING_ROD && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 1));
							
						}
					}
					// Fisherman LVL 1
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
					// Fisherman LVL 2
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
					// Fisherman LVL 3
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
					// SnowGolem LVL 0
					if(c.getType() == Material.PUMPKIN && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
							
						}
					}
					// SnowGolem LVL 1
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
					// SnowGolem LVL 2
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
					// SnowGolem LVL 3
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
					// Librarian LVL 0
					if(c.getType() == Material.BOOKSHELF && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 1));
							
						}
					}
					// Librarian LVL 1
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
					// Librarian LVL 2
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
					// Librarian LVL 3
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
					// Spider LVL 0
					if(c.getType() == Material.SPIDER_EYE && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 1));
							
						}
					}
					// Spider LVL 1
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
					// Spider LVL 2
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
					// Spider LVL 3
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
					// Villager LVL 0
					if(c.getType() == Material.EMERALD && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 1));
							
						}
					}
					// Villager LVL 1
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
					// Villager LVL 2
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
					// Villager LVL 3
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
					// Assassin LVL 0
					if(c.getType() == Material.DIAMOND_SWORD && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(assassininv.AssassinInventory(p, 1));
							
						}
					}
					// Assassin LVL 1
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
					// Assassin LVL 2
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
					// Assassin LVL 3
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
					// Lord LVL 0
					if(c.getType() == Material.GOLD_SWORD && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(lordinv.LordInventory(p, 1));
							
						}
					}
					// Lord LVL 1
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
					// Lord LVL 2
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
					// Lord LVL 3
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
					// Vampire LVL 0
					if(c.getType() == Material.REDSTONE && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(vampireinv.VampireInventory(p, 1));
							
						}
					}
					// Vampire LVL 1
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
					// Vampire LVL 2
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
					// Vampire LVL 3
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
					// DarkMage LVL 0
					if(c.getType() == Material.BLAZE_ROD && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(darkmageinv.DarkMageInventory(p, 1));
							
						}
					}
					// DarkMage LVL 1
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
					// DarkMage LVL 2
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
					// DarkMage LVL 3
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
					// Beast LVL 0
					if(c.getType() == Material.IRON_AXE && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(beastinv.BeastInventory(p, 1));
							
						}
					}
					// Beast LVL 1
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
					// Beast LVL 2
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
					// Beast LVL 3
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
					// Fish LVL 0
					if(c.getType() == Material.RAW_FISH && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishinv.FishInventory(p, 1));
							
						}
					}
					// Fish LVL 1
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
					// Fish LVL 2
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
					// Fish LVL 3
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
					// Heavy LVL 0
					if(c.getType() == Material.ARROW && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(heavyinv.HeavyInventory(p, 1));
							
						}
					}
					// Heavy LVL 1
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
					// Heavy LVL 2
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
					// Heavy LVL 3
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
					// GrimReaper LVL 0
					if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
							
						}
					}
					// GrimReaper LVL 1
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
					// GrimReaper LVL 2
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
					// GrimReaper LVL 3
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
					// Miner LVL 0
					if(c.getType() == Material.GOLD_PICKAXE && c.getItemMeta().getLore().contains("§4§lLocked")){
						
						// RIGHT CLICK
						if(a == InventoryAction.PICKUP_HALF){
							
							p.sendMessage(Start.TAG + "This kit is §4§lLocked§7 for you! Buy it with §6Left Click§7!");
							
						}
						// LEFT CLICK
						if(a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(minerinv.MinerInventory(p, 1));
							
						}
					}
					// Miner LVL 1
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
					// Miner LVL 2
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
					// Miner LVL 3
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
			// KNIGHT 1
			if(e.getInventory().getName().equals(knightinv.KnightInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// KNIGHT 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 1));
							
						}
					}
					// KNIGHT 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 2));
							
						}
					}
					// KNIGHT 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 3));
							
						}
					}
					// BUY KNIGHT 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o0 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 0){
								
								if(!DatabaseManager.containsPath("name", "Kits-Knight", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Knight", "knight", 0);
								}
								
								// ADD KNIGHT LVL
								try {
									DatabaseManager.addKnightLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 0);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
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
			// KNIGHT 2
			if(e.getInventory().getName().equals(knightinv.KnightInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// KNIGHT 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 1));
							
						}
					}
					// KNIGHT 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 2));
							
						}
					}
					// KNIGHT 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 3));
							
						}
					}
					// BUY KNIGHT 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o10000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 10000){
								
								// ADD KNIGHT LVL
								try {
									DatabaseManager.addKnightLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 10000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lKnight§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(knightinv.KnightInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// KNIGHT 3
			if(e.getInventory().getName().equals(knightinv.KnightInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// KNIGHT 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 1));
							
						}
					}
					// KNIGHT 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 2));
							
						}
					}
					// KNIGHT 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKnight §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(knightinv.KnightInventory(p, 3));
							
						}
					}
					// BUY KNIGHT 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 50000){
								
								// ADD KNIGHT LVL
								try {
									DatabaseManager.addKnightLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 50000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lKnight§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(knightinv.KnightInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}		
			// ARCHER 1
			if(e.getInventory().getName().equals(archerinv.ArcherInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// ARCHER 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 1));
							
						}
					}
					// ARCHER 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 2));
							
						}
					}
					// ARCHER 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 3));
							
						}
					}
					// BUY ARCHER 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o2500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 2500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Archer", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Archer", "archer", 0);
								}
								
								// ADD ARCHER LVL
								try {
									DatabaseManager.addArcherLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 2500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lArcher§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(archerinv.ArcherInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// ARCHER 2
			if(e.getInventory().getName().equals(archerinv.ArcherInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// ARCHER 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 1));
							
						}
					}
					// ARCHER 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 2));
							
						}
					}
					// ARCHER 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 3));
							
						}
					}
					// BUY ARCHER 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o25000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 25000){
								
								// ADD ARCHER LVL
								try {
									DatabaseManager.addArcherLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 25000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lArcher§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(archerinv.ArcherInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// ARCHER 3
			if(e.getInventory().getName().equals(archerinv.ArcherInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// ARCHER 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 1));
							
						}
					}
					// ARCHER 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 2));
							
						}
					}
					// ARCHER 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lArcher §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(archerinv.ArcherInventory(p, 3));
							
						}
					}
					// BUY ARCHER 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 50000){
								
								// ADD ARCHER LVL
								try {
									DatabaseManager.addArcherLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 50000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lArcher§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(archerinv.ArcherInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// SOLDIER 1
			if(e.getInventory().getName().equals(soldierinv.SoldierInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// SOLDIER 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 1));
							
						}
					}
					// SOLDIER 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 2));
							
						}
					}
					// SOLDIER 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 3));
							
						}
					}
					// BUY SOLDIER 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o7500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 7500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Soldier", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Soldier", "soldier", 0);
								}
								
								// ADD SOLDIER LVL
								try {
									DatabaseManager.addSoldierLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 7500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lSoldier§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(soldierinv.SoldierInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// SOLDIER 2
			if(e.getInventory().getName().equals(soldierinv.SoldierInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// SOLDIER 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 1));
							
						}
					}
					// SOLDIER 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 2));
							
						}
					}
					// SOLDIER 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 3));
							
						}
					}
					// BUY SOLDIER 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o35000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 35000){
								
								// ADD SOLDIER LVL
								try {
									DatabaseManager.addSoldierLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 35000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lSoldier§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(soldierinv.SoldierInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// SOLDIER 3
			if(e.getInventory().getName().equals(soldierinv.SoldierInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// SOLDIER 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 1));
							
						}
					}
					// SOLDIER 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 2));
							
						}
					}
					// SOLDIER 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSoldier §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(soldierinv.SoldierInventory(p, 3));
							
						}
					}
					// BUY SOLDIER 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o42500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 42500){
								
								// ADD SOLDIER LVL
								try {
									DatabaseManager.addSoldierLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 42500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lSoldier§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(soldierinv.SoldierInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// WIZARD 1
			if(e.getInventory().getName().equals(wizardinv.WizardInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// WIZARD 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 1));
							
						}
					}
					// WIZARD 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 2));
							
						}
					}
					// WIZARD 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 3));
							
						}
					}
					// BUY WIZARD 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o10000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 10000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Wizard", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Wizard", "wizard", 0);
								}
								
								// ADD WIZARD LVL
								try {
									DatabaseManager.addWizardLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 10000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lWizard§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(wizardinv.WizardInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// WIZARD 2
			if(e.getInventory().getName().equals(wizardinv.WizardInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// WIZARD 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 1));
							
						}
					}
					// WIZARD 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 2));
							
						}
					}
					// WIZARD 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 3));
							
						}
					}
					// BUY WIZARD 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o30000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 30000){
								
								// ADD WIZARD LVL
								try {
									DatabaseManager.addWizardLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 30000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lWizard§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(wizardinv.WizardInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// WIZARD 3
			if(e.getInventory().getName().equals(wizardinv.WizardInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// WIZARD 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 1));
							
						}
					}
					// WIZARD 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 2));
							
						}
					}
					// WIZARD 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lWizard §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(wizardinv.WizardInventory(p, 3));
							
						}
					}
					// BUY WIZARD 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o45000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 45000){
								
								// ADD WIZARD LVL
								try {
									DatabaseManager.addWizardLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 45000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lWizard§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(wizardinv.WizardInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Tank 1
			if(e.getInventory().getName().equals(tankinv.TankInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Tank 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 1));
							
						}
					}
					// Tank 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 2));
							
						}
					}
					// Tank 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 3));
							
						}
					}
					// BUY Tank 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o15000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 15000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Tank", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Tank", "tank", 0);
								}
								
								// ADD Tank LVL
								try {
									DatabaseManager.addTankLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 15000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lTank§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(tankinv.TankInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Tank 2
			if(e.getInventory().getName().equals(tankinv.TankInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Tank 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 1));
							
						}
					}
					// Tank 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 2));
							
						}
					}
					// Tank 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 3));
							
						}
					}
					// BUY Tank 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 50000){
								
								// ADD Tank LVL
								try {
									DatabaseManager.addTankLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 50000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lTank§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(tankinv.TankInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Tank 3
			if(e.getInventory().getName().equals(tankinv.TankInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Tank 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 1));
							
						}
					}
					// Tank 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 2));
							
						}
					}
					// Tank 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTank §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tankinv.TankInventory(p, 3));
							
						}
					}
					// BUY Tank 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o80000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 80000){
								
								// ADD Tank LVL
								try {
									DatabaseManager.addTankLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 80000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lTank§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(tankinv.TankInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Drunk 1
			if(e.getInventory().getName().equals(drunkinv.DrunkInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Drunk 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 1));
							
						}
					}
					// Drunk 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 2));
							
						}
					}
					// Drunk 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 3));
							
						}
					}
					// BUY Drunk 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o17500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 17500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Drunk", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Drunk", "drunk", 0);
								}
								
								// ADD Drunk LVL
								try {
									DatabaseManager.addDrunkLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 17500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lDrunk§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(drunkinv.DrunkInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Drunk 2
			if(e.getInventory().getName().equals(drunkinv.DrunkInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Drunk 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 1));
							
						}
					}
					// Drunk 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 2));
							
						}
					}
					// Drunk 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 3));
							
						}
					}
					// BUY Drunk 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o52500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 52500){
								
								// ADD Drunk LVL
								try {
									DatabaseManager.addDrunkLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 52500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lDrunk§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(drunkinv.DrunkInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Drunk 3
			if(e.getInventory().getName().equals(drunkinv.DrunkInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Drunk 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 1));
							
						}
					}
					// Drunk 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 2));
							
						}
					}
					// Drunk 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDrunk §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(drunkinv.DrunkInventory(p, 3));
							
						}
					}
					// BUY Drunk 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o87500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 87500){
								
								// ADD Drunk LVL
								try {
									DatabaseManager.addDrunkLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 87500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lDrunk§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(drunkinv.DrunkInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Pyro 1
			if(e.getInventory().getName().equals(pyroinv.PyroInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Pyro 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 1));
							
						}
					}
					// Pyro 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 2));
							
						}
					}
					// Pyro 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 3));
							
						}
					}
					// BUY Pyro 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o25000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 25000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Pyro", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Pyro", "pyro", 0);
								}
								
								// ADD Pyro LVL
								try {
									DatabaseManager.addPyroLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 25000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lPyro§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(pyroinv.PyroInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Pyro 2
			if(e.getInventory().getName().equals(pyroinv.PyroInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Pyro 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 1));
							
						}
					}
					// Pyro 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 2));
							
						}
					}
					// Pyro 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 3));
							
						}
					}
					// BUY Pyro 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o65000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 65000){
								
								// ADD Pyro LVL
								try {
									DatabaseManager.addPyroLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 65000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lPyro§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(pyroinv.PyroInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Pyro 3
			if(e.getInventory().getName().equals(pyroinv.PyroInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Pyro 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 1));
							
						}
					}
					// Pyro 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 2));
							
						}
					}
					// Pyro 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lPyro §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(pyroinv.PyroInventory(p, 3));
							
						}
					}
					// BUY Pyro 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o95000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 95000){
								
								// ADD Pyro LVL
								try {
									DatabaseManager.addPyroLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 95000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lPyro§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(pyroinv.PyroInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Bunny 1
			if(e.getInventory().getName().equals(bunnyinv.BunnyInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Bunny 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 1));
							
						}
					}
					// Bunny 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 2));
							
						}
					}
					// Bunny 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 3));
							
						}
					}
					// BUY Bunny 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o37500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 37500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Bunny", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Bunny", "bunny", 0);
								}
								
								// ADD Bunny LVL
								try {
									DatabaseManager.addBunnyLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 37500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lBunny§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(bunnyinv.BunnyInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Bunny 2
			if(e.getInventory().getName().equals(bunnyinv.BunnyInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Bunny 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 1));
							
						}
					}
					// Bunny 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 2));
							
						}
					}
					// Bunny 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 3));
							
						}
					}
					// BUY Bunny 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 50000){
								
								// ADD Bunny LVL
								try {
									DatabaseManager.addBunnyLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 50000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lBunny§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(bunnyinv.BunnyInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Bunny 3
			if(e.getInventory().getName().equals(bunnyinv.BunnyInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Bunny 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 1));
							
						}
					}
					// Bunny 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 2));
							
						}
					}
					// Bunny 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBunny §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(bunnyinv.BunnyInventory(p, 3));
							
						}
					}
					// BUY Bunny 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o72500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 72500){
								
								// ADD Bunny LVL
								try {
									DatabaseManager.addBunnyLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 72500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lBunny§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(bunnyinv.BunnyInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Necromancer 1
			if(e.getInventory().getName().equals(necromancerinv.NecromancerInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Necromancer 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 1));
							
						}
					}
					// Necromancer 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 2));
							
						}
					}
					// Necromancer 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 3));
							
						}
					}
					// BUY Necromancer 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 50000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Necromancer", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Necromancer", "necromancer", 0);
								}
								
								// ADD Necromancer LVL
								try {
									DatabaseManager.addNecromancerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 50000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lNecromancer§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(necromancerinv.NecromancerInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Necromancer 2
			if(e.getInventory().getName().equals(necromancerinv.NecromancerInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Necromancer 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 1));
							
						}
					}
					// Necromancer 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 2));
							
						}
					}
					// Necromancer 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 3));
							
						}
					}
					// BUY Necromancer 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o75000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 75000){
								
								// ADD Necromancer LVL
								try {
									DatabaseManager.addNecromancerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 75000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lNecromancer§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(necromancerinv.NecromancerInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Necromancer 3
			if(e.getInventory().getName().equals(necromancerinv.NecromancerInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Necromancer 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 1));
							
						}
					}
					// Necromancer 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 2));
							
						}
					}
					// Necromancer 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lNecromancer §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(necromancerinv.NecromancerInventory(p, 3));
							
						}
					}
					// BUY Necromancer 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o100000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 100000){
								
								// ADD Necromancer LVL
								try {
									DatabaseManager.addNecromancerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 100000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lNecromancer§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(necromancerinv.NecromancerInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// King 1
			if(e.getInventory().getName().equals(kinginv.KingInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// King 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 1));
							
						}
					}
					// King 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 2));
							
						}
					}
					// King 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 3));
							
						}
					}
					// BUY King 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o10000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 10000){
								
								if(!DatabaseManager.containsPath("name", "Kits-King", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-King", "king", 0);
								}
								
								// ADD King LVL
								try {
									DatabaseManager.addKingLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 10000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lKing§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(kinginv.KingInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// King 2
			if(e.getInventory().getName().equals(kinginv.KingInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// King 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 1));
							
						}
					}
					// King 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 2));
							
						}
					}
					// King 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 3));
							
						}
					}
					// BUY King 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o25000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 25000){
								
								// ADD King LVL
								try {
									DatabaseManager.addKingLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 25000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lKing§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(kinginv.KingInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// King 3
			if(e.getInventory().getName().equals(kinginv.KingInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// King 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 1));
							
						}
					}
					// King 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 2));
							
						}
					}
					// King 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lKing §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kinginv.KingInventory(p, 3));
							
						}
					}
					// BUY King 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 40000){
								
								// ADD King LVL
								try {
									DatabaseManager.addKingLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 40000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lKing§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(kinginv.KingInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Tree 1
			if(e.getInventory().getName().equals(treeinv.TreeInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Tree 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 1));
							
						}
					}
					// Tree 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 2));
							
						}
					}
					// Tree 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 3));
							
						}
					}
					// BUY Tree 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o20000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 20000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Tree", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Tree", "tree", 0);
								}
								
								// ADD Tree LVL
								try {
									DatabaseManager.addTreeLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 20000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lTree§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(treeinv.TreeInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Tree 2
			if(e.getInventory().getName().equals(treeinv.TreeInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Tree 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 1));
							
						}
					}
					// Tree 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 2));
							
						}
					}
					// Tree 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 3));
							
						}
					}
					// BUY Tree 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o35000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 35000){
								
								// ADD Tree LVL
								try {
									DatabaseManager.addTreeLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 35000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lTree§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(treeinv.TreeInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Tree 3
			if(e.getInventory().getName().equals(treeinv.TreeInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Tree 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 1));
							
						}
					}
					// Tree 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 2));
							
						}
					}
					// Tree 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTree §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(treeinv.TreeInventory(p, 3));
							
						}
					}
					// BUY Tree 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o50000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 50000){
								
								// ADD Tree LVL
								try {
									DatabaseManager.addTreeLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 50000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lTree§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(treeinv.TreeInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}	
			// Blaze 1
			if(e.getInventory().getName().equals(blazeinv.BlazeInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Blaze 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 1));
							
						}
					}
					// Blaze 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 2));
							
						}
					}
					// Blaze 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 3));
							
						}
					}
					// BUY Blaze 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o30000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 30000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Blaze", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Blaze", "blaze", 0);
								}
								
								// ADD Blaze LVL
								try {
									DatabaseManager.addBlazeLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 30000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lBlaze§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(blazeinv.BlazeInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Blaze 2
			if(e.getInventory().getName().equals(blazeinv.BlazeInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Blaze 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 1));
							
						}
					}
					// Blaze 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 2));
							
						}
					}
					// Blaze 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 3));
							
						}
					}
					// BUY Blaze 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o60000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 60000){
								
								// ADD Blaze LVL
								try {
									DatabaseManager.addBlazeLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 60000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lBlaze§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(blazeinv.BlazeInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Blaze 3
			if(e.getInventory().getName().equals(blazeinv.BlazeInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Blaze 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 1));
							
						}
					}
					// Blaze 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 2));
							
						}
					}
					// Blaze 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBlaze §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(blazeinv.BlazeInventory(p, 3));
							
						}
					}
					// BUY Blaze 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 40000){
								
								// ADD Blaze LVL
								try {
									DatabaseManager.addBlazeLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 40000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lBlaze§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(blazeinv.BlazeInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// TNT 1
			if(e.getInventory().getName().equals(tntinv.TNTInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// TNT 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 1));
							
						}
					}
					// TNT 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 2));
							
						}
					}
					// TNT 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 3));
							
						}
					}
					// BUY TNT 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 40000){
								
								if(!DatabaseManager.containsPath("name", "Kits-TNT", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-TNT", "tnt", 0);
								}
								
								// ADD TNT LVL
								try {
									DatabaseManager.addTNTLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 40000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lTNT§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(tntinv.TNTInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// TNT 2
			if(e.getInventory().getName().equals(tntinv.TNTInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// TNT 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 1));
							
						}
					}
					// TNT 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 2));
							
						}
					}
					// TNT 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 3));
							
						}
					}
					// BUY TNT 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o65000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 65000){
								
								// ADD TNT LVL
								try {
									DatabaseManager.addTNTLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 65000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lTNT§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(tntinv.TNTInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// TNT 3
			if(e.getInventory().getName().equals(tntinv.TNTInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// TNT 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 1));
							
						}
					}
					// TNT 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 2));
							
						}
					}
					// TNT 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lTNT §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(tntinv.TNTInventory(p, 3));
							
						}
					}
					// BUY TNT 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o42500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 42500){
								
								// ADD TNT LVL
								try {
									DatabaseManager.addTNTLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 42500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lTNT§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(tntinv.TNTInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Fisherman 1
			if(e.getInventory().getName().equals(fishermaninv.FishermanInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Fisherman 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 1));
							
						}
					}
					// Fisherman 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 2));
							
						}
					}
					// Fisherman 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 3));
							
						}
					}
					// BUY Fisherman 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o32500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 32500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Fisherman", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Fisherman", "fisherman", 0);
								}
								
								// ADD Fisherman LVL
								try {
									DatabaseManager.addFishermanLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 32500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lFisherman§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(fishermaninv.FishermanInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Fisherman 2
			if(e.getInventory().getName().equals(fishermaninv.FishermanInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Fisherman 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 1));
							
						}
					}
					// Fisherman 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 2));
							
						}
					}
					// Fisherman 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 3));
							
						}
					}
					// BUY Fisherman 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 40000){
								
								// ADD Fisherman LVL
								try {
									DatabaseManager.addFishermanLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 40000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lFisherman§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(fishermaninv.FishermanInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Fisherman 3
			if(e.getInventory().getName().equals(fishermaninv.FishermanInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Fisherman 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 1));
							
						}
					}
					// Fisherman 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 2));
							
						}
					}
					// Fisherman 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFisherman §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishermaninv.FishermanInventory(p, 3));
							
						}
					}
					// BUY Fisherman 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o45000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 45000){
								
								// ADD Fisherman LVL
								try {
									DatabaseManager.addFishermanLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 45000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lFisherman§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(fishermaninv.FishermanInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// SnowGolem 1
			if(e.getInventory().getName().equals(snowgoleminv.SnowGolemInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// SnowGolem 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
							
						}
					}
					// SnowGolem 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
							
						}
					}
					// SnowGolem 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
							
						}
					}
					// BUY SnowGolem 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o40000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 40000){
								
								if(!DatabaseManager.containsPath("name", "Kits-SnowGolem", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-SnowGolem", "snowgolem", 0);
								}
								
								// ADD SnowGolem LVL
								try {
									DatabaseManager.addSnowGolemLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 40000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lSnowGolem§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// SnowGolem 2
			if(e.getInventory().getName().equals(snowgoleminv.SnowGolemInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// SnowGolem 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
							
						}
					}
					// SnowGolem 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
							
						}
					}
					// SnowGolem 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
							
						}
					}
					// BUY SnowGolem 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o55000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 55000){
								
								// ADD SnowGolem LVL
								try {
									DatabaseManager.addSnowGolemLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 55000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lSnowGolem§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// SnowGolem 3
			if(e.getInventory().getName().equals(snowgoleminv.SnowGolemInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// SnowGolem 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 1));
							
						}
					}
					// SnowGolem 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 2));
							
						}
					}
					// SnowGolem 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSnowGolem §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
							
						}
					}
					// BUY SnowGolem 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o60000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 60000){
								
								// ADD SnowGolem LVL
								try {
									DatabaseManager.addSnowGolemLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 60000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lSnowGolem§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(snowgoleminv.SnowGolemInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			
			
			
			
			
			
			// Librarian 1
			if(e.getInventory().getName().equals(librarianinv.LibrarianInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Librarian 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 1));
							
						}
					}
					// Librarian 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 2));
							
						}
					}
					// Librarian 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 3));
							
						}
					}
					// BUY Librarian 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o60000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 60000){
								
								if(!DatabaseManager.containsPath("name", "Kits-Librarian", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Librarian", "librarian", 0);
								}
								
								// ADD Librarian LVL
								try {
									DatabaseManager.addLibrarianLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 60000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lLibrarian§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(librarianinv.LibrarianInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Librarian 2
			if(e.getInventory().getName().equals(librarianinv.LibrarianInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Librarian 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 1));
							
						}
					}
					// Librarian 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 2));
							
						}
					}
					// Librarian 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 3));
							
						}
					}
					// BUY Librarian 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o70000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 70000){
								
								// ADD Librarian LVL
								try {
									DatabaseManager.addLibrarianLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 70000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lLibrarian§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(librarianinv.LibrarianInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Librarian 3
			if(e.getInventory().getName().equals(librarianinv.LibrarianInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Librarian 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 1));
							
						}
					}
					// Librarian 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 2));
							
						}
					}
					// Librarian 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLibrarian §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(librarianinv.LibrarianInventory(p, 3));
							
						}
					}
					// BUY Librarian 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o80000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 80000){
								
								// ADD Librarian LVL
								try {
									DatabaseManager.addLibrarianLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 80000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lLibrarian§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(librarianinv.LibrarianInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Spider 1
			if(e.getInventory().getName().equals(spiderinv.SpiderInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Spider 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 1));
							
						}
					}
					// Spider 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 2));
							
						}
					}
					// Spider 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 3));
							
						}
					}
					// BUY Spider 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o67500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 67500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Spider", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Spider", "spider", 0);
								}
								
								// ADD Spider LVL
								try {
									DatabaseManager.addSpiderLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 67500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lSpider§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(spiderinv.SpiderInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Spider 2
			if(e.getInventory().getName().equals(spiderinv.SpiderInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Spider 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 1));
							
						}
					}
					// Spider 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 2));
							
						}
					}
					// Spider 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 3));
							
						}
					}
					// BUY Spider 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o75000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 75000){
								
								// ADD Spider LVL
								try {
									DatabaseManager.addSpiderLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 75000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lSpider§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(spiderinv.SpiderInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Spider 3
			if(e.getInventory().getName().equals(spiderinv.SpiderInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Spider 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 1));
							
						}
					}
					// Spider 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 2));
							
						}
					}
					// Spider 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lSpider §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(spiderinv.SpiderInventory(p, 3));
							
						}
					}
					// BUY Spider 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o85000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 85000){
								
								// ADD Spider LVL
								try {
									DatabaseManager.addSpiderLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 85000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lSpider§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(spiderinv.SpiderInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Villager 1
			if(e.getInventory().getName().equals(villagerinv.VillagerInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Villager 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 1));
							
						}
					}
					// Villager 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 2));
							
						}
					}
					// Villager 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 3));
							
						}
					}
					// BUY Villager 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o72500 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 72500){
								
								if(!DatabaseManager.containsPath("name", "Kits-Villager", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Villager", "villager", 0);
								}
								
								// ADD Villager LVL
								try {
									DatabaseManager.addVillagerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 72500);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lVillager§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(villagerinv.VillagerInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Villager 2
			if(e.getInventory().getName().equals(villagerinv.VillagerInventory(p, 2).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Villager 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 1));
							
						}
					}
					// Villager 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 2));
							
						}
					}
					// Villager 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 3));
							
						}
					}
					// BUY Villager 2
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o85000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 85000){
								
								// ADD Villager LVL
								try {
									DatabaseManager.addVillagerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 85000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lVillager§7' kit! §7§o(§a§oLvL 2§7§o)");
								p.openInventory(villagerinv.VillagerInventory(p, 2));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Villager 3
			if(e.getInventory().getName().equals(villagerinv.VillagerInventory(p, 3).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Villager 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 1));
							
						}
					}
					// Villager 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 2));
							
						}
					}
					// Villager 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVillager §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(villagerinv.VillagerInventory(p, 3));
							
						}
					}
					// BUY Villager 3
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §6§o100000 Coins")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.money.get(p.getName()) >= 100000){
								
								// ADD Villager LVL
								try {
									DatabaseManager.addVillagerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeMoney(p, 100000);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have upgraded the '§b§lVillager§7' kit! §7§o(§a§oLvL 3§7§o)");
								p.openInventory(villagerinv.VillagerInventory(p, 3));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §6Coins§7!");
							}
						}
					}
				}
			}
			// Assassin 1
			if(e.getInventory().getName().equals(assassininv.AssassinInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Assassin 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lAssassin §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(assassininv.AssassinInventory(p, 1));
							
						}
					}
					// Assassin 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lAssassin §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(assassininv.AssassinInventory(p, 2));
							
						}
					}
					// Assassin 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lAssassin §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(assassininv.AssassinInventory(p, 3));
							
						}
					}
					// BUY Assassin 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Assassin", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Assassin", "assassin", 0);
								}
								
								// ADD Assassin LVL
								try {
									DatabaseManager.addAssassinLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lAssassin§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(assassininv.AssassinInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// Lord 1
			if(e.getInventory().getName().equals(lordinv.LordInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Lord 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLord §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(lordinv.LordInventory(p, 1));
							
						}
					}
					// Lord 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLord §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(lordinv.LordInventory(p, 2));
							
						}
					}
					// Lord 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lLord §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(lordinv.LordInventory(p, 3));
							
						}
					}
					// BUY Lord 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Lord", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Lord", "lord", 0);
								}
								
								// ADD Lord LVL
								try {
									DatabaseManager.addLordLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lLord§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(lordinv.LordInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// Vampire 1
			if(e.getInventory().getName().equals(vampireinv.VampireInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Vampire 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVampire §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(vampireinv.VampireInventory(p, 1));
							
						}
					}
					// Vampire 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVampire §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(vampireinv.VampireInventory(p, 2));
							
						}
					}
					// Vampire 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lVampire §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(vampireinv.VampireInventory(p, 3));
							
						}
					}
					// BUY Vampire 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Vampire", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Vampire", "vampire", 0);
								}
								
								// ADD Vampire LVL
								try {
									DatabaseManager.addVampireLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lVampire§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(vampireinv.VampireInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// DarkMage 1
			if(e.getInventory().getName().equals(darkmageinv.DarkMageInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// DarkMage 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDarkMage §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(darkmageinv.DarkMageInventory(p, 1));
							
						}
					}
					// DarkMage 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDarkMage §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(darkmageinv.DarkMageInventory(p, 2));
							
						}
					}
					// DarkMage 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lDarkMage §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(darkmageinv.DarkMageInventory(p, 3));
							
						}
					}
					// BUY DarkMage 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-DarkMage", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-DarkMage", "darkmage", 0);
								}
								
								// ADD DarkMage LVL
								try {
									DatabaseManager.addDarkMageLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lDarkMage§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(darkmageinv.DarkMageInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// Beast 1
			if(e.getInventory().getName().equals(beastinv.BeastInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Beast 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBeast §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(beastinv.BeastInventory(p, 1));
							
						}
					}
					// Beast 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBeast §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(beastinv.BeastInventory(p, 2));
							
						}
					}
					// Beast 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lBeast §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(beastinv.BeastInventory(p, 3));
							
						}
					}
					// BUY Beast 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Beast", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Beast", "beast", 0);
								}
								
								// ADD Beast LVL
								try {
									DatabaseManager.addBeastLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lBeast§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(beastinv.BeastInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// Fish 1
			if(e.getInventory().getName().equals(fishinv.FishInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Fish 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFish §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishinv.FishInventory(p, 1));
							
						}
					}
					// Fish 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFish §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishinv.FishInventory(p, 2));
							
						}
					}
					// Fish 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lFish §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(fishinv.FishInventory(p, 3));
							
						}
					}
					// BUY Fish 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Fish", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Fish", "fish", 0);
								}
								
								// ADD Fish LVL
								try {
									DatabaseManager.addFishLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lFish§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(fishinv.FishInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// Heavy 1
			if(e.getInventory().getName().equals(heavyinv.HeavyInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Heavy 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lHeavy §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(heavyinv.HeavyInventory(p, 1));
							
						}
					}
					// Heavy 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lHeavy §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(heavyinv.HeavyInventory(p, 2));
							
						}
					}
					// Heavy 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lHeavy §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(heavyinv.HeavyInventory(p, 3));
							
						}
					}
					// BUY Heavy 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Heavy", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Heavy", "Heavy", 0);
								}
								
								// ADD Heavy LVL
								try {
									DatabaseManager.addHeavyLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lHeavy§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(heavyinv.HeavyInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// GrimReaper 1
			if(e.getInventory().getName().equals(grimreaperinv.GrimReaperInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// GrimReaper 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lGrimReaper §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
							
						}
					}
					// GrimReaper 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lGrimReaper §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 2));
							
						}
					}
					// GrimReaper 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lGrimReaper §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(grimreaperinv.GrimReaperInventory(p, 3));
							
						}
					}
					// BUY GrimReaper 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-GrimReaper", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-GrimReaper", "grimreaper", 0);
								}
								
								// ADD GrimReaper LVL
								try {
									DatabaseManager.addGrimReaperLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lGrimReaper§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(grimreaperinv.GrimReaperInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
			// Miner 1
			if(e.getInventory().getName().equals(minerinv.MinerInventory(p, 1).getName())){
				
				e.setCancelled(true);
				
				InventoryAction a = e.getAction();
				ItemStack c = e.getCurrentItem();
				if(c != null){
					// BACK
					if(c.getType() == Material.REDSTONE_BLOCK && c.getItemMeta().getDisplayName().equals("§4§l§o<< Back")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(kitselector.getKitSelector(p));
							
						}
					}
					// Miner 1
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lMiner §7§o(§a§oLvL 1§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(minerinv.MinerInventory(p, 1));
							
						}
					}
					// Miner 2
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lMiner §7§o(§a§oLvL 2§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(minerinv.MinerInventory(p, 2));
							
						}
					}
					// Miner 3
					if(c.getType() == Material.NETHER_STAR && c.getItemMeta().getDisplayName().equals("§b§lMiner §7§o(§a§oLvL 3§7§o)")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							p.openInventory(minerinv.MinerInventory(p, 3));
							
						}
					}
					// BUY Miner 1
					if(c.getType() == Material.EMERALD_BLOCK && c.getItemMeta().getLore().contains("§7§oPrice: §e§o150 OMT")){
						
						// RIGHT CLICK / LEFT CLICK
						if(a == InventoryAction.PICKUP_HALF || a == InventoryAction.PICKUP_ALL){
							
							if(StorageManager.omt.get(p.getName()) >= 150){
								
								if(!DatabaseManager.containsPath("name", "Kits-Miner", p.getName())){
									DatabaseManager.insertInt(p.getName(), "Kits-Miner", "miner", 0);
								}
								
								// ADD Miner LVL
								try {
									DatabaseManager.addMinerLvL(p, 1);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								// REMOVE MONEY
								try {
									DatabaseManager.removeOMT(p, 150);
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								
								p.sendMessage(Start.TAG + "You have bought the '§b§lMiner§7' kit! §7§o(§a§oLvL 1§7§o)");
								p.openInventory(minerinv.MinerInventory(p, 1));
								
							}
							else{
								p.sendMessage(Start.TAG + "You don't have enough §eOrbitMines Tokens§7!");
							}
						}
					}
				}
			}
		}
	}
}
