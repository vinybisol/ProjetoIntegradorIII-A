package com.ucs.formularios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadConsulta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton btnCancelCadConsulta;
    private JTextField textField1;
    private JButton btnBuscarMedico;

    public FormCadConsulta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        btnCancelCadConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        FormCadConsulta dialog = new FormCadConsulta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
