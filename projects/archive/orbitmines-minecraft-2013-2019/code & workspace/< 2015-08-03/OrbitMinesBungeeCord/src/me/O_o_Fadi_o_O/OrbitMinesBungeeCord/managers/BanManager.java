package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.Utils;


public class BanManager {

	public static void reportPlayer(String PlayerReporter, String PlayerReporterBy, String Reason, String server){
		Calendar cOn = Calendar.getInstance();
        
        Date ReportedOnDate = new Date(cOn.getTimeInMillis()); 
        SimpleDateFormat sdOn = new SimpleDateFormat();
        sdOn.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String ReportedOn = sdOn.format(ReportedOnDate);
        
        DatabaseManager.insertReport(Utils.getUUID(PlayerReporter), PlayerReporterBy, Reason, ReportedOn, server);
	}
	
	public static void banPlayer(String BannedByPlayer, String BannedPlayer, String Reason, int years, int days, int hours, int minutes){
		Calendar cUntil = Calendar.getInstance();
		cUntil.add(Calendar.YEAR, years);
		cUntil.add(Calendar.MINUTE, minutes);
		cUntil.add(Calendar.HOUR_OF_DAY, hours);
		cUntil.add(Calendar.DATE, days);
        
        Date BannedUntilDate = new Date(cUntil.getTimeInMillis()); 
        SimpleDateFormat sdUntil = new SimpleDateFormat();
        sdUntil.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String BannedUntil = sdUntil.format(BannedUntilDate);
        
		Calendar cOn = Calendar.getInstance();
        
        Date BannedOnDate = new Date(cOn.getTimeInMillis()); 
        SimpleDateFormat sdOn = new SimpleDateFormat();
        sdOn.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String BannedOn = sdOn.format(BannedOnDate);
        
        UUID uuid = Utils.getUUID(BannedPlayer);
        
        DatabaseManager.insertBan(uuid, BannedByPlayer, Reason, BannedOn, BannedUntil);
        
        String uuidString = uuid.toString();
        
		Start.bannedplayers.add(uuidString);
		Start.bannedby.put(uuidString, BannedByPlayer);
		Start.bannedreason.put(uuidString, Reason);
		Start.bannedon.put(uuidString, BannedOn);
		Start.banneduntil.put(uuidString, BannedUntil);
	}
	
	public static void unbanPlayer(String BannedPlayer){
		UUID uuid = Utils.getUUID(BannedPlayer);
		
		if(Start.bannedplayers.contains(uuid)){
			Start.bannedplayers.remove(uuid);
		}
		
		DatabaseManager.unBan(uuid);
	}
	
	public static void banIP(String BannedByPlayer, String BannedIP, String Reason, int years, int days, int hours, int minutes){
		Calendar cUntil = Calendar.getInstance();
		cUntil.add(Calendar.YEAR, years);
		cUntil.add(Calendar.MINUTE, minutes);
		cUntil.add(Calendar.HOUR_OF_DAY, hours);
		cUntil.add(Calendar.DATE, days);
        
        Date BannedUntilDate = new Date(cUntil.getTimeInMillis()); 
        SimpleDateFormat sdUntil = new SimpleDateFormat();
        sdUntil.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String BannedUntil = sdUntil.format(BannedUntilDate);
        
		Calendar cOn = Calendar.getInstance();
        
        Date BannedOnDate = new Date(cOn.getTimeInMillis()); 
        SimpleDateFormat sdOn = new SimpleDateFormat();
        sdOn.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        String BannedOn = sdOn.format(BannedOnDate);
        
        DatabaseManager.insertIPBan(BannedIP, BannedByPlayer, Reason, BannedOn, BannedUntil);
        
		Start.bannedips.add(BannedIP);
		Start.bannedby.put(BannedIP, BannedByPlayer);
		Start.bannedreason.put(BannedIP, Reason);
		Start.bannedon.put(BannedIP, BannedOn);
		Start.banneduntil.put(BannedIP, BannedUntil);
	}
	
	public static void unbanIP(String BannedIP){
	
		if(Start.bannedips.contains(BannedIP)){
			Start.bannedips.remove(BannedIP);
		}
		
		DatabaseManager.unBanIP(BannedIP);
	}
}
