package editor;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugins.Plugin;
import plugins.PluginListener;
import editor.listener.ExitActionListener;
import editor.listener.PluginActionListener;
import event.PluginEvent;

public class PluginFrame implements PluginListener{
	
	private JFrame frame;
	private int width, height;
	private JMenu toolMenu;
	private JTextArea textArea;
	
	/** PublicFram()
	 * Create a new frame with a textarea of dimension of 800x600 
	 */
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
		
		this.textArea = new JTextArea();
		
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

	/** addingFile(PluginEvent event)
	 * Add a tool in the tool menu
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addingFile(PluginEvent event) {
		String className = "plugins." + event.getFileName().replace(".class", "");
		
		try {
			Class<Plugin> pluginClass = (Class<Plugin>) Class.forName(className);
			Plugin plugin = pluginClass.newInstance();
			JMenuItem pluginItem = new JMenuItem(plugin.getLabel());
			pluginItem.addActionListener(new PluginActionListener(plugin, this.textArea));
			this.toolMenu.add(pluginItem);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	
	/** removingFile(PluginEvent event)
	 * Remove a tool in the tool menu
	 */
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
