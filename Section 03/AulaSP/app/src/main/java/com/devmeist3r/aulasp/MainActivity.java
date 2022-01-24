package com.devmeist3r.aulasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "APP_AULA_SP";
    private static final String PREF_NOME = "APP_AULA_SP_PREF";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Pasta shared criada");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);

        // Modo Debug

        Log.i(TAG, "onCreate: Dados para serem salvos");
        Log.i(TAG, "onCreate: Produto Nome: " + nomeProduto);
        Log.i(TAG, "onCreate: Produto Codigo: " + codigoProduto);
        Log.i(TAG, "onCreate: Produto Preco: " + precoProduto);
        Log.i(TAG, "onCreate: Produto Estoque: " + estoque);

//        dados.clear();
//        dados.apply();

        dados.remove("estoque");
        dados.apply();
    }
    
}