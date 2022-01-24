package com.devmeist3r.appminhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {
    public boolean incluir(T obj);
    public boolean alterar(T obj);
    public boolean deletar(int id);
    public List<T> listar();
}
