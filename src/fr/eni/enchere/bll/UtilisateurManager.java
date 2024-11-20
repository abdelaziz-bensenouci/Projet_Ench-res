package fr.eni.enchere.bll;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DaoFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.exception.DALException;

public class UtilisateurManager {

	/******* Début Singleton **********/
	// Création d'un attribut de classe static
	private static UtilisateurManager instance;

	// Constructeur en privé
	private UtilisateurManager() {
	}

	// Méthode qui renvoie l'instance unique
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	/******* Fin de Singleton **********/

	/**
	 * meth pour valider les infos de l'utilisateur quand celui ci ne possède pas de compte
	 * 
	 * @param utilisateur
	 * @throws BLLException
	 */
	private void validerNouveauUtilisateur(Utilisateur utilisateur) throws BLLException {
		if (utilisateur == null) {
			throw new BLLException("Utilisateur NULL");
		}
		// Vérification qu'aucun des champs n'est vide --- pas ouf voir pour faire mieux
		// peut etre pas necessaire si on rend tous les champs obligatoires
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
			throw new BLLException("Pseudo Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()) {
			throw new BLLException("Nom Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
			throw new BLLException("Prenom Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
			throw new BLLException("Email Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().isEmpty()) {
			throw new BLLException("Telephone Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().isEmpty()) {
			throw new BLLException("Rue Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isEmpty()) {
			throw new BLLException("CodePostal Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().isEmpty()) {
			throw new BLLException("Ville Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isEmpty()) {
			throw new BLLException("MDP Utilisateur NULL / EMPTY");
		}

		// Vérification d'un email et d'un pseudo unique pour toute la BDD
		
		if (pseudoExistantUtilisateur(utilisateur.getPseudo())) {
			throw new BLLException("Ce pseudo possède déjà un compte !");
		}
		if (emailExistantUtilisateur(utilisateur.getEmail())) {
			throw new BLLException("Un compte a déjà été créé avec cet email !");
		}
	}
	
	/**
	 * Valider les infos de l'utilisateur quand celui ci possède déjà un compte
	 * @param utilisateur
	 * @throws BLLException
	 */
	private void validerUtilisateurExistant(Utilisateur utilisateur) throws BLLException {
		if (utilisateur == null) {
			throw new BLLException("Utilisateur NULL");
		}
		// Vérification qu'aucun des champs n'est vide --- pas ouf voir pour faire mieux
		// peut etre pas necessaire si on rend tous les champs obligatoires
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
			throw new BLLException("Pseudo Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()) {
			throw new BLLException("Nom Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
			throw new BLLException("Prenom Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
			throw new BLLException("Email Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().isEmpty()) {
			throw new BLLException("Telephone Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().isEmpty()) {
			throw new BLLException("Rue Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isEmpty()) {
			throw new BLLException("CodePostal Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().isEmpty()) {
			throw new BLLException("Ville Utilisateur NULL / EMPTY");
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isEmpty()) {
			throw new BLLException("MDP Utilisateur NULL / EMPTY");
		}
	}

	/**
	 * meth pour l'ajout d'un utilisateur
	 * 
	 * @param utilisateur
	 * @throws BLLException
	 */
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			validerNouveauUtilisateur(utilisateur);
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			utilisateurDAO.ajouterUtilisateur(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Probleme dans l'ajout à la bdd!");
		}
	}

	/**
	 * meth pour valider la supp d'un profil
	 * 
	 * @param utilisateur
	 * @param no_utilisateur
	 * @throws BLLException
	 */
	public void supprimerUtilisateur(int no_utilisateur) throws BLLException {
		try {
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			utilisateurDAO.supprimerUtilisateur(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la suppression de l'utilisateur.");
		}
	}

	/**
	 *  meth pour valider la gestion du profil
	 * @param utilisateur
	 * @param no_utilisateur
	 * @param typeAChanger
	 * @param nouvelleValeur
	 * @throws BLLException
	 */
	public void gererUtilisateur(int no_utilisateur, Utilisateur utilisateur) throws BLLException {
		try {
			validerUtilisateurExistant(utilisateur);
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			utilisateurDAO.modifDonneesUtilisateur(no_utilisateur, utilisateur);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	// meth pour valider la recup de tous les profils
	public void recupererTousLesUtilisateurs() throws DALException {
		try {
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			utilisateurDAO.recupererTousLesUtilisateurs();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Vérifie l'existence du pseudo donné dans la BDD
	 * @param pseudo
	 * @return true si le pseudo existe, false sinon
	 * @throws BLLException
	 */
	public boolean pseudoExistantUtilisateur(String pseudo) throws BLLException {
		try {
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			return utilisateurDAO.pseudoExistantUtilisateur(pseudo);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Ce pseudo n'est pas valide");
		}
	}
	
	/**
	 * Vérifie l'existence de l'email dans la BDD
	 * @param email
	 * @return true si l'email existe, false sinon
	 * @throws BLLException
	 */
	public boolean emailExistantUtilisateur(String email) throws BLLException {
		try {
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			return utilisateurDAO.pseudoExistantUtilisateur(email);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Cet email n'est pas valide");
		}
	}

	/**
	 * Retourne l'utilisateur en le recherchant dans la BDD par son identifiant et son MDP
	 * @param identifiant
	 * @param motDePasse
	 * @return Utilisateur
	 * @throws DALException
	 * @throws BLLException 
	 */
	public Utilisateur recupererUtilisateurParIdentifiantEtMotDePasse(String identifiant, String motDePasse) throws BLLException {
		try {
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			return utilisateurDAO.recupererUtilisateurParIdentifiantEtMotDePasse(identifiant, motDePasse);	
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Cet Utilisateur n'existe pas.");
		}	
	}
	
	/**
	 * Retourne l'utilisateur en le recherchant dans la BDD par son pseudo uniquement
	 * @param pseudo
	 * @return Utilisateur
	 * @throws DALException
	 * @throws BLLException 
	 */
	public Utilisateur recupererUtilisateurParPseudo(String pseudo) throws BLLException {
		try {
			UtilisateurDAO utilisateurDAO = DaoFactory.getUtilisateurDAO();
			return utilisateurDAO.recupererUtilisateurParPseudo(pseudo);	
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Cet Utilisateur n'existe pas.");
		}	
	}
}
