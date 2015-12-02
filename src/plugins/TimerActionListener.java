package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class TimerActionListener implements ActionListener {

	private PluginFinder finder;
	
	/**
	 * @param finder : a PluginFinder
	 * create a new object TimerActionListener
	 */
	public TimerActionListener(PluginFinder finder) {
		this.finder = finder;
	}
	
	@Override
	/**
	 * Invoked when an action occurs.
	 * @param e : Action event
	 * set the files in the current directory and check this directory
	 * this is display an information on the adding or removing file in this directory
	 */
	public void actionPerformed(ActionEvent e) {
		String[] t = this.finder.getDir().list(this.finder.getFilter());
		this.finder.setFiles(new ArrayList<String>(Arrays.asList(t)));
		this.finder.checkDir();
	}

}
