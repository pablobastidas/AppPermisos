package appadministrador;

import Conexion.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ines Muñoz
 *
 */
public class FormLogin extends javax.swing.JFrame {

    Connection conn;
    Statement sent;

    public FormLogin() {
        initComponents();

        this.setLocationRelativeTo(null);
    }

    /**
     * Valida que los campos del formulario no esten vacíos.
     *
     * @return boolean
     */
    private boolean ValidarCampos() {
        if (!this.tfUsuario.getText().equals("") && !this.tfPassword.toString().equals("")) {
            return true;
        }
        return false;
    }

    void Limpiar() {
        this.tfUsuario.setText("");
        this.tfPassword.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");
        setSize(new java.awt.Dimension(700, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ilustre Municipalidad de Vista Hermosa");

        tfUsuario.setToolTipText("");

        btIngresar.setBackground(new java.awt.Color(66, 139, 202));
        btIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logo .png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUsuario)
                                .addComponent(btIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(tfPassword))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btIngresar)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        tfUsuario.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed

        if (ValidarCampos()) {
            try {
                conn = conexion.getConexion();

                /* Toma los parametros del Formulario de Escritorio*/
                String rut = this.tfUsuario.getText().trim();
                String pass = this.tfPassword.getText().trim();

                /*
                    Realiza una llamada a la función definida en Oracle.
                    Devuelve el primer parametro, los siguientes 2 los recibe del formulario
                 */
                String call = "{? = call LOGINESCRITORIO(?,?)}";
                /* Prepara la llamada para ejecutar la función */
                CallableStatement cstmt = conn.prepareCall(call);

                /*
                    Asigna las variables del formulario
                    La primera variable le asigna el tipo de dato de la BD para asignarle la salida
                 */
                cstmt.setString(2, rut);
                cstmt.setString(3, pass);
                cstmt.registerOutParameter(1, java.sql.Types.INTEGER);

                /* Ejecuta la función y asigna la variable de resultado. */
                int check = cstmt.executeUpdate();

                /* Comprueba si es administrador o no */
                if (check == 1) {
                    FormAdministrador a = new FormAdministrador();
                    a.setVisible(true);
                    this.dispose();
                } else if (check > 1) {
                    JOptionPane.showMessageDialog(null, "Usted no es Administrador!\n Su acceso es por Web");
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o Password incorrecta!!!");
                    Limpiar();
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error!!!");
                Limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se permiten datos vacíos en el formulario.");
            Limpiar();
        }


    }//GEN-LAST:event_btIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
