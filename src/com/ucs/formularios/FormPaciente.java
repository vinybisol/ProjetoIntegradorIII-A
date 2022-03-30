package com.ucs.formularios;

import com.ucs.dados.ListaDePaciente;
import com.ucs.modelos.Paciente;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import java.awt.event.*;


public class FormPaciente extends JDialog {
    private JPanel contentPane;
    private JTextField textNomePaciente;
    private JTextField textCPFPaciemte;
    private JTextField textEndereçoPaciente;
    private JLabel lblNomePaciente;
    private JButton btnOKPaciente;
    private JButton btnCancelarPaciente;
    private JButton buttonOK;

    public FormPaciente() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Cadastro de paciente");



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
        btnCancelarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
        btnOKPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnOKPaciente();

            }
        });
        textCPFPaciemte.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
    }
    private void setBtnOKPaciente(){
        var paciente = new Paciente();
        paciente.Nome = textNomePaciente.getText();
        paciente.CPF = textCPFPaciemte.getText();
        paciente.Endereco = textEndereçoPaciente.getText();
        ListaDePaciente.adicionarPaciente(paciente);

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
        FormPaciente dialog = new FormPaciente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
