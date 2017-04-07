package com.laurenshup.superapi.message;

public class MessageEventBundle {
	
	private ClickEvent clickevent;
	private HoverEvent hoverevent;
	private String message;
	
	public MessageEventBundle(ClickEvent clickevent, HoverEvent hoverevent, String message) {
		this.clickevent = clickevent;
		this.hoverevent = hoverevent;
		this.message = message;
	}
	
	public ClickEvent getClickEvent() {
		return clickevent;
	}
	
	public HoverEvent getHoverEvent() {
		return hoverevent;
	}
	
	public String getMesssage() {
		return message;
	}

}
