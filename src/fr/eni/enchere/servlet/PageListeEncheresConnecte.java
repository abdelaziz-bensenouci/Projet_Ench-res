package fr.eni.enchere.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DaoFactory;

/**
 * Servlet implementation class PageListeEncheresConnecte
 */
@WebServlet("/PageListeEncheresConnecte")
public class PageListeEncheresConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageListeEncheresConnecte() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		if (utilisateur != null) {
			ArticleDAO articleDAO = DaoFactory.getArticleDAO();
			List<Article> listeArticles = articleDAO.recupererArticles();
			/// A MODIF --- passer par la BLL pour ça

			request.setAttribute("articles", listeArticles);
			request.getRequestDispatcher("/WEB-INF/ListeEncheresConnecte.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/PageCreerCompte");
		}
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

		request.getRequestDispatcher("/WEB-INF/ListeEncheresConnecte.jsp").forward(request, response);
	}

}
