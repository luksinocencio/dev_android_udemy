package com.devmeist3r.appcoordenadasgps;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] permissoesRequiridas = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS
    };

    public static  final int APP_PERMISSOES_ID = 2021;

    TextView txtValorLatitude, txtValorLongitude;

    double latitude, longitude;

    LocationManager locationManager;

    boolean gpsAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtValorLongitude);

        locationManager = (LocationManager) getApplication().getSystemService(Context.LOCATION_SERVICE);

        gpsAtivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (gpsAtivo) {
            obterCoordenadas();
        } else {
            latitude = 0.00;
            longitude = 0.00;


            txtValorLatitude.setText(String.valueOf(latitude));
            txtValorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this, "Coordenadas não Disponíveis", Toast.LENGTH_LONG).show();
        }
    }

    private void obterCoordenadas() {
        boolean permissaoAtiva = true;

        if (permissaoAtiva) {
            capturarUltimaLocalizacaoValida();
        }
    }

    private void capturarUltimaLocalizacaoValida() {
        latitude = 1.98;
        longitude = -1.67;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));

        Toast.makeText(this, "Coordenadas obtidas com sucesso.", Toast.LENGTH_LONG).show();
    }

    private boolean solicitarPermissaoParaObterLocalizacao() {
        Toast.makeText(this, "Aplicativo não tem permissão...", Toast.LENGTH_LONG).show();

        List<String> permissoesNegadas = new ArrayList<>();

        

        return true;
    }
}