package com.ucs.formularios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static com.ucs.dados.ListaDeMedico._listaMedico;

public class FormCadConsulta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton btnCancelCadConsulta;
    private JTextField textField1;
    private JButton btnBuscarMedico;
    private JTable table1;

    public FormCadConsulta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        btnCancelCadConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnBuscarMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        table1.addComponentListener(new ComponentAdapter() {
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

    }

    public static void main(String[] args) {
        FormCadConsulta dialog = new FormCadConsulta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    //link di video do youtube
    //https://www.youtube.com/watch?v=3R1itvzQKpk
    String header[] = {"Nome do medico", "Especialidade"};
    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0,2);
        model.setColumnIdentifiers(header);
        table1 = new JTable(model);
        model.addRow(_listaMedico.toArray());


    }
}
