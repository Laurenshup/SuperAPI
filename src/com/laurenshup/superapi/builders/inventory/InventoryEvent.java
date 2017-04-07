package com.laurenshup.superapi.builders.inventory;

import com.laurenshup.superapi.builders.MessageBuilder;
import com.laurenshup.superapi.message.Message;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

/**
 * A event to run events in inventories
 *
 * @author Laurenshup
 */
public class InventoryEvent {
	
	private Set<Message> messages = new HashSet<>();
	private Set<String> commands = new HashSet<>();
	private Inventory inventory;
	private Location location;
    
    /**
     * Adds a message to the event that will run
     *
     * @param message the message that will be runed
     */
	public void sendMessage(String message) {
		messages.add(new MessageBuilder().addString(message).build());
	}
    
    /**
     * Adds a message to the event that will run
     *
     * @param message the message that will be runed
     */
	public void sendMessage(Message message) {
		messages.add(message);
	}
    
    /**
     * Adds a command to the event that will run
     *
     * @param command the command that will be runed
     */
	public void runCommand(String command) {
		commands.add(command);
	}
    
    /**
     * Adds a inventory to the event that will open
     *
     * @param inventory the inventory that will be opened
     */
	public void openInventory(Inventory inventory) {
		this.inventory = inventory;
	}
    
    /**
     * Adds a teleport to the event
     *
     * @param location the teleport location
     */
	public void teleport(Location location) {
		this.location = location;
	}
    
    /**
     * Runs this event for a certain player
     *
     * @param player the player the event will run on
     */
	public void run(Player player) {
		for(Message message : messages) {
			player.spigot().sendMessage(ChatMessageType.CHAT, message.getComponent());
		}
		for(String command : commands) {
			player.performCommand(command);
		}
		if(inventory!=null) {
			player.openInventory(inventory);
		}
		if(location!=null) {
			player.teleport(location);
		}
	}

}
