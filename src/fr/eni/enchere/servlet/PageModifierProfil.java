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

@WebServlet("/PageModifierProfil")
public class PageModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageModifierProfil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		int noUtilisateur = utilisateur.getno_utilisateur();

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String actuelMotDePasse = request.getParameter("actuelMotDePasse");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmerMotDePasse = request.getParameter("confirmerMotDePasse");

		if (confirmerMotDePasse != null && !confirmerMotDePasse.isEmpty()) {
			System.out.println(2);
			// le MDP saisis au niveau de "Mot de passe actuel" est le même que
			// l'utilisateur actuel et nouveau MDP = MDP confirmé
			if (nouveauMotDePasse.compareTo(confirmerMotDePasse) == 0
					&& actuelMotDePasse.compareTo(utilisateur.getMotDePasse()) == 0) {
				Utilisateur nouveauUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal,
						ville, confirmerMotDePasse);
				UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
				try {
					utilisateurManager.gererUtilisateur(noUtilisateur, nouveauUtilisateur);
					request.getSession().setAttribute("utilisateur", nouveauUtilisateur);
					request.getRequestDispatcher("/PageMonProfil").forward(request, response);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		} else {
			// Si le MDP saisis au niveau de "Mot de passe actuel" n'est pas bon ou/et si le
			// nouveau MDP n'est pas le même que celui confirmé
			response.sendRedirect(request.getContextPath() + "/PageModifierProfil");
			// rajouter une alerte en rouge 'MDP non Identique'
		}
	}
}