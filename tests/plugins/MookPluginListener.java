package plugins;

import event.PluginEvent;

public class MookPluginListener implements PluginListener {
	
	private boolean adding = false;
	private boolean removing = false;
	
	@Override
	public void addingFile(PluginEvent event) {
		this.adding = true;
	}

	@Override
	public void removingFile(PluginEvent event) {
		this.removing = true;
	}
	
	public boolean getAdding() {
		return this.adding;
	}
	
	public boolean getRemoving() {
		return this.removing;
	}
	
}
