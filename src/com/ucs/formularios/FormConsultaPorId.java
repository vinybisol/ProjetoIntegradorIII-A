package com.ucs.formularios;

import com.ucs.dados.ListaDeConsultas;
import com.ucs.modelos.Consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormConsultaPorId extends JDialog {
    private JPanel contentPane;
    private JButton buttonSair;
    private JTable table1;
    private JLabel lb;
    private Consulta _consulta;
    private DefaultTableModel model;

    public FormConsultaPorId(Consulta consulta) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSair);
        _consulta = consulta;
        buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void criarTabela(){
        if(table1 == null)
            table1 = new JTable();
        if(model == null){
            model = new DefaultTableModel(){
                @Override
                public int getColumnCount() {
                    return 5;
                }
            }; // essa llnnha é para a quantidde de coluinas
        }
        model.getDataVector().removeAllElements();
        model.setColumnCount(0);
        model.addRow(new Object[]{"ID", "Data", "Hora", "Medico", "Paciente"});
        model.addRow(new Object[]{_consulta.ID, _consulta.Data, _consulta.Hora, _consulta.Medico, _consulta.Paciente});
        table1.setModel(model);
        table1.revalidate();
    }

}
