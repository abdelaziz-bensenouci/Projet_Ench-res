<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="./style/Encherir.css">
<link rel="stylesheet" href="./style/StyleBouton.css">

<title>Acquérir</title>
</head>
<body>
	<header>
		<a href="PageListeEncheresConnecte" class="lien-icone">
			<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
		<h2>Vous avez remporté la vente</h2>
	</header>

	<main>
		<form action="PageAcquisition" method="get" enctype="multipart/form-data">
		<img src="./image/${article.no_article}.jpeg" alt="">
			<p>${article.nom_article}</p>
			<p data-label="Description :">${article.description}</p>
			<p data-label="Meilleure offre :">${article.prix_vente}</p>
			<p data-label="Mise à prix :">${article.prix_initial}</p>
			<p data-label="Retrait :">${utilisateurVente.rue} <br>${utilisateurVente.codePostal} ${utilisateurVente.ville}</p>
			<p data-label="Vendeur :">${utilisateurVente.pseudo}</p>
			<p data-label="Telephone :">${utilisateurVente.telephone}</p>
			<input type="submit" value="Retour" formaction="PageListeEncheresConnecte">
		</form>
	</main>
	<footer> </footer>
</body>
</html>