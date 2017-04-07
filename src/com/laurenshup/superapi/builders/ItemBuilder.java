package com.laurenshup.superapi.builders;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

/**
 * Create your own items with this handy builder.
 * 
 * @author Laurenshup
 */
public class ItemBuilder {
	
	private Material material;
	private Integer amount;
	private Short durability;
	private String name;
	private List<String> lores;
	private Boolean unbreakable;
	private ItemFlag[] flags;
	private HashMap<Enchantment, Integer> enchantments = new HashMap<>();
	
	
	public ItemBuilder(Material material) {
		this.material = material;
	}
	
	/**
	 * Sets the material for the item.
	 * 
	 * @param material the material to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setMaterial(Material material) {
		this.material = material;
		return this;
	}
	
	/**
	 * Sets the amount for the item.
	 * 
	 * @param amount the amount to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setAmount(int amount) {
		this.amount = amount;
		return this;
	}
	
	/**
	 * Sets the durability for the item.
	 * For tools: the durability
	 * For blocks: the data type
	 * 
	 * @param durability the durability to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setDurability(short durability) {
		this.durability = durability;
		return this;
	}
	
	/**
	 * Sets the name for the item.
	 * 
	 * @param name the name to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets the lores for the item.
	 * 
	 * @param lores the lores to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setLores(List<String> lores) {
		this.lores = lores;
		return this;
	}
	
	/**
	 * Sets the unbreakable for the item.
	 * 
	 * @param unbreakable the unbreakable to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setUnbreakable(boolean unbreakable) {
		this.unbreakable = unbreakable;
		return this;
	}
	
	/**
	 * Sets the flags for the item.
	 * 
	 * @param flags the flags to set
	 * @return the new instance of the builder
	 */
	public ItemBuilder setFlags(ItemFlag... flags) {
		this.flags = flags;
		return this;
	}
	
	/**
	 * Adds the enchantment for the item.
	 * 
	 * @param enchantment the enchantment to set
	 * @param level
	 * @return the new instance of the builder
	 */
	public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
		this.enchantments.put(enchantment, level);
		return this;
	}
	
	/**
	 * Creates the item.
	 * 
	 * @return the created item
	 */
	public ItemStack build() {
		ItemStack item = new ItemStack(material);
		if(amount!=null) {
			item.setAmount(amount);
		}
		if(durability!=null) {
			item.setDurability(durability);
		}
		ItemMeta meta = item.getItemMeta();
		if(name!=null) {
			meta.setDisplayName(name);
		}
		if(lores!=null) {
			meta.setLore(lores);
		}
		if(unbreakable!=null) {
			meta.setUnbreakable(unbreakable);
		}
		if(flags!=null) {
			meta.addItemFlags(flags);
		}
		if(enchantments!=null) {
			for(Enchantment enchantment : enchantments.keySet()) {
				int level = enchantments.get(enchantment);
				meta.addEnchant(enchantment, level, true);
			}
		}
		item.setItemMeta(meta);
		return item;
	}

}
