package com.example.merchandising2.entities;

public class Produit {
    private int id_produit;
    private String libelle_produit;
    private int id_categorie;
    private float poids_volume;
    private String image;
    private float prix;

    public Produit() {
    }

    public Produit(int id_produit, String libelle_produit, int id_categorie, float poids_volume, String image, float prix) {
        this.id_produit = id_produit;
        this.libelle_produit = libelle_produit;
        this.id_categorie = id_categorie;
        this.poids_volume = poids_volume;
        this.image = image;
        this.prix = prix;
    }

    public int getId_produit() {
        return id_produit;
    }

    public String getLibelle_produit() {
        return libelle_produit;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public float getPoids_volume() {
        return poids_volume;
    }

    public String getImage() {
        return image;
    }

    public float getPrix() {
        return prix;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setLibelle_produit(String libelle_produit) {
        this.libelle_produit = libelle_produit;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setPoids_volume(float poids_volume) {
        this.poids_volume = poids_volume;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
