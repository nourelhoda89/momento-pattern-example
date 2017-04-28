package edu.jalc.momentopattern.logging;

import edu.jalc.momentopattern.logging.messages.*;
import edu.jalc.momentopattern.logging.messages.Error;

import java.util.ArrayList;

public class Logger {

	private String message;
	private State state;
	private Caretaker caretaker = new Caretaker();

	public Logger message(State state, String message){
		this.message = message;
		this.state = state;
		return this;
	}

	public Logger save() throws Exception {
		if(state == null || message == null) throw new Exception("State | Message cannot be null");

		Message message;

		if(state == State.DEBUG) message = new Debug(this.message);
		else if(state == State.TRACE) message = new Trace(this.message);
		else if(state == State.INFO) message = new Info(this.message);
		else if(state == State.WARN) message = new Warn(this.message);
		else if(state == State.ERROR) message = new Error(this.message);
		else message = new Fatal(this.message);

		caretaker.add(message);

		return this;
	}

	public Message get(int position){
		return caretaker.get(position);
	}

	public ArrayList<Message> getWarnings(){
		return caretaker.getAll(State.WARN);
	}
   
   public ArrayList<Message> getErrors(){
		return caretaker.getAll(State.ERROR);
	}

}
