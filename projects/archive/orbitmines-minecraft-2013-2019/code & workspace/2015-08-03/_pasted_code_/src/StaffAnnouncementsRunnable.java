public class StaffAnnouncementsRunnable implements Runnable {

	int i = 0;
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		i++;
		
		if(i == 1){
			
			for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
				if(p.hasPermission("Rank.Owner") || p.hasPermission("Rank.Moderator")){
					if(Start.showstaffmessage.get(p.getName()) == false){
						p.sendMessage("§d§lStaff §8| §7Use §d/staffMSG§7 to toggle §dStaff Messages§7. (§c§lDISABLED§7)");
					}
					else{
						p.sendMessage("§d§lStaff §8| §7Use §d/staffMSG§7 to toggle §dStaff Messages§7. (§a§lENABLED§7)");
					}
				}
			}
			
		}
		else if(i == 2){
			
			for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
				if(p.hasPermission("Rank.Owner") || p.hasPermission("Rank.Moderator")){
					p.sendMessage("§d§lStaff §8| §7Use §d@§7 to talk in the §dStaff Chat§7.");
				}
			}
			
			i = 0;
		}
	}
}