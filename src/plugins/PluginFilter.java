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

	/**
	 * accept(File dir, String name) try if this file is a plugin return boolean
	 * : true if this file is a plug-in
	 * 
	 * @param dir
	 *            : the path where 'name' is located
	 * @param name
	 *            : name of the file
	 * @return boolean : return true if this file is a plugin
	 */
	@Override
	public boolean accept(File dir, String name) {
		boolean test = false;
		boolean construct = false;
		try {
			Class<?> plugin = Class.forName("plugins." + name.replace(".class", ""));
			test = Plugin.class.isAssignableFrom(plugin);
			construct = plugin.getConstructor().getParameterTypes().length == 0;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		} catch (SecurityException e) {
			return false;
		}
		return name.endsWith(".class") && test && construct;
	}

}
