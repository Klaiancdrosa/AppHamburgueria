package br.ulbra.menuhamburgueria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static String nome = "BancoDados.db";
    private static int versao = 2;

    public DBHelper(Context context) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE utilizador(" +
                "username TEXT PRIMARY KEY, " +
                "password TEXT, " +
                "email TEXT, " +
                "telefone TEXT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS utilizador;");
        onCreate(db);
    }

    public long criarUtilizador(String nomeUsuario, String password, String email, String telefone) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM utilizador WHERE username=?", new String[]{nomeUsuario});
        if (cursor.getCount() > 0) {
            cursor.close();
            return -1;
        }
        cursor.close();

        ContentValues cv = new ContentValues();
        cv.put("username", nomeUsuario);
        cv.put("password", password);
        cv.put("email", email);
        cv.put("telefone", telefone);
        return db.insert("utilizador", null, cv);
    }

    public String validarLogin(String nomeUsuario, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM utilizador WHERE username=? AND password=?", new String[]{nomeUsuario, password});
        if (c.getCount() > 0) {
            c.close();
            return "OK";
        }
        c.close();
        return "erro";
    }

    public Cursor buscarDadosUsuario(String nomeUsuario) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM utilizador WHERE username=?", new String[]{nomeUsuario});
    }
}
