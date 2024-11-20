package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class PageEncherir
 */
@WebServlet("/PageAcquisition")
public class PageAcquisition extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PageAcquisition() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noArticle = Integer.parseInt(request.getParameter("noArticle"));
		
		try {
			ArticleManager articleManager = ArticleManager.getInstance();
			Article article = articleManager.recupererArticleParNumero(noArticle);
			String pseudo = article.getPseudo();
			
			UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
			Utilisateur utilisateurVente = utilisateurManager.recupererUtilisateurParPseudo(pseudo);
			
			request.setAttribute("utilisateurVente", utilisateurVente);
			request.setAttribute("article", article);
			
			request.getRequestDispatcher("/WEB-INF/Acquisition.jsp").forward(request, response);
		} catch (BLLException e) {
			response.sendRedirect(request.getContextPath() + "/PageListeEncheresConnecte");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
