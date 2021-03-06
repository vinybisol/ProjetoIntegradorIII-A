package com.ucs.formularios;

import com.ucs.dados.ListaDePaciente;
import com.ucs.modelos.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;




public class FormVerPacientes extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private DefaultTableModel model;


    public FormVerPacientes() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Ver pacientes");

        buttonCancel.addActionListener(new ActionListener() {
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
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });






    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        var listaDePacientes = ListaDePaciente.retornaTodos();
        CriarListaPacientes(listaDePacientes);

    }

    private void CriarListaPacientes(List<Paciente> listaDePaciente){
        if(table1 == null)
            table1 = new JTable();
        if(model == null){
            model = new DefaultTableModel(){
                @Override
                public int getColumnCount() {
                    return 4;
                }
            }; // essa llnnha ?? para a quantidde de coluinas
        }
        model.getDataVector().removeAllElements();
        model.setColumnCount(0);
        if(listaDePaciente.stream().count() > 0) // se for maior que 0 executa:
                model.addRow(new Object[]{"Paciente", "CPF", "Endere??o", "Nome mais Endere??o"});
        listaDePaciente.forEach(paciente -> model.addRow(new Object[]{paciente.getNome(), paciente.getCPF(), paciente.getEndereco(), paciente.toString()}));
        table1.setModel(model);
        table1.revalidate();
    }
}
