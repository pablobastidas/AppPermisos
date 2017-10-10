package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Inés Muñoz
 */
public class conexion {
    
    public conexion(){}
    
    public static Connection getConexion()
    {
        Connection con= null;
        Statement sr;
        ResultSet rs;
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@190.163.62.242:1521:DBORACLE", "vistahermosa", "portafolio");
            sr = con.createStatement();
            //rs = sr.executeQuery("select id_rol from funcionario");c
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Conexión erronea "+e);
        }
        return con;
    }
    
}
