package com.ucs.formularios;

import com.ucs.dados.ListaDeMedico;
import com.ucs.modelos.Medico;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;



public class FormSelecionarMedicoEspecialidade extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton btnCancelCadConsulta;
    private JTextField textBuscaPaciente;
    private JButton btnBuscarPaciente;
    private JTable table1;
    private DefaultTableModel model;
    public String NomeDoMedico;

    public FormSelecionarMedicoEspecialidade() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Seleção do médico por especialidade");
        btnCancelCadConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnBuscarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarMedicosPorEspecialidade();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("deu dois cliques");
            }
        });
        buttonOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indexSelected = table1.getSelectedRow();
                    if(indexSelected >= 0){
                        NomeDoMedico = table1.getValueAt(indexSelected,0).toString();
                    }
                    dispose();
                }
        });
    }

    private void MostrarMedicosPorEspecialidade(){
        List<Medico> listaDeMedicos = ListaDeMedico.retornaListaDeMedicoPorEspecialidade(textBuscaPaciente.getText());
        if(listaDeMedicos.size() == 0){
            FuncoesGerais.MensagemInforma("Não existe médicos cadastrados com a especialidade solicitada!",false);
            dispose();
            return;
        }
        CriarListaMedicos(listaDeMedicos);

    }

    //link di video do youtube
    //https://www.youtube.com/watch?v=3R1itvzQKpk

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CriarListaMedicos(ListaDeMedico.retornaTodos());

    }

    private void CriarListaMedicos(List<Medico> listaDeMedicos){
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
        if(listaDeMedicos.stream().count() > 0)
            listaDeMedicos.forEach(medico -> model.addRow(new Object[]{medico.getNome(), medico.getEspecialidade()}));
        table1.setModel(model);
        table1.revalidate();
    }
}
