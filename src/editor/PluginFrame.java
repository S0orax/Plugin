package editor;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.HashMap;

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
	private HashMap<String, Plugin> pluginCache;
	
	/** PublicFram()
	 * Create a new frame with a textarea of dimension of 800x600 
	 */
	public PluginFrame() {
		this.width = 800;
		this.height = 600;
		this.pluginCache = new HashMap<String, Plugin>();
		
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

	@Override
	public void addingFile(PluginEvent event) {
		String className = "plugins." + event.getFileName().replace(".class", "");
		
		try {
			Class<?> pluginClass = Class.forName(className);
			Plugin plugin = (Plugin) pluginClass.newInstance();
			pluginCache.put(plugin.getLabel(), plugin);
			JMenuItem pluginItem = new JMenuItem(plugin.getLabel());
			pluginItem.addActionListener(new PluginActionListener(plugin, this.textArea));
			this.toolMenu.add(pluginItem);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	
	/** removingFile(PluginEvent event)
	 * Remove a tool in the tool menu
	 */
	@Override
	public void removingFile(PluginEvent event) {
		for(int i = 0; i < this.toolMenu.getMenuComponentCount(); i++) {
			JMenuItem item = this.toolMenu.getItem(i);
			Plugin plugin = this.pluginCache.get(item.getText());
			if(plugin != null) {
				String pluginLabel = plugin.getLabel();
				if(item.getText().equals(pluginLabel)) {
					this.toolMenu.remove(item);
				}
			}
		}
	}
	
	/**
	 * Get the menu tool
	 * @return the menu tool
	 */
	public JMenu getToolMenu() {
		return this.toolMenu;
	}
	
	/**
	 * Get the text area
	 * @return the text area
	 */
	public JTextArea getTextArea() {
		return this.textArea;
	}
}
