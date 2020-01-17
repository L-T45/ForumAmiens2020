package com.example.forumamiens2020.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "Forum" ;
    private static final String Table1 = "Categorie";
    private static final String Table2 ="Images" ;
    private static final String Table3 = "SousCategorie";
    private static final String Table4 = "SousSousCategorie";

    public Database(Context context){
        super(context,DATABASE,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  request = "CREATE Table "+this.Table1+" (id_cat INTEGER PRIMARY KEY, nom_cat TEXT);" +
                "CREATE TABLE " +this.Table3+" (id_sous_cat INTEGER PRIMARY KEY, id_cat INTEGER, nom_sous_cat TEXT);" +
                "CREATE TABLE " + this.Table4 +" (id_sous_sous_cat INTEGER PRIMARY KEY, id_sous_cat INTEGER, nom_sous_sous_cat TEXT);" +
                "CREATE TABLE "+this.Table2 + "(id_image INTEGER PRIMARY KEY, nom_chemin TEXT);";
        sqLiteDatabase.execSQL(request);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String request = "DROP TABLE IF EXISTS "+this.DATABASE;
        sqLiteDatabase.execSQL(request);
        onCreate(sqLiteDatabase);
    }
}
