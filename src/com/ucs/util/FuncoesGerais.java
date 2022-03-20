package com.ucs.util;

import com.ucs.formularios.FormAviso;

public class FuncoesGerais {
    public static void MensagemInforma(String mensagem, boolean mostarCancela){
        FormAviso formAviso = new FormAviso();
        formAviso.setTitle("Erro");
        formAviso.buttonCancel.setVisible(mostarCancela);
        formAviso.lbMensagem.setText(mensagem);
        formAviso.pack();
        formAviso.setVisible(true);
    }
}
