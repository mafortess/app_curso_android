package com.example.agendabd.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
   private static final int DATABASE_VERSION = 1;
   private static final String DATABASE_NAME ="agenda.db";
   public static final String TABLA_CONTACTOS ="t_contactos";

   public DBHelper(@Nullable Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_CONTACTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefonoTEXT NOT NULL," +
                "correo_electronicoTEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLA_CONTACTOS );
        onCreate(sqLiteDatabase);
    }

}
