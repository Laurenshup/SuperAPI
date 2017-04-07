package com.laurenshup.superapi;

import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.laurenshup.superapi.message.Message;
import com.laurenshup.superapi.party.Party;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * This is your SuperAPI's MessageManager.
 * The actionbar works only with Minecraft 1.11.
 * 
 * @author Laurenshup
 */
public class MessageManager {
	
	private Plugin plugin;
	
	protected MessageManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Sends a string to the given player.
	 * 
	 * @param player player to send the string to
	 * @param message the string to send to the player
	 */
	public void sendMessage(Player player, String message) {
		player.sendMessage(message);
	}
	
	/**
	 * Sends a message to the given player.
	 * 
	 * @param player player to send the message to
	 * @param message the message to send to the player
	 */
	public void sendMessage(Player player, Message message) {
		player.spigot().sendMessage(ChatMessageType.CHAT, message.getComponent());
	}
	
	/**
	 * Sends a string to the given players.
	 * 
	 * @param players players to send the string to
	 * @param message the string to send to the players
	 */
	public void sendMessageToPlayers(Set<Player> players, String message) {
		for(Player player : players) {
			player.sendMessage(message);
		}
	}
	
	/**
	 * Sends a message to the given players.
	 * 
	 * @param players players to send the message to
	 * @param message the message to send to the players
	 */
	public void sendMessageToPlayers(Set<Player> players, Message message) {
		for(Player player : players) {
			player.spigot().sendMessage(ChatMessageType.CHAT, message.getComponent());
		}
	}
	
	/**
	 * Sends a string to all players in the party.
	 * 
	 * @param party party's players to send the string to
	 * @param message the string to send to the players
	 */
	public void sendMessageToParty(Party party, String message) {
		for(Player player : party.getPlayers()) {
			player.sendMessage(message);
		}
	}
	
	/**
	 * Sends a message to all players in the party.
	 * 
	 * @param party party's players to send the message to
	 * @param message the message to send to the players
	 */
	public void sendMessageToParty(Party party, Message message) {
		for(Player player : party.getPlayers()) {
			player.spigot().sendMessage(ChatMessageType.CHAT, message.getComponent());
		}
	}
	
	/**
	 * Sends a string to all players.
	 * 
	 * @param message the string to send to all players
	 */
	public void sendMessageToAll(String message) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.sendMessage(message);
		}
	}
	
	/**
	 * Sends a message to all players.
	 * 
	 * @param message the message to send to all players
	 */
	public void sendMessageToAll(Message message) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.spigot().sendMessage(ChatMessageType.CHAT, message.getComponent());
		}
	}
	
	/**
	 * Sends a actionbar string to the given player.
	 * 
	 * @param player the player to send the actiobar string to
	 * @param message the actionbar string to send to the player
	 */
	public void sendActionMessage(Player player, String message) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
	}
	
	/**
	 * Sends a actionbar message to the given player.
	 * 
	 * @param player the player to send the actiobar message to
	 * @param message the actionbar message to send to the player
	 */
	public void sendActionMessage(Player player, Message message) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message.getComponent());
	}
	
	/**
	 * Sends a actionbar string to all players in the party.
	 * 
	 * @param party party's players to send the actionbar string to
	 * @param message the actiobar string to send to the players
	 */
	public void sendActionMessageToParty(Party party, String message) {
		for(Player player : party.getPlayers()) {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
		}
	}
	
	/**
	 * Sends a actionbar message to all players in the party.
	 * 
	 * @param party party's players to send the actionbar message to
	 * @param message the actiobar message to send to the players
	 */
	public void sendActionMessageToParty(Party party, Message message) {
		for(Player player : party.getPlayers()) {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message.getComponent());
		}
	}
	
	/**
	 * Sends a actionbar string to the given players.
	 * 
	 * @param players players to send the actionbar string to
	 * @param message the actionbar string to send to the players
	 */
	public void sendActionMessageToPlayers(Set<Player> players, String message) {
		for(Player player : players) {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
		}
	}
	
	/**
	 * Sends a actionbar message to the given players.
	 * 
	 * @param players players to send the actionbar message to
	 * @param message the actionbar message to send to the players
	 */
	public void sendActionMessageToPlayers(Set<Player> players, Message message) {
		for(Player player : players) {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message.getComponent());
		}
	}
	
	/**
	 * Sends a actiobar string to all players.
	 * 
	 * @param message the actiobar string to send to all players
	 */
	public void sendActionMessageToAll(String message) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
		}
	}
	
	/**
	 * Sends a actiobar message to all players.
	 * 
	 * @param message the actiobar message to send to all players
	 */
	public void sendActionMessageToAll(Message message) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message.getComponent());
		}
	}
	
	/**
	 * Sends a title to the given player.
	 * 
	 * @param player the player to send the title to
	 * @param title the title to send to the player
	 * @param subtitle the subtitle to send to the player
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitle(Player player, String title, String subtitle, int fadein, int stay, int fadeout) {
		player.sendTitle(title, subtitle, fadein, stay, fadeout);
	}
	
	/**
	 * Sends a title to the given player.
	 * 
	 * @param player the player to send the title to
	 * @param title the title to send to the player
	 * @param subtitle the subtitle to send to the player
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitle(Player player, Message title, Message subtitle, int fadein, int stay, int fadeout) {
		player.sendTitle(title.getText(), subtitle.getText(), fadein, stay, fadeout);
	}
	
	/**
	 * Sends a title to all players in the party.
	 * 
	 * @param party the party's players to send to title to
	 * @param title the title to send to the players
	 * @param subtitle the subtitle to send to the players
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitleToParty(Party party, String title, String subtitle, int fadein, int stay, int fadeout) {
		for(Player player : party.getPlayers()) {
			player.sendTitle(title, subtitle, fadein, stay, fadeout);
		}
	}
	
	/**
	 * Sends a title to all players in the party.
	 * 
	 * @param party the party's players to send to title to
	 * @param title the title to send to the players
	 * @param subtitle the subtitle to send to the players
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitleToParty(Party party, Message title, Message subtitle, int fadein, int stay, int fadeout) {
		for(Player player : party.getPlayers()) {
			player.sendTitle(title.getText(), subtitle.getText(), fadein, stay, fadeout);
		}
	}
	
	/**
	 * Sends a title to the given players.
	 * 
	 * @param players the players to send the title to
	 * @param title the title to send to the players
	 * @param subtitle the subtitle to send to the players
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitleToPlayers(Set<Player> players, String title, String subtitle, int fadein, int stay, int fadeout) {
		for(Player player : players) {
			player.sendTitle(title, subtitle, fadein, stay, fadeout);
		}
	}
	
	/**
	 * Sends a title to the given players.
	 * 
	 * @param players the players to send the title to
	 * @param title the title to send to the players
	 * @param subtitle the subtitle to send to the players
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitleToPlayers(Set<Player> players, Message title, Message subtitle, int fadein, int stay, int fadeout) {
		for(Player player : players) {
			player.sendTitle(title.getText(), subtitle.getText(), fadein, stay, fadeout);
		}
	}
	
	/**
	 * Sends a title to all players.
	 * 
	 * @param title the title to send to the players
	 * @param subtitle the subtitle to send to the players
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitleToAll(String title, String subtitle, int fadein, int stay, int fadeout) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.sendTitle(title, subtitle, fadein, stay, fadeout);
		}
	}
	
	/**
	 * Sends a title to all players.
	 * 
	 * @param title the title to send to the players
	 * @param subtitle the subtitle to send to the players
	 * @param fadein the time in ticks to let the title fade in
	 * @param stay the time in ticks to let the title stay
	 * @param fadeout the time in ticks to let the title fade out
	 */
	public void sendTitleToAll(Message title, Message subtitle, int fadein, int stay, int fadeout) {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			player.sendTitle(title.getText(), subtitle.getText(), fadein, stay, fadeout);
		}
	}

}
