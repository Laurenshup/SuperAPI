package com.laurenshup.superapi;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

/**
 * This is your SuperAPI's PlayerManager.
 * 
 * @author Laurenshup
 */
public class PlayerManager implements Listener {
	
	private Plugin plugin;
	private Set<Player> online = new HashSet<>();
	
	protected PlayerManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Disables the given player from leaving.
	 * Sometimes this wouldn't work because players can close their Minecraft directly.
	 * This is a little bit buggy. Don't use it when you don't have to.
	 * 
	 * @param player the player to disable his leaving
	 */
	public void disableQuit(Player player) {
		online.add(player);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		final Player player = event.getPlayer();
		if(online.contains(player)) {
			World already = player.getWorld();
			World world = plugin.getServer().getWorlds().get(0);
			if(world.getUID().equals(already.getUID())) {
				world = plugin.getServer().getWorlds().get(1);
			}
			final Location location = player.getLocation();
			Location teleport = new Location(world, 0, 80, 0);
			player.teleport(teleport);
			plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
				public void run() {
					player.teleport(location);
				}
			}, 1);
		}
	}

}
