package com.example.lucas.crudsqlite.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lucas.crudsqlite.Pessoa;

import java.util.ArrayList;

public class Read extends SQLiteOpenHelper {

    private static final String NOME_DB = "MEU_DB";
    private static final int VERSAO_DB = 1;
    private static final String TABELA_PESSOA = "TABELA_PESSOA";

    private static final String PATH_DB = "/data/user/0/com.example.lucas.crudsqlite/database/MEU_DB";
    private Context nContext;
    private SQLiteDatabase db;

    public Read(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.nContext = context;
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public ArrayList<Pessoa> getPessoas(){
        openDB();
        ArrayList<Pessoa> pArray = new ArrayList<>();
        String getPessoas = "SELECT * FROM " + TABELA_PESSOA;

        try{
            Cursor c = db.rawQuery(getPessoas, null);

            if (c.moveToFirst()){

                do {
                    Pessoa p = new Pessoa();
                    p.setNome(c.getString(0));
                    p.setIdade(c.getInt(1));
                    p.setCasada(Boolean.parseBoolean(c.getString(2)));
                    pArray.add(p);
                }while (c.moveToNext());
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }

        return pArray;
    }






    private void openDB(){
        if (db.isOpen()){
            db = nContext.openOrCreateDatabase(PATH_DB,SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
