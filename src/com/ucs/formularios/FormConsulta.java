package com.ucs.formularios;

import javax.swing.*;
import java.awt.event.*;

public class FormConsulta extends JDialog {
    private JPanel contentPane;
    private JButton btnOKConsulta;
    private JButton btnCancelarConsulta;
    private JTextField textIDConsulta;
    private JComboBox comboPaciente;
    private JTextField textDataConsulta;
    private JTextField textHorarioConsulta;
    private JTextField textNomeMedico;

    public FormConsulta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOKConsulta);

        btnOKConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

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
        btnCancelarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        textNomeMedico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                VerificaCampoVazioAbreTela();
            }
        });
    }


    private void VerificaCampoVazioAbreTela(){
        String text = textNomeMedico.getText().trim();
        if(text.isEmpty()){
            FormCadConsulta dialog = new FormCadConsulta();
            dialog.pack();
            dialog.setVisible(true);
            textNomeMedico.setText(dialog.NomeDoMedico);
        }
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
        FormConsulta dialog = new FormConsulta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}