package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MyActionListener implements ActionListener {

	private PluginFinder finder;
	
	public MyActionListener(PluginFinder finder) {
		this.finder = finder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] t = this.finder.getDir().list(this.finder.getFilter());
		this.finder.setFiles(new ArrayList<String>(Arrays.asList(t)));
		this.finder.checkDir();
	}

}
