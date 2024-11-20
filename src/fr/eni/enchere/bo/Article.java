package fr.eni.enchere.bo;

public class Article {
	private Integer no_article;
	private String nom_article;
	private String description;
	private String date_debut_encheres;
	private String date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private int no_utilisateur;
	private int no_categorie;
	private String pseudo;

	public Article(Integer no_article, String nom_article, String description, String date_debut_encheres,

			String date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie,
			String pseudo) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.pseudo = pseudo;
	}

	public Article(String nom_article, String description, String date_debut_encheres, String date_fin_encheres,
			int prix_initial, int prix_vente, int no_utilisateur, int no_categorie, String pseudo) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.pseudo = pseudo;
	}

	public Article() {
		super();
	}

	public Integer getNo_article() {
		return no_article;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(String date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public String getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(String date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Article [no_article=");
		builder.append(no_article);
		builder.append(", nom_article=");
		builder.append(nom_article);
		builder.append(", description=");
		builder.append(description);
		builder.append(", date_debut_encheres=");
		builder.append(date_debut_encheres);
		builder.append(", date_fin_encheres=");
		builder.append(date_fin_encheres);
		builder.append(", prix_initial=");
		builder.append(prix_initial);
		builder.append(", prix_vente=");
		builder.append(prix_vente);
		builder.append(", no_utilisateur=");
		builder.append(no_utilisateur);
		builder.append(", no_categorie=");
		builder.append(no_categorie);
		builder.append("]");
		return builder.toString();
	}

}
