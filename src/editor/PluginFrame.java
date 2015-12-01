package editor;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugins.PluginListener;
import editor.listener.ExitActionListener;
import event.PluginEvent;

public class PluginFrame implements PluginListener{
	
	private JFrame frame;
	private int width, height;
	private JMenu toolMenu;
	
	public PluginFrame() {
		this.width = 800;
		this.height = 600;
		
		Dimension dim = new Dimension(width, height);
		this.toolMenu = new JMenu("Tool");
		JMenuBar menu = this.initMenu();
		
		this.frame = new JFrame("Projet Plugin V0.2");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.setPreferredSize(dim);
		this.frame.setMinimumSize(dim);
		this.frame.setMaximumSize(dim);
		
		JTextArea textArea = new JTextArea();
		
		this.frame.add(textArea);
		this.frame.setJMenuBar(menu);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
	}
	
	private JMenuBar initMenu() {
		JMenuBar menu = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new ExitActionListener());
		fileMenu.add(exitItem);
		
		menu.add(fileMenu);
		menu.add(this.toolMenu);
		
		return menu;
	}

	@Override
	public void addingFile(PluginEvent event) {
		JMenuItem pluginItem = new JMenuItem(event.getFileName().replace(".class", ""));
		this.toolMenu.add(pluginItem);
	}

	@Override
	public void removingFile(PluginEvent event) {
		for(int i = 0; i < this.toolMenu.getMenuComponentCount(); i++) {
			JMenuItem item = this.toolMenu.getItem(i);
			if(item.getText().equals(event.getFileName().replace(".class", ""))) {
				this.toolMenu.remove(item);
			}
		}
	}
}
