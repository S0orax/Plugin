/**
 * 
 */
package plugin;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import plugins.PluginFilter;
import plugins.PluginFinder;

/**
 * @author heras
 *
 */
public class PluginFinderTest {
	PluginFinder finder;
	@Before
	public void testPluginFinder() {
		this.finder = new PluginFinder("dropins/plugins");
	}
	
	public void testStartTimer() {
		this.finder.start();
		// test remaining time		
	}
	
	public void checkDir() {
		
	}
	public void setandgetFilestest() {
		ArrayList<String> files = new ArrayList();
		assertNotNull(this.finder.getFiles());
	}

	public void getDirtest() {
		assertNotNull(this.finder.getDir());
	}

	/**
	 * Get the filter
	 * 
	 * @return the filter
	 */
	public void getFiltertest() {
		assertNotNull(this.finder.getFilter());
	}

}
