package fr.eni.enchere.config;

import java.io.IOException;
import java.util.Properties;

public class Settings {

	private static Properties properties;
	
	/*
	 * Syntaxe pour EXTERNALISER une chaine de caractère.
	 * Le "BLOC" static permet d'initialiser en 1er l'instruction qui est à l'intérieur.
	 * C'est l'initailisation d'une classe static.
	 */
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);		
	}
}
