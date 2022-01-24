package com.devmeist3r.javanivelamentointerface;

import android.util.Log;

import static com.devmeist3r.javanivelamentointerface.MainActivity.TAG;

public class Cliente implements ICrud {

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void incluir() {
        Log.i(TAG, "incluir: Cliente");
    }

    @Override
    public void alterar() {
        Log.i(TAG, "alterar: Cliente");
    }

    @Override
    public void deletar() {
        Log.i(TAG, "deletar: Cliente");
    }

    @Override
    public void listar() {
        Log.i(TAG, "listar: Cliente");
    }
}
