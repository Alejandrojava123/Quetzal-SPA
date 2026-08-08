package com.mycompany.quetzalspa.dao;

import com.mycompany.quetzalspa.modelo.Servicio;
import com.mycompany.quetzalspa.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {

    public boolean registrarServicio(Servicio servicio) {

        String sql = "INSERT INTO servicios "
                + "(nombre, descripcion, precio, duracion, activo) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getPrecio());
            ps.setInt(4, servicio.getDuracion());
            ps.setBoolean(5, servicio.isActivo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error al registrar servicio: " + e.getMessage()
            );
        }

        return false;
    }


    public List<Servicio> listarServicios() {

        List<Servicio> lista = new ArrayList<>();

        String sql = "SELECT * FROM servicios ORDER BY id_servicio DESC";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Servicio servicio = new Servicio();

                servicio.setIdServicio(
                        rs.getInt("id_servicio")
                );

                servicio.setNombre(
                        rs.getString("nombre")
                );

                servicio.setDescripcion(
                        rs.getString("descripcion")
                );

                servicio.setPrecio(
                        rs.getDouble("precio")
                );

                servicio.setDuracion(
                        rs.getInt("duracion")
                );

                servicio.setActivo(
                        rs.getBoolean("activo")
                );

                lista.add(servicio);
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error al listar servicios: " + e.getMessage()
            );
        }

        return lista;
    }


    public Servicio buscarServicio(int idServicio) {

        Servicio servicio = null;

        String sql = "SELECT * FROM servicios WHERE id_servicio = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idServicio);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    servicio = new Servicio();

                    servicio.setIdServicio(
                            rs.getInt("id_servicio")
                    );

                    servicio.setNombre(
                            rs.getString("nombre")
                    );

                    servicio.setDescripcion(
                            rs.getString("descripcion")
                    );

                    servicio.setPrecio(
                            rs.getDouble("precio")
                    );

                    servicio.setDuracion(
                            rs.getInt("duracion")
                    );

                    servicio.setActivo(
                            rs.getBoolean("activo")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error al buscar servicio: " + e.getMessage()
            );
        }

        return servicio;
    }


    public boolean actualizarServicio(Servicio servicio) {

        String sql = "UPDATE servicios SET "
                + "nombre = ?, descripcion = ?, precio = ?, "
                + "duracion = ?, activo = ? "
                + "WHERE id_servicio = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getPrecio());
            ps.setInt(4, servicio.getDuracion());
            ps.setBoolean(5, servicio.isActivo());
            ps.setInt(6, servicio.getIdServicio());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error al actualizar servicio: " + e.getMessage()
            );
        }

        return false;
    }


    public boolean eliminarServicio(int idServicio) {

        String sql = "DELETE FROM servicios WHERE id_servicio = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idServicio);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error al eliminar servicio: " + e.getMessage()
            );
        }

        return false;
    }
}