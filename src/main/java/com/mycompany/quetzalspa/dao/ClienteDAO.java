package com.mycompany.quetzalspa.dao;

import com.mycompany.quetzalspa.modelo.Cliente;
import com.mycompany.quetzalspa.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // Registrar cliente
    public boolean registrarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes "
                + "(nombre, apellido, telefono, correo, sexo) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getSexo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar cliente: "
                    + e.getMessage()
            );
        }

        return false;
    }


    // Listar clientes
    public List<Cliente> listarClientes() {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY id_cliente DESC";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(
                        rs.getInt("id_cliente")
                );

                cliente.setNombre(
                        rs.getString("nombre")
                );

                cliente.setApellido(
                        rs.getString("apellido")
                );

                cliente.setTelefono(
                        rs.getString("telefono")
                );

                cliente.setCorreo(
                        rs.getString("correo")
                );

                cliente.setSexo(
                        rs.getString("sexo")
                );

                lista.add(cliente);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al listar clientes: "
                    + e.getMessage()
            );
        }

        return lista;
    }


    // Buscar cliente por ID
    public Cliente buscarCliente(int idCliente) {

        Cliente cliente = null;

        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    cliente = new Cliente();

                    cliente.setIdCliente(
                            rs.getInt("id_cliente")
                    );

                    cliente.setNombre(
                            rs.getString("nombre")
                    );

                    cliente.setApellido(
                            rs.getString("apellido")
                    );

                    cliente.setTelefono(
                            rs.getString("telefono")
                    );

                    cliente.setCorreo(
                            rs.getString("correo")
                    );

                    cliente.setSexo(
                            rs.getString("sexo")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar cliente: "
                    + e.getMessage()
            );
        }

        return cliente;
    }


    // Actualizar cliente
    public boolean actualizarCliente(Cliente cliente) {

        String sql = "UPDATE clientes "
                + "SET nombre = ?, "
                + "apellido = ?, "
                + "telefono = ?, "
                + "correo = ?, "
                + "sexo = ? "
                + "WHERE id_cliente = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getSexo());
            ps.setInt(6, cliente.getIdCliente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al actualizar cliente: "
                    + e.getMessage()
            );
        }

        return false;
    }


    // Eliminar cliente
    public boolean eliminarCliente(int idCliente) {

        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al eliminar cliente: "
                    + e.getMessage()
            );
        }

        return false;
    }
}