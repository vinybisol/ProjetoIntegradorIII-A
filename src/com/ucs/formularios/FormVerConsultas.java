package com.ucs.formularios;

import com.ucs.dados.ListaDeConsultas;
import com.ucs.dados.ListaDeMedico;
import com.ucs.modelos.Consulta;
import com.ucs.modelos.Medico;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class FormVerConsultas extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private DefaultTableModel model;

    public FormVerConsultas() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CriarListaConsultas(ListaDeConsultas.retornaTodos());
    }

    private void CriarListaConsultas(List<Consulta> listaConsulta) {
        if (table1 == null)
            table1 = new JTable();
        if (model == null) {
            model = new DefaultTableModel() {
                @Override
                public int getColumnCount() {
                    return 4;
                }
            }; // essa llnnha é para a quantidde de coluinas
        }
        model.getDataVector().removeAllElements();
        model.setColumnCount(0);
        if (listaConsulta.stream().count() > 0) // se for maior que 0 executa:
            model.addRow(new Object[]{"ID", "Data/Hora", "Paciente", "Medico"});
        listaConsulta.forEach(consulta -> model.addRow(new Object[]{consulta.ID, consulta.DataHora, consulta.Medico, consulta.Paciente}));
        table1.setModel(model);
        table1.revalidate();
    }
}



