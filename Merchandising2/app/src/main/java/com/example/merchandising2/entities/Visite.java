package com.example.merchandising2.entities;

public class Visite {
    private int id_visite;
    private int id_employee;
    private int id_succursale;
    private String date_visite;
    private int visite_terminee;

    public Visite(int id_visite, int id_employee, int id_succursale, String date_visite, int visite_terminee) {
        this.id_visite = id_visite;
        this.id_employee = id_employee;
        this.id_succursale = id_succursale;
        this.date_visite = date_visite;
        this.visite_terminee = visite_terminee;
    }
    public Visite() {
    }

    public int getId_visite() {
        return id_visite;
    }

    public int getId_employee() {
        return id_employee;
    }

    public int getId_succursale() {
        return id_succursale;
    }

    public String getDate_visite() {
        return date_visite;
    }

    public int getVisite_terminee() {
        return visite_terminee;
    }

    public void setId_visite(int id_visite) {
        this.id_visite = id_visite;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public void setId_succursale(int id_succursale) {
        this.id_succursale = id_succursale;
    }

    public void setDate_visite(String date_visite) {
        this.date_visite = date_visite;
    }

    public void setVisite_terminee(int visite_terminee) {
        this.visite_terminee = visite_terminee;
    }
}
