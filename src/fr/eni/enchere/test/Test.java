package fr.eni.enchere.test;


import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DaoFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.jdbc.ConnectionProvider;

public class Test {

	public static void main(String[] args) throws BLLException {
//----------AJOUT Utilisateur----------		
		//UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
		//Utilisateur utilisateur = new Utilisateur("Khal", "SANCHEZ", "Greg", "greg@greg.fr", "0612234556", "Rue des tulipes", "33000", "Bordeaux", "1234", 100, false);
		//utilisateurDAO.ajouterUtilisateur(utilisateur);
		
		
		//ArticleDAO ArticleDAO = DaoFactory.getArticleDAO();
		//ARTICLES Article = new ARTICLES("ordinateur", "ordinateur neuf", "11/10/2023", "11/11/2023", 1000, 500, 35, 1);
		//ArticleDAO.ajouterArticle(Article);
//----------SUPPRIMER Utilisateur----------	
		//UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
		//utilisateurDAO.supprimerUtilisateur(14);
		
//		ArticleDAO articleDAO = DaoFactory.getArticleDAO();
//		System.out.println(articleDAO.recupererArticles());
		
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		Utilisateur utilisateur = utilisateurManager.recupererUtilisateurParPseudo("ui");
		System.out.println(utilisateur);
		
		//ConnectionProvider.recupererConnexion();
		
	}

}
