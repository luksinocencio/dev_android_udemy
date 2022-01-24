package com.devmeist3r.appminhaideia.controller;

import android.util.Log;

import com.devmeist3r.appminhaideia.core.AppUtil;

public class ClienteController {

    String versaoDoApp;

    public ClienteController() {
        this.versaoDoApp = AppUtil.versaoDoAplicativo();
        Log.i(AppUtil.TAG, "ClienteController -> Versao do app: "+ versaoDoApp);
    }

}
