package com.example.lucas.crudsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.crudsqlite.CRUD.Create;
import com.example.lucas.crudsqlite.CRUD.Delete;
import com.example.lucas.crudsqlite.CRUD.Read;
import com.example.lucas.crudsqlite.CRUD.Update;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnadd, btnedit, btnrmv, btnreg, btndel;
    EditText nome, idade;
    Switch casada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnedit = (Button)findViewById(R.id.btnedit);
        btnreg = (Button)findViewById(R.id.btnreg);
        btnrmv =(Button)findViewById(R.id.btnrmv);
        btndel = (Button)findViewById(R.id.btndel);

        nome = (EditText)findViewById(R.id.nome);
        idade = (EditText)findViewById(R.id.idade);

        casada = (Switch)findViewById(R.id.casada);

        btnadd.setOnClickListener(this);
        btnedit.setOnClickListener(this);
        btndel.setOnClickListener(this);
        btnrmv.setOnClickListener(this);
        btnreg.setOnClickListener(this);

        Create c = new Create(getApplicationContext());
        c.createTable();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnadd){
            Pessoa p = new Pessoa();
            p.setNome(nome.getText().toString());
            p.setIdade(Integer.parseInt(idade.getText().toString()));
            p.setCasada(casada.isChecked());

            Update u = new Update(getApplicationContext());
            if (u.insertPessoa(p)){
                Toast.makeText(this,"PESSOA FOI INSERIDA COM SUCESSO",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"PESSOA NÃO INSERIDA",Toast.LENGTH_SHORT).show();

            }

        }else if (view.getId() == R.id.btnedit){
            Pessoa p = new Pessoa();
            p.setNome(nome.getText().toString());
            p.setIdade(Integer.parseInt(idade.getText().toString()));
            p.setCasada(casada.isChecked());

            Update u = new Update(getApplicationContext());
            if (u.updatePessoa(p)){
                Toast.makeText(this,"PESSOA FOI ATUALIZADA COM SUCESSO",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"PESSOA NÃO ATUALIZADA",Toast.LENGTH_SHORT).show();

            }
        }else if (view.getId() == R.id.btnrmv){
            Pessoa p = new Pessoa();
            p.setNome(nome.getText().toString());
            p.setIdade(Integer.parseInt(idade.getText().toString()));
            p.setCasada(casada.isChecked());

            Delete d = new Delete(getApplicationContext());
            if (d.deletePessoa(p)){
                Toast.makeText(this,"PESSOA FOI REMOVIDA COM SUCESSO",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"PESSOA NÃO FOI REMOVIDA",Toast.LENGTH_SHORT).show();
            }
        }else if (view.getId() == R.id.btndel){
            Delete d = new Delete(getApplicationContext());
            if (d.deleteTable()){
                Toast.makeText(this,"TABELA FOI REMOVIDA COM SUCESSO",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"TABELA NÃO FOI REMOVIDA",Toast.LENGTH_SHORT).show();
            }
        }else if (view.getId() == R.id.btnreg){
            Read r = new Read(getApplicationContext());
            ArrayList<Pessoa> pArray = r.getPessoas();

            for (int i = 0; i < pArray.size(); i++) {
                Pessoa p = pArray.get(i);
                System.out.println("NOME: "+p.getNome()+"    IDADE: "+p.getIdade() + "  ESTÁ CASADA?"+ p.getCasada());
            }
        }
    }
}
