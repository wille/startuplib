package startuplib;

import java.io.File;

public class OSXStartup extends AbstractStartup {

	public static File getLaunchAgentsDir() {
		String home = System.getProperty("user.home");
		
		return new File(home + "/Library/LaunchAgents/");
	}
	
	@Override
	public void install() {
		
	}

}
