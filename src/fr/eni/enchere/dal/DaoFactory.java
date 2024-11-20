package fr.eni.enchere.dal;

import fr.eni.enchere.dal.jdbc.ArticleDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.UtilisateurDaoJdbcImpl;

public abstract class DaoFactory {

	//3eme étape DAO
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDaoJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDaoJdbcImpl();
	}
}
