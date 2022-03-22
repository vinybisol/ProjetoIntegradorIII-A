package com.ucs.formularios;

import javax.swing.*;
import java.awt.event.*;

public class FormInicial extends JDialog {
    private JPanel contentPane;
    private JButton btnSelPaciente;
    private JButton btnSelMedico;
    private JButton btnCancelarInicial;
    private JButton btnSelConsulta;
    private JButton btnVerPacientes;
    private JButton btnVerMedicos;
    private JButton btnVerConsultas;
    private JButton buttonOK;

    public FormInicial() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnCancelarInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            setBtnCancelarInicial();
            }
        });
        btnSelPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnSelPaciente();

            }
        });
        btnSelMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnSelMedico();
            }
        });
        btnSelConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnSelConsulta();

            }
        });

        btnVerPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnCadConsulta();
            }
        });
        btnVerMedicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnVerMedicos();
            }
        });
    }
    private void onBtnVerMedicos(){
        var telaVerMedicos = new FormVerMedicos();
        telaVerMedicos.pack();
        telaVerMedicos.setVisible(true);
    }
    private void onBtnCadConsulta(){
        var telaConsulta = new FormVerPacientes();
        telaConsulta.pack();
        telaConsulta.setVisible(true);
    }
    private void setBtnSelConsulta(){
        var telaConsulta = new FormConsulta();
        telaConsulta.pack();
        telaConsulta.setVisible(true);

    }
    private void setBtnSelMedico(){
        var telaMedico = new FormMedico();
        telaMedico.pack();
        telaMedico.setVisible(true);
    }
    private void setBtnSelPaciente() {
        var pacientecad = new FormPaciente();
        pacientecad.pack();
        pacientecad.setVisible(true);
    }

    private void setBtnCancelarInicial() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FormInicial dialog = new FormInicial();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
