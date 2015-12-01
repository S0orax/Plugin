package main;

import plugins.PluginFinder;
import editor.PluginAddedLogger;
import editor.PluginFrame;

public class Main {
	
	public static void main(String[] argv) {
		PluginFinder finder = new PluginFinder("plugins");
		finder.addPluginListener(new PluginAddedLogger());
		finder.addPluginListener(new PluginFrame());
		finder.start();
	}
}
