package com.laurenshup.superapi;

import com.laurenshup.superapi.builders.inventory.InventoryEvent;
import com.laurenshup.superapi.builders.inventory.InventoryInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class InventoryRegister implements Listener {
    
    private static List<InventoryInstance> inventories = new ArrayList<>();
    
    public static void add(InventoryInstance instance) {
        inventories.add(instance);
    }
    
    @EventHandler
    public static void onInventory(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player) {
            List<InventoryInstance> instances = inventories;
            for(InventoryInstance inventory : instances) {
                if(inventory.title.equals(event.getInventory().getName())) {
                    if(inventory.size == event.getInventory().getSize()) {
                        int slot = event.getSlot();
                        if(inventory.events.containsKey(slot)) {
                            InventoryEvent inventoryevent = inventory.events.get(slot);
                            inventoryevent.run((Player) event.getWhoClicked());
                        }
                    }
                }
            }
        }
    }
    
}
