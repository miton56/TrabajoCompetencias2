package clases;

public class usuario {
     private int ID;

     private String nombre;

     private String apellidos;

     private String contrasena;

     private String cargo;



     public usuario(int id, String Nombre, String Contrasena, String Cargo, String Apellidos){

        this.ID = id;

        this.nombre = Nombre;

        this.contrasena = Contrasena;

        this.cargo = Cargo;

        this.apellidos = Apellidos;


     }


         public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }
    
     public String getApellido() {
        return apellidos;
    }

     public void setApellido(String Apellido) {
        this.apellidos = Apellido;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }




}
