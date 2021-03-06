package com.ucs.formularios;

import com.ucs.dados.ListaDeMedico;
import com.ucs.modelos.Medico;
import com.ucs.modelos.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class FormVerMedicos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private DefaultTableModel model;

    public FormVerMedicos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Ver medicos");
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CriarListaMedicos(ListaDeMedico.retornaTodos());
    }

    private void CriarListaMedicos(List<Medico> listaMedico){
        if(table1 == null)
            table1 = new JTable();
        if(model == null){
            model = new DefaultTableModel(){
                @Override
                public int getColumnCount() {
                    return 4;
                }
            };
        }
        model.getDataVector().removeAllElements();
        model.setColumnCount(0);
        if(listaMedico.stream().count() > 0)
            model.addRow(new Object[]{"Medico", "CPF", "Especialidade", "Nome com especialidade"});
            listaMedico.forEach(medico -> model.addRow(new Object[]{medico.getNome(), medico.getCPF(),medico.getEspecialidade(), medico.toString()}));
        table1.setModel(model);
        table1.revalidate();
    }
}
