package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.enchere.config.Settings;

/*
 * CONNEXION STANDARD (avec une bonne pratique de syntaxe SAUF POUR URL,login et MDP car ils sont "endure", alors qu'il faut "externaliser".)
 * Si j'ai plusieurs classe dans la couche DAL qui nécessite une connexion:
 * 	-	COPIER/COLLER ce code dans la classe en question.
 */
public class ConnectionProvider {

	/*
	 * Si CONNEXION = REUSSI alors renvoie moi la connexion.
	 * Si CONNEXION = ECHEC alors ne renvoie rien.
	 */
	public static Connection recupererConnexion() {
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection cnx = DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("login"), Settings.getProperty("password"));
			System.out.println("Connexion à la BDD réussie.");
			return cnx;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
