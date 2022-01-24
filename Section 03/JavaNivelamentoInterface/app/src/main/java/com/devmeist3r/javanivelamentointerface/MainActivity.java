package com.devmeist3r.javanivelamentointerface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "APP_INTERFACE";

    Produto objProduto;
    Cliente objCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objProduto = new Produto();
        objCliente = new Cliente();

        objProduto.setNome("HD SSD 1TB");
        objProduto.setFornecedor("DELL");

        objCliente.setNome("Lucas");
        objCliente.setEmail("luksinocencio@gmail.com");

        objCliente.deletar();
        objCliente.alterar();

        objProduto.deletar();
        objProduto.listar();
    }
}