package me.O_o_Fadi_o_O.BungeeMSG.managers;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class TitleManager {

	@SuppressWarnings("deprecation")
	public static String importTitle(ProxiedPlayer p, String s){
		boolean b = false;
		
		if(s.contains("%ActionBar%{") && s.endsWith("}")){
			try{
				String actionbarstring = s.substring(s.indexOf("%ActionBar%{")).substring(12);
				actionbarstring = actionbarstring.substring(0, actionbarstring.length() -1);
				sendActionBar(p, actionbarstring);
			}catch(Exception ex){
				ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] Invalid ActionBar Usage! (" + s + ") Error:");
				ex.printStackTrace();
			}
			s = s.substring(0, s.indexOf("%ActionBar%{"));
			b = true;
		}
		
		if(b == false){
			if(s.contains("%Title%{") && s.endsWith("}")){
				try{
					String titlestring = s.substring(s.indexOf("%Title%{")).substring(8);
					titlestring = titlestring.substring(0, titlestring.length() -1);
					String[] strings = titlestring.split("\\|");
					sendTitle(p, strings[0], strings[strings.length -4], Integer.parseInt(strings[strings.length -3]), Integer.parseInt(strings[strings.length -2]), Integer.parseInt(strings[strings.length -1]));
				}catch(Exception ex){
					ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] Invalid Title Usage! (" + s + ") Error:");
					ex.printStackTrace();
				}
				s = s.substring(0, s.indexOf("%Title%{"));
			}
		}
		
		if(s.equals(" ") || s.equals("")){
			return null;
		}
		else{
			return s;
		}
	}
	
	public static void sendTitle(ProxiedPlayer p, String title, String subtitle, int fadein, int fadeout, int stay){
		TextComponent tc1 = new TextComponent(title);
		TextComponent tc2 = new TextComponent(subtitle);
		Title t = ProxyServer.getInstance().createTitle();
		t.fadeIn(fadein * 20);
		t.fadeOut(fadeout * 20);
		t.stay(stay * 20);
		t.title(tc1);
		t.subTitle(tc2);
		t.send(p);
	}
	
	public static void sendActionBar(ProxiedPlayer p, String bar){
		TextComponent tc1 = new TextComponent(bar);
		p.sendMessage(ChatMessageType.ACTION_BAR, tc1);
	}
}
