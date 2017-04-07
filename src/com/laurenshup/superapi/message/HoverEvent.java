package com.laurenshup.superapi.message;

import net.md_5.bungee.api.chat.TextComponent;

/**
 * This is the class for a hover event.
 * 
 * @author Laurenshup
 */
public class HoverEvent {
	
	private HoverEventType type;
	private Message text;
	
	/**
	 * The text is used for showing text, entities, etc..
	 * 
	 * @param type the hover event type
	 * @param text the text to show on hovering
	 */
	public HoverEvent(HoverEventType type, String text) {
		this.type = type;
		this.text = new Message(new TextComponent(text));
	}
	
	/**
	 * The text is used for showing text, entities, etc..
	 * 
	 * @param type the hover event type
	 * @param text the text to show on hovering
	 */
	public HoverEvent(HoverEventType type, Message text) {
		this.type = type;
		this.text = text;
	}
	
	/**
	 * Gives the hover event type.
	 * 
	 * @return the hover event type
	 */
	public HoverEventType getType() {
		return type;
	}
	
	/**
	 * Gives the text of a hover event.
	 * The text is used for showing text, entities, etc..
	 * 
	 * @return the text to show on hovering
	 */
	public Message getText() {
		return text;
	}

}
