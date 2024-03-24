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
