package modelos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.usuario;

public class usuarioModelo {
    
 String url = "jdbc:mysql://100.113.173.92:3306/empleados";
        
    String user = "ventas";

    String pass = "ventasMartin";

    Connection con;


    public usuarioModelo(){

         try {
             Connection con = DriverManager.getConnection(url, user, pass);
             
             System.out.print("conectado exitosamente");
            
        } catch (Exception e){
            System.out.print("hubo un error: " + e);
        }

    }

    public void insertarUsuario(usuario Usuario){

        try {

        String consulta = "INSERT INTO Empleados VALUES (?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(consulta);

        statement.setString(1, consulta);    

        

        }
        catch (Exception e){
            
            System.out.println("hubo una excepcion: " + e);

        }

    }


}
