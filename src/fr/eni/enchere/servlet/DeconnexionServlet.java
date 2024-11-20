package fr.eni.enchere.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Deconnexion")
public class DeconnexionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Récupérer la session 
        HttpSession session = request.getSession();

        // Supprimer l'objet utilisateur de la session
        session.removeAttribute("utilisateur"); 
        

        // Invalider la session
        session.invalidate();

        // Rediriger apres la déconnexion
        response.sendRedirect(request.getContextPath() + "/PageConnexion");
    }
}
