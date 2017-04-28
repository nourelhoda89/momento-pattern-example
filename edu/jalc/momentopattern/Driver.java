package edu.jalc.momentopattern;

import edu.jalc.momentopattern.logging.Logger;
import edu.jalc.momentopattern.logging.State;

public class Driver {

	public static void main(String... args) throws Exception {

		Logger logger = new Logger();

		logger.message(State.DEBUG, "debugging").save();
		logger.message(State.INFO, "info").save();

		System.out.println(logger.get(0));
		System.out.println(logger.get(1));
	}
}
