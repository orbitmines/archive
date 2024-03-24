package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

public class Ticket {

	private TicketType type;
	private int amount;
	
	public Ticket(TicketType type, int amount){
		this.type = type;
		this.amount = amount;
	}

	public TicketType getType() {
		return type;
	}
	public void setType(TicketType type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString(){
		return getType().ordinal() + ":" + getAmount();
	}
}
