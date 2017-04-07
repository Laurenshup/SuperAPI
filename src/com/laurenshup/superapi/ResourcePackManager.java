package com.laurenshup.superapi;

import com.laurenshup.superapi.party.Party;
import com.laurenshup.superapi.resourcepack.ResourcePack;
import com.laurenshup.superapi.resourcepack.ResourcePackStatus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Set;

/**
 * This is your SuperAPI's ResourcePackManager.
 * 
 * @author Laurenshup
 */
public class ResourcePackManager implements Listener {
	
	private Plugin plugin;
	private HashMap<Player, ResourcePackStatus> status = new HashMap<Player, ResourcePackStatus>();
	
	protected ResourcePackManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Gives the given resourcepack to the given player.
	 * 
	 * @param player the player to give the resourcepack to
	 * @param pack the resourcepack to give
	 */
	public void setResourcePack(Player player, ResourcePack pack) {
		player.setResourcePack(pack.getPath());
	}
	
	/**
	 * Gives the given resourcepack to the given players.
	 * 
	 * @param players the players to give the resourcepack to
	 * @param pack the resourcepack to give
	 */
	public void setResourcePackToPlayers(Set<Player> players, ResourcePack pack) {
		for(Player player : players) {
			player.setResourcePack(pack.getPath());
		}
	}
	
	/**
	 * Gives the given resourcepack to the party's players.
	 * 
	 * @param party the party's players to give the resourcepack to
	 * @param pack the resourcepack to give
	 */
	public void setResourcePackToParty(Party party, ResourcePack pack) {
		for(Player player : party.getPlayers()) {
			player.setResourcePack(pack.getPath());
		}
	}
	
	/**
	 * Gives the given resourcepack to all players.
	 * 
	 * @param pack the resourcepack to give
	 */
	public void setResourcePackToAll(ResourcePack pack) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.setResourcePack(pack.getPath());
		}
	}
	
	/**
	 * Gets the resourcepack status of the selected player.
	 * If there is no valid status then the status will be WAITING.
	 * 
	 * @param player the player to get the status of
	 * @return the resourcepack status of the given player
	 */
	public ResourcePackStatus getResourcePackStatus(Player player) {
		if(status.containsKey(player)) {
			return status.get(player);
		} else {
			return ResourcePackStatus.WAITING;
		}
	}
	
	@EventHandler
	public void onResourcePackUpdate(PlayerResourcePackStatusEvent event) {
		Player player = event.getPlayer();
		if(status.containsKey(player)) {
			status.remove(player);
		}
		ResourcePackStatus packstatus = ResourcePackStatus.valueOf(event.getStatus().toString());
		status.put(player, packstatus);
	}

}
