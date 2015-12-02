package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class TimerActionListener implements ActionListener {

	private PluginFinder finder;
	
	public TimerActionListener(PluginFinder finder) {
		this.finder = finder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] t = this.finder.getDir().list(this.finder.getFilter());
		this.finder.setFiles(new ArrayList<String>(Arrays.asList(t)));
		this.finder.checkDir();
	}

}
