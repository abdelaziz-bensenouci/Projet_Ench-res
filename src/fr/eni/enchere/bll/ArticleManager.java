package fr.eni.enchere.bll;

import java.sql.SQLException;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DaoFactory;
import fr.eni.enchere.dal.exception.DALException;

public class ArticleManager {
	private static ArticleManager instancearticle;

	private ArticleManager() {
	}

	public static ArticleManager getInstance() {
		if (instancearticle == null) {
			instancearticle = new ArticleManager();
		}
		return instancearticle;
	}

	private void validerArticle(Article article) throws BLLException {
		if (article == null) {
			throw new BLLException("Article NULL");
		}

		if (article.getNom_article() == null && article.getDescription().isEmpty()) {
			throw new BLLException("Le nom de l'article et une description est obligatoire!");
		}
	}

	public void ajouterArticle(Article article) throws BLLException, SQLException {
		try {
			validerArticle(article);
			ArticleDAO articleDAO = DaoFactory.getArticleDAO();
			articleDAO.ajouterArticle(article);
		} catch (BLLException e) {
			e.printStackTrace();
			throw new BLLException("Probleme lors de l'ajout de l'article dans la BDD!");
		}
	}

	public void supprimerArticle(int no_article) throws BLLException, DALException {
		try {
			ArticleDAO articleDAO = DaoFactory.getArticleDAO();
			articleDAO.supprimerArticle(no_article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la suppression de l'article.");
		}
	}
	
	public Article recupererArticleParNumero(int no_article) throws BLLException {
		try {
			ArticleDAO articleDAO = DaoFactory.getArticleDAO();
			return articleDAO.recupererArtcileParNumero(no_article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la suppression de l'article.");
		}
	}
}
