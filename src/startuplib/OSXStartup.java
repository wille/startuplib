package startuplib;

import java.io.File;

public class OSXStartup extends AbstractStartup {

	public OSXStartup(String name, String path) {
		super(name, path);
	}

	public static File getLaunchAgentsDir() throws Exception {
		String home = System.getProperty("user.home");
		
		if (Utils.isRoot()) {
			home = "/System/";
		}
		
		return new File(home + "/Library/LaunchAgents/");
	}
	
	@Override
	public void install() throws Exception {
		if (!getLaunchAgentsDir().exists()) {
			getLaunchAgentsDir().mkdirs();
		}
		
		File file = new File(getLaunchAgentsDir(), super.name + ".plist");
		
		
	}

}
