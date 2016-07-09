package startuplib;

import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import oslib.OperatingSystem;

public class Utils {
	
	public static File getJarFile() {
		return new File(Utils.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("%20", " ").replace("file:", ""));
	}
	
	public static boolean isRoot() throws Exception {
		return OperatingSystem.getOperatingSystem().getType() != OperatingSystem.WINDOWS && new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("whoami").getInputStream())).readLine().equals("root");
	}
	
	public static boolean isHeadless() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadlessInstance();
	}
}
