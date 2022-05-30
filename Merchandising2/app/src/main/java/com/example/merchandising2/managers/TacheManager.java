package com.example.merchandising2.managers;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.merchandising2.entities.Magasin;
import com.example.merchandising2.entities.Tache;
import com.example.merchandising2.services.ConnexionBd;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TacheManager {
    @SuppressLint("Range")
    public static int getById(Context context,int idProduit,int idVisite) {
        int retour = 0;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String query = "select * from table_taches where id_produit=? and id_visite=?";
        Cursor cursor = bd.rawQuery(query, new String[]{"" + idProduit,""+idVisite});
        if (cursor.isBeforeFirst()) {
            retour = 0;
            while (cursor.moveToNext()) {

                retour=cursor.getInt(cursor.getColumnIndex("tache_terminee"));
            }
            ConnexionBd.close();
        }
        return retour;
    }

    public static void add(Context context, Tache tacheToAdd) {

        SQLiteDatabase bd = ConnexionBd.getBd(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_produit", tacheToAdd.getId_produit());
        contentValues.put("id_visite", tacheToAdd.getId_visite());
        contentValues.put("date_tache", tacheToAdd.getDate_tache());
        contentValues.put("produit_existant", tacheToAdd.getProduit_existant());
        contentValues.put("emplacement", tacheToAdd.getEmplacement());
        contentValues.put("type_promo", tacheToAdd.getType_promo());
        contentValues.put("prix", tacheToAdd.getPrix());
        contentValues.put("commentaire", tacheToAdd.getCommentaire());
        contentValues.put("tache_terminee", tacheToAdd.getTache_terminee());
        String[] args = new String[]{""+tacheToAdd.getId_produit(), ""+tacheToAdd.getId_visite()};
        bd.update("table_taches", contentValues,"id_produit=? AND id_visite-?",args);
        ConnexionBd.close();
    }
}
