package com.example.lucas.crudsqlite.CRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lucas.crudsqlite.Pessoa;

public class Update extends SQLiteOpenHelper {

    private static final String NOME_DB = "MEU_DB";
    private static final int VERSAO_DB = 1;
    private static final String TABELA_PESSOA = "TABELA_PESSOA";

    private static final String PATH_DB = "/data/user/0/com.example.lucas.crudsqlite/database/MEU_DB";
    private Context nContext;
    private SQLiteDatabase db;

    public Update(Context context) {
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

   public boolean insertPessoa(Pessoa p){
        openDB();
        try {
            ContentValues cv = new ContentValues();
            cv.put("NOME", p.getNome());
            cv.put("IDADE", p.getIdade());
            cv.put("CASADA",String.valueOf(p.getCasada()));
            db.insert(TABELA_PESSOA,null,cv);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
   }

    public boolean updatePessoa(Pessoa p){
        openDB();
        try {
            String where = "NOME ='"+p.getNome()+"'";
            ContentValues cv = new ContentValues();
            cv.put("NOME", p.getNome());
            cv.put("IDADE", p.getIdade());
            cv.put("CASADA",String.valueOf(p.getCasada()));
            db.update(TABELA_PESSOA,cv,where,null);
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
