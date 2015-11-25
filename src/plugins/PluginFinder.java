/**
 * 
 */
package plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

/**
 * Class to find the plugin add into the application
 * 
 * @author heras
 * 
 */
public class PluginFinder extends PluginFilter {
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;
	private List<String> previousFiles;
	
	/**
	 * Constructor of a new PluginFinder
	 * @param dirPath the path of the current directory
	 */
	public PluginFinder(String dirPath) {
		this.filter = new PluginFilter();
		this.dir = new File(dirPath);
		this.timer = new Timer(100, new MyActionListener(this));
		this.files = new ArrayList<String>();
		this.previousFiles = new ArrayList<String>();
		this.timer.start();
		while(true);
	}
	
	/**
	 * Check the current directory, display an information on the adding or removing file in this directory
	 */
	public void checkDir() {
		if(this.previousFiles.size() < this.files.size()) {
			System.out.println("Un fichier class a été ajouté au dossier " + this.dir.getName());
		} else if(this.previousFiles.size() > this.files.size()) {
			System.out.println("Un fichier class a été retiré du dossier " + this.dir.getName());
		}
		this.previousFiles = this.files;
	}
	
	/**
	 * Set the current files list of the current directory
	 * @param files the files on the directory
	 */
	public void setFiles(ArrayList<String> files) {
		this.files = files;
	}
	
	/**
	 * Get the current files list
	 * @return the current files list
	 */
	public List<String> getFiles() {
		return this.files;
	}
	
	/**
	 * Get the directory
	 * @return the directory
	 */
	public File getDir() {
		return this.dir;
	}
	
	/**
	 * Get the filter
	 * @return the filter
	 */
	public PluginFilter getFilter() {
		return this.filter;
	}

}
