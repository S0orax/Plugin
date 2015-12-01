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
//		if(name.endsWith(".class")) {
//			try {
//				Class plugin = Class.forName(name);
//			} catch (ClassNotFoundException e) {
//				System.out.println("Un fichier class non plugin a  été ajouté");
//			}
//		}
		
		return name.endsWith(".class");
	}

}
