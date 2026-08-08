package com.mycompany.quetzalspa.dao;

import com.mycompany.quetzalspa.modelo.MedicionIMC;
import com.mycompany.quetzalspa.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicionDAO {

    public boolean guardar(MedicionIMC medicion) {
        String sql = "INSERT INTO mediciones(id_usuario, peso, imc, clasificacion) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, medicion.getIdUsuario());
            ps.setDouble(2, medicion.getPeso());
            ps.setDouble(3, medicion.getImc());
            ps.setString(4, medicion.getClasificacion());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar medición: " + e.getMessage());
            return false;
        }
    }

    public List<MedicionIMC> obtenerHistorial(int idUsuario) {
        List<MedicionIMC> lista = new ArrayList<>();

        String sql = "SELECT * FROM mediciones WHERE id_usuario = ? ORDER BY fecha DESC";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MedicionIMC m = new MedicionIMC();
                m.setIdMedicion(rs.getInt("id_medicion"));
                m.setIdUsuario(rs.getInt("id_usuario"));
                m.setPeso(rs.getDouble("peso"));
                m.setImc(rs.getDouble("imc"));
                m.setClasificacion(rs.getString("clasificacion"));
                m.setFecha(rs.getTimestamp("fecha"));

                lista.add(m);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener historial: " + e.getMessage());
        }

        return lista;
    }
}