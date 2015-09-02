package startuplib;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public class Startup {

	public static void install(String name, String path) {
		AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();
		
		AbstractStartup startup;
		
		if (os.getType() == OperatingSystem.WINDOWS) {
			startup = new WindowsStartup(name, path);
		} else if (os.getType() == OperatingSystem.OSX) {
			startup = new OSXStartup(name, path);
		} else if (os.isUnix()) {
			startup = new UnixStartup(name, path);
		} else {
			throw new RuntimeException("Unknown operating system " + os.getDetailedString());
		}
		
		startup.install();
	}
}
