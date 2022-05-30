package com.example.merchandising2.entities;

public class Tache {
    private int id_tache;
    private int id_produit;
    private int id_visite;
    private String date_tache;
    private int produit_existant;
    private String emplacement;
    private String type_promo;
    private float prix;
    private String commentaire;
    private int tache_terminee;
    private String photo;

    public Tache(int id_produit, int id_visite, String date_tache, int produit_existant, String emplacement, String type_promo, float prix, String commentaire, int tache_terminee) {
        this.id_produit = id_produit;
        this.id_visite = id_visite;
        this.date_tache = date_tache;
        this.produit_existant = produit_existant;
        this.emplacement = emplacement;
        this.type_promo = type_promo;
        this.prix = prix;
        this.commentaire = commentaire;
        this.tache_terminee = tache_terminee;
    }

    public Tache() {
    }

    public int getId_tache() {
        return id_tache;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getId_visite() {
        return id_visite;
    }

    public String getDate_tache() {
        return date_tache;
    }

    public int getProduit_existant() {
        return produit_existant;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public String getType_promo() {
        return type_promo;
    }

    public float getPrix() {
        return prix;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getTache_terminee() {
        return tache_terminee;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_visite(int id_visite) {
        this.id_visite = id_visite;
    }

    public void setDate_tache(String date_tache) {
        this.date_tache = date_tache;
    }

    public void setProduit_existant(int produit_existant) {
        this.produit_existant = produit_existant;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public void setType_promo(String type_promo) {
        this.type_promo = type_promo;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setTache_terminee(int tache_terminee) {
        this.tache_terminee = tache_terminee;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
