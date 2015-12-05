package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PluginTest {

	private MookPlugin plugin;
	
	@Before
	public void init() {
		this.plugin = new MookPlugin();
	}
	
	@Test
	public void testTransform() {
		String s = "Hello world";
		assertEquals("Hello world", s);
		s = this.plugin.transform(s);
		assertEquals("Test", s);
	}

}
