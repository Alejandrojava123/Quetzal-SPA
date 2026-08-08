package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.ClienteDAO;
import com.mycompany.quetzalspa.modelo.Cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

    private final ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "editar":

                int idEditar = Integer.parseInt(request.getParameter("id"));

                Cliente cliente = dao.buscarCliente(idEditar);

                request.setAttribute("cliente", cliente);

                request.getRequestDispatcher("editarCliente.jsp")
                       .forward(request, response);

                break;

            case "eliminar":

                int idEliminar = Integer.parseInt(request.getParameter("id"));

                dao.eliminarCliente(idEliminar);

                response.sendRedirect("ClienteServlet");

                break;

            default:

                List<Cliente> listaClientes = dao.listarClientes();

                request.setAttribute("listaClientes", listaClientes);

                request.getRequestDispatcher("clientes.jsp")
                       .forward(request, response);

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if ("actualizar".equals(accion)) {

            int idCliente = Integer.parseInt(
                    request.getParameter("idCliente")
            );

            Cliente cliente = new Cliente();

            cliente.setIdCliente(idCliente);
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setCorreo(request.getParameter("correo"));
            cliente.setSexo(request.getParameter("sexo"));

            dao.actualizarCliente(cliente);

            response.sendRedirect("ClienteServlet");

        } else {

            Cliente cliente = new Cliente();

            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setCorreo(request.getParameter("correo"));
            cliente.setSexo(request.getParameter("sexo"));

            boolean registrado = dao.registrarCliente(cliente);

            if (registrado) {
                response.sendRedirect("ClienteServlet");
            } else {
                response.sendRedirect("registroCliente.jsp?error=1");
            }
        }
    }
}