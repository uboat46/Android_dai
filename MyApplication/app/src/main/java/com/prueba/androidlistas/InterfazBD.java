package com.prueba.androidlistas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sdist on 24/11/2016.
 */
public class InterfazBD {
    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD(Context context){
        con = new ConexionBD(context);
    }

    public void  open() throws SQLException{
        db = con.getWritableDatabase();
    }

    public  void close() throws SQLException{
        con.close();
    }

    public long insertaDatos(String dato){
        ContentValues values;
        open();
        values = new ContentValues();
        values.put("datos",dato);
        long clave = db.insert("tablaprueba",null,values);
        db.close();
        return clave;
    }

    public void insertaDatosPrueba(){
        ContentValues values;
        open();
        String[] noms = {"prueba1","prueba2","prueba3","prueba4"};
        values = new ContentValues();
        values.put("datos",noms[0]);
        db.insert("tablaprueba",null,values);
        db.close();
    }

    public Cursor traerDatos(){
        Cursor res = null;
        open();
        String cadena = "SELECT * FROM tablaPrueba";
        res = db.rawQuery(cadena,null);
        if (res.getCount() == 0){
            insertaDatosPrueba();
            res = db.rawQuery(cadena,null);
        }
        return res;
    }


}
