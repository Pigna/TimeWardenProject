package model.control;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NewUserTracker {
	public void track() {
		//TODO: track new users in db
		Logger.getAnonymousLogger().log(Level.INFO, "New User tracked.");
	}
}
