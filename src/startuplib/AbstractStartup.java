package startuplib;

public abstract class AbstractStartup {
	
	protected boolean jar;
	protected String name;
	protected String path;
	
	public AbstractStartup(String name, String path) {
		this.name = name;
		this.path = path;
		this.jar = false;
	}
	
	public AbstractStartup(String name, String path, boolean jar) {
		this.name = name;
		this.path = path;
		this.jar = jar;
	}
	
	public abstract void install() throws Exception;
	
	public boolean isJar() {
		return this.jar;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPath() {
		return this.path;
	}
}
