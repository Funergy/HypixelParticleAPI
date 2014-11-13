package com.funergy.particleapi.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
 
public class ParticleUtils {
 
	private static String version = "";
 
	static Object packet;
 
	private static Method getHandle;
	private static Method sendPacket;
	private static Field playerConnection;
 
	private static Class<?> packetType;
	static {
		try {
 
			version = Bukkit.getServer().getClass().getPackage().getName()
					.split("\\.")[3];
 
			packetType = Class.forName(getPacketPlayOutParticles());
 
			Class<?> typeCraftPlayer = Class.forName(getCraftPlayerClasspath());
			Class<?> typeNMSPlayer = Class.forName(getNMSPlayerClasspath());
			Class<?> typePlayerConnection = Class
					.forName(getPlayerConnectionClasspath());
 
			getHandle = typeCraftPlayer.getMethod("getHandle");
			playerConnection = typeNMSPlayer.getField("playerConnection");
			sendPacket = typePlayerConnection.getMethod("sendPacket",
					Class.forName(getPacketClasspath()));
		} catch (Exception e) {
			System.out
					.println("Failed to setup reflection for PacketPlayOutWorldParticles");
			e.printStackTrace();
		}
	}
 
	private static void setField(String field, Object value)
			throws NoSuchFieldException, IllegalAccessException {
		Field f = packet.getClass().getDeclaredField(field);
		f.setAccessible(true);
		f.set(packet, value);
 
	}
 
	// Particle Effects
	public static void spawnParticles(double x,double y,double z, Player receivingPacket,
			String packetname, int amount) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException,
			NoSuchMethodException, NoSuchFieldException,
			IllegalArgumentException, InvocationTargetException {
 
		packet = packetType.newInstance();
		setField("a", packetname); // Particle name
		setField("b",(float) x); // Block X
		setField("c",(float) y); // Block Y
		setField("d",(float) z); // Block Z
		setField("e", 0); // Random X Offset
		setField("f", 0); // Random Y Offset
		setField("g", 0); // Random Z Offset
		setField("h", 0); // Speed/data of particles
		setField("i", amount); // Amount of particles
 
		Object player = getHandle.invoke(receivingPacket);
 
		Object connection = playerConnection.get(player);
 
		sendPacket.invoke(connection, packet);
	}
 
	private static String getCraftPlayerClasspath() {
		return "org.bukkit.craftbukkit." + version + ".entity.CraftPlayer";
	}
 
	private static String getPlayerConnectionClasspath() {
		return "net.minecraft.server." + version + ".PlayerConnection";
	}
 
	private static String getNMSPlayerClasspath() {
		return "net.minecraft.server." + version + ".EntityPlayer";
	}
 
	private static String getPacketClasspath() {
		return "net.minecraft.server." + version + ".Packet";
	}
 
	private static String getPacketPlayOutParticles() {
		if (Integer.valueOf(version.split("_")[1]) < 7
				&& Integer.valueOf(version.toLowerCase().split("_")[0].replace(
						"v", "")) == 1) {
			return "net.minecraft.server." + version
					+ ".Packet63WorldParticles";
		} else {
			return "net.minecraft.server." + version
					+ ".PacketPlayOutWorldParticles";
		}
	}
}
