package me.O_o_Fadi_o_O.OrbitMines.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;

public class FireworkSettings {

	private OMPlayer player;
	private Color color1;
	private Color color2;
	private Color fade1;
	private Color fade2;
	private boolean flicker;
	private boolean trail;
	private Type type;
	
	public FireworkSettings(OMPlayer player, Color color1, Color color2, Color fade1, Color fade2, boolean flicker, boolean trail, Type type){
		this.player = player;
		this.color1 = color1;
		this.color2 = color2;
		this.fade1 = fade1;
		this.fade2 = fade2;
		this.flicker = flicker;
		this.trail = trail;
		this.type = type;
	}

	public OMPlayer getPlayer(){
		return player;
	}
	public void setPlayer(OMPlayer player){
		this.player = player;
	}

	public Color getColor1(){
		return color1;
	}
	public void setColor1(Color color1){
		this.color1 = color1;
	}
	public void nextColor1(){
		this.color1 = nextColor(this.color1);
	}

	public Color getColor2(){
		return color2;
	}
	public void setColor2(Color color2){
		this.color2 = color2;
	}
	public void nextColor2(){
		this.color2 = nextColor(this.color2);
	}

	public Color getFade1(){
		return fade1;
	}
	public void setFade1(Color fade1){
		this.fade1 = fade1;
	}
	public void nextFade1(){
		this.fade1 = nextColor(this.fade1);
	}

	public Color getFade2(){
		return fade2;
	}
	public void setFade2(Color fade2){
		this.fade2 = fade2;
	}
	public void nextFade2(){
		this.fade2 = nextColor(this.fade2);
	}

	public boolean hasFlicker(){
		return flicker;
	}
	public void setFlicker(boolean flicker){
		this.flicker = flicker;
	}
	public void nextFlicker(){
		this.flicker = !flicker;
	}

	public boolean hasTrail(){
		return trail;
	}
	public void setTrail(boolean trail){
		this.trail = trail;
	}
	public void nextTrail(){
		this.trail = !trail;
	}

	public Type getType(){
		return type;
	}
	public void setType(Type type){
		this.type = type;
	}
	public void nextType(){
		switch(this.type){
			case BALL:
				this.type = Type.BALL_LARGE;
				break;
			case BALL_LARGE:
				this.type = Type.BURST;
				break;
			case BURST:
				this.type = Type.CREEPER;
				break;
			case CREEPER:
				this.type = Type.STAR;
				break;
			case STAR:
				this.type = Type.BALL;
				break;
			default:
				this.type = Type.BALL;
				break;
		}
	}
	
	public String toString(){
		return Utils.parseString(getColor1()) + "|" + Utils.parseString(getColor2()) + "|" + Utils.parseString(getFade1()) + "|" + Utils.parseString(getFade2()) + "|" + hasFlicker() + "|" + hasTrail() + "|" + getType().toString();
	}
	
	public Color nextColor(Color color){
		if(color != null){
			if(color == Color.AQUA){
				return Color.BLACK;
			}
			else if(color == Color.BLACK){
				return Color.BLUE;
			}
			else if(color == Color.BLUE){
				return Color.FUCHSIA;
			}
			else if(color == Color.FUCHSIA){
				return Color.GRAY;
			}
			else if(color == Color.GRAY){
				return Color.GREEN;
			}
			else if(color == Color.GREEN){
				return Color.LIME;
			}
			else if(color == Color.LIME){
				return Color.MAROON;
			}
			else if(color == Color.MAROON){
				return Color.NAVY;
			}
			else if(color == Color.NAVY){
				return Color.ORANGE;
			}
			else if(color == Color.ORANGE){
				return Color.PURPLE;
			}
			else if(color == Color.PURPLE){
				return Color.RED;
			}
			else if(color == Color.RED){
				return Color.SILVER;
			}
			else if(color == Color.SILVER){
				return Color.TEAL;
			}
			else if(color == Color.TEAL){
				return Color.WHITE;
			}
			else if(color == Color.WHITE){
				return Color.YELLOW;
			}
			else if(color == Color.YELLOW){
				return Color.AQUA;
			}
			else{}
		}
		return Color.BLACK;
	}
	
	public static FireworkSettings getFWSettings(Player player){
		for(OMPlayer omplayer : OMPlayer.getOMPlayers()){
			if(omplayer.getPlayer() == player){
				return omplayer.getFWSettings();
			}
		}
		return null;
	}
	
	public static FireworkSettings addFWSettings(OMPlayer player, Color color1, Color color2, Color fade1, Color fade2, boolean flicker, boolean trail, Type type){
		FireworkSettings fwsettings = new FireworkSettings(player, color1, color2, fade1, fade2, flicker, trail, type);
		return fwsettings;
	}
}
