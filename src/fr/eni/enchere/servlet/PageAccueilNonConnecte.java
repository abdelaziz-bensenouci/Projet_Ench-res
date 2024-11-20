package fr.eni.enchere.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DaoFactory;

/**
 * Servlet implementation class PageAccueilNonConnecte
 */
@WebServlet("/PageAccueilNonConnecte")
public class PageAccueilNonConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageAccueilNonConnecte() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CREER une instance de la classe "ArticleDAO" en utilisant une fabrique ("DaoFactory")
		// - PERMET d'accéder à la couche (DAO) pour les articles.
		ArticleDAO articleDAO = DaoFactory.getArticleDAO();

		// APPELLE la méthode "recupererDeuxArticles()" de l'objet "articleDAO", qui est le DAO pour les articles.
		List<Article> listeArticles = articleDAO.recupererArticles();

		// TRANSMET les données que "articles" a récupérer, à la JSP.
		request.setAttribute("articles", listeArticles);

		request.getRequestDispatcher("/WEB-INF/AccueilNonConnecte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CONVERTIT le "String" en "int" car l'APPEL de la categorie est de type "int".
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		String titre = request.getParameter("titre");

		if (categorie == 0) {
			doGet(request, response);
		} else {

			ArticleDAO articleDAO = DaoFactory.getArticleDAO();
			List<Article> listeRechercheArticles = articleDAO.rechercheArticlesParCategorie(categorie, titre);

			request.setAttribute("articles", listeRechercheArticles);
		}
		request.getRequestDispatcher("/WEB-INF/AccueilNonConnecte.jsp").forward(request, response);
	}
}
