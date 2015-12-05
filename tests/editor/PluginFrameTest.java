/**
 * 
 */
package editor;

import org.junit.Before;
import org.junit.Test;

import event.PluginEvent;

import plugins.PluginFinder;

import static org.junit.Assert.*;

/**
 * @author heras
 *
 */
public class PluginFrameTest {
	
	private PluginFinder finder;
	private PluginFrame frame;
	
	@Before
	public void init() {
		this.finder = new PluginFinder("dropins/plugins");
		this.frame = new PluginFrame();
		this.finder.addPluginListener(this.frame);
	}
	
	@Test
	public void testAddingFile() {
		assertEquals(0, this.frame.getToolMenu().getMenuComponentCount());
		this.frame.addingFile(new PluginEvent(finder, "MookPlugin"));
		assertEquals(1, this.frame.getToolMenu().getMenuComponentCount());
	}
	
	@Test
	public void testRemovingFile() {
		this.frame.addingFile(new PluginEvent(finder, "MookPlugin"));
		assertEquals(1, this.frame.getToolMenu().getMenuComponentCount());
		this.frame.removingFile(new PluginEvent(finder, "MookPlugin"));
		assertEquals(0, this.frame.getToolMenu().getMenuComponentCount());
	}
}
