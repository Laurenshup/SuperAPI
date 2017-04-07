package com.laurenshup.superapi.events.party;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.laurenshup.superapi.party.Party;

/**
 * This is the event for when a plugin joined a player to a party.
 * 
 * @author Laurenshup
 */
public class PartyPlayerJoinEvent extends Event implements Cancellable {
	
	private Party party;
	private Player player;
	private boolean cancelled = false;
	
	/**
	 * @param party the party where the player joined in
	 * @param player the joined player
	 */
	public PartyPlayerJoinEvent(Party party, Player player) {
		this.party = party;
		this.player = player;
	}
	
	/**
	 * Gives the party.
	 * 
	 * @return the party where the player joined in
	 */
	public Party getParty() {
		return party;
	}
	
	/**
	 * Gives the player.
	 * 
	 * @return the joined player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * (non-Javadoc)
	 * @see org.bukkit.event.Cancellable#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * (non-Javadoc)
	 * @see org.bukkit.event.Cancellable#setCancelled(boolean)
	 */
	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
