package me.O_o_Fadi_o_O.BungeeMSG.managers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BannedWordsManager {

	public static String checkForBannedWords(ProxiedPlayer p, String message){
		message = message.replace("%Title%{", "%Title% {").replace("%ActionBar%{", "%ActionBar% {");
		
		if(!p.hasPermission("BungeeMSG.bypass.bannedwords") && !p.hasPermission("BungeeMSG.bypass.*")){
			for(String word : message.split(" ")){
				String messagenow = message;
				
				StringBuilder replacement = new StringBuilder();
			    for(int i = 1; i <= word.length(); i++) {
			    	replacement.append("*");
			    }
			    
			    int index = 0;
			    for(String bannedword : StorageManager.bannedwords){
					
			    	StringBuilder sb = new StringBuilder();
					for(int i = 0; i < bannedword.length(); i++){
						if(i != 0){
							sb.append("+");
						}
						sb.append(bannedword.charAt(i));
					}
					
					String sbstring = sb.toString();
	
					sbstring = sbstring.replace("*", "");
					
					Matcher m = Pattern.compile("\\b(?i)" + sbstring.replaceAll("\\$", "[s\\$]").replaceAll("(?i)s", "[s\\$]").replace("a", "[a*]").replace("e", "[e*]").replace("o", "[o*]").replace("u", "[u*]").replace("c+k", "c*k") + "+" + "\\b").matcher(message);
	
					if(StorageManager.replacements.get(index).equals("")){
						message = m.replaceAll(replacement.toString());
					}
					else{
						message = m.replaceAll(StorageManager.replacements.get(index));
					}
					
					index++;
			    }
			    
			    if(!messagenow.equals(message)){
					if(StorageManager.uselog == true && StorageManager.readbannedwords == true){
						LogManager.getLog().info("[BANNED WORDS] " + p.getName() + " tried to use a banned word: '" + word + "'");
					}
			    }
			}
		}
		
		return message;
	}
}
