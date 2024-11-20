package fr.eni.enchere.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionSuivi implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        session.setAttribute("heureactuelle", System.currentTimeMillis());
        session.setAttribute("derniereactivite", System.currentTimeMillis());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }

    public static void miseajourdeladerniereactivite(HttpSession session) {
        session.setAttribute("derniereactivite", System.currentTimeMillis());
    }

}

