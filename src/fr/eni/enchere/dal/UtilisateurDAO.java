package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;

//1ere étape DAO
public interface UtilisateurDAO {

	// CRUD
	/**
	 * Ajout d'un utilisateur à la BDD UTILISATEURS
	 * 
	 * @param utilisateur
	 * @throws DALException
	 */
	void ajouterUtilisateur(Utilisateur utilisateur) throws DALException;

	/**
	 * Supprimer un utilisateur de la BDD UTILISATEURS via sa PK 'noUtilisateur'
	 * 
	 * @param noUtilisateur
	 * @throws DALException
	 */
	void supprimerUtilisateur(int noUtilisateur) throws DALException;

	/**
	 * Modifie les données d'un utilisateur via sa PK 'noUtilisateur'
	 * 
	 * @param noUtilisateur
	 * @param utilisateur   utilisateur avec les nouveaux paramètres
	 * @throws DALException
	 */
	void modifDonneesUtilisateur(int noUtilisateur, Utilisateur utilisateur) throws DALException;
	
	/**
	 * Liste de tous les utilisateurs de la BDD UTILISATEURS
	 * 
	 * @return
	 * @throws DALException
	 */
	List<Utilisateur> recupererTousLesUtilisateurs() throws DALException;

	/**
	 * Retourne 'True' si le pseudo existe déjà dans la BDD
	 * 
	 * @param pseudo
	 * @return
	 * @throws DALException 
	 */
	boolean pseudoExistantUtilisateur(String pseudo) throws DALException;
	
	/**
	 * Retourne 'True' si l'email existe déjà dans la BDD
	 * 
	 * @param email
	 * @return
	 * @throws DALException
	 */
	boolean emailExistantUtilisateur(String email) throws DALException;

	/**
	 * Retourne un utilisateur en le recherchant par l'identifiant donné et le mdp
	 * 
	 * @param identifiant
	 * @param motDePasse
	 * @return Utilisateur par identifiant et mdp
	 * @throws DALException
	 */
	Utilisateur recupererUtilisateurParIdentifiantEtMotDePasse(String identifiant, String motDePasse) throws DALException;

	/**
	 * Retourne un utilisateur en le recherchant par le pseudo uniquement
	 * 
	 * @param identifiant
	 * @return Utilisateur par pseudo 
	 * @throws DALException
	 */
	Utilisateur recupererUtilisateurParPseudo(String pseudo) throws DALException;
}
