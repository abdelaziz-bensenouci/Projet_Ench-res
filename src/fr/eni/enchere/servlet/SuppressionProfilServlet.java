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

/**
 * Servlet implementation class SuppressionProfilServlet
 */
@WebServlet("/SuppressionProfilServlet")
public class SuppressionProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SuppressionProfilServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/PageAccueilNonConnecte");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		try {
			utilisateurManager.supprimerUtilisateur(utilisateur.getno_utilisateur());
		} catch (BLLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
}
