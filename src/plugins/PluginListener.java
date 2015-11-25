/**
 * 
 */
package plugins;

import event.PluginEvent;

/**
 * @author heras
 *
 */
public interface PluginListener {

	/**
	 * Event sended when a file was adding
	 * @param event the event object sended
	 */
	public void addingFile(PluginEvent event);
	
	/**
	 * Event sended when a file was removing
	 * @param event the event object sended
	 */
	public void removingFile(PluginEvent event);
}
