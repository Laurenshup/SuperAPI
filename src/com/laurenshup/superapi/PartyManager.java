package com.laurenshup.superapi;

import com.laurenshup.superapi.party.Party;
import com.laurenshup.superapi.party.PartyRegister;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

/**
 * This is your SuperAPI's PartyManager.
 * 
 * @author Laurenshup
 */
public class PartyManager {
	
	@SuppressWarnings("unused")
	private Plugin plugin;
	
	protected PartyManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Gives a set of all registered parties.
	 * 
	 * @return a set of all registered parties
	 */
	public Set<Party> getParties() {
		return PartyRegister.getParties();
	}
	
	/**
	 * Creates a new party and registers it.
	 * 
	 * @return the created party
	 */
	public Party createParty() {
		UUID id = getUUID(UUID.randomUUID());
		Party party = new Party(id);
		return party;
	}
	
	private UUID getUUID(UUID id) {
		boolean already = false;
		for(Party party : getParties()) {
			if(party.getPartyID().equals(id)) {
				already = true;
				break;
			}
		}
		if(already) {
			return getUUID(UUID.randomUUID());
		} else {
			return id;
		}
	}
	
	/**
	 * Gives a party by its id.
	 * 
	 * @param id the party's id to get the party for
	 * @return the found party of the id
	 */
	public Party getParty(UUID id) {
		for(Party party : getParties()) {
			if(party.getPartyID().equals(id)) {
				return party;
			}
		}
		return null;
	}
	
	/**
	 * Gives the party of a player.
	 * Null if the player is not in a party
	 * 
	 * @param player the player to get the party for
	 * @return the found party of the player
	 */
	public Party getPartyByPlayer(Player player) {
		for(Party party : getParties()) {
			if(party.getPlayers().contains(player)) {
				return party;
			}
		}
		return null;
	}

}
