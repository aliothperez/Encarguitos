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
     
     
     
     //--FIN ULTRALORD************************************************************************
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