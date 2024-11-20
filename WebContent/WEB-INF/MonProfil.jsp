<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="./style/Profil.css">
<link rel="stylesheet" href="./style/StyleBouton.css">

<title>Mon Profil</title>
</head>
<body>
	<header>
		<a href="PageListeEncheresConnecte" class="lien-icone">
			<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
	</header>
	<main>
		<form action="PageMonProfil" method="get">
			<p data-label="Pseudo :">${utilisateur.pseudo}</p>
			<p data-label="Nom :">${utilisateur.nom}</p>
			<p data-label="Prénom :">${utilisateur.prenom}</p>
			<p data-label="Email :">${utilisateur.email}</p>
			<p data-label="Téléphone :">${utilisateur.telephone}</p>
			<p data-label="Rue :">${utilisateur.rue}</p>
			<p data-label="Code Postal :">${utilisateur.codePostal}</p>
			<p data-label="Ville :">${utilisateur.ville}</p>
			<input type="submit" value="Modifier" formaction="PageModifierProfil" class="btn-Modifier">
		</form>
	</main>
	<footer> </footer>
</body>
</html>