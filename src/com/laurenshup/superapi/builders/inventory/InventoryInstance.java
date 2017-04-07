package com.laurenshup.superapi.builders.inventory;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryInstance {
    
    public int size;
    public String title;
    public HashMap<Integer, ItemStack> items = new HashMap<>();
    public HashMap<Integer, InventoryEvent> events = new HashMap<>();
    
}
