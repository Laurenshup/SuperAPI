package com.laurenshup.superapi.builders;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Create locations with this handy builder.
 * 
 * @author Laurenshup
 */
public class LocationBuilder {
	
	private World world;
	private double x;
	private double y;
	private double z;
	private float yaw = 0f;
	private float pitch = 0f;
	
	public LocationBuilder() {};
	
	/**
	 * @param location start with the given location
	 */
	public LocationBuilder(Location location) {
		world = location.getWorld();
		x = location.getX();
		y = location.getY();
		z = location.getZ();
		yaw = location.getYaw();
		pitch = location.getPitch();
	}
	
	/**
	 * @param locationstring start with the given locationstring
	 */
	public LocationBuilder(String locationstring) {
		String[] split = locationstring.split(";");
		world = Bukkit.getWorld(UUID.fromString(split[0]));
		x = Double.parseDouble(split[1]);
		y = Double.parseDouble(split[2]);
		z = Double.parseDouble(split[3]);
		yaw = Float.parseFloat(split[4]);
		pitch = Float.parseFloat(split[5]);
	}
	
	/**
	 * Sets a whole new location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		world = location.getWorld();
		x = location.getX();
		y = location.getY();
		z = location.getZ();
		yaw = location.getYaw();
		pitch = location.getPitch();
	}
	
	/**
	 * Sets the world.
	 * 
	 * @param name the world's name
	 */
	public void setWorld(String name) {
		world = Bukkit.getWorld(name);
	}
	
	/**
	 * Sets the world.
	 * 
	 * @param id the world's id
	 */
	public void setWorld(UUID id) {
		world = Bukkit.getWorld(id);
	}
	
	/**
	 * Sets the x coordinate.
	 * 
	 * @param x the x coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate.
	 * 
	 * @param y the y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Sets the z coordinate.
	 * 
	 * @param z the z coordinate
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Sets the yaw.
	 * 
	 * @param yaw the yaw
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
	
	/**
	 * Sets the pitch.
	 * 
	 * @param pitch the pitch
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
	
	/**
	 * Builds the location.
	 * 
	 * @return the builded location
	 */
	public Location buildLocation() {
		return new Location(world, x, y, z, yaw, pitch);
	}
	
	/**
	 * Builds the location as string.
	 * This is useful to save it in files.
	 * You can create a new LocationBuilder with a location string.
	 * 
	 * @return the builded location string
	 */
	public String buildString() {
		String string = world.getUID() + ";" + x + ";" + y + ";" + z + ";" + yaw + ";" + pitch;
		return string;
	}

}
