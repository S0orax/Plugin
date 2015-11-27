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
	
	public String getFileName() {
		return this.fileName;
	}
	
	public PluginFinder getSource() {
		return (PluginFinder) this.source;
	}

}
