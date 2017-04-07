package com.laurenshup.superapi;

import org.bukkit.plugin.Plugin;

/**
 * This is the base class for the SuperAPI.
 * 
 * @author Laurenshup
 */
public class SuperAPI {
	
	/**
	 * Creates a new SuperAPI for you with the given Plugin.
	 * 
	 * @param plugin your plugin's instance
	 * @return your own new instance of SuperAPI
	 */
	public static SuperAPI getAPI(Plugin plugin) {
		return Core.createAPI(plugin);
	}
	
	protected Plugin plugin;
	protected MessageManager messagemanager;
	protected PartyManager partymanager;
	protected ResourcePackManager resourcepackmanager;
	protected TimeManager timemanager;
	protected LanguageManager languagemanager;
	protected PlayerManager playermanager;
	
	protected SuperAPI(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Gets the you the MessageManager.
	 * 
	 * @return your SuperAPI's MessageManager
	 */
	public MessageManager getMessageManager() {
		return messagemanager;
	}
	
	/**
	 * Gets the you the PartyManager.
	 * 
	 * @return your SuperAPI's PartyManager
	 */
	public PartyManager getPartyManager() {
		return partymanager;
	}
	
	/**
	 * Gets the you the ResourcePackManager.
	 * 
	 * @return your SuperAPI's ResourcePackManager
	 */
	public ResourcePackManager getResourcePackManager() {
		return resourcepackmanager;
	}
	
	/**
	 * Gets the you the TimeManager.
	 * 
	 * @return your SuperAPI's TimeManager
	 */
	public TimeManager getTimeManager() {
		return timemanager;
	}
	
	/**
	 * Gets the you the LanguageManager.
	 * 
	 * @return your SuperAPI's LanguageManager
	 */
	public LanguageManager getLanguageManager() {
		return languagemanager;
	}
	
	/**
	 * Gets the you the PlayerManager.
	 * 
	 * @return your SuperAPI's PlayerManager
	 */
	public PlayerManager getPlayerManager() {
		return playermanager;
	}

}
