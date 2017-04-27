package edu.jalc.momentopattern.logging;

import java.util.Date;

public class Message {

	private final String message;
	private final Date timestamp;

	protected Message(){
		this.message = null;
		this.timestamp = null;
	}

	public Message(String message){
		this.message = message;
		this.timestamp = new Date();
	}

	public String toString(){
		return "[" + this.getClass().getSimpleName().toUpperCase() + "] @ " + this.timestamp+ " :: " + this.message;
	}
}
