package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.exception.DALException;

public class ArticleDaoJdbcImpl implements ArticleDAO {

	private static final String ARTICLE_SQL_AJOUTER = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private static final String ARTICLE_SQL_SUPPRIMER_PAR_NO_ARTICLE = "DELETE ARTICLES_VENDUS WHERE no_article = ?";
	//private static final String ARTICLE_SQL_MODIFIER = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? WHERE no_article=?";
	private static final String ARTICLE_SQL_RECUPERER_ARTICLES = "SELECT * FROM ARTICLES_VENDUS AS A JOIN UTILISATEURS AS U ON A.no_utilisateur = U.no_utilisateur";
	private static final String ARTICLE_SQL_RECHERCHER_ARTICLE_PAR_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS AS A JOIN UTILISATEURS AS U ON A.no_utilisateur = U.no_utilisateur WHERE no_categorie = ? AND nom_article LIKE ?";
	//"LIKE ?" = SELECTIONNE les enregistrements où la valeur de la colonne "nom_article" correspond partiellement à la valeur fournie en paramètre (le deuxième paramètre de la requête).
	//Le symbole "%" dans le paramètre indique qu'il peut y avoir n'importe quelle séquence de caractères avant ou après la valeur fournie.
	// - Cela nous permet d'effectuer une recherche partielle dans le titre de l'article.
	private static final String ARTICLE_SQL_RECUPERER_ARTICLE_PAR_NO_ARTCILE = "SELECT * FROM ARTICLES_VENDUS AS A JOIN UTILISATEURS AS U ON A.no_utilisateur = U.no_utilisateur WHERE no_article= ?";
	
	// private static final String ARTICLE_SQL_RECUPERER_DEUX_ARTICLES = "SELECT *
	// FROM ARTICLES_VENDUS ORDER BY RAND() LIMIT 2";

	@Override
	public void ajouterArticle(Article article) {
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			// CREATION
			PreparedStatement pStmt = connexion.prepareStatement(ARTICLE_SQL_AJOUTER);

			// INJECTION

			pStmt.setString(1, article.getNom_article());
			pStmt.setString(2, article.getDescription());
			pStmt.setString(3, article.getDate_debut_encheres());
			pStmt.setString(4, article.getDate_fin_encheres());
			pStmt.setInt(5, article.getPrix_initial());
			pStmt.setInt(6, article.getPrix_vente());
			pStmt.setInt(7, article.getNo_utilisateur());
			pStmt.setInt(8, article.getNo_categorie());

			System.out.println("L'article " + article.getNom_article() + " a bien été ajouté");

			// EXECUTE
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Article> recupererArticles() {
		List<Article> article = new ArrayList<>();

		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			Statement stmt = connexion.createStatement();

			ResultSet rs = stmt.executeQuery(ARTICLE_SQL_RECUPERER_ARTICLES);
			while (rs.next()) {
				article.add(new Article(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getString("date_debut_encheres"),
						rs.getString("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"),
						rs.getInt("no_utilisateur"), rs.getInt("no_categorie"), rs.getString("pseudo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public List<Article> rechercheArticlesParCategorie(int no_categorie, String titre) {
		List<Article> rechercheArticles = new ArrayList<>();

		try (Connection connexion = ConnectionProvider.recupererConnexion()) {
			// CREATION "PreparedStatement" + REQUETE SQL via notre CONSTANTE
			PreparedStatement pStmt = connexion.prepareStatement(ARTICLE_SQL_RECHERCHER_ARTICLE_PAR_CATEGORIE);

			// SELECTIONNE l'Article en définissant les paramètres
			pStmt.setInt(1, no_categorie);
			// % = RECHERCHE une correspondance partielle dans la base de données.
			//EXEMPLE: - Si titre est "ordi", cela recherchera tous les articles dont le titre contient le mot "ordi", comme "Ordinateur portable", "Accessoire pour ordinateur", etc.
			pStmt.setString(2, "%" + titre + "%");

			// EXECUTE
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				rechercheArticles.add(new Article(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getString("date_debut_encheres"),
						rs.getString("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"),
						rs.getInt("no_utilisateur"), rs.getInt("no_categorie"), rs.getString("pseudo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rechercheArticles;
	}

    @Override
    public void supprimerArticle(int numeroArticle) throws DALException {
       try (Connection connexion = ConnectionProvider.recupererConnexion()) {

    	   PreparedStatement pStmt = connexion.prepareStatement(ARTICLE_SQL_SUPPRIMER_PAR_NO_ARTICLE);
    	   pStmt.setInt(1, numeroArticle);
    	   pStmt.executeUpdate();
			System.out.println("L'article a bien été supprimé");

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Suppression article",e);
		}
	}
    
	@Override
	public Article recupererArtcileParNumero(int no_article) throws DALException{
	    try (Connection connexion = ConnectionProvider.recupererConnexion()) {
	    	PreparedStatement pStmt;
	    	pStmt = connexion.prepareStatement(ARTICLE_SQL_RECUPERER_ARTICLE_PAR_NO_ARTCILE);
	    	pStmt.setInt(1, no_article);
	        ResultSet rs = pStmt.executeQuery();
	        Article article = null;
			while (rs.next()) {
				article = new Article(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getString("date_debut_encheres"),
						rs.getString("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"),
						rs.getInt("no_utilisateur"), rs.getInt("no_categorie"), rs.getString("pseudo"));
			}
	        return article;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException("Problème au niveau de la récupération d'un article.", e);
	    }
	}
}

