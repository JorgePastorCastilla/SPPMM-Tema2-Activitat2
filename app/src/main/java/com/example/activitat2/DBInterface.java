package com.example.activitat2;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBInterface {


    //Declaració de constants
    public static final String CLAU_ID = "_id";
    public static final String CLAU_NOM = "nom";
    public static final String CLAU_EMAIL = "email";
    public static final String TAG = "DBInterface";
    public static final String BD_NOM = "BDAlumnes";
    public static final String BD_TAULA = "contactes";
    public static final int VERSIO = 1;
    public static final String BD_CREATE ="create table " + BD_TAULA + "( "
            + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +"text not
    null, " + CLAU_EMAIL + " text not null);";
    public DBInterface(Context con) {
        this.context = con;
        ajuda = new AjudaDB(context);
    }
    private final Context context;
    private AjudaDB ajuda;
    private SQLiteDatabase bd;

    //Obre la Base de dades
    public DBInterface obre() throws SQLException {
        bd = ajuda.getWritableDatabase();
        return this;
    }
    //Tanca la Base de dades
    public void tanca() {
        ajuda.close();
    }

}
