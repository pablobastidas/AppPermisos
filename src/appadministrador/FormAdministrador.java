
package appadministrador;

import javax.swing.ImageIcon;

/**
 *
 * @author InésMuñoz
 */
public class FormAdministrador extends javax.swing.JFrame {

    
  
    public FormAdministrador() {
        initComponents(); 
        this.setLocationRelativeTo(null);
       
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lImagen = new javax.swing.JLabel();
        lBienvenido = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mPermisos = new javax.swing.JMenu();
        miTipoPermiso = new javax.swing.JMenuItem();
        miMotivo = new javax.swing.JMenuItem();
        mFuncionario = new javax.swing.JMenu();
        miFuncionario = new javax.swing.JMenuItem();
        miUnidad = new javax.swing.JMenuItem();
        miRol = new javax.swing.JMenuItem();
        mRoles = new javax.swing.JMenu();
        mSalir = new javax.swing.JMenu();
        miCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setName("formAdministrador"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 500));

        lImagen.setIcon(new javax.swing.ImageIcon("C:\\Users\\perritosAIBO\\Downloads\\logo .png")); // NOI18N

        lBienvenido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lBienvenido.setText("Bienvenido Administrador");

        jMenuBar1.setAlignmentY(2.5F);

        mPermisos.setText("Gestión Permisos");

        miTipoPermiso.setText("Tipo de Permiso");
        miTipoPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTipoPermisoActionPerformed(evt);
            }
        });
        mPermisos.add(miTipoPermiso);

        miMotivo.setText("Motivo");
        miMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMotivoActionPerformed(evt);
            }
        });
        mPermisos.add(miMotivo);

        jMenuBar1.add(mPermisos);

        mFuncionario.setText("Gestión Administrativa");

        miFuncionario.setText("Gestión Funcionario");
        miFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFuncionarioActionPerformed(evt);
            }
        });
        mFuncionario.add(miFuncionario);

        miUnidad.setText("Gestión Unidad Interna");
        miUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUnidadActionPerformed(evt);
            }
        });
        mFuncionario.add(miUnidad);

        miRol.setText("Gestión Roles");
        miRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRolActionPerformed(evt);
            }
        });
        mFuncionario.add(miRol);

        jMenuBar1.add(mFuncionario);
        jMenuBar1.add(mRoles);

        mSalir.setText("Salir");

        miCerrarSesion.setText("Cerrar Sesión");
        miCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarSesionActionPerformed(evt);
            }
        });
        mSalir.add(miCerrarSesion);

        jMenuBar1.add(mSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lBienvenido)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(lImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lBienvenido)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarSesionActionPerformed
       
          FormLogin a = new FormLogin();
                       a.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_miCerrarSesionActionPerformed

    private void miTipoPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTipoPermisoActionPerformed
       FormTipo t =  FormTipo.getInstance1();
       t.setVisible(true);
    }//GEN-LAST:event_miTipoPermisoActionPerformed

    private void miMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMotivoActionPerformed
        FormMotivo t =  FormMotivo.getInstance1();
        t.setVisible(true);
    }//GEN-LAST:event_miMotivoActionPerformed

    private void miRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRolActionPerformed
        FormRol t =  FormRol.getInstance1();
        t.setVisible(true);
    }//GEN-LAST:event_miRolActionPerformed

    private void miUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUnidadActionPerformed
        FormUnidad t =  FormUnidad.getInstance1();
        t.setVisible(true);
    }//GEN-LAST:event_miUnidadActionPerformed

    private void miFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFuncionarioActionPerformed
        FormFuncionario t =  FormFuncionario.getInstance1();
        t.setVisible(true);
    }//GEN-LAST:event_miFuncionarioActionPerformed

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
            java.util.logging.Logger.getLogger(FormAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lBienvenido;
    private javax.swing.JLabel lImagen;
    private javax.swing.JMenu mFuncionario;
    private javax.swing.JMenu mPermisos;
    private javax.swing.JMenu mRoles;
    private javax.swing.JMenu mSalir;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miFuncionario;
    private javax.swing.JMenuItem miMotivo;
    private javax.swing.JMenuItem miRol;
    private javax.swing.JMenuItem miTipoPermiso;
    private javax.swing.JMenuItem miUnidad;
    // End of variables declaration//GEN-END:variables
}
