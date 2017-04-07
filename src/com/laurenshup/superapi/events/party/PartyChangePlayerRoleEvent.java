package com.laurenshup.superapi.events.party;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.laurenshup.superapi.party.Party;
import com.laurenshup.superapi.party.PartyRole;

/**
 * This is the event for when a plugin changed a player's party role.
 * 
 * @author Laurenshup
 */
public class PartyChangePlayerRoleEvent extends Event implements Cancellable {
	
	private Party party;
	private Player player;
	private PartyRole oldrole;
	private PartyRole newrole;
	private boolean cancelled = false;
	
	/**
	 * @param party the party where the player changed its role
	 * @param player the player what changed its role
	 * @param oldrole the player's old role
	 * @param newrole the player's new role
	 */
	public PartyChangePlayerRoleEvent(Party party, Player player, PartyRole oldrole, PartyRole newrole) {
		this.party = party;
		this.player = player;
		this.oldrole = oldrole;
		this.newrole = newrole;
	}
	
	/**
	 * Gives the party.
	 * 
	 * @return the party where the player changed its role
	 */
	public Party getParty() {
		return party;
	}
	
	/**
	 * Gives the player.
	 * 
	 * @return the player what changed its role
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Gives the old role.
	 * 
	 * @return the player's old role
	 */
	public PartyRole getOldRole() {
		return oldrole;
	}
	
	/**
	 * Gives the new role.
	 * 
	 * @return the player's new role
	 */
	public PartyRole getNewRole() {
		return newrole;
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
