<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="./style/ArticleVente.css">
<link rel="stylesheet" href="./style/StyleBouton.css">
<title>Nouvelle vente</title>
</head>

<body>
	<header>
		<a href="PageListeEncheresConnecte" class="lien-icone"> <img
			alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
		<h1>Nouvelle vente</h1>
	</header>
	<main>

		<form action="PageVendreUnArticle" method="post">
			<div class="form">
				<div class="form-group">
					<label for="nom_article">Article :</label> <input type="text"
						name="nom_article" id="nom_article" required>
				</div>
				<div class="form-group">
					<label for="description">Description :</label> <input type="text"
						name="description" id="description" required>
				</div>
				<div class="form-group">
					<label for="categorie">Catégorie :</label> <select name="categorie"
						id="categorie">
						<option value="1">Informatique</option>
						<option value="2">Ameublement</option>
						<option value="3">Vêtement</option>
						<option value="4">Sport & Loisirs</option>
					</select>
				</div>
				<div class="form-group">
					<label for="photo">Photo de l'article</label> <input type="file"
						 name="photo" id="photo" accept="image/*">
				</div>
				<div class="form-group">
					<label for="prixInitial">Mise à prix :</label> <input type="number"
						step="10" name="prixInitial" id="prixInitial" required>
				</div>
				<div class="form-group">
					<label for="datedebut">Début de l'enchère :</label> <input
						type="date" name="datedebut" id="datedebut" required>
				</div>
				<div class="form-group">
					<label for="datefin">Fin de l'enchère :</label> <input type="date"
						name="datefin" id="datefin" required>
				</div>
				<div class="coordonnees">
					<fieldset form="mygeeks">
						<legend>Retrait</legend>
						<div class="form-group">
							<label for="rue">Rue :</label> <input type="text" name="rue"
								id="rue" value="${rueUtilisateur}">
						</div>
						<div class="form-group">
							<label for="codePostal">Code Postal :</label> <input type="text"
								name="codePostal" id="codePostal"
								value="${codePostalUtilisateur}">
						</div>
						<div class="form-group">
							<label for="ville">Ville :</label> <input type="text"
								name="ville" id="ville" value="${villeUtilisateur}">
						</div>
					</fieldset>
				</div>
				<div class="logIN">
					<button type="submit">Enregistrer</button>
					<a href="PageListeEncheresConnecte">
						<button type="button" id="buttonannul">Annuler</button>
					</a>
				</div>
			</div>
		</form>
	</main>
</body>

</html>
