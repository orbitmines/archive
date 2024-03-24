package me.O_o_Fadi_o_O.BungeeMSG.managers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class AdvertiseManager {
	
	@SuppressWarnings("deprecation")
	public static boolean canChat(ProxiedPlayer p, String message){
		boolean canchat = true;
		
		if(StorageManager.useantiadvertise == true){
	    	if(StorageManager.cancelips == true && canchat){
				if(!p.hasPermission("BungeeMSG.bypass.ips") && !p.hasPermission("BungeeMSG.bypass.*")){
		    		String tocheck = message.replace("dot", " ").replace(".", " ");
		    		StringBuilder sb = new StringBuilder();
		    		for(int i = 0; i < tocheck.length(); i++){
			    		if(Character.isDigit(tocheck.charAt(i)) || Character.isSpace(tocheck.charAt(i)) && !sb.toString().endsWith(" ") && !sb.toString().equals("")){
			    			sb.append(tocheck.charAt(i));
			    		}
		    		}
		    		if(!StorageManager.whitelistedips.contains(sb.toString().replace(" ", "."))){
			    		Matcher m = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])[\\. ]" + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])[\\. ]" + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])[\\. ]" + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(sb.toString());
			    		if(m.find() == true){
			    			if(StorageManager.kick == true){
			    				p.disconnect(StorageManager.advertisekickmessage.replace("&", "§").replace("%type%", StorageManager.typevariableips.replace("&", "§")));
			    				
			    				if(StorageManager.uselog == true && StorageManager.readadvertising == true){
			    					LogManager.getLog().info("[ADVERTISING] " + p.getName() + " tried to send the IP '" + sb.toString() + "'. (Kick)");
			    				}
			    			}
			    			else{
			    				Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.advertisemessage.replace("&", "§").replace("%type%", StorageManager.typevariableips.replace("&", "§"))));
			    				
			    				if(StorageManager.uselog == true && StorageManager.readadvertising == true){
			    					LogManager.getLog().info("[ADVERTISING] " + p.getName() + " tried to send the IP '" + sb.toString() + "'. (Sent Message)");
			    				}
			    			}
			    			return false;
			    		}
		    		}
				}
	    	}
	    	if(StorageManager.canceldomainnames == true && canchat){
				if(!p.hasPermission("BungeeMSG.bypass.domainnames") && !p.hasPermission("BungeeMSG.bypass.*")){
					String lowercasemsg = message.toLowerCase();

					lowercasemsg.replace(" dot ", ".");
					lowercasemsg.replace(" dot", ".");
					lowercasemsg.replace("dot ", ".");
					lowercasemsg.replace("dot", ".");
					
					for(String domainname : StorageManager.whitelisteddomainnames){
						lowercasemsg = lowercasemsg.replace("http://" + domainname, "").replace("https://" + domainname, "").replace("http://www." + domainname, "").replace("https://www." + domainname, "").replace("www." + domainname, "").replace(domainname, "");
					}
					
		    		if(lowercasemsg.contains("www.") || lowercasemsg.contains(".net") || lowercasemsg.contains(".com") || lowercasemsg.contains(".co.uk") || lowercasemsg.contains("http://") || lowercasemsg.contains("https://") || lowercasemsg.contains(".de") || lowercasemsg.contains(".nl") || lowercasemsg.contains(".be") || lowercasemsg.contains(".fr") || lowercasemsg.contains(".org") || lowercasemsg.contains(".us")){
		    			if(StorageManager.kick == true){
		    				p.disconnect(StorageManager.advertisekickmessage.replace("&", "§").replace("%type%", StorageManager.typevariabledomainnames.replace("&", "§")));
	
		    				if(StorageManager.uselog == true && StorageManager.readadvertising == true){
		    					LogManager.getLog().info("[ADVERTISING] " + p.getName() + " tried to send a Website. (Message: " + message + ")");
		    				}
		    			}
		    			else{
		    				Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.advertisemessage.replace("&", "§").replace("%type%", StorageManager.typevariabledomainnames.replace("&", "§"))));
	
		    				if(StorageManager.uselog == true && StorageManager.readadvertising == true){
		    					LogManager.getLog().info("[ADVERTISING] " + p.getName() + " tried to send a Website. (Message: " + message + ")");
		    				}
		    			}
		    			return false;
		    		}
				}
	    	}
	    }
		
		return canchat;
	}
}
