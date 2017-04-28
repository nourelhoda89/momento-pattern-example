package edu.jalc.momentopattern.logging;

import edu.jalc.momentopattern.logging.messages.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Caretaker {

	private ArrayList<Message> messages = new ArrayList<Message>();

	Caretaker add(Message message){
		this.messages.add(message);
		return this;
	}

	Message get(int messageId){
		return this.messages.get(messageId);
	}

	ArrayList<Message> getAll(State context){

		ArrayList<Message> filtered = null;

		if(context == State.WARN){
			filtered =  (ArrayList<Message>) this.getWarnings();
		}
      else if (context == State.ERROR){
         filtered = (ArrayList<Message>) this.getErrors();
      }
		return filtered;
	}

	private List<Message> getWarnings(){

		return messages.parallelStream().filter((message) -> message instanceof Warn).collect(Collectors.toList());

	}
   private List<Message> getErrors(){

		return messages.parallelStream().filter((message) -> message instanceof edu.jalc.momentopattern.logging.messages.Error).collect(Collectors.toList());

	}


}
