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
    
    public Usuario obtenerUsuario(String correo, String contrasena) {
         Usuario u = new Usuario();
         
         try {
            //SELECT * FROM `Login` WHERE Correo like 'A' and Constrasena like 'A';
            String SQL="SELECT * FROM Usuarios WHERE CorreoUsuario = '"+ correo+"' and Contrasena ='"+contrasena + "'";
            cursor= transaccion.executeQuery(SQL);
            if(cursor.next()){
                u.idUsuario= cursor.getInt(1);
                u.nombreUsuario = cursor.getString(2);
                u.correoUsuario = cursor.getString(3);
                u.contrasena = cursor.getString(4);
                u.rolUsuario = cursor.getString(5); 
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;         
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
            SQL = SQL.replaceAll("%Corr%", p.correoUsuario);
            SQL = SQL.replaceAll("%Constr%", p.contrasena);
            SQL = SQL.replaceAll("%Rol%", p.rolUsuario);
            System.out.println(SQL);
            transaccion.execute(SQL);
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar producto: " + ex.getMessage());
            return false;
        }
        System.out.println("Producto insertado exitosamente");
        return true;
    }
     
    public ArrayList<String[]> mostrarClientes() {
    ArrayList<String[]> resultado = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM Cliente";
        cursor = transaccion.executeQuery(SQL);

        while (cursor.next()) {
            String[] datos = {
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),cursor.getString(4),cursor.getString(5)
            };
            resultado.add(datos);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return resultado;
    }
    public ArrayList<String[]> mostrarRepartidor()  {
    ArrayList<String[]> resultado = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM Usuarios where RolUsuario= 'Repartidor'";
        cursor = transaccion.executeQuery(SQL);

        while (cursor.next()) {
            String[] datos = {
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)
            };
            resultado.add(datos);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return resultado;
    }
    public Cliente obtenerCliente(String nombre){
        Cliente c = new Cliente();
        try {
        String SQL = "SELECT * FROM Cliente WHERE NombreCliente = %nom%";
        SQL = SQL.replaceAll("%nom%", nombre);
        cursor = transaccion.executeQuery(SQL);

        if (cursor.next()) {
            c.idCliente= cursor.getInt(1);
            c.nombreCliente = cursor.getString(2);
            c.numeroTel = cursor.getString(3);
            c.direccion = cursor.getString(4);
            c.referencias = cursor.getString(5); 
        }
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al buscar el pCliente por ID", ex);
    }
    return c;
    }
    public Usuario obtenerRepartidor(String nombre){
        Usuario c = new Usuario();
        try {
        String SQL = "SELECT * FROM Usuarios WHERE NombreUsuario = '%nom%' and RolUSuario= 'Repartidor'";
        SQL = SQL.replaceAll("%nom%", nombre);
        cursor = transaccion.executeQuery(SQL);

        if (cursor.next()) {
            c.idUsuario= cursor.getInt(1);
            c.nombreUsuario = cursor.getString(2);
            c.correoUsuario = cursor.getString(3);
            c.contrasena = cursor.getString(4);
            c.rolUsuario = cursor.getString(5); 
        }
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al buscar el Repartidor por ID", ex);
    }
    return c;
    }
    
    public int obtenerIdUsuario(String Co){
           int i=-1;
        try {
        String SQL = "SELECT * FROM Usuarios WHERE CorreoUsuario = '%nom%';";
        SQL = SQL.replaceAll("%nom%", Co);
        cursor = transaccion.executeQuery(SQL);

        if (cursor.next()) {
            i= cursor.getInt(1); 
        }
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al buscar el usuario por correo", ex);
    }
    return i; 
    }
    public int obtenerRolUsuario(String Co){
        int r=-1;
         try {
            //SELECT * FROM `Login` WHERE Correo like 'A' and Constrasena like 'A';
            String SQL="SELECT * FROM Usuarios WHERE CorreoUsuario = '"+ Co+"';";
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
    public boolean insertarSolicitud(Solicitud s) {
        try {
             
            String SQL = "INSERT INTO Solicitud (idUsuario, idCliente, Tipo, Especificaciones, FechaSolicitud, FechaEntrega, Estatus)" +
"VALUES (%idU%, %idC%, '%ti%', '%ee%', CURDATE(), '%fe%', '%est%');";

            SQL = SQL.replaceAll("%idU%", String.valueOf(s.idUsuario));
            SQL = SQL.replaceAll("%idC%", String.valueOf(s.idCliente));
            SQL = SQL.replaceAll("%ti%", s.tipo);
            SQL = SQL.replaceAll("%ee%", s.especificaciones);
            SQL = SQL.replaceAll("%fe%", s.fechaEntrega);
            SQL = SQL.replaceAll("%est%", s.estatus);
            
            transaccion.execute(SQL);
            System.out.println(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar solicitud: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        JOptionPane.showMessageDialog(null, "Solicitud insertada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    public ArrayList<String[]> mostrarListaSolicitud(){
        ArrayList<String[]> resultado = new ArrayList<>();
        try {
String SQL = "SELECT s.idSolicitud, s.Tipo, s.Especificaciones, s.FechaSolicitud, s.FechaEntrega, s.Estatus, " +
             "c.NombreCliente, c.NumeroTel, c.Direccion, c.Referencias, u.NombreUsuario " +
             "FROM Solicitud s INNER JOIN Cliente c ON s.idCliente = c.idCliente " +
             "INNER JOIN Usuarios u ON s.idUsuario = u.idUsuario;";
            cursor = transaccion.executeQuery(SQL);

            while (cursor.next()) {
                String[] datos = {
                    cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7), cursor.getString(8),
                    cursor.getString(9),cursor.getString(10),
                    cursor.getString(11)
                    /*"ID:"+cursor.getString(1)+", ",cursor.getString(2)+"\n",
                    cursor.getString(3)+"\n",
                    cursor.getString(4),cursor.getString(5)+" : ",cursor.getString(6),
                    cursor.getString(7)+" : ", cursor.getString(8),
                    cursor.getString(9),cursor.getString(10)+"\n",
                    cursor.getString(11)*/
                };
                resultado.add(datos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }
    
    public boolean eliminarSolicitud(String id) {
    try {
        String SQL = "DELETE FROM Solicitud WHERE idSolicitud = " + id;
        transaccion.execute(SQL);
    } catch (SQLException ex) {
        System.out.println("Error al eliminar Solicitud: " + ex.getMessage());
        return false;
    }
    return true;
}
    public boolean eliminarSolicitudDe(String id) {
    Connection conn = null;
    PreparedStatement stmtNotificaciones = null;
    PreparedStatement stmtSolicitud = null;
    
    try {
        conn = obtenerConexion();
        conn.setAutoCommit(false); // Iniciar transacción

        // 1. Primero eliminar notificaciones relacionadas
        String sqlNotificaciones = "DELETE FROM Notificaciones WHERE idSolicitud = ?";
        stmtNotificaciones = conn.prepareStatement(sqlNotificaciones);
        stmtNotificaciones.setInt(1, Integer.parseInt(id));
        stmtNotificaciones.executeUpdate();

        // 2. Luego eliminar la solicitud
        String sqlSolicitud = "DELETE FROM Solicitud WHERE IdSolictud = ?";
        stmtSolicitud = conn.prepareStatement(sqlSolicitud);
        stmtSolicitud.setInt(1, Integer.parseInt(id));
        int affectedRows = stmtSolicitud.executeUpdate();

        conn.commit(); // Confirmar transacción
        return affectedRows > 0;

    } catch (SQLException ex) {
        try {
            if (conn != null) conn.rollback(); // Revertir en caso de error
        } catch (SQLException e) {
            System.err.println("Error al hacer rollback: " + e.getMessage());
        }
        System.err.println("Error al eliminar solicitud: " + ex.getMessage());
        return false;
    } finally {
        // Cerrar recursos
        try {
            if (stmtNotificaciones != null) stmtNotificaciones.close();
            if (stmtSolicitud != null) stmtSolicitud.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar recursos: " + ex.getMessage());
        }
    }
}
     
    
    public boolean insertarNotificacion(Notificacion n) {
        try {
             
            String SQL = "INSERT INTO Notificaciones (idUsuario, idSolicitud, Descripcion)" +
"VALUES (%iU%, %iS%, '%ee%');";

            SQL = SQL.replaceAll("%iU%", String.valueOf(n.idUsuario));
            SQL = SQL.replaceAll("%iS%", String.valueOf(n.idSolicitud));
            SQL = SQL.replaceAll("%ee%", n.descripcion);
            
            transaccion.execute(SQL);
            System.out.println(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar Notificacion: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        JOptionPane.showMessageDialog(null, "Notificacion insertada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
     
    public ArrayList<String[]> mostrarNotificaciones() {
    ArrayList<String[]> resultado = new ArrayList<>();
    try {
        String SQL = "Select n.idNotificacion,u.NombreUsuario,s.idSolicitud,n.Descripcion"
                + " from Notificaciones n inner join Usuarios u on u.idUsuario=n.idUsuario "
                + "inner join Solicitud s on s.idSolicitud = n.idSolicitud;";
        
        cursor = transaccion.executeQuery(SQL);

        while (cursor.next()) {
            String[] datos = {
                cursor.getString(1), // ID Notificación
                cursor.getString(2), // Nombre Usuario
                cursor.getString(3), // Tipo Solicitud
                cursor.getString(4), // Descripción
                
            };
            resultado.add(datos);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return resultado;
}
    public boolean eliminarNotificacion(String id) {
    try {
        String SQL = "DELETE FROM Notificaciones WHERE idNotificacion = " + id;
        transaccion.execute(SQL);
        return true;
    } catch (SQLException ex) {
        System.out.println("Error al eliminar notificación: " + ex.getMessage());
        return false;
    }
}
    
     
    

     
     //--FIN ULTRALORD************************************************************************
     
public void RegistrarCliente(Cliente c ){        
    try { 
            String sql = "INSERT INTO Cliente (NombreCliente, NumeroTel, Direccion, Referencias) VALUES ('%Nom%', '%Tel%', '%Dir%', '%Ref%');";
            sql = sql.replaceAll("%Nom%", c.nombreCliente);
            sql = sql.replaceAll("%Tel%", c.numeroTel);
            sql = sql.replaceAll("%Dir%", c.direccion);
            sql = sql.replaceAll("%Ref%", c.referencias);
            transaccion.execute(sql);     
        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
    } catch (SQLException ex) {
        Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al registrar cliente");
        }
    } 

    public void RegistrarUsuario(Usuario u){        
    try { 
            String sql = "INSERT INTO Usuarios (NombreUsuario, CorreoUsuario, Contrasena, RolUsuario) VALUES ('%Nom%', '%Cor%', '%Con%', '%Rol%');";
            sql = sql.replaceAll("%Nom%", u.nombreUsuario);
            sql = sql.replaceAll("%Cor%", u.correoUsuario);
            sql = sql.replaceAll("%Con%", u.contrasena);
            sql = sql.replaceAll("%Rol%", u.rolUsuario);
            transaccion.execute(sql);
        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
    } catch (SQLException ex) {
        Logger.getLogger(RegistrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al registrar Usuario");
        }
    } 
    
        public ArrayList<String[]> ConsultarCliente() {
    ArrayList<String[]> resultado = new ArrayList<>();
    try {
        String SQL = "SELECT NombreCliente, NumeroTel, Direccion FROM Cliente";
        cursor = transaccion.executeQuery(SQL);  // <- CORREGIDO

        while (cursor.next()) {
            String[] datos = {
                cursor.getString("NombreCliente"),
                cursor.getString("NumeroTel"),
                cursor.getString("Direccion")
                
            };
            resultado.add(datos);
        }

        cursor.close();
    } catch (SQLException ex) {
        Logger.getLogger(ConsultarClientes.class.getName()).log(Level.SEVERE, null, ex);
    }
    return resultado;
}

public ArrayList<String[]> ConsultarUsuarios() {
    ArrayList<String[]> resultado = new ArrayList<>();
    try {
        String SQL = "SELECT NombreUsuario, CorreoUsuario, Contrasena, RolUsuario FROM Usuarios";
        cursor = transaccion.executeQuery(SQL);  // <- CORREGIDO

        while (cursor.next()) {
            String[] datos = {
                cursor.getString("NombreUsuario"),
                cursor.getString("CorreoUsuario"),
                cursor.getString("Contrasena"),
                cursor.getString("RolUsuario")
            };
            resultado.add(datos);
        }

        cursor.close();
    } catch (SQLException ex) {
        Logger.getLogger(ConsultarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
    }
    return resultado;
}

    public boolean eliminarCliente(Cliente c) {
    String SQL = "DELETE FROM Cliente WHERE NombreCliente = ? AND NumeroTel = ? AND Direccion = ?";
    try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
        ps.setString(1, c.nombreCliente);
        ps.setString(2, c.numeroTel);
        ps.setString(3, c.direccion);

        int filas = ps.executeUpdate();
        return filas > 0;
    } catch (SQLException ex) {
        System.out.println("Error al eliminar cliente: " + ex.getMessage());
        return false;
    }
}
    public boolean eliminarUsuario(Usuario u) {
    String SQL = "DELETE FROM Usuarios WHERE NombreUsuario = ? AND CorreoUsuario = ? AND RolUsuario = ?";
    try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
        ps.setString(1, u.nombreUsuario);
        ps.setString(2, u.correoUsuario);
        ps.setString(3, u.rolUsuario);

        int filas = ps.executeUpdate();
        if (filas > 0) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "️ No se encontró un usuario con esos datos.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
    }
    return false;
}
    public boolean eliminarRepartidor(Usuario u) {
    String SQL = "DELETE FROM Usuarios WHERE NombreUsuario = ? AND CorreoUsuario = ? AND RolUsuario = 'Repartidor'";
    try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
        ps.setString(1, u.nombreUsuario);
        ps.setString(2, u.correoUsuario);

        int filas = ps.executeUpdate();
        if (filas > 0) {
            JOptionPane.showMessageDialog(null, "Repartidor eliminado correctamente.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "️ No se encontró un repartidor con esos datos.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar repartidor: " + e.getMessage());
    }
    return false;
}
    
    
}//FIN CONEXION


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

    Cliente() {
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

    Usuario() {
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

