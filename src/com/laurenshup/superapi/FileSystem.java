package com.laurenshup.superapi;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileSystem {
	
	private static File root = Bukkit.getPluginManager().getPlugin("SuperAPI").getDataFolder();
	private static File languages = new File(root, "languages.yml");
	
	protected static void checkFiles() {
		if(!root.exists()) {
			root.mkdirs();
		}
		if(!languages.exists()) {
			try {
				languages.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected static FileConfiguration getLanguageConfig() {
		checkFiles();
		FileConfiguration config = new YamlConfiguration();
		try {
			config.load(languages);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		return config;
	}
	
	protected static void saveLanguageConfig(FileConfiguration config) {
		checkFiles();
		try {
			config.save(languages);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
