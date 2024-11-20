<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="./style/Connexion.css">
<link rel="stylesheet" href="./style/StyleBouton.css">
<title>Page de connexion</title>
</head>

<body>
	<header>
		<a href="PageAccueilNonConnecte" class="lien-icone">
			<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
		</a>
	</header>


	<main>
		<form action="#" method="post">
			<div class="logID">
				<div class="id">
					<label for="id">Identifiant: </label> <input type="text" name="id"
						id="id">
				</div>
				<div class="pwd">
					<label for="motDePasse">Mot de passe: </label> <input
						type="password" name="motDePasse" id="password">
				</div>
			</div>

			<div class="logIN">
				<button id="buttonCnx">Connexion</button>

				<div class="gestion">
					<label for="rememberUser"> <input type="checkbox"
						name="rememberUser" id="rememberUser">Se souvenir de moi
					</label> <a href="">Mot de passe oublié</a>
				</div>
			</div>

		</form>
		<a href="PageCreerCompte">
			<button class="logCreate">Créer un compte</button>
		</a>
	</main>



	<footer> </footer>
</body>

</html>