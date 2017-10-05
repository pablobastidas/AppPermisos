package appadministrador;

import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Inés Muñoz
 */
public class FormMotivo extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;

    private static FormMotivo instance1;

    public static FormMotivo getInstance1() {
        if (instance1 == null) {
            instance1 = new FormMotivo();
        }
        return instance1;
    }

    private FormMotivo() {
        initComponents();
        setLocationRelativeTo(null);
        this.cbTipos.removeAllItems();
        ArrayList<String> listanom = new ArrayList<String>();
        listanom = this.cargarComboId();

        for (String i : listanom) {
            this.cbTipos.addItem(i);
        }
        Deshabilitar();
        conn = conexion.getConexion();
        llenar();

    }

    public ArrayList<String> cargarComboId() {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            conn = conexion.getConexion();
            String sql = "select id_tiposolicitud from tipo_solicitud";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("id_tiposolicitud"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    void Deshabilitar() {
        this.tfDescripcionM.setEditable(false);

    }

    void Limpiar() {
        this.tfDescripcionM.setText("");

    }

    void Habilitar() {
        this.tfDescripcionM.setEditable(true);
    }

    void llenar() {
        try {
            conn = conexion.getConexion();
            String[] titulos = {"Id Motivo", "Descripcion Motivo", "Id Tipo solicitud"};
            String sql = "select * from motivo";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[3];

            while (rs.next()) {
                fila[0] = rs.getString("id_motivo");
                fila[1] = rs.getString("descripcion");
                fila[2] = rs.getString("id_tiposolicitud");
                model.addRow(fila);
            }
            this.tbMotivos.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Validar los campos del formulario
     *
     * @return boolean
     * @author Pablo Bastidas
     */
    private boolean ValidarCampos() {
        if (!this.tfDescripcionM.getText().equals("")) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDescripcionM = new javax.swing.JTextField();
        cbTipos = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btNuevoM = new javax.swing.JButton();
        btGuardarM = new javax.swing.JButton();
        btModificarM = new javax.swing.JButton();
        btEliminarM = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMotivos = new javax.swing.JTable();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Motivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Descripción");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Tipo de solicitud");

        cbTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNuevoM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoM.setText("Nuevo");
        btNuevoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoMActionPerformed(evt);
            }
        });

        btGuardarM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarM.setText("Guardar");
        btGuardarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarMActionPerformed(evt);
            }
        });

        btModificarM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarM.setText("Modificar");
        btModificarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarMActionPerformed(evt);
            }
        });

        btEliminarM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarM.setText("Eliminar");
        btEliminarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModificarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEliminarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNuevoM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGuardarM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btModificarM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEliminarM)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDescripcionM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDescripcionM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbMotivos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMotivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMotivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMotivos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoMActionPerformed
        Limpiar();
        Habilitar();
    }//GEN-LAST:event_btNuevoMActionPerformed

    private void btGuardarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarMActionPerformed

        if (ValidarCampos()) {
            try {
                String item = (String) this.cbTipos.getSelectedItem();
                String sql = "insert into motivo(descripcion,id_tiposolicitud) values(?,?)";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, this.tfDescripcionM.getText());
                ps.setString(2, item);
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Motivo Ingresado con éxito");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar " + e.getMessage());
            }
            llenar();
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se permiten campos vacíos.");
        }


    }//GEN-LAST:event_btGuardarMActionPerformed

    private void tbMotivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMotivosMouseClicked
        if (evt.getButton() == 1) {
            int fila = this.tbMotivos.getSelectedRow();

            try {
                Habilitar();
                String sql = "select * from motivo where id_motivo = " + this.tbMotivos.getValueAt(fila, 0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);

                rs.next();
                this.tfDescripcionM.setText(rs.getString("descripcion"));
                this.cbTipos.setSelectedItem(rs.getString("id_tiposolicitud"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tbMotivosMouseClicked

    private void btEliminarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarMActionPerformed

        if (this.tbMotivos.getSelectedRow() > -1) {
            try {
                int fila = this.tbMotivos.getSelectedRow();
                String sql = "Delete motivo where id_motivo = " + this.tbMotivos.getValueAt(fila, 0);

                sent = conn.createStatement();
                int n = sent.executeUpdate(sql);

                if (n > 0) {
                    llenar();
                    JOptionPane.showMessageDialog(null, "Motivo Eliminado exitosamente");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un Motivo de la lista.");
        }
    }//GEN-LAST:event_btEliminarMActionPerformed

    private void btModificarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarMActionPerformed

        if (ValidarCampos()) {
            try {

                String sql = "Update motivo SET descripcion = ? ,id_tiposolicitud= ?  where id_motivo = ?";
                String item = (String) this.cbTipos.getSelectedItem();
                int fila = this.tbMotivos.getSelectedRow();
                String dao = (String) this.tbMotivos.getValueAt(fila, 0);
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, this.tfDescripcionM.getText());
                ps.setString(2, item);
                ps.setString(3, dao);

                int n = ps.executeUpdate();
                if (n > 0) {
                    Limpiar();
                    llenar();
                    JOptionPane.showMessageDialog(null, "Motivo Modificado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se permiten campos vacíos.");
        }


    }//GEN-LAST:event_btModificarMActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMotivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarM;
    private javax.swing.JButton btGuardarM;
    private javax.swing.JButton btModificarM;
    private javax.swing.JButton btNuevoM;
    private javax.swing.JComboBox<String> cbTipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMotivos;
    private javax.swing.JTextField tfDescripcionM;
    // End of variables declaration//GEN-END:variables
}
