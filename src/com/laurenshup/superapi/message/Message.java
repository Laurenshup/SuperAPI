package com.laurenshup.superapi.message;

import net.md_5.bungee.api.chat.TextComponent;

/**
 * This is the class for a message.
 * 
 * @author Laurenshup
 */
public class Message {
	
	private TextComponent component;
	
	/**
	 * @param component the text component to make the message of.
	 */
	public Message(TextComponent component) {
		this.component = component;
	}
	
	/**
	 * Gets the text component of the message.
	 * 
	 * @return the text component
	 */
	public TextComponent getComponent() {
		return component;
	}
	
	/**
	 * Gets the text component of the message as array.
	 * 
	 * @return the text component as array
	 */
	public TextComponent[] getComponents() {
		TextComponent[] components = {component};
		return components;
	}
	
	/**
	 * Gets the text of the message without the click and hover events.
	 * 
	 * @return the text
	 */
	public String getText() {
		return component.getText();
	}

}
