package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class LoginRunnable implements Runnable {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
			if(Start.staffpasswords.containsKey(p.getName())){
				if(Start.stafflogin.containsKey(p) && Start.stafflogin.get(p) == false){
					Start.stafflogintimeleft.put(p, Start.stafflogintimeleft.get(p) -1);
					
					if(Start.stafflogintimeleft.get(p) == 0){
						p.disconnect("§4§lSTAFF PROTECTION\n§7Kicked!");
					}
					else{
						TextComponent title = new TextComponent("§4§lSTAFF PROTECTION");
						TextComponent subtitle = new TextComponent("§7" + Start.stafflogintimeleft.get(p) + "...");
						Title t = ProxyServer.getInstance().createTitle();
						t.fadeIn(0);
						t.fadeOut(0);
						t.stay(40);
						t.title(title);
						t.subTitle(subtitle);
						t.send(p);
					}
				}
			}
		}
	}
}
