package fr.eni.enchere.bll;

public class NOTE {

	
	// Se faire une classe codeResultatBLL qui comprant tous les codes en public static final int 
	/** 
	 * A faire
	 * 	pseudo slt en char alphanum  
	 *  page d'acceuil == page par défaut si aucune ressource indiquée dans url
	 *  hash de MDP se fait à quel niveau?
	 *  penser à enlever les inputs dans la jsp MonProfil.jsp
	 * 
	 *  
	 *  R:
	 *  ajouter l'autofocus sur les pages pour pouvoir tab? --- on peut tab mais ordre chelou
	 *  pourquoi quand on se co on a 2x le "connexion à BDD réussie"? ---
	 *  	pcq on fait d'abbord un "Connection connexion = ConnectionProvider.recupererConnexion()"
	 *  	puis un "connexion.prepareStatement()"
	 * 
	 * -------------------------------------------------------
	 * 
	 * 
	 * MODIFS
	 * --------- PageProfil --- A FAIRE
	 * Reste à modif le fait qu'il affiche bien le profil de l'utilisateur demané mais faudra add une meth dans Utilisateur manager --- 1/2 FAIT
	 * 	>>> pour le moment renvoit uniquement sur la page de toto >>> comment on envois le "article.pseudo" vers la PageProfil?
	 * penser à mettre le lien sur les pages PageListeEncheresCo --- FAIT
	 * 
	 * --------- PageEncherir --- A FAIRE
	 * idem manque la bonne redirection et l'attribut article
	 * 
	 * --------- PageAcquisition --- A FAIRE
	 * Creer la page une fois que la PageEncherir est nickel
	 * 
	 * --------- PageDetailMaVenteFinEnchere --- A FAIRE
	 * Creer la page une fois que la PageEncherir est nickel
	 * 
	 * 
	 * 
	 * 
	 * --------- Creer un compte --- PAS FAIT
	 * si pseudo / mail deja existant recharger PageCreerCompte et mettre mess dd'alerte rouge comme quoi il existe déjà un compte avec ce log
	 * 
	 * --------- Connexion --- PAS FAIT
	 * si mauvais pseudo redirige vers PageCreerCompte ---> il faudrait rediriger vers PageConnexion + avoir un message d'erreur de login en rouge?
	 * R: la connexion au compte est assez longue on dirait
	 * 
	 * --------- Acceuil non co --- PAS FAIT
	 * PageAcceuilNonConnecte -> doit être la "destination par défaut si aucune ressource n’est indiquée dans l’url SAUF SI 
	 * 	l’url ne précise pas de ressource (http://localhost:8080/encheres/), la page affichée est la page de connexion"
	 * -> rediriger vers cette page dès qu'on clique sur "ENI-Enchère"?
	 *  
	 * 
	 * 
	 * 
	 * ----->>>>> MANQUE TOUTES LES ERREURS DE SERVLETS == FAIRE LES CODES ERREURS <<<<<--------
	 */
}
