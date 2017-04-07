package com.laurenshup.superapi.builders;

import com.laurenshup.superapi.builders.inventory.InventoryEvent;
import com.laurenshup.superapi.message.Message;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

/**
 * Create your own inventory events with this handy builder
 *
 * @author Laurenshup
 */
public class InventoryEventBuilder {
    
    private Set<Message> messages = new HashSet<>();
    private Set<String> commands = new HashSet<>();
    private Inventory inventory;
    private Location location;
    
    /**
     * Adds a message to the event that will run
     *
     * @param message the message that will be runed
     * @return the new instance of the builder
     */
    public InventoryEventBuilder sendMessage(String message) {
        messages.add(new MessageBuilder().addString(message).build());
        return this;
    }
    
    /**
     * Adds a message to the event that will run
     *
     * @param message the message that will be runed
     * @return the new instance of the builder
     */
    public InventoryEventBuilder sendMessage(Message message) {
        messages.add(message);
        return this;
    }
    
    /**
     * Adds a command to the event that will run
     *
     * @param command the command that will be runed
     * @return the new instance of the builder
     */
    public InventoryEventBuilder runCommand(String command) {
        commands.add(command);
        return this;
    }
    
    /**
     * Adds a inventory to the event that will open
     *
     * @param inventory the inventory that will be opened
     * @return the new instance of the builder
     */
    public InventoryEventBuilder openInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }
    
    /**
     * Adds a teleport to the event
     *
     * @param location the teleport location
     * @return the new instance of the builder
     */
    public InventoryEventBuilder teleport(Location location) {
        this.location = location;
        return this;
    }
    
    /**
     * Creates a inventory event
     *
     * @return the created event
     */
    public InventoryEvent build() {
        InventoryEvent event = new InventoryEvent();
        for(Message message : messages) {
            event.sendMessage(message);
        }
        for(String command : commands) {
            event.sendMessage(command);
        }
        if(inventory!=null) {
            event.openInventory(inventory);
        }
        if(location!=null) {
            event.teleport(location);
        }
        return event;
    }
    
}
