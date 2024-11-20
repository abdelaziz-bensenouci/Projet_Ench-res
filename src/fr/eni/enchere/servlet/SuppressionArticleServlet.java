package fr.eni.enchere.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.exception.DALException;

/**
 * Servlet implementation class SuppressionArticleServlet
 */
@WebServlet("/SuppressionArticleServlet")
public class SuppressionArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuppressionArticleServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/PageAccueilNonConnecte");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Article article = (Article) request.getSession().getAttribute("article");

	    if (article != null) {
	        ArticleManager articleManager = ArticleManager.getInstance();
	        try {
	            articleManager.supprimerArticle(article.getNo_article());
	        } catch (DALException e) { //je ne comprends pas trop je suis oblige de mettre cette ligne
	            e.printStackTrace();
	        } catch (BLLException e) {
	        	e.printStackTrace();
	            }
	    } else {
	        System.out.println("Article non trouvé dans la session.");
	    }

	    // Après suppression 
	    response.sendRedirect("PageListeEncheresConnecte");
	}
}
