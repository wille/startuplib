package startuplib;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MacOSStartup extends AbstractStartup {

	public MacOSStartup(String name, String path) {
		super(name, path);
	}
	
	public MacOSStartup(String name, String path, boolean jar) {
		super(name, path, jar);
	}

	public static File getLaunchAgentsDir() throws Exception {
		String home = System.getProperty("user.home");

		if (Utils.isRoot()) {
			home = "";
		}

		return new File(home + "/Library/LaunchAgents/");
	}

	@Override
	public void install() throws Exception {
		if (!getLaunchAgentsDir().exists()) {
			getLaunchAgentsDir().mkdirs();
		}

		File file = new File(getLaunchAgentsDir(), super.name + ".plist");

		PrintWriter out = new PrintWriter(new FileWriter(file));
		out.println("<plist version=\"1.0\">");
		out.println("<dict>");
		out.println("\t<key>Label</key>");
		out.println("\t<string>" + super.name + "</string>");
		out.println("\t<key>ProgramArguments</key>");
		out.println("\t<array>");
		if (jar) {
			out.println("\t\t<string>java</string>");
			out.println("\t\t<string>-jar</string>");
		}
		out.println("\t\t<string>" + super.path + "</string>");
		out.println("\t</array>");
		out.println("\t<key>RunAtLoad</key>");
		out.println("\t<true/>");
		out.println("</dict>");
		out.println("</plist>");
		out.close();
	}

}
