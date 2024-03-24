package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.net.InetAddress;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.DefaultPingManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.PingManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import net.md_5.bungee.protocol.PacketWrapper;
import net.md_5.bungee.protocol.packet.Handshake;
import net.md_5.bungee.protocol.packet.PingPacket;
import net.md_5.bungee.protocol.packet.StatusRequest;
import net.md_5.bungee.protocol.packet.StatusResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class NettyDecoder extends MessageToMessageDecoder<PacketWrapper> {

	private final Start plugin;
	private StatusListener statusListener;
	private long previousTime = System.currentTimeMillis();
	private ChannelHandlerContext ctx;
	private ScheduledTask task;
	private boolean isPing = false;
	private final long startTime;
	private long requestedProtocol = -1;
	private boolean respondPing = false;

	public NettyDecoder(Start plugin, InetAddress adress) {
		this.plugin = plugin;
		this.startTime = System.currentTimeMillis();
		try {
			this.statusListener = PingManager.getPingManager().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		task = ProxyServer.getInstance().getScheduler().schedule(this.plugin, new Runnable() {

			@Override
			public void run() {
				if (!isPing) {
					task.cancel();
				}
				if ((System.currentTimeMillis() - previousTime) > 10000) {
					if (isPing) {
						ctx.close();
					}
					task.cancel();
				}
			}
		}, 15L, 15L, TimeUnit.SECONDS);
	}

	@Override
	protected void decode(final ChannelHandlerContext ctx, PacketWrapper packet, List<Object> out) throws Exception {
		this.previousTime = System.currentTimeMillis();
		this.ctx = ctx;
		if (packet == null || packet.packet == null) {
			out.add(packet);
			return;
		}
		if (packet.packet instanceof Handshake) {
			Handshake packett = (Handshake) packet.packet;
			this.requestedProtocol = packett.getProtocolVersion();
		}
		if (packet.packet instanceof PingPacket) {
			if (respondPing) {
				ctx.pipeline().writeAndFlush(new PingPacket(((PingPacket) packet.packet).getTime()));
				ctx.close();
				return;
			}
			if ((System.currentTimeMillis() - startTime) > (PingManager.getStopAfter() * 1000)) {
				final ServerData data = this.statusListener.update();

				JsonObject version = new JsonObject();
				if(Start.maintenancemode == false){
					version.addProperty("name", "§7" + ProxyServer.getInstance().getOnlineCount() + "§8/§7" + (ProxyServer.getInstance().getOnlineCount() +1));
					version.addProperty("protocol", requestedProtocol);
				}
				else{
					version.addProperty("name", "§d§lMaintenance Mode");
					version.addProperty("protocol", 1);
				}

				JsonArray playerArray = new JsonArray();
				for (String playerName : data.getPlayers()) {
					JsonObject playerObject = new JsonObject();
					playerObject.addProperty("name", playerName);
					playerObject.addProperty("id", UUID.randomUUID().toString());
					playerArray.add(playerObject);
				}

				JsonObject countData = new JsonObject();
				countData.addProperty("max", ProxyServer.getInstance().getOnlineCount() +1);
				countData.addProperty("online", ProxyServer.getInstance().getOnlineCount());
				countData.add("sample", playerArray);

				JsonObject jsonObject = new JsonObject();
				jsonObject.add("version", version);
				jsonObject.add("players", countData);
				jsonObject.addProperty("description", DefaultPingManager.getNormalMessage());

				if (data.getFavicon() != null) {
					jsonObject.addProperty("favicon", data.getFavicon());
				}
				ctx.pipeline().writeAndFlush(new StatusResponse(jsonObject.toString()));
				respondPing = true;
			} else {
				final ServerData data = this.statusListener.update();
				this.isPing = true;
				ProxyServer.getInstance().getScheduler().schedule(this.plugin, new Runnable() {

					@Override
					public void run() {
						ctx.pipeline().writeAndFlush((new StatusResponse(buildResponseJSON())));
					}
				}, data.getSleepMillis(), TimeUnit.MILLISECONDS);
			}
		} else if (packet.packet instanceof StatusRequest) {
			ctx.pipeline().writeAndFlush(new StatusResponse(buildResponseJSON()));
		} else {
			out.add(packet);
		}
	}

	private String buildResponseJSON() {
		final ServerData data = this.statusListener.update();
		JsonObject version = new JsonObject();
		if(Start.maintenancemode == false){
			version.addProperty("name", "§7" + ProxyServer.getInstance().getOnlineCount() + "§8/§7" + (ProxyServer.getInstance().getOnlineCount() +1));
			version.addProperty("protocol", 1);
		}
		else{
			version.addProperty("name", "§d§lMaintenance Mode");
			version.addProperty("protocol", 1);
		}
	
		JsonArray playerArray = new JsonArray();
		for (String playerName : data.getPlayers()) {
			JsonObject playerObject = new JsonObject();
			playerObject.addProperty("name", playerName);
			playerObject.addProperty("id", UUID.randomUUID().toString());
			playerArray.add(playerObject);
		}
	
		JsonObject countData = new JsonObject();
		countData.addProperty("max", ProxyServer.getInstance().getOnlineCount() +1);
		countData.addProperty("online", ProxyServer.getInstance().getOnlineCount());
		countData.add("sample", playerArray);
	
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("version", version);
		jsonObject.add("players", countData);
		jsonObject.addProperty("description", data.getMotd());
	
		if (data.getFavicon() != null) {
			jsonObject.addProperty("favicon", data.getFavicon());
		}		
		return jsonObject.toString();
	}
}
