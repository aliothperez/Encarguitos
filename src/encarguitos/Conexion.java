/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encarguitos;
import static com.mysql.cj.conf.PropertyKey.PASSWORD;
import static com.mysql.cj.conf.PropertyKey.USER;
import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author falio
 */
public class Conexion {
    Connection conexion;
    Statement transaccion;
    ResultSet cursor;
    private static final String URL = "jdbc:mysql://bxzqahn8l7tzouihijgg-mysql.services.clever-cloud.com:3306/bxzqahn8l7tzouihijgg";
    private static final String USER = "uhtizfzseb5vjftn";
    private static final String PASSWORD = "Jt6Ylx7jpfbKdDxaOrcB";
    public Conexion() {
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            transaccion = conexion.createStatement();
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "❌ Driver no encontrado", ex);
        }
    }
    
     public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "❌ Driver no encontrado", ex);
        }
        return null;
     }
     
     
     
     
     
          //ULTRALORD************************************************************************
     public int IniciarSecion(String correo, String contrasena) {
         int r=-1;
         try {
            //SELECT * FROM `Login` WHERE Correo like 'A' and Constrasena like 'A';
            String SQL="SELECT * FROM Usuarios WHERE CorreoUsuario = '"+ correo+"' and Contrasena ='"+contrasena + "'";
            cursor= transaccion.executeQuery(SQL);
            if(cursor.next()){
                if(cursor.getString(5).equals("Gerente")){
                    r=2;
                }else if(cursor.getString(5).equals("Repartidor")){
                    r=1;
                }else if(cursor.getString(5).equals("Gestor de Operaciones")){
                    r=0;
                }
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;         
    }
     public boolean insertarProducto(Usuario p) {
        try {
            /*
            INSERT INTO `Usuarios` (`idArticulo`, `Nombre`, `Descripcion`, `CodigoBarras`, `PrecioCompra`, `PrecioVenta`, `Stock`, `StockMinimo`, `IdCategoria`, `IdProveedor`) 
            VALUES (NULL, 'Producto', 'Descripción', 'Código de Barras', 'Precio de Compra', 'Precio de Venta', 'Stock', 'Stock Mínimo', 'Categoría', 'Proveedor');
            */
            String SQL = "INSERT INTO `Usuarios` (`NombreUsuario`, `CorreoUsuario`, `Contrasena`,`RolUsuario`) "
                       + "VALUES ('%Nombre%', '%Corr%', '%Constr%', '%Rol%');";

            SQL = SQL.replaceAll("%Nombre%", p.nombreUsuario);
            SQL = SQL.replaceAll("%corr%", p.correoUsuario);
            SQL = SQL.replaceAll("%constr%", p.contrasena);
            SQL = SQL.replaceAll("%ROL%", String.valueOf(p.rolUsuario));
            
            transaccion.execute(SQL);
            System.out.println(SQL);
        } catch (SQLException ex) {
            System.out.println("Error al insertar producto: " + ex.getMessage());
            return false;
        }
        System.out.println("Producto insertado exitosamente");
        return true;
    }

     
     //--FIN ULTRALORD************************************************************************
     
public void RegistrarCliente(Cliente c ){        
    try { 
            String sql = "INSERT INTO Cliente (NombreCliente, NumeroTel, Direccion, Referencias) VALUES (%Nom%, %Tel%, %Dir%, %Ref%)";
            sql = sql.replaceAll("%Nom%", c.nombreCliente);
            sql = sql.replaceAll("%Tel%", c.numeroTel);
            sql = sql.replaceAll("%Dir%", c.direccion);
            sql = sql.replaceAll("%Ref%", c.referencias);
            cursor = transaccion.executeQuery(sql);       
        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
    } catch (SQLException ex) {
        Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al registrar cliente");
        }
    } 

    public void RegistrarUsuario(Usuario u){        
    try { 
            String sql = "INSERT INTO Usuario (NombreUsuario, CorreoUsuario, Contrasena, RolUsuario) VALUES (%Nom%, %Cor%, %Con%, %Rol%)";
            sql = sql.replaceAll("%Nom%", u.nombreUsuario);
            sql = sql.replaceAll("%Cor%", u.correoUsuario);
            sql = sql.replaceAll("%Con%", u.contrasena);
            sql = sql.replaceAll("%Rol%", u.rolUsuario);
            cursor = transaccion.executeQuery(sql);       
        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
    } catch (SQLException ex) {
        Logger.getLogger(RegistrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al registrar Usuario");
        }
    } 
    
        public ArrayList<String[]> ConsultarCliente() {
        ArrayList<String[]> resultado = new ArrayList<>();
        try {
            String SQL = "SELECT NombreCliente, NumeroTel, Dirección from Cliente ";
            cursor = transaccion.executeQuery(SQL);
            if (cursor.next()) {
                do {
                    String[] datos = {
                        cursor.getString(1)+"/n",
                        cursor.getString(2)+"/n", 
                        cursor.getString(3)+"/n",
                        "___________________"
                    };
                    resultado.add(datos);
                } while (cursor.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;    
        }
        
        public ArrayList<String[]> ConsultarUsuarios() {
        ArrayList<String[]> resultado = new ArrayList<>();
        try {
            String SQL = "SELECT NombreUsuario, CorreoUsuario, Contrasena, RolUsuario from Usuario ";
            cursor = transaccion.executeQuery(SQL);
            if (cursor.next()) {
                do {
                    String[] datos = {
                        cursor.getString(1)+"/n",
                        cursor.getString(2)+"/n", 
                        cursor.getString(3)+"/n",
                        cursor.getString(4)+"/n",
                        "___________________"
                    };
                    resultado.add(datos);
                } while (cursor.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    
        }
    public boolean eliminarClientePorCampos(String nombre, String telefono, String direccion) {
    String sql = "DELETE FROM Cliente WHERE NombreCliente = %Nom% AND NumeroTel = %Num% AND Direccion = %Dir%";
    try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ps.setString(2, telefono);
        ps.setString(3, direccion);
        int filas = ps.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
}


//ULTRALORD************************************************************************
class Cliente {
     int idCliente;
     String nombreCliente;
     String numeroTel;
     String direccion;
     String referencias;

    
    public Cliente(int idCliente, String nombreCliente, String numeroTel, String direccion, String referencias) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.numeroTel = numeroTel;
        this.direccion = direccion;
        this.referencias = referencias;
    }  
 
}

class Usuario {
    int idUsuario;
    String nombreUsuario;
    String correoUsuario;
    String contrasena;
    String rolUsuario;

    public Usuario(int idUsuario, String nombreUsuario, String correoUsuario, String contrasena, String rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasena = contrasena;
        this.rolUsuario = rolUsuario;
    }

     
}

 class Solicitud {
    int idSolicitud;
    int idUsuario;
    int idCliente;
    String tipo;
    String especificaciones;
    String fechaSolicitud;
    String fechaEntrega;
    String estatus;

    // Constructor
    public Solicitud(int idSolicitud, int idUsuario, int idCliente, String tipo, String especificaciones, String fechaSolicitud, String fechaEntrega, String estatus) {
        this.idSolicitud = idSolicitud;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.tipo = tipo;
        this.especificaciones = especificaciones;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
    }

}

class Notificacion {
    int idNotificacion;
    int idUsuario;
    int idSolicitud;
    String descripcion;

    // Constructor
    public Notificacion(int idNotificacion, int idUsuario, int idSolicitud, String descripcion) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
    }

 
}


     //--FIN ULTRALORD************************************************************************

