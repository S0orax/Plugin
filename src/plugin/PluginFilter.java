/**
 * 
 */
package plugin;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author orieux
 * 
 */
public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class")) {
			
		}
		
		return name.endsWith(".class");
	}

}
