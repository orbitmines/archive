package me.O_o_Fadi_o_O.Prison.managers;

import me.O_o_Fadi_o_O.Prison.utils.Letters;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class TextManager {
	
	public static void createCountdownWord(Location l, int Minutes, int Seconds){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location n1 = new Location(w, x +8, y, z);
		Location n2 = new Location(w, x +4, y, z);
		Location n3 = new Location(w, x -2, y, z);
		Location n4 = new Location(w, x -6, y, z);
		
		Letters.createEmpty(n1, "SOUTH", Material.AIR, (byte) 0);
		Letters.createEmpty(n2, "SOUTH", Material.AIR, (byte) 0);
		Letters.createEmpty(n3, "SOUTH", Material.AIR, (byte) 0);
		Letters.createEmpty(n4, "SOUTH", Material.AIR, (byte) 0);

		Letters.createDPunt(l, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		
		if(Minutes == 0){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 1){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 2){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 3){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 4){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 5){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 6){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 7){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 8){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 9){
			Letters.create0(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 10){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 11){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 12){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 13){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 14){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 15){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 16){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 17){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 18){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 19){
			Letters.create1(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 20){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 21){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 22){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 23){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 24){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 25){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 26){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 27){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 28){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 29){
			Letters.create2(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 30){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 31){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 32){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 33){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 34){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 35){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 36){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 37){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 38){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 39){
			Letters.create3(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 40){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 41){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 42){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 43){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 44){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 45){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 46){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 47){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 48){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 49){
			Letters.create4(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 50){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 51){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 52){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 53){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 54){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 55){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 56){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 57){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 58){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 59){
			Letters.create5(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if(Minutes == 60){
			Letters.create6(n1, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n2, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		
		
		if (Seconds == 0) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 1) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 2) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 3) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 4) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 5) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 6) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 7) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 8) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 9) {
			Letters.create0(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 10) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 11) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 12) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 13) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 14) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 15) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 16) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 17) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 18) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 19) {
			Letters.create1(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 20) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 21) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 22) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 23) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 24) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 25) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 26) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 27) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 28) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 29) {
			Letters.create2(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 30) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 31) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 32) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 33) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 34) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 35) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 36) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 37) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 38) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 39) {
			Letters.create3(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 40) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 41) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 42) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 43) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 44) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 45) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 46) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 47) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 48) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 49) {
			Letters.create4(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 50) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 51) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create1(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 52) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create2(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 53) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create3(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 54) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create4(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 55) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create5(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 56) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create6(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 57) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create7(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 58) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create8(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 59) {
			Letters.create5(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create9(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
		if (Seconds == 60) {
			Letters.create6(n3, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
			Letters.create0(n4, "SOUTH", Material.REDSTONE_BLOCK, (byte) 0);
		}
	}
}
