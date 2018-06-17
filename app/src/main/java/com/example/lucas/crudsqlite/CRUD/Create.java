package com.example.lucas.crudsqlite.CRUD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create extends SQLiteOpenHelper {

    private static final String NOME_DB = "MEU_DB";
    private static final int VERSAO_DB = 1;
    private static final String TABELA_PESSOA = "TABELA_PESSOA";

    private static final String PATH_DB = "/data/user/0/com.example.lucas.crudsqlite/database/MEU_DB";
    private Context nContext;
    private SQLiteDatabase db;

    public Create(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.nContext = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public boolean createTable(){
        openDB();
        String createTable = "CREATE TABLE IF NOT EXISTS "+TABELA_PESSOA+" ("
                +"NOME TEXT,"
                +"IDADE INTEGER,"
                +"CASADA TEXT)";
        try{
            db.execSQL(createTable);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    private void openDB(){
        if (db.isOpen()){
            db = nContext.openOrCreateDatabase(PATH_DB,SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
