package utils;

import java.io.IOException;

/**
 * @author Valentin
 *
 */
public class DatabaseOffException extends IOException {

	private static final long serialVersionUID = 6545323918568469134L;

	public DatabaseOffException() {
		System.out.println("MON MESSAGE 0");
	}
	
	public DatabaseOffException(String message) {
		System.out.println("MON MESSAGE 1");
	}
	
	public DatabaseOffException(Throwable cause) {
		System.out.println("MON MESSAGE 2");
	}
	
	public DatabaseOffException(String massage, Throwable cause) {
		System.out.println("MON MESSAGE 3");
	}
}
