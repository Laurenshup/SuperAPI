package com.laurenshup.superapi;

import com.laurenshup.superapi.language.Language;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

/**
 * This is your SuperAPI's LanguageManager.
 * 
 * @author Laurenshup
 */
public class LanguageManager {
	
	@SuppressWarnings("unused")
	private Plugin plugin;
	private String defaultlanguage;
	private Set<Language> languages = new HashSet<>();
	
	protected LanguageManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Registers a language.
	 * 
	 * @param language the needed language to register
	 */
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	/**
	 * Sets the default language.
	 * This is used when players haven't chosen a their own language.
	 * 
	 * @param languagecode the default language's languagecode
	 */
	public void setDefaultLanguage(String languagecode) {
		defaultlanguage = languagecode;
	}
	
	/**
	 * Gets all registered languages.
	 * 
	 * @return returns a set of all registered languages
	 */
	public Set<Language> getLanguages() {
		return languages;
	}
	
	/**
	 * Gets a registered language by its languagecode.
	 * 
	 * @param languagecode the languagecode to get the registered language from
	 * @return registered language by the given languagecode, null if there is no registered language with this languagecode.
	 */
	public Language getLanguage(String languagecode) {
		for(Language language : languages) {
			if(language.getLanguageCode().equals(languagecode)) {
				return language;
			}
		}
		return null;
	}
	
	/**
	 * Sets the player's language with a languagecode.
	 * 
	 * @param player player to set the language to
	 * @param languagecode languagecode to set the language to
	 */
	public void setPlayerLanguage(Player player, String languagecode) {
		FileConfiguration config = FileSystem.getLanguageConfig();
		config.set(player.getUniqueId().toString(), languagecode);
		FileSystem.saveLanguageConfig(config);
	}
	
	/**
	 * Gets the translation of a player with a key.
	 * <p>
	 * Example:
	 * The player has as language: Dutch
	 * Dutch file:
	 *   skywars.start: "Het spel is gestart!"
	 *   skywars.end: "Het spel is gestopt!"
	 * If the key is: skywars.start then it returns "Het spel is gestart!"
	 * 
	 * @param player player to get the translation for
	 * @param key key to search for in the configuration file
	 * @return returns the value(translation) for the given player and given key
	 */
	public String getPlayerTranslation(Player player, String key) {
		FileConfiguration config = FileSystem.getLanguageConfig();
		String languagecode = config.getString(player.getUniqueId().toString());
		if(languagecode==null) {
			languagecode = defaultlanguage;
		}
		Language language = getLanguage(languagecode);
		return language.getTranslation(key);
	}

}
