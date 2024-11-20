package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.exception.DALException;

public interface ArticleDAO {
	void ajouterArticle(Article article);
	List<Article> recupererArticles();
	List<Article> rechercheArticlesParCategorie(int no_categorie, String titre);
	void supprimerArticle(int numeroArticle) throws DALException;
	Article recupererArtcileParNumero(int no_article) throws DALException;
}
