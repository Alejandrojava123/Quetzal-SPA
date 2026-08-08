package com.mycompany.quetzalspa.dao;

import com.mycompany.quetzalspa.modelo.Cita;
import com.mycompany.quetzalspa.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    public boolean registrarCita(Cita cita) {

        String sql = "INSERT INTO citas "
                + "(id_cliente, id_servicio, fecha, hora, estado) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cita.getIdCliente());
            ps.setInt(2, cita.getIdServicio());
            ps.setDate(3, cita.getFecha());
            ps.setTime(4, cita.getHora());
            ps.setString(5, cita.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error al registrar cita: " + e.getMessage()
            );
        }

        return false;
    }


    public List<Cita> listarCitas() {

        List<Cita> lista = new ArrayList<>();

        String sql =
                "SELECT c.id_cita, c.id_cliente, c.id_servicio, "
                + "c.fecha, c.hora, c.estado, "
                + "CONCAT(cl.nombre, ' ', cl.apellido) AS nombre_cliente, "
                + "s.nombre AS nombre_servicio "
                + "FROM citas c "
                + "INNER JOIN clientes cl "
                + "ON c.id_cliente = cl.id_cliente "
                + "INNER JOIN servicios s "
                + "ON c.id_servicio = s.id_servicio "
                + "ORDER BY c.fecha DESC, c.hora DESC";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cita cita = new Cita();

                cita.setIdCita(rs.getInt("id_cita"));
                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setIdServicio(rs.getInt("id_servicio"));

                cita.setFecha(rs.getDate("fecha"));
                cita.setHora(rs.getTime("hora"));
                cita.setEstado(rs.getString("estado"));

                cita.setNombreCliente(
                        rs.getString("nombre_cliente")
                );

                cita.setNombreServicio(
                        rs.getString("nombre_servicio")
                );

                lista.add(cita);
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error al listar citas: " + e.getMessage()
            );
        }

        return lista;
    }


    public Cita buscarCita(int idCita) {

        Cita cita = null;

        String sql =
                "SELECT * FROM citas WHERE id_cita = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCita);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    cita = new Cita();

                    cita.setIdCita(
                            rs.getInt("id_cita")
                    );

                    cita.setIdCliente(
                            rs.getInt("id_cliente")
                    );

                    cita.setIdServicio(
                            rs.getInt("id_servicio")
                    );

                    cita.setFecha(
                            rs.getDate("fecha")
                    );

                    cita.setHora(
                            rs.getTime("hora")
                    );

                    cita.setEstado(
                            rs.getString("estado")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error al buscar cita: " + e.getMessage()
            );
        }

        return cita;
    }


    public boolean actualizarCita(Cita cita) {

        String sql =
                "UPDATE citas SET "
                + "id_cliente = ?, "
                + "id_servicio = ?, "
                + "fecha = ?, "
                + "hora = ?, "
                + "estado = ? "
                + "WHERE id_cita = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cita.getIdCliente());
            ps.setInt(2, cita.getIdServicio());

            ps.setDate(3, cita.getFecha());
            ps.setTime(4, cita.getHora());

            ps.setString(5, cita.getEstado());

            ps.setInt(6, cita.getIdCita());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error al actualizar cita: " + e.getMessage()
            );
        }

        return false;
    }


    public boolean eliminarCita(int idCita) {

        String sql =
                "DELETE FROM citas WHERE id_cita = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCita);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error al eliminar cita: " + e.getMessage()
            );
        }

        return false;
    }
}