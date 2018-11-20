package com.example.marco.app_baseproyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    String query1 = "CREATE TABLE tblItem (idItem INTEGER PRIMARY KEY AUTOINCREMENT, nombreItem TEXT)";
    String query2 = "INSERT INTO tblItem VALUES (null, 'Supermercado'),(null, 'Autopista'),(null, 'Vestuario'),(null, 'Paseo')";
    String query3 = "CREATE TABLE tblGasto (idGasto INTEGER PRIMARY KEY AUTOINCREMENT, monto INTEGER, fecha TEXT, descripcion TEXT, idItem  INTEGER, FOREIGN KEY (idItem) REFERENCES tblItem(idItem))";
    String query4 = "CREATE TABLE tbl_datos(columna1 TEXT, columna2 INTEGER)";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table IF EXISTS tbl_dato");
        db.execSQL(query4);
    }
}
