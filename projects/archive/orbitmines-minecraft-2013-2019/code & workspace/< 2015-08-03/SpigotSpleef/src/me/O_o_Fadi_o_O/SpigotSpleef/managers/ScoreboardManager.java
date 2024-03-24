package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

	Start start = Start.getInstance();
	
	public static void loadScoreboards(){
		
		String waitingtitle = "";
		List<String> waitingscores = new ArrayList<String>();
		List<String> waitingrows = new ArrayList<String>();
		
		waitingtitle = ConfigManager.config.getString("Settings.Scoreboards.Waiting.Title");
		for(String s : ConfigManager.config.getStringList("Settings.Scoreboards.Waiting.Rows")){
			int startscore = s.indexOf("<score>") +7;
			int endscore = s.indexOf("</score>");
			waitingscores.add(s.substring(startscore, endscore));
			
			int startrow = s.indexOf("<row>") + 5;
			int endrow = s.indexOf("</row>");
			waitingrows.add(s.substring(startrow, endrow));
		}
		StorageManager.scoreboardwaitingrows = waitingrows;
		StorageManager.scoreboardwaitingscores = waitingscores;
		StorageManager.scoreboardwaitingtitle = waitingtitle;
		
		String enoughplayerstitle = "";
		List<String> enoughplayersscores = new ArrayList<String>();
		List<String> enoughplayersrows = new ArrayList<String>();
		
		enoughplayerstitle = ConfigManager.config.getString("Settings.Scoreboards.EnoughPlayers.Title");
		for(String s : ConfigManager.config.getStringList("Settings.Scoreboards.EnoughPlayers.Rows")){
			int startscore = s.indexOf("<score>") +7;
			int endscore = s.indexOf("</score>");
			enoughplayersscores.add(s.substring(startscore, endscore));
			
			int startrow = s.indexOf("<row>") + 5;
			int endrow = s.indexOf("</row>");
			enoughplayersrows.add(s.substring(startrow, endrow));
		}
		StorageManager.scoreboardenoughplayersrows = enoughplayersrows;
		StorageManager.scoreboardenoughplayersscores = enoughplayersscores;
		StorageManager.scoreboardenoughplayerstitle = enoughplayerstitle;
		
		String ingametitle = "";
		List<String> ingamescores = new ArrayList<String>();
		List<String> ingamerows = new ArrayList<String>();
		
		ingametitle = ConfigManager.config.getString("Settings.Scoreboards.InGame.Title");
		for(String s : ConfigManager.config.getStringList("Settings.Scoreboards.InGame.Rows")){
			int startscore = s.indexOf("<score>") +7;
			int endscore = s.indexOf("</score>");
			ingamescores.add(s.substring(startscore, endscore));
			
			int startrow = s.indexOf("<row>") + 5;
			int endrow = s.indexOf("</row>");
			ingamerows.add(s.substring(startrow, endrow));
		}
		StorageManager.scoreboardingamerows = ingamerows;
		StorageManager.scoreboardingamescores = ingamescores;
		StorageManager.scoreboardingametitle = ingametitle;
	}
	
	public static Scoreboard updateScoreboard(SpleefPlayer sp){
		Scoreboard b = sp.getScoreboard();
		Objective o = b.getObjective(DisplaySlot.SIDEBAR);
		
		int newscoreboardid = sp.getScoreboardID();
		
		Arena arena = sp.getArena();
		if(arena.isStatus(SpleefStatus.WAITING) || arena.isStatus(SpleefStatus.STARTING)){
			List<String> rows = new ArrayList<String>();
			List<String> scores = new ArrayList<String>();
			
			if(arena.enoughPlayers()){
				rows = StorageManager.scoreboardenoughplayersrows;
				scores = StorageManager.scoreboardenoughplayersscores;
				newscoreboardid = 2;
			}
			else{
				rows = StorageManager.scoreboardwaitingrows;
				scores = StorageManager.scoreboardwaitingscores;
				newscoreboardid = 1;
			}
			
			if(sp.getScoreboardID() != newscoreboardid){
				sp.setScoreboardID(newscoreboardid);
				return getNewScoreboard(sp);
			}
			
			int index = 0;
			for(String row : rows){
				String scorestring = getReplacedScore(sp, scores.get(index));
				try{
					int score = Integer.parseInt(scorestring);
					String newrow = getReplacedRow(sp, row.replace("&", "§"));

					if(!(newrow.length() > 32)){
						updateRow(b, o, sp, index, newrow, score);
					}else{
						Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Row '" + newrow + "' is longer than 32 characters!");
					}
				}catch(NumberFormatException ex){
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Score '" + scorestring + "' is not a number!");
				}
				index++;
			}
		
			if(arena.enoughPlayers()){
				String title = getReplacedRow(sp, StorageManager.scoreboardenoughplayerstitle.replace("&", "§"));
				if(!(title.length() > 32)){
					o.setDisplayName(title);
				}
				else{
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Title '" + title + "' is longer than 32 characters!");
				}
			}
			else{
				String title = getReplacedRow(sp, StorageManager.scoreboardwaitingtitle.replace("&", "§"));
				if(!(title.length() > 32)){
					o.setDisplayName(title);
				}
				else{
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Title '" + title + "' is longer than 32 characters!");
				}
			}
		}
		else if(arena.isStatus(SpleefStatus.WARMUP) || arena.isStatus(SpleefStatus.INGAME) || arena.isStatus(SpleefStatus.ENDING)){
			List<String> rows = StorageManager.scoreboardingamerows;
			List<String> scores = StorageManager.scoreboardingamescores;
			
			newscoreboardid = 3;
			
			if(sp.getScoreboardID() != newscoreboardid){
				sp.setScoreboardID(newscoreboardid);
				return getNewScoreboard(sp);
			}
			
			int index = 0;
			for(String row : rows){
				String scorestring = getReplacedScore(sp, scores.get(index));
				try{
					int score = Integer.parseInt(scorestring);
					String newrow = getReplacedRow(sp, row.replace("&", "§"));

					if(!(newrow.length() > 32)){
						updateRow(b, o, sp, index, newrow, score);
					}else{
						Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Row '" + newrow + "' is longer than 32 characters!");
					}
				}catch(NumberFormatException ex){
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Score '" + scorestring + "' is not a number!");
				}
				index++;
			}
			
			String title = getReplacedRow(sp, StorageManager.scoreboardingametitle.replace("&", "§"));
			if(!(title.length() > 32)){
				o.setDisplayName(title);
			}
			else{
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Title '" + title + "' is longer than 32 characters!");
			}
		}
		else{}
		
		if(b.getTeam("Spleef-Specs") != null){
			b.getTeam("Spleef-Specs").unregister();
		}
		
		Team spectators = b.registerNewTeam("Spleef-Specs");
		for(SpleefPlayer sps : sp.getArena().getSpectators()){
			spectators.addPlayer(sps.getPlayer());
		}
		spectators.setCanSeeFriendlyInvisibles(true);
		
		return b;
	}
	
	public static Scoreboard getNewScoreboard(SpleefPlayer sp){
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard b = sm.getNewScoreboard();
		Objective o = b.registerNewObjective(sp.getPlayer().getName(), sp.getPlayer().getName() + "2");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
	
		Arena arena = sp.getArena();
		if(arena.isStatus(SpleefStatus.WAITING) || arena.isStatus(SpleefStatus.STARTING)){
			List<String> rows = new ArrayList<String>();
			List<String> scores = new ArrayList<String>();
			
			if(arena.enoughPlayers()){
				rows = StorageManager.scoreboardenoughplayersrows;
				scores = StorageManager.scoreboardenoughplayersscores;

				sp.setScoreboardID(2);
			}
			else{
				rows = StorageManager.scoreboardwaitingrows;
				scores = StorageManager.scoreboardwaitingscores;
				sp.setScoreboardID(1);
			}
			
			int index = 0;
			for(String row : rows){
				String scorestring = getReplacedScore(sp, scores.get(index));
				try{
					int score = Integer.parseInt(scorestring);
					String newrow = getReplacedRow(sp, row.replace("&", "§"));

					if(!(newrow.length() > 32)){
						addRow(b, o, sp, index, newrow, score);
					}else{
						Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Row '" + newrow + "' is longer than 32 characters!");
					}
				}catch(NumberFormatException ex){
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Score '" + scorestring + "' is not a number!");
				}
				index++;
			}
			

			if(arena.enoughPlayers()){
				String title = getReplacedRow(sp, StorageManager.scoreboardenoughplayerstitle.replace("&", "§"));
				if(!(title.length() > 32)){
					o.setDisplayName(title);
				}
				else{
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Title '" + title + "' is longer than 32 characters!");
				}
			}
			else{
				String title = getReplacedRow(sp, StorageManager.scoreboardwaitingtitle.replace("&", "§"));
				if(!(title.length() > 32)){
					o.setDisplayName(title);
				}
				else{
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Title '" + title + "' is longer than 32 characters!");
				}
			}
		}
		else if(arena.isStatus(SpleefStatus.WARMUP) || arena.isStatus(SpleefStatus.INGAME) || arena.isStatus(SpleefStatus.ENDING)){
			List<String> rows = StorageManager.scoreboardingamerows;
			List<String> scores = StorageManager.scoreboardingamescores;
			
			sp.setScoreboardID(3);
			
			int index = 0;
			for(String row : rows){
				String scorestring = getReplacedScore(sp, scores.get(index));
				try{
					int score = Integer.parseInt(scorestring);
					String newrow = getReplacedRow(sp, row.replace("&", "§"));

					if(!(newrow.length() > 32)){
						addRow(b, o, sp, index, newrow, score);
					}else{
						Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Row '" + newrow + "' is longer than 32 characters!");
					}
				}catch(NumberFormatException ex){
					Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Score '" + scorestring + "' is not a number!");
				}
				index++;
			}
			
			String title = getReplacedRow(sp, StorageManager.scoreboardingametitle.replace("&", "§"));
			if(!(title.length() > 32)){
				o.setDisplayName(title);
			}
			else{
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error! Title '" + title + "' is longer than 32 characters!");
			}
		}
		else{}
		
		if(b.getTeam("Spleef-Specs") != null){
			b.getTeam("Spleef-Specs").unregister();
		}
		
		Team spectators = b.registerNewTeam("Spleef-Specs");
		for(SpleefPlayer sps : sp.getArena().getSpectators()){
			spectators.addPlayer(sps.getPlayer());
			((CraftPlayer) sps.getPlayer()).getHandle().setInvisible(true);
		}
		spectators.setCanSeeFriendlyInvisibles(true);
		
		return b;
	}
	
	private static String getReplacedScore(SpleefPlayer sp, String score){
		Arena arena = sp.getArena();
		return score.replace("%minutes%", "" + arena.getMinutes()).replace("%seconds%", "" + arena.getSeconds()).replace("%min-players%", "" + arena.getMinPlayers()).replace("%players%", "" + arena.getPlayers().size()).replace("%max-players%", "" + arena.getMaxPlayers()).replace("%tokens%", "" + sp.getTokens()).replace("%arena-id%", "" + arena.getArenaID()).replace("%spectators%", "" + arena.getSpectators().size());
	}
	private static String getReplacedRow(SpleefPlayer sp, String row){
		Arena arena = sp.getArena();
		row = row.replace("%minutes%", "" + arena.getMinutes()).replace("%seconds%", "" + arena.getSeconds()).replace("%min-players%", "" + arena.getMinPlayers()).replace("%players%", "" + arena.getPlayers().size()).replace("%max-players%", "" + arena.getMaxPlayers()).replace("%tokens%", "" + sp.getTokens()).replace("%arena-id%", "" + arena.getArenaID()).replace("%spectators%", "" + arena.getSpectators().size()).replace("%map-name%", arena.getMap().getName()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
		
		if(sp.getKit() == null){
			return row.replace("%kit-name%", "None");
		}
		return row.replace("%kit-name%", sp.getKit().getName());
	}
	
	@SuppressWarnings("deprecation")
	private static void updateRow(Scoreboard b, Objective o, SpleefPlayer sp, int index, String row, int score){
		String row1 = "";
		String row2 = "";
		
		boolean blank = true;
		if(row.equals("")){
			blank = true;
		}
		if(row.length() != 0){
			for(int i = 0; i < row.length(); i++){
				if(!Character.isSpace(row.charAt(i))){
					blank = false;
				}
			}
		}
		
		if(row.length() > 16){
			row1 = row.substring(0, 16);
			row2 = row.substring(16);
		}
		else{
			row1 = row;
		}
		
		if(b.getTeam("Spleef-" + index) != null){
			b.getTeam("Spleef-" + index).unregister();
		}
		
		if(blank == false){
			OfflinePlayer prevop = null;
			try{
				prevop = Bukkit.getOfflinePlayer(sp.getRow(index));
				if(prevop != null){
					b.resetScores(prevop);
				}
			}catch(IllegalArgumentException ex){}
			
			Team t = b.registerNewTeam("Spleef-" + index);
			t.setSuffix(row2);
			OfflinePlayer op = Bukkit.getServer().getOfflinePlayer(row1);
			
			if(prevop != null){
				sp.setRow(index, op.getName());
			}
			else{
				sp.addRow(op.getName());
			}
			t.addPlayer(op);
			
			Score s = o.getScore(op.getName());
			s.setScore(1);
			s.setScore(score);
		}
		else{
			Score s = o.getScore(row);
			s.setScore(1);
			s.setScore(score);
			if(sp.getRow(index) != null){
				sp.setRow(index, row);
			}
			else{
				sp.addRow(row);
			}
		}
	}
	@SuppressWarnings("deprecation")
	private static void addRow(Scoreboard b, Objective o, SpleefPlayer sp, int index, String row, int score){
		String row1 = "";
		String row2 = "";
		
		boolean blank = true;
		if(row.equals("")){
			blank = true;
		}
		if(row.length() != 0){
			for(int i = 0; i < row.length(); i++){
				if(!Character.isSpace(row.charAt(i))){
					blank = false;
				}
			}
		}
		
		if(row.length() > 16){
			row1 = row.substring(0, 16);
			row2 = row.substring(16);
		}
		else{
			row1 = row;
		}
		
		if(blank == false){
			Team t = b.registerNewTeam("Spleef-" + index);
			t.setSuffix(row2);
			OfflinePlayer op = Bukkit.getServer().getOfflinePlayer(row1);
			t.addPlayer(op);
			sp.addRow(op.getName());
		
			Score s = o.getScore(op.getName());
			s.setScore(1);
			s.setScore(score);
		}
		else{
			Score s = o.getScore(row);
			s.setScore(1);
			s.setScore(score);
			sp.addRow(row);
		}
	}
}
