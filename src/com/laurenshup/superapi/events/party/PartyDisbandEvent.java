package com.laurenshup.superapi.events.party;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.laurenshup.superapi.party.Party;

/**
 * This is the event for when a plugin disbanded the party.
 * 
 * @author Laurenshup
 */
public class PartyDisbandEvent extends Event implements Cancellable {
	
	private Party party;
	private boolean cancelled = false;
	
	/**
	 * @param party the disbanded party
	 */
	public PartyDisbandEvent(Party party) {
		this.party = party;
	}
	
	/**
	 * Gives the party
	 * 
	 * @return the disbanded party
	 */
	public Party getParty() {
		return party;
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
