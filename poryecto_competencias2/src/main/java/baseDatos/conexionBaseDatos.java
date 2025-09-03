/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Willow
 */
public class conexionBaseDatos {
    String url = "jdbc:mysql://100.113.173.92:3306/empleados";
        
    String user = "ventas";

    String pass = "ventasMartin";
    

    public  conexionBaseDatos(){
        
       
        try {
             Connection con = DriverManager.getConnection(url, user, pass);
             
             System.out.print("conectado exitosamente");
            
        } catch (Exception e){
            System.out.print("hubo un error: " + e);
        }
       
    }


    
}
