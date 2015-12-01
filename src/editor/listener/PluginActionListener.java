package editor.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import plugins.Plugin;

public class PluginActionListener implements ActionListener {
	
	private Plugin plugin;
	private JTextArea area;

	public PluginActionListener(Plugin plugin, JTextArea area) {
		this.area = area;
		this.plugin = plugin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.area.getSelectedText() != null) {
			String text = this.area.getText();
			int debut = this.area.getSelectionStart();
			int fin = this.area.getSelectionEnd();
			String resText = text.substring(0, debut);
			resText += plugin.transform(area.getSelectedText());
			resText += text.substring(fin);
			this.area.setText(resText);
		} else {
			this.area.setText(plugin.transform(area.getText()));					
		}
		
	}

}
