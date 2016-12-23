package startuplib;

import java.io.File;

import oslib.AbstractOperatingSystem;
import oslib.OperatingSystem;

public final class Startup {
	
	/**
	 * Adds current JAR to startup with filename as name
	 * @throws Exception
	 */
	public static void add() throws Exception {	
		File file = Utils.getJarFile();

		add(file.getName());
	}
	
	/**
	 * Adds current JAR to startup
	 * @param name Name of key/file
	 * @throws Exception
	 */
	public static void add(String name) throws Exception {
		File file = Utils.getJarFile();
		
		add(name, file.getAbsolutePath(), true);
	}

	/**
	 * Add file to startup
	 * @param name Name of key/file
	 * @param file File to add
	 * @throws Exception
	 */
	public static void add(String name, File file) throws Exception {
		add(name, file.getAbsolutePath());
	}
	
	public static void add(String name, String path) throws Exception {
		add(name, path, false);
	}
	
	/**
	 * Add file to startup
	 * @param name Name of key/file
	 * @param path Path to file
	 * @param jar If file should be executed by the JVM
	 * @throws Exception
	 */
	public static void add(String name, String path, boolean jar) throws Exception {
		AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();
		
		AbstractStartup startup;
		
		if (os.getType() == OperatingSystem.WINDOWS) {
			startup = new WindowsStartup(name, path, jar);
		} else if (os.getType() == OperatingSystem.MACOS) {
			startup = new MacOSStartup(name, path, jar);
		} else if (os.isUnix() && !Utils.isHeadless()) {
			startup = new UnixXDGStartup(name, path, jar);
		} else if (os.isUnix()) {
			startup = new HeadlessStartup(name, path, jar);
		} else {
			throw new RuntimeException("Unknown operating system " + os.getDetailedString());
		}
		
		startup.install();
	}
}
