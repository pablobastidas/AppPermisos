package appadministrador;

import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Inés Muñoz
 */
public class FormFuncionario extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;
    private static FormFuncionario instance1;

    public static FormFuncionario getInstance1() {
        if (instance1 == null) {
            instance1 = new FormFuncionario();
        }
        return instance1;
    }

    private FormFuncionario() {
        initComponents();
        setLocationRelativeTo(null);
        Deshabilitar();

        
        this.cbRolF.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();

        lista = this.cargarComboRolId();

        for (String i : lista) {
            this.cbRolF.addItem(i);
        }

        conn = conexion.getConexion();
        llenar();
    }


    public ArrayList<String> cargarComboRolId() {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            conn = conexion.getConexion();
            String sql = "select id_rol from rol";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("id_rol"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    void Deshabilitar() {
        this.tfAmaternoF.setEditable(false);
        this.tfApaternoF.setEditable(false);
        this.tfNombreF1.setEditable(false);
        this.tfEmailF.setEditable(false);
        this.tfPassword.setEditable(false);
        this.tfRutF.setEditable(false);
        this.tfTelefonoF.setEditable(false);
    }

    void Limpiar() {
        this.tfAmaternoF.setText("");
        this.tfApaternoF.setText("");
        this.tfNombreF1.setText("");
        this.tfEmailF.setText("");
        this.tfPassword.setText("");
        this.tfRutF.setText("");
        this.tfTelefonoF.setText("");
        this.tfDireccionF.setText("");

    }

    void Habilitar() {
        this.tfAmaternoF.setEditable(true);
        this.tfApaternoF.setEditable(true);
        this.tfNombreF1.setEditable(true);
        this.tfEmailF.setEditable(true);
        this.tfPassword.setEditable(true);
        this.tfRutF.setEditable(true);
        this.tfTelefonoF.setEditable(true);
        this.tfRutF.requestFocus();
    }

    void llenar() {
        try {
            conn = conexion.getConexion();
            String[] titulos = {"Rut", "Rut Evaluador", "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Telefono", "Password", "Email", "Fecha creacion", "Fecha modificacion", "Estado", "Rol", "Unidad Interna",};
            String sql = "select * from funcionario";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[14];

            while (rs.next()) {
                if(rs.getString("estado").equals("1")){
                fila[0] = rs.getString("rut");
                fila[1] = rs.getString("rut_evaluador");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido_paterno");
                fila[4] = rs.getString("apellido_materno");
                fila[5] = rs.getString("direccion");
                fila[6] = rs.getString("telefono");
                fila[7] = rs.getString("password");
                fila[8] = rs.getString("email");
                fila[9] = rs.getString("fecha_creacion");
                fila[10] = rs.getString("fecha_modificacion");
                fila[11] = rs.getString("estado");
                fila[12] = rs.getString("id_rol");
                fila[13] = rs.getString("id_unidad");

                model.addRow(fila);
                }
            }
            this.tbFuncionarios.setModel(model);
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
        tfRutF = new javax.swing.JTextField();
        tfApaternoF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNombreF1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfAmaternoF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDireccionF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTelefonoF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfEmailF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbRolF = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfRutJefeU = new javax.swing.JTextField();
        tfUnidad = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btNuevoF = new javax.swing.JButton();
        btGuardarF = new javax.swing.JButton();
        btModificarF = new javax.swing.JButton();
        btEliminarF = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Funcionarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Rut");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Dirección");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Teléfono");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Rol");

        cbRolF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Rut Jefe Unidad");

        tfUnidad.setEditable(false);
        tfUnidad.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Unidad");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNuevoF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoF.setText("Nuevo");
        btNuevoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoFActionPerformed(evt);
            }
        });

        btGuardarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarF.setText("Guardar");
        btGuardarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarFActionPerformed(evt);
            }
        });

        btModificarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarF.setText("Modificar");
        btModificarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarFActionPerformed(evt);
            }
        });

        btEliminarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarF.setText("Eliminar");
        btEliminarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarFActionPerformed(evt);
            }
        });

        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEliminarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btModificarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevoF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btNuevoF)
                .addGap(18, 18, 18)
                .addComponent(btGuardarF)
                .addGap(18, 18, 18)
                .addComponent(btModificarF)
                .addGap(18, 18, 18)
                .addComponent(btEliminarF)
                .addGap(18, 18, 18)
                .addComponent(btBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfEmailF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombreF1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAmaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(tfRutF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfApaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRutJefeU, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefonoF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccionF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRolF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(79, 79, 79)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(tfRutJefeU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfRutF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(67, 67, 67)
                                .addComponent(tfNombreF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfAmaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(tfApaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfEmailF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(tfDireccionF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(tfTelefonoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRolF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoFActionPerformed
        Limpiar();
        Habilitar();
    }//GEN-LAST:event_btNuevoFActionPerformed

    public String UnidadPorRol(String itemR){
         
        String itemU="";
         try {
            conn = conexion.getConexion();
           
            String sql = "select id_unidad from rol where id_rol="+itemR;
           
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
             rs.next();
             itemU = rs.getString("id_unidad");         
           
        } catch (Exception e) {
            e.printStackTrace();
        }
         return itemU;
    }
    
    private void btGuardarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarFActionPerformed
       
        String itemR = (String) this.cbRolF.getSelectedItem();
        String itemU = this.UnidadPorRol(itemR);
        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechacreacion = dateFormat.format(date);
        String fechamodificacion = fechacreacion;
        String estado = "1";
        try {
            String sql = "insert into funcionario(rut,rut_evaluador,nombre,apellido_paterno,apellido_materno,direccion,telefono,password,email,fecha_creacion,\n"
                    + "                fecha_modificacion,estado,id_rol,id_unidad) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, this.tfRutF.getText());
            ps.setString(2, this.tfRutJefeU.getText());
            ps.setString(3, this.tfNombreF1.getText());
            ps.setString(4, this.tfApaternoF.getText());
            ps.setString(5, this.tfAmaternoF.getText());
            ps.setString(6, this.tfDireccionF.getText());
            ps.setString(7, this.tfTelefonoF.getText());
            ps.setString(8, this.tfPassword.getText());
            ps.setString(9, this.tfEmailF.getText());
            ps.setString(10, fechacreacion);
            ps.setString(11, fechamodificacion);
            ps.setString(12, estado);
            ps.setString(13, itemR);
            ps.setString(14, itemU);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario Ingresado con éxito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar " + e.getMessage());
        }
        llenar();
        Limpiar();
    }//GEN-LAST:event_btGuardarFActionPerformed

    private void tbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionariosMouseClicked
        if (evt.getButton() == 1) {
            int fila = this.tbFuncionarios.getSelectedRow();

            try {
                Habilitar();
                String sql = "select * from funcionario where rut = '" + this.tbFuncionarios.getValueAt(fila, 0)+"'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);

                rs.next();

                this.tfRutF.setText(rs.getString("rut"));
                this.tfRutJefeU.setText(rs.getString("rut_evaluador"));
                this.tfNombreF1.setText(rs.getString("nombre"));
                this.tfApaternoF.setText(rs.getString("apellido_paterno"));
                this.tfAmaternoF.setText(rs.getString("apellido_materno"));
                this.tfDireccionF.setText(rs.getString("direccion"));
                this.tfTelefonoF.setText(rs.getString("telefono"));
                this.tfPassword.setText(rs.getString("password"));
                this.tfEmailF.setText(rs.getString("email"));
                this.cbRolF.setSelectedItem(rs.getString("id_rol"));
                this.tfUnidad.setText(rs.getString("id_unidad"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tbFuncionariosMouseClicked

    private void btEliminarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarFActionPerformed
        try {
            int fila = this.tbFuncionarios.getSelectedRow();
            String sql = "Update funcionario  SET estado = '0' where rut = '"+this.tbFuncionarios.getValueAt(fila,0)+"'";
             
               sent = conn.createStatement();
               int n = sent.executeUpdate(sql);
              
               if(n>0)
               {
                   llenar();
                   JOptionPane.showMessageDialog(null, "Funcionario Eliminado exitosamente");
               }
               
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }//GEN-LAST:event_btEliminarFActionPerformed

    private void btModificarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarFActionPerformed
        try {
         
        String itemR = (String) this.cbRolF.getSelectedItem();
        String itemU = this.UnidadPorRol(itemR);
        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechamodificacion = dateFormat.format(date);
        
            String sql = "Update funcionario  SET nombre = ? ,apellido_paterno= ? ,apellido_materno= ? ,"
                    + "  direccion = ? ,telefono= ? ,password= ?, email = ? ,fecha_modificacion= ? , id_rol= ?,"
                    + " id_unidad=?  where rut = ?";
             
              int fila = this.tbFuncionarios.getSelectedRow();
              String dao = (String) this.tbFuncionarios.getValueAt(fila,0);
              PreparedStatement ps = conn.prepareStatement(sql);
           
              
            ps.setString(1, this.tfNombreF1.getText());
            ps.setString(2, this.tfApaternoF.getText());
            ps.setString(3, this.tfAmaternoF.getText());
            ps.setString(4, this.tfDireccionF.getText());
            ps.setString(5, this.tfTelefonoF.getText());
            ps.setString(6, this.tfPassword.getText());
            ps.setString(7, this.tfEmailF.getText());           
            ps.setString(8, fechamodificacion);            
            ps.setString(9, itemR);
            ps.setString(10, itemU);
             ps.setString(11, dao); 
                int n = ps.executeUpdate();
                if(n>0)
               {
                   Limpiar();
                   llenar();
                   JOptionPane.showMessageDialog(null, "Funcionario Modificado");
               }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }//GEN-LAST:event_btModificarFActionPerformed

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
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminarF;
    private javax.swing.JButton btGuardarF;
    private javax.swing.JButton btModificarF;
    private javax.swing.JButton btNuevoF;
    private javax.swing.JComboBox<String> cbRolF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JTextField tfAmaternoF;
    private javax.swing.JTextField tfApaternoF;
    private javax.swing.JTextField tfDireccionF;
    private javax.swing.JTextField tfEmailF;
    private javax.swing.JTextField tfNombreF1;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfRutF;
    private javax.swing.JTextField tfRutJefeU;
    private javax.swing.JTextField tfTelefonoF;
    private javax.swing.JTextField tfUnidad;
    // End of variables declaration//GEN-END:variables
}
