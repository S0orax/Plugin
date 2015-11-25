package event;

import java.util.EventObject;

import plugin.PluginFinder;

public class PluginEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public PluginEvent(PluginFinder source) {
		super(source);
	}
	
	

}
