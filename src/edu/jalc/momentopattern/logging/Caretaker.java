package edu.jalc.momentopattern.logging;

import java.util.ArrayList;

class Caretaker {

	private ArrayList<Message> message = new ArrayList<Message>();

	Caretaker add(Message message){
		this.message.add(message);
		return this;
	}

	Message get(int messageId){
		return this.message.get(messageId);
	}
}
