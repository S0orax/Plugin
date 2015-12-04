package plugins;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PluginFinderTest {

	private PluginFinder finder;
	
	@Before
	public void init() {
		this.finder = new PluginFinder("dropins/plugins");
	}
	
	@Test
	public void testCheckDirWhenAddingFile() {
		MookPluginListener pl = new MookPluginListener();
		this.finder.addPluginListener(pl);
		assertFalse(pl.getAdding());
		this.finder.getFiles().add("Test.class");
		this.finder.checkDir();
		assertTrue(pl.getAdding());
	}
	
	@Test
	public void testCheckDirWhenRemovingFile() {
		MookPluginListener pl = new MookPluginListener();
		this.finder.addPluginListener(pl);
		assertFalse(pl.getRemoving());
		this.finder.getFiles().add("Test.class");
		this.finder.checkDir();
		this.finder.setFiles(new ArrayList<String>());
		this.finder.checkDir();
		assertTrue(pl.getRemoving());
	}
	
	@Test
	public void testAddListener() {
		assertEquals(0, this.finder.getPluginListeners().size());
		this.finder.addPluginListener(new MookPluginListener());
		assertEquals(1, this.finder.getPluginListeners().size());
	}
	
	@Test
	public void testRemoveListener() {
		MookPluginListener pl = new MookPluginListener();
		this.finder.addPluginListener(pl);
		assertEquals(1, this.finder.getPluginListeners().size());
		this.finder.removePluginListener(pl);
		assertEquals(0, this.finder.getPluginListeners().size());
	}
}
