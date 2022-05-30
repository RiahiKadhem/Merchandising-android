package com.example.merchandising2.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.merchandising2.helper.BdHelper;

public class ConnexionBd {
    private static SQLiteDatabase bd;
    private static int version = 1;
    private static String name ="Merchandising3.db";

    public static SQLiteDatabase getBd(Context context){
        BdHelper bdHelper = new BdHelper(context, name, null, version);
        bd = bdHelper.getWritableDatabase();

        return  bd;
    }

    public static void close(){
        bd.close();
    }
}
