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

PluginFrame

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


Ici pluginCache permet de récupérer facilement un plugin ajouté en fonction de son label,
ce qui permet une suppression facile du plugin


PluginFinder

	public void checkDir() {
		if (this.previousFiles.size() < this.files.size()) {
			this.fireAddingFile();
		} else if (this.previousFiles.size() > this.files.size()) {
			this.fireRemovingFile();
		}
		this.previousFiles = this.files;
	}


Cette méthode permet de savoir si un fichier a été ajouté ou supprimé et d'envoyer les événements
correspondants


TimeActionListener

	public void actionPerformed(ActionEvent e) {
		String[] t = this.finder.getDir().list(this.finder.getFilter());
		this.finder.setFiles(new ArrayList<String>(Arrays.asList(t)));
		this.finder.checkDir();
	}


Cette méthode permet de mettre à jour la liste courante des fichiers que le programme
accepte