package plugins;

import plugins.PluginFinder;
import plugins.TimerActionListener;
import static org.junit.Assert.*;

public class TimerActionListenerTest {
	public void TimerActionListenerTest() {
		PluginFinder finder = new PluginFinder("dropins/plugins");
		assertNotNull(new TimerActionListener(finder));
	}
}
