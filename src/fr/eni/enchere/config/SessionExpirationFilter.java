package fr.eni.enchere.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")// Permet d appliquer le filtre sur toutes les urls du site
public class SessionExpirationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        // Vérifie si l'utilisateur est connecté
        boolean isConnected = session.getAttribute("utilisateur") != null;

        if (isConnected) {
            long heureActuelle = System.currentTimeMillis();
            Long derniereActivite = (Long) session.getAttribute("lastActivityTime");

            // Vérification si 5 minutes se sont écoulées
            long fiveMinutesInMillis = 5 * 60 * 1000; // 5 minutes en millisecondes (il faut penser a remettre a 5 minutes je l ai modifier pour les test)
            if (derniereActivite != null && heureActuelle - derniereActivite > fiveMinutesInMillis) {
                // 5 minutes se sont écoulées, déconnecter l'utilisateur
                session.invalidate();
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/PageConnexion");
                return; // Arrêter le filtre 
            } else {
                // Maj du dernier temps d'activité
                session.setAttribute("lastActivityTime", heureActuelle);
            }
        }

        chain.doFilter(request, response); // Laisser la requête continuer vers la servlet
    }

    @Override
    public void destroy() {
    }
}
