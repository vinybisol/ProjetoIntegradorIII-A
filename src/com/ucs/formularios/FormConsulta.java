package com.ucs.formularios;

import com.ucs.dados.ListaDeConsultas;
import com.ucs.modelos.Consulta;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

public class FormConsulta extends JDialog {
    private JPanel contentPane;
    private JButton btnOKConsulta;
    private JButton btnCancelarConsulta;
    private JTextField textIDConsulta;
    private JTextField textDataConsulta;
    private JTextField textHorarioConsulta;
    private JTextField textNomeMedico;
    private JTextField textPaciente;
    private boolean _campoAlterado;

    public FormConsulta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOKConsulta);
        _campoAlterado = false;
        textIDConsulta.setText(String.valueOf(ListaDeConsultas.proximoId()));
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
        _campoAlterado = true;
        FormCadConsulta dialog = new FormCadConsulta();
        dialog.pack();
        dialog.setVisible(true);
        textNomeMedico.setText(dialog.NomeDoMedico);
    }
    private void onOK() {
        // add your code here
        if(ValidaCampos()){
            var consult = new Consulta(){};
            consult.ID = Integer.parseInt(textIDConsulta.getText());
            consult.Medico = textNomeMedico.getText();
            consult.Paciente = textPaciente.getText();
            consult.DataHora = textDataConsulta.getText();
            consult.DataHora = consult.DataHora + textDataConsulta.getText();
            ListaDeConsultas.incluirNoFim(consult);
            FuncoesGerais.MensagemInforma("Consulta cadastrada", false);
            dispose();
        }
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
    private boolean ValidaCampos(){
        if(textNomeMedico.getText().isEmpty()){
            FuncoesGerais.MensagemInforma("Obrigatório medico", false);
            return  false;
        }
        if(textPaciente.getText().isEmpty()){
            FuncoesGerais.MensagemInforma("Obrigatório Paciente", false);
            return  false;
        }
        if(!_campoAlterado){
            FuncoesGerais.MensagemInforma("Os campos devem ser preenchidos", false);
            return  false;
        }
        return true;
    }
}
