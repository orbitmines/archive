package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class ServerData {

	private String favicon;
	private final int sleepTime;
	private final String format;
	private final List<String> players;
	private String motd;

	public ServerData(String motd, BufferedImage pngIcon, int sleepTime, String format, List<String> players) {
		this.players = players;
		this.sleepTime = sleepTime;
		this.format = format;
		this.motd = motd;
		
		if (pngIcon != null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				if (pngIcon.getWidth() == 64 && pngIcon.getHeight() == 64) {
					ImageIO.write(pngIcon, "png", baos);
					baos.flush();
					this.favicon = "data:image/png;base64," + DatatypeConverter.printBase64Binary(baos.toByteArray());
				} else {
					throw new RuntimeException("Your server-icon.png needs to be 64*64!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getMotd() {
		return motd;
	}

	public String getFavicon() {
		return favicon;
	}

	public int getSleepMillis() {
		return sleepTime;
	}

	public String getFormat() {
		return format;
	}

	public List<String> getPlayers() {
		return players;
	}
}
