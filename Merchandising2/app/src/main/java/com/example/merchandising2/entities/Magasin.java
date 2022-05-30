package com.example.merchandising2.entities;

public class Magasin {
    private int id_succursale;
    private String libelle_succursale;
    private String libelle_magasin;
    private String adresse;
    private int groupe;

    public Magasin(int id_succursale, String libelle_succursale, String libelle_magasin, String adresse, int groupe) {
        this.id_succursale = id_succursale;
        this.libelle_succursale = libelle_succursale;
        this.libelle_magasin = libelle_magasin;
        this.adresse = adresse;
        this.groupe = groupe;
    }

    public Magasin() {
    }

    public void setId_succursale(int id_succursale) {
        this.id_succursale = id_succursale;
    }

    public void setLibelle_succursale(String libelle_succursale) {
        this.libelle_succursale = libelle_succursale;
    }

    public void setLibelle_magasin(String libelle_magasin) {
        this.libelle_magasin = libelle_magasin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public int getId_succursale() {
        return id_succursale;
    }

    public String getLibelle_succursale() {
        return libelle_succursale;
    }

    public String getLibelle_magasin() {
        return libelle_magasin;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getGroupe() {
        return groupe;
    }
}
