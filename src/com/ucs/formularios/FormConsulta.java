package com.ucs.formularios;

import com.ucs.dados.ListaDeConsultas;
import com.ucs.modelos.Consulta;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import java.awt.event.*;

public class FormConsulta extends JDialog {
    private JPanel contentPane;
    private JButton btnOKConsulta;
    private JButton btnCancelarConsulta;
    private JTextField textIDConsulta;
    private JTextField textDataConsulta;
    private JTextField textHoraConsulta;
    private JTextField textNomeMedico;
    private JTextField textPaciente;
    private JTextField DataDiaConsulta;
    private JTextField DataAnoConsulta;
    private JTextField DataMesConsulta;
    private JTextField textMinutoConsulta;
    private boolean _campoAlterado;
    private boolean _campoDiaAlterado;
    private boolean _campoMesAlterado;
    private boolean _campoAnoAlterado;
    private boolean _campoHoraAlterado;
    private boolean _campoMinutoAlterado;


    public FormConsulta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOKConsulta);
        setTitle("Cadastro de consulta");
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
                VerificaCampoVazioAbreTelaMedico();
            }
        });
        textPaciente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                VerificaCampoVazioAbreTelaPaciente();
            }
        });

        DataDiaConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                DataDiaConsulta.setName("dia");
                LimparCampos(DataDiaConsulta);
            }
        });
        DataMesConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                DataMesConsulta.setName("mes");
                LimparCampos(DataMesConsulta);
            }
        });
        DataAnoConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                DataAnoConsulta.setName("ano");
                LimparCampos(DataAnoConsulta);
            }
        });
        textHoraConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textHoraConsulta.setName("hora");
                LimparCampos(textHoraConsulta);
            }
        });
        textMinutoConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textMinutoConsulta.setName("minuto");
                LimparCampos(textMinutoConsulta);
            }
        });

        DataDiaConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
        DataMesConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
        DataAnoConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
        textHoraConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
        textMinutoConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
    }


    private void VerificaCampoVazioAbreTelaMedico(){
        _campoAlterado = true;
        FormSelecionarMedicoEspecialidade dialog = new FormSelecionarMedicoEspecialidade();
        dialog.pack();
        dialog.setVisible(true);
        textNomeMedico.setText(dialog.NomeDoMedico);
    }
    private void VerificaCampoVazioAbreTelaPaciente(){
        _campoAlterado = true;
        FormBuscaPaciente dialog = new FormBuscaPaciente();
        dialog.pack();
        dialog.setVisible(true);
        textPaciente.setText(dialog.NomePaciente);
    }
    private void onOK() {
        // add your code here
        if(ValidaCampos()){
            var consult = new Consulta(){};
            consult.ID = ListaDeConsultas.proximoId();
            consult.Medico = textNomeMedico.getText();
            consult.Paciente = textPaciente.getText();
            consult.Data = DataDiaConsulta.getText() + "/" + DataMesConsulta.getText() + "/" + DataAnoConsulta.getText();
            consult.Hora = textHoraConsulta.getText() + ":" + textMinutoConsulta.getText();
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
        if(DataAnoConsulta.getText().isEmpty() || DataMesConsulta.getText().isEmpty() || DataDiaConsulta.getText().isEmpty()){
            FuncoesGerais.MensagemInforma("O campo data não pode ficar vazio", false);
        }
        if(textHoraConsulta.getText().isEmpty() || textMinutoConsulta.getText().isEmpty()){
            FuncoesGerais.MensagemInforma("O campo hora não pode ficar vazio", false);
            return false;
        }
        if(!_campoAlterado || !_campoDiaAlterado || !_campoMesAlterado || !_campoAnoAlterado || !_campoHoraAlterado || !_campoMinutoAlterado){
            FuncoesGerais.MensagemInforma("Os campos devem ser preenchidos", false);
            return  false;
        }
        return true;
    }

    private void LimparCampos(JTextField campoGenerico){
        campoGenerico.setText("");
        String nomeCampo = campoGenerico.getName();
        if(nomeCampo == null)
            nomeCampo = "";

        switch (nomeCampo){
            case "dia":
                _campoDiaAlterado = true;
                break;
            case "mes":
                _campoMesAlterado = true;
                break;
            case "ano":
                _campoAnoAlterado = true;
                break;
                case "hora":
                _campoHoraAlterado = true;
                break;
            case "minuto":
                _campoMinutoAlterado = true;
                break;

            default:
                break;
        }
    }
    private void FormartarData(KeyEvent e){
        if(textHoraConsulta != null && textHoraConsulta.getText().isEmpty()){
            String hora = textHoraConsulta.getText();
            StringBuilder horaStrng = new StringBuilder(hora);
            horaStrng.insert(2, "/");
            textHoraConsulta.setText(horaStrng.toString());

        }

    }
}
