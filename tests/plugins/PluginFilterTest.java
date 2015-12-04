/**
 * 
 */
package plugins;

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
		PluginFilter filtre = new PluginFilter();
		assertTrue(filtre.accept(null,"ToLowercasePlugin.class"));
	}


	@Test(expected = NoClassDefFoundError.class)
	public void testPluginFilterWithNotInPackagePlugin() {
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(null,"PluginEvent.class"));
	}
	

	@Test(expected = RuntimeException.class)
	public void testPluginFilterWithNotExistingFile() {
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(null,"Rien.class"));
	}
	
	@Test(expected = RuntimeException.class)
	public void testPluginFilterWithNoEmptyConstructor() {
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(null,"PluginWithConstructor.class"));
	}
}
