package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.exception.DALException;

//2eme étpae DAO
public class UtilisateurDaoJdbcImpl implements UtilisateurDAO {

	private static final String UTILISATEUR_SQL_AJOUTER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UTILISATEUR_SQL_SUPPRIMER_PAR_NO_UTILISATEUR = "DELETE UTILISATEURS WHERE no_utilisateur = ?";
	private static final String UTILISATEUR_SQL_GERER_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?";
	private static final String UTILISATEUR_SQL_RECUP_LISTE_UTILISATEURS = "SELECT *  FROM UTILISATEURS";
	private static final String UTILISATEUR_SQL_RECUP_PSEUDO_EXISTANT = "SELECT pseudo FROM UTILISATEURS WHERE pseudo = ?";
	private static final String UTILISATEUR_SQL_RECUP_EMAIL_EXISTANT = "SELECT pseudo FROM UTILISATEURS WHERE email = ?";
	private static final String UTILISATEUR_SQL_RECUP_UTILISATEUR_PAR_PSEUDO_ET_MDP = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	private static final String UTILISATEUR_SQL_RECUP_UTILISATEUR_PAR_EMAIL_ET_MDP = "SELECT * FROM UTILISATEURS WHERE email = ? AND mot_de_passe = ?";
	private static final String UTILISATEUR_SQL_RECUP_UTILISATEUR_PAR_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
	
	
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) throws DALException {
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			PreparedStatement pStmt = connexion.prepareStatement(UTILISATEUR_SQL_AJOUTER);

			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, false);

			System.out.println("L'utilisateur " + utilisateur.getNom() + " a bien été ajouté");

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Ajout Utilisateur",e);
		}

	}

	@Override
	public void supprimerUtilisateur(int noUtilisateur) throws DALException{
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {
			
			PreparedStatement pStmt = connexion.prepareStatement(UTILISATEUR_SQL_SUPPRIMER_PAR_NO_UTILISATEUR);
			
			pStmt.setInt(1, noUtilisateur);
			
			pStmt.executeUpdate();
			System.out.println("L'utilisateur a bien été supprimé");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Suppression Utilisateur",e);
		}
	}

	@Override
	public void modifDonneesUtilisateur(int noUtilisateur, Utilisateur utilisateur) throws DALException{
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			PreparedStatement pStmt = connexion.prepareStatement(UTILISATEUR_SQL_GERER_UTILISATEUR);

			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, noUtilisateur);

			pStmt.executeUpdate();
			System.out.println("Le profil a été modifié.");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Mofication Utilisateur noUtilisateur = " + noUtilisateur,e);
		}
	}

	@Override
	public List<Utilisateur> recupererTousLesUtilisateurs() throws DALException{
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			PreparedStatement pStmt = connexion.prepareStatement(UTILISATEUR_SQL_RECUP_LISTE_UTILISATEURS);
			ResultSet rs = pStmt.executeQuery();

			List<Utilisateur> listeUtilisateurs = new ArrayList<>();
			while (rs.next()) {
				listeUtilisateurs.add(new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur")));
			}
			System.out.println("La liste des utilisateurs a été fournie.");
			return listeUtilisateurs;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Suppression Utilisateur",e);
		}
	}
	
	@Override
	public Utilisateur recupererUtilisateurParIdentifiantEtMotDePasse(String identifiant, String motDePasse) throws DALException {
	    try (Connection connexion = ConnectionProvider.recupererConnexion()) {
	    	PreparedStatement pStmt;
	    	if (pseudoExistantUtilisateur(identifiant)) {
	    		pStmt = connexion.prepareStatement(UTILISATEUR_SQL_RECUP_UTILISATEUR_PAR_PSEUDO_ET_MDP);
			} else if (emailExistantUtilisateur(identifiant)) {
				pStmt = connexion.prepareStatement(UTILISATEUR_SQL_RECUP_UTILISATEUR_PAR_EMAIL_ET_MDP);
			} else {
				throw new DALException("Identifiant innexistant");
			}

	    	pStmt.setString(1, identifiant);
	        pStmt.setString(2, motDePasse);
	        ResultSet rs = pStmt.executeQuery();
	        Utilisateur utilisateur = null;
	        while(rs.next()) {
	        	 utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
	        }
	        return utilisateur;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException("Problème d'identifiant / Mot de Passe incorrect.", e);
	    }
	}
	
	@Override
	public boolean pseudoExistantUtilisateur(String pseudo) throws DALException {
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			PreparedStatement pStmt = connexion.prepareStatement(UTILISATEUR_SQL_RECUP_PSEUDO_EXISTANT);

			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Echec de la vérification du pseudo", e);
		}
	}
	
	@Override
	public boolean emailExistantUtilisateur(String email) throws DALException {
		try (Connection connexion = ConnectionProvider.recupererConnexion()) {

			PreparedStatement pStmt = connexion.prepareStatement(UTILISATEUR_SQL_RECUP_EMAIL_EXISTANT);

			pStmt.setString(1, email);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Echec de la vérification de l'email", e);
		}
	}
	
	@Override
	public Utilisateur recupererUtilisateurParPseudo(String pseudo) throws DALException{
	    try (Connection connexion = ConnectionProvider.recupererConnexion()) {
	    	PreparedStatement pStmt;
	    	if (pseudoExistantUtilisateur(pseudo)) {
	    		pStmt = connexion.prepareStatement(UTILISATEUR_SQL_RECUP_UTILISATEUR_PAR_PSEUDO);
			} else {
				throw new DALException("Identifiant innexistant");
			}
	    	
	    	pStmt.setString(1, pseudo);
	        ResultSet rs = pStmt.executeQuery();
	        Utilisateur utilisateur = null;
	        while(rs.next()) {
	        	 utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
	        }
	        return utilisateur;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException("Problème d'identifiant / Mot de Passe incorrect.", e);
	    }
	}
	 
}
