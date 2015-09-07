package startuplib;

public class WindowsStartup extends AbstractStartup {

	public WindowsStartup(String name, String path) {
		super(name, path);
	}

	public WindowsStartup(String name, String path, boolean jar) {
		super(name, path, jar);
	}

	@Override
	public void install() throws Exception {
		String data;

		if (jar) {
			String javaHome = System.getProperty("java.home") + "\\bin\\javaw.exe";
			data = javaHome + " -jar \"" + path + "\"";
		} else {
			data = super.path;
		}

		Runtime.getRuntime().exec(new String[] { "reg", "add", "HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run\\", "/v", super.name, "/t", "REG_SZ", "/d", data, "/f" });
	}

}
