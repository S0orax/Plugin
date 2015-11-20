/**
 * 
 */
package plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author heras
 * 
 */
public class PluginFinder extends PluginFilter {
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private ArrayList<String> files;

	public PluginFinder(String dirPath) {
		this.filter = new PluginFilter();
		this.dir = new File(dirPath);
		this.timer = new Timer(100, new MyActionListener());
		this.files = new ArrayList<String>();
		this.timer.start();
	}

}
