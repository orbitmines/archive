package me.O_o_Fadi_o_O.BungeeMSG.managers;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import net.md_5.bungee.log.ConciseFormatter;

public class LogManager {

	private static Logger log = Logger.getLogger("BungeeMSG - Log");
	private static FileHandler fileh = null;
	static Start start = Start.getInstance();
	
	public static boolean islogloaded = false;
	
	public static void createNewLog(){
		if(StorageManager.uselog == true){
			new File(start.getDataFolder().getPath() + "/logs").mkdir();
			
			if(fileh != null){
				log.removeHandler(fileh);
			}
			
			try{
				FileHandler fh = new FileHandler(start.getDataFolder().getPath() + "/logs/" + Start.getDayDate() + "_BungeeMSG.log", 1 << 24, 8, true);
		        fh.setFormatter(new ConciseFormatter());  
		        log.addHandler(fh);
		
		        log.setUseParentHandlers(false);
		         
		        log.info("Starting BungeeMSG Log... (" + Start.getDate() + ")"); 
		        log.info("");
		        log.info("BungeeMSG " + StorageManager.version + " - Developed by O_o_Fadi_o_O.");
		        log.info("");
		        
		        islogloaded = true;
		        setFileh(fh);
		    }catch(SecurityException ex){  
		        ex.printStackTrace();  
		    }catch(IOException ex){  
		        ex.printStackTrace();  
		    }  
		}
	}
	
	public static Logger getLog(){
		return log;
	}

	public static FileHandler getFileH() {
		return fileh;
	}

	public static void setFileh(FileHandler fileh) {
		LogManager.fileh = fileh;
	}
}
