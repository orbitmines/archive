package me.O_o_Fadi_o_O.OrbitMinesBungee.managers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerInfo;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.StatusListener;

public class DefaultPingManager implements StatusListener {
	
	public static int i = 0;
	public static String om;
	
	@Override
	public ServerInfo update() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("        §6§lOrbitMines§4§lNetwork ");
		list.add("");
		list.add(" §7§o'One does not simply walk into Orbit' ");
		list.add("");
		list.add("  §7§lWebsite ");
		list.add("     §6www.orbitmines.com ");
		list.add("  §7§lDonate ");
		list.add("     §3shop.orbitmines.com ");
		list.add("  §7§lVote ");
		list.add("     §borbitmines.com/vote ");
		list.add("");
		
		BufferedImage img = null;
		 
        try{
            img = ImageIO.read(new File("ServerLogo.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
		
		return new ServerInfo(getRandomStringMessage(), img, 20, "", list);
	}
	
	public static String getNormalMessage(){
        return "                §6§lOrbitMines§4§lNetwork §3§l1.8                 §4§l§k!§c§l§k!§6§l§k! §eMassive update! Info @ §lwww.orbitmines.com §6§l§k!§c§l§k!§4§l§k!";
	}
	
	public static String getRandomStringMessage(){
		String s = " ";
		if(!ServerData.getBungee().inMaintenanceMode()){
			s = "                " + om + " §3§l1.8                 §4§l§k!§c§l§k!§6§l§k! §eMassive update! Info @ §lwww.orbitmines.com §6§l§k!§c§l§k!§4§l§k!";
			return s;
		}
		else{
			s = "                " + om + " §3§l1.8                      §5§l§k!§d§l§k!§5§l§k! §dYou'll be able to join in a moment §5§l§k!§d§l§k!§5§l§k!";
			
			return s;
		}
	}
	
	public static void setNextOrbitMinesTitle(){
		i++;
		
		if(i == 1){om = "§6§lOrbitMines§4§lNetwork";}
		if(i == 7){om = "§e§lO§6§lrbitMines§4§lNetwork";}
		if(i == 8){om = "§e§lOr§6§lbitMines§4§lNetwork";}
		if(i == 9){om = "§e§lOrb§6§litMines§4§lNetwork";}
		if(i == 10){om = "§e§lOrbi§6§ltMines§4§lNetwork";}
		if(i == 11){om = "§e§lOrbit§6§lMines§4§lNetwork";}
		if(i == 12){om = "§e§lOrbitM§6§lines§4§lNetwork";}
		if(i == 13){om = "§e§lOrbitMi§6§lnes§4§lNetwork";}
		if(i == 14){om = "§e§lOrbitMin§6§les§4§lNetwork";}
		if(i == 15){om = "§e§lOrbitMine§6§ls§4§lNetwork";}
		if(i == 16){om = "§e§lOrbitMines§4§lNetwork";}
		if(i == 17){om = "§e§lOrbitMines§c§lN§4§letwork";}
		if(i == 18){om = "§e§lOrbitMines§c§lNe§4§ltwork";}
		if(i == 19){om = "§e§lOrbitMines§c§lNet§4§lwork";}
		if(i == 20){om = "§e§lOrbitMines§c§lNetw§4§lork";}
		if(i == 21){om = "§e§lOrbitMines§c§lNetwo§4§lrk";}
		if(i == 22){om = "§e§lOrbitMines§c§lNetwor§4§lk";}
		if(i == 23){om = "§e§lOrbitMines§c§lNetwork";}
		if(i == 29){om = "§6§lO§e§lrbitMines§c§lNetwork";}
		if(i == 30){om = "§6§lOr§e§lbitMines§c§lNetwork";}
		if(i == 31){om = "§6§lOrb§e§litMines§c§lNetwork";}
		if(i == 32){om = "§6§lOrbi§e§ltMines§c§lNetwork";}
		if(i == 33){om = "§6§lOrbit§e§lMines§c§lNetwork";}
		if(i == 34){om = "§6§lOrbitM§e§lines§c§lNetwork";}
		if(i == 35){om = "§6§lOrbitMi§e§lnes§c§lNetwork";}
		if(i == 36){om = "§6§lOrbitMin§e§les§c§lNetwork";}
		if(i == 37){om = "§6§lOrbitMine§e§ls§c§lNetwork";}
		if(i == 38){om = "§6§lOrbitMines§c§lNetwork";}
		if(i == 39){om = "§6§lOrbitMines§4§lN§c§letwork";}
		if(i == 40){om = "§6§lOrbitMines§4§lNe§c§ltwork";}
		if(i == 41){om = "§6§lOrbitMines§4§lNet§c§lwork";}
		if(i == 42){om = "§6§lOrbitMines§4§lNetw§c§lork";}
		if(i == 43){om = "§6§lOrbitMines§4§lNetwo§c§lrk";}
		if(i == 44){om = "§6§lOrbitMines§4§lNetwor§c§lk";}
		if(i == 45){om = "§6§lOrbitMines§4§lNetwork"; i = 0;}
	}
}
