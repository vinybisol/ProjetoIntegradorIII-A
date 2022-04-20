package com.ucs.formularios;

import com.ucs.dados.ListaDeMedico;
import com.ucs.modelos.Medico;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import java.awt.event.*;


public class FormMedico extends JDialog {
    private JPanel contentPane;
    private JButton btnOKMedico;
    private JButton btnCancelMedico;
    private JTextField textNomeMedico;
    private JTextField textCPFMedico;
    private JTextField textEspecialidadeMedico;

    public FormMedico() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOKMedico);
        setTitle("Cadastro de medico");



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
        btnCancelMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOKMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnOKMedico();
            }
        });
        textCPFMedico.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
    }
    private void setBtnOKMedico(){
        var medico = new Medico();
        medico.setNome(textNomeMedico.getText());
        medico.setCPF(textCPFMedico.getText());
        medico.setEspecialidade(textEspecialidadeMedico.getText());
        ListaDeMedico.adicionarMedico(medico);


        dispose();
    }
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FormMedico dialog = new FormMedico();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
