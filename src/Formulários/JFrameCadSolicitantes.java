package Formulários;

import DAO.DespesasFamiliaresDAO;
import DAO.SolicitanteDAO;
import bean.DespesasFamiliares;
import bean.Solicitante;

import java.sql.Date;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFrameCadSolicitantes extends javax.swing.JDialog {

    public JFrameCadSolicitantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        edtNome = new JTextField();
        ComboboxSexo = new JComboBox<>();
        jLabel4 = new JLabel();
        edtCpf = new JFormattedTextField();
        edtRg = new JTextField();
        edtDataNascimento = new JFormattedTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        edtNaturalidade = new JTextField();
        jLabel7 = new JLabel();
        ComboboxEstadoCivil = new JComboBox<>();
        jLabel8 = new JLabel();
        jScrollPane1 = new JScrollPane();
        textAreaHistoricoSocial = new JTextArea();
        edtNomePai = new JTextField();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        edtNomeMae = new JTextField();
        btnSalvar = new JButton();
        btnExcluir = new JButton();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel14 = new JLabel();
        jLabel13 = new JLabel();
        jLabel16 = new JLabel();
        jLabel15 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        edtValorMoradia = new JFormattedTextField();
        edtValorEnergia = new JFormattedTextField();
        edtValorAgua = new JFormattedTextField();
        edtValorAlimentacao = new JFormattedTextField();
        edtValorFarmacia = new JFormattedTextField();
        edtValorGas = new JFormattedTextField();
        edtValorFinancimento = new JFormattedTextField();
        edtValorTelefone = new JFormattedTextField();
        jLabel20 = new JLabel();
        edtValorOutros = new JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Solicitantes");
        setModal(true);

        jLabel1.setText("Nome");
        jLabel2.setText("Sexo");
        jLabel3.setText("CPF");
        jLabel5.setText("Data de nascimento");
        jLabel6.setText("Naturalidade");
        jLabel7.setText("Estado Civil");
        jLabel9.setText("Nome pai");
        jLabel10.setText("Nome Mãe");
        jLabel4.setText("RG");
        jLabel8.setText("Histórico social");
        jLabel11.setText("Moradia");
        jLabel12.setText("Energia");
        jLabel14.setText("Água");
        jLabel13.setText("Farmácia");
        jLabel16.setText("Alimentação");
        jLabel15.setText("Gás");
        jLabel18.setText("Financiamento/Empréstimo");
        jLabel19.setText("Telefone");

        edtNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        ComboboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Masculino", "Feminino"}));
        

        try {
            edtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            edtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        

        ComboboxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Solteiro", "Casado", "Separado", "Divorciado", "Viúvo"}));
        

        textAreaHistoricoSocial.setColumns(20);
        textAreaHistoricoSocial.setRows(5);
        jScrollPane1.setViewportView(textAreaHistoricoSocial);

        

        edtNomeMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeMaeActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3)
                                                                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(edtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(2, 2, 2)
                                                                        .addComponent(jLabel4)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(edtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(edtNaturalidade)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1)
                                                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel7)
                                                                .addComponent(ComboboxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2)
                                                                .addComponent(ComboboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel9)
                                                                .addComponent(edtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel10)
                                                                .addComponent(edtNomeMae, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))))
                        .addGap(18, 18, 18))
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel2))
                                                        .addGap(6, 6, 6)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ComboboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ComboboxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(edtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(edtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(edtNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel9)
                                        .addGap(6, 6, 6)
                                        .addComponent(edtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(6, 6, 6)
                                        .addComponent(edtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSalvar)
                                .addComponent(btnExcluir))
                        .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Gerias", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 504, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 292, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Composição Familiar", jPanel2);

        

        edtValorMoradia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorMoradia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorEnergia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorEnergia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorAgua.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorAgua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorAlimentacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorAlimentacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorFarmacia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorFarmacia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorGas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorGas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorFinancimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorFinancimento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        edtValorTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorTelefone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel20.setText("Outros");

        edtValorOutros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edtValorOutros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edtValorMoradia)
                                        .addComponent(edtValorAlimentacao)
                                        .addComponent(edtValorFinancimento))
                                .addComponent(jLabel16))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(edtValorTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edtValorEnergia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edtValorFarmacia, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel19))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel14)
                                                                .addComponent(edtValorAgua, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                                .addComponent(jLabel15)
                                                                .addComponent(edtValorGas))
                                                        .addGap(33, 33, 33))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                        .addComponent(edtValorOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel20))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edtValorMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtValorEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtValorAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edtValorAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtValorFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtValorGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(edtValorFinancimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(edtValorTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(edtValorOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Despesas familiares", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Dados Gerais");

        pack();
    }

    private void edtNomeMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeMaeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (this.validaCampos()) {

            if (this.salvarSolicitante()) {

                if (this.salvarComposicaoFamiliar()) {

                    if (this.salvarDespesasFamiliares(1)) {
                        JOptionPane.showMessageDialog(null, "Solicitante Salvo com sucesso.");
                    }

                }
            }

        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
        try {
            solicitanteDAO.delete(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir solicitantes. Motivo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {           
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameCadSolicitantes dialog = new JFrameCadSolicitantes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public static boolean getFrameSolicitantes() {
        new JFrameCadSolicitantes(null, true);
        return true;
    }

    public boolean validaData(String data) {
        int dia = Integer.getInteger(data.substring(0, 2));
        int mes = Integer.getInteger(data.substring(3, 5));
        int ano = Integer.getInteger(data.substring(6, 10));

        if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 0 && ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30) || (mes == 2 && (dia <= 29 && ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) || dia <= 28))) {
            return true;
        } else {
            return false;
        }
    }

    public Date formataData(String data) {
        this.validaData(data);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);

        return Date.valueOf(ano + '-' + mes + '-' + dia);
    }

    public boolean validaCampos() {

        if (edtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Nome é obrigatório e não foi preenchido.");
            edtNome.requestFocus();
            return false;
        }

        if (edtCpf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo CPF é obrigatório e não foi preenchido.");
            edtCpf.requestFocus();
            return false;
        }

        if (edtRg.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo RG é obrigatório e não foi preenchido.");
            edtRg.requestFocus();
            return false;
        }

        return true;

    }

    private boolean salvarSolicitante() {

        Solicitante solicitante = new Solicitante();

        solicitante.setId(-1);
        solicitante.setCpf(edtCpf.getText());
        solicitante.setDataNascimento(formataData(edtDataNascimento.getText()));
        solicitante.setEstadoCivil(ComboboxEstadoCivil.getItemAt(ComboboxEstadoCivil.getSelectedIndex()));
        solicitante.setHistoricoSocial(textAreaHistoricoSocial.getText());
        solicitante.setNaturalidade(edtNaturalidade.getText());
        solicitante.setNome(edtNome.getText());
        solicitante.setNomeMae(edtNomeMae.getText());
        solicitante.setNomePai(edtNomePai.getText());
        solicitante.setRg(edtRg.getText());
        solicitante.setSexo(ComboboxSexo.getItemAt(ComboboxSexo.getSelectedIndex()).substring(0, 1));

        SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
        try {
            return solicitanteDAO.salvar(solicitante);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar solicitante. Motivo: " + e.getMessage());
            return false;
        }

    }

    private boolean salvarComposicaoFamiliar() {
        return true;
    }

    private boolean salvarDespesasFamiliares(int idSolicitantes) {
        
        DespesasFamiliares despesasFamiliares = new DespesasFamiliares();
        
        despesasFamiliares.setId(-1);
        despesasFamiliares.setIdSolicitante(idSolicitantes);
        despesasFamiliares.setValorAgua(Double.parseDouble(edtValorAgua.getText()));
        despesasFamiliares.setValorAlimentacao(Double.parseDouble(edtValorAlimentacao.getText()));
        despesasFamiliares.setValorEnergia(Double.parseDouble(edtValorEnergia.getText()));
        despesasFamiliares.setValorFarmacia(Double.parseDouble(edtValorFarmacia.getText()));
        despesasFamiliares.setValorFinanciamento(Double.parseDouble(edtValorFinancimento.getText()));
        despesasFamiliares.setValorGas(Double.parseDouble(edtValorGas.getText()));
        despesasFamiliares.setValorMoradia(Double.parseDouble(edtValorMoradia.getText()));
        despesasFamiliares.setValorOutros(Double.parseDouble(edtValorOutros.getText()));
        despesasFamiliares.setValorTelefone(Double.parseDouble(edtValorTelefone.getText()));

        DespesasFamiliaresDAO despesasFamiliaresDAO = new DespesasFamiliaresDAO();

        try {
            return despesasFamiliaresDAO.salvar(despesasFamiliares);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar despesas familiares");
            return false;
        }

    }

    private boolean getSolicitante() {

        Solicitante solicitante = new Solicitante();

        SolicitanteDAO solicitanteDAO = new SolicitanteDAO();

        try {

            if (solicitanteDAO.getObjeto(idSolicitante, solicitante)) {

                edtCpf.setText(solicitante.getCpf());
                edtDataNascimento.setText(solicitante.getDataNascimento().toString());
                edtNome.setText(solicitante.getNome());
                edtNaturalidade.setText((solicitante.getNaturalidade()));
                edtNomeMae.setText(solicitante.getNomeMae());
                edtNomePai.setText(solicitante.getNomePai());
                edtRg.setText(solicitante.getRg());
                textAreaHistoricoSocial.setText(solicitante.getHistoricoSocial());
                ComboboxEstadoCivil.setSelectedItem(solicitante.getEstadoCivil());
                ComboboxSexo.setSelectedItem(solicitante.getSexo());
            }
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar dados do solicitante. Motivo: " + ex.getMessage());
            return false;

        }

    }

    private JComboBox<String> ComboboxSexo;
    private JComboBox<String> ComboboxEstadoCivil;
    private JButton btnExcluir;
    private JButton btnSalvar;
    private JFormattedTextField edtCpf;
    private JFormattedTextField edtDataNascimento;
    private JTextField edtNaturalidade;
    private JTextField edtNome;
    private JTextField edtNomeMae;
    private JTextField edtNomePai;
    private JTextField edtRg;
    private JFormattedTextField edtValorAgua;
    private JFormattedTextField edtValorAlimentacao;
    private JFormattedTextField edtValorEnergia;
    private JFormattedTextField edtValorFarmacia;
    private JFormattedTextField edtValorFinancimento;
    private JFormattedTextField edtValorGas;
    private JFormattedTextField edtValorMoradia;
    private JFormattedTextField edtValorOutros;
    private JFormattedTextField edtValorTelefone;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextArea textAreaHistoricoSocial;
    
    
    private int idSolicitante;
}
