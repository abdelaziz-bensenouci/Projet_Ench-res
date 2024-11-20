package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.jdbc.ArticleDaoJdbcImpl;

@WebServlet("/PageVendreUnArticle")
public class PageVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PageVendreUnArticle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

        if (utilisateur != null) {
            
            request.setAttribute("rueUtilisateur", utilisateur.getRue());
            request.setAttribute("codePostalUtilisateur", utilisateur.getCodePostal());
            request.setAttribute("villeUtilisateur", utilisateur.getVille());
            request.setAttribute("no_utilisateur", utilisateur.getno_utilisateur());
        }
        
        request.getRequestDispatcher("/WEB-INF/VendreUnArticle.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        String pseudo = request.getParameter("pseudo");
        String nomArticle = request.getParameter("nom_article");
        String description = request.getParameter("description");
        String dateDebutEncheres = request.getParameter("datedebut");
        String dateFinEncheres = request.getParameter("datefin");
        int prixInitial = Integer.parseInt(request.getParameter("prixInitial"));;
        int prixVente = 0; //  sera mis à jour lors de la vente
        Integer noCategorie = null; // Valeur par défaut en cas de valeur invalide ou non sélectionnée dans le formulaire
        String categorieParam = request.getParameter("categorie");
        if (categorieParam != null && !categorieParam.isEmpty()) {
            noCategorie = Integer.parseInt(categorieParam);
        }
        int noUtilisateur = utilisateur.getno_utilisateur();
        Article article = new Article(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, noUtilisateur, noCategorie, pseudo);
        ArticleDAO articleDAO = new ArticleDaoJdbcImpl();
        articleDAO.ajouterArticle(article);

        response.sendRedirect("PageListeEncheresConnecte");
    }
}


