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
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##PABLOB", "123456");
            sr = con.createStatement();
            //rs = sr.executeQuery("select id_rol from funcionario");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Conexión erronea "+e);
        }
        return con;
    }
    
}
