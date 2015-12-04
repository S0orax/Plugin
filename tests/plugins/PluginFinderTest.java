package plugins;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import event.PluginEvent;

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
		assertFalse(pl.adding);
		this.finder.getFiles().add("Test.class");
		this.finder.checkDir();
		assertTrue(pl.adding);
	}
	
	@Test
	public void testCheckDirWhenRemovingFile() {
		MookPluginListener pl = new MookPluginListener();
		this.finder.addPluginListener(pl);
		assertFalse(pl.removing);
		this.finder.getFiles().add("Test.class");
		this.finder.checkDir();
		this.finder.setFiles(new ArrayList<String>());
		this.finder.checkDir();
		assertTrue(pl.removing);
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
	
	class MookPluginListener implements PluginListener {
		
		private boolean adding = false;
		private boolean removing = false;
		
		@Override
		public void addingFile(PluginEvent event) {
			this.adding = true;
		}

		@Override
		public void removingFile(PluginEvent event) {
			System.out.println("test2");
			this.removing = true;
		}
		
	}
}
