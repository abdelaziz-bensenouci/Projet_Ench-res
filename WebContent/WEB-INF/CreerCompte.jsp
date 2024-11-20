<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="style/CreerCompte.css">
<link rel="stylesheet" href="style/StyleBouton.css">

<title>Creer Compte</title>
</head>
<body>
	<header>
		<a href="PageAccueilNonConnecte" class="lien-icone"> <img
			alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
	</header>
	<main>
		<h1>Mon profil</h1>
		<form action="PageCreerCompte" method="post">
			<div class="form">
				<div class="form-colonne">
					<div class="form-saisie">
						<label for="pseudo">Pseudo :</label> <input type="text"
							name="pseudo" id="pseudo">
					</div>
					<div class="form-saisie">
						<label for="prenom">Prenom :</label> <input type="text"
							name="prenom" id="prenom">
					</div>
					<div class="form-saisie">
						<label for="telephone">Telephone :</label> <input type="tel"
							name="telephone" id="telephone">
					</div>
					<div class="form-saisie">
						<label for="codePostal">Code Postal :</label> <input type="text"
							name="codePostal" id="codePostal">
					</div>
					<div class="form-saisie">
						<label for="motDePasse">Mot de passe :</label> <input
							type="password" name="motDePasse" id="motDePasse">
					</div>
				</div>
				<div class="form-colonne">
					<div class="form-saisie">
						<label for="nom">Nom :</label> <input type="text" name="nom"
							id="nom">
					</div>
					<div class="form-saisie">
						<label for="email">Email :</label> <input type="email"
							name="email" id="email">
					</div>
					<div class="form-saisie">
						<label for="rue">Rue :</label> <input type="text" name="rue"
							id="rue">
					</div>
					<div class="form-saisie">
						<label for="ville">Ville :</label> <input type="text" name="ville"
							id="ville">
					</div>
					<div class="form-saisie">
						<label for="confirmerMotDePasse">Confirmation :</label> <input
							type="password" name="confirmerMotDePasse"
							id="confirmerMotDePasse">
					</div>
				</div>
			</div>
			<div class="logIN">
				<input type="submit" value="Créer" id="buttonCnx">
				<button type="button" onclick="redirectPageAccueilNonConnecte()"
					class="btn-annuler">Annuler</button>
			</div>
		</form>
		<script>
			function redirectPageAccueilNonConnecte() {
				// Effectuer la redirection vers la servlet2 en utilisant JavaScript
				window.location.href = "PageAccueilNonConnecte"; // Remplacez "servlet2" par le chemin approprié si nécessaire
			}
		</script>
	</main>
	<footer> </footer>
</body>

</html>