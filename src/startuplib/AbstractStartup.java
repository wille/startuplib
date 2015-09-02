package startuplib;

public abstract class AbstractStartup {
	
	protected String name;
	protected String path;
	
	public AbstractStartup(String name, String path) {
		this.name = name;
		this.path = path;
	}
	
	public abstract void install() throws Exception;
	
	public String getName() {
		return this.name;
	}
	
	public String getPath() {
		return this.path;
	}
}
