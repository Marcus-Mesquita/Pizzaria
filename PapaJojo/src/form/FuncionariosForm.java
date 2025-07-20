/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.FuncionariosDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import log.FuncionariosLog;

/**
 *
 * @author Aluno
 */
public class FuncionariosForm extends javax.swing.JFrame {

    /**
     * Creates new form FuncionariosForm
     */
    public FuncionariosForm() {
        initComponents();
    }

      DefaultTableModel tmfuncionario = new DefaultTableModel(null, new String[]{"CPF", "NOME", "SALARIO", "CARGO", "TELEFONE"});
    List<FuncionariosLog> funcionario;
    ListSelectionModel lsmcontato;

    
        public boolean DadosObriga() {
        //campos de preenchimento obrigatorio
        if (!TfNome.getText().equals("")
                && !TfCPF.getText().equals("") 
                && !TfCargo.getText().equals("")
                && !TfSalario.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios ( * ) não Preenchidos");
            return false;
        }
    }
        
      public void pesq_p() throws SQLException {
        FuncionariosDao dao = new FuncionariosDao();
        funcionario = dao.getLista("%" + TfPesq.getText() + "%");
        most_p(funcionario);
        
    }
      
       private void most_p(List<FuncionariosLog> contatos) {
        while (tmfuncionario.getRowCount() > 0) {
            tmfuncionario.removeRow(0);
        }
        if (contatos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Cliente nao cadastrado");
        } else {
            String[] linha = new String[]{null, null, null, null, null};
            for (int i = 0; i < contatos.size(); i++) {
                tmfuncionario.addRow(linha);
                tmfuncionario.setValueAt(contatos.get(i).getCpf(), i, 0);
                tmfuncionario.setValueAt(contatos.get(i).getNome(), i, 1);
                tmfuncionario.setValueAt(contatos.get(i).getSalario(), i, 2);
                tmfuncionario.setValueAt(contatos.get(i).getCargo(), i, 3);
                tmfuncionario.setValueAt(contatos.get(i).getTel(), i, 4);
            }
        }
    }
    private void LinhaTab(JTable tabela) {
    if (jTable2.getSelectedRow() != -1) {
        TfCPF.setText(String.valueOf(funcionario.get(tabela.getSelectedRow()).getCpf()));
        TfCargo.setText(funcionario.get(tabela.getSelectedRow()).getCargo());
        TfNome.setText(funcionario.get(tabela.getSelectedRow()).getNome());
        TfTel.setText(String.valueOf(funcionario.get(tabela.getSelectedRow()).getTel()));
        TfSalario.setText(String.valueOf(funcionario.get(tabela.getSelectedRow()).getSalario()));
    } else {
        btLimparActionPerformed(null);
    }
    
    
}
    
    public void salva() {
        try {
            FuncionariosLog c1 = new FuncionariosLog();
            c1.setNome(TfNome.getText());
            c1.setCargo(TfCargo.getText());
            c1.setTel(TfTel.getText());
            c1.setSalario(Double.valueOf(TfSalario.getText()));
            c1.setCpf(Long.valueOf(TfCPF.getText()));
            FuncionariosDao dao = new FuncionariosDao();
            dao.adiciona(c1);
            JOptionPane.showMessageDialog(null, "Cadastrado com SUCESSO");
        } 
            
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha no envio" + ex.toString());
            
             System.out.println("Erro: " + ex.getMessage());
        }
    }

public void exclui() {
        int resp = JOptionPane.showConfirmDialog(this, "DESEJA EXCLUIR?",
                "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            FuncionariosDao exc;
            try {
                exc = new FuncionariosDao();
                exc.Excluir(funcionario.get(jTable2.getSelectedRow()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir");
            }
        }
    }


 public void alterar() {
        if (jTable2.getSelectedRow() != -1) {
            if (DadosObriga()) {
                
                try {
                    FuncionariosLog c1 = new FuncionariosLog();
                    FuncionariosDao alt = new FuncionariosDao();
                    c1.setCpf(Long.valueOf(TfCPF.getText()));
                    c1.setNome(TfNome.getText());
                    c1.setSalario(Double.valueOf(TfSalario.getText()));
                    c1.setTel(TfTel.getText());
                    c1.setCargo(TfCargo.getText());

                    alt.altera(c1);
                    JOptionPane.showMessageDialog(null, "Dados Alterados");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Falha no envio");
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        TfPesq = new javax.swing.JTextField();
        BtPesq = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TfCPF = new javax.swing.JTextField();
        TfNome = new javax.swing.JTextField();
        TfSalario = new javax.swing.JTextField();
        TfCargo = new javax.swing.JTextField();
        TfTel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CBSetores = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        BtSalva = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btRetornar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(202, 225, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        TfPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPesqActionPerformed(evt);
            }
        });

        BtPesq.setBackground(new java.awt.Color(255, 153, 153));
        BtPesq.setText("Procurar");
        BtPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtPesq)
                    .addComponent(TfPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TfPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtPesq)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(202, 225, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("CPF*");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome*");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Salario*");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Cargo*");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Telefone");

        TfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfCPFActionPerformed(evt);
            }
        });

        TfNome.setForeground(new java.awt.Color(76, 118, 106));
        TfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfNomeActionPerformed(evt);
            }
        });

        TfSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfSalarioActionPerformed(evt);
            }
        });

        TfCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfCargoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Setor");

        CBSetores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TfTel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TfCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TfSalario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TfCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBSetores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(202, 225, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botões"));

        BtSalva.setBackground(new java.awt.Color(60, 179, 113));
        BtSalva.setText("Salvar");
        BtSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvaActionPerformed(evt);
            }
        });

        BtExcluir.setBackground(new java.awt.Color(60, 179, 113));
        BtExcluir.setText("Excluir");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        BtAlterar.setBackground(new java.awt.Color(239, 239, 239));
        BtAlterar.setText("Alterar");
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        btLimpar.setBackground(new java.awt.Color(255, 153, 153));
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btRetornar.setBackground(new java.awt.Color(255, 153, 153));
        btRetornar.setText("Retornar");
        btRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtSalva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRetornar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtSalva)
                    .addComponent(BtExcluir)
                    .addComponent(BtAlterar)
                    .addComponent(btLimpar)
                    .addComponent(btRetornar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setBackground(new java.awt.Color(255, 220, 218));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(tmfuncionario);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmcontato = jTable2.getSelectionModel();
        lsmcontato.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                if (! e.getValueIsAdjusting()){
                    LinhaTab(jTable2);
                }
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(133, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TfPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfPesqActionPerformed

    private void BtPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqActionPerformed
        // TODO add your handling code here:
        try {
            pesq_p();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nome não encontrado ");
        }
    }//GEN-LAST:event_BtPesqActionPerformed

    private void TfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfCPFActionPerformed

    private void TfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfNomeActionPerformed

    private void TfSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfSalarioActionPerformed

    private void TfCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfCargoActionPerformed

    private void BtSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvaActionPerformed
        // TODO add your handling code here:
        if (DadosObriga()) {
            salva();

        }      btLimparActionPerformed(evt);
    }//GEN-LAST:event_BtSalvaActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        // TODO add your handling code here:
        exclui();
        BtPesqActionPerformed(evt);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed
        // TODO add your handling code here:
        alterar();
        BtPesqActionPerformed(evt);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        TfCPF.setText("");
        TfCargo.setText("");
        TfSalario.setText("");
        TfNome.setText("");
        TfTel.setText("");
        TfPesq.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetornarActionPerformed
        // TODO add your handling code here:
        new form.Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btRetornarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionariosForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtPesq;
    private javax.swing.JButton BtSalva;
    private javax.swing.JComboBox<String> CBSetores;
    private javax.swing.JTextField TfCPF;
    private javax.swing.JTextField TfCargo;
    private javax.swing.JTextField TfNome;
    private javax.swing.JTextField TfPesq;
    private javax.swing.JTextField TfSalario;
    private javax.swing.JTextField TfTel;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRetornar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
