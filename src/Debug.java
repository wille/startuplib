import startuplib.Startup;

public class Debug {

	public static void main(String[] args) {
		try {
			Startup.add("startuplib-test", "startuplib-path");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
