package com.mycompany.quetzalspa.dao;

import com.mycompany.quetzalspa.modelo.Usuario;
import com.mycompany.quetzalspa.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios(nombre_completo, nombre_usuario, contrasena, edad, sexo, estatura) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getSexo());
            ps.setDouble(6, usuario.getEstatura());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario validarLogin(String nombreUsuario, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreCompleto(rs.getString("nombre_completo"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEdad(rs.getInt("edad"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setEstatura(rs.getDouble("estatura"));

                return usuario;
            }

        } catch (Exception e) {
            System.out.println("Error al validar login: " + e.getMessage());
        }

        return null;
    }
}