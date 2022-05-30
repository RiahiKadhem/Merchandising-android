package com.example.merchandising2.entities;

public class Employee {
    private int id_employee;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String nom_usager;
    private String mdp;
    private String adresse;
    private String date_inscrit;

    public Employee(int id_employee, String nom, String prenom, String date_naissance, String nom_usager, String mdp, String adresse, String date_inscrit) {
        this.id_employee = id_employee;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.nom_usager = nom_usager;
        this.mdp = mdp;
        this.adresse = adresse;
        this.date_inscrit = date_inscrit;
    }

    public Employee() {
    }

    public int getId_employee() {
        return id_employee;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String getNom_usager() {
        return nom_usager;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDate_inscrit() {
        return date_inscrit;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setNom_usager(String nom_usager) {
        this.nom_usager = nom_usager;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate_inscrit(String date_inscrit) {
        this.date_inscrit = date_inscrit;
    }
}
