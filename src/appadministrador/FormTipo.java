package appadministrador;

import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Inés Muñoz
 */
public class FormTipo extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;

    private static FormTipo instance1;

    public static FormTipo getInstance1() {
        if (instance1 == null) {
            instance1 = new FormTipo();
        }
        return instance1;
    }

    private FormTipo() {
        initComponents();
        setLocationRelativeTo(null);
        Deshabilitar();
        conn = conexion.getConexion();
        llenar();

    }

    void Deshabilitar() {
        this.tfDescripcionTP.setEditable(false);
        this.tfCantidadTP.setEditable(false);
    }

    void Limpiar() {
        this.tfDescripcionTP.setText("");
        this.tfCantidadTP.setText("");
    }

    void Habilitar() {
        this.tfDescripcionTP.setEditable(true);
        this.tfCantidadTP.setEditable(true);
        this.tfDescripcionTP.requestFocus();
    }

    /**
     * Validar los Campos del Formulario
     *
     * @return
     * @author Pablo Bastidas
     */
    private boolean ValidarCampos() {
        if (!this.tfDescripcionTP.getText().equals("") && Integer.parseInt(this.tfCantidadTP.getText()) > 0) {
            return true;
        }
        return false;
    }

    void llenar() {
        try {
            conn = conexion.getConexion();
            String[] titulos = {"Id Tipo", "Descripcion Tipo", "cantidad dias", "Fecha Creación", "Fecha Modificacion", "estado"};
            String sql = "select * from tipo_solicitud";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();

            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[6];

            while (rs.next()) {
                if (rs.getString("estado").equals("1")) {
                    fila[0] = rs.getString("id_tiposolicitud");
                    fila[1] = rs.getString("descripcion");
                    fila[2] = rs.getString("cantidad_dias");
                    fila[3] = rs.getString("fecha_creacion");
                    fila[4] = rs.getString("fecha_modifacion");
                    fila[5] = rs.getString("estado");
                    model.addRow(fila);
                }
            }
            this.tbTipos.setModel(model);
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
        tfDescripcionTP = new javax.swing.JTextField();
        tfCantidadTP = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btNuevoTP = new javax.swing.JButton();
        btGuardarTP = new javax.swing.JButton();
        btModificarrTp = new javax.swing.JButton();
        btEliminarTP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTipos = new javax.swing.JTable();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");
        setLocation(new java.awt.Point(0, 0));
        setName("formtipo"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Tipos de Permisos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Descripción");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad de Días");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNuevoTP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoTP.setText("Nuevo");
        btNuevoTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoTPActionPerformed(evt);
            }
        });

        btGuardarTP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarTP.setText("Guardar");
        btGuardarTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarTPActionPerformed(evt);
            }
        });

        btModificarrTp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarrTp.setText("Modificar");
        btModificarrTp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarrTpActionPerformed(evt);
            }
        });

        btEliminarTP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarTP.setText("Eliminar");
        btEliminarTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarTPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModificarrTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevoTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardarTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEliminarTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNuevoTP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGuardarTP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btModificarrTp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminarTP)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfDescripcionTP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfCantidadTP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfDescripcionTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCantidadTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbTipos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTipos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoTPActionPerformed
        Limpiar();
        Habilitar();
    }//GEN-LAST:event_btNuevoTPActionPerformed

    private void btGuardarTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarTPActionPerformed

        if (ValidarCampos()) {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechacreacion = dateFormat.format(date);
            String fechamodificacion = fechacreacion;
            String estado = "1";
            try {
                String sql = "insert into tipo_solicitud(descripcion,cantidad_dias,fecha_creacion,fecha_modifacion,estado) values(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, this.tfDescripcionTP.getText());
                ps.setString(2, this.tfCantidadTP.getText());

                ps.setString(3, fechacreacion);

                ps.setString(4, fechamodificacion);
                ps.setString(5, estado);
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Tipo de Permiso Ingresado con éxito");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar " + e.getMessage());
            }
            llenar();
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error: No puede ingresar campos vacíos. ");
        }
    }//GEN-LAST:event_btGuardarTPActionPerformed

    private void tbTiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTiposMouseClicked

        if (evt.getButton() == 1) {
            int fila = this.tbTipos.getSelectedRow();

            try {
                Habilitar();
                String sql = "select * from tipo_solicitud where id_tiposolicitud = " + this.tbTipos.getValueAt(fila, 0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);

                rs.next();
                this.tfDescripcionTP.setText(rs.getString("descripcion"));
                this.tfCantidadTP.setText(rs.getString("cantidad_dias"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_tbTiposMouseClicked

    private void btEliminarTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarTPActionPerformed

        if (this.tbTipos.getSelectedRow() > -1) {
            try {
                int fila = this.tbTipos.getSelectedRow();
                String sql = "Update tipo_solicitud  SET estado = '0' where id_tiposolicitud = " + this.tbTipos.getValueAt(fila, 0);

                sent = conn.createStatement();
                int n = sent.executeUpdate(sql);

                if (n > 0) {
                    llenar();
                    JOptionPane.showMessageDialog(null, "Tipo de solicitud Eliminada exitosamente");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un Tipo ya existente.");
        }


    }//GEN-LAST:event_btEliminarTPActionPerformed

    private void btModificarrTpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarrTpActionPerformed

        if (ValidarCampos()) {
            try {

                String sql = "Update tipo_solicitud  SET descripcion = ? ,cantidad_dias= ? where id_tiposolicitud = ?";

                int fila = this.tbTipos.getSelectedRow();
                String dao = (String) this.tbTipos.getValueAt(fila, 0);
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, this.tfDescripcionTP.getText());
                ps.setString(2, this.tfCantidadTP.getText());
                ps.setString(3, dao);
                int n = ps.executeUpdate();
                if (n > 0) {
                    Limpiar();
                    llenar();
                    JOptionPane.showMessageDialog(null, "Tipo de solicitud Modificada");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se permiten campos vacíos. ");
        }


    }//GEN-LAST:event_btModificarrTpActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarTP;
    private javax.swing.JButton btGuardarTP;
    private javax.swing.JButton btModificarrTp;
    private javax.swing.JButton btNuevoTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTipos;
    private javax.swing.JTextField tfCantidadTP;
    private javax.swing.JTextField tfDescripcionTP;
    // End of variables declaration//GEN-END:variables

}
