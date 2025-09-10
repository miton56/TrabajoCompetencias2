/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poryecto_competencias2;

import com.mycompany.poryecto_competencias2.DAOs.usuariosDAO;
import com.mycompany.poryecto_competencias2.modelos.usuarios;

/**
 *
 * @author Willow
 */
public class Poryecto_competencias2 {

    public static void main(String[] args) {

       usuarios u = new usuarios("simon", "barros", "1234567", "2123421-4", "av simon", "simon@correo.com", "1234");

       usuariosDAO uDao = new usuariosDAO();

       uDao.ingresarUsuario(u);

    }
   
}
