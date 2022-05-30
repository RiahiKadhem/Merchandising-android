package com.example.merchandising2.managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.merchandising2.entities.Visite;
import com.example.merchandising2.services.ConnexionBd;

public class VisiteManager {
    @SuppressLint("Range")
    public static ArrayList<Visite> getAll(Context context,String idEmployee) {
        ArrayList<Visite> retour = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String query = "select * from table_visites where id_employee=?";
        Cursor cursor = bd.rawQuery(query, new String[]{"" + idEmployee});
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                Visite visite = new Visite();
                visite.setId_visite(cursor.getInt(cursor.getColumnIndex("id_visite")));
                visite.setId_employee(cursor.getInt(cursor.getColumnIndex("id_employee")));
                visite.setId_succursale(cursor.getInt(cursor.getColumnIndex("id_succursale")));
                visite.setDate_visite(cursor.getString(cursor.getColumnIndex("date_visite")));
                visite.setVisite_terminee(cursor.getInt(cursor.getColumnIndex("visite_terminee")));
                retour.add(visite);
            }
            ConnexionBd.close();
        }
        return retour;
    }
}