package me.O_o_Fadi_o_O.VaultToCoins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends JavaPlugin{
	
	Connection connection;
	
	public void onEnable(){
		
		setupPermissions();
		setupChat();
		setupEconomy();
		
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				openConnection();
				
			}
		}.runTaskAsynchronously(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("tradecoins")){
		
		if((sender instanceof Player)){
			Player p = (Player)sender;
			
				int money = (int) economy.getBalance(p.getName());
				
				economy.withdrawPlayer(p.getName(), money);
				try {
					addMoney(p, money);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				p.sendMessage("§8[§c§lKitPvP§8] §7Traded §e" + money + " Money§7 for §6" + money + " Coins§7!");
			
			
			}
		}
		return false;
	}
	// ADD COINS
	public void addMoney(Player p, int money) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-Money` SET `money` = '" + (getMoney(p) + money) + "' WHERE `name` = '" + p.getName() + "'");
	}
	// GET MONEY
	public int getMoney(Player p){
		int money = 0;
		
		String query = "SELECT `money` FROM `KitPvP-Money` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				money = rs.getInt("money");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return money;
	}
	public synchronized void openConnection(){
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	// VAULT SETUP
	public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        
        return (economy != null);
    }
}
