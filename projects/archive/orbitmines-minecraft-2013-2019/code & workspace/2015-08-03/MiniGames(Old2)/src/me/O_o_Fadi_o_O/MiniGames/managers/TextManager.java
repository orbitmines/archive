package me.O_o_Fadi_o_O.MiniGames.managers;

import me.O_o_Fadi_o_O.MiniGames.utils.Letters;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class TextManager {

	public static void createSurvivalGamesWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z +3);
		Location e3 = new Location(w, x, y, z +6);
		Location e4 = new Location(w, x, y, z +9);
		Location e5 = new Location(w, x, y, z +12);
		Location e6 = new Location(w, x, y, z +15);
		Location e7 = new Location(w, x, y, z +18);
		Location e8 = new Location(w, x, y, z +21);
		Location e9 = new Location(w, x, y, z +24);
		Location e10 = new Location(w, x, y, z +27);
		Location e11 = new Location(w, x, y, z +30);
		Location e12 = new Location(w, x, y, z +33);
		Location e13 = new Location(w, x, y, z +36);
		Location e14 = new Location(w, x, y, z +39);
		Location e15 = new Location(w, x, y, z +42);
		Location e16 = new Location(w, x, y, z +45);
		Location e17 = new Location(w, x, y, z +48);
		Location e18 = new Location(w, x, y, z +51);
		Location e19 = new Location(w, x, y, z +54);
		Location e20 = new Location(w, x, y, z +57);
		Location e21 = new Location(w, x, y, z +60);
		Location e22 = new Location(w, x, y, z +63);
		Location e23 = new Location(w, x, y, z +66);
		Location e24 = new Location(w, x, y, z +69);
		Location e25 = new Location(w, x, y, z +72);
		
		Letters.createEmpty(e1, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "EAST", Material.AIR, (byte) 0);
		
		Location G1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z +4);
		Location M1 = new Location(w, x, y, z +8);
		Location E1 = new Location(w, x, y, z +12);
		Location DPunt1 = new Location(w, x, y, z +16);
		
		Location S1 = new Location(w, x, y, z +20);
		Location U1 = new Location(w, x, y, z +24);
		Location R1 = new Location(w, x, y, z +28);
		Location V1 = new Location(w, x, y, z +32);
		Location I1 = new Location(w, x, y, z +36);
		Location V2 = new Location(w, x, y, z +40);
		Location A2 = new Location(w, x, y, z +44);
		Location L1 = new Location(w, x, y, z +48);

		Location G2 = new Location(w, x, y, z +54);
		Location A3 = new Location(w, x, y, z +58);
		Location M2 = new Location(w, x, y, z +62);
		Location E2 = new Location(w, x, y, z +66);
		Location S2 = new Location(w, x, y, z +70);
		
		Letters.createG(G1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createA(A1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createM(M1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createE(E1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createDPunt(DPunt1, "EAST", Material.STAINED_CLAY, (byte) 14);
		
		Letters.createS(S1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createU(U1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createV(V1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createI(I1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createV(V2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createL(L1, "EAST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createG(G2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A3, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createM(M2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createS(S2, "EAST", Material.STAINED_CLAY, (byte) 0);
		
	}
	
	public static void createHerobrinesTrainingWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z -3);
		Location e3 = new Location(w, x, y, z -6);
		Location e4 = new Location(w, x, y, z -9);
		Location e5 = new Location(w, x, y, z -12);
		Location e6 = new Location(w, x, y, z -15);
		Location e7 = new Location(w, x, y, z -18);
		Location e8 = new Location(w, x, y, z -21);
		Location e9 = new Location(w, x, y, z -24);
		Location e10 = new Location(w, x, y, z -27);
		Location e11 = new Location(w, x, y, z -30);
		Location e12 = new Location(w, x, y, z -33);
		Location e13 = new Location(w, x, y, z -36);
		Location e14 = new Location(w, x, y, z -39);
		Location e15 = new Location(w, x, y, z -42);
		Location e16 = new Location(w, x, y, z -45);
		Location e17 = new Location(w, x, y, z -48);
		Location e18 = new Location(w, x, y, z -51);
		Location e19 = new Location(w, x, y, z -54);
		Location e20 = new Location(w, x, y, z -57);
		Location e21 = new Location(w, x, y, z -60);
		Location e22 = new Location(w, x, y, z -63);
		Location e23 = new Location(w, x, y, z -66);
		Location e24 = new Location(w, x, y, z -69);
		Location e25 = new Location(w, x, y, z -72);
		Location e26 = new Location(w, x, y, z -75);
		
		Letters.createEmpty(e1, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e26, "WEST", Material.AIR, (byte) 0);
		
		Location M1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z -4);
		Location P1 = new Location(w, x, y, z -8);
		Location DPunt1 = new Location(w, x, y, z -12);
		
		Location G1 = new Location(w, x, y, z -16);
		Location L1 = new Location(w, x, y, z -20);
		Location A2 = new Location(w, x, y, z -24);
		Location D1 = new Location(w, x, y, z -28);
		Location I1 = new Location(w, x, y, z -32);
		Location A3 = new Location(w, x, y, z -36);
		Location T1 = new Location(w, x, y, z -40);
		Location O1 = new Location(w, x, y, z -44);
		Location R1 = new Location(w, x, y, z -48);
		
		Location A4 = new Location(w, x, y, z -54);
		Location R2 = new Location(w, x, y, z -58);
		Location E1 = new Location(w, x, y, z -62);
		Location N1 = new Location(w, x, y, z -66);
		Location A5 = new Location(w, x, y, z -70);
		
		Letters.createM(M1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createA(A1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createP(P1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createDPunt(DPunt1, "WEST", Material.STAINED_CLAY, (byte) 13);
		
		Letters.createG(G1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createL(L1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createD(D1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createI(I1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A3, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createT(T1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createO(O1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createA(A4, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createN(N1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A5, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		
	}
	
	public static void createTheNetherlandsWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z -3);
		Location e3 = new Location(w, x, y, z -6);
		Location e4 = new Location(w, x, y, z -9);
		Location e5 = new Location(w, x, y, z -12);
		Location e6 = new Location(w, x, y, z -15);
		Location e7 = new Location(w, x, y, z -18);
		Location e8 = new Location(w, x, y, z -21);
		Location e9 = new Location(w, x, y, z -24);
		Location e10 = new Location(w, x, y, z -27);
		Location e11 = new Location(w, x, y, z -30);
		Location e12 = new Location(w, x, y, z -33);
		Location e13 = new Location(w, x, y, z -36);
		Location e14 = new Location(w, x, y, z -39);
		Location e15 = new Location(w, x, y, z -42);
		Location e16 = new Location(w, x, y, z -45);
		Location e17 = new Location(w, x, y, z -48);
		Location e18 = new Location(w, x, y, z -51);
		Location e19 = new Location(w, x, y, z -54);
		Location e20 = new Location(w, x, y, z -57);
		Location e21 = new Location(w, x, y, z -60);
		Location e22 = new Location(w, x, y, z -63);
		Location e23 = new Location(w, x, y, z -66);
		Location e24 = new Location(w, x, y, z -69);
		Location e25 = new Location(w, x, y, z -72);
		Location e26 = new Location(w, x, y, z -75);
		
		Letters.createEmpty(e1, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e26, "WEST", Material.AIR, (byte) 0);
		
		Location M1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z -4);
		Location P1 = new Location(w, x, y, z -8);
		Location DPunt1 = new Location(w, x, y, z -12);
		
		Location T1 = new Location(w, x, y, z -16);
		Location H1 = new Location(w, x, y, z -20);
		Location E1 = new Location(w, x, y, z -24);
		
		Location N1 = new Location(w, x, y, z -30);
		Location E2 = new Location(w, x, y, z -34);
		Location T2 = new Location(w, x, y, z -38);
		Location H2 = new Location(w, x, y, z -42);
		Location E3 = new Location(w, x, y, z -46);
		Location R1 = new Location(w, x, y, z -50);
		Location L1 = new Location(w, x, y, z -54);
		Location A2 = new Location(w, x, y, z -58);
		Location N2 = new Location(w, x, y, z -62);
		Location D1 = new Location(w, x, y, z -66);
		Location S1 = new Location(w, x, y, z -70);
		
		Letters.createM(M1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createA(A1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createP(P1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createDPunt(DPunt1, "WEST", Material.STAINED_CLAY, (byte) 13);
		
		Letters.createT(T1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createH(H1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createN(N1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createT(T2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createH(H2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E3, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createL(L1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createN(N2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createD(D1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createS(S1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		
	}
	
	public static void createEstyrWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z -3);
		Location e3 = new Location(w, x, y, z -6);
		Location e4 = new Location(w, x, y, z -9);
		Location e5 = new Location(w, x, y, z -12);
		Location e6 = new Location(w, x, y, z -15);
		Location e7 = new Location(w, x, y, z -18);
		Location e8 = new Location(w, x, y, z -21);
		Location e9 = new Location(w, x, y, z -24);
		Location e10 = new Location(w, x, y, z -27);
		Location e11 = new Location(w, x, y, z -30);
		Location e12 = new Location(w, x, y, z -33);
		Location e13 = new Location(w, x, y, z -36);
		Location e14 = new Location(w, x, y, z -39);
		Location e15 = new Location(w, x, y, z -42);
		Location e16 = new Location(w, x, y, z -45);
		Location e17 = new Location(w, x, y, z -48);
		Location e18 = new Location(w, x, y, z -51);
		Location e19 = new Location(w, x, y, z -54);
		Location e20 = new Location(w, x, y, z -57);
		Location e21 = new Location(w, x, y, z -60);
		Location e22 = new Location(w, x, y, z -63);
		Location e23 = new Location(w, x, y, z -66);
		Location e24 = new Location(w, x, y, z -69);
		Location e25 = new Location(w, x, y, z -72);
		Location e26 = new Location(w, x, y, z -75);
		Location e27 = new Location(w, x, y, z +3);
		Location e28 = new Location(w, x, y, z +6);
		Location e29 = new Location(w, x, y, z +9);
		Location e30 = new Location(w, x, y, z +12);
		Location e31 = new Location(w, x, y, z +15);
		
		Letters.createEmpty(e1, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e26, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e27, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e28, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e29, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e30, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e31, "WEST", Material.AIR, (byte) 0);
		
		Location M1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z -4);
		Location P1 = new Location(w, x, y, z -8);
		Location DPunt1 = new Location(w, x, y, z -12);
		
		Location E1 = new Location(w, x, y, z -16);
		Location S1 = new Location(w, x, y, z -20);
		Location T1 = new Location(w, x, y, z -24);
		Location Y1 = new Location(w, x, y, z -28);
		Location R1 = new Location(w, x, y, z -32);
		
		Letters.createM(M1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createA(A1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createP(P1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createDPunt(DPunt1, "WEST", Material.STAINED_CLAY, (byte) 13);
		
		Letters.createE(E1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createS(S1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createT(T1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createY(Y1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		
	}
	
	public static void createAbraxParkWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z -3);
		Location e3 = new Location(w, x, y, z -6);
		Location e4 = new Location(w, x, y, z -9);
		Location e5 = new Location(w, x, y, z -12);
		Location e6 = new Location(w, x, y, z -15);
		Location e7 = new Location(w, x, y, z -18);
		Location e8 = new Location(w, x, y, z -21);
		Location e9 = new Location(w, x, y, z -24);
		Location e10 = new Location(w, x, y, z -27);
		Location e11 = new Location(w, x, y, z -30);
		Location e12 = new Location(w, x, y, z -33);
		Location e13 = new Location(w, x, y, z -36);
		Location e14 = new Location(w, x, y, z -39);
		Location e15 = new Location(w, x, y, z -42);
		Location e16 = new Location(w, x, y, z -45);
		Location e17 = new Location(w, x, y, z -48);
		Location e18 = new Location(w, x, y, z -51);
		Location e19 = new Location(w, x, y, z -54);
		Location e20 = new Location(w, x, y, z -57);
		Location e21 = new Location(w, x, y, z -60);
		Location e22 = new Location(w, x, y, z -63);
		Location e23 = new Location(w, x, y, z -66);
		Location e24 = new Location(w, x, y, z -69);
		Location e25 = new Location(w, x, y, z -72);
		Location e26 = new Location(w, x, y, z -75);
		Location e27 = new Location(w, x, y, z +3);
		Location e28 = new Location(w, x, y, z +6);
		Location e29 = new Location(w, x, y, z +9);
		
		Letters.createEmpty(e1, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e26, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e27, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e28, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e29, "WEST", Material.AIR, (byte) 0);
		
		Location M1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z -4);
		Location P1 = new Location(w, x, y, z -8);
		Location DPunt1 = new Location(w, x, y, z -12);
		
		Location A2 = new Location(w, x, y, z -16);
		Location B1 = new Location(w, x, y, z -20);
		Location R1 = new Location(w, x, y, z -24);
		Location A3 = new Location(w, x, y, z -28);
		Location X1 = new Location(w, x, y, z -32);
		
		Location P2 = new Location(w, x, y, z -38);
		Location A4 = new Location(w, x, y, z -42);
		Location R2 = new Location(w, x, y, z -46);
		Location K1 = new Location(w, x, y, z -50);
		
		Letters.createM(M1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createA(A1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createP(P1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createDPunt(DPunt1, "WEST", Material.STAINED_CLAY, (byte) 13);
		
		Letters.createA(A2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createB(B1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A3, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createX(X1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createP(P2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A4, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createK(K1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		
	}
	
	public static void createLavaIslandWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z -3);
		Location e3 = new Location(w, x, y, z -6);
		Location e4 = new Location(w, x, y, z -9);
		Location e5 = new Location(w, x, y, z -12);
		Location e6 = new Location(w, x, y, z -15);
		Location e7 = new Location(w, x, y, z -18);
		Location e8 = new Location(w, x, y, z -21);
		Location e9 = new Location(w, x, y, z -24);
		Location e10 = new Location(w, x, y, z -27);
		Location e11 = new Location(w, x, y, z -30);
		Location e12 = new Location(w, x, y, z -33);
		Location e13 = new Location(w, x, y, z -36);
		Location e14 = new Location(w, x, y, z -39);
		Location e15 = new Location(w, x, y, z -42);
		Location e16 = new Location(w, x, y, z -45);
		Location e17 = new Location(w, x, y, z -48);
		Location e18 = new Location(w, x, y, z -51);
		Location e19 = new Location(w, x, y, z -54);
		Location e20 = new Location(w, x, y, z -57);
		Location e21 = new Location(w, x, y, z -60);
		Location e22 = new Location(w, x, y, z -63);
		Location e23 = new Location(w, x, y, z -66);
		Location e24 = new Location(w, x, y, z -69);
		Location e25 = new Location(w, x, y, z -72);
		Location e26 = new Location(w, x, y, z -75);
		Location e27 = new Location(w, x, y, z +3);
		Location e28 = new Location(w, x, y, z +6);
		Location e29 = new Location(w, x, y, z +9);
		
		Letters.createEmpty(e1, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e26, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e27, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e28, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e29, "WEST", Material.AIR, (byte) 0);
		
		Location M1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z -4);
		Location P1 = new Location(w, x, y, z -8);
		Location DPunt1 = new Location(w, x, y, z -12);
		
		Location L1 = new Location(w, x, y, z -16);
		Location A2 = new Location(w, x, y, z -20);
		Location V1 = new Location(w, x, y, z -24);
		Location A3 = new Location(w, x, y, z -28);
		
		Location I1 = new Location(w, x, y, z -34);
		Location S1 = new Location(w, x, y, z -38);
		Location L2 = new Location(w, x, y, z -42);
		Location A4 = new Location(w, x, y, z -46);
		Location N1 = new Location(w, x, y, z -50);
		Location D1 = new Location(w, x, y, z -54);
		
		Letters.createM(M1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createA(A1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createP(P1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createDPunt(DPunt1, "WEST", Material.STAINED_CLAY, (byte) 13);
		
		Letters.createL(L1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createV(V1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A3, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createI(I1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createS(S1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createL(L2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A4, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createN(N1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createD(D1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		
	}
	
	public static void createBreezeIslandWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z -3);
		Location e3 = new Location(w, x, y, z -6);
		Location e4 = new Location(w, x, y, z -9);
		Location e5 = new Location(w, x, y, z -12);
		Location e6 = new Location(w, x, y, z -15);
		Location e7 = new Location(w, x, y, z -18);
		Location e8 = new Location(w, x, y, z -21);
		Location e9 = new Location(w, x, y, z -24);
		Location e10 = new Location(w, x, y, z -27);
		Location e11 = new Location(w, x, y, z -30);
		Location e12 = new Location(w, x, y, z -33);
		Location e13 = new Location(w, x, y, z -36);
		Location e14 = new Location(w, x, y, z -39);
		Location e15 = new Location(w, x, y, z -42);
		Location e16 = new Location(w, x, y, z -45);
		Location e17 = new Location(w, x, y, z -48);
		Location e18 = new Location(w, x, y, z -51);
		Location e19 = new Location(w, x, y, z -54);
		Location e20 = new Location(w, x, y, z -57);
		Location e21 = new Location(w, x, y, z -60);
		Location e22 = new Location(w, x, y, z -63);
		Location e23 = new Location(w, x, y, z -66);
		Location e24 = new Location(w, x, y, z -69);
		Location e25 = new Location(w, x, y, z -72);
		Location e26 = new Location(w, x, y, z -75);
		Location e27 = new Location(w, x, y, z -78);
		Location e28 = new Location(w, x, y, z -81);
		
		
		Location e29 = new Location(w, x, y, z +3);
		Location e30 = new Location(w, x, y, z +6);
		Location e31 = new Location(w, x, y, z +9);
		
		Letters.createEmpty(e1, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e25, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e26, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e27, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e28, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e29, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e30, "WEST", Material.AIR, (byte) 0);
		Letters.createEmpty(e31, "WEST", Material.AIR, (byte) 0);
		
		Location M1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z -4);
		Location P1 = new Location(w, x, y, z -8);
		Location DPunt1 = new Location(w, x, y, z -12);
		
		Location B1 = new Location(w, x, y, z -16);
		Location R1 = new Location(w, x, y, z -20);
		Location E1 = new Location(w, x, y, z -24);
		Location E2 = new Location(w, x, y, z -28);
		Location Z1 = new Location(w, x, y, z -32);
		Location E3 = new Location(w, x, y, z -36);
		
		Location I1 = new Location(w, x, y, z -42);
		Location S1 = new Location(w, x, y, z -46);
		Location L2 = new Location(w, x, y, z -50);
		Location A4 = new Location(w, x, y, z -54);
		Location N1 = new Location(w, x, y, z -58);
		Location D1 = new Location(w, x, y, z -62);
		
		Letters.createM(M1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createA(A1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createP(P1, "WEST", Material.STAINED_CLAY, (byte) 13);
		Letters.createDPunt(DPunt1, "WEST", Material.STAINED_CLAY, (byte) 13);
		
		Letters.createB(B1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createR(R1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createZ(Z1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E3, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createI(I1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createS(S1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createL(L2, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createA(A4, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createN(N1, "WEST", Material.STAINED_CLAY, (byte) 0);
		Letters.createD(D1, "WEST", Material.STAINED_CLAY, (byte) 0);
		
		
	}
	
	public static void createChickenFightWord(Location l){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x, y, z +3);
		Location e3 = new Location(w, x, y, z +6);
		Location e4 = new Location(w, x, y, z +9);
		Location e5 = new Location(w, x, y, z +12);
		Location e6 = new Location(w, x, y, z +15);
		Location e7 = new Location(w, x, y, z +18);
		Location e8 = new Location(w, x, y, z +21);
		Location e9 = new Location(w, x, y, z +24);
		Location e10 = new Location(w, x, y, z +27);
		Location e11 = new Location(w, x, y, z +30);
		Location e12 = new Location(w, x, y, z +33);
		Location e13 = new Location(w, x, y, z +36);
		Location e14 = new Location(w, x, y, z +39);
		Location e15 = new Location(w, x, y, z +42);
		Location e16 = new Location(w, x, y, z +45);
		Location e17 = new Location(w, x, y, z +48);
		Location e18 = new Location(w, x, y, z +51);
		Location e19 = new Location(w, x, y, z +54);
		Location e20 = new Location(w, x, y, z +57);
		Location e21 = new Location(w, x, y, z +60);
		Location e22 = new Location(w, x, y, z +63);
		Location e23 = new Location(w, x, y, z +66);
		Location e24 = new Location(w, x, y, z +69);
		
		Letters.createEmpty(e1, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e20, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e21, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e22, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e23, "EAST", Material.AIR, (byte) 0);
		Letters.createEmpty(e24, "EAST", Material.AIR, (byte) 0);
		
		Location G1 = new Location(w, x, y, z);
		Location A1 = new Location(w, x, y, z +4);
		Location M1 = new Location(w, x, y, z +8);
		Location E1 = new Location(w, x, y, z +12);
		Location DPunt1 = new Location(w, x, y, z +16);
		
		Location C1 = new Location(w, x, y, z +20);
		Location H1 = new Location(w, x, y, z +24);
		Location I1 = new Location(w, x, y, z +28);
		Location C2 = new Location(w, x, y, z +32);
		Location K1 = new Location(w, x, y, z +36);
		Location E2 = new Location(w, x, y, z +40);
		Location N1 = new Location(w, x, y, z +44);

		Location F1 = new Location(w, x, y, z +50);
		Location I2 = new Location(w, x, y, z +54);
		Location G2 = new Location(w, x, y, z +58);
		Location H2 = new Location(w, x, y, z +62);
		Location T1 = new Location(w, x, y, z +66);
		
		Letters.createG(G1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createA(A1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createM(M1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createE(E1, "EAST", Material.STAINED_CLAY, (byte) 14);
		Letters.createDPunt(DPunt1, "EAST", Material.STAINED_CLAY, (byte) 14);
		
		Letters.createC(C1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createH(H1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createI(I1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createC(C2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createK(K1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createE(E2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createN(N1, "EAST", Material.STAINED_CLAY, (byte) 0);
		
		Letters.createF(F1, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createI(I2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createG(G2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createH(H2, "EAST", Material.STAINED_CLAY, (byte) 0);
		Letters.createT(T1, "EAST", Material.STAINED_CLAY, (byte) 0);
		
	}
	
	public static void createCountdownWord(Location l, int i, boolean getCounting){
		
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		Location e1 = new Location(w, x, y, z);
		Location e2 = new Location(w, x +3, y, z);
		Location e3 = new Location(w, x +6, y, z);
		Location e4 = new Location(w, x +9, y, z);
		Location e5 = new Location(w, x +12, y, z);
		Location e6 = new Location(w, x +15, y, z);
		Location e7 = new Location(w, x +18, y, z);
		Location e8 = new Location(w, x +21, y, z);
		Location e9 = new Location(w, x +24, y, z);
		Location e10 = new Location(w, x +27, y, z);
		Location e11 = new Location(w, x +30, y, z);
		Location e12 = new Location(w, x +33, y, z);
		Location e13 = new Location(w, x +36, y, z);
		Location e14 = new Location(w, x +39, y, z);
		Location e15 = new Location(w, x +42, y, z);
		Location e16 = new Location(w, x +45, y, z);
		Location e17 = new Location(w, x +48, y, z);
		Location e18 = new Location(w, x +51, y, z);
		Location e19 = new Location(w, x +54, y, z);
		
		Letters.createEmpty(e1, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e2, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e3, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e4, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e5, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e6, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e7, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e8, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e9, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e10, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e11, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e12, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e13, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e14, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e15, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e16, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e17, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e18, "NORTH", Material.AIR, (byte) 0);
		Letters.createEmpty(e19, "NORTH", Material.AIR, (byte) 0);
		
		if(getCounting == false){
			
			Location W1 = new Location(w, x +8, y, z);
			Location A1 = new Location(w, x +12, y, z);
			Location I1 = new Location(w, x +16, y, z);
			Location T1 = new Location(w, x +20, y, z);
			Location I2 = new Location(w, x +24, y, z);
			Location N1 = new Location(w, x +28, y, z);
			Location G1 = new Location(w, x +32, y, z);
			
			Letters.createW(W1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createA(A1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createI(I1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createT(T1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createI(I2, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createN(N1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createG(G1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			
		}
		else{
			
			Location S1 = new Location(w, x, y, z);
			Location T1 = new Location(w, x +4, y, z);
			Location A1 = new Location(w, x +8, y, z);
			Location R1 = new Location(w, x +12, y, z);
			Location T2 = new Location(w, x +16, y, z);
			Location I1 = new Location(w, x +20, y, z);
			Location N1 = new Location(w, x +24, y, z);
			Location G1 = new Location(w, x +28, y, z);
			
			Location I2 = new Location(w, x +34, y, z);
			Location N2 = new Location(w, x +38, y, z);
			
			Letters.createS(S1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createT(T1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createA(A1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createR(R1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createT(T2, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createI(I1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createN(N1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createG(G1, "NORTH", Material.STAINED_CLAY, (byte) 0);
			
			Letters.createI(I2, "NORTH", Material.STAINED_CLAY, (byte) 0);
			Letters.createN(N2, "NORTH", Material.STAINED_CLAY, (byte) 0);
			if(i <= 9){
				Location DOT1 = new Location(w, x +46, y, z);
				Location DOT2 = new Location(w, x +48, y, z);
				Location DOT3 = new Location(w, x +50, y, z);
				
				Letters.createDOT(DOT1, "NORTH", Material.STAINED_CLAY, (byte) 0);
				Letters.createDOT(DOT2, "NORTH", Material.STAINED_CLAY, (byte) 0);
				Letters.createDOT(DOT3, "NORTH", Material.STAINED_CLAY, (byte) 0);
			
			}
			else{
				Location DOT1 = new Location(w, x +50, y, z);
				Location DOT2 = new Location(w, x +52, y, z);
				Location DOT3 = new Location(w, x +54, y, z);
				
				Letters.createDOT(DOT1, "NORTH", Material.STAINED_CLAY, (byte) 0);
				Letters.createDOT(DOT2, "NORTH", Material.STAINED_CLAY, (byte) 0);
				Letters.createDOT(DOT3, "NORTH", Material.STAINED_CLAY, (byte) 0);
			}
			if(i == 0){
				Location n1 = new Location(w, x +44, y, z);
				
				Letters.create0(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 1){
				Location n1 = new Location(w, x +44, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 2){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 3){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 4){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 5){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 6){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create6(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 7){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create7(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 8){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create8(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 9){
			Location n1 = new Location(w, x +44, y, z);
				
				Letters.create9(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 10){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create0(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 11){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create1(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 12){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create2(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 13){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create3(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 14){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create4(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 15){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create5(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 16){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create6(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 17){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create7(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 18){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create8(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 19){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create1(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create9(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 20){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create0(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 21){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create1(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 22){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create2(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 23){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create3(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 24){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create4(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 25){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create5(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 26){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create6(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 27){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create7(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 28){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create8(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 29){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create2(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create9(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 30){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create0(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 31){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create1(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 32){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create2(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 33){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create3(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 34){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create4(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 35){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create5(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 36){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create6(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 37){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create7(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 38){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create8(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 39){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create3(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create9(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 40){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create0(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 41){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create1(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 42){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create2(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 43){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create3(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 44){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create4(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 45){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create5(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 46){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create6(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 47){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create7(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 48){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create8(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 49){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create4(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create9(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 50){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create0(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 51){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create1(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 52){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create2(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 53){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create3(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 54){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create4(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 55){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create5(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 56){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create6(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 57){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create7(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 58){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create8(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 59){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create5(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create9(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
			if(i == 60){
				Location n1 = new Location(w, x +44, y, z);
				Location n2 = new Location(w, x +48, y, z);
				
				Letters.create6(n1, "NORTH", Material.STAINED_CLAY, (byte) 4);
				Letters.create0(n2, "NORTH", Material.STAINED_CLAY, (byte) 4);
			}
		}
	}
}
