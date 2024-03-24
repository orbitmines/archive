package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R2.PlayerConnection;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Message {

	private MessageName messagename;
	private MessageType messagetype;
	private String message;
	private List<String> messages;
	private Sound sound;
	private String title;
	private String subtitle;
	private String actionbar;
	private int titlefadein;
	private int titlefadeout;
	private int titlestay;
	
	private String messagetosend;
	private List<String> messagestosend;
	private String titletosend;
	private String subtitletosend;
	private String actionbartosend;
	
	public Message(MessageName messagename, MessageType messagetype, String message, Sound sound){
		if(messagetype == MessageType.MESSAGE){
			this.messagename = messagename;
			this.messagetype = messagetype;
			this.message = message;
			this.sound = sound;
		}
		else{
			this.messagename = messagename;
			this.messagetype = messagetype;
			this.actionbar = message;
			this.sound = sound;
		}
	}
	
	public Message(MessageName messagename, MessageType messagetype, List<String> messages, Sound sound){
		this.messagename = messagename;
		this.messagetype = messagetype;
		this.messages = messages;
		this.sound = sound;
	}
	
	public Message(MessageName messagename, MessageType messagetype, Sound sound){
		this.messagename = messagename;
		this.messagetype = messagetype;
		this.sound = sound;
	}
	
	public Message(MessageName messagename, MessageType messagetype, String title, String subtitle, int titlefadein, int titlefadeout, int titlestay, Sound sound){
		this.messagename = messagename;
		this.messagetype = messagetype;
		this.title = title;
		this.subtitle = subtitle;
		this.titlefadein = titlefadein * 20;
		this.titlefadeout = titlefadeout * 20;
		this.titlestay = titlestay * 20;
		this.sound = sound;
	}

	public MessageName getMessageName(){
		return messagename;
	}
	public void setMessageName(MessageName messagename){
		this.messagename = messagename;
	}

	public MessageType getMessageType(){
		return messagetype;
	}
	public void setMessageType(MessageType messagetype){
		this.messagetype = messagetype;
	}

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	
	public List<String> getMessages(){
		return messages;
	}
	public void setMessages(List<String> messages){
		this.messages = messages;
	}

	public Sound getSound(){
		return sound;
	}
	public void setSound(Sound sound){
		this.sound = sound;
	}

	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

	public String getSubtitle(){
		return subtitle;
	}
	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getActionBar(){
		return actionbar;
	}
	public void setActionBar(String actionbar){
		this.actionbar = actionbar;
	}

	public int getTitleFadeIn(){
		return titlefadein;
	}
	public void setTitleFadeIn(int titlefadein){
		this.titlefadein = titlefadein;
	}

	public int getTitleFadeOut(){
		return titlefadeout;
	}
	public void setTitlefadeout(int titlefadeout){
		this.titlefadeout = titlefadeout;
	}

	public int getTitleStay(){
		return titlestay;
	}
	public void setTitleStay(int titlestay){
		this.titlestay = titlestay;
	}
	
	public String getMessageToSend() {
		return messagetosend;
	}
	public void setMessageToSend(String messagetosend) {
		this.messagetosend = messagetosend;
	}
	
	public List<String> getMessagesToSend() {
		return messagestosend;
	}
	public void setMessagesToSend(List<String> messagestosend) {
		this.messagestosend = messagestosend;
	}

	public String getTitleToSend() {
		return titletosend;
	}
	public void setTitleToSend(String titletosend) {
		this.titletosend = titletosend;
	}

	public String getSubtitleToSend() {
		return subtitletosend;
	}
	public void setSubtitleToSend(String subtitletosend) {
		this.subtitletosend = subtitletosend;
	}

	public String getActionBarToSend() {
		return actionbartosend;
	}
	public void setActionBarToSend(String actionbartosend) {
		this.actionbartosend = actionbartosend;
	}
	
	public String getPlayerReplacement(CommandSender p1, CommandSender p2, String s){
		s = s.replace("&", "§");
		
		if(p1 != null){
			if(p1 instanceof Player){
				SpleefPlayer sp = StorageManager.spleefplayer.get(p1);
				s = s.replace("%player%", p1.getName()).replace("%tokens%", "" + sp.getTokens()).replace("%kills%", "" + sp.getKills()).replace("%wins%", "" + sp.getWins()).replace("%loses%", "" + sp.getLoses());
			}
			else{
				s = s.replace("%player%", "The Console");
			}
		}
		if(p2 != null){
			if(p2 instanceof Player){
				SpleefPlayer sp = StorageManager.spleefplayer.get(p2);
				s = s.replace("%player-2%", p2.getName()).replace("%tokens%", "" + sp.getTokens()).replace("%kills%", "" + sp.getKills()).replace("%wins%", "" + sp.getWins()).replace("%loses%", "" + sp.getLoses());
			}
			else{
				s = s.replace("%player-2%", "The Console");
			}
		}
		
		return s;
	}
	
	public String getArenaReplacement(Arena arena, SpleefPlayer sp1, SpleefPlayer sp2, SpleefPlayer sp3, String s){
		s = s.replace("&", "§");
		
		if(arena != null){
			s = s.replace("%players%", "" + arena.getPlayers().size()).replace("%spectators%", "" + arena.getSpectators().size()).replace("%minutes%", "" + arena.getMinutes()).replace("%seconds%", "" + arena.getSeconds()).replace("%min-players%", "" + arena.getMinPlayers()).replace("%max-players%", "" + arena.getMaxPlayers()).replace("%arena-id%", "" + arena.getArenaID());
		}
		if(sp1 != null){
			s = s.replace("%player%", sp1.getPlayer().getName()).replace("%player-1%", sp1.getPlayer().getName());
		}
		else{
			if(getMessageName() == MessageName.ENDED){
				s = s.replace("%player-1%", "");
			}
		}
		if(sp2 != null){
			s = s.replace("%player-2%", sp2.getPlayer().getName());
		}
		else{
			if(getMessageName() == MessageName.ENDED){
				s = s.replace("%player-2%", "");
			}
		}
		if(sp3 != null){
			s = s.replace("%player-3%", sp3.getPlayer().getName());
		}
		else{
			if(getMessageName() == MessageName.ENDED){
				s = s.replace("%player-3%", "");
			}
		}
		return s;
	}
	
	public void updateForPlayer(CommandSender p1, CommandSender p2){
		if(getMessageType() == MessageType.MESSAGE){
			setMessageToSend(getPlayerReplacement(p1, p2, getMessage()));
		}
		if(getMessageType() == MessageType.MESSAGES){
			List<String> newlist = new ArrayList<String>();
			for(String s : getMessages()){
				newlist.add(getPlayerReplacement(p1, p2, s));
			}
			setMessagesToSend(newlist);
		}
		if(getMessageType() == MessageType.TITLE){
			setTitleToSend(getPlayerReplacement(p1, p2, getTitle()));
			setSubtitleToSend(getPlayerReplacement(p1, p2, getSubtitle()));
		}
		if(getMessageType() == MessageType.ACTIONBAR){
			setActionBarToSend(getPlayerReplacement(p1, p2, getActionBar()));
		}
	}
	
	public void replace(String oldChar, String newChar){
		if(getMessageType() == MessageType.MESSAGE){
			if(getMessageToSend() != null){
				setMessageToSend(getMessageToSend().replace(oldChar, newChar));
			}
			else{
				setMessageToSend(getMessage().replace(oldChar, newChar));
			}
		}
		if(getMessageType() == MessageType.MESSAGES){
			if(getMessagesToSend() != null){
				List<String> newlist = new ArrayList<String>();
				for(String s : getMessagesToSend()){
					newlist.add(s.replace(oldChar, newChar));
				}
				setMessagesToSend(newlist);
			}
			else{
				List<String> newlist = new ArrayList<String>();
				for(String s : getMessages()){
					newlist.add(s.replace(oldChar, newChar));
				}
				setMessagesToSend(newlist);
			}
		}
		if(getMessageType() == MessageType.TITLE){
			if(getTitleToSend() != null){
				setTitleToSend(getTitleToSend().replace(oldChar, newChar));
			}
			else{
				setTitleToSend(getTitle().replace(oldChar, newChar));
			}
			
			if(getSubtitleToSend() != null){
				setSubtitleToSend(getSubtitleToSend().replace(oldChar, newChar));
			}
			else{
				setSubtitleToSend(getSubtitle().replace(oldChar, newChar));
			}
		}
		if(getMessageType() == MessageType.ACTIONBAR){
			if(getActionBarToSend() != null){
				setActionBarToSend(getActionBarToSend().replace(oldChar, newChar));
			}
			else{
				setActionBarToSend(getActionBar().replace(oldChar, newChar));
			}
		}
	}
	
	public void updateForArena(Arena arena, SpleefPlayer sp1, SpleefPlayer sp2, SpleefPlayer sp3){
		if(getMessageType() == MessageType.MESSAGE){
			setMessageToSend(getArenaReplacement(arena, sp1, sp2, sp3, getMessage()));
		}
		else if(getMessageType() == MessageType.MESSAGES){
			List<String> newlist = new ArrayList<String>();
			for(String s : getMessages()){
				newlist.add(getArenaReplacement(arena, sp1, sp2, sp3, s));
			}
			setMessagesToSend(newlist);
		}
		else if(getMessageType() == MessageType.TITLE){
			setTitleToSend(getArenaReplacement(arena, sp1, sp2, sp3, getTitle()));
			setSubtitleToSend(getArenaReplacement(arena, sp1, sp2, sp3, getSubtitle()));
		}
		else if(getMessageType() == MessageType.ACTIONBAR){
			setActionBarToSend(getArenaReplacement(arena, sp1, sp2, sp3, getActionBar()));
		}
		else{}
	}
	
	public void send(List<SpleefPlayer> list){
		if(getSound() != null){
			for(SpleefPlayer sp : list){
				sp.getPlayer().playSound(sp.getPlayer().getLocation(), getSound(), 5, 1);
			}
		}
		
		if(getMessageType() == MessageType.MESSAGE){
			for(SpleefPlayer sp : list){
				sp.getPlayer().sendMessage(getMessageToSend());
			}
		}
		else if(getMessageType() == MessageType.MESSAGES){
			for(SpleefPlayer sp : list){
				Player p = sp.getPlayer();
				for(String s : getMessagesToSend()){
					p.sendMessage(s);
				}
			}
		}
		else if(getMessageType() == MessageType.TITLE){

			IChatBaseComponent time = ChatSerializer.a("{\"text\": \"" + "" + "\"}");
			PacketPlayOutTitle timepacket = new PacketPlayOutTitle(EnumTitleAction.TIMES, time, getTitleFadeIn(), getTitleStay(), getTitleFadeOut());
			
			IChatBaseComponent t = ChatSerializer.a("{\"text\": \"" + getTitleToSend() + "\"}");
			PacketPlayOutTitle tpacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, t);
			
			IChatBaseComponent s = ChatSerializer.a("{\"text\": \"" + getSubtitleToSend() + "\"}");
			PacketPlayOutTitle spacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, s);
			
			for(SpleefPlayer sp : list){
				PlayerConnection c = ((CraftPlayer) sp.getPlayer()).getHandle().playerConnection;
				
				c.sendPacket(timepacket);
				c.sendPacket(tpacket);
				c.sendPacket(spacket);
			}
		}
		else if(getMessageType() == MessageType.ACTIONBAR){
			IChatBaseComponent a = ChatSerializer.a("{\"text\": \"" + getActionBarToSend() + "\"}");
			PacketPlayOutChat apacket = new PacketPlayOutChat(a, (byte) 2);
			
			for(SpleefPlayer sp : list){
				PlayerConnection c = ((CraftPlayer) sp.getPlayer()).getHandle().playerConnection;
				
				c.sendPacket(apacket);
			}
		}
		else{}
		
		setMessageToSend(null);
		setMessagesToSend(null);
		setTitleToSend(null);
		setSubtitleToSend(null);
		setActionBarToSend(null);
	}
	
	public void send(CommandSender sender){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(getSound() != null){
				p.playSound(p.getLocation(), getSound(), 5, 1);
			}
		}
		
		if(getMessageType() == MessageType.MESSAGE){
			sender.sendMessage(getMessageToSend());
		}
		else if(getMessageType() == MessageType.MESSAGES){
			for(String s : getMessagesToSend()){
				sender.sendMessage(s);
			}
		}
		else if(getMessageType() == MessageType.TITLE){
			if(sender instanceof Player){
				Player p = (Player) sender;
				
				IChatBaseComponent time = ChatSerializer.a("{\"text\": \"" + "" + "\"}");
				PacketPlayOutTitle timepacket = new PacketPlayOutTitle(EnumTitleAction.TIMES, time, getTitleFadeIn(), getTitleStay(), getTitleFadeOut());
				
				IChatBaseComponent t = ChatSerializer.a("{\"text\": \"" + getTitleToSend() + "\"}");
				PacketPlayOutTitle tpacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, t);
				
				IChatBaseComponent s = ChatSerializer.a("{\"text\": \"" + getSubtitleToSend() + "\"}");
				PacketPlayOutTitle spacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, s);
				
				PlayerConnection c = ((CraftPlayer) p).getHandle().playerConnection;
				
				c.sendPacket(timepacket);
				c.sendPacket(tpacket);
				c.sendPacket(spacket);
			}
		}
		else if(getMessageType() == MessageType.ACTIONBAR){
			if(sender instanceof Player){
				Player p = (Player) sender;
				
				IChatBaseComponent a = ChatSerializer.a("{\"text\": \"" + getActionBarToSend() + "\"}");
				PacketPlayOutChat apacket = new PacketPlayOutChat(a, (byte) 2);
				
				PlayerConnection c = ((CraftPlayer) p).getHandle().playerConnection;
				
				c.sendPacket(apacket);
			}
		}
		else{}
		
		setMessageToSend(null);
		setMessagesToSend(null);
		setTitleToSend(null);
		setSubtitleToSend(null);
		setActionBarToSend(null);
	}
	

	public void send(CommandSender sender, String... ifnotcontains){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(getSound() != null){
				p.playSound(p.getLocation(), getSound(), 5, 1);
			}
		}
		
		if(getMessageType() == MessageType.MESSAGE){
			boolean send = true;
			for(String contains : ifnotcontains){
				if(getMessageToSend().toLowerCase().contains(contains.toLowerCase())){
					send = false;
				}
			}
			
			if(send == true){
				sender.sendMessage(getMessageToSend());
			}
		}
		else if(getMessageType() == MessageType.MESSAGES){
			for(String s : getMessagesToSend()){
				boolean send = true;
				for(String contains : ifnotcontains){
					if(s.toLowerCase().contains(contains.toLowerCase())){
						send = false;
					}
				}
				
				if(send == true){
					sender.sendMessage(s);
				}
			}
		}
		else if(getMessageType() == MessageType.TITLE){
			if(sender instanceof Player){
				boolean send = true;
				for(String contains : ifnotcontains){
					if(getTitleToSend().toLowerCase().contains(contains.toLowerCase()) || getSubtitleToSend().toLowerCase().contains(contains.toLowerCase())){
						send = false;
					}
				}
				
				if(send == true){
					Player p = (Player) sender;
					
					IChatBaseComponent time = ChatSerializer.a("{\"text\": \"" + "" + "\"}");
					PacketPlayOutTitle timepacket = new PacketPlayOutTitle(EnumTitleAction.TIMES, time, getTitleFadeIn(), getTitleStay(), getTitleFadeOut());
					
					IChatBaseComponent t = ChatSerializer.a("{\"text\": \"" + getTitleToSend() + "\"}");
					PacketPlayOutTitle tpacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, t);
					
					IChatBaseComponent s = ChatSerializer.a("{\"text\": \"" + getSubtitleToSend() + "\"}");
					PacketPlayOutTitle spacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, s);
					
					PlayerConnection c = ((CraftPlayer) p).getHandle().playerConnection;
					
					c.sendPacket(timepacket);
					c.sendPacket(tpacket);
					c.sendPacket(spacket);
				}
			}
		}
		else if(getMessageType() == MessageType.ACTIONBAR){
			if(sender instanceof Player){
				boolean send = true;
				for(String contains : ifnotcontains){
					if(getActionBarToSend().toLowerCase().contains(contains.toLowerCase())){
						send = false;
					}
				}
				
				if(send == true){
					Player p = (Player) sender;
					
					IChatBaseComponent a = ChatSerializer.a("{\"text\": \"" + getActionBarToSend() + "\"}");
					PacketPlayOutChat apacket = new PacketPlayOutChat(a, (byte) 2);
					
					PlayerConnection c = ((CraftPlayer) p).getHandle().playerConnection;
					
					c.sendPacket(apacket);
				}
			}
		}
		else{}
		
		setMessageToSend(null);
		setMessagesToSend(null);
		setTitleToSend(null);
		setSubtitleToSend(null);
		setActionBarToSend(null);
	}
	
	public static Message getMessage(MessageName messagename){
		for(Message message : StorageManager.messages){
			if(message.getMessageName() == messagename){
				return message;
			}
		}
		return null;
	}
}
