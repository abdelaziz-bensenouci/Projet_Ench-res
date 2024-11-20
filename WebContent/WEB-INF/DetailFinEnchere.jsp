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

<title>Enchérir</title>
</head>
<body>
	<header>
		<a href="PageListeEncheresConnecte" class="lien-icone">
			<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
		<h2>Détail Vente</h2>
	</header>

	<main>
		<form action="PageDetailFinEnchere" method="post" enctype="multipart/form-data">
		<img src="./image/${article.no_article}.jpeg" alt="">
			<p>${article.nom_article}</p>
			<p data-label="Description :">${article.description}</p>
			<p data-label="Meilleure offre :">${article.prix_vente}</p>
			<p data-label="Mise à prix :">${article.prix_initial}</p>
			<p data-label="Fin de l'enchère :">${article.date_fin_encheres}</p>
			<p data-label="Retrait :">${utilisateurVente.rue} <br>${utilisateurVente.codePostal} ${utilisateurVente.ville}</p>
			<p data-label="Vendeur :"><a href="PageProfil?pseudo=${article.pseudo}">${article.pseudo}</a></p>
			<input type="submit" value="Encherir" formaction="PageListeEnchereConnecte" class="btn-Encherir">
		</form>
	</main>
	<footer> </footer>
</body>
</html>