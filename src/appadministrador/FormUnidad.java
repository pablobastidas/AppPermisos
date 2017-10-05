
package appadministrador;
import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ines Muñoz
 */
public class FormUnidad extends javax.swing.JFrame {
    
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    
    private static FormUnidad instance1;
    
    public static FormUnidad getInstance1(){
        if(instance1==null){
            instance1 = new FormUnidad();
        }
        return instance1;
    }
    private FormUnidad() {
        initComponents();
         setLocationRelativeTo(null);
         Deshabilitar();
          
        conn = conexion.getConexion();
       llenar();
    }
    void Deshabilitar(){
        this.tfNombreU.setEditable(false);
    }
    void Limpiar(){
        this.tfNombreU.setText("");
    }
    void Habilitar(){
        this.tfNombreU.setEditable(true);
        this.tfNombreU.requestFocus();
    }
    void llenar(){
        try{
            conn = conexion.getConexion();
            String[]titulos ={"Id Unidad","Nombre Unidad","Estado"};
            String sql = "select * from unidad";
          model = new DefaultTableModel(null,titulos);
          sent = conn.createStatement();
          ResultSet rs = sent.executeQuery(sql);
          
          String[] fila = new String[3];
          
          while(rs.next()){
              if(rs.getString("estado").equals("1")){
              fila[0] = rs.getString("id_unidad");
              fila[1] = rs.getString("nombre_unidad");
              fila[2] = rs.getString("estado");
              model.addRow(fila);
              }
          }
          this.tbUnidad.setModel(model);
         }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNombreU = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUnidad = new javax.swing.JTable();
        btNuevoU = new javax.swing.JButton();
        btModificarU = new javax.swing.JButton();
        btEliminarU = new javax.swing.JButton();
        btGuardarU1 = new javax.swing.JButton();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Unidad Interna", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Unidad");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(tfNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        tbUnidad.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUnidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUnidad);

        btNuevoU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoU.setText("Nuevo");
        btNuevoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoUActionPerformed(evt);
            }
        });

        btModificarU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarU.setText("Modificar");
        btModificarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarUActionPerformed(evt);
            }
        });

        btEliminarU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarU.setText("Eliminar");
        btEliminarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarUActionPerformed(evt);
            }
        });

        btGuardarU1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarU1.setText("Guardar");
        btGuardarU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarU1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btNuevoU)
                        .addGap(26, 26, 26)
                        .addComponent(btGuardarU1)
                        .addGap(29, 29, 29)
                        .addComponent(btModificarU)
                        .addGap(36, 36, 36)
                        .addComponent(btEliminarU)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNuevoU)
                    .addComponent(btModificarU)
                    .addComponent(btEliminarU)
                    .addComponent(btGuardarU1))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoUActionPerformed
       Limpiar();
       Habilitar();
    }//GEN-LAST:event_btNuevoUActionPerformed

    private void btGuardarU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarU1ActionPerformed
      
      String estado = "1";
              try{
            String sql = "insert into unidad(nombre_unidad,estado) values(?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, this.tfNombreU.getText());            
            ps.setString(2,estado);
            int n = ps.executeUpdate();
            if(n>0)
            {
             JOptionPane.showMessageDialog(null, "Unidad Ingresado con éxito");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al insertar "+e.getMessage());
        }
        llenar();
        Limpiar();                   
    }//GEN-LAST:event_btGuardarU1ActionPerformed
  
    private void btEliminarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarUActionPerformed
       try {
            int fila = this.tbUnidad.getSelectedRow();
            String sql = "Update unidad SET estado = '0' where id_unidad = "+this.tbUnidad.getValueAt(fila,0);
             
               sent = conn.createStatement();
               int n = sent.executeUpdate(sql);
              
               if(n>0)
               {
                   llenar();
                   JOptionPane.showMessageDialog(null, "Unidad Eliminada exitosamente");
               }
               
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
        
    }//GEN-LAST:event_btEliminarUActionPerformed

    private void tbUnidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUnidadMouseClicked
       if(evt.getButton()==1)
        {
            int fila = this.tbUnidad.getSelectedRow();
              
            try{
                Habilitar();
                String sql = "select * from unidad where id_unidad = "+this.tbUnidad.getValueAt(fila,0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                
                rs.next();
                this.tfNombreU.setText(rs.getString("nombre_unidad"));
           
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_tbUnidadMouseClicked

    private void btModificarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarUActionPerformed
           try {
          
            String sql = "Update unidad SET nombre_unidad = ? where id_unidad = ?";
             
              int fila = this.tbUnidad.getSelectedRow();
              String dao = (String) this.tbUnidad.getValueAt(fila,0);
              PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, this.tfNombreU.getText());   
                ps.setString(2, dao);
                int n = ps.executeUpdate();
                if(n>0)
               {
                   Limpiar();
                   llenar();
                   JOptionPane.showMessageDialog(null, "Unidad Modificada");
               }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }//GEN-LAST:event_btModificarUActionPerformed

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
            java.util.logging.Logger.getLogger(FormUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUnidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarU;
    private javax.swing.JButton btGuardarU1;
    private javax.swing.JButton btModificarU;
    private javax.swing.JButton btNuevoU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUnidad;
    private javax.swing.JTextField tfNombreU;
    // End of variables declaration//GEN-END:variables
}
