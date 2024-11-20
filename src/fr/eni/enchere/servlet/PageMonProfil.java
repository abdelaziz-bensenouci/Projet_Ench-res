package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DaoFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

@WebServlet("/PageMonProfil")
public class PageMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageMonProfil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		if (utilisateur != null) {
			request.setAttribute("utilisateur", utilisateur);
			request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/PageCreerCompte");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}