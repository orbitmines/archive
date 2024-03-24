package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.StaffRank;

public enum Command {
	
	// Bungee Commands \\
	ALLCHAT,
	ALL,
	LIST,
	GLIST,
	FRIENDS,
	FRIEND,
	HUB,
	LOBBY,
	SERVER,
	DONATE,
	WEBSITE,
	SITE,
	REPORT,
	HELP,
	IP,
	SEEN,
	SAY,
	MAINTENANCE,
	STAFFHELP,
	KICKALL,
	KICK,
	UNBAN,
	UNBANIP,
	BAN,
	BANIP,
	STAFFMSG,
	BROADCAST,
	MSG,
	M,
	T,
	TELL,
	W,
	WHISPER,
	R,
	REPLY,
	
	UUID,
	PLUGINS,
	PL,
	BUILDER,
	SERVERS,
	PERKS,
	OPMODE,
	TOPVOTERS,
	AFK,
	NICK,
	DISGUISE,
	DIS,
	D,
	UNDISGUISE,
	UNDIS,
	UND,
	GIVE,
	TP,
	TELEPORT,
	SKULL,
	EAT,
	FEED,
	FLY,
	GMS,
	GMC,
	GMA,
	GMSPEC,
	GAMEMODE,
	GM,
	VOTE,
	PETS,
	CHATCOLORS,
	DISGUISES,
	GADGETS,
	WARDROBE,
	TRAILS,
	HATS,
	FIREWORKS,
	SILENT,
	HEAL,
	KIT,
	PLOT,
	P,
	SPAWN,
	HOME,
	H,
	DELHOME,
	DELH,
	SETHOME,
	SETH,
	HOMES,
	CONFIRM,
	REGION,
	TOPMONEY,
	WARPS,
	MYWARPS,
	SETWARP,
	EDITWARP,
	ENDERCHEST,
	WORKBENCH,
	ACCEPT,
	TPHERE,
	INVSEE,
	BACK,
	ISLAND,
	IS,
	RANKUP,
	MINES,
	ADDENCH,
	ADDENCHANTMENT,
	PAY,
	TOPGOLD;
	
	public String getName(){
		return "/" + this.toString().toLowerCase();
	}
	
	public boolean addToList(BungeePlayer bp, Server server){
		switch(this){
			case AFK:
				return true;
			case BUILDER:
				if(bp.hasPerms(StaffRank.Builder) && server == Server.HUB){
					return true;
				}
				break;
			case D:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case DIS:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case DISGUISE:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case EAT:
				if(bp.hasPerms(StaffRank.Owner) || server == Server.PRISON){
					return true;
				}
				break;
			case FEED:
				if(bp.hasPerms(StaffRank.Owner) || server == Server.PRISON){
					return true;
				}
				break;
			case FLY:
				if(bp.hasPerms(StaffRank.Moderator) || server == Server.SURVIVAL || server == Server.SKYBLOCK || server == Server.PRISON){
					return true;
				}
				break;
			case GAMEMODE:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case GIVE:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case GM:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case GMA:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case GMC:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case GMS:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case GMSPEC:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case NICK:
				return true;
			case OPMODE:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case PERKS:
				return true;
			case PL:
				break;
			case PLUGINS:
				break;
			case SERVERS:
				return true;
			case SKULL:
				if(bp.hasPerms(StaffRank.Owner) || bp.hasPerms(StaffRank.Builder) && server == Server.HUB){
					return true;
				}
				break;
			case TELEPORT:
				if(bp.hasPerms(StaffRank.Moderator) || server == Server.SURVIVAL){
					return true;
				}
				break;
			case TOPVOTERS:
				return true;
			case TP:
				if(bp.hasPerms(StaffRank.Moderator) || server == Server.SURVIVAL){
					return true;
				}
				break;
			case UND:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case UNDIS:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case UNDISGUISE:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case UUID:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case VOTE:
				return true;
			case CHATCOLORS:
				return true;
			case DISGUISES:
				return true;
			case FIREWORKS:
				return true;
			case GADGETS:
				return true;
			case HATS:
				return true;
			case PETS:
				return true;
			case TRAILS:
				return true;
			case WARDROBE:
				return true;
			case SILENT:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case HEAL:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case KIT:
				if(server == Server.KITPVP || server == Server.SKYBLOCK || server == Server.PRISON){
					return true;
				}
				break;
			case P:
				if(server == Server.CREATIVE){
					return true;
				}
				break;
			case PLOT:
				if(server == Server.CREATIVE){
					return true;
				}
				break;
			case SPAWN:
				if(server == Server.CREATIVE || server == Server.SURVIVAL || server == Server.SKYBLOCK || server == Server.PRISON){
					return true;
				}
				break;
			case HOME:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case H:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case DELHOME:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case DELH:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case SETHOME:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case SETH:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case HOMES:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case CONFIRM:
				break;
			case REGION:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case TOPMONEY:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case WARPS:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case MYWARPS:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case SETWARP:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case EDITWARP:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case ENDERCHEST:
				if(server == Server.SURVIVAL || server == Server.SKYBLOCK || server == Server.PRISON){
					return true;
				}
				break;
			case WORKBENCH:
				if(server == Server.SURVIVAL || server == Server.SKYBLOCK || server == Server.PRISON){
					return true;
				}
				break;
			case TPHERE:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case ACCEPT:
				break;
			case INVSEE:
				if(bp.hasPerms(StaffRank.Moderator) || server == Server.SURVIVAL || server == Server.SKYBLOCK || server == Server.PRISON){
					return true;
				}
				break;
			case BACK:
				if(server == Server.SURVIVAL){
					return true;
				}
				break;
			case ISLAND:
				if(server == Server.SKYBLOCK){
					return true;
				}
				break;
			case IS:
				if(server == Server.SKYBLOCK){
					return true;
				}
				break;
			case RANKUP:
				if(server == Server.PRISON){
					return true;
				}
				break;
			case MINES:
				if(server == Server.PRISON){
					return true;
				}
				break;
			case ADDENCH:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case ADDENCHANTMENT:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case PAY:
				if(server == Server.PRISON){
					return true;
				}
				break;
			case TOPGOLD:
				if(server == Server.PRISON){
					return true;
				}
				break;
			case ALL:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case ALLCHAT:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case BAN:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case BANIP:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case BROADCAST:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case DONATE:
				return true;
			case FRIEND:
				return true;
			case FRIENDS:
				return true;
			case GLIST:
				return true;
			case HELP:
				return true;
			case HUB:
				return true;
			case IP:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case KICK:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case KICKALL:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case LIST:
				return true;
			case LOBBY:
				return true;
			case M:
				return true;
			case MAINTENANCE:
				if(bp.hasPerms(StaffRank.Owner)){
					return true;
				}
				break;
			case MSG:
				return true;
			case R:
				return true;
			case REPLY:
				return true;
			case REPORT:
				return true;
			case SAY:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case SEEN:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case SERVER:
				return true;
			case SITE:
				return true;
			case STAFFHELP:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case STAFFMSG:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case T:
				return true;
			case TELL:
				return true;
			case UNBAN:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case UNBANIP:
				if(bp.hasPerms(StaffRank.Moderator)){
					return true;
				}
				break;
			case W:
				return true;
			case WEBSITE:
				return true;
			case WHISPER:
				return true;
		}
		return false;
	}
	
	public static List<String> getBungeeCommands(){
		return Arrays.asList(Command.FRIEND.getName(), Command.REPORT.getName(), Command.IP.getName(), Command.SEEN.getName(), Command.SAY.getName(), Command.KICKALL.getName(), Command.KICK.getName(), Command.UNBAN.getName(), Command.BAN.getName(), Command.BROADCAST.getName(), Command.MSG.getName(), Command.M.getName(), Command.T.getName(), Command.TELL.getName(), Command.W.getName(), Command.WHISPER.getName(), Command.R.getName(), Command.REPLY.getName());
	}
	
	public static List<String> getServerCommands(){
		return Arrays.asList(Command.UUID.getName(), Command.DISGUISE.getName(), Command.DIS.getName(), Command.D.getName(), Command.UNDISGUISE.getName(), Command.UNDIS.getName(), Command.UND.getName(), Command.GIVE.getName(), Command.TP.getName(), Command.TELEPORT.getName(), Command.SKULL.getName(), Command.EAT.getName(), Command.FEED.getName(), Command.FLY.getName(), Command.GMS.getName(), Command.GMC.getName(), Command.GMA.getName(), Command.GMSPEC.getName(), Command.GAMEMODE.getName(), Command.GM.getName(), Command.HEAL.getName(), Command.PLOT.getName(), Command.P.getName(), Command.TPHERE.getName(), Command.INVSEE.getName(), Command.ISLAND.getName(), Command.IS.getName(), Command.PAY.getName());
	}
	
	public static List<String> getCommands(BungeePlayer bp){
		List<String> commands = new ArrayList<String>();
		
		for(Command command : Command.values()){
			if(command.addToList(bp, bp.getServer())){
				commands.add(command.getName());
			}
		}
		
		return commands;
	}
}
