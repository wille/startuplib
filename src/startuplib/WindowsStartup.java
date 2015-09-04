package startuplib;

public class WindowsStartup extends AbstractStartup {

	public WindowsStartup(String name, String path) {
		super(name, path);
	}

	@Override
	public void install() throws Exception {
		String javaHome = System.getProperty("java.home") + "\\bin\\javaw.exe";
		String data = javaHome + " -jar \"" + path + "\"";

		Runtime.getRuntime().exec(new String[] { "reg", "add", "HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run\\", "/v", name, "/t", "REG_SZ", "/d", data, "/f" });
	}

}
