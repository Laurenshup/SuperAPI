package com.laurenshup.superapi.events.party;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.laurenshup.superapi.party.Party;

/**
 * This is the event for when a plugin teleports the party.
 * 
 * @author Laurenshup
 */
public class PartyWarpEvent extends Event implements Cancellable {
	
	private Party party;
	private Location location;
	private boolean cancelled = false;
	
	/**
	 * @param party the teleported party
	 * @param location the teleport location
	 */
	public PartyWarpEvent(Party party, Location location) {
		this.party = party;
		this.location = location;
	}
	
	/**
	 * Gives the party
	 * 
	 * @return the teleported party
	 */
	public Party getParty() {
		return party;
	}
	
	/**
	 * Gives the location
	 * 
	 * @return the teleport location
	 */
	public Location getLocation() {
		return location;
	}
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

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
