package com.example.agendabd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbContactos extends DBHelper{
    Context context;
    public DbContactos(@Nullable Context context){
        super(context);
        this.context= context;
    }

    public long insertaContacto(String nombre, String telefono, String correo){
        long id = 0;

        try {
            DBHelper dbHelper= new DBHelper(context);
            SQLiteDatabase db= dbHelper.getReadableDatabase();
            ContentValues values= new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo);
            id = db.insert(TABLA_CONTACTOS, null, values);
        }
        catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public ArrayList<Contactos> mostrarContactos(){
        DBHelper dbHelper= new DBHelper(context);
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        ArrayList<Contactos> listaContactos= new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos= null;
        cursorContactos= db.rawQuery("SELECT * FROM "+ TABLA_CONTACTOS, null);
        if(cursorContactos.moveToFirst()) {
            do {contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo_electronico(cursorContactos.getString(3));
                listaContactos.add(contacto);
            } while(cursorContactos.moveToNext());

            cursorContactos.close();
        }
        return listaContactos;
    }

}
