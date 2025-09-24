package com.mycompany.poryecto_competencias2.DAOs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;
import com.mycompany.poryecto_competencias2.modelos.usuarios;

public class usuariosDAO {
    
    Conexion conect = new Conexion();


    Connection con;

    public usuariosDAO(){

       this.con = this.conect.getConexion();


    }

    public Integer ingresarUsuario(usuarios Usuario){

        String sql = "INSERT into Empleados (Nombre, Apellidos, Telefono, Rut, Direccion) Values (?,?,?,?,?)";

        

        try{

            PreparedStatement ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            int IDgenerado = 1;

            ps.setString(1, Usuario.getNombre());

            ps.setString(2, Usuario.getApellidos());

            ps.setString(3, Usuario.getTelefono());

            ps.setString(4, Usuario.getRut());
            
            ps.setString(5, Usuario.getDireccion());

            ps.executeUpdate();

            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    IDgenerado = rs.getInt(1); // la primera columna contiene el ID generado
                }
            }
            System.out.println("Insercion Realizada");

            return IDgenerado;
            

        }catch(Exception e){

            System.out.print("hubo un error: " + e);

            return null;

        }

    }

    public  ArrayList<usuarios> seleccionarUsuarios(Map<String, String> condiciones){

        String sql = "select * from Empleados";

        List<String> anidados = new ArrayList<>();
        
        usuarios usuario = null;

        if (condiciones != null && !condiciones.isEmpty()){

            for(Map.Entry<String, String> condi : condiciones.entrySet()){

                anidados.add(condi.getKey() + " = " + condi.getValue());

            }
        }

        if (!anidados.isEmpty()){

            sql = sql + " where ";

            for (int i = 0; i < anidados.size(); i++){

                boolean esUltimo = i == anidados.size() -1;

                if (!esUltimo){

                    sql = sql + anidados.get(i) + " and ";

                }else{

                    sql = sql + anidados.get(i);

                }

            }}

         try{

            PreparedStatement ps = this.con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<usuarios> listaUsuarios = new ArrayList<>();

            while(rs.next()){

                int id = rs.getInt("ID");

                String nombre = rs.getString("Nombre");

                String apellidos = rs.getString("Apellidos");

                String telefono = rs.getString("Telefono");

                String rut = rs.getString("Rut");

                String direccion = rs.getString("Direccion");

                usuario = new usuarios(nombre, apellidos, telefono, rut, direccion, "", "");

                usuario.setID(id);

                listaUsuarios.add(usuario);
                
                
            }

            

            return listaUsuarios;
            

        }catch(Exception e){

            System.out.print("hubo un error: " + e);

            ArrayList<usuarios> listaVacia = new ArrayList<>();

            return listaVacia;
        }

    }

    public void eliminarUsuario(int id){

        String sql = "delete from Empleados where ID = ?";

        try{

            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setString(1, String.valueOf(id));

            ps.executeUpdate();

            System.out.print("se ha eliminado el usuario");
            
        }catch(Exception e){
            System.out.print("ha ocurrido un error: " + e);
        }

    }

    public void actualizarUsuario(int IDusuario, Map<String, String> campos){

        String sql = "update Empleados set";

         List<String> values = new ArrayList<String>();

        if (campos != null && !campos.isEmpty()){

            Iterator<Map.Entry<String, String>> it = campos.entrySet().iterator();

           

            while (it.hasNext()) {
                Map.Entry<String, String> camp = it.next();
                boolean esUltimo = !it.hasNext();

                values.add(camp.getValue());

                if (!esUltimo) {

                    sql = sql + " " + camp.getKey() + " = " + "?,";
                     
                    
                } else {
                    sql = sql + " " + camp.getKey() + " = " + "?";
                }
            }

            sql = sql + "where ID = " + String.valueOf(IDusuario);

        }else{
            System.out.println("introduzca campos a actualizar");

            return;
        }

        try {

            PreparedStatement ps = this.con.prepareStatement(sql);

            for (int i = 0; i < values.size(); i++) {
                
                ps.setString(i + 1, values.get(i));

            }

            ps.executeUpdate();

            
        } catch (Exception e) {
            System.out.print("ha ocurrido un error: " + e);
        }
        
        
    }

}
