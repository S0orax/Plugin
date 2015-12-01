/**
 * 
 */
package plugins;

import java.io.File;
import java.io.FilenameFilter;
import static org.junit.Assert.*;

/**
 * @author orieux
 * 
 */
public class PluginFilter implements FilenameFilter {

	/** accept(File dit, String name)
	 * try if this file is a plugin
	 * return boolean : true if this file is a plug-in
	 * @param construct 
	 */
	@Override
	public boolean accept(File dir, String name) {
		boolean test = false;
		boolean construct = false;
		
		try {
			test = Class.forName("plugins."+name.replace(".class","")).isAssignableFrom(Plugin.class);
			construct = Class.forName("plugins."+name.replace(".class","")).getConstructor().getParameterCount() == 0;
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			System.out.println("ClassNotFoundException : "+e);
		}
		return name.endsWith(".class") && test && construct;
	}

}
