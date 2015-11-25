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
		assertTrue(filtre.accept(file, "test.class"));
		assertFalse(filtre.accept(file, "test.cla"));
	}

}
