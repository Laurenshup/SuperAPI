package com.laurenshup.superapi.language;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * This is the base class for a language.
 * 
 * @author Laurenshup
 */
public class Language {
	
	private String name;
	private String languagecode;
	private File languagefile;
	
	/**
	 * @param name the language's full name
	 * @param languagecode the language's code
	 * @param languagefile the language's translation file
	 */
	public Language(String name, String languagecode, File languagefile) {
		this.name = name;
		this.languagecode = languagecode;
		this.languagefile = languagefile;
	}
	
	/**
	 * Gives the language's full name.
	 * 
	 * @return the full name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gives the language's code.
	 * 
	 * @return the code
	 */
	public String getLanguageCode() {
		return languagecode;
	}
	
	/**
	 * Gives a translation for the given key.
	 * 
	 * @param key the key to get the value of
	 * @return the value(translation) of the key
	 */
	public String getTranslation(String key) {
		FileConfiguration config = new YamlConfiguration();
		try {
			config.load(languagefile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		return config.getString(key);
	}

}
