package me.O_o_Fadi_o_O.BungeeMSG.managers;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class SpamManager {

	public static boolean canMessage(ProxiedPlayer p, String message, boolean pm){
		boolean canchat = true;
		
		if(StorageManager.useantispam == true){
			if(StorageManager.usecooldown == true){
				if(!p.hasPermission("BungeeMSG.bypass.cooldown") && !p.hasPermission("BungeeMSG.bypass.*")){
					long lastchat = 0;
					
					if(pm == true){
						if(StorageManager.lastspamcheckpm.containsKey(p.getName())){
							lastchat = StorageManager.lastspamcheckpm.get(p.getName());
						}
						int lastchatmillis = StorageManager.messagecooldownpm * 1000;
								
						if(System.currentTimeMillis()-lastchat >= lastchatmillis){
							StorageManager.lastspamcheckpm.put(p.getName(), System.currentTimeMillis());
						}
						else{
							canchat = false;
							int timeleft = (int) (StorageManager.messagecooldownpm - ((System.currentTimeMillis() - lastchat) / 1000));
							if(timeleft == 1){
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamcooldown.replaceAll("&", "§").replaceAll("%left%", "" + timeleft).replaceAll("%second-grammer%", StorageManager.secondgrammervariableone.replaceAll("&", "§"))));
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamcooldown.replaceAll("&", "§").replaceAll("%left%", "" + timeleft).replaceAll("%second-grammer%", StorageManager.secondgrammervariablemultiple.replaceAll("&", "§"))));
							}
							
							if(StorageManager.readspam == true){
								LogManager.getLog().info("[SPAM] Muted '" + message + "' for " + p.getName() + ". (Cooldown)");
							}
						}
					}
					else{
						if(StorageManager.lastspamcheckglobal.containsKey(p.getName())){
							lastchat = StorageManager.lastspamcheckglobal.get(p.getName());
						}
						int lastchatmillis = StorageManager.messagecooldownglobal * 1000;
								
						if(System.currentTimeMillis()-lastchat >= lastchatmillis){
							StorageManager.lastspamcheckglobal.put(p.getName(), System.currentTimeMillis());
						}
						else{
							canchat = false;
							int timeleft = (int) (StorageManager.messagecooldownglobal - ((System.currentTimeMillis() - lastchat) / 1000));
							if(timeleft == 1){
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamcooldown.replaceAll("&", "§").replaceAll("%left%", "" + timeleft).replaceAll("%second-grammer%", StorageManager.secondgrammervariableone.replaceAll("&", "§"))));
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamcooldown.replaceAll("&", "§").replaceAll("%left%", "" + timeleft).replaceAll("%second-grammer%", StorageManager.secondgrammervariablemultiple.replaceAll("&", "§"))));
							}
							
							if(StorageManager.readspam == true){
								LogManager.getLog().info("[SPAM] Muted '" + message + "' for " + p.getName() + ". (Cooldown)");
							}
						}
					}
				}
			}
			
			if(StorageManager.cancelduplicate == true && canchat){
				if(!p.hasPermission("BungeeMSG.bypass.duplicate") && !p.hasPermission("BungeeMSG.bypass.*")){
					if(StorageManager.lastmessage.containsKey(p)){
						String lastmessage = StorageManager.lastmessage.get(p);
						
						if(lastmessage.length() > 2){
							String newstring = lastmessage.substring(0, lastmessage.length() - StorageManager.duplicatesensitivity);
							if(newstring.length() > 1){
								lastmessage = newstring;
							}
						}
						
						if(StorageManager.duplicatesensitivity != 0){
							if(message.toLowerCase().startsWith(lastmessage.toLowerCase())){
								canchat = false;
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamduplicate.replaceAll("&", "§")));
								
								if(StorageManager.readspam == true){
									LogManager.getLog().info("[SPAM] Muted '" + message + "' for " + p.getName() + ". (Duplicate)");
								}
							}
							else{
								StorageManager.lastmessage.put(p, message);
							}
						}
						else{
							if(message.toLowerCase().equals(lastmessage.toLowerCase())){
								canchat = false;
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamduplicate.replaceAll("&", "§")));
								
								if(StorageManager.readspam == true){
									LogManager.getLog().info("[SPAM] Muted '" + message + "' for " + p.getName() + ". (Duplicate)");
								}
							}
							else{
								StorageManager.lastmessage.put(p, message);
							}
						}
					}
					else{
						StorageManager.lastmessage.put(p, message);
					}
				}
			}
			
			if(StorageManager.canceltofastusage == true && canchat){
				if(!p.hasPermission("BungeeMSG.bypass.toofast") && !p.hasPermission("BungeeMSG.bypass.*")){
					if(StorageManager.tofaststartedcount.containsKey(p) && StorageManager.tofastamount.containsKey(p)){
						long lastchat = 0;
						if(StorageManager.tofaststartedcount.containsKey(p)){
							lastchat = StorageManager.tofaststartedcount.get(p);
						}
						int lastchatmillis = StorageManager.tofasttimecheck * 1000;
								
						if(System.currentTimeMillis()-lastchat >= lastchatmillis){
							StorageManager.tofaststartedcount.remove(p);
							StorageManager.tofastamount.remove(p);
						}
						else{
							if(StorageManager.tofastamount.get(p) >= StorageManager.tofastmaxusage){
								canchat = false;
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spamtofast.replaceAll("&", "§")));
	
								if(StorageManager.readspam == true){
									LogManager.getLog().info("[SPAM] Muted '" + message + "' for " + p.getName() + ". (ToFast)");
								}
							}
							else{
								StorageManager.tofastamount.put(p, StorageManager.tofastamount.get(p) +1);
							}
						}
					}
					else{
						StorageManager.tofaststartedcount.put(p, System.currentTimeMillis());
						StorageManager.tofastamount.put(p, 1);
					}
				}
			}
		}
		
		return canchat;
	}
	
	public static String checkForCaps(ProxiedPlayer p, String message){
		if(StorageManager.useantispam == true && StorageManager.cancelcaps == true){
			if(!p.hasPermission("BungeeMSG.bypass.caps") && !p.hasPermission("BungeeMSG.bypass.*")){
				int caps = 0;
				for(int i = 0; i < message.length(); i++){
					if(Character.isUpperCase(message.charAt(i))){
						caps++;
					}
				}
				
				if(caps > StorageManager.maxcapsinmessage){
					if(StorageManager.readspam == true){
						LogManager.getLog().info("[SPAM] Replaced all uppercases to lowercases in '" + message + "' for " + p.getName() + ". (Caps)");
					}
					message = message.toLowerCase();
				}
			}
		}
		
		return message;
	}
}
