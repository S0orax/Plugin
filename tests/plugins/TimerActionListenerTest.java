package plugins;

import static org.junit.Assert.*;

import org.junit.Before;

public class TimerActionListenerTest {
	
	private TimerActionListener timerAction;
	private PluginFinder finder;
	
	@Before
	public void testTimerActionListener() {
		this.finder = new PluginFinder("dropins/plugins");
		this.finder.addPluginListener(new MookPluginListener());
		this.timerAction = new TimerActionListener(finder);
		assertNotNull(this.timerAction);
	}
	
	
}
