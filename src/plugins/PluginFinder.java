/**
 * 
 */
package plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import event.PluginEvent;

/**
 * Class to find the plugin add into the application
 * 
 * @author heras_dubois_orieux
 * 
 */
public class PluginFinder extends PluginFilter {
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;
	private List<String> previousFiles;
	private List<PluginListener> listeners;

	/**
	 * Constructor of a new PluginFinder
	 * 
	 * @param dirPath
	 *            the path of the current directory
	 */
	public PluginFinder(String dirPath) {
		this.filter = new PluginFilter();
		this.dir = new File(dirPath);
		this.timer = new Timer(100, new TimerActionListener(this));
		this.files = new ArrayList<String>();
		this.previousFiles = new ArrayList<String>();
		this.listeners = new ArrayList<PluginListener>();
	}
	
	/**
	 * Start the timer
	 */
	public void start() {
		this.timer.start();
		while (true);
	}

	/**
	 * Check the current directory, display an information on the adding or
	 * removing file in this directory
	 */
	public void checkDir() {
		if (this.previousFiles.size() < this.files.size()) {
			this.fireAddingFile();
		} else if (this.previousFiles.size() > this.files.size()) {
			this.fireRemovingFile();
		}
		this.previousFiles = this.files;
	}
	
	/**
	 * Notify all listeners the event : addingFile
	 */
	private void fireAddingFile() {
		String fileName = this.findInterestingFile(this.files, this.previousFiles);
		
		PluginEvent event = new PluginEvent(this, fileName);
		for(PluginListener l : listeners) {
			l.addingFile(event);
		}
	}
	
	/**
	 * Notify all the listener the event : removingFile
	 */
	private void fireRemovingFile() {
		String fileName = this.findInterestingFile(this.previousFiles, this.files);
		
		PluginEvent event = new PluginEvent(this, fileName);
		for(PluginListener l : listeners) {
			l.removingFile(event);
		}
	}
	
	/**
	 * Find an interesting file name, this file was removed or added
	 * 
	 * @param refList the reference list, the method search if the file was not in this list
	 * @param checkedList List of file name, the interesting file is in this list
	 * @return the file name of the interesting file, or null if any interesting file
	 */
	private String findInterestingFile(List<String> refList, List<String> checkedList) {
		for(String s : refList) {
			if(!checkedList.contains(s)) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Subscribe a listener to the list of listeners
	 * @param listener the listener to adding
	 */
	public void addPluginListener(PluginListener listener) {
		this.listeners.add(listener);
	}
	
	/**
	 * Unsubscribe a listener to the list of listeners
	 * @param listener
	 */
	public void removePluginListener(PluginListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * Set the current files list of the current directory
	 * 
	 * @param files the files on the directory
	 */
	public void setFiles(ArrayList<String> files) {
		this.files = files;
	}

	/**
	 * Get the current files list
	 * 
	 * @return the current files list
	 */
	public List<String> getFiles() {
		return this.files;
	}

	/**
	 * Get the directory
	 * 
	 * @return the directory
	 */
	public File getDir() {
		return this.dir;
	}

	/**
	 * Get the filter
	 * 
	 * @return the filter
	 */
	public PluginFilter getFilter() {
		return this.filter;
	}

}
