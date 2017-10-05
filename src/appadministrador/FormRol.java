package appadministrador;

import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ines Muñoz
 */
public class FormRol extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;

    private static FormRol instance1;

    public static FormRol getInstance1() {
        if (instance1 == null) {
            instance1 = new FormRol();
        }
        return instance1;
    }

    private FormRol() {
        initComponents();
        setLocationRelativeTo(null);
        this.cbUnidadInterna.removeAllItems();
        ArrayList<String> listanom = new ArrayList<String>();

        listanom = this.cargarComboId();

        for (String i : listanom) {
            this.cbUnidadInterna.addItem(i);
        }

        Deshabilitar();
        conn = conexion.getConexion();
        llenar();
    }

    public ArrayList<String> cargarComboId() {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            conn = conexion.getConexion();
            String sql = "select id_unidad from unidad";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("id_unidad"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    /*/   public ArrayList<String> cargarComboNombre() {
        ArrayList<String> lista = new ArrayList<String>();
      
        try {
            conn = conexion.getConexion();
            String sql = "select nombre_unidad from unidad";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
             while (rs.next()) {
                lista.add(rs.getString("nombre_unidad"));
                              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }*/

    void Deshabilitar() {
        this.tfDescripcionR.setEditable(false);
        this.tfNombreR.setEditable(false);
    }

    void Limpiar() {
        this.tfDescripcionR.setText("");
        this.tfNombreR.setText("");
    }

    void Habilitar() {
        this.tfDescripcionR.setEditable(true);
        this.tfNombreR.setEditable(true);
        this.tfDescripcionR.requestFocus();
    }

    void llenar() {
        try {
            conn = conexion.getConexion();
            String[] titulos = {"Id Rol", "Nombre Rol", "Descripcion Rol", "Unidad Interna", "Estado"};
            String sql = "select * from rol";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[5];

            while (rs.next()) {
                if (rs.getString("estado").equals("1")) {
                    fila[0] = rs.getString("id_rol");
                    fila[1] = rs.getString("nombre_rol");
                    fila[2] = rs.getString("descripcion_rol");
                    fila[3] = rs.getString("id_unidad");
                    fila[4] = rs.getString("estado");
                    model.addRow(fila);
                }
            }
            this.tbRoles.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNombreR = new javax.swing.JTextField();
        tfDescripcionR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbUnidadInterna = new javax.swing.JComboBox<>();
        tfUnidadInterna = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRoles = new javax.swing.JTable();
        btNuevoR = new javax.swing.JButton();
        btModificarR = new javax.swing.JButton();
        btEliminarR = new javax.swing.JButton();
        btGuardarR1 = new javax.swing.JButton();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Roles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Rol");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Descripción Rol");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Unidad Interna");

        cbUnidadInterna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbUnidadInterna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfDescripcionR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfUnidadInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDescripcionR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbUnidadInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUnidadInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tbRoles.setModel(new javax.swing.table.DefaultTableModel(
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
        tbRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRolesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRoles);

        btNuevoR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoR.setText("Nuevo");
        btNuevoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoRActionPerformed(evt);
            }
        });

        btModificarR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarR.setText("Modificar");
        btModificarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarRActionPerformed(evt);
            }
        });

        btEliminarR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarR.setText("Eliminar");
        btEliminarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarRActionPerformed(evt);
            }
        });

        btGuardarR1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarR1.setText("Guardar");
        btGuardarR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarR1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNuevoR)
                        .addGap(31, 31, 31)
                        .addComponent(btGuardarR1)
                        .addGap(34, 34, 34)
                        .addComponent(btModificarR)
                        .addGap(44, 44, 44)
                        .addComponent(btEliminarR)
                        .addGap(91, 91, 91))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNuevoR)
                    .addComponent(btModificarR)
                    .addComponent(btEliminarR)
                    .addComponent(btGuardarR1))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoRActionPerformed
        Limpiar();
        Habilitar();
    }//GEN-LAST:event_btNuevoRActionPerformed

    private void btGuardarR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarR1ActionPerformed
       String item = (String )this.cbUnidadInterna.getSelectedItem();
      // JOptionPane.showMessageDialog(null, ""+item);
         String estado = "1";
              try{
            String sql = "insert into rol(nombre_rol,descripcion_rol,id_unidad,estado) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, this.tfNombreR.getText());            
            ps.setString(2, this.tfDescripcionR.getText());
            ps.setString(3, item);
            ps.setString(4,estado);
            int n = ps.executeUpdate();
            if(n>0)
            {
             JOptionPane.showMessageDialog(null, "Rol Ingresado con éxito");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al insertar "+e.getMessage());
        }
        llenar();
        Limpiar();
    }//GEN-LAST:event_btGuardarR1ActionPerformed

    private void tbRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRolesMouseClicked
       if(evt.getButton()==1)
        {
            int fila = this.tbRoles.getSelectedRow();
              
            try{
                Habilitar();
                String sql = "select * from rol where id_rol = "+this.tbRoles.getValueAt(fila,0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                
                rs.next();
                this.tfNombreR.setText(rs.getString("nombre_rol"));
                this.tfDescripcionR.setText(rs.getString("descripcion_rol"));
                this.cbUnidadInterna.setSelectedItem(rs.getString("id_unidad"));
           
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_tbRolesMouseClicked

    private void btEliminarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarRActionPerformed
         try {
            int fila = this.tbRoles.getSelectedRow();
            String sql = "Update rol  SET estado = '0' where id_rol = "+this.tbRoles.getValueAt(fila,0);
             
               sent = conn.createStatement();
               int n = sent.executeUpdate(sql);
              
               if(n>0)
               {
                   llenar();
                   JOptionPane.showMessageDialog(null, "Rol Eliminado exitosamente");
               }
               
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }//GEN-LAST:event_btEliminarRActionPerformed

    private void btModificarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarRActionPerformed
          try {
          
            String sql = "Update rol  SET nombre_rol = ? ,descripcion_rol= ? , id_unidad= ? where id_rol = ?";
             
              int fila = this.tbRoles.getSelectedRow();
              String dao = (String) this.tbRoles.getValueAt(fila,0);
              PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, this.tfNombreR.getText());            
                ps.setString(2, this.tfDescripcionR.getText());
                  String item = (String )this.cbUnidadInterna.getSelectedItem();
                ps.setString(3, item);
                ps.setString(4,dao);
                int n = ps.executeUpdate();
                if(n>0)
               {
                   Limpiar();
                   llenar();
                   JOptionPane.showMessageDialog(null, "Rol Modificado");
               }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }//GEN-LAST:event_btModificarRActionPerformed

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
            java.util.logging.Logger.getLogger(FormRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarR;
    private javax.swing.JButton btGuardarR1;
    private javax.swing.JButton btModificarR;
    private javax.swing.JButton btNuevoR;
    private javax.swing.JComboBox<String> cbUnidadInterna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRoles;
    private javax.swing.JTextField tfDescripcionR;
    private javax.swing.JTextField tfNombreR;
    private javax.swing.JTextField tfUnidadInterna;
    // End of variables declaration//GEN-END:variables
}
