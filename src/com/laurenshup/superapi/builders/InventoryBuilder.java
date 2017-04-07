package com.laurenshup.superapi.builders;

import com.laurenshup.superapi.InventoryRegister;
import com.laurenshup.superapi.builders.inventory.InventoryEvent;
import com.laurenshup.superapi.builders.inventory.InventoryInstance;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Create your own inventories with this handy builder.
 *
 * @author Laurenshup
 */
public class InventoryBuilder {
	
	private int size;
	private String title;
	private HashMap<Integer, ItemStack> items = new HashMap<>();
	private HashMap<Integer, InventoryEvent> events = new HashMap<>();
	
	public InventoryBuilder(int size) {
		this.size = size;
	}
    
    /**
     * Adds a specific size to the inventory.
     * Be sure to make it divideable by 9:
     * 9, 18, 27, 36, 45 etc.
     *
     * @param size the size of the inventory
     * @return the new instance of the builder
     */
	public InventoryBuilder addSize(int size) {
		this.size = size;
		return this;
	}
    
    /**
     * Adds a title to the inventory
     *
     * @param title the title of the inventory
     * @return the new instance of the builder
     */
	public InventoryBuilder addTitle(String title) {
		this.title = title;
		return this;
	}
    
    /**
     * Adds a item to the inventory
     *
     * @param slot the slot of the inventory to set the item to
     * @param item the item that needs to be set
     * @return the new instance of the builder
     */
	public InventoryBuilder addItem(int slot, ItemStack item) {
		if(items.get(slot)!=null) {
			items.remove(slot);
		}
		items.put(slot, item);
		return this;
	}
    
    /**
     * Adds a event to a slot
     *
     * @param slot the slot of the inventory to add the event to
     * @param event the event that needs to be added
     * @return the new instance of the builder
     */
	public InventoryBuilder addEvent(int slot, InventoryEvent event) {
		if(events.get(slot)!=null) {
			events.remove(slot);
		}
		events.put(slot, event);
		return this;
	}
    
    /**
     * Creates a inventory and will also register the events
     *
     * @return the created inventory
     */
	public Inventory build() {
		Inventory inventory;
		if(title!=null) {
			inventory = Bukkit.createInventory(null, size, title);
		} else {
			inventory = Bukkit.createInventory(null, size);
		}
		for(Integer slot : items.keySet()) {
			inventory.setItem(slot, items.get(slot));
		}
        InventoryRegister.add(asInstance());
		return inventory;
	}
    
	private InventoryInstance asInstance() {
	    InventoryInstance instance = new InventoryInstance();
	    instance.size = size;
	    instance.title = title;
	    instance.items = items;
	    instance.events = events;
	    return instance;
    }

}
