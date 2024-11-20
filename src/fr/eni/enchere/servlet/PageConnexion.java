package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DaoFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

/**
 * Servlet implementation class PageConnexion
 */
@WebServlet("/PageConnexion")
public class PageConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageConnexion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("id");
		String motDePasse = request.getParameter("motDePasse");
		
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		Utilisateur utilisateur;
		try {
			utilisateur = utilisateurManager.recupererUtilisateurParIdentifiantEtMotDePasse(identifiant, motDePasse);
			
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect(request.getContextPath() + "/PageListeEncheresConnecte");
		} catch (BLLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/PageCreerCompte");
		}
	}
}
