package utils;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Valentin DOULCIER
 * @version 1.0
 * 
 * Ici, on gère les exceptions générées par hibernate.
 * (Non implémenté)
 *
 */
public class DatabaseOffException extends IOException {

	private static final long serialVersionUID = 6545323918568469134L;
	
	private static Logger logger = Logger.getLogger(DatabaseOffException.class);

	public DatabaseOffException() {
		logger.fatal("MON MESSAGE 0");
	}
	
	public DatabaseOffException(String message) {
		logger.fatal("MON MESSAGE 1");
	}
	
	public DatabaseOffException(Throwable cause) {
		logger.fatal("MON MESSAGE 2");
	}
	
	public DatabaseOffException(String massage, Throwable cause) {
		logger.fatal("MON MESSAGE 3");
	}
}
