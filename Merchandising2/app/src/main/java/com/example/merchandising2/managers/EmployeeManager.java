package com.example.merchandising2.managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.merchandising2.entities.Employee;
import com.example.merchandising2.entities.Magasin;
import com.example.merchandising2.services.ConnexionBd;

public class EmployeeManager {
    @SuppressLint("Range")
    public static int getId(Context context, String userName, String mdp) {
        int id = 0;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String query = "select * from table_employee where nom_usager=? and mdp=?";
        Cursor cursor = bd.rawQuery(query, new String[]{"" + userName, "" + mdp});
        if (cursor.isBeforeFirst()) {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id_employee"));
            }
            ConnexionBd.close();
        }
        return id;
    }
}
