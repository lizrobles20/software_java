/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginSE;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author lizir
 */
public class conexionBD {
    public Connection Conectar(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/loginse","root","");
        } catch(SQLException e){
            System.err.print(e.toString());
            JOptionPane.showMessageDialog(null,"Ocurrio un error inesperado.\n Favor comunicarse con el administrador.");
        }
        return con;
    }
}
