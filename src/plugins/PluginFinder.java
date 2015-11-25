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
 * @author heras_dubois_orieux
 * 
 */
public class PluginFinder extends PluginFilter {
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;
	private List<String> previousFiles;
	private String interestingName; // Nom du fichier sur lequel il y a eu
									// modification
	private int added; // -1 : fichier retiré 0 : aucun changement 1 : fichier
						// ajouté

	/**
	 * Constructor of a new PluginFinder
	 * 
	 * @param dirPath
	 *            the path of the current directory
	 */
	public PluginFinder(String dirPath) {
		this.added = 0;
		this.filter = new PluginFilter();
		this.dir = new File(dirPath);
		this.timer = new Timer(100, new MyActionListener(this));
		this.files = new ArrayList<String>();
		this.previousFiles = new ArrayList<String>();
		this.timer.start();
		while (true)
			;
	}

	/**
	 * Check the current directory, display an information on the adding or
	 * removing file in this directory
	 */
	public void checkDir() {
		if (this.previousFiles.size() < this.files.size()) {
			System.out.println("Un fichier class a été ajouté au dossier "
					+ this.dir.getName());
		} else if (this.previousFiles.size() > this.files.size()) {
			System.out.println("Un fichier class a été retiré du dossier "
					+ this.dir.getName());
		}
		this.previousFiles = this.files;
	}

	/**
	 * Set the current files list of the current directory
	 * 
	 * @param files
	 *            the files on the directory
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

	/**
	 * setInterestingFileName() Compare the two list of plugins before and after
	 * a tick. It changes added to -1 if a plugin has been deleted, 0 if no
	 * changement and 1 if a plugin has been added. It also change the name of
	 * interestingName with the name of the targetted file.
	 */
	public void setInterestingFileName() {
		this.interestingName = "";
		this.added = 0;
		for (String s : this.files) {
			if (!this.previousFiles.contains(s)) {
				this.interestingName = s; // Nom du fichier cible
				this.added = 1; // Fichier ajouté
			}
			for (String s1 : this.previousFiles) {
				if (!this.files.contains(s1)) {
					this.interestingName = s1; // Nom du fichier cible
					this.added = -1; // Fichier retiré
				}
			}
		}

	}

	/**
	 * getInterestingName() The files where the changement have been done
	 * 
	 * @return String : interestingName
	 */
	public String getInterestingName() {
		return this.interestingName;
	}

	/**
	 * getAdded() If
	 * 
	 * @return int : -1 if interestingName has been remove, 0 if no changement
	 *         and 1 if interestingName has been added
	 */
	public int getAdded() {
		return this.added;
	}

}
