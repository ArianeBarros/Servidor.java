//Formulario Principal
package Servidor.java;
import bd.*;
import bd.core.*;
import bd.daos.Salas;
import bd.dbos.Sala;
import java.awt.Color;
import java.sql.Array;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import controle.SalaUsuario;
import controle.Usuario;

public class FormularioPrincipal extends javax.swing.JFrame {

    SalaUsuario<Usuario> sala = new SalaUsuario<Usuario>();
    Usuario usuario;
    /**
     * Creates new form Crud
     */
    public FormularioPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        txtMessage = new javax.swing.JTextField();
       // jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel1.setText("CHAT");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setText("Usuário: ");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Salas disponíveis:");

        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        btnEntrar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtMessage.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMessage.setText("Mensagem:");

        //jScrollPane1.setViewportView(txtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   // .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      //  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    //.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
               //.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  ) ) ;      );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {

		usuario = new Usuario(Socket conexao, ObjectOutputStream transmissor, ObjectInputStream receptor, txtNome.text, sala);


         sala.add(usuario);

        new FormularioChat();

      /*txtMessage.setForeground(Color.black);
      txtMessage.setText("Mensagem:");
        if(txtCodigo.getText() == null || "".equals(txtCodigo.getText()))
       {
           txtMessage.setForeground(Color.red);
           txtMessage.setText("Erro ao incluir : Complete todos os campos");
           txtCodigo.grabFocus();
       }
       else
       {
           if(txtTitulo.getText() == null || "".equals(txtTitulo.getText()))
            {
                txtMessage.setForeground(Color.red);
                txtMessage.setText("Erro ao incluir : Complete todos os campos");
                txtTitulo.grabFocus();
            }
           else
           {
            if(txtPreco.getText() == null || "".equals(txtPreco.getText()))
            {
                txtMessage.setForeground(Color.red);
                txtMessage.setText("Erro ao incluir : Complete todos os campos");
                txtPreco.grabFocus();
            }
            else
            {
                try
                {
                    Salas.incluir(new Sala(Integer.parseInt(txtCodigo.getText()),
                            txtTitulo.getText(),Float.parseFloat(txtPreco.getText())));
                    txtMessage.setText("Mensagem: Sala incluido.");
                } catch (Exception ex)
                {
                    Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                     txtMessage.setText("Mensagem: Erro ao incluir - Código já existente.");
                }
            }
           }
       }
        txtPreco.setText("");
        txtTitulo.setText("");
        txtCodigo.setText("");*/
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         txtMessage.setForeground(Color.black);
         txtMessage.setText("Mensagem:");

         if(txtCodigo.getText() == null || "".equals(txtCodigo.getText()))
       {
           txtMessage.setForeground(Color.red);
           txtMessage.setText("Erro ao editar : Digite o código do livro a ser editado.");
           txtCodigo.grabFocus();
       }
       else
       {

        if(txtTitulo.getText() == null || "".equals(txtTitulo.getText()))
            {
                if(txtPreco.getText() == null || "".equals(txtPreco.getText()))
                {
                    txtMessage.setForeground(Color.red);
                    txtMessage.setText("Erro ao editar : Digite o que deseja mudar no livro.");
                    txtTitulo.grabFocus();
                }
            }
           else
           {
            try {
                if(Salas.cadastrado(Integer.parseInt(txtCodigo.getText())))
                {
                    if(txtPreco.getText() == null || "".equals(txtPreco.getText()))
                    {
                        try {
                            float preco = (Salas.getSala(Integer.parseInt(txtCodigo.getText()))).getPreco();
                            Salas.alterar(new Sala(Integer.parseInt(txtCodigo.getText()),
                                    txtTitulo.getText(),preco));
                            txtMessage.setText("Mensagem: Sala editado.");
                        }
                        catch (Exception ex) {
                            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                            txtMessage.setText("Mensagem: Erro na edição do livro - Não existe.");
                        }

                    }
                    else
                    {
                        if(txtTitulo.getText() == null || "".equals(txtTitulo.getText()))
                        {
                            try {
                                String titulo = (Salas.getSala(Integer.parseInt(txtCodigo.getText()))).getNome();
                                Salas.alterar(new Sala(Integer.parseInt(txtCodigo.getText()),
                                        titulo,Float.parseFloat(txtPreco.getText())));
                                txtMessage.setText("Mensagem: Sala editado.");
                            }
                            catch (Exception ex) {
                                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                                txtMessage.setText("Mensagem: Erro na edição do livro - Não existe.");
                            }

                        }

                        else
                        {
                            try {
                                Salas.alterar(new Sala(Integer.parseInt(txtCodigo.getText()),
                                        txtTitulo.getText(),Float.parseFloat(txtPreco.getText())));
                                txtMessage.setText("Mensagem: Sala editado.");
                            }
                            catch (Exception ex) {
                                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                                txtMessage.setText("Mensagem: Erro na edição do livro - Não existe.");
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
       }
          txtPreco.setText("");
        txtTitulo.setText("");
        txtCodigo.setText("");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        txtMessage.setForeground(Color.black);
         txtMessage.setText("Mensagem:");

         if(txtCodigo.getText() == null || "".equals(txtCodigo.getText()))
       {
           txtMessage.setForeground(Color.red);
           txtMessage.setText("Erro ao consultar : Digite o código do livro a ser consultado.");
           txtCodigo.grabFocus();
       }
       else
       {

        try {
            if(Salas.cadastrado(Integer.parseInt(txtCodigo.getText())))
            {
            Sala livro = Salas.getSala(Integer.parseInt(txtCodigo.getText()));
            String titulo = livro.getNome();
            String preco = livro.getPreco() +"";
            txtTitulo.setText(titulo);
            txtPreco.setText(preco);
            txtMessage.setText("Mensagem: Consulta realizada com sucesso.");
            }
            else
            {
                 txtMessage.setForeground(Color.red);
                 txtMessage.setText("Mensagem: Erro na consulta do livro - Não existe.");
            }
            }
            catch (Exception ex) {
                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                 txtMessage.setForeground(Color.red);
                 txtMessage.setText("Mensagem: Erro na consulta do livro .");
            }
       }

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       txtMessage.setForeground(Color.black);
         txtMessage.setText("Mensagem:");


          if(txtCodigo.getText() == null || "".equals(txtCodigo.getText()))
       {
           txtMessage.setForeground(Color.red);
           txtMessage.setText("Erro ao excluir : Digite o código do livro a ser editado.");
           txtCodigo.grabFocus();
       }
          else
          {
           try
           {
               if(Salas.cadastrado(Integer.parseInt(txtCodigo.getText())))
               {

              String message = "Deseja realmente excluir o cadastro deste livro?";
                String title = "Confirmação";

                int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION)
                  {
                    try
                    {
                        Salas.excluir(Integer.parseInt(txtCodigo.getText()));
                        txtMessage.setText("Mensagem: Consulta excluída com sucesso .");
                    }
                    catch (Exception ex)
                    {
                        Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                        txtMessage.setText("Erro ao excluir.");
                    }

                    txtCodigo.setText("");
                    txtTitulo.setText("");
                    txtPreco.setText("");
                  }
               }
               else
               {
                    txtMessage.setForeground(Color.red);
                     txtMessage.setText("Erro ao excluir: Sala não existente.");
               }
          }
                catch (Exception ex)
              {
                  Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                  txtMessage.setText("Erro ao excluir.");
              }
          }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            MeuResultSet resultado = Salas.getSalas();
            for(int i = 0; i<resultado.getRow();i++)
                {
                    for(int c = 0 ; c<4;c++)
                    {
                            resultado.absolute(i);

                            txtArea.append(resultado.getString(c) + "     ");
                    }
                    txtArea.append("\n");
            }
        }
        catch (Exception ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Crud().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
