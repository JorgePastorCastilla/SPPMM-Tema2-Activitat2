package com.example.activitat2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String BD_CREATE ="create table " + BD_TAULA + "( " + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +" text not null, " + CLAU_EMAIL + " text not null);";
    private final Context context;
    private AjudaDB ajuda;
    private SQLiteDatabase bd;

    public DBInterface(Context con) {
        this.context = con;
        ajuda = new AjudaDB(context);
    }

    //Obre la Base de dades
    public DBInterface obre() throws SQLException {
        bd = ajuda.getWritableDatabase();
        return this;
    }
    //Tanca la Base de dades
    public void tanca() {
        ajuda.close();
    }

    //Insereix un contacte
    public long insereixContacte(String nom, String email) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(CLAU_NOM, nom);
        initialValues.put(CLAU_EMAIL, email);
        return bd.insert(BD_TAULA ,null, initialValues);
    }

    //Esborra un contacte
    public boolean esborraContacte(long IDFila) {
        return bd.delete(BD_TAULA, CLAU_ID + " = " + IDFila, null) > 0;
    }

    //Retorna un contacte
    public Cursor obtenirContacte(long IDFila) throws SQLException {
        Cursor mCursor = bd.query(true, BD_TAULA, new String[] {CLAU_ID,
                        CLAU_NOM,CLAU_EMAIL},CLAU_ID + " = " + IDFila, null, null, null, null,
                null);
        if(mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //Retorna tots els contactes
    public Cursor obtenirTotsElsContactes() {
        return bd.query(BD_TAULA, new String[] {CLAU_ID, CLAU_NOM, CLAU_EMAIL},
                null,null, null, null, null);
    }

    //Modifica un contacte
    public boolean actualitzarContacte(long IDFila, String nom, String email) {
        ContentValues args = new ContentValues();
        args.put(CLAU_NOM, nom);
        args.put(CLAU_EMAIL, email);
        return bd.update(BD_TAULA, args, CLAU_ID + " = " + IDFila, null) > 0;
    }

}
