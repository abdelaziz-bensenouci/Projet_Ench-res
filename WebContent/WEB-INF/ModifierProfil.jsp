<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="./style/CreerCompte.css">
<link rel="stylesheet" href="./style/StyleBouton.css">

<title>Mon profil</title>
</head>
<body>
    <header>
    <a href="PageListeEncheresConnecte" class="lien-icone">
			<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
        </a>
    </header>
    <main>
        <h1>Mon profil</h1>
        <form action="PageModifierProfil" method="post">
            <div class="form">
                <div class="form-colonne">
                    <div class="form-saisie">
                        <label for="pseudo">Pseudo :</label>
                        <input type="text" name="pseudo" value="${utilisateur.pseudo}">
                    </div>
                    <div class="form-saisie">
                        <label for="prenom">Prenom :</label>
                        <input type="text" name="prenom" value="${utilisateur.prenom}">
                    </div>
                    <div class="form-saisie">
                        <label for="telephone">Telephone :</label>
                        <input type="tel" name="telephone" value="${utilisateur.telephone}">
                    </div>
                    <div class="form-saisie">
                        <label for="codePostal">Code Postal :</label>
                        <input type="text" name="codePostal" value="${utilisateur.codePostal}">
                    </div>
                    <div class="form-saisie">
                        <label for="actuelMotDePasse">Mot de passe actuel :</label>
                        <input type="password" name="actuelMotDePasse">
                    </div>
                    <div class="form-saisie">
                        <label for="nouveauMotDePasse">Nouveau Mot de passe :</label>
                        <input type="password" name="nouveauMotDePasse">
                    </div>
                    <div class="credit">
                    <p>Crédit : ${utilisateur.credit}</p>
                    </div>
                </div>
                <div class="form-colonne">
                    <div class="form-saisie">
                        <label for="nom">Nom :</label>
                        <input type="text" name="nom" value="${utilisateur.nom}">
                    </div>
                    <div class="form-saisie">
                        <label for="email">Email :</label>
                        <input type="email" name="email" value="${utilisateur.email}">
                    </div>
                    <div class="form-saisie">
                        <label for="rue">Rue :</label>
                        <input type="text" name="rue" value="${utilisateur.rue}">
                    </div>
                    <div class="form-saisie">
                        <label for="ville">Ville :</label>
                        <input type="text" name="ville" value="${utilisateur.ville}">
                    </div>                  
                    <div class="form-saisie">
                        <label for="confirmerMotDePasse">Confirmation Mot de passe :</label>
                        <input type="password" name="confirmerMotDePasse">
                    </div>
                </div>
            </div>
            <div class="logIN">
            <input type="submit" value="Enregistrer" id="buttonCnx" formaction="PageModifierProfil">
                <input type="submit" value="Supprimer mon compte" formaction="SuppressionProfilServlet" class="btn-annuler">
            </div>
        </form>
    </main>
    <footer>
    </footer>
</body>
</html>
