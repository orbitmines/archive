package me.O_o_Fadi_o_O.Friends.managers;

import java.sql.DriverManager;
import java.sql.SQLException;

import me.O_o_Fadi_o_O.Friends.Start;

public class DatabaseManager {

	public static synchronized void openConnection(){
		
		try {
			Start.connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
