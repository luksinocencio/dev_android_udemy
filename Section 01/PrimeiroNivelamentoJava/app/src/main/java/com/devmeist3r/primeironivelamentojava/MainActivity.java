package com.devmeist3r.primeironivelamentojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.devmeist3r.primeironivelamentojava.model.Cliente;

public class MainActivity extends AppCompatActivity {

    String TAG = "APP_MINHA_IDEIA";

    Cliente objcliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objcliente = new Cliente(
                "Lucas",
                "luksinocencio@gmail.com",
                "61 998725477",
                27,
                true
        );

        Log.i(TAG, "onCreate: objCliente Nome " + objcliente.getName());
        Log.i(TAG, "onCreate: objCliente Email " + objcliente.getEmail());
        Log.i(TAG, "onCreate: objCliente Telefone " + objcliente.getTelefone());
        Log.i(TAG, "onCreate: objCliente Idade " + objcliente.getIdade());
        Log.i(TAG, "onCreate: objCliente Sexo " + objcliente.isSexo());
    }
}