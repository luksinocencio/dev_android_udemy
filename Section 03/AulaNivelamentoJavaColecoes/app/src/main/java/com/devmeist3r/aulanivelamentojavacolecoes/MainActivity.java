package com.devmeist3r.aulanivelamentojavacolecoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Tipos de dados Primitivos - int, float, long, double
    // Tipos de dados nao Primitivos "Classes" - Integer, Float Long, Double


//    List<Integer> inteiros;
//    List<Float> precos;

    List<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        inteiros = new ArrayList<>();
//
//        inteiros.add(10); // 0
//        inteiros.add(20); // 1
//        inteiros.add(30); // 2
//        inteiros.add(40); // 2
//        inteiros.add(50); // 2
//        inteiros.add(60); // 2
//        inteiros.add(70); // 2
//
//
//        for (int i = 0; i < inteiros.size(); i++) {
//            Log.i("Inteiros", "For Elemento: "+i+" - " + inteiros.get(i));
//        }
//
//        for (Integer numero: inteiros) {
//            Log.i("Inteiros", "For Each Elemento: "+ " - " + numero);
//        }

//        precos = new ArrayList<>();
//
//        precos.add(10.00f); // 0
//        precos.add(20.00f); // 1
//        precos.add(30.00f); // 2
//        precos.add(40.00f); // 2
//        precos.add(50.00f); // 2
//        precos.add(60.00f); // 2
//        precos.add(70.00f); // 2
//
//
//        for (int i = 0; i < precos.size(); i++) {
//            Log.i("Inteiros", "For Elemento: "+i+" - " + precos.get(i));
//        }
//
//        for (Float numero: precos) {
//            Log.i("Inteiros", "For Each Elemento: "+ " - " + numero);
//        }

        clientes = new ArrayList<>();

        Cliente objA = new Cliente();
        objA.setId(1);
        objA.setNome("Lucas");
        objA.setEmail("luksinocencio@gmail.com");

        Cliente objB = new Cliente();
        objB.setId(2);
        objB.setNome("Eren");
        objB.setEmail("eren@mail.com");

        clientes.add(objA);
        clientes.add(objB);

        for (Cliente obj: clientes) {
            Log.e("Clientes", "********");
            Log.i("Clientes", "id: " + obj.getId());
            Log.i("Clientes", "nome: " + obj.getNome());
            Log.i("Clientes", "email: " + obj.getEmail());
        }
    }

}