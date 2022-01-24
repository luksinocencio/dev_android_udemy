package com.devmeist3r.ferramentalayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    EditText edtNomeCompleto;
    Button btnConfirmar;
    ToggleButton tbLigado;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch swMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atribuição do ID relacionado com o componente
        txtTitulo = findViewById(R.id.txtTitulo);
        edtNomeCompleto = findViewById(R.id.edtNomeCompleto);
        btnConfirmar = findViewById(R.id.btn_confirmar);
        tbLigado = findViewById(R.id.tbLigado);
        swMostrar = findViewById(R.id.swMostrar);

        // Acesso aos métodos dos componentes
        txtTitulo.setText("Retrato");

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean dadosOK = true;

                if (TextUtils.isEmpty(edtNomeCompleto.getText().toString())) {
                  edtNomeCompleto.setError("*");
                  Toast.makeText(getBaseContext(), "Digite o nome completo por favor...", Toast.LENGTH_SHORT).show();
                    dadosOK = false;
                }

                // Toast
                if (dadosOK) {
                    Toast.makeText(getBaseContext(), "Olá, " + edtNomeCompleto.getText(), Toast.LENGTH_LONG).show();
                }
            }
        });

        tbLigado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbLigado.isChecked()) {
                    edtNomeCompleto.setEnabled(false);
                } else {
                    edtNomeCompleto.setEnabled(true);
                }
            }
        });

        swMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swMostrar.isChecked()) {
                   txtTitulo.setVisibility(View.GONE);
                } else {
                    txtTitulo.setVisibility(View.VISIBLE);
                    String novoTitulo = txtTitulo.getText().toString().toUpperCase();
                    txtTitulo.setText(novoTitulo);
                }
            }
        });
    }
}