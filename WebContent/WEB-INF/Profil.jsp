<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="./style/Profil.css">
<link rel="stylesheet" href="./style/StyleBouton.css">

<title>Profil du vendeur</title>
</head>
<body>
	<header>
		<a href="PageListeEncheresConnecte" class="lien-icone">
			<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
	</header>
	<main>
		<form action="PageProfil" method="get">
			<p data-label="Pseudo :">${utilisateurVente.pseudo}</p>
			<p data-label="Nom :">${utilisateurVente.nom}</p>
			<p data-label="Prénom :">${utilisateurVente.prenom}</p>
			<p data-label="Email :">${utilisateurVente.email}</p>
			<p data-label="Téléphone :">${utilisateurVente.telephone}</p>
			<p data-label="Rue :">${utilisateurVente.rue}</p>
			<p data-label="Code Postal :">${utilisateurVente.codePostal}</p>
			<p data-label="Ville :">${utilisateurVente.ville}</p>
		</form>
	</main>
	<footer> </footer>
</body>
</html>