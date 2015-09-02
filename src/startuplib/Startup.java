package startuplib;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public class Startup {

	public static void install() {
		AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();
		
		AbstractStartup startup;
		
		if (os.getType() == OperatingSystem.WINDOWS) {
			startup = new WindowsStartup();
		} else if (os.getType() == OperatingSystem.OSX) {
			startup = new OSXStartup();
		} else if (os.isUnix()) {
			startup = new UnixStartup();
		} else {
			throw new RuntimeException("Unknown operating system " + os.getDetailedString());
		}
		
		startup.install();
	}
}
