package event;

import java.util.EventObject;

import plugins.PluginFinder;

public class PluginEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	private String fileName;

	public PluginEvent(PluginFinder source, String fileName) {
		super(source);
		this.fileName = fileName;
	}
	
	/** getFileName()
	 * Gives you acces to fileName
	 * @return String : the filename
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/** getSource()
	 * simple getter on the source
	 * @return PluginFinder : the source
	 */
	public PluginFinder getSource() {
		return (PluginFinder) this.source;
	}

}
