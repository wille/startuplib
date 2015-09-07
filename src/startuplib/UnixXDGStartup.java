package startuplib;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class UnixXDGStartup extends AbstractStartup {

	public UnixXDGStartup(String name, String path) {
		super(name, path);
	}
	
	public UnixXDGStartup(String name, String path, boolean jar) {
		super(name, path, jar);
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
		
		PrintWriter out = new PrintWriter(new FileWriter(file));
		out.println("[Desktop Entry]");
		out.println("Type=Application");
		out.println("Name=" + super.name);
		if (jar) {
			out.println("Exec=java -jar '" + super.path + "'");
		} else {
			out.println("Exec=" + super.path);
		}
		out.println("Terminal=false");
		out.println("NoDisplay=true");
		out.close();
        
		String[] cmd = new String[] { "chmod", "+x", super.path };
		Runtime.getRuntime().exec(cmd);
	}

}
