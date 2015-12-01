package editor;

import plugins.PluginListener;
import event.PluginEvent;

public class PluginAddedLogger implements PluginListener {

	@Override
	public void addingFile(PluginEvent event) {
		System.out.println("The file  " + event.getFileName() + " was added to the directory " + event.getSource().getDir());
	}

	@Override
	public void removingFile(PluginEvent event) {
		System.out.println("The file "+event.getFileName()+" was removed of the directory "+event.getSource().getDir());
	}
	
}
