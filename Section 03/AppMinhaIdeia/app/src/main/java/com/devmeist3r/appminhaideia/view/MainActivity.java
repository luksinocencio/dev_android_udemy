package com.devmeist3r.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.devmeist3r.appminhaideia.R;
import com.devmeist3r.appminhaideia.model.Cliente;

public class MainActivity extends AppCompatActivity {

    String TAG = "APP_MINHA_IDEIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView txtNome;
        TextView txtEmail;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Tela Principal criada...");

        Bundle bundle = getIntent().getExtras();

        Log.d(TAG, "onCreate: Nome..."+bundle.getString("nome"));
        Log.d(TAG, "onCreate: Email..."+bundle.getString("email"));

        txtNome = findViewById(R.id.txtNome);
        txtNome.setText("Bem vindo, " + bundle.getString("nome"));
        txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(bundle.getString("email"));
    }
}