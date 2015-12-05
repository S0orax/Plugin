/**
 * 
 */
package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author orieux
 * 
 */
public class PluginFilterTest {

	@Test
	public void testPluginFilter() {
		PluginFilter filtre = new PluginFilter();
		assertTrue(filtre.accept(null,"MookPlugin.class"));
	}


	@Test
	public void testPluginFilterWithNotInPackagePlugin() {
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(null,"event/MookPlugin.class"));
	}
	

	@Test
	public void testPluginFilterWithNotExistingFile() {
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(null,"Rien.class"));
	}
	
	@Test
	public void testPluginFilterWithNoEmptyConstructor() {
		PluginFilter filtre = new PluginFilter();
		assertFalse(filtre.accept(null,"PluginWithConstructor.class"));
	}
}
