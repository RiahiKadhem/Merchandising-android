package com.example.merchandising2.managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.merchandising2.entities.Magasin;
import com.example.merchandising2.entities.Produit;
import com.example.merchandising2.services.ConnexionBd;

import java.util.ArrayList;

public class MagasinManager {
    @SuppressLint("Range")
    public static Magasin getById(Context context,int id) {
        Magasin retour = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String query = "select * from table_magasin where id_succursale=?";
        Cursor cursor = bd.rawQuery(query, new String[]{"" + id});
        if (cursor.isBeforeFirst()) {
            retour = new Magasin();
            while (cursor.moveToNext()) {
                Magasin magasin = new Magasin();
                magasin.setId_succursale(cursor.getInt(cursor.getColumnIndex("id_succursale")));
                magasin.setLibelle_succursale(cursor.getString(cursor.getColumnIndex("libelle_succursale")));
                magasin.setLibelle_magasin(cursor.getString(cursor.getColumnIndex("libelle_magasin")));
                magasin.setAdresse(cursor.getString(cursor.getColumnIndex("adresse")));
                magasin.setGroupe(cursor.getInt(cursor.getColumnIndex("groupe")));
                retour=magasin;
            }
            ConnexionBd.close();
        }
        return retour;
    }
}
