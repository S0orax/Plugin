# Plugin

DUBOIS Yann

ORIEUX Baptiste

HERAS Guillaume

05/12/2015

## Introduction

Ce logiciel est un éditeur de texte où nous pouvons ajouter des plugins de manière dynamique,
ce qui a un effet sur le texte lorsque le plugin est sélectionné

## Usage

Voici la commande à lancer pour lancer le jar

`java -jar plugin_dubois_orieux_heras.jar`

Pour ajouter des plugins, ils suffis d'ajouter la class dans le dossier : ./dropins/plugins

## Architecture

En terme d'architecture, il n'y a pas grand chose à dire, mise à par le système d'événement
vue en cours :

PluginListener : L'interface qui s'occupe de créer les événement, chaque classe écoutera les
méthodes d'événement

PluginFinder : C'est l'ordonanceur d'événement, c'est cette classe qui envoie les événements aux
écouteurs

PluginAddedLogger et PluginFrame sont les receveurs des événements, l'un s'occupe d'inscrire un
message dans la console, l'autre s'occupe de l'ajout du plugin dans tool et de transformer le texte
si besoin

## Code Sample

`

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
`