package editor;

import plugins.PluginListener;
import event.PluginEvent;

public class PluginAddedLogger implements PluginListener {

	@Override
	/**
	 * Event sended when a file was adding
	 * @param event : the event object sended
	 * print the added file
	 */
	public void addingFile(PluginEvent event) {
		System.out.println("The file  " + event.getFileName() + " was added to the directory " + event.getSource().getDir());
	}

	@Override
	/**
	 * Event sended when a file was removing
	 * @param event : the event object sended
	 * print the removed file 
	 */
	public void removingFile(PluginEvent event) {
		System.out.println("The file "+event.getFileName()+" was removed of the directory "+event.getSource().getDir());
	}
	
}
