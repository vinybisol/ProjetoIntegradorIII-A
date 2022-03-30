package com.ucs.util;

import com.ucs.formularios.FormAviso;

import java.awt.event.KeyEvent;

public class FuncoesGerais {
    public static void MensagemInforma(String mensagem, boolean mostarCancela){
        FormAviso formAviso = new FormAviso();
        formAviso.setTitle("Erro");
        formAviso.buttonCancel.setVisible(mostarCancela);
        formAviso.lbMensagem.setText(mensagem);
        formAviso.pack();
        formAviso.setVisible(true);
    }
    public static void SomenteNumeros(KeyEvent e){
        String caracteres = "0123456789";
        if(!caracteres.contains(e.getKeyChar()+"")){
            e.consume();
        }
    }
}
