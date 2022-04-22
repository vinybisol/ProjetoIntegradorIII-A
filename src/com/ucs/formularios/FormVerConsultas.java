package com.ucs.formularios;

import com.ucs.dados.ListaDeConsultas;
import com.ucs.modelos.Consulta;
import com.ucs.util.FuncoesGerais;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;



public class FormVerConsultas extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JLabel lbFiltro;
    private JTextField textFiltroMedico;
    private JTextField textFiltroPaciente;
    private JButton btnFiltar;
    private JLabel lbQuantidade;
    private JLabel lbTamanho;
    private JLabel lbBuscarId;
    private JTextField textBuscarPorId;
    private JButton btnBuscaId;
    private DefaultTableModel model;


    public FormVerConsultas() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        CriarListaConsultas(ListaDeConsultas.retornaTodos());
        setTitle("Ver consultas");
        buttonCancel.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnFiltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltarConsulta();
            }
        });
        btnBuscaId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textBuscarPorId.getText().isEmpty())
                    return;
                String texto = textBuscarPorId.getText();
                int index = Integer.parseInt(texto);

                try{
                    var consulta = ListaDeConsultas.get(index);
                    var dialog = new FormConsultaPorId(consulta);
                    dialog.pack();
                    dialog.criarTabela();
                    dialog.setVisible(true);
                }
                catch (NullPointerException ex){
                    FuncoesGerais.MensagemInforma("Não existe consultas com esse ID", false);
                    return;
                }
                catch (Exception exception){
                    FuncoesGerais.MensagemInforma(exception.getMessage(),false);
                }

            }
        });
        textBuscarPorId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                FuncoesGerais.SomenteNumeros(e);
            }
        });
        textFiltroMedico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFiltroMedico.setText("");
            }
        });
        textFiltroPaciente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFiltroPaciente.setText("");
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
                    return 6;
                }
            }; // essa llnnha é para a quantidde de coluinas
        }
        model.getDataVector().removeAllElements();
        model.setColumnCount(0);
        if (listaConsulta.stream().count() > 0) // se for maior que 0 executa:
            model.addRow(new Object[]{"ID", "Data", "Hora", "Paciente", "Medico", "Descrição"});
        listaConsulta.forEach(consulta -> model.addRow(new Object[]{consulta.ID, consulta.Data, consulta.Hora, consulta.Medico, consulta.Paciente, consulta.toString()}));
        table1.setModel(model);
        table1.revalidate();
        lbTamanho.setText(String.valueOf(ListaDeConsultas.tamanho()));
    }

    private void FiltarConsulta(){
        String filtroMedico = textFiltroMedico.getText();
        String filtroPaciente = textFiltroPaciente.getText();
        var listaFiltrada = ListaDeConsultas.retornaFiltrada(filtroMedico, filtroPaciente);
        CriarListaConsultas(listaFiltrada);
    }
}



