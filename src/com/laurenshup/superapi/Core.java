package com.laurenshup.superapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		FileSystem.checkFiles();
        Bukkit.getPluginManager().registerEvents(new InventoryRegister(), this);
	}
	
	protected static SuperAPI createAPI(Plugin plugin) {
		SuperAPI api = new SuperAPI(plugin);
		api.messagemanager = new MessageManager(plugin);
		api.partymanager = new PartyManager(plugin);
		ResourcePackManager resourcepackmanager = new ResourcePackManager(plugin);
		plugin.getServer().getPluginManager().registerEvents(resourcepackmanager, plugin);
		api.resourcepackmanager = resourcepackmanager;
		api.timemanager = new TimeManager(plugin);
		api.languagemanager = new LanguageManager(plugin);
		PlayerManager playermanager = new PlayerManager(plugin);
		plugin.getServer().getPluginManager().registerEvents(playermanager, plugin);
		api.playermanager = playermanager;
		return null;
	}

}
