/**
 * 
 */
package event;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plugins.PluginFinder;

/**
 * @author heras
 *
 */
public class PluginEventTest {

	private PluginFinder find;
	private String fileName;
	private PluginEvent event;
	
	@Before
	public void initialise() {
		this.find = new PluginFinder("dropins/plugin");
		this.fileName = "test";
		this.event = new PluginEvent(find,fileName);
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(this.event);
	}
	
	@Test
	public void getFileNameTest() {
		assertEquals("test",this.event.getFileName()); 
	}
	
	@Test
	public void getSourceTest() {
		assertNotNull(this.find);
	}
	
}
