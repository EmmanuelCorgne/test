package fr.imie.ecommerce.presentation;

import java.util.UUID;

public class Bean {

	private String nom="";
	private String prenom="";
	private String tel="";
	private String email="";
	private String mdp="";
	private String erreur="";
	private String id="";
	private String pseudo="";
	private	int nb=0;
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	
	public Bean(String nom, String tel) {
		super();
		this.nom=nom;
		this.tel=tel;
		this.id = UUID.randomUUID().toString();
		// TODO Auto-generated constructor stub
	}
	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNb() {
		return nb;
	}
	public void setNb() {
		this.nb++;
	}
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = UUID.randomUUID().toString();
	}
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
}
