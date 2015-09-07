package startuplib;

public class HeadlessStartup extends AbstractStartup {

	public HeadlessStartup(String name, String path) {
		super(name, path);
	}
	
	public HeadlessStartup(String name, String path, boolean jar) {
		super(name, path, jar);
	}

	@Override
	public void install() throws Exception {
		
	}

}
