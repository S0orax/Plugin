/**
 * 
 */
package plugins;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author orieux
 * 
 */
public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".class");
	}

}
