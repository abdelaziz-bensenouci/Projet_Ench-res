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

@WebServlet("/PageProfil")
public class PageProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageProfil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		try {
			Utilisateur utilisateurVente = utilisateurManager.recupererUtilisateurParPseudo(pseudo);
			request.setAttribute("utilisateurVente", utilisateurVente);
			request.getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request, response);
		} catch (BLLException e) {
			response.sendRedirect(request.getContextPath() + "/PageListeEncheresConnecte");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}