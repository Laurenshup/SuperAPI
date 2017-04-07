package com.laurenshup.superapi.party;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.laurenshup.superapi.events.party.PartyChangePlayerRoleEvent;
import com.laurenshup.superapi.events.party.PartyDisbandEvent;
import com.laurenshup.superapi.events.party.PartyPlayerJoinEvent;
import com.laurenshup.superapi.events.party.PartyPlayerQuitEvent;
import com.laurenshup.superapi.events.party.PartyWarpEvent;

/**
 * This is the class for a party.
 * 
 * @author Laurenshup
 */
public class Party {
	
	private UUID id;
	private HashMap<Player, PartyRole> players = new HashMap<>();
	
	/**
	 * @param id the custom id for the party
	 */
	public Party(UUID id) {
		this.id = id;
		update();
	}
	
	/**
	 * Gets the party's id.
	 * 
	 * @return the party's id
	 */
	public UUID getPartyID() {
		return id;
	}
	
	/**
	 * Adds a player to the party.
	 * This will run the {@link com.laurenshup.superapi.events.party.PartyPlayerJoinEvent} event.
	 * 
	 * @param player the player to add to the party
	 */
	public void addPlayer(Player player) {
		PartyPlayerJoinEvent event = new PartyPlayerJoinEvent(this, player);
		if(!event.isCancelled()) {
			players.put(player, PartyRole.MEMBER);
			update();
		}
	}
	
	/**
	 * Removes a player of the party.
	 * This will run the {@link com.laurenshup.superapi.events.party.PartyPlayerQuitEvent} event.
	 * 
	 * @param player the player to add to the party
	 */
	public void removePlayer(Player player) {
		if(players.containsKey(player)) {
			PartyPlayerQuitEvent event = new PartyPlayerQuitEvent(this, player);
			if(!event.isCancelled()) {
				players.remove(player);
				update();
			}
		}
	}
	
	/**
	 * Gets all players in the party as a set
	 * 
	 * @return all players in the party
	 */
	public Set<Player> getPlayers() {
		return players.keySet();
	}
	
	/**
	 * Gets the player's party role.
	 * 
	 * @param player the player to get the role of
	 * @return the party role of the given player
	 */
	public PartyRole getPlayerPartyRole(Player player) {
		return players.get(player);
	}
	
	/**
	 * Changes the player's party role.
	 * This will run the {@link com.laurenshup.superapi.events.party.PartyChangePlayerRoleEvent} event.
	 * 
	 * @param player the player to change the role of
	 * @param role the role to change it to
	 */
	public void setPlayerPartyRole(Player player, PartyRole role) {
		if(players.containsKey(player)) {
			PartyRole oldrole = players.get(player);
			PartyChangePlayerRoleEvent event = new PartyChangePlayerRoleEvent(this, player, oldrole, role);
			if(!event.isCancelled()) {
				players.remove(player);
				players.put(player, role);
				update();
			}
		}
	}
	
	/**
	 * Warps the party.
	 * This will run the {@link com.laurenshup.superapi.events.party.PartyWarpEvent} event.
	 * 
	 * @param location the location to warp the party to
	 */
	public void warpParty(Location location) {
		PartyWarpEvent event = new PartyWarpEvent(this, location);
		if(!event.isCancelled()) {
			for(Player player : players.keySet()) {
				player.teleport(location);
			}
		}
	}
	
	/**
	 * Disbands the party.
	 * This will run the {@link com.laurenshup.superapi.events.party.PartyDisbandEvent} event.
	 */
	public void disbandParty() {
		PartyDisbandEvent event = new PartyDisbandEvent(this);
		if(!event.isCancelled()) {
			players.clear();
			PartyRegister.parties.remove(this);
		}
	}
	
	private void update() {
		for(Party party : PartyRegister.parties) {
			if(party.getPartyID().equals(getPartyID())) {
				PartyRegister.parties.remove(party);
			}
		}
		PartyRegister.parties.add(this);
	}

}
