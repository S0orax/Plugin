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
		assertFalse(filtre.accept(file, "test.class"));
		assertFalse(filtre.accept(file,"test.cla"));
		assertTrue(filtre.accept(file,"ToUppercasePlugin.class"));
		// Ajouter ToUppercasePlugin.class dans le dossier des plugins
		fail("A retirer lorsque le fichier .class est ajouté dans le dossier plugins (par défaut, le rendu est à faire avec le fichier dedans afin de pouvoir faire les tests)");
		assertFalse(filtre.accept(file,"ToUppercasePlugin"));
	}

}
