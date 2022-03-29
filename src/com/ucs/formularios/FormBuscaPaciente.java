package com.ucs.formularios;

import com.ucs.dados.ListaDeMedico;
import com.ucs.dados.ListaDePaciente;
import com.ucs.modelos.Medico;
import com.ucs.modelos.Paciente;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

public class FormBuscaPaciente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton btnBuscarPaciente;
    private JTextField textField1;
    private JTable table1;
    private DefaultTableModel model;
    public String NomePaciente;


    public FormBuscaPaciente() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Buscar Paciente");
        btnBuscarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarPaciente(textField1.getText());
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexSelected = table1.getSelectedRow();
                if(indexSelected >= 0){
                    NomePaciente = table1.getValueAt(indexSelected,0).toString();
                }
                dispose();
            }
        });
    }

    private void BuscarPaciente(String nomePaciente){
        List<Paciente> listaDePaciente = ListaDePaciente.retornaPorNome(nomePaciente);
        if(listaDePaciente.size() == 0){
            FuncoesGerais.MensagemInforma("Não existe paciente cadastrados com este nome solicitada!",false);
            dispose();
            return;
        }
        CriarListaPacinetes(listaDePaciente);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CriarListaPacinetes(ListaDePaciente.retornaTodos());

    }

    private void CriarListaPacinetes(List<Paciente> listaDePaciente){
        if(table1 == null)
            table1 = new JTable();
        if(model == null){
            model = new DefaultTableModel(){
                @Override
                public int getColumnCount() {
                    return 2;
                }
            };
        }
        model.getDataVector().removeAllElements();
        model.setColumnCount(0);
        if(listaDePaciente.stream().count() > 0)
            listaDePaciente.forEach(paciente -> model.addRow(new Object[]{paciente.Nome, paciente.CPF}));
        table1.setModel(model);
        table1.revalidate();
    }

    public static void main(String[] args) {
        FormBuscaPaciente dialog = new FormBuscaPaciente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
