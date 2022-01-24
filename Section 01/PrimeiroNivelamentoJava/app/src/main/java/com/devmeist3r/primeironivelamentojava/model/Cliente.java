package com.devmeist3r.primeironivelamentojava.model;

public class Cliente {

    // atributos
    private String name;
    private String email;
    private String telefone;
    private int idade;
    private boolean sexo;
    
    // constructor
    public Cliente(String name, String email, String telefone, int idade, boolean sexo) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.sexo = sexo;
    }

    // gets and sets

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}

