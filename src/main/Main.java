package main;

import editor.PluginAddedLogger;
import plugins.PluginFinder;

public class Main {
	
	public static void main(String[] argv) {
		PluginFinder finder = new PluginFinder("plugins");
		finder.addPluginListener(new PluginAddedLogger());
		finder.start();
	}
}
