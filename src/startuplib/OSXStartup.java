package startuplib;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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

		PrintWriter out = new PrintWriter(new FileWriter(file));
		out.println("<plist version=\"1.0\">");
		out.println("<dict>");
		out.println("\t<key>Label</key>");
		out.println("\t<string>" + super.name + "</string>");
		out.println("\t<key>ProgramArguments</key>");
		out.println("\t<array>");
		out.println("\t\t<string>java</string>");
		out.println("\t\t<string>-jar</string>");
		out.println("\t\t<string>" + file.getAbsolutePath() + "</string>");
		out.println("\t</array>");
		out.println("\t<key>RunAtLoad</key>");
		out.println("\t<true/>");
		out.println("</dict>");
		out.println("</plist>");
		out.close();
	}

}
