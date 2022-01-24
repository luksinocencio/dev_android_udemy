package com.devmeist3r.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.devmeist3r.appminhaideia.R;
import com.devmeist3r.appminhaideia.controller.ClienteController;
import com.devmeist3r.appminhaideia.core.AppUtil;
import com.devmeist3r.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 3;

    Cliente objCliente;

    ClienteController clienteController;

    TextView txtAppVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada...");

        clienteController = new ClienteController();

        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.versaoDoAplicativo());

        trocarDeTela();
    }

    private void trocarDeTela() {
        Log.d(AppUtil.TAG, "trocarDeTela: Mudando de tela...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                objCliente = new Cliente(
                        "Lucas",
                        "luksinocencio@gmail.com",
                        "61 99872-5477",
                        27,
                        true
                );

                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);

                // madar parametros para tela seguinte
                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getName());
                bundle.putString("email", objCliente.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                // para nao voltar a tela anterior
                finish();
            }
        }, tempoDeEspera);
    }
}