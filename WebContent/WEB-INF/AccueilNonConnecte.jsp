<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="style/AccueilNonConnecte.css">
<link rel="stylesheet" href="style/StyleBouton.css">
<title>Page d'accueil non connecté</title>
</head>

<body>
	<header>
		<div class="entete">
			<a href="PageAccueilNonConnecte" class="lien-icone">
				<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
			</a>
			<nav>
				<a href="PageConnexion">S'inscrire - Se connecter</a>
			</nav>
		</div>
	</header>

	<main>
		<h1>Liste des enchères</h1>
		<section class="rechercheArticle2">
			<h2>Filtres:</h2>
			<form action="#" method="post">
				<div class="rechercher">
					<div class="article">
						<input type="text" name="titre" id="recherche"
							placeholder="Le nom de l'article contient">

						<div class="categorie">
							<label for="categorie">Catégorie:</label> <select
								name="categorie" id="categorie">
								<option value="0">Toutes</option>
								<option value="1">Informatique</option>
								<option value="2">Ameublement</option>
								<option value="3">Vêtement</option>
								<option value="4">Sport & Loisirs</option>
							</select>
						</div>
					</div>
					<button id="rechercher">Rechercher</button>
				</div>

				<div class="encheresEnCours">
					<c:forEach items="${articles}" var="article">
						<div class="enchere01">
							<div>
								<img src="./image/${article.no_article}.jpeg"
									alt="Image PC Gamer">
							</div>
							<div>
								<h4><a href="PageEncherir?noArticle=${article.no_article}">${article.nom_article}</a></h4>
								<p>Prix: ${article.prix_vente}</p>
								<p>Fin de l'enchère: ${article.date_fin_encheres}</p>
								<p>Vendeur: <a href="PageProfil?pseudo=${article.pseudo}">${article.pseudo}</a></p>
							</div>
						</div>
					</c:forEach>
				</div>
			</form>
		</section>
	</main>

	<footer> </footer>
</body>

</html>
