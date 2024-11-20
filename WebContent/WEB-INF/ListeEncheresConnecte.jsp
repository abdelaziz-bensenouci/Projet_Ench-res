<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="favicon.png">
    <link rel="stylesheet" href="./style/ListeEncheresConnecte.css">
    <link rel="stylesheet" href="./style/StyleBouton.css">
    <title>Page de liste d'enchères après connexion</title>
</head>

<body>
    <header>
        <div class="entete" class="lien-icone">
			<a href="PageListeEncheresConnecte" class="lien-icone">
				<img alt="Logo ENI Ecole informatique" src="image/logo_ENI.png">
			</a>
            <nav>
                <a href="PageEnchereNonCommencee">Enchères</a>
                <a href="PageVendreUnArticle">Vendre un article</a>
                <a href="PageMonProfil">Mon profil</a>
                <a href="${pageContext.request.contextPath}/Deconnexion">Déconnexion</a>
            </nav>
        </div>
    </header>

    <main>
        <h1>Liste des enchères</h1>

        <section class="rechercheArticle">
            <h2>Filtres:</h2>
            <form action="#" method="post">
                <div class="rechercher">

                    <div class="article">
                        <input type="text" name="titre" id="recherche" placeholder="Le nom de l'article contient">

                        <div class="categorie">
                            <label for="categorie">Catégorie:</label>
                            <select name="categorie" id="categorie">
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

               <div class="choix">
                    <div class="achat">
                        <input type="radio" name="gestion" id="achat">                
                        <label for="achat">Achats</label>

                        <div class="achatCheckbox">
                            <div>
                                <input type="checkbox" name="enchere" id="enchere">
                                <label for="enchere">enchères ouvertes</label>
                            </div>
                            <div>
                                <input type="checkbox" name="enchereEnCours" id="enchereEnCours">
                                <label for="enchere">mes encherès en cours</label>
                            </div>
                            <div>
                                <input type="checkbox" name="enchereRemportées" id="enchereRemportées">
                                <label for="enchere">mes enchères remportées</label>
                            </div>
                        </div>
                    </div>             
                    
                    <div class="vente">
                        <input type="radio" name="gestion" id="vente">
                        <label for="vente">Mes ventes</label>              
                        
                        <div class="venteCheckbox">
                            <div>
                                <input type="checkbox" name="enchere" id="enchere">
                                <label for="enchere">enchères ouvertes</label>
                            </div>
                            <div>
                                <input type="checkbox" name="enchereEnCours" id="enchereEnCours">
                                <label for="enchere">mes encherès en cours</label>
                            </div>
                            <div>
                                <input type="checkbox" name="enchereRemportées" id="enchereRemportées">
                                <label for="enchere">mes enchères remportées</label>
                            </div>        
                        </div>
                    </div>
                </div>
                <div class="encheresEnCours">
					<c:forEach items="${articles}" var="article">
						<div class="enchere01">
							<div>
								<img src="./image/${article.no_article}.jpeg" alt="">
							</div>
							<div>
								<h4><a href="PageEncherir?noArticle=${article.no_article}">${article.nom_article}</a></h4>
								<p>Prix: ${article.prix_vente} points</p>
								<p>Fin de l'enchère: ${article.date_fin_encheres}</p>
								<p>Vendeur: <a href="PageProfil?pseudo=${article.pseudo}">${article.pseudo}</a></p>
							</div>
						</div>
					</c:forEach>					
				</div>
            </form>
        </section>
    </main>

    <footer>
    </footer>
</body>

</html>