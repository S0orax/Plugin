package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimerActionListenerTest {
	
	private TimerActionListener timerAction;
	private PluginFinder finder;
	
	@Before
	public void init() {
		this.finder = new PluginFinder("dropins/plugins");
		this.finder.addPluginListener(new MookPluginListener());
		this.timerAction = new TimerActionListener(finder);
	}
	
	@Test
	public void testTimerActionListener() {
		assertNotNull(this.timerAction);
	}
	
	
}
