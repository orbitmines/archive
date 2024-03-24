package me.O_o_Fadi_o_O.Prison;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.Prison.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Prison.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.Prison.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Prison.NMS.CustomVillager;
import me.O_o_Fadi_o_O.Prison.NMS.CustomZombie;
import me.O_o_Fadi_o_O.Prison.NMS.PetChicken;
import me.O_o_Fadi_o_O.Prison.NMS.PetCow;
import me.O_o_Fadi_o_O.Prison.NMS.PetCreeper;
import me.O_o_Fadi_o_O.Prison.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.Prison.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.Prison.NMS.PetOcelot;
import me.O_o_Fadi_o_O.Prison.NMS.PetPig;
import me.O_o_Fadi_o_O.Prison.NMS.PetSheep;
import me.O_o_Fadi_o_O.Prison.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.Prison.NMS.PetSlime;
import me.O_o_Fadi_o_O.Prison.NMS.PetSpider;
import me.O_o_Fadi_o_O.Prison.NMS.PetSquid;
import me.O_o_Fadi_o_O.Prison.NMS.PetWolf;
import me.O_o_Fadi_o_O.Prison.events.BreakEvent;
import me.O_o_Fadi_o_O.Prison.events.ChunkUnload;
import me.O_o_Fadi_o_O.Prison.events.ClickEvent;
import me.O_o_Fadi_o_O.Prison.events.ClickEvent2;
import me.O_o_Fadi_o_O.Prison.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Prison.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.Prison.events.EntityDamage;
import me.O_o_Fadi_o_O.Prison.events.EntityDeath;
import me.O_o_Fadi_o_O.Prison.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Prison.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.Prison.events.InteractEvent;
import me.O_o_Fadi_o_O.Prison.events.JoinEvent;
import me.O_o_Fadi_o_O.Prison.events.PlaceEvent;
import me.O_o_Fadi_o_O.Prison.events.PlayerChat;
import me.O_o_Fadi_o_O.Prison.events.PlayerMove;
import me.O_o_Fadi_o_O.Prison.events.QuitEvent;
import me.O_o_Fadi_o_O.Prison.events.SignsEvent;
import me.O_o_Fadi_o_O.Prison.events.VoteEvent;
import me.O_o_Fadi_o_O.Prison.managers.BungeeManager;
import me.O_o_Fadi_o_O.Prison.managers.ConfigManager;
import me.O_o_Fadi_o_O.Prison.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Prison.managers.EmptyWorldGenerator;
import me.O_o_Fadi_o_O.Prison.managers.NPCManager;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.managers.VoteManager;
import me.O_o_Fadi_o_O.Prison.runnables.ChestRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.GambleRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.MineRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.PetRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.RankLettersRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.SignRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.WoodmenRunnable;
import me.O_o_Fadi_o_O.Prison.utils.ChatColor;
import me.O_o_Fadi_o_O.Prison.utils.Disguise;
import me.O_o_Fadi_o_O.Prison.utils.Server;
import me.O_o_Fadi_o_O.Prison.utils.StaffRank;
import me.O_o_Fadi_o_O.Prison.utils.Trail;
import me.O_o_Fadi_o_O.Prison.utils.TrailType;
import me.O_o_Fadi_o_O.Prison.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends JavaPlugin {
	
	public static String TAG = "§4§lPrison §8| §7";
	@SuppressWarnings("deprecation")
	public void onEnable(){
		
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersgambling.containsKey(p)){
						int Seconds = StorageManager.playergamblingseconds.get(p);
						StorageManager.playergamblingseconds.put(p, Seconds +1);
					}
				}
			}
		}.runTaskTimer(this, 0, 20);
		

	}
}
