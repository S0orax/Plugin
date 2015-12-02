/**
 * 
 */
package plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import plugins.PluginFilter;

/**
 * @author orieux
 * 
 */
public class PluginFilterTest {

	@Test
	public void testPluginFilter() {
		File file = new File("inutile");
		PluginFilter filtre = new PluginFilter();
		assertTrue(filtre.accept(file,"ToLowercasePlugin.class"));
	}


	@Test(expected = NoClassDefFoundError.class)
	public void testPluginFilterWithNotInPackagePlugin() {
		File file = new File("inutile");
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(file,"PluginEvent.class"));
	}
	

	@Test(expected = RuntimeException.class)
	public void testPluginFilterWithNotExistingFile() {
		File file = new File("inutile");
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(file,"Rien.class"));
	}
	
	@Test(expected = RuntimeException.class)
	public void testPluginFilterWithNoEmptyConstructor() {
		File file = new File("inutile");
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(file,"PluginWithConstructor.class"));
	}
}
