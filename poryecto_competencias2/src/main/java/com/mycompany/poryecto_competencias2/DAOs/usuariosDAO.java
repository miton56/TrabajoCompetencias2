package com.mycompany.poryecto_competencias2.DAOs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mycompany.poryecto_competencias2.modelos.usuarios;

public class usuariosDAO {
    
    String url = "jdbc:mysql://100.113.173.92:3306/empleados";

    String user = "ventas";

    String pass = "ventasMartin";

    Connection con;

    public usuariosDAO(){

        try{

            this.con = DriverManager.getConnection(this.url, this.user, this.pass);

            System.out.print("conexion correcta");

        }catch(Exception e){
            System.err.println("ha ocurrido un error: " + e);
        }

    }

    public void ingresarUsuario(usuarios Usuario){

        String sql = "INSERT into Empleados (Nombre, Apellidos, Telefono, Rut, Direccion) Values (?,?,?,?,?)";

        

        try{

            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setString(1, Usuario.getNombre());

            ps.setString(2, Usuario.getApellidos());

            ps.setString(3, Usuario.getTelefono());

            ps.setString(4, Usuario.getRut());
            
            ps.setString(5, Usuario.getDireccion());

            ps.executeUpdate();

            

            System.out.println("Insercion Realizada");


            

        }catch(Exception e){

            System.out.print("hubo un error: " + e);

        }

    }

    public void seleccionarUsuarios(Map<String, String> condiciones){

        String sql = "select * from Empleados";

        List<String> anidados = new ArrayList<>();
        

        if (condiciones != null){

            for(Map.Entry<String, String> condi : condiciones.entrySet()){

                anidados.add(condi.getKey() + " = " + condi.getValue());

            }
        }

         try{

            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.executeQuery();



            

        }catch(Exception e){

            System.out.print("hubo un error: " + e);

        }

    }

    public void eliminarUsuario(){}

    public void actualizarUsuario(){}

}
