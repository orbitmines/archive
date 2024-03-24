package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.DisguisePlayer;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.BabyChicken;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.ChickenMama;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.ChickenWarrior;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.HotWing;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.LobbyKit;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ChickenFight {
	
	@SuppressWarnings("deprecation")
	public static void startGame(int arena){
					
					if(StorageManager.chickenfightkit.get(p).equals("None") || StorageManager.chickenfightkit.get(p).equals("Chicken Mama")){
						StorageManager.chickenfightkit.put(p, "Chicken Mama");
						ChickenMama.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, false, true, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					if(StorageManager.chickenfightkit.get(p).equals("Baby Chicken")){
						BabyChicken.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, false, false, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					if(StorageManager.chickenfightkit.get(p).equals("Hot Wing")){
						HotWing.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, true, true, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					if(StorageManager.chickenfightkit.get(p).equals("Chicken Warrior")){
						ChickenWarrior.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.IRON_GOLEM, false, true, true, p.getName(), Bukkit.getOnlinePlayers());
					}
	}
}
