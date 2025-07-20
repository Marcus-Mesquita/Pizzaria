/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.ClienteDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import log.ClienteLog;

/**
 *
 * @author Aluno
 */
public class ClienteForm extends javax.swing.JFrame {

    DefaultTableModel tmCliente = new DefaultTableModel(null, new String[]{"CPF", "EMAIL", "NOME", "TELEFONE", "DATA DE NASCIMENTO"});
    List<ClienteLog> cliente;
    ListSelectionModel lsmcontato;
    /**
     * Creates new form ClienteForm
     */
    public ClienteForm() {
        initComponents();
    }
    
    public boolean DadosObriga() {
        //campos de preenchimento obrigatorio
        if (!TfCPF.getText().equals("")
                && !TfNome.getText().equals("")
                && !TfTelefone.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios ( * ) não Preenchidos");
            return false;
        }
    }
    
    
  public void pesq_p() throws SQLException {
        ClienteDao dao = new ClienteDao();
        cliente = dao.getLista("%" + TfPesq.getText() + "%");
        most_p(cliente);
        
    }

public void salva() {
        try {
            ClienteLog c1 = new ClienteLog();
            c1.setCpf(Long.valueOf(TfCPF.getText()));
            c1.setNome(TfNome.getText());
            c1.setEmail(TfEmail.getText());
            c1.setContato(TfTelefone.getText());
            c1.setNascimento(TfData.getText());

            ClienteDao dao = new ClienteDao();
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
            ClienteDao exc;
            try {
                exc = new ClienteDao();
                exc.Excluir(cliente.get(jTable2.getSelectedRow()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir");
            }
        }
    }


 public void alterar() {
        if (jTable2.getSelectedRow() != -1) {
            if (DadosObriga()) {
                
                try {
                    ClienteLog c1 = new ClienteLog();
                    ClienteDao alt = new ClienteDao();
                    c1.setCpf(Long.valueOf(TfCPF.getText()));
                    c1.setEmail(TfEmail.getText());
                    c1.setNome(TfNome.getText());
                    c1.setNascimento(TfData.getText());
                    c1.setContato(TfTelefone.getText());

                    alt.altera(c1);
                    JOptionPane.showMessageDialog(null, "Dados Alterados");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Falha no envio");
                }
            }
        }
    }

 private void most_p(List<ClienteLog> contatos) {
        while (tmCliente.getRowCount() > 0) {
            tmCliente.removeRow(0);
        }
        if (contatos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Cliente nao cadastrado");
        } else {
            String[] linha = new String[]{null, null, null, null, null};
            for (int i = 0; i < contatos.size(); i++) {
                tmCliente.addRow(linha);
                tmCliente.setValueAt(contatos.get(i).getCpf(), i, 0);
                tmCliente.setValueAt(contatos.get(i).getEmail(), i, 1);
                tmCliente.setValueAt(contatos.get(i).getNome(), i, 2);
                tmCliente.setValueAt(contatos.get(i).getContato(), i, 3);
                tmCliente.setValueAt(contatos.get(i).getNascimento(), i, 4);
            }
        }
    }

    private void LinhaTab(JTable tabela) {
        if (jTable2.getSelectedRow() != -1) {
            TfCPF.setText(String.valueOf(cliente.get(tabela.getSelectedRow()).getCpf()));
            TfEmail.setText(cliente.get(tabela.getSelectedRow()).getEmail());
            TfNome.setText(cliente.get(tabela.getSelectedRow()).getNome());
            TfTelefone.setText(cliente.get(tabela.getSelectedRow()).getContato());
            TfData.setText(cliente.get(tabela.getSelectedRow()).getNascimento());
        } else {
            btLimparActionPerformed(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtSalva = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btRetornar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TfCPF = new javax.swing.JTextField();
        TfNome = new javax.swing.JTextField();
        TfTelefone = new javax.swing.JTextField();
        TfEmail = new javax.swing.JTextField();
        TfData = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        TfPesq = new javax.swing.JTextField();
        BtPesq = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(184, 138, 107));
        setIconImages(null);

        jPanel4.setBackground(new java.awt.Color(239, 239, 239));

        jPanel2.setBackground(new java.awt.Color(202, 225, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botões"));

        BtSalva.setBackground(new java.awt.Color(60, 179, 113));
        BtSalva.setText("Salvar");
        BtSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvaActionPerformed(evt);
            }
        });

        BtExcluir.setBackground(new java.awt.Color(239, 239, 239));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jPanel1.setBackground(new java.awt.Color(202, 225, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("CPF*");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome*");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Data de Nascimento");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Telefone*");

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

        TfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfTelefoneActionPerformed(evt);
            }
        });

        TfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfEmailActionPerformed(evt);
            }
        });

        TfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(TfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(TfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(TfData, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(TfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jTable2.setBackground(new java.awt.Color(224,240,240));
        jTable2.setForeground(new java.awt.Color(0,0,0));
        jTable2.setModel(tmCliente);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmcontato = jTable2.getSelectionModel();
        lsmcontato.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                if (! e.getValueIsAdjusting()){
                    LinhaTab(jTable2);
                }
            }
        });
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setSelectionForeground(new java.awt.Color(224, 240, 240));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfCPFActionPerformed

    private void TfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfNomeActionPerformed

    private void TfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfTelefoneActionPerformed

    private void TfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfEmailActionPerformed

    private void TfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfDataActionPerformed

    private void TfPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfPesqActionPerformed

    private void BtSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvaActionPerformed
if (DadosObriga()) {
            salva();
           
    }      btLimparActionPerformed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_BtSalvaActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
       TfCPF.setText("");
       TfEmail.setText("");
       TfNome.setText("");
       TfData.setText("");
       TfTelefone.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        exclui();
        BtPesqActionPerformed(evt);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqActionPerformed
try {
            pesq_p();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nome não encontrado ");
        }
                                          
            // TODO add your handling code here:
    }//GEN-LAST:event_BtPesqActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed
        alterar();
        BtPesqActionPerformed(evt);
    }//GEN-LAST:event_BtAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtPesq;
    private javax.swing.JButton BtSalva;
    private javax.swing.JTextField TfCPF;
    private javax.swing.JTextField TfData;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JTextField TfNome;
    private javax.swing.JTextField TfPesq;
    private javax.swing.JTextField TfTelefone;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRetornar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
