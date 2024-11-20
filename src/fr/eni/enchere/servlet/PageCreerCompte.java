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


@WebServlet("/PageCreerCompte")
public class PageCreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/CreerCompte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmerMotDePasse = request.getParameter("confirmerMotDePasse");
		int credit = 0;
		boolean administrateur = false;

		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		// Vérfication que MDP = confirmation MDP
		if (!motDePasse.isEmpty() && motDePasse.compareTo(confirmerMotDePasse) == 0) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, credit, administrateur);
			try {
				utilisateurManager.ajouterUtilisateur(utilisateur);
				request.getSession().setAttribute("utilisateur", utilisateur);
				response.sendRedirect(request.getContextPath() + "/PageListeEncheresConnecte");
			} catch (BLLException e) {
				response.sendRedirect(request.getContextPath() + "/PageCreerCompte");
				e.printStackTrace();
			}
		} else {
			System.out.println("Mot de passe incorrect / Ne correspond pas à sa vérification"); // creer les codes err
			response.sendRedirect(request.getContextPath() + "/PageCreerCompte");
			// ajouter texte en rouge comme quoi mdp non-identique / érroné
		}
	}
}
