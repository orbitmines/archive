package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

import java.net.InetSocketAddress;

import me.O_o_Fadi_o_O.OrbitMinesBungee.Start;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.connection.InitialHandler;
import net.md_5.bungee.netty.HandlerBoss;
import net.md_5.bungee.netty.PipelineUtils;
import net.md_5.bungee.protocol.KickStringWriter;
import net.md_5.bungee.protocol.LegacyDecoder;
import net.md_5.bungee.protocol.MinecraftDecoder;
import net.md_5.bungee.protocol.MinecraftEncoder;
import net.md_5.bungee.protocol.Protocol;

public final class ConnectionReplacement extends ChannelInitializer<Channel> {

	private final Start plugin;
	private static final String NETTY_LISTENER_NAME = "packet-interception";

	public ConnectionReplacement(Start plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void initChannel(Channel ch) throws Exception {
		if(BungeeCord.getInstance().getConnectionThrottle().throttle(((InetSocketAddress) ch.remoteAddress()).getAddress())){
			// throttling should actually be done here but for some reason
			// BungeeCord no longer has a working throttle
		}
		PipelineUtils.BASE.initChannel(ch);

		ch.pipeline().addBefore(PipelineUtils.FRAME_DECODER, PipelineUtils.LEGACY_DECODER, new LegacyDecoder());
		ch.pipeline().addAfter(PipelineUtils.FRAME_DECODER, PipelineUtils.PACKET_DECODER, new MinecraftDecoder(Protocol.HANDSHAKE, true, ProxyServer.getInstance().getProtocolVersion()));
		ch.pipeline().addAfter(PipelineUtils.FRAME_PREPENDER, PipelineUtils.PACKET_ENCODER, new MinecraftEncoder(Protocol.HANDSHAKE, true, ProxyServer.getInstance().getProtocolVersion()));
		ch.pipeline().addAfter(PipelineUtils.PACKET_DECODER, NETTY_LISTENER_NAME, new NettyDecoder(this.plugin, ((InetSocketAddress) ch.remoteAddress()).getAddress()));
		ch.pipeline().addBefore(PipelineUtils.FRAME_PREPENDER, PipelineUtils.LEGACY_KICKER, new KickStringWriter());
		ch.pipeline().get(HandlerBoss.class).setHandler(new InitialHandler(ProxyServer.getInstance(), ch.attr(PipelineUtils.LISTENER).get()));
	}
}
