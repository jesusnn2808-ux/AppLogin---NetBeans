package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private DBConection conexionBD = new DBConection();

    public User autenticar(String username, String password) {
        Connection con = conexionBD.getConexion();
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");
                    String rol = rs.getString("rol");
                    
                    // Al corregir los archivos de arriba, estas líneas dejarán de marcar error:
                    if (rol.equalsIgnoreCase("Administrador")) {
                        return new Admin(id, user, pass, rol);
                    } else if (rol.equalsIgnoreCase("Cliente")) {
                        return new Client(id, user, pass, rol);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
        }
        return null;
    }
}