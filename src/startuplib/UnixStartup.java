package startuplib;

import java.io.File;

public class UnixStartup extends AbstractStartup {

	public UnixStartup(String name, String path) {
		super(name, path);
	}

	public static File getAutostartDir() {
		String home = System.getProperty("user.home");
		
		return new File(home + "/.config/autostart/");
	}
	
	@Override
	public void install() throws Exception {
		if (!getAutostartDir().exists()) {
			getAutostartDir().mkdirs();
		}
		
		File file = new File(getAutostartDir(), super.name + ".desktop");
	}

}
