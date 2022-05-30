package com.example.merchandising2.managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.merchandising2.services.ConnexionBd;
import com.example.merchandising2.entities.Produit;

public class ProduitManager {
    @SuppressLint("Range")
    public static ArrayList<Produit> getById(Context context,int id) {
        ArrayList<Produit> retour = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String query = "select * from table_produit tp, table_taches tt where tt.id_visite=? and tt.id_produit=tp.id_produit";
        Cursor cursor = bd.rawQuery(query, new String[]{"" + id});
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                Produit produit = new Produit();
                produit.setId_produit(cursor.getInt(cursor.getColumnIndex("id_produit")));
                produit.setLibelle_produit(cursor.getString(cursor.getColumnIndex("libelle_produit")));
                produit.setPrix(cursor.getFloat(cursor.getColumnIndex("prix")));
                produit.setImage(cursor.getString(cursor.getColumnIndex("image")));
                produit.setId_categorie(cursor.getInt(cursor.getColumnIndex("id_categorie")));
                produit.setPoids_volume(cursor.getFloat(cursor.getColumnIndex("poids_volume")));
                retour.add(produit);
            }
            ConnexionBd.close();
        }
        return retour;
    }
}
