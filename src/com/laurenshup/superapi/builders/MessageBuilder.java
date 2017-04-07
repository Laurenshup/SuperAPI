package com.laurenshup.superapi.builders;

import java.util.ArrayList;
import java.util.List;

import com.laurenshup.superapi.message.ClickEvent;
import com.laurenshup.superapi.message.HoverEvent;
import com.laurenshup.superapi.message.Message;
import com.laurenshup.superapi.message.MessageEventBundle;

import net.md_5.bungee.api.chat.TextComponent;

/**
 * Create your own messages with this handy builder.
 * 
 * @author Laurenshup
 */
public class MessageBuilder {
	
	private List<Object> objects = new ArrayList<>();
	
	/**
	 * Adds a string to the builder.
	 * 
	 * @param message the string to add to the builder
	 * @return the new instance of the builder
	 */
	public MessageBuilder addString(String message) {
		objects.add(message);
		return this;
	}
	
	/**
	 * Adds a message to the builder.
	 * 
	 * @param message the message to add to the builder
	 * @return the new instance of the builder
	 */
	public MessageBuilder addMessage(Message message) {
		objects.add(message);
		return this;
	}
	
	/**
	 * Adds a click event with the given message to the builder.
	 * 
	 * @param event the click event what will run when clicking on the message
	 * @param message the message to click on to run the click event
	 * @return the new instance of the builder
	 */
	public MessageBuilder addClick(ClickEvent event, String message) {
		MessageEventBundle bundle = new MessageEventBundle(event, null, message);
		objects.add(bundle);
		return this;
	}
	
	/**
	 * Adds a hover event with the given message to the builder.
	 * 
	 * @param event the hover event what will run when hovering on the message
	 * @param message the message to hover on to run the hover event
	 * @return the new instance of the builder
	 */
	public MessageBuilder addHover(HoverEvent event, String message) {
		MessageEventBundle bundle = new MessageEventBundle(null, event, message);
		objects.add(bundle);
		return this;
	}
	
	/**
	 * Adds a click and hover event with the given message to the builder.
	 * 
	 * @param clickevent the click event what will run when clicking on the message
	 * @param hoverevent the hover event what will run when hovering on the message
	 * @param message the message to hover and click on
	 * @return the new instance of the builder
	 */
	public MessageBuilder addClickHover(ClickEvent clickevent, HoverEvent hoverevent, String message) {
		MessageEventBundle bundle = new MessageEventBundle(clickevent, hoverevent, message);
		objects.add(bundle);
		return this;
	}
	
	/**
	 * Build the message
	 * 
	 * @return the builded message
	 */
	public Message build() {
		TextComponent component = new TextComponent();
		for(Object object : objects) {
			TextComponent add = new TextComponent();
			if(object instanceof MessageEventBundle) {
				MessageEventBundle bundle = (MessageEventBundle) object;
				add.setText(bundle.getMesssage());
				if(bundle.getClickEvent()!=null) {
					net.md_5.bungee.api.chat.ClickEvent.Action type = net.md_5.bungee.api.chat.ClickEvent.Action.valueOf(bundle.getClickEvent().getType().toString());
					net.md_5.bungee.api.chat.ClickEvent clickevent = new net.md_5.bungee.api.chat.ClickEvent(type, bundle.getClickEvent().getLocation());
					add.setClickEvent(clickevent);
				}
				if(bundle.getHoverEvent()!=null) {
					net.md_5.bungee.api.chat.HoverEvent.Action type = net.md_5.bungee.api.chat.HoverEvent.Action.valueOf(bundle.getHoverEvent().getType().toString());
					net.md_5.bungee.api.chat.HoverEvent hoverevent = new net.md_5.bungee.api.chat.HoverEvent(type, bundle.getHoverEvent().getText().getComponents());
					add.setHoverEvent(hoverevent);
				}
			} else if(object instanceof String) {
				String text = (String) object;
				add.setText(text);
			} else if(object instanceof Message) {
				Message message = (Message) object;
				add = message.getComponent();
			}
			component.addExtra(add);
		}
		Message message = new Message(component);
		return message;
	}
	
}
